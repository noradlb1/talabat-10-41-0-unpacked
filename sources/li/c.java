package li;

import com.talabat.darkstores.data.search.SearchRepository;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchRepository f56993b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56994c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f56995d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f56996e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f56997f;

    public /* synthetic */ c(SearchRepository searchRepository, String str, int i11, int i12, String str2) {
        this.f56993b = searchRepository;
        this.f56994c = str;
        this.f56995d = i11;
        this.f56996e = i12;
        this.f56997f = str2;
    }

    public final Object apply(Object obj) {
        return SearchRepository.m9733createBaseSearchRequestWithVendorId$lambda6(this.f56993b, this.f56994c, this.f56995d, this.f56996e, this.f56997f, (Vendor) obj);
    }
}
