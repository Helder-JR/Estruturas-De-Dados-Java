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
	private Pilha<Integer> pilha;
	
	@BeforeEach
	void criaPilhaComArray()
	{
		this.pilha = new PilhaComArray<>();
	}
	
	@Test
	void testNovaPilha()
	{
		assertNotNull(this.pilha);
		assertTrue(this.pilha.isEmpty());
	}
	
	@Test
	void testAdicionarElementos()
	{
		this.pilha.push(32);
		this.pilha.push(16);
		assertFalse(this.pilha.isEmpty());
		assertEquals(this.pilha.peek(), 16);
	}
	
	@Test
	void testRemoverElementos()
	{
		this.pilha.push(49);
		assertFalse(this.pilha.isEmpty());
		this.pilha.pop();
		assertTrue(this.pilha.isEmpty());
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
		this.pilha.push(58);
		this.pilha.push(291);
		this.pilha.push(-25);
		assertEquals(this.pilha.size(), 3);
	}
	
	@Test
	void testAdicionaElementoAposRemocao()
	{
		this.pilha.push(33);
		this.pilha.push(56);
		this.pilha.pop();
		this.pilha.push(14);
		assertEquals(this.pilha.peek(), 14);
	}
	
	@Test
	void testElementoRemovido()
	{
		this.pilha.push(78);
		this.pilha.push(-65);
		assertEquals(this.pilha.pop(), -65);
	}
}
