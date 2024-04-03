package com.talabat.feature.darkstorescartlist.domain.usecase;

import com.talabat.feature.darkstorescartlist.domain.model.CartInfo;
import com.talabat.feature.darkstorescartlist.domain.model.CartListToast;
import com.talabat.feature.darkstorescartlist.domain.repository.DarkstoresCartListRepository;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;
import jm.a;
import jm.b;
import jm.c;
import jm.d;
import jm.e;
import jm.f;
import jm.g;
import jm.h;
import jm.i;
import jm.j;
import jm.k;
import jm.l;
import jm.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/domain/usecase/GetCartListToastUseCaseImpl;", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/GetCartListToastUseCase;", "isMultiBasketEnabled", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/IsMultiBasketEnabledUseCase;", "darkstoresCartListRepository", "Lcom/talabat/feature/darkstorescartlist/domain/repository/DarkstoresCartListRepository;", "isMultiBasketCommunicationExperimentEnabled", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/IsMultiBasketCommunicationExperimentEnabledUseCase;", "(Lcom/talabat/feature/darkstorescartlist/domain/usecase/IsMultiBasketEnabledUseCase;Lcom/talabat/feature/darkstorescartlist/domain/repository/DarkstoresCartListRepository;Lcom/talabat/feature/darkstorescartlist/domain/usecase/IsMultiBasketCommunicationExperimentEnabledUseCase;)V", "getCartListToastControl", "Lio/reactivex/Maybe;", "Lcom/talabat/feature/darkstorescartlist/domain/model/CartListToast;", "globalVendorId", "", "getCartListToastVariation1", "invoke", "com_talabat_feature_darkstores-cart-list_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetCartListToastUseCaseImpl implements GetCartListToastUseCase {
    @NotNull
    private final DarkstoresCartListRepository darkstoresCartListRepository;
    @NotNull
    private final IsMultiBasketCommunicationExperimentEnabledUseCase isMultiBasketCommunicationExperimentEnabled;
    @NotNull
    private final IsMultiBasketEnabledUseCase isMultiBasketEnabled;

    @Inject
    public GetCartListToastUseCaseImpl(@NotNull IsMultiBasketEnabledUseCase isMultiBasketEnabledUseCase, @NotNull DarkstoresCartListRepository darkstoresCartListRepository2, @NotNull IsMultiBasketCommunicationExperimentEnabledUseCase isMultiBasketCommunicationExperimentEnabledUseCase) {
        Intrinsics.checkNotNullParameter(isMultiBasketEnabledUseCase, "isMultiBasketEnabled");
        Intrinsics.checkNotNullParameter(darkstoresCartListRepository2, "darkstoresCartListRepository");
        Intrinsics.checkNotNullParameter(isMultiBasketCommunicationExperimentEnabledUseCase, "isMultiBasketCommunicationExperimentEnabled");
        this.isMultiBasketEnabled = isMultiBasketEnabledUseCase;
        this.darkstoresCartListRepository = darkstoresCartListRepository2;
        this.isMultiBasketCommunicationExperimentEnabled = isMultiBasketCommunicationExperimentEnabledUseCase;
    }

    private final Maybe<CartListToast> getCartListToastControl(String str) {
        Maybe<R> map = this.darkstoresCartListRepository.getCartInfoList().filter(new a(str)).map(new e()).filter(new f(this)).doOnSuccess(new g(this)).map(new h());
        Intrinsics.checkNotNullExpressionValue(map, "darkstoresCartListReposi…          }\n            }");
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: getCartListToastControl$lambda-3  reason: not valid java name */
    public static final boolean m10187getCartListToastControl$lambda3(String str, List list) {
        Intrinsics.checkNotNullParameter(str, "$globalVendorId");
        Intrinsics.checkNotNullParameter(list, "cartList");
        if (list.isEmpty()) {
            return true;
        }
        if (list.size() != 1 || Intrinsics.areEqual((Object) ((CartInfo) CollectionsKt___CollectionsKt.first(list)).getGlobalVendorId(), (Object) str)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: getCartListToastControl$lambda-4  reason: not valid java name */
    public static final Integer m10188getCartListToastControl$lambda4(List list) {
        Intrinsics.checkNotNullParameter(list, "cartList");
        return Integer.valueOf(list.size());
    }

    /* access modifiers changed from: private */
    /* renamed from: getCartListToastControl$lambda-5  reason: not valid java name */
    public static final boolean m10189getCartListToastControl$lambda5(GetCartListToastUseCaseImpl getCartListToastUseCaseImpl, Integer num) {
        Intrinsics.checkNotNullParameter(getCartListToastUseCaseImpl, "this$0");
        Intrinsics.checkNotNullParameter(num, "cartCount");
        return !getCartListToastUseCaseImpl.darkstoresCartListRepository.isCartListToastShown(num.intValue(), "Control");
    }

    /* access modifiers changed from: private */
    /* renamed from: getCartListToastControl$lambda-6  reason: not valid java name */
    public static final void m10190getCartListToastControl$lambda6(GetCartListToastUseCaseImpl getCartListToastUseCaseImpl, Integer num) {
        Intrinsics.checkNotNullParameter(getCartListToastUseCaseImpl, "this$0");
        DarkstoresCartListRepository darkstoresCartListRepository2 = getCartListToastUseCaseImpl.darkstoresCartListRepository;
        Intrinsics.checkNotNullExpressionValue(num, "cartCount");
        darkstoresCartListRepository2.setCartListToastShown(num.intValue(), "Control", true);
    }

    /* access modifiers changed from: private */
    /* renamed from: getCartListToastControl$lambda-7  reason: not valid java name */
    public static final CartListToast m10191getCartListToastControl$lambda7(Integer num) {
        Intrinsics.checkNotNullParameter(num, "cartCount");
        if (num.intValue() == 0) {
            return CartListToast.FirstCartControl.INSTANCE;
        }
        return CartListToast.SecondCartControl.INSTANCE;
    }

    private final Maybe<CartListToast> getCartListToastVariation1(String str) {
        Maybe<R> map = this.darkstoresCartListRepository.getCartInfoList().filter(new l(str)).map(new m()).filter(new b(this)).doOnSuccess(new c(this)).map(new d());
        Intrinsics.checkNotNullExpressionValue(map, "darkstoresCartListReposi…tVariation1\n            }");
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: getCartListToastVariation1$lambda-10  reason: not valid java name */
    public static final boolean m10192getCartListToastVariation1$lambda10(GetCartListToastUseCaseImpl getCartListToastUseCaseImpl, Integer num) {
        Intrinsics.checkNotNullParameter(getCartListToastUseCaseImpl, "this$0");
        Intrinsics.checkNotNullParameter(num, "cartCount");
        return !getCartListToastUseCaseImpl.darkstoresCartListRepository.isCartListToastShown(num.intValue(), "Variation1");
    }

    /* access modifiers changed from: private */
    /* renamed from: getCartListToastVariation1$lambda-11  reason: not valid java name */
    public static final void m10193getCartListToastVariation1$lambda11(GetCartListToastUseCaseImpl getCartListToastUseCaseImpl, Integer num) {
        Intrinsics.checkNotNullParameter(getCartListToastUseCaseImpl, "this$0");
        DarkstoresCartListRepository darkstoresCartListRepository2 = getCartListToastUseCaseImpl.darkstoresCartListRepository;
        Intrinsics.checkNotNullExpressionValue(num, "cartCount");
        darkstoresCartListRepository2.setCartListToastShown(num.intValue(), "Variation1", true);
    }

    /* access modifiers changed from: private */
    /* renamed from: getCartListToastVariation1$lambda-12  reason: not valid java name */
    public static final CartListToast m10194getCartListToastVariation1$lambda12(Integer num) {
        Intrinsics.checkNotNullParameter(num, "it");
        return CartListToast.SecondCartVariation1.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: getCartListToastVariation1$lambda-8  reason: not valid java name */
    public static final boolean m10195getCartListToastVariation1$lambda8(String str, List list) {
        Intrinsics.checkNotNullParameter(str, "$globalVendorId");
        Intrinsics.checkNotNullParameter(list, "cartList");
        if (list.size() != 1 || Intrinsics.areEqual((Object) ((CartInfo) CollectionsKt___CollectionsKt.first(list)).getGlobalVendorId(), (Object) str)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: getCartListToastVariation1$lambda-9  reason: not valid java name */
    public static final Integer m10196getCartListToastVariation1$lambda9(List list) {
        Intrinsics.checkNotNullParameter(list, "cartList");
        return Integer.valueOf(list.size());
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final Boolean m10197invoke$lambda0(GetCartListToastUseCaseImpl getCartListToastUseCaseImpl) {
        Intrinsics.checkNotNullParameter(getCartListToastUseCaseImpl, "this$0");
        return Boolean.valueOf(getCartListToastUseCaseImpl.isMultiBasketEnabled.invoke());
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final boolean m10198invoke$lambda1(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "isMultiBasketEnabled");
        return bool.booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final MaybeSource m10199invoke$lambda2(GetCartListToastUseCaseImpl getCartListToastUseCaseImpl, String str, Boolean bool) {
        Intrinsics.checkNotNullParameter(getCartListToastUseCaseImpl, "this$0");
        Intrinsics.checkNotNullParameter(str, "$globalVendorId");
        Intrinsics.checkNotNullParameter(bool, "it");
        if (getCartListToastUseCaseImpl.isMultiBasketCommunicationExperimentEnabled.invoke()) {
            return getCartListToastUseCaseImpl.getCartListToastVariation1(str);
        }
        return getCartListToastUseCaseImpl.getCartListToastControl(str);
    }

    @NotNull
    public Maybe<CartListToast> invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "globalVendorId");
        Maybe<CartListToast> flatMap = Single.fromCallable(new i(this)).filter(new j()).flatMap(new k(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMap, "fromCallable { isMultiBa…          }\n            }");
        return flatMap;
    }
}
