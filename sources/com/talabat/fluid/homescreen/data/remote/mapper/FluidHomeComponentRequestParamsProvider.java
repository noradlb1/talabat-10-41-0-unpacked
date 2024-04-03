package com.talabat.fluid.homescreen.data.remote.mapper;

import com.talabat.configuration.country.Country;
import com.talabat.configuration.language.Language;
import com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentRequestParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u0014R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/fluid/homescreen/data/remote/mapper/FluidHomeComponentRequestParamsProvider;", "", "tProPlanId", "", "selectedCountry", "Lcom/talabat/configuration/country/Country;", "latLongProvider", "Lkotlin/Function0;", "Lkotlin/Pair;", "", "selectedAreaProvider", "deviceWidthInDP", "selectedLanguageProvider", "Lcom/talabat/configuration/language/Language;", "getACodeComponentEnabled", "", "(Ljava/lang/String;Lcom/talabat/configuration/country/Country;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "createExternalExperimentList", "", "getFluidHomeComponentRequestParams", "Lcom/talabat/fluid/homescreen/data/remote/component/FluidHomeComponentRequestParams;", "Companion", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeComponentRequestParamsProvider {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String PROMO_CODE_COMPONENT = "show_voucher_code_entry";
    @NotNull
    private final Function0<String> deviceWidthInDP;
    @NotNull
    private final Function0<Boolean> getACodeComponentEnabled;
    @NotNull
    private final Function0<Pair<Double, Double>> latLongProvider;
    @NotNull
    private final Function0<String> selectedAreaProvider;
    @NotNull
    private final Country selectedCountry;
    @NotNull
    private final Function0<Language> selectedLanguageProvider;
    @NotNull
    private final String tProPlanId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/fluid/homescreen/data/remote/mapper/FluidHomeComponentRequestParamsProvider$Companion;", "", "()V", "PROMO_CODE_COMPONENT", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FluidHomeComponentRequestParamsProvider(@NotNull String str, @NotNull Country country, @NotNull Function0<Pair<Double, Double>> function0, @NotNull Function0<String> function02, @NotNull Function0<String> function03, @NotNull Function0<? extends Language> function04, @NotNull Function0<Boolean> function05) {
        Intrinsics.checkNotNullParameter(str, "tProPlanId");
        Intrinsics.checkNotNullParameter(country, "selectedCountry");
        Intrinsics.checkNotNullParameter(function0, "latLongProvider");
        Intrinsics.checkNotNullParameter(function02, "selectedAreaProvider");
        Intrinsics.checkNotNullParameter(function03, "deviceWidthInDP");
        Intrinsics.checkNotNullParameter(function04, "selectedLanguageProvider");
        Intrinsics.checkNotNullParameter(function05, "getACodeComponentEnabled");
        this.tProPlanId = str;
        this.selectedCountry = country;
        this.latLongProvider = function0;
        this.selectedAreaProvider = function02;
        this.deviceWidthInDP = function03;
        this.selectedLanguageProvider = function04;
        this.getACodeComponentEnabled = function05;
    }

    private final List<String> createExternalExperimentList() {
        List<String> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(this.tProPlanId);
        if (this.getACodeComponentEnabled.invoke().booleanValue()) {
            mutableListOf.add(PROMO_CODE_COMPONENT);
        }
        return mutableListOf;
    }

    @NotNull
    public final FluidHomeComponentRequestParams getFluidHomeComponentRequestParams() {
        Pair invoke = this.latLongProvider.invoke();
        return new FluidHomeComponentRequestParams(createExternalExperimentList(), this.deviceWidthInDP.invoke(), this.selectedCountry.getTwoLetterCode(), String.valueOf(((Number) invoke.component1()).doubleValue()), String.valueOf(((Number) invoke.component2()).doubleValue()), this.selectedAreaProvider.invoke(), this.selectedLanguageProvider.invoke());
    }
}
