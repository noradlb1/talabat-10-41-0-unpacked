package com.talabat.vendormenu.presentation.flutter.channels;

import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.extentions.GsonKt;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.vendormenu.presentation.flutter.data.FlutterMenuKt;
import com.talabat.vendormenu.presentation.flutter.dto.UpdateVendorMenuCallArguments;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0002¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/channels/VendorMenuMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "callback", "Lcom/talabat/vendormenu/presentation/flutter/channels/VendorMenuMethodChannelCallback;", "extractArgs", "T", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "clazz", "Ljava/lang/Class;", "(Lio/flutter/plugin/common/MethodCall;Ljava/lang/Class;)Ljava/lang/Object;", "getVendorMenu", "", "", "", "onMethodCall", "", "call", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setCallback", "Companion", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorMenuMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String GET_MENU = "getVendorMenu";
    @NotNull
    private static final String GET_MENU_RESPONSE_KEY = "menu";
    @NotNull
    private static final String GET_MENU_RESULT_KEY = "result";
    @NotNull
    private static final String TAG = "VendorMenuMethodChannel";
    @NotNull
    private static final String UPDATE_VENDOR_MENU = "updateVendorMenu";
    @Nullable
    private VendorMenuMethodChannelCallback callback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/channels/VendorMenuMethodChannel$Companion;", "", "()V", "GET_MENU", "", "GET_MENU_RESPONSE_KEY", "GET_MENU_RESULT_KEY", "TAG", "UPDATE_VENDOR_MENU", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    private final Map<String, Object> getVendorMenu() {
        MenuItemRM menuItemRM;
        VendorMenuMethodChannelCallback vendorMenuMethodChannelCallback = this.callback;
        Map<String, Object> map = null;
        if (vendorMenuMethodChannelCallback == null) {
            MenuItemsResponseModel menuItemsResponseModel = GlobalDataModel.JSON.menuItemsResponseModel;
            if (menuItemsResponseModel != null) {
                menuItemRM = menuItemsResponseModel.menu;
            } else {
                menuItemRM = null;
            }
            Pair[] pairArr = new Pair[1];
            if (menuItemRM != null) {
                map = FlutterMenuKt.toMap(menuItemRM);
            }
            pairArr[0] = TuplesKt.to("menu", map);
            return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result", MapsKt__MapsKt.mutableMapOf(pairArr)));
        } else if (vendorMenuMethodChannelCallback != null) {
            return vendorMenuMethodChannelCallback.getVendorMenu();
        } else {
            return null;
        }
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        LogManager.debug("VendorMenuMethodChannel onMethodCall: method: " + str);
        String str2 = methodCall.method;
        if (Intrinsics.areEqual((Object) str2, (Object) GET_MENU)) {
            result.success(getVendorMenu());
        } else if (Intrinsics.areEqual((Object) str2, (Object) UPDATE_VENDOR_MENU)) {
            GlobalDataModel.JSON.menuItemsResponseModel = ((UpdateVendorMenuCallArguments) extractArgs(methodCall, UpdateVendorMenuCallArguments.class)).getResult();
        }
    }

    public final void setCallback(@NotNull VendorMenuMethodChannelCallback vendorMenuMethodChannelCallback) {
        Intrinsics.checkNotNullParameter(vendorMenuMethodChannelCallback, "callback");
        this.callback = vendorMenuMethodChannelCallback;
    }
}
