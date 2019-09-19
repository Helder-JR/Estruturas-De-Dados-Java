package estruturas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interfaces.Pilha;

/**
 * Teste de unidade responsável por verificar os métodos da classe
 * PilhaComArray.
 * 
 * @author Helder Chaves Leite Junior
 * @see PilhaComArray
 */
class PilhaComArrayTest
{
	private Pilha<Integer> stack;
	
	@BeforeEach
	void criaPilhaComArray()
	{
		this.stack = new PilhaComArray<>();
	}
	
	@Test
	void testNovaPilha()
	{
		assertNotNull(this.stack);
		assertTrue(this.stack.isEmpty());
	}
	
	@Test
	void testAdicionarElementos()
	{
		this.stack.push(32);
		this.stack.push(16);
		assertFalse(this.stack.isEmpty());
		assertEquals(this.stack.peek(), 16);
	}
	
	@Test
	void testRemoverElementos()
	{
		this.stack.push(49);
		assertFalse(this.stack.isEmpty());
		this.stack.pop();
		assertTrue(this.stack.isEmpty());
	}
	
	@Test
	void testAdicionarEmPilhaCheia()
	{
		try
		{
			Pilha<Integer> pilha = new PilhaComArray<Integer>(2);
			pilha.push(23);
			pilha.push(31);
			pilha.push(9);
		}
		catch(RuntimeException re)
		{
			System.out.println(re.getMessage());
		}
	}
	
	@Test
	void testRemoverEmPilhaVazia()
	{
		try
		{
			Pilha<Integer> pilha = new PilhaComArray<Integer>(2);
			pilha.pop();
		}
		catch (RuntimeException re)
		{
			System.out.println(re.getMessage());
		}
	}
	
	@Test
	void testTamanhoPilha()
	{
		this.stack.push(58);
		this.stack.push(291);
		this.stack.push(-25);
		assertEquals(this.stack.size(), 3);
	}
	
	@Test
	void testAdicionaElementoAposRemocao()
	{
		this.stack.push(33);
		this.stack.push(56);
		this.stack.pop();
		this.stack.push(14);
		assertEquals(this.stack.peek(), 14);
	}
	
	@Test
	void testElementoRemovido()
	{
		this.stack.push(78);
		this.stack.push(-65);
		assertEquals(this.stack.pop(), -65);
	}
}
