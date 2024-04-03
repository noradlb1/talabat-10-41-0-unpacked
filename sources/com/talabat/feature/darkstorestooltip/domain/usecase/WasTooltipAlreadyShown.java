package com.talabat.feature.darkstorestooltip.domain.usecase;

import com.talabat.feature.darkstorestooltip.domain.model.TooltipKey;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦\u0002¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/darkstorestooltip/domain/usecase/WasTooltipAlreadyShown;", "", "invoke", "Lio/reactivex/Single;", "", "key", "Lcom/talabat/feature/darkstorestooltip/domain/model/TooltipKey;", "com_talabat_feature_darkstores-tooltip_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WasTooltipAlreadyShown {
    @NotNull
    Single<Boolean> invoke(@NotNull TooltipKey tooltipKey);
}
