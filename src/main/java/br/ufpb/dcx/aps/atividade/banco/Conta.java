package br.ufpb.dcx.aps.atividade.banco;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Conta {

    private String numeroConta;

    private Correntista correntista;

    private List<Transacao> transacoes;

    public Conta(Correntista correntista){
        numeroConta = "";
        transacoes = new LinkedList<>();
        this.correntista = correntista;
    }


    public BigDecimal depositar(BigDecimal valor){
        transacoes.add(new Transacao(TipoTransacao.DEPOSITO,valor));
        return valor;
    }

    public BigDecimal sacar(BigDecimal valor) throws ContaException{
        BigDecimal saldo = this.getSaldo();
        if(saldo.compareTo(BigDecimal.valueOf(0)) < 0)
            throw new ContaException("Não há saldo suficiente na conta: "+saldo);
        transacoes.add(new Transacao(TipoTransacao.SAQUE,valor));
        return valor;
    }

    public BigDecimal getSaldo(){
        BigDecimal saldo = BigDecimal.valueOf(0);
        for(Transacao transacao: transacoes){
            saldo = saldo.add(transacao.getValor());
        }
        return saldo;
    }





}
