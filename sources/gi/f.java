package gi;

import com.talabat.darkstores.data.mission.control.MissionControlProductRepository;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MissionControlProductRepository f56854b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56855c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f56856d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f56857e;

    public /* synthetic */ f(MissionControlProductRepository missionControlProductRepository, String str, int i11, int i12) {
        this.f56854b = missionControlProductRepository;
        this.f56855c = str;
        this.f56856d = i11;
        this.f56857e = i12;
    }

    public final Object apply(Object obj) {
        return MissionControlProductRepository.m9720createBaseSearchRequestWithVendorId$lambda4(this.f56854b, this.f56855c, this.f56856d, this.f56857e, (Vendor) obj);
    }
}
