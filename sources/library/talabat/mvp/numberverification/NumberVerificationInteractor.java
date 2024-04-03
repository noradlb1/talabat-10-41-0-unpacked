package library.talabat.mvp.numberverification;

import JsonModels.Request.MobileNumberVerifyRequest;
import JsonModels.Request.MobileVerification.CheckRequest;
import JsonModels.Request.MobileVerification.EditRequest;
import JsonModels.Request.MobileVerification.GetCodeRequest;
import JsonModels.Response.MobNumberCheckRM;
import JsonModels.Response.MobNumberGetCodeRespose;
import JsonModels.Response.MobNumberUpdateRM;
import JsonModels.Response.MobNumberValidationGetCodeRM;
import JsonModels.Response.MobNumberVerifyRM;
import JsonModels.Response.MobileVerification.CheckResponse;
import JsonModels.Response.MobileVerification.EditResponse;
import JsonModels.parser.UniversalGson;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.TalabatVolley;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class NumberVerificationInteractor implements INumberVerificationInteractor {
    /* access modifiers changed from: private */
    public String addressId;
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public String mobileNumber;
    /* access modifiers changed from: private */
    public NumberVerificationListener numberVerificationListener;
    /* access modifiers changed from: private */
    public int option;
    /* access modifiers changed from: private */
    public int verificationOption;

    public NumberVerificationInteractor(AppVersionProvider appVersionProvider2, NumberVerificationListener numberVerificationListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.numberVerificationListener = numberVerificationListener2;
    }

    private Response.Listener<MobNumberValidationGetCodeRM> onGetCodeVerifyOption() {
        return new Response.Listener<MobNumberValidationGetCodeRM>() {
            public void onResponse(MobNumberValidationGetCodeRM mobNumberValidationGetCodeRM) {
                if (mobNumberValidationGetCodeRM != null) {
                    MobNumberGetCodeRespose mobNumberGetCodeRespose = mobNumberValidationGetCodeRM.result;
                    if (mobNumberGetCodeRespose != null) {
                        if (mobNumberGetCodeRespose.isvalid) {
                            if (mobNumberGetCodeRespose.mobileverified) {
                                if (NumberVerificationInteractor.this.numberVerificationListener != null) {
                                    NumberVerificationInteractor.this.numberVerificationListener.onMobileNumberVerified(true, NumberVerificationInteractor.this.mobileNumber, NumberVerificationInteractor.this.verificationOption, "", true, 30);
                                }
                            } else if (NumberVerificationInteractor.this.numberVerificationListener != null) {
                                NumberVerificationInteractor.this.numberVerificationListener.onMobileNumberVerified(false, NumberVerificationInteractor.this.mobileNumber, NumberVerificationInteractor.this.verificationOption, mobNumberValidationGetCodeRM.result.displaymessage, false, 30);
                            }
                        } else if (NumberVerificationInteractor.this.numberVerificationListener != null) {
                            NumberVerificationInteractor.this.numberVerificationListener.onMobileNumberInCorrectGetCode(false, NumberVerificationInteractor.this.mobileNumber, NumberVerificationInteractor.this.verificationOption, mobNumberValidationGetCodeRM.result.displaymessage, false);
                        }
                    } else if (NumberVerificationInteractor.this.verificationOption == 1) {
                        NumberVerificationInteractor.this.numberVerificationListener.onValidationErrorHandler(mobNumberValidationGetCodeRM.result.displaymessage, -8);
                    } else {
                        NumberVerificationInteractor.this.numberVerificationListener.onValidationErrorHandler(mobNumberValidationGetCodeRM.result.displaymessage, -6);
                    }
                } else {
                    NumberVerificationInteractor.this.numberVerificationListener.onValidationErrorHandler(mobNumberValidationGetCodeRM.result.displaymessage, -6);
                }
            }
        };
    }

    private Response.Listener<MobNumberCheckRM> onMobileCheck() {
        return new Response.Listener<MobNumberCheckRM>() {
            public void onResponse(MobNumberCheckRM mobNumberCheckRM) {
                if (mobNumberCheckRM != null) {
                    CheckResponse checkResponse = mobNumberCheckRM.result;
                    if (checkResponse != null) {
                        if (!TalabatUtils.isNullOrEmpty(checkResponse.mobilenumber)) {
                            NumberVerificationInteractor.this.mobileNumber = mobNumberCheckRM.result.mobilenumber;
                        }
                        CheckResponse checkResponse2 = mobNumberCheckRM.result;
                        if (checkResponse2.isvalid) {
                            if (checkResponse2.mobileverified) {
                                if (NumberVerificationInteractor.this.numberVerificationListener != null) {
                                    NumberVerificationInteractor.this.numberVerificationListener.onMobileCheckVerified(true, NumberVerificationInteractor.this.mobileNumber, -1, "", true);
                                }
                            } else if (NumberVerificationInteractor.this.numberVerificationListener == null) {
                            } else {
                                if (NumberVerificationInteractor.this.option == -3) {
                                    String str = "";
                                    String str2 = !TalabatUtils.isNullOrEmpty(mobNumberCheckRM.result.smstoken) ? mobNumberCheckRM.result.smstoken : str;
                                    if (!TalabatUtils.isNullOrEmpty(mobNumberCheckRM.result.emobile)) {
                                        str = mobNumberCheckRM.result.emobile;
                                    }
                                    NumberVerificationInteractor.this.numberVerificationListener.updateMobielNumbeVerifcationFailed(NumberVerificationInteractor.this.mobileNumber, -1, mobNumberCheckRM.result.displaymessage, str2, str);
                                    return;
                                }
                                NumberVerificationInteractor.this.numberVerificationListener.onMobileCheckVerified(false, NumberVerificationInteractor.this.mobileNumber, -1, mobNumberCheckRM.result.displaymessage, false);
                            }
                        } else if (NumberVerificationInteractor.this.option == -3) {
                            NumberVerificationInteractor.this.numberVerificationListener.onValidationErrorHandler(mobNumberCheckRM.result.displaymessage, -4);
                        } else {
                            NumberVerificationInteractor.this.numberVerificationListener.onValidationErrorHandler(mobNumberCheckRM.result.displaymessage, -5);
                        }
                    } else {
                        NumberVerificationInteractor.this.numberVerificationListener.onValidationErrorHandler(mobNumberCheckRM.result.displaymessage, -5);
                    }
                }
            }
        };
    }

    private Response.Listener<MobNumberUpdateRM> onUpdateMobileNumber() {
        return new Response.Listener<MobNumberUpdateRM>() {
            public void onResponse(MobNumberUpdateRM mobNumberUpdateRM) {
                EditResponse editResponse;
                if (mobNumberUpdateRM != null && (editResponse = mobNumberUpdateRM.result) != null) {
                    if (!TalabatUtils.isNullOrEmpty(editResponse.mobilenumber)) {
                        NumberVerificationInteractor.this.mobileNumber = mobNumberUpdateRM.result.mobilenumber;
                    }
                    if (mobNumberUpdateRM.result.isvalid) {
                        if (NumberVerificationInteractor.this.numberVerificationListener != null) {
                            NumberVerificationInteractor.this.numberVerificationListener.onNumberUpdated();
                        }
                        if (mobNumberUpdateRM.result.mobileverified) {
                            if (NumberVerificationInteractor.this.numberVerificationListener != null) {
                                NumberVerificationInteractor.this.numberVerificationListener.updateMobielNumbeVerifcationSucess(NumberVerificationInteractor.this.mobileNumber, -1, NumberVerificationInteractor.this.addressId, true);
                            }
                        } else if (NumberVerificationInteractor.this.numberVerificationListener != null) {
                            String str = "";
                            String str2 = !TalabatUtils.isNullOrEmpty(mobNumberUpdateRM.result.smstoken) ? mobNumberUpdateRM.result.smstoken : str;
                            if (!TalabatUtils.isNullOrEmpty(mobNumberUpdateRM.result.emobile)) {
                                str = mobNumberUpdateRM.result.emobile;
                            }
                            NumberVerificationInteractor.this.numberVerificationListener.updateMobielNumbeVerifcationFailed(NumberVerificationInteractor.this.mobileNumber, -1, mobNumberUpdateRM.result.displaymessage, str2, str);
                        }
                    } else if (NumberVerificationInteractor.this.numberVerificationListener != null) {
                        NumberVerificationInteractor.this.numberVerificationListener.onValidationErrorHandler(mobNumberUpdateRM.result.displaymessage, -4);
                    }
                }
            }
        };
    }

    private Response.Listener<MobNumberVerifyRM> onVerify() {
        return new Response.Listener<MobNumberVerifyRM>() {
            public void onResponse(MobNumberVerifyRM mobNumberVerifyRM) {
                if (mobNumberVerifyRM != null) {
                    MobNumberGetCodeRespose mobNumberGetCodeRespose = mobNumberVerifyRM.result;
                    if (mobNumberGetCodeRespose == null) {
                        NumberVerificationInteractor.this.numberVerificationListener.onValidationErrorHandler(mobNumberVerifyRM.result.displaymessage, -7);
                    } else if (mobNumberGetCodeRespose.isvalid) {
                        if (!mobNumberGetCodeRespose.mobileverified) {
                            NumberVerificationInteractor.this.numberVerificationListener.onMobileNumberVerifiedWithCode(false, NumberVerificationInteractor.this.mobileNumber, -2, "", false, false);
                        } else if (NumberVerificationInteractor.this.numberVerificationListener != null) {
                            NumberVerificationInteractor.this.numberVerificationListener.onMobileNumberVerifiedWithCode(true, NumberVerificationInteractor.this.mobileNumber, -1, "", false, true);
                        }
                    } else if (NumberVerificationInteractor.this.numberVerificationListener != null) {
                        NumberVerificationInteractor.this.numberVerificationListener.onMobileNumberVerifiedWithCode(false, NumberVerificationInteractor.this.mobileNumber, -2, mobNumberVerifyRM.result.displaymessage, false, false);
                    }
                }
            }
        };
    }

    public void VerifyOptiongetCodeForMobileNumber(GetCodeRequest getCodeRequest) {
        String str;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        this.mobileNumber = getCodeRequest.mobile;
        this.verificationOption = getCodeRequest.verifyoption;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) getCodeRequest);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) getCodeRequest);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.VERIFY_OPTION).setClazz(MobNumberValidationGetCodeRM.class).setRequestBody(jSONObject).setListener(onGetCodeVerifyOption()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void mobileCheck(CheckRequest checkRequest, int i11, String str, String str2) {
        String str3;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        this.mobileNumber = checkRequest.mobile;
        this.option = i11;
        if (!(gson instanceof Gson)) {
            str3 = gson.toJson((Object) checkRequest);
        } else {
            str3 = GsonInstrumentation.toJson(gson, (Object) checkRequest);
        }
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.CHECK_NUMBER).setClazz(MobNumberCheckRM.class).setRequestBody(jSONObject).setListener(onMobileCheck()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if ((volleyError instanceof ServerError) && NumberVerificationInteractor.this.numberVerificationListener != null) {
                    NumberVerificationInteractor.this.numberVerificationListener.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && NumberVerificationInteractor.this.numberVerificationListener != null) {
                    NumberVerificationInteractor.this.numberVerificationListener.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && NumberVerificationInteractor.this.numberVerificationListener != null) {
                    NumberVerificationInteractor.this.numberVerificationListener.onDataError();
                }
            }
        };
    }

    public void unregister() {
        this.numberVerificationListener = null;
    }

    public void updateMobileNumber(EditRequest editRequest) {
        String str;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        this.mobileNumber = editRequest.mobile;
        this.addressId = editRequest.f474id;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) editRequest);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) editRequest);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.UPDATE_NUMBER).setClazz(MobNumberUpdateRM.class).setRequestBody(jSONObject).setListener(onUpdateMobileNumber()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void verifyMobileNumberWithCode(MobileNumberVerifyRequest mobileNumberVerifyRequest) {
        String str;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        this.mobileNumber = mobileNumberVerifyRequest.mobile;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) mobileNumberVerifyRequest);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) mobileNumberVerifyRequest);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        TalabatVolley.addToRequestQueue(new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.MOBILENUMBERVERIFY).setClazz(MobNumberVerifyRM.class).setRequestBody(jSONObject).setListener(onVerify()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }
}
