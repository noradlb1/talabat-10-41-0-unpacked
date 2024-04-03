package a9;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import java.util.concurrent.Executor;

public final /* synthetic */ class c implements RemovalListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f44465b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RemovalListener f44466c;

    public /* synthetic */ c(Executor executor, RemovalListener removalListener) {
        this.f44465b = executor;
        this.f44466c = removalListener;
    }

    public final void onRemoval(RemovalNotification removalNotification) {
        this.f44465b.execute(new b(this.f44466c, removalNotification));
    }
}
