package com.huawei.location.base.activity.entity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

public class ClientInfo implements Parcelable {
    public static final Parcelable.Creator<ClientInfo> CREATOR = new yn();
    private int clientPid;
    private int clientUid;
    private Bundle mExtras;
    private String packageName;
    private String transactionID;

    public static class yn implements Parcelable.Creator<ClientInfo> {
        public Object createFromParcel(Parcel parcel) {
            return new ClientInfo(parcel);
        }

        public Object[] newArray(int i11) {
            return new ClientInfo[i11];
        }
    }

    public ClientInfo() {
        this.mExtras = null;
        this.transactionID = UUID.randomUUID().toString();
    }

    public ClientInfo(Parcel parcel) {
        this.mExtras = null;
        this.packageName = parcel.readString();
        this.clientUid = parcel.readInt();
        this.clientPid = parcel.readInt();
        this.transactionID = parcel.readString();
        this.mExtras = parcel.readBundle(Bundle.class.getClassLoader());
    }

    public ClientInfo(String str, int i11, int i12) {
        this.mExtras = null;
        this.packageName = str;
        this.clientUid = i11;
        this.clientPid = i12;
        this.transactionID = UUID.randomUUID().toString();
        this.mExtras = new Bundle();
    }

    public ClientInfo(String str, int i11, int i12, String str2) {
        this.mExtras = null;
        this.packageName = str;
        this.clientUid = i11;
        this.clientPid = i12;
        this.transactionID = str2;
        this.mExtras = new Bundle();
    }

    public ClientInfo(String str, int i11, int i12, String str2, Bundle bundle) {
        this.packageName = str;
        this.clientUid = i11;
        this.clientPid = i12;
        this.transactionID = str2;
        this.mExtras = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public int getClientPid() {
        return this.clientPid;
    }

    public int getClientUid() {
        return this.clientUid;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getTransactionID() {
        return this.transactionID;
    }

    public Bundle getmExtras() {
        return this.mExtras;
    }

    public void setClientPid(int i11) {
        this.clientPid = i11;
    }

    public void setClientUid(int i11) {
        this.clientUid = i11;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setTransactionID(String str) {
        this.transactionID = str;
    }

    public void setmExtras(Bundle bundle) {
        this.mExtras = bundle;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.packageName);
        parcel.writeInt(this.clientUid);
        parcel.writeInt(this.clientPid);
        parcel.writeString(this.transactionID);
        parcel.writeBundle(this.mExtras);
    }
}
