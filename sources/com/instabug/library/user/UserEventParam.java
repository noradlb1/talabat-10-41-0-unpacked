package com.instabug.library.user;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;

public class UserEventParam {
    @Nullable
    private String key;
    @Nullable
    private String value;

    @SuppressLint({"NP_METHOD_PARAMETER_TIGHTENS_ANNOTATION"})
    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof UserEventParam)) {
            return false;
        }
        UserEventParam userEventParam = (UserEventParam) obj;
        if (!String.valueOf(userEventParam.getKey()).equals(String.valueOf(getKey())) || !String.valueOf(userEventParam.getValue()).equals(String.valueOf(getValue()))) {
            return false;
        }
        return true;
    }

    @Nullable
    public String getKey() {
        return this.key;
    }

    @Nullable
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        if (getKey() == null || getValue() == null) {
            return -1;
        }
        return (getKey() + ": " + getValue()).hashCode();
    }

    public UserEventParam setKey(String str) {
        this.key = str;
        return this;
    }

    public UserEventParam setValue(String str) {
        this.value = str;
        return this;
    }
}
