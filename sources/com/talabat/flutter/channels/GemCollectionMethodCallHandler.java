package com.talabat.flutter.channels;

import androidx.core.app.NotificationCompat;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/flutter/channels/GemCollectionMethodCallHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "callback", "Lcom/talabat/flutter/channels/IGemCollectionMethodCallback;", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setCallback", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemCollectionMethodCallHandler implements MethodChannel.MethodCallHandler {
    private IGemCollectionMethodCallback callback;

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        boolean z11;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        IGemCollectionMethodCallback iGemCollectionMethodCallback = null;
        if (Intrinsics.areEqual((Object) str, (Object) "navigateToMenu")) {
            Object obj = methodCall.arguments;
            if (obj != null) {
                HashMap hashMap = (HashMap) obj;
                Integer num = (Integer) hashMap.get(OPNavigatorActions.ARG_BRANCH_ID);
                Boolean bool = (Boolean) hashMap.get("is_pro_vendor");
                if (bool != null) {
                    z11 = bool.booleanValue();
                } else {
                    z11 = false;
                }
                String str2 = (String) hashMap.get("delivery_mode");
                String str3 = "";
                if (str2 == null) {
                    str2 = str3;
                }
                String str4 = (String) hashMap.get("shop_click_origin");
                if (str4 != null) {
                    str3 = str4;
                }
                if (num != null) {
                    num.intValue();
                    IGemCollectionMethodCallback iGemCollectionMethodCallback2 = this.callback;
                    if (iGemCollectionMethodCallback2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("callback");
                    } else {
                        iGemCollectionMethodCallback = iGemCollectionMethodCallback2;
                    }
                    iGemCollectionMethodCallback.navigateToMenu(num.intValue(), z11, str2, str3);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any?>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any?> }");
        } else if (Intrinsics.areEqual((Object) str, (Object) "navigateBack")) {
            IGemCollectionMethodCallback iGemCollectionMethodCallback3 = this.callback;
            if (iGemCollectionMethodCallback3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
            } else {
                iGemCollectionMethodCallback = iGemCollectionMethodCallback3;
            }
            iGemCollectionMethodCallback.navigateBack();
        }
    }

    public final void setCallback(@NotNull IGemCollectionMethodCallback iGemCollectionMethodCallback) {
        Intrinsics.checkNotNullParameter(iGemCollectionMethodCallback, "callback");
        this.callback = iGemCollectionMethodCallback;
    }
}
