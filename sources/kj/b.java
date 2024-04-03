package kj;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.darkstores.feature.product.usecase.ProductSwimlanesUseCase;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;

public final /* synthetic */ class b implements MaybeOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ITalabatFeatureFlag f56976a;

    public /* synthetic */ b(ITalabatFeatureFlag iTalabatFeatureFlag) {
        this.f56976a = iTalabatFeatureFlag;
    }

    public final void subscribe(MaybeEmitter maybeEmitter) {
        ProductSwimlanesUseCase.m10044campaignTriggersByProduct$lambda2(this.f56976a, maybeEmitter);
    }
}
