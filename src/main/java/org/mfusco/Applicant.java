package org.mfusco;

import java.time.LocalDate;

// Scott Queen born in the US and turned 42 yesterday. His wife died from COVID during the first year of the pandemic. He is caring for a child who was born a three years before his wife died. Scott paid for the funeral expenses, but never filed for reimbursement

public record Applicant(String applicantFirstName, String applicantLastName, LocalDate applicantBirthDate, String applicantRelationshipToDeceased, String applicantMaritalStatus, Boolean applicantCitizenStatus, Boolean applicantCaringForChild, Boolean childDisabled, LocalDate childAge, Boolean paidFuneralExpenses, LocalDate deceasedDateOfDeath)  {

    @Override
    public String toString() {
        return "Applicant {" +
                " applicantFirstName = \"" + applicantFirstName + "\"" +
                ", applicantLastName = \"" + applicantLastName + "\"" +
                ", applicantBirthDate = " + applicantBirthDate +
                ", applicantRelationshipToDeceased = " + applicantRelationshipToDeceased +
                ", applicantMaritalStatus = " + applicantMaritalStatus +
                ", applicantCitizenStatus = " + applicantCitizenStatus +
                ", applicantCaringForChild = " + applicantCaringForChild +
                ", childDisabled = " + childDisabled +
                ", childAge = " + childAge +
                ", applicantPaidFuneralExpenses = " + paidFuneralExpenses +
                ", deceasedDateOfDeath = " + deceasedDateOfDeath +
                " }";
    }

    public String getFullName() {
        return applicantFirstName + " " + applicantLastName;
    }

    public int getAge() {
        return applicantBirthDate.until(LocalDate.now()).getYears();
    }

    public int getDeath() {
        return deceasedDateOfDeath.until(LocalDate.now()).getYears();
    }
}
