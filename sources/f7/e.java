package f7;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Uploader f34443b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f34444c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f34445d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Runnable f34446e;

    public /* synthetic */ e(Uploader uploader, TransportContext transportContext, int i11, Runnable runnable) {
        this.f34443b = uploader;
        this.f34444c = transportContext;
        this.f34445d = i11;
        this.f34446e = runnable;
    }

    public final void run() {
        this.f34443b.lambda$upload$1(this.f34444c, this.f34445d, this.f34446e);
    }
}
