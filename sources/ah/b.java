package ah;

import com.talabat.core.google.login.data.impl.GoogleLoginRepositoryImpl;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public final /* synthetic */ class b implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GoogleLoginRepositoryImpl f50821a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f50822b;

    public /* synthetic */ b(GoogleLoginRepositoryImpl googleLoginRepositoryImpl, int i11) {
        this.f50821a = googleLoginRepositoryImpl;
        this.f50822b = i11;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        GoogleLoginRepositoryImpl.m9602login$lambda4(this.f50821a, this.f50822b, singleEmitter);
    }
}
