package com.talabat.feature.darkstorescartlist.data.local;

import android.content.SharedPreferences;
import com.talabat.feature.darkstorescartlist.data.model.CartInfoResponse;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.utility.JavaConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010J\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0015R4\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/data/local/CartListLocalDataSource;", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "value", "", "Lcom/talabat/feature/darkstorescartlist/data/model/CartInfoResponse;", "cartList", "getCartList", "()Ljava/util/List;", "setCartList", "(Ljava/util/List;)V", "cartListReference", "Ljava/util/concurrent/atomic/AtomicReference;", "getCartListToastPreferenceKey", "", "cartCount", "", "variation", "isCartListToastShown", "", "setCartListToastShown", "", "shown", "com_talabat_feature_darkstores-cart-list_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartListLocalDataSource {
    @NotNull
    private final AtomicReference<List<CartInfoResponse>> cartListReference = new AtomicReference<>();
    @NotNull
    private final SharedPreferences sharedPreferences;

    @Inject
    public CartListLocalDataSource(@NotNull SharedPreferences sharedPreferences2) {
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        this.sharedPreferences = sharedPreferences2;
    }

    private final String getCartListToastPreferenceKey(int i11, String str) {
        return "cart_list_toast_shown_" + str + JavaConstant.Dynamic.DEFAULT_NAME + i11;
    }

    @Nullable
    public final List<CartInfoResponse> getCartList() {
        return this.cartListReference.get();
    }

    public final boolean isCartListToastShown(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "variation");
        return this.sharedPreferences.getBoolean(getCartListToastPreferenceKey(i11, str), false);
    }

    public final void setCartList(@Nullable List<CartInfoResponse> list) {
        this.cartListReference.set(list);
    }

    public final void setCartListToastShown(int i11, @NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "variation");
        this.sharedPreferences.edit().putBoolean(getCartListToastPreferenceKey(i11, str), z11).apply();
    }
}
