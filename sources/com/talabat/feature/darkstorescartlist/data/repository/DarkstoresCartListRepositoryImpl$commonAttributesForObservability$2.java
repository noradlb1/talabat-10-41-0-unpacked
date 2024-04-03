package com.talabat.feature.darkstorescartlist.data.repository;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresCartListRepositoryImpl$commonAttributesForObservability$2 extends Lambda implements Function0<HashMap<String, String>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartListRepositoryImpl f58495g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkstoresCartListRepositoryImpl$commonAttributesForObservability$2(DarkstoresCartListRepositoryImpl darkstoresCartListRepositoryImpl) {
        super(0);
        this.f58495g = darkstoresCartListRepositoryImpl;
    }

    @NotNull
    public final HashMap<String, String> invoke() {
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to("latitude", String.valueOf(this.f58495g.integrationDataModel.selectedLocationLatitude()));
        pairArr[1] = TuplesKt.to("longitude", String.valueOf(this.f58495g.integrationDataModel.selectedLocationLongitude()));
        pairArr[2] = TuplesKt.to("countryId", String.valueOf(this.f58495g.integrationDataModel.selectedCountryCode()));
        pairArr[3] = TuplesKt.to("deviceSource", "6");
        pairArr[4] = TuplesKt.to("eventSource", ExifInterface.GPS_MEASUREMENT_2D);
        String appVersion = this.f58495g.appVersionProvider.appVersion();
        if (appVersion == null) {
            appVersion = "";
        }
        pairArr[5] = TuplesKt.to("appVersion", appVersion);
        pairArr[6] = TuplesKt.to("customerId", this.f58495g.integrationDataModel.customerID());
        return MapsKt__MapsKt.hashMapOf(pairArr);
    }
}
