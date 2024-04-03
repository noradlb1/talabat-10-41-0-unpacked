package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class i implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f56787b;

    public /* synthetic */ i(List list) {
        this.f56787b = list;
    }

    public final Object call() {
        return DiscoveryRepo.m9690getPastOrders$lambda33$lambda32(this.f56787b);
    }
}
