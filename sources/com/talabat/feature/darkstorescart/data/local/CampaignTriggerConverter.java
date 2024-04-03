package com.talabat.feature.darkstorescart.data.local;

import androidx.room.TypeConverter;
import com.serjltt.moshi.adapters.FallbackEnum;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/local/CampaignTriggerConverter;", "", "()V", "fromTriggerJson", "", "stat", "Lcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;", "toTrigger", "json", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CampaignTriggerConverter {
    @TypeConverter
    @NotNull
    public final String fromTriggerJson(@Nullable CampaignTrigger campaignTrigger) {
        JsonAdapter<CampaignTrigger> adapter = new Moshi.Builder().add(FallbackEnum.ADAPTER_FACTORY).build().adapter(CampaignTrigger.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(CampaignTrigger::class.java)");
        String json = adapter.toJson(campaignTrigger);
        Intrinsics.checkNotNullExpressionValue(json, "adapter.toJson(stat)");
        return json;
    }

    @TypeConverter
    @Nullable
    public final CampaignTrigger toTrigger(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "json");
        JsonAdapter<CampaignTrigger> adapter = new Moshi.Builder().add(FallbackEnum.ADAPTER_FACTORY).build().adapter(CampaignTrigger.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(CampaignTrigger::class.java)");
        return adapter.fromJson(str);
    }
}
