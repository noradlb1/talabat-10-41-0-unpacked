package sz;

import android.content.Context;
import android.os.Handler;
import io.flutter.embedding.engine.loader.FlutterLoader;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FlutterLoader f24115b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f24116c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String[] f24117d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Handler f24118e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Runnable f24119f;

    public /* synthetic */ b(FlutterLoader flutterLoader, Context context, String[] strArr, Handler handler, Runnable runnable) {
        this.f24115b = flutterLoader;
        this.f24116c = context;
        this.f24117d = strArr;
        this.f24118e = handler;
        this.f24119f = runnable;
    }

    public final void run() {
        this.f24115b.lambda$ensureInitializationCompleteAsync$1(this.f24116c, this.f24117d, this.f24118e, this.f24119f);
    }
}
