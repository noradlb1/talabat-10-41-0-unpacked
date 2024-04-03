package com.talabat.growth.ui.lifecyclevoucher.factory;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.growth.ui.lifecyclevoucher.LoginLifecycleVoucherViewModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GuestWelcomeVoucherUseCase;
import d2.h;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/talabat/growth/ui/lifecyclevoucher/factory/LoginLifecycleVoucherViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "getConfigurationLocalCoreLibApi", "()Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "setConfigurationLocalCoreLibApi", "(Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoginLifecycleVoucherViewModelFactory implements ViewModelProvider.Factory {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Inject
    public ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/growth/ui/lifecyclevoucher/factory/LoginLifecycleVoucherViewModelFactory$Companion;", "", "()V", "newInstance", "Lcom/talabat/growth/ui/lifecyclevoucher/factory/LoginLifecycleVoucherViewModelFactory;", "context", "Landroid/content/Context;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LoginLifecycleVoucherViewModelFactory newInstance(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new LoginLifecycleVoucherViewModelFactory(context);
        }
    }

    public LoginLifecycleVoucherViewModelFactory(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            DaggerLoginLifecycleVoucherViewModelFactoryComponent.factory().create((ConfigurationLocalCoreLibApi) ((ApiContainer) applicationContext).getFeature(ConfigurationLocalCoreLibApi.class)).inject(this);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return new LoginLifecycleVoucherViewModel((CoroutineDispatcher) null, (GuestWelcomeVoucherUseCase) null, getConfigurationLocalCoreLibApi().getRepository(), 3, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }

    @NotNull
    public final ConfigurationLocalCoreLibApi getConfigurationLocalCoreLibApi() {
        ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2 = this.configurationLocalCoreLibApi;
        if (configurationLocalCoreLibApi2 != null) {
            return configurationLocalCoreLibApi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalCoreLibApi");
        return null;
    }

    public final void setConfigurationLocalCoreLibApi(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
        Intrinsics.checkNotNullParameter(configurationLocalCoreLibApi2, "<set-?>");
        this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
    }
}
