/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamahasiswa;

/**
 *
 * @author Rogasper
 */
import java.util.Scanner;
public class DataMahasiswa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean menu = true;
        int pilihMenu;
        Mahasiswa mhs = new Mahasiswa();
        
        
        while(menu){
            System.out.println("");
            System.out.println("##################");
            System.out.println("Data Mahasiswa UNS");
            System.out.println("##################");
            System.out.println("Menu Program:");
            System.out.println("1. Tambah Data");
            System.out.println("2. Hapus Data");
            System.out.println("3. Cari Data");
            System.out.println("4. Tampilkan Data");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");
            pilihMenu = input.nextInt();
            switch(pilihMenu){
                case 1:
                    char ulang = 'y';
                    while(ulang == 'y'){
                        mhs.tambah();
                        System.out.print("  Ingin menambahkan lagi? (y/n): ");
                        ulang = input.next().charAt(0);
                    }
                    break;
                case 2:
                    mhs.hapus();
                    break;
                case 3:
                    mhs.cari();
                    break;
                case 4:
                    mhs.tampilkan();
                    break;
                case 0:
                    menu = false;
                    break;
                default:
                    System.out.println("===============================");
                    System.out.println("MENU YANG ANDA PILIH TIDAK ADA.");
                    System.out.println("===============================");
            }
                    
        }
    }
    
}
