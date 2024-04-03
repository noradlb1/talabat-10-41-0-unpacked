package com.talabat.restaurants.v2.domain.vendors;

import com.facebook.internal.NativeProtocol;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.restaurants.v2.data.vendors.VendorsRepository;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestuarntListResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u0012B\u0001\u00128\b\u0002\u0010\u0005\u001a2\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006\u0012:\b\u0002\u0010\n\u001a4\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0002R>\u0010\u0005\u001a2\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R@\u0010\n\u001a4\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/restaurants/v2/domain/vendors/RequestVendorsUseCase;", "Lkotlin/Function1;", "Lcom/talabat/restaurants/v2/domain/vendors/RequestVendorsUseCase$Params;", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/RestuarntListResponse;", "requestVendorsByAreaUseCase", "Lkotlin/Function6;", "", "", "", "requestVendorsByPolygonUseCase", "Lkotlin/Function5;", "", "shouldUsePolygonApiUseCase", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function6;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function0;)V", "invoke", "params", "Params", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RequestVendorsUseCase implements Function1<Params, Single<RestuarntListResponse>> {
    @NotNull
    private final Function6<Boolean, Integer, Integer, Integer, String, String, Single<RestuarntListResponse>> requestVendorsByAreaUseCase;
    @NotNull
    private final Function5<Boolean, Integer, String, String, List<Integer>, Single<RestuarntListResponse>> requestVendorsByPolygonUseCase;
    @NotNull
    private final Function0<Boolean> shouldUsePolygonApiUseCase;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fHÆ\u0003JW\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fHÆ\u0001J\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/talabat/restaurants/v2/domain/vendors/RequestVendorsUseCase$Params;", "", "isForceUpdate", "", "areaId", "", "cityId", "countryId", "latitude", "", "longitude", "verticalIds", "", "(ZIIILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAreaId", "()I", "getCityId", "getCountryId", "()Z", "getLatitude", "()Ljava/lang/String;", "getLongitude", "getVerticalIds", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Params {
        private final int areaId;
        private final int cityId;
        private final int countryId;
        private final boolean isForceUpdate;
        @NotNull
        private final String latitude;
        @NotNull
        private final String longitude;
        @Nullable
        private final List<Integer> verticalIds;

        public Params(boolean z11, int i11, int i12, int i13, @NotNull String str, @NotNull String str2, @Nullable List<Integer> list) {
            Intrinsics.checkNotNullParameter(str, "latitude");
            Intrinsics.checkNotNullParameter(str2, "longitude");
            this.isForceUpdate = z11;
            this.areaId = i11;
            this.cityId = i12;
            this.countryId = i13;
            this.latitude = str;
            this.longitude = str2;
            this.verticalIds = list;
        }

        public static /* synthetic */ Params copy$default(Params params, boolean z11, int i11, int i12, int i13, String str, String str2, List<Integer> list, int i14, Object obj) {
            if ((i14 & 1) != 0) {
                z11 = params.isForceUpdate;
            }
            if ((i14 & 2) != 0) {
                i11 = params.areaId;
            }
            int i15 = i11;
            if ((i14 & 4) != 0) {
                i12 = params.cityId;
            }
            int i16 = i12;
            if ((i14 & 8) != 0) {
                i13 = params.countryId;
            }
            int i17 = i13;
            if ((i14 & 16) != 0) {
                str = params.latitude;
            }
            String str3 = str;
            if ((i14 & 32) != 0) {
                str2 = params.longitude;
            }
            String str4 = str2;
            if ((i14 & 64) != 0) {
                list = params.verticalIds;
            }
            return params.copy(z11, i15, i16, i17, str3, str4, list);
        }

        public final boolean component1() {
            return this.isForceUpdate;
        }

        public final int component2() {
            return this.areaId;
        }

        public final int component3() {
            return this.cityId;
        }

        public final int component4() {
            return this.countryId;
        }

        @NotNull
        public final String component5() {
            return this.latitude;
        }

        @NotNull
        public final String component6() {
            return this.longitude;
        }

        @Nullable
        public final List<Integer> component7() {
            return this.verticalIds;
        }

        @NotNull
        public final Params copy(boolean z11, int i11, int i12, int i13, @NotNull String str, @NotNull String str2, @Nullable List<Integer> list) {
            Intrinsics.checkNotNullParameter(str, "latitude");
            Intrinsics.checkNotNullParameter(str2, "longitude");
            return new Params(z11, i11, i12, i13, str, str2, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.isForceUpdate == params.isForceUpdate && this.areaId == params.areaId && this.cityId == params.cityId && this.countryId == params.countryId && Intrinsics.areEqual((Object) this.latitude, (Object) params.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) params.longitude) && Intrinsics.areEqual((Object) this.verticalIds, (Object) params.verticalIds);
        }

        public final int getAreaId() {
            return this.areaId;
        }

        public final int getCityId() {
            return this.cityId;
        }

        public final int getCountryId() {
            return this.countryId;
        }

        @NotNull
        public final String getLatitude() {
            return this.latitude;
        }

        @NotNull
        public final String getLongitude() {
            return this.longitude;
        }

        @Nullable
        public final List<Integer> getVerticalIds() {
            return this.verticalIds;
        }

        public int hashCode() {
            boolean z11 = this.isForceUpdate;
            if (z11) {
                z11 = true;
            }
            int hashCode = (((((((((((z11 ? 1 : 0) * true) + this.areaId) * 31) + this.cityId) * 31) + this.countryId) * 31) + this.latitude.hashCode()) * 31) + this.longitude.hashCode()) * 31;
            List<Integer> list = this.verticalIds;
            return hashCode + (list == null ? 0 : list.hashCode());
        }

        public final boolean isForceUpdate() {
            return this.isForceUpdate;
        }

        @NotNull
        public String toString() {
            boolean z11 = this.isForceUpdate;
            int i11 = this.areaId;
            int i12 = this.cityId;
            int i13 = this.countryId;
            String str = this.latitude;
            String str2 = this.longitude;
            List<Integer> list = this.verticalIds;
            return "Params(isForceUpdate=" + z11 + ", areaId=" + i11 + ", cityId=" + i12 + ", countryId=" + i13 + ", latitude=" + str + ", longitude=" + str2 + ", verticalIds=" + list + ")";
        }
    }

    public RequestVendorsUseCase(@NotNull Function6<? super Boolean, ? super Integer, ? super Integer, ? super Integer, ? super String, ? super String, ? extends Single<RestuarntListResponse>> function6, @NotNull Function5<? super Boolean, ? super Integer, ? super String, ? super String, ? super List<Integer>, ? extends Single<RestuarntListResponse>> function5, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function6, "requestVendorsByAreaUseCase");
        Intrinsics.checkNotNullParameter(function5, "requestVendorsByPolygonUseCase");
        Intrinsics.checkNotNullParameter(function0, "shouldUsePolygonApiUseCase");
        this.requestVendorsByAreaUseCase = function6;
        this.requestVendorsByPolygonUseCase = function5;
        this.shouldUsePolygonApiUseCase = function0;
    }

    @NotNull
    public Single<RestuarntListResponse> invoke(@NotNull Params params) {
        Intrinsics.checkNotNullParameter(params, NativeProtocol.WEB_DIALOG_PARAMS);
        if (this.shouldUsePolygonApiUseCase.invoke().booleanValue()) {
            return this.requestVendorsByPolygonUseCase.invoke(Boolean.valueOf(params.isForceUpdate()), 3, params.getLatitude(), params.getLongitude(), params.getVerticalIds());
        }
        return this.requestVendorsByAreaUseCase.invoke(Boolean.valueOf(params.isForceUpdate()), Integer.valueOf(params.getAreaId()), Integer.valueOf(params.getCountryId()), Integer.valueOf(params.getCityId()), params.getLatitude(), params.getLongitude());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RequestVendorsUseCase(Function6 function6, Function5 function5, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new RequestVendorsByAreaUseCase((VendorsRepository) null, 1, (DefaultConstructorMarker) null) : function6, (i11 & 2) != 0 ? new RequestVendorsByPolygonUseCase((VendorsRepository) null, (ITalabatExperiment) null, 3, (DefaultConstructorMarker) null) : function5, function0);
    }
}
