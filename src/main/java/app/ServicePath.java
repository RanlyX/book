package app;

public class ServicePath {

	// Service entry
	public static final String ROOT_PATH = "/";
	public static final String API_ROOT = ROOT_PATH + "api";
	public static final String API_ENTRY = API_ROOT + "/v1";

	// book
	public static final String BOOK_COLLECTION = API_ENTRY + "/books";
	// TODO: path about book

	// publisher
	public static final String PUBLISHER_COLLECTION = API_ENTRY + "/publishers";
	// TODO: path about publisher

	// author
	public static final String AUTHOR_COLLECTION = API_ENTRY + "/authors";
	// TODO: path about author

	// translator
	public static final String TRANSLATOR_COLLECTION = API_ENTRY + "/translators";
	// TODO: path about translator
}
