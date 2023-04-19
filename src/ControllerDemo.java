import java.io.FileReader;

public class ControllerDemo {
    
    public static void main(String[] args) {
        
        try {
            
            FileReader dosya = new FileReader("Numbers.txt");
            NumberController numberControl = new NumberController(dosya);
        }
            
        catch (Exception e) {
            System.out.println("Dosya bulunamadi veya dosya hatasi! ");
        }
    }
}
