package com.talabat.feature.darkstoresflutter.data.mapper;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgress;
import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse;
import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressState;
import com.talabat.feature.darkstoresflutter.data.model.FlutterCampaignProgress;
import com.talabat.feature.darkstoresflutter.data.model.FlutterCampaignProgressWrapper;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0002J\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/mapper/CampaignProgressToFlutterCampaignProgressMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressResponse;", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaignProgressWrapper;", "()V", "apply", "source", "toCampaignProgress", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCampaignProgress;", "Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgress;", "toStateString", "", "Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressState;", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignProgressToFlutterCampaignProgressMapper implements ModelMapper<NetworkCampaignProgressResponse, FlutterCampaignProgressWrapper> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NetworkCampaignProgressState.values().length];
            iArr[NetworkCampaignProgressState.HIDDEN.ordinal()] = 1;
            iArr[NetworkCampaignProgressState.IN_PROGRESS.ordinal()] = 2;
            iArr[NetworkCampaignProgressState.SUCCESS.ordinal()] = 3;
            iArr[NetworkCampaignProgressState.BELOW_THRESHOLD.ordinal()] = 4;
            iArr[NetworkCampaignProgressState.TRANSIENT.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final FlutterCampaignProgress toCampaignProgress(NetworkCampaignProgress networkCampaignProgress) {
        String str;
        boolean z11;
        String iconImage = networkCampaignProgress.getIconImage();
        String message = networkCampaignProgress.getMessage();
        Float progressValue = networkCampaignProgress.getProgressValue();
        Long showForSeconds = networkCampaignProgress.getShowForSeconds();
        NetworkCampaignProgressState state = networkCampaignProgress.getState();
        if (state != null) {
            str = toStateString(state);
        } else {
            str = null;
        }
        String str2 = str;
        Boolean isTPro = networkCampaignProgress.isTPro();
        if (isTPro != null) {
            z11 = isTPro.booleanValue();
        } else {
            z11 = false;
        }
        return new FlutterCampaignProgress(iconImage, message, progressValue, showForSeconds, str2, Boolean.valueOf(z11), networkCampaignProgress.getMessageSource());
    }

    private final String toStateString(NetworkCampaignProgressState networkCampaignProgressState) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[networkCampaignProgressState.ordinal()];
        if (i11 == 1) {
            return "hidden";
        }
        if (i11 == 2) {
            return "in_progress";
        }
        if (i11 == 3) {
            return "success";
        }
        if (i11 == 4) {
            return "below_threshold";
        }
        if (i11 == 5) {
            return FacebookRequestErrorClassification.KEY_TRANSIENT;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public FlutterCampaignProgressWrapper apply(@NotNull NetworkCampaignProgressResponse networkCampaignProgressResponse) {
        Intrinsics.checkNotNullParameter(networkCampaignProgressResponse, "source");
        NetworkCampaignProgress networkCampaignProgress = networkCampaignProgressResponse.getTransient();
        FlutterCampaignProgress flutterCampaignProgress = null;
        FlutterCampaignProgress campaignProgress = networkCampaignProgress != null ? toCampaignProgress(networkCampaignProgress) : null;
        NetworkCampaignProgress permanent = networkCampaignProgressResponse.getPermanent();
        if (permanent != null) {
            flutterCampaignProgress = toCampaignProgress(permanent);
        }
        return new FlutterCampaignProgressWrapper(flutterCampaignProgress, campaignProgress);
    }
}
