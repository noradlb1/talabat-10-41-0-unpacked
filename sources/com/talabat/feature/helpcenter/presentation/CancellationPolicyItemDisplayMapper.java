package com.talabat.feature.helpcenter.presentation;

import com.talabat.feature.cancellationpolicy.domain.model.CancellationPolicyData;
import com.talabat.feature.cancellationpolicy.domain.model.CancellationPolicyItemData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyItemDisplayMapper;", "Lcom/talabat/feature/helpcenter/presentation/ICancellationPolicyItemDisplayMapper;", "()V", "map", "Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyDisplayModel;", "cancellationPolicyData", "Lcom/talabat/feature/cancellationpolicy/domain/model/CancellationPolicyData;", "com_talabat_feature_helpcenter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancellationPolicyItemDisplayMapper implements ICancellationPolicyItemDisplayMapper {
    @NotNull
    public CancellationPolicyDisplayModel map(@NotNull CancellationPolicyData cancellationPolicyData) {
        Intrinsics.checkNotNullParameter(cancellationPolicyData, "cancellationPolicyData");
        boolean isEnabled = cancellationPolicyData.isEnabled();
        String title = cancellationPolicyData.getTitle();
        Iterable<CancellationPolicyItemData> cancellationPolicyList = cancellationPolicyData.getCancellationPolicyList();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(cancellationPolicyList, 10));
        for (CancellationPolicyItemData cancellationPolicyItemData : cancellationPolicyList) {
            arrayList.add(new CancellationPolicyItemDisplayModel(cancellationPolicyItemData.getIcon(), cancellationPolicyItemData.getTitle(), cancellationPolicyItemData.getDescription()));
        }
        return new CancellationPolicyDisplayModel(isEnabled, title, arrayList);
    }
}
