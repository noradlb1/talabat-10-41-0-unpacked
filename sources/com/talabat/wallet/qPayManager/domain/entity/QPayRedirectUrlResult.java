package com.talabat.wallet.qPayManager.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/qPayManager/domain/entity/QPayRedirectUrlResult;", "", "()V", "Error", "RedirectToQPayThreeDSUrl", "Lcom/talabat/wallet/qPayManager/domain/entity/QPayRedirectUrlResult$RedirectToQPayThreeDSUrl;", "Lcom/talabat/wallet/qPayManager/domain/entity/QPayRedirectUrlResult$Error;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class QPayRedirectUrlResult {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/qPayManager/domain/entity/QPayRedirectUrlResult$Error;", "Lcom/talabat/wallet/qPayManager/domain/entity/QPayRedirectUrlResult;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Error extends QPayRedirectUrlResult {
        @NotNull
        public static final Error INSTANCE = new Error();

        private Error() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/qPayManager/domain/entity/QPayRedirectUrlResult$RedirectToQPayThreeDSUrl;", "Lcom/talabat/wallet/qPayManager/domain/entity/QPayRedirectUrlResult;", "redirectUrl", "", "(Ljava/lang/String;)V", "getRedirectUrl", "()Ljava/lang/String;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RedirectToQPayThreeDSUrl extends QPayRedirectUrlResult {
        @NotNull
        private final String redirectUrl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RedirectToQPayThreeDSUrl(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "redirectUrl");
            this.redirectUrl = str;
        }

        @NotNull
        public final String getRedirectUrl() {
            return this.redirectUrl;
        }
    }

    private QPayRedirectUrlResult() {
    }

    public /* synthetic */ QPayRedirectUrlResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
