package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
//		Refatora��o para deixar o c�digio mais limpo e eliminado os if's excessivos, padr�o de projeto Strategy.
		BigDecimal percentual = desempenho.percentualAjuste();
		BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
		funcionario.reajustarSalario(reajuste);
		
//		C�digo elminado em refatora��o
//		Agora o enum me devolve a l�gica e aqui eu s� chama o m�todo
//		if (desempenho == Desempenho.A_DESEJAR) {
//			BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
//			funcionario.reajustarSalario(reajuste);
//		} else if (desempenho == Desempenho.BOM) {
//			BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
//			funcionario.reajustarSalario(reajuste);
//		} else {
//			BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.2"));
//			funcionario.reajustarSalario(reajuste);
//		}	
		
	}

}
