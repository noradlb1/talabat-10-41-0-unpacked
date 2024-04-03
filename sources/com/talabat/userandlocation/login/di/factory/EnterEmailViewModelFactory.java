package com.talabat.userandlocation.login.di.factory;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.gson.Gson;
import com.talabat.authentication.aaa.AaaApiBuilder;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.userandlocation.login.data.impl.EmailVerificationRepositoryImpl;
import com.talabat.userandlocation.login.data.remote.api.VerifyEmailApi;
import com.talabat.userandlocation.login.data.remote.impl.EmailVerificationRemoteDataSourceImpl;
import com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginEmailUseCase;
import com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginEmailUseCaseImpl;
import com.talabat.userandlocation.login.presentation.provider.EnterEmailStringProvider;
import com.talabat.userandlocation.login.presentation.provider.impl.EnterEmailStringProviderImpl;
import com.talabat.userandlocation.login.presentation.viewmodel.EnterEmailViewModel;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/userandlocation/login/di/factory/EnterEmailViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "enterEmailStringProvider", "Lcom/talabat/userandlocation/login/presentation/provider/EnterEmailStringProvider;", "verifyLoginEmailUseCase", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/userandlocation/login/presentation/provider/EnterEmailStringProvider;Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginEmailUseCase;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Companion", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EnterEmailViewModelFactory implements ViewModelProvider.Factory {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static EnterEmailViewModel mockedEnterEmailViewModel;
    @NotNull
    private final EnterEmailStringProvider enterEmailStringProvider;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final VerifyLoginEmailUseCase verifyLoginEmailUseCase;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/talabat/userandlocation/login/di/factory/EnterEmailViewModelFactory$Companion;", "", "()V", "mockedEnterEmailViewModel", "Lcom/talabat/userandlocation/login/presentation/viewmodel/EnterEmailViewModel;", "getMockedEnterEmailViewModel$annotations", "getMockedEnterEmailViewModel", "()Lcom/talabat/userandlocation/login/presentation/viewmodel/EnterEmailViewModel;", "setMockedEnterEmailViewModel", "(Lcom/talabat/userandlocation/login/presentation/viewmodel/EnterEmailViewModel;)V", "newInstance", "Lcom/talabat/userandlocation/login/di/factory/EnterEmailViewModelFactory;", "context", "Landroid/content/Context;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "tokenRepository", "Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getMockedEnterEmailViewModel$annotations() {
        }

        @Nullable
        public final EnterEmailViewModel getMockedEnterEmailViewModel() {
            return EnterEmailViewModelFactory.mockedEnterEmailViewModel;
        }

        @NotNull
        public final EnterEmailViewModelFactory newInstance(@NotNull Context context, @NotNull IObservabilityManager iObservabilityManager, @NotNull TokenRepository tokenRepository) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
            Intrinsics.checkNotNullParameter(tokenRepository, "tokenRepository");
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            return new EnterEmailViewModelFactory(new EnterEmailStringProviderImpl(resources), new VerifyLoginEmailUseCaseImpl(Dispatchers.getIO(), new EmailVerificationRepositoryImpl(new EmailVerificationRemoteDataSourceImpl((VerifyEmailApi) AaaApiBuilder.INSTANCE.createApi(VerifyEmailApi.class), new Gson(), iObservabilityManager)), tokenRepository), iObservabilityManager, (DefaultConstructorMarker) null);
        }

        public final void setMockedEnterEmailViewModel(@Nullable EnterEmailViewModel enterEmailViewModel) {
            EnterEmailViewModelFactory.mockedEnterEmailViewModel = enterEmailViewModel;
        }
    }

    private EnterEmailViewModelFactory(EnterEmailStringProvider enterEmailStringProvider2, VerifyLoginEmailUseCase verifyLoginEmailUseCase2, IObservabilityManager iObservabilityManager) {
        this.enterEmailStringProvider = enterEmailStringProvider2;
        this.verifyLoginEmailUseCase = verifyLoginEmailUseCase2;
        this.observabilityManager = iObservabilityManager;
    }

    public /* synthetic */ EnterEmailViewModelFactory(EnterEmailStringProvider enterEmailStringProvider2, VerifyLoginEmailUseCase verifyLoginEmailUseCase2, IObservabilityManager iObservabilityManager, DefaultConstructorMarker defaultConstructorMarker) {
        this(enterEmailStringProvider2, verifyLoginEmailUseCase2, iObservabilityManager);
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        T t11 = mockedEnterEmailViewModel;
        return t11 == null ? new EnterEmailViewModel(this.enterEmailStringProvider, this.verifyLoginEmailUseCase, this.observabilityManager) : t11;
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }
}
