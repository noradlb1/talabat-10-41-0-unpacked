package oj;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.darkstores.feature.searchResults.SearchResultsUseCase;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;

public final /* synthetic */ class h implements MaybeOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ITalabatFeatureFlag f57088a;

    public /* synthetic */ h(ITalabatFeatureFlag iTalabatFeatureFlag) {
        this.f57088a = iTalabatFeatureFlag;
    }

    public final void subscribe(MaybeEmitter maybeEmitter) {
        SearchResultsUseCase.m10085campaignTriggersByProduct$lambda2(this.f57088a, maybeEmitter);
    }
}
