package br.ufpb.dcx.aps.atividade.banco;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transacao {

    private BigDecimal valor;
    private TipoTransacao tipo;

    private LocalDateTime dataHora;

    public Transacao(TipoTransacao tipo, BigDecimal valor){
        this.dataHora = LocalDateTime.now();
    }

    public BigDecimal getValor() {
        return (this.tipo == TipoTransacao.SAQUE)?valor.negate():valor;
    }

    public void setValor(BigDecimal valor) {
        if(valor.signum() < 0)
            throw new IllegalArgumentException("valor inválido: menor que zero");
        this.valor = valor;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }


    public LocalDateTime getDataHora() {
        return dataHora;
    }

}
