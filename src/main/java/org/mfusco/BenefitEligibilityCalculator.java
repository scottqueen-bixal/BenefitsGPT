package org.mfusco;

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
        KieHelper kieHelper = new KieHelper();
        kieBase = kieHelper
                .addFromClassPath("/covid-funeral-assistance.drl")
                .build(ExecutableModelProject.class);
    }

    public String benefitEligibility(String name) {
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
            return "Yes, " + applicant.getFullName() + " is likely eligible for Covid funeral assistance";
        }
        return "" + applicant.getFullName() + " is not eligible for Covid funeral assistance because " + answers;
    }

    public void register(Applicant applicant) {
        applicantRegistry.put(applicant.applicantFirstName(), applicant);
    }
}
