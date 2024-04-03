package com.talabat.darkstores.feature.cart;

import android.content.SharedPreferences;
import com.talabat.darkstores.common.SwimlaneTrackingData;
import com.talabat.darkstores.common.TimeProvider;
import com.talabat.darkstores.data.tracking.product.ProductTracker;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.feature.darkstorescart.data.model.CartResponse;
import com.talabat.feature.darkstorescart.data.model.CartVendor;
import com.talabat.feature.darkstorescart.data.model.CheckoutParams;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import com.talabat.feature.darkstorescartlist.domain.repository.DarkstoresCartListRepository;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ri.g;
import ri.h;
import ri.i;
import timber.log.Timber;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 H2\u00020\u0001:\u0001HB7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013J \u0010\u0016\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0019 \u001a*\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00180\u00180\u0017J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cJ\u0006\u0010\u001e\u001a\u00020\u001fJ\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!J\b\u0010#\u001a\u00020$H\u0002J\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0017J\u0012\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017J\u0016\u0010(\u001a\u00020\u00102\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00130*H\u0002J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017Jo\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u001d2\u0006\u00102\u001a\u0002032\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\n\b\u0002\u00106\u001a\u0004\u0018\u0001072\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010:\u001a\u000200¢\u0006\u0002\u0010;Jw\u0010<\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u001d2\b\u00101\u001a\u0004\u0018\u00010\u001d2\b\u0010>\u001a\u0004\u0018\u00010\u001f2\u0006\u00102\u001a\u0002032\b\b\u0002\u0010?\u001a\u00020\u001f2\b\u00106\u001a\u0004\u0018\u0001072\b\u00104\u001a\u0004\u0018\u0001052\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001f2\u0006\u0010/\u001a\u000200H\u0002¢\u0006\u0002\u0010@J\u0006\u0010A\u001a\u00020\u0013J\u0006\u0010B\u001a\u00020\u0013J\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010D\u001a\u00020EJ\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010D\u001a\u00020EJ\b\u0010G\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartController;", "", "cartRepository", "Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;", "cartListRepository", "Lcom/talabat/feature/darkstorescartlist/domain/repository/DarkstoresCartListRepository;", "sharedPreferences", "Landroid/content/SharedPreferences;", "tracker", "Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;", "productTracker", "Lcom/talabat/darkstores/data/tracking/product/ProductTracker;", "timeProvider", "Lcom/talabat/darkstores/common/TimeProvider;", "(Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;Lcom/talabat/feature/darkstorescartlist/domain/repository/DarkstoresCartListRepository;Landroid/content/SharedPreferences;Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;Lcom/talabat/darkstores/data/tracking/product/ProductTracker;Lcom/talabat/darkstores/common/TimeProvider;)V", "clearCart", "Lio/reactivex/Completable;", "clearCartIfNeeded", "clearDuplicateCartId", "", "clearSelectedVendor", "disableResetCartFlag", "getAllAsObservable", "Lio/reactivex/Observable;", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "kotlin.jvm.PlatformType", "getCartCount", "Lio/reactivex/Single;", "", "getCartId", "", "getCartOwner", "Lio/reactivex/Maybe;", "Lcom/talabat/feature/darkstorescart/data/model/CartVendor;", "getLastModifiedDate", "", "getNavigateToCheckoutActions", "Lcom/talabat/feature/darkstorescart/data/model/CheckoutParams;", "getOOSProducts", "invokeWithLastModifiedUpdate", "block", "Lkotlin/Function0;", "observeCartQuantityUpdatedChanges", "setProductCount", "product", "count", "isAdded", "", "listPosition", "eventOriginType", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "trackingCategoryId", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;", "swimlaneTrackingData", "Lcom/talabat/darkstores/common/SwimlaneTrackingData;", "swimlaneRequestId", "swimlaneStrategy", "useOldTracking", "(Lcom/talabat/feature/darkstorescart/data/model/Product;IZLjava/lang/Integer;Lcom/talabat/darkstores/feature/tracking/EventOriginType;Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;Lcom/talabat/darkstores/common/SwimlaneTrackingData;Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Completable;", "trackProductChanged", "quantity", "screenName", "shelfViewTitle", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;Ljava/lang/String;Lcom/talabat/darkstores/feature/tracking/EventOriginType;Ljava/lang/String;Lcom/talabat/darkstores/common/SwimlaneTrackingData;Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;Ljava/lang/String;Ljava/lang/String;Z)V", "updateCartSyncFailure", "updateCartSyncStarted", "updateCartSyncSuccess", "cartResponse", "Lcom/talabat/feature/darkstorescart/data/model/CartResponse;", "updateCartSyncSuccessV2", "updateLastModifiedDate", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartController {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    private static final String RESET_DS_CART = "reset_ds_cart";
    @Deprecated
    private static final long TIME_TO_DELETE_IN_MILLIS = TimeUnit.DAYS.toMillis(7);
    @NotNull
    private final DarkstoresCartListRepository cartListRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final DarkstoresCartRepository cartRepository;
    @NotNull
    private final ProductTracker productTracker;
    @NotNull
    private final SharedPreferences sharedPreferences;
    @NotNull
    private final TimeProvider timeProvider;
    @NotNull
    private final DarkstoresEventTracker tracker;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartController$Companion;", "", "()V", "RESET_DS_CART", "", "TIME_TO_DELETE_IN_MILLIS", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public CartController(@NotNull DarkstoresCartRepository darkstoresCartRepository, @NotNull DarkstoresCartListRepository darkstoresCartListRepository, @NotNull SharedPreferences sharedPreferences2, @NotNull DarkstoresEventTracker darkstoresEventTracker, @NotNull ProductTracker productTracker2, @NotNull TimeProvider timeProvider2) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "cartRepository");
        Intrinsics.checkNotNullParameter(darkstoresCartListRepository, "cartListRepository");
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        Intrinsics.checkNotNullParameter(darkstoresEventTracker, "tracker");
        Intrinsics.checkNotNullParameter(productTracker2, "productTracker");
        Intrinsics.checkNotNullParameter(timeProvider2, "timeProvider");
        this.cartRepository = darkstoresCartRepository;
        this.cartListRepository = darkstoresCartListRepository;
        this.sharedPreferences = sharedPreferences2;
        this.tracker = darkstoresEventTracker;
        this.productTracker = productTracker2;
        this.timeProvider = timeProvider2;
    }

    /* access modifiers changed from: private */
    /* renamed from: clearCart$lambda-0  reason: not valid java name */
    public static final void m9774clearCart$lambda0(CartController cartController) {
        Intrinsics.checkNotNullParameter(cartController, "this$0");
        cartController.cartRepository.clearCart();
    }

    public static /* synthetic */ void d(CartController cartController, Product product, int i11, Integer num, String str, EventOriginType eventOriginType, String str2, SwimlaneTrackingData swimlaneTrackingData, TrackingCategoryId trackingCategoryId, String str3, String str4, boolean z11, int i12, Object obj) {
        String str5;
        String str6;
        String str7;
        int i13 = i12;
        if ((i13 & 32) != 0) {
            str5 = "";
        } else {
            str5 = str2;
        }
        if ((i13 & 256) != 0) {
            str6 = null;
        } else {
            str6 = str3;
        }
        if ((i13 & 512) != 0) {
            str7 = null;
        } else {
            str7 = str4;
        }
        cartController.trackProductChanged(product, i11, num, str, eventOriginType, str5, swimlaneTrackingData, trackingCategoryId, str6, str7, z11);
    }

    private final long getLastModifiedDate() {
        return this.cartRepository.getLastModifiedTime();
    }

    private final Completable invokeWithLastModifiedUpdate(Function0<Unit> function0) {
        Completable subscribeOn = Completable.fromAction(new h(function0)).doOnComplete(new i(this)).subscribeOn(Schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "fromAction { block.invok…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeWithLastModifiedUpdate$lambda-1  reason: not valid java name */
    public static final void m9775invokeWithLastModifiedUpdate$lambda1(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$block");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeWithLastModifiedUpdate$lambda-2  reason: not valid java name */
    public static final void m9776invokeWithLastModifiedUpdate$lambda2(CartController cartController) {
        Intrinsics.checkNotNullParameter(cartController, "this$0");
        cartController.updateLastModifiedDate();
    }

    public static /* synthetic */ Completable setProductCount$default(CartController cartController, Product product, int i11, boolean z11, Integer num, EventOriginType eventOriginType, TrackingCategoryId trackingCategoryId, SwimlaneTrackingData swimlaneTrackingData, String str, String str2, boolean z12, int i12, Object obj) {
        int i13 = i12;
        return cartController.setProductCount(product, i11, z11, num, eventOriginType, (i13 & 32) != 0 ? null : trackingCategoryId, (i13 & 64) != 0 ? null : swimlaneTrackingData, (i13 & 128) != 0 ? null : str, (i13 & 256) != 0 ? null : str2, (i13 & 512) != 0 ? true : z12);
    }

    private final void trackProductChanged(Product product, int i11, Integer num, String str, EventOriginType eventOriginType, String str2, SwimlaneTrackingData swimlaneTrackingData, TrackingCategoryId trackingCategoryId, String str3, String str4, boolean z11) {
        if (z11) {
            ProductTracker.addToCartClicked$default(this.productTracker, product, i11, num, str, eventOriginType, str2, swimlaneTrackingData, trackingCategoryId, str3, str4, getCartId(), (String) null, 2048, (Object) null);
            return;
        }
        ProductTracker.removeFromCartClicked$default(this.productTracker, product, i11, num, str, eventOriginType, str2, swimlaneTrackingData, trackingCategoryId, str3, (String) null, str4, 512, (Object) null);
    }

    private final void updateLastModifiedDate() {
        this.cartRepository.updateLastModifiedTime(this.timeProvider.getCurrentTimeMillis());
    }

    @NotNull
    public final Completable clearCart() {
        updateLastModifiedDate();
        Completable subscribeOn = Completable.fromAction(new g(this)).subscribeOn(Schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "fromAction {\n           …scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    @NotNull
    public final Completable clearCartIfNeeded() {
        if (this.timeProvider.getCurrentTimeMillis() - getLastModifiedDate() >= TIME_TO_DELETE_IN_MILLIS) {
            return clearCart();
        }
        if (this.sharedPreferences.getBoolean(RESET_DS_CART, false)) {
            disableResetCartFlag();
            return clearCart();
        }
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "complete()");
        return complete;
    }

    public final void clearDuplicateCartId() {
        this.cartRepository.clearCartId();
    }

    public final void clearSelectedVendor() {
        this.cartRepository.setSelectedVendor((CartVendor) null);
    }

    public final void disableResetCartFlag() {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        edit.putBoolean(RESET_DS_CART, false);
        edit.apply();
    }

    @NotNull
    public final Observable<List<Product>> getAllAsObservable() {
        Observable<List<Product>> andThen = clearCartIfNeeded().andThen(this.cartRepository.getAllInStockProducts());
        Intrinsics.checkNotNullExpressionValue(andThen, "clearCartIfNeeded().andT…llInStockProducts()\n    )");
        return andThen;
    }

    @NotNull
    public final Single<Integer> getCartCount() {
        return this.cartRepository.getInStockProductCount();
    }

    @NotNull
    public final String getCartId() {
        return this.cartRepository.getCartId();
    }

    @NotNull
    public final Maybe<CartVendor> getCartOwner() {
        return this.cartRepository.getCartOwner();
    }

    @NotNull
    public final Observable<CheckoutParams> getNavigateToCheckoutActions() {
        return this.cartRepository.getNavigateToCheckoutActions();
    }

    @NotNull
    public final Observable<List<Product>> getOOSProducts() {
        return this.cartRepository.getAllOutOfStockProducts();
    }

    @NotNull
    public final Observable<Unit> observeCartQuantityUpdatedChanges() {
        return this.cartRepository.observeCartQuantityUpdatedChanges();
    }

    @NotNull
    public final Completable setProductCount(@NotNull Product product, int i11, boolean z11, @Nullable Integer num, @NotNull EventOriginType eventOriginType, @Nullable TrackingCategoryId trackingCategoryId, @Nullable SwimlaneTrackingData swimlaneTrackingData, @Nullable String str, @Nullable String str2, boolean z12) {
        Product product2 = product;
        Intrinsics.checkNotNullParameter(product2, "product");
        Intrinsics.checkNotNullParameter(eventOriginType, "eventOriginType");
        Timber.d("Set product count: %d", Integer.valueOf(i11));
        if (z12) {
            d(this, product, i11, num, this.tracker.getScreenName(), eventOriginType, (String) null, swimlaneTrackingData, trackingCategoryId, str, str2, z11, 32, (Object) null);
        }
        Completable ignoreElement = invokeWithLastModifiedUpdate(new CartController$setProductCount$1(this, product2, i11)).andThen(this.cartRepository.getInStockProductCount()).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "@Suppress(\"LongParameter…   .ignoreElement()\n    }");
        return ignoreElement;
    }

    public final void updateCartSyncFailure() {
        this.cartRepository.updateCartSyncFailure();
    }

    public final void updateCartSyncStarted() {
        this.cartRepository.updateCartSyncStarted();
    }

    @NotNull
    public final List<Product> updateCartSyncSuccess(@NotNull CartResponse cartResponse) {
        Intrinsics.checkNotNullParameter(cartResponse, "cartResponse");
        return this.cartRepository.updateCartSyncSuccess(cartResponse);
    }

    @NotNull
    public final List<Product> updateCartSyncSuccessV2(@NotNull CartResponse cartResponse) {
        Intrinsics.checkNotNullParameter(cartResponse, "cartResponse");
        return this.cartRepository.updateCartSyncSuccessV2(cartResponse);
    }
}
