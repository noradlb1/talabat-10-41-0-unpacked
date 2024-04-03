package library.talabat.mvp.address;

import com.talabat.domain.address.Address;

public class DistanceSortedAddress {
    public Address address;
    public double distance;

    public DistanceSortedAddress(double d11, Address address2) {
        this.distance = d11;
        this.address = address2;
    }
}
