package com.talabat.core.safety.data.di;

import com.talabat.core.safety.data.DefaultSafetyAgent;
import com.talabat.core.safety.data.datasource.api.SafetyApi;
import com.talabat.core.safety.data.datasource.api.playintegrity.PlayIntegrityApi;
import com.talabat.core.safety.data.datasource.availability.AvailabilityCheck;
import com.talabat.core.safety.data.datasource.availability.play.GooglePlayAvailabilityCheck;
import com.talabat.core.safety.data.datasource.info.ShieldInfoDtoFactory;
import com.talabat.core.safety.data.datasource.info.impl.DefaultShieldInfoDtoFactory;
import com.talabat.core.safety.data.repository.protection.ProtectionRepository;
import com.talabat.core.safety.data.repository.protection.local.LocalProtectionRepository;
import com.talabat.core.safety.data.repository.shield.ShieldRepository;
import com.talabat.core.safety.data.repository.shield.remote.RemoteShieldRepository;
import com.talabat.core.safety.domain.SafetyAgent;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0011H'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0014H'¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/safety/data/di/SafetyModule;", "", "availabilityCheck", "Lcom/talabat/core/safety/data/datasource/availability/AvailabilityCheck;", "real", "Lcom/talabat/core/safety/data/datasource/availability/play/GooglePlayAvailabilityCheck;", "dtoFactory", "Lcom/talabat/core/safety/data/datasource/info/ShieldInfoDtoFactory;", "Lcom/talabat/core/safety/data/datasource/info/impl/DefaultShieldInfoDtoFactory;", "protectionRepository", "Lcom/talabat/core/safety/data/repository/protection/ProtectionRepository;", "Lcom/talabat/core/safety/data/repository/protection/local/LocalProtectionRepository;", "remoteRepository", "Lcom/talabat/core/safety/data/repository/shield/ShieldRepository;", "Lcom/talabat/core/safety/data/repository/shield/remote/RemoteShieldRepository;", "safetyAgent", "Lcom/talabat/core/safety/domain/SafetyAgent;", "Lcom/talabat/core/safety/data/DefaultSafetyAgent;", "safetyNetApi", "Lcom/talabat/core/safety/data/datasource/api/SafetyApi;", "Lcom/talabat/core/safety/data/datasource/api/playintegrity/PlayIntegrityApi;", "com_talabat_core_safety_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface SafetyModule {
    @NotNull
    @Binds
    @Reusable
    AvailabilityCheck availabilityCheck(@NotNull GooglePlayAvailabilityCheck googlePlayAvailabilityCheck);

    @NotNull
    @Binds
    @Reusable
    ShieldInfoDtoFactory dtoFactory(@NotNull DefaultShieldInfoDtoFactory defaultShieldInfoDtoFactory);

    @NotNull
    @Binds
    @Reusable
    ProtectionRepository protectionRepository(@NotNull LocalProtectionRepository localProtectionRepository);

    @NotNull
    @Binds
    @Reusable
    ShieldRepository remoteRepository(@NotNull RemoteShieldRepository remoteShieldRepository);

    @NotNull
    @Binds
    @Reusable
    SafetyAgent safetyAgent(@NotNull DefaultSafetyAgent defaultSafetyAgent);

    @NotNull
    @Binds
    @Reusable
    SafetyApi safetyNetApi(@NotNull PlayIntegrityApi playIntegrityApi);
}
