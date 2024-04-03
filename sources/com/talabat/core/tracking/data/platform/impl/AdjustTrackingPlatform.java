package com.talabat.core.tracking.data.platform.impl;

import android.content.Context;
import com.talabat.adjust.Adjust;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.core.tracking.data.platform.TrackingPlatform;
import com.talabat.core.tracking.domain.CommonAttributes;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n2\u0006\u0010\r\u001a\u00020\u000bH\u0016J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u000b2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/core/tracking/data/platform/impl/AdjustTrackingPlatform;", "Lcom/talabat/core/tracking/data/platform/TrackingPlatform;", "context", "Landroid/content/Context;", "commonAttributes", "Lcom/talabat/core/tracking/domain/CommonAttributes;", "adjust", "Lcom/talabat/adjust/Adjust;", "(Landroid/content/Context;Lcom/talabat/core/tracking/domain/CommonAttributes;Lcom/talabat/adjust/Adjust;)V", "getCommonAttributes", "", "", "", "eventName", "track", "", "attributes", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AdjustTrackingPlatform implements TrackingPlatform {
    @NotNull
    private final Adjust adjust;
    @NotNull
    private final CommonAttributes commonAttributes;
    @NotNull
    private final Context context;

    public AdjustTrackingPlatform(@NotNull Context context2, @NotNull CommonAttributes commonAttributes2, @NotNull Adjust adjust2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(commonAttributes2, "commonAttributes");
        Intrinsics.checkNotNullParameter(adjust2, "adjust");
        this.context = context2;
        this.commonAttributes = commonAttributes2;
        this.adjust = adjust2;
    }

    @NotNull
    public Map<String, Object> getCommonAttributes(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("user_id", this.commonAttributes.getUserId());
        linkedHashMap.put("country", this.commonAttributes.getSelectedCountry());
        linkedHashMap.put(ConstantsKt.ADJUST_CITY_ID, String.valueOf(this.commonAttributes.getSelectedCityId()));
        linkedHashMap.put("area_id", this.commonAttributes.getSelectedArea());
        linkedHashMap.put("app_version", this.commonAttributes.getAppVersion());
        linkedHashMap.put(ConstantsKt.ADJUST_LANGUAGE, this.commonAttributes.getSelectedLanguage());
        return linkedHashMap;
    }

    public void track(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        for (Map.Entry next : getCommonAttributes(str).entrySet()) {
            this.adjust.addSessionParameter((String) next.getKey(), String.valueOf(next.getValue()));
        }
        this.adjust.trackEvent(str, map);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdjustTrackingPlatform(Context context2, CommonAttributes commonAttributes2, Adjust adjust2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, commonAttributes2, (i11 & 4) != 0 ? Adjust.INSTANCE.initialize(context2) : adjust2);
    }
}
