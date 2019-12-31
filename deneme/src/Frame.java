// yaptığımız FehmiFieldı denemek için bir frame
import javax.swing.JFrame;

public class Frame extends JFrame {

    public Frame() {
        
        JfehmiTextArea fehmi = new JfehmiTextArea();
        fehmi.setSize(400,400);
        this.add(fehmi);
        
    }
    
    public static void main(String[] args) {
        
        Frame jf = new Frame();
        jf.setSize(400,400);
        jf.setVisible(true);
        
        
    }
    
}
