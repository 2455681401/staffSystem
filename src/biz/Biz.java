package biz;
/**
 * 所有业务对象通用接口
 * @author Administrator
 *
 */
public interface Biz<T> {
	public void add(T t);
	public T delete(T t);
	public T find(T t);
	public T update(T t);
}
