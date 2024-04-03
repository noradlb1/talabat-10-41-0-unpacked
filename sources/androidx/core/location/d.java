package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Consumer f11330b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Location f11331c;

    public /* synthetic */ d(Consumer consumer, Location location) {
        this.f11330b = consumer;
        this.f11331c = location;
    }

    public final void run() {
        this.f11330b.accept(this.f11331c);
    }
}
