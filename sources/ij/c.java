package ij;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.feature.mission.control.GetLifestyleMissionControlProductsUseCase;
import io.reactivex.functions.Function;
import kotlin.Unit;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56909b;

    public /* synthetic */ c(DarkstoresRepo darkstoresRepo) {
        this.f56909b = darkstoresRepo;
    }

    public final Object apply(Object obj) {
        return GetLifestyleMissionControlProductsUseCase.m10002campaignTriggersByProduct$lambda3(this.f56909b, (Unit) obj);
    }
}
