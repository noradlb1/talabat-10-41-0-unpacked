package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.autofill.HintConstants;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.model.StoredDetails;
import org.json.JSONException;
import org.json.JSONObject;

public final class StoredDetailsImpl extends JsonObject implements StoredDetails {
    @NonNull
    public static final Parcelable.Creator<StoredDetailsImpl> CREATOR = new JsonObject.DefaultCreator(StoredDetailsImpl.class);
    private CardImpl mCard = ((CardImpl) f("card", CardImpl.class));
    private String mEmailAddress;

    public StoredDetailsImpl(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mEmailAddress = jSONObject.optString(HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS, (String) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StoredDetailsImpl.class != obj.getClass()) {
            return false;
        }
        StoredDetailsImpl storedDetailsImpl = (StoredDetailsImpl) obj;
        CardImpl cardImpl = this.mCard;
        if (cardImpl == null ? storedDetailsImpl.mCard != null : !cardImpl.equals(storedDetailsImpl.mCard)) {
            return false;
        }
        String str = this.mEmailAddress;
        String str2 = storedDetailsImpl.mEmailAddress;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public String getEmailAddress() {
        return this.mEmailAddress;
    }

    public int hashCode() {
        int i11;
        CardImpl cardImpl = this.mCard;
        int i12 = 0;
        if (cardImpl != null) {
            i11 = cardImpl.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = i11 * 31;
        String str = this.mEmailAddress;
        if (str != null) {
            i12 = str.hashCode();
        }
        return i13 + i12;
    }

    @Nullable
    public CardImpl getCard() {
        return this.mCard;
    }
}
