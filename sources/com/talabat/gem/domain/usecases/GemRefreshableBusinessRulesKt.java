package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.Location;
import com.talabat.gem.domain.usecases.GemOfferRequester;
import com.talabat.gem.ports.presentation.GemRefreshableViewPort;
import io.reactivex.subjects.ReplaySubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u001a\u001c\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0007\u001a\u001c\u0010\b\u001a\u00020\u0004*\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0007\u001a\u0012\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\u00020\u0005H\u0007\u001a\u0012\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b*\u00020\u0005H\u0007\u001a$\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0010*\u00020\u00052\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0007\u001a\u0014\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010*\u00020\u0005H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"MAX_LOCATIONS_CACHED", "", "MIN_LOCALIZATION_CHANGES", "bindLocalizationHistory", "", "Lcom/talabat/gem/ports/presentation/GemRefreshableViewPort;", "onLocalizationChanged", "Lkotlin/Function0;", "bindLocationsHistory", "onLocationChanged", "createLocalizationSubject", "Lio/reactivex/subjects/ReplaySubject;", "", "createLocationsSubject", "Lcom/talabat/gem/domain/entities/Location;", "onRefreshWithLocalizationChange", "", "requestOffer", "onRefreshWithLocationChange", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemRefreshableBusinessRulesKt {
    public static final int MAX_LOCATIONS_CACHED = 2;
    public static final int MIN_LOCALIZATION_CHANGES = 2;

    @BusinessRules
    public static final void bindLocalizationHistory(@NotNull GemRefreshableViewPort gemRefreshableViewPort, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(gemRefreshableViewPort, "<this>");
        Intrinsics.checkNotNullParameter(function0, "onLocalizationChanged");
        gemRefreshableViewPort.autoDispose(new GemRefreshableBusinessRulesKt$bindLocalizationHistory$2(gemRefreshableViewPort, function0));
    }

    public static /* synthetic */ void bindLocalizationHistory$default(GemRefreshableViewPort gemRefreshableViewPort, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function0 = new GemRefreshableBusinessRulesKt$bindLocalizationHistory$1(gemRefreshableViewPort);
        }
        bindLocalizationHistory(gemRefreshableViewPort, function0);
    }

    @BusinessRules
    public static final void bindLocationsHistory(@NotNull GemRefreshableViewPort gemRefreshableViewPort, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(gemRefreshableViewPort, "<this>");
        Intrinsics.checkNotNullParameter(function0, "onLocationChanged");
        gemRefreshableViewPort.autoDispose(new GemRefreshableBusinessRulesKt$bindLocationsHistory$2(gemRefreshableViewPort, function0));
    }

    public static /* synthetic */ void bindLocationsHistory$default(GemRefreshableViewPort gemRefreshableViewPort, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function0 = new GemRefreshableBusinessRulesKt$bindLocationsHistory$1(gemRefreshableViewPort);
        }
        bindLocationsHistory(gemRefreshableViewPort, function0);
    }

    @NotNull
    @BusinessRules
    public static final ReplaySubject<String> createLocalizationSubject(@NotNull GemRefreshableViewPort gemRefreshableViewPort) {
        Intrinsics.checkNotNullParameter(gemRefreshableViewPort, "<this>");
        ReplaySubject<String> createWithSize = ReplaySubject.createWithSize(2);
        Intrinsics.checkNotNullExpressionValue(createWithSize, "createWithSize<String>(MIN_LOCALIZATION_CHANGES)");
        return createWithSize;
    }

    @NotNull
    @BusinessRules
    public static final ReplaySubject<Location> createLocationsSubject(@NotNull GemRefreshableViewPort gemRefreshableViewPort) {
        Intrinsics.checkNotNullParameter(gemRefreshableViewPort, "<this>");
        ReplaySubject<Location> createWithSize = ReplaySubject.createWithSize(2);
        Intrinsics.checkNotNullExpressionValue(createWithSize, "createWithSize<Location>(MAX_LOCATIONS_CACHED)");
        return createWithSize;
    }

    @BusinessRules
    @Nullable
    public static final List<String> onRefreshWithLocalizationChange(@NotNull GemRefreshableViewPort gemRefreshableViewPort, @NotNull Function0<Unit> function0) {
        List<String> takeLast;
        Intrinsics.checkNotNullParameter(gemRefreshableViewPort, "<this>");
        Intrinsics.checkNotNullParameter(function0, "requestOffer");
        Object[] values = gemRefreshableViewPort.getLocalizationHistory().getValues();
        Intrinsics.checkNotNullExpressionValue(values, "localizationHistory\n    .values");
        ArrayList arrayList = new ArrayList(values.length);
        int length = values.length;
        boolean z11 = false;
        int i11 = 0;
        while (i11 < length) {
            Object obj = values[i11];
            if (obj != null) {
                arrayList.add((String) obj);
                i11++;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (arrayList.size() < 2) {
            z11 = true;
        }
        if (z11) {
            arrayList = null;
        }
        if (arrayList == null || (takeLast = CollectionsKt___CollectionsKt.takeLast(arrayList, 2)) == null) {
            return null;
        }
        if (!(!Intrinsics.areEqual(CollectionsKt___CollectionsKt.first(takeLast), CollectionsKt___CollectionsKt.last(takeLast)))) {
            takeLast = null;
        }
        if (takeLast == null) {
            return null;
        }
        function0.invoke();
        return takeLast;
    }

    public static /* synthetic */ List onRefreshWithLocalizationChange$default(GemRefreshableViewPort gemRefreshableViewPort, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function0 = new GemRefreshableBusinessRulesKt$onRefreshWithLocalizationChange$1(gemRefreshableViewPort);
        }
        return onRefreshWithLocalizationChange(gemRefreshableViewPort, function0);
    }

    @BusinessRules
    @Nullable
    public static final List<Location> onRefreshWithLocationChange(@NotNull GemRefreshableViewPort gemRefreshableViewPort) {
        boolean z11;
        Intrinsics.checkNotNullParameter(gemRefreshableViewPort, "<this>");
        Object[] values = gemRefreshableViewPort.getLocationsHistory().getValues();
        Intrinsics.checkNotNullExpressionValue(values, "locationsHistory\n    .values");
        ArrayList arrayList = new ArrayList(values.length);
        int length = values.length;
        int i11 = 0;
        while (i11 < length) {
            Object obj = values[i11];
            if (obj != null) {
                arrayList.add((Location) obj);
                i11++;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.gem.domain.entities.Location");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            boolean z12 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Location location = (Location) next;
            if (location.getLatitude() == null || location.getLongitude() == null) {
                z12 = false;
            }
            if (z12) {
                arrayList2.add(next);
            }
        }
        if (arrayList2.size() == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            arrayList2 = null;
        }
        if (arrayList2 == null) {
            return null;
        }
        if (Intrinsics.areEqual(arrayList2.get(1), (Object) gemRefreshableViewPort.getRefreshedLocation().getValue())) {
            arrayList2 = null;
        }
        if (arrayList2 == null) {
            return null;
        }
        if (Intrinsics.areEqual(arrayList2.get(0), arrayList2.get(1))) {
            arrayList2 = null;
        }
        if (arrayList2 == null) {
            return null;
        }
        GemViewBusinessRulesKt.onRequestOffer(gemRefreshableViewPort, GemOfferRequester.Refresh.INSTANCE, new GemRefreshableBusinessRulesKt$onRefreshWithLocationChange$6$1(gemRefreshableViewPort, arrayList2));
        return arrayList2;
    }
}
