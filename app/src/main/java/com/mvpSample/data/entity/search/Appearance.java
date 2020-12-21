
package com.mvpSample.data.entity.search;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Appearance
 */
public class Appearance implements Parcelable {
    public static final Creator<Appearance> CREATOR = new Creator<Appearance>() {
        @Override
        public Appearance createFromParcel(final Parcel in) {
            return new Appearance(in);
        }

        @Override
        public Appearance[] newArray(final int size) {
            return new Appearance[size];
        }
    };

    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("race")
    @Expose
    private String race;
    @SerializedName("height")
    @Expose
    private ArrayList<String> height = null;
    @SerializedName("weight")
    @Expose
    private ArrayList<String> weight = null;
    @SerializedName("eye-color")
    @Expose
    private String eyeColor;
    @SerializedName("hair-color")
    @Expose
    private String hairColor;

    protected Appearance(Parcel in) {
        gender = in.readString();
        race = in.readString();
        height = in.createStringArrayList();
        weight = in.createStringArrayList();
        eyeColor = in.readString();
        hairColor = in.readString();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public ArrayList<String> getHeight() {
        return height;
    }

    public void setHeight(ArrayList<String> height) {
        this.height = height;
    }

    public ArrayList<String> getWeight() {
        return weight;
    }

    public void setWeight(ArrayList<String> weight) {
        this.weight = weight;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel parcel, final int i) {
        parcel.writeString(gender);
        parcel.writeString(race);
        parcel.writeStringList(height);
        parcel.writeStringList(weight);
        parcel.writeString(eyeColor);
        parcel.writeString(hairColor);
    }
}
