package com.talabat.home.useraccount.tracking;

import android.content.Context;
import com.talabat.domain.address.Address;
import com.talabat.feature.bnplcore.domain.model.BnplNavigationOptionLoadedEventKt;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.ITalabatFirebase;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJT\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010\u0015\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ:\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/home/useraccount/tracking/UserAccountTracker;", "", "context", "Landroid/content/Context;", "talabatFirebase", "Ltracking/gtm/ITalabatFirebase;", "locationDataFactory", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;", "(Landroid/content/Context;Ltracking/gtm/ITalabatFirebase;Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;)V", "trackEvent", "", "address", "Lcom/talabat/domain/address/Address;", "eventName", "", "userId", "screenType", "screenName", "navigationOption", "badgeType", "badgeValue", "trackHelpCenterClick", "trackNavigationOptionClick", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserAccountTracker {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String KEY_BADGE_TYPE = "badgeType";
    @NotNull
    @Deprecated
    public static final String KEY_BADGE_VALUE = "badgeValue";
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
    private final Context context;
    @NotNull
    private final LocationDataFactory locationDataFactory;
    @NotNull
    private final ITalabatFirebase talabatFirebase;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/home/useraccount/tracking/UserAccountTracker$Companion;", "", "()V", "KEY_BADGE_TYPE", "", "KEY_BADGE_VALUE", "KEY_EVENT_ORIGIN", "KEY_LOCATION_ADDRESS", "KEY_LOCATION_AREA", "KEY_LOCATION_CITY", "KEY_LOCATION_COUNTRY", "KEY_LOCATION_LATITUDE", "KEY_LOCATION_LONGITUDE", "KEY_NAVIGATION_OPTION", "KEY_SCREEN_NAME", "KEY_SCREEN_TYPE", "KEY_USER_ID", "VALUE_NOT_AVAILABLE", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UserAccountTracker(@NotNull Context context2, @NotNull ITalabatFirebase iTalabatFirebase, @NotNull LocationDataFactory locationDataFactory2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(iTalabatFirebase, "talabatFirebase");
        Intrinsics.checkNotNullParameter(locationDataFactory2, "locationDataFactory");
        this.context = context2;
        this.talabatFirebase = iTalabatFirebase;
        this.locationDataFactory = locationDataFactory2;
    }

    public static /* synthetic */ void a(UserAccountTracker userAccountTracker, Address address, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, Object obj) {
        int i12 = i11;
        userAccountTracker.trackEvent(address, str, str2, str3, str4, str5, (i12 & 64) != 0 ? null : str6, (i12 & 128) != 0 ? null : str7);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00e9, code lost:
        if (r1 == null) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r9 == null) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void trackEvent(com.talabat.domain.address.Address r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19) {
        /*
            r11 = this;
            r0 = r11
            com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory r1 = r0.locationDataFactory
            r2 = r12
            com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory$LocationData r1 = r1.createLocationData(r12)
            tracking.gtm.ITalabatFirebase r2 = r0.talabatFirebase
            android.content.Context r3 = r0.context
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            r5 = 0
            r6 = 1
            r7 = 0
            java.lang.String r8 = "N/A"
            if (r14 == 0) goto L_0x0028
            int r9 = r14.length()
            if (r9 <= 0) goto L_0x0020
            r9 = r6
            goto L_0x0021
        L_0x0020:
            r9 = r7
        L_0x0021:
            if (r9 == 0) goto L_0x0025
            r9 = r14
            goto L_0x0026
        L_0x0025:
            r9 = r5
        L_0x0026:
            if (r9 != 0) goto L_0x0029
        L_0x0028:
            r9 = r8
        L_0x0029:
            java.lang.String r10 = "userId"
            r4.putString(r10, r9)
            java.lang.String r9 = "screenType"
            r10 = r15
            r4.putString(r9, r15)
            java.lang.String r9 = "screenName"
            r10 = r16
            r4.putString(r9, r10)
            int r9 = r17.length()
            if (r9 <= 0) goto L_0x0044
            r9 = r6
            goto L_0x0045
        L_0x0044:
            r9 = r7
        L_0x0045:
            if (r9 == 0) goto L_0x004a
            r9 = r17
            goto L_0x004b
        L_0x004a:
            r9 = r5
        L_0x004b:
            if (r9 != 0) goto L_0x004e
            r9 = r8
        L_0x004e:
            java.lang.String r10 = "navigationOption"
            r4.putString(r10, r9)
            java.lang.String r9 = "eventOrigin"
            java.lang.String r10 = "bottom_navigation_account"
            r4.putString(r9, r10)
            java.lang.String r9 = r1.getCity()
            int r10 = r9.length()
            if (r10 != 0) goto L_0x0066
            r10 = r6
            goto L_0x0067
        L_0x0066:
            r10 = r7
        L_0x0067:
            if (r10 == 0) goto L_0x006a
            r9 = r8
        L_0x006a:
            java.lang.String r10 = "locationCity"
            r4.putString(r10, r9)
            java.lang.String r9 = r1.getArea()
            int r10 = r9.length()
            if (r10 != 0) goto L_0x007b
            r10 = r6
            goto L_0x007c
        L_0x007b:
            r10 = r7
        L_0x007c:
            if (r10 == 0) goto L_0x007f
            r9 = r8
        L_0x007f:
            java.lang.String r10 = "locationArea"
            r4.putString(r10, r9)
            java.lang.String r9 = r1.getCountry()
            int r10 = r9.length()
            if (r10 != 0) goto L_0x0090
            r10 = r6
            goto L_0x0091
        L_0x0090:
            r10 = r7
        L_0x0091:
            if (r10 == 0) goto L_0x0094
            r9 = r8
        L_0x0094:
            java.lang.String r10 = "locationCountry"
            r4.putString(r10, r9)
            java.lang.String r9 = r1.getLatitude()
            int r10 = r9.length()
            if (r10 != 0) goto L_0x00a5
            r10 = r6
            goto L_0x00a6
        L_0x00a5:
            r10 = r7
        L_0x00a6:
            if (r10 == 0) goto L_0x00a9
            r9 = r8
        L_0x00a9:
            java.lang.String r10 = "locationLat"
            r4.putString(r10, r9)
            java.lang.String r9 = r1.getLongitude()
            int r10 = r9.length()
            if (r10 != 0) goto L_0x00ba
            r10 = r6
            goto L_0x00bb
        L_0x00ba:
            r10 = r7
        L_0x00bb:
            if (r10 == 0) goto L_0x00be
            r9 = r8
        L_0x00be:
            java.lang.String r10 = "locationLon"
            r4.putString(r10, r9)
            java.lang.String r1 = r1.getAddress()
            int r9 = r1.length()
            if (r9 != 0) goto L_0x00cf
            r9 = r6
            goto L_0x00d0
        L_0x00cf:
            r9 = r7
        L_0x00d0:
            if (r9 == 0) goto L_0x00d3
            r1 = r8
        L_0x00d3:
            java.lang.String r9 = "locationAddress"
            r4.putString(r9, r1)
            if (r18 == 0) goto L_0x00eb
            int r1 = r18.length()
            if (r1 <= 0) goto L_0x00e2
            r1 = r6
            goto L_0x00e3
        L_0x00e2:
            r1 = r7
        L_0x00e3:
            if (r1 == 0) goto L_0x00e8
            r1 = r18
            goto L_0x00e9
        L_0x00e8:
            r1 = r5
        L_0x00e9:
            if (r1 != 0) goto L_0x00ec
        L_0x00eb:
            r1 = r8
        L_0x00ec:
            java.lang.String r9 = "badgeType"
            r4.putString(r9, r1)
            if (r19 == 0) goto L_0x0103
            int r1 = r19.length()
            if (r1 <= 0) goto L_0x00fa
            goto L_0x00fb
        L_0x00fa:
            r6 = r7
        L_0x00fb:
            if (r6 == 0) goto L_0x00ff
            r5 = r19
        L_0x00ff:
            if (r5 != 0) goto L_0x0102
            goto L_0x0103
        L_0x0102:
            r8 = r5
        L_0x0103:
            java.lang.String r1 = "badgeValue"
            r4.putString(r1, r8)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r1 = r13
            r2.dispatchEvent(r3, r13, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.home.useraccount.tracking.UserAccountTracker.trackEvent(com.talabat.domain.address.Address, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static /* synthetic */ void trackNavigationOptionClick$default(UserAccountTracker userAccountTracker, String str, String str2, Address address, String str3, String str4, int i11, Object obj) {
        userAccountTracker.trackNavigationOptionClick(str, str2, address, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : str4);
    }

    public final void trackHelpCenterClick(@Nullable String str, @Nullable Address address) {
        a(this, address, "contact_option_clicked", str, "help_center", "Help", "", (String) null, (String) null, 192, (Object) null);
    }

    public final void trackNavigationOptionClick(@NotNull String str, @Nullable String str2, @Nullable Address address, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "navigationOption");
        trackEvent(address, "navigation_option_clicked", str2, BnplNavigationOptionLoadedEventKt.VALUE_SCREEN_TYPE_NAVIGATION_MENU, BnplNavigationOptionLoadedEventKt.VALUE_SCREEN_NAME_NAVIGATION, str, str3, str4);
    }
}
