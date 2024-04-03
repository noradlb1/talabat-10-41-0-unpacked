package jm;

import com.talabat.feature.darkstorescartlist.domain.usecase.GetCartListToastUseCaseImpl;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class b implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetCartListToastUseCaseImpl f62181b;

    public /* synthetic */ b(GetCartListToastUseCaseImpl getCartListToastUseCaseImpl) {
        this.f62181b = getCartListToastUseCaseImpl;
    }

    public final boolean test(Object obj) {
        return GetCartListToastUseCaseImpl.m10192getCartListToastVariation1$lambda10(this.f62181b, (Integer) obj);
    }
}
