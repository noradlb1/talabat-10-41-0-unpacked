package com.talabat.user.address.data.remote;

import com.talabat.domain.address.Address;
import com.talabat.user.address.data.remote.api.AddAddressResponse;
import com.talabat.user.address.data.remote.api.AddressBody;
import com.talabat.user.address.data.remote.api.UpdateAddressResponse;
import com.talabat.user.address.data.remote.dto.AddAddressDto;
import com.talabat.user.address.data.remote.dto.AddressPayload;
import com.talabat.user.address.data.remote.dto.UpdateAddressDto;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014¨\u0006\u0015"}, d2 = {"Lcom/talabat/user/address/data/remote/AddressDtoMapper;", "", "()V", "map", "Lcom/talabat/domain/address/Address;", "addAddressDto", "Lcom/talabat/user/address/data/remote/dto/AddAddressDto;", "updateAddressDto", "Lcom/talabat/user/address/data/remote/dto/UpdateAddressDto;", "mapToAddAddressDto", "addAddressResponse", "Lcom/talabat/user/address/data/remote/api/AddAddressResponse;", "mapToAddressBody", "Lcom/talabat/user/address/data/remote/api/AddressBody;", "addressPayload", "Lcom/talabat/user/address/data/remote/dto/AddressPayload;", "mapToAddressPayload", "address", "mapToUpdateAddressDto", "response", "Lcom/talabat/user/address/data/remote/api/UpdateAddressResponse;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Replace with AddressDtoToAddressMapper")
public final class AddressDtoMapper {
    @NotNull
    public final Address map(@NotNull AddAddressDto addAddressDto) {
        Intrinsics.checkNotNullParameter(addAddressDto, "addAddressDto");
        String profileId = addAddressDto.getProfileId();
        String profileName = addAddressDto.getProfileName();
        String areaName = addAddressDto.getAreaName();
        int type = addAddressDto.getType();
        String block = addAddressDto.getBlock();
        String judda = addAddressDto.getJudda();
        String street = addAddressDto.getStreet();
        String buildingNo = addAddressDto.getBuildingNo();
        String floor = addAddressDto.getFloor();
        String suite = addAddressDto.getSuite();
        String extraDirections = addAddressDto.getExtraDirections();
        String phoneNumber = addAddressDto.getPhoneNumber();
        String mobileNumber = addAddressDto.getMobileNumber();
        int country = addAddressDto.getCountry();
        double latitude = addAddressDto.getLatitude();
        double longitude = addAddressDto.getLongitude();
        String grl = addAddressDto.getGrl();
        String countryCode = addAddressDto.getCountryCode();
        Address address = new Address(profileId, (int) addAddressDto.getAreaId(), areaName, block, buildingNo, addAddressDto.getCityId(), country, (String) null, extraDirections, floor, (String) null, (String) null, grl, (String) null, addAddressDto.isAreaDisabled(), addAddressDto.isEligibleForDelivery(), false, judda, latitude, longitude, mobileNumber, countryCode, phoneNumber, profileName, street, suite, type, 76928, (DefaultConstructorMarker) null);
        address.grlid = addAddressDto.getGrlId();
        return address;
    }

