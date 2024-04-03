package com.talabat.collectiondetails.data;

import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import library.talabat.com.talabatlib.RestuarntListResponse;
import library.talabat.com.talabatlib.VendorTagsResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH'J\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00062\u0010\b\u0001\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f2\u0010\b\u0001\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f2\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\bH'¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/talabat/collectiondetails/data/CollectionsApi;", "", "getCollectionVendorTags", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/VendorTagsResponse;", "collectionId", "", "latitude", "", "longitude", "getCollectionVendors", "Llibrary/talabat/com/talabatlib/RestuarntListResponse;", "page", "size", "filtersIds", "", "cuisineIds", "sorting", "deviceEntryPoint", "deviceCTA", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CollectionsApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Single getCollectionVendors$default(CollectionsApi collectionsApi, int i11, String str, String str2, Integer num, Integer num2, List list, List list2, String str3, String str4, String str5, int i12, Object obj) {
            String str6;
            String str7;
            int i13 = i12;
            if (obj == null) {
                if ((i13 & 256) != 0) {
                    str6 = "home";
                } else {
                    str6 = str4;
                }
                if ((i13 & 512) != 0) {
                    str7 = "channel";
                } else {
                    str7 = str5;
                }
                return collectionsApi.getCollectionVendors(i11, str, str2, num, num2, list, list2, str3, str6, str7);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCollectionVendors");
        }
    }

    @NotNull
    @GET("vendor-list/v1/collections/{collectionId}/vendor-tags")
    Single<VendorTagsResponse> getCollectionVendorTags(@Path("collectionId") int i11, @NotNull @Query("lat") String str, @NotNull @Query("lon") String str2);

    @NotNull
    @GET("vendor-list/v1/collections/{collectionId}/vendors")
    Single<RestuarntListResponse> getCollectionVendors(@Path("collectionId") int i11, @NotNull @Query("lat") String str, @NotNull @Query("lon") String str2, @Nullable @Query("page") Integer num, @Nullable @Query("size") Integer num2, @Nullable @Query("filter_id") List<Integer> list, @Nullable @Query("cuisine_id") List<Integer> list2, @Nullable @Query("sort") String str3, @Nullable @Header("X-Device-Entrypoint") String str4, @Nullable @Header("X-Device-CTA") String str5);
}
