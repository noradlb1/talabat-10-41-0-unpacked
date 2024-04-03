package com.huawei.hms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import com.huawei.hms.feature.dynamic.IObjectWrapper;

public class GroundOverlayOptions implements Parcelable {
    public static final Parcelable.Creator<GroundOverlayOptions> CREATOR = new Parcelable.Creator<GroundOverlayOptions>() {
        public GroundOverlayOptions createFromParcel(Parcel parcel) {
            return new GroundOverlayOptions(parcel);
        }

        public GroundOverlayOptions[] newArray(int i11) {
            return new GroundOverlayOptions[i11];
        }
    };
    public static final float NO_DIMENSION = -1.0f;

    /* renamed from: a  reason: collision with root package name */
    private float f49464a = 0.5f;

    /* renamed from: b  reason: collision with root package name */
    private float f49465b = 0.5f;

    /* renamed from: c  reason: collision with root package name */
    private float f49466c;

    /* renamed from: d  reason: collision with root package name */
    private LatLngBounds f49467d;

    /* renamed from: e  reason: collision with root package name */
    private float f49468e;

    /* renamed from: f  reason: collision with root package name */
    private BitmapDescriptor f49469f;

    /* renamed from: g  reason: collision with root package name */
    private LatLng f49470g;

    /* renamed from: h  reason: collision with root package name */
    private float f49471h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private float f49472i;

    /* renamed from: j  reason: collision with root package name */
    private float f49473j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f49474k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f49475l = true;

    public GroundOverlayOptions() {
    }

    public GroundOverlayOptions(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.f49464a = parcelReader.readFloat(2, 0.0f);
        this.f49465b = parcelReader.readFloat(3, 0.0f);
        this.f49466c = parcelReader.readFloat(4, 0.0f);
        this.f49467d = (LatLngBounds) parcelReader.readParcelable(5, LatLngBounds.CREATOR, null);
        this.f49468e = parcelReader.readFloat(6, 0.0f);
        IBinder readIBinder = parcelReader.readIBinder(7, (IBinder) null);
        if (readIBinder != null) {
            this.f49469f = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(readIBinder));
        }
        this.f49470g = (LatLng) parcelReader.readParcelable(8, LatLng.CREATOR, null);
        this.f49471h = parcelReader.readFloat(9, 0.0f);
        this.f49472i = parcelReader.readFloat(10, 0.0f);
        this.f49473j = parcelReader.readFloat(11, 0.0f);
        this.f49474k = parcelReader.readBoolean(12, true);
        this.f49475l = parcelReader.readBoolean(13, true);
    }

    private boolean a(float f11) {
        return f11 < 0.0f;
    }

    public GroundOverlayOptions anchor(float f11, float f12) {
        this.f49464a = f11;
        this.f49465b = f12;
        return this;
    }

    public GroundOverlayOptions bearing(float f11) {
        this.f49466c = f11;
        return this;
    }

    public GroundOverlayOptions clickable(boolean z11) {
        this.f49474k = z11;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.f49464a;
    }

    public float getAnchorV() {
        return this.f49465b;
    }

    public float getBearing() {
        return this.f49466c;
    }

    public LatLngBounds getBounds() {
        return this.f49467d;
    }

    public float getHeight() {
        return this.f49468e;
    }

    public BitmapDescriptor getImage() {
        return this.f49469f;
    }

    public LatLng getLocation() {
        return this.f49470g;
    }

    public float getTransparency() {
        return this.f49471h;
    }

    public float getWidth() {
        return this.f49472i;
    }

    public float getZIndex() {
        return this.f49473j;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f49469f = bitmapDescriptor;
            return this;
        }
        throw new NullPointerException("image descriptor can not be null.");
    }

    public boolean isClickable() {
        return this.f49474k;
    }

    public boolean isSetPosition() {
        return (this.f49467d == null && this.f49470g == null) ? false : true;
    }

    public boolean isVisible() {
        return this.f49475l;
    }

    public GroundOverlayOptions position(LatLng latLng, float f11) {
        if (this.f49470g != null || this.f49467d != null) {
            throw new IllegalStateException("GroundOverlay location is illegal,position has been set positionFromBounds function,this value can not reassign.");
        } else if (latLng == null) {
            throw new IllegalArgumentException("Location must be specified");
        } else if (!a(f11)) {
            this.f49470g = latLng;
            this.f49472i = f11;
            this.f49468e = -1.0f;
            return this;
        } else {
            throw new IllegalArgumentException("GroundOverlay width value is illegal ,this value must be non-negative");
        }
    }

    public GroundOverlayOptions position(LatLng latLng, float f11, float f12) {
        if (this.f49470g != null || this.f49467d != null) {
            throw new IllegalStateException("GroundOverlay location is illegal,position has been set by positionFromBounds function,this value can not reassign.");
        } else if (a(f11)) {
            throw new IllegalArgumentException("GroundOverlay width value is illegal ,this value must be non-negative");
        } else if (a(f12)) {
            throw new IllegalArgumentException("GroundOverlay height value is illegal,this value must be non-negative");
        } else if (latLng != null) {
            this.f49470g = latLng;
            this.f49472i = f11;
            this.f49468e = f12;
            return this;
        } else {
            throw new IllegalArgumentException("Location must be specified");
        }
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        if (this.f49470g == null) {
            this.f49467d = latLngBounds;
            return this;
        }
        throw new IllegalStateException("Set position from LatLngBounds failed,position has been set by position function,this value can not reassign.");
    }

    public GroundOverlayOptions transparency(float f11) {
        if (f11 > 1.0f) {
            throw new IllegalArgumentException("The transparency value  is illegal,this value must be less than 1");
        } else if (f11 >= 0.0f) {
            this.f49471h = f11;
            return this;
        } else {
            throw new IllegalArgumentException("The transparency value  is illegal,this value must be greater than 0");
        }
    }

    public GroundOverlayOptions visible(boolean z11) {
        this.f49475l = z11;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeFloat(2, this.f49464a);
        parcelWrite.writeFloat(3, this.f49465b);
        parcelWrite.writeFloat(4, this.f49466c);
        parcelWrite.writeParcelable(5, this.f49467d, i11, false);
        parcelWrite.writeFloat(6, this.f49468e);
        parcelWrite.writeIBinder(7, this.f49469f.getObject().asBinder(), false);
        parcelWrite.writeParcelable(8, this.f49470g, i11, false);
        parcelWrite.writeFloat(9, this.f49471h);
        parcelWrite.writeFloat(10, this.f49472i);
        parcelWrite.writeFloat(11, this.f49473j);
        parcelWrite.writeBoolean(12, this.f49474k);
        parcelWrite.writeBoolean(13, this.f49475l);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }

    public GroundOverlayOptions zIndex(float f11) {
        this.f49473j = f11;
        return this;
    }
}
