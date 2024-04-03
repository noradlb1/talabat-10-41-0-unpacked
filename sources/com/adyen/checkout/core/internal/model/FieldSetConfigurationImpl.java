package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.model.FieldSetConfiguration;
import org.json.JSONException;
import org.json.JSONObject;

public final class FieldSetConfigurationImpl extends JsonObject implements FieldSetConfiguration {
    @NonNull
    public static final Parcelable.Creator<FieldSetConfigurationImpl> CREATOR = new JsonObject.DefaultCreator(FieldSetConfigurationImpl.class);
    private static final String FIELD_VISIBILITY_KEY = "fieldVisibility";
    private FieldSetConfiguration.FieldVisibility mFieldVisibility = ((FieldSetConfiguration.FieldVisibility) d(FIELD_VISIBILITY_KEY, FieldSetConfiguration.FieldVisibility.class));

    private FieldSetConfigurationImpl(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FieldSetConfigurationImpl.class != obj.getClass()) {
            return false;
        }
        if (this.mFieldVisibility == ((FieldSetConfigurationImpl) obj).mFieldVisibility) {
            return true;
        }
        return false;
    }

    @NonNull
    public FieldSetConfiguration.FieldVisibility getFieldVisibility() {
        return this.mFieldVisibility;
    }

    public int hashCode() {
        FieldSetConfiguration.FieldVisibility fieldVisibility = this.mFieldVisibility;
        if (fieldVisibility != null) {
            return fieldVisibility.hashCode();
        }
        return 0;
    }
}
