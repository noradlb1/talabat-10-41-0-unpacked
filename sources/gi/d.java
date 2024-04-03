package gi;

import com.talabat.darkstores.data.mission.control.MissionControlProductRepository;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MissionControlProductRepository f56849b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56850c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f56851d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f56852e;

    public /* synthetic */ d(MissionControlProductRepository missionControlProductRepository, String str, int i11, String str2) {
        this.f56849b = missionControlProductRepository;
        this.f56850c = str;
        this.f56851d = i11;
        this.f56852e = str2;
    }

    public final Object apply(Object obj) {
        return MissionControlProductRepository.m9724getMissionControlProducts$lambda3(this.f56849b, this.f56850c, this.f56851d, this.f56852e, (Vendor) obj);
    }
}
