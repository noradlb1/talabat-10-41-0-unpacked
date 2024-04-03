package k;

import android.net.Uri;
import androidx.browser.trusted.TrustedWebActivityServiceConnectionPool;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TrustedWebActivityServiceConnectionPool f11598b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Uri f11599c;

    public /* synthetic */ l(TrustedWebActivityServiceConnectionPool trustedWebActivityServiceConnectionPool, Uri uri) {
        this.f11598b = trustedWebActivityServiceConnectionPool;
        this.f11599c = uri;
    }

    public final void run() {
        this.f11598b.lambda$connect$0(this.f11599c);
    }
}
