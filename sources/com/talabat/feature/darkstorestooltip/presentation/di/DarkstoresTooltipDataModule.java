package com.talabat.feature.darkstorestooltip.presentation.di;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.feature.darkstorestooltip.DarkstoresTooltipRepositoryImpl;
import com.talabat.feature.darkstorestooltip.domain.di.DarkstoresTooltipRepository;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/darkstorestooltip/presentation/di/DarkstoresTooltipDataModule;", "", "()V", "provideRepository", "Lcom/talabat/feature/darkstorestooltip/domain/di/DarkstoresTooltipRepository;", "impl", "Lcom/talabat/feature/darkstorestooltip/DarkstoresTooltipRepositoryImpl;", "provideSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "com_talabat_feature_darkstores-tooltip_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class DarkstoresTooltipDataModule {
    @NotNull
    public static final DarkstoresTooltipDataModule INSTANCE = new DarkstoresTooltipDataModule();

    private DarkstoresTooltipDataModule() {
    }

    @NotNull
    @Provides
    public final DarkstoresTooltipRepository provideRepository(@NotNull DarkstoresTooltipRepositoryImpl darkstoresTooltipRepositoryImpl) {
        Intrinsics.checkNotNullParameter(darkstoresTooltipRepositoryImpl, "impl");
        return darkstoresTooltipRepositoryImpl;
    }

    @NotNull
    @Provides
    public final SharedPreferences provideSharedPreferences(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("darkstores_tooltips", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        return sharedPreferences;
    }
}
