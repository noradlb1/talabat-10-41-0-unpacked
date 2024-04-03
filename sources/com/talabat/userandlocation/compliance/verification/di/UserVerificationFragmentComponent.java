package com.talabat.userandlocation.compliance.verification.di;

import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/di/UserVerificationFragmentComponent;", "", "inject", "", "target", "Lcom/talabat/userandlocation/compliance/verification/ui/fragment/UserVerificationFragment;", "Factory", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationRemoteCoreLibApi.class})
public interface UserVerificationFragmentComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/di/UserVerificationFragmentComponent$Factory;", "", "create", "Lcom/talabat/userandlocation/compliance/verification/di/UserVerificationFragmentComponent;", "configurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationRemoteCoreLibApi;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        UserVerificationFragmentComponent create(@NotNull ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi);
    }

    void inject(@NotNull UserVerificationFragment userVerificationFragment);
}
