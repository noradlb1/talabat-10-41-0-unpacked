package com.talabat.darkstores.feature.product.usecase;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.darkstores.common.extensions.SingleExtensionsKt;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.SearchResultData;
import com.talabat.darkstores.data.TrackingInfo;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.model.ProductDiscount;
import com.talabat.feature.darkstores.swimlanes.domain.SwimlanesRepository;
import com.talabat.feature.darkstores.swimlanes.domain.model.Swimlanes;
import com.talabat.feature.darkstores.swimlanes.domain.model.SwimlanesData;
import com.talabat.feature.darkstores.swimlanes.domain.model.SwimlanesProduct;
import com.talabat.feature.darkstores.swimlanes.domain.model.SwimlanesProductUrl;
import com.talabat.feature.darkstores.swimlanes.domain.model.SwimlanesRequest;
import com.talabat.feature.darkstores.swimlanes.domain.model.SwimlanesTracking;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo;
import com.talabat.feature.darkstorescart.data.model.ProductUrl;
import com.talabat.feature.darkstorescart.data.model.Tracking;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import dagger.Reusable;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kj.a;
import kj.b;
import kj.c;
import kj.d;
import kj.e;
import kj.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0011H\u0002J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010JF\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0011*\b\u0012\u0004\u0012\u00020\u001f0\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u000f2\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000fH\u0002J<\u0010!\u001a\u00020\u001b*\u0004\u0018\u00010\"2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u000f2\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000fH\u0002R@\u0010\r\u001a4\u00120\u0012.\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011 \u0013*\u0016\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u000f0\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R4\u0010\u0014\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0015 \u0013*\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000f0\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/talabat/darkstores/feature/product/usecase/ProductSwimlanesUseCase;", "", "darkstoresRepo", "Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "discoveryRepo", "Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;", "swimlanesRepository", "Lcom/talabat/feature/darkstores/swimlanes/domain/SwimlanesRepository;", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "featureFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;Lcom/talabat/feature/darkstores/swimlanes/domain/SwimlanesRepository;Lcom/talabat/darkstores/data/ConfigurationParameters;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "campaignTriggersByProduct", "Lio/reactivex/Single;", "", "", "", "Lcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;", "kotlin.jvm.PlatformType", "discountsByProduct", "Lcom/talabat/darkstores/model/ProductDiscount;", "getProductImageUrls", "Lcom/talabat/feature/darkstorescart/data/model/ProductUrl;", "imageUrls", "Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesProductUrl;", "getSwimlanes", "Lcom/talabat/darkstores/data/SearchResultData;", "productId", "productSku", "applyDiscountsAndCampaigns", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "campaignByProduct", "toSearchResultData", "Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesData;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class ProductSwimlanesUseCase {
    @NotNull
    private final Single<Map<String, List<CampaignTrigger>>> campaignTriggersByProduct;
    @NotNull
    private final ConfigurationParameters configurationParameters;
    @NotNull
    private final DarkstoresRepo darkstoresRepo;
    @NotNull
    private final Single<Map<String, ProductDiscount>> discountsByProduct;
    @NotNull
    private final DiscoveryRepo discoveryRepo;
    @NotNull
    private final SwimlanesRepository swimlanesRepository;

    @Inject
    public ProductSwimlanesUseCase(@NotNull DarkstoresRepo darkstoresRepo2, @NotNull DiscoveryRepo discoveryRepo2, @NotNull SwimlanesRepository swimlanesRepository2, @NotNull ConfigurationParameters configurationParameters2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(darkstoresRepo2, "darkstoresRepo");
        Intrinsics.checkNotNullParameter(discoveryRepo2, "discoveryRepo");
        Intrinsics.checkNotNullParameter(swimlanesRepository2, "swimlanesRepository");
        Intrinsics.checkNotNullParameter(configurationParameters2, "configurationParameters");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlags");
        this.darkstoresRepo = darkstoresRepo2;
        this.discoveryRepo = discoveryRepo2;
        this.swimlanesRepository = swimlanesRepository2;
        this.configurationParameters = configurationParameters2;
        Single<R> onErrorReturnItem = darkstoresRepo2.getDiscounts().map(new a()).onErrorReturnItem(MapsKt__MapsKt.emptyMap());
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "darkstoresRepo.getDiscou…rorReturnItem(emptyMap())");
        this.discountsByProduct = SingleExtensionsKt.cacheButRetryOnError(onErrorReturnItem);
        Single single = Maybe.create(new b(iTalabatFeatureFlag)).flatMap(new c(this)).map(new d()).toSingle(MapsKt__MapsKt.emptyMap());
        Intrinsics.checkNotNullExpressionValue(single, "create<Unit> { emitter -…    .toSingle(emptyMap())");
        this.campaignTriggersByProduct = SingleExtensionsKt.cacheButRetryOnError(single);
    }

    private final List<Product> applyDiscountsAndCampaigns(List<Product> list, Map<String, ProductDiscount> map, Map<String, ? extends List<CampaignTrigger>> map2) {
        float f11;
        Float f12;
        CampaignTrigger campaignTrigger;
        Iterable<Product> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Product product : iterable) {
            ProductDiscount productDiscount = map.get(product.getId());
            if (productDiscount != null) {
                f11 = productDiscount.getDiscountedPrice();
            } else {
                f11 = product.getPrice();
            }
            if (productDiscount != null) {
                f12 = Float.valueOf(productDiscount.getOriginalPrice());
            } else {
                f12 = product.getPreviousPrice();
            }
            Float f13 = f12;
            List list2 = (List) map2.get(product.getId());
            if (list2 != null) {
                campaignTrigger = (CampaignTrigger) CollectionsKt___CollectionsKt.firstOrNull(list2);
            } else {
                campaignTrigger = null;
            }
            arrayList.add(Product.copy$default(product, (String) null, (String) null, (String) null, f11, f13, 0, 0, (Integer) null, (Float) null, (Tracking) null, (String) null, 0, false, (List) null, (List) null, (String) null, (List) null, (String) null, false, (String) null, false, campaignTrigger, 0, (ProductExtendedInfo) null, (List) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, 2145386471, (Object) null));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: campaignTriggersByProduct$lambda-2  reason: not valid java name */
    public static final void m10044campaignTriggersByProduct$lambda2(ITalabatFeatureFlag iTalabatFeatureFlag, MaybeEmitter maybeEmitter) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "$featureFlags");
        Intrinsics.checkNotNullParameter(maybeEmitter, "emitter");
        if (iTalabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_DARKSTORES_LISTING_PROMO_TAG, false)) {
            maybeEmitter.onSuccess(Unit.INSTANCE);
        } else {
            maybeEmitter.onComplete();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: campaignTriggersByProduct$lambda-3  reason: not valid java name */
    public static final MaybeSource m10045campaignTriggersByProduct$lambda3(ProductSwimlanesUseCase productSwimlanesUseCase, Unit unit) {
        Intrinsics.checkNotNullParameter(productSwimlanesUseCase, "this$0");
        Intrinsics.checkNotNullParameter(unit, "it");
        return productSwimlanesUseCase.darkstoresRepo.getAllCampaignsTriggers().toMaybe().onErrorComplete();
    }

    /* access modifiers changed from: private */
    /* renamed from: campaignTriggersByProduct$lambda-5  reason: not valid java name */
    public static final Map m10046campaignTriggersByProduct$lambda5(List list) {
        Intrinsics.checkNotNullParameter(list, "triggers");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : list) {
            String id2 = ((CampaignTrigger) next).getId();
            Object obj = linkedHashMap.get(id2);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(id2, obj);
            }
            ((List) obj).add(next);
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: discountsByProduct$lambda-1  reason: not valid java name */
    public static final Map m10047discountsByProduct$lambda1(List list) {
        Intrinsics.checkNotNullParameter(list, "discounts");
        Iterable iterable = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(((ProductDiscount) next).getProductId(), next);
        }
        return linkedHashMap;
    }

    private final List<ProductUrl> getProductImageUrls(List<SwimlanesProductUrl> list) {
        Iterable<SwimlanesProductUrl> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (SwimlanesProductUrl url : iterable) {
            arrayList.add(new ProductUrl(url.getUrl()));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: getSwimlanes$lambda-7  reason: not valid java name */
    public static final SingleSource m10048getSwimlanes$lambda7(boolean z11, String str, String str2, ProductSwimlanesUseCase productSwimlanesUseCase, Vendor vendor) {
        Intrinsics.checkNotNullParameter(str, "$productId");
        Intrinsics.checkNotNullParameter(str2, "$productSku");
        Intrinsics.checkNotNullParameter(productSwimlanesUseCase, "this$0");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return Single.zip(productSwimlanesUseCase.swimlanesRepository.getSwimlanes(new SwimlanesRequest(vendor.getVendorId(), vendor.getVendorCode(), z11, str, str2)), productSwimlanesUseCase.discountsByProduct, productSwimlanesUseCase.campaignTriggersByProduct, new f(productSwimlanesUseCase));
    }

    /* access modifiers changed from: private */
    /* renamed from: getSwimlanes$lambda-7$lambda-6  reason: not valid java name */
    public static final SearchResultData m10049getSwimlanes$lambda7$lambda6(ProductSwimlanesUseCase productSwimlanesUseCase, SwimlanesData swimlanesData, Map map, Map map2) {
        Intrinsics.checkNotNullParameter(productSwimlanesUseCase, "this$0");
        Intrinsics.checkNotNullParameter(swimlanesData, "swimlaneData");
        Intrinsics.checkNotNullParameter(map, "discounts");
        Intrinsics.checkNotNullParameter(map2, "triggers");
        return productSwimlanesUseCase.toSearchResultData(swimlanesData, map, map2);
    }

    private final SearchResultData toSearchResultData(SwimlanesData swimlanesData, Map<String, ProductDiscount> map, Map<String, ? extends List<CampaignTrigger>> map2) {
        Swimlanes swimlanes;
        List<SwimlanesProduct> list;
        TrackingInfo trackingInfo;
        String str;
        String str2;
        String str3;
        String str4;
        String requestId;
        TrackingInfo trackingInfo2;
        SwimlanesTracking tracking2;
        String trackingId;
        List<Swimlanes> swimlanes2;
        if (swimlanesData == null || (swimlanes2 = swimlanesData.getSwimlanes()) == null) {
            swimlanes = null;
        } else {
            swimlanes = (Swimlanes) CollectionsKt___CollectionsKt.firstOrNull(swimlanes2);
        }
        if (swimlanes == null || (list = swimlanes.getProducts()) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Iterable<SwimlanesProduct> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (SwimlanesProduct swimlanesProduct : iterable) {
            Product product = r6;
            Product product2 = new Product(swimlanesProduct.getId(), swimlanesProduct.getName(), swimlanesProduct.getImageUrl(), swimlanesProduct.getPrice(), (Float) null, 0, 0, (Integer) null, (Float) null, (Tracking) null, swimlanesProduct.getVendorId(), swimlanesProduct.getStockAmount(), swimlanesProduct.isAvailable(), getProductImageUrls(swimlanesProduct.getImageUrls()), swimlanesProduct.getTags(), swimlanesProduct.getDescription(), (List) null, swimlanesProduct.getCategoryId(), false, swimlanesProduct.getSku(), false, (CampaignTrigger) null, swimlanesProduct.getAgeLimit(), (ProductExtendedInfo) null, (List) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, 2142569456, (DefaultConstructorMarker) null);
            arrayList.add(product);
        }
        List<Product> applyDiscountsAndCampaigns = applyDiscountsAndCampaigns(arrayList, map, map2);
        if (swimlanesData == null || (requestId = swimlanesData.getRequestId()) == null) {
            trackingInfo = null;
        } else {
            if (swimlanes == null || (tracking2 = swimlanes.getTracking()) == null || (trackingId = tracking2.getTrackingId()) == null) {
                trackingInfo2 = null;
            } else {
                trackingInfo2 = new TrackingInfo(requestId, trackingId);
            }
            trackingInfo = trackingInfo2;
        }
        if (swimlanes != null) {
            str = swimlanes.getId();
        } else {
            str = null;
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (swimlanes != null) {
            str3 = swimlanes.getName();
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str4 = "";
        } else {
            str4 = str3;
        }
        return new SearchResultData(applyDiscountsAndCampaigns, str2, str4, applyDiscountsAndCampaigns.size(), (List) null, trackingInfo, 16, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final Single<SearchResultData> getSwimlanes(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "productId");
        Intrinsics.checkNotNullParameter(str2, "productSku");
        Single<R> flatMap = this.darkstoresRepo.getVendor().flatMap(new e(!this.configurationParameters.isMigrated(), str, str2, this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "darkstoresRepo.getVendor…          }\n            }");
        return flatMap;
    }
}
