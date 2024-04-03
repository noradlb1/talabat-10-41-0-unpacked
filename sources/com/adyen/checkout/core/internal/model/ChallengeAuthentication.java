package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.internal.ProvidedBy;
import com.adyen.checkout.core.model.Authentication;

@ProvidedBy(ChallengeAuthentication.class)
public final class ChallengeAuthentication extends JsonObject implements Authentication {
    public static final Parcelable.Creator<ChallengeAuthentication> CREATOR = new JsonObject.DefaultCreator(ChallengeAuthentication.class);
    private static final String KEY_THREE_DS_CHALLENGE_TOKEN = "threeds2.challengeToken";
    private final String mChallengeToken;

    @NonNull
    public String getChallengeToken() {
        return this.mChallengeToken;
    }
}
