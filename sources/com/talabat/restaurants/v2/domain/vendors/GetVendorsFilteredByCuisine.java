package com.talabat.restaurants.v2.domain.vendors;

import com.facebook.internal.NativeProtocol;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.restaurants.v2.domain.vendors.GetVendorsUseCase;
import datamodels.Cuisine;
import datamodels.Restaurant;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pt.f;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001:\u0001\rB-\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001¢\u0006\u0002\u0010\nJ\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0002R&\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/restaurants/v2/domain/vendors/GetVendorsFilteredByCuisine;", "Lkotlin/Function1;", "Lcom/talabat/restaurants/v2/domain/vendors/GetVendorsFilteredByCuisine$Params;", "Lio/reactivex/Single;", "", "Ldatamodels/Restaurant;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getVendorsUseCase", "Lcom/talabat/restaurants/v2/domain/vendors/GetVendorsUseCase$Params;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lkotlin/jvm/functions/Function1;)V", "invoke", "params", "Params", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetVendorsFilteredByCuisine implements Function1<Params, Single<List<? extends Restaurant>>> {
    @NotNull
    private final Function1<GetVendorsUseCase.Params, Single<List<Restaurant>>> getVendorsUseCase;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001c\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006%"}, d2 = {"Lcom/talabat/restaurants/v2/domain/vendors/GetVendorsFilteredByCuisine$Params;", "", "isForceUpdate", "", "areaId", "", "cityId", "countryId", "latitude", "", "longitude", "verticalId", "cuisineId", "(ZIIILjava/lang/String;Ljava/lang/String;II)V", "getAreaId", "()I", "getCityId", "getCountryId", "getCuisineId", "()Z", "getLatitude", "()Ljava/lang/String;", "getLongitude", "getVerticalId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Params {
        private final int areaId;
        private final int cityId;
        private final int countryId;
        private final int cuisineId;
        private final boolean isForceUpdate;
        @NotNull
        private final String latitude;
        @NotNull
        private final String longitude;
        private final int verticalId;

        public Params(boolean z11, int i11, int i12, int i13, @NotNull String str, @NotNull String str2, int i14, int i15) {
            Intrinsics.checkNotNullParameter(str, "latitude");
            Intrinsics.checkNotNullParameter(str2, "longitude");
            this.isForceUpdate = z11;
            this.areaId = i11;
            this.cityId = i12;
            this.countryId = i13;
            this.latitude = str;
            this.longitude = str2;
            this.verticalId = i14;
            this.cuisineId = i15;
        }

        public static /* synthetic */ Params copy$default(Params params, boolean z11, int i11, int i12, int i13, String str, String str2, int i14, int i15, int i16, Object obj) {
            Params params2 = params;
            int i17 = i16;
            return params.copy((i17 & 1) != 0 ? params2.isForceUpdate : z11, (i17 & 2) != 0 ? params2.areaId : i11, (i17 & 4) != 0 ? params2.cityId : i12, (i17 & 8) != 0 ? params2.countryId : i13, (i17 & 16) != 0 ? params2.latitude : str, (i17 & 32) != 0 ? params2.longitude : str2, (i17 & 64) != 0 ? params2.verticalId : i14, (i17 & 128) != 0 ? params2.cuisineId : i15);
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

        public final int component8() {
            return this.cuisineId;
        }

        @NotNull
        public final Params copy(boolean z11, int i11, int i12, int i13, @NotNull String str, @NotNull String str2, int i14, int i15) {
            Intrinsics.checkNotNullParameter(str, "latitude");
            String str3 = str2;
            Intrinsics.checkNotNullParameter(str3, "longitude");
            return new Params(z11, i11, i12, i13, str, str3, i14, i15);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.isForceUpdate == params.isForceUpdate && this.areaId == params.areaId && this.cityId == params.cityId && this.countryId == params.countryId && Intrinsics.areEqual((Object) this.latitude, (Object) params.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) params.longitude) && this.verticalId == params.verticalId && this.cuisineId == params.cuisineId;
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

        public final int getCuisineId() {
            return this.cuisineId;
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
            return ((((((((((((((z11 ? 1 : 0) * true) + this.areaId) * 31) + this.cityId) * 31) + this.countryId) * 31) + this.latitude.hashCode()) * 31) + this.longitude.hashCode()) * 31) + this.verticalId) * 31) + this.cuisineId;
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
            int i15 = this.cuisineId;
            return "Params(isForceUpdate=" + z11 + ", areaId=" + i11 + ", cityId=" + i12 + ", countryId=" + i13 + ", latitude=" + str + ", longitude=" + str2 + ", verticalId=" + i14 + ", cuisineId=" + i15 + ")";
        }
    }

    public GetVendorsFilteredByCuisine(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull Function1<? super GetVendorsUseCase.Params, ? extends Single<List<Restaurant>>> function1) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(function1, "getVendorsUseCase");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.getVendorsUseCase = function1;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final List m10749invoke$lambda2(Params params, List list) {
        boolean z11;
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(list, "it");
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            Cuisine[] cuisines = ((Restaurant) next).getCuisines();
            Intrinsics.checkNotNullExpressionValue(cuisines, "vendor.getCuisines()");
            int length = cuisines.length;
            boolean z12 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (cuisines[i11].f13848id == params.getCuisineId()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    z12 = true;
                    break;
                }
                i11++;
            }
            if (z12) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @NotNull
    public Single<List<Restaurant>> invoke(@NotNull Params params) {
        Intrinsics.checkNotNullParameter(params, NativeProtocol.WEB_DIALOG_PARAMS);
        Single<List<Restaurant>> map = this.getVendorsUseCase.invoke(new GetVendorsUseCase.Params(params.isForceUpdate(), params.getAreaId(), params.getCityId(), params.getCountryId(), params.getLatitude(), params.getLongitude(), params.getVerticalId())).map(new f(params));
        Intrinsics.checkNotNullExpressionValue(map, "getVendorsUseCase(\n     …}\n            }\n        }");
        return map;
    }
}
