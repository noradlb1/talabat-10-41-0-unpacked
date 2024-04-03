package g40;

import JsonModels.Response.AppInitRM;
import com.android.volley.Response;
import io.reactivex.SingleEmitter;

public final /* synthetic */ class h implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f63141b;

    public /* synthetic */ h(SingleEmitter singleEmitter) {
        this.f63141b = singleEmitter;
    }

    public final void onResponse(Object obj) {
        this.f63141b.onSuccess((AppInitRM) obj);
    }
}
