package JsonModels.Request.BIN;

public class BinRequest {
    public int areaId;
    private String binNum;
    public int branchId;
    private float delChrg;
    private boolean hascoupon;
    private boolean hasfreeitem;
    private boolean haspromotion;
    private String mob;
    private float ordAmt;
    private int restId;
    private String voucherCode;
    private float voucherDisc;

    public BinRequest(float f11, int i11, float f12, boolean z11, boolean z12, boolean z13, String str, String str2, String str3, float f13, int i12, int i13) {
        this.ordAmt = f11;
        this.restId = i11;
        this.delChrg = f12;
        this.hascoupon = z11;
        this.hasfreeitem = z12;
        this.haspromotion = z13;
        this.mob = str;
        this.binNum = str2;
        this.voucherCode = str3;
        this.voucherDisc = f13;
        this.areaId = i12;
        this.branchId = i13;
    }

    public String getBinNum() {
        return this.binNum;
    }

    public float getDelChrg() {
        return this.delChrg;
    }

    public boolean getHascoupon() {
        return this.hascoupon;
    }

    public boolean getHasfreeitem() {
        return this.hasfreeitem;
    }

    public boolean getHaspromotion() {
        return this.haspromotion;
    }

    public String getMob() {
        return this.mob;
    }

    public float getOrdAmt() {
        return this.ordAmt;
    }

    public int getRestId() {
        return this.restId;
    }

    public String getVoucherCode() {
        return this.voucherCode;
    }

    public float getVoucherDisc() {
        return this.voucherDisc;
    }
}
