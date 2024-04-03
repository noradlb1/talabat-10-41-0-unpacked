package com.talabat.sdsquad.domain.darkstores;

import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.data.darkstors.DarkStoreRepository;
import com.talabat.sdsquad.data.darkstors.responses.DarkStoreResponse;
import io.reactivex.Flowable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\fB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/talabat/sdsquad/domain/darkstores/GetDarkStoreUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/darkstores/GetDarkStoreUseCase$RequestValues;", "Lio/reactivex/Flowable;", "Lcom/talabat/sdsquad/data/darkstors/responses/DarkStoreResponse;", "requestValues", "a", "Lcom/talabat/sdsquad/data/darkstors/DarkStoreRepository;", "mVendorRepository", "Lcom/talabat/sdsquad/data/darkstors/DarkStoreRepository;", "<init>", "(Lcom/talabat/sdsquad/data/darkstors/DarkStoreRepository;)V", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0})
public final class GetDarkStoreUseCase extends UseCase<RequestValues, Flowable<DarkStoreResponse>> {
    @NotNull
    private final DarkStoreRepository mVendorRepository;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/talabat/sdsquad/domain/darkstores/GetDarkStoreUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "isForceUpdate", "", "areaId", "", "latitude", "", "longitude", "(ZILjava/lang/String;Ljava/lang/String;)V", "getAreaId", "()I", "()Z", "getLatitude", "()Ljava/lang/String;", "getLongitude", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RequestValues implements UseCase.RequestValues {
        private final int areaId;
        private final boolean isForceUpdate;
        @NotNull
        private final String latitude;
        @NotNull
        private final String longitude;

        public RequestValues(boolean z11, int i11, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "latitude");
            Intrinsics.checkNotNullParameter(str2, "longitude");
            this.isForceUpdate = z11;
            this.areaId = i11;
            this.latitude = str;
            this.longitude = str2;
        }

        public final int getAreaId() {
            return this.areaId;
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

    public GetDarkStoreUseCase(@NotNull DarkStoreRepository darkStoreRepository) {
        Intrinsics.checkNotNullParameter(darkStoreRepository, "mVendorRepository");
        this.mVendorRepository = darkStoreRepository;
    }

    @NotNull
    /* renamed from: a */
    public Flowable<DarkStoreResponse> executeUseCase(@Nullable RequestValues requestValues) {
        if (requestValues != null) {
            return this.mVendorRepository.getDarkStore(requestValues.isForceUpdate(), requestValues.getAreaId(), requestValues.getLatitude(), requestValues.getLongitude());
        }
        throw new RuntimeException("request value can not be null");
    }
}
