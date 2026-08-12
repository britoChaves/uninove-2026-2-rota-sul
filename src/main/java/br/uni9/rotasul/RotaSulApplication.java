package br.uni9.rotasul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Ponto de entrada da aplicação da Rota Sul.
 *
 * <p>Esta é a única classe do repositório-esqueleto. O primeiro código de
 * aplicação entra na Aula 06, quando as três camadas aparecem e os pacotes
 * {@code br.uni9.rotasul.<contexto>.<camada>} começam a ser criados.
 */
@SpringBootApplication
public class RotaSulApplication {

    public static void main(String[] args) {
        SpringApplication.run(RotaSulApplication.class, args);
    }

}
