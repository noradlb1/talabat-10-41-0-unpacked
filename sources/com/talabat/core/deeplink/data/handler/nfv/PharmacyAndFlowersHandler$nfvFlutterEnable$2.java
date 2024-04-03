package com.talabat.core.deeplink.data.handler.nfv;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QcommerceExperimentsKeys;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PharmacyAndFlowersHandler$nfvFlutterEnable$2 extends Lambda implements Function0<Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ITalabatExperiment f55818g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PharmacyAndFlowersHandler$nfvFlutterEnable$2(ITalabatExperiment iTalabatExperiment) {
        super(0);
        this.f55818g = iTalabatExperiment;
    }

    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(Intrinsics.areEqual((Object) this.f55818g.getStringVariant(QcommerceExperimentsKeys.QCOMMERCE_NFV_FLUTTER_NAVIGATION, "", TalabatExperimentDataSourceStrategy.FWF), (Object) "Variation1"));
    }
}
