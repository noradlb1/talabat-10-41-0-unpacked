package JsonModels.Request;

import com.talabat.domain.address.Address;

public class McdBranchRequest {
    public Address address;
    public int restid;

    public McdBranchRequest(Address address2, int i11) {
        this.address = address2;
        this.restid = i11;
    }
}
