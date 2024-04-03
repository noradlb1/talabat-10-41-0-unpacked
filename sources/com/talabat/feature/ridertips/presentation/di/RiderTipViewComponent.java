package com.talabat.feature.ridertips.presentation.di;

import android.content.Context;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.feature.ridertips.domain.RiderTipFeatureApi;
import com.talabat.feature.ridertips.presentation.view.RiderTipView;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/ridertips/presentation/di/RiderTipViewComponent;", "", "inject", "", "target", "Lcom/talabat/feature/ridertips/presentation/view/RiderTipView;", "Factory", "com_talabat_feature_ridertips_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationLocalCoreLibApi.class, ConfigurationRemoteCoreLibApi.class, RiderTipFeatureApi.class}, modules = {RiderTipPresentationModule.class})
public interface RiderTipViewComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/feature/ridertips/presentation/di/RiderTipViewComponent$Factory;", "", "create", "Lcom/talabat/feature/ridertips/presentation/di/RiderTipViewComponent;", "context", "Landroid/content/Context;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "riderTipFeatureApi", "Lcom/talabat/feature/ridertips/domain/RiderTipFeatureApi;", "com_talabat_feature_ridertips_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        RiderTipViewComponent create(@NotNull @BindsInstance @Named("context") Context context, @NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, @NotNull RiderTipFeatureApi riderTipFeatureApi);
    }

    void inject(@NotNull RiderTipView riderTipView);
}
