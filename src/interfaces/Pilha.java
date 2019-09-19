package interfaces;

/**
 * Interface respons�vel pelas fun��es presentes
 * em uma pilha. H� o uso do generics para que a
 * estrutura possa servir para qualquer tipo ou
 * classe.
 * 
 * @param <T> o tipo que ter� a pilha.
 *
 * @author Helder Chaves Leite Junior
 */
public interface Pilha<T>
{
	/**
	 * M�todo respons�vel por adicionar um elemento ao topo da pilha.
	 * 
	 * @param elemento o elemento que ser� adicionado.
	 * @throws RuntimeException caso a pilha esteja cheia.
	 */
	public void push(T element) throws RuntimeException;
	
	/**
	 * M�todo respons�vel por remover um elemento do topo da pilha.
	 * 
	 * @return o elemento que foi removido.
	 * @throws RuntimeException caso a pilha esteja vazia.
	 */
	public T pop();
	
	/**
	 * M�todo que recupera o elemento do topo da pilha.
	 * 
	 * @return o elemento do topo da pilha.
	 */
	public T peek();
	
	/**
	 * M�todo que recupera o tamanho atual da pilha.
	 * 
	 * @return um inteiro que indica o tamanho atual da pilha.
	 */
	public int size();
	
	/**
	 * M�todo que verifica se a pilha est� vazia.
	 * 
	 * @return um booleano {@code true} caso a pilha esteja vazia,
	 * ou {@code false} caso n�o esteja.
	 */
	public boolean isEmpty();
	
	/**
	 * M�todo que verifica se a pilha est� cheia.
	 * 
	 * @return um booleano {@code true} caso a pilha esteja cheia,
	 * ou {@code false} caso n�o esteja.
	 */
	public boolean isFull();
}