package models;

import io.codearte.jfairy.producer.person.Person;

public class SavingsRequest {
    private String selectedFund;
    private String investment;
    private String years;
    private Person email;

    public SavingsRequest(String textOfSelect, String investment, String years, Person email ){
        this.selectedFund = textOfSelect;
        this.investment = investment;
        this.years = years;
        this.email= email;
    }


    public String getTextOfSelect(){
        return selectedFund;
    }
    public String getInvestment(){
        return investment;
    }
    public String getYears(){
        return years;
    }
    public Person getEmail(){ return email;}


}
