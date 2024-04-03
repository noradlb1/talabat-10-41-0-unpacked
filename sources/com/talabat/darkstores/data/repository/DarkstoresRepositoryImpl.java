package com.talabat.darkstores.data.repository;

import JsonModels.parser.UniversalGson;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.darkstores.data.vendors.remote.VendorsApi;
import com.talabat.darkstores.di.qualifier.IoScheduler;
import com.talabat.feature.darkstores.domain.repository.DarkstoresRepository;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import com.talabat.helpers.GlobalConstants;
import datamodels.Restaurant;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import ki.a;
import ki.b;
import ki.c;
import ki.d;
import ki.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001By\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\u000e\b\u0001\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\fH\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0018H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0018H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0011\u0010#\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020&H\u0016J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u0006\u0010(\u001a\u00020\fH\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001dH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/talabat/darkstores/data/repository/DarkstoresRepositoryImpl;", "Lcom/talabat/feature/darkstores/domain/repository/DarkstoresRepository;", "cartRepository", "Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;", "sharedPreferences", "Landroid/content/SharedPreferences;", "vendorsApi", "Lcom/talabat/darkstores/data/vendors/remote/VendorsApi;", "selectedAreaId", "Ljavax/inject/Provider;", "", "selectedLatitude", "", "selectedLongitude", "selectedCountryId", "ioScheduler", "Lio/reactivex/Scheduler;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "gson", "Lcom/google/gson/Gson;", "(Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;Landroid/content/SharedPreferences;Lcom/talabat/darkstores/data/vendors/remote/VendorsApi;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Lio/reactivex/Scheduler;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;Lcom/google/gson/Gson;)V", "getCartId", "getCartItemCount", "Lio/reactivex/Single;", "getCartTotalValue", "", "getCartVendor", "Lio/reactivex/Maybe;", "Ldatamodels/Restaurant;", "getLastVisitedVendor", "getMigratedVendor", "LJsonModels/Response/MenuItemResponse;", "branchId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNearestDarkstoreVendor", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDarkstoresCartClearedFromCheckout", "", "optString", "key", "putLastVisitedVendor", "Lio/reactivex/Completable;", "restaurant", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresRepositoryImpl implements DarkstoresRepository {
    @NotNull
    private final DarkstoresCartRepository cartRepository;
    @NotNull
    private final CoroutineDispatchersFactory coroutineDispatchersFactory;
    @NotNull
    private final Gson gson;
    @NotNull
    private final Scheduler ioScheduler;
    /* access modifiers changed from: private */
    @NotNull
    public final Provider<Integer> selectedAreaId;
    /* access modifiers changed from: private */
    @NotNull
    public final Provider<Integer> selectedCountryId;
    /* access modifiers changed from: private */
    @NotNull
    public final Provider<String> selectedLatitude;
    /* access modifiers changed from: private */
    @NotNull
    public final Provider<String> selectedLongitude;
    @NotNull
    private final SharedPreferences sharedPreferences;
    @NotNull
    private final VendorsApi vendorsApi;

    @Inject
    public DarkstoresRepositoryImpl(@NotNull DarkstoresCartRepository darkstoresCartRepository, @NotNull SharedPreferences sharedPreferences2, @NotNull VendorsApi vendorsApi2, @NotNull @Named("selectedAreaId") Provider<Integer> provider, @NotNull @Named("selectedLatitude") Provider<String> provider2, @NotNull @Named("selectedLongitude") Provider<String> provider3, @NotNull @Named("selectedCountryId") Provider<Integer> provider4, @IoScheduler @NotNull Scheduler scheduler, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2, @NotNull Gson gson2) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "cartRepository");
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        Intrinsics.checkNotNullParameter(vendorsApi2, "vendorsApi");
        Intrinsics.checkNotNullParameter(provider, GlobalConstants.ExtraNames.SELECTED_AREA_ID);
        Intrinsics.checkNotNullParameter(provider2, "selectedLatitude");
        Intrinsics.checkNotNullParameter(provider3, "selectedLongitude");
        Intrinsics.checkNotNullParameter(provider4, "selectedCountryId");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "coroutineDispatchersFactory");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.cartRepository = darkstoresCartRepository;
        this.sharedPreferences = sharedPreferences2;
        this.vendorsApi = vendorsApi2;
        this.selectedAreaId = provider;
        this.selectedLatitude = provider2;
        this.selectedLongitude = provider3;
        this.selectedCountryId = provider4;
        this.ioScheduler = scheduler;
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
        this.gson = gson2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getCartTotalValue$lambda-1  reason: not valid java name */
    public static final Double m9728getCartTotalValue$lambda1(List list) {
        Intrinsics.checkNotNullParameter(list, "products");
        Iterator it = list.iterator();
        double d11 = 0.0d;
        while (it.hasNext()) {
            d11 += getCartTotalValue$totalPrice((Product) it.next());
        }
        return Double.valueOf(d11);
    }

    private static final double getCartTotalValue$totalPrice(Product product) {
        return ((double) product.getPrice()) * ((double) product.getCartCount());
    }

    /* access modifiers changed from: private */
    /* renamed from: getCartVendor$lambda-0  reason: not valid java name */
    public static final Restaurant m9729getCartVendor$lambda0(DarkstoresRepositoryImpl darkstoresRepositoryImpl, String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(darkstoresRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(str, "restaurantJson");
        Gson gson2 = darkstoresRepositoryImpl.gson;
        Class cls = Restaurant.class;
        if (!(gson2 instanceof Gson)) {
            obj = gson2.fromJson(str, cls);
        } else {
            obj = GsonInstrumentation.fromJson(gson2, str, cls);
        }
        return (Restaurant) obj;
    }

    /* access modifiers changed from: private */
    /* renamed from: getLastVisitedVendor$lambda-4  reason: not valid java name */
    public static final Restaurant m9730getLastVisitedVendor$lambda4(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "restaurantJson");
        Gson gson2 = UniversalGson.INSTANCE.gson;
        Class cls = Restaurant.class;
        if (!(gson2 instanceof Gson)) {
            obj = gson2.fromJson(str, cls);
        } else {
            obj = GsonInstrumentation.fromJson(gson2, str, cls);
        }
        return (Restaurant) obj;
    }

    private final Maybe<String> optString(String str) {
        Maybe<String> subscribeOn = Maybe.create(new b(this, str)).subscribeOn(this.ioScheduler);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "create<String> { emitter….subscribeOn(ioScheduler)");
        return subscribeOn;
    }

    /* access modifiers changed from: private */
    /* renamed from: optString$lambda-5  reason: not valid java name */
    public static final void m9731optString$lambda5(DarkstoresRepositoryImpl darkstoresRepositoryImpl, String str, MaybeEmitter maybeEmitter) {
        Intrinsics.checkNotNullParameter(darkstoresRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(str, "$key");
        Intrinsics.checkNotNullParameter(maybeEmitter, "emitter");
        if (darkstoresRepositoryImpl.sharedPreferences.contains(str)) {
            String str2 = "";
            String string = darkstoresRepositoryImpl.sharedPreferences.getString(str, str2);
            if (string != null) {
                str2 = string;
            }
            maybeEmitter.onSuccess(str2);
            return;
        }
        maybeEmitter.onComplete();
    }

    /* access modifiers changed from: private */
    /* renamed from: putLastVisitedVendor$lambda-3  reason: not valid java name */
    public static final void m9732putLastVisitedVendor$lambda3(DarkstoresRepositoryImpl darkstoresRepositoryImpl, Restaurant restaurant) {
        String str;
        Intrinsics.checkNotNullParameter(darkstoresRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(restaurant, "$restaurant");
        SharedPreferences.Editor edit = darkstoresRepositoryImpl.sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        Gson gson2 = UniversalGson.INSTANCE.gson;
        if (!(gson2 instanceof Gson)) {
            str = gson2.toJson((Object) restaurant);
        } else {
            str = GsonInstrumentation.toJson(gson2, (Object) restaurant);
        }
        edit.putString("RESTAURANT_JSON", str);
        edit.apply();
    }

    @NotNull
    public String getCartId() {
        return this.cartRepository.getCartId();
    }

    @NotNull
    public Single<Integer> getCartItemCount() {
        Single<Integer> subscribeOn = this.cartRepository.getInStockProductCount().subscribeOn(this.ioScheduler);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "cartRepository.getInStoc….subscribeOn(ioScheduler)");
        return subscribeOn;
    }

    @NotNull
    public Single<Double> getCartTotalValue() {
        Single<R> subscribeOn = this.cartRepository.getAllInStockProductsAsMaybe().map(new a()).toSingle(Double.valueOf(0.0d)).subscribeOn(this.ioScheduler);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "cartRepository.getAllInS….subscribeOn(ioScheduler)");
        return subscribeOn;
    }

    @NotNull
    public Maybe<Restaurant> getCartVendor() {
        Maybe<R> subscribeOn = this.cartRepository.getCartVendorJson().map(new c(this)).subscribeOn(this.ioScheduler);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "cartRepository.getCartVe….subscribeOn(ioScheduler)");
        return subscribeOn;
    }

    @NotNull
    public Maybe<Restaurant> getLastVisitedVendor() {
        Maybe<R> onErrorComplete = optString("RESTAURANT_JSON").map(new e()).onErrorComplete();
        Intrinsics.checkNotNullExpressionValue(onErrorComplete, "optString(KEY_RESTAURANT…       .onErrorComplete()");
        return onErrorComplete;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getMigratedVendor(@org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super JsonModels.Response.MenuItemResponse> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl$getMigratedVendor$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl$getMigratedVendor$1 r0 = (com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl$getMigratedVendor$1) r0
            int r1 = r0.f56207j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f56207j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl$getMigratedVendor$1 r0 = new com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl$getMigratedVendor$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f56205h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f56207j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0049
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory r7 = r5.coroutineDispatchersFactory
            kotlinx.coroutines.CoroutineDispatcher r7 = r7.io()
            com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl$getMigratedVendor$2 r2 = new com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl$getMigratedVendor$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.f56207j = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            if (r7 != r1) goto L_0x0049
            return r1
        L_0x0049:
            java.lang.String r6 = "override suspend fun get…  .awaitFirst()\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl.getMigratedVendor(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0072 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getNearestDarkstoreVendor(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super datamodels.Restaurant> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl$getNearestDarkstoreVendor$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl$getNearestDarkstoreVendor$1 r0 = (com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl$getNearestDarkstoreVendor$1) r0
            int r1 = r0.f56213j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f56213j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl$getNearestDarkstoreVendor$1 r0 = new com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl$getNearestDarkstoreVendor$1
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f56211h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f56213j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006a
        L_0x0029:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r8)
            com.talabat.darkstores.data.vendors.remote.VendorsApi r8 = r7.vendorsApi
            javax.inject.Provider<java.lang.Integer> r2 = r7.selectedAreaId
            java.lang.Object r2 = r2.get()
            java.lang.String r4 = "selectedAreaId.get()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            javax.inject.Provider<java.lang.String> r4 = r7.selectedLatitude
            java.lang.Object r4 = r4.get()
            java.lang.String r5 = "selectedLatitude.get()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.String r4 = (java.lang.String) r4
            javax.inject.Provider<java.lang.String> r5 = r7.selectedLongitude
            java.lang.Object r5 = r5.get()
            java.lang.String r6 = "selectedLongitude.get()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.String r5 = (java.lang.String) r5
            r0.f56213j = r3
            java.lang.Object r8 = r8.getInfo(r2, r4, r5, r0)
            if (r8 != r1) goto L_0x006a
            return r1
        L_0x006a:
            JsonModels.Response.Darkstores.DarkStoresEntryPointResponse r8 = (JsonModels.Response.Darkstores.DarkStoresEntryPointResponse) r8
            datamodels.Restaurant r0 = r8.getResult()
            if (r0 == 0) goto L_0x0073
            return r0
        L_0x0073:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            datamodels.Restaurant r8 = r8.getResult()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "DarkStoreInfo api result is null "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl.getNearestDarkstoreVendor(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean isDarkstoresCartClearedFromCheckout() {
        return this.sharedPreferences.getBoolean("reset_ds_cart", false);
    }

    @NotNull
    public Completable putLastVisitedVendor(@NotNull Restaurant restaurant) {
        Intrinsics.checkNotNullParameter(restaurant, "restaurant");
        Completable subscribeOn = Completable.fromRunnable(new d(this, restaurant)).subscribeOn(this.ioScheduler);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "fromRunnable {\n         ….subscribeOn(ioScheduler)");
        return subscribeOn;
    }
}
