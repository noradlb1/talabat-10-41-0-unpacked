package datamodels;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class Cuisine implements Parcelable, Serializable {
    public static final Parcelable.Creator<Cuisine> CREATOR = new Parcelable.Creator<Cuisine>() {
        public Cuisine createFromParcel(Parcel parcel) {
            return new Cuisine(parcel);
        }

        public Cuisine[] newArray(int i11) {
            return new Cuisine[i11];
        }
    };
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    public int f13848id;
    private Boolean isPrimary = Boolean.FALSE;
    @SerializedName(alternate = {"na"}, value = "name")

    /* renamed from: name  reason: collision with root package name */
    public String f13849name;
    @SerializedName(alternate = {"sl"}, value = "slug")
    public String slugName;

    public Cuisine() {
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cuisine cuisine = (Cuisine) obj;
        if (this.f13848id != cuisine.f13848id) {
            return false;
        }
        String str = this.f13849name;
        if (str == null ? cuisine.f13849name != null : !str.equals(cuisine.f13849name)) {
            return false;
        }
        if (!Objects.equals(this.isPrimary, cuisine.isPrimary)) {
            return false;
        }
        String str2 = this.slugName;
        String str3 = cuisine.slugName;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int getId() {
        return this.f13848id;
    }

    public String getName() {
        return this.f13849name;
    }

    public Boolean getPrimary() {
        return this.isPrimary;
    }

    public String getSlugName() {
        return this.slugName;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13 = this.f13848id * 31;
        String str = this.f13849name;
        int i14 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i15 = (i13 + i11) * 31;
        String str2 = this.slugName;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i16 = (i15 + i12) * 31;
        Boolean bool = this.isPrimary;
        if (bool != null) {
            i14 = bool.hashCode();
        }
        return i16 + i14;
    }

    public void setId(int i11) {
        this.f13848id = i11;
    }

    public void setName(String str) {
        this.f13849name = str;
    }

    public void setPrimary(Boolean bool) {
        this.isPrimary = bool;
    }

    public void setSlugName(String str) {
        this.slugName = str;
    }

    public String toString() {
        return "Cuisine{id=" + this.f13848id + ", name='" + this.f13849name + '\'' + ", slugName='" + this.slugName + '\'' + ", isPrimary ='" + this.isPrimary + '\'' + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.f13848id);
        parcel.writeString(this.f13849name);
        parcel.writeString(this.slugName);
        parcel.writeByte(this.isPrimary.booleanValue() ? (byte) 1 : 0);
    }

    public Cuisine(Parcel parcel) {
        this.f13848id = parcel.readInt();
        this.f13849name = parcel.readString();
        this.slugName = parcel.readString();
        this.isPrimary = Boolean.valueOf(parcel.readByte() != 0);
    }
}
