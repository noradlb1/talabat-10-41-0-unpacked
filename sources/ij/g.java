package ij;

import com.talabat.darkstores.data.search.model.SearchResultsResponse;
import com.talabat.darkstores.feature.mission.control.GetLifestyleMissionControlProductsUseCase;
import io.reactivex.functions.Function3;
import java.util.Map;

public final /* synthetic */ class g implements Function3 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GetLifestyleMissionControlProductsUseCase f56912a;

    public /* synthetic */ g(GetLifestyleMissionControlProductsUseCase getLifestyleMissionControlProductsUseCase) {
        this.f56912a = getLifestyleMissionControlProductsUseCase;
    }

    public final Object apply(Object obj, Object obj2, Object obj3) {
        return GetLifestyleMissionControlProductsUseCase.m10005getMissionControlProducts$lambda10(this.f56912a, (SearchResultsResponse) obj, (Map) obj2, (Map) obj3);
    }
}
