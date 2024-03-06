package uruntakipprogrami;
import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author CASPER
 */
public class UrunTakipProgrami {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    DatabaseFunctions dbf = new DatabaseFunctions(); // Tek bir DatabaseFunctions örneği oluştur
    try {
        while(true) {
            System.out.print("1 - Veri Gir\n2 - Veri Sil\n3 - Ürün Ara\n4 - Ürünleri Göster\nq - Çıkış\n\n: ");
            String data = scan.nextLine();
            if (data.equals("1")) {
                System.out.print("Ürün İsmi Gir");
                String name = scan.nextLine();
                System.out.println("İçerik Gir");
                String content = scan.nextLine();
                dbf.addUrun(name, content);
                continue;
            }
            else if (data.equals("q")) {
                break;
            }
            else if (data.equals("2")){
                System.out.print("Ürün id:");
                int id = scan.nextInt();
                dbf.deleteUrun(id);
                continue;
            }
            else if(data.equals("3")){
                System.out.print("Ürün adı ya da içeriği girin: ");
                String searchOption = scan.nextLine();
                dbf.searchUrun(searchOption,searchOption);
            }
            else if (data.equals("4")){
                dbf.getUrun();
            }
            else {
                System.out.println("\u001B[31mGeçersiz seçenek, lütfen tekrar deneyin.");
            }
        }
    } finally {
        scan.close(); // Scanner nesnesini kapat
    }
}

    
}
