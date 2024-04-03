package com.talabat.feature.activecarts.domain.usecase;

import com.talabat.feature.activecarts.domain.repository.ActiveCartRepository;
import com.talabat.feature.darkstorescartlist.domain.usecase.IsMultiBasketEnabledUseCase;
import gl.g;
import io.reactivex.Maybe;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.domain.model.ActiveCartInfo;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/activecarts/domain/usecase/GetQCommerceCartListUseCaseImpl;", "Lcom/talabat/feature/activecarts/domain/usecase/GetQCommerceCartListUseCase;", "isMultiBasketEnabled", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/IsMultiBasketEnabledUseCase;", "activeCartRepository", "Lcom/talabat/feature/activecarts/domain/repository/ActiveCartRepository;", "(Lcom/talabat/feature/darkstorescartlist/domain/usecase/IsMultiBasketEnabledUseCase;Lcom/talabat/feature/activecarts/domain/repository/ActiveCartRepository;)V", "invoke", "Lio/reactivex/Maybe;", "", "Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo;", "com_talabat_feature_active-carts_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetQCommerceCartListUseCaseImpl implements GetQCommerceCartListUseCase {
    @NotNull
    private final ActiveCartRepository activeCartRepository;
    @NotNull
    private final IsMultiBasketEnabledUseCase isMultiBasketEnabled;

    @Inject
    public GetQCommerceCartListUseCaseImpl(@NotNull IsMultiBasketEnabledUseCase isMultiBasketEnabledUseCase, @NotNull ActiveCartRepository activeCartRepository2) {
        Intrinsics.checkNotNullParameter(isMultiBasketEnabledUseCase, "isMultiBasketEnabled");
        Intrinsics.checkNotNullParameter(activeCartRepository2, "activeCartRepository");
        this.isMultiBasketEnabled = isMultiBasketEnabledUseCase;
        this.activeCartRepository = activeCartRepository2;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final List m10131invoke$lambda0(ActiveCartInfo activeCartInfo) {
        Intrinsics.checkNotNullParameter(activeCartInfo, "cart");
        return CollectionsKt__CollectionsJVMKt.listOf(activeCartInfo);
    }

    @NotNull
    public Maybe<List<ActiveCartInfo>> invoke() {
        if (this.isMultiBasketEnabled.invoke()) {
            return this.activeCartRepository.getQCommerceCartList();
        }
        Maybe<R> map = this.activeCartRepository.getQCommerceCart().map(new g());
        Intrinsics.checkNotNullExpressionValue(map, "{\n            activeCart…)\n            }\n        }");
        return map;
    }
}
