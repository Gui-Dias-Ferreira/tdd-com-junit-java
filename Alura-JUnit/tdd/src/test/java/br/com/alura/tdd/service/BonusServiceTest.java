package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {
	
//	É uma boa pratica escrever o nome do método bem descritivo.
	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
//		Lidando com exceção,				  lambda
//		assertThrows(nome-da-exception.class, () ->   codigo que lança a excption)
		assertThrows(IllegalArgumentException.class, 
				() -> service.calcularBonus(new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("25000"))));
		
//		outra forma de lançar exceção
//		nesse caso é para cair dentro do bloco catch por isso tem o método fail(), para forçar o error caso não caia no catch
//		try {
//			service.calcularBonus(new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("25000")));
//			fail("Não deu a exception");
//		} catch (Exception e) {
//			assertEquals("Funcionário com sálario maior do que R$1000 não pode receber bônus", e.getMessage());
//		}
		
//		já fez o import lá em cima, para evitar de ficar escrevendo o nome da classe a todo instante, Assert.assert*
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
