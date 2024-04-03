package com.talabat.feature.activecarts.domain.usecase;

import com.talabat.feature.activecarts.domain.extensions.MaybeExtensionsKt$toResultSingle$1;
import com.talabat.feature.activecarts.domain.extensions.MaybeExtensionsKt$toResultSingle$2;
import com.talabat.feature.activecarts.domain.mapper.ActiveCartInfoMapper;
import com.talabat.feature.activecarts.domain.model.BasketType;
import com.talabat.feature.activecarts.domain.repository.ActiveCartRepository;
import gl.e;
import gl.f;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.domain.model.ActiveCartInfo;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ7\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\r0\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/activecarts/domain/usecase/GetCartListUseCaseImpl;", "Lcom/talabat/feature/activecarts/domain/usecase/GetCartListUseCase;", "getFoodCart", "Lcom/talabat/feature/activecarts/domain/usecase/GetFoodCartUseCase;", "getQCommerceCartList", "Lcom/talabat/feature/activecarts/domain/usecase/GetQCommerceCartListUseCase;", "mapActiveCart", "Lcom/talabat/feature/activecarts/domain/mapper/ActiveCartInfoMapper;", "activeCartRepository", "Lcom/talabat/feature/activecarts/domain/repository/ActiveCartRepository;", "(Lcom/talabat/feature/activecarts/domain/usecase/GetFoodCartUseCase;Lcom/talabat/feature/activecarts/domain/usecase/GetQCommerceCartListUseCase;Lcom/talabat/feature/activecarts/domain/mapper/ActiveCartInfoMapper;Lcom/talabat/feature/activecarts/domain/repository/ActiveCartRepository;)V", "invoke", "Lio/reactivex/Single;", "", "", "", "", "basketTypes", "", "Lcom/talabat/feature/activecarts/domain/model/BasketType;", "invalidateCache", "", "com_talabat_feature_active-carts_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetCartListUseCaseImpl implements GetCartListUseCase {
    @NotNull
    private final ActiveCartRepository activeCartRepository;
    @NotNull
    private final GetFoodCartUseCase getFoodCart;
    @NotNull
    private final GetQCommerceCartListUseCase getQCommerceCartList;
    @NotNull
    private final ActiveCartInfoMapper mapActiveCart;

    @Inject
    public GetCartListUseCaseImpl(@NotNull GetFoodCartUseCase getFoodCartUseCase, @NotNull GetQCommerceCartListUseCase getQCommerceCartListUseCase, @NotNull ActiveCartInfoMapper activeCartInfoMapper, @NotNull ActiveCartRepository activeCartRepository2) {
        Intrinsics.checkNotNullParameter(getFoodCartUseCase, "getFoodCart");
        Intrinsics.checkNotNullParameter(getQCommerceCartListUseCase, "getQCommerceCartList");
        Intrinsics.checkNotNullParameter(activeCartInfoMapper, "mapActiveCart");
        Intrinsics.checkNotNullParameter(activeCartRepository2, "activeCartRepository");
        this.getFoodCart = getFoodCartUseCase;
        this.getQCommerceCartList = getQCommerceCartListUseCase;
        this.mapActiveCart = activeCartInfoMapper;
        this.activeCartRepository = activeCartRepository2;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-3  reason: not valid java name */
    public static final List m10129invoke$lambda3(Result result, Result result2) {
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(result, "foodCartResult");
        Object r32 = result.m6338unboximpl();
        List list = null;
        if (Result.m6335isFailureimpl(r32)) {
            r32 = null;
        }
        ActiveCartInfo activeCartInfo = (ActiveCartInfo) r32;
        if (activeCartInfo != null) {
            arrayList.add(activeCartInfo);
        }
        Intrinsics.checkNotNullExpressionValue(result2, "qCommerceCartListResult");
        Object r33 = result2.m6338unboximpl();
        if (!Result.m6335isFailureimpl(r33)) {
            list = r33;
        }
        List list2 = list;
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-4  reason: not valid java name */
    public static final List m10130invoke$lambda4(GetCartListUseCaseImpl getCartListUseCaseImpl, List list) {
        Intrinsics.checkNotNullParameter(getCartListUseCaseImpl, "this$0");
        Intrinsics.checkNotNullParameter(list, "activeCarts");
        ActiveCartInfoMapper activeCartInfoMapper = getCartListUseCaseImpl.mapActiveCart;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map<String, Object> apply = activeCartInfoMapper.apply((ActiveCartInfo) it.next());
            if (apply != null) {
                arrayList.add(apply);
            }
        }
        return arrayList;
    }

    @NotNull
    public Single<List<Map<String, Object>>> invoke(@NotNull Set<? extends BasketType> set, boolean z11) {
        Maybe<ActiveCartInfo> maybe;
        Maybe<List<ActiveCartInfo>> maybe2;
        Intrinsics.checkNotNullParameter(set, "basketTypes");
        if (z11) {
            this.activeCartRepository.invalidateQCommerceCartListCache();
        }
        if (set.contains(BasketType.FOOD)) {
            maybe = this.getFoodCart.invoke();
        } else {
            maybe = Maybe.empty();
        }
        Intrinsics.checkNotNullExpressionValue(maybe, "if (basketTypes.contains…ybe.empty()\n            }");
        MaybeExtensionsKt$toResultSingle$1<T, R> maybeExtensionsKt$toResultSingle$1 = MaybeExtensionsKt$toResultSingle$1.INSTANCE;
        Single<R> single = maybe.map(maybeExtensionsKt$toResultSingle$1).toSingle();
        Function function = MaybeExtensionsKt$toResultSingle$2.INSTANCE;
        Single<R> onErrorReturn = single.onErrorReturn(function);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "map { activeCartInfo ->\n…> Result.failure(error) }");
        if (set.contains(BasketType.QCOMMERCE)) {
            maybe2 = this.getQCommerceCartList.invoke();
        } else {
            maybe2 = Maybe.empty();
        }
        Intrinsics.checkNotNullExpressionValue(maybe2, "if (basketTypes.contains…ybe.empty()\n            }");
        Single<R> onErrorReturn2 = maybe2.map(maybeExtensionsKt$toResultSingle$1).toSingle().onErrorReturn(function);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn2, "map { activeCartInfo ->\n…> Result.failure(error) }");
        Single<R> map = Single.zip(onErrorReturn, onErrorReturn2, new e()).map(new f(this));
        Intrinsics.checkNotNullExpressionValue(map, "zip(\n            foodCar…iveCart::apply)\n        }");
        return map;
    }
}
