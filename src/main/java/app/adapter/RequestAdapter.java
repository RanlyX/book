package app.adapter;

public interface RequestAdapter<D, S> {
	public D convert(final S source);
}
