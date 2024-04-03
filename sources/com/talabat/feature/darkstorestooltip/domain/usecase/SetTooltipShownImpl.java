package com.talabat.feature.darkstorestooltip.domain.usecase;

import com.talabat.feature.darkstorestooltip.domain.di.DarkstoresTooltipRepository;
import com.talabat.feature.darkstorestooltip.domain.model.TooltipKey;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/darkstorestooltip/domain/usecase/SetTooltipShownImpl;", "Lcom/talabat/feature/darkstorestooltip/domain/usecase/SetTooltipShown;", "repository", "Lcom/talabat/feature/darkstorestooltip/domain/di/DarkstoresTooltipRepository;", "(Lcom/talabat/feature/darkstorestooltip/domain/di/DarkstoresTooltipRepository;)V", "invoke", "Lio/reactivex/Completable;", "key", "Lcom/talabat/feature/darkstorestooltip/domain/model/TooltipKey;", "isShown", "", "com_talabat_feature_darkstores-tooltip_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SetTooltipShownImpl implements SetTooltipShown {
    @NotNull
    private final DarkstoresTooltipRepository repository;

    @Inject
    public SetTooltipShownImpl(@NotNull DarkstoresTooltipRepository darkstoresTooltipRepository) {
        Intrinsics.checkNotNullParameter(darkstoresTooltipRepository, "repository");
        this.repository = darkstoresTooltipRepository;
    }

    @NotNull
    public Completable invoke(@NotNull TooltipKey tooltipKey, boolean z11) {
        Intrinsics.checkNotNullParameter(tooltipKey, "key");
        return this.repository.setTooltipShown(tooltipKey, z11);
    }
}
