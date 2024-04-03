package com.integration.tLife;

import android.content.Context;
import android.os.Bundle;
import com.talabat.feature.subscriptions.data.tracking.events.TProEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.gtm.GTMTLife;
import tracking.gtm.TalabatFirebase;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/integration/tLife/IntegrationAppTrackerTLifeSubscriptions;", "", "()V", "onTLifeSubscriptionCompleted", "", "subscriptionType", "", "subscriptionEndDate", "subscriptionStartDate", "onTLifeSubscriptionFailed", "subscriptionTier", "errorMessage", "com_talabat_NewArchi_TalabatIntegration_TalabatIntegration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IntegrationAppTrackerTLifeSubscriptions {
    @NotNull
    public static final IntegrationAppTrackerTLifeSubscriptions INSTANCE = new IntegrationAppTrackerTLifeSubscriptions();

    private IntegrationAppTrackerTLifeSubscriptions() {
    }

    public final void onTLifeSubscriptionCompleted(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str4, "subscriptionType");
        Intrinsics.checkNotNullParameter(str5, "subscriptionEndDate");
        Intrinsics.checkNotNullParameter(str6, "subscriptionStartDate");
        Bundle createBasicBundle$default = GTMTLife.Companion.createBasicBundle$default(GTMTLife.Companion, "SubscriptionResultScreen", (String) null, 2, (Object) null);
        createBasicBundle$default.putString("subscriptionType", str4);
        createBasicBundle$default.putString("subscriptionEndDate", str5);
        createBasicBundle$default.putString("subscriptionStartDate", str6);
        TalabatFirebase.Companion.dispatchEvent$default(TalabatFirebase.Companion, (Context) null, TProEvent.NAME_SUBSCRIPTION_COMPLETED, createBasicBundle$default, 1, (Object) null);
    }

    public final void onTLifeSubscriptionFailed(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str4, "subscriptionType");
        Intrinsics.checkNotNullParameter(str5, "subscriptionTier");
        Intrinsics.checkNotNullParameter(str6, "errorMessage");
        Bundle createBasicBundle$default = GTMTLife.Companion.createBasicBundle$default(GTMTLife.Companion, "subscriptionBottomSheetScreen", (String) null, 2, (Object) null);
        createBasicBundle$default.putString("subscriptionType", str4);
        createBasicBundle$default.putString("subscriptionTier", str5);
        createBasicBundle$default.putString("errorMessage", str6);
        TalabatFirebase.Companion.dispatchEvent$default(TalabatFirebase.Companion, (Context) null, TProEvent.NAME_SUBSCRIPTION_FAILED, createBasicBundle$default, 1, (Object) null);
    }
}
