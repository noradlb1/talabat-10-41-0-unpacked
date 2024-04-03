package com.talabat.userandlocation.login.ui.fragment.di;

import com.talabat.authentication.token.data.di.TokenCoreLibDataApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.userandlocation.login.ui.fragment.EnterEmailFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/login/ui/fragment/di/EnterEmailFragmentComponent;", "", "inject", "", "enterEmailFragment", "Lcom/talabat/userandlocation/login/ui/fragment/EnterEmailFragment;", "Factory", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ObservabilityCoreLibApi.class, TokenCoreLibDataApi.class})
public interface EnterEmailFragmentComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/userandlocation/login/ui/fragment/di/EnterEmailFragmentComponent$Factory;", "", "create", "Lcom/talabat/userandlocation/login/ui/fragment/di/EnterEmailFragmentComponent;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "tokenCoreLibDataApi", "Lcom/talabat/authentication/token/data/di/TokenCoreLibDataApi;", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        EnterEmailFragmentComponent create(@NotNull ObservabilityCoreLibApi observabilityCoreLibApi, @NotNull TokenCoreLibDataApi tokenCoreLibDataApi);
    }

    void inject(@NotNull EnterEmailFragment enterEmailFragment);
}
