package com.talabat.core.flutter.channels.impl.data.vendormenuinfo;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.flutter.channels.domain.vendormenuinfo.VendorMenuInfoChannelCallback;
import com.talabat.core.navigation.domain.screen.menu.MenuScreen;
import com.talabat.talabatcommon.extentions.GsonKt;
import com.talabat.talabatcommon.ports.VendorMenuFlutterNavigatorPort;
import com.talabat.talabatcommon.ports.VendorMenuIntegratorKt;
import com.talabat.talabatcommon.ports.dto.VendorBusyPopupCallArguments;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0019\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010\u0007J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/vendormenuinfo/VendorMenuInfoChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/vendormenuinfo/VendorMenuInfoChannelCallback;", "()V", "getBranchId", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)Ljava/lang/Integer;", "getDeliveryMode", "", "getItemId", "getShopClickOrigin", "getVendorMenuInfo", "", "", "showVendorBusyPopup", "", "arguments", "activity", "Landroid/app/Activity;", "Companion", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorMenuInfoChannelCallbackImpl implements VendorMenuInfoChannelCallback {
    @NotNull
    private static final String BRANCH_ID_KEY = "branchId";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String SHOP_CLICK_ORIGIN_KEY = "shopClickOrigin";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/vendormenuinfo/VendorMenuInfoChannelCallbackImpl$Companion;", "", "()V", "BRANCH_ID_KEY", "", "SHOP_CLICK_ORIGIN_KEY", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final Integer getBranchId(Intent intent) {
        Integer num;
        MenuScreen.MenuData menuData;
        if (intent == null || (menuData = (MenuScreen.MenuData) intent.getParcelableExtra("navigatorData")) == null) {
            num = null;
        } else {
            num = Integer.valueOf(menuData.getBranchId());
        }
        boolean z11 = false;
        if (intent != null && intent.hasExtra("branchId")) {
            z11 = true;
        }
        if (z11) {
            return Integer.valueOf(intent.getIntExtra("branchId", -1));
        }
        return num;
    }

    private final String getDeliveryMode(Intent intent) {
        String str;
        MenuScreen.MenuData menuData;
        if (intent == null || (menuData = (MenuScreen.MenuData) intent.getParcelableExtra("navigatorData")) == null) {
            str = null;
        } else {
            str = menuData.getDeliveryMode();
        }
        boolean z11 = false;
        if (intent != null && intent.hasExtra("deliveryMode")) {
            z11 = true;
        }
        if (z11) {
            return intent.getStringExtra("deliveryMode");
        }
        return str;
    }

    private final Integer getItemId(Intent intent) {
        Integer num;
        MenuScreen.MenuData menuData;
        if (intent == null || (menuData = (MenuScreen.MenuData) intent.getParcelableExtra("navigatorData")) == null) {
            num = null;
        } else {
            num = Integer.valueOf(menuData.getItemId());
        }
        boolean z11 = false;
        if (intent != null && intent.hasExtra("itemId")) {
            z11 = true;
        }
        if (z11) {
            return Integer.valueOf(intent.getIntExtra("itemId", -1));
        }
        return num;
    }

    private final String getShopClickOrigin(Intent intent) {
        String str;
        MenuScreen.MenuData menuData;
        if (intent == null || (menuData = (MenuScreen.MenuData) intent.getParcelableExtra("navigatorData")) == null) {
            str = null;
        } else {
            str = menuData.getShopClickOrigin();
        }
        boolean z11 = false;
        if (intent != null && intent.hasExtra("shopClickOrigin")) {
            z11 = true;
        }
        if (z11) {
            return intent.getStringExtra("shopClickOrigin");
        }
        return str;
    }

    @NotNull
    public Map<String, Object> getVendorMenuInfo(@Nullable Intent intent) {
        return MapsKt__MapsKt.mapOf(TuplesKt.to("shopClickOrigin", getShopClickOrigin(intent)), TuplesKt.to("branchId", getBranchId(intent)), TuplesKt.to("itemId", getItemId(intent)), TuplesKt.to("deliveryMode", getDeliveryMode(intent)));
    }

    public void showVendorBusyPopup(@Nullable Object obj, @Nullable Activity activity) {
        Object obj2;
        VendorMenuFlutterNavigatorPort vendorMenuNavigator;
        Gson gson = GsonKt.getGson();
        String json$default = GsonKt.toJson$default(obj, (Gson) null, 1, (Object) null);
        Class cls = VendorBusyPopupCallArguments.class;
        if (!(gson instanceof Gson)) {
            obj2 = gson.fromJson(json$default, cls);
        } else {
            obj2 = GsonInstrumentation.fromJson(gson, json$default, cls);
        }
        VendorBusyPopupCallArguments vendorBusyPopupCallArguments = (VendorBusyPopupCallArguments) obj2;
        if (activity != null && (vendorMenuNavigator = VendorMenuIntegratorKt.getVendorMenuNavigator()) != null) {
            Intrinsics.checkNotNullExpressionValue(vendorBusyPopupCallArguments, StepData.ARGS);
            vendorMenuNavigator.navigateToBusyBottomSheet((FragmentActivity) activity, vendorBusyPopupCallArguments);
        }
    }
}
