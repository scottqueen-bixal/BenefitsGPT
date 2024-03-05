package org.mfusco;

import dev.langchain4j.service.UserMessage;

public interface ApplicantExtractor {

    @UserMessage("Extract information about a applicant from {{it}}.")
    Applicant extractApplicantFrom(String text);
}

