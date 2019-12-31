 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deneme;

import java.sql.*;

/**
 *
 * @author Adnan
 */
public class database implements IDataBase{
private Connection conn = null; //Bağlantı nesnemiz
private String url = "jdbc:mysql://localhost:3306/";//veritabanının adresi ve portu
private String dbName = "hastane"; //veritabanının ismi
private String properties= "?useUnicode=true&characterEncoding=utf8"; //Türkçe karakter problemi yaşamamak için
private String driver = "com.mysql.jdbc.Driver";//MySQL-Java bağlantısını sağlayan JDBC sürücüsü
private String userName = "root"; //veritabanı için kullanıcı adı
private String password = ""; //kullanıcı şifresi
private ResultSet res; // sorgulardan dönecek kayıtlar (sonuç kümesi) bu nesne içerisinde tutulacak


@Override
public Statement baglantiAc() throws Exception {
    Class.forName(driver).newInstance();
    conn = DriverManager.getConnection(url + dbName + properties, userName, password);//bağlantı açılıyor
    return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
    //return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

 
}
public void baglantiKapat() throws Exception {
    conn.close();
}

public ResultSet TabloCek(String sorgu) //VERİTABANINDAN SORGUYLA TABLO ÇEKİP ResultSet olarak döndürüyoruz.
{
        try {
    Statement st; // SQL komutumuz için
            st = baglantiAc(); //veritabanına bağlanılıyor
            res = st.executeQuery(sorgu); //tablodaki kayıtlar getiriliyor
            return res;
        } catch (Exception ex) {
            //Eğer bir hata oluşursa
            //örneğin veritabanına bağlanılamazsa
            //aşağıdaki kod çalışacak
            System.out.println("Bağlantı Başarısız");
            return null;
        }
}
public boolean Kaydet(String sorgu) //PROGRAMDAKİ TÜM EKLEME SİLME GÜNCELLEME İŞLEMLERİ BU METODDA YAPILIYOR.
{                                   //İŞLEM BAŞARILIYSA TRUE DEĞİLSE FALSE DEĞER DÖNDÜRÜYOR.
        try {
            baglantiAc(); //veritabanına bağlanılıyor
            System.out.println("Bağlandı");
            String sorguuu=sorgu;
            System.out.println(sorgu);
           // PreparedStatement ps = sorguuu;
            //conn.prepareStatement(sorguuu); //tablodaki kayıtlar getiriliyor
            PreparedStatement ps = conn.prepareStatement(sorguuu);
            ps.execute();
            System.out.println(sorguuu);
            return true;
        } catch (Exception ex) {
            //Eğer bir hata oluşursa
            //örneğin veritabanına bağlanılamazsa
            //aşağıdaki kod çalışacak
            System.out.println("Bağlantı Başarısız");
            return false;
        }
}
 
}

