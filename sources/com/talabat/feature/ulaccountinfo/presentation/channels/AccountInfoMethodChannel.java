package com.talabat.feature.ulaccountinfo.presentation.channels;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/ulaccountinfo/presentation/channels/AccountInfoMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "callback", "Lcom/talabat/feature/ulaccountinfo/presentation/channels/AccountInfoMethodChannelCallback;", "handleAccountCloseInfo", "", "handleLogOutAndClearCache", "handleSaveSuccess", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "onMethodCall", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setCallback", "Companion", "com_talabat_feature_ul-account-info_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AccountInfoMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final String CLOSE_ACCOUNT_INFO = "closeAccountInfoScreen";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String DELETE_API_SUCCESS = "deleteApiSuccess";
    @NotNull
    public static final String SAVE_SUCCESS_ACCOUNT_INFO = "saveSuccess";
    private AccountInfoMethodChannelCallback callback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/ulaccountinfo/presentation/channels/AccountInfoMethodChannel$Companion;", "", "()V", "CLOSE_ACCOUNT_INFO", "", "DELETE_API_SUCCESS", "SAVE_SUCCESS_ACCOUNT_INFO", "com_talabat_feature_ul-account-info_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void handleAccountCloseInfo() {
        AccountInfoMethodChannelCallback accountInfoMethodChannelCallback = this.callback;
        if (accountInfoMethodChannelCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            accountInfoMethodChannelCallback = null;
        }
        accountInfoMethodChannelCallback.closeAccountInfoScreen();
    }

    private final void handleLogOutAndClearCache() {
        AccountInfoMethodChannelCallback accountInfoMethodChannelCallback = this.callback;
        if (accountInfoMethodChannelCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            accountInfoMethodChannelCallback = null;
        }
        accountInfoMethodChannelCallback.logOutAndClearCache();
    }

    private final void handleSaveSuccess(MethodCall methodCall) {
        Object obj = methodCall.arguments;
        if (obj != null) {
            HashMap hashMap = (HashMap) obj;
            AccountInfoMethodChannelCallback accountInfoMethodChannelCallback = this.callback;
            if (accountInfoMethodChannelCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
                accountInfoMethodChannelCallback = null;
            }
            accountInfoMethodChannelCallback.saveSuccessResult(hashMap);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, "methodCall");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1570294636) {
                if (hashCode != -1176510522) {
                    if (hashCode == 689486255 && str.equals(CLOSE_ACCOUNT_INFO)) {
                        handleAccountCloseInfo();
                    }
                } else if (str.equals(SAVE_SUCCESS_ACCOUNT_INFO)) {
                    handleSaveSuccess(methodCall);
                }
            } else if (str.equals(DELETE_API_SUCCESS)) {
                handleLogOutAndClearCache();
            }
        }
    }

    public final void setCallback(@NotNull AccountInfoMethodChannelCallback accountInfoMethodChannelCallback) {
        Intrinsics.checkNotNullParameter(accountInfoMethodChannelCallback, "callback");
        this.callback = accountInfoMethodChannelCallback;
    }
}
