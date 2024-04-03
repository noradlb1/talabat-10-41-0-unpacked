package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import io.reactivex.functions.Function;

public final /* synthetic */ class c0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f56775b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeedEndpointRequest.PageType f56776c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f56777d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f56778e;

    public /* synthetic */ c0(String str, FeedEndpointRequest.PageType pageType, int i11, String str2) {
        this.f56775b = str;
        this.f56776c = pageType;
        this.f56777d = i11;
        this.f56778e = str2;
    }

    public final Object apply(Object obj) {
        return DiscoveryRepo.m9704getSubcategorySwimlanes$lambda4(this.f56775b, this.f56776c, this.f56777d, this.f56778e, (FeedEndpointRequest) obj);
    }
}
