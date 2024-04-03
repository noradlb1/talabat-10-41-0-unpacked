package com.talabat.feature.darkstorescampaignmessage.data.model;

import com.serjltt.moshi.adapters.FallbackEnum;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

@JsonClass(generateAdapter = false)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressState;", "", "(Ljava/lang/String;I)V", "HIDDEN", "IN_PROGRESS", "SUCCESS", "BELOW_THRESHOLD", "TRANSIENT", "com_talabat_feature_darkstores-campaign-message_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@FallbackEnum(name = "HIDDEN")
public enum NetworkCampaignProgressState {
    HIDDEN,
    IN_PROGRESS,
    SUCCESS,
    BELOW_THRESHOLD,
    TRANSIENT
}
