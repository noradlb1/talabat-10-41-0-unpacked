package com.talabat.cuisines.navigation;

import androidx.appcompat.app.AppCompatActivity;
import com.talabat.talabatcommon.views.StartForResultExecutor;
import com.talabat.talabatcommon.views.StartForResultKt;
import datamodels.Cuisine;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a2\u0010\u0007\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"ACTION_OPEN_CUISINES_ACTIVITY", "", "ANALYTICS_SHOP_CATEGORY", "EXTRA_CUISINE", "EXTRA_IS_COLLECTION", "EXTRA_IS_PICKUP", "MULTIPLE_SELECTION", "startFragmentForResult", "Lcom/talabat/talabatcommon/views/StartForResultExecutor;", "Lkotlin/Pair;", "Ldatamodels/Cuisine;", "Landroidx/appcompat/app/AppCompatActivity;", "isCollection", "", "isPickup", "com_talabat_Components_cuisines_cuisines"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RouterKt {
    @NotNull
    private static final String ACTION_OPEN_CUISINES_ACTIVITY = "talabat.components.cuisines";
    @NotNull
    public static final String ANALYTICS_SHOP_CATEGORY = "ANALYTICS_SHOP_CATEGORY";
    @NotNull
    private static final String EXTRA_CUISINE = "EXTRA_CUISINE";
    @NotNull
    private static final String EXTRA_IS_COLLECTION = "isCollection";
    @NotNull
    private static final String EXTRA_IS_PICKUP = "isPickup";
    @NotNull
    private static final String MULTIPLE_SELECTION = "MULTIPLE_SELECTION";

    @NotNull
    public static final StartForResultExecutor<Pair<Cuisine, String>> startFragmentForResult(@NotNull AppCompatActivity appCompatActivity, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        return StartForResultKt.StartForResultBuilder(appCompatActivity, new RouterKt$startFragmentForResult$1(z11, z12));
    }
}
