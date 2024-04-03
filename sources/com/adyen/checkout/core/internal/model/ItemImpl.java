package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.model.Item;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

public final class ItemImpl extends JsonObject implements Item {
    @NonNull
    public static final Parcelable.Creator<ItemImpl> CREATOR = new JsonObject.DefaultCreator(ItemImpl.class);
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private final String mId;
    private final String mName;

    private ItemImpl(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mId = jSONObject.getString("id");
        this.mName = jSONObject.getString("name");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ItemImpl.class != obj.getClass()) {
            return false;
        }
        ItemImpl itemImpl = (ItemImpl) obj;
        String str = this.mId;
        if (str == null ? itemImpl.mId != null : !str.equals(itemImpl.mId)) {
            return false;
        }
        String str2 = this.mName;
        String str3 = itemImpl.mName;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    @NonNull
    public String getName() {
        return this.mName;
    }

    @NonNull
    public String getTxSubVariant() {
        return this.mId;
    }

    public int hashCode() {
        int i11;
        String str = this.mId;
        int i12 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = i11 * 31;
        String str2 = this.mName;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return i13 + i12;
    }

    @NonNull
    public String toString() {
        return "Item{Name='" + this.mName + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
