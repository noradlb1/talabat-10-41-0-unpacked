package com.talabat.darkstores.di;

import com.talabat.feature.darkstorescampaignmessage.data.mapper.CampaignProgressResponseMapper;
import com.talabat.feature.darkstorescampaignmessage.data.mapper.CampaignProgressSourceMapper;
import com.talabat.feature.darkstorescampaignmessage.data.mapper.CampaignProgressStateMapper;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/di/DarkstoresCampaignMessageModule;", "", "()V", "provideCampaignProgressResponseMapper", "Lcom/talabat/feature/darkstorescampaignmessage/data/mapper/CampaignProgressResponseMapper;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class DarkstoresCampaignMessageModule {
    @NotNull
    @Provides
    public final CampaignProgressResponseMapper provideCampaignProgressResponseMapper() {
        return new CampaignProgressResponseMapper(new CampaignProgressStateMapper(), new CampaignProgressSourceMapper());
    }
}
