package com.talabat.feature.darkstores.domain.repository;

import JsonModels.Response.MenuItemResponse;
import datamodels.Restaurant;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0011\u0010\u0011\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bH&\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/darkstores/domain/repository/DarkstoresRepository;", "", "getCartId", "", "getCartItemCount", "Lio/reactivex/Single;", "", "getCartTotalValue", "", "getCartVendor", "Lio/reactivex/Maybe;", "Ldatamodels/Restaurant;", "getLastVisitedVendor", "getMigratedVendor", "LJsonModels/Response/MenuItemResponse;", "branchId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNearestDarkstoreVendor", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDarkstoresCartClearedFromCheckout", "", "putLastVisitedVendor", "Lio/reactivex/Completable;", "restaurant", "com_talabat_feature_darkstores_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkstoresRepository {
    @NotNull
    String getCartId();

    @NotNull
    Single<Integer> getCartItemCount();

    @NotNull
    Single<Double> getCartTotalValue();

    @NotNull
    Maybe<Restaurant> getCartVendor();

    @NotNull
    Maybe<Restaurant> getLastVisitedVendor();

    @Nullable
    Object getMigratedVendor(@NotNull String str, @NotNull Continuation<? super MenuItemResponse> continuation);

    @Nullable
    Object getNearestDarkstoreVendor(@NotNull Continuation<? super Restaurant> continuation);

    boolean isDarkstoresCartClearedFromCheckout();

    @NotNull
    Completable putLastVisitedVendor(@NotNull Restaurant restaurant);
}
