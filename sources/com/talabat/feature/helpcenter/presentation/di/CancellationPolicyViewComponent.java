package com.talabat.feature.helpcenter.presentation.di;

import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.helpcenter.presentation.CancellationPolicyView;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/helpcenter/presentation/di/CancellationPolicyViewComponent;", "", "inject", "", "cancellationPolicyView", "Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyView;", "Factory", "com_talabat_feature_helpcenter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {HelpCenterFeatureApi.class}, modules = {CancellationPolicyViewModule.class})
public interface CancellationPolicyViewComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/helpcenter/presentation/di/CancellationPolicyViewComponent$Factory;", "", "create", "Lcom/talabat/feature/helpcenter/presentation/di/CancellationPolicyViewComponent;", "helpCenterFeatureApi", "Lcom/talabat/feature/cancellationpolicy/domain/HelpCenterFeatureApi;", "com_talabat_feature_helpcenter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        CancellationPolicyViewComponent create(@NotNull HelpCenterFeatureApi helpCenterFeatureApi);
    }

    void inject(@NotNull CancellationPolicyView cancellationPolicyView);
}
