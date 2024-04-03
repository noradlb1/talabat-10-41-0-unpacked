package com.talabat.feature.activecarts.domain.usecase;

import com.talabat.feature.activecarts.domain.extensions.MaybeExtensionsKt$toResultSingle$1;
import com.talabat.feature.activecarts.domain.extensions.MaybeExtensionsKt$toResultSingle$2;
import com.talabat.feature.activecarts.domain.repository.ActiveCartRepository;
import gl.a;
import gl.b;
import gl.c;
import gl.d;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.domain.GetActiveCartInfoUseCase;
import library.talabat.mvp.home.domain.model.ActiveCartInfo;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/activecarts/domain/usecase/GetActiveCartInfoUseCaseImpl;", "Llibrary/talabat/mvp/home/domain/GetActiveCartInfoUseCase;", "getFoodCart", "Lcom/talabat/feature/activecarts/domain/usecase/GetFoodCartUseCase;", "getQCommerceCartList", "Lcom/talabat/feature/activecarts/domain/usecase/GetQCommerceCartListUseCase;", "trackCartLoaded", "Lcom/talabat/feature/activecarts/domain/usecase/TrackCartLoadedEventUseCase;", "activeCartRepository", "Lcom/talabat/feature/activecarts/domain/repository/ActiveCartRepository;", "(Lcom/talabat/feature/activecarts/domain/usecase/GetFoodCartUseCase;Lcom/talabat/feature/activecarts/domain/usecase/GetQCommerceCartListUseCase;Lcom/talabat/feature/activecarts/domain/usecase/TrackCartLoadedEventUseCase;Lcom/talabat/feature/activecarts/domain/repository/ActiveCartRepository;)V", "invoke", "Lio/reactivex/Maybe;", "Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo;", "com_talabat_feature_active-carts_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetActiveCartInfoUseCaseImpl implements GetActiveCartInfoUseCase {
    @NotNull
    private final ActiveCartRepository activeCartRepository;
    @NotNull
    private final GetFoodCartUseCase getFoodCart;
    @NotNull
    private final GetQCommerceCartListUseCase getQCommerceCartList;
    @NotNull
    private final TrackCartLoadedEventUseCase trackCartLoaded;

    @Inject
    public GetActiveCartInfoUseCaseImpl(@NotNull GetFoodCartUseCase getFoodCartUseCase, @NotNull GetQCommerceCartListUseCase getQCommerceCartListUseCase, @NotNull TrackCartLoadedEventUseCase trackCartLoadedEventUseCase, @NotNull ActiveCartRepository activeCartRepository2) {
        Intrinsics.checkNotNullParameter(getFoodCartUseCase, "getFoodCart");
        Intrinsics.checkNotNullParameter(getQCommerceCartListUseCase, "getQCommerceCartList");
        Intrinsics.checkNotNullParameter(trackCartLoadedEventUseCase, "trackCartLoaded");
        Intrinsics.checkNotNullParameter(activeCartRepository2, "activeCartRepository");
        this.getFoodCart = getFoodCartUseCase;
        this.getQCommerceCartList = getQCommerceCartListUseCase;
        this.trackCartLoaded = trackCartLoadedEventUseCase;
        this.activeCartRepository = activeCartRepository2;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-3  reason: not valid java name */
    public static final List m10125invoke$lambda3(Result result, Result result2) {
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
    public static final boolean m10126invoke$lambda4(List list) {
        Intrinsics.checkNotNullParameter(list, "cartList");
        return !list.isEmpty();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-5  reason: not valid java name */
    public static final void m10127invoke$lambda5(GetActiveCartInfoUseCaseImpl getActiveCartInfoUseCaseImpl, List list) {
        Intrinsics.checkNotNullParameter(getActiveCartInfoUseCaseImpl, "this$0");
        TrackCartLoadedEventUseCase trackCartLoadedEventUseCase = getActiveCartInfoUseCaseImpl.trackCartLoaded;
        Intrinsics.checkNotNullExpressionValue(list, "cartList");
        trackCartLoadedEventUseCase.invoke(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-6  reason: not valid java name */
    public static final ActiveCartInfo m10128invoke$lambda6(List list) {
        Intrinsics.checkNotNullParameter(list, "cartList");
        if (list.size() == 1) {
            return (ActiveCartInfo) list.get(0);
        }
        return new ActiveCartInfo.MultipleCarts(list.size());
    }

    @NotNull
    public Maybe<ActiveCartInfo> invoke() {
        this.activeCartRepository.invalidateQCommerceCartListCache();
        Maybe<ActiveCartInfo> invoke = this.getFoodCart.invoke();
        MaybeExtensionsKt$toResultSingle$1<T, R> maybeExtensionsKt$toResultSingle$1 = MaybeExtensionsKt$toResultSingle$1.INSTANCE;
        Single<R> single = invoke.map(maybeExtensionsKt$toResultSingle$1).toSingle();
        Function function = MaybeExtensionsKt$toResultSingle$2.INSTANCE;
        Single<R> onErrorReturn = single.onErrorReturn(function);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "map { activeCartInfo ->\n…> Result.failure(error) }");
        Maybe<List<ActiveCartInfo>> onErrorComplete = this.getQCommerceCartList.invoke().onErrorComplete();
        Intrinsics.checkNotNullExpressionValue(onErrorComplete, "getQCommerceCartList()\n …       .onErrorComplete()");
        Single<R> onErrorReturn2 = onErrorComplete.map(maybeExtensionsKt$toResultSingle$1).toSingle().onErrorReturn(function);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn2, "map { activeCartInfo ->\n…> Result.failure(error) }");
        Maybe<R> map = Single.zip(onErrorReturn, onErrorReturn2, new a()).filter(new b()).doOnSuccess(new c(this)).map(new d());
        Intrinsics.checkNotNullExpressionValue(map, "zip(\n            foodCar…)\n            }\n        }");
        return map;
    }
}
