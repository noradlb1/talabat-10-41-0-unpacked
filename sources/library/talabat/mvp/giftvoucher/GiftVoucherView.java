package library.talabat.mvp.giftvoucher;

import JsonModels.GiftVoucherThankyouResponse;
import com.talabat.helpers.Talabat;

public interface GiftVoucherView extends Talabat {
    public static final int VAL_ENTER_RECIPIENT_EMAIL = 60;
    public static final int VAL_ENTER_RECIPIENT_NAME = 61;
    public static final int VAL_INVALID_EMAIL = 62;

    int getGiftVoucherId();

    String getMessage();

    String getReciepientEmail();

    String getReciepientName();

    void onRedirectionToPaymentPage(String str, String str2);

    void onRedirectionToThanyouPage(GiftVoucherThankyouResponse giftVoucherThankyouResponse);

    void onValidationError(int i11);

    void onValidationSuccess();
}
