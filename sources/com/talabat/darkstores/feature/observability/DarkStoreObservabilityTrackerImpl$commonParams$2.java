package com.talabat.darkstores.feature.observability;

import androidx.exifinterface.media.ExifInterface;
import com.talabat.darkstores.data.tracking.BaseTrackerKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DarkStoreObservabilityTrackerImpl$commonParams$2 extends Lambda implements Function0<HashMap<String, String>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DarkStoreObservabilityTrackerImpl f56472g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkStoreObservabilityTrackerImpl$commonParams$2(DarkStoreObservabilityTrackerImpl darkStoreObservabilityTrackerImpl) {
        super(0);
        this.f56472g = darkStoreObservabilityTrackerImpl;
    }

    @NotNull
    public final HashMap<String, String> invoke() {
        return MapsKt__MapsKt.hashMapOf(TuplesKt.to("isDarkStore", String.valueOf(!this.f56472g.configurationParameters.isMigrated())), TuplesKt.to("chainId", String.valueOf(this.f56472g.configurationParameters.getChainId())), TuplesKt.to("talabatBranchCode", String.valueOf(this.f56472g.configurationParameters.getBranchId())), TuplesKt.to("latitude", String.valueOf(this.f56472g.configurationParameters.getLocation().getLatitude())), TuplesKt.to("longitude", String.valueOf(this.f56472g.configurationParameters.getLocation().getLongitude())), TuplesKt.to("countryId", String.valueOf(this.f56472g.integrationGlobalDataModel.selectedCountryCode())), TuplesKt.to("deviceSource", "6"), TuplesKt.to("eventSource", ExifInterface.GPS_MEASUREMENT_2D), TuplesKt.to("appVersion", BaseTrackerKt.orDefault$default(this.f56472g.appVersionProvider.appVersion(), (String) null, 1, (Object) null)), TuplesKt.to("customerId", this.f56472g.configurationParameters.getCustomerId()));
    }
}
