package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.internal.ProvidedBy;
import com.adyen.checkout.core.model.Configuration;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.core.model.Item;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

public final class InputDetailImpl extends JsonObject implements InputDetail {
    @NonNull
    public static final Parcelable.Creator<InputDetailImpl> CREATOR = new JsonObject.DefaultCreator(InputDetailImpl.class);
    private static final String KEY_CONFIGURATION = "configuration";
    private static final String KEY_INPUT_DETAILS = "details";
    private static final String KEY_ITEMS = "items";
    private static final String KEY_KEY = "key";
    private static final String KEY_OPTIONAL = "optional";
    private static final String KEY_TYPE = "type";
    private static final String KEY_VALUE = "value";
    private List<InputDetailImpl> mChildInputDetails;
    private JSONObject mConfiguration;
    private final List<ItemImpl> mItems;
    private final String mKey;
    private final Boolean mOptional;
    private final InputDetail.Type mType = ((InputDetail.Type) d("type", InputDetail.Type.class));
    private final String mValue;

    private InputDetailImpl(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        Boolean bool;
        this.mKey = jSONObject.getString("key");
        if (jSONObject.has(KEY_OPTIONAL)) {
            bool = Boolean.valueOf(jSONObject.getBoolean(KEY_OPTIONAL));
        } else {
            bool = null;
        }
        this.mOptional = bool;
        this.mValue = jSONObject.optString("value", (String) null);
        this.mItems = g("items", ItemImpl.class);
        this.mConfiguration = jSONObject.optJSONObject(KEY_CONFIGURATION);
        this.mChildInputDetails = g(KEY_INPUT_DETAILS, InputDetailImpl.class);
    }

    @Nullable
    public static InputDetail findByKey(@Nullable List<InputDetail> list, @NonNull String str) {
        if (list == null) {
            return null;
        }
        for (InputDetail next : list) {
            if (str.equals(next.getKey())) {
                return next;
            }
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || InputDetailImpl.class != obj.getClass()) {
            return false;
        }
        InputDetailImpl inputDetailImpl = (InputDetailImpl) obj;
        String str = this.mKey;
        if (str == null ? inputDetailImpl.mKey != null : !str.equals(inputDetailImpl.mKey)) {
            return false;
        }
        if (this.mType != inputDetailImpl.mType) {
            return false;
        }
        Boolean bool = this.mOptional;
        if (bool == null ? inputDetailImpl.mOptional != null : !bool.equals(inputDetailImpl.mOptional)) {
            return false;
        }
        String str2 = this.mValue;
        if (str2 == null ? inputDetailImpl.mValue != null : !str2.equals(inputDetailImpl.mValue)) {
            return false;
        }
        List<ItemImpl> list = this.mItems;
        if (list == null ? inputDetailImpl.mItems != null : !list.equals(inputDetailImpl.mItems)) {
            return false;
        }
        JSONObject jSONObject = this.mConfiguration;
        if (jSONObject == null ? inputDetailImpl.mConfiguration != null : !jSONObject.equals(inputDetailImpl.mConfiguration)) {
            return false;
        }
        List<InputDetailImpl> list2 = this.mChildInputDetails;
        List<InputDetailImpl> list3 = inputDetailImpl.mChildInputDetails;
        if (list2 != null) {
            return list2.equals(list3);
        }
        if (list3 == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public List<InputDetail> getChildInputDetails() {
        if (this.mChildInputDetails != null) {
            return new ArrayList(this.mChildInputDetails);
        }
        return null;
    }

    @Nullable
    public <T extends Configuration> T getConfiguration(@NonNull Class<T> cls) throws CheckoutException {
        JSONObject jSONObject = this.mConfiguration;
        if (jSONObject != null) {
            return (Configuration) ProvidedBy.Util.parse(jSONObject, cls);
        }
        return null;
    }

    @Nullable
    public List<Item> getItems() {
        if (this.mItems != null) {
            return new ArrayList(this.mItems);
        }
        return null;
    }

    @NonNull
    public String getKey() {
        return this.mKey;
    }

    @NonNull
    public InputDetail.Type getType() {
        return this.mType;
    }

    @Nullable
    public String getValue() {
        return this.mValue;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        String str = this.mKey;
        int i17 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i18 = i11 * 31;
        InputDetail.Type type = this.mType;
        if (type != null) {
            i12 = type.hashCode();
        } else {
            i12 = 0;
        }
        int i19 = (i18 + i12) * 31;
        Boolean bool = this.mOptional;
        if (bool != null) {
            i13 = bool.hashCode();
        } else {
            i13 = 0;
        }
        int i21 = (i19 + i13) * 31;
        String str2 = this.mValue;
        if (str2 != null) {
            i14 = str2.hashCode();
        } else {
            i14 = 0;
        }
        int i22 = (i21 + i14) * 31;
        List<ItemImpl> list = this.mItems;
        if (list != null) {
            i15 = list.hashCode();
        } else {
            i15 = 0;
        }
        int i23 = (i22 + i15) * 31;
        JSONObject jSONObject = this.mConfiguration;
        if (jSONObject != null) {
            i16 = jSONObject.hashCode();
        } else {
            i16 = 0;
        }
        int i24 = (i23 + i16) * 31;
        List<InputDetailImpl> list2 = this.mChildInputDetails;
        if (list2 != null) {
            i17 = list2.hashCode();
        }
        return i24 + i17;
    }

    public boolean isOptional() {
        return Boolean.TRUE.equals(this.mOptional);
    }

    @NonNull
    public String toString() {
        return "InputDetail{Key='" + this.mKey + '\'' + ", Optional=" + this.mOptional + AbstractJsonLexerKt.END_OBJ;
    }
}
