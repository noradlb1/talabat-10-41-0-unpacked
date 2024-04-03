package datamodels;

import com.talabat.lib.Integration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class TransactionItem {
    ArrayList<TransactionChoice> Choices;
    int Id;
    boolean IsDiscounted;
    boolean IsFreeItem;
    boolean IsPromotional;
    float Price;
    int Qty;
    String SpecialRequest;
    @Nullable
    private Integer couponId;
    private float darkStoreItemDiscountPrice;
    boolean isUpsell;
    private String itemGuid;

    /* renamed from: nm  reason: collision with root package name */
    private String f13876nm;
    float oldPrice;
    private StringBuilder refID;
    private String thumbnailImage;

    public static TransactionItem createTransactionItem(CartMenuItem cartMenuItem, boolean z11) {
        float f11;
        float f12;
        float f13;
        CartMenuItem cartMenuItem2 = cartMenuItem;
        TransactionItem transactionItem = new TransactionItem();
        StringBuilder sb2 = new StringBuilder();
        transactionItem.refID = sb2;
        int i11 = cartMenuItem2.f13861id;
        transactionItem.Id = i11;
        sb2.append(i11);
        float f14 = 0.0f;
        if (!Integration.isGemActive() || !cartMenuItem2.isItemDiscount) {
            f11 = cartMenuItem2.price;
        } else {
            f11 = cartMenuItem2.oldPrice;
            if (f11 < 0.0f) {
                f11 = cartMenuItem2.price;
            }
        }
        transactionItem.Price = f11;
        boolean z12 = (!Integration.isGemActive() || !cartMenuItem2.isItemDiscount) && cartMenuItem2.isItemDiscount;
        transactionItem.IsDiscounted = z12;
        if (z12) {
            f14 = cartMenuItem2.oldPrice;
        }
        transactionItem.oldPrice = f14;
        transactionItem.IsFreeItem = cartMenuItem2.isFreeItem;
        transactionItem.IsPromotional = cartMenuItem2.isPromotional;
        transactionItem.Qty = cartMenuItem.getQuantity();
        transactionItem.SpecialRequest = cartMenuItem2.specialRequest;
        transactionItem.isUpsell = cartMenuItem2.isUpsellingItem;
        transactionItem.couponId = cartMenuItem2.couponId;
        if (z11) {
            transactionItem.f13876nm = cartMenuItem2.f13862name;
            transactionItem.itemGuid = cartMenuItem.getStringId();
            transactionItem.darkStoreItemDiscountPrice = cartMenuItem2.darkStoreItemDiscountPrice;
            String str = cartMenuItem2.thumbnail;
            if (str != null) {
                transactionItem.thumbnailImage = str;
            }
        }
        if (cartMenuItem.getSelectedChoices() != null) {
            ArrayList<ChoiceSection> selectedChoices = cartMenuItem.getSelectedChoices();
            List<ChoiceSection> list = cartMenuItem2.allChoices;
            if (list == null || list.isEmpty()) {
                Iterator<ChoiceSection> it = cartMenuItem.getSelectedChoices().iterator();
                while (it.hasNext()) {
                    ChoiceSection next = it.next();
                    int i12 = next.isSubChoice ? next.parentItemId : 0;
                    Iterator<ChoiceItem> it2 = next.itemChoices.iterator();
                    while (it2.hasNext()) {
                        ChoiceItem next2 = it2.next();
                        if (!Integration.isGemActive() || !next2.isDisountedItem) {
                            f12 = next2.price;
                        } else {
                            f12 = next2.oldPrice;
                        }
                        TransactionChoice transactionChoice = new TransactionChoice(next2.f13839id, next.f13841id, f12, next2.quantity, false, i12, next2.couponId, next2.oldPrice);
                        if (transactionItem.Choices == null) {
                            transactionItem.Choices = new ArrayList<>();
                        }
                        transactionItem.Choices.add(transactionChoice);
                        transactionItem.refID.append(transactionChoice.Id);
                    }
                }
            } else {
                for (ChoiceSection next3 : cartMenuItem2.allChoices) {
                    Iterator<ChoiceSection> it3 = selectedChoices.iterator();
                    while (it3.hasNext()) {
                        ChoiceSection next4 = it3.next();
                        if (next3.f13841id == next4.f13841id) {
                            int i13 = next4.isSubChoice ? next4.parentItemId : 0;
                            Iterator<ChoiceItem> it4 = next4.itemChoices.iterator();
                            while (it4.hasNext()) {
                                ChoiceItem next5 = it4.next();
                                if (!Integration.isGemActive() || !next5.isDisountedItem) {
                                    f13 = next5.price;
                                } else {
                                    f13 = next5.oldPrice;
                                }
                                TransactionChoice transactionChoice2 = r8;
                                TransactionChoice transactionChoice3 = new TransactionChoice(next5.f13839id, next4.f13841id, f13, next5.quantity, false, i13, next5.couponId, next5.oldPrice);
                                if (transactionItem.Choices == null) {
                                    transactionItem.Choices = new ArrayList<>();
                                }
                                transactionItem.Choices.add(transactionChoice2);
                                transactionItem.refID.append(transactionChoice2.Id);
                            }
                        }
                    }
                }
            }
        }
        return transactionItem;
    }

    public static TransactionItem createTransactionItem(BenefitItem benefitItem) {
        List<ChoiceSection> list;
        TransactionItem transactionItem = new TransactionItem();
        transactionItem.Id = benefitItem.itemId;
        transactionItem.IsFreeItem = true;
        transactionItem.IsPromotional = true;
        transactionItem.Qty = 1;
        StringBuilder sb2 = new StringBuilder();
        transactionItem.refID = sb2;
        sb2.append(transactionItem.Id);
        if (benefitItem.choiceSelected && (list = benefitItem.choiceCategories) != null) {
            for (ChoiceSection next : list) {
                Iterator<ChoiceItem> it = next.itemChoices.iterator();
                while (it.hasNext()) {
                    ChoiceItem next2 = it.next();
                    TransactionChoice transactionChoice = new TransactionChoice(next2.f13839id, next.f13841id, next2.price, next2.quantity, false, 0, next2.couponId, next2.oldPrice);
                    if (transactionItem.Choices == null) {
                        transactionItem.Choices = new ArrayList<>();
                    }
                    transactionItem.Choices.add(transactionChoice);
                    transactionItem.refID.append(transactionChoice.Id);
                }
            }
        }
        return transactionItem;
    }
}
