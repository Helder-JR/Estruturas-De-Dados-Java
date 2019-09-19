package estruturas;

import interfaces.Pilha;

/**
 * Classe que implementa a interface Pilha, por�m com a utiliza��o
 * de arrays, de modo que seu tamanho � fixo a partir da cria��o.
 * 
 * @param <T> o tipo que a pilha ter�.
 *
 * @author Helder Chaves Leite Junior
 * @see Pilha
 */
public class PilhaComArray<T> implements Pilha<T>
{
	/**
	 * O array que ir� armazenar a pilha de elementos.
	 */
	private T[] stack;
		
	/**
	 * O inteiro que representa o �ndice do topo da pilha.
	 */
	private int top;
	
	/**
	 * M�todo que cria uma pilha com base em uma capacidade
	 * especificada.
	 * 
	 * @param length a capacidade total que a pilha ter�.
	 */
	@SuppressWarnings("unchecked")
	public PilhaComArray(int length)
	{
		this.stack = (T[]) new Object[length];
		this.top = -1;
	}
	
	/**
	 * M�todo que cria uma pilha com capacidade de armazenar 20
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
