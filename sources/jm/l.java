package jm;

import com.talabat.feature.darkstorescartlist.domain.usecase.GetCartListToastUseCaseImpl;
import io.reactivex.functions.Predicate;
import java.util.List;

public final /* synthetic */ class l implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f62188b;

    public /* synthetic */ l(String str) {
        this.f62188b = str;
    }

    public final boolean test(Object obj) {
        return GetCartListToastUseCaseImpl.m10195getCartListToastVariation1$lambda8(this.f62188b, (List) obj);
    }
}
