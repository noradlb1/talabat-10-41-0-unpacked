package da;

import android.content.Context;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class d implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f50606a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f50607b;

    public /* synthetic */ d(Context context, String str) {
        this.f50606a = context;
        this.f50607b = str;
    }

    public final Object get() {
        return DefaultHeartBeatController.lambda$new$2(this.f50606a, this.f50607b);
    }
}
