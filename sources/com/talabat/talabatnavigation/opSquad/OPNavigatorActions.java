package com.talabat.talabatnavigation.opSquad;

import android.os.Bundle;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.base.NavigatorModelForResult;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatnavigation/opSquad/OPNavigatorActions;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPNavigatorActions {
    @NotNull
    public static final String ARG_BRANCH_ID = "branch_id";
    @NotNull
    public static final String ARG_DELIVERY_MODE = "deliveryMode";
    @NotNull
    public static final String ARG_GRL_SHOP = "grl_shop";
    @NotNull
    public static final String ARG_IS_DARK_STORE = "dark_store";
    @NotNull
    public static final String ARG_IS_MIGRATED = "is_migrated";
    @NotNull
    public static final String ARG_ITEM_ID = "itemId";
    @NotNull
    public static final String ARG_SEARCH_TERM = "searchSearchTerm";
    @NotNull
    public static final String ARG_SHOP_TYPE = "shop_type";
    @NotNull
    public static final String ARG_SHOULD_SUPPRESS_VENDOR_STATUS_ALERT = "should_suppress_vendor_status_alert";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String OPEN_MENU = "com.talabat.menu.bridgeactivity";
    public static final int OPEN_MENU_REQUEST_CODE = 123;
    @NotNull
    public static final String PICKUP_DELIVERY_MODE = "pickup";
    @NotNull
    public static final String RIDER_DELIVERY_MODE = "rider";

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JV\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0013H\u0002JP\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0013H\u0007JT\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00132\u0006\u0010\"\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/talabat/talabatnavigation/opSquad/OPNavigatorActions$Companion;", "", "()V", "ARG_BRANCH_ID", "", "ARG_DELIVERY_MODE", "ARG_GRL_SHOP", "ARG_IS_DARK_STORE", "ARG_IS_MIGRATED", "ARG_ITEM_ID", "ARG_SEARCH_TERM", "ARG_SHOP_TYPE", "ARG_SHOULD_SUPPRESS_VENDOR_STATUS_ALERT", "OPEN_MENU", "OPEN_MENU_REQUEST_CODE", "", "PICKUP_DELIVERY_MODE", "RIDER_DELIVERY_MODE", "createMenuBridgeActivityOptions", "Landroid/os/Bundle;", "deliveryMode", "branchId", "verticalType", "grlEnabled", "", "isDarkStore", "isMigrated", "shouldSuppressVendorStatusAlert", "itemId", "bundle", "createNavigatorModelForMenuBridgeActivity", "Lcom/talabat/talabatnavigation/base/NavigatorModel;", "createNavigatorModelForResultForMenuBridgeActivity", "Lcom/talabat/talabatnavigation/base/NavigatorModelForResult;", "isPickup", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Bundle createMenuBridgeActivityOptions(String str, int i11, int i12, boolean z11, boolean z12, boolean z13, boolean z14, String str2, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt(OPNavigatorActions.ARG_BRANCH_ID, i11);
            bundle2.putInt(OPNavigatorActions.ARG_SHOP_TYPE, i12);
            bundle2.putBoolean(OPNavigatorActions.ARG_IS_DARK_STORE, z12);
            bundle2.putBoolean(OPNavigatorActions.ARG_GRL_SHOP, z11);
            bundle2.putBoolean(OPNavigatorActions.ARG_IS_MIGRATED, z13);
            bundle2.putBoolean(OPNavigatorActions.ARG_SHOULD_SUPPRESS_VENDOR_STATUS_ALERT, z14);
            bundle2.putString("deliveryMode", str);
            if (z12 || z13) {
                bundle2.putString("itemId", str2);
            } else if (new Regex("-?\\d+(\\.\\d+)?").matches(str2)) {
                bundle2.putInt("itemId", Integer.parseInt(str2));
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            return bundle2;
        }

        public static /* synthetic */ NavigatorModel createNavigatorModelForMenuBridgeActivity$default(Companion companion, int i11, int i12, boolean z11, boolean z12, boolean z13, boolean z14, String str, Bundle bundle, int i13, Object obj) {
            boolean z15;
            String str2;
            Bundle bundle2;
            int i14 = i13;
            if ((i14 & 32) != 0) {
                z15 = false;
            } else {
                z15 = z14;
            }
            if ((i14 & 64) != 0) {
                str2 = "";
            } else {
                str2 = str;
            }
            if ((i14 & 128) != 0) {
                bundle2 = null;
            } else {
                bundle2 = bundle;
            }
            return companion.createNavigatorModelForMenuBridgeActivity(i11, i12, z11, z12, z13, z15, str2, bundle2);
        }

        public static /* synthetic */ NavigatorModelForResult createNavigatorModelForResultForMenuBridgeActivity$default(Companion companion, int i11, int i12, boolean z11, boolean z12, boolean z13, boolean z14, String str, Bundle bundle, boolean z15, int i13, Object obj) {
            String str2;
            Bundle bundle2;
            int i14 = i13;
            if ((i14 & 64) != 0) {
                str2 = "";
            } else {
                str2 = str;
            }
            if ((i14 & 128) != 0) {
                bundle2 = null;
            } else {
                bundle2 = bundle;
            }
            return companion.createNavigatorModelForResultForMenuBridgeActivity(i11, i12, z11, z12, z13, z14, str2, bundle2, z15);
        }

        @NotNull
        @JvmOverloads
        public final NavigatorModel createNavigatorModelForMenuBridgeActivity(int i11, int i12, boolean z11, boolean z12, boolean z13) {
            return createNavigatorModelForMenuBridgeActivity$default(this, i11, i12, z11, z12, z13, false, (String) null, (Bundle) null, 224, (Object) null);
        }

        @NotNull
        @JvmOverloads
        public final NavigatorModel createNavigatorModelForMenuBridgeActivity(int i11, int i12, boolean z11, boolean z12, boolean z13, boolean z14) {
            return createNavigatorModelForMenuBridgeActivity$default(this, i11, i12, z11, z12, z13, z14, (String) null, (Bundle) null, 192, (Object) null);
        }

        @NotNull
        @JvmOverloads
        public final NavigatorModel createNavigatorModelForMenuBridgeActivity(int i11, int i12, boolean z11, boolean z12, boolean z13, boolean z14, @NotNull String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "itemId");
            return createNavigatorModelForMenuBridgeActivity$default(this, i11, i12, z11, z12, z13, z14, str2, (Bundle) null, 128, (Object) null);
        }

        @NotNull
        @JvmOverloads
        public final NavigatorModel createNavigatorModelForMenuBridgeActivity(int i11, int i12, boolean z11, boolean z12, boolean z13, boolean z14, @NotNull String str, @Nullable Bundle bundle) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "itemId");
            return new NavigatorModel(OPNavigatorActions.OPEN_MENU, createMenuBridgeActivityOptions("rider", i11, i12, z11, z12, z13, z14, str2, bundle), (Function1) null, 4, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final NavigatorModelForResult createNavigatorModelForResultForMenuBridgeActivity(int i11, int i12, boolean z11, boolean z12, boolean z13, boolean z14, @NotNull String str, @Nullable Bundle bundle, boolean z15) {
            String str2;
            Intrinsics.checkNotNullParameter(str, "itemId");
            if (z15) {
                str2 = "pickup";
            } else {
                str2 = "rider";
            }
            return new NavigatorModelForResult(OPNavigatorActions.OPEN_MENU, createMenuBridgeActivityOptions(str2, i11, i12, z11, z12, z13, z14, str, bundle), (Function1) null, 123, 4, (DefaultConstructorMarker) null);
        }
    }
}
