package JsonModels;

public class ReorderWithBranchIdRequestModel {
    public String areaId;
    public String branchId;
    public String countryid;

    public ReorderWithBranchIdRequestModel(String str, String str2, String str3) {
        this.branchId = str;
        this.areaId = str2;
        this.countryid = str3;
    }
}
