package interfaces;

/**
 * Interface responsável pelas funções presentes
 * em uma pilha. Há o uso do generics para que a
 * estrutura possa servir para qualquer tipo ou
 * classe.
 * 
 * @param <T> o tipo que terá a pilha.
 *
 * @author Helder Chaves Leite Junior
 */
public interface Pilha<T>
{
	/**
	 * Método responsável por adicionar um elemento ao topo da pilha.
	 * 
	 * @param elemento o elemento que será adicionado.
	 * @throws RuntimeException caso a pilha esteja cheia.
	 */
	public void push(T element) throws RuntimeException;
	
	/**
	 * Método responsável por remover um elemento do topo da pilha.
	 * 
	 * @return o elemento que foi removido.
	 * @throws RuntimeException caso a pilha esteja vazia.
	 */
	public T pop();
	
	/**
	 * Método que recupera o elemento do topo da pilha.
	 * 
	 * @return o elemento do topo da pilha.
	 */
	public T peek();
	
	/**
	 * Método que recupera o tamanho atual da pilha.
	 * 
	 * @return um inteiro que indica o tamanho atual da pilha.
	 */
	public int size();
	
	/**
	 * Método que verifica se a pilha está vazia.
	 * 
	 * @return um booleano {@code true} caso a pilha esteja vazia,
	 * ou {@code false} caso não esteja.
	 */
	public boolean isEmpty();
	
	/**
	 * Método que verifica se a pilha está cheia.
	 * 
	 * @return um booleano {@code true} caso a pilha esteja cheia,
	 * ou {@code false} caso não esteja.
	 */
	public boolean isFull();
}