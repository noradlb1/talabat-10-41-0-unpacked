package com.talabat.darkstores.feature.home.flutter.channel;

import androidx.core.app.NotificationCompat;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/darkstores/feature/home/flutter/channel/DarkstoresMethodCallHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "callback", "Lcom/talabat/darkstores/feature/home/flutter/channel/IDarkstoresMethodCallHandlerCallback;", "handleSearchBarClicked", "", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setCallback", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresMethodCallHandler implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String SEARCH_BAR_CLICKED = "searchBarClicked";
    private IDarkstoresMethodCallHandlerCallback callback;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/home/flutter/channel/DarkstoresMethodCallHandler$Companion;", "", "()V", "SEARCH_BAR_CLICKED", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void handleSearchBarClicked() {
        IDarkstoresMethodCallHandlerCallback iDarkstoresMethodCallHandlerCallback = this.callback;
        if (iDarkstoresMethodCallHandlerCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            iDarkstoresMethodCallHandlerCallback = null;
        }
        iDarkstoresMethodCallHandlerCallback.onSearchBarClicked();
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual((Object) methodCall.method, (Object) SEARCH_BAR_CLICKED)) {
            handleSearchBarClicked();
        }
    }

    public final void setCallback(@NotNull IDarkstoresMethodCallHandlerCallback iDarkstoresMethodCallHandlerCallback) {
        Intrinsics.checkNotNullParameter(iDarkstoresMethodCallHandlerCallback, "callback");
        this.callback = iDarkstoresMethodCallHandlerCallback;
    }
}
