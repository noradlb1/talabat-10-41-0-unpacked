package com.talabat.feature.cancellationpolicy.mapper;

import com.talabat.feature.cancellationpolicy.domain.model.CancellationPolicyData;
import com.talabat.feature.cancellationpolicy.domain.model.CancellationPolicyItemData;
import com.talabat.feature.cancellationpolicy.remote.CancellationPolicyItem;
import com.talabat.feature.cancellationpolicy.remote.CancellationPolicyResponse;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/mapper/CancellationPolicyMapper;", "Lcom/talabat/feature/cancellationpolicy/mapper/ICancellationPolicyMapper;", "()V", "map", "Lcom/talabat/feature/cancellationpolicy/domain/model/CancellationPolicyData;", "cancellationPolicyResponse", "Lcom/talabat/feature/cancellationpolicy/remote/CancellationPolicyResponse;", "com_talabat_feature_helpcenter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancellationPolicyMapper implements ICancellationPolicyMapper {
    @NotNull
    public CancellationPolicyData map(@NotNull CancellationPolicyResponse cancellationPolicyResponse) {
        Intrinsics.checkNotNullParameter(cancellationPolicyResponse, "cancellationPolicyResponse");
        boolean isEnabled = cancellationPolicyResponse.isEnabled();
        String title = cancellationPolicyResponse.getContent().getTitle();
        Iterable<CancellationPolicyItem> list = cancellationPolicyResponse.getContent().getList();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (CancellationPolicyItem cancellationPolicyItem : list) {
            arrayList.add(new CancellationPolicyItemData(cancellationPolicyItem.getIcon(), cancellationPolicyItem.getTitle(), cancellationPolicyItem.getDescription()));
        }
        return new CancellationPolicyData(isEnabled, title, arrayList);
    }
}
