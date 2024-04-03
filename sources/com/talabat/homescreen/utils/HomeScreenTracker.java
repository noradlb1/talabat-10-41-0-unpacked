package com.talabat.homescreen.utils;

import android.content.Context;
import android.os.Bundle;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.ITalabatFirebase;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J*\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u001a\u0010\u0017\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0014\u0010\u0018\u001a\u00020\u0010*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\f\u0010\u001c\u001a\u00020\u0010*\u00020\u0019H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/talabat/homescreen/utils/HomeScreenTracker;", "", "context", "Landroid/content/Context;", "talabatFirebase", "Ltracking/gtm/ITalabatFirebase;", "locationDataFactory", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;", "(Landroid/content/Context;Ltracking/gtm/ITalabatFirebase;Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;)V", "_shopListType", "", "shopListType", "getShopListType", "()Ljava/lang/String;", "getHomePageUaeExp", "homePageAATestExperiments", "", "trackBottomNavigationClick", "navigationOption", "eventOrigin", "userId", "address", "Lcom/talabat/domain/address/Address;", "trackHomeLoad", "applyLocationData", "Landroid/os/Bundle;", "locationData", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory$LocationData;", "applyScreenType", "Companion", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenTracker {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String DEFAULT_EXPERIMENT_VARIATION = "Control";
    @NotNull
    @Deprecated
    public static final String KEY_EVENT_ORIGIN = "eventOrigin";
    @NotNull
    @Deprecated
    public static final String KEY_LOCATION_ADDRESS = "locationAddress";
    @NotNull
    @Deprecated
    public static final String KEY_LOCATION_AREA = "locationArea";
    @NotNull
    @Deprecated
    public static final String KEY_LOCATION_CITY = "locationCity";
    @NotNull
    @Deprecated
    public static final String KEY_LOCATION_COUNTRY = "locationCountry";
    @NotNull
    @Deprecated
    public static final String KEY_LOCATION_LATITUDE = "locationLat";
    @NotNull
    @Deprecated
    public static final String KEY_LOCATION_LONGITUDE = "locationLon";
    @NotNull
    @Deprecated
    public static final String KEY_NAVIGATION_OPTION = "navigationOption";
    @NotNull
    @Deprecated
    public static final String KEY_SCREEN_NAME = "screenName";
    @NotNull
    @Deprecated
    public static final String KEY_SCREEN_TYPE = "screenType";
    @NotNull
    @Deprecated
    public static final String KEY_USER_ID = "userId";
    @NotNull
    @Deprecated
    public static final String VALUE_NOT_AVAILABLE = "N/A";
    @NotNull
    @Deprecated
    public static final String VALUE_PAGE_TYPE = "home";
    @NotNull
    @Deprecated
    public static final String VALUE_SCREEN_NAME = "Home Screen";
    @Nullable
    private String _shopListType;
    @Nullable
    private final Context context;
    @NotNull
    private final LocationDataFactory locationDataFactory;
    @NotNull
    private final ITalabatFirebase talabatFirebase;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/homescreen/utils/HomeScreenTracker$Companion;", "", "()V", "DEFAULT_EXPERIMENT_VARIATION", "", "KEY_EVENT_ORIGIN", "KEY_LOCATION_ADDRESS", "KEY_LOCATION_AREA", "KEY_LOCATION_CITY", "KEY_LOCATION_COUNTRY", "KEY_LOCATION_LATITUDE", "KEY_LOCATION_LONGITUDE", "KEY_NAVIGATION_OPTION", "KEY_SCREEN_NAME", "KEY_SCREEN_TYPE", "KEY_USER_ID", "VALUE_NOT_AVAILABLE", "VALUE_PAGE_TYPE", "VALUE_SCREEN_NAME", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HomeScreenTracker(@Nullable Context context2, @NotNull ITalabatFirebase iTalabatFirebase, @NotNull LocationDataFactory locationDataFactory2) {
        Intrinsics.checkNotNullParameter(iTalabatFirebase, "talabatFirebase");
        Intrinsics.checkNotNullParameter(locationDataFactory2, "locationDataFactory");
        this.context = context2;
        this.talabatFirebase = iTalabatFirebase;
        this.locationDataFactory = locationDataFactory2;
    }

    private final void applyLocationData(Bundle bundle, LocationDataFactory.LocationData locationData) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        String city = locationData.getCity();
        boolean z16 = true;
        if (city.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        String str = "N/A";
        if (z11) {
            city = str;
        }
        bundle.putString("locationCity", city);
        String area = locationData.getArea();
        if (area.length() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            area = str;
        }
        bundle.putString("locationArea", area);
        String country = locationData.getCountry();
        if (country.length() == 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13) {
            country = str;
        }
        bundle.putString("locationCountry", country);
        String latitude = locationData.getLatitude();
        if (latitude.length() == 0) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14) {
            latitude = str;
        }
        bundle.putString("locationLat", latitude);
        String longitude = locationData.getLongitude();
        if (longitude.length() == 0) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z15) {
            longitude = str;
        }
        bundle.putString("locationLon", longitude);
        String address = locationData.getAddress();
        if (address.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            str = address;
        }
        bundle.putString("locationAddress", str);
    }

    private final void applyScreenType(Bundle bundle) {
        bundle.putString("screenType", "home");
        bundle.putString("screenName", "Home Screen");
    }

    private final String getHomePageUaeExp() {
        return TalabatExperiment.INSTANCE.getStringVariant(TalabatExperimentConstants.HOME_PAGE_UAE_EXP_POC, "Control", TalabatExperimentDataSourceStrategy.FWF);
    }

    private final void homePageAATestExperiments() {
        String homePageUaeExp = getHomePageUaeExp();
        TalabatExperimentConstants talabatExperimentConstants = TalabatExperimentConstants.HOME_PAGE_UAE_EXP_POC;
        LogManager.info(talabatExperimentConstants + " experiment: " + homePageUaeExp);
    }

    @Nullable
    public final String getShopListType() {
        return this._shopListType;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r9 == null) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void trackBottomNavigationClick(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.Nullable java.lang.String r9, @org.jetbrains.annotations.Nullable com.talabat.domain.address.Address r10) {
        /*
            r6 = this;
            java.lang.String r0 = "navigationOption"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r1 = "eventOrigin"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            android.content.Context r2 = r6.context
            if (r2 != 0) goto L_0x000f
            return
        L_0x000f:
            com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory r2 = r6.locationDataFactory
            com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory$LocationData r10 = r2.createLocationData(r10)
            tracking.gtm.ITalabatFirebase r2 = r6.talabatFirebase
            android.content.Context r3 = r6.context
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            if (r9 == 0) goto L_0x002f
            int r5 = r9.length()
            if (r5 <= 0) goto L_0x0028
            r5 = 1
            goto L_0x0029
        L_0x0028:
            r5 = 0
        L_0x0029:
            if (r5 == 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r9 = 0
        L_0x002d:
            if (r9 != 0) goto L_0x0031
        L_0x002f:
            java.lang.String r9 = "N/A"
        L_0x0031:
            java.lang.String r5 = "userId"
            r4.putString(r5, r9)
            r6.applyScreenType(r4)
            r4.putString(r0, r7)
            r4.putString(r1, r8)
            r6.applyLocationData(r4, r10)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            java.lang.String r7 = "navigation_clicked"
            r2.dispatchEvent(r3, r7, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.homescreen.utils.HomeScreenTracker.trackBottomNavigationClick(java.lang.String, java.lang.String, java.lang.String, com.talabat.domain.address.Address):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        if (r5 == null) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void trackHomeLoad(@org.jetbrains.annotations.Nullable java.lang.String r5, @org.jetbrains.annotations.Nullable com.talabat.domain.address.Address r6) {
        /*
            r4 = this;
            android.content.Context r0 = r4.context
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory r0 = r4.locationDataFactory
            com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory$LocationData r6 = r0.createLocationData(r6)
            tracking.gtm.ITalabatFirebase r0 = r4.talabatFirebase
            android.content.Context r1 = r4.context
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            if (r5 == 0) goto L_0x0025
            int r3 = r5.length()
            if (r3 <= 0) goto L_0x001e
            r3 = 1
            goto L_0x001f
        L_0x001e:
            r3 = 0
        L_0x001f:
            if (r3 == 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r5 = 0
        L_0x0023:
            if (r5 != 0) goto L_0x0027
        L_0x0025:
            java.lang.String r5 = "N/A"
        L_0x0027:
            java.lang.String r3 = "userId"
            r2.putString(r3, r5)
            r4.applyScreenType(r2)
            r4.applyLocationData(r2, r6)
            java.lang.String r5 = "eventOrigin"
            java.lang.String r6 = "bottom_navigation_home"
            r2.putString(r5, r6)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            java.lang.String r5 = "home_screen_loaded"
            r0.dispatchEvent(r1, r5, r2)
            r4.homePageAATestExperiments()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.homescreen.utils.HomeScreenTracker.trackHomeLoad(java.lang.String, com.talabat.domain.address.Address):void");
    }
}
