package com.huawei.hms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import com.huawei.hms.maps.model.CameraPosition;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.LatLngBounds;
import com.huawei.hms.maps.utils.LogM;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class HuaweiMapOptions implements Parcelable {
    public static final Parcelable.Creator<HuaweiMapOptions> CREATOR = new Parcelable.Creator<HuaweiMapOptions>() {
        /* renamed from: a */
        public HuaweiMapOptions createFromParcel(Parcel parcel) {
            return new HuaweiMapOptions(parcel);
        }

        /* renamed from: a */
        public HuaweiMapOptions[] newArray(int i11) {
            return new HuaweiMapOptions[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f49284a = -1;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f49285b;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f49286c;

    /* renamed from: d  reason: collision with root package name */
    private CameraPosition f49287d;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f49288e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f49289f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f49290g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f49291h;

    /* renamed from: i  reason: collision with root package name */
    private Boolean f49292i;

    /* renamed from: j  reason: collision with root package name */
    private Boolean f49293j;

    /* renamed from: k  reason: collision with root package name */
    private Boolean f49294k;

    /* renamed from: l  reason: collision with root package name */
    private Boolean f49295l;

    /* renamed from: m  reason: collision with root package name */
    private Boolean f49296m;

    /* renamed from: n  reason: collision with root package name */
    private Float f49297n;

    /* renamed from: o  reason: collision with root package name */
    private Float f49298o;

    /* renamed from: p  reason: collision with root package name */
    private LatLngBounds f49299p;

    /* renamed from: q  reason: collision with root package name */
    private Boolean f49300q;

    /* renamed from: r  reason: collision with root package name */
    private String f49301r;

    /* renamed from: s  reason: collision with root package name */
    private String f49302s;

    /* renamed from: t  reason: collision with root package name */
    private Boolean f49303t;

    /* renamed from: u  reason: collision with root package name */
    private Boolean f49304u;

    public HuaweiMapOptions() {
        Boolean bool = Boolean.TRUE;
        this.f49288e = bool;
        this.f49289f = bool;
        this.f49290g = bool;
        this.f49291h = bool;
        this.f49292i = bool;
        this.f49293j = bool;
        Boolean bool2 = Boolean.FALSE;
        this.f49294k = bool2;
        this.f49297n = Float.valueOf(3.0f);
        this.f49298o = Float.valueOf(20.0f);
        this.f49299p = null;
        this.f49303t = bool;
        this.f49304u = bool2;
    }

    public HuaweiMapOptions(Parcel parcel) {
        Boolean bool = Boolean.TRUE;
        this.f49288e = bool;
        this.f49289f = bool;
        this.f49290g = bool;
        this.f49291h = bool;
        this.f49292i = bool;
        this.f49293j = bool;
        Boolean bool2 = Boolean.FALSE;
        this.f49294k = bool2;
        this.f49297n = Float.valueOf(3.0f);
        this.f49298o = Float.valueOf(20.0f);
        this.f49299p = null;
        this.f49303t = bool;
        this.f49304u = bool2;
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.f49284a = parcelReader.readInt(2, this.f49284a);
        this.f49285b = parcelReader.readBooleanObject(3, (Boolean) null);
        this.f49286c = parcelReader.readBooleanObject(4, (Boolean) null);
        this.f49288e = parcelReader.readBooleanObject(5, (Boolean) null);
        this.f49289f = parcelReader.readBooleanObject(6, (Boolean) null);
        this.f49290g = parcelReader.readBooleanObject(7, (Boolean) null);
        this.f49291h = parcelReader.readBooleanObject(8, (Boolean) null);
        this.f49292i = parcelReader.readBooleanObject(9, (Boolean) null);
        this.f49293j = parcelReader.readBooleanObject(10, (Boolean) null);
        this.f49294k = parcelReader.readBooleanObject(11, (Boolean) null);
        this.f49295l = parcelReader.readBooleanObject(12, (Boolean) null);
        this.f49296m = parcelReader.readBooleanObject(13, (Boolean) null);
        this.f49297n = parcelReader.readFloatObject(14, (Float) null);
        this.f49298o = parcelReader.readFloatObject(15, (Float) null);
        this.f49299p = (LatLngBounds) parcelReader.readParcelable(16, LatLngBounds.CREATOR, null);
        this.f49287d = (CameraPosition) parcelReader.readParcelable(17, CameraPosition.CREATOR, null);
        this.f49300q = parcelReader.readBooleanObject(18, (Boolean) null);
        this.f49301r = parcelReader.createString(19, (String) null);
        this.f49302s = parcelReader.createString(20, (String) null);
        this.f49303t = parcelReader.readBooleanObject(21, (Boolean) null);
        this.f49304u = parcelReader.readBooleanObject(22, (Boolean) null);
    }

    public static CameraPosition buildCameraPosition(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        int i11 = R.styleable.MapAttrs_cameraTargetLat;
        float f11 = obtainAttributes.hasValue(i11) ? obtainAttributes.getFloat(i11, 0.0f) : 0.0f;
        int i12 = R.styleable.MapAttrs_cameraTargetLng;
        LatLng latLng = new LatLng((double) f11, (double) (obtainAttributes.hasValue(i12) ? obtainAttributes.getFloat(i12, 0.0f) : 0.0f));
        CameraPosition.Builder builder = CameraPosition.builder();
        builder.target(latLng);
        int i13 = R.styleable.MapAttrs_cameraZoom;
        if (obtainAttributes.hasValue(i13)) {
            builder.zoom(obtainAttributes.getFloat(i13, 0.0f));
        }
        int i14 = R.styleable.MapAttrs_cameraBearing;
        if (obtainAttributes.hasValue(i14)) {
            builder.bearing(obtainAttributes.getFloat(i14, 0.0f));
        }
        int i15 = R.styleable.MapAttrs_cameraTilt;
        if (obtainAttributes.hasValue(i15)) {
            builder.tilt(obtainAttributes.getFloat(i15, 0.0f));
        }
        obtainAttributes.recycle();
        return builder.build();
    }

    public static LatLngBounds buildLatLngBounds(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        int i11 = R.styleable.MapAttrs_latLngBoundsSouthWestLatitude;
        Float valueOf = obtainAttributes.hasValue(i11) ? Float.valueOf(obtainAttributes.getFloat(i11, 0.0f)) : null;
        int i12 = R.styleable.MapAttrs_latLngBoundsSouthWestLongitude;
        Float valueOf2 = obtainAttributes.hasValue(i12) ? Float.valueOf(obtainAttributes.getFloat(i12, 0.0f)) : null;
        int i13 = R.styleable.MapAttrs_latLngBoundsNorthEastLatitude;
        Float valueOf3 = obtainAttributes.hasValue(i13) ? Float.valueOf(obtainAttributes.getFloat(i13, 0.0f)) : null;
        int i14 = R.styleable.MapAttrs_latLngBoundsNorthEastLongitude;
        Float valueOf4 = obtainAttributes.hasValue(i14) ? Float.valueOf(obtainAttributes.getFloat(i14, 0.0f)) : null;
        obtainAttributes.recycle();
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null) {
            return null;
        }
        return new LatLngBounds(new LatLng((double) valueOf.floatValue(), (double) valueOf2.floatValue()), new LatLng((double) valueOf3.floatValue(), (double) valueOf4.floatValue()));
    }

    public static HuaweiMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        HuaweiMapOptions huaweiMapOptions = new HuaweiMapOptions();
        if (attributeSet == null) {
            LogM.d("ContentValues", "createFromAttributes() attrs is null");
            return huaweiMapOptions;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.MapAttrs, 0, 0);
        try {
            int i11 = obtainStyledAttributes.getInt(R.styleable.MapAttrs_mapType, 1);
            LogM.d("ContentValues", "createFromAttributes() mapyType is " + i11);
            if (i11 != 0) {
                if (i11 != 3) {
                    i11 = 1;
                }
            }
            huaweiMapOptions.f49284a = i11;
            huaweiMapOptions.f49287d = CameraPosition.createFromAttributes(context, attributeSet);
            huaweiMapOptions.f49288e = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.MapAttrs_uiZoomControls, true));
            huaweiMapOptions.f49289f = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.MapAttrs_uiCompass, true));
            int i12 = R.styleable.MapAttrs_uiZoomGestures;
            if (obtainStyledAttributes.hasValue(i12)) {
                huaweiMapOptions.f49291h = Boolean.valueOf(obtainStyledAttributes.getBoolean(i12, true));
            }
            int i13 = R.styleable.MapAttrs_uiScrollGestures;
            if (obtainStyledAttributes.hasValue(i13)) {
                huaweiMapOptions.f49290g = Boolean.valueOf(obtainStyledAttributes.getBoolean(i13, true));
            }
            int i14 = R.styleable.MapAttrs_uiRotateGestures;
            if (obtainStyledAttributes.hasValue(i14)) {
                huaweiMapOptions.f49293j = Boolean.valueOf(obtainStyledAttributes.getBoolean(i14, true));
            }
            int i15 = R.styleable.MapAttrs_uiTiltGestures;
            if (obtainStyledAttributes.hasValue(i15)) {
                huaweiMapOptions.f49292i = Boolean.valueOf(obtainStyledAttributes.getBoolean(i15, true));
            }
            huaweiMapOptions.f49285b = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.MapAttrs_zOrderOnTop, false));
            huaweiMapOptions.f49286c = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.MapAttrs_useViewLifecycle, true));
            huaweiMapOptions.f49294k = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.MapAttrs_liteMode, false));
            huaweiMapOptions.f49300q = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom, false));
            huaweiMapOptions.f49295l = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.MapAttrs_uiMapToolbar, false));
            huaweiMapOptions.f49296m = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.MapAttrs_ambientEnabled, false));
            huaweiMapOptions.f49297n = Float.valueOf(obtainStyledAttributes.getFloat(R.styleable.MapAttrs_cameraMinZoomPreference, 3.0f));
            huaweiMapOptions.f49298o = Float.valueOf(obtainStyledAttributes.getFloat(R.styleable.MapAttrs_cameraMaxZoomPreference, 22.0f));
            huaweiMapOptions.f49301r = obtainStyledAttributes.getString(R.styleable.MapAttrs_styleId);
            huaweiMapOptions.f49302s = obtainStyledAttributes.getString(R.styleable.MapAttrs_previewId);
            huaweiMapOptions.f49303t = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.MapAttrs_styleEnable, true));
            huaweiMapOptions.f49304u = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.MapAttrs_dark, false));
            huaweiMapOptions.latLngBoundsForCameraTarget(buildLatLngBounds(context, attributeSet));
            return huaweiMapOptions;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public HuaweiMapOptions ambientEnabled(boolean z11) {
        this.f49296m = Boolean.valueOf(z11);
        return this;
    }

    public HuaweiMapOptions camera(CameraPosition cameraPosition) {
        this.f49287d = cameraPosition;
        return this;
    }

    public HuaweiMapOptions compassEnabled(boolean z11) {
        this.f49289f = Boolean.valueOf(z11);
        return this;
    }

    public HuaweiMapOptions dark(boolean z11) {
        this.f49304u = Boolean.valueOf(z11);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public Boolean getAmbientEnabled() {
        return Boolean.FALSE;
    }

    public CameraPosition getCamera() {
        return this.f49287d;
    }

    public Boolean getCompassEnabled() {
        return this.f49289f;
    }

    public Boolean getDark() {
        return this.f49304u;
    }

    public LatLngBounds getLatLngBoundsForCameraTarget() {
        return this.f49299p;
    }

    public Boolean getLiteMode() {
        return this.f49294k;
    }

    public Boolean getMapToolbarEnabled() {
        return Boolean.FALSE;
    }

    public int getMapType() {
        return this.f49284a;
    }

    public Float getMaxZoomPreference() {
        return this.f49298o;
    }

    public Float getMinZoomPreference() {
        return this.f49297n;
    }

    public String getPreviewId() {
        return this.f49302s;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.f49293j;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.f49290g;
    }

    public Boolean getStyleEnable() {
        return this.f49303t;
    }

    public String getStyleId() {
        return this.f49301r;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.f49292i;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.f49286c;
    }

    public Boolean getZOrderOnTop() {
        return this.f49285b;
    }

    public Boolean getZoomControlsEnabled() {
        return this.f49288e;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.f49291h;
    }

    public HuaweiMapOptions latLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        this.f49299p = latLngBounds;
        return this;
    }

    public HuaweiMapOptions liteMode(boolean z11) {
        this.f49294k = Boolean.valueOf(z11);
        return this;
    }

    public HuaweiMapOptions mapToolbarEnabled(boolean z11) {
        this.f49295l = Boolean.valueOf(z11);
        return this;
    }

    public HuaweiMapOptions mapType(int i11) {
        this.f49284a = i11;
        return this;
    }

    public HuaweiMapOptions maxZoomPreference(float f11) {
        this.f49298o = Float.valueOf(f11);
        return this;
    }

    public HuaweiMapOptions minZoomPreference(float f11) {
        this.f49297n = Float.valueOf(f11);
        return this;
    }

    public HuaweiMapOptions previewId(String str) {
        this.f49302s = str;
        return this;
    }

    public HuaweiMapOptions rotateGesturesEnabled(boolean z11) {
        this.f49293j = Boolean.valueOf(z11);
        return this;
    }

    public HuaweiMapOptions scrollGesturesEnabled(boolean z11) {
        this.f49290g = Boolean.valueOf(z11);
        return this;
    }

    public HuaweiMapOptions styleEnable(boolean z11) {
        this.f49303t = Boolean.valueOf(z11);
        return this;
    }

    public HuaweiMapOptions styleId(String str) {
        this.f49301r = str;
        return this;
    }

    public HuaweiMapOptions tiltGesturesEnabled(boolean z11) {
        this.f49292i = Boolean.valueOf(z11);
        return this;
    }

    public String toString() {
        return "HuaweiMapOptions{mapType=" + this.f49284a + ", zOrderOnTop=" + this.f49285b + ", isUseViewLifecycleInFragment=" + this.f49286c + ", cameraPosition=" + this.f49287d + ", isZoomControlsEnabled=" + this.f49288e + ", isCompassEnabled=" + this.f49289f + ", isScrollGesturesEnabled=" + this.f49290g + ", isZoomGesturesEnabled=" + this.f49291h + ", isTiltGesturesEnabled=" + this.f49292i + ", isRotateGesturesEnabled=" + this.f49293j + ", isLiteMode=" + this.f49294k + ", isMapToolbarEnabled=" + this.f49295l + ", isAmbientEnabled=" + this.f49296m + ", minZoomLevel=" + this.f49297n + ", maxZoomLevel=" + this.f49298o + ", latLngBounds=" + this.f49299p + ", styleId=" + this.f49301r + ", previewId=" + this.f49302s + AbstractJsonLexerKt.END_OBJ;
    }

    public HuaweiMapOptions useViewLifecycleInFragment(boolean z11) {
        this.f49286c = Boolean.valueOf(z11);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeInt(2, this.f49284a);
        parcelWrite.writeBooleanObject(3, this.f49285b);
        parcelWrite.writeBooleanObject(4, this.f49286c);
        parcelWrite.writeBooleanObject(5, this.f49288e);
        parcelWrite.writeBooleanObject(6, this.f49289f);
        parcelWrite.writeBooleanObject(7, this.f49290g);
        parcelWrite.writeBooleanObject(8, this.f49291h);
        parcelWrite.writeBooleanObject(9, this.f49292i);
        parcelWrite.writeBooleanObject(10, this.f49293j);
        parcelWrite.writeBooleanObject(11, this.f49294k);
        parcelWrite.writeBooleanObject(12, this.f49295l);
        parcelWrite.writeBooleanObject(13, this.f49296m);
        parcelWrite.writeFloatObject(14, this.f49297n, true);
        parcelWrite.writeFloatObject(15, this.f49298o, true);
        parcelWrite.writeParcelable(16, this.f49299p, i11, false);
        parcelWrite.writeParcelable(17, this.f49287d, i11, false);
        parcelWrite.writeBooleanObject(18, this.f49300q);
        parcelWrite.writeString(19, this.f49301r, false);
        parcelWrite.writeString(20, this.f49302s, false);
        parcelWrite.writeBooleanObject(21, this.f49303t, false);
        parcelWrite.writeBooleanObject(22, this.f49304u, false);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }

    public HuaweiMapOptions zOrderOnTop(boolean z11) {
        this.f49285b = Boolean.valueOf(z11);
        return this;
    }

    public HuaweiMapOptions zoomControlsEnabled(boolean z11) {
        this.f49288e = Boolean.valueOf(z11);
        return this;
    }

    public HuaweiMapOptions zoomGesturesEnabled(boolean z11) {
        this.f49291h = Boolean.valueOf(z11);
        return this;
    }
}
