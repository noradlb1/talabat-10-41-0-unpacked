package com.talabat.helpers;

import JsonModels.parser.UniversalGson;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import datamodels.LoginRM;
import datamodels.RegistrationRM;
import datamodels.Token;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.perseus.TalabatPerseus;

@Instrumented
public class TalabatTokenRequest extends Request<Token> {
    private static final int BRAND = 1;
    public static final int FACEBOOK = 1;
    public static final int GOOGLE = 2;
    private static final String JSON_KEY_ADJUST_ID = "AdjustId";
    private static final String JSON_KEY_ADVERTISING_ID = "AdvertisingId";
    private static final String JSON_KEY_COUNTRY_ID = "countryId";
    private static final String JSON_KEY_MOBILE_COUNTRY_CODE = "mobileCountryCode";
    private static final String JSON_KEY_OTP_CODE = "otp";
    private static final String JSON_KEY_REGISTRATION_TYPE = "registrationType";
    private static final String JSON_KEY_USER_NAME = "UserName";
    public static final int NORMAL = 0;
    private final String appVersion;
    private final Gson gson;
    private final Response.Listener<Token> listener;
    private final LoginRM loginModel;
    private final RegistrationRM registration;
    private final int registrationType;

    public static class Builder {
        private String appVersion = null;
        private Response.ErrorListener errorListener = null;
        private Response.Listener<Token> listener;
        private LoginRM loginModel;
        private int method = 0;
        private RegistrationRM registration;
        private int registrationType;
        private String url = null;

        public TalabatTokenRequest build() {
            return new TalabatTokenRequest(this.method, this.url, this.loginModel, this.registration, this.registrationType, this.listener, this.errorListener, this.appVersion);
        }

        public Builder setAppVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public Builder setErrorListener(Response.ErrorListener errorListener2) {
            this.errorListener = errorListener2;
            return this;
        }

        public Builder setListener(Response.Listener<Token> listener2) {
            this.listener = listener2;
            return this;
        }

        public Builder setLoginModel(LoginRM loginRM) {
            this.loginModel = loginRM;
            return this;
        }

        public Builder setMethod(int i11) {
            this.method = i11;
            return this;
        }

        public Builder setRegistration(RegistrationRM registrationRM) {
            this.registration = registrationRM;
            return this;
        }

