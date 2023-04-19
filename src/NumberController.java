import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class NumberController {
    
    private int[] numbers;
    
    public int[] getNumbers() {
        return this.numbers;
    }
    
    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
    
    public NumberController(FileReader file) throws IOException {
        
        Scanner scanner1 = new Scanner(System.in);
        BufferedReader br = new BufferedReader(file);
        String number = br.readLine();
            
        setNumbers(new int[20]);
            
        for (int i = 0; i < 20; i++) {
            
            numbers[i] = Integer.parseInt(number);
            number = br.readLine();
        }
            
        int[] sortedNumbers = bubbleSort(getNumbers());
        
        System.out.print("Sayi 1 giriniz: ");
        int sayi1 = scanner1.nextInt();
            
        boolean binaryResult = searchBinary(sortedNumbers, sayi1);
          
        if (binaryResult)
            System.out.println("Sayi 1 binary search ile bulundu! ");
            
        else
            System.out.println("Sayi 1 binary search ile bulunamadi! ");
        
        System.out.print("\nSayi 2 giriniz: ");
        int sayi2 = scanner1.nextInt();
            
        boolean sequentialResult = searchSequential(sortedNumbers, sayi2);
            
        if (sequentialResult)
            System.out.println("Sayi 2 sequential search ile bulundu! \n");
            
        else
            System.out.println("Sayi 2 sequential search ile bulunamadi! \n");
    }
    
    public int[] bubbleSort(int[] numbers) {
        
        int size = numbers.length;
        
        for (int i = 0; i < size - 1; i++) {
            
            for (int j = 0; j < size - i - 1; j++) {
                
                if (numbers[j] > numbers[j + 1]) {
                    
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        
        return numbers;
    }
    
    public boolean searchBinary(int[] numbers, int wantedNumber) {
        
        int ilk = 0;
        int son = numbers.length - 1;

        while (ilk <= son) {
            
            int orta = (ilk + son) / 2;

            if (numbers[orta] == wantedNumber)
                return true;
            
            else if (numbers[orta] < wantedNumber)
                ilk = orta + 1;
            
            else
                son = orta - 1;
        }

        return false;
    }
    
    public boolean searchSequential(int[] numbers, int wantedNumber) {
        
        for (int i = 0; i < numbers.length; i++) {
            
            if (numbers[i] == wantedNumber) {
                return true;
            }
        }
        
        return false;
    }
}
