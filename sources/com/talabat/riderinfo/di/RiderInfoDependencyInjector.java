package com.talabat.riderinfo.di;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.talabat.chat.api.ChatApi;
import com.talabat.chat.di.ChatFactory;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.LegacyConfigurationLocalRepository;
import com.talabat.core.network.endpoint.PoeEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.riderinfo.data.datasource.remote.PoeRetrofitService;
import com.talabat.riderinfo.data.datasource.repository.RiderInfoRepositoryImpl;
import com.talabat.riderinfo.domain.repository.RiderInfoRepository;
import com.talabat.riderinfo.domain.usecase.GetRiderInfo;
import com.talabat.riderinfo.domain.usecase.StartRiderChat;
import com.talabat.riderinfo.presentation.activity.RiderChatDeepLinkActivity;
import com.talabat.riderinfo.presentation.viewmodel.RiderChatDeepLinkViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/talabat/riderinfo/di/RiderInfoDependencyInjector;", "", "()V", "mockChatApi", "Lcom/talabat/chat/api/ChatApi;", "getMockChatApi", "()Lcom/talabat/chat/api/ChatApi;", "setMockChatApi", "(Lcom/talabat/chat/api/ChatApi;)V", "mockConfigurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getMockConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setMockConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "mockPoeRetrofitService", "Lcom/talabat/riderinfo/data/datasource/remote/PoeRetrofitService;", "getMockPoeRetrofitService", "()Lcom/talabat/riderinfo/data/datasource/remote/PoeRetrofitService;", "setMockPoeRetrofitService", "(Lcom/talabat/riderinfo/data/datasource/remote/PoeRetrofitService;)V", "initConfigurationRepository", "initPoeRetrofitService", "initRiderChatDeepLinkViewModel", "Lcom/talabat/riderinfo/presentation/viewmodel/RiderChatDeepLinkViewModel;", "riderChatDeepLinkActivity", "Lcom/talabat/riderinfo/presentation/activity/RiderChatDeepLinkActivity;", "initRiderInfoRepository", "Lcom/talabat/riderinfo/domain/repository/RiderInfoRepository;", "initRiderInfoUseCase", "Lcom/talabat/riderinfo/domain/usecase/GetRiderInfo;", "initStartRiderChatUseCase", "Lcom/talabat/riderinfo/domain/usecase/StartRiderChat;", "com_talabat_NewArchi_RiderInfo_RiderInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderInfoDependencyInjector {
    @NotNull
    public static final RiderInfoDependencyInjector INSTANCE = new RiderInfoDependencyInjector();
    @Nullable
    private static ChatApi mockChatApi;
    @Nullable
    private static ConfigurationLocalRepository mockConfigurationLocalRepository;
    @Nullable
    private static PoeRetrofitService mockPoeRetrofitService;

    private RiderInfoDependencyInjector() {
    }

    private final ConfigurationLocalRepository initConfigurationRepository() {
        ConfigurationLocalRepository configurationLocalRepository = mockConfigurationLocalRepository;
        if (configurationLocalRepository == null) {
            return new LegacyConfigurationLocalRepository();
        }
        Intrinsics.checkNotNull(configurationLocalRepository);
        return configurationLocalRepository;
    }

    private final PoeRetrofitService initPoeRetrofitService() {
        return (PoeRetrofitService) new TalabatAPIBuilder().createApi(PoeEndPointProvider.INSTANCE.getBaseUrl(), PoeRetrofitService.class);
    }

    private final RiderInfoRepository initRiderInfoRepository() {
        PoeRetrofitService poeRetrofitService = mockPoeRetrofitService;
        if (poeRetrofitService == null) {
            return new RiderInfoRepositoryImpl(initPoeRetrofitService());
        }
        Intrinsics.checkNotNull(poeRetrofitService);
        return new RiderInfoRepositoryImpl(poeRetrofitService);
    }

    /* access modifiers changed from: private */
    public final GetRiderInfo initRiderInfoUseCase() {
        return new GetRiderInfo(initRiderInfoRepository());
    }

    /* access modifiers changed from: private */
    public final StartRiderChat initStartRiderChatUseCase() {
        if (mockChatApi == null) {
            return new StartRiderChat(initConfigurationRepository(), ChatFactory.Companion.getInstance$default(ChatFactory.Companion, (ChatApi) null, 1, (Object) null).initializeChatProvider());
        }
        ConfigurationLocalRepository initConfigurationRepository = initConfigurationRepository();
        ChatFactory.Companion companion = ChatFactory.Companion;
        ChatApi chatApi = mockChatApi;
        Intrinsics.checkNotNull(chatApi);
        return new StartRiderChat(initConfigurationRepository, companion.getInstance(chatApi).initializeChatProvider());
    }

    @Nullable
    public final ChatApi getMockChatApi() {
        return mockChatApi;
    }

    @Nullable
    public final ConfigurationLocalRepository getMockConfigurationLocalRepository() {
        return mockConfigurationLocalRepository;
    }

    @Nullable
    public final PoeRetrofitService getMockPoeRetrofitService() {
        return mockPoeRetrofitService;
    }

    @NotNull
    public final RiderChatDeepLinkViewModel initRiderChatDeepLinkViewModel(@NotNull RiderChatDeepLinkActivity riderChatDeepLinkActivity) {
        Intrinsics.checkNotNullParameter(riderChatDeepLinkActivity, "riderChatDeepLinkActivity");
        return (RiderChatDeepLinkViewModel) new ViewModelProvider((ViewModelStoreOwner) riderChatDeepLinkActivity, (ViewModelProvider.Factory) new RiderInfoDependencyInjector$initRiderChatDeepLinkViewModel$1()).get(RiderChatDeepLinkViewModel.class);
    }

    public final void setMockChatApi(@Nullable ChatApi chatApi) {
        mockChatApi = chatApi;
    }

    public final void setMockConfigurationLocalRepository(@Nullable ConfigurationLocalRepository configurationLocalRepository) {
        mockConfigurationLocalRepository = configurationLocalRepository;
    }

    public final void setMockPoeRetrofitService(@Nullable PoeRetrofitService poeRetrofitService) {
        mockPoeRetrofitService = poeRetrofitService;
    }
}
