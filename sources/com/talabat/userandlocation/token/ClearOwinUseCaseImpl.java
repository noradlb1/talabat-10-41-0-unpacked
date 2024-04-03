package com.talabat.userandlocation.token;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.authentication.token.domain.repository.ClearOwinUseCase;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.common.EventType;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcore.logger.impl.TimberLogger;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/userandlocation/token/ClearOwinUseCaseImpl;", "Lcom/talabat/authentication/token/domain/repository/ClearOwinUseCase;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "observability", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "context", "Landroid/content/Context;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Landroid/content/Context;)V", "doClearOwin", "", "invoke", "", "forceClean", "shouldStopUseOwinToken", "Companion", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ClearOwinUseCaseImpl implements ClearOwinUseCase {
    @NotNull
    private static final String CLEAR_OWIN_FLAG_VALUE = "clear_owin_flag_value";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Context context;
    @NotNull
    private final ITalabatFeatureFlag featureFlag;
    @NotNull
    private final IObservabilityManager observability;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/userandlocation/token/ClearOwinUseCaseImpl$Companion;", "", "()V", "CLEAR_OWIN_FLAG_VALUE", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public ClearOwinUseCaseImpl(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull IObservabilityManager iObservabilityManager, @NotNull Context context2) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observability");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.featureFlag = iTalabatFeatureFlag;
        this.observability = iObservabilityManager;
        this.context = context2;
    }

    private final void doClearOwin() {
        GlobalDataModel.token = null;
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(LegacyTokenLocalDataSourceImpl.KEY, "");
        edit.apply();
        TimberLogger.INSTANCE.info("Owin token is cleared");
    }

    private final boolean shouldStopUseOwinToken() {
        boolean featureFlag2 = this.featureFlag.getFeatureFlag(UserFeatureFlagsKeys.FF_USER_STOP_USING_OWIN_TOKEN, false);
        this.observability.trackEvent(CLEAR_OWIN_FLAG_VALUE, EventType.AuthEvent.name(), (Map<String, String>) MapsKt__MapsJVMKt.mapOf(TuplesKt.to("enabled", String.valueOf(featureFlag2))));
        return featureFlag2;
    }

    public boolean invoke(boolean z11) {
        if (z11) {
            doClearOwin();
            return true;
        } else if (!shouldStopUseOwinToken()) {
            return false;
        } else {
            doClearOwin();
            return true;
        }
    }
}
