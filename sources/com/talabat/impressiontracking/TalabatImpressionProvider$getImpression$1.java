package com.talabat.impressiontracking;

import com.deliveryhero.impression.Impression;
import com.talabat.impressiontracking.items.TrackableImpressionItem;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\u0004H\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"com/talabat/impressiontracking/TalabatImpressionProvider$getImpression$1", "Lcom/deliveryhero/impression/Impression;", "payload", "", "", "getPayload", "()Ljava/util/Map;", "getId", "com_talabat_ThirdPartyLibs_ImpressionTracking_ImpressionTracking"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatImpressionProvider$getImpression$1 implements Impression {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TrackableImpressionItem f60987a;
    @NotNull
    private final Map<String, String> payload;

    public TalabatImpressionProvider$getImpression$1(TrackableImpressionItem trackableImpressionItem) {
        this.f60987a = trackableImpressionItem;
        this.payload = trackableImpressionItem.getImpressionPayload();
    }

    @NotNull
    public String getId() {
        return this.f60987a.getId();
    }

    @NotNull
    public Map<String, String> getPayload() {
        return this.payload;
    }
}
