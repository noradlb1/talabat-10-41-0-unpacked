package com.talabat.collectiondetails.data;

import JsonModels.Response.Darkstores.DarkStoresEntryPointResponse;
import JsonModels.Response.TermsResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J0\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J(\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H&¨\u0006\u0013"}, d2 = {"Lcom/talabat/collectiondetails/data/TermsDataSource;", "", "getCountryId", "Lio/reactivex/Single;", "", "getDarkstoresInfo", "LJsonModels/Response/Darkstores/DarkStoresEntryPointResponse;", "url", "", "areaId", "lat", "lng", "getLatitude", "getLongitude", "getSelectedAreaId", "getTerms", "LJsonModels/Response/TermsResponse;", "collectionId", "countryId", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TermsDataSource {
    @NotNull
    Single<Integer> getCountryId();

    @NotNull
    Single<DarkStoresEntryPointResponse> getDarkstoresInfo(@NotNull String str, int i11, @NotNull String str2, @NotNull String str3);

    @NotNull
    Single<String> getLatitude();

    @NotNull
    Single<String> getLongitude();

    @NotNull
    Single<Integer> getSelectedAreaId();

    @NotNull
    Single<TermsResponse> getTerms(@NotNull String str, int i11, int i12);
}
