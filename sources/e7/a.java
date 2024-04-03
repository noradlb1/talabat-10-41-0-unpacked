package e7;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

public final /* synthetic */ class a implements SynchronizationGuard.CriticalSection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultScheduler f34425a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f34426b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EventInternal f34427c;

    public /* synthetic */ a(DefaultScheduler defaultScheduler, TransportContext transportContext, EventInternal eventInternal) {
        this.f34425a = defaultScheduler;
        this.f34426b = transportContext;
        this.f34427c = eventInternal;
    }

    public final Object execute() {
        return this.f34425a.lambda$schedule$0(this.f34426b, this.f34427c);
    }
}
