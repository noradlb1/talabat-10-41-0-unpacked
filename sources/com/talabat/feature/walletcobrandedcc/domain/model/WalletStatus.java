package com.talabat.feature.walletcobrandedcc.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/walletcobrandedcc/domain/model/WalletStatus;", "", "shouldShowNotification", "", "text", "", "style", "(ZLjava/lang/String;Ljava/lang/String;)V", "getShouldShowNotification", "()Z", "getStyle", "()Ljava/lang/String;", "getText", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_wallet-cobranded-cc_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletStatus {
    private final boolean shouldShowNotification;
    @NotNull
    private final String style;
    @NotNull
    private final String text;

    public WalletStatus(boolean z11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "style");
        this.shouldShowNotification = z11;
        this.text = str;
        this.style = str2;
    }

    public static /* synthetic */ WalletStatus copy$default(WalletStatus walletStatus, boolean z11, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = walletStatus.shouldShowNotification;
        }
        if ((i11 & 2) != 0) {
            str = walletStatus.text;
        }
        if ((i11 & 4) != 0) {
            str2 = walletStatus.style;
        }
        return walletStatus.copy(z11, str, str2);
    }

    public final boolean component1() {
        return this.shouldShowNotification;
    }

    @NotNull
    public final String component2() {
        return this.text;
    }

    @NotNull
    public final String component3() {
        return this.style;
    }

    @NotNull
    public final WalletStatus copy(boolean z11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "style");
        return new WalletStatus(z11, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletStatus)) {
            return false;
        }
        WalletStatus walletStatus = (WalletStatus) obj;
        return this.shouldShowNotification == walletStatus.shouldShowNotification && Intrinsics.areEqual((Object) this.text, (Object) walletStatus.text) && Intrinsics.areEqual((Object) this.style, (Object) walletStatus.style);
    }

    public final boolean getShouldShowNotification() {
        return this.shouldShowNotification;
    }

    @NotNull
    public final String getStyle() {
        return this.style;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        boolean z11 = this.shouldShowNotification;
        if (z11) {
            z11 = true;
        }
        return ((((z11 ? 1 : 0) * true) + this.text.hashCode()) * 31) + this.style.hashCode();
    }

    @NotNull
    public String toString() {
        boolean z11 = this.shouldShowNotification;
        String str = this.text;
        String str2 = this.style;
        return "WalletStatus(shouldShowNotification=" + z11 + ", text=" + str + ", style=" + str2 + ")";
    }
}
