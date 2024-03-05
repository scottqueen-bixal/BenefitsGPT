package org.mfusco;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;

import static java.time.Duration.ofSeconds;

public class BenefitChat {

    private final ChatLanguageModel model;

    private final ApplicantExtractor extractor;

    private final BenefitEligibilityCalculator benefitEligibilityCalculator = new BenefitEligibilityCalculator();

    private final Assistant assistant;

    public BenefitChat(String openAiApiKey) {
        model = OpenAiChatModel.builder()
                .apiKey(openAiApiKey)
                .timeout(ofSeconds(60))
                .build();

        extractor = AiServices.create(ApplicantExtractor.class, model);

        assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(model)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .tools(benefitEligibilityCalculator)
                .build();
    }

    public String chat(String text) {
        return text.endsWith("?") ? assistant.chat(text) : extractApplicant(text);
    }

    private String extractApplicant(String text) {
        Applicant applicant = extractor.extractApplicantFrom(text);
        benefitEligibilityCalculator.register(applicant);
        return applicant.toString();
    }
}
