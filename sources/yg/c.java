package yg;

import com.google.android.gms.tasks.OnFailureListener;
import com.talabat.core.google.login.data.datasource.impl.GoogleLoginDataSourceImpl;
import io.reactivex.CompletableEmitter;

public final /* synthetic */ class c implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CompletableEmitter f58017a;

    public /* synthetic */ c(CompletableEmitter completableEmitter) {
        this.f58017a = completableEmitter;
    }

    public final void onFailure(Exception exc) {
        GoogleLoginDataSourceImpl.m9601logout$lambda7$lambda6(this.f58017a, exc);
    }
}
