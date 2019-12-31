
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;


public class JfehmiTextArea extends JTextArea{
    public int uzunluk = 0;

    public JfehmiTextArea() {
        initComponents();
    }
    
    public void initComponents(){
        
        this.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent evt){
                FehmiFieldRelased(evt);
                //alternatifKeyRelased(evt);
            }
        
        });
                
    }
    
    public void onMaxsize(String yazi){
        if (yazi.length() > 140){
            yazi = removeLastChar(yazi);
            this.setText(yazi); // kontrol sonrası text kısmı güncellendi
        }
    }
    
    public String removeLastChar(String s) {
       String c =  s.substring(0,s.length() - 1);
       return c;
    }
    
    public void FehmiFieldRelased(java.awt.event.KeyEvent evt){
        
        String yazi = this.getText();
        uzunluk = yazi.length();
        if(!yazi.isEmpty()){ // girdi kısmı boş olduğu zaman hata vermesin diye bu kontrol yapıldı
            try {
                cout(yazi);
            } catch (FehmiException ex) {
                ex.printStackTrace();
            }
        }
        
        onMaxsize(yazi);
        
    }
    
    public void cout(String yazi) throws FehmiException{
        
        int uzunluk = yazi.length();
        
        if(uzunluk >= 140){
            throw new FehmiException();
        }
        
    }
    
    
    
    
    
}
