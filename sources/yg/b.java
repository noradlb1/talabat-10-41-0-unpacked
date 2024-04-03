package yg;

import com.google.android.gms.tasks.OnSuccessListener;
import com.talabat.core.google.login.data.datasource.impl.GoogleLoginDataSourceImpl;
import io.reactivex.CompletableEmitter;

public final /* synthetic */ class b implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CompletableEmitter f58016a;

    public /* synthetic */ b(CompletableEmitter completableEmitter) {
        this.f58016a = completableEmitter;
    }

    public final void onSuccess(Object obj) {
        GoogleLoginDataSourceImpl.m9600logout$lambda7$lambda5(this.f58016a, (Void) obj);
    }
}
