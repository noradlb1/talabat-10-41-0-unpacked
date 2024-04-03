package gi;

import com.talabat.darkstores.data.mission.control.model.MissionControlProductsResponse;
import com.talabat.darkstores.domain.mapper.MissionControlProductsResponseToDomainMapper;
import io.reactivex.functions.Function;

public final /* synthetic */ class e implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MissionControlProductsResponseToDomainMapper f56853b;

    public /* synthetic */ e(MissionControlProductsResponseToDomainMapper missionControlProductsResponseToDomainMapper) {
        this.f56853b = missionControlProductsResponseToDomainMapper;
    }

    public final Object apply(Object obj) {
        return this.f56853b.invoke((MissionControlProductsResponse) obj);
    }
}
