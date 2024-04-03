package com.huawei.hms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

public class HeatMapOptions implements Parcelable {
    public static final Parcelable.Creator<HeatMapOptions> CREATOR = new Parcelable.Creator<HeatMapOptions>() {
        public HeatMapOptions createFromParcel(Parcel parcel) {
            return new HeatMapOptions(parcel);
        }

        public HeatMapOptions[] newArray(int i11) {
            return new HeatMapOptions[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f49477a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f49478b = true;

    /* renamed from: c  reason: collision with root package name */
    private Map<Float, Integer> f49479c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private Map<Float, Float> f49480d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private Map<Float, Float> f49481e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private Map<Float, Float> f49482f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private int f49483g = 1;

    /* renamed from: h  reason: collision with root package name */
    private int f49484h;

    public enum RadiusUnit {
        PIXEL,
        METER
    }

    public HeatMapOptions() {
    }

    public HeatMapOptions(Parcel parcel) {
        boolean z11 = true;
        this.f49477a = parcel.readString();
        this.f49478b = parcel.readByte() == 0 ? false : z11;
        HashMap hashMap = new HashMap();
        this.f49479c = hashMap;
        parcel.readMap(hashMap, getClass().getClassLoader());
        HashMap hashMap2 = new HashMap();
        this.f49480d = hashMap2;
        parcel.readMap(hashMap2, getClass().getClassLoader());
        HashMap hashMap3 = new HashMap();
        this.f49481e = hashMap3;
        parcel.readMap(hashMap3, getClass().getClassLoader());
        HashMap hashMap4 = new HashMap();
        this.f49482f = hashMap4;
        parcel.readMap(hashMap4, getClass().getClassLoader());
        this.f49483g = parcel.readInt();
        this.f49484h = parcel.readInt();
    }

    public void color(Map<Float, Integer> map) {
        if (map != null) {
            this.f49479c.clear();
            this.f49479c.putAll(map);
        }
    }

    public void dataSet(int i11) {
        this.f49484h = i11;
    }

    public void dataSet(String str) {
        this.f49477a = str;
    }

    public int describeContents() {
        return 0;
    }

    public Map<Float, Integer> getColor() {
        return this.f49479c;
    }

    public String getHeatMapData() {
        return this.f49477a;
    }

    public Map<Float, Float> getIntensity() {
        return this.f49481e;
    }

    public Map<Float, Float> getOpacity() {
        return this.f49480d;
    }

    public Map<Float, Float> getRadius() {
        return this.f49482f;
    }

    public RadiusUnit getRadiusUnit() {
        return this.f49483g == 2 ? RadiusUnit.METER : RadiusUnit.PIXEL;
    }

    public int getResourceId() {
        return this.f49484h;
    }

    public boolean getVisible() {
        return this.f49478b;
    }

    public void intensity(float f11) {
        this.f49481e.clear();
        this.f49481e.put(Float.valueOf(0.0f), Float.valueOf(f11));
    }

    public void intensity(Map<Float, Float> map) {
        if (map != null) {
            this.f49481e.clear();
            this.f49481e.putAll(map);
        }
    }

    public void opacity(float f11) {
        this.f49480d.clear();
        this.f49480d.put(Float.valueOf(-1.0f), Float.valueOf(f11));
    }

    public void opacity(Map<Float, Float> map) {
        if (map != null) {
            this.f49480d.clear();
            this.f49480d.putAll(map);
        }
    }

    public void radius(float f11) {
        this.f49482f.clear();
        this.f49482f.put(Float.valueOf(0.0f), Float.valueOf(f11));
    }

    public void radius(Map<Float, Float> map) {
        if (map != null) {
            this.f49482f.clear();
            this.f49482f.putAll(map);
        }
    }

    public void radiusUnit(RadiusUnit radiusUnit) {
        this.f49483g = radiusUnit.equals(RadiusUnit.METER) ? 2 : 1;
    }

    public void setResourceId(int i11) {
        this.f49484h = i11;
    }

    public void visible(boolean z11) {
        this.f49478b = z11;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f49477a);
        parcel.writeByte(this.f49478b ? (byte) 1 : 0);
        parcel.writeMap(this.f49479c);
        parcel.writeMap(this.f49480d);
        parcel.writeMap(this.f49481e);
        parcel.writeMap(this.f49482f);
        parcel.writeInt(this.f49483g);
        parcel.writeInt(this.f49484h);
    }
}
