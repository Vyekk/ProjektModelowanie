package ekomp.Models;

import ekomp.Helpers.ObjectPlus;

public class PartComputer extends ObjectPlus {
    private int quantity;
    private Part part;
    private Computer computer;

    public PartComputer(int quantity, Part part, Computer computer) {
        this.quantity = quantity;
        setPart(part);
        setComputer(computer);
    }

    // Getery i setery

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        if(this.part != part) {
            if (this.part != null) {
                this.part.removePartComputer(this);
            }
            this.part = part;
            this.part.addPartComputer(this);
        }
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        if(this.computer != computer) {
            if (this.computer != null) {
                this.computer.removePartComputer(this);
            }
            this.computer = computer;
            this.computer.addPartComputer(this);
        }
    }
}
