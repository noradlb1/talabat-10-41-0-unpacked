package com.talabat.feature.helpcenter.presentation;

import com.talabat.feature.cancellationpolicy.domain.model.CancellationPolicyData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/helpcenter/presentation/ICancellationPolicyItemDisplayMapper;", "", "map", "Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyDisplayModel;", "cancellationPolicyItemData", "Lcom/talabat/feature/cancellationpolicy/domain/model/CancellationPolicyData;", "com_talabat_feature_helpcenter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICancellationPolicyItemDisplayMapper {
    @NotNull
    CancellationPolicyDisplayModel map(@NotNull CancellationPolicyData cancellationPolicyData);
}
