package com.talabat.feature.address.data.local;

import com.talabat.domain.address.Address;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/address/data/local/CustomerAddressLocalDataModel;", "", "result", "", "Lcom/talabat/domain/address/Address;", "(Ljava/util/List;)V", "getResult", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_address_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomerAddressLocalDataModel {
    @Nullable
    private final List<Address> result;

    public CustomerAddressLocalDataModel(@Nullable List<Address> list) {
        this.result = list;
    }

    public static /* synthetic */ CustomerAddressLocalDataModel copy$default(CustomerAddressLocalDataModel customerAddressLocalDataModel, List<Address> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = customerAddressLocalDataModel.result;
        }
        return customerAddressLocalDataModel.copy(list);
    }

    @Nullable
    public final List<Address> component1() {
        return this.result;
    }

    @NotNull
    public final CustomerAddressLocalDataModel copy(@Nullable List<Address> list) {
        return new CustomerAddressLocalDataModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CustomerAddressLocalDataModel) && Intrinsics.areEqual((Object) this.result, (Object) ((CustomerAddressLocalDataModel) obj).result);
    }

    @Nullable
    public final List<Address> getResult() {
        return this.result;
    }

    public int hashCode() {
        List<Address> list = this.result;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        List<Address> list = this.result;
        return "CustomerAddressLocalDataModel(result=" + list + ")";
    }
}
