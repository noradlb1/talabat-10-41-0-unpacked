package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.model.Name;

public class NameImpl extends JsonObject implements Name {
    @NonNull
    public static final Parcelable.Creator<NameImpl> CREATOR = new JsonObject.DefaultCreator(NameImpl.class);
    private static final String KEY_FIRST_NAME = "firstName";
    private static final String KEY_LAST_NAME = "lastName";
    private String mFirstName;
    private String mLastName;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NameImpl nameImpl = (NameImpl) obj;
        String str = this.mFirstName;
        if (str == null ? nameImpl.mFirstName != null : !str.equals(nameImpl.mFirstName)) {
            return false;
        }
        String str2 = this.mLastName;
        String str3 = nameImpl.mLastName;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getFirstName() {
        return this.mFirstName;
    }

    @NonNull
    public String getLastName() {
        return this.mLastName;
    }

    public int hashCode() {
        int i11;
        String str = this.mFirstName;
        int i12 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = i11 * 31;
        String str2 = this.mLastName;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return i13 + i12;
    }
}
