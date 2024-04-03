package nc;

import android.os.Handler;
import android.os.Message;
import com.instabug.featuresrequest.ui.custom.t;

public final /* synthetic */ class e implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f47173b;

    public /* synthetic */ e(t tVar) {
        this.f47173b = tVar;
    }

    public final boolean handleMessage(Message message) {
        return this.f47173b.a(message);
    }
}
