package ij;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.darkstores.feature.mission.control.GetLifestyleMissionControlProductsUseCase;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;

public final /* synthetic */ class b implements MaybeOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ITalabatFeatureFlag f56908a;

    public /* synthetic */ b(ITalabatFeatureFlag iTalabatFeatureFlag) {
        this.f56908a = iTalabatFeatureFlag;
    }

    public final void subscribe(MaybeEmitter maybeEmitter) {
        GetLifestyleMissionControlProductsUseCase.m10001campaignTriggersByProduct$lambda2(this.f56908a, maybeEmitter);
    }
}
