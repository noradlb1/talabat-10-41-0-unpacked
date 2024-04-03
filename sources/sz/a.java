package sz;

import android.content.Context;
import android.os.Handler;
import io.flutter.embedding.engine.loader.FlutterLoader;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterLoader f24110b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f24111c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String[] f24112d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Handler f24113e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Runnable f24114f;

    public /* synthetic */ a(FlutterLoader flutterLoader, Context context, String[] strArr, Handler handler, Runnable runnable) {
        this.f24110b = flutterLoader;
        this.f24111c = context;
        this.f24112d = strArr;
        this.f24113e = handler;
        this.f24114f = runnable;
    }

    public final void run() {
        this.f24110b.lambda$ensureInitializationCompleteAsync$0(this.f24111c, this.f24112d, this.f24113e, this.f24114f);
    }
}
