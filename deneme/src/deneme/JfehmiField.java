package deneme;



/*program AhmetField methodunu kullandığımızda eğer tuşlara basılı tutmazsak çalışıyor
 *basılı tuttuğumda çalışmıyor bende o yüzden alternatif method yazmaya çalıştım
 *alternatifkeyrelased diye, o metotda istediğim gibi çalışmadı iç içe try catch olduğu zaman nedense ikincisine
 *girmiyor.
 */

import javax.swing.JTextField;
import java.lang.NumberFormatException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class JfehmiField extends JTextField{ // kendi yazdığımız JfehmiField kalıtım yoluyla Jtextfieldıntüm özelliklerini ALDIK
   
    public JfehmiField() { // class ilk oluşturulduğunda constructor methodu çalışır
        initComponents(); // tanımcadığımız componentler burda clasa dahil edilir
    }
    
    public void initComponents(){
        
        this.addKeyListener(new java.awt.event.KeyAdapter() { // klavyeden işlem yapmak için bu metod override edildi

            public void keyReleased(java.awt.event.KeyEvent evt){
                FehmiFieldKeyReleased(evt); // TC nin kontrolleri burada yapılıyor
                //alternatifKeyRelased(evt);
            }
        
        });
                
    }
    
    public void FehmiFieldKeyReleased(java.awt.event.KeyEvent evt){
        
        String tc = this.getText();
        
        try{
            if(!tc.isEmpty()) // girdi kısmı boş olduğu zaman hata vermesin diye bu kontrol yapıldı
                try {
                    isAllNumbers(tc); // önce girdilerin int olup olmadığı kontrol edildi 
            } catch (FehmiException ex) {
                Logger.getLogger(JfehmiField.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch(NumberFormatException ex){ // eğer hata fırlatırsa...
            tc = removeLastChar(tc); // girdiler string olduğu zamanı siler
            this.setText(tc); // text kısmı güncellendi
        }
        onMaxsize(tc); // 11 haneden büyük olup olmadığı kontrol edildi
        
    }
    
    
    public String removeLastChar(String s) { 
       String c =  s.substring(0,s.length() - 1); // son karakteri silme algoritması
       return c;
    }

    public void isAllNumbers(String tc) throws FehmiException{ // eğer String long veri tipine dönüşmezse stringin içinde harf var demektir
        long temp = Long.valueOf(tc); // harf varsa hata fırlatır
    }
    public void isAllNumbers(char tc) throws FehmiException{ // override method yaptık ve string aynı zamanda char diziside alabilecek
        long temp = Long.valueOf(tc);
    }
    
    public void onMaxsize(String tc){ 
        if (tc.length() > 11){
            tc = removeLastChar(tc); // 11 haneden büyük olduğu an son karakter silindi.
            this.setText(tc); // kontrol sonrası text kısmı güncellendi
        }
    }

}
