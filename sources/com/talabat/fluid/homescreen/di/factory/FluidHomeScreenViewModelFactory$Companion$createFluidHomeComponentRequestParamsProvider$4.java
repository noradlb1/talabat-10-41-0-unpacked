package com.talabat.fluid.homescreen.di.factory;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.language.Language;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/configuration/language/Language;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeScreenViewModelFactory$Companion$createFluidHomeComponentRequestParamsProvider$4 extends Lambda implements Function0<Language> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ConfigurationLocalRepository f59715g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FluidHomeScreenViewModelFactory$Companion$createFluidHomeComponentRequestParamsProvider$4(ConfigurationLocalRepository configurationLocalRepository) {
        super(0);
        this.f59715g = configurationLocalRepository;
    }

    @NotNull
    public final Language invoke() {
        return this.f59715g.selectedLanguage();
    }
}
