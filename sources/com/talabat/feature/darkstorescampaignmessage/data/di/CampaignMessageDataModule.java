package com.talabat.feature.darkstorescampaignmessage.data.di;

import com.talabat.feature.darkstorescampaignmessage.data.mapper.CampaignProgressResponseMapper;
import com.talabat.feature.darkstorescampaignmessage.data.mapper.CampaignProgressSourceMapper;
import com.talabat.feature.darkstorescampaignmessage.data.mapper.CampaignProgressStateMapper;
import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse;
import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressState;
import com.talabat.feature.darkstorescampaignmessage.data.repository.CampaignMessageRepositoryImpl;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignProgressResponse;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignSource;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignState;
import com.talabat.feature.darkstorescampaignmessage.domain.repository.CampaignMessageRepository;
import com.talabat.mapper.ModelMapper;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH'J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\u000f\u001a\u00020\u0010H'J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\n\u001a\u00020\u0014H'¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/darkstorescampaignmessage/data/di/CampaignMessageDataModule;", "", "bindCampaignMessageRepository", "Lcom/talabat/feature/darkstorescampaignmessage/domain/repository/CampaignMessageRepository;", "campaignMessageRepository", "Lcom/talabat/feature/darkstorescampaignmessage/data/repository/CampaignMessageRepositoryImpl;", "bindsCampaignProgressResponseMapper", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressResponse;", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignProgressResponse;", "campaignProgressStateMapper", "Lcom/talabat/feature/darkstorescampaignmessage/data/mapper/CampaignProgressResponseMapper;", "bindsCampaignProgressSourceMapper", "", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignSource;", "campaignProgressSourceMapper", "Lcom/talabat/feature/darkstorescampaignmessage/data/mapper/CampaignProgressSourceMapper;", "bindsCampaignProgressStateMapper", "Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressState;", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignState;", "Lcom/talabat/feature/darkstorescampaignmessage/data/mapper/CampaignProgressStateMapper;", "com_talabat_feature_darkstores-campaign-message_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface CampaignMessageDataModule {
    @NotNull
    @Binds
    @Reusable
    CampaignMessageRepository bindCampaignMessageRepository(@NotNull CampaignMessageRepositoryImpl campaignMessageRepositoryImpl);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<NetworkCampaignProgressResponse, CampaignProgressResponse> bindsCampaignProgressResponseMapper(@NotNull CampaignProgressResponseMapper campaignProgressResponseMapper);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<String, CampaignSource> bindsCampaignProgressSourceMapper(@NotNull CampaignProgressSourceMapper campaignProgressSourceMapper);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<NetworkCampaignProgressState, CampaignState> bindsCampaignProgressStateMapper(@NotNull CampaignProgressStateMapper campaignProgressStateMapper);
}
