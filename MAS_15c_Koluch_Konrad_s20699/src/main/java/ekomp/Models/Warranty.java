package ekomp.Models;

public class Warranty {
    private int daysNumber;
    private String description;
    private String conditions;

    public Warranty(int daysNumber, String description, String conditions) {
        this.daysNumber = daysNumber;
        this.description = description;
        this.conditions = conditions;
    }

    //Getery i setery


    public int getDaysNumber() {
        return daysNumber;
    }

    public void setDaysNumber(int daysNumber) {
        this.daysNumber = daysNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
}
