package com.talabat.feature.activecarts.domain.usecase;

import com.talabat.feature.activecarts.domain.repository.ActiveCartRepository;
import io.reactivex.Maybe;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.domain.model.ActiveCartInfo;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/feature/activecarts/domain/usecase/GetFoodCartUseCaseImpl;", "Lcom/talabat/feature/activecarts/domain/usecase/GetFoodCartUseCase;", "activeCartRepository", "Lcom/talabat/feature/activecarts/domain/repository/ActiveCartRepository;", "(Lcom/talabat/feature/activecarts/domain/repository/ActiveCartRepository;)V", "invoke", "Lio/reactivex/Maybe;", "Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo;", "com_talabat_feature_active-carts_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetFoodCartUseCaseImpl implements GetFoodCartUseCase {
    @NotNull
    private final ActiveCartRepository activeCartRepository;

    @Inject
    public GetFoodCartUseCaseImpl(@NotNull ActiveCartRepository activeCartRepository2) {
        Intrinsics.checkNotNullParameter(activeCartRepository2, "activeCartRepository");
        this.activeCartRepository = activeCartRepository2;
    }

    @NotNull
    public Maybe<ActiveCartInfo> invoke() {
        return this.activeCartRepository.getFoodCart();
    }
}
