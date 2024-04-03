package md;

import com.instabug.library.model.session.SessionState;
import com.instabug.library.tracking.u;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f57022b;

    public /* synthetic */ d(u uVar) {
        this.f57022b = uVar;
    }

    public final void accept(Object obj) {
        u.a(this.f57022b, (SessionState) obj);
    }
}
