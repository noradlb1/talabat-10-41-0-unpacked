package ah;

import com.talabat.core.google.login.data.impl.GoogleLoginRepositoryImpl;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GoogleLoginRepositoryImpl f50823b;

    public /* synthetic */ d(GoogleLoginRepositoryImpl googleLoginRepositoryImpl) {
        this.f50823b = googleLoginRepositoryImpl;
    }

    public final void accept(Object obj) {
        GoogleLoginRepositoryImpl.m9604login$lambda4$lambda3(this.f50823b, (Throwable) obj);
    }
}
