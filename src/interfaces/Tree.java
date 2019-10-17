package interfaces;

/**
 * Interface responsável pelas funções presentes em uma árvore de busca binária.
 * Há o uso do generics para que a estrutura possa servir para qualquer tipo ou
 * classe.
 * 
 * @param <T> o tipo que terá a árvore.
 *
 * @author Helder Chaves Leite Junior
 */
public interface Tree<T>
{
	public void insert(T element);
	
	public void remove(T element);
	
	public boolean isEmpty();
	
	public int size();
	
	public int height();
	
	public int countLeaves();
	
	public T[] preOrder();
	
	public T[] inOrder();
	
	public T[] posOrder();
}
