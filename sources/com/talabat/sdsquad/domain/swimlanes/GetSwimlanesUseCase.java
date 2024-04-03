package com.talabat.sdsquad.domain.swimlanes;

import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.data.swimlanes.SwimlanesRepository;
import com.talabat.sdsquad.data.swimlanes.responses.Result;
import com.talabat.sdsquad.data.swimlanes.responses.SwimLane;
import com.talabat.sdsquad.data.swimlanes.responses.SwimlanesResponse;
import cu.a;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001:\u0001\rB\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/talabat/sdsquad/domain/swimlanes/GetSwimlanesUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/swimlanes/GetSwimlanesUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/data/swimlanes/responses/SwimLane;", "requestValues", "b", "Lcom/talabat/sdsquad/data/swimlanes/SwimlanesRepository;", "mSwimlanesRepository", "Lcom/talabat/sdsquad/data/swimlanes/SwimlanesRepository;", "<init>", "(Lcom/talabat/sdsquad/data/swimlanes/SwimlanesRepository;)V", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0})
public final class GetSwimlanesUseCase extends UseCase<RequestValues, Flowable<List<? extends SwimLane>>> {
    @NotNull
    private final SwimlanesRepository mSwimlanesRepository;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/talabat/sdsquad/domain/swimlanes/GetSwimlanesUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "isForceUpdate", "", "latitude", "", "longitude", "areaId", "countryCode", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAreaId", "()Ljava/lang/String;", "getCountryCode", "()Z", "getLatitude", "getLongitude", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RequestValues implements UseCase.RequestValues {
        @NotNull
        private final String areaId;
        @NotNull
        private final String countryCode;
        private final boolean isForceUpdate;
        @NotNull
        private final String latitude;
        @NotNull
        private final String longitude;

        public RequestValues(boolean z11, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, "latitude");
            Intrinsics.checkNotNullParameter(str2, "longitude");
            Intrinsics.checkNotNullParameter(str3, "areaId");
            Intrinsics.checkNotNullParameter(str4, "countryCode");
            this.isForceUpdate = z11;
            this.latitude = str;
            this.longitude = str2;
            this.areaId = str3;
            this.countryCode = str4;
        }

        @NotNull
        public final String getAreaId() {
            return this.areaId;
        }

        @NotNull
        public final String getCountryCode() {
            return this.countryCode;
        }

        @NotNull
        public final String getLatitude() {
            return this.latitude;
        }

        @NotNull
        public final String getLongitude() {
            return this.longitude;
        }

        public final boolean isForceUpdate() {
            return this.isForceUpdate;
        }
    }

    public GetSwimlanesUseCase(@NotNull SwimlanesRepository swimlanesRepository) {
        Intrinsics.checkNotNullParameter(swimlanesRepository, "mSwimlanesRepository");
        this.mSwimlanesRepository = swimlanesRepository;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeUseCase$lambda-1$lambda-0  reason: not valid java name */
    public static final List m10788executeUseCase$lambda1$lambda0(SwimlanesResponse swimlanesResponse) {
        List<SwimLane> swimLanes;
        Intrinsics.checkNotNullParameter(swimlanesResponse, "it");
        Result result = swimlanesResponse.getResult();
        if (result == null || (swimLanes = result.getSwimLanes()) == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return swimLanes;
    }

    @NotNull
    /* renamed from: b */
    public Flowable<List<SwimLane>> executeUseCase(@Nullable RequestValues requestValues) {
        if (requestValues != null) {
            Flowable<R> map = this.mSwimlanesRepository.getSwimlanesResponse(requestValues.isForceUpdate(), requestValues.getLatitude(), requestValues.getLongitude(), requestValues.getAreaId(), requestValues.getCountryCode()).map(new a());
            Intrinsics.checkNotNullExpressionValue(map, "mSwimlanesRepository.get…Lane>()\n                }");
            return map;
        }
        throw new RuntimeException("request values can not be null");
    }
}
