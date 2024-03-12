package org.mfusco;

import java.time.LocalDate;
import java.util.Arrays;

// likely-eligible
// Today is Mar 5, 2024. The applicant Scott Queen was born in the US. He turned 42 yesterday. His wife died while visiting her mother in Texas from COVID during the second year of the pandemic. He is now caring for a special needs child who was born three years before his wife died. Scott paid for the funeral expenses, but never filed for reimbursement.

// not-eligible
// Today is Mar 5, 2024. The applicant Scott Queen was born in Sudan, but has dual citizenship including U.S. He turned 72 yesterday. His wife died while visiting her mother in Texas from COVID during the first year of the pandemic. He is now caring for a child who was born one year before his wife died. Scott paid for the funeral expenses and was reimbursement.

public record Applicant(
        String applicantFirstName,
        String applicantLastName,
        LocalDate applicantBirthDate,
        String applicantRelationshipToDeceased,
        String applicantMaritalStatus,
        Boolean applicantCitizenStatus,
        Boolean applicantPaidFuneralExpenses,
        Boolean applicantReimbursedFuneralExpenses,
        Boolean deceasedPaidSocialSecurityTaxes,
        LocalDate deceasedDateOfDeath,
        Boolean deceasedDiedInUs,
        Boolean deceasedDiedFromCovid,
        Boolean applicantCaringForChild,
        Boolean childDisabled,
        LocalDate childAge) {

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
                ", deceasedDiedInUs = " + deceasedDiedInUs +
                ", deceasedPaidSocialSecurityTaxes = " + deceasedPaidSocialSecurityTaxes +
                ", deceasedDiedFromCovid = " + deceasedDiedFromCovid +
                ", deceasedDateOfDeath = " + deceasedDateOfDeath +
                ", applicantCaringForChild = " + applicantCaringForChild +
                ", childDisabled = " + childDisabled +
                ", childAge = " + childAge +
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
