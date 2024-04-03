package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.model.Address;
import com.adyen.checkout.core.model.KlarnaSsnLookupResponse;
import com.adyen.checkout.core.model.Name;

public class AddressAndName extends JsonObject implements KlarnaSsnLookupResponse {
    @NonNull
    public static final Parcelable.Creator<AddressAndName> CREATOR = new JsonObject.DefaultCreator(AddressAndName.class);
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_NAME = "name";
    private Address mAddress;
    private Name mName;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AddressAndName addressAndName = (AddressAndName) obj;
        Address address = this.mAddress;
        if (address == null ? addressAndName.mAddress != null : !address.equals(addressAndName.mAddress)) {
            return false;
        }
        Name name2 = this.mName;
        Name name3 = addressAndName.mName;
        if (name2 != null) {
            return name2.equals(name3);
        }
        if (name3 == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public Address getAddress() {
        return this.mAddress;
    }

    @NonNull
    public Name getName() {
        return this.mName;
    }

    public int hashCode() {
        int i11;
        Address address = this.mAddress;
        int i12 = 0;
        if (address != null) {
            i11 = address.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = i11 * 31;
        Name name2 = this.mName;
        if (name2 != null) {
            i12 = name2.hashCode();
        }
        return i13 + i12;
    }
}
