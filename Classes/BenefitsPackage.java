// Benefits Package class
package Classes;

public class BenefitsPackage {
    public static int numBenefits = 15;
    public static Benefit[] benefits = new Benefit[numBenefits];

    public BenefitsPackage() {

    }

    public BenefitsPackage(int numBenefits) {
        this.numBenefits = numBenefits;
    }

    public void setNumBenefits(int numBenefits) {
        this.numBenefits = numBenefits;
    }

    public void setBenefits(int index, Benefit benefit) {
        this.benefits[index] = benefit;
    }

    public int getNumBenefits() {
        return numBenefits;
    }

    public Benefit getBenefits(int index) {
        return benefits[index];
    }

    public static void display() {
        for (int index = 0; index < benefits.length; index++)
            (benefits[index]).print();
    }

}
