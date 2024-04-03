package com.talabat.feature.activecarts.presentation.di;

import android.app.Activity;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.feature.activecarts.domain.di.ActiveCartsApi;
import com.talabat.feature.activecarts.presentation.BasketListActivity;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/activecarts/presentation/di/BasketListPresentationComponent;", "", "inject", "", "activity", "Lcom/talabat/feature/activecarts/presentation/BasketListActivity;", "Factory", "com_talabat_feature_active-carts_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ActiveCartsApi.class, DarkstoresFeatureApi.class, NavigationCoreLibApi.class})
public interface BasketListPresentationComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/feature/activecarts/presentation/di/BasketListPresentationComponent$Factory;", "", "create", "Lcom/talabat/feature/activecarts/presentation/di/BasketListPresentationComponent;", "activeCartsApi", "Lcom/talabat/feature/activecarts/domain/di/ActiveCartsApi;", "darkstoresFeatureApi", "Lcom/talabat/feature/darkstores/domain/DarkstoresFeatureApi;", "navigationCoreLibApi", "Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "activity", "Landroid/app/Activity;", "com_talabat_feature_active-carts_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        BasketListPresentationComponent create(@NotNull ActiveCartsApi activeCartsApi, @NotNull DarkstoresFeatureApi darkstoresFeatureApi, @NotNull NavigationCoreLibApi navigationCoreLibApi, @NotNull @BindsInstance Activity activity);
    }

    void inject(@NotNull BasketListActivity basketListActivity);
}
