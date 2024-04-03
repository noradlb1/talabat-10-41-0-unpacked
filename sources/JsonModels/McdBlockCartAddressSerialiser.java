package JsonModels;

import com.talabat.domain.address.Address;

public class McdBlockCartAddressSerialiser {
    private Address mcdBlockAddress;
    private String selectedBlock;
    private int selectedBranchId;

    public McdBlockCartAddressSerialiser(Address address, String str, int i11) {
        this.mcdBlockAddress = address;
        this.selectedBlock = str;
        this.selectedBranchId = i11;
    }

    public Address getMcdBlockMapAddress() {
        return this.mcdBlockAddress;
    }

    public int getMcdCartBranchId() {
        int i11 = this.selectedBranchId;
        if (i11 > 0) {
            return i11;
        }
        return 0;
    }

    public String selectedBlock() {
        return this.selectedBlock;
    }
}
