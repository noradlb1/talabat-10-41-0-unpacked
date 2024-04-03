package com.talabat.darkstores.feature.checkout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.gson.Gson;
import com.integration.IntegrationGlobalDataModel;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.navigation.domain.screen.checkout.ExitPointData;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.verticalsSquad.VerticalsNavigatorActions;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/feature/checkout/DarkstoresEventListener;", "Lcom/talabat/darkstores/feature/checkout/DarkstoresListener;", "navigator", "Lcom/talabat/talabatnavigation/Navigator$Companion;", "integrationGlobalDataModel", "Lcom/integration/IntegrationGlobalDataModel$Companion;", "gson", "Lcom/google/gson/Gson;", "(Lcom/talabat/talabatnavigation/Navigator$Companion;Lcom/integration/IntegrationGlobalDataModel$Companion;Lcom/google/gson/Gson;)V", "onBackFromDSAfterDeepLink", "", "activity", "Landroid/app/Activity;", "onBackPressed", "onCheckout", "exitPointData", "Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointData;", "restaurant", "Ldatamodels/Restaurant;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresEventListener implements DarkstoresListener {
    @NotNull
    private final Gson gson;
    @NotNull
    private final IntegrationGlobalDataModel.Companion integrationGlobalDataModel;
    @NotNull
    private final Navigator.Companion navigator;

    public DarkstoresEventListener(@NotNull Navigator.Companion companion, @NotNull IntegrationGlobalDataModel.Companion companion2, @NotNull Gson gson2) {
        Intrinsics.checkNotNullParameter(companion, "navigator");
        Intrinsics.checkNotNullParameter(companion2, "integrationGlobalDataModel");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.navigator = companion;
        this.integrationGlobalDataModel = companion2;
        this.gson = gson2;
    }

    public void onBackFromDSAfterDeepLink(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.navigator.navigate((Context) activity, new NavigatorModel("talabat.action.homeScreen", (Bundle) null, DarkstoresEventListener$onBackFromDSAfterDeepLink$1.INSTANCE, 2, (DefaultConstructorMarker) null));
    }

    public void onBackPressed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.integrationGlobalDataModel.clearTalabatCart(activity);
    }

    public void onCheckout(@NotNull Activity activity, @Nullable ExitPointData exitPointData, @NotNull Restaurant restaurant) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(restaurant, "restaurant");
        Bundle bundle = new Bundle();
        Gson gson2 = this.gson;
        if (!(gson2 instanceof Gson)) {
            str = gson2.toJson((Object) exitPointData);
        } else {
            str = GsonInstrumentation.toJson(gson2, (Object) exitPointData);
        }
        bundle.putString(VerticalsNavigatorActions.EXTRA_VERTICALS_DARKSTORES_BRIDGE, str);
        Gson gson3 = this.gson;
        if (!(gson3 instanceof Gson)) {
            str2 = gson3.toJson((Object) restaurant);
        } else {
            str2 = GsonInstrumentation.toJson(gson3, (Object) restaurant);
        }
        bundle.putString(VerticalsNavigatorActions.EXTRA_VERTICALS_DARKSTORES_BRIDGE_RESTAURANT, str2);
        this.navigator.navigate((Context) activity, VerticalsNavigatorActions.Companion.createNavigatorModelForDarkstoresBridge(bundle));
    }
}
