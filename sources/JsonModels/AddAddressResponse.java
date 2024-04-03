package JsonModels;

import JsonModels.AddAddressResult;
import com.facebook.appevents.UserDataStore;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.talabat.domain.address.Address;
import java.lang.reflect.Type;

public class AddAddressResponse {
    public Address address;
    public AddAddressResult rst;

    public static class AddressDeserializer implements JsonDeserializer<Address> {
        public Address deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            int i11;
            String str;
            String str2;
            String str3;
            int i12;
            int i13;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            boolean z11;
            boolean z12;
            boolean z13;
            String str11;
            double d11;
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
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            JsonElement jsonElement2 = asJsonObject.get("eid");
            JsonElement jsonElement3 = asJsonObject.get("aid");
            JsonElement jsonElement4 = asJsonObject.get("an");
            JsonElement jsonElement5 = asJsonObject.get("blk");
            JsonElement jsonElement6 = asJsonObject.get("bno");
            JsonElement jsonElement7 = asJsonObject.get("cid");
            JsonElement jsonElement8 = asJsonObject.get("cnt");
            JsonElement jsonElement9 = asJsonObject.get("cnm");
            JsonElement jsonElement10 = asJsonObject.get("exd");
            JsonElement jsonElement11 = asJsonObject.get("fl");
            JsonElement jsonElement12 = asJsonObject.get("msg");
            JsonElement jsonElement13 = asJsonObject.get("title");
            JsonElement jsonElement14 = asJsonObject.get("grl");
            JsonElement jsonElement15 = asJsonObject.get("grlid");
            JsonElement jsonElement16 = asJsonObject.get("asplt");
            JsonElement jsonElement17 = asJsonObject.get("efd");
            JsonElement jsonElement18 = asJsonObject.get("iso");
            JsonElement jsonElement19 = asJsonObject.get("jd");
            JsonElement jsonElement20 = asJsonObject.get("ltd");
            JsonElement jsonElement21 = asJsonObject.get("lngt");
            JsonElement jsonElement22 = asJsonObject.get("mob");
            JsonElement jsonElement23 = asJsonObject.get("ccd");
            JsonElement jsonElement24 = asJsonObject.get(UserDataStore.PHONE);
            JsonElement jsonElement25 = asJsonObject.get("pn");
            JsonElement jsonElement26 = asJsonObject.get(UserDataStore.STATE);
            JsonElement jsonElement27 = asJsonObject.get("su");
            JsonElement jsonElement28 = asJsonObject.get("type");
            String str22 = "";
            if (jsonElement2 != null && !jsonElement2.isJsonNull()) {
                str22 = jsonElement2.getAsString();
            }
            String str23 = str22;
            int i14 = 0;
            if (jsonElement3 != null) {
                i11 = jsonElement3.isJsonNull() ? 0 : jsonElement3.getAsInt();
            } else {
                i11 = 0;
            }
            String str24 = null;
            if (jsonElement4 != null) {
                str = jsonElement4.isJsonNull() ? null : jsonElement4.getAsString();
            } else {
                str = null;
            }
            if (jsonElement5 != null) {
                str2 = jsonElement5.isJsonNull() ? null : jsonElement5.getAsString();
            } else {
                str2 = null;
            }
            if (jsonElement6 != null) {
                str3 = jsonElement6.isJsonNull() ? null : jsonElement6.getAsString();
            } else {
                str3 = null;
            }
            if (jsonElement7 != null) {
                i12 = jsonElement7.isJsonNull() ? 0 : jsonElement7.getAsInt();
            } else {
                i12 = 0;
            }
            if (jsonElement8 != null) {
                i13 = jsonElement8.isJsonNull() ? 0 : jsonElement8.getAsInt();
            } else {
                i13 = 0;
            }
            if (jsonElement9 != null) {
                str4 = jsonElement9.isJsonNull() ? null : jsonElement9.getAsString();
            } else {
                str4 = null;
            }
            if (jsonElement10 != null) {
                if (jsonElement10.isJsonNull()) {
                    str21 = null;
                } else {
                    str21 = jsonElement10.getAsString();
                }
                str5 = str21;
            } else {
                str5 = null;
            }
            if (jsonElement11 != null) {
                str6 = jsonElement11.isJsonNull() ? null : jsonElement11.getAsString();
            } else {
                str6 = null;
            }
            if (jsonElement12 != null) {
                if (jsonElement12.isJsonNull()) {
                    str20 = null;
                } else {
                    str20 = jsonElement12.getAsString();
                }
                str7 = str20;
            } else {
                str7 = null;
            }
            if (jsonElement13 != null) {
                if (jsonElement13.isJsonNull()) {
                    str19 = null;
                } else {
                    str19 = jsonElement13.getAsString();
                }
                str8 = str19;
            } else {
                str8 = null;
            }
            if (jsonElement14 != null) {
                str9 = jsonElement14.isJsonNull() ? null : jsonElement14.getAsString();
            } else {
                str9 = null;
            }
            if (jsonElement15 != null) {
                str10 = jsonElement15.isJsonNull() ? null : jsonElement15.getAsString();
            } else {
                str10 = null;
            }
            boolean z14 = true;
            if (jsonElement16 != null) {
                z11 = !jsonElement16.isJsonNull() && jsonElement16.getAsBoolean();
            } else {
                z11 = false;
            }
            if (jsonElement17 != null) {
                z12 = !jsonElement17.isJsonNull() && jsonElement17.getAsBoolean();
            } else {
                z12 = false;
            }
            if (jsonElement18 != null) {
                if (jsonElement18.isJsonNull() || !jsonElement18.getAsBoolean()) {
                    z14 = false;
                }
                z13 = z14;
            } else {
                z13 = false;
            }
            if (jsonElement19 != null) {
                str11 = jsonElement19.isJsonNull() ? null : jsonElement19.getAsString();
            } else {
                str11 = null;
            }
            double d12 = 1.0E-5d;
            if (jsonElement20 != null) {
                d11 = jsonElement20.isJsonNull() ? 1.0E-5d : jsonElement20.getAsDouble();
            } else {
                d11 = 1.0E-5d;
            }
            if (jsonElement21 != null && !jsonElement21.isJsonNull()) {
                d12 = jsonElement21.getAsDouble();
            }
            double d13 = d12;
            if (jsonElement22 != null) {
                if (jsonElement22.isJsonNull()) {
                    str18 = null;
                } else {
                    str18 = jsonElement22.getAsString();
                }
                str12 = str18;
            } else {
                str12 = null;
            }
            if (jsonElement23 != null) {
                if (jsonElement23.isJsonNull()) {
                    str17 = null;
                } else {
                    str17 = jsonElement23.getAsString();
                }
                str13 = str17;
            } else {
                str13 = null;
            }
            if (jsonElement24 != null) {
                str14 = jsonElement24.isJsonNull() ? null : jsonElement24.getAsString();
            } else {
                str14 = null;
            }
            if (jsonElement25 != null) {
                str15 = jsonElement25.isJsonNull() ? null : jsonElement25.getAsString();
            } else {
                str15 = null;
            }
            if (jsonElement26 != null) {
                str16 = jsonElement26.isJsonNull() ? null : jsonElement26.getAsString();
            } else {
                str16 = null;
            }
            if (jsonElement27 != null && !jsonElement27.isJsonNull()) {
                str24 = jsonElement27.getAsString();
            }
            String str25 = str24;
            if (jsonElement28 != null && !jsonElement28.isJsonNull()) {
                i14 = jsonElement28.getAsInt();
            }
            return new Address(str23, i11, str, str2, str3, i12, i13, str4, str5, str6, str7, str8, str9, str10, z11, z12, z13, str11, d11, d13, str12, str13, str14, str15, str16, str25, i14);
        }
    }

    public static class AddressSerializer implements JsonSerializer<Address> {
        public JsonElement serialize(Address address, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("eid", address.f58343id);
            jsonObject.addProperty("aid", (Number) Integer.valueOf(address.areaId));
            jsonObject.addProperty("an", address.areaName);
            jsonObject.addProperty("blk", address.block);
            jsonObject.addProperty("bno", address.buildingNo);
            jsonObject.addProperty("cid", (Number) Integer.valueOf(address.cityId));
            jsonObject.addProperty("cnt", (Number) Integer.valueOf(address.countyId));
            jsonObject.addProperty("cnm", address.countryName);
            jsonObject.addProperty("exd", address.extraDirections);
            jsonObject.addProperty("fl", address.floor);
            jsonObject.addProperty("msg", address.geoAddressMsg);
            jsonObject.addProperty("title", address.geoAddressTitle);
            jsonObject.addProperty("grl", address.grl);
            jsonObject.addProperty("grlid", address.grlid);
            jsonObject.addProperty("asplt", Boolean.valueOf(address.isAreaSplit));
            jsonObject.addProperty("efd", Boolean.valueOf(address.isDeliverable));
            jsonObject.addProperty("iso", Boolean.valueOf(address.isOldAddreses));
            jsonObject.addProperty("jd", address.judda);
            jsonObject.addProperty("ltd", (Number) Double.valueOf(address.latitude));
            jsonObject.addProperty("lngt", (Number) Double.valueOf(address.longitude));
            jsonObject.addProperty("mob", address.mobileNumber);
            jsonObject.addProperty("ccd", address.mobilNumberCountryCode);
            jsonObject.addProperty(UserDataStore.PHONE, address.phoneNumber);
            jsonObject.addProperty("pn", address.profileName);
            jsonObject.addProperty(UserDataStore.STATE, address.street);
            jsonObject.addProperty("su", address.suite);
            jsonObject.addProperty("type", (Number) Integer.valueOf(address.type));
            return jsonObject;
        }
    }

    public static class Deserializer implements JsonDeserializer<AddAddressResponse> {
        public AddAddressResponse deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonElement jsonElement2 = jsonElement.getAsJsonObject().get("rst");
            AddAddressResult addAddressResult = null;
            if (jsonElement2 != null) {
                JsonObject asJsonObject = jsonElement2.isJsonNull() ? null : jsonElement2.getAsJsonObject();
                if (asJsonObject != null) {
                    addAddressResult = new AddAddressResult.Deserializer().deserialize((JsonElement) asJsonObject, (Type) AddAddressResult.class, jsonDeserializationContext);
                }
            }
            return new AddAddressResponse(addAddressResult, new AddressDeserializer().deserialize(jsonElement, (Type) Address.class, jsonDeserializationContext));
        }
    }

    public AddAddressResponse() {
        this.rst = null;
        this.address = new Address();
    }

    public AddAddressResponse(AddAddressResult addAddressResult, Address address2) {
        this.rst = addAddressResult;
        this.address = address2;
    }
}
