package com.talabat.gem.domain.usecases;

import com.talabat.gem.ports.presentation.GemHelpViewPort;
import com.talabat.talabatcommon.extentions.RxKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¨\u0006\u0003"}, d2 = {"onHowItWorksClicked", "", "Lcom/talabat/gem/ports/presentation/GemHelpViewPort;", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemHelpBusinessRulesKt {
    @BusinessRules
    @Deprecated(level = DeprecationLevel.WARNING, message = "not used in new component")
    public static final void onHowItWorksClicked(@NotNull GemHelpViewPort gemHelpViewPort) {
        Intrinsics.checkNotNullParameter(gemHelpViewPort, "<this>");
        RxKt.plusAssign(gemHelpViewPort.getHowItWorksVisibility(), Boolean.valueOf(!((Boolean) RxKt.get(gemHelpViewPort.getHowItWorksVisibility(), Boolean.FALSE)).booleanValue()));
    }
}
