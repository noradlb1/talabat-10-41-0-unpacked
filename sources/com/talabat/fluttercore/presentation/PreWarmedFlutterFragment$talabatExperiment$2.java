package com.talabat.fluttercore.presentation;

import androidx.fragment.app.Fragment;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.ui.di.AndroidComponentsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PreWarmedFlutterFragment$talabatExperiment$2 extends Lambda implements Function0<ITalabatExperiment> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PreWarmedFlutterFragment f59779g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreWarmedFlutterFragment$talabatExperiment$2(PreWarmedFlutterFragment preWarmedFlutterFragment) {
        super(0);
        this.f59779g = preWarmedFlutterFragment;
    }

    @NotNull
    public final ITalabatExperiment invoke() {
        return ((ExperimentCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this.f59779g).getFeature(ExperimentCoreLibApi.class)).getExperimentProvider();
    }
}
