package library.talabat.mvp.talabatcreditvoucher;

import com.talabat.helpers.Talabat;

public interface TalabatCreditVoucherView extends Talabat {
    public static final int VAL_ENTER_VOUCHER_CODE = 70;

    String getVoucherCode();

    void onLocalValidationFailed(int i11);

    void onValidationSuccess();

    void onVoucherApplied(String str, float f11);
}
