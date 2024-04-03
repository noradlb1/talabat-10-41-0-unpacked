package com.talabat.feature.darkstores.swimlanes.data;

import com.talabat.configuration.country.Country;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceFeatureFlagsKeys;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.darkstores.swimlanes.data.remote.SwimlanesApi;
import com.talabat.feature.darkstores.swimlanes.data.remote.model.SwimLanesResult;
import com.talabat.feature.darkstores.swimlanes.data.remote.model.SwimlanesProductResponse;
import com.talabat.feature.darkstores.swimlanes.data.remote.model.SwimlanesResponse;
import com.talabat.feature.darkstores.swimlanes.data.remote.model.SwimlanesResponseData;
import com.talabat.feature.darkstores.swimlanes.domain.SwimlanesRepository;
import com.talabat.feature.darkstores.swimlanes.domain.model.SwimlanesData;
import com.talabat.feature.darkstores.swimlanes.domain.model.SwimlanesRequest;
import com.talabat.mapper.ModelMapper;
import io.reactivex.Single;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vl.a;
import vl.b;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BE\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00162\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001dH\u0002J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/data/RealSwimlanesRepository;", "Lcom/talabat/feature/darkstores/swimlanes/domain/SwimlanesRepository;", "selectedCountry", "Lcom/talabat/configuration/country/Country;", "swimlanesApi", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/SwimlanesApi;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "swimlanesMapper", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimlanesResponse;", "Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesData;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/configuration/country/Country;Lcom/talabat/feature/darkstores/swimlanes/data/remote/SwimlanesApi;Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;Lcom/talabat/mapper/ModelMapper;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "getSwimlanes", "Lio/reactivex/Single;", "request", "Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesRequest;", "isSwimlanesEnabled", "", "isValidResponse", "swimlanesResponse", "isValidSwimlaneProducts", "swimlanes", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimlanesResponseData;", "isValidSwimlanes", "", "trackObservabilityEvent", "", "vendorId", "", "productId", "productSku", "com_talabat_feature_darkstores-swimlanes_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RealSwimlanesRepository implements SwimlanesRepository {
    @NotNull
    private final ITalabatFeatureFlag featureFlag;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final RxSchedulersFactory rxSchedulersFactory;
    @NotNull
    private final Country selectedCountry;
    @NotNull
    private final SwimlanesApi swimlanesApi;
    @NotNull
    private final ModelMapper<SwimlanesResponse, SwimlanesData> swimlanesMapper;

    @Inject
    public RealSwimlanesRepository(@NotNull @Named("selectedCountry") Country country, @NotNull SwimlanesApi swimlanesApi2, @NotNull RxSchedulersFactory rxSchedulersFactory2, @NotNull ModelMapper<SwimlanesResponse, SwimlanesData> modelMapper, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(country, "selectedCountry");
        Intrinsics.checkNotNullParameter(swimlanesApi2, "swimlanesApi");
        Intrinsics.checkNotNullParameter(rxSchedulersFactory2, "rxSchedulersFactory");
        Intrinsics.checkNotNullParameter(modelMapper, "swimlanesMapper");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.selectedCountry = country;
        this.swimlanesApi = swimlanesApi2;
        this.rxSchedulersFactory = rxSchedulersFactory2;
        this.swimlanesMapper = modelMapper;
        this.featureFlag = iTalabatFeatureFlag;
        this.observabilityManager = iObservabilityManager;
    }

    /* access modifiers changed from: private */
    /* renamed from: getSwimlanes$lambda-0  reason: not valid java name */
    public static final SwimlanesData m10148getSwimlanes$lambda0(RealSwimlanesRepository realSwimlanesRepository, SwimlanesRequest swimlanesRequest, SwimlanesData swimlanesData, SwimlanesResponse swimlanesResponse) {
        Intrinsics.checkNotNullParameter(realSwimlanesRepository, "this$0");
        Intrinsics.checkNotNullParameter(swimlanesRequest, "$request");
        Intrinsics.checkNotNullParameter(swimlanesResponse, "response");
        if (realSwimlanesRepository.isValidResponse(swimlanesResponse)) {
            return realSwimlanesRepository.swimlanesMapper.apply(swimlanesResponse);
        }
        realSwimlanesRepository.trackObservabilityEvent(swimlanesRequest.getVendorId(), swimlanesRequest.getProductId(), swimlanesRequest.getProductSku());
        return swimlanesData;
    }

    /* access modifiers changed from: private */
    /* renamed from: getSwimlanes$lambda-1  reason: not valid java name */
    public static final SwimlanesData m10149getSwimlanes$lambda1(SwimlanesData swimlanesData, Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return swimlanesData;
    }

    private final boolean isSwimlanesEnabled() {
        return this.featureFlag.getFeatureFlag(QCommerceFeatureFlagsKeys.PRODUCT_DETAIL_PAGE_SWIMLANES, false);
    }

    private final boolean isValidResponse(SwimlanesResponse swimlanesResponse) {
        SwimLanesResult result = swimlanesResponse.getResult();
        return isValidSwimlanes(result != null ? result.getSwimlanes() : null);
    }

    private final boolean isValidSwimlaneProducts(SwimlanesResponseData swimlanesResponseData) {
        List<SwimlanesProductResponse> products = swimlanesResponseData.getProducts();
        return products != null && (products.isEmpty() ^ true);
    }

    private final boolean isValidSwimlanes(List<SwimlanesResponseData> list) {
        boolean z11;
        if (list == null || !(!list.isEmpty())) {
            return false;
        }
        Iterable iterable = list;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!isValidSwimlaneProducts((SwimlanesResponseData) it.next())) {
                        z11 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z11 = true;
        if (z11) {
            return true;
        }
        return false;
    }

    private final void trackObservabilityEvent(String str, String str2, String str3) {
        this.observabilityManager.track("SwimlanesResponseError", "DarkstoreEvents", MapsKt__MapsKt.mapOf(TuplesKt.to("vendorID", str), TuplesKt.to("productID", str2), TuplesKt.to("productSKU", str3)));
    }

    @NotNull
    public Single<SwimlanesData> getSwimlanes(@NotNull SwimlanesRequest swimlanesRequest) {
        Intrinsics.checkNotNullParameter(swimlanesRequest, "request");
        SwimlanesData apply = this.swimlanesMapper.apply(new SwimlanesResponse((SwimLanesResult) null, (String) null, 3, (DefaultConstructorMarker) null));
        if (isSwimlanesEnabled()) {
            Single<R> onErrorReturn = this.swimlanesApi.getSwimlanes(this.selectedCountry.getTwoLetterCode(), swimlanesRequest.getVendorId(), swimlanesRequest.getTalabatBranchId(), swimlanesRequest.isDarkstore(), swimlanesRequest.getProductId(), swimlanesRequest.getProductSku()).subscribeOn(this.rxSchedulersFactory.io()).map(new a(this, swimlanesRequest, apply)).onErrorReturn(new b(apply));
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "{\n            swimlanesA…e\n            }\n        }");
            return onErrorReturn;
        }
        Single<SwimlanesData> just = Single.just(apply);
        Intrinsics.checkNotNullExpressionValue(just, "{\n            Single.just(emptyResponse)\n        }");
        return just;
    }
}
