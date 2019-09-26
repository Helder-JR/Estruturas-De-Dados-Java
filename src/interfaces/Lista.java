package interfaces;

/**
 * Interface responsável pelas funções presentes em uma lista. Há o uso do
 * generics para que a estrutura possa servir para qualquer tipo ou
 * classe.
 * 
 * @param <T> o tipo que terá a fila.
 *
 * @author Helder Chaves Leite Junior
 */
public interface Lista<T>
{
	/**
	 * Método responsável por adicionar um elemento no início da lista.
	 * 
	 * @param element o elemento a ser adicionado.
	 * @throws IllegalArgumentException caso o elemento seja de um tipo
	 *         diferente do esperado.
	 * @throws NullPointerException caso o elemento seja {@code null}.
	 */
	public void addFirst(T element);
	
	
	/**
	 * Método responsável por adicionar um elemento em uma posição especificada
	 * da lista.
	 * 
	 * @param element o elemento a ser adicionado.
	 * @param index o índice em que esse elemento será adicionado.
	 * @throws IllegalArgumentException caso o elemento seja de um tipo
	 *         diferente do esperado.
	 * @throws NullPointerException caso o elemento seja {@code null}.
	 * @throws IndexOutOfBoundsException caso o índice não seja válido.
	 */
	public void add(T element, int index);
	
	/**
	 * Método responsável por adicionar um elemento no fim da lista.
	 * 
	 * @param element o elemento a ser adicionado.
	 * @throws IllegalArgumentException caso o elemento seja de um tipo
	 *         diferente do esperado ou {@code null}.
	 * @throws NullPointerException caso o elemento seja {@code null}.
	 */
	public void addLast(T element);
	
	/**
	 * Método responsável por remover o primeiro elemento da lista. Caso a lista
	 * esteja vazia o método retorna {@code null}.
	 * 
	 * @return o elemento que foi removido da lista.
	 */
	public T removeFirst();
	
	/**
	 * Método responsável por remover um elemento de um índice especificado da
	 * lista. Caso a lista esteja vazia o método retorna {@code null}.
	 * 
	 * @param index o índice do elemento a ser removido.
	 * @return o elemento que foi removido da lista.
	 * @throws IndexOutOfBoundsException cado o índice não seja válido.
	 */
	public T remove(int index);
	
	/**
	 * Método responsável por remover o último elemento da lista. Caso a lista
	 * esteja vazia o método retorna {@code null}.
	 * 
	 * @return o elemento que foi removido da lista.
	 */
	public T removeLast();
	
	
	/**
	 * Método que retorna um elemento da pilha a partir de um índice específico.
	 * 
	 * @param index o índice do elemento a ser retornado.
	 * @return o elemento na posição especificada da lista.
	 * @throws IndexOutOfBoundsException caso o índice seja inválido.
	 */
	public T get(int index);
	
	
	/**
	 * Método que substitui um elemento da lista por outro especificado.
	 * 
	 * @param index o índice do elemento a ser substituído.
	 * @param element o elemento que irá substituir o elemento do índice
	 *        especificado.
	 * @return o elemento que foi substituído na lista.
	 * @throws IllegalArgumentException caso o elemento seja de um tipo
	 *         diferente do esperado.
	 * @throws NullPointerException caso o elemento seja {@code null}.
	 * @throws IndexOutOfBoundsException caso o índice não seja válido. 
	 */
	public T set(int index, T element);
	
	/**
	 * Método que retorna o índice da primeira ocorrência de um elemento
	 * especificado na lista, ou -1 caso o elemento não esteja presente na mesma.
	 * 
	 * @param element o elemento a ser procurado.
	 * @return o índice da primeira ocorrência desse elemento, ou -1 caso ele
	 *         não exista na lista.
	 * @throws IndexOutOfBoundsException caso o índice não seja válido. 
	 */
	public int indexOf(T element);
	
	/**
	 * Método que verifica se um determinado elemento existe na lista.
	 * 
	 * @param element o elemento a ser procurado.
	 * @return um booleano {@code true} caso o elemento exista na lista ou
	 *         {@code false} caso contrário.
	 */
	public boolean contains(T element);
	
	/**
	 * Método que retorna o tamanho atual da lista.
	 * 
	 * @return o inteiro que representa o tamanho atual da lista.
	 */
	public int size();
	
	/**
	 * Método que remove todos os elementos da lista.
	 */
	public void clear();
	
	/**
	 * Método que verifica se a lista está vazia.
	 * 
	 * @return um booleano {@code true} caso a lista esteja vazia,
	 *         ou {@code false} caso não esteja.
	 */
	public boolean isEmpty();
	
	/**
	 * Método que verifica se a lista está cheia.
	 * 
	 * @return um booleano {@code true} caso a lista esteja cheia,
	 *         ou {@code false} caso não esteja.
	 */
	public boolean isFull();
}
