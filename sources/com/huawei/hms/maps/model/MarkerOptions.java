package com.huawei.hms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import com.huawei.hms.feature.dynamic.IObjectWrapper;

public class MarkerOptions implements Parcelable {
    public static final Parcelable.Creator<MarkerOptions> CREATOR = new Parcelable.Creator<MarkerOptions>() {
        /* renamed from: a */
        public MarkerOptions createFromParcel(Parcel parcel) {
            return new MarkerOptions(parcel);
        }

        /* renamed from: a */
        public MarkerOptions[] newArray(int i11) {
            return new MarkerOptions[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private LatLng f49508a;

    /* renamed from: b  reason: collision with root package name */
    private String f49509b;

    /* renamed from: c  reason: collision with root package name */
    private String f49510c;

    /* renamed from: d  reason: collision with root package name */
    private BitmapDescriptor f49511d;

    /* renamed from: e  reason: collision with root package name */
    private float f49512e = 0.5f;

    /* renamed from: f  reason: collision with root package name */
    private float f49513f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f49514g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f49515h = true;

    /* renamed from: i  reason: collision with root package name */
    private boolean f49516i = false;

    /* renamed from: j  reason: collision with root package name */
    private float f49517j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    private float f49518k = 0.5f;

    /* renamed from: l  reason: collision with root package name */
    private float f49519l = 0.0f;

    /* renamed from: m  reason: collision with root package name */
    private float f49520m = 1.0f;

    /* renamed from: n  reason: collision with root package name */
    private float f49521n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f49522o = false;

    /* renamed from: p  reason: collision with root package name */
    private float f49523p = 0.5f;

    /* renamed from: q  reason: collision with root package name */
    private float f49524q = 1.0f;

    /* renamed from: r  reason: collision with root package name */
    private boolean f49525r = true;

    /* renamed from: s  reason: collision with root package name */
    private boolean f49526s = true;

    public MarkerOptions() {
    }

    public MarkerOptions(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.f49508a = (LatLng) parcelReader.readParcelable(2, LatLng.CREATOR, null);
        this.f49509b = parcelReader.createString(3, (String) null);
        this.f49510c = parcelReader.createString(4, (String) null);
        this.f49512e = parcelReader.readFloat(5, 0.0f);
        this.f49513f = parcelReader.readFloat(6, 0.0f);
        this.f49514g = parcelReader.readBoolean(7, true);
        this.f49515h = parcelReader.readBoolean(8, true);
        this.f49516i = parcelReader.readBoolean(9, true);
        this.f49517j = parcelReader.readFloat(10, 0.0f);
        this.f49518k = parcelReader.readFloat(11, 0.0f);
        this.f49519l = parcelReader.readFloat(12, 0.0f);
        this.f49520m = parcelReader.readFloat(13, 0.0f);
        this.f49521n = parcelReader.readFloat(14, 0.0f);
        this.f49522o = parcelReader.readBoolean(15, false);
        IBinder readIBinder = parcelReader.readIBinder(16, (IBinder) null);
        if (readIBinder != null) {
            this.f49511d = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(readIBinder));
        }
        this.f49523p = parcelReader.readFloat(17, 0.0f);
        this.f49524q = parcelReader.readFloat(18, 0.0f);
        this.f49525r = parcelReader.readBoolean(19, false);
        this.f49526s = parcelReader.readBoolean(20, true);
    }

    public MarkerOptions alpha(float f11) {
        this.f49520m = f11;
        return this;
    }

    @Deprecated
    public MarkerOptions anchor(float f11, float f12) {
        this.f49525r = false;
        this.f49512e = f11;
        this.f49513f = f12;
        return this;
    }

    public MarkerOptions anchorMarker(float f11, float f12) {
        this.f49525r = true;
        this.f49523p = f11;
        this.f49524q = f12;
        return this;
    }

    public MarkerOptions clickable(boolean z11) {
        this.f49526s = z11;
        return this;
    }

    public MarkerOptions clusterable(boolean z11) {
        this.f49522o = z11;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean z11) {
        this.f49514g = z11;
        return this;
    }

    public MarkerOptions flat(boolean z11) {
        this.f49516i = z11;
        return this;
    }

    public float getAlpha() {
        return this.f49520m;
    }

    @Deprecated
    public float getAnchorU() {
        return this.f49512e;
    }

    @Deprecated
    public float getAnchorV() {
        return this.f49513f;
    }

    public BitmapDescriptor getIcon() {
        return this.f49511d;
    }

    public float getInfoWindowAnchorU() {
        return this.f49518k;
    }

    public float getInfoWindowAnchorV() {
        return this.f49519l;
    }

    public float getMarkerAnchorU() {
        return this.f49523p;
    }

    public float getMarkerAnchorV() {
        return this.f49524q;
    }

    public final LatLng getPosition() {
        return this.f49508a;
    }

    public float getRotation() {
        return this.f49517j;
    }

    public String getSnippet() {
        return this.f49510c;
    }

    public String getTitle() {
        return this.f49509b;
    }

    public float getZIndex() {
        return this.f49521n;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.f49511d = bitmapDescriptor;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float f11, float f12) {
        this.f49518k = f11;
        this.f49519l = f12;
        return this;
    }

    public boolean isClickable() {
        return this.f49526s;
    }

    public boolean isDraggable() {
        return this.f49514g;
    }

    public boolean isFlat() {
        return this.f49516i;
    }

    public boolean isNewAnchorSetting() {
        return this.f49525r;
    }

    public boolean isVisible() {
        return this.f49515h;
    }

    public boolean ismClusterable() {
        return this.f49522o;
    }

    public MarkerOptions position(LatLng latLng) {
        this.f49508a = latLng;
        return this;
    }

    public MarkerOptions rotation(float f11) {
        this.f49517j = f11;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.f49510c = str;
        return this;
    }

    public MarkerOptions title(String str) {
        this.f49509b = str;
        return this;
    }

    public MarkerOptions visible(boolean z11) {
        this.f49515h = z11;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeParcelable(2, this.f49508a, i11, false);
        parcelWrite.writeString(3, this.f49509b, false);
        parcelWrite.writeString(4, this.f49510c, false);
        parcelWrite.writeFloat(5, this.f49512e);
        parcelWrite.writeFloat(6, this.f49513f);
        parcelWrite.writeBoolean(7, this.f49514g);
        parcelWrite.writeBoolean(8, this.f49515h);
        parcelWrite.writeBoolean(9, this.f49516i);
        parcelWrite.writeFloat(10, this.f49517j);
        parcelWrite.writeFloat(11, this.f49518k);
        parcelWrite.writeFloat(12, this.f49519l);
        parcelWrite.writeFloat(13, this.f49520m);
        parcelWrite.writeFloat(14, this.f49521n);
        parcelWrite.writeBoolean(15, this.f49522o);
        BitmapDescriptor bitmapDescriptor = this.f49511d;
        parcelWrite.writeIBinder(16, bitmapDescriptor != null ? bitmapDescriptor.getObject().asBinder() : null, true);
        parcelWrite.writeFloat(17, this.f49523p);
        parcelWrite.writeFloat(18, this.f49524q);
        parcelWrite.writeBoolean(19, this.f49525r);
        parcelWrite.writeBoolean(20, this.f49526s);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }

    public MarkerOptions zIndex(float f11) {
        this.f49521n = f11;
        return this;
    }
}
