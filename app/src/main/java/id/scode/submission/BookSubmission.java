package id.scode.submission;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dani on 12/24/2018.
 * Yogi Arif Widodo
 * Getter and Setter , Parcelable ,
 */

public class BookSubmission implements Parcelable {
    private String judulBuku;
    private String newsOlder;
    private String spoiler;
    private String hrgBuku;
    private String detailBuku;

    public BookSubmission(String judulBuku, String newsOlder, String spoiler, String hrgBuku, String detailBuku) {
        this.judulBuku = judulBuku;
        this.newsOlder = newsOlder;
        this.spoiler = spoiler;
        this.hrgBuku = hrgBuku;
        this.detailBuku = detailBuku;
    }

    public String getDetailBuku() {
        return detailBuku;
    }

    public void setDetailBuku(String detailBuku) {
        this.detailBuku = detailBuku;
    }

    public String getHrgBuku() {
        return hrgBuku;
    }

    public void setHrgBuku(String hrgBuku) {
        this.hrgBuku = hrgBuku;
    }


    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getNewsOlder() {
        return newsOlder;
    }

    public void setNewsOlder(String newsOlder) {
        this.newsOlder = newsOlder;
    }

    public String getSpoiler() {
        return spoiler;
    }

    public void setSpoiler(String spoiler) {
        this.spoiler = spoiler;
    }
// parcelable

    public BookSubmission() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judulBuku);
        dest.writeString(this.newsOlder);
        dest.writeString(this.spoiler);
        dest.writeString(this.hrgBuku);
        dest.writeString(this.detailBuku);
    }

    protected BookSubmission(Parcel in) {
        this.judulBuku = in.readString();
        this.newsOlder = in.readString();
        this.spoiler = in.readString();
        this.hrgBuku = in.readString();
        this.detailBuku = in.readString();
    }

    public static final Creator<BookSubmission> CREATOR = new Creator<BookSubmission>() {
        @Override
        public BookSubmission createFromParcel(Parcel source) {
            return new BookSubmission(source);
        }

        @Override
        public BookSubmission[] newArray(int size) {
            return new BookSubmission[size];
        }
    };
}
