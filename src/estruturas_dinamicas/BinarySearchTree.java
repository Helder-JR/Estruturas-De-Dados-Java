package estruturas_dinamicas;

import interfaces.Tree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>
{
	private TreeNode root;

	public BinarySearchTree()
	{
		this.root = null;
	}

	@Override
	public boolean isEmpty()
	{
		return this.root == null;
	}
	
	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int height()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(T element)
	{
		if (element != null)
		{
			TreeNode newNode = new TreeNode(element);
			
			if (this.isEmpty())
				this.root = newNode;
			else
			{
				TreeNode auxiliar = this.root;
				
				while (auxiliar != null)
				{
					if (newNode.data.compareTo(auxiliar.data) < 0)
					{
						if (auxiliar.left == null)
						{
							auxiliar.left = newNode;
							newNode.parent = auxiliar;
							break;
						}
						else
							auxiliar = auxiliar.left;
					}
					else if (newNode.data.compareTo(auxiliar.data) > 0)
					{
						if (auxiliar.right == null)
						{
							auxiliar.right = newNode;
							newNode.parent = auxiliar;
							break;
						}
						else
							auxiliar = auxiliar.right;
					}
				}
			}
		}
	}

	@Override
	public void remove(T element)
	{
		if (element != null && !this.isEmpty())
		{
			
		}
	}

	public TreeNode search(T element)
	{
		TreeNode auxiliar = this.root;
		
		if (element != null)
		{
			while (auxiliar != null)
			{
				if (element.compareTo(auxiliar.data) < 0)
					auxiliar = auxiliar.left;
				else if (element.compareTo(auxiliar.data) > 0)
					auxiliar = auxiliar.right;
				else
					return auxiliar;
			}
		}
		
		return auxiliar;
	}

	public TreeNode minimum()
	{
		TreeNode auxiliar = this.root;
		
		while (auxiliar.left != null)
			auxiliar = auxiliar.left;
		
		return auxiliar;
	}

	public TreeNode maximum()
	{
		TreeNode auxiliar = this.root;
		
		while (auxiliar.right != null)
			auxiliar = auxiliar.right;
		
		return auxiliar;
	}

	@Override
	public int countLeaves()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T[] preOrder()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public T[] inOrder()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public T[] posOrder()
	{
		// TODO Auto-generated method stub

	}

	class TreeNode
	{
		TreeNode parent;
		TreeNode left;
		TreeNode right;
		T data;

		TreeNode(T data)
		{
			this.data = data;
		}
	}
}
