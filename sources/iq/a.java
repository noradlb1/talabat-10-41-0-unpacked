package iq;

import com.talabat.flutter.groceryhome.domain.usecase.GetClosestDarkstoreInfoUseCaseImpl;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetClosestDarkstoreInfoUseCaseImpl f62164b;

    public /* synthetic */ a(GetClosestDarkstoreInfoUseCaseImpl getClosestDarkstoreInfoUseCaseImpl) {
        this.f62164b = getClosestDarkstoreInfoUseCaseImpl;
    }

    public final Object call() {
        return GetClosestDarkstoreInfoUseCaseImpl.m10471invoke$lambda0(this.f62164b);
    }
}
