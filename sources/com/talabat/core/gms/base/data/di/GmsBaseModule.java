package com.talabat.core.gms.base.data.di;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.gms.base.domain.IsGmsAvailable;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/gms/base/data/di/GmsBaseModule;", "", "()V", "isGmsAvailable", "", "context", "Landroid/content/Context;", "com_talabat_core_gms_base_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class GmsBaseModule {
    @NotNull
    public static final GmsBaseModule INSTANCE = new GmsBaseModule();

    private GmsBaseModule() {
    }

    @IsGmsAvailable
    @Provides
    public final boolean isGmsAvailable(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
            return true;
        }
        return false;
    }
}
