package deneme;

public class FehmiException extends Exception{ // kendi yazdığımız fehmi exception , exception klasından miras aldı

    @Override
    public void printStackTrace() { // fehmi exceptionu aldığımız zamanki hata mesajını kendimiz yazıyoruz
        super.printStackTrace(); // print stack trace methodunu override edip değiştirdik
        System.out.println("fehmi exception aldınız karakter sayısı 11 den büyük olamaz aynı zamanda harf de olamaz...\n" // kendi hata mesajımız
                + "Fehmi Can Ergin");
    }
    
}
