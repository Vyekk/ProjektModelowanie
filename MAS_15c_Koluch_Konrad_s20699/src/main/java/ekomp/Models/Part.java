package ekomp.Models;

import java.util.ArrayList;
import java.util.List;

public class Part extends ObjectPlus {
    private String name;
    private float price;
    private String category;
    private List<PartComputer> partComputerList = new ArrayList<>();
    private List<Warranty> warranties = new ArrayList<>();
    private List<Warranty> allWarranties = new ArrayList<>();

    public Part(String name, float price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Geterry i setery


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Realizacja asocjacji

    public void removePartComputer(PartComputer partComputer) {
        if(partComputerList.contains(partComputer)) {
            partComputerList.remove(partComputer);
        }
    }

    public void addPartComputer(PartComputer partComputer) {
        if(!partComputerList.contains(partComputer)) {
            partComputerList.add(partComputer);
            partComputer.setPart(this);
        }
    }

    public void addWarranty(Warranty warranty) throws Exception {
        if (!warranties.contains(warranty)) {
            if (allWarranties.contains(warranty)) {
                throw new Exception("Gwarancja ta jest już połączona!");
            }
            warranties.add(warranty);
            allWarranties.add(warranty);
        }
    }
}
