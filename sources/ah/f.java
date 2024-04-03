package ah;

import com.talabat.core.google.login.data.impl.GoogleLoginRepositoryImpl;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GoogleLoginRepositoryImpl f50825b;

    public /* synthetic */ f(GoogleLoginRepositoryImpl googleLoginRepositoryImpl) {
        this.f50825b = googleLoginRepositoryImpl;
    }

    public final void accept(Object obj) {
        GoogleLoginRepositoryImpl.m9606logout$lambda6$lambda5(this.f50825b, (Throwable) obj);
    }
}
