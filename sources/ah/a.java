package ah;

import com.talabat.core.google.login.data.impl.GoogleLoginRepositoryImpl;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;

public final /* synthetic */ class a implements CompletableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GoogleLoginRepositoryImpl f50820a;

    public /* synthetic */ a(GoogleLoginRepositoryImpl googleLoginRepositoryImpl) {
        this.f50820a = googleLoginRepositoryImpl;
    }

    public final void subscribe(CompletableEmitter completableEmitter) {
        GoogleLoginRepositoryImpl.m9605logout$lambda6(this.f50820a, completableEmitter);
    }
}
