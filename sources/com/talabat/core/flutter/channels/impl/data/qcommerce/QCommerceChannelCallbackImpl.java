package com.talabat.core.flutter.channels.impl.data.qcommerce;

import android.app.Activity;
import android.os.Bundle;
import buisnessmodels.Cart;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelCallback;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.checkout.ExitPointData;
import com.talabat.core.navigation.domain.screen.checkout.QCommerceCheckoutScreen;
import com.talabat.feature.darkstorescart.data.model.CartResponse;
import com.talabat.feature.darkstoresvendor.data.model.VendorResponse;
import com.talabat.talabatnavigation.verticalsSquad.VerticalsNavigatorActions;
import datamodels.Restaurant;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJB\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/qcommerce/QCommerceChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/qcommerce/QCommerceChannelCallback;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "nonMigratedCart", "Lbuisnessmodels/Cart;", "moshi", "Lcom/squareup/moshi/Moshi;", "gson", "Lcom/google/gson/Gson;", "(Lcom/talabat/core/navigation/domain/Navigator;Lbuisnessmodels/Cart;Lcom/squareup/moshi/Moshi;Lcom/google/gson/Gson;)V", "navigateToCheckout", "", "activity", "Landroid/app/Activity;", "vendorMap", "", "", "", "cartMap", "specialRequest", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QCommerceChannelCallbackImpl implements QCommerceChannelCallback {
    @NotNull
    private final Gson gson;
    @NotNull
    private final Moshi moshi;
    @NotNull
    private final Navigator navigator;
    @NotNull
    private final Cart nonMigratedCart;

    @Inject
    public QCommerceChannelCallbackImpl(@NotNull Navigator navigator2, @NotNull Cart cart, @NotNull Moshi moshi2, @NotNull @Named("LegacyUniversalGson") Gson gson2) {
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        Intrinsics.checkNotNullParameter(cart, "nonMigratedCart");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.navigator = navigator2;
        this.nonMigratedCart = cart;
        this.moshi = moshi2;
        this.gson = gson2;
    }

    public void navigateToCheckout(@NotNull Activity activity, @NotNull Map<String, ? extends Object> map, @NotNull Map<String, ? extends Object> map2, @Nullable String str) {
        Object obj;
        String str2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(map, "vendorMap");
        Intrinsics.checkNotNullParameter(map2, "cartMap");
        Class<Map> cls = Map.class;
        CartResponse fromJson = this.moshi.adapter(CartResponse.class).fromJson(this.moshi.adapter(cls).toJson(map2));
        if (fromJson != null) {
            JsonAdapter<VendorResponse> adapter = this.moshi.adapter(VendorResponse.class);
            JsonAdapter<Map> adapter2 = this.moshi.adapter(cls);
            Object obj2 = map.get("affordability_attributes");
            if (obj2 != null) {
                VendorResponse fromJson2 = adapter.fromJson(adapter2.toJson((Map) obj2));
                if (fromJson2 != null) {
                    JsonAdapter<Map> adapter3 = this.moshi.adapter(cls);
                    Object obj3 = map.get("vendor");
                    if (obj3 != null) {
                        Object obj4 = ((Map) obj3).get("result");
                        if (obj4 != null) {
                            String json = adapter3.toJson((Map) obj4);
                            Gson gson2 = this.gson;
                            Class cls2 = Restaurant.class;
                            if (!(gson2 instanceof Gson)) {
                                obj = gson2.fromJson(json, cls2);
                            } else {
                                obj = GsonInstrumentation.fromJson(gson2, json, cls2);
                            }
                            Restaurant restaurant = (Restaurant) obj;
                            ExitPointData access$getExitPointData = QCommerceChannelCallbackImplKt.getExitPointData(fromJson, fromJson2, str);
                            Bundle bundle = new Bundle();
                            Gson gson3 = this.gson;
                            if (!(gson3 instanceof Gson)) {
                                str2 = gson3.toJson((Object) access$getExitPointData);
                            } else {
                                str2 = GsonInstrumentation.toJson(gson3, (Object) access$getExitPointData);
                            }
                            bundle.putString(VerticalsNavigatorActions.EXTRA_VERTICALS_DARKSTORES_BRIDGE, str2);
                            bundle.putString(VerticalsNavigatorActions.EXTRA_VERTICALS_DARKSTORES_BRIDGE_RESTAURANT, json);
                            this.nonMigratedCart.clearCartFromDarkstores(activity);
                            this.nonMigratedCart.setRestaurant(restaurant, activity);
                            this.navigator.navigateTo(activity, new QCommerceCheckoutScreen((Void) null, 1, (DefaultConstructorMarker) null), new QCommerceChannelCallbackImpl$navigateToCheckout$1(bundle));
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                }
                throw new IllegalArgumentException("Unable to parse vendor");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        }
        throw new IllegalArgumentException("Unable to parse cart");
    }
}
