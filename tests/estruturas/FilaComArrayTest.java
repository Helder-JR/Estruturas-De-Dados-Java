package estruturas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interfaces.Fila;

/**
 * Teste de unidade responsável por verificar os métodos da classe
 * FilaComArray.
 * 
 * @author Helder Chaves Leite Junior
 * @see FilaComArray
 */
class FilaComArrayTest
{
	private Fila<Integer> queue;
	
	@BeforeEach
	void criaFilaComArray()
	{
		this.queue = new FilaComArray<>();
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
			Fila<Integer> fila = new FilaComArray<Integer>(2);
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
			Fila<Integer> fila = new FilaComArray<Integer>(2);
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
