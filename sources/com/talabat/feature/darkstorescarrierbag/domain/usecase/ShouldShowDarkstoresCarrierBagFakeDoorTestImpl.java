package com.talabat.feature.darkstorescarrierbag.domain.usecase;

import cm.b;
import cm.c;
import cm.d;
import com.google.firebase.perf.util.Constants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QcommerceExperimentsKeys;
import com.talabat.feature.darkstorescarrierbag.domain.repository.DarkstoresCarrierBagRepository;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/domain/usecase/ShouldShowDarkstoresCarrierBagFakeDoorTestImpl;", "Lcom/talabat/feature/darkstorescarrierbag/domain/usecase/ShouldShowDarkstoresCarrierBagFakeDoorTest;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "repository", "Lcom/talabat/feature/darkstorescarrierbag/domain/repository/DarkstoresCarrierBagRepository;", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/feature/darkstorescarrierbag/domain/repository/DarkstoresCarrierBagRepository;)V", "invoke", "Lio/reactivex/Single;", "", "com_talabat_feature_darkstores-carrier-bag_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShouldShowDarkstoresCarrierBagFakeDoorTestImpl implements ShouldShowDarkstoresCarrierBagFakeDoorTest {
    @NotNull
    private final DarkstoresCarrierBagRepository repository;
    @NotNull
    private final ITalabatExperiment talabatExperiment;

    @Inject
    public ShouldShowDarkstoresCarrierBagFakeDoorTestImpl(@NotNull ITalabatExperiment iTalabatExperiment, @NotNull DarkstoresCarrierBagRepository darkstoresCarrierBagRepository) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(darkstoresCarrierBagRepository, "repository");
        this.talabatExperiment = iTalabatExperiment;
        this.repository = darkstoresCarrierBagRepository;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final String m10156invoke$lambda0(ShouldShowDarkstoresCarrierBagFakeDoorTestImpl shouldShowDarkstoresCarrierBagFakeDoorTestImpl) {
        Intrinsics.checkNotNullParameter(shouldShowDarkstoresCarrierBagFakeDoorTestImpl, "this$0");
        return shouldShowDarkstoresCarrierBagFakeDoorTestImpl.talabatExperiment.getStringVariant(QcommerceExperimentsKeys.BASKET_CARRIER_BAG, "", TalabatExperimentDataSourceStrategy.FWF);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final Boolean m10157invoke$lambda1(String str) {
        Intrinsics.checkNotNullParameter(str, "variation");
        return Boolean.valueOf(Intrinsics.areEqual((Object) str, (Object) "Variation1"));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final Boolean m10158invoke$lambda2(Boolean bool, Boolean bool2) {
        boolean z11;
        Intrinsics.checkNotNullParameter(bool, Constants.ENABLE_DISABLE);
        Intrinsics.checkNotNullParameter(bool2, "isShown");
        if (!bool.booleanValue() || bool2.booleanValue()) {
            z11 = false;
        } else {
            z11 = true;
        }
        return Boolean.valueOf(z11);
    }

    @NotNull
    public Single<Boolean> invoke() {
        Single map = Single.fromCallable(new b(this)).map(new c());
        Intrinsics.checkNotNullExpressionValue(map, "fromCallable {\n         …ERIMENT_ENABLED\n        }");
        Single<Boolean> zip = Single.zip(map, this.repository.isDarkstoresCarrierBagFakeDoorTestShown(), new d());
        Intrinsics.checkNotNullExpressionValue(zip, "zip(isExperimentEnabled,…led && !isShown\n        }");
        return zip;
    }
}
