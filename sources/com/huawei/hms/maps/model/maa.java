package com.huawei.hms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;

public class maa implements Parcelable {
    public static final Parcelable.Creator<maa> CREATOR = new Parcelable.Creator<maa>() {
        /* renamed from: a */
        public maa createFromParcel(Parcel parcel) {
            return new maa(parcel);
        }

        /* renamed from: a */
        public maa[] newArray(int i11) {
            return new maa[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f49601a;

    /* renamed from: b  reason: collision with root package name */
    private String f49602b;

    /* renamed from: c  reason: collision with root package name */
    private String f49603c;

    /* renamed from: d  reason: collision with root package name */
    private String f49604d;

    /* renamed from: e  reason: collision with root package name */
    private String f49605e;

    /* renamed from: f  reason: collision with root package name */
    private long f49606f;

    /* renamed from: g  reason: collision with root package name */
    private String f49607g;

    /* renamed from: h  reason: collision with root package name */
    private String f49608h;

    public maa() {
    }

    public maa(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.f49601a = parcelReader.createString(2, "");
        this.f49602b = parcelReader.createString(3, "");
        this.f49603c = parcelReader.createString(4, "");
        this.f49604d = parcelReader.createString(5, "");
        this.f49605e = parcelReader.createString(6, "");
        this.f49606f = parcelReader.readLong(7, 0);
        this.f49607g = parcelReader.createString(8, "");
        this.f49608h = parcelReader.createString(9, "");
    }

    public maa a(long j11) {
        this.f49606f = j11;
        return this;
    }

    public maa a(String str) {
        this.f49607g = str;
        return this;
    }

    public maa b(String str) {
        this.f49601a = str;
        return this;
    }

    public maa c(String str) {
        this.f49602b = str;
        return this;
    }

    public maa d(String str) {
        this.f49603c = str;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public maa e(String str) {
        this.f49604d = str;
        return this;
    }

    public maa f(String str) {
        this.f49605e = str;
        return this;
    }

    public maa g(String str) {
        this.f49608h = str;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeString(2, this.f49601a, false);
        parcelWrite.writeString(3, this.f49602b, false);
        parcelWrite.writeString(4, this.f49603c, false);
        parcelWrite.writeString(5, this.f49604d, false);
        parcelWrite.writeString(6, this.f49605e, false);
        parcelWrite.writeLong(7, this.f49606f);
        parcelWrite.writeString(8, this.f49607g, false);
        parcelWrite.writeString(9, this.f49608h, false);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }
}
