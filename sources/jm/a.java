package jm;

import com.talabat.feature.darkstorescartlist.domain.usecase.GetCartListToastUseCaseImpl;
import io.reactivex.functions.Predicate;
import java.util.List;

public final /* synthetic */ class a implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f62180b;

    public /* synthetic */ a(String str) {
        this.f62180b = str;
    }

    public final boolean test(Object obj) {
        return GetCartListToastUseCaseImpl.m10187getCartListToastControl$lambda3(this.f62180b, (List) obj);
    }
}
