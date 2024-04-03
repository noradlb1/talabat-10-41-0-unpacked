package com.talabat.feature.bnpldashboard.presentation.channel;

import androidx.core.app.NotificationCompat;
import com.talabat.feature.bnpldashboard.presentation.BNPLDashboardChannelCallback;
import com.talabat.talabatcommon.extentions.IntKt;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/bnpldashboard/presentation/channel/BNPLDashboardMethodCallHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "eventOrigin", "", "callback", "Lcom/talabat/feature/bnpldashboard/presentation/BNPLDashboardChannelCallback;", "(Ljava/lang/String;Lcom/talabat/feature/bnpldashboard/presentation/BNPLDashboardChannelCallback;)V", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "com_talabat_feature_bnpl-dashboard_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLDashboardMethodCallHandler implements MethodChannel.MethodCallHandler {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    private static final String OPEN_HELP_CENTER_SCREEN = "openHelpCenter";
    @NotNull
    @Deprecated
    private static final String OPEN_ORDER_DETAILS_SCREEN = "openOrderDetails";
    @NotNull
    @Deprecated
    private static final String SOURCE_PAGE = "sourcePageType";
    @NotNull
    private final BNPLDashboardChannelCallback callback;
    @NotNull
    private final String eventOrigin;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/bnpldashboard/presentation/channel/BNPLDashboardMethodCallHandler$Companion;", "", "()V", "OPEN_HELP_CENTER_SCREEN", "", "OPEN_ORDER_DETAILS_SCREEN", "SOURCE_PAGE", "com_talabat_feature_bnpl-dashboard_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public BNPLDashboardMethodCallHandler(@NotNull String str, @NotNull BNPLDashboardChannelCallback bNPLDashboardChannelCallback) {
        Intrinsics.checkNotNullParameter(str, "eventOrigin");
        Intrinsics.checkNotNullParameter(bNPLDashboardChannelCallback, "callback");
        this.eventOrigin = str;
        this.callback = bNPLDashboardChannelCallback;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -504035420) {
                if (hashCode != -279936800) {
                    if (hashCode == 1388063358 && str.equals(OPEN_ORDER_DETAILS_SCREEN)) {
                        Object argument = methodCall.argument("encryptedOrderId");
                        Intrinsics.checkNotNull(argument);
                        this.callback.navigateToOrderDetailScreen((String) argument);
                    }
                } else if (str.equals(OPEN_HELP_CENTER_SCREEN)) {
                    this.callback.navigateToHelpCenter(IntKt.orZero((Integer) methodCall.argument("orderId")));
                }
            } else if (str.equals(SOURCE_PAGE)) {
                result.success(this.eventOrigin);
            }
        }
    }
}
