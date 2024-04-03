package com.talabat.feature.bnplcore.domain.usecase;

import io.reactivex.Completable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H¦\u0002¨\u0006\b"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/usecase/SendNavigationOptionLoadedEventUseCase;", "", "invoke", "Lio/reactivex/Completable;", "eventOrigin", "", "screenName", "screenType", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SendNavigationOptionLoadedEventUseCase {
    @NotNull
    Completable invoke(@NotNull String str, @NotNull String str2, @NotNull String str3);
}
