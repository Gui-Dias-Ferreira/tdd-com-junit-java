package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {
	
//	� uma boa pratica escrever o nome do m�todo bem descritivo.
	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
//		Lidando com exce��o,				  lambda
//		assertThrows(nome-da-exception.class, () ->   codigo que lan�a a excption)
		assertThrows(IllegalArgumentException.class, 
				() -> service.calcularBonus(new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("25000"))));
		
//		outra forma de lan�ar exce��o
//		nesse caso � para cair dentro do bloco catch por isso tem o m�todo fail(), para for�ar o error caso n�o caia no catch
//		try {
//			service.calcularBonus(new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("25000")));
//			fail("N�o deu a exception");
//		} catch (Exception e) {
//			assertEquals("Funcion�rio com s�lario maior do que R$1000 n�o pode receber b�nus", e.getMessage());
//		}
		
//		j� fez o import l� em cima, para evitar de ficar escrevendo o nome da classe a todo instante, Assert.assert*
//		assertEquals(BigDecimal.ZERO, bonus);
	}
	
	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}
	
	

}
