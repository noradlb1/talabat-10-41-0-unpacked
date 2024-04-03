package com.talabat.feature.pharmacy.di;

import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.feature.pharmacy.presentation.ui.fragment.PrescriptionFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/pharmacy/di/PrescriptionFragmentComponent;", "", "inject", "", "target", "Lcom/talabat/feature/pharmacy/presentation/ui/fragment/PrescriptionFragment;", "Factory", "com_talabat_feature_pharmacy_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {NetworkCoreLibApi.class, DispatcherCoreLibApi.class})
public interface PrescriptionFragmentComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/feature/pharmacy/di/PrescriptionFragmentComponent$Factory;", "", "create", "Lcom/talabat/feature/pharmacy/di/PrescriptionFragmentComponent;", "networkCoreLibApi", "Lcom/talabat/core/network/domain/NetworkCoreLibApi;", "dispatchersCoreLib", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "com_talabat_feature_pharmacy_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        PrescriptionFragmentComponent create(@NotNull NetworkCoreLibApi networkCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi);
    }

    void inject(@NotNull PrescriptionFragment prescriptionFragment);
}
