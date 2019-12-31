// iç içe try catch lerde ikincisine girmesi için debellenirken yazdığım bir şey çok gereksiz aslında
public class FehmiException extends Exception{

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.println("sayı 140 karakteri geçti artık yazamazsınız...\n"
                + "Fehmi Can Ergin");
    }
    
}
