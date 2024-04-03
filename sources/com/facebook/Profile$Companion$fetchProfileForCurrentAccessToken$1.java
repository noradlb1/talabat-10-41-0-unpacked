package com.facebook;

import android.net.Uri;
import android.util.Log;
import com.facebook.internal.Utility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/facebook/Profile$Companion$fetchProfileForCurrentAccessToken$1", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "onFailure", "", "error", "Lcom/facebook/FacebookException;", "onSuccess", "userInfo", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Profile$Companion$fetchProfileForCurrentAccessToken$1 implements Utility.GraphMeRequestWithCacheCallback {
    public void onFailure(@Nullable FacebookException facebookException) {
        Log.e(Profile.TAG, Intrinsics.stringPlus("Got unexpected exception: ", facebookException));
    }

    public void onSuccess(@Nullable JSONObject jSONObject) {
        String str;
        Uri uri;
        Uri uri2 = null;
        if (jSONObject == null) {
            str = null;
        } else {
            str = jSONObject.optString("id");
        }
        if (str == null) {
            Log.w(Profile.TAG, "No user ID returned on Me request");
            return;
        }
        String optString = jSONObject.optString("link");
        String optString2 = jSONObject.optString("profile_picture", (String) null);
        String optString3 = jSONObject.optString("first_name");
        String optString4 = jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_MIDDLE_NAME);
        String optString5 = jSONObject.optString("last_name");
        String optString6 = jSONObject.optString("name");
        if (optString != null) {
            uri = Uri.parse(optString);
        } else {
            uri = null;
        }
        if (optString2 != null) {
            uri2 = Uri.parse(optString2);
        }
        Profile.Companion.setCurrentProfile(new Profile(str, optString3, optString4, optString5, optString6, uri, uri2));
    }
}
