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
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
public class Mahasiswa {
    ArrayList<String> listNim = new ArrayList<>();
    ArrayList<String> listNama = new ArrayList<>();
    ArrayList<Date> listTglLahir = new ArrayList<>();
    ArrayList<Integer> listGender = new ArrayList<>();
    Scanner inputData = new Scanner(System.in);
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
    void tambah(){
        String nim,nama;
        Integer gender;
        int tahun,hari,bulan;
        
        System.out.println("Masukkan Data:");
        inputData.nextLine();
        System.out.print("  NIM: ");
        nim = inputData.nextLine();
        System.out.print("  Nama: ");
        nama = inputData.nextLine();
        System.out.println("  Tanggal Lahir (dd/mm/yyyy): ");
        System.out.print("          > Tanggal : ");
        hari = inputData.nextInt();
        System.out.print("          > Bulan : ");
        bulan = inputData.nextInt();
        System.out.print("          > Tahun : ");
        tahun = inputData.nextInt();
        Date tanggal = new GregorianCalendar(tahun, bulan - 1, hari).getTime();
        System.out.print("  Gender (0:Perempuan 1:Laki-laki): ");
        gender = inputData.nextInt();
        listNim.add(nim);
        listNama.add(nama);
        listTglLahir.add(tanggal);
        listGender.add(gender);   
    }
    
    void hapus(){
        if(listNim.size() > 0){
            System.out.print("Masukkan NIM: ");
            String terhapus = inputData.nextLine();
            inputData.nextLine();
            int index = listNim.indexOf(terhapus);
            if(index < 0){
                System.out.println("");
                System.out.println("##########################");
                System.out.println("TIDAK ADA DATA YANG COCOK.");
                System.out.println("##########################");
                System.out.println("");
            }else{
                listNim.remove(index);
                listNama.remove(index);
                listTglLahir.remove(index);
                listGender.remove(index);
                System.out.println("");
                System.out.println("######################");
                System.out.println("DATA BERHASIL DIHAPUS.");
                System.out.println("######################");
                System.out.println("");
            }
        }else{
            System.out.println("");
            System.out.println("###############");
            System.out.println("TIDAK ADA DATA.");
            System.out.println("###############");
            System.out.println("");
        }  
    }
    
    void cari(){
        System.out.println(">Mencari Berdasarkan : ");
        System.out.println("    1. NIM");
        System.out.println("    2. Gender");
        System.out.print("  Masukkan Pilihan: ");
        int pilihan = inputData.nextInt();
        switch(pilihan){
            case 1:
                inputData.nextLine();
                System.out.print("  Masukkan NIM : ");
                String dicari = inputData.nextLine();
                for(String n: listNim){
                    if(listNim.contains(dicari)){
                        int index = listNim.indexOf(dicari);
                        String tanggalah = formatter.format(listTglLahir.get(index));
                        String jenisKel = (listGender.get(index) == 0) ? "Perempuan" : "Laki-laki";
                        System.out.println("");
                        System.out.println("#######################");
                        System.out.println("Mahasiswa NIM " + listNim.get(index));
                        System.out.println("#######################");
                        System.out.println("NIM : " + listNim.get(index));
                        System.out.println("Nama : " + listNama.get(index));
                        System.out.println("Tanggal Lahir : " + tanggalah);
                        System.out.println("Gender : " + jenisKel);
                        System.out.println("#######################");
                        System.out.println("");
                        break;
                    }
                }
                break;
            case 2:
                inputData.nextLine();
                System.out.print("  Masukkan Gender(0:Perempuan 1:Laki-laki):");
                int dicari2 = inputData.nextInt();
                for(int n = 0; n < listGender.size(); n++){
                    if(listGender.get(n) == dicari2){
                        String tanggalah = formatter.format(listTglLahir.get(n));
                        String jenisKel = (listGender.get(n) == 0) ? "Perempuan" : "Laki-laki";
                        System.out.println("");
                        System.out.println("#######################");
                        System.out.println("Data Berdasarkan Gender");
                        System.out.println("#######################");
                        System.out.println("NIM : " + this.listNim.get(n));
                        System.out.println("Nama : " + this.listNama.get(n));
                        System.out.println("Tanggal Lahir : " + tanggalah);
                        System.out.println("Gender : " + jenisKel);
                        System.out.println("#######################");
                        System.out.println("");
                    }
                };
                break;
            default:
                System.out.println("");
                System.out.println("####################################");
                System.out.println("Menu Yang Anda Pilih Tidak Tersedia.");
                System.out.println("####################################");
                System.out.println("");
        }
        
    }
    
    void tampilkan(){
        if(listNim.size() == 0){
            System.out.println("");
            System.out.println("###############");
            System.out.println("TIDAK ADA DATA.");
            System.out.println("###############");
            System.out.println("");
        }else{
            for(int n = 0; n < listNim.size(); n++){
                String tanggalah = formatter.format(listTglLahir.get(n));
                String jenisKel = (listGender.get(n) == 0) ? "Perempuan" : "Laki-laki";
                System.out.println("");
                System.out.println("####################");
                System.out.println("    Mahasiswa ke " + (n+1));
                System.out.println("####################");
                System.out.println("NIM : " + listNim.get(n));
                System.out.println("Nama : " + listNama.get(n));
                System.out.println("Tanggal : " + tanggalah);
                System.out.println("Gender : " + jenisKel);
                System.out.println("####################");
            }
            System.out.println("Jumlah Seluruh Mahasiswa : " + listNim.size() +"\n\n");
        }
        
    }
    
}
