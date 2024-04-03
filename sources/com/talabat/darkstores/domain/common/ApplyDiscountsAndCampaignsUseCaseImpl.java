package com.talabat.darkstores.domain.common;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.darkstores.common.extensions.SingleExtensionsKt;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.domain.model.ProductsHolder;
import com.talabat.darkstores.model.ProductDiscount;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo;
import com.talabat.feature.darkstorescart.data.model.Tracking;
import dagger.Reusable;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qi.a;
import qi.b;
import qi.c;
import qi.d;
import qi.e;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u000e\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\u00122\u0006\u0010\u0013\u001a\u0002H\u0011H\u0002¢\u0006\u0002\u0010\u0014JF\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b*\b\u0012\u0004\u0012\u00020\u00160\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\t2\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tH\u0002R@\u0010\u0007\u001a4\u00120\u0012.\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b \r*\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0018\u00010\t0\t0\bX\u0004¢\u0006\u0002\n\u0000R4\u0010\u000e\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f \r*\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t0\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/darkstores/domain/common/ApplyDiscountsAndCampaignsUseCaseImpl;", "Lcom/talabat/darkstores/domain/common/ApplyDiscountsAndCampaignsUseCase;", "darkstoresRepo", "Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "campaignTriggersByProduct", "Lio/reactivex/Single;", "", "", "", "Lcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;", "kotlin.jvm.PlatformType", "discountsByProduct", "Lcom/talabat/darkstores/model/ProductDiscount;", "invoke", "T", "Lcom/talabat/darkstores/domain/model/ProductsHolder;", "response", "(Lcom/talabat/darkstores/domain/model/ProductsHolder;)Lio/reactivex/Single;", "applyDiscountsAndCampaigns", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "campaignByProduct", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class ApplyDiscountsAndCampaignsUseCaseImpl implements ApplyDiscountsAndCampaignsUseCase {
    @NotNull
    private final Single<Map<String, List<CampaignTrigger>>> campaignTriggersByProduct;
    @NotNull
    private final Single<Map<String, ProductDiscount>> discountsByProduct;

    @Inject
    public ApplyDiscountsAndCampaignsUseCaseImpl(@NotNull DarkstoresRepo darkstoresRepo, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "darkstoresRepo");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Single<R> onErrorReturnItem = darkstoresRepo.getDiscounts().map(new a()).onErrorReturnItem(MapsKt__MapsKt.emptyMap());
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "darkstoresRepo.getDiscou…rorReturnItem(emptyMap())");
        this.discountsByProduct = SingleExtensionsKt.cacheButRetryOnError(onErrorReturnItem);
        Single single = Maybe.create(new b(iTalabatFeatureFlag)).flatMap(new c(darkstoresRepo)).map(new d()).toSingle(MapsKt__MapsKt.emptyMap());
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
    public static final void m9744campaignTriggersByProduct$lambda2(ITalabatFeatureFlag iTalabatFeatureFlag, MaybeEmitter maybeEmitter) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "$talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(maybeEmitter, "emitter");
        if (iTalabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_DARKSTORES_LISTING_PROMO_TAG, false)) {
            maybeEmitter.onSuccess(Unit.INSTANCE);
        } else {
            maybeEmitter.onComplete();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: campaignTriggersByProduct$lambda-3  reason: not valid java name */
    public static final MaybeSource m9745campaignTriggersByProduct$lambda3(DarkstoresRepo darkstoresRepo, Unit unit) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "$darkstoresRepo");
        Intrinsics.checkNotNullParameter(unit, "it");
        return darkstoresRepo.getAllCampaignsTriggers().toMaybe().onErrorComplete();
    }

    /* access modifiers changed from: private */
    /* renamed from: campaignTriggersByProduct$lambda-5  reason: not valid java name */
    public static final Map m9746campaignTriggersByProduct$lambda5(List list) {
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
    public static final Map m9747discountsByProduct$lambda1(List list) {
        Intrinsics.checkNotNullParameter(list, "discounts");
        Iterable iterable = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(((ProductDiscount) next).getProductId(), next);
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-6  reason: not valid java name */
    public static final ProductsHolder m9748invoke$lambda6(ProductsHolder productsHolder, ApplyDiscountsAndCampaignsUseCaseImpl applyDiscountsAndCampaignsUseCaseImpl, Map map, Map map2) {
        Intrinsics.checkNotNullParameter(productsHolder, "$response");
        Intrinsics.checkNotNullParameter(applyDiscountsAndCampaignsUseCaseImpl, "this$0");
        Intrinsics.checkNotNullParameter(map, "discounts");
        Intrinsics.checkNotNullParameter(map2, "campaigns");
        return productsHolder.withProducts(applyDiscountsAndCampaignsUseCaseImpl.applyDiscountsAndCampaigns(productsHolder.getProducts(), map, map2));
    }

    @NotNull
    public <T extends ProductsHolder<T>> Single<T> invoke(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "response");
        Single<T> zip = Single.zip(this.discountsByProduct, this.campaignTriggersByProduct, new e(t11, this));
        Intrinsics.checkNotNullExpressionValue(zip, "zip(discountsByProduct, …          )\n            }");
        return zip;
    }
}
