/*
 * This file is part of IGraphStore. It is subject to the license terms in
 * the LICENSE file found in the top-level directory of this distribution.
 * You may not use this file except in compliance with the License.
 */
package de.dfki.resc28.igraphstore;

import javax.ws.rs.core.MediaType;

/**
 * @author resc01
 *
 */
public class Constants 
{
	// RDF Content types
	public static final String CT_APPLICATION_JSON = MediaType.APPLICATION_JSON;
	public static final String CT_APPLICATION_JSON_LD = "application/ld+json";
	public static final String CT_APPLICATION_XTURTLE = "application/x-turtle";
	public static final String CT_APPLICATION_NQUADS = "application/n-quads";
	public static final String CT_APPLICATION_NTRIPLES = "application/n-triples";
	public static final String CT_APPLICATION_RDF_JSON = "application/rdf+json";
	public static final String CT_APPLICATION_RDFXML = "application/rdf+xml";
	public static final String CT_APPLICATION_TRIX = "application/trix";
	public static final String CT_TEXT_N3 = "text/n3; charset=utf-8";
	public static final String CT_TEXT_TRIG = "text/trig";
	public static final String CT_TEXT_TURTLE = "text/turtle";
		
	// SPARQL Content types
	public static final String CT_APPLICATION_SPARQLQUERY = "application/sparql-query";
	public static final String CT_APPLICATION_SPARQLRESULTS_BIO = "application/sparql-results+bio";
	public static final String CT_APPLICATION_SPARQLRESULTS_CSV = "application/sparql-results+csv";
	public static final String CT_APPLICATION_SPARQLRESULTS_JSON = "application/sparql-results+json";
	public static final String CT_APPLICATION_SPARQLRESULTS_SSE = "application/sparql-results+sse";
	public static final String CT_APPLICATION_SPARQLRESULTS_TSV = "application/sparql-results+tsv";
	public static final String CT_APPLICATION_SPARQLRESULTS_XML = "application/sparql-results+xml";

	// HTML & plain text content types
	public static final String CT_TEXT_HTML = MediaType.TEXT_HTML;
	public static final String CT_TEXT_PLAIN = "text/plain";
	public static final String CT_IMAGE_SVG_XML = "image/svg+xml";

}

