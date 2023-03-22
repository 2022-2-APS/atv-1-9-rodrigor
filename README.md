**Universidade Federal da Paraíba - UFPB** \
**Centro de Ciências Exatas e Educação - CCAE** \
**Departamento de Ciências Exatas - DCX**

**Professor:** [Rodrigo Rebouças de Almeida](http://rodrigor.dcx.ufpb.br)

# Banco

## Projete as classes de negócio de um sistema bancário.

O sistema deve manter o controle de contas para correntistas. Os correntistas podem ser pessoas físicas ou jurídicas.
Uma pessoa física possui cpf, nome, endereço, data de nascimento, telefone.
Uma pessoa jurídica possui cnpj, nome fantasia, nome, endereço, telefone.
Um correntista pode ter mais de uma conta no banco.
Uma conta pode ser conta simples ou conta especial.
Uma conta possui um número de conta e tem apenas um correntista.
Um banco tem várias contas.
Na conta simples não é possível sacar um valor meior que o seu saldo.
A conta especial possui uma margem de crédito. Neste caso, é possível sacar um valor até o valor da margem.
Deve ser possível sacar e depositar valores na conta do aluno.
Deve ser possível gerar um extrato da conta, contendo todas as transações de créditos e débitos, e o saldo da conta.
O extrato deve informar a data e horário em que a transação aconteceu.

Exemplo do extrato:

```
CONTA ESPECIAL
Correntista: João da Silva
Número da conta: 234
Crédito: 50,00

EXTRATO:

Saldo inicial: 0,00

18/03/2023 08:42 DEPOSITO  R$  10,00
19/03/2023 10:42 SAQUE     R$ (20,00)
20/03/2023 08:42 DEPOSITO  R$  30,00

SALDO DA CONTA: 20,00
```

## Faça testes nas classes que você criou. 
