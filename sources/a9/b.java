package a9;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RemovalListener f44463b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RemovalNotification f44464c;

    public /* synthetic */ b(RemovalListener removalListener, RemovalNotification removalNotification) {
        this.f44463b = removalListener;
        this.f44464c = removalNotification;
    }

    public final void run() {
        this.f44463b.onRemoval(this.f44464c);
    }
}
