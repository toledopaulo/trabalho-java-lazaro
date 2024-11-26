package com.moretti.natatoys.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LoginService {

    private HashMap<String, String[]> usuarios; // Map para armazenar dados (email -> [senha, tipo])

    public LoginService() {
        carregarUsuarios(); // Carrega os dados ao instanciar a classe
    }

    /**
     * Carrega os usuários a partir do arquivo texto.
     */
    private void carregarUsuarios() {
        usuarios = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Paulo\\Documents\\NetBeansProjects\\nataToys\\src\\main\\java\\usuarios.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 4) {
                    String tipo = partes[0].trim();
                    String email = partes[1].trim();
                    String senha = partes[2].trim();
                    String nome = partes[3].trim();
                    usuarios.put(email, new String[]{senha, tipo});
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar usuários: " + e.getMessage());
        }
    }

    /**
     * Valida o login com base no e-mail e senha fornecidos.
     *
     * @param email E-mail do usuário
     * @param senha Senha do usuário
     * @return Tipo do usuário (admin/cliente) ou null se inválido
     */
    public String[] validarLogin(String email, String senha) {
        System.out.println("E-mail recebido: " + email);
        System.out.println("Senha recebida: " + senha);

        if (usuarios.containsKey(email)) {
            String[] dados = usuarios.get(email);
            String senhaCorreta = dados[0].trim();

            System.out.println("Senha esperada: " + senhaCorreta);

            if (senha.equals(senhaCorreta)) {
                System.out.println("Login válido!");
                System.out.println(dados[1]);
                return new String[]{dados[1]}; // Retorna tipo e nome
            }
        }
        System.out.println("Login inválido.");
        return null;
    }

}
