package p10;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import library.talabat.mvp.login.LoginInteractor;

public final /* synthetic */ class l implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginInteractor f28144b;

    public /* synthetic */ l(LoginInteractor loginInteractor) {
        this.f28144b = loginInteractor;
    }

    public final void accept(Object obj) {
        this.f28144b.handleMergedResult((Pair) obj);
    }
}
