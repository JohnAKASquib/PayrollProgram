// Benefit class
package Classes;

public class Benefit {

    String name;
    int amountResponsibleFor;
    int amountGiven;
    boolean includesFamily;

    public Benefit() {

    }

    public Benefit(String name, int amountResponsibleFor, int amountGiven, boolean includesFamily) {

        this.name = name;
        this.amountResponsibleFor = amountResponsibleFor;
        this.amountGiven = amountGiven;
        this.includesFamily = includesFamily;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmountResponsibleFor(int amountResponsibleFor) {
        this.amountResponsibleFor = amountResponsibleFor;
    }

    public void setAmountGiven(int amountGiven) {
        this.amountGiven = amountGiven;
    }

    public void setIncludesFamily(boolean includesFamily) {
        this.includesFamily = includesFamily;
    }

    public String getName() {
        return name;
    }

    public int getAmountResponsibleFor() {
        return amountResponsibleFor;
    }

    public int getAmountGiven() {
        return amountGiven;
    }

    public boolean getIncludesFamily() {
        return includesFamily;
    }

    public void print() {
        System.out.println(name);
        System.out.println(amountResponsibleFor);
        System.out.println(amountGiven);
        System.out.println(includesFamily);

    }

}
