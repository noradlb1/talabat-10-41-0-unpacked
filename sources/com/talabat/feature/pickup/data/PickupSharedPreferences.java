package com.talabat.feature.pickup.data;

import android.content.SharedPreferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/pickup/data/PickupSharedPreferences;", "", "prefs", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "value", "", "pickupVlScreenVisits", "getPickupVlScreenVisits", "()I", "setPickupVlScreenVisits", "(I)V", "", "userPlacedHisFirstOrder", "getUserPlacedHisFirstOrder", "()Z", "setUserPlacedHisFirstOrder", "(Z)V", "valuePropBannerVisits", "getValuePropBannerVisits", "setValuePropBannerVisits", "Companion", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupSharedPreferences {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String PICKUP_FIRST_ORDER_PLACED = "pickup_first_order_placed";
    @NotNull
    public static final String PICKUP_VL_SCREEN_VISITS = "pickup_vl_screen_visits";
    @NotNull
    public static final String PREFS_KEY = "pickup_prefs";
    @NotNull
    public static final String VALUE_PROP_BANNER_VISITS = "value_prop_banner_visits";
    @NotNull
    private final SharedPreferences prefs;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/feature/pickup/data/PickupSharedPreferences$Companion;", "", "()V", "PICKUP_FIRST_ORDER_PLACED", "", "PICKUP_VL_SCREEN_VISITS", "PREFS_KEY", "VALUE_PROP_BANNER_VISITS", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public PickupSharedPreferences(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "prefs");
        this.prefs = sharedPreferences;
    }

    public final int getPickupVlScreenVisits() {
        return this.prefs.getInt(PICKUP_VL_SCREEN_VISITS, 0);
    }

    public final boolean getUserPlacedHisFirstOrder() {
        return this.prefs.getBoolean(PICKUP_FIRST_ORDER_PLACED, false);
    }

    public final int getValuePropBannerVisits() {
        return this.prefs.getInt(VALUE_PROP_BANNER_VISITS, 0);
    }

    public final void setPickupVlScreenVisits(int i11) {
        this.prefs.edit().putInt(PICKUP_VL_SCREEN_VISITS, i11).apply();
    }

    public final void setUserPlacedHisFirstOrder(boolean z11) {
        this.prefs.edit().putBoolean(PICKUP_FIRST_ORDER_PLACED, z11).apply();
    }

    public final void setValuePropBannerVisits(int i11) {
        this.prefs.edit().putInt(VALUE_PROP_BANNER_VISITS, i11).apply();
    }
}
