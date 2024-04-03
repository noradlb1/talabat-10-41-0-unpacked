package com.huawei.hms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;

public class MapAuthInfo implements Parcelable {
    public static final Parcelable.Creator<MapAuthInfo> CREATOR = new Parcelable.Creator<MapAuthInfo>() {
        /* renamed from: a */
        public MapAuthInfo createFromParcel(Parcel parcel) {
            return new MapAuthInfo(parcel);
        }

        /* renamed from: a */
        public MapAuthInfo[] newArray(int i11) {
            return new MapAuthInfo[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private long f49494a;

    /* renamed from: b  reason: collision with root package name */
    private String f49495b;

    /* renamed from: c  reason: collision with root package name */
    private String f49496c;

    /* renamed from: d  reason: collision with root package name */
    private int f49497d;

    /* renamed from: e  reason: collision with root package name */
    private int f49498e;

    /* renamed from: f  reason: collision with root package name */
    private String f49499f;

    /* renamed from: g  reason: collision with root package name */
    private String f49500g;

    /* renamed from: h  reason: collision with root package name */
    private String f49501h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f49502i;

    /* renamed from: j  reason: collision with root package name */
    private String f49503j;

    public MapAuthInfo() {
    }

    public MapAuthInfo(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.f49495b = parcelReader.createString(2, "");
        this.f49496c = parcelReader.createString(3, "");
        this.f49497d = parcelReader.readInt(4, 10);
        this.f49498e = parcelReader.readInt(5, 60);
        this.f49494a = parcelReader.readLong(6, 0);
        this.f49499f = parcelReader.createString(7, "");
        this.f49500g = parcelReader.createString(8, "");
        this.f49501h = parcelReader.createString(9, "");
        this.f49502i = parcelReader.readBoolean(10, true);
        this.f49503j = parcelReader.createString(11, "");
    }

    public int describeContents() {
        return 0;
    }

    public int getApiUsageBatchNum() {
        return this.f49497d;
    }

    public int getApiUsageWaitDuration() {
        return this.f49498e;
    }

    public String getIidentifyResult() {
        return this.f49495b;
    }

    public boolean getIsSyncAuth() {
        return this.f49502i;
    }

    public String getPoliticalView() {
        return this.f49499f;
    }

    public String getProviderType() {
        return this.f49503j;
    }

    public String getRequestId() {
        return this.f49500g;
    }

    public String getSdkVersion() {
        return this.f49501h;
    }

    public long getStartAuthTime() {
        return this.f49494a;
    }

    public String getTomApikey() {
        return this.f49496c;
    }

    public MapAuthInfo identifyResult(String str) {
        this.f49495b = str;
        return this;
    }

    public MapAuthInfo isSyncAuth(boolean z11) {
        this.f49502i = z11;
        return this;
    }

    public MapAuthInfo mapApiUsageBatchNum(int i11) {
        this.f49497d = i11;
        return this;
    }

    public MapAuthInfo mapApiUsageWaitDuration(int i11) {
        this.f49498e = i11;
        return this;
    }

    public MapAuthInfo packageFingerprint(int i11) {
        this.f49498e = i11;
        return this;
    }

    public MapAuthInfo politicalView(String str) {
        this.f49499f = str;
        return this;
    }

    public MapAuthInfo providerType(String str) {
        this.f49503j = str;
        return this;
    }

    public MapAuthInfo requestId(String str) {
        this.f49500g = str;
        return this;
    }

    public MapAuthInfo sdkVersion(String str) {
        this.f49501h = str;
        return this;
    }

    public MapAuthInfo startAuthTime(Long l11) {
        this.f49494a = l11.longValue();
        return this;
    }

    public MapAuthInfo tomApikey(String str) {
        this.f49496c = str;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeString(2, this.f49495b, false);
        parcelWrite.writeString(3, this.f49496c, false);
        parcelWrite.writeInt(4, this.f49497d);
        parcelWrite.writeInt(5, this.f49498e);
        parcelWrite.writeLong(6, this.f49494a);
        parcelWrite.writeString(7, this.f49499f, false);
        parcelWrite.writeString(8, this.f49500g, false);
        parcelWrite.writeString(9, this.f49501h, false);
        parcelWrite.writeBoolean(10, this.f49502i);
        parcelWrite.writeString(11, this.f49503j, false);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }
}
