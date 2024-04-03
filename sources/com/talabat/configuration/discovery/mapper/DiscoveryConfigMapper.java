package com.talabat.configuration.discovery.mapper;

import com.talabat.configuration.discovery.DiscoveryConfig;
import com.talabat.configuration.remote.model.AppInfoEntity;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/configuration/discovery/mapper/DiscoveryConfigMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/configuration/remote/model/AppInfoEntity;", "Lcom/talabat/configuration/discovery/DiscoveryConfig;", "()V", "apply", "source", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DiscoveryConfigMapper implements ModelMapper<AppInfoEntity, DiscoveryConfig> {
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r2 = r2.getNewAppVersion();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.configuration.discovery.DiscoveryConfig apply(@org.jetbrains.annotations.NotNull com.talabat.configuration.remote.model.AppInfoEntity r6) {
        /*
            r5 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.talabat.configuration.discovery.DiscoveryConfig r0 = new com.talabat.configuration.discovery.DiscoveryConfig
            com.talabat.configuration.discovery.NewAppVersion r1 = new com.talabat.configuration.discovery.NewAppVersion
            com.talabat.configuration.remote.model.AppInfoResultEntity r2 = r6.getResult()
            r3 = 0
            if (r2 == 0) goto L_0x001c
            com.talabat.configuration.remote.model.NewAppVersionEntity r2 = r2.getNewAppVersion()
            if (r2 == 0) goto L_0x001c
            java.lang.String r2 = r2.getGetMessage()
            goto L_0x001d
        L_0x001c:
            r2 = r3
        L_0x001d:
            com.talabat.configuration.remote.model.AppInfoResultEntity r4 = r6.getResult()
            if (r4 == 0) goto L_0x002d
            com.talabat.configuration.remote.model.NewAppVersionEntity r4 = r4.getNewAppVersion()
            if (r4 == 0) goto L_0x002d
            java.lang.String r3 = r4.getGetVersion()
        L_0x002d:
            com.talabat.configuration.remote.model.AppInfoResultEntity r6 = r6.getResult()
            if (r6 == 0) goto L_0x0044
            com.talabat.configuration.remote.model.NewAppVersionEntity r6 = r6.getNewAppVersion()
            if (r6 == 0) goto L_0x0044
            java.lang.Boolean r6 = r6.getShouldForceUpdate()
            if (r6 == 0) goto L_0x0044
            boolean r6 = r6.booleanValue()
            goto L_0x0045
        L_0x0044:
            r6 = 0
        L_0x0045:
            r1.<init>(r2, r3, r6)
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.configuration.discovery.mapper.DiscoveryConfigMapper.apply(com.talabat.configuration.remote.model.AppInfoEntity):com.talabat.configuration.discovery.DiscoveryConfig");
    }
}
