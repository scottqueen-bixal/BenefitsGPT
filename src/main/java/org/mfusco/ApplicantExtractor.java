package org.mfusco;

import dev.langchain4j.service.UserMessage;

public interface ApplicantExtractor {

    String message = "Extract information about a applicant from {{it}}. Calculate dates based on todays YYYY-MM-DD values.";

    @UserMessage(message)
    Applicant extractApplicantFrom(String text);
}
