package com.talabat.feature.fees.data.di;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/fees/data/di/FeesLocalModule;", "", "()V", "provideSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "com_talabat_feature_pricing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class FeesLocalModule {
    @NotNull
    public static final FeesLocalModule INSTANCE = new FeesLocalModule();

    private FeesLocalModule() {
    }

    @NotNull
    @Provides
    @Named("disclaimer_prefs")
    public final SharedPreferences provideSharedPreferences(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("darkstores_preferences", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        return sharedPreferences;
    }
}
