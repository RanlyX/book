package app.model.view;

public interface ResourceCollection<T> {
	default String getCollectionName(T t) {
		Class<?> resourceClass = this.getResourceClass();
		
	}
	
	Class<T> getResourceClass();
}
