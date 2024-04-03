package com.talabat.helpcenter.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.network.endpoint.HelpCenterChatEndPointProvider;
import com.talabat.core.network.endpoint.PoeEndPointProvider;
import com.talabat.core.network.network.OKHttpBuilder;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.helpcenter.data.datasources.remote.impl.ChatMessageApi;
import com.talabat.helpcenter.data.datasources.remote.impl.PoeRetrofitService;
import com.talabat.helpcenter.data.util.JwtTokenExtractorImpl;
import com.talabat.helpcenter.domain.repository.HelpCenterRepository;
import com.talabat.helpcenter.domain.repository.UnreadChatMessagesRepository;
import com.talabat.helpcenter.domain.usecases.GetUnreadMessagesUseCase;
import com.talabat.helpcenter.domain.usecases.UnreadMessagesLiveData;
import com.talabat.helpcenter.domain.usecases.UpdateActivationUseCase;
import com.talabat.helpcenter.presentation.viewModel.GlobalHelpCenterViewModel;
import com.talabat.helpcenter.presentation.webInterface.WebMessageBuilder;
import com.talabat.talabatcore.permissions.impl.TalabatPermissions;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.deeplink.IDeepLinkPresenter;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010$\u001a\u00020%H\u0007J\b\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u0004\u0018\u00010!J\u0006\u0010-\u001a\u00020\u000fJ\b\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020!H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/talabat/helpcenter/di/HelpCenterFactory;", "", "()V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "configurationLocalRepository$delegate", "Lkotlin/Lazy;", "helpCenterRepository", "Lcom/talabat/helpcenter/domain/repository/HelpCenterRepository;", "getHelpCenterRepository", "()Lcom/talabat/helpcenter/domain/repository/HelpCenterRepository;", "helpCenterRepository$delegate", "mockedGlobalHelpCenterViewModel", "Lcom/talabat/helpcenter/presentation/viewModel/GlobalHelpCenterViewModel;", "getMockedGlobalHelpCenterViewModel", "()Lcom/talabat/helpcenter/presentation/viewModel/GlobalHelpCenterViewModel;", "setMockedGlobalHelpCenterViewModel", "(Lcom/talabat/helpcenter/presentation/viewModel/GlobalHelpCenterViewModel;)V", "mockedPermissions", "Lcom/talabat/talabatcore/permissions/impl/TalabatPermissions;", "getMockedPermissions", "()Lcom/talabat/talabatcore/permissions/impl/TalabatPermissions;", "setMockedPermissions", "(Lcom/talabat/talabatcore/permissions/impl/TalabatPermissions;)V", "unreadChatMessagesRepository", "Lcom/talabat/helpcenter/domain/repository/UnreadChatMessagesRepository;", "getUnreadChatMessagesRepository", "()Lcom/talabat/helpcenter/domain/repository/UnreadChatMessagesRepository;", "unreadChatMessagesRepository$delegate", "weakDeepLinkPresenter", "Ljava/lang/ref/WeakReference;", "Ltracking/deeplink/IDeepLinkPresenter;", "createGetUnreadMessagesUseCase", "Lcom/talabat/helpcenter/domain/usecases/GetUnreadMessagesUseCase;", "appVersion", "", "createUnreadMessagesLiveData", "Lcom/talabat/helpcenter/domain/usecases/UnreadMessagesLiveData;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getChatMessageApi", "Lcom/talabat/helpcenter/data/datasources/remote/impl/ChatMessageApi;", "getDeepLinkPresenter", "getGlobalHelpCenterViewModel", "getPoeRetrofitService", "Lcom/talabat/helpcenter/data/datasources/remote/impl/PoeRetrofitService;", "setDeepLinkPresenter", "", "deepLinkPresenter", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HelpCenterFactory {
    @NotNull
    public static final HelpCenterFactory INSTANCE = new HelpCenterFactory();
    @NotNull
    private static final Lazy configurationLocalRepository$delegate;
    @NotNull
    private static final Lazy helpCenterRepository$delegate;
    @Nullable
    private static GlobalHelpCenterViewModel mockedGlobalHelpCenterViewModel;
    @Nullable
    private static TalabatPermissions mockedPermissions;
    @NotNull
    private static final Lazy unreadChatMessagesRepository$delegate;
    @Nullable
    private static WeakReference<IDeepLinkPresenter> weakDeepLinkPresenter;

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        configurationLocalRepository$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, HelpCenterFactory$configurationLocalRepository$2.INSTANCE);
        unreadChatMessagesRepository$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, HelpCenterFactory$unreadChatMessagesRepository$2.INSTANCE);
        helpCenterRepository$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, HelpCenterFactory$helpCenterRepository$2.INSTANCE);
    }

    private HelpCenterFactory() {
    }

    private final GetUnreadMessagesUseCase createGetUnreadMessagesUseCase(String str) {
        return new GetUnreadMessagesUseCase(getUnreadChatMessagesRepository(), getHelpCenterRepository(), new JwtTokenExtractorImpl(), getConfigurationLocalRepository().selectedLanguage().getIsoCode(), getConfigurationLocalRepository().selectedCountry().getCountryId(), str, "Android", (CoroutineDispatcher) null, 128, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    @NotNull
    public static final UnreadMessagesLiveData createUnreadMessagesLiveData(@NotNull CoroutineScope coroutineScope, @NotNull String str) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(str, "appVersion");
        return new UnreadMessagesLiveData(coroutineScope, INSTANCE.createGetUnreadMessagesUseCase(str), TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_UNREAD_MESSAGE_COUNTER, false, TalabatExperimentDataSourceStrategy.FWF));
    }

    /* access modifiers changed from: private */
    public final ChatMessageApi getChatMessageApi() {
        return (ChatMessageApi) new TalabatAPIBuilder().createApi(HelpCenterChatEndPointProvider.INSTANCE.getBaseUrl(), ChatMessageApi.class, OKHttpBuilder.getBaseHttpClient$default(OKHttpBuilder.INSTANCE, (List) null, 0, 3, (Object) null));
    }

    /* access modifiers changed from: private */
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        return (ConfigurationLocalRepository) configurationLocalRepository$delegate.getValue();
    }

    private final HelpCenterRepository getHelpCenterRepository() {
        return (HelpCenterRepository) helpCenterRepository$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PoeRetrofitService getPoeRetrofitService() {
        return (PoeRetrofitService) new TalabatAPIBuilder().createApi(PoeEndPointProvider.INSTANCE.getBaseUrl(), PoeRetrofitService.class);
    }

    private final UnreadChatMessagesRepository getUnreadChatMessagesRepository() {
        return (UnreadChatMessagesRepository) unreadChatMessagesRepository$delegate.getValue();
    }

    @JvmStatic
    public static final void setDeepLinkPresenter(@NotNull IDeepLinkPresenter iDeepLinkPresenter) {
        Intrinsics.checkNotNullParameter(iDeepLinkPresenter, "deepLinkPresenter");
        weakDeepLinkPresenter = new WeakReference<>(iDeepLinkPresenter);
    }

    @Nullable
    public final IDeepLinkPresenter getDeepLinkPresenter() {
        WeakReference<IDeepLinkPresenter> weakReference = weakDeepLinkPresenter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @NotNull
    public final GlobalHelpCenterViewModel getGlobalHelpCenterViewModel() {
        GlobalHelpCenterViewModel globalHelpCenterViewModel = mockedGlobalHelpCenterViewModel;
        if (globalHelpCenterViewModel == null) {
            HelpCenterRepository helpCenterRepository = getHelpCenterRepository();
            UpdateActivationUseCase updateActivationUseCase = new UpdateActivationUseCase(getUnreadChatMessagesRepository());
            WebMessageBuilder webMessageBuilder = new WebMessageBuilder();
            TalabatPermissions talabatPermissions = mockedPermissions;
            if (talabatPermissions == null) {
                talabatPermissions = new TalabatPermissions();
            }
            globalHelpCenterViewModel = new GlobalHelpCenterViewModel(helpCenterRepository, updateActivationUseCase, webMessageBuilder, talabatPermissions, getConfigurationLocalRepository().selectedCountry().getCountryId(), getConfigurationLocalRepository().selectedLanguage().getIsoCode(), "Android");
        }
        return globalHelpCenterViewModel;
    }

    @Nullable
    public final GlobalHelpCenterViewModel getMockedGlobalHelpCenterViewModel() {
        return mockedGlobalHelpCenterViewModel;
    }

    @Nullable
    public final TalabatPermissions getMockedPermissions() {
        return mockedPermissions;
    }

    public final void setMockedGlobalHelpCenterViewModel(@Nullable GlobalHelpCenterViewModel globalHelpCenterViewModel) {
        mockedGlobalHelpCenterViewModel = globalHelpCenterViewModel;
    }

    public final void setMockedPermissions(@Nullable TalabatPermissions talabatPermissions) {
        mockedPermissions = talabatPermissions;
    }
}
