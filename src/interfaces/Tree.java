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
	/**
	 * Método que insere um elemento na árvore, de acordo com a sua especificidade
	 * de inserção.
	 * 
	 * @param element o elemento a ser inserido no nó da árvore.
	 * @throws IllegalArgumentException caso o elemento seja de um tipo
	 *         diferente do esperado.
	 * @throws NullPointerException caso o elemento seja {@code null}.
	 */
	public void insert(T element);
	
	/**
	 * Método que remove um elemento da árvore, seguindo sua especificidade de
	 * remoção.
	 * 
	 * @param element o elemento do nó a ser removido da árvore.
	 * @throws IllegalArgumentException caso o elemento seja de um tipo
	 *         diferente do esperado.
	 * @throws NullPointerException caso o elemento seja {@code null}.
	 */
	public void remove(T element);
	
	/**
	 * Método que verifica se uma árvore está vazia, geralmente verificando se
	 * o nó raíz aponta para null.
	 * 
	 * @return um booleano {@code true} caso a árvore esteja vazia, ou {@code false}
	 *            caso contrário.
	 */
	public boolean isEmpty();
	
	/**
	 * Método que conta o tamanho total da árvore, ou seja, a quantidade de nós
	 * que a mesma possui até o momento da contagem.
	 * 
	 * @return um inteiro que representa o tamanho atual da árvore.
	 */
	public int size();
	
	/**
	 * Método que calcula a altura máxima da árvore. Se ela estiver vazia, a
	 * sua altura é -1, caso tenha apenas um elemento a altura é 0, e assim por
	 * diante.
	 * 
	 * @return um inteiro que representa a altura máxima da árvore a partir da
	 *         raíz.
	 */
	public int height();
	
	/**
	 * Método que conta a quantidade de folhas que a árvore possui. Uma folha
	 * basicamente é um nó que possui grau 0 (não contém sub-árvores à esquerda
	 * e/ou à direita).
	 * 
	 * @return o inteiro que representa o número de folhas que a árvore possui.
	 */
	public int countLeaves();
}
