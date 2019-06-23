package id.scode.exercise04ReyclerView;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dani on 12/23/2018.
 * Yogi Arif Widodo
 */

public class Presiden implements Parcelable {
    private String name, remarks, photos;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getPhotos()
    {
        return photos;
    }

    public void setPhotos(String photos)
    {
        this.photos = photos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.remarks);
        dest.writeString(this.photos);
    }

    public Presiden() {
    }

    protected Presiden(Parcel in) {
        this.name = in.readString();
        this.remarks = in.readString();
        this.photos = in.readString();
    }

    public static final Parcelable.Creator<Presiden> CREATOR = new Parcelable.Creator<Presiden>() {
        @Override
        public Presiden createFromParcel(Parcel source) {
            return new Presiden(source);
        }

        @Override
        public Presiden[] newArray(int size) {
            return new Presiden[size];
        }
    };
}
