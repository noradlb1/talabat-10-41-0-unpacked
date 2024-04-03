package com.talabat.sign_in_with_facebook;

import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

class FacebookLoginResultDelegate implements FacebookCallback<LoginResult>, PluginRegistry.ActivityResultListener {
    private final CallbackManager callbackManager;
    private MethodChannel.Result pendingResult;

    public FacebookLoginResultDelegate(CallbackManager callbackManager2) {
        this.callbackManager = callbackManager2;
    }

    public void a(String str, String str2) {
        MethodChannel.Result result = this.pendingResult;
        if (result != null) {
            result.error(str, str2, (Object) null);
            this.pendingResult = null;
        }
    }

    public void b(Object obj) {
        MethodChannel.Result result = this.pendingResult;
        if (result != null) {
            result.success(obj);
            this.pendingResult = null;
        }
    }

    public boolean c(MethodChannel.Result result) {
        if (this.pendingResult != null) {
            result.error("OPERATION_IN_PROGRESS", "The method login was called while another Facebook operation was in progress.", (Object) null);
            return false;
        }
        this.pendingResult = result;
        return true;
    }

    public boolean onActivityResult(int i11, int i12, Intent intent) {
        return this.callbackManager.onActivityResult(i11, i12, intent);
    }

    public void onCancel() {
        a("CANCELLED", "User has cancelled login with facebook");
    }

    public void onError(FacebookException facebookException) {
        a("FAILED", facebookException.getMessage());
    }

    public void onSuccess(LoginResult loginResult) {
        b(FacebookAuth.a(loginResult.getAccessToken()));
    }
}
