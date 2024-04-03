package yg;

import com.talabat.core.google.login.data.datasource.impl.GoogleLoginDataSourceImpl;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public final /* synthetic */ class a implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GoogleLoginDataSourceImpl f58014a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f58015b;

    public /* synthetic */ a(GoogleLoginDataSourceImpl googleLoginDataSourceImpl, int i11) {
        this.f58014a = googleLoginDataSourceImpl;
        this.f58015b = i11;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        GoogleLoginDataSourceImpl.m9597login$lambda4(this.f58014a, this.f58015b, singleEmitter);
    }
}
