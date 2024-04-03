package com.talabat.feature.referafriend.presentation.channel;

import androidx.core.app.NotificationCompat;
import com.visa.checkout.PurchaseInfo;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/feature/referafriend/presentation/channel/ReferAFriendMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "callback", "Lcom/talabat/feature/referafriend/presentation/channel/ReferAFriendMethodChannelCallback;", "(Lcom/talabat/feature/referafriend/presentation/channel/ReferAFriendMethodChannelCallback;)V", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "com_talabat_feature_refer-a-friend_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ReferAFriendMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    private static final String PLACE_ORDER = "placeOrder";
    @NotNull
    @Deprecated
    private static final String REDEEM_VOUCHER = "redeemVoucher";
    @NotNull
    private final ReferAFriendMethodChannelCallback callback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/referafriend/presentation/channel/ReferAFriendMethodChannel$Companion;", "", "()V", "PLACE_ORDER", "", "REDEEM_VOUCHER", "com_talabat_feature_refer-a-friend_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public ReferAFriendMethodChannel(@NotNull ReferAFriendMethodChannelCallback referAFriendMethodChannelCallback) {
        Intrinsics.checkNotNullParameter(referAFriendMethodChannelCallback, "callback");
        this.callback = referAFriendMethodChannelCallback;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (Intrinsics.areEqual((Object) str, (Object) REDEEM_VOUCHER)) {
            ReferAFriendMethodChannelCallback referAFriendMethodChannelCallback = this.callback;
            String str2 = (String) methodCall.argument(PurchaseInfo.PROMO_CODE);
            if (str2 == null) {
                str2 = "";
            }
            referAFriendMethodChannelCallback.redeemVoucher(str2, result);
        } else if (Intrinsics.areEqual((Object) str, (Object) PLACE_ORDER)) {
            this.callback.placeOrder();
        } else {
            result.notImplemented();
        }
    }
}
