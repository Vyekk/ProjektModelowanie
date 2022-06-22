package ekomp.Models;

import ekomp.Helpers.ObjectPlus;

public class Adress extends ObjectPlus {
    private String streetName;
    private int houseNr;
    private Integer flatNr;
    private String cityName;
    private String zipCode;
    private Client client;
    private Shop shop;

    // Przeciążone konstruktory
    public Adress(String streetName, int houseNr, String cityName, String zipCode) {
        this.streetName = streetName;
        this.houseNr = houseNr;
        this.cityName = cityName;
        this.zipCode = zipCode;
    }
    public Adress(String streetName, int houseNr, Integer flatNr, String cityName, String zipCode) {
        this.streetName = streetName;
        this.houseNr = houseNr;
        this.flatNr = flatNr;
        this.cityName = cityName;
        this.zipCode = zipCode;
    }

    // Getery i Setery

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(int houseNr) {
        this.houseNr = houseNr;
    }

    public Integer getFlatNr() throws Exception {
        if(this.flatNr == null)
            throw new Exception("Pod tym adresem nie ma numeru mieszkania!");
        return flatNr;
    }

    public void setFlatNr(Integer flatNr) {
        this.flatNr = flatNr;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Client getClient() throws Exception {
        if (this.client == null)
            throw new Exception("Wybrany adres nie jest powiązany z żadnym klientem");
        return client;
    }

    public void setClient(Client client) {
        if (this.client == null) {
            this.client = client;
            this.client.setAdress(this);
        }
    }

    public Shop getShop() throws Exception {
        if (this.shop == null)
            throw new Exception("Wybrany adres nie jest powiązany z żadnym sklepem");
        return shop;
    }

    public void setShop(Shop shop) {
        if (this.shop == null) {
            this.shop = shop;
            this.shop.setAdress(this);
        }
    }
}
