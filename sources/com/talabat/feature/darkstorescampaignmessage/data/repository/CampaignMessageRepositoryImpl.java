package com.talabat.feature.darkstorescampaignmessage.data.repository;

import am.a;
import com.facebook.internal.NativeProtocol;
import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse;
import com.talabat.feature.darkstorescampaignmessage.data.remote.CampaignMessageApi;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignMessageParams;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignProgressResponse;
import com.talabat.feature.darkstorescampaignmessage.domain.repository.CampaignMessageRepository;
import com.talabat.mapper.ModelMapper;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/feature/darkstorescampaignmessage/data/repository/CampaignMessageRepositoryImpl;", "Lcom/talabat/feature/darkstorescampaignmessage/domain/repository/CampaignMessageRepository;", "campaignMessageApi", "Lcom/talabat/feature/darkstorescampaignmessage/data/remote/CampaignMessageApi;", "campaignProgressResponseMapper", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressResponse;", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignProgressResponse;", "(Lcom/talabat/feature/darkstorescampaignmessage/data/remote/CampaignMessageApi;Lcom/talabat/mapper/ModelMapper;)V", "getCampaignMessage", "Lio/reactivex/Single;", "params", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignMessageParams;", "com_talabat_feature_darkstores-campaign-message_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignMessageRepositoryImpl implements CampaignMessageRepository {
    @NotNull
    private final CampaignMessageApi campaignMessageApi;
    @NotNull
    private final ModelMapper<NetworkCampaignProgressResponse, CampaignProgressResponse> campaignProgressResponseMapper;

    @Inject
    public CampaignMessageRepositoryImpl(@NotNull CampaignMessageApi campaignMessageApi2, @NotNull ModelMapper<NetworkCampaignProgressResponse, CampaignProgressResponse> modelMapper) {
        Intrinsics.checkNotNullParameter(campaignMessageApi2, "campaignMessageApi");
        Intrinsics.checkNotNullParameter(modelMapper, "campaignProgressResponseMapper");
        this.campaignMessageApi = campaignMessageApi2;
        this.campaignProgressResponseMapper = modelMapper;
    }

    /* access modifiers changed from: private */
    /* renamed from: getCampaignMessage$lambda-0  reason: not valid java name */
    public static final CampaignProgressResponse m10152getCampaignMessage$lambda0(CampaignMessageRepositoryImpl campaignMessageRepositoryImpl, NetworkCampaignProgressResponse networkCampaignProgressResponse) {
        Intrinsics.checkNotNullParameter(campaignMessageRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(networkCampaignProgressResponse, "it");
        return campaignMessageRepositoryImpl.campaignProgressResponseMapper.apply(networkCampaignProgressResponse);
    }

    @NotNull
    public Single<CampaignProgressResponse> getCampaignMessage(@NotNull CampaignMessageParams campaignMessageParams) {
        Intrinsics.checkNotNullParameter(campaignMessageParams, NativeProtocol.WEB_DIALOG_PARAMS);
        CampaignMessageApi campaignMessageApi2 = this.campaignMessageApi;
        float subTotal = campaignMessageParams.getSubTotal();
        Float subTotalAfterDiscount = campaignMessageParams.getSubTotalAfterDiscount();
        Single<R> map = campaignMessageApi2.getCampaignMessage(campaignMessageParams.getVendorCode(), campaignMessageParams.getGlobalEntityId(), subTotal, subTotalAfterDiscount, campaignMessageParams.getLatitude(), campaignMessageParams.getLongitude(), campaignMessageParams.getChainId()).map(new a(this));
        Intrinsics.checkNotNullExpressionValue(map, "campaignMessageApi.getCa…esponseMapper.apply(it) }");
        return map;
    }
}
