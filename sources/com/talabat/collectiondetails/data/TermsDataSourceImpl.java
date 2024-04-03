package com.talabat.collectiondetails.data;

import JsonModels.Request.TermsRequest;
import JsonModels.Response.Darkstores.DarkStoresEntryPointResponse;
import JsonModels.Response.TermsResponse;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.helpers.GlobalDataModel;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.CreateApiUrl;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J0\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\fH\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\fH\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J(\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/talabat/collectiondetails/data/TermsDataSourceImpl;", "Lcom/talabat/collectiondetails/data/TermsDataSource;", "termsApi", "Lcom/talabat/collectiondetails/data/TermsApi;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "(Lcom/talabat/collectiondetails/data/TermsApi;Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;)V", "getConfigurationLocalCoreLibApi", "()Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "getTermsApi", "()Lcom/talabat/collectiondetails/data/TermsApi;", "getCountryId", "Lio/reactivex/Single;", "", "getDarkstoresInfo", "LJsonModels/Response/Darkstores/DarkStoresEntryPointResponse;", "url", "", "areaId", "lat", "lng", "getLatitude", "getLongitude", "getSelectedAreaId", "getTerms", "LJsonModels/Response/TermsResponse;", "collectionId", "countryId", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TermsDataSourceImpl implements TermsDataSource {
    @NotNull
    private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
    @NotNull
    private final TermsApi termsApi;

    public TermsDataSourceImpl(@NotNull TermsApi termsApi2, @NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
        Intrinsics.checkNotNullParameter(termsApi2, "termsApi");
        Intrinsics.checkNotNullParameter(configurationLocalCoreLibApi2, "configurationLocalCoreLibApi");
        this.termsApi = termsApi2;
        this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
    }

    @NotNull
    public final ConfigurationLocalCoreLibApi getConfigurationLocalCoreLibApi() {
        return this.configurationLocalCoreLibApi;
    }

    @NotNull
    public Single<Integer> getCountryId() {
        Single<Integer> just = Single.just(Integer.valueOf(this.configurationLocalCoreLibApi.getRepository().selectedCountry().getCountryId()));
        Intrinsics.checkNotNullExpressionValue(just, "just(configurationLocalC…ectedCountry().countryId)");
        return just;
    }

    @NotNull
    public Single<DarkStoresEntryPointResponse> getDarkstoresInfo(@NotNull String str, int i11, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "lat");
        Intrinsics.checkNotNullParameter(str3, "lng");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        return this.termsApi.getDarkStoresInfo(CreateApiUrl.createWithParameters(str, new String[]{"{areaId}", sb2.toString(), "{latitude}", str2, "{longitude}", str3}));
    }

    @NotNull
    public Single<String> getLatitude() {
        Single<String> just = Single.just(GlobalDataModel.LATLONGFORAPI.getLatitude());
        Intrinsics.checkNotNullExpressionValue(just, "just(GlobalDataModel.LATLONGFORAPI.getLatitude())");
        return just;
    }

    @NotNull
    public Single<String> getLongitude() {
        Single<String> just = Single.just(GlobalDataModel.LATLONGFORAPI.getLongitude());
        Intrinsics.checkNotNullExpressionValue(just, "just(GlobalDataModel.LATLONGFORAPI.getLongitude())");
        return just;
    }

    @NotNull
    public Single<Integer> getSelectedAreaId() {
        Single<Integer> just = Single.just(Integer.valueOf(GlobalDataModel.SelectedAreaId));
        Intrinsics.checkNotNullExpressionValue(just, "just(GlobalDataModel.SelectedAreaId)");
        return just;
    }

    @NotNull
    public Single<TermsResponse> getTerms(@NotNull String str, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, "url");
        TermsRequest termsRequest = new TermsRequest();
        termsRequest.setCollectionId(i11);
        termsRequest.setCountryId(i12);
        return this.termsApi.getTerms(str, termsRequest);
    }

    @NotNull
    public final TermsApi getTermsApi() {
        return this.termsApi;
    }
}
