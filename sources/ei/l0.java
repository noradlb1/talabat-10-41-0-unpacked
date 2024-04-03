package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class l0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56797b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56798c;

    public /* synthetic */ l0(DiscoveryRepo discoveryRepo, String str) {
        this.f56797b = discoveryRepo;
        this.f56798c = str;
    }

    public final void accept(Object obj) {
        DiscoveryRepo.m9693getProductDetails$lambda25(this.f56797b, this.f56798c, (Throwable) obj);
    }
}
