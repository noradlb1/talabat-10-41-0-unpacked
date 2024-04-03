package com.talabat.feature.darkstoresflutter.domain.repository;

import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H&J$\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\r2\u0006\u0010\u000e\u001a\u00020\u0006H&J\b\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0006H&¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/domain/repository/DarkstoresCartFlutterRepository;", "", "addProductToCart", "Lio/reactivex/Completable;", "productMap", "", "", "globalVendorId", "clearCart", "navigateToCheckout", "", "specialRequest", "observeCartChanges", "Lio/reactivex/Observable;", "vendorId", "refreshCart", "removeProductFromCart", "productId", "com_talabat_feature_darkstores-flutter_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkstoresCartFlutterRepository {
    @NotNull
    Completable addProductToCart(@NotNull Map<String, ? extends Object> map, @NotNull String str);

    @NotNull
    Completable clearCart();

    void navigateToCheckout(@NotNull String str);

    @NotNull
    Observable<Map<String, Object>> observeCartChanges(@NotNull String str);

    @NotNull
    Completable refreshCart();

    @NotNull
    Completable removeProductFromCart(@NotNull String str);
}
