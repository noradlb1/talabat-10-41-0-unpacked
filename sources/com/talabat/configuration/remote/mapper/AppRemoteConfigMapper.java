package com.talabat.configuration.remote.mapper;

import com.talabat.configuration.AppRemoteConfig;
import com.talabat.configuration.remote.model.AppInfoEntity;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/configuration/remote/mapper/AppRemoteConfigMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/configuration/remote/model/AppInfoEntity;", "Lcom/talabat/configuration/AppRemoteConfig;", "()V", "apply", "source", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppRemoteConfigMapper implements ModelMapper<AppInfoEntity, AppRemoteConfig> {
    @NotNull
    public AppRemoteConfig apply(@NotNull AppInfoEntity appInfoEntity) {
        Intrinsics.checkNotNullParameter(appInfoEntity, "source");
        return new AppRemoteConfig("");
    }
}
