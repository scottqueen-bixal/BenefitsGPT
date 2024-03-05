package org.mfusco;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.service.V;
import org.drools.model.codegen.ExecutableModelProject;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BenefitEligibilityCalculator {

    private final Map<String, Applicant> applicantRegistry = new HashMap<>();

    private final KieBase kieBase;

    public BenefitEligibilityCalculator() {
        kieBase = new KieHelper().addFromClassPath("/covid-funeral-assistance.drl").build(ExecutableModelProject.class);
    }

    @Tool("Apply benefit eligibility to {{name}}")
    public String benefitEligibility(@V("name") String name) {
        Applicant applicant = applicantRegistry.get(name);

        if (applicant == null) {
            return "Unknown applicant";
        }

        KieSession kieSession = kieBase.newKieSession();
        List<String> answers = new ArrayList<>();
        kieSession.setGlobal("answers", answers);
        kieSession.insert(applicant);
        kieSession.fireAllRules();

        if (answers.isEmpty()) {
            return "Yes, the applicant is eligible.";
        }
        return "The applicant is not eligible for the benefit because " + answers;
    }

    public void register(Applicant applicant) {
        applicantRegistry.put(applicant.applicantFirstName(), applicant);
    }
}
