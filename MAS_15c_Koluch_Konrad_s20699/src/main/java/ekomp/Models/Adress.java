package ekomp.Models;

public class Adress {
    private String streetName;
    private int houseNr;
    private Integer flatNr;
    private String cityName;
    private String zipCode;

    public Adress(String streetName, int houseNr, Integer flatNr, String cityName, String zipCode) {
        this.streetName = streetName;
        this.houseNr = houseNr;
        this.flatNr = flatNr;
        this.cityName = cityName;
        this.zipCode = zipCode;
    }
}
