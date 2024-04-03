package fwfd.com.fwfsdk.model.dao;

import fwfd.com.fwfsdk.FunWithFlags;
import fwfd.com.fwfsdk.model.api.FWFPut;
import fwfd.com.fwfsdk.model.api.FlagKeysContainer;
import fwfd.com.fwfsdk.model.api.requestbody.FWFGetFeaturesRequest;
import fwfd.com.fwfsdk.model.api.requestbody.FWFGetFlagRequest;
import fwfd.com.fwfsdk.util.FWFHelper;
import fwfd.com.fwfsdk.util.FWFResultCallback;
import java.util.Arrays;
import java.util.LinkedHashMap;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FWFAPIDAO extends FWFAPIClient {

    /* renamed from: service  reason: collision with root package name */
    private final FWFAPIService f14059service = ((FWFAPIService) this.retrofit.create(FWFAPIService.class));

    public FWFAPIDAO(String str) {
        super(str, FunWithFlags.getInstance().getFwfConfig().getCustomInterceptors());
    }

    private FWFGetFeaturesRequest createGetFlagsRequest(String[] strArr) {
        return new FWFGetFeaturesRequest(FunWithFlags.getInstance().getUser().getAttributes(), strArr);
    }

    public void getFWFFeature(final String str, String str2, final FWFResultCallback<FWFPut> fWFResultCallback) {
        this.f14059service.getFWFFeature(str, new FWFGetFlagRequest(FunWithFlags.getInstance().getUser().getAttributes()), str2, String.valueOf(FunWithFlags.getInstance().getFwfConfig().isDebugMode())).enqueue(new Callback<FWFPut>() {
            public void onFailure(Call<FWFPut> call, Throwable th2) {
                fWFResultCallback.onError(FWFHelper.fwfErrorAPIResponse(str, th2.getMessage()));
            }

            public void onResponse(Call<FWFPut> call, Response<FWFPut> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    fWFResultCallback.onError(FWFHelper.fwfErrorAPIResponse(str, Integer.valueOf(response.code())));
                } else {
                    fWFResultCallback.onResponse(response.body());
                }
            }
        });
    }

    public void getFWFFeatures(final String[] strArr, String str, final FWFResultCallback<LinkedHashMap<String, FWFPut>> fWFResultCallback) {
        this.f14059service.getFWFFeatures(createGetFlagsRequest(strArr), str, String.valueOf(FunWithFlags.getInstance().getFwfConfig().isDebugMode())).enqueue(new Callback<LinkedHashMap<String, FWFPut>>() {
            public void onFailure(Call<LinkedHashMap<String, FWFPut>> call, Throwable th2) {
                fWFResultCallback.onError(FWFHelper.fwfErrorAPIResponse(Arrays.toString(strArr), th2.getMessage()));
            }

            public void onResponse(Call<LinkedHashMap<String, FWFPut>> call, Response<LinkedHashMap<String, FWFPut>> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    fWFResultCallback.onError(FWFHelper.fwfErrorAPIResponse(Arrays.toString(strArr), Integer.valueOf(response.code())));
                } else {
                    fWFResultCallback.onResponse(response.body());
                }
            }
        });
    }

    public void getFWFFlagKeys(final String str, final FWFResultCallback<FlagKeysContainer> fWFResultCallback) {
        this.f14059service.getFlagKeys(str).enqueue(new Callback<FlagKeysContainer>() {
            public void onFailure(Call<FlagKeysContainer> call, Throwable th2) {
                fWFResultCallback.onError(FWFHelper.fwfErrorFlagKeysAPIResponse(str, th2.getMessage()));
            }

            public void onResponse(Call<FlagKeysContainer> call, Response<FlagKeysContainer> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    fWFResultCallback.onError(FWFHelper.fwfErrorFlagKeysAPIResponse(str, Integer.valueOf(response.code())));
                } else {
                    fWFResultCallback.onResponse(response.body());
                }
            }
        });
    }

    public void getFWFFeatures(final String str, final FWFResultCallback<LinkedHashMap<String, FWFPut>> fWFResultCallback) {
        this.f14059service.getFlags(new FWFGetFlagRequest(FunWithFlags.getInstance().getUser().getAttributes()), str, String.valueOf(FunWithFlags.getInstance().getFwfConfig().isDebugMode())).enqueue(new Callback<LinkedHashMap<String, FWFPut>>() {
            public void onFailure(Call<LinkedHashMap<String, FWFPut>> call, Throwable th2) {
                fWFResultCallback.onError(FWFHelper.fwfErrorAllFlagsAPIResponse(str, th2.getMessage()));
            }

            public void onResponse(Call<LinkedHashMap<String, FWFPut>> call, Response<LinkedHashMap<String, FWFPut>> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    fWFResultCallback.onError(FWFHelper.fwfErrorAllFlagsAPIResponse(str, Integer.valueOf(response.code())));
                } else {
                    fWFResultCallback.onResponse(response.body());
                }
            }
        });
    }
}
