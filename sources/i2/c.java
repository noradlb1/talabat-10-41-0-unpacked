package i2;

import androidx.profileinstaller.ProfileInstaller;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback f44343b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f44344c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f44345d;

    public /* synthetic */ c(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i11, Object obj) {
        this.f44343b = diagnosticsCallback;
        this.f44344c = i11;
        this.f44345d = obj;
    }

    public final void run() {
        this.f44343b.onResultReceived(this.f44344c, this.f44345d);
    }
}
