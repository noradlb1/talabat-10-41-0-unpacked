package gi;

import com.talabat.darkstores.data.mission.control.MissionControlProductRepository;
import io.reactivex.functions.Function;
import kotlin.Pair;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MissionControlProductRepository f56847b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56848c;

    public /* synthetic */ c(MissionControlProductRepository missionControlProductRepository, String str) {
        this.f56847b = missionControlProductRepository;
        this.f56848c = str;
    }

    public final Object apply(Object obj) {
        return MissionControlProductRepository.m9722getDeprecatedMissionControlProducts$lambda2(this.f56847b, this.f56848c, (Pair) obj);
    }
}
