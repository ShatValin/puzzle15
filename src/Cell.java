public class Cell {
    private int value;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public void printCell(){
        if(this.value<10){
            if (this.value==0)
                System.out.print(" ");
            else
                System.out.print(this.value);
            System.out.print("  ");
        }
        else{
            System.out.print(this.value);
            System.out.print(" ");
        }


    }

}
