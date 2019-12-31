

/*program AhmetField methodunu kullandığımızda eğer tuşlara basılı tutmazsak çalışıyor
 *basılı tuttuğumda çalışmıyor bende o yüzden alternatif method yazmaya çalıştım
 *alternatifkeyrelased diye, o metotda istediğim gibi çalışmadı iç içe try catch olduğu zaman nedense ikincisine
 *girmiyor.
 */


import javax.swing.JTextField;
import java.lang.NumberFormatException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class JfehmiField extends JTextField{
   
    public JfehmiField() {
        initComponents();
    }
    
    public void initComponents(){
        
        this.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent evt){
                AhmetFieldKeyReleased(evt);
                //alternatifKeyRelased(evt);
            }
        
        });
                
    }
    
    public void AhmetFieldKeyReleased(java.awt.event.KeyEvent evt){
        
        String tc = this.getText();
        
        try{
            if(!tc.isEmpty()) // girdi kısmı boş olduğu zaman hata vermesin diye bu kontrol yapıldı
                isAllNumbers(tc); // önce girdilerin int olup olmadığı kontrol edildi 
        }
        catch(NumberFormatException ex){
            tc = removeLastChar(tc); // girdiler string olduğu zaman sildi
            this.setText(tc); // text kısmı güncellendi
        }
        onMaxsize(tc); // 11 haneden büyük olup olmadığı kontrol edildi
        
    }
    
    public void alternatifKeyRelased(java.awt.event.KeyEvent evt){ 
        int count = -1; // girilen değerin indexini tutmak için 
        String tc = this.getText();
        
            try{
                isAllNumbers(tc); // eğer girilen sayı int değilse hata fırlatır
            }catch(NumberFormatException e){ 
                //System.out.println("fist exception"); // catch bloğuna girip girmediğini kontrol amacı ile yazıldı
                for(char ch : tc.toCharArray()){ // girilen değerin baştan itibaren tüm değerleri kontrol edilir
                    count++; // index sayma işlemi
                    try {
                        isAllNumbers(ch); // girilen her değerin sayı oldup olmadığı kontrol edilir
                    } catch (FehmiException ex) {
                        Logger.getLogger(JfehmiField.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        onMaxsize(tc); // aynı try cath işlemlerini burda da yapmam lazımdı aslında ama yukarıdaki zaten çalışmıyor 
        // o yüzden yazmadım
    }
    
    public String removeLastChar(String s) {
       String c =  s.substring(0,s.length() - 1);
       return c;
    }

    public void isAllNumbers(String tc) throws NumberFormatException{
        long temp = Long.valueOf(tc);
    }
    public void isAllNumbers(char tc) throws FehmiException{
        long temp = Long.valueOf(tc);
    }
    
    public void onMaxsize(String tc){
        if (tc.length() > 11){
            tc = removeLastChar(tc);
            this.setText(tc); // kontrol sonrası text kısmı güncellendi
        }
    }

}
