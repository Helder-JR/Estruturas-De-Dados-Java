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
	private T[] pilha;
	
	/**
	 * A inteiro que representa a capacidade total da pilha.
	 */
	private int capacidade;
	
	/**
	 * O inteiro que representa o �ndice do topo da pilha.
	 */
	private int topo;
	
	/**
	 * M�todo que cria uma pilha com base em uma capacidade
	 * especificada.
	 * 
	 * @param capacidade a capacidade total que a pilha ter�.
	 */
	@SuppressWarnings("unchecked")
	public PilhaComArray(int capacidade)
	{
		this.pilha = (T[]) new Object[capacidade];
		this.capacidade = capacidade;
		this.topo = -1;
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
	public void push(T elemento)
	{
		if (this.isFull()) throw new RuntimeException("FullStackException");
		this.pilha[++this.topo] = elemento;
	}
	
	@Override
	public T pop()
	{
		if (this.isEmpty()) throw new RuntimeException("EmptyStackException");
		return this.pilha[this.topo--];
	}

	@Override
	public T peek()
	{
		return this.pilha[this.topo];
	}

	@Override
	public int size()
	{
		return this.topo + 1;
	}
	
	@Override
	public boolean isEmpty()
	{
		return this.topo == -1;
	}

	@Override
	public boolean isFull()
	{
		return this.topo == (this.capacidade - 1);
	}
}
