package models;

public class SavingsCalculator {
    private Integer numberOfSelect;
    private String investment;
    private String years;
    private String email;

    public SavingsCalculator (Integer numberOfSelect, String investment,String years, String email ){
        this.numberOfSelect = numberOfSelect;
        this.investment = investment;
        this.years = years;
        this.email= email;
    }


    public Integer getNumberOfSelect(){
        return numberOfSelect;
    }
    public String getInvestment(){
        return investment;
    }
    public String getYears(){
        return years;
    }

    public  String getEmail(){ return email;}


}
