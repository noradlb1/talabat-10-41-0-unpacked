package com.adyen.checkout.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public final class ChallengeDetails extends PaymentMethodDetails {
    public static final Parcelable.Creator<ChallengeDetails> CREATOR = new Parcelable.Creator<ChallengeDetails>() {
        public ChallengeDetails createFromParcel(Parcel parcel) {
            return new ChallengeDetails(parcel);
        }

        public ChallengeDetails[] newArray(int i11) {
            return new ChallengeDetails[i11];
        }
    };
    public static final String KEY_THREE_DS_CHALLENGE_RESULT = "threeds2.challengeResult";
    private final String mChallengeResult;

    public ChallengeDetails(@NonNull String str) {
        this.mChallengeResult = str;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_THREE_DS_CHALLENGE_RESULT, (Object) this.mChallengeResult);
        return jSONObject;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.mChallengeResult);
    }

    public ChallengeDetails(@NonNull Parcel parcel) {
        super(parcel);
        this.mChallengeResult = parcel.readString();
    }
}
