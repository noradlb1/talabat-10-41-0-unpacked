package com.talabat.address.list;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/talabat/address/list/AddressListModule;", "", "()V", "addressListEventsListener", "Lcom/talabat/address/list/AddressListEventsListener;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class AddressListModule {
    @NotNull
    public static final AddressListModule INSTANCE = new AddressListModule();

    private AddressListModule() {
    }

    @JvmStatic
    @NotNull
    @Provides
    public static final AddressListEventsListener addressListEventsListener(@NotNull TalabatTracker talabatTracker, @NotNull ConfigurationLocalRepository configurationLocalRepository) {
        Intrinsics.checkNotNullParameter(talabatTracker, "talabatTracker");
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        return new AddressListEventsTracker(talabatTracker, configurationLocalRepository, (Function0) null, 4, (DefaultConstructorMarker) null);
    }
}
