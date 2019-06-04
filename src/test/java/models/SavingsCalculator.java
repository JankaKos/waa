package models;

public class SavingsCalculator {
    private String textOfSelect;
    private String investment;
    private String years;
    private String email;

    public SavingsCalculator (String textOfSelect, String investment,String years, String email ){
        this.textOfSelect = textOfSelect;
        this.investment = investment;
        this.years = years;
        this.email= email;
    }


    public String getTextOfSelect(){
        return textOfSelect;
    }
    public String getInvestment(){
        return investment;
    }
    public String getYears(){
        return years;
    }

    public  String getEmail(){ return email;}


}
