package estruturas_estaticas;

import interfaces.Stack;

/**
 * Classe que implementa a interface Pilha, porém com a utilização de arrays,
 * de modo que seu tamanho é fixo a partir da criação.
 * 
 * @param <T> o tipo que a pilha terá.
 *
 * @author Helder Chaves Leite Junior
 * @see Stack
 */
public class ArrayStack<T> implements Stack<T>
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
	 * Capacidade padrão que a pilha terá caso não seja especificada no construtor.
	 */
	private static final int DEFAULT_CAPACITY = 20;
	
	/**
	 * Método que cria uma pilha com base em uma capacidade especificada.
	 * 
	 * @param length a capacidade total que a pilha terá.
	 * @throws IllegalArgumentException caso a capacidade especificada não seja
	 *                                  válida.
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int length) throws IllegalArgumentException
	{
		if (length <= 0)
			throw new IllegalArgumentException("Illegal Capacity: " + length);
		
		this.stack = (T[]) new Object[length];
		this.top = -1;
	}
	
	/**
	 * Método que cria uma pilha com capacidade de armazenar a quantidade padrão
	 * de elementos.
	 */
	public ArrayStack()
	{
		this(DEFAULT_CAPACITY);
	}
	
	@Override
	public void push(T element) throws RuntimeException
	{
		if (element != null)
		{
			if (this.isFull())
				throw new RuntimeException("FullStackException");
			
			this.stack[++this.top] = element;
		}
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
		if (this.isEmpty())
			return null;
		
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
