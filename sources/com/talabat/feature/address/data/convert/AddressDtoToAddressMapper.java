package com.talabat.feature.address.data.convert;

import com.talabat.domain.address.Address;
import com.talabat.feature.address.data.AddressDto;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/address/data/convert/AddressDtoToAddressMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/address/data/AddressDto;", "Lcom/talabat/domain/address/Address;", "()V", "apply", "source", "com_talabat_feature_address_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddressDtoToAddressMapper implements ModelMapper<AddressDto, Address> {
    @NotNull
    public Address apply(@NotNull AddressDto addressDto) {
        Intrinsics.checkNotNullParameter(addressDto, "source");
        Address address = new Address(addressDto.getId(), addressDto.getAreaId(), addressDto.getAreaName(), addressDto.getBlock(), addressDto.getBuildingNo(), addressDto.getCityId(), addressDto.getCountyId(), addressDto.getCountryName(), addressDto.getExtraDirections(), addressDto.getFloor(), addressDto.getGeoAddressMsg(), addressDto.getGeoAddressTitle(), addressDto.getGrl(), (String) null, addressDto.isAreaSplit(), addressDto.isDeliverable(), addressDto.isOldAddreses(), addressDto.getJudda(), addressDto.getLatitude(), addressDto.getLongitude(), addressDto.getMobileNumber(), addressDto.getMobilNumberCountryCode(), addressDto.getPhoneNumber(), addressDto.getProfileName(), addressDto.getStreet(), addressDto.getSuite(), addressDto.getType(), 8192, (DefaultConstructorMarker) null);
        String grlid = addressDto.getGrlid();
        if (grlid == null) {
            grlid = "";
        }
        address.grlid = grlid;
        return address;
    }
}
