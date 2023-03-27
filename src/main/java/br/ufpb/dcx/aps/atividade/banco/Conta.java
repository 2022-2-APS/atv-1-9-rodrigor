package br.ufpb.dcx.aps.atividade.banco;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Conta {

    private String numeroConta;

    private Correntista correntista;

    private List<Transacao> transacoes;

    private BigDecimal saldoInicial;

    public Conta(Correntista correntista){
        this(correntista,BigDecimal.valueOf(0.0));
    }

    public Conta(Correntista correntista, BigDecimal saldoInicial){
        this("",correntista,saldoInicial);
    }
    public Conta(String numeroConta, Correntista correntista, BigDecimal saldoInicial){
        this.numeroConta = numeroConta;
        transacoes = new LinkedList<>();
        this.correntista = correntista;
        this.saldoInicial = depositar(saldoInicial);
    }



    public BigDecimal depositar(BigDecimal valor){
        if(valor == null || valor.signum() < 0)
            throw new IllegalArgumentException("valor inválido!"+valor);
        transacoes.add(new Transacao(TipoTransacao.DEPOSITO,valor));
        return valor;
    }

    public BigDecimal sacar(BigDecimal valor) throws ContaException{
        if(valor == null || valor.signum() < 0)
            throw new IllegalArgumentException("valor inválido!"+valor);
        BigDecimal saldo = this.getSaldo();
        if(saldo.compareTo(BigDecimal.valueOf(0)) < 0)
            throw new ContaException("Não há saldo suficiente na conta: "+saldo);
        transacoes.add(new Transacao(TipoTransacao.SAQUE,valor));
        return valor;
    }

    public BigDecimal getSaldo(){
        BigDecimal saldo = BigDecimal.valueOf(0.0);
        for(Transacao transacao: transacoes){
            saldo = saldo.add(transacao.getValor());
        }
        return saldo;
    }

    public String gerarExtrato(){
        StringBuilder extrato = new StringBuilder();
        extrato.append("CONTA SIMPLES\n");
        extrato.append("Correntista: "+this.correntista.getNome()+"\n");
        extrato.append("Número da conta: "+this.numeroConta+"\n\n");
        extrato.append("EXTRATO:\n\n");
        extrato.append("Saldo inicial:"+this.saldoInicial+"\n\n");

        for(Transacao transacao: transacoes)
            extrato.append(transacao.toString());
        extrato.append("\nSALDO DA CONTA:\t"+this.getSaldo());
        return extrato.toString();
    }





}
