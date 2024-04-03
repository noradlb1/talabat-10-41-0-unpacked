package com.talabat.core.navigation.domain.screen.wallet;

import com.talabat.core.navigation.domain.screen.Screen;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/wallet/WalletCustomDeepLinkFlutter;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "", "deepLink", "", "(Ljava/lang/String;)V", "data", "getData", "()Ljava/lang/Void;", "link", "getLink", "()Ljava/lang/String;", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCustomDeepLinkFlutter implements Screen {
    @Nullable
    private final Void data;
    @NotNull
    private final String link;

    public WalletCustomDeepLinkFlutter(@Nullable String str) {
        this.link = str == null ? "talabat://s=/cobranded-credit-card?source=wallet_dashboard" : str;
    }

    @NotNull
    public String getLink() {
        return this.link;
    }

    @Nullable
    public Void getData() {
        return this.data;
    }
}
