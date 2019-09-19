package interfaces;

/**
 * Interface respons�vel pelas fun��es presentes
 * em uma fila. H� o uso do generics para que a
 * estrutura possa servir para qualquer tipo ou
 * classe.
 * 
 * @param <T> o tipo que ter� a fila.
 *
 * @author Helder Chaves Leite Junior
 */
public interface Fila<T>
{
	/**
	 * M�todo respons�vel por adicionar um elemento no fim da fila.
	 * 
	 * @param elemento o elemento que ser� adicionado.
	 * @throws RuntimeException caso a fila esteja cheia.
	 */
	public void push(T element) throws RuntimeException;
	
	/**
	 * M�todo respons�vel por remover um elemento do fim da fila.
	 * 
	 * @return o elemento que foi removido.
	 * @throws RuntimeException caso a fila esteja vazia.
	 */
	public T pop() throws RuntimeException;
	
	/**
	 * M�todo que recupera o elemento do in�cio da fila.
	 * 
	 * @return o elemento do topo da pilha.
	 */
	public T head();
	
	/**
	 * M�todo que recupera o tamanho atual da fila.
	 * 
	 * @return um inteiro que indica o tamanho atual da fila.
	 */
	public int size();
	
	/**
	 * M�todo que verifica se a fila est� vazia.
	 * 
	 * @return um booleano {@code true} caso a fila esteja vazia,
	 * ou {@code false} caso n�o esteja.
	 */
	public boolean isEmpty();
	
	/**
	 * M�todo que verifica se a fila est� cheia.
	 * 
	 * @return um booleano {@code true} caso a fila esteja cheia,
	 * ou {@code false} caso n�o esteja.
	 */
	public boolean isFull();
}
