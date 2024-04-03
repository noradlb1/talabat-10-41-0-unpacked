package com.talabat.feature.pickup.data.di;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.feature.pickup.data.PickupRepositoryImpl;
import com.talabat.feature.pickup.data.PickupSharedPreferences;
import com.talabat.feature.pickup.domain.PickupRepository;
import com.talabat.talabatcommon.feature.vendorTags.data.VendorTagsRepository;
import com.talabat.talabatcommon.feature.vendorTags.domain.RequestVendorTagsUseCase;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/talabat/feature/pickup/data/di/PickupFeatureModule;", "", "()V", "provideRepository", "Lcom/talabat/feature/pickup/domain/PickupRepository;", "impl", "Lcom/talabat/feature/pickup/data/PickupRepositoryImpl;", "provideSharedPrefs", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "provideVendorTagsUseCase", "Lcom/talabat/talabatcommon/feature/vendorTags/domain/RequestVendorTagsUseCase;", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {PickupNetworkModule.class})
public final class PickupFeatureModule {
    @NotNull
    public static final PickupFeatureModule INSTANCE = new PickupFeatureModule();

    private PickupFeatureModule() {
    }

    @NotNull
    @Provides
    public final PickupRepository provideRepository(@NotNull PickupRepositoryImpl pickupRepositoryImpl) {
        Intrinsics.checkNotNullParameter(pickupRepositoryImpl, "impl");
        return pickupRepositoryImpl;
    }

    @NotNull
    @Provides
    public final SharedPreferences provideSharedPrefs(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(PickupSharedPreferences.PREFS_KEY, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        return sharedPreferences;
    }

    @NotNull
    @Provides
    public final RequestVendorTagsUseCase provideVendorTagsUseCase() {
        return new RequestVendorTagsUseCase((VendorTagsRepository) null, 1, (DefaultConstructorMarker) null);
    }
}
