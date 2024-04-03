package datamodels;

import com.talabat.domain.address.Address;

public class QuickOrderInfo {
    public Address address;
    public String firstName;
    public String lastName;

    public QuickOrderInfo copyForSaving() {
        QuickOrderInfo quickOrderInfo = new QuickOrderInfo();
        Address address2 = this.address;
        Address address3 = address2;
        String str = address2.f58343id;
        QuickOrderInfo quickOrderInfo2 = quickOrderInfo;
        Address address4 = address2;
        Address address5 = address3;
        String str2 = str;
        Address copy = address5.copy(str2, address2.areaId, address2.areaName, address2.block, address2.buildingNo, address2.cityId, address2.countyId, address2.countryName, address2.extraDirections, address2.floor, address2.geoAddressMsg, address2.geoAddressTitle, address2.grl, address4.grlid, address4.isAreaSplit, address4.isDeliverable, address4.isOldAddreses, address4.judda, address4.latitude, address4.longitude, address4.mobileNumber, address4.mobilNumberCountryCode, address4.phoneNumber, address4.profileName, address4.street, address4.suite, address4.type);
        QuickOrderInfo quickOrderInfo3 = quickOrderInfo2;
        quickOrderInfo3.address = copy;
        copy.grl = "";
        quickOrderInfo3.firstName = this.firstName;
        quickOrderInfo3.lastName = this.lastName;
        return quickOrderInfo3;
    }
}
