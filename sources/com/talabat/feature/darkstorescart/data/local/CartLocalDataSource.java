package com.talabat.feature.darkstorescart.data.local;

import android.content.SharedPreferences;
import com.talabat.feature.darkstorescart.data.model.CartVendor;
import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J!\u0010\u0014\u001a\u00020\u000f2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000f0\u0016¢\u0006\u0002\b\u0018H\u0002J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0011J\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0013R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/local/CartLocalDataSource;", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "_selectedVendor", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/talabat/feature/darkstorescart/data/model/CartVendor;", "value", "selectedVendor", "getSelectedVendor", "()Lcom/talabat/feature/darkstorescart/data/model/CartVendor;", "setSelectedVendor", "(Lcom/talabat/feature/darkstorescart/data/model/CartVendor;)V", "clearCartId", "", "getCartId", "", "getCartLAstModifiedTime", "", "save", "block", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/ExtensionFunctionType;", "saveCartId", "cartId", "saveCartLastModifiedTime", "time", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartLocalDataSource {
    @NotNull
    private final AtomicReference<CartVendor> _selectedVendor = new AtomicReference<>((Object) null);
    @NotNull
    private final SharedPreferences sharedPreferences;

    @Inject
    public CartLocalDataSource(@NotNull SharedPreferences sharedPreferences2) {
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        this.sharedPreferences = sharedPreferences2;
    }

    private final void save(Function1<? super SharedPreferences.Editor, Unit> function1) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "");
        function1.invoke(edit);
        edit.apply();
    }

    public final void clearCartId() {
        save(CartLocalDataSource$clearCartId$1.INSTANCE);
    }

    @Nullable
    public final String getCartId() {
        return this.sharedPreferences.getString("cart_id", (String) null);
    }

    public final long getCartLAstModifiedTime() {
        return this.sharedPreferences.getLong("cart_last_modified_millis", 0);
    }

    @Nullable
    public final CartVendor getSelectedVendor() {
        return this._selectedVendor.get();
    }

    public final void saveCartId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        save(new CartLocalDataSource$saveCartId$1(str));
    }

    public final void saveCartLastModifiedTime(long j11) {
        save(new CartLocalDataSource$saveCartLastModifiedTime$1(j11));
    }

    public final void setSelectedVendor(@Nullable CartVendor cartVendor) {
        this._selectedVendor.set(cartVendor);
    }
}
