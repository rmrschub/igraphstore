/**
 * 
 */
package de.dfki.resc28.igraphstore.jena;

import org.apache.jena.query.DatasetAccessorFactory;
import org.apache.jena.rdf.model.Model;

import de.dfki.resc28.igraphstore.IGraphStore;

/**
 * @author resc01
 *
 * The FusekiGraphStore maintains an RDF-Dataset.
 * 
 * An RDF-Dataset is a collection of named graphs and a background graph 
 * (also called the default or unnamed graph). 
 */
public class FusekiGraphStore implements IGraphStore 
{
	//================================================================================
    // Constructors
	//================================================================================
	
	public FusekiGraphStore(final String dataServerURI, final String sparqlServerURI) 
	{
		fDataServerURI = dataServerURI;
		fSparqlServerURI = sparqlServerURI;
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
		return DatasetAccessorFactory.createHTTP(fDataServerURI).getModel();
	}

	/**
	 * Replaces the default graph by the given model.
	 */
	@Override
	public void replaceDefaultGraph(final Model model) 
	{
		DatasetAccessorFactory.createHTTP(fDataServerURI).putModel(model);
	}

	/**
	 * Adds the statements of the given model to the default graph in the RDF-Dataset.
	 */
	@Override
	public void addToDefaultGraph(Model model) 
	{
		DatasetAccessorFactory.createHTTP(fDataServerURI).add(model);
	}
	
	/**
	 * Clears the default graph 
	 */
	@Override
	public void clearDefaultGraph()
	{
		DatasetAccessorFactory.createHTTP(fDataServerURI).deleteDefault();
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
		return DatasetAccessorFactory.createHTTP(fDataServerURI).containsModel(graphURI);
	}

	/**
	 * Gets a graph by name as a Jena Model from the RDF-Dataset.
	 * Defaults to background graph as a Jena Model.
	 */
	@Override
	public Model getNamedGraph(final String graphURI) 
	{
		return DatasetAccessorFactory.createHTTP(fDataServerURI).getModel(graphURI);
	}

	/**
	 * Deletes a graph by name from the RDF-dataset.
	 */
	@Override
	public void deleteNamedGraph(final String graphURI) 
	{
		DatasetAccessorFactory.createHTTP(fDataServerURI).deleteModel(graphURI);
	}

	/**
	 * Replaces a named graph in the RDF-Dataset by the given model.
	 */
	@Override
	public void replaceNamedGraph(final String graphURI, final Model model) 
	{
		DatasetAccessorFactory.createHTTP(fDataServerURI).putModel(graphURI, model);
	}
	
	/**
	 * Adds the statements of the given model to the named graph in the RDF-Dataset.
	 */
	@Override
	public void addToNamedGraph(String graphURI, Model model) 
	{
		DatasetAccessorFactory.createHTTP(fDataServerURI).add(graphURI, model);
	}

	/**
	 * Creates a graph in the RDF-Dataset by name with the given model.
	 */
	@Override
	public void createNamedGraph(final String graphURI, final  Model model) 
	{
		DatasetAccessorFactory.createHTTP(fDataServerURI).putModel(graphURI, model);
	}


	//================================================================================
    // Query-related Methods
    //================================================================================


	//================================================================================
    // Member variables
	//================================================================================
	
	private String fDataServerURI;
	private String fSparqlServerURI;
}
