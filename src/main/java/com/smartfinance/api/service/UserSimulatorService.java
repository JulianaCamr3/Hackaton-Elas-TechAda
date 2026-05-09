package com.smartfinance.api.service;

import com.smartfinance.api.domain.entity.FinanceRegister;
import net.datafaker.Faker;

import java.util.*;

public class UserSimulatorService {

    private final Faker faker = new Faker(new Locale("pt-BR"));
    private final Random random = new Random();

    private final Map<String, String> categorias = Map.of(
            "Netflix", "Filmes", "Disney+", "Filmes", "Spotify", "Música", "Xbox Game Pass", "Jogos"
    );

    private final Map<String, Double> valores = Map.of(
            "Netflix", 39.90, "Disney+", 32.90, "Spotify", 19.90, "Xbox Game Pass", 45.00
    );

    public List<FinanceRegister> gerarVarios(int quantidade) {
        List<FinanceRegister> lista = new ArrayList<>();
        List<String> servicos = new ArrayList<>(valores.keySet());

        for (int i = 0; i < quantidade; i++) {
            String servico = servicos.get(random.nextInt(servicos.size()));
            lista.add(new FinanceRegister(
                    faker.name().fullName(),
                    faker.internet().emailAddress(),
                    servico,
                    categorias.get(servico),
                    valores.get(servico),
                    random.nextInt(1, 24)
            ));
        }
        return lista;
    }

}
