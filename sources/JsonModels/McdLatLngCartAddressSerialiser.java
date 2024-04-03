package JsonModels;

import com.talabat.domain.address.Address;

public class McdLatLngCartAddressSerialiser {
    private Address mcdAddress;
    private int selectedBranchId;

    public McdLatLngCartAddressSerialiser(Address address, int i11) {
        this.mcdAddress = address;
        this.selectedBranchId = i11;
    }

    public int getMcdCartBranchId() {
        int i11 = this.selectedBranchId;
        if (i11 > 0) {
            return i11;
        }
        return 0;
    }

    public Address getMcdMapAddress() {
        return this.mcdAddress;
    }
}
