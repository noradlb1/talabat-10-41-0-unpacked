package com.talabat.talabatnavigation.tpro;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"EXTRA_SUBSCRIPTION_MEMBER_ID", "", "OPEN_TPRO_BENEFITS_ACTIVITY", "OPEN_TPRO_SUBSCRIPTION_DETAILS_ACTIVITY", "navigateToBenefitsActivity", "", "activity", "Landroid/app/Activity;", "Lcom/talabat/talabatnavigation/Navigator$Companion;", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TproNavigatorActionsKt {
    @NotNull
    public static final String EXTRA_SUBSCRIPTION_MEMBER_ID = "subscriptionMemberId";
    @NotNull
    public static final String OPEN_TPRO_BENEFITS_ACTIVITY = "talabat.action.tpro.benefitsActivity";
    @NotNull
    public static final String OPEN_TPRO_SUBSCRIPTION_DETAILS_ACTIVITY = "talabat.action.tpro.subscriptionDetailsActivity";

    public static final void navigateToBenefitsActivity(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        navigateToBenefitsActivity(Navigator.Companion, activity);
    }

    public static final void navigateToBenefitsActivity(@NotNull Navigator.Companion companion, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        companion.navigate((Context) activity, new NavigatorModel(OPEN_TPRO_BENEFITS_ACTIVITY, new Bundle(), (Function1) null, 4, (DefaultConstructorMarker) null));
    }
}
