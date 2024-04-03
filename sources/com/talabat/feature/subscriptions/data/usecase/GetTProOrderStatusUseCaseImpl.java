package com.talabat.feature.subscriptions.data.usecase;

import buisnessmodels.Cart;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import com.talabat.feature.subscriptions.domain.usecase.GetTProOrderStatusUseCase;
import datamodels.Restaurant;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 22\u00020\u0001:\u00012B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJD\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00192!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001f0$H\u0002J\u0012\u0010)\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u0010*\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010+\u001a\u00020\u0019H\u0002J\b\u0010,\u001a\u00020\u0019H\u0002J,\u0010-\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010*\u001a\u00020\u0019H\u0002J \u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020%2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0014H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"Lcom/talabat/feature/subscriptions/data/usecase/GetTProOrderStatusUseCaseImpl;", "Lcom/talabat/feature/subscriptions/domain/usecase/GetTProOrderStatusUseCase;", "subscriptionsFlags", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "subscriptionsTracker", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "subscriptionsRepository", "Lcom/talabat/feature/subscriptions/data/SubscriptionsRepositoryImpl;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;Lcom/talabat/feature/subscriptions/data/SubscriptionsRepositoryImpl;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "calculateMOVdifference", "", "mov", "cart", "Lbuisnessmodels/Cart;", "checkDeliveryValue", "", "restaurant", "Ldatamodels/Restaurant;", "getMovForVendor", "(Ldatamodels/Restaurant;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "", "shouldUpdateCart", "subscribeAtCheckout", "shouldMOVRecalculate", "onTProOrderStatusLoaded", "Lkotlin/Function1;", "Lcom/talabat/feature/subscriptions/domain/model/TProOrderStatus;", "Lkotlin/ParameterName;", "name", "tProOrderStatus", "isFlagEnabledForVendor", "isFreeDeliveryEligibleVendor", "isTProEnabledForNfv", "isTProEnabledForTMart", "observeDataFromInvoke", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "observeDataOnSuccess", "result", "Companion", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetTProOrderStatusUseCaseImpl implements GetTProOrderStatusUseCase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final HashMap<Integer, Float> movCache = new HashMap<>();
    /* access modifiers changed from: private */
    @NotNull
    public final CoroutineDispatchersFactory coroutineDispatchersFactory;
    @NotNull
    private CoroutineScope coroutineScope = new GetTProOrderStatusUseCaseImpl$coroutineScope$1(this);
    @NotNull
    private final ISubscriptionStatusRepository subscriptionStatusRepository;
    @NotNull
    private final ISubscriptionsFeatureFlagsRepository subscriptionsFlags;
    @NotNull
    private final SubscriptionsRepositoryImpl subscriptionsRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final ISubscriptionsTracker subscriptionsTracker;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/talabat/feature/subscriptions/data/usecase/GetTProOrderStatusUseCaseImpl$Companion;", "", "()V", "movCache", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getMovCache", "()Ljava/util/HashMap;", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HashMap<Integer, Float> getMovCache() {
            return GetTProOrderStatusUseCaseImpl.movCache;
        }
    }

    @Inject
    public GetTProOrderStatusUseCaseImpl(@NotNull ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository, @NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository, @NotNull ISubscriptionsTracker iSubscriptionsTracker, @NotNull SubscriptionsRepositoryImpl subscriptionsRepositoryImpl, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2) {
        Intrinsics.checkNotNullParameter(iSubscriptionsFeatureFlagsRepository, "subscriptionsFlags");
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "subscriptionStatusRepository");
        Intrinsics.checkNotNullParameter(iSubscriptionsTracker, "subscriptionsTracker");
        Intrinsics.checkNotNullParameter(subscriptionsRepositoryImpl, "subscriptionsRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "coroutineDispatchersFactory");
        this.subscriptionsFlags = iSubscriptionsFeatureFlagsRepository;
        this.subscriptionStatusRepository = iSubscriptionStatusRepository;
        this.subscriptionsTracker = iSubscriptionsTracker;
        this.subscriptionsRepository = subscriptionsRepositoryImpl;
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
    }

    /* access modifiers changed from: private */
    public final float calculateMOVdifference(float f11, Cart cart) {
        return f11 - cart.getCartTotalPrice(false);
    }

    /* access modifiers changed from: private */
    public final boolean checkDeliveryValue(Restaurant restaurant, Cart cart) {
        boolean z11;
        float calculateDeliveryCharges = cart.calculateDeliveryCharges();
        if (restaurant.deliveryCharges > 0.0f || calculateDeliveryCharges < 0.0f || cart.getDeliveryCharges() > 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.subscriptionsTracker.tProOrderStatusDeliveryValue(Boolean.valueOf(z11), Float.valueOf(cart.getDeliveryCharges()), Float.valueOf(calculateDeliveryCharges), Float.valueOf(restaurant.deliveryCharges));
        return z11;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getMovForVendor(datamodels.Restaurant r5, kotlin.coroutines.Continuation<? super java.lang.Float> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.feature.subscriptions.data.usecase.GetTProOrderStatusUseCaseImpl$getMovForVendor$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.feature.subscriptions.data.usecase.GetTProOrderStatusUseCaseImpl$getMovForVendor$1 r0 = (com.talabat.feature.subscriptions.data.usecase.GetTProOrderStatusUseCaseImpl$getMovForVendor$1) r0
            int r1 = r0.f58963j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58963j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.data.usecase.GetTProOrderStatusUseCaseImpl$getMovForVendor$1 r0 = new com.talabat.feature.subscriptions.data.usecase.GetTProOrderStatusUseCaseImpl$getMovForVendor$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f58961h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58963j
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0029 }
            goto L_0x0060
        L_0x0029:
            r5 = move-exception
            goto L_0x0067
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.HashMap<java.lang.Integer, java.lang.Float> r6 = movCache
            int r2 = r5.branchId
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            java.lang.Object r2 = r6.get(r2)
            if (r2 == 0) goto L_0x0051
            int r5 = r5.branchId
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            java.lang.Object r5 = r6.get(r5)
            java.lang.Float r5 = (java.lang.Float) r5
            goto L_0x00a6
        L_0x0051:
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0029 }
            com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl r6 = r4.subscriptionsRepository     // Catch:{ all -> 0x0029 }
            int r5 = r5.branchId     // Catch:{ all -> 0x0029 }
            r0.f58963j = r3     // Catch:{ all -> 0x0029 }
            java.lang.Object r6 = r6.getProVendorMov(r5, r0)     // Catch:{ all -> 0x0029 }
            if (r6 != r1) goto L_0x0060
            return r1
        L_0x0060:
            com.talabat.feature.subscriptions.domain.model.ProVendorMov r6 = (com.talabat.feature.subscriptions.domain.model.ProVendorMov) r6     // Catch:{ all -> 0x0029 }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x0029 }
            goto L_0x0071
        L_0x0067:
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0071:
            boolean r6 = kotlin.Result.m6336isSuccessimpl(r5)
            if (r6 == 0) goto L_0x0094
            r6 = r5
            com.talabat.feature.subscriptions.domain.model.ProVendorMov r6 = (com.talabat.feature.subscriptions.domain.model.ProVendorMov) r6
            java.lang.Float r0 = r6.getMov()
            if (r0 == 0) goto L_0x0094
            r1 = 0
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Float) r0, (float) r1)
            if (r1 != 0) goto L_0x0094
            java.util.HashMap<java.lang.Integer, java.lang.Float> r1 = movCache
            int r6 = r6.getBranchId()
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            r1.put(r6, r0)
        L_0x0094:
            boolean r6 = kotlin.Result.m6335isFailureimpl(r5)
            r0 = 0
            if (r6 == 0) goto L_0x009c
            r5 = r0
        L_0x009c:
            com.talabat.feature.subscriptions.domain.model.ProVendorMov r5 = (com.talabat.feature.subscriptions.domain.model.ProVendorMov) r5
            if (r5 == 0) goto L_0x00a5
            java.lang.Float r5 = r5.getMov()
            goto L_0x00a6
        L_0x00a5:
            r5 = r0
        L_0x00a6:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.usecase.GetTProOrderStatusUseCaseImpl.getMovForVendor(datamodels.Restaurant, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean isFlagEnabledForVendor(Restaurant restaurant) {
        boolean z11;
        Integer num;
        boolean isTProEnabledForTMart = isTProEnabledForTMart();
        boolean isTProEnabledForNfv = isTProEnabledForNfv();
        if (restaurant == null) {
            z11 = false;
        } else if (restaurant.shopType == 0) {
            z11 = true;
        } else if (restaurant.isTMart()) {
            z11 = isTProEnabledForTMart();
        } else {
            z11 = isTProEnabledForNfv();
        }
        ISubscriptionsTracker iSubscriptionsTracker = this.subscriptionsTracker;
        if (restaurant != null) {
            num = Integer.valueOf(restaurant.shopType);
        } else {
            num = null;
        }
        iSubscriptionsTracker.tProOrderStatusFlags(num, Boolean.valueOf(isTProEnabledForTMart), Boolean.valueOf(isTProEnabledForNfv), Boolean.valueOf(z11));
        return z11;
    }

    private final boolean isFreeDeliveryEligibleVendor(Restaurant restaurant) {
        boolean z11;
        boolean z12;
        if (!isFlagEnabledForVendor(restaurant)) {
            return false;
        }
        if (restaurant == null || !restaurant.isProRestaurant) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (restaurant != null) {
            z12 = Intrinsics.areEqual((Object) restaurant.isPickup(), (Object) Boolean.TRUE);
        } else {
            z12 = false;
        }
        if (z12 || !z11) {
            return false;
        }
        return true;
    }

    private final boolean isTProEnabledForNfv() {
        return this.subscriptionsFlags.isTProEnabledForNFV();
    }

    private final boolean isTProEnabledForTMart() {
        return this.subscriptionsFlags.isTProEnabledForTMart();
    }

    private final void observeDataFromInvoke(boolean z11, Restaurant restaurant, Subscription subscription, boolean z12) {
        String str;
        Boolean bool;
        String str2;
        String str3;
        String str4;
        Boolean bool2;
        ISubscriptionsTracker iSubscriptionsTracker = this.subscriptionsTracker;
        boolean isTProUser = this.subscriptionStatusRepository.isTProUser();
        if (subscription != null) {
            str = subscription.getMembershipId();
        } else {
            str = null;
        }
        if (restaurant != null) {
            bool = Boolean.valueOf(restaurant.isProRestaurant);
        } else {
            bool = null;
        }
        if (restaurant != null) {
            str2 = Integer.valueOf(restaurant.f13872id).toString();
        } else {
            str2 = null;
        }
        if (restaurant != null) {
            str3 = Integer.valueOf(restaurant.branchId).toString();
        } else {
            str3 = null;
        }
        if (restaurant != null) {
            str4 = restaurant.branchName;
        } else {
            str4 = null;
        }
        if (restaurant != null) {
            bool2 = restaurant.isPickup();
        } else {
            bool2 = null;
        }
        iSubscriptionsTracker.tProOrderStatusInvoke(Boolean.valueOf(isTProUser), Boolean.valueOf(z11), str, Boolean.valueOf(z12), bool, str2, str3, str4, bool2);
    }

    /* access modifiers changed from: private */
    public final void observeDataOnSuccess(TProOrderStatus tProOrderStatus, boolean z11, float f11) {
        this.subscriptionsTracker.tProOrderStatusSuccess(String.valueOf(f11), tProOrderStatus, Boolean.valueOf(z11));
    }

    @NotNull
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public void invoke(boolean z11, boolean z12, boolean z13, @NotNull Function1<? super TProOrderStatus, Unit> function1) {
        boolean z14;
        boolean z15 = z12;
        Function1<? super TProOrderStatus, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(function12, "onTProOrderStatusLoaded");
        Cart instance = Cart.getInstance();
        Restaurant restaurant = instance.getRestaurant();
        if (this.subscriptionStatusRepository.isTProUser() || z15) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z15) {
            instance.setFreeDelivery(true);
        }
        Subscription tProSubscriptionInfo = this.subscriptionStatusRepository.getTProSubscriptionInfo();
        boolean isFreeDeliveryEligibleVendor = isFreeDeliveryEligibleVendor(restaurant);
        observeDataFromInvoke(z15, restaurant, tProSubscriptionInfo, isFreeDeliveryEligibleVendor);
        if (tProSubscriptionInfo == null || restaurant == null || ((!z14 && !z13) || !isFreeDeliveryEligibleVendor)) {
            instance.setFreeDelivery(false);
            function12.invoke(new TProOrderStatus(false, 0.0d, false, false, 15, (DefaultConstructorMarker) null));
            ISubscriptionsTracker.DefaultImpls.tProOrderStatus$default(this.subscriptionsTracker, "GetTProOrderStatusUseCase -> preChecks return", (String) null, Boolean.FALSE, 2, (Object) null);
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new GetTProOrderStatusUseCaseImpl$invoke$1(this, restaurant, function1, instance, z14, isFreeDeliveryEligibleVendor, z11, (Continuation<? super GetTProOrderStatusUseCaseImpl$invoke$1>) null), 3, (Object) null);
    }

    public final void setCoroutineScope(@NotNull CoroutineScope coroutineScope2) {
        Intrinsics.checkNotNullParameter(coroutineScope2, "<set-?>");
        this.coroutineScope = coroutineScope2;
    }
}
