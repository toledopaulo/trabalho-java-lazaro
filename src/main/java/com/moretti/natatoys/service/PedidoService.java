package com.moretti.natatoys.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PedidoService {

    public void salvarCompra(String endereco, String cep, String formaPagamento, List<String> itens) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Paulo\\Documents\\NetBeansProjects\\nataToys\\src\\main\\java\\compras.txt", true))) {
            bw.write("Compra realizada:");
            bw.newLine();
            bw.write("Endereço: " + endereco);
            bw.newLine();
            bw.write("CEP: " + cep);
            bw.newLine();
            bw.write("Forma de pagamento: " + formaPagamento);
            bw.newLine();
            bw.write("Itens:");
            for (String item : itens) {
                bw.newLine();
                bw.write("- " + item);
            }
            bw.newLine();
            bw.write("--------------");
            bw.newLine();
        }
    }
}