package com.huawei.hms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.Preconditions;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import com.huawei.hms.common.util.Objects;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import java.util.Locale;

public class Cap implements Parcelable {
    public static final Parcelable.Creator<Cap> CREATOR = new Parcelable.Creator<Cap>() {
        /* renamed from: a */
        public Cap createFromParcel(Parcel parcel) {
            return Cap.a(parcel);
        }

        /* renamed from: a */
        public Cap[] newArray(int i11) {
            return new Cap[i11];
        }
    };
    public static final int TYPE_BUTT_CAP = 0;
    public static final int TYPE_CUSTOM_CAP = 3;
    public static final int TYPE_ROUND_CAP = 2;
    public static final int TYPE_SQUARE_CAP = 1;

    /* renamed from: a  reason: collision with root package name */
    private int f49448a;

    /* renamed from: b  reason: collision with root package name */
    private BitmapDescriptor f49449b;

    /* renamed from: c  reason: collision with root package name */
    private float f49450c;

    public Cap(int i11) {
        this(i11, (IBinder) null, Float.valueOf(0.0f));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Cap(int i11, IBinder iBinder, Float f11) {
        this(i11, iBinder == null ? null : new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder)), f11);
    }

    private Cap(int i11, BitmapDescriptor bitmapDescriptor, Float f11) {
        Preconditions.checkArgument(i11 != 3 || (bitmapDescriptor != null && (f11 != null && (f11.floatValue() > 0.0f ? 1 : (f11.floatValue() == 0.0f ? 0 : -1)) > 0)), String.format(Locale.ENGLISH, "Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", new Object[]{Integer.valueOf(i11), bitmapDescriptor, f11}));
        this.f49448a = i11;
        this.f49449b = bitmapDescriptor;
        if (f11 != null) {
            this.f49450c = f11.floatValue();
        }
    }

    public Cap(BitmapDescriptor bitmapDescriptor, float f11) {
        this(3, bitmapDescriptor, Float.valueOf(f11));
    }

    public static Cap a(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        int readInt = parcelReader.readInt(2, 3);
        if (readInt == 0) {
            return new ButtCap();
        }
        if (readInt == 1) {
            return new SquareCap();
        }
        if (readInt == 2) {
            return new RoundCap();
        }
        if (readInt == 3) {
            IBinder readIBinder = parcelReader.readIBinder(3, (IBinder) null);
            float readFloat = parcelReader.readFloat(4, 0.0f);
            if (readIBinder != null) {
                BitmapDescriptor bitmapDescriptor = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(readIBinder));
                return readFloat != 0.0f ? new CustomCap(bitmapDescriptor, readFloat) : new CustomCap(bitmapDescriptor);
            }
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return super.equals(obj);
        }
        if (!(obj instanceof Cap)) {
            return false;
        }
        Cap cap = (Cap) obj;
        return this.f49448a == cap.f49448a && Objects.equal(this.f49449b, cap.f49449b) && Objects.equal(Float.valueOf(this.f49450c), Float.valueOf(cap.f49450c));
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f49448a), this.f49449b, Float.valueOf(this.f49450c));
    }

    public String toString() {
        return "Cap: type=" + this.f49448a;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeInt(2, this.f49448a);
        BitmapDescriptor bitmapDescriptor = this.f49449b;
        parcelWrite.writeIBinder(3, bitmapDescriptor != null ? bitmapDescriptor.getObject().asBinder() : null, true);
        parcelWrite.writeFloat(4, this.f49450c);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }
}
