package org.mfusco;

import dev.langchain4j.service.UserMessage;

public interface ApplicantExtractor {

    @UserMessage("Extract information about a applicant from {{it}}. When income is null, it is set to 0.")
    Applicant extractApplicantFrom(String text);
}

