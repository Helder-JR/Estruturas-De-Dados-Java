package estruturas;

import interfaces.Lista;

/**
 * Classe que implementa a interface Lista, porém com a utilização de arrays,
 * com a adição que quando o array fica cheio seu tamanho é aumentado.
 * 
 * @param <T> o tipo que a lista terá.
 *
 * @author Helder Chaves Leite Junior
 * @see Lista
 */
public class ListaComArray<T> implements Lista<T>
{
	/**
	 * O array que irá armazenar a lista de elementos.
	 */
	private T[] list;

	/**
	 * O inteiro que representa o tamanho da listas.
	 */
	private int size;

	/**
	 * A constante que representa a capacidade padrão da lista.
	 */
	private static final int DEFAULT_CAPACITY = 20;

	/**
	 * Método que cria uma lista com base em uma capacidade especificada.
	 * 
	 * @param length a capacidade total que a lista terá.
	 * @throws IllegalArgumentException caso a capacidade especificada não seja
	 *                                  válida.
	 */
	@SuppressWarnings("unchecked")
	public ListaComArray(int length) throws IllegalArgumentException
	{
		if (length <= 0)
			throw new IllegalArgumentException("Illegal capacity " + length);

		this.list = (T[]) new Object[length];
		this.size = 0;
	}

	public ListaComArray()
	{
		this(DEFAULT_CAPACITY);
	}
	
	@Override
	public void addFirst(T element)
	{
		if (element != null)
		{
			if (this.isEmpty())
				this.list[0] = element;
			else if (this.isFull())
			{
				this.resize();
				this.shiftRight(0);
				this.list[0] = element;
			}
			else
			{
				this.shiftRight(0);
				this.list[0] = element;
			}

			this.size++;
		}
	}
	
	@Override
	public void add(T element, int index) throws IndexOutOfBoundsException
	{
		if (element != null)
		{
			this.indexCheck(index, this.size);

			if (this.isEmpty())
				this.list[0] = element;
			else if (this.isFull())
			{
				this.resize();
				this.shiftRight(index);
				this.list[index] = element;
			}
			else
			{
				this.shiftRight(index);
				this.list[index] = element;
			}
			
			this.size++;
		}
	}

	@Override
	public void addLast(T element)
	{
		if (element != null)
		{
			if (this.isFull())
				this.resize();

			this.list[this.size++] = element;
		}
	}

	@Override
	public T removeFirst()
	{
		if (this.isEmpty())
			return null;
		else
		{
			T removed = this.list[0];
			
			this.shiftLeft(0);
			this.list[--this.size] = null;
			
			return removed;
		}
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException
	{
		if (this.isEmpty())
			return null;
		else
		{
			this.indexCheck(index, this.size);
			
			T removed = this.list[index];
			
			this.shiftLeft(index);
			this.list[--this.size] = null;
			
			return removed;
		}
	}

	@Override
	public T removeLast()
	{
		if (this.isEmpty())
			return null;
		else
		{
			T removed = this.list[this.size - 1];
			
			this.list[--this.size] = null;
			
			return removed;
		}
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException
	{
		this.indexCheck(index, this.size);

		return this.list[index];
	}

	@Override
	public T set(int index, T element) throws IndexOutOfBoundsException
	{
		this.indexCheck(index, this.size);

		T removed = this.list[index];

		this.list[index] = element;

		return removed;
	}

	@Override
	public int indexOf(T element)
	{
		if (this.isEmpty() || element == null)
			return -1;

		for (int i = 0; i < this.size; i++)
			if (this.list[i] == element)
				return i;

		return -1;
	}

	@Override
	public boolean contains(T element)
	{
		if (this.isEmpty() || element == null)
			return false;

		for (int i = 0; i < this.size; i++)
			if (this.list[i] == element)
				return true;

		return false;
	}

	@Override
	public int size()
	{
		return this.size;
	}

	@Override
	public void clear()
	{
		if (!this.isEmpty())
			for (int i = 0; i < this.size; i++)
				this.list[i] = null;
	}

	@Override
	public boolean isEmpty()
	{
		return this.size == 0;
	}

	@Override
	public boolean isFull()
	{
		return this.size == this.list.length;
	}

	/**
	 * Método auxiliar que aumenta a capacidade total da lista assim que a
	 * mesma é completamente preenchida com elementos.
	 */
	@SuppressWarnings("unchecked")
	private void resize()
	{
		T[] newList = (T[]) new Object[2 * this.list.length];
		
		for (int i = 0; i < this.size; i++)
			newList[i] = this.list[i];
		
		this.list = newList;
	}

	/**
	 * Método auxiliar que a partir de um índice especificado sobrepõe o
	 * elemento nesse devido índice pelo próximo elemento no array, fazendo
	 * isso com todos os elementos subsequentes.
	 * 
	 * @param index o índice do elemento que será sobrescrito.
	 */
	private void shiftLeft(int index)
	{
		for (int i = index; i < this.size - 1; i++)
			this.list[i] = this.list[i + 1];
	}

	/**
	 * Método auxiliar que a partir de um índice especificado copia todos os
	 * elementos do array para uma posição à frente, de modo que o elemento do
	 * índice especificado tenha o seu conteúdo idêntico ao do próximo índice.
	 * 
	 * @param index o índice de onde a cópia inicia.
	 */
	private void shiftRight(int index)
	{
		for (int i = this.size; i > index; i--)
			this.list[i] = this.list[i - 1];
	}
	
	/**
	 * Método auxiliar que checa a validade de um índice em um array, de forma
	 * que caso esse índice não seja válido uma exceção seja lançada.
	 * 
	 * @param index o índice a ser verificado.
	 * @param size o tamanho atual do array.
	 */
	private void indexCheck(int index, int size)
	{
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("InvalidIndexException");
	}
}
