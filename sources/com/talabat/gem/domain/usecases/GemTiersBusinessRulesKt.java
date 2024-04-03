package com.talabat.gem.domain.usecases;

import com.talabat.gem.ports.presentation.GemTiersViewPort;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0007\u001a\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"STATIC_TIERS_MODE", "", "bindStaticTiersMode", "", "Lcom/talabat/gem/ports/presentation/GemTiersViewPort;", "bindTiers", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemTiersBusinessRulesKt {
    public static final int STATIC_TIERS_MODE = 4;

    @BusinessRules
    public static final void bindStaticTiersMode(@NotNull GemTiersViewPort gemTiersViewPort) {
        Intrinsics.checkNotNullParameter(gemTiersViewPort, "<this>");
        gemTiersViewPort.autoDispose(new GemTiersBusinessRulesKt$bindStaticTiersMode$1(gemTiersViewPort));
    }

    @BusinessRules
    public static final void bindTiers(@NotNull GemTiersViewPort gemTiersViewPort) {
        Intrinsics.checkNotNullParameter(gemTiersViewPort, "<this>");
        gemTiersViewPort.autoDispose(new GemTiersBusinessRulesKt$bindTiers$1(gemTiersViewPort));
    }
}
