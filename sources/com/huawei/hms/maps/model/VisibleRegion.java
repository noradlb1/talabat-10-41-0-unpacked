package com.huawei.hms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class VisibleRegion implements Parcelable {
    public static final Parcelable.Creator<VisibleRegion> CREATOR = new Parcelable.Creator<VisibleRegion>() {
        /* renamed from: a */
        public VisibleRegion createFromParcel(Parcel parcel) {
            return new VisibleRegion(parcel);
        }

        /* renamed from: a */
        public VisibleRegion[] newArray(int i11) {
            return new VisibleRegion[i11];
        }
    };
    public final LatLng farLeft;
    public final LatLng farRight;
    public final LatLngBounds latLngBounds;
    public final LatLng nearLeft;
    public final LatLng nearRight;

    public VisibleRegion(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        Parcelable.Creator creator = LatLng.CREATOR;
        this.farLeft = (LatLng) parcelReader.readParcelable(2, creator, null);
        this.farRight = (LatLng) parcelReader.readParcelable(3, creator, null);
        this.latLngBounds = (LatLngBounds) parcelReader.readParcelable(4, LatLngBounds.CREATOR, null);
        this.nearLeft = (LatLng) parcelReader.readParcelable(5, creator, null);
        this.nearRight = (LatLng) parcelReader.readParcelable(6, creator, null);
    }

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds2) {
        this.nearLeft = latLng;
        this.farLeft = latLng3;
        this.nearRight = latLng2;
        this.farRight = latLng4;
        this.latLngBounds = latLngBounds2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return (this.nearLeft.equals(visibleRegion.nearLeft) && this.nearRight.equals(visibleRegion.nearRight)) && (this.farRight.equals(visibleRegion.farRight) && this.latLngBounds.equals(visibleRegion.latLngBounds));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds});
    }

    public String toString() {
        return "VisibleRegion{farLeft=" + this.farLeft + ", farRight=" + this.farRight + ", latLngBounds=" + this.latLngBounds + ", nearLeft=" + this.nearLeft + ", nearRight=" + this.nearRight + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeParcelable(2, this.farLeft, i11, false);
        parcelWrite.writeParcelable(3, this.farRight, i11, false);
        parcelWrite.writeParcelable(4, this.latLngBounds, i11, false);
        parcelWrite.writeParcelable(5, this.nearLeft, i11, false);
        parcelWrite.writeParcelable(6, this.nearRight, i11, false);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }
}
