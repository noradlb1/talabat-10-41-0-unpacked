package com.talabat.flutter.channels;

import androidx.core.app.NotificationCompat;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/flutter/channels/CollectionMethodCallHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "isListView", "", "channel", "", "deeplink", "(ZLjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/talabat/flutter/channels/ICollectionMethodCallback;", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setCallback", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionMethodCallHandler implements MethodChannel.MethodCallHandler {
    private ICollectionMethodCallback callback;
    @NotNull
    private final String channel;
    @NotNull
    private final String deeplink;
    private final boolean isListView;

    public CollectionMethodCallHandler(boolean z11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "channel");
        Intrinsics.checkNotNullParameter(str2, "deeplink");
        this.isListView = z11;
        this.channel = str;
        this.deeplink = str2;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Integer num;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            int hashCode = str.hashCode();
            ICollectionMethodCallback iCollectionMethodCallback = null;
            if (hashCode != -1449267278) {
                if (hashCode != -401213707) {
                    if (hashCode == 1962358116 && str.equals("collection_screen_configuration")) {
                        result.success(MapsKt__MapsKt.mapOf(TuplesKt.to("vendorTileType", Integer.valueOf(this.isListView ? 1 : 0)), TuplesKt.to("canShowFilterBarOnFlutterCollection", Boolean.TRUE), TuplesKt.to("collectionChannel", this.channel), TuplesKt.to("deeplink", this.deeplink)));
                    }
                } else if (str.equals("navigate_back")) {
                    ICollectionMethodCallback iCollectionMethodCallback2 = this.callback;
                    if (iCollectionMethodCallback2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("callback");
                    } else {
                        iCollectionMethodCallback = iCollectionMethodCallback2;
                    }
                    iCollectionMethodCallback.onBackPressed();
                }
            } else if (str.equals("vendor_selected")) {
                Object obj = methodCall.arguments;
                if (obj != null) {
                    Object obj2 = ((HashMap) obj).get("vendor");
                    if (obj2 != null) {
                        Object obj3 = ((HashMap) obj2).get("branchId");
                        if (obj3 instanceof Integer) {
                            num = (Integer) obj3;
                        } else {
                            num = null;
                        }
                        if (num != null) {
                            num.intValue();
                            ICollectionMethodCallback iCollectionMethodCallback3 = this.callback;
                            if (iCollectionMethodCallback3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("callback");
                            } else {
                                iCollectionMethodCallback = iCollectionMethodCallback3;
                            }
                            iCollectionMethodCallback.navigateToMenu(num.intValue());
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
                }
                throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
            }
        }
    }

    public final void setCallback(@NotNull ICollectionMethodCallback iCollectionMethodCallback) {
        Intrinsics.checkNotNullParameter(iCollectionMethodCallback, "callback");
        this.callback = iCollectionMethodCallback;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CollectionMethodCallHandler(boolean z11, String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z11, str, str2);
    }
}
