package com.huawei.wearengine.monitor;

import android.os.Parcel;
import android.os.Parcelable;

public class MonitorItem implements Parcelable {
    public static final Parcelable.Creator<MonitorItem> CREATOR = new a();
    public static final MonitorItem MONITOR_CHARGE_STATUS = new MonitorItem("chargeStatus");
    public static final MonitorItem MONITOR_ITEM_CONNECTION = new MonitorItem("connectionStatus");
    public static final MonitorItem MONITOR_ITEM_HEART_RATE_ALARM = new MonitorItem("heartRateAlarm");
    public static final MonitorItem MONITOR_ITEM_LOW_POWER = new MonitorItem("lowPower");
    public static final MonitorItem MONITOR_ITEM_SLEEP = new MonitorItem("sleepStatus");
    public static final MonitorItem MONITOR_ITEM_SPORT = new MonitorItem("sportStatus");
    public static final MonitorItem MONITOR_ITEM_USER_AVAILABLE_KBYTES = new MonitorItem("userAvailableKbytes");
    public static final MonitorItem MONITOR_ITEM_WEAR = new MonitorItem("wearStatus");
    public static final MonitorItem MONITOR_POWER_STATUS = new MonitorItem("powerStatus");
    private String mName;

    public static class a implements Parcelable.Creator<MonitorItem> {
        public Object createFromParcel(Parcel parcel) {
            MonitorItem monitorItem = new MonitorItem();
            monitorItem.setName(parcel.readString());
            return monitorItem;
        }

        public Object[] newArray(int i11) {
            if (i11 > 65535 || i11 < 0) {
                return null;
            }
            return new MonitorItem[i11];
        }
    }

    public MonitorItem() {
    }

    private MonitorItem(String str) {
        this.mName = str;
    }

    public int describeContents() {
        return 0;
    }

    public String getName() {
        return this.mName;
    }

    public void readFromParcel(Parcel parcel) {
        this.mName = parcel.readString();
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.mName);
    }
}
