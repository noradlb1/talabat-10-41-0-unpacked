package com.talabat.feature.bnpldashboard.presentation.di;

import androidx.fragment.app.Fragment;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.feature.bnpldashboard.presentation.BNPLDashboardFlutterFragment;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.walletaddcard.domain.WalletAddCardFeatureApi;
import com.talabat.feature.walletaddcard.presentation.channel.WalletMethodCallHandler;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/bnpldashboard/presentation/di/BNPLDashboardFlutterFragmentComponent;", "", "inject", "", "target", "Lcom/talabat/feature/bnpldashboard/presentation/BNPLDashboardFlutterFragment;", "Factory", "com_talabat_feature_bnpl-dashboard_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {WalletAddCardFeatureApi.class, DeepLinkCoreLibApi.class, HelpCenterFeatureApi.class})
public interface BNPLDashboardFlutterFragmentComponent {

    @Component.Factory
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/bnpldashboard/presentation/di/BNPLDashboardFlutterFragmentComponent$Factory;", "", "create", "Lcom/talabat/feature/bnpldashboard/presentation/di/BNPLDashboardFlutterFragmentComponent;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "fragment", "Landroidx/fragment/app/Fragment;", "walletAddCardMethodChannelCallback", "Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler$WalletAddCardMethodChannelCallback;", "walletAddCardFeatureApi", "Lcom/talabat/feature/walletaddcard/domain/WalletAddCardFeatureApi;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "helpCenterFeatureApi", "Lcom/talabat/feature/cancellationpolicy/domain/HelpCenterFeatureApi;", "com_talabat_feature_bnpl-dashboard_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        BNPLDashboardFlutterFragmentComponent create(@NotNull @BindsInstance CoroutineScope coroutineScope, @NotNull @BindsInstance Fragment fragment, @NotNull @BindsInstance WalletMethodCallHandler.WalletAddCardMethodChannelCallback walletAddCardMethodChannelCallback, @NotNull WalletAddCardFeatureApi walletAddCardFeatureApi, @NotNull DeepLinkCoreLibApi deepLinkCoreLibApi, @NotNull HelpCenterFeatureApi helpCenterFeatureApi);
    }

    void inject(@NotNull BNPLDashboardFlutterFragment bNPLDashboardFlutterFragment);
}
