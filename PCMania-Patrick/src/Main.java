import br.inatel.clientes.Cliente;
import br.inatel.componentes.Computador;
import br.inatel.componentes.HardwareBasico;
import br.inatel.componentes.MemoriaUSB;
import br.inatel.componentes.SistemaOperacional;
import br.inatel.utilitarios.ProcessarPedido;

import java.util.Scanner;

public class Main {

    private static void mostraMenu() {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("|                                 PC Mania                                |");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("| Qual promoção deseja comprar?                                           |");
        System.out.println("| Digite 1, 2 ou 3. Caso queira parar de comprar, digite 0                |");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    public static void main(String[] args) {

        //Promocao 1
        HardwareBasico p1_hardware1 = new HardwareBasico("Pentium Core i3", 2200);
        HardwareBasico p1_hardware2 = new HardwareBasico("Memória RAM", 8);
        HardwareBasico p1_hardware3 = new HardwareBasico("HD", 500);

        HardwareBasico[] listaHardware1 = new HardwareBasico[3];
        listaHardware1[0] = p1_hardware1;
        listaHardware1[1] = p1_hardware2;
        listaHardware1[2] = p1_hardware3;

        SistemaOperacional sistema1 = new SistemaOperacional("macOS Sequoia", 64);

        Computador promocao1 = new Computador("Apple", 496, listaHardware1, sistema1);

        MemoriaUSB memoria1 = new MemoriaUSB("Pen-drive", 16);
        promocao1.addMemoriaUSB(memoria1);




        //Promocao 2
        HardwareBasico p2_hardware1 = new HardwareBasico("Pentium Core i5", 3370);
        HardwareBasico p2_hardware2 = new HardwareBasico("Memória RAM", 16);
        HardwareBasico p2_hardware3 = new HardwareBasico("HD", 1000);

        HardwareBasico[] listaHardware2 = new HardwareBasico[3];
        listaHardware2[0] = p2_hardware1;
        listaHardware2[1] = p2_hardware2;
        listaHardware2[2] = p2_hardware3;

        SistemaOperacional sistema2 = new SistemaOperacional("Windows 8", 64);

        Computador promocao2 = new Computador("Samsung", 496 + 1234, listaHardware2, sistema2);

        MemoriaUSB memoria2 = new MemoriaUSB("Pen-drive", 32);
        promocao2.addMemoriaUSB(memoria2);




        // Promocao 3
        HardwareBasico p3_hardware1 = new HardwareBasico("Pentium Core i7", 4500);
        HardwareBasico p3_hardware2 = new HardwareBasico("Memória RAM", 32);
        HardwareBasico p3_hardware3 = new HardwareBasico("HD", 2000);

        HardwareBasico[] listaHardware3 = new HardwareBasico[3];
        listaHardware3[0] = p3_hardware1;
        listaHardware3[1] = p3_hardware2;
        listaHardware3[2] = p3_hardware3;

        SistemaOperacional sistema3 = new SistemaOperacional("Windows 10", 64);

        Computador promocao3 = new Computador("Dell", 496 + 5678, listaHardware3, sistema3);

        MemoriaUSB memoria3 = new MemoriaUSB("HD Externo", 1000);
        promocao3.addMemoriaUSB(memoria3);

        //br.inatel.clientes.Cliente
        Cliente cliente = new Cliente("Patrick", "561.082.770-17");


        //Fluxo principal

        Scanner scanner = new Scanner(System.in);
        Computador[] compra = new Computador[50];
        int total = 0;
        int opcao = 1;

        System.out.println("\n\nPromoções disponíveis: ");
        System.out.println("\nPromoção 1: ");
        promocao1.mostraPCConfigs();
        System.out.println("\nPromoção 2: ");
        promocao2.mostraPCConfigs();
        System.out.println("\nPromoção 3: ");
        promocao3.mostraPCConfigs();

        while (opcao != 0) {
            mostraMenu();
            opcao = scanner.nextInt();
            if (opcao < 0 || opcao > 4) {
                System.out.println("Informe uma opção válida!");
            } else {
                switch (opcao) {
                    case 1:
                        for (int i = 0; i < compra.length; i++){
                            if (compra[i] == null) {
                                compra[i] = promocao1;
                                break;
                            }
                        }
                        total++;
                        break;
                    case 2:
                        for (int i = 0; i < compra.length; i++){
                            if (compra[i] == null) {
                                compra[i] = promocao2;
                                break;
                            }
                        }
                        total++;
                        break;
                    case 3:
                        for (int i = 0; i < compra.length; i++){
                            if (compra[i] == null) {
                                compra[i] = promocao3;
                                break;
                            }
                        }
                        total++;
                        break;
                    case 0:
                        if (total < 2) {
                            System.out.println("Você deve escolher pelo menos 2 computadores!");
                            opcao = 1;
                        }
                        break;
                }
            }
        }

        cliente.setCompra(compra);

        ProcessarPedido.finalizarPedido(compra);
        System.out.println("\nPreço Total: R$" + cliente.calculaTotalCompra());
    }
}