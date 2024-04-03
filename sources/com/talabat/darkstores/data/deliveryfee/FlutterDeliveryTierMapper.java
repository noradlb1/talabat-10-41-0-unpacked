package com.talabat.darkstores.data.deliveryfee;

import com.talabat.feature.darkstoresvendor.domain.model.BasketDeliveryFeeTiersInfo;
import com.talabat.feature.darkstoresvendor.domain.model.BasketDeliveryFreeTier;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/data/deliveryfee/FlutterDeliveryTierMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFeeTiersInfo;", "Lcom/talabat/darkstores/data/deliveryfee/FlutterDeliveryFeeTierRequest;", "()V", "apply", "source", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterDeliveryTierMapper implements ModelMapper<BasketDeliveryFeeTiersInfo, FlutterDeliveryFeeTierRequest> {
    @NotNull
    public FlutterDeliveryFeeTierRequest apply(@NotNull BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo) {
        Intrinsics.checkNotNullParameter(basketDeliveryFeeTiersInfo, "source");
        String bottomSheetTitle = basketDeliveryFeeTiersInfo.getTags().getBottomSheetTitle();
        Iterable<BasketDeliveryFreeTier> basketDeliveryFreeTiers = basketDeliveryFeeTiersInfo.getBasketDeliveryFreeTiers();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(basketDeliveryFreeTiers, 10));
        for (BasketDeliveryFreeTier basketDeliveryFreeTier : basketDeliveryFreeTiers) {
            arrayList.add(new FlutterGroceryDeliveryFeeTier(basketDeliveryFreeTier.getTags().getLabel(), basketDeliveryFreeTier.getTags().getMessage(), basketDeliveryFreeTier.getTags().isHighlighted() ? "highlighted" : null));
        }
        return new FlutterDeliveryFeeTierRequest(bottomSheetTitle, arrayList, basketDeliveryFeeTiersInfo.getTags().getBottomSheetMovMessage(), basketDeliveryFeeTiersInfo.getTags().getBottomSheetButtonTitle());
    }
}