    @NotNull
    public final AddAddressDto mapToAddAddressDto(@NotNull AddAddressResponse addAddressResponse) {
        String str;
        String str2;
        long j11;
        String str3;
        int i11;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        int i12;
        double d11;
        String str14;
        String str15;
        int i13;
        boolean z11;
        boolean z12;
        AddAddressDto.Error error;
        String str16;
        String str17;
        String str18;
        String str19;
        Boolean isEligibleForDelivery;
        Boolean isAreaDisabled;
        Integer cityId;
        Double longitude;
        Double latitude;
        Integer country;
        Integer type;
        Long areaId;
        Intrinsics.checkNotNullParameter(addAddressResponse, "addAddressResponse");
        AddAddressResponse.Result result = addAddressResponse.getResult();
        if (result != null) {
            str = result.getProfileId();
        } else {
            str = null;
        }
        String str20 = "";
        if (str == null) {
            str = str20;
        }
        if (result != null) {
            str2 = result.getProfileName();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = str20;
        }
        if (result == null || (areaId = result.getAreaId()) == null) {
            j11 = 0;
        } else {
            j11 = areaId.longValue();
        }
        if (result != null) {
            str3 = result.getAreaName();
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = str20;
        }
        if (result == null || (type = result.getType()) == null) {
            i11 = 0;
        } else {
            i11 = type.intValue();
        }
        if (result != null) {
            str4 = result.getBlock();
        } else {
            str4 = null;
        }
        if (str4 == null) {
            str4 = str20;
        }
        if (result != null) {
            str5 = result.getJudda();
        } else {
            str5 = null;
        }
        if (str5 == null) {
            str5 = str20;
        }
        if (result != null) {
            str6 = result.getStreet();
        } else {
            str6 = null;
        }
        if (str6 == null) {
            str6 = str20;
        }
        if (result != null) {
            str7 = result.getBuildingNo();
        } else {
            str7 = null;
        }
        if (str7 == null) {
            str7 = str20;
        }
        if (result != null) {
            str8 = result.getFloor();
        } else {
            str8 = null;
        }
        if (str8 == null) {
            str8 = str20;
        }
        if (result != null) {
            str9 = result.getSuite();
        } else {
            str9 = null;
        }
        if (str9 == null) {
            str9 = str20;
        }
        if (result != null) {
            str10 = result.getExtraDirections();
        } else {
            str10 = null;
        }
        if (str10 == null) {
            str10 = str20;
        }
        if (result != null) {
            str11 = result.getPhoneNumber();
        } else {
            str11 = null;
        }
        if (str11 == null) {
            str11 = str20;
        }
        if (result != null) {
            str12 = result.getCountryCode();
        } else {
            str12 = null;
        }
        if (str12 == null) {
            str12 = str20;
        }
        if (result != null) {
            str13 = result.getMobileNumber();
        } else {
            str13 = null;
        }
        if (str13 == null) {
            str13 = str20;
        }
        if (result == null || (country = result.getCountry()) == null) {
            i12 = 0;
        } else {
            i12 = country.intValue();
        }
        double d12 = 0.0d;
        if (result == null || (latitude = result.getLatitude()) == null) {
            d11 = 0.0d;
        } else {
            d11 = latitude.doubleValue();
        }
        if (!(result == null || (longitude = result.getLongitude()) == null)) {
            d12 = longitude.doubleValue();
        }
        if (result != null) {
            str14 = result.getGrl();
        } else {
            str14 = null;
        }
        if (str14 == null) {
            str14 = str20;
        }
        if (result != null) {
            str15 = result.getGrlId();
        } else {
            str15 = null;
        }
        if (str15 == null) {
            str15 = str20;
        }
        if (result == null || (cityId = result.getCityId()) == null) {
            i13 = 0;
        } else {
            i13 = cityId.intValue();
        }
        if (result == null || (isAreaDisabled = result.isAreaDisabled()) == null) {
            z11 = false;
        } else {
            z11 = isAreaDisabled.booleanValue();
        }
        if (result == null || (isEligibleForDelivery = result.isEligibleForDelivery()) == null) {
            z12 = false;
        } else {
            z12 = isEligibleForDelivery.booleanValue();
        }
        if (Intrinsics.areEqual((Object) addAddressResponse.getHasError(), (Object) Boolean.TRUE)) {
            AddAddressResponse.Error error2 = addAddressResponse.getError();
            if (error2 != null) {
                str16 = error2.getErrorCode();
            } else {
                str16 = null;
            }
            if (str16 == null) {
                str16 = str20;
            }
            AddAddressResponse.Error error3 = addAddressResponse.getError();
            if (error3 != null) {
                str17 = error3.getMessage();
            } else {
                str17 = null;
            }
            if (str17 == null) {
                str18 = str20;
            } else {
                str18 = str17;
            }
            AddAddressResponse.Error error4 = addAddressResponse.getError();
            if (error4 != null) {
                str19 = error4.getTitle();
            } else {
                str19 = null;
            }
            if (str19 != null) {
                str20 = str19;
            }
            error = new AddAddressDto.Error(str16, str18, str20);
        } else {
            error = null;
        }
        return new AddAddressDto(str, str2, j11, str3, i11, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, i12, d11, d12, str14, str15, i13, z11, z12, error);
    }

