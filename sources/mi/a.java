package mi;

import com.talabat.darkstores.data.swimlanes.SwimlanesProductRepository;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwimlanesProductRepository f57023b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f57024c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f57025d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f57026e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f57027f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f57028g;

    public /* synthetic */ a(SwimlanesProductRepository swimlanesProductRepository, String str, String str2, String str3, int i11, String str4) {
        this.f57023b = swimlanesProductRepository;
        this.f57024c = str;
        this.f57025d = str2;
        this.f57026e = str3;
        this.f57027f = i11;
        this.f57028g = str4;
    }

    public final Object apply(Object obj) {
        return SwimlanesProductRepository.m9742getSwimlaneProducts$lambda0(this.f57023b, this.f57024c, this.f57025d, this.f57026e, this.f57027f, this.f57028g, (Vendor) obj);
    }
}
