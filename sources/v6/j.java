package v6;

import com.facebook.internal.FileLruCache;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FileLruCache f34754b;

    public /* synthetic */ j(FileLruCache fileLruCache) {
        this.f34754b = fileLruCache;
    }

    public final void run() {
        FileLruCache.m8956postTrim$lambda3$lambda2(this.f34754b);
    }
}
