package com.talabat.talabatremoteconfiguration.keys;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000fB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatremoteconfiguration/keys/SplashRemoteConfigurationKeys;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "value", "", "projectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;)V", "getProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getValue", "()Ljava/lang/String;", "SPLASH_VIEW_TYPE", "SPLASH_CONFIGURATION", "SPLASH_CAMPAIGN_LOGO", "Companion", "com_talabat_core_fwf-remote-configuration_fwf-remote-configuration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum SplashRemoteConfigurationKeys implements FWFKey {
    SPLASH_VIEW_TYPE("enable-splash_viewtype_android", (int) null, 2, (FWFProjectName) null),
    SPLASH_CONFIGURATION("splash_config", (int) null, 2, (FWFProjectName) null),
    SPLASH_CAMPAIGN_LOGO("splash_campaign_logo", (int) null, 2, (FWFProjectName) null);
    
    @NotNull
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<SplashRemoteConfigurationKeys[]> SPLASH_KEYS$delegate = null;
    @NotNull
    private final FWFProjectName projectName;
    @NotNull
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/talabat/talabatremoteconfiguration/keys/SplashRemoteConfigurationKeys$Companion;", "", "()V", "SPLASH_KEYS", "", "Lcom/talabat/talabatremoteconfiguration/keys/SplashRemoteConfigurationKeys;", "getSPLASH_KEYS", "()[Lcom/talabat/talabatremoteconfiguration/keys/SplashRemoteConfigurationKeys;", "SPLASH_KEYS$delegate", "Lkotlin/Lazy;", "com_talabat_core_fwf-remote-configuration_fwf-remote-configuration"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SplashRemoteConfigurationKeys[] getSPLASH_KEYS() {
            return (SplashRemoteConfigurationKeys[]) SplashRemoteConfigurationKeys.SPLASH_KEYS$delegate.getValue();
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
        SPLASH_KEYS$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, SplashRemoteConfigurationKeys$Companion$SPLASH_KEYS$2.INSTANCE);
    }

    private SplashRemoteConfigurationKeys(String str, FWFProjectName fWFProjectName) {
        this.value = str;
        this.projectName = fWFProjectName;
    }

    @NotNull
    public FWFProjectName getProjectName() {
        return this.projectName;
    }

    @NotNull
    public String getValue() {
        return this.value;
    }
}
