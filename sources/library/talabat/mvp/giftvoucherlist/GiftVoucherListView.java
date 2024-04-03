package library.talabat.mvp.giftvoucherlist;

import com.talabat.helpers.Talabat;
import datamodels.GiftVoucherItem;

public interface GiftVoucherListView extends Talabat {
    void dismisLoading();

    void onRedirectToGiftVoucherDetails(GiftVoucherItem giftVoucherItem);

    void setDescription(String str);

    void setGiftVoucherItems(GiftVoucherItem[] giftVoucherItemArr);

    void showLoading();
}
