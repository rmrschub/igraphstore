/**
 * 
 */
package de.dfki.resc28.igraphstore.jena;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.tdb.TDBFactory;

import de.dfki.resc28.igraphstore.IGraphStore;

/**
 * @author resc01
 * 
 * The TDBGraphStore maintains an RDF-Dataset.
 * 
 * An RDF-Dataset is a collection of named graphs and a background graph 
 * (also called the default or unnamed graph). 
 * 
 * Depending on construction, the TDBGraphStore is maintained in-memory 
 * or in a given dataset directory on disk.
 */
public class TDBGraphStore implements IGraphStore 
{
	//================================================================================
    // Constructors
	//================================================================================
	
	/**
	 * Constructs in-memory TDBGraphStore with default RDF-dataset.
	 */
	public TDBGraphStore()
	{
		fDataset = TDBFactory.createDataset();
	}
	
	/**
	 * Constructs disk-based TDBGraphStore with default RDF-dataset in user-specified directory. 
	 */
	public TDBGraphStore(final String datasetDir)
	{
		fDatasetDir = datasetDir;
		fDataset = TDBFactory.createDataset(fDatasetDir);
	}


	//================================================================================
	// CRUD-related methods for the default graph 
	//================================================================================

	/**
	 * Gets the default graph by name as a Jena Model from the RDF-Dataset.
	 */
	@Override
	public Model getDefaultGraph()
	{
		Model graph = null;
		
		fDataset.begin(ReadWrite.READ);
		
		graph = fDataset.getDefaultModel(); 
		
		fDataset.end();
		
		return graph;
	}
	
	/**
	 * Replaces the default graph by the given model.
	 */
	@Override
	public void replaceDefaultGraph(final Model model)
	{
		fDataset.begin(ReadWrite.WRITE);
		
		fDataset.setDefaultModel(model);
		
		fDataset.commit();
		fDataset.end();
	}

	/**
	 * Adds the statements of the given model to the named graph in the RDF-Dataset.
	 */
	@Override
	public void addToDefaultGraph(final Model model) 
	{
		fDataset.begin(ReadWrite.WRITE);
		
		fDataset.setDefaultModel(fDataset.getDefaultModel().add(model));
		
		fDataset.commit();
		fDataset.end();
	}

	/**
	 * Clears the default graph 
	 */
	@Override
	public void clearDefaultGraph()
	{
		fDataset.begin(ReadWrite.WRITE);
		
		fDataset.setDefaultModel(fDataset.getDefaultModel().removeAll());
		
		fDataset.commit();
		fDataset.end();	
	}

	//================================================================================
    // CRUD-related methods for named graphs 
	//================================================================================

	/**
	 * Checks if RDF-Dataset contains graph with given name.
	 */
	@Override
	public boolean containsNamedGraph(final String graphURI) 
	{
		return fDataset.containsNamedModel(graphURI);
	}
	
	/**
	 * Gets a graph by name as a Jena Model from the RDF-Dataset.
	 * Defaults to background graph as a Jena Model.
	 * Implemented transactionally.
	 */
	@Override
	public Model getNamedGraph(final String graphURI) 
	{
		Model graph = null;
		
		fDataset.begin(ReadWrite.READ);
		
		// http://bit.ly/1U4TS85 
		if (fDataset.containsNamedModel(graphURI))
		{
			graph = fDataset.getNamedModel(graphURI);
		}
		else
		{
			graph = fDataset.getDefaultModel();
		}
		
		fDataset.end();
		
		return graph;
	}

	/**
	 * Deletes a graph by name from the RDF-dataset.
	 * Implemented transactionally.
	 */
	@Override
	public void deleteNamedGraph(final String graphURI) 
	{
		fDataset.begin(ReadWrite.WRITE);
		
		if (fDataset.containsNamedModel(graphURI))
		{
			fDataset.removeNamedModel(graphURI);
		}
		
		fDataset.commit();
		fDataset.end();
	}

	/**
	 * Replaces a named graph in the RDF-Dataset by the given model.
	 */
	@Override
	public void replaceNamedGraph(final String graphURI, final Model model) 
	{
		fDataset.begin(ReadWrite.WRITE);
		
		if (fDataset.containsNamedModel(graphURI))
		{
			
			fDataset.replaceNamedModel(graphURI, model);
		}
		
		fDataset.commit();
		fDataset.end();
	}

	/**
	 * Adds the statements of the given model to the named graph in the RDF-Dataset.
	 */
	@Override
	public void addToNamedGraph(final String graphURI, final Model model) 
	{
		fDataset.begin(ReadWrite.WRITE);
		
		fDataset.replaceNamedModel(graphURI, fDataset.getNamedModel(graphURI).add(model));
		
		fDataset.commit();
		fDataset.end();
	}

	/**
	 * Creates a graph in the RDF-Dataset by name with the given model.
	 */
	@Override
	public void createNamedGraph(final String graphURI, final Model model) 
	{
		fDataset.begin(ReadWrite.WRITE);
		
		// http://bit.ly/1JwYYmT
		if ( !graphURI.isEmpty() && !fDataset.containsNamedModel(graphURI))	
		{
			fDataset.addNamedModel(graphURI, model);
		}
		
		fDataset.commit();
		fDataset.end();
	}


	//================================================================================
    // Query-related Methods
    //================================================================================


	//================================================================================
    // Member variables
	//================================================================================
	
	private Dataset fDataset;
	private String fDatasetDir = null;
}
