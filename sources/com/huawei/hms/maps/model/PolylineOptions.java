package com.huawei.hms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.ViewCompat;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolylineOptions implements Parcelable {
    public static final Parcelable.Creator<PolylineOptions> CREATOR = new Parcelable.Creator<PolylineOptions>() {
        /* renamed from: a */
        public PolylineOptions createFromParcel(Parcel parcel) {
            return new PolylineOptions(parcel);
        }

        /* renamed from: a */
        public PolylineOptions[] newArray(int i11) {
            return new PolylineOptions[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final List<LatLng> f49545a;

    /* renamed from: b  reason: collision with root package name */
    private int f49546b;

    /* renamed from: c  reason: collision with root package name */
    private float f49547c;

    /* renamed from: d  reason: collision with root package name */
    private float f49548d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f49549e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f49550f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f49551g;

    /* renamed from: h  reason: collision with root package name */
    private Cap f49552h;

    /* renamed from: i  reason: collision with root package name */
    private Cap f49553i;

    /* renamed from: j  reason: collision with root package name */
    private int f49554j;

    /* renamed from: k  reason: collision with root package name */
    private List<PatternItem> f49555k;

    /* renamed from: l  reason: collision with root package name */
    private List<Integer> f49556l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f49557m;

    public PolylineOptions() {
        this.f49545a = new ArrayList();
        this.f49547c = 10.0f;
        this.f49546b = ViewCompat.MEASURED_STATE_MASK;
        this.f49550f = false;
        this.f49551g = false;
        this.f49549e = true;
        this.f49552h = new ButtCap();
        this.f49553i = new ButtCap();
        this.f49554j = 0;
        this.f49555k = null;
        this.f49556l = new ArrayList();
        this.f49557m = false;
    }

    public PolylineOptions(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.f49545a = parcelReader.createTypedList(2, LatLng.CREATOR, new ArrayList());
        this.f49546b = parcelReader.readInt(3, 0);
        this.f49547c = parcelReader.readFloat(4, 10.0f);
        this.f49548d = parcelReader.readFloat(5, 0.0f);
        this.f49549e = parcelReader.readBoolean(6, true);
        this.f49550f = parcelReader.readBoolean(7, false);
        this.f49551g = parcelReader.readBoolean(8, false);
        Parcelable.Creator creator = Cap.CREATOR;
        this.f49552h = (Cap) parcelReader.readParcelable(9, creator, null);
        this.f49553i = (Cap) parcelReader.readParcelable(10, creator, null);
        this.f49554j = parcelReader.readInt(11, 0);
        this.f49555k = parcelReader.createTypedList(12, PatternItem.CREATOR, (ArrayList) null);
        this.f49556l = parcelReader.createIntegerList(13, new ArrayList());
        this.f49557m = parcelReader.readBoolean(14, false);
    }

    public PolylineOptions add(LatLng latLng) {
        this.f49545a.add(latLng);
        return this;
    }

    public PolylineOptions add(LatLng... latLngArr) {
        this.f49545a.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f49545a.add(add);
        }
        return this;
    }

    public PolylineOptions clickable(boolean z11) {
        this.f49550f = z11;
        return this;
    }

    public PolylineOptions color(int i11) {
        this.f49546b = i11;
        return this;
    }

    public PolylineOptions colorValues(List<Integer> list) {
        if (list != null && list.size() > 1) {
            ArrayList arrayList = new ArrayList(list);
            this.f49556l = arrayList;
            if (arrayList.size() >= 100000) {
                ArrayList arrayList2 = new ArrayList(this.f49556l);
                this.f49556l.clear();
                this.f49556l.addAll(arrayList2.subList(0, 99999));
            }
        }
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolylineOptions endCap(Cap cap) {
        this.f49553i = cap;
        return this;
    }

    public PolylineOptions geodesic(boolean z11) {
        this.f49551g = z11;
        return this;
    }

    public int getColor() {
        return this.f49546b;
    }

    public List<Integer> getColorValues() {
        return this.f49556l;
    }

    public Cap getEndCap() {
        return this.f49553i;
    }

    public int getJointType() {
        return this.f49554j;
    }

    public List<PatternItem> getPattern() {
        return this.f49555k;
    }

    public List<LatLng> getPoints() {
        return this.f49545a;
    }

    public Cap getStartCap() {
        return this.f49552h;
    }

    public float getWidth() {
        return this.f49547c;
    }

    public float getZIndex() {
        return this.f49548d;
    }

    public PolylineOptions gradient(boolean z11) {
        this.f49557m = z11;
        return this;
    }

    public boolean isClickable() {
        return this.f49550f;
    }

    public boolean isGeodesic() {
        return this.f49551g;
    }

    public boolean isGradient() {
        return this.f49557m;
    }

    public boolean isVisible() {
        return this.f49549e;
    }

    public PolylineOptions jointType(int i11) {
        this.f49554j = i11;
        return this;
    }

    public PolylineOptions pattern(List<PatternItem> list) {
        this.f49555k = list;
        return this;
    }

    public PolylineOptions startCap(Cap cap) {
        this.f49552h = cap;
        return this;
    }

    public PolylineOptions visible(boolean z11) {
        this.f49549e = z11;
        return this;
    }

    public PolylineOptions width(float f11) {
        this.f49547c = f11;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeTypedList(2, this.f49545a, false);
        parcelWrite.writeInt(3, this.f49546b);
        parcelWrite.writeFloat(4, this.f49547c);
        parcelWrite.writeFloat(5, this.f49548d);
        parcelWrite.writeBoolean(6, this.f49549e);
        parcelWrite.writeBoolean(7, this.f49550f);
        parcelWrite.writeBoolean(8, this.f49551g);
        parcelWrite.writeParcelable(9, this.f49552h, i11, false);
        parcelWrite.writeParcelable(10, this.f49553i, i11, false);
        parcelWrite.writeInt(11, this.f49554j);
        parcelWrite.writeTypedList(12, this.f49555k, false);
        parcelWrite.writeIntegerList(13, this.f49556l, false);
        parcelWrite.writeBoolean(14, this.f49557m);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }

    public PolylineOptions zIndex(float f11) {
        this.f49548d = f11;
        return this;
    }
}
