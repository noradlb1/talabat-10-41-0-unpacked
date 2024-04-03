package ij;

import com.talabat.darkstores.feature.mission.control.GetLifestyleMissionControlProductsUseCase;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetLifestyleMissionControlProductsUseCase f56911b;

    public /* synthetic */ f(GetLifestyleMissionControlProductsUseCase getLifestyleMissionControlProductsUseCase) {
        this.f56911b = getLifestyleMissionControlProductsUseCase;
    }

    public final void accept(Object obj) {
        GetLifestyleMissionControlProductsUseCase.m10007getMissionControlProducts$lambda7(this.f56911b, (Throwable) obj);
    }
}
