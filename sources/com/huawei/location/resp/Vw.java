package com.huawei.location.resp;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class Vw implements Parcelable {
    public static final Parcelable.Creator<Vw> CREATOR = new yn();

    /* renamed from: yn  reason: collision with root package name */
    private List<yn> f50210yn;

    public static class yn implements Parcelable.Creator<Vw> {
        public Object createFromParcel(Parcel parcel) {
            return new Vw(parcel);
        }

        public Object[] newArray(int i11) {
            return new Vw[i11];
        }
    }

    public Vw() {
        this.f50210yn = new ArrayList();
    }

    public Vw(Parcel parcel) {
        this.f50210yn = parcel.createTypedArrayList(yn.CREATOR);
    }

    public final List<Location> Vw() {
        ArrayList arrayList = new ArrayList();
        for (yn yn2 : this.f50210yn) {
            Location yn3 = yn2.yn();
            if (yn3 != null) {
                arrayList.add(yn3);
            }
        }
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Vw) {
            return Objects.equals(this.f50210yn, ((Vw) obj).f50210yn);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f50210yn});
    }

    public String toString() {
        return "LocationResult{locations=" + this.f50210yn + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeTypedList(this.f50210yn);
    }

    public final List<yn> yn() {
        return this.f50210yn;
    }

    public boolean yn(Location location) {
        if (location == null) {
            return false;
        }
        yn ynVar = new yn(location);
        if (this.f50210yn == null) {
            this.f50210yn = new ArrayList();
        }
        return this.f50210yn.add(ynVar);
    }
}
