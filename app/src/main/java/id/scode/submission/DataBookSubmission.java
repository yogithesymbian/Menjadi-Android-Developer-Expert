package id.scode.submission;

import java.util.ArrayList;

/**
 * Created by Dani on 12/24/2018.
 * Yogi Arif Widodo
 * Data Book Without Mysql
 */

public class DataBookSubmission
{
    private static String[][] data = new String[][]{
            {"News", "mainan anak muslim buku pintar layar sentuh", "https://ecs7.tokopedia.net/img/cache/700/product-1/2018/7/17/13264308/13264308_98bc2065-7059-4e2f-81ac-d06d07416b34_1000_561.jpg","Rp 82.000","Buku ini terdiri dari (10 halaman / halaman bagian kanan saja yang bisa berbunyi bila ditekan).\n" +
                    "\n" +
                    "Fungsi e-book :\n" +
                    "1. Belajar mengenal Huruf Hijaiyah dan Alfabeth di sertai Bacaan dalam Arab dan Inggris...."}
            ,
            {"News", "Cerita Anak Cerita Islami Terpopuler Ibadah Anak Muslim", "https://ecs7.tokopedia.net/img/cache/700/product-1/2018/6/1/2858621/2858621_b6c531bc-5c65-4d88-802d-822aaededda5_780_1040.jpg","Rp 55.000","Ibadah Anak Muslim\n" +
                    "Adik adik, kalian suka membaca dan mendengarkan cerita kan? Adik adik pasti suka dengan buku ini. Selain ceritanya menarik, adik adik juga bisa belajar tentang ibadah.\n" +
                    "Ada juga bonus poster shalatnya lho, biar adik adik makin pintar mengerjakan shalat."}
            ,
            {"News", "anak muslim kisah 25 nabi & rasul", "https://ecs7.tokopedia.net/img/cache/700/product-1/2016/6/7/19813996/19813996_b04ad1d1-7cbc-4124-8a62-3a1182141370.jpg","Rp 15.000","no865\n" +
                    "Buku anak muslim kisah 25 nabi dan rasul\n" +
                    "Harga per pc\n" +
                    "80 halaman berwarna\n" +
                    "#jual #jualan #online #tokoonline #onlineshop  #bukumuslim #pendidikan #agama #buku #suvenir"}
            ,
            {"News", "Bantal Kain Softbook Bayi Doa Anak Muslim", "https://ecs7.tokopedia.net/img/cache/700/product-1/2018/2/4/52860533/52860533_e0260ac9-2650-4441-af29-6275bfddc927_1280_720.jpg","Rp 22.000","Ukuran tertutup: 10 x 16 cm (mungil)\n" +
                    "Jumlah halaman: 6 halaman isi + 2 halaman sampul\n" +
                    "Buku yang berisi doa-doa untuk anak-anak:\n" +
                    "saat masuk rumah, saat keluar rumah, setelah mimpi baik, setelah mimpi buruk, saat menjenguk orang sakit, untuk kedua orangtua."}
            ,
            {"News", "Cerita Anak Muslim Kids Story Cerita Tentang Kebiasaan Baik", "https://ecs7.tokopedia.net/img/cache/700/product-1/2018/4/8/0/0_d6da609f-4b38-403c-b297-4dc1a4238cce_774_878.jpg","Rp 56.000","#CeritaTentang Kebiasaan Baik\n" +
                    "        #Janganlah seseorang di antaramu \n" +
                    "        makan \n" +
                    "        dengan tangan kiri. Dan janganlah minum pula dengan tangan kirinya. Maka sesungguhnya setan makan dan minum dengan tangan kirinya. (HR. Muslim)"}
            ,
            {"News", "Anak Muslim Wahai Adik-Adik Cintailah Orang Tuamu", "https://ecs7.tokopedia.net/img/cache/700/product-1/2017/11/29/5626643/5626643_60b7cd8c-8be5-4c1b-a90d-77260a87d293_1280_960","Rp 11.000","Barangsiapa yang berbuat baik \n" +
                    "kepada kedua orang tuanya, akan menjadilah ia \n" +
                    "sebagai orang \n" +
                    "yang paling baik \n" +
                    "dan \n" +
                    "akan dipanjangkan umurnya. (HR.Bukhari)"}
            ,
            {"Yesterday", "Halal Haram For Kids - Hukum Islam Anak - Kado Buku Hadiah Anak Muslim", "https://ecs7.tokopedia.net/img/cache/700/product-1/2018/4/24/28234129/28234129_42faa206-0a4e-4a32-8d98-d0945e69f5f9_1080_1080.jpg","Rp 30.000","Kenapa ya Allah melarang makan daging babi ? \n" +
                    "        Daging Anjing juga nggak boleh ?\n" +
                    "Trus kenapa bangkai dan darah juga haram?\n" +
                    "Trus bagaimana cara kita mengetahui \n" +
                    "makanan \n" +
                    "halal dan haram?"}
    };


    public static ArrayList<BookSubmission> getListData()
    {
        BookSubmission bookSubmission;

        ArrayList<BookSubmission> list = new ArrayList<>();

        for (String[] arrayDataBook : data)
        {
            bookSubmission = new BookSubmission();
            bookSubmission.setNewsOlder(arrayDataBook[0]);
            bookSubmission.setJudulBuku(arrayDataBook[1]);
            bookSubmission.setSpoiler(arrayDataBook[2]);
            bookSubmission.setHrgBuku(arrayDataBook[3]);
            bookSubmission.setDetailBuku(arrayDataBook[4]);

            list.add(bookSubmission);
        }
        return list;
    }
}
