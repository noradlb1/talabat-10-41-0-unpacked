package com.talabat.restaurants.v2.data.swimlane;

import com.talabat.observability.tracker.TimeTrackerImplementation;
import com.talabat.observability.tracker.TimeTrackerKt;
import com.talabat.restaurants.v2.data.InMemoryCache;
import com.talabat.restaurants.v2.data.swimlane.SwimlaneApi;
import com.talabat.restaurants.v2.data.swimlane.SwimlaneRepository;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kt.a;
import library.talabat.com.talabatlib.SwimlaneResponse;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/restaurants/v2/data/swimlane/SwimlaneRepositoryImpl;", "Lcom/talabat/restaurants/v2/data/swimlane/SwimlaneRepository;", "swimlaneApi", "Lcom/talabat/restaurants/v2/data/swimlane/SwimlaneApi;", "cache", "Lcom/talabat/restaurants/v2/data/InMemoryCache;", "tracker", "Lcom/talabat/observability/tracker/TimeTrackerImplementation;", "(Lcom/talabat/restaurants/v2/data/swimlane/SwimlaneApi;Lcom/talabat/restaurants/v2/data/InMemoryCache;Lcom/talabat/observability/tracker/TimeTrackerImplementation;)V", "getSwimlanes", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/SwimlaneResponse;", "kotlin.jvm.PlatformType", "data", "Lcom/talabat/restaurants/v2/data/swimlane/SwimlaneRepository$SwimlaneData;", "responseKey", "", "latitude", "", "longitude", "responseKey$com_talabat_talabat_talabat", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneRepositoryImpl implements SwimlaneRepository {
    @NotNull
    private final InMemoryCache cache;
    @NotNull
    private final SwimlaneApi swimlaneApi;
    @NotNull
    private final TimeTrackerImplementation tracker;

    public SwimlaneRepositoryImpl() {
        this((SwimlaneApi) null, (InMemoryCache) null, (TimeTrackerImplementation) null, 7, (DefaultConstructorMarker) null);
    }

    public SwimlaneRepositoryImpl(@NotNull SwimlaneApi swimlaneApi2, @NotNull InMemoryCache inMemoryCache, @NotNull TimeTrackerImplementation timeTrackerImplementation) {
        Intrinsics.checkNotNullParameter(swimlaneApi2, "swimlaneApi");
        Intrinsics.checkNotNullParameter(inMemoryCache, "cache");
        Intrinsics.checkNotNullParameter(timeTrackerImplementation, "tracker");
        this.swimlaneApi = swimlaneApi2;
        this.cache = inMemoryCache;
        this.tracker = timeTrackerImplementation;
    }

    /* access modifiers changed from: private */
    /* renamed from: getSwimlanes$lambda-1$lambda-0  reason: not valid java name */
    public static final void m10733getSwimlanes$lambda1$lambda0(SwimlaneRepositoryImpl swimlaneRepositoryImpl, SwimlaneRepository.SwimlaneData swimlaneData, String str, SwimlaneResponse swimlaneResponse) {
        Intrinsics.checkNotNullParameter(swimlaneRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(swimlaneData, "$this_with");
        Intrinsics.checkNotNullParameter(str, "$trackName");
        swimlaneRepositoryImpl.cache.setSwimlaneResponse(swimlaneResponse);
        swimlaneRepositoryImpl.cache.setKey(swimlaneRepositoryImpl.responseKey$com_talabat_talabat_talabat(swimlaneData.getLatitude$com_talabat_talabat_talabat(), swimlaneData.getLongitude$com_talabat_talabat_talabat()));
        TimeTrackerImplementation.stopTracking$default(swimlaneRepositoryImpl.tracker, str, 0, 2, (Object) null);
    }

    @NotNull
    public Single<SwimlaneResponse> getSwimlanes(@NotNull SwimlaneRepository.SwimlaneData swimlaneData) {
        SwimlaneRepository.SwimlaneData swimlaneData2 = swimlaneData;
        Intrinsics.checkNotNullParameter(swimlaneData2, "data");
        if (this.cache.getSwimlaneResponse() == null || swimlaneData.isForceUpdate$com_talabat_talabat_talabat()) {
            Object obj = (Integer) CollectionsKt___CollectionsKt.firstOrNull(swimlaneData.getVerticalIds$com_talabat_talabat_talabat());
            if (obj == null) {
                obj = "0";
            }
            String str = "SWIMLANES_REQUEST_VL" + obj;
            TimeTrackerImplementation.startTracking$default(this.tracker, str, 0, 2, (Object) null);
            Single<SwimlaneResponse> doOnSuccess = SwimlaneApi.DefaultImpls.getSwimlanes$default(this.swimlaneApi, 0, swimlaneData.getLatitude$com_talabat_talabat_talabat(), swimlaneData.getLongitude$com_talabat_talabat_talabat(), swimlaneData.getAreaId$com_talabat_talabat_talabat(), swimlaneData.getCountryCode$com_talabat_talabat_talabat(), swimlaneData.getVerticalIds$com_talabat_talabat_talabat(), swimlaneData.getSwimlaneVariant$com_talabat_talabat_talabat(), swimlaneData.getPlacementScreen$com_talabat_talabat_talabat(), swimlaneData.getPlacementPlace$com_talabat_talabat_talabat(), 1, (Object) null).doOnSuccess(new a(this, swimlaneData2, str));
            Intrinsics.checkNotNullExpressionValue(doOnSuccess, "{\n            val trackN…)\n            }\n        }");
            return doOnSuccess;
        }
        Single<SwimlaneResponse> just = Single.just(this.cache.getSwimlaneResponse());
        Intrinsics.checkNotNullExpressionValue(just, "{\n            Single.jus…imlaneResponse)\n        }");
        return just;
    }

    public final int responseKey$com_talabat_talabat_talabat(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        return str.hashCode() + str2.hashCode();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SwimlaneRepositoryImpl(SwimlaneApi swimlaneApi2, InMemoryCache inMemoryCache, TimeTrackerImplementation timeTrackerImplementation, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? SwimlaneApiImplKt.SwimlaneApiImpl() : swimlaneApi2, (i11 & 2) != 0 ? SwimlaneRepositoryImplKt.getInMemoryCache() : inMemoryCache, (i11 & 4) != 0 ? TimeTrackerKt.getTimeTracker() : timeTrackerImplementation);
    }
}
