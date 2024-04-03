package buisnessmodels;

import com.talabat.domain.address.Address;
import com.talabat.helpers.TalabatUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class McdMapTempAddress {
    private static McdMapTempAddress ourInstance = new McdMapTempAddress();

    /* renamed from: a  reason: collision with root package name */
    public Address f39649a;

    /* renamed from: b  reason: collision with root package name */
    public Address f39650b;

    /* renamed from: c  reason: collision with root package name */
    public Address f39651c;
    private String inforMapGrlID;
    private String mcdBarnchId;
    private int mcdBhBranchId = -1;
    private int mcdKsBranchId = -1;

    public class JsonModelAddAddressResult {
        public String item;
        public int itemId;

        public JsonModelAddAddressResult() {
        }
    }

    private McdMapTempAddress() {
    }

    public static McdMapTempAddress getInstance() {
        return ourInstance;
    }

    public void clearMcdBlockTempAddress() {
        this.f39650b = null;
    }

    public void clearTempinfoAddress() {
        this.f39649a = null;
    }

    public String getGrlID() {
        Address address = this.f39649a;
        if (address != null && !TalabatUtils.isNullOrEmpty(address.grl)) {
            this.inforMapGrlID = infoMaptoGrlIDConverter(this.f39649a.grl);
        }
        return this.inforMapGrlID;
    }

    public int getMcdBranchTempId() {
        return this.mcdBhBranchId;
    }

    public int getMcdKSBranchTempId() {
        return this.mcdKsBranchId;
    }

    public Address getSelectedGrlTempAddress() {
        Address address = this.f39649a;
        if (address != null) {
            return address;
        }
        return null;
    }

    public Address getSelectedMcdBlockTempAddress() {
        Address address = this.f39650b;
        if (address != null) {
            return address;
        }
        return null;
    }

    public Address getSelectedMcdLatLangTempAddress() {
        Address address = this.f39651c;
        if (address != null) {
            return address;
        }
        return null;
    }

    public String infoMaptoGrlIDConverter(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("AddressElements");
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JsonModelAddAddressResult jsonModelAddAddressResult = new JsonModelAddAddressResult();
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                jsonModelAddAddressResult.itemId = jSONObject.getInt("AddressElementTypeCode");
                jsonModelAddAddressResult.item = jSONObject.getString("Value");
                arrayList.add(i11, jsonModelAddAddressResult);
            }
            if (arrayList.size() > 4) {
                return ((JsonModelAddAddressResult) arrayList.get(4)).item;
            }
            return "";
        } catch (Exception unused) {
            return str;
        }
    }

    public void removeSelectedTempBlockAddress() {
        this.f39650b = null;
    }

    public void saveTempAddressGlrCustomerAddress(Address address) {
        if (address != null) {
            this.f39649a = address;
        }
    }

    public void saveTempAddressMcdBlockCustomerAddress(Address address) {
        if (address != null) {
            this.f39650b = address;
        }
    }

    public void saveTempAddressMcdLatLangCustomerAddress(Address address) {
        if (address != null) {
            this.f39651c = address;
        }
    }

    public void setSelectedGrlBranchId(String str) {
        this.mcdBarnchId = str;
    }

    public void setSelectedMCdBhBranchId(int i11) {
        this.mcdBhBranchId = i11;
    }

    public void setSelectedMCdKsBranchId(int i11) {
        this.mcdKsBranchId = i11;
    }

    public void setSelectedTempBlockAddress(Address address) {
        this.f39650b = new Address();
        saveTempAddressMcdBlockCustomerAddress(address);
    }

    public void setSelectedTempGrlAddress(Address address) {
        this.f39649a = new Address();
        saveTempAddressGlrCustomerAddress(address);
    }

    public void setSelectedTempLatLangAddress(Address address) {
        this.f39651c = new Address();
        saveTempAddressMcdLatLangCustomerAddress(address);
    }
}
