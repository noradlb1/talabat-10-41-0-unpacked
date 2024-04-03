package com.talabat.core.navigation.domain.screen.cart;

import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0004J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0015\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/cart/CartScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "", "data", "(Ljava/lang/Void;)V", "getData", "()Ljava/lang/Void;", "link", "", "getLink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartScreen implements Screen {
    @Nullable
    private final Void data;
    @NotNull
    private final String link;

    public CartScreen() {
        this((Void) null, 1, (DefaultConstructorMarker) null);
    }

    public CartScreen(@Nullable Void voidR) {
        this.data = voidR;
        this.link = LegacyTalabatActions.OPEN_CART;
    }

    public static /* synthetic */ CartScreen copy$default(CartScreen cartScreen, Void voidR, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            voidR = cartScreen.getData();
        }
        return cartScreen.copy(voidR);
    }

    @Nullable
    public final Void component1() {
        return getData();
    }

    @NotNull
    public final CartScreen copy(@Nullable Void voidR) {
        return new CartScreen(voidR);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CartScreen) && Intrinsics.areEqual((Object) getData(), (Object) ((CartScreen) obj).getData());
    }

    @NotNull
    public String getLink() {
        return this.link;
    }

    public int hashCode() {
        if (getData() == null) {
            return 0;
        }
        return getData().hashCode();
    }

    @NotNull
    public String toString() {
        Void data2 = getData();
        return "CartScreen(data=" + data2 + ")";
    }

    @Nullable
    public Void getData() {
        return this.data;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CartScreen(Void voidR, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : voidR);
    }
}
