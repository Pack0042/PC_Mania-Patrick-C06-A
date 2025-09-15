package br.inatel.componentes;

public class Computador {
    private String marca;
    private float preco;

    private HardwareBasico[] hardware;
    private SistemaOperacional sistema;
    private MemoriaUSB musb;

    public Computador(String marca, float preco, HardwareBasico[] hardware, SistemaOperacional sistema) {
        this.marca = marca;
        this.preco = preco;
        this.hardware = hardware;
        this.sistema = sistema;
    }

    public float getPreco() {
        return preco;
    }

    public String getMarca() {
        return marca;
    }

    public void mostraPCConfigs() {
        System.out.printf("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("\nMarca: " + marca);
        System.out.println("Preco: R$" + preco);

        System.out.println("\nHardware: ");
        for (int i = 0; i < hardware.length; i++) {
            System.out.println("-" + hardware[i].getNome() + " (" + hardware[i].getCapacidade() + ")" );
        }

        System.out.println("\nSistema: " + sistema.getNome() + " (" + sistema.getTipo() + " bits)" );

        if (musb != null) {
            System.out.println("Memória USB: " + musb.getNome() + " (" + musb.getCapacidade() + " Gb)");
        }

        System.out.printf("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n");
    }

    public void addMemoriaUSB(MemoriaUSB musb) {
        this.musb = musb;
    }


}
