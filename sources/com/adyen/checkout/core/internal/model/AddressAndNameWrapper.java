package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;

public class AddressAndNameWrapper extends JsonObject {
    @NonNull
    public static final Parcelable.Creator<AddressAndNameWrapper> CREATOR = new JsonObject.DefaultCreator(AddressAndNameWrapper.class);
    private static final String KEY_ADDRESS_NAME = "AddressName";
    private AddressAndName mAddressAndName;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AddressAndName addressAndName = this.mAddressAndName;
        AddressAndName addressAndName2 = ((AddressAndNameWrapper) obj).mAddressAndName;
        if (addressAndName != null) {
            return addressAndName.equals(addressAndName2);
        }
        if (addressAndName2 == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public AddressAndName getAddressAndName() {
        return this.mAddressAndName;
    }

    public int hashCode() {
        AddressAndName addressAndName = this.mAddressAndName;
        if (addressAndName != null) {
            return addressAndName.hashCode();
        }
        return 0;
    }
}
