package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
//		Refatoração para deixar o códigio mais limpo e eliminado os if's excessivos, padrão de projeto Strategy.
		BigDecimal percentual = desempenho.percentualAjuste();
		BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
		funcionario.reajustarSalario(reajuste);
		
//		Código elminado em refatoração
//		Agora o enum me devolve a lógica e aqui eu só chama o método
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
