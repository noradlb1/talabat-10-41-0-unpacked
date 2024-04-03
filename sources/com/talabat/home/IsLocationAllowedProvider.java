package com.talabat.home;

import android.app.Activity;
import com.talabat.homemaphelper.CurrentLocationFetchRefactor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000*\u0001\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fR\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R,\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078F@FX\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/talabat/home/IsLocationAllowedProvider;", "", "()V", "NO_OP_ON_LOCATION_LISTENER", "com/talabat/home/IsLocationAllowedProvider$NO_OP_ON_LOCATION_LISTENER$1", "Lcom/talabat/home/IsLocationAllowedProvider$NO_OP_ON_LOCATION_LISTENER$1;", "value", "", "isLocationAllowedForUiTests", "()Ljava/lang/Boolean;", "setLocationAllowedForUiTests", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isLocationAllowed", "activity", "Landroid/app/Activity;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsLocationAllowedProvider {
    @NotNull
    public static final IsLocationAllowedProvider INSTANCE = new IsLocationAllowedProvider();
    @NotNull
    private static final IsLocationAllowedProvider$NO_OP_ON_LOCATION_LISTENER$1 NO_OP_ON_LOCATION_LISTENER = new IsLocationAllowedProvider$NO_OP_ON_LOCATION_LISTENER$1();
    @Nullable
    private static Boolean isLocationAllowedForUiTests;

    private IsLocationAllowedProvider() {
    }

    public final boolean isLocationAllowed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Boolean isLocationAllowedForUiTests2 = isLocationAllowedForUiTests();
        if (isLocationAllowedForUiTests2 != null) {
            return isLocationAllowedForUiTests2.booleanValue();
        }
        return new CurrentLocationFetchRefactor(activity, NO_OP_ON_LOCATION_LISTENER).userAllowedAllLocationPermissions(activity);
    }

    @Nullable
    public final Boolean isLocationAllowedForUiTests() {
        return null;
    }

    public final void setLocationAllowedForUiTests(@Nullable Boolean bool) {
        isLocationAllowedForUiTests = null;
    }
}
