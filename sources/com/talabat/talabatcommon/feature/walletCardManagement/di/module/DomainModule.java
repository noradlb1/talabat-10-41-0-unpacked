package com.talabat.talabatcommon.feature.walletCardManagement.di.module;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006R\u0018\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/di/module/DomainModule;", "", "()V", "selectedCountryIdProvider", "Lkotlin/Function0;", "", "Lcom/talabat/talabatcommon/feature/walletCardManagement/di/module/SelectedCountryIdProvider;", "provideSelectedCountryId", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DomainModule {
    @NotNull
    public static final DomainModule INSTANCE = new DomainModule();
    @NotNull
    private static final Function0<Integer> selectedCountryIdProvider = DomainModule$selectedCountryIdProvider$1.INSTANCE;

    private DomainModule() {
    }

    @NotNull
    public final Function0<Integer> provideSelectedCountryId() {
        return selectedCountryIdProvider;
    }
}
