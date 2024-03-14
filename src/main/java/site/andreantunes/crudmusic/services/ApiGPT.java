package site.andreantunes.crudmusic.services;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ApiGPT {
    public static String obterDescricao(String texto) {
        OpenAiService service = new OpenAiService(System.getenv("OPENAI_API_KEY"));

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct") //text-davinci-003 is deprecated
                .prompt("Descreve resumidamente sobre o artista, dupla ou banda: " + texto)
                .maxTokens(500)
                .temperature(0.5)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}
