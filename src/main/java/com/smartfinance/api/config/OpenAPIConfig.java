package com.smartfinance.api.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Smart Finance API")
                .description("A Smart Finance API é uma aplicação backend desenvolvida para organizar finanças pessoais de forma simples e em um lugar só. Ela permite o cadastro e autenticação de usuários, além de exibir informações sobre movimentações financeiras como receitas e despesas vindas de várias fontes de dados.\n" +
                        "\n" +
                        "A API utiliza autenticação via JWT (JSON Web Token) para garantir segurança no acesso às rotas protegidas, mantendo os dados do usuário isolados e seguros.\n" +
                        "\n" +
                        "Além do controle financeiro, o sistema também integra um modelo de LLM (Large Language Model) para fornecer sugestões e dicas personalizadas de educação financeira, ajudando o usuário a tomar melhores decisões sobre seus gastos e organização financeira.")
                .version("1.0.0"));
    }
}
