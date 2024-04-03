package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class r implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56808b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56809c;

    public /* synthetic */ r(DiscoveryRepo discoveryRepo, String str) {
        this.f56808b = discoveryRepo;
        this.f56809c = str;
    }

    public final void accept(Object obj) {
        DiscoveryRepo.m9716search$lambda11$lambda9(this.f56808b, this.f56809c, (Throwable) obj);
    }
}
