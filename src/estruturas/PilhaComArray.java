package estruturas;

import interfaces.Pilha;

/**
 * Classe que implementa a interface Pilha, porém com a utilização
 * de arrays, de modo que seu tamanho é fixo a partir da criação.
 * 
 * @param <T> o tipo que a pilha terá.
 *
 * @author Helder Chaves Leite Junior
 * @see Pilha
 */
public class PilhaComArray<T> implements Pilha<T>
{
	/**
	 * O array que irá armazenar a pilha de elementos.
	 */
	private T[] stack;
		
	/**
	 * O inteiro que representa o índice do topo da pilha.
	 */
	private int top;
	
	/**
	 * Método que cria uma pilha com base em uma capacidade
	 * especificada.
	 * 
	 * @param length a capacidade total que a pilha terá.
	 */
	@SuppressWarnings("unchecked")
	public PilhaComArray(int length)
	{
		this.stack = (T[]) new Object[length];
		this.top = -1;
	}
	
	/**
	 * Método que cria uma pilha com capacidade de armazenar 20
	 * elementos.
	 */
	public PilhaComArray()
	{
		this(20);
	}
	
	@Override
	public void push(T element) throws RuntimeException
	{
		if (this.isFull())
			throw new RuntimeException("FullStackException");
		
		this.stack[++this.top] = element;
	}
	
	@Override
	public T pop() throws RuntimeException
	{
		if (this.isEmpty())
			throw new RuntimeException("EmptyStackException");
		
		return this.stack[this.top--];
	}

	@Override
	public T peek()
	{
		return this.stack[this.top];
	}

	@Override
	public int size()
	{
		return this.top + 1;
	}
	
	@Override
	public boolean isEmpty()
	{
		return this.top == -1;
	}

	@Override
	public boolean isFull()
	{
		return this.top == (this.stack.length - 1);
	}
}
