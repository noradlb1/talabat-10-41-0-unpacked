package com.talabat.talabatnavigation.sdsquad;

import android.os.Bundle;
import com.talabat.talabatnavigation.base.NavigatorModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatnavigation/sdsquad/SdSquadActions;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SdSquadActions {
    @NotNull
    public static final String ACTION_FLUTTER_COLLECTION_ACTIVITY = "com.talabat.CollectionFlutterActivity";
    @NotNull
    public static final String ACTION_FLUTTER_SEARCH_ACTIVITY = "com.talabat.VendorListSearchFlutterActivity";
    @NotNull
    public static final String ACTION_GROCERY_HOME_SCREEN = "com.talabat.GroceryHomeFlutterActivity";
    @NotNull
    public static final String ACTION_SDSQUAD_LISTING_SCREEN = "talabat.action.SQSquad.vendorList";
    @NotNull
    public static final String ACTION_SEARCH_ACTIVITY = "talabat.action.RestaurantsSearchActivity";
    @NotNull
    public static final String ARG_AREA_ID = "areaId";
    @NotNull
    public static final String ARG_AREA_NAME = "areaName";
    @NotNull
    public static final String ARG_CHANNEL = "channel";
    @NotNull
    public static final String ARG_CITY_ID = "cityId";
    @NotNull
    public static final String ARG_COUNTRY_ID = "countryId";
    @NotNull
    public static final String ARG_DEEPLINK = "deeplink";
    @NotNull
    public static final String ARG_FROM = "from";
    @NotNull
    public static final String ARG_TILE_ID = "tileId";
    @NotNull
    public static final String ARG_VERTICAL_IDS = "verticalIds";
    @NotNull
    public static final String ARG_VERTICAL_NAME = "verticalName";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_LATITUDE = "latitude";
    @NotNull
    public static final String EXTRA_LONGITUDE = "longitude";

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J6\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/talabat/talabatnavigation/sdsquad/SdSquadActions$Companion;", "", "()V", "ACTION_FLUTTER_COLLECTION_ACTIVITY", "", "ACTION_FLUTTER_SEARCH_ACTIVITY", "ACTION_GROCERY_HOME_SCREEN", "ACTION_SDSQUAD_LISTING_SCREEN", "ACTION_SEARCH_ACTIVITY", "ARG_AREA_ID", "ARG_AREA_NAME", "ARG_CHANNEL", "ARG_CITY_ID", "ARG_COUNTRY_ID", "ARG_DEEPLINK", "ARG_FROM", "ARG_TILE_ID", "ARG_VERTICAL_IDS", "ARG_VERTICAL_NAME", "EXTRA_LATITUDE", "EXTRA_LONGITUDE", "createNavigatorModelForGroceryHomeScreen", "Lcom/talabat/talabatnavigation/base/NavigatorModel;", "tileId", "", "verticalName", "verticalIds", "", "deeplinkBundle", "Landroid/os/Bundle;", "createNavigatorModelForListingScreen", "latitude", "longitude", "areaId", "cityId", "countryId", "areaName", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavigatorModel createNavigatorModelForGroceryHomeScreen$default(Companion companion, int i11, String str, List list, Bundle bundle, int i12, Object obj) {
            if ((i12 & 8) != 0) {
                bundle = null;
            }
            return companion.createNavigatorModelForGroceryHomeScreen(i11, str, list, bundle);
        }

        @NotNull
        @JvmOverloads
        public final NavigatorModel createNavigatorModelForGroceryHomeScreen(int i11, @NotNull String str, @NotNull List<Integer> list) {
            Intrinsics.checkNotNullParameter(str, "verticalName");
            Intrinsics.checkNotNullParameter(list, "verticalIds");
            return createNavigatorModelForGroceryHomeScreen$default(this, i11, str, list, (Bundle) null, 8, (Object) null);
        }

        @NotNull
        @JvmOverloads
        public final NavigatorModel createNavigatorModelForGroceryHomeScreen(int i11, @NotNull String str, @NotNull List<Integer> list, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(str, "verticalName");
            Intrinsics.checkNotNullParameter(list, "verticalIds");
            Bundle bundle2 = new Bundle();
            bundle2.putInt(SdSquadActions.ARG_TILE_ID, i11);
            bundle2.putString("verticalName", str);
            bundle2.putIntegerArrayList("verticalIds", new ArrayList(list));
            if (bundle != null) {
                bundle2.putBundle("deeplink", bundle);
            }
            return new NavigatorModel(SdSquadActions.ACTION_GROCERY_HOME_SCREEN, bundle2, (Function1) null, 4, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final NavigatorModel createNavigatorModelForListingScreen(@NotNull String str, @NotNull String str2, int i11, int i12, int i13, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "latitude");
            Intrinsics.checkNotNullParameter(str2, "longitude");
            Intrinsics.checkNotNullParameter(str3, "areaName");
            Bundle bundle = new Bundle();
            bundle.putString("latitude", str);
            bundle.putString("longitude", str2);
            bundle.putInt("areaId", i11);
            bundle.putInt("cityId", i12);
            bundle.putInt("countryId", i13);
            bundle.putString("areaName", str3);
            return new NavigatorModel(SdSquadActions.ACTION_SDSQUAD_LISTING_SCREEN, bundle, (Function1) null, 4, (DefaultConstructorMarker) null);
        }
    }
}
