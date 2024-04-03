package androidx.appcompat.app;

import androidx.appcompat.app.AppLocalesStorageHelper;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppLocalesStorageHelper.SerialExecutor f642b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f643c;

    public /* synthetic */ c(AppLocalesStorageHelper.SerialExecutor serialExecutor, Runnable runnable) {
        this.f642b = serialExecutor;
        this.f643c = runnable;
    }

    public final void run() {
        this.f642b.lambda$execute$0(this.f643c);
    }
}
