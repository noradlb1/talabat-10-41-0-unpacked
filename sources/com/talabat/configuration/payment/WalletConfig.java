package com.talabat.configuration.payment;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/configuration/payment/WalletConfig;", "", "isAmexAvailable", "", "tokenizedBankCards", "", "Lcom/talabat/configuration/payment/TokenizedBankCard;", "(ZLjava/util/List;)V", "()Z", "getTokenizedBankCards", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletConfig {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final WalletConfig DEFAULT = new WalletConfig(false, CollectionsKt__CollectionsKt.emptyList());
    private final boolean isAmexAvailable;
    @NotNull
    private final List<TokenizedBankCard> tokenizedBankCards;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/configuration/payment/WalletConfig$Companion;", "", "()V", "DEFAULT", "Lcom/talabat/configuration/payment/WalletConfig;", "getDEFAULT", "()Lcom/talabat/configuration/payment/WalletConfig;", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WalletConfig getDEFAULT() {
            return WalletConfig.DEFAULT;
        }
    }

    public WalletConfig(boolean z11, @NotNull List<TokenizedBankCard> list) {
        Intrinsics.checkNotNullParameter(list, "tokenizedBankCards");
        this.isAmexAvailable = z11;
        this.tokenizedBankCards = list;
    }

    public static /* synthetic */ WalletConfig copy$default(WalletConfig walletConfig, boolean z11, List<TokenizedBankCard> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = walletConfig.isAmexAvailable;
        }
        if ((i11 & 2) != 0) {
            list = walletConfig.tokenizedBankCards;
        }
        return walletConfig.copy(z11, list);
    }

    public final boolean component1() {
        return this.isAmexAvailable;
    }

    @NotNull
    public final List<TokenizedBankCard> component2() {
        return this.tokenizedBankCards;
    }

    @NotNull
    public final WalletConfig copy(boolean z11, @NotNull List<TokenizedBankCard> list) {
        Intrinsics.checkNotNullParameter(list, "tokenizedBankCards");
        return new WalletConfig(z11, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletConfig)) {
            return false;
        }
        WalletConfig walletConfig = (WalletConfig) obj;
        return this.isAmexAvailable == walletConfig.isAmexAvailable && Intrinsics.areEqual((Object) this.tokenizedBankCards, (Object) walletConfig.tokenizedBankCards);
    }

    @NotNull
    public final List<TokenizedBankCard> getTokenizedBankCards() {
        return this.tokenizedBankCards;
    }

    public int hashCode() {
        boolean z11 = this.isAmexAvailable;
        if (z11) {
            z11 = true;
        }
        return ((z11 ? 1 : 0) * true) + this.tokenizedBankCards.hashCode();
    }

    public final boolean isAmexAvailable() {
        return this.isAmexAvailable;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isAmexAvailable;
        List<TokenizedBankCard> list = this.tokenizedBankCards;
        return "WalletConfig(isAmexAvailable=" + z11 + ", tokenizedBankCards=" + list + ")";
    }
}
