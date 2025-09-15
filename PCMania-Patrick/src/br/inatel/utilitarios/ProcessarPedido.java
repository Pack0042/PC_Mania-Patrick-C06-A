package br.inatel.utilitarios;

import br.inatel.componentes.Computador;

public class ProcessarPedido {

    public static void finalizarPedido(Computador[] compra) {
        int totalApple = 0;
        int totalSamsung = 0;
        int totalDell = 0;

        System.out.println("Processando pedido...");

        for (Computador computador : compra) {
            if (computador == null) {
                break;
            }

            if (computador.getMarca().equals("Apple")) {
                totalApple++;
            } else if (computador.getMarca().equals("Samsung")) {
                totalSamsung++;
            } else if (computador.getMarca().equals("Dell")) {
                totalDell++;
            }
        }

        System.out.println("Total Computadores Apple: " + totalApple);
        System.out.println("Total Computadores Samsung: " + totalSamsung);
        System.out.println("Total Computadores Dell: " + totalDell);
        System.out.println("Total Computadores: " + (totalApple + totalSamsung + totalDell) );

    }
}
