package datamodels;

import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import buisnessmodels.TalabatFormatter;
import com.talabat.helpers.GlobalDataModel;
import datamodels.darkstores.DarkstoresExitPointProduct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class CartMenuItem extends MenuItem implements Parcelable {
    public static final Parcelable.Creator<CartMenuItem> CREATOR = new Parcelable.Creator<CartMenuItem>() {
        public CartMenuItem createFromParcel(Parcel parcel) {
            return new CartMenuItem(parcel);
        }

        public CartMenuItem[] newArray(int i11) {
            return new CartMenuItem[i11];
        }
    };
    public List<ChoiceSection> allChoices;
    public int allMandatorychoicesCount;
    public int allOptionalChoicesCount;
    private float cartItemPrice;
    private float cartOldPrice;
    private float cartOldTotalPrice;
    private float cartTotalPrice;
    public float darkStoreItemDiscountPrice;
    public boolean isFreeItem;
    public boolean isReorderItem = false;
    public boolean isUpsellingItem = false;
    public MenuSection menuSection = new MenuSection();
    @Nullable
    public List<String> qcCategoryIds;
    private int quantity;
    public ArrayList<ChoiceSection> selectedChoices;
    public int selectedMandatorychoicesCount;
    public int selectedOptionalChoicesCount;
    @Nullable
    public String sku;
    public String specialRequest;
    private String stringId = "";

    public CartMenuItem() {
    }

    private void appendChoiceName(StringBuilder sb2, ChoiceItem choiceItem) {
        if (sb2.length() > 0) {
            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        }
        int i11 = choiceItem.quantity;
        if (i11 > 1) {
            sb2.append(i11);
            sb2.append(" x ");
            sb2.append(choiceItem.f13840name);
            return;
        }
        sb2.append(choiceItem.f13840name);
    }

    private boolean checkIfMandatoryItemsAvailable() {
        for (ChoiceSection isMandatoryChoiceSection : this.allChoices) {
            if (isMandatoryChoiceSection.isMandatoryChoiceSection()) {
                return false;
            }
        }
        return true;
    }

    public static CartMenuItem createWith(ReorderItem reorderItem) {
        CartMenuItem cartMenuItem = new CartMenuItem();
        cartMenuItem.f13862name = reorderItem.itemName;
        cartMenuItem.f13861id = reorderItem.itemId;
        cartMenuItem.price = reorderItem.price;
        cartMenuItem.isReorderItem = true;
        cartMenuItem.isPromotional = reorderItem.isPromotionalItem;
        cartMenuItem.hasThumbnail = reorderItem.hasThumbnail;
        cartMenuItem.thumbnail = reorderItem.itemImage;
        cartMenuItem.isItemDiscount = reorderItem.isItemDiscounted;
        cartMenuItem.specialRequest = reorderItem.specialReq;
        cartMenuItem.selectedChoices = new ArrayList<>();
        Iterator<ReorderItemChoice> it = reorderItem.lstItemsChoice.iterator();
        while (it.hasNext()) {
            ReorderItemChoice next = it.next();
            ChoiceSection choiceSection = new ChoiceSection();
            choiceSection.itemChoices = new ArrayList<>();
            choiceSection.f13841id = 0;
            ChoiceItem choiceItem = new ChoiceItem();
            choiceItem.f13839id = next.itemChoiceId;
            choiceItem.price = next.itemChoicePrice;
            choiceItem.f13840name = next.itemName;
            choiceItem.quantity = next.itemChoiceQty;
            choiceSection.itemChoices.add(choiceItem);
            int i11 = next.itemParentId;
            if (i11 > 0) {
                choiceSection.isSubChoice = true;
                choiceSection.parentItemId = i11;
            }
            cartMenuItem.selectedChoices.add(choiceSection);
        }
        cartMenuItem.setQuantity(reorderItem.quantity);
        return cartMenuItem;
    }

    public static CartMenuItem createWithDarkstoreProduct(DarkstoresExitPointProduct darkstoresExitPointProduct) {
        boolean z11;
        CartMenuItem cartMenuItem = new CartMenuItem();
        cartMenuItem.stringId = darkstoresExitPointProduct.getId();
        cartMenuItem.f13862name = darkstoresExitPointProduct.getName();
        cartMenuItem.price = BigDecimal.valueOf((double) (darkstoresExitPointProduct.getPrice() / ((float) darkstoresExitPointProduct.getQuantity()))).setScale(3, 4).floatValue();
        if (darkstoresExitPointProduct.getAbsoluteDiscount() > 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        cartMenuItem.isItemDiscount = z11;
        cartMenuItem.darkStoreItemDiscountPrice = darkstoresExitPointProduct.getAbsoluteDiscount();
        cartMenuItem.cartTotalPrice = darkstoresExitPointProduct.getPrice();
        if (darkstoresExitPointProduct.getOriginalPrice() != null) {
            cartMenuItem.oldPrice = BigDecimal.valueOf((double) (darkstoresExitPointProduct.getOriginalPrice().floatValue() / ((float) darkstoresExitPointProduct.getQuantity()))).setScale(3, 4).floatValue();
        }
        if (darkstoresExitPointProduct.getProductDescription() != null) {
            cartMenuItem.desc = darkstoresExitPointProduct.getProductDescription();
        }
        if (darkstoresExitPointProduct.getThumbnail() != null) {
            cartMenuItem.setThumbnail(darkstoresExitPointProduct.getThumbnail());
        }
        cartMenuItem.quantity = darkstoresExitPointProduct.getQuantity();
        cartMenuItem.sku = darkstoresExitPointProduct.getSku();
        if (darkstoresExitPointProduct.getCategoryIds() != null && !darkstoresExitPointProduct.getCategoryIds().isEmpty()) {
            cartMenuItem.qcCategoryIds = darkstoresExitPointProduct.getCategoryIds();
        }
        return cartMenuItem;
    }

    public static CartMenuItem createWithMenuItem(MenuItem menuItem) {
        MenuItemRM menuItemRM;
        MenuSection[] menuSectionArr;
        CartMenuItem cartMenuItem = new CartMenuItem();
        if (menuItem != null) {
            cartMenuItem.f13861id = menuItem.f13861id;
            cartMenuItem.menuSectionId = menuItem.menuSectionId;
            MenuItemsResponseModel menuItemsResponseModel = GlobalDataModel.JSON.menuItemsResponseModel;
            if (menuItemsResponseModel != null && (menuItemRM = menuItemsResponseModel.menu) != null && (menuSectionArr = menuItemRM.menuSection) != null && menuSectionArr != null) {
                int length = menuSectionArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    MenuSection menuSection2 = menuSectionArr[i11];
                    if (menuSection2.f13863id == menuItem.menuSectionId) {
                        cartMenuItem.menuSection = menuSection2;
                        break;
                    }
                    i11++;
                }
            }
            cartMenuItem.f13862name = menuItem.f13862name;
            cartMenuItem.price = menuItem.price;
            cartMenuItem.descPrice = menuItem.descPrice;
            cartMenuItem.choiceSections = menuItem.choiceSections;
            cartMenuItem.setThumbnail(menuItem.getThumbnail());
            cartMenuItem.hasThumbnail = menuItem.hasThumbnail;
            cartMenuItem.isItemDiscount = menuItem.isItemDiscount;
            cartMenuItem.desc = menuItem.desc;
            cartMenuItem.specialRequest = "";
            float f11 = menuItem.oldPrice;
            cartMenuItem.oldPrice = f11;
            cartMenuItem.cartOldTotalPrice = f11;
            cartMenuItem.cartTotalPrice = menuItem.price;
            cartMenuItem.isPromotional = menuItem.isPromotional;
            cartMenuItem.couponId = menuItem.couponId;
            if (menuItem.choiceSections != null) {
                cartMenuItem.allChoices = new ArrayList(Arrays.asList(menuItem.choiceSections));
            }
        }
        return cartMenuItem;
    }

    private void reCalculatePrice() {
        int i11;
        this.cartItemPrice = this.price;
        this.cartOldPrice = 0.0f;
        if (this.oldPrice > 0.0f) {
            this.isItemDiscount = true;
        }
        ArrayList<ChoiceSection> arrayList = this.selectedChoices;
        if (arrayList != null) {
            Iterator<ChoiceSection> it = arrayList.iterator();
            while (it.hasNext()) {
                Iterator<ChoiceItem> it2 = it.next().itemChoices.iterator();
                while (it2.hasNext()) {
                    ChoiceItem next = it2.next();
                    this.cartItemPrice += next.price * ((float) next.getQuantity());
                    if (!this.isItemDiscount) {
                        this.isItemDiscount = next.isDiscounted();
                    }
                }
            }
        }
        if (this.isItemDiscount) {
            float f11 = this.oldPrice;
            if (f11 <= 0.0f) {
                f11 = this.price;
            }
            this.cartOldPrice = f11;
            ArrayList<ChoiceSection> arrayList2 = this.selectedChoices;
            if (arrayList2 != null) {
                Iterator<ChoiceSection> it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    Iterator<ChoiceItem> it4 = it3.next().itemChoices.iterator();
                    while (it4.hasNext()) {
                        ChoiceItem next2 = it4.next();
                        float f12 = this.cartOldPrice;
                        float f13 = next2.oldPrice;
                        if (f13 > 0.0f) {
                            i11 = next2.getQuantity();
                        } else {
                            f13 = next2.price;
                            i11 = next2.getQuantity();
                        }
                        this.cartOldPrice = f12 + (f13 * ((float) i11));
                    }
                }
            }
        }
        float f14 = this.cartOldPrice;
        int i12 = this.quantity;
        this.cartOldTotalPrice = f14 * ((float) i12);
        this.cartTotalPrice = this.cartItemPrice * ((float) i12);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean thirdCondition() {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List<datamodels.ChoiceSection> r1 = r9.allChoices
            java.util.Iterator r1 = r1.iterator()
        L_0x000b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0027
            java.lang.Object r2 = r1.next()
            datamodels.ChoiceSection r2 = (datamodels.ChoiceSection) r2
            boolean r3 = r2.isMandatoryChoiceSection()
            if (r3 == 0) goto L_0x000b
            int r2 = r2.f13841id
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.add(r2)
            goto L_0x000b
        L_0x0027:
            int r1 = r0.size()
            r2 = 1
            r3 = 0
            if (r1 <= 0) goto L_0x0064
            java.util.ArrayList<datamodels.ChoiceSection> r1 = r9.selectedChoices
            java.util.Iterator r1 = r1.iterator()
        L_0x0035:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x005b
            java.lang.Object r4 = r1.next()
            datamodels.ChoiceSection r4 = (datamodels.ChoiceSection) r4
            int r5 = r4.f13841id
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            boolean r5 = r0.contains(r5)
            if (r5 == 0) goto L_0x0035
            int r4 = r4.f13841id
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r4 = r0.indexOf(r4)
            r0.remove(r4)
            goto L_0x0035
        L_0x005b:
            int r0 = r0.size()
            if (r0 > 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r0 = r3
            goto L_0x0065
        L_0x0064:
            r0 = r2
        L_0x0065:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = ""
            r1.append(r4)
            r1.append(r0)
            if (r0 == 0) goto L_0x011c
            java.util.List<datamodels.ChoiceSection> r1 = r9.allChoices
            java.util.Iterator r1 = r1.iterator()
            r4 = r3
            r5 = r4
        L_0x007c:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0095
            java.lang.Object r6 = r1.next()
            datamodels.ChoiceSection r6 = (datamodels.ChoiceSection) r6
            boolean r7 = r6.isMandatoryChoiceSection()
            if (r7 == 0) goto L_0x007c
            int r7 = r6.minQuantity
            int r4 = r4 + r7
            int r6 = r6.maxQuantity
            int r5 = r5 + r6
            goto L_0x007c
        L_0x0095:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r6 = "ALL --> MIN "
            r1.append(r6)
            r1.append(r4)
            java.lang.String r6 = " AND  MAX "
            r1.append(r6)
            r1.append(r5)
            java.util.ArrayList<datamodels.ChoiceSection> r1 = r9.selectedChoices
            java.util.Iterator r1 = r1.iterator()
            r6 = r3
        L_0x00b1:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x00cb
            java.lang.Object r7 = r1.next()
            datamodels.ChoiceSection r7 = (datamodels.ChoiceSection) r7
            boolean r8 = r7.isMandatoryChoiceSection()
            if (r8 == 0) goto L_0x00b1
            java.util.ArrayList<datamodels.ChoiceItem> r7 = r7.itemChoices
            int r7 = r7.size()
            int r6 = r6 + r7
            goto L_0x00b1
        L_0x00cb:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r7 = "SELECTED --> Mandatory "
            r1.append(r7)
            r1.append(r6)
            if (r6 < r4) goto L_0x011d
            if (r6 > r5) goto L_0x011d
            java.util.List<datamodels.ChoiceSection> r1 = r9.allChoices
            java.util.Iterator r1 = r1.iterator()
        L_0x00e2:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x011c
            java.lang.Object r4 = r1.next()
            datamodels.ChoiceSection r4 = (datamodels.ChoiceSection) r4
            boolean r5 = r4.isMandatoryChoiceSection()
            if (r5 == 0) goto L_0x011a
            java.util.ArrayList<datamodels.ChoiceSection> r5 = r9.selectedChoices
            java.util.Iterator r5 = r5.iterator()
        L_0x00fa:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00e2
            java.lang.Object r6 = r5.next()
            datamodels.ChoiceSection r6 = (datamodels.ChoiceSection) r6
            int r7 = r6.f13841id
            int r8 = r4.f13841id
            if (r7 != r8) goto L_0x00fa
            java.util.ArrayList<datamodels.ChoiceItem> r0 = r6.itemChoices
            int r0 = r0.size()
            int r6 = r6.minQuantity
            if (r0 < r6) goto L_0x0118
            r0 = r2
            goto L_0x00fa
        L_0x0118:
            r0 = r3
            goto L_0x00fa
        L_0x011a:
            r0 = r2
            goto L_0x00e2
        L_0x011c:
            r3 = r0
        L_0x011d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: datamodels.CartMenuItem.thirdCondition():boolean");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CartMenuItem)) {
            return false;
        }
        CartMenuItem cartMenuItem = (CartMenuItem) obj;
        if (cartMenuItem.f13861id != this.f13861id || !Objects.equals(cartMenuItem.specialRequest, this.specialRequest) || !Objects.equals(cartMenuItem.selectedChoices, this.selectedChoices)) {
            return false;
        }
        return true;
    }

    public int[] getAllQuantityOfMandatoryAndOptionalChoices() {
        int[] iArr = new int[2];
        this.allMandatorychoicesCount = 0;
        this.allOptionalChoicesCount = 0;
        List<ChoiceSection> list = this.allChoices;
        if (list != null && list.size() > 0) {
            for (ChoiceSection next : this.allChoices) {
                if (next.isMandatoryChoiceSection()) {
                    this.allMandatorychoicesCount += next.minQuantity;
                } else {
                    this.allOptionalChoicesCount++;
                }
            }
        }
        iArr[0] = this.allMandatorychoicesCount;
        iArr[1] = this.allOptionalChoicesCount;
        return iArr;
    }

    public float getCartOldPrice() {
        return this.cartOldPrice;
    }

    public float getCartOldTotalPrice() {
        return this.cartOldTotalPrice;
    }

    public ArrayList<Integer> getIndexOfNotSelectedMandatoryChoices() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        List<ChoiceSection> list = this.allChoices;
        if (list != null && list.size() > 0) {
            ArrayList<ChoiceSection> arrayList2 = this.selectedChoices;
            if (arrayList2 == null || arrayList2.size() <= 0) {
                for (int i11 = 0; i11 < this.allChoices.size(); i11++) {
                    if (this.allChoices.get(i11).isMandatoryChoiceSection()) {
                        arrayList.add(Integer.valueOf(i11));
                    }
                }
            } else {
                for (int i12 = 0; i12 < this.allChoices.size(); i12++) {
                    boolean z11 = true;
                    if (this.allChoices.get(i12).isMandatoryChoiceSection()) {
                        Iterator<ChoiceSection> it = this.selectedChoices.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z11 = false;
                                break;
                            }
                            ChoiceSection choiceSection = this.allChoices.get(i12);
                            int i13 = it.next().f13841id;
                            int i14 = choiceSection.f13841id;
                            if (i13 == i14 && choiceSection.minQuantity <= getNumberofItemsSectionForChoiceSection(i14)) {
                                break;
                            }
                        }
                    }
                    if (!z11) {
                        arrayList.add(Integer.valueOf(i12));
                    }
                }
            }
        }
        return arrayList;
    }

    public int[] getIndexofNotSelectedMandatoryChoices() {
        ArrayList arrayList = new ArrayList();
        ChoiceSection[] choiceSectionArr = this.choiceSections;
        if (choiceSectionArr != null && choiceSectionArr.length != 0) {
            int i11 = 0;
            while (true) {
                ChoiceSection[] choiceSectionArr2 = this.choiceSections;
                if (i11 >= choiceSectionArr2.length) {
                    break;
                }
                ChoiceSection choiceSection = choiceSectionArr2[i11];
                if (choiceSection.minQuantity > getNumberofItemsSectionForChoiceSection(choiceSection.f13841id)) {
                    arrayList.add(Integer.valueOf(i11));
                }
                i11++;
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            iArr[i12] = ((Integer) arrayList.get(i12)).intValue();
        }
        return iArr;
    }

    public String getItemDisplayPrice() {
        return TalabatFormatter.getInstance().getFormattedCurrency(this.cartItemPrice, true);
    }

    public float getItemPrice() {
        return this.cartItemPrice;
    }

    public int getNumberofItemsSectionForChoiceSection(int i11) {
        ArrayList<ChoiceSection> arrayList = this.selectedChoices;
        if (arrayList == null) {
            return 0;
        }
        Iterator<ChoiceSection> it = arrayList.iterator();
        while (it.hasNext()) {
            ChoiceSection next = it.next();
            if (next.f13841id == i11) {
                return next.itemChoices.size();
            }
        }
        return 0;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getRefId() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("" + this.f13861id);
        ArrayList<ChoiceSection> arrayList = this.selectedChoices;
        if (arrayList != null) {
            Iterator<ChoiceSection> it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList<ChoiceItem> arrayList2 = it.next().itemChoices;
                if (arrayList2 != null) {
                    Iterator<ChoiceItem> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        sb2.append("" + it2.next().f13839id);
                    }
                }
            }
        }
        return sb2.toString();
    }

    public ChoiceSection getSelectedChoiceForSectionId(int i11) {
        ArrayList<ChoiceSection> arrayList = this.selectedChoices;
        if (arrayList == null) {
            return null;
        }
        Iterator<ChoiceSection> it = arrayList.iterator();
        while (it.hasNext()) {
            ChoiceSection next = it.next();
            if (next.f13841id == i11) {
                return next;
            }
        }
        return null;
    }

    public String getSelectedChoiceNames() {
        StringBuilder sb2 = new StringBuilder();
        if (this.selectedChoices != null) {
            List<ChoiceSection> list = this.allChoices;
            if (list == null || list.size() <= 0) {
                Iterator<ChoiceSection> it = this.selectedChoices.iterator();
                while (it.hasNext()) {
                    ArrayList<ChoiceItem> arrayList = it.next().itemChoices;
                    if (arrayList != null) {
                        Iterator<ChoiceItem> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            appendChoiceName(sb2, it2.next());
                        }
                    }
                }
            } else {
                for (ChoiceSection next : this.allChoices) {
                    Iterator<ChoiceSection> it3 = this.selectedChoices.iterator();
                    while (it3.hasNext()) {
                        ChoiceSection next2 = it3.next();
                        ArrayList<ChoiceItem> arrayList2 = next2.itemChoices;
                        if (arrayList2 != null && next.f13841id == next2.f13841id) {
                            Iterator<ChoiceItem> it4 = arrayList2.iterator();
                            while (it4.hasNext()) {
                                appendChoiceName(sb2, it4.next());
                            }
                        }
                    }
                }
            }
        }
        return sb2.toString();
    }

    public ArrayList<ChoiceSection> getSelectedChoices() {
        return this.selectedChoices;
    }

    public String getSelectedMandatoryAndOptionalChoices() {
        ArrayList<ChoiceSection> arrayList;
        StringBuilder sb2 = new StringBuilder();
        List<ChoiceSection> list = this.allChoices;
        if (list != null && list.size() > 0 && (arrayList = this.selectedChoices) != null && arrayList.size() > 0) {
            Iterator<ChoiceSection> it = this.selectedChoices.iterator();
            while (it.hasNext()) {
                Iterator<ChoiceItem> it2 = it.next().itemChoices.iterator();
                while (it2.hasNext()) {
                    ChoiceItem next = it2.next();
                    if (sb2.length() > 0) {
                        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                    }
                    sb2.append(next.f13840name);
                }
            }
        }
        return sb2.toString();
    }

    public String getSelectedMandatoryAndOptionalChoicesForDisplay() {
        ArrayList<ChoiceSection> arrayList;
        StringBuilder sb2 = new StringBuilder();
        List<ChoiceSection> list = this.allChoices;
        if (list != null && list.size() > 0 && (arrayList = this.selectedChoices) != null && arrayList.size() > 0) {
            Iterator<ChoiceSection> it = this.selectedChoices.iterator();
            while (it.hasNext()) {
                ChoiceSection next = it.next();
                if (next.isMandatoryChoiceSection()) {
                    Iterator<ChoiceItem> it2 = next.itemChoices.iterator();
                    while (it2.hasNext()) {
                        ChoiceItem next2 = it2.next();
                        if (sb2.length() > 0) {
                            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                        }
                        sb2.append(next2.f13840name);
                    }
                } else {
                    Iterator<ChoiceItem> it3 = next.itemChoices.iterator();
                    while (it3.hasNext()) {
                        ChoiceItem next3 = it3.next();
                        if (sb2.length() > 0) {
                            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                        }
                        String str = next3.f13840name;
                        if (next3.isPriced()) {
                            str = str + " (+" + next3.getDisplayItemChoicePice() + ")";
                        }
                        sb2.append(str);
                    }
                }
            }
        }
        return sb2.toString();
    }

    public int[] getSelectedQuantityOfMandatoryAndOptionalChoices() {
        ArrayList<ChoiceSection> arrayList;
        int[] iArr = new int[2];
        this.selectedMandatorychoicesCount = 0;
        this.selectedOptionalChoicesCount = 0;
        List<ChoiceSection> list = this.allChoices;
        if (list != null && list.size() > 0 && (arrayList = this.selectedChoices) != null && arrayList.size() > 0) {
            Iterator<ChoiceSection> it = this.selectedChoices.iterator();
            while (it.hasNext()) {
                ChoiceSection next = it.next();
                if (next.isMandatoryChoiceSection()) {
                    this.selectedMandatorychoicesCount += next.itemChoices.size();
                } else {
                    this.selectedOptionalChoicesCount += next.itemChoices.size();
                }
            }
        }
        iArr[0] = this.selectedMandatorychoicesCount;
        iArr[1] = this.selectedOptionalChoicesCount;
        return iArr;
    }

    public int getSelectionProgress() {
        if (getTotalSteps() > 0) {
            return (getSelectedQuantityOfMandatoryAndOptionalChoices()[0] * 100) / getTotalSteps();
        }
        return 0;
    }

    public String getStringId() {
        return this.stringId;
    }

    public String getTotalDisplayOldPrice() {
        if (!this.isItemDiscount) {
            return "0";
        }
        return TalabatFormatter.getInstance().getFormattedCurrency(this.cartOldTotalPrice);
    }

    public String getTotalDisplayPrice() {
        return TalabatFormatter.getInstance().getFormattedCurrency(this.cartTotalPrice, true);
    }

    public String getTotalDisplayPriceWithCurrency() {
        return TalabatFormatter.getInstance().getFormattedCurrency(this.cartTotalPrice, true);
    }

    public float getTotalPrice() {
        return this.cartTotalPrice;
    }

    public int getTotalSteps() {
        int i11 = 0;
        for (ChoiceSection next : this.allChoices) {
            if (next.isMandatoryChoiceSection()) {
                i11 += next.minQuantity;
            }
        }
        return i11;
    }

    public boolean hasChoices() {
        ChoiceSection[] choiceSectionArr = this.choiceSections;
        return choiceSectionArr != null && choiceSectionArr.length > 0;
    }

    public boolean hasSelectedChoices() {
        ArrayList<ChoiceSection> arrayList = this.selectedChoices;
        return arrayList != null && arrayList.size() > 0;
    }

    public int hashCode() {
        int i11 = this.f13861id;
        return i11 > 0 ? i11 : this.stringId.hashCode();
    }

    public boolean isAllMantatoryChoiceSelected() {
        return isNewAllMantatoryChoiceSelected();
    }

    public boolean isChoiceItemSelected(int i11, int i12) {
        ArrayList<ChoiceSection> arrayList = this.selectedChoices;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        Iterator<ChoiceSection> it = this.selectedChoices.iterator();
        while (it.hasNext()) {
            ChoiceSection next = it.next();
            if (next.f13841id == i11) {
                Iterator<ChoiceItem> it2 = next.itemChoices.iterator();
                while (it2.hasNext()) {
                    if (it2.next().f13839id == i12) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public boolean isDiscounted() {
        return this.cartOldPrice > 0.0f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.stringId;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isGroceryItem() {
        /*
            r1 = this;
            int r0 = r1.f13861id
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = r1.stringId
            if (r0 == 0) goto L_0x0010
            boolean r0 = ue.m0.a(r0)
            if (r0 != 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: datamodels.CartMenuItem.isGroceryItem():boolean");
    }

    public boolean isItemHasStartPrice() {
        if (this.price == 0.0f || getDisplayPrice().equals(TalabatFormatter.getInstance().getFormattedCurrency(0.0f, true))) {
            return true;
        }
        return false;
    }

    public boolean isNewAllMantatoryChoiceSelected() {
        List<ChoiceSection> list = this.allChoices;
        if (list == null || list.size() <= 0) {
            return true;
        }
        ArrayList<ChoiceSection> arrayList = this.selectedChoices;
        if (arrayList == null || arrayList.size() <= 0) {
            return checkIfMandatoryItemsAvailable();
        }
        return thirdCondition();
    }

    public void setItemPrice(float f11) {
        this.cartItemPrice = f11;
    }

    public void setItemTotalPrice(float f11) {
        this.cartTotalPrice = f11;
    }

    public void setQuantity(int i11) {
        this.quantity = i11;
        reCalculatePrice();
    }

    public void setSelectedChoicesForSection(ChoiceSection choiceSection) {
        ChoiceSection choiceSection2;
        if (this.selectedChoices == null) {
            this.selectedChoices = new ArrayList<>();
        }
        for (ChoiceSection choiceSection3 : GlobalDataModel.SELECTED.cartMenuItem.choiceSections) {
            if (choiceSection3.f13841id == choiceSection.f13841id) {
                Iterator<ChoiceItem> it = choiceSection3.itemChoices.iterator();
                while (it.hasNext()) {
                    ChoiceItem next = it.next();
                    Iterator<ChoiceSection> it2 = this.selectedChoices.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().parentItemId == next.f13839id) {
                            it2.remove();
                        }
                    }
                }
            }
        }
        ArrayList<ChoiceSection> arrayList = this.selectedChoices;
        if (arrayList == null) {
            this.selectedChoices = new ArrayList<>();
        } else {
            Iterator<ChoiceSection> it3 = arrayList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    choiceSection2 = null;
                    break;
                }
                choiceSection2 = it3.next();
                if (choiceSection2.f13841id == choiceSection.f13841id) {
                    break;
                }
            }
            if (choiceSection2 != null) {
                this.selectedChoices.remove(choiceSection2);
            }
        }
        this.selectedChoices.add(choiceSection);
        reCalculatePrice();
    }

    public void setStringId(String str) {
        this.stringId = str;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeFloat(this.cartItemPrice);
        parcel.writeInt(this.quantity);
        parcel.writeFloat(this.cartTotalPrice);
        parcel.writeFloat(this.cartOldPrice);
        parcel.writeFloat(this.cartOldTotalPrice);
        parcel.writeByte(this.isFreeItem ? (byte) 1 : 0);
        parcel.writeByte(this.isReorderItem ? (byte) 1 : 0);
        parcel.writeByte(this.isUpsellingItem ? (byte) 1 : 0);
        parcel.writeString(this.specialRequest);
        parcel.writeInt(this.selectedMandatorychoicesCount);
        parcel.writeInt(this.selectedOptionalChoicesCount);
        parcel.writeInt(this.allMandatorychoicesCount);
        parcel.writeInt(this.allOptionalChoicesCount);
        parcel.writeFloat(this.darkStoreItemDiscountPrice);
        parcel.writeString(this.stringId);
    }

    public String getTotalDisplayPrice(boolean z11) {
        return TalabatFormatter.getInstance().getFormattedCurrency(this.cartTotalPrice, z11);
    }

    public CartMenuItem(Parcel parcel) {
        boolean z11 = false;
        this.cartItemPrice = parcel.readFloat();
        this.quantity = parcel.readInt();
        this.cartTotalPrice = parcel.readFloat();
        this.cartOldPrice = parcel.readFloat();
        this.cartOldTotalPrice = parcel.readFloat();
        this.isFreeItem = parcel.readByte() != 0;
        this.specialRequest = parcel.readString();
        this.isReorderItem = parcel.readByte() != 0;
        this.isUpsellingItem = parcel.readByte() != 0 ? true : z11;
        this.selectedMandatorychoicesCount = parcel.readInt();
        this.selectedOptionalChoicesCount = parcel.readInt();
        this.allMandatorychoicesCount = parcel.readInt();
        this.allOptionalChoicesCount = parcel.readInt();
        this.darkStoreItemDiscountPrice = parcel.readFloat();
        this.stringId = parcel.readString();
    }

    @Deprecated
    public static CartMenuItem createWith(BenefitItem benefitItem) {
        List<ChoiceSection> list;
        CartMenuItem cartMenuItem = new CartMenuItem();
        cartMenuItem.f13861id = benefitItem.itemId;
        cartMenuItem.f13862name = benefitItem.f13837name;
        cartMenuItem.desc = benefitItem.description;
        cartMenuItem.hasThumbnail = benefitItem.hasThumbnail();
        cartMenuItem.isFreeItem = true;
        cartMenuItem.setThumbnail(benefitItem.getImage());
        if (benefitItem.containsChoices && (list = benefitItem.choiceCategories) != null) {
            cartMenuItem.choiceSections = (ChoiceSection[]) list.toArray(new ChoiceSection[list.size()]);
            cartMenuItem.allChoices = new ArrayList(benefitItem.choiceCategories);
        }
        cartMenuItem.setQuantity(benefitItem.quantity);
        cartMenuItem.reCalculatePrice();
        return cartMenuItem;
    }

    public static CartMenuItem createWith(BenefitItem benefitItem, boolean z11) {
        List<ChoiceSection> list;
        CartMenuItem cartMenuItem = new CartMenuItem();
        cartMenuItem.f13861id = benefitItem.itemId;
        cartMenuItem.f13862name = benefitItem.f13837name;
        cartMenuItem.desc = benefitItem.description;
        cartMenuItem.hasThumbnail = benefitItem.hasThumbnail();
        cartMenuItem.isFreeItem = true;
        cartMenuItem.setThumbnail(benefitItem.getImage());
        if (z11) {
            if (benefitItem.choiceCategories != null) {
                cartMenuItem.selectedChoices = new ArrayList<>();
                cartMenuItem.selectedChoices = (ArrayList) benefitItem.choiceCategories;
            }
        } else if (benefitItem.containsChoices && (list = benefitItem.choiceCategories) != null) {
            cartMenuItem.choiceSections = (ChoiceSection[]) list.toArray(new ChoiceSection[list.size()]);
        }
        cartMenuItem.reCalculatePrice();
        cartMenuItem.setQuantity(benefitItem.quantity);
        return cartMenuItem;
    }
}
