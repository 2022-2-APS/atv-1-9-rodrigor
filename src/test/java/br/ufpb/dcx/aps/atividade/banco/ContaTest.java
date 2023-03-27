package br.ufpb.dcx.aps.atividade.banco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {


    Conta contaTeste;

    @BeforeEach
    void setup(){
        contaTeste = new Conta("123", new Correntista(), BigDecimal.valueOf(10.0));
    }



    @Test
    void depositar() {
        Conta vazia = new Conta(new Correntista());
        vazia.depositar(big(10));
        assertEquals(big(10),vazia.getSaldo());


        vazia.depositar(big(10));
        assertEquals(big(20),vazia.getSaldo());


        assertThrows(IllegalArgumentException.class, () -> vazia.depositar(null));
        assertThrows(IllegalArgumentException.class, () -> vazia.depositar(big(-1)));

    }

    BigDecimal big(double valor){
        return BigDecimal.valueOf(valor);
    }

    BigDecimal big(String valor){
        return new BigDecimal(valor);
    }




    @Test
    void sacar() {
    }

    @Test
    void getSaldo() {
    }

    @Test
    void gerarExtrato() throws ContaException {
        contaTeste.depositar(big(10));
        contaTeste.sacar(big(5));
        System.out.println(contaTeste.gerarExtrato());

    }
}