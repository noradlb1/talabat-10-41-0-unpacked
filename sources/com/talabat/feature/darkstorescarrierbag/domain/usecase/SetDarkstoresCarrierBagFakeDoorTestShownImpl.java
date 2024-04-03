package com.talabat.feature.darkstorescarrierbag.domain.usecase;

import com.talabat.feature.darkstorescarrierbag.domain.repository.DarkstoresCarrierBagRepository;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/domain/usecase/SetDarkstoresCarrierBagFakeDoorTestShownImpl;", "Lcom/talabat/feature/darkstorescarrierbag/domain/usecase/SetDarkstoresCarrierBagFakeDoorTestShown;", "repository", "Lcom/talabat/feature/darkstorescarrierbag/domain/repository/DarkstoresCarrierBagRepository;", "(Lcom/talabat/feature/darkstorescarrierbag/domain/repository/DarkstoresCarrierBagRepository;)V", "invoke", "Lio/reactivex/Completable;", "shown", "", "com_talabat_feature_darkstores-carrier-bag_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SetDarkstoresCarrierBagFakeDoorTestShownImpl implements SetDarkstoresCarrierBagFakeDoorTestShown {
    @NotNull
    private final DarkstoresCarrierBagRepository repository;

    @Inject
    public SetDarkstoresCarrierBagFakeDoorTestShownImpl(@NotNull DarkstoresCarrierBagRepository darkstoresCarrierBagRepository) {
        Intrinsics.checkNotNullParameter(darkstoresCarrierBagRepository, "repository");
        this.repository = darkstoresCarrierBagRepository;
    }

    @NotNull
    public Completable invoke(boolean z11) {
        return this.repository.setDarkstoresCarrierBagFakeDoorTestShown(z11);
    }
}
