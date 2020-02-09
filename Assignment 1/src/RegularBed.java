
public class RegularBed implements IBed {

    private boolean bedDown;
    private int bedAngle;

    public RegularBed(boolean bedDown, int bedAngle) {
        this.bedDown = bedDown;
        this.bedAngle = bedAngle;

    }

    public RegularBed() {
        setBedAngle(0);
    }


    /* COULD BE DANGEROUS. KEPT IN COMMENTS IN CASE WE NEED THEM LATER ON.
    public void setBedDownTrue() {
        bedDown = true;
    }

    public void setBedDownFalse() {
        bedDown = false;
    }

     */

    private void incrementAngle(int amount) {
        if(amount > 0 && (bedAngle + amount <= 70)) {
            bedAngle += amount;
        }
    }

    private void decrementAngle(int amount) {
        if(amount > 0 && (bedAngle - amount >= 0)) {
            bedAngle -= amount;
        }
    }

    public void raiseBed(int amount) {
        incrementAngle(amount);
    }

    public void lowerBed(int amount) {
        decrementAngle(amount);
    }

    //GETTRS AND SETTERS FOR THE BED

    public int getCurrentBedAngle() {
        return bedAngle;
    }

    public void setBedAngle(int amount) {
        if(amount > 0 && amount <= 70) {
            bedAngle = amount;
        } else {
            System.out.println("Please enter a valid amount for the angle of the bed");
        }
    }

}
