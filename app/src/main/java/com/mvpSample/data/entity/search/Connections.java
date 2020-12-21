
package com.mvpSample.data.entity.search;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Connections
 */
public class Connections implements Parcelable {
    public static final Creator<Connections> CREATOR = new Creator<Connections>() {
        @Override
        public Connections createFromParcel(Parcel in) {
            return new Connections(in);
        }

        @Override
        public Connections[] newArray(int size) {
            return new Connections[size];
        }
    };

    @SerializedName("group-affiliation")
    @Expose
    private String groupAffiliation;
    @SerializedName("relatives")
    @Expose
    private String relatives;

    protected Connections(final Parcel in) {
        groupAffiliation = in.readString();
        relatives = in.readString();
    }


    public String getGroupAffiliation() {
        return groupAffiliation;
    }

    public void setGroupAffiliation(String groupAffiliation) {
        this.groupAffiliation = groupAffiliation;
    }

    public String getRelatives() {
        return relatives;
    }

    public void setRelatives(String relatives) {
        this.relatives = relatives;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel parcel, final int i) {
        parcel.writeString(groupAffiliation);
        parcel.writeString(relatives);
    }
}
