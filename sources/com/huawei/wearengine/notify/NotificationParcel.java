package com.huawei.wearengine.notify;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

public class NotificationParcel implements Parcelable {
    public static final Parcelable.Creator<NotificationParcel> CREATOR = new a();
    private HashMap<Integer, String> mButtonContents;
    private String mExtendJson = "";
    private String mPackageName;
    private int mRingtoneId = -1;
    private int mTemplateId;
    private String mText;
    private String mTitle;
    private int mVibration;

    public static class a implements Parcelable.Creator<NotificationParcel> {
        public Object createFromParcel(Parcel parcel) {
            return new NotificationParcel(parcel);
        }

        public Object[] newArray(int i11) {
            if (i11 > 65535 || i11 < 0) {
                return null;
            }
            return new NotificationParcel[i11];
        }
    }

    public NotificationParcel(Parcel parcel) {
        this.mTemplateId = parcel.readInt();
        this.mPackageName = parcel.readString();
        this.mTitle = parcel.readString();
        this.mText = parcel.readString();
        this.mButtonContents = parcel.readHashMap(HashMap.class.getClassLoader());
        this.mVibration = parcel.readInt();
        this.mRingtoneId = parcel.readInt();
        this.mExtendJson = parcel.readString();
    }

    public NotificationParcel(Notification notification) {
        if (notification != null) {
            this.mTemplateId = notification.getTemplateId();
            this.mPackageName = notification.getPackageName();
            this.mTitle = notification.getTitle();
            this.mText = notification.getText();
            this.mButtonContents = notification.getButtonContents();
        }
    }

    public int describeContents() {
        return 0;
    }

    public HashMap<Integer, String> getButtonContents() {
        return this.mButtonContents;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getRingtoneId() {
        return this.mRingtoneId;
    }

    public int getTemplateId() {
        return this.mTemplateId;
    }

    public String getText() {
        return this.mText;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getVibration() {
        return this.mVibration;
    }

    public void readFromParcel(Parcel parcel) {
        this.mTemplateId = parcel.readInt();
        this.mPackageName = parcel.readString();
        this.mTitle = parcel.readString();
        this.mText = parcel.readString();
        this.mButtonContents = parcel.readHashMap(HashMap.class.getClassLoader());
        this.mVibration = parcel.readInt();
        this.mRingtoneId = parcel.readInt();
        this.mExtendJson = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.mTemplateId);
        parcel.writeString(this.mPackageName);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mText);
        parcel.writeMap(this.mButtonContents);
        parcel.writeInt(this.mVibration);
        parcel.writeInt(this.mRingtoneId);
        parcel.writeString(this.mExtendJson);
    }
}
