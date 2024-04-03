package com.talabat.vendormenu.presentation.flutter.channels;

import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.talabatcommon.extentions.GsonKt;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.vendormenu.presentation.flutter.dto.UpdateProStatusArguments;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/channels/TalabatProMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "callback", "Lcom/talabat/vendormenu/presentation/flutter/channels/TalabatProMethodChannelCallback;", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setCallback", "Companion", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatProMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String GET_CONFIGS = "configs";
    @NotNull
    private static final String TAG = "TalabatProMethodChannel";
    @NotNull
    private static final String UPDATE_PRO_STATUS = "updateProStatus";
    private TalabatProMethodChannelCallback callback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/channels/TalabatProMethodChannel$Companion;", "", "()V", "GET_CONFIGS", "", "TAG", "UPDATE_PRO_STATUS", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Object obj;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        LogManager.debug("TalabatProMethodChannel onMethodCall: method: " + str);
        String str2 = methodCall.method;
        TalabatProMethodChannelCallback talabatProMethodChannelCallback = null;
        if (Intrinsics.areEqual((Object) str2, (Object) GET_CONFIGS)) {
            TalabatProMethodChannelCallback talabatProMethodChannelCallback2 = this.callback;
            if (talabatProMethodChannelCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
            } else {
                talabatProMethodChannelCallback = talabatProMethodChannelCallback2;
            }
            talabatProMethodChannelCallback.getTalabatProConfigs(new TalabatProMethodChannel$onMethodCall$1(result));
        } else if (Intrinsics.areEqual((Object) str2, (Object) UPDATE_PRO_STATUS)) {
            Gson gson = GsonKt.getGson();
            String json$default = GsonKt.toJson$default(methodCall.arguments, (Gson) null, 1, (Object) null);
            Class cls = UpdateProStatusArguments.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(json$default, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, json$default, cls);
            }
            int countryId = ((UpdateProStatusArguments) obj).getCountryId();
            TalabatProMethodChannelCallback talabatProMethodChannelCallback3 = this.callback;
            if (talabatProMethodChannelCallback3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
            } else {
                talabatProMethodChannelCallback = talabatProMethodChannelCallback3;
            }
            talabatProMethodChannelCallback.updateProStatus(countryId);
        }
    }

    public final void setCallback(@NotNull TalabatProMethodChannelCallback talabatProMethodChannelCallback) {
        Intrinsics.checkNotNullParameter(talabatProMethodChannelCallback, "callback");
        this.callback = talabatProMethodChannelCallback;
    }
}
