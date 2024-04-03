package com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/QPayRedirectUrlDisplayModel;", "", "()V", "Loading", "ShowQPayRedirectError", "ShowQPayRedirectScreen", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/QPayRedirectUrlDisplayModel$Loading;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/QPayRedirectUrlDisplayModel$ShowQPayRedirectError;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/QPayRedirectUrlDisplayModel$ShowQPayRedirectScreen;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class QPayRedirectUrlDisplayModel {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/QPayRedirectUrlDisplayModel$Loading;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/QPayRedirectUrlDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Loading extends QPayRedirectUrlDisplayModel {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/QPayRedirectUrlDisplayModel$ShowQPayRedirectError;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/QPayRedirectUrlDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowQPayRedirectError extends QPayRedirectUrlDisplayModel {
        @NotNull
        public static final ShowQPayRedirectError INSTANCE = new ShowQPayRedirectError();

        private ShowQPayRedirectError() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/QPayRedirectUrlDisplayModel$ShowQPayRedirectScreen;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/QPayRedirectUrlDisplayModel;", "redirectUrl", "", "(Ljava/lang/String;)V", "getRedirectUrl", "()Ljava/lang/String;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowQPayRedirectScreen extends QPayRedirectUrlDisplayModel {
        @NotNull
        private final String redirectUrl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowQPayRedirectScreen(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "redirectUrl");
            this.redirectUrl = str;
        }

        @NotNull
        public final String getRedirectUrl() {
            return this.redirectUrl;
        }
    }

    private QPayRedirectUrlDisplayModel() {
    }

    public /* synthetic */ QPayRedirectUrlDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
