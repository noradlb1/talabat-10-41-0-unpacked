package com.huawei.hms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.hms.common.Preconditions;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import com.huawei.hms.maps.model.internal.ITileProviderDelegate;

public class TileOverlayOptions implements Parcelable {
    public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new Parcelable.Creator<TileOverlayOptions>() {
        /* renamed from: a */
        public TileOverlayOptions createFromParcel(Parcel parcel) {
            return new TileOverlayOptions(parcel);
        }

        /* renamed from: a */
        public TileOverlayOptions[] newArray(int i11) {
            return new TileOverlayOptions[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f49561a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f49562b = true;

    /* renamed from: c  reason: collision with root package name */
    private float f49563c = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ITileProviderDelegate f49564d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f49565e = true;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TileProvider f49566f;

    public TileOverlayOptions() {
    }

    public TileOverlayOptions(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.f49561a = parcelReader.readFloat(2, 0.0f);
        this.f49562b = parcelReader.readBoolean(3, true);
        this.f49563c = parcelReader.readFloat(4, 0.0f);
        IBinder readIBinder = parcelReader.readIBinder(5, (IBinder) null);
        if (readIBinder != null) {
            this.f49564d = ITileProviderDelegate.Stub.asInterface(readIBinder);
        }
        this.f49565e = parcelReader.readBoolean(6, true);
        this.f49566f = new TileProvider() {
            public Tile getTile(int i11, int i12, int i13) {
                try {
                    return TileOverlayOptions.this.f49564d.getTile(i11, i12, i13);
                } catch (RemoteException unused) {
                    return null;
                }
            }
        };
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean z11) {
        this.f49565e = z11;
        return this;
    }

    public boolean getFadeIn() {
        return this.f49565e;
    }

    public TileProvider getTileProvider() {
        return this.f49566f;
    }

    public float getTransparency() {
        return this.f49563c;
    }

    public float getZIndex() {
        return this.f49561a;
    }

    public boolean isVisible() {
        return this.f49562b;
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.f49566f = tileProvider;
        this.f49564d = tileProvider == null ? null : new ITileProviderDelegate.Stub() {
            public Tile getTile(int i11, int i12, int i13) {
                return TileOverlayOptions.this.f49566f.getTile(i11, i12, i13);
            }
        };
        return this;
    }

    public TileOverlayOptions transparency(float f11) {
        boolean z11 = true;
        Preconditions.checkArgument(f11 >= 0.0f, "Transparency should be equal or more than 0.0");
        if (f11 > 1.0f) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Transparency should be equal or less than 1.0");
        this.f49563c = f11;
        return this;
    }

    public TileOverlayOptions visible(boolean z11) {
        this.f49562b = z11;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeFloat(2, this.f49561a);
        parcelWrite.writeBoolean(3, this.f49562b);
        parcelWrite.writeFloat(4, this.f49563c);
        parcelWrite.writeIBinder(5, this.f49564d.asBinder(), false);
        parcelWrite.writeBoolean(6, this.f49565e);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }

    public TileOverlayOptions zIndex(float f11) {
        this.f49561a = f11;
        return this;
    }
}
