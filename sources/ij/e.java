package ij;

import com.talabat.darkstores.data.search.model.SearchResultsResponse;
import com.talabat.darkstores.feature.mission.control.GetLifestyleMissionControlProductsUseCase;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetLifestyleMissionControlProductsUseCase f56910b;

    public /* synthetic */ e(GetLifestyleMissionControlProductsUseCase getLifestyleMissionControlProductsUseCase) {
        this.f56910b = getLifestyleMissionControlProductsUseCase;
    }

    public final void accept(Object obj) {
        GetLifestyleMissionControlProductsUseCase.m10006getMissionControlProducts$lambda6(this.f56910b, (SearchResultsResponse) obj);
    }
}
