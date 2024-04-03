package jm;

import com.talabat.feature.darkstorescartlist.domain.usecase.GetCartListToastUseCaseImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class k implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetCartListToastUseCaseImpl f62186b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62187c;

    public /* synthetic */ k(GetCartListToastUseCaseImpl getCartListToastUseCaseImpl, String str) {
        this.f62186b = getCartListToastUseCaseImpl;
        this.f62187c = str;
    }

    public final Object apply(Object obj) {
        return GetCartListToastUseCaseImpl.m10199invoke$lambda2(this.f62186b, this.f62187c, (Boolean) obj);
    }
}
