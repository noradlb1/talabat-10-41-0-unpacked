package JsonModels.Response.BIN;

import com.google.gson.annotations.SerializedName;

public class BinResponse {
    @SerializedName("bankId")
    public int bankId;
    @SerializedName("binDisc")
    public float binDiscount;
    @SerializedName("binMinAmt")
    public float binMinimumOrderAmount;
    public String binNum;
    public float delChrg;
    @SerializedName("discTyp")
    public int discountType;
    public boolean hasCoupon;
    public boolean hasFreeItem;
    public boolean hasPromotion;
    public boolean isValid;
    @SerializedName("chkOutMesg")
    public String message;
    @SerializedName("mob")
    public String mobile;
    @SerializedName("newAcc")
    public boolean newAccusition;
    @SerializedName("showCheckoutMesg")
    public boolean onlyShowMessage;
    public float ordAmt;
    @SerializedName("publicKey")
    public String publicKey;
    public int restId;
    @SerializedName("sts")
    public String status;
    public String voucherCode;
    public float voucherDisc;
}
