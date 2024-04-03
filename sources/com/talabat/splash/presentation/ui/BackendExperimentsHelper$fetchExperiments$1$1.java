package com.talabat.splash.presentation.ui;

import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "experimentValue", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BackendExperimentsHelper$fetchExperiments$1$1 extends Lambda implements Function1<String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TalabatExperimentConstants f61518g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackendExperimentsHelper$fetchExperiments$1$1(TalabatExperimentConstants talabatExperimentConstants) {
        super(1);
        this.f61518g = talabatExperimentConstants;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "experimentValue");
        TalabatExperimentConstants talabatExperimentConstants = this.f61518g;
        LogManager.debug("Backend experiment " + talabatExperimentConstants + ": " + str);
    }
}
