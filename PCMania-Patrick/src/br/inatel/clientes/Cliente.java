package br.inatel.clientes;

import br.inatel.componentes.Computador;

public class Cliente {
    private String nome;
    private String cpf;
    private Computador[] compra;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void setCompra(Computador[] compra) {
        this.compra = compra;
    }

    public float calculaTotalCompra() {
        float total = 0;

        for (Computador computador : compra) {
            if (computador == null) {
                break;
            }
            total += computador.getPreco();
        }

        return total;
    }

}
