package interfaces;

import java.util.List;

public interface InterfacesDao<T> {

	//O "T" estar� padronizando os elementos dos nossos m�todos do crud do carro
	public boolean salvar(T t);
	public boolean update(T t);
	public boolean excluir(T t);
	public T retornarUm(int id);
	public List<T> retornarTodos();
	public boolean excluir(int id);
	
}
