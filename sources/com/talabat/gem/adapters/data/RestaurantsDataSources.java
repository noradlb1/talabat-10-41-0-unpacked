package com.talabat.gem.adapters.data;

import android.content.Context;
import buisnessmodels.Cart;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.usecases.BusinessRulesKt;
import com.talabat.gem.ports.data.RestaurantsDataSourcesPort;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oq.f;
import oq.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\bH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0014\u0010\u0013\u001a\u00020\f*\u00020\u00142\u0006\u0010\r\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/gem/adapters/data/RestaurantsDataSources;", "Lcom/talabat/gem/ports/data/RestaurantsDataSourcesPort;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "loadSelectedGemRestaurant", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "observeOnSelectedGemRestaurant", "Lio/reactivex/Observable;", "observeOnSelectedRestaurantId", "", "resetCart", "", "selectedRestaurant", "cachedRestaurant", "updateSelectedGemRestaurant", "restaurant", "isGemCollectionRestaurant", "", "updateCart", "Lbuisnessmodels/Cart;", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RestaurantsDataSources implements RestaurantsDataSourcesPort {
    @NotNull
    private final Context context;

    public RestaurantsDataSources(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    /* access modifiers changed from: private */
    /* renamed from: observeOnSelectedRestaurantId$lambda-1  reason: not valid java name */
    public static final boolean m10506observeOnSelectedRestaurantId$lambda1(ObservedData observedData) {
        Intrinsics.checkNotNullParameter(observedData, "it");
        if (observedData.getSelectedRestaurantId() != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: observeOnSelectedRestaurantId$lambda-2  reason: not valid java name */
    public static final Integer m10507observeOnSelectedRestaurantId$lambda2(ObservedData observedData) {
        Intrinsics.checkNotNullParameter(observedData, "it");
        return observedData.getSelectedRestaurantId();
    }

    private final void resetCart(GemRestaurant gemRestaurant, GemRestaurant gemRestaurant2) {
        if (!Intrinsics.areEqual((Object) gemRestaurant, (Object) gemRestaurant2)) {
            Cart instance = Cart.getInstance();
            instance.clearCart(this.context);
            Intrinsics.checkNotNullExpressionValue(instance, "");
            updateCart(instance, gemRestaurant);
        }
    }

    private final void updateCart(Cart cart, GemRestaurant gemRestaurant) {
        if (!Intrinsics.areEqual((Object) gemRestaurant, (Object) BusinessRulesKt.getNullGemRestaurant())) {
            cart.setRestaurant(gemRestaurant.getData());
            cart.addSuppressedForRestaurantId(gemRestaurant.getId());
        }
    }

    @Nullable
    public GemRestaurant loadSelectedGemRestaurant() {
        return (GemRestaurant) RxKt.invoke(CacheKt.getSelectedGemRestaurant());
    }

    @NotNull
    public Observable<GemRestaurant> observeOnSelectedGemRestaurant() {
        Observable<GemRestaurant> share = CacheKt.getSelectedGemRestaurant().share();
        Intrinsics.checkNotNullExpressionValue(share, "selectedGemRestaurant.share()");
        return share;
    }

    @NotNull
    public Observable<Integer> observeOnSelectedRestaurantId() {
        Observable<R> map = CacheKt.getCacheObservable().share().filter(new f()).map(new g());
        Intrinsics.checkNotNullExpressionValue(map, "cacheObservable\n        …it.selectedRestaurantId }");
        return map;
    }

    public void updateSelectedGemRestaurant(@NotNull GemRestaurant gemRestaurant, boolean z11) {
        Intrinsics.checkNotNullParameter(gemRestaurant, "restaurant");
        if (!Intrinsics.areEqual((Object) gemRestaurant, (Object) BusinessRulesKt.getNullGemRestaurant())) {
            GlobalDataModel.SELECTED.updateRestaurant(gemRestaurant.getData());
        }
        resetCart(gemRestaurant, loadSelectedGemRestaurant());
        CacheKt.getSelectedGemRestaurant().onNext(gemRestaurant);
        CacheKt.setGemCollectionRestaurant(z11);
    }
}
