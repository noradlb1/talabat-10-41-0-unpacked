package com.talabat.userandlocation.choosecountry;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/ChooseCountryModuleIntegrator;", "", "()V", "onCountryChange", "Lkotlin/Function0;", "", "getOnCountryChange", "()Lkotlin/jvm/functions/Function0;", "setOnCountryChange", "(Lkotlin/jvm/functions/Function0;)V", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChooseCountryModuleIntegrator {
    @NotNull
    public static final ChooseCountryModuleIntegrator INSTANCE = new ChooseCountryModuleIntegrator();
    @NotNull
    private static Function0<Unit> onCountryChange = ChooseCountryModuleIntegrator$onCountryChange$1.INSTANCE;

    private ChooseCountryModuleIntegrator() {
    }

    @NotNull
    public final Function0<Unit> getOnCountryChange() {
        return onCountryChange;
    }

    public final void setOnCountryChange(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        onCountryChange = function0;
    }
}
