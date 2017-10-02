package fr.wcs.blablawild;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/**
 * Created by apprenti on 9/19/17.
 */

public class SearchRequestModel implements Parcelable {

    private String depart;
    private String destination;
    private Date dateTrajet;

    public SearchRequestModel(String depart, String destination, Date dateTrajet) {
        this.depart = depart;
        this.destination = destination;
        this.dateTrajet = dateTrajet;
    }

    public String getDepart() {
        return depart;
    }
    public void setDepart(String depart) {
        this.depart = depart;
    }
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    public Date getDateTrajet() {
        return dateTrajet;
    }
    public void setDateTrajet(Date dateTrajet) {
        this.dateTrajet = dateTrajet;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(depart);
        dest.writeString(destination);
        dest.writeLong(dateTrajet.getTime());
    }

    public static final Parcelable.Creator<SearchRequestModel> CREATOR = new Parcelable.Creator<SearchRequestModel>()
    {
        public SearchRequestModel createFromParcel(Parcel source)
        {
            return new SearchRequestModel(source);
        }

        public SearchRequestModel[] newArray(int size)
        {
            return new SearchRequestModel[size];
        }
    };

    public SearchRequestModel(Parcel in) {
        this.depart = in.readString();
        this.destination = in.readString();
        dateTrajet = new Date(in.readLong());
    }
}
