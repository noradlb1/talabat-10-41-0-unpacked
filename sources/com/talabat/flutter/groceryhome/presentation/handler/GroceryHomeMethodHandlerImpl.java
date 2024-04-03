package com.talabat.flutter.groceryhome.presentation.handler;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.flutter.channels.impl.data.tpro.TProChannelCallbackImpl;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.flutter.groceryhome.domain.usecase.GetClosestDarkstoreInfoUseCase;
import com.talabat.flutter.groceryhome.domain.usecase.GetMigratedVendorInfoUseCase;
import com.talabat.flutter.groceryhome.presentation.handler.GroceryHomeMethodHandler;
import datamodels.Restaurant;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import jq.a;
import jq.b;
import jq.c;
import jq.d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001*BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001bH\u0002J\u0018\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010(\u001a\u00020!H\u0016J\u0018\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019*\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandlerImpl;", "Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandler;", "fwfParams", "Lcom/talabat/flutter/groceryhome/presentation/handler/FWFParams;", "callback", "Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandler$Callback;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "deeplinkBundle", "Landroid/os/Bundle;", "verticalIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "tileId", "getClosestDarkstoreInfo", "Lcom/talabat/flutter/groceryhome/domain/usecase/GetClosestDarkstoreInfoUseCase;", "getMigratedVendorInfo", "Lcom/talabat/flutter/groceryhome/domain/usecase/GetMigratedVendorInfoUseCase;", "(Lcom/talabat/flutter/groceryhome/presentation/handler/FWFParams;Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandler$Callback;Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;Landroid/os/Bundle;Ljava/util/ArrayList;ILcom/talabat/flutter/groceryhome/domain/usecase/GetClosestDarkstoreInfoUseCase;Lcom/talabat/flutter/groceryhome/domain/usecase/GetMigratedVendorInfoUseCase;)V", "cartDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "navigationDisposable", "Lio/reactivex/disposables/Disposable;", "getConfigurationMap", "", "", "", "getKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "isTalabatProEnabled", "", "navigateToLifestyleProductListing", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "arguments", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "unsubscribe", "toMap", "LifestyleProductsNavigationData", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryHomeMethodHandlerImpl implements GroceryHomeMethodHandler {
    @NotNull
    private final GroceryHomeMethodHandler.Callback callback;
    @NotNull
    private final CompositeDisposable cartDisposable = new CompositeDisposable();
    @Nullable
    private final Bundle deeplinkBundle;
    @NotNull
    private final FWFParams fwfParams;
    @NotNull
    private final GetClosestDarkstoreInfoUseCase getClosestDarkstoreInfo;
    @NotNull
    private final GetMigratedVendorInfoUseCase getMigratedVendorInfo;
    @Nullable
    private Disposable navigationDisposable;
    @NotNull
    private final RxSchedulersFactory rxSchedulersFactory;
    private final int tileId;
    @NotNull
    private final ArrayList<Integer> verticalIds;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandlerImpl$LifestyleProductsNavigationData;", "", "branchId", "", "swimlaneId", "isDarkstore", "", "collectionName", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getBranchId", "()Ljava/lang/String;", "getCollectionName", "()Z", "getSwimlaneId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LifestyleProductsNavigationData {
        @NotNull
        private final String branchId;
        @NotNull
        private final String collectionName;
        private final boolean isDarkstore;
        @NotNull
        private final String swimlaneId;

        public LifestyleProductsNavigationData(@NotNull String str, @NotNull String str2, boolean z11, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "branchId");
            Intrinsics.checkNotNullParameter(str2, "swimlaneId");
            Intrinsics.checkNotNullParameter(str3, "collectionName");
            this.branchId = str;
            this.swimlaneId = str2;
            this.isDarkstore = z11;
            this.collectionName = str3;
        }

        public static /* synthetic */ LifestyleProductsNavigationData copy$default(LifestyleProductsNavigationData lifestyleProductsNavigationData, String str, String str2, boolean z11, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = lifestyleProductsNavigationData.branchId;
            }
            if ((i11 & 2) != 0) {
                str2 = lifestyleProductsNavigationData.swimlaneId;
            }
            if ((i11 & 4) != 0) {
                z11 = lifestyleProductsNavigationData.isDarkstore;
            }
            if ((i11 & 8) != 0) {
                str3 = lifestyleProductsNavigationData.collectionName;
            }
            return lifestyleProductsNavigationData.copy(str, str2, z11, str3);
        }

        @NotNull
        public final String component1() {
            return this.branchId;
        }

        @NotNull
        public final String component2() {
            return this.swimlaneId;
        }

        public final boolean component3() {
            return this.isDarkstore;
        }

        @NotNull
        public final String component4() {
            return this.collectionName;
        }

        @NotNull
        public final LifestyleProductsNavigationData copy(@NotNull String str, @NotNull String str2, boolean z11, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "branchId");
            Intrinsics.checkNotNullParameter(str2, "swimlaneId");
            Intrinsics.checkNotNullParameter(str3, "collectionName");
            return new LifestyleProductsNavigationData(str, str2, z11, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LifestyleProductsNavigationData)) {
                return false;
            }
            LifestyleProductsNavigationData lifestyleProductsNavigationData = (LifestyleProductsNavigationData) obj;
            return Intrinsics.areEqual((Object) this.branchId, (Object) lifestyleProductsNavigationData.branchId) && Intrinsics.areEqual((Object) this.swimlaneId, (Object) lifestyleProductsNavigationData.swimlaneId) && this.isDarkstore == lifestyleProductsNavigationData.isDarkstore && Intrinsics.areEqual((Object) this.collectionName, (Object) lifestyleProductsNavigationData.collectionName);
        }

        @NotNull
        public final String getBranchId() {
            return this.branchId;
        }

        @NotNull
        public final String getCollectionName() {
            return this.collectionName;
        }

        @NotNull
        public final String getSwimlaneId() {
            return this.swimlaneId;
        }

        public int hashCode() {
            int hashCode = ((this.branchId.hashCode() * 31) + this.swimlaneId.hashCode()) * 31;
            boolean z11 = this.isDarkstore;
            if (z11) {
                z11 = true;
            }
            return ((hashCode + (z11 ? 1 : 0)) * 31) + this.collectionName.hashCode();
        }

        public final boolean isDarkstore() {
            return this.isDarkstore;
        }

        @NotNull
        public String toString() {
            String str = this.branchId;
            String str2 = this.swimlaneId;
            boolean z11 = this.isDarkstore;
            String str3 = this.collectionName;
            return "LifestyleProductsNavigationData(branchId=" + str + ", swimlaneId=" + str2 + ", isDarkstore=" + z11 + ", collectionName=" + str3 + ")";
        }
    }

    public GroceryHomeMethodHandlerImpl(@NotNull FWFParams fWFParams, @NotNull GroceryHomeMethodHandler.Callback callback2, @NotNull RxSchedulersFactory rxSchedulersFactory2, @Nullable Bundle bundle, @NotNull ArrayList<Integer> arrayList, int i11, @NotNull GetClosestDarkstoreInfoUseCase getClosestDarkstoreInfoUseCase, @NotNull GetMigratedVendorInfoUseCase getMigratedVendorInfoUseCase) {
        Intrinsics.checkNotNullParameter(fWFParams, "fwfParams");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        Intrinsics.checkNotNullParameter(rxSchedulersFactory2, "rxSchedulersFactory");
        Intrinsics.checkNotNullParameter(arrayList, "verticalIds");
        Intrinsics.checkNotNullParameter(getClosestDarkstoreInfoUseCase, "getClosestDarkstoreInfo");
        Intrinsics.checkNotNullParameter(getMigratedVendorInfoUseCase, "getMigratedVendorInfo");
        this.fwfParams = fWFParams;
        this.callback = callback2;
        this.rxSchedulersFactory = rxSchedulersFactory2;
        this.deeplinkBundle = bundle;
        this.verticalIds = arrayList;
        this.tileId = i11;
        this.getClosestDarkstoreInfo = getClosestDarkstoreInfoUseCase;
        this.getMigratedVendorInfo = getMigratedVendorInfoUseCase;
    }

    private final Map<String, Object> getConfigurationMap() {
        Map<String, Object> map;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to(TProChannelCallbackImpl.IS_PRO_ENABLED_VALUE_KEY, Boolean.valueOf(isTalabatProEnabled()));
        Bundle bundle = this.deeplinkBundle;
        if (bundle != null) {
            map = toMap(bundle);
        } else {
            map = null;
        }
        pairArr[1] = TuplesKt.to("deeplinkMap", map);
        pairArr[2] = TuplesKt.to("verticalIds", this.verticalIds);
        pairArr[3] = TuplesKt.to("verticalTileId", Integer.valueOf(this.tileId));
        return MapsKt__MapsKt.mapOf(pairArr);
    }

    private final FWFKey getKey() {
        int i11 = this.tileId;
        if (i11 == 1 || i11 == 10) {
            return EcosystemsFeatureFlagsKeys.IS_TALABAT_PRO_SUBSCRIPTION_ENABLED;
        }
        return null;
    }

    private final boolean isTalabatProEnabled() {
        FWFKey key = getKey();
        if (key != null) {
            return this.fwfParams.getTalabatExperiment().getBooleanVariant(key, false, TalabatExperimentDataSourceStrategy.FWF);
        }
        return false;
    }

    private final void navigateToLifestyleProductListing(MethodChannel.Result result, Object obj) {
        Disposable disposable = this.navigationDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        this.navigationDisposable = Single.fromCallable(new a(obj)).map(new b()).flatMap(new a(this)).observeOn(this.rxSchedulersFactory.main()).subscribe(new c(this, result));
    }

    /* access modifiers changed from: private */
    /* renamed from: navigateToLifestyleProductListing$lambda-1  reason: not valid java name */
    public static final Map m10474navigateToLifestyleProductListing$lambda1(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "$arguments");
        return (Map) obj;
    }

    /* access modifiers changed from: private */
    /* renamed from: navigateToLifestyleProductListing$lambda-2  reason: not valid java name */
    public static final LifestyleProductsNavigationData m10475navigateToLifestyleProductListing$lambda2(Map map) {
        Intrinsics.checkNotNullParameter(map, "argumentMap");
        Object obj = map.get("branchId");
        if (obj != null) {
            String str = (String) obj;
            Object obj2 = map.get("swimlaneId");
            if (obj2 != null) {
                String str2 = (String) obj2;
                Object obj3 = map.get("isDarkstore");
                if (obj3 != null) {
                    boolean booleanValue = ((Boolean) obj3).booleanValue();
                    Object obj4 = map.get("collectionName");
                    if (obj4 != null) {
                        return new LifestyleProductsNavigationData(str, str2, booleanValue, (String) obj4);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    /* access modifiers changed from: private */
    /* renamed from: navigateToLifestyleProductListing$lambda-4  reason: not valid java name */
    public static final SingleSource m10476navigateToLifestyleProductListing$lambda4(GroceryHomeMethodHandlerImpl groceryHomeMethodHandlerImpl, LifestyleProductsNavigationData lifestyleProductsNavigationData) {
        Single<Restaurant> single;
        Intrinsics.checkNotNullParameter(groceryHomeMethodHandlerImpl, "this$0");
        Intrinsics.checkNotNullParameter(lifestyleProductsNavigationData, "<name for destructuring parameter 0>");
        String component1 = lifestyleProductsNavigationData.component1();
        String component2 = lifestyleProductsNavigationData.component2();
        boolean component3 = lifestyleProductsNavigationData.component3();
        String component4 = lifestyleProductsNavigationData.component4();
        if (component3) {
            single = groceryHomeMethodHandlerImpl.getClosestDarkstoreInfo.invoke();
        } else {
            single = groceryHomeMethodHandlerImpl.getMigratedVendorInfo.invoke(component1);
        }
        return single.map(new d(component2, component4));
    }

    /* access modifiers changed from: private */
    /* renamed from: navigateToLifestyleProductListing$lambda-4$lambda-3  reason: not valid java name */
    public static final Triple m10477navigateToLifestyleProductListing$lambda4$lambda3(String str, String str2, Restaurant restaurant) {
        Intrinsics.checkNotNullParameter(str, "$swimlaneId");
        Intrinsics.checkNotNullParameter(str2, "$collectionName");
        Intrinsics.checkNotNullParameter(restaurant, "vendor");
        return new Triple(restaurant, str, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: navigateToLifestyleProductListing$lambda-5  reason: not valid java name */
    public static final void m10478navigateToLifestyleProductListing$lambda5(GroceryHomeMethodHandlerImpl groceryHomeMethodHandlerImpl, MethodChannel.Result result, Triple triple) {
        Intrinsics.checkNotNullParameter(groceryHomeMethodHandlerImpl, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        Restaurant restaurant = (Restaurant) triple.component1();
        GroceryHomeMethodHandler.Callback callback2 = groceryHomeMethodHandlerImpl.callback;
        Intrinsics.checkNotNullExpressionValue(restaurant, "vendor");
        callback2.onNavigationToLifestyleProducts(restaurant, (String) triple.component2(), (String) triple.component3());
        result.success((Object) null);
    }

    private final Map<String, Object> toMap(Bundle bundle) {
        HashMap hashMap = new HashMap(bundle.size());
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if (obj != null) {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (Intrinsics.areEqual((Object) str, (Object) "getConfiguration")) {
            result.success(getConfigurationMap());
        } else if (Intrinsics.areEqual((Object) str, (Object) "navigateToLifestyleProductListing")) {
            Object obj = methodCall.arguments;
            Intrinsics.checkNotNullExpressionValue(obj, "call.arguments");
            navigateToLifestyleProductListing(result, obj);
        }
    }

    public void unsubscribe() {
        this.cartDisposable.clear();
        Disposable disposable = this.navigationDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        this.navigationDisposable = null;
    }
}
