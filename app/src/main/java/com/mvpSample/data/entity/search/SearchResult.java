
package com.mvpSample.data.entity.search;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * SearchResult
 */
public class SearchResult implements Parcelable {
    public static final Creator<SearchResult> CREATOR = new Creator<SearchResult>() {
        @Override
        public SearchResult createFromParcel(Parcel in) {
            return new SearchResult(in);
        }

        @Override
        public SearchResult[] newArray(int size) {
            return new SearchResult[size];
        }
    };
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("appearance")
    @Expose
    private Appearance appearance;
    @SerializedName("connections")
    @Expose
    private Connections connections;
    @SerializedName("image")
    @Expose
    private Image image;

    protected SearchResult(final Parcel in) {
        id = in.readString();
        name = in.readString();
        appearance = in.readParcelable(Appearance.class.getClassLoader());
        connections = in.readParcelable(Connections.class.getClassLoader());
        image = in.readParcelable(Image.class.getClassLoader());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public Connections getConnections() {
        return connections;
    }

    public void setConnections(Connections connections) {
        this.connections = connections;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel parcel, final int flags) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeParcelable(appearance, flags);
        parcel.writeParcelable(connections, flags);
        parcel.writeParcelable(image, flags);
    }
}
