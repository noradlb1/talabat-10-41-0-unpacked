package com.talabat.restaurants.v2.data.swimlane;

import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import library.talabat.com.talabatlib.SwimlaneResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001Jr\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00062\u000e\b\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\b\b\u0001\u0010\u000e\u001a\u00020\u00062\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\bH'¨\u0006\u0011"}, d2 = {"Lcom/talabat/restaurants/v2/data/swimlane/SwimlaneApi;", "", "getSwimlanes", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/SwimlaneResponse;", "apiVersion", "", "latitude", "", "longitude", "areaId", "countryCode", "verticalIds", "", "swimlaneVariant", "placementScreen", "placementPlace", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SwimlaneApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Single getSwimlanes$default(SwimlaneApi swimlaneApi, int i11, String str, String str2, int i12, int i13, List list, int i14, String str3, String str4, int i15, Object obj) {
            int i16 = i15;
            if (obj == null) {
                return swimlaneApi.getSwimlanes((i16 & 1) != 0 ? 4 : i11, str, str2, i12, i13, list, i14, (i16 & 128) != 0 ? null : str3, (i16 & 256) != 0 ? null : str4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSwimlanes");
        }
    }

    @NotNull
    @GET("/restaurantapi/v{version}/swimlanes")
    Single<SwimlaneResponse> getSwimlanes(@Path("version") int i11, @NotNull @Query("latitude") String str, @NotNull @Query("longitude") String str2, @Query("areaid") int i12, @Query("countrycode") int i13, @NotNull @Query("verticalIds") List<Integer> list, @Query("swimlaneVariant") int i14, @Nullable @Header("X-Device-Entrypoint") String str3, @Nullable @Header("X-Device-CTA") String str4);
}
