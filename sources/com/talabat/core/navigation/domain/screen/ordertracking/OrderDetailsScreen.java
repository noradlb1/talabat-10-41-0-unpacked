package com.talabat.core.navigation.domain.screen.ordertracking;

import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/ordertracking/OrderDetailsScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "", "data", "(Ljava/lang/Void;)V", "getData", "()Ljava/lang/Void;", "link", "", "getLink", "()Ljava/lang/String;", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderDetailsScreen implements Screen {
    @Nullable
    private final Void data;

    public OrderDetailsScreen() {
        this((Void) null, 1, (DefaultConstructorMarker) null);
    }

    public OrderDetailsScreen(@Nullable Void voidR) {
        this.data = voidR;
    }

    @NotNull
    public String getLink() {
        return WalletNavigatorActions.OPEN_ORDER_DETAIL_SCREEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrderDetailsScreen(Void voidR, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : voidR);
    }

    @Nullable
    public Void getData() {
        return this.data;
    }
}