    @NotNull
    public final AddressBody mapToAddressBody(@NotNull AddressPayload addressPayload) {
        Intrinsics.checkNotNullParameter(addressPayload, "addressPayload");
        return new AddressBody(addressPayload.getProfileName(), addressPayload.getAreaId(), addressPayload.getAreaName(), addressPayload.getType(), addressPayload.getBlock(), addressPayload.getJudda(), addressPayload.getStreet(), addressPayload.getBuildingNo(), addressPayload.getFloor(), addressPayload.getSuite(), addressPayload.getExtraDirections(), addressPayload.getPhoneNumber(), addressPayload.getCountryCode(), addressPayload.getMobileNumber(), addressPayload.getCityId(), addressPayload.getCountry(), addressPayload.getLatitude(), addressPayload.getLongitude(), addressPayload.getGrl(), addressPayload.getGrlId());
    }

    @NotNull
    public final AddressPayload mapToAddressPayload(@NotNull Address address) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        Address address2 = address;
        Intrinsics.checkNotNullParameter(address2, "address");
        String str14 = address2.profileName;
        if (str14 == null) {
            str = "";
        } else {
            str = str14;
        }
        long j11 = (long) address2.areaId;
        String str15 = address2.areaName;
        if (str15 == null) {
            str2 = "";
        } else {
            str2 = str15;
        }
        int i11 = address2.type;
        String str16 = address2.block;
        if (str16 == null) {
            str3 = "";
        } else {
            str3 = str16;
        }
        String str17 = address2.judda;
        if (str17 == null) {
            str4 = "";
        } else {
            str4 = str17;
        }
        String str18 = address2.street;
        if (str18 == null) {
            str5 = "";
        } else {
            str5 = str18;
        }
        String str19 = address2.buildingNo;
        if (str19 == null) {
            str6 = "";
        } else {
            str6 = str19;
        }
        String str20 = address2.floor;
        if (str20 == null) {
            str7 = "";
        } else {
            str7 = str20;
        }
        String str21 = address2.suite;
        if (str21 == null) {
            str8 = "";
        } else {
            str8 = str21;
        }
        String str22 = address2.extraDirections;
        if (str22 == null) {
            str9 = "";
        } else {
            str9 = str22;
        }
        String str23 = address2.phoneNumber;
        if (str23 == null) {
            str10 = "";
        } else {
            str10 = str23;
        }
        String str24 = address2.mobilNumberCountryCode;
        if (str24 == null) {
            str11 = "";
        } else {
            str11 = str24;
        }
        String str25 = address2.mobileNumber;
        if (str25 == null) {
            str12 = "";
        } else {
            str12 = str25;
        }
        int i12 = address2.cityId;
        String str26 = str9;
        String str27 = str8;
        int i13 = address2.countyId;
        double d11 = address2.latitude;
        double d12 = address2.longitude;
        int i14 = i12;
        String str28 = address2.grl;
        if (str28 == null) {
            str13 = "";
        } else {
            str13 = str28;
        }
        String str29 = address2.grlid;
        if (str29 == null) {
            str29 = "";
        }
        return new AddressPayload(str, j11, str2, i11, str3, str4, str5, str6, str7, str27, str26, str10, str11, str12, i14, i13, d11, d12, str13, str29);
    }

    @NotNull
    public final UpdateAddressDto mapToUpdateAddressDto(@NotNull UpdateAddressResponse updateAddressResponse) {
        String str;
        String str2;
        String str3;
        String str4;
        long j11;
        String str5;
        String str6;
        int i11;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        int i12;
        double d11;
        String str27;
        String str28;
        String str29;
        String str30;
        int i13;
        boolean z11;
        boolean z12;
        UpdateAddressDto.Error error;
        String str31;
        String str32;
        String str33;
        String str34;
        Boolean isEligibleForDelivery;
        Boolean isAreaDisabled;
        Integer cityId;
        Double longitude;
        Double latitude;
        Integer country;
        Integer type;
        Long areaId;
        Intrinsics.checkNotNullParameter(updateAddressResponse, "response");
        UpdateAddressResponse.Result result = updateAddressResponse.getResult();
        if (result != null) {
            str = result.getProfileId();
        } else {
            str = null;
        }
        String str35 = "";
        if (str == null) {
            str2 = str35;
        } else {
            str2 = str;
        }
        UpdateAddressResponse.Result result2 = updateAddressResponse.getResult();
        if (result2 != null) {
            str3 = result2.getProfileName();
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str4 = str35;
        } else {
            str4 = str3;
        }
        UpdateAddressResponse.Result result3 = updateAddressResponse.getResult();
        if (result3 == null || (areaId = result3.getAreaId()) == null) {
            j11 = 0;
        } else {
            j11 = areaId.longValue();
        }
        UpdateAddressResponse.Result result4 = updateAddressResponse.getResult();
        if (result4 != null) {
            str5 = result4.getAreaName();
        } else {
            str5 = null;
        }
        if (str5 == null) {
            str6 = str35;
        } else {
            str6 = str5;
        }
        UpdateAddressResponse.Result result5 = updateAddressResponse.getResult();
        if (result5 == null || (type = result5.getType()) == null) {
            i11 = 0;
        } else {
            i11 = type.intValue();
        }
        UpdateAddressResponse.Result result6 = updateAddressResponse.getResult();
        if (result6 != null) {
            str7 = result6.getBlock();
        } else {
            str7 = null;
        }
        if (str7 == null) {
            str8 = str35;
        } else {
            str8 = str7;
        }
        UpdateAddressResponse.Result result7 = updateAddressResponse.getResult();
        if (result7 != null) {
            str9 = result7.getJudda();
        } else {
            str9 = null;
        }
        if (str9 == null) {
            str10 = str35;
        } else {
            str10 = str9;
        }
        UpdateAddressResponse.Result result8 = updateAddressResponse.getResult();
        if (result8 != null) {
            str11 = result8.getStreet();
        } else {
            str11 = null;
        }
        if (str11 == null) {
            str12 = str35;
        } else {
            str12 = str11;
        }
        UpdateAddressResponse.Result result9 = updateAddressResponse.getResult();
        if (result9 != null) {
            str13 = result9.getBuildingNo();
        } else {
            str13 = null;
        }
        if (str13 == null) {
            str14 = str35;
        } else {
            str14 = str13;
        }
        UpdateAddressResponse.Result result10 = updateAddressResponse.getResult();
        if (result10 != null) {
            str15 = result10.getFloor();
        } else {
            str15 = null;
        }
        if (str15 == null) {
            str16 = str35;
        } else {
            str16 = str15;
        }
        UpdateAddressResponse.Result result11 = updateAddressResponse.getResult();
        if (result11 != null) {
            str17 = result11.getSuite();
        } else {
            str17 = null;
        }
        if (str17 == null) {
            str18 = str35;
        } else {
            str18 = str17;
        }
        UpdateAddressResponse.Result result12 = updateAddressResponse.getResult();
        if (result12 != null) {
            str19 = result12.getExtraDirections();
        } else {
            str19 = null;
        }
        if (str19 == null) {
            str20 = str35;
        } else {
            str20 = str19;
        }
        UpdateAddressResponse.Result result13 = updateAddressResponse.getResult();
        if (result13 != null) {
            str21 = result13.getPhoneNumber();
        } else {
            str21 = null;
        }
        if (str21 == null) {
            str22 = str35;
        } else {
            str22 = str21;
        }
        UpdateAddressResponse.Result result14 = updateAddressResponse.getResult();
        if (result14 != null) {
            str23 = result14.getCountryCode();
        } else {
            str23 = null;
        }
        if (str23 == null) {
            str24 = str35;
        } else {
            str24 = str23;
        }
        UpdateAddressResponse.Result result15 = updateAddressResponse.getResult();
        if (result15 != null) {
            str25 = result15.getMobileNumber();
        } else {
            str25 = null;
        }
        if (str25 == null) {
            str26 = str35;
        } else {
            str26 = str25;
        }
        UpdateAddressResponse.Result result16 = updateAddressResponse.getResult();
        if (result16 == null || (country = result16.getCountry()) == null) {
            i12 = 0;
        } else {
            i12 = country.intValue();
        }
        UpdateAddressResponse.Result result17 = updateAddressResponse.getResult();
        double d12 = 0.0d;
        if (result17 == null || (latitude = result17.getLatitude()) == null) {
            d11 = 0.0d;
        } else {
            d11 = latitude.doubleValue();
        }
        UpdateAddressResponse.Result result18 = updateAddressResponse.getResult();
        if (!(result18 == null || (longitude = result18.getLongitude()) == null)) {
            d12 = longitude.doubleValue();
        }
        double d13 = d12;
        UpdateAddressResponse.Result result19 = updateAddressResponse.getResult();
        if (result19 != null) {
            str27 = result19.getGrl();
        } else {
            str27 = null;
        }
        if (str27 == null) {
            str28 = str35;
        } else {
            str28 = str27;
        }
        UpdateAddressResponse.Result result20 = updateAddressResponse.getResult();
        if (result20 != null) {
            str29 = result20.getGrlId();
        } else {
            str29 = null;
        }
        if (str29 == null) {
            str30 = str35;
        } else {
            str30 = str29;
        }
        UpdateAddressResponse.Result result21 = updateAddressResponse.getResult();
        if (result21 == null || (cityId = result21.getCityId()) == null) {
            i13 = 0;
        } else {
            i13 = cityId.intValue();
        }
        UpdateAddressResponse.Result result22 = updateAddressResponse.getResult();
        if (result22 == null || (isAreaDisabled = result22.isAreaDisabled()) == null) {
            z11 = false;
        } else {
            z11 = isAreaDisabled.booleanValue();
        }
        UpdateAddressResponse.Result result23 = updateAddressResponse.getResult();
        if (result23 == null || (isEligibleForDelivery = result23.isEligibleForDelivery()) == null) {
            z12 = false;
        } else {
            z12 = isEligibleForDelivery.booleanValue();
        }
        if (Intrinsics.areEqual((Object) updateAddressResponse.getHasError(), (Object) Boolean.TRUE)) {
            UpdateAddressResponse.Error error2 = updateAddressResponse.getError();
            if (error2 != null) {
                str31 = error2.getErrorCode();
            } else {
                str31 = null;
            }
            if (str31 == null) {
                str31 = str35;
            }
            UpdateAddressResponse.Error error3 = updateAddressResponse.getError();
            if (error3 != null) {
                str32 = error3.getMessage();
            } else {
                str32 = null;
            }
            if (str32 == null) {
                str33 = str35;
            } else {
                str33 = str32;
            }
            UpdateAddressResponse.Error error4 = updateAddressResponse.getError();
            if (error4 != null) {
                str34 = error4.getTitle();
            } else {
                str34 = null;
            }
            if (str34 != null) {
                str35 = str34;
            }
            error = new UpdateAddressDto.Error(str31, str33, str35);
        } else {
            error = null;
        }
        return new UpdateAddressDto(str2, str4, j11, str6, i11, str8, str10, str12, str14, str16, str18, str20, str22, str24, str26, i13, z12, z11, i12, d11, d13, str28, str30, error);
    }

    @NotNull
    public final Address map(@NotNull UpdateAddressDto updateAddressDto) {
        Intrinsics.checkNotNullParameter(updateAddressDto, "updateAddressDto");
        String profileId = updateAddressDto.getProfileId();
        String profileName = updateAddressDto.getProfileName();
        String areaName = updateAddressDto.getAreaName();
        int type = updateAddressDto.getType();
        String block = updateAddressDto.getBlock();
        String judda = updateAddressDto.getJudda();
        String street = updateAddressDto.getStreet();
        String buildingNo = updateAddressDto.getBuildingNo();
        String floor = updateAddressDto.getFloor();
        String suite = updateAddressDto.getSuite();
        String extraDirections = updateAddressDto.getExtraDirections();
        String phoneNumber = updateAddressDto.getPhoneNumber();
        String mobileNumber = updateAddressDto.getMobileNumber();
        int country = updateAddressDto.getCountry();
        double latitude = updateAddressDto.getLatitude();
        double longitude = updateAddressDto.getLongitude();
        String grl = updateAddressDto.getGrl();
        String countryCode = updateAddressDto.getCountryCode();
        Address address = new Address(profileId, (int) updateAddressDto.getAreaId(), areaName, block, buildingNo, updateAddressDto.getCityId(), country, (String) null, extraDirections, floor, (String) null, (String) null, grl, (String) null, updateAddressDto.isAreaDisabled(), updateAddressDto.isEligibleForDelivery(), false, judda, latitude, longitude, mobileNumber, countryCode, phoneNumber, profileName, street, suite, type, 76928, (DefaultConstructorMarker) null);
        address.grlid = updateAddressDto.getGrlId();
        return address;
    }
}
