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
	private T[] pilha;
	
	/**
	 * A inteiro que representa a capacidade total da pilha.
	 */
	private int capacidade;
	
	/**
	 * O inteiro que representa o índice do topo da pilha.
	 */
	private int topo;
	
	/**
	 * Método que cria uma pilha com base em uma capacidade
	 * especificada.
	 * 
	 * @param capacidade a capacidade total que a pilha terá.
	 */
	@SuppressWarnings("unchecked")
	public PilhaComArray(int capacidade)
	{
		this.pilha = (T[]) new Object[capacidade];
		this.capacidade = capacidade;
		this.topo = -1;
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
