package com.talabat.feature.darkstorescarrierbag.domain.repository;

import io.reactivex.Completable;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/domain/repository/DarkstoresCarrierBagRepository;", "", "isDarkstoresCarrierBagFakeDoorTestShown", "Lio/reactivex/Single;", "", "setDarkstoresCarrierBagFakeDoorTestShown", "Lio/reactivex/Completable;", "shown", "com_talabat_feature_darkstores-carrier-bag_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkstoresCarrierBagRepository {
    @NotNull
    Single<Boolean> isDarkstoresCarrierBagFakeDoorTestShown();

    @NotNull
    Completable setDarkstoresCarrierBagFakeDoorTestShown(boolean z11);
}
