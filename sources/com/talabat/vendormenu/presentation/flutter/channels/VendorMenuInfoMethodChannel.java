package com.talabat.vendormenu.presentation.flutter.channels;

import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.talabatcommon.extentions.GsonKt;
import com.talabat.talabatcommon.ports.dto.VendorBusyPopupCallArguments;
import com.talabat.talabatcore.logger.LogManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0002¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/channels/VendorMenuInfoMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "callback", "Lcom/talabat/vendormenu/presentation/flutter/channels/VendorMenuInfoMethodChannelCallBack;", "extractArgs", "T", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "clazz", "Ljava/lang/Class;", "(Lio/flutter/plugin/common/MethodCall;Ljava/lang/Class;)Ljava/lang/Object;", "onMethodCall", "", "call", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setCallback", "Companion", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorMenuInfoMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String GET_VENDOR_MENU_INFO = "getVendorMenuInfo";
    @NotNull
    private static final String SHOW_VENDOR_BUSY_POPUP = "navigateToVendorBusyScreen";
    @NotNull
    private static final String TAG = "VendorMenuInfoMethodChannel";
    private VendorMenuInfoMethodChannelCallBack callback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/channels/VendorMenuInfoMethodChannel$Companion;", "", "()V", "GET_VENDOR_MENU_INFO", "", "SHOW_VENDOR_BUSY_POPUP", "TAG", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final <T> T extractArgs(MethodCall methodCall, Class<T> cls) {
        Gson gson = GsonKt.getGson();
        String json$default = GsonKt.toJson$default(methodCall.arguments, (Gson) null, 1, (Object) null);
        return !(gson instanceof Gson) ? gson.fromJson(json$default, cls) : GsonInstrumentation.fromJson(gson, json$default, cls);
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        LogManager.debug("VendorMenuInfoMethodChannel onMethodCall: method: " + str);
        String str2 = methodCall.method;
        VendorMenuInfoMethodChannelCallBack vendorMenuInfoMethodChannelCallBack = null;
        if (Intrinsics.areEqual((Object) str2, (Object) GET_VENDOR_MENU_INFO)) {
            VendorMenuInfoMethodChannelCallBack vendorMenuInfoMethodChannelCallBack2 = this.callback;
            if (vendorMenuInfoMethodChannelCallBack2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
            } else {
                vendorMenuInfoMethodChannelCallBack = vendorMenuInfoMethodChannelCallBack2;
            }
            result.success(vendorMenuInfoMethodChannelCallBack.getVendorMenuInfo());
        } else if (Intrinsics.areEqual((Object) str2, (Object) SHOW_VENDOR_BUSY_POPUP)) {
            VendorBusyPopupCallArguments vendorBusyPopupCallArguments = (VendorBusyPopupCallArguments) extractArgs(methodCall, VendorBusyPopupCallArguments.class);
            VendorMenuInfoMethodChannelCallBack vendorMenuInfoMethodChannelCallBack3 = this.callback;
            if (vendorMenuInfoMethodChannelCallBack3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
            } else {
                vendorMenuInfoMethodChannelCallBack = vendorMenuInfoMethodChannelCallBack3;
            }
            vendorMenuInfoMethodChannelCallBack.showVendorBusyPopup(vendorBusyPopupCallArguments);
        }
    }

    public final void setCallback(@NotNull VendorMenuInfoMethodChannelCallBack vendorMenuInfoMethodChannelCallBack) {
        Intrinsics.checkNotNullParameter(vendorMenuInfoMethodChannelCallBack, "callback");
        this.callback = vendorMenuInfoMethodChannelCallBack;
    }
}
