package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class b0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f56772b;

    public /* synthetic */ b0(String str) {
        this.f56772b = str;
    }

    public final void accept(Object obj) {
        DiscoveryRepo.m9717search$lambda13(this.f56772b, (List) obj);
    }
}
