package com.talabat.core.safety.data.di;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.talabat.core.context.domain.ApplicationContext;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\u0012\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\f"}, d2 = {"Lcom/talabat/core/safety/data/di/IdentifiersModule;", "", "()V", "androidId", "", "context", "Landroid/content/Context;", "debugValue", "", "deviceModel", "installationPath", "packageName", "com_talabat_core_safety_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class IdentifiersModule {
    @NotNull
    public static final IdentifiersModule INSTANCE = new IdentifiersModule();

    private IdentifiersModule() {
    }

    @NotNull
    @AndroidId
    @Provides
    public final String androidId(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (string == null) {
            return "";
        }
        return string;
    }

    @DebugValue
    @Provides
    public final boolean debugValue() {
        return false;
    }

    @NotNull
    @DeviceName
    @Provides
    public final String deviceModel() {
        String str = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str, "MODEL");
        return str;
    }

    @NotNull
    @InstallationPath
    @Provides
    public final String installationPath(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = context.getApplicationInfo().dataDir;
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    @PackageName
    @Provides
    public final String packageName(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String packageName = context.getPackageName();
        if (packageName == null) {
            return "";
        }
        return packageName;
    }
}
