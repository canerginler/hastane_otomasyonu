
package deneme;

import java.sql.ResultSet;
import java.sql.Statement;

public interface IDataBase { //interface imizi yazdık
    
    public Statement baglantiAc() throws Exception; // yazılan methodların gövdesiz olarak yazılması
    
    public void baglantiKapat() throws Exception;
    
    public ResultSet TabloCek(String sorgu);
    
    public boolean Kaydet(String sorgu);
    
}
