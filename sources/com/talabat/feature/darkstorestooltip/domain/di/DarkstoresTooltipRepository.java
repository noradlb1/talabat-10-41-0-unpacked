package com.talabat.feature.darkstorestooltip.domain.di;

import com.talabat.feature.darkstorestooltip.domain.model.TooltipKey;
import io.reactivex.Completable;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/talabat/feature/darkstorestooltip/domain/di/DarkstoresTooltipRepository;", "", "setTooltipShown", "Lio/reactivex/Completable;", "key", "Lcom/talabat/feature/darkstorestooltip/domain/model/TooltipKey;", "isShown", "", "wasTooltipAlreadyShown", "Lio/reactivex/Single;", "com_talabat_feature_darkstores-tooltip_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkstoresTooltipRepository {
    @NotNull
    Completable setTooltipShown(@NotNull TooltipKey tooltipKey, boolean z11);

    @NotNull
    Single<Boolean> wasTooltipAlreadyShown(@NotNull TooltipKey tooltipKey);
}
