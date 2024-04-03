package v6;

import com.facebook.internal.FileLruCache;
import java.io.File;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ File[] f34755b;

    public /* synthetic */ k(File[] fileArr) {
        this.f34755b = fileArr;
    }

    public final void run() {
        FileLruCache.m8955clearCache$lambda1(this.f34755b);
    }
}
