package com.talabat.darkstores.di;

import com.integration.IntegrationGlobalDataModel;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\u0007H\u0007¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/di/DarkstoresUserDataModule;", "", "()V", "provideSelectedAreaId", "", "provideSelectedCountryId", "provideSelectedLatitude", "", "provideSelectedLongitude", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class DarkstoresUserDataModule {
    @NotNull
    public static final DarkstoresUserDataModule INSTANCE = new DarkstoresUserDataModule();

    private DarkstoresUserDataModule() {
    }

    @Provides
    @Named("selectedAreaId")
    public final int provideSelectedAreaId() {
        return IntegrationGlobalDataModel.Companion.getSelectedAreaId();
    }

    @Provides
    @Named("selectedCountryId")
    public final int provideSelectedCountryId() {
        return IntegrationGlobalDataModel.Companion.selectedCountryCode();
    }

    @NotNull
    @Provides
    @Named("selectedLatitude")
    public final String provideSelectedLatitude() {
        return IntegrationGlobalDataModel.Companion.getCustomerSavedLatitude();
    }

    @NotNull
    @Provides
    @Named("selectedLongitude")
    public final String provideSelectedLongitude() {
        return IntegrationGlobalDataModel.Companion.getCustomerSavedLongitude();
    }
}
