package org.mfusco;

import java.time.LocalDate;
import java.util.Arrays;

public record Applicant(
        String applicantFirstName,
        String applicantLastName,
        LocalDate applicantBirthDate,
        String applicantRelationshipToDeceased,
        String applicantMaritalStatus,
        Boolean applicantCitizenStatus,
        Boolean applicantPaidFuneralExpenses,
        Boolean applicantReimbursedFuneralExpenses,
        LocalDate deceasedDateOfDeath,
        Boolean deceasedDiedInUs,
        Boolean deceasedDiedFromCovid) {

    @Override
    public String toString() {
        return "Applicant {" +
                " applicantFirstName = \"" + applicantFirstName + "\"" +
                ", applicantLastName = \"" + applicantLastName + "\"" +
                ", applicantBirthDate = " + applicantBirthDate +
                ", applicantRelationshipToDeceased = " + applicantRelationshipToDeceased +
                ", applicantMaritalStatus = " + applicantMaritalStatus +
                ", applicantCitizenStatus = " + applicantCitizenStatus +
                ", applicantPaidFuneralExpenses = " + applicantPaidFuneralExpenses +
                ", applicantReimbursedFuneralExpenses = " + applicantReimbursedFuneralExpenses +
                ", deceasedDateOfDeath = " + deceasedDateOfDeath +
                ", deceasedDiedInUs = " + deceasedDiedInUs +
                ", deceasedDiedFromCovid = " + deceasedDiedFromCovid +
                " }";
    }

    public String getFullName() {
        return applicantFirstName + " " + applicantLastName;
    }

    public int getAge() {
        return applicantBirthDate.until(LocalDate.now()).getYears();
    }

    public boolean getApplicantRelationshipToDeceased(String[] applicantRelationships) {
        for (String relationship : applicantRelationships) {
            if (Arrays.asList(applicantRelationshipToDeceased).contains(relationship)) {
                return true;
            }
        }
        return false;
    }

    public int getDeath() {
        return deceasedDateOfDeath.until(LocalDate.now()).getYears();
    }
}
