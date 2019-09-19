package interfaces;

/**
 * Interface responsável pelas funções presentes
 * em uma fila. Há o uso do generics para que a
 * estrutura possa servir para qualquer tipo ou
 * classe.
 * 
 * @param <T> o tipo que terá a fila.
 *
 * @author Helder Chaves Leite Junior
 */
public interface Fila<T>
{
	/**
	 * Método responsável por adicionar um elemento no fim da fila.
	 * 
	 * @param elemento o elemento que será adicionado.
	 * @throws RuntimeException caso a fila esteja cheia.
	 */
	public void push(T element) throws RuntimeException;
	
	/**
	 * Método responsável por remover um elemento do fim da fila.
	 * 
	 * @return o elemento que foi removido.
	 * @throws RuntimeException caso a fila esteja vazia.
	 */
	public T pop() throws RuntimeException;
	
	/**
	 * Método que recupera o elemento do início da fila.
	 * 
	 * @return o elemento do topo da pilha.
	 */
	public T head();
	
	/**
	 * Método que recupera o tamanho atual da fila.
	 * 
	 * @return um inteiro que indica o tamanho atual da fila.
	 */
	public int size();
	
	/**
	 * Método que verifica se a fila está vazia.
	 * 
	 * @return um booleano {@code true} caso a fila esteja vazia,
	 * ou {@code false} caso não esteja.
	 */
	public boolean isEmpty();
	
	/**
	 * Método que verifica se a fila está cheia.
	 * 
	 * @return um booleano {@code true} caso a fila esteja cheia,
	 * ou {@code false} caso não esteja.
	 */
	public boolean isFull();
}
