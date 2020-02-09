public class CarStack {
    public Transportable[] cars;
    public int size;
    public int top;

    public CarStack(Transportable[] cars, int size, int top) {
       this.cars = cars;
       this.size = size;
       this.top  = top;

    }

    public CarStack() {
        createArray();
        setSize(8);
        setTop(0);
    }

    public void push(Transportable t) {
        if (top > size) {
            //error get fucked.
        }
        else {
            top++;
            cars[top] = t;
        }
    }

    public Transportable pop() {
        top--;
        Transportable t = cars[top];
        return t;
    }

    public Transportable[] createArray() {
        return new Transportable[8];
    }

    public void setSize(int s) {
        size = s;
    }

    public void setTop(int t) {
        top = t;
    }
}
