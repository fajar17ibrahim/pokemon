package com.example.pokemon;

import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataAnak {
    private String code;
    private String name;
    private String parent;

    public DataAnak(String code, String name, String parent) {
        this.code = code;
        this.name = name;
        this.parent = parent;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getParent() {
        return parent;
    }

    public static void main(String[] args) throws IOException {
        List<DataAnak> dataAnaks = new ArrayList<>();
        DataAnak dataAnak0 = new DataAnak("A001", "Wati", "");
        DataAnak dataAnak1 = new DataAnak("A002", "Wira", "A001");
        DataAnak dataAnak2 = new DataAnak("A003", "Andi", "A002");
        DataAnak dataAnak3 = new DataAnak("A004", "Bagus", "A002");
        DataAnak dataAnak4 = new DataAnak("A005", "Siti", "A001");
        DataAnak dataAnak5 = new DataAnak("A006", "Hasan", "A005");
        DataAnak dataAnak6 = new DataAnak("A007", "Abdul", "A006");

        dataAnaks.add(dataAnak0);
        dataAnaks.add(dataAnak1);
        dataAnaks.add(dataAnak2);
        dataAnaks.add(dataAnak3);
        dataAnaks.add(dataAnak4);
        dataAnaks.add(dataAnak5);
        dataAnaks.add(dataAnak6);

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Masukkan Parent ID : ");
        String parent = keyboard.nextLine();

        List<DataAnak> parentArrTemp = new ArrayList<>();
        for (DataAnak dataAnak : dataAnaks) {
            if (dataAnak.getCode().equals(parent)) {
                parentArrTemp.add(dataAnak);
                break;
            }
        }

        for (DataAnak dataAnakTemp : dataAnaks) {
            List<DataAnak> dataAnakList = new ArrayList<>();
            dataAnakList.addAll(parentArrTemp);
            for (DataAnak parentData : dataAnakList) {
                if (parentData.getCode().equals(dataAnakTemp.getParent())) {
                    parentArrTemp.add(dataAnakTemp);
                    System.out.println(dataAnakTemp.getName());
                }
            }
        }
    }
}
