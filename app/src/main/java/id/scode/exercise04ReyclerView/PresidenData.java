package id.scode.exercise04ReyclerView;

import java.util.ArrayList;

/**
 * Created by Dani on 12/23/2018.
 * Yogi Arif Widodo
 */

public class PresidenData
{
    public static String[][] data = new String[][]{
            {"Soekarno", "Presiden Pertama RI", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Presiden_Sukarno.jpg/418px-Presiden_Sukarno.jpg"}
            ,
            {"Soeharto", "Presiden Kedua RI", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/President_Suharto%2C_1993.jpg/468px-President_Suharto%2C_1993.jpg"}
            ,
            {"Bacharuddin Jusuf Habibie", "Presiden Ketiga RI", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Bacharuddin_Jusuf_Habibie_official_portrait.jpg/520px-Bacharuddin_Jusuf_Habibie_official_portrait.jpg"}
            ,
            {"Abdurrahman Wahid", "Presiden Keempat RI", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/President_Abdurrahman_Wahid_-_Indonesia.jpg/486px-President_Abdurrahman_Wahid_-_Indonesia.jpg"}
            ,
            {"Megawati Soekarnoputri", "Presiden Kelima RI", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/President_Megawati_Sukarnoputri_-_Indonesia.jpg/540px-President_Megawati_Sukarnoputri_-_Indonesia.jpg"}
            ,
            {"Susilo Bambang Yudhoyono", "Presiden Keenam RI", "https://upload.wikimedia.org/wikipedia/commons/5/58/Presiden_Susilo_Bambang_Yudhoyono.png"}
            ,
            {"CINA", "Presiden Keetujuh RI", ""}
            ,
            {"Yogi Arif Widodo", "Presiden Kedelapan RI", ""}
    };


    public static ArrayList<Presiden> getListData()
    {
        Presiden presiden = null;
        ArrayList<Presiden> list = new ArrayList<Presiden>();
        for (String[] aData : data)
        {
            presiden = new Presiden();
            presiden.setName(aData[0]);
            presiden.setRemarks(aData[1]);
            presiden.setPhotos(aData[2]);

            list.add(presiden);
        }
        return list;
    }
}
