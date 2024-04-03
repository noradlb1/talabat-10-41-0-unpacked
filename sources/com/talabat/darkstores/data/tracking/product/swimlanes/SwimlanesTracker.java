package com.talabat.darkstores.data.tracking.product.swimlanes;

import android.os.Bundle;
import com.facebook.internal.security.CertificateUtil;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J>\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0012*\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/data/tracking/product/swimlanes/SwimlanesTracker;", "", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "storeInfoTrackingProvider", "Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;)V", "swimlanesLoaded", "", "swimlaneRequestId", "", "swimlaneTitles", "", "screenName", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "screenType", "pageType", "toMap", "", "Landroid/os/Bundle;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesTracker {
    @NotNull
    private final StoreInfoTrackingProvider storeInfoTrackingProvider;
    @NotNull
    private final TalabatTracker talabatTracker;

    @Inject
    public SwimlanesTracker(@NotNull TalabatTracker talabatTracker2, @NotNull StoreInfoTrackingProvider storeInfoTrackingProvider2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        Intrinsics.checkNotNullParameter(storeInfoTrackingProvider2, "storeInfoTrackingProvider");
        this.talabatTracker = talabatTracker2;
        this.storeInfoTrackingProvider = storeInfoTrackingProvider2;
    }

    public static /* synthetic */ void swimlanesLoaded$default(SwimlanesTracker swimlanesTracker, String str, List list, EventOriginType eventOriginType, String str2, String str3, int i11, Object obj) {
        String str4;
        String str5;
        if ((i11 & 2) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List list2 = list;
        if ((i11 & 8) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i11 & 16) != 0) {
            str5 = null;
        } else {
            str5 = str3;
        }
        swimlanesTracker.swimlanesLoaded(str, list2, eventOriginType, str4, str5);
    }

    private final Map<String, Object> toMap(Bundle bundle) {
        HashMap hashMap = new HashMap(bundle.size());
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if (obj != null) {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }

    public final void swimlanesLoaded(@NotNull String str, @NotNull List<String> list, @NotNull EventOriginType eventOriginType, @Nullable String str2, @Nullable String str3) {
        String str4 = str;
        List<String> list2 = list;
        String str5 = str2;
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str4, "swimlaneRequestId");
        Intrinsics.checkNotNullParameter(list2, "swimlaneTitles");
        Intrinsics.checkNotNullParameter(eventOriginType, "screenName");
        Pair[] pairArr = new Pair[3];
        int i11 = 0;
        pairArr[0] = TuplesKt.to("swimlaneRequestId", str4);
        Iterable iterable = list2;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Object next : iterable) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(i11 + CertificateUtil.DELIMITER + ((String) next));
            i11 = i12;
        }
        pairArr[1] = TuplesKt.to("swimlaneTitleList", CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        pairArr[2] = TuplesKt.to("screenName", eventOriginType.getTrackingName());
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (str5 != null) {
            String str7 = (String) mutableMapOf.put("screenType", str5);
        }
        if (str6 != null) {
            mutableMapOf.put(SwimlanesTrackerKt.PAGE_TYPE, str6);
        }
        this.talabatTracker.track(new SwimlaneLoadedEvent(toMap(this.storeInfoTrackingProvider.getStoreInfoParams()), mutableMapOf));
    }
}
