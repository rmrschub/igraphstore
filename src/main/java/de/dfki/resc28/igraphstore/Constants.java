/**
 * 
 */
package de.dfki.resc28.igraphstore;

import javax.ws.rs.core.MediaType;

/**
 * @author resc01
 *
 */
public class Constants 
{
	// Content types
	public static final String CT_APPLICATION_JSON = MediaType.APPLICATION_JSON;
	public static final String CT_APPLICATION_LD_JSON = "application/ld+json";
	public static final String CT_APPLICATION_RDFXML = "application/rdf+xml";
	public static final String CT_APPLICATION_XTURTLE = "application/x-turtle";
	public static final String CT_APPLICATION_SPARQLQUERY = "application/sparql-query";
	
	public static final String CT_APPLICATION_SPARQLRESULTS_BIO = "application/sparql-results+bio";
	public static final String CT_APPLICATION_SPARQLRESULTS_CSV = "application/sparql-results+csv";
	public static final String CT_APPLICATION_SPARQLRESULTS_JSON = "application/sparql-results+json";
	public static final String CT_APPLICATION_SPARQLRESULTS_SSE = "application/sparql-results+sse";
	public static final String CT_APPLICATION_SPARQLRESULTS_TSV = "application/sparql-results+tsv";
	public static final String CT_APPLICATION_SPARQLRESULTS_XML = "application/sparql-results+xml";
	
	public static final String CT_TEXT_HTML = MediaType.TEXT_HTML;
	public static final String CT_TEXT_TURTLE = "text/turtle";
	public static final String CT_TEXT_TRIG = "text/trig";
}