package ei;

import com.talabat.darkstores.data.basket.model.SwimlaneResponse;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import java.util.concurrent.Callable;

public final /* synthetic */ class h0 implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwimlaneResponse f56786b;

    public /* synthetic */ h0(SwimlaneResponse swimlaneResponse) {
        this.f56786b = swimlaneResponse;
    }

    public final Object call() {
        return DiscoveryRepo.m9709getSwimlane$lambda37$lambda36(this.f56786b);
    }
}
