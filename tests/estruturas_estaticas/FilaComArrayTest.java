package estruturas_estaticas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import estruturas_estaticas.ArrayQueue;
import interfaces.Queue;

/**
 * Teste de unidade responsável por verificar os métodos da classe
 * FilaComArray.
 * 
 * @author Helder Chaves Leite Junior
 * @see ArrayQueue
 */
class FilaComArrayTest
{
	private Queue<Integer> queue;
	
	@BeforeEach
	void criaFilaComArray()
	{
		this.queue = new ArrayQueue<>();
	}
	
	@Test
	void testNovaFila()
	{
		assertNotNull(this.queue);
		assertTrue(this.queue.isEmpty());
	}
	
	@Test
	void testAdicionarElementos()
	{
		this.queue.push(32);
		this.queue.push(16);
		assertFalse(this.queue.isEmpty());
		assertEquals(this.queue.head(), 32);
	}
	
	@Test
	void testRemoverElementos()
	{
		this.queue.push(49);
		assertFalse(this.queue.isEmpty());
		this.queue.pop();
		assertTrue(this.queue.isEmpty());
	}
	
	@Test
	void testAdicionarEmFilaCheia()
	{
		try
		{
			Queue<Integer> fila = new ArrayQueue<Integer>(2);
			fila.push(23);
			fila.push(31);
			fila.push(9);
		}
		catch(RuntimeException re)
		{
			System.out.println(re.getMessage());
		}
	}
	
	@Test
	void testRemoverEmFilaVazia()
	{
		try
		{
			Queue<Integer> fila = new ArrayQueue<Integer>(2);
			fila.pop();
		}
		catch (RuntimeException re)
		{
			System.out.println(re.getMessage());
		}
	}
	
	@Test
	void testTamanhoFila()
	{
		this.queue.push(58);
		this.queue.push(291);
		this.queue.push(-25);
		assertEquals(this.queue.size(), 3);
	}
	
	@Test
	void testAdicionaElementoAposRemocao()
	{
		this.queue.push(33);
		this.queue.push(56);
		this.queue.pop();
		this.queue.push(14);
		assertEquals(this.queue.head(), 56);
	}
	
	@Test
	void testElementoRemovido()
	{
		this.queue.push(78);
		this.queue.push(-65);
		assertEquals(this.queue.pop(), 78);
	}
}
