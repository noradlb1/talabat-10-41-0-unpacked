package com.talabat.core.flutter.channels.impl.data.featureflags;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.flutter.channels.domain.featureflags.FeatureFlagChannelCallback;
import com.talabat.core.fwfprojectskeys.domain.FWFKeyObject;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.fluttercore.mappers.FWFProjectNameMapper;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ)\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000fJ0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/featureflags/FeatureFlagChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/featureflags/FeatureFlagChannelCallback;", "talabatObservability", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "featureFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "remoteConfig", "Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;)V", "getFeatureFlag", "", "featureName", "", "projectName", "defaultValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Z", "getRemoteConfig", "", "remoteConfigName", "", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeatureFlagChannelCallbackImpl implements FeatureFlagChannelCallback {
    @NotNull
    private final ITalabatFeatureFlag featureFlags;
    @NotNull
    private final RemoteConfiguration remoteConfig;
    @NotNull
    private final IObservabilityManager talabatObservability;

    @Inject
    public FeatureFlagChannelCallbackImpl(@NotNull IObservabilityManager iObservabilityManager, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull RemoteConfiguration remoteConfiguration) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "talabatObservability");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlags");
        Intrinsics.checkNotNullParameter(remoteConfiguration, "remoteConfig");
        this.talabatObservability = iObservabilityManager;
        this.featureFlags = iTalabatFeatureFlag;
        this.remoteConfig = remoteConfiguration;
    }

    public boolean getFeatureFlag(@NotNull String str, @Nullable String str2, @Nullable Boolean bool) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "featureName");
        if (bool != null) {
            z11 = bool.booleanValue();
        } else {
            z11 = false;
        }
        FWFProjectNameMapper fWFProjectNameMapper = FWFProjectNameMapper.INSTANCE;
        if (str2 == null) {
            str2 = FWFProjectName.DEFAULT.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        return this.featureFlags.getFeatureFlag(new FWFKeyObject(str, fWFProjectNameMapper.getFwfProjectFromProjectName(str2)), z11);
    }

    @NotNull
    public Object getRemoteConfig(@NotNull String str, @Nullable String str2, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "remoteConfigName");
        if (map == null) {
            map = new HashMap<>();
        }
        FWFProjectNameMapper fWFProjectNameMapper = FWFProjectNameMapper.INSTANCE;
        if (str2 == null) {
            str2 = FWFProjectName.DEFAULT.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        try {
            return this.remoteConfig.getRemoteConfiguration(new FWFKeyObject(str, fWFProjectNameMapper.getFwfProjectFromProjectName(str2)), map, Object.class);
        } catch (Exception e11) {
            IObservabilityManager iObservabilityManager = this.talabatObservability;
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.to("method", "getRemoteConfig");
            pairArr[1] = TuplesKt.to("message", String.valueOf(e11.getMessage()));
            String localizedMessage = e11.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "N/A";
            }
            pairArr[2] = TuplesKt.to("localizedMessage", localizedMessage);
            iObservabilityManager.trackUnExpectedScenario("FeatureFlagMethodChannel", MapsKt__MapsKt.mapOf(pairArr));
            return map;
        }
    }
}
