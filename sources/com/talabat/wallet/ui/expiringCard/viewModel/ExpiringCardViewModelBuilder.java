package com.talabat.wallet.ui.expiringCard.viewModel;

import android.app.Activity;
import android.app.Application;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.wallet.features.expiringCard.GetExpiringCardDetailUseCase;
import com.talabat.wallet.features.expiringCard.network.ExpiringCardService;
import com.talabat.wallet.features.expiringCard.repository.ExpiringCardRepositoryImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/wallet/ui/expiringCard/viewModel/ExpiringCardViewModelBuilder;", "", "()V", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExpiringCardViewModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/talabat/wallet/ui/expiringCard/viewModel/ExpiringCardViewModelBuilder$Companion;", "", "()V", "getExpiringCardViewModel", "Lcom/talabat/wallet/ui/expiringCard/viewModel/ExpiringCardViewModel;", "activity", "Landroid/app/Activity;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ExpiringCardViewModel getExpiringCardViewModel(@NotNull Activity activity, @NotNull CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Application application = activity.getApplication();
            if (application != null) {
                return new ExpiringCardViewModelImpl(new GetExpiringCardDetailUseCase(new ExpiringCardRepositoryImpl(new NetworkHandler(activity), new ExpiringCardService(new TalabatAPIBuilder())), coroutineScope, Dispatchers.getMain(), (Function1) null, ((ConfigurationLocalCoreLibApi) ((ApiContainer) application).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository(), 8, (DefaultConstructorMarker) null));
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
        }
    }
}
