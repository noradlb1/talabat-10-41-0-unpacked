package com.talabat.configuration.discovery;

import com.talabat.configuration.AppInfoContainer;
import com.talabat.configuration.discovery.mapper.DiscoveryConfigMapper;
import com.talabat.configuration.remote.model.AppInfoEntity;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/configuration/discovery/RealDiscoveryConfigurationRepository;", "Lcom/talabat/configuration/discovery/DiscoveryConfigurationRepository;", "appInfoContainer", "Lcom/talabat/configuration/AppInfoContainer;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "mapper", "Lcom/talabat/configuration/discovery/mapper/DiscoveryConfigMapper;", "(Lcom/talabat/configuration/AppInfoContainer;Lcom/talabat/configuration/discovery/AppVersionProvider;Lcom/talabat/configuration/discovery/mapper/DiscoveryConfigMapper;)V", "compareVersions", "", "currentVersion", "", "newVersion", "config", "Lcom/talabat/configuration/discovery/DiscoveryConfig;", "isNewAppVersionAvailable", "", "shouldForceUpdate", "Companion", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RealDiscoveryConfigurationRepository implements DiscoveryConfigurationRepository {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String VERSION_DELIMETER = ".";
    @NotNull
    private final AppInfoContainer appInfoContainer;
    @NotNull
    private final AppVersionProvider appVersionProvider;
    @NotNull
    private final DiscoveryConfigMapper mapper;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/configuration/discovery/RealDiscoveryConfigurationRepository$Companion;", "", "()V", "VERSION_DELIMETER", "", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public RealDiscoveryConfigurationRepository(@NotNull AppInfoContainer appInfoContainer2, @NotNull AppVersionProvider appVersionProvider2, @NotNull DiscoveryConfigMapper discoveryConfigMapper) {
        Intrinsics.checkNotNullParameter(appInfoContainer2, "appInfoContainer");
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        Intrinsics.checkNotNullParameter(discoveryConfigMapper, "mapper");
        this.appInfoContainer = appInfoContainer2;
        this.appVersionProvider = appVersionProvider2;
        this.mapper = discoveryConfigMapper;
    }

    private final int compareVersions(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (Object next : StringsKt__StringsKt.split$default((CharSequence) str, new String[]{VERSION_DELIMETER}, false, 0, 6, (Object) null)) {
            if (true ^ StringsKt__StringsJVMKt.isBlank((String) next)) {
                arrayList.add(next);
            }
        }
        String str3 = str2;
        ArrayList arrayList2 = new ArrayList();
        for (Object next2 : StringsKt__StringsKt.split$default((CharSequence) str3, new String[]{VERSION_DELIMETER}, false, 0, 6, (Object) null)) {
            if (!StringsKt__StringsJVMKt.isBlank((String) next2)) {
                arrayList2.add(next2);
            }
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < arrayList.size() && i12 < arrayList2.size()) {
            int i13 = (Long.parseLong((String) arrayList.get(i11)) > Long.parseLong((String) arrayList2.get(i12)) ? 1 : (Long.parseLong((String) arrayList.get(i11)) == Long.parseLong((String) arrayList2.get(i12)) ? 0 : -1));
            if (i13 > 0) {
                return 1;
            }
            if (i13 < 0) {
                return -1;
            }
            i11++;
            i12++;
        }
        while (i11 < arrayList.size()) {
            if (Long.parseLong((String) arrayList.get(i11)) > 0) {
                return 1;
            }
            i11++;
        }
        while (i12 < arrayList2.size()) {
            if (Long.parseLong((String) arrayList2.get(i12)) > 0) {
                return -1;
            }
            i12++;
        }
        return 0;
    }

    @NotNull
    public DiscoveryConfig config() {
        DiscoveryConfig apply;
        AppInfoEntity cachedAppInfoEntity = this.appInfoContainer.getCachedAppInfoEntity();
        if (cachedAppInfoEntity == null || (apply = this.mapper.apply(cachedAppInfoEntity)) == null) {
            return DiscoveryConfig.Companion.getDEFAULT();
        }
        return apply;
    }

    public boolean isNewAppVersionAvailable() {
        String version;
        DiscoveryConfig config = config();
        String appVersion = this.appVersionProvider.appVersion();
        if (appVersion != null) {
            NewAppVersion newAppVersion = config.getNewAppVersion();
            if (!(newAppVersion == null || (version = newAppVersion.getVersion()) == null || compareVersions(appVersion, version) >= 0)) {
                return true;
            }
        } else if (!Intrinsics.areEqual((Object) config, (Object) DiscoveryConfig.Companion.getDEFAULT())) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (r0.getShouldForceUpdate() == true) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldForceUpdate() {
        /*
            r3 = this;
            com.talabat.configuration.discovery.DiscoveryConfig r0 = r3.config()
            com.talabat.configuration.discovery.NewAppVersion r0 = r0.getNewAppVersion()
            r1 = 0
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.getShouldForceUpdate()
            r2 = 1
            if (r0 != r2) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r2 = r1
        L_0x0014:
            if (r2 == 0) goto L_0x001a
            boolean r1 = r3.isNewAppVersionAvailable()
        L_0x001a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository.shouldForceUpdate():boolean");
    }
}
