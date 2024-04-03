package e7;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultScheduler f34428b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f34429c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TransportScheduleCallback f34430d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ EventInternal f34431e;

    public /* synthetic */ b(DefaultScheduler defaultScheduler, TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        this.f34428b = defaultScheduler;
        this.f34429c = transportContext;
        this.f34430d = transportScheduleCallback;
        this.f34431e = eventInternal;
    }

    public final void run() {
        this.f34428b.lambda$schedule$1(this.f34429c, this.f34430d, this.f34431e);
    }
}
