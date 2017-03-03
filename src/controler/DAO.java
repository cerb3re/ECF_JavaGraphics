package controler;

import java.util.List;

public interface DAO <T>
{
	public List<T> findAll();
	public T findBy(Object o);
	public void save(T t) throws Exception;
	public void update(T t) throws Exception;
	public void delete(T t) throws Exception;
}
