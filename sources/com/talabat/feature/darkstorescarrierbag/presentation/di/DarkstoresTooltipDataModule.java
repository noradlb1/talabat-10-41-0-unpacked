package com.talabat.feature.darkstorescarrierbag.presentation.di;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.feature.darkstorescarrierbag.data.DarkstoresCarrierBagRepositoryImpl;
import com.talabat.feature.darkstorescarrierbag.domain.repository.DarkstoresCarrierBagRepository;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/presentation/di/DarkstoresTooltipDataModule;", "", "()V", "provideRepository", "Lcom/talabat/feature/darkstorescarrierbag/domain/repository/DarkstoresCarrierBagRepository;", "impl", "Lcom/talabat/feature/darkstorescarrierbag/data/DarkstoresCarrierBagRepositoryImpl;", "provideSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "com_talabat_feature_darkstores-carrier-bag_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class DarkstoresTooltipDataModule {
    @NotNull
    public static final DarkstoresTooltipDataModule INSTANCE = new DarkstoresTooltipDataModule();

    private DarkstoresTooltipDataModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final DarkstoresCarrierBagRepository provideRepository(@NotNull DarkstoresCarrierBagRepositoryImpl darkstoresCarrierBagRepositoryImpl) {
        Intrinsics.checkNotNullParameter(darkstoresCarrierBagRepositoryImpl, "impl");
        return darkstoresCarrierBagRepositoryImpl;
    }

    @NotNull
    @Provides
    public final SharedPreferences provideSharedPreferences(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("darkstores_carrier_bags", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        return sharedPreferences;
    }
}
