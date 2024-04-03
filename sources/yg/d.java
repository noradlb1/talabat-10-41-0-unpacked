package yg;

import com.talabat.core.google.login.data.datasource.impl.GoogleLoginDataSourceImpl;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;

public final /* synthetic */ class d implements CompletableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GoogleLoginDataSourceImpl f58018a;

    public /* synthetic */ d(GoogleLoginDataSourceImpl googleLoginDataSourceImpl) {
        this.f58018a = googleLoginDataSourceImpl;
    }

    public final void subscribe(CompletableEmitter completableEmitter) {
        GoogleLoginDataSourceImpl.m9599logout$lambda7(this.f58018a, completableEmitter);
    }
}
