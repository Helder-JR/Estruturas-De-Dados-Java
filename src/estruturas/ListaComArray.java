package estruturas;

import interfaces.Lista;

public class ListaComArray<T> implements Lista<T>
{
	private T[] list;

	private int size;

	private static final int DEFAULT_CAPACITY = 20;

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

	@SuppressWarnings("unchecked")
	private void resize()
	{
		T[] newList = (T[]) new Object[2 * this.list.length];
		
		for (int i = 0; i < this.size; i++)
			newList[i] = this.list[i];
		
		this.list = newList;
	}

	private void shiftLeft(int index)
	{
		for (int i = index; i < this.size - 1; i++)
			this.list[i] = this.list[i + 1];
	}

	private void shiftRight(int index)
	{
		for (int i = this.size; i > index; i--)
			this.list[i] = this.list[i - 1];
	}
	
	private void indexCheck(int index, int size)
	{
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("InvalidIndexException");
	}
}
