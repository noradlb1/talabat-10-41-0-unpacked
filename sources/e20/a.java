package e20;

import java.util.concurrent.ThreadFactory;
import okhttp3.internal.Util;

public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f24321b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f24322c;

    public /* synthetic */ a(String str, boolean z11) {
        this.f24321b = str;
        this.f24322c = z11;
    }

    public final Thread newThread(Runnable runnable) {
        return Util.m8049threadFactory$lambda1(this.f24321b, this.f24322c, runnable);
    }
}
