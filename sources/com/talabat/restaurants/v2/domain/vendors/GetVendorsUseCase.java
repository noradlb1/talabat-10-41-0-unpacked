package com.talabat.restaurants.v2.domain.vendors;

import JsonModels.RestaurantListJM;
import com.facebook.internal.NativeProtocol;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.restaurants.v2.domain.utils.VendorFilterByVertical;
import com.talabat.restaurants.v2.domain.vendors.RequestVendorsUseCase;
import datamodels.Restaurant;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestuarntListResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pt.g;
import pt.h;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/restaurants/v2/domain/vendors/GetVendorsUseCase;", "Lcom/talabat/restaurants/v2/domain/vendors/VendorsUseCase;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "requestVendorsUseCase", "Lcom/talabat/restaurants/v2/domain/vendors/RequestVendorsUseCase;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/restaurants/v2/domain/vendors/RequestVendorsUseCase;)V", "invoke", "Lio/reactivex/Single;", "", "Ldatamodels/Restaurant;", "params", "Lcom/talabat/restaurants/v2/domain/vendors/GetVendorsUseCase$Params;", "Params", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetVendorsUseCase implements VendorsUseCase {
    @NotNull
    private final RequestVendorsUseCase requestVendorsUseCase;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\""}, d2 = {"Lcom/talabat/restaurants/v2/domain/vendors/GetVendorsUseCase$Params;", "", "isForceUpdate", "", "areaId", "", "cityId", "countryId", "latitude", "", "longitude", "verticalId", "(ZIIILjava/lang/String;Ljava/lang/String;I)V", "getAreaId", "()I", "getCityId", "getCountryId", "()Z", "getLatitude", "()Ljava/lang/String;", "getLongitude", "getVerticalId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Params {
        private final int areaId;
        private final int cityId;
        private final int countryId;
        private final boolean isForceUpdate;
        @NotNull
        private final String latitude;
        @NotNull
        private final String longitude;
        private final int verticalId;

        public Params(boolean z11, int i11, int i12, int i13, @NotNull String str, @NotNull String str2, int i14) {
            Intrinsics.checkNotNullParameter(str, "latitude");
            Intrinsics.checkNotNullParameter(str2, "longitude");
            this.isForceUpdate = z11;
            this.areaId = i11;
            this.cityId = i12;
            this.countryId = i13;
            this.latitude = str;
            this.longitude = str2;
            this.verticalId = i14;
        }

        public static /* synthetic */ Params copy$default(Params params, boolean z11, int i11, int i12, int i13, String str, String str2, int i14, int i15, Object obj) {
            if ((i15 & 1) != 0) {
                z11 = params.isForceUpdate;
            }
            if ((i15 & 2) != 0) {
                i11 = params.areaId;
            }
            int i16 = i11;
            if ((i15 & 4) != 0) {
                i12 = params.cityId;
            }
            int i17 = i12;
            if ((i15 & 8) != 0) {
                i13 = params.countryId;
            }
            int i18 = i13;
            if ((i15 & 16) != 0) {
                str = params.latitude;
            }
            String str3 = str;
            if ((i15 & 32) != 0) {
                str2 = params.longitude;
            }
            String str4 = str2;
            if ((i15 & 64) != 0) {
                i14 = params.verticalId;
            }
            return params.copy(z11, i16, i17, i18, str3, str4, i14);
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

        public final int component7() {
            return this.verticalId;
        }

        @NotNull
        public final Params copy(boolean z11, int i11, int i12, int i13, @NotNull String str, @NotNull String str2, int i14) {
            Intrinsics.checkNotNullParameter(str, "latitude");
            Intrinsics.checkNotNullParameter(str2, "longitude");
            return new Params(z11, i11, i12, i13, str, str2, i14);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.isForceUpdate == params.isForceUpdate && this.areaId == params.areaId && this.cityId == params.cityId && this.countryId == params.countryId && Intrinsics.areEqual((Object) this.latitude, (Object) params.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) params.longitude) && this.verticalId == params.verticalId;
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

        public final int getVerticalId() {
            return this.verticalId;
        }

        public int hashCode() {
            boolean z11 = this.isForceUpdate;
            if (z11) {
                z11 = true;
            }
            return ((((((((((((z11 ? 1 : 0) * true) + this.areaId) * 31) + this.cityId) * 31) + this.countryId) * 31) + this.latitude.hashCode()) * 31) + this.longitude.hashCode()) * 31) + this.verticalId;
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
            int i14 = this.verticalId;
            return "Params(isForceUpdate=" + z11 + ", areaId=" + i11 + ", cityId=" + i12 + ", countryId=" + i13 + ", latitude=" + str + ", longitude=" + str2 + ", verticalId=" + i14 + ")";
        }
    }

    public GetVendorsUseCase(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull RequestVendorsUseCase requestVendorsUseCase2) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(requestVendorsUseCase2, "requestVendorsUseCase");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.requestVendorsUseCase = requestVendorsUseCase2;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final List m10750invoke$lambda0(RestuarntListResponse restuarntListResponse) {
        Restaurant[] restaurantArr;
        List list;
        Intrinsics.checkNotNullParameter(restuarntListResponse, "it");
        RestaurantListJM restaurantListJM = restuarntListResponse.result;
        if (restaurantListJM == null || (restaurantArr = restaurantListJM.restaurants) == null || (list = ArraysKt___ArraysKt.toList((T[]) restaurantArr)) == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return list;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final List m10751invoke$lambda1(Params params, GetVendorsUseCase getVendorsUseCase, List list) {
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(getVendorsUseCase, "this$0");
        Intrinsics.checkNotNullParameter(list, "it");
        return VendorFilterByVertical.INSTANCE.filter(list, true, params.getVerticalId(), getVendorsUseCase.talabatFeatureFlag);
    }

    @NotNull
    public Single<List<Restaurant>> invoke(@NotNull Params params) {
        Intrinsics.checkNotNullParameter(params, NativeProtocol.WEB_DIALOG_PARAMS);
        Single<R> map = this.requestVendorsUseCase.invoke(new RequestVendorsUseCase.Params(params.isForceUpdate(), params.getAreaId(), params.getCityId(), params.getCountryId(), params.getLatitude(), params.getLongitude(), CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(params.getVerticalId())))).map(new g()).map(new h(params, this));
        Intrinsics.checkNotNullExpressionValue(map, "requestVendorsUseCase.in…eatureFlag)\n            }");
        return map;
    }
}
