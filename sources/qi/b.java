package qi;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.darkstores.domain.common.ApplyDiscountsAndCampaignsUseCaseImpl;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;

public final /* synthetic */ class b implements MaybeOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ITalabatFeatureFlag f57197a;

    public /* synthetic */ b(ITalabatFeatureFlag iTalabatFeatureFlag) {
        this.f57197a = iTalabatFeatureFlag;
    }

    public final void subscribe(MaybeEmitter maybeEmitter) {
        ApplyDiscountsAndCampaignsUseCaseImpl.m9744campaignTriggersByProduct$lambda2(this.f57197a, maybeEmitter);
    }
}
