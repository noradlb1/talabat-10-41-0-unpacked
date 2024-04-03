package com.talabat.vendormenu.presentation.flutter.channels;

import androidx.core.app.NotificationCompat;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.vendormenu.presentation.flutter.PlumbingWork;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/channels/VendorInfoMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "callback", "Lcom/talabat/vendormenu/presentation/flutter/channels/VendorInfoMethodChannelCallback;", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setCallback", "Companion", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PlumbingWork
public final class VendorInfoMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String GET_BRANCH_ID = "getBranchId";
    @NotNull
    private static final String TAG = "VendorInfoMethodChannel";
    private VendorInfoMethodChannelCallback callback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/channels/VendorInfoMethodChannel$Companion;", "", "()V", "GET_BRANCH_ID", "", "TAG", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        LogManager.debug("VendorInfoMethodChannel onMethodCall: method: " + str);
        if (Intrinsics.areEqual((Object) methodCall.method, (Object) GET_BRANCH_ID)) {
            VendorInfoMethodChannelCallback vendorInfoMethodChannelCallback = this.callback;
            if (vendorInfoMethodChannelCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
                vendorInfoMethodChannelCallback = null;
            }
            result.success(vendorInfoMethodChannelCallback.getBranchId());
        }
    }

    public final void setCallback(@NotNull VendorInfoMethodChannelCallback vendorInfoMethodChannelCallback) {
        Intrinsics.checkNotNullParameter(vendorInfoMethodChannelCallback, "callback");
        this.callback = vendorInfoMethodChannelCallback;
    }
}
