package com.talabat.feature.darkstoresvendor.data.repository;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.darkstoresvendor.data.local.VendorCache;
import com.talabat.feature.darkstoresvendor.data.model.VendorResponse;
import com.talabat.feature.darkstoresvendor.data.remote.GroceryAffordabilityApi;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.feature.darkstoresvendor.domain.model.VendorParams;
import com.talabat.feature.darkstoresvendor.domain.repository.VendorRepository;
import com.talabat.mapper.ModelMapper;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import um.a;
import um.b;
import um.c;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/data/repository/VendorRepositoryImpl;", "Lcom/talabat/feature/darkstoresvendor/domain/repository/VendorRepository;", "vendorCache", "Lcom/talabat/feature/darkstoresvendor/data/local/VendorCache;", "vendorResponseMapper", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstoresvendor/data/model/VendorResponse;", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "groceryAffordabilityApi", "Lcom/talabat/feature/darkstoresvendor/data/remote/GroceryAffordabilityApi;", "(Lcom/talabat/feature/darkstoresvendor/data/local/VendorCache;Lcom/talabat/mapper/ModelMapper;Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;Lcom/talabat/feature/darkstoresvendor/data/remote/GroceryAffordabilityApi;)V", "vendorSingle", "Lio/reactivex/Single;", "getVendorSingle", "()Lio/reactivex/Single;", "setVendorSingle", "(Lio/reactivex/Single;)V", "clearVendorCache", "", "getVendor", "vendorParams", "Lcom/talabat/feature/darkstoresvendor/domain/model/VendorParams;", "getVendorFromApi", "com_talabat_feature_darkstores-vendor_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorRepositoryImpl implements VendorRepository {
    @NotNull
    private final GroceryAffordabilityApi groceryAffordabilityApi;
    @NotNull
    private final RxSchedulersFactory rxSchedulersFactory;
    @NotNull
    private final VendorCache vendorCache;
    @NotNull
    private final ModelMapper<VendorResponse, Vendor> vendorResponseMapper;
    public Single<VendorResponse> vendorSingle;

    @Inject
    public VendorRepositoryImpl(@NotNull VendorCache vendorCache2, @NotNull ModelMapper<VendorResponse, Vendor> modelMapper, @NotNull RxSchedulersFactory rxSchedulersFactory2, @NotNull GroceryAffordabilityApi groceryAffordabilityApi2) {
        Intrinsics.checkNotNullParameter(vendorCache2, "vendorCache");
        Intrinsics.checkNotNullParameter(modelMapper, "vendorResponseMapper");
        Intrinsics.checkNotNullParameter(rxSchedulersFactory2, "rxSchedulersFactory");
        Intrinsics.checkNotNullParameter(groceryAffordabilityApi2, "groceryAffordabilityApi");
        this.vendorCache = vendorCache2;
        this.vendorResponseMapper = modelMapper;
        this.rxSchedulersFactory = rxSchedulersFactory2;
        this.groceryAffordabilityApi = groceryAffordabilityApi2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendor$lambda-0  reason: not valid java name */
    public static final VendorResponse m10215getVendor$lambda0(VendorRepositoryImpl vendorRepositoryImpl, VendorParams vendorParams) {
        Intrinsics.checkNotNullParameter(vendorRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(vendorParams, "$vendorParams");
        return vendorRepositoryImpl.vendorCache.getVendor(vendorParams.getVendorCode());
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendor$lambda-1  reason: not valid java name */
    public static final SingleSource m10216getVendor$lambda1(VendorRepositoryImpl vendorRepositoryImpl, VendorParams vendorParams, Throwable th2) {
        Intrinsics.checkNotNullParameter(vendorRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(vendorParams, "$vendorParams");
        Intrinsics.checkNotNullParameter(th2, "it");
        return vendorRepositoryImpl.getVendorFromApi(vendorParams);
    }

    private final Single<VendorResponse> getVendorFromApi(VendorParams vendorParams) {
        if (this.vendorSingle != null && Intrinsics.areEqual((Object) this.vendorCache.getVendorCode(), (Object) vendorParams.getVendorCode())) {
            return getVendorSingle();
        }
        this.vendorCache.setVendorCode(vendorParams.getVendorCode());
        Single<VendorResponse> doOnSuccess = this.groceryAffordabilityApi.getVendorInfo(vendorParams.getCustomerId(), vendorParams.getVendorCode(), vendorParams.getGlobalEntityId(), vendorParams.getLatitude(), vendorParams.getLongitude()).doOnSuccess(new c(this, vendorParams));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "groceryAffordabilityApi.…orResponse)\n            }");
        setVendorSingle(VendorRepositoryImplKt.cacheButRetryOnError(doOnSuccess));
        return getVendorSingle();
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendorFromApi$lambda-3$lambda-2  reason: not valid java name */
    public static final void m10217getVendorFromApi$lambda3$lambda2(VendorRepositoryImpl vendorRepositoryImpl, VendorParams vendorParams, VendorResponse vendorResponse) {
        Intrinsics.checkNotNullParameter(vendorRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(vendorParams, "$vendorParams");
        VendorCache vendorCache2 = vendorRepositoryImpl.vendorCache;
        String vendorCode = vendorParams.getVendorCode();
        Intrinsics.checkNotNullExpressionValue(vendorResponse, "vendorResponse");
        vendorCache2.cacheVendor(vendorCode, vendorResponse);
    }

    public void clearVendorCache() {
        this.vendorCache.clearCache();
    }

    @NotNull
    public Single<Vendor> getVendor(@NotNull VendorParams vendorParams) {
        Intrinsics.checkNotNullParameter(vendorParams, "vendorParams");
        Single<Vendor> map = Single.fromCallable(new a(this, vendorParams)).onErrorResumeNext(new b(this, vendorParams)).subscribeOn(this.rxSchedulersFactory.io()).map(this.vendorResponseMapper);
        Intrinsics.checkNotNullExpressionValue(map, "fromCallable {\n         …map(vendorResponseMapper)");
        return map;
    }

    @NotNull
    public final Single<VendorResponse> getVendorSingle() {
        Single<VendorResponse> single = this.vendorSingle;
        if (single != null) {
            return single;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vendorSingle");
        return null;
    }

    public final void setVendorSingle(@NotNull Single<VendorResponse> single) {
        Intrinsics.checkNotNullParameter(single, "<set-?>");
        this.vendorSingle = single;
    }
}
