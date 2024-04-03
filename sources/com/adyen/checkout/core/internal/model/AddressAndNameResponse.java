package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import java.util.List;

public class AddressAndNameResponse extends JsonObject {
    @NonNull
    public static final Parcelable.Creator<AddressAndNameResponse> CREATOR = new JsonObject.DefaultCreator(AddressAndNameResponse.class);
    private static final String KEY_ADDRESS_NAMES = "addressNames";
    private List<AddressAndNameWrapper> mAddressAndNameWrappers;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        List<AddressAndNameWrapper> list = this.mAddressAndNameWrappers;
        List<AddressAndNameWrapper> list2 = ((AddressAndNameResponse) obj).mAddressAndNameWrappers;
        if (list != null) {
            return list.equals(list2);
        }
        if (list2 == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public List<AddressAndNameWrapper> getAddressAndNameWrappers() {
        return this.mAddressAndNameWrappers;
    }

    public int hashCode() {
        List<AddressAndNameWrapper> list = this.mAddressAndNameWrappers;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }
}
