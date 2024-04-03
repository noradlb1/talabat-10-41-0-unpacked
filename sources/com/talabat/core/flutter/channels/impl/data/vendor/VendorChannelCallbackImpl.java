package com.talabat.core.flutter.channels.impl.data.vendor;

import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.flutter.channels.domain.vendor.VendorChannelCallback;
import com.talabat.core.flutter.channels.impl.data.vendor.dto.FlutterRestaurantKt;
import com.talabat.core.flutter.channels.impl.data.vendor.dto.UpdateVendorCallArguments;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.extentions.GsonKt;
import datamodels.Restaurant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/vendor/VendorChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/vendor/VendorChannelCallback;", "()V", "getVendor", "", "", "", "updateVendor", "", "arguments", "Companion", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorChannelCallbackImpl implements VendorChannelCallback {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String GET_VENDOR_RESPONSE_BASE_URL_KEY = "baseUrl";
    @NotNull
    private static final String GET_VENDOR_RESPONSE_RESTAURANT_KEY = "restaurant";
    @NotNull
    private static final String GET_VENDOR_RESPONSE_RESULT_KEY = "result";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/vendor/VendorChannelCallbackImpl$Companion;", "", "()V", "GET_VENDOR_RESPONSE_BASE_URL_KEY", "", "GET_VENDOR_RESPONSE_RESTAURANT_KEY", "GET_VENDOR_RESPONSE_RESULT_KEY", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Nullable
    public Map<String, Object> getVendor() {
        Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
        if (restaurant == null) {
            return null;
        }
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to(GET_VENDOR_RESPONSE_BASE_URL_KEY, GlobalDataModel.imageBaseUrl), TuplesKt.to("result", MapsKt__MapsKt.mutableMapOf(TuplesKt.to("restaurant", FlutterRestaurantKt.toMap(restaurant)))));
    }

    public void updateVendor(@Nullable Object obj) {
        Object obj2;
        Boolean bool;
        Gson gson = GsonKt.getGson();
        String json$default = GsonKt.toJson$default(obj, (Gson) null, 1, (Object) null);
        Class cls = UpdateVendorCallArguments.class;
        if (!(gson instanceof Gson)) {
            obj2 = gson.fromJson(json$default, cls);
        } else {
            obj2 = GsonInstrumentation.fromJson(gson, json$default, cls);
        }
        UpdateVendorCallArguments updateVendorCallArguments = (UpdateVendorCallArguments) obj2;
        Restaurant restaurant = updateVendorCallArguments.getResult().restaurant;
        Restaurant restaurant2 = GlobalDataModel.SELECTED.getRestaurant();
        if (restaurant2 == null || (bool = restaurant2.isPickup()) == null) {
            bool = Boolean.FALSE;
        }
        restaurant.setPickup(bool);
        GlobalDataModel.SELECTED.updateRestaurant(updateVendorCallArguments.getResult().restaurant);
    }
}
