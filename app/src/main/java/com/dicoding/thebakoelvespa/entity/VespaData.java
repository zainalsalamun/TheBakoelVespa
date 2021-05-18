package com.dicoding.thebakoelvespa.entity;


import java.util.ArrayList;

public class VespaData {
    public static String[][] data = new String[][]{
            {
                    "Vespa, BTS 150,I-GET ABS, 2017",
                    "https://www.vespa.com/dam/jcr:886e6ea5-ddb3-4859-88d4-55d56948b875/TopBanner.jpg","19 Juta", "Jakarta Selatan"
            },
            {
                    "Vespa, 150, I-GET ABS, 2018",
                    "https://bd.gaadicdn.com/processedimages/piaggio/piaggio-vespa-125/source/v_piaggio-vespa-125-std1530859339.jpg","19 Juta", "Jakarta Selatan"
            },
            {
                    "VESPA, GTS 150 , I-GET ABS, 2019",
                    "https://vespa.co.id/assets/img/vespa-gts-150/banner-1.jpg", "44 Juta","JAKARTA"
            },
            {
                    "Honda, Jazz, A 1.5 M/T, 2015",
                    "https://vespa.co.id/assets/img/vespa-lx/banner-1.jpg","Rp. 207.500.000", "Jakarta Barat"
            },
            {
                    "Mitsubishi, Outlander, Sport PX, 2015",
                    "https://vespa.co.id/assets/img/vespa-s/banner-1.jpg","Call", "Tangerang"
            }
    };
    public static ArrayList<VespaModel> getListData(){
        VespaModel vespa = null;
        ArrayList<VespaModel> list = new ArrayList<>();
        for (int i = 0; i<data.length; i++){
            vespa = new VespaModel();
            vespa.setTitle(data[i][0]);
            vespa.setImage(data[i][1]);
            vespa.setHarga(data[i][2]);
            vespa.setLokasi(data[i][3]);

            list.add(vespa);
        }

    return list;
    }

}
