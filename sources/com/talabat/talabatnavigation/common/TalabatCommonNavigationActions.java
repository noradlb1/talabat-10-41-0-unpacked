package com.talabat.talabatnavigation.common;

import android.os.Bundle;
import com.talabat.talabatnavigation.base.NavigatorModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatnavigation/common/TalabatCommonNavigationActions;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatCommonNavigationActions {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_BOTTOM_SHEET_DISPLAY_MODEL = "bottomSheetDisplayModel";
    @NotNull
    public static final String EXTRA_FROM_TOGGLE = "fromToggle";
    @NotNull
    public static final String EXTRA_FROM_TOOLTIP = "fromTooltip";
    @NotNull
    public static final String EXTRA_TNC_PATH = "tncPath";
    @NotNull
    public static final String EXTRA_WALLET_HIDE_CARD_HEIGHT = "hideCardViewHeight";
    @NotNull
    public static final String EXTRA_WALLET_PAYMENT_BOTTOM_SHEET = "walletPaymentBottomSheet";
    @NotNull
    public static final String EXTRA_WALLET_PAYMENT_WIDGET_CARD_LIST_BUNDLE_KEY = "viewHeightBundle";
    @NotNull
    public static final String EXTRA_WALLET_PAYMENT_WIDGET_CARD_LIST_HEIGHT = "viewHeight";
    @NotNull
    private static final String OPEN_WALLET_ADD_CARD_ACTIVITY = "talabat.action.Wallet.addcard";
    @NotNull
    public static final String SOURCE = "source";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatnavigation/common/TalabatCommonNavigationActions$Companion;", "", "()V", "EXTRA_BOTTOM_SHEET_DISPLAY_MODEL", "", "EXTRA_FROM_TOGGLE", "EXTRA_FROM_TOOLTIP", "EXTRA_TNC_PATH", "EXTRA_WALLET_HIDE_CARD_HEIGHT", "EXTRA_WALLET_PAYMENT_BOTTOM_SHEET", "EXTRA_WALLET_PAYMENT_WIDGET_CARD_LIST_BUNDLE_KEY", "EXTRA_WALLET_PAYMENT_WIDGET_CARD_LIST_HEIGHT", "OPEN_WALLET_ADD_CARD_ACTIVITY", "SOURCE", "createNavigationToWalletAddCard", "Lcom/talabat/talabatnavigation/base/NavigatorModel;", "source", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NavigatorModel createNavigationToWalletAddCard(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "source");
            Bundle bundle = new Bundle();
            bundle.putString("source", str);
            return new NavigatorModel("talabat.action.Wallet.addcard", bundle, (Function1) null, 4, (DefaultConstructorMarker) null);
        }
    }
}
