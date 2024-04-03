package com.talabat.configuration.discovery;

import android.content.Context;
import android.content.res.Resources;
import com.talabat.core.configuration.remote.data.R;
import com.talabat.core.context.domain.ApplicationContext;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/configuration/discovery/RealAppVersionProvider;", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appVersion", "", "compareVersionTo", "", "other", "(Ljava/lang/String;)Ljava/lang/Long;", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RealAppVersionProvider implements AppVersionProvider {
    @NotNull
    private final Context context;

    @Inject
    public RealAppVersionProvider(@NotNull @ApplicationContext Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @Nullable
    public String appVersion() {
        try {
            return this.context.getResources().getString(R.string.app_version);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    @Nullable
    public Long compareVersionTo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "other");
        String appVersion = appVersion();
        if (appVersion == null) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(StringsKt__StringsKt.trim((CharSequence) StringsKt__StringsJVMKt.replace$default(appVersion, RealDiscoveryConfigurationRepository.VERSION_DELIMETER, "", false, 4, (Object) null)).toString()) - Long.parseLong(StringsKt__StringsKt.trim((CharSequence) StringsKt__StringsJVMKt.replace$default(str, RealDiscoveryConfigurationRepository.VERSION_DELIMETER, "", false, 4, (Object) null)).toString()));
        } catch (NumberFormatException e11) {
            Timber.e(e11, "Failed to parse versions: current=" + appVersion + " :: other=" + str, new Object[0]);
            return null;
        }
    }
}
