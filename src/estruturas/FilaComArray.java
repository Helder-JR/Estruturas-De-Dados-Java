package estruturas;

import interfaces.Fila;

/**
 * Classe que implementa a interface Fila, por�m com a utiliza��o
 * de arrays, de modo que seu tamanho � fixo a partir da cria��o.
 * 
 * @param <T> o tipo que a fila ter�.
 *
 * @author Helder Chaves Leite Junior
 * @see Fila
 */
public class FilaComArray<T> implements Fila<T>
{
	/**
	 * O array que ir� armazenar a fila de elementos.
	 */
	private T[] queue;
	
	/**
	 * O inteiro que representa o �ndice do fim da fila.
	 */
	private int tail;
	
	/**
	 * M�todo que cria uma fila com base em uma capacidade
	 * especificada.
	 * 
	 * @param length a capacidade total que a fila ter�.
	 */
	@SuppressWarnings("unchecked")
	public FilaComArray(int length)
	{
		this.queue = (T[]) new Object[length];
		this.tail = -1;
	}
	
	/**
	 * M�todo que cria uma fila com capacidade de armazenar 20
	 * elementos.
	 */
	public FilaComArray()
	{
		this(20);
	}
	
	@Override
	public void push(T element) throws RuntimeException
	{
		if (this.isFull())
			throw new RuntimeException("FullQueueException");
		
		if (!element.equals(null))
			this.queue[++this.tail] = element;
	}

	@Override
	public T pop() throws RuntimeException
	{
		if (this.isEmpty())
			throw new RuntimeException("EmptyQueueException");
		
		T removed = this.queue[0];
		
		for (int i = 0; i < this.tail; i++)
			this.queue[i] = this.queue[i + 1];
		
		this.tail--;
		
		return removed;
	}

	@Override
	public T head()
	{
		if (this.isEmpty())
			return null;
		else
			return this.queue[0];
	}

	@Override
	public int size()
	{
		return this.tail + 1;
	}

	@Override
	public boolean isEmpty()
	{
		return this.tail == -1;
	}

	@Override
	public boolean isFull()
	{
		return this.tail == (this.queue.length - 1);
	}
}
