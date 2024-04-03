package com.talabat.feature.nfvinvendorsearch.presentation.di;

import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstoresflutter.domain.DarkstoresFlutterCartApi;
import com.talabat.feature.darkstoresvendor.domain.DarkstoresVendorApi;
import com.talabat.feature.nfvinvendorsearch.domain.di.QCommerceFlutterFeatureApi;
import com.talabat.feature.nfvinvendorsearch.presentation.activity.QCommerceFlutterActivity;
import com.talabat.feature.nfvinvendorsearch.presentation.fragment.QCommerceFlutterFragment;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/di/QCommerceFlutterPresentationComponent;", "", "inject", "", "activity", "Lcom/talabat/feature/nfvinvendorsearch/presentation/activity/QCommerceFlutterActivity;", "fragment", "Lcom/talabat/feature/nfvinvendorsearch/presentation/fragment/QCommerceFlutterFragment;", "Factory", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {DarkstoresFeatureApi.class, DarkstoresVendorApi.class, QCommerceFlutterFeatureApi.class, DarkstoresFlutterCartApi.class})
public interface QCommerceFlutterPresentationComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/di/QCommerceFlutterPresentationComponent$Factory;", "", "create", "Lcom/talabat/feature/nfvinvendorsearch/presentation/di/QCommerceFlutterPresentationComponent;", "darkstoresFeatureApi", "Lcom/talabat/feature/darkstores/domain/DarkstoresFeatureApi;", "darkstoresVendorApi", "Lcom/talabat/feature/darkstoresvendor/domain/DarkstoresVendorApi;", "qCommerceFlutterFeatureApi", "Lcom/talabat/feature/nfvinvendorsearch/domain/di/QCommerceFlutterFeatureApi;", "darkstoresFlutterCartApi", "Lcom/talabat/feature/darkstoresflutter/domain/DarkstoresFlutterCartApi;", "configurationParams", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        QCommerceFlutterPresentationComponent create(@NotNull DarkstoresFeatureApi darkstoresFeatureApi, @NotNull DarkstoresVendorApi darkstoresVendorApi, @NotNull QCommerceFlutterFeatureApi qCommerceFlutterFeatureApi, @NotNull DarkstoresFlutterCartApi darkstoresFlutterCartApi, @NotNull @BindsInstance FlutterConfigurationParams flutterConfigurationParams);
    }

    void inject(@NotNull QCommerceFlutterActivity qCommerceFlutterActivity);

    void inject(@NotNull QCommerceFlutterFragment qCommerceFlutterFragment);
}
