package com.talabat.core.network;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u000b\u001a\u00020\u00062\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000fH\u0007\u001a\u001b\u0010\u0003\u001a\u00020\u000e*\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0004\"*\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u001e\u0010\u0005\u001a\u00020\u0006*\u00020\u00068FX\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"<set-?>", "Lkotlin/Function0;", "", "isMidasInterceptorActive", "()Lkotlin/jvm/functions/Function0;", "set", "Lcom/talabat/core/network/TalabatCore;", "getSet$annotations", "(Lcom/talabat/core/network/TalabatCore;)V", "getSet", "(Lcom/talabat/core/network/TalabatCore;)Lcom/talabat/core/network/TalabatCore;", "TalabatCoreIntegration", "integration", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "isActive", "com_talabat_core_network_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TalabatCoreKt {
    @NotNull
    private static Function0<Boolean> isMidasInterceptorActive = TalabatCoreKt$isMidasInterceptorActive$1.INSTANCE;

    @NotNull
    @TalabatCoreIntegrationDsl
    public static final TalabatCore TalabatCoreIntegration(@NotNull Function1<? super TalabatCore, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "integration");
        TalabatCore talabatCore = TalabatCore.INSTANCE;
        function1.invoke(talabatCore);
        return talabatCore;
    }

    @NotNull
    public static final TalabatCore getSet(@NotNull TalabatCore talabatCore) {
        Intrinsics.checkNotNullParameter(talabatCore, "<this>");
        return talabatCore;
    }

    @TalabatCoreIntegrationDsl
    public static /* synthetic */ void getSet$annotations(TalabatCore talabatCore) {
    }

    @NotNull
    public static final Function0<Boolean> isMidasInterceptorActive() {
        return isMidasInterceptorActive;
    }

    @TalabatCoreIntegrationDsl
    public static final void isMidasInterceptorActive(@NotNull TalabatCore talabatCore, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(talabatCore, "<this>");
        Intrinsics.checkNotNullParameter(function0, "isActive");
        isMidasInterceptorActive = new TalabatCoreKt$isMidasInterceptorActive$2(talabatCore, function0);
    }
}
