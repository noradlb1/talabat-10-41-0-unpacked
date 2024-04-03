package jm;

import com.talabat.feature.darkstorescartlist.domain.usecase.GetCartListToastUseCaseImpl;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class f implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetCartListToastUseCaseImpl f62183b;

    public /* synthetic */ f(GetCartListToastUseCaseImpl getCartListToastUseCaseImpl) {
        this.f62183b = getCartListToastUseCaseImpl;
    }

    public final boolean test(Object obj) {
        return GetCartListToastUseCaseImpl.m10189getCartListToastControl$lambda5(this.f62183b, (Integer) obj);
    }
}
