package ekomp.Models;

public class PartComputer {
    private int quantity;
    private Part part;
    private Computer computer;

    public PartComputer(int quantity, Part part, Computer computer) {
        this.quantity = quantity;
        this.part = part;
        this.computer = computer;
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
            if (part != null) {
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
            if (computer != null) {
                this.computer.removePartComputer(this);
            }
            this.computer = computer;
            this.computer.addPartComputer(this);
        }
    }
}
