package com.talabat.feature.walletaddcard.presentation.channel;

import androidx.core.app.NotificationCompat;
import com.talabat.feature.walletaddcard.domain.usecase.GetCardTokenUseCase;
import com.talabat.feature.walletaddcard.domain.usecase.IsBenefitEnabledUseCase;
import com.talabat.feature.walletaddcard.domain.usecase.IsQPayEnabledUseCase;
import dagger.Reusable;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "getCardTokenUseCase", "Lcom/talabat/feature/walletaddcard/domain/usecase/GetCardTokenUseCase;", "isQPayEnabledUseCase", "Lcom/talabat/feature/walletaddcard/domain/usecase/IsQPayEnabledUseCase;", "isBenefitEnabledUseCase", "Lcom/talabat/feature/walletaddcard/domain/usecase/IsBenefitEnabledUseCase;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "walletAddCardMethodChannelCallback", "Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler$WalletAddCardMethodChannelCallback;", "(Lcom/talabat/feature/walletaddcard/domain/usecase/GetCardTokenUseCase;Lcom/talabat/feature/walletaddcard/domain/usecase/IsQPayEnabledUseCase;Lcom/talabat/feature/walletaddcard/domain/usecase/IsBenefitEnabledUseCase;Lkotlinx/coroutines/CoroutineScope;Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler$WalletAddCardMethodChannelCallback;)V", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "closeWalletWithSuccess", "", "generateCardToken", "call", "Lio/flutter/plugin/common/MethodCall;", "isBenefitDeflectionEnabled", "isWalletAddCardQPayDeflectionEnabled", "onActivityResult", "resultCode", "", "onMethodCall", "Companion", "WalletAddCardMethodChannelCallback", "com_talabat_feature_wallet-add-card_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class WalletMethodCallHandler implements MethodChannel.MethodCallHandler {
    @NotNull
    private static final String ARG_WALLET_ADD_CARD_3DS = "wallet_add_card_3ds";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String GENERATE_CARD_TOKEN_FUNCTION = "generateCardToken";
    @NotNull
    private static final String IS_BENEFIT_DEFLECTION_ENABLED_FUNCTION = "isBenefitDeflectionEnabled";
    @NotNull
    private static final String IS_WALLET_ADD_CARD_QPAY_DEFLECTION_ENABLED_FUNCTION = "isWalletAddCardQPayDeflectionEnabled";
    @NotNull
    private static final String NEW_CARD_ADDED_FUNCTION = "newCardAdded";
    @NotNull
    private static final String OPEN_3DS_SCREEN_FUNCTION = "open3dsScreen";
    @NotNull
    public static final String WALLET_CHANNEL = "com.talabat.flutter/walletAddCard";
    @NotNull
    private final CoroutineScope coroutineScope;
    /* access modifiers changed from: private */
    @NotNull
    public final GetCardTokenUseCase getCardTokenUseCase;
    @NotNull
    private final IsBenefitEnabledUseCase isBenefitEnabledUseCase;
    @NotNull
    private final IsQPayEnabledUseCase isQPayEnabledUseCase;
    @Nullable
    private MethodChannel.Result result;
    @NotNull
    private final WalletAddCardMethodChannelCallback walletAddCardMethodChannelCallback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler$Companion;", "", "()V", "ARG_WALLET_ADD_CARD_3DS", "", "GENERATE_CARD_TOKEN_FUNCTION", "IS_BENEFIT_DEFLECTION_ENABLED_FUNCTION", "IS_WALLET_ADD_CARD_QPAY_DEFLECTION_ENABLED_FUNCTION", "NEW_CARD_ADDED_FUNCTION", "OPEN_3DS_SCREEN_FUNCTION", "WALLET_CHANNEL", "com_talabat_feature_wallet-add-card_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler$WalletAddCardMethodChannelCallback;", "", "navigateToAddCardSuccessScreen", "", "open3DSScreen", "walletAddCard3dsUrl", "", "com_talabat_feature_wallet-add-card_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface WalletAddCardMethodChannelCallback {
        void navigateToAddCardSuccessScreen();

        void open3DSScreen(@NotNull String str);
    }

    @Inject
    public WalletMethodCallHandler(@NotNull GetCardTokenUseCase getCardTokenUseCase2, @NotNull IsQPayEnabledUseCase isQPayEnabledUseCase2, @NotNull IsBenefitEnabledUseCase isBenefitEnabledUseCase2, @NotNull CoroutineScope coroutineScope2, @NotNull WalletAddCardMethodChannelCallback walletAddCardMethodChannelCallback2) {
        Intrinsics.checkNotNullParameter(getCardTokenUseCase2, "getCardTokenUseCase");
        Intrinsics.checkNotNullParameter(isQPayEnabledUseCase2, "isQPayEnabledUseCase");
        Intrinsics.checkNotNullParameter(isBenefitEnabledUseCase2, "isBenefitEnabledUseCase");
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        Intrinsics.checkNotNullParameter(walletAddCardMethodChannelCallback2, "walletAddCardMethodChannelCallback");
        this.getCardTokenUseCase = getCardTokenUseCase2;
        this.isQPayEnabledUseCase = isQPayEnabledUseCase2;
        this.isBenefitEnabledUseCase = isBenefitEnabledUseCase2;
        this.coroutineScope = coroutineScope2;
        this.walletAddCardMethodChannelCallback = walletAddCardMethodChannelCallback2;
    }

    private final void closeWalletWithSuccess() {
        this.walletAddCardMethodChannelCallback.navigateToAddCardSuccessScreen();
    }

    private final void generateCardToken(MethodCall methodCall, MethodChannel.Result result2) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new WalletMethodCallHandler$generateCardToken$1(methodCall, result2, this, (Continuation<? super WalletMethodCallHandler$generateCardToken$1>) null), 3, (Object) null);
    }

    private final void isBenefitDeflectionEnabled(MethodChannel.Result result2) {
        result2.success(Boolean.valueOf(this.isBenefitEnabledUseCase.invoke()));
    }

    private final void isWalletAddCardQPayDeflectionEnabled(MethodChannel.Result result2) {
        result2.success(Boolean.valueOf(this.isQPayEnabledUseCase.invoke()));
    }

    public final void onActivityResult(int i11) {
        if (i11 == -1) {
            MethodChannel.Result result2 = this.result;
            if (result2 != null) {
                result2.success(Boolean.TRUE);
            }
        } else if (i11 != 201) {
            MethodChannel.Result result3 = this.result;
            if (result3 != null) {
                result3.success(Boolean.FALSE);
            }
        } else {
            MethodChannel.Result result4 = this.result;
            if (result4 != null) {
                result4.success(Boolean.FALSE);
            }
        }
        this.result = null;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result2) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result2, "result");
        this.result = result2;
        String str = methodCall.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1926621484:
                    if (str.equals(GENERATE_CARD_TOKEN_FUNCTION)) {
                        generateCardToken(methodCall, result2);
                        return;
                    }
                    return;
                case -353888413:
                    if (str.equals(IS_WALLET_ADD_CARD_QPAY_DEFLECTION_ENABLED_FUNCTION)) {
                        isWalletAddCardQPayDeflectionEnabled(result2);
                        return;
                    }
                    return;
                case -224379900:
                    if (str.equals(OPEN_3DS_SCREEN_FUNCTION)) {
                        WalletAddCardMethodChannelCallback walletAddCardMethodChannelCallback2 = this.walletAddCardMethodChannelCallback;
                        String str2 = (String) methodCall.argument(ARG_WALLET_ADD_CARD_3DS);
                        if (str2 == null) {
                            str2 = "";
                        }
                        walletAddCardMethodChannelCallback2.open3DSScreen(str2);
                        return;
                    }
                    return;
                case 31205904:
                    if (str.equals(NEW_CARD_ADDED_FUNCTION)) {
                        closeWalletWithSuccess();
                        return;
                    }
                    return;
                case 244866043:
                    if (str.equals(IS_BENEFIT_DEFLECTION_ENABLED_FUNCTION)) {
                        isBenefitDeflectionEnabled(result2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
