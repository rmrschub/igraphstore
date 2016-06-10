/*
 * This file is part of IGraphStore. It is subject to the license terms in
 * the LICENSE file found in the top-level directory of this distribution.
 * You may not use this file except in compliance with the License.
 */
package de.dfki.resc28.igraphstore;

import org.apache.jena.rdf.model.Model;

/**
 * @author resc01
 *
 */
public interface IGraphStore 
{
	//================================================================================
	// CRUD-related methods for the default graph 
	//================================================================================
	
	Model getDefaultGraph();
	
	void replaceDefaultGraph(final Model model);
	
	void addToDefaultGraph(final Model model);
	
	void clearDefaultGraph();


	//================================================================================
	// CRUD-related methods for named graphs 
	//================================================================================

	boolean containsNamedGraph(final String graphURI);
	
	Model getNamedGraph(final String graphURI);
	
	void deleteNamedGraph(final String graphURI);
	
	void replaceNamedGraph(final String graphURI, final Model model);
	
	void addToNamedGraph(final String graphURI, final Model model);
	
	void createNamedGraph(final String graphURI, final Model model);


	//================================================================================
	// Query-related Methods
	//================================================================================

//	boolean ask(String queryString);
//	
//	void select(OutputStream outStream, String queryString);
//	
//	void select(OutputStream outStream, String queryString, String contentType);
//	
//	Model construct(String queryString);
//	
//	Model describe(String queryString);
}
