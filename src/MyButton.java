import javax.swing.*;
import java.util.ArrayList;

public class MyButton extends JButton {
    private int index;
    private ArrayList arr=null;

    public MyButton(int index, ArrayList arr){
        this.index=index;
        this.arr=arr;
    }
    public int getIndex() {
        return index;
    }
    public ArrayList getArr() {
        return arr;
    }
    public void setArr(ArrayList arr){
        this.arr=arr;
    }
}
