
package readjasonfile;


public class currency {
    
    private String currName;
    private double value;

    public String getCurrName() {
        return currName;
    }

    public void setCurrName(String currName) {
        this.currName = currName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public currency(String currName, double value) {
        this.currName = currName;
        this.value = value;
    }
    
    
}
