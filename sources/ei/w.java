package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class w implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56815b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56816c;

    public /* synthetic */ w(DiscoveryRepo discoveryRepo, String str) {
        this.f56815b = discoveryRepo;
        this.f56816c = str;
    }

    public final void accept(Object obj) {
        DiscoveryRepo.m9696getProductDetailsBySku$lambda28(this.f56815b, this.f56816c, (Throwable) obj);
    }
}
