package org.mfusco;

import java.time.LocalDate;

// Scott Queen born in the US, turned 42 yesterday. His wife died while visiting her mother in Texas from COVID during the first year of the pandemic. He is now caring for a special needs child who was born three years before his wife died. Scott paid for the funeral expenses, but never filed for reimbursement.


public record Applicant(String applicantFirstName, String applicantLastName, LocalDate applicantBirthDate, String applicantRelationshipToDeceased, String applicantMaritalStatus, Boolean applicantCitizenStatus, Boolean applicantPaidFuneralExpenses, LocalDate deceasedDateOfDeath, Boolean deceasedDiedInUs, Boolean deceasedDiedFromCovid, Boolean applicantCaringForChild, Boolean childDisabled, LocalDate childAge)  {

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
                ", deceasedDiedInUs = " + deceasedDiedInUs +
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

    public int getDeath() {
        return deceasedDateOfDeath.until(LocalDate.now()).getYears();
    }
}
