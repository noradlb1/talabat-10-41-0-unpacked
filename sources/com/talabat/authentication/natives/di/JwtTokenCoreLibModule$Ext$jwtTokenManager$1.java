package com.talabat.authentication.natives.di;

import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/talabatremoteconfiguration/datasource/IRemoteConfigurationDataSource;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class JwtTokenCoreLibModule$Ext$jwtTokenManager$1 extends Lambda implements Function0<IRemoteConfigurationDataSource> {
    public static final JwtTokenCoreLibModule$Ext$jwtTokenManager$1 INSTANCE = new JwtTokenCoreLibModule$Ext$jwtTokenManager$1();

    public JwtTokenCoreLibModule$Ext$jwtTokenManager$1() {
        super(0);
    }

    @NotNull
    public final IRemoteConfigurationDataSource invoke() {
        return RemoteConfiguration.INSTANCE.getRemoteConfigurationDataSource();
    }
}
