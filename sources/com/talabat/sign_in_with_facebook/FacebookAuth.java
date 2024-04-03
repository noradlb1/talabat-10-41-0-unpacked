package com.talabat.sign_in_with_facebook;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class FacebookAuth {

    /* renamed from: a  reason: collision with root package name */
    public FacebookLoginResultDelegate f61415a;
    private final LoginManager loginManager;

    public FacebookAuth() {
        LoginManager instance = LoginManager.getInstance();
        this.loginManager = instance;
        CallbackManager create = CallbackManager.Factory.create();
        FacebookLoginResultDelegate facebookLoginResultDelegate = new FacebookLoginResultDelegate(create);
        this.f61415a = facebookLoginResultDelegate;
        instance.registerCallback(create, facebookLoginResultDelegate);
    }

    public static HashMap<String, Object> a(AccessToken accessToken) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(AccessTokenKey.TOKEN.toString(), accessToken.getToken());
        hashMap.put(AccessTokenKey.USER_ID.toString(), accessToken.getUserId());
        hashMap.put(AccessTokenKey.EXPIRES.toString(), Long.valueOf(accessToken.getExpires().getTime()));
        hashMap.put(AccessTokenKey.APPLICATION_ID.toString(), accessToken.getApplicationId());
        hashMap.put(AccessTokenKey.LAST_REFRESH.toString(), Long.valueOf(accessToken.getLastRefresh().getTime()));
        hashMap.put(AccessTokenKey.IS_EXPIRED.toString(), Boolean.valueOf(accessToken.isExpired()));
        hashMap.put(AccessTokenKey.GRANTED_PERMISSIONS.toString(), new ArrayList(accessToken.getPermissions()));
        hashMap.put(AccessTokenKey.DECLINED_PERMISSIONS.toString(), new ArrayList(accessToken.getDeclinedPermissions()));
        hashMap.put(AccessTokenKey.DATA_ACCESS_EXPIRATION_TIME.toString(), Long.valueOf(accessToken.getDataAccessExpirationTime().getTime()));
        return hashMap;
    }

    public void b(MethodChannel.Result result) {
        boolean z11;
        if (AccessToken.getCurrentAccessToken() != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.loginManager.logOut();
        }
        result.success((Object) null);
    }

    public void c(Activity activity, List<String> list, MethodChannel.Result result) {
        boolean z11;
        if (AccessToken.getCurrentAccessToken() != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            try {
                this.loginManager.logOut();
            } catch (Exception e11) {
                result.error("FAILED", e11.getMessage(), (Object) null);
            }
        }
        if (this.f61415a.c(result)) {
            try {
                this.loginManager.logIn(activity, (Collection<String>) list);
            } catch (Exception e12) {
                result.error("FAILED", e12.getMessage(), (Object) null);
            }
        } else {
            result.error("FAILED", "No result returned", (Object) null);
        }
    }

    public void getUserData(String str, final MethodChannel.Result result) {
        GraphRequest newMeRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            public void onCompleted(JSONObject jSONObject, GraphResponse graphResponse) {
                String str;
                try {
                    MethodChannel.Result result = result;
                    if (!(jSONObject instanceof JSONObject)) {
                        str = jSONObject.toString();
                    } else {
                        str = JSONObjectInstrumentation.toString(jSONObject);
                    }
                    result.success(str);
                } catch (Exception e11) {
                    result.error("FAILED", e11.getMessage(), (Object) null);
                }
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString("fields", str);
        newMeRequest.setParameters(bundle);
        newMeRequest.executeAsync();
    }

    public void setLoginBehavior(String str) {
        LoginBehavior loginBehavior;
        try {
            loginBehavior = LoginBehavior.valueOf(str);
        } catch (IllegalArgumentException unused) {
            loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
        }
        this.loginManager.setLoginBehavior(loginBehavior);
    }
}