        public Builder setRegistrationType(int i11) {
            this.registrationType = i11;
            return this;
        }

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }
    }

    private TalabatTokenRequest(int i11, String str, LoginRM loginRM, RegistrationRM registrationRM, int i12, Response.Listener<Token> listener2, Response.ErrorListener errorListener, String str2) {
        super(i11, str, errorListener);
        this.gson = UniversalGson.INSTANCE.gson;
        this.loginModel = loginRM;
        this.registration = registrationRM;
        this.registrationType = i12;
        this.listener = listener2;
        this.appVersion = str2;
    }

    private void putAdjustAndAdvertisementIdTo(@NotNull Map<String, String> map, @Nullable String str, @Nullable String str2) {
        if (str == null) {
            str = "";
        }
        map.put(JSON_KEY_ADJUST_ID, str);
        if (str2 == null) {
            str2 = "";
        }
        map.put(JSON_KEY_ADVERTISING_ID, str2);
    }

    public String getBodyContentType() {
        return "application/x-www-from-urlencoded";
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.ACCEPT_LANGUAGE, GlobalDataModel.SelectedLanguage);
        hashMap.put("X-Device-Source", "6");
        TalabatPerseus.Companion companion = TalabatPerseus.Companion;
        hashMap.put("X-PerseusSessionId", companion.getNetworkHeaderSessionId());
        hashMap.put("X-PerseusClientId", companion.getNetworkHeaderClientId());
        hashMap.put("BrandType", "1");
        hashMap.put("AppBrand", "1");
        hashMap.put("X-Device-Version", this.appVersion);
        if (this.registration != null) {
            int i11 = this.registrationType;
            if (i11 == 1 || i11 == 2) {
                hashMap.put("SocialAuth", "1");
            } else {
                hashMap.put("IsReg", "true");
            }
        }
        return hashMap;
    }

    public Map<String, String> getParams() throws AuthFailureError {
        HashMap hashMap = new HashMap();
        LoginRM loginRM = this.loginModel;
        if (loginRM != null) {
            if (!TalabatUtils.isNullOrEmpty(loginRM.UserName)) {
                hashMap.put(JSON_KEY_USER_NAME, this.loginModel.UserName);
            }
            String str = this.loginModel.Password;
            if (str == null) {
                str = "";
            }
            hashMap.put("Password", str);
            hashMap.put("grant_type", this.loginModel.GrantType);
            if (!TalabatUtils.isNullOrEmpty(this.loginModel.UDID)) {
                hashMap.put("UDID", this.loginModel.UDID);
            }
            hashMap.put(JSON_KEY_MOBILE_COUNTRY_CODE, "" + this.loginModel.mobileCountryCode);
            hashMap.put(JSON_KEY_REGISTRATION_TYPE, "" + this.loginModel.registrationType.getValue());
            String str2 = this.loginModel.otp;
            if (str2 != null) {
                hashMap.put(JSON_KEY_OTP_CODE, str2);
            }
            LoginRM loginRM2 = this.loginModel;
            putAdjustAndAdvertisementIdTo(hashMap, loginRM2.adjustId, loginRM2.advertisingId);
        } else {
            if (this.registrationType == 0) {
                hashMap.put("grant_type", "password");
                RegistrationRM registrationRM = this.registration;
                String str3 = registrationRM.Email;
                if (str3 != null) {
                    hashMap.put(JSON_KEY_USER_NAME, str3);
                } else {
                    String str4 = registrationRM.mobileNumber;
                    if (str4 != null && !str4.isEmpty()) {
                        hashMap.put(JSON_KEY_USER_NAME, this.registration.mobileNumber);
                    }
                }
                hashMap.put("Password", this.registration.Password);
                hashMap.put("ConfirmPassword", this.registration.Password);
                hashMap.put("FirstName", this.registration.FirstName);
                String str5 = this.registration.LastName;
                if (str5 == null) {
                    str5 = "";
                }
                hashMap.put("LastName", str5);
                hashMap.put("Region", "" + this.registration.AreaId);
                hashMap.put("BirthDate", this.registration.BirthDate);
                String str6 = this.registration.mobileNumber;
                if (str6 == null) {
                    str6 = "";
                }
                hashMap.put("mobileNumber", str6);
                hashMap.put(JSON_KEY_MOBILE_COUNTRY_CODE, "" + this.registration.mobileCountryCode);
                String str7 = this.registration.otp;
                if (str7 == null) {
                    str7 = "";
                }
                hashMap.put(JSON_KEY_OTP_CODE, str7);
                hashMap.put(JSON_KEY_REGISTRATION_TYPE, "" + this.registration.registrationType.getValue());
                if (this.registration.Gender) {
                    hashMap.put("IsMale", "true");
                } else {
                    hashMap.put("IsMale", "false");
                }
                if (this.registration.subscribedToNewsletter) {
                    hashMap.put("IsSubscribeNews", "true");
                } else {
                    hashMap.put("IsSubscribeNews", "false");
                }
                if (this.registration.subscribedToSMS) {
                    hashMap.put("IsSubscribeSMS", "true");
                } else {
                    hashMap.put("IsSubscribeSMS", "false");
                }
                String str8 = this.registration.Email;
                if (str8 != null) {
                    hashMap.put("Email", str8);
                }
            } else {
                String str9 = this.registration.Email;
                if (str9 != null) {
                    hashMap.put("Email", str9);
                }
                int i11 = this.registrationType;
                if (i11 == 1) {
                    hashMap.put("LoginProvider", "Facebook");
                } else if (i11 == 2) {
                    hashMap.put("LoginProvider", "Google");
                }
                hashMap.put("ProviderKey", this.registration.ProviderKey);
                hashMap.put(LegacyTokenLocalDataSourceImpl.KEY, this.registration.token);
                hashMap.put("FirstName", this.registration.FirstName);
                String str10 = this.registration.LastName;
                if (str10 == null) {
                    str10 = "";
                }
                hashMap.put("LastName", str10);
                hashMap.put("grant_type", "password");
                hashMap.put("BirthDate", this.registration.BirthDate);
                String str11 = this.registration.facebookUserId;
                if (str11 == null) {
                    str11 = "";
                }
                hashMap.put("providerId", str11);
            }
            String str12 = this.registration.UDID;
            if (str12 != null && !TalabatUtils.isNullOrEmpty(str12)) {
                hashMap.put("UDID", this.registration.UDID);
            }
            RegistrationRM registrationRM2 = this.registration;
            putAdjustAndAdvertisementIdTo(hashMap, registrationRM2.adjustId, registrationRM2.advertisingId);
        }
        hashMap.put("countryId", "" + GlobalDataModel.SelectedCountryId);
        return hashMap;
    }

    public Response parseNetworkResponse(NetworkResponse networkResponse) {
        Object obj;
        try {
            String str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
            Gson gson2 = this.gson;
            Class cls = Token.class;
            if (!(gson2 instanceof Gson)) {
                obj = gson2.fromJson(str, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson2, str, cls);
            }
            return Response.success((Token) obj, HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e11) {
            return Response.error(new ParseError((Throwable) e11));
        } catch (JsonSyntaxException e12) {
            return Response.error(new ParseError((Throwable) e12));
        }
    }

    public void deliverResponse(Token token) {
        this.listener.onResponse(token);
    }
}
