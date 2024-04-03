package com.huawei.hms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import com.huawei.hms.maps.utils.LogM;

public class IndoorBuilding implements Parcelable {
    public static final Parcelable.Creator<IndoorBuilding> CREATOR = new Parcelable.Creator<IndoorBuilding>() {
        /* renamed from: a */
        public IndoorBuilding createFromParcel(Parcel parcel) {
            return new IndoorBuilding(parcel);
        }

        /* renamed from: a */
        public IndoorBuilding[] newArray(int i11) {
            return new IndoorBuilding[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    String f49486a;

    /* renamed from: b  reason: collision with root package name */
    String[] f49487b;

    /* renamed from: c  reason: collision with root package name */
    int[] f49488c;

    /* renamed from: d  reason: collision with root package name */
    String f49489d;

    public IndoorBuilding(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.f49486a = parcelReader.createString(2, "");
        this.f49487b = parcelReader.createStringArray(3, new String[0]);
        this.f49488c = parcelReader.createIntArray(4, new int[0]);
        this.f49489d = parcelReader.createString(5, "");
    }

    public IndoorBuilding(String str, String str2, String str3, String str4) {
        this.f49486a = str;
        this.f49487b = str2.split("\\|");
        String[] split = str3.split("\\|");
        this.f49488c = new int[split.length];
        try {
            int i11 = 0;
            for (String parseInt : split) {
                this.f49488c[i11] = Integer.parseInt(parseInt);
                i11++;
            }
        } catch (NumberFormatException unused) {
            LogM.e("IndoorBuilding", "error number type");
        }
        this.f49489d = str4;
    }

    public int describeContents() {
        return 0;
    }

    public String getBuildingId() {
        return this.f49486a;
    }

    public String getCurrFloorName() {
        return this.f49489d;
    }

    public String[] getFloorNames() {
        return this.f49487b;
    }

    public int[] getFloorOrder() {
        return this.f49488c;
    }

    public void setBuildingId(String str) {
        this.f49486a = str;
    }

    public void setCurrFloorName(String str) {
        this.f49489d = str;
    }

    public void setFloorNames(String[] strArr) {
        this.f49487b = strArr;
    }

    public void setFloorOrder(int[] iArr) {
        this.f49488c = iArr;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeString(2, this.f49486a, false);
        parcelWrite.writeStringArray(3, this.f49487b, false);
        parcelWrite.writeIntArray(4, this.f49488c, false);
        parcelWrite.writeString(5, this.f49489d, false);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }
}
