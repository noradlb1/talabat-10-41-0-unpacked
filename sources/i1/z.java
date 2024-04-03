package i1;

import android.location.Location;
import androidx.core.util.Consumer;

public final /* synthetic */ class z implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Consumer f11596b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Location f11597c;

    public /* synthetic */ z(Consumer consumer, Location location) {
        this.f11596b = consumer;
        this.f11597c = location;
    }

    public final void run() {
        this.f11596b.accept(this.f11597c);
    }
}
