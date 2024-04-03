package fwfd.com.fwfsdk.model.dao;

import fwfd.com.fwfsdk.model.api.FWFPut;
import fwfd.com.fwfsdk.model.api.FlagKeysContainer;
import fwfd.com.fwfsdk.model.api.requestbody.FWFGetFeaturesRequest;
import fwfd.com.fwfsdk.model.api.requestbody.FWFGetFlagRequest;
import java.util.LinkedHashMap;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface FWFAPIService {
    @PUT("features/{key}")
    Call<FWFPut> getFWFFeature(@Path("key") String str, @Body FWFGetFlagRequest fWFGetFlagRequest, @Header("Authorization") String str2, @Header("Isdebug") String str3);

    @PUT("features")
    Call<LinkedHashMap<String, FWFPut>> getFWFFeatures(@Body FWFGetFeaturesRequest fWFGetFeaturesRequest, @Header("Authorization") String str, @Header("Isdebug") String str2);

    @GET("features-list/keys")
    Call<FlagKeysContainer> getFlagKeys(@Header("Authorization") String str);

    @PUT("features")
    Call<LinkedHashMap<String, FWFPut>> getFlags(@Body FWFGetFlagRequest fWFGetFlagRequest, @Header("Authorization") String str, @Header("Isdebug") String str2);
}
