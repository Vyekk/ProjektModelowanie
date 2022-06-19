package ekomp.Models;

import ekomp.Helpers.ObjectPlus;

public class Warranty extends ObjectPlus {
    private int daysNumber;
    private String description;
    private String conditions;
    private Part part;

    private Warranty(Part part,int daysNumber, String description, String conditions) {
        this.part = part;
        this.daysNumber = daysNumber;
        this.description = description;
        this.conditions = conditions;
    }

    public static Warranty createWarranty(Part part, int daysNumber, String description, String conditions) throws Exception {
        if(part == null) {
            throw new Exception("Podana część nie istnieje!");
        }
        Warranty warranty = new Warranty(part,daysNumber,description,conditions);
        part.addWarranty(warranty);
        return warranty;
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
