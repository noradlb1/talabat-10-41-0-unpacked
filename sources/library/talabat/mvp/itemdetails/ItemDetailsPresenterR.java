package library.talabat.mvp.itemdetails;

import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceResponse;
import android.content.Context;
import buisnessmodels.Cart;
import buisnessmodels.TalabatFormatter;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.lib.Integration;
import datamodels.CartMenuItem;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tracking.AppTracker;
import tracking.ScreenNames;

public class ItemDetailsPresenterR implements IItemDetailsPresenterR, ItemDetailsListener {
    ArrayList<ChoiceSection> baseChoiceSections = new ArrayList<>();
    ArrayList<ChoiceSection> choiceSections = new ArrayList<>();
    IItemDetailsInteractor iItemDetailsInteractor;
    float mCurrentPrice;
    CartMenuItem mMenuItem;
    HashMap<Integer, Integer> mSelectedItemsForSections = new HashMap<>();
    ItemDetailsViewR mView;

    public ItemDetailsPresenterR(AppVersionProvider appVersionProvider, ItemDetailsViewR itemDetailsViewR) {
        this.mView = itemDetailsViewR;
        this.iItemDetailsInteractor = new ItemDetailsInteractor(appVersionProvider, this);
        CartMenuItem cartMenuItem = GlobalDataModel.SELECTED.cartMenuItem;
        this.mMenuItem = cartMenuItem;
        if (cartMenuItem != null && !TalabatUtils.isNullOrEmpty(cartMenuItem.f13862name)) {
            CartMenuItem cartMenuItem2 = this.mMenuItem;
            if (cartMenuItem2.f13861id > 0) {
                cartMenuItem2.setQuantity(1);
                if (isItemHasStartPrice()) {
                    this.mCurrentPrice = 0.0f;
                    return;
                } else if (!this.mMenuItem.isDiscounted() || !Integration.isGemActive()) {
                    this.mCurrentPrice = this.mMenuItem.getItemPrice();
                    return;
                } else {
                    this.mCurrentPrice = this.mMenuItem.getCartOldPrice();
                    return;
                }
            }
        }
        this.mView.onNoItem();
    }

    private String getChoicesString(ArrayList<ChoiceSection> arrayList) {
        StringBuilder sb2 = new StringBuilder();
        if (arrayList.size() == 0) {
            return "";
        }
        Iterator<ChoiceSection> it = arrayList.iterator();
        while (it.hasNext()) {
            Iterator<ChoiceItem> it2 = it.next().itemChoices.iterator();
            while (it2.hasNext()) {
                ChoiceItem next = it2.next();
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(next.f13840name);
            }
        }
        return sb2.toString();
    }

    public ArrayList<ChoiceSection> addSectionToTheList(int i11, int i12) {
        this.mSelectedItemsForSections.put(Integer.valueOf(i12), Integer.valueOf(i11));
        this.choiceSections.clear();
        this.choiceSections.addAll(this.baseChoiceSections);
        new ChoiceSection();
        int i13 = 0;
        int i14 = 0;
        for (ChoiceSection choiceSection : GlobalDataModel.SELECTED.cartMenuItem.choiceSections) {
            for (Map.Entry next : this.mSelectedItemsForSections.entrySet()) {
                if (choiceSection.parentItemId == ((Integer) next.getValue()).intValue()) {
                    int i15 = 0;
                    for (int i16 = 0; i16 < this.choiceSections.size(); i16++) {
                        if (this.choiceSections.get(i16).f13841id == ((Integer) next.getKey()).intValue()) {
                            i15 = i16;
                        }
                    }
                    if (this.choiceSections.size() > i15) {
                        if (i13 != i15) {
                            i14 = 0;
                            i13 = i15;
                        }
                        this.choiceSections.add(i15 + 1 + i14, choiceSection);
                        i14++;
                    } else {
                        this.choiceSections.add(choiceSection);
                    }
                }
            }
        }
        CartMenuItem cartMenuItem = this.mMenuItem;
        if (cartMenuItem == null) {
            this.mView.onNoItem();
        } else {
            cartMenuItem.allChoices = this.choiceSections;
        }
        return this.choiceSections;
    }

    public void addSelectedChoiceSection(ChoiceSection choiceSection) {
        float f11;
        CartMenuItem cartMenuItem = this.mMenuItem;
        if (cartMenuItem == null) {
            this.mView.onNoItem();
            return;
        }
        cartMenuItem.setSelectedChoicesForSection(choiceSection);
        ItemDetailsViewR itemDetailsViewR = this.mView;
        if (!this.mMenuItem.isDiscounted() || !Integration.isGemActive()) {
            f11 = this.mMenuItem.getTotalPrice();
        } else {
            f11 = this.mMenuItem.getCartOldTotalPrice();
        }
        itemDetailsViewR.priceChanged(f11);
        this.mView.adjustButtonTransparency();
    }

    public void addToCart(Context context) {
        String str;
        if (this.mMenuItem == null) {
            this.mView.onNoItem();
            return;
        }
        Cart instance = Cart.getInstance();
        this.mMenuItem.specialRequest = this.mView.getSpecialRequest();
        if (!instance.hasItems()) {
            instance.setRestaurant(GlobalDataModel.SELECTED.restaurant, context);
        } else if (instance.getRestaurant() != null && !instance.isRestaurantCart(GlobalDataModel.SELECTED.restaurant)) {
            this.mView.showRestaurantChangePopup(this.mMenuItem);
            return;
        }
        if (!this.mMenuItem.isAllMantatoryChoiceSelected()) {
            this.mView.onMandatoryItemsNotSelected(this.mMenuItem.getIndexOfNotSelectedMandatoryChoices());
            return;
        }
        instance.addItem(this.mMenuItem, context);
        ArrayList<ChoiceSection> arrayList = this.mMenuItem.selectedChoices;
        if (arrayList != null) {
            str = getChoicesString(arrayList);
        } else {
            str = "";
        }
        Context context2 = context;
        AppTracker.onItemAddedToCart(context2, Cart.getInstance().getRestaurant(), this.mMenuItem, AppTracker.getRestaurantId(GlobalDataModel.SELECTED.restaurant), AppTracker.getRestaurantName(GlobalDataModel.SELECTED.restaurant), "product_choice", str, this.mMenuItem.getSelectedQuantityOfMandatoryAndOptionalChoices()[0], this.mMenuItem.getSelectedQuantityOfMandatoryAndOptionalChoices()[1], ScreenNames.getScreenType(this.mView.getScreenName()), this.mView.getScreenName());
        GlobalDataModel.ANIMATIONHELPER.addItemClicked = true;
        this.mView.itemAdded(this.mMenuItem);
    }

    public void callThirdLevelChoice(String str) {
        this.iItemDetailsInteractor.callThirdLevelChoice(str);
    }

    public void changeRestaurantAndAddItem(Context context, CartMenuItem cartMenuItem) {
        if (this.mMenuItem == null) {
            this.mView.onNoItem();
        }
        Cart.getInstance().setRestaurant(GlobalDataModel.SELECTED.restaurant, context);
        addToCart(context);
    }

    public void decreaseQuantity() {
        float f11;
        CartMenuItem cartMenuItem = this.mMenuItem;
        if (cartMenuItem == null) {
            this.mView.onNoItem();
            return;
        }
        int quantity = cartMenuItem.getQuantity();
        if (quantity > 1) {
            quantity--;
        }
        this.mMenuItem.setQuantity(quantity);
        ItemDetailsViewR itemDetailsViewR = this.mView;
        if (!this.mMenuItem.isDiscounted() || !Integration.isGemActive()) {
            f11 = this.mMenuItem.getTotalPrice();
        } else {
            f11 = this.mMenuItem.getCartOldTotalPrice();
        }
        itemDetailsViewR.priceChanged(f11);
        this.mView.quantityChanged("" + quantity);
    }

    public boolean disableSpecialRequest(Restaurant restaurant) {
        if (restaurant != null) {
            return restaurant.disableItemSpecialRequest;
        }
        return false;
    }

    public boolean enableAddToCartButton() {
        CartMenuItem cartMenuItem = this.mMenuItem;
        if (cartMenuItem != null) {
            return cartMenuItem.isNewAllMantatoryChoiceSelected();
        }
        this.mView.onNoItem();
        return false;
    }

    public ArrayList<ChoiceSection> getBaseAdapterList() {
        if (this.mMenuItem == null) {
            this.mView.onNoItem();
        }
        Iterator<ChoiceSection> it = getChoiceSections().iterator();
        while (it.hasNext()) {
            ChoiceSection next = it.next();
            if (next.parentItemId == GlobalDataModel.SELECTED.cartMenuItem.f13861id) {
                this.baseChoiceSections.add(next);
            }
        }
        this.choiceSections.addAll(this.baseChoiceSections);
        this.mMenuItem.allChoices = this.choiceSections;
        return this.baseChoiceSections;
    }

    public ArrayList<ChoiceSection> getChoiceSections() {
        if (this.mMenuItem != null) {
            return new ArrayList<>(Arrays.asList(this.mMenuItem.choiceSections));
        }
        this.mView.onNoItem();
        return new ArrayList<>();
    }

    public String getItemDescription() {
        CartMenuItem cartMenuItem = this.mMenuItem;
        if (cartMenuItem != null) {
            return cartMenuItem.desc;
        }
        this.mView.onNoItem();
        return "";
    }

    public String getItemImageUrl() {
        CartMenuItem cartMenuItem = this.mMenuItem;
        if (cartMenuItem != null) {
            return cartMenuItem.getThumbnail();
        }
        this.mView.onNoItem();
        return "";
    }

    public String getItemImageUrlWithSize(int i11) {
        CartMenuItem cartMenuItem = this.mMenuItem;
        if (cartMenuItem != null) {
            return cartMenuItem.getThumbnailWithWidth(i11);
        }
        this.mView.onNoItem();
        return "";
    }

    public String getItemName() {
        CartMenuItem cartMenuItem = this.mMenuItem;
        if (cartMenuItem != null && !TalabatUtils.isNullOrEmpty(cartMenuItem.f13862name)) {
            return this.mMenuItem.f13862name;
        }
        this.mView.onNoItem();
        return "";
    }

    public String getItemOldPrice() {
        CartMenuItem cartMenuItem = this.mMenuItem;
        if (cartMenuItem != null) {
            return cartMenuItem.getDisplayOldPriceNonFormatted();
        }
        this.mView.onNoItem();
        return "";
    }

    public String getItemPrice() {
        CartMenuItem cartMenuItem = this.mMenuItem;
        if (cartMenuItem != null) {
            return cartMenuItem.getDisplayPrice();
        }
        this.mView.onNoItem();
        return "";
    }

    public String getItemStartPrice() {
        CartMenuItem cartMenuItem = this.mMenuItem;
        if (cartMenuItem != null) {
            return cartMenuItem.getDisplayStartsWithPrice(true);
        }
        this.mView.onNoItem();
        return "";
    }

    public ChoiceSection getSelectedChoice(int i11) {
        CartMenuItem cartMenuItem = this.mMenuItem;
        if (cartMenuItem != null) {
            return cartMenuItem.getSelectedChoiceForSectionId(i11);
        }
        this.mView.onNoItem();
        return null;
    }

    public boolean hasChoiceSections() {
        if (this.mMenuItem == null) {
            this.mView.onNoItem();
        }
        if (getChoiceSections().size() > 0) {
            return true;
        }
        return false;
    }

    public void increaseQuantity() {
        float f11;
        CartMenuItem cartMenuItem = this.mMenuItem;
        if (cartMenuItem == null) {
            this.mView.onNoItem();
            return;
        }
        int quantity = cartMenuItem.getQuantity();
        if (quantity < 100) {
            quantity++;
        }
        this.mMenuItem.setQuantity(quantity);
        ItemDetailsViewR itemDetailsViewR = this.mView;
        if (!this.mMenuItem.isDiscounted() || !Integration.isGemActive()) {
            f11 = this.mMenuItem.getTotalPrice();
        } else {
            f11 = this.mMenuItem.getCartOldTotalPrice();
        }
        itemDetailsViewR.priceChanged(f11);
        ItemDetailsViewR itemDetailsViewR2 = this.mView;
        itemDetailsViewR2.quantityChanged("" + quantity);
    }

    public boolean isChoiceItemSelectedOrNot(int i11, int i12) {
        CartMenuItem cartMenuItem = this.mMenuItem;
        if (cartMenuItem != null) {
            return cartMenuItem.isChoiceItemSelected(i11, i12);
        }
        this.mView.onNoItem();
        return false;
    }

    public boolean isChoiceSelected() {
        CartMenuItem cartMenuItem = this.mMenuItem;
        if (cartMenuItem == null) {
            this.mView.onNoItem();
            return false;
        }
        for (ChoiceSection choiceSection : cartMenuItem.choiceSections) {
            if (this.mMenuItem.getSelectedChoiceForSectionId(choiceSection.f13841id) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean isItemHasDiscount() {
        return this.mMenuItem.isDiscounted();
    }

    public boolean isItemHasStartPrice() {
        if (getItemPrice().equals("0") || getItemPrice().equals(TalabatFormatter.getInstance().getFormattedCurrency(0.0f, true))) {
            return true;
        }
        return false;
    }

    public void itemSelectionChanged(ChoiceItem choiceItem, boolean z11) {
        CartMenuItem cartMenuItem = this.mMenuItem;
        if (cartMenuItem != null) {
            this.mView.setChoicesName(cartMenuItem.getSelectedMandatoryAndOptionalChoicesForDisplay());
            this.mView.setSelectionProgress(this.mMenuItem.getSelectionProgress());
        }
        if (this.mMenuItem == null) {
            this.mView.onNoItem();
        }
        this.mView.adjustButtonTransparency();
    }

    public void onDataError() {
        this.mView.onDataError();
    }

    public void onDestroy() {
        this.mView = null;
        IItemDetailsInteractor iItemDetailsInteractor2 = this.iItemDetailsInteractor;
        if (iItemDetailsInteractor2 != null) {
            iItemDetailsInteractor2.unregister();
        }
        this.iItemDetailsInteractor = null;
    }

    public void onNetworkError() {
        this.mView.onNetworkError();
    }

    public void onServerError(VolleyError volleyError) {
        this.mView.onServerError(volleyError);
    }

    public void onThirdLevelChoicesReceived(SplitChoiceResponse splitChoiceResponse) {
        this.mView.onThirdLevelChoicesReceived(splitChoiceResponse);
    }

    public void onToolBarVisible(boolean z11) {
        CartMenuItem cartMenuItem = this.mMenuItem;
        if (cartMenuItem == null || !z11) {
            this.mView.hideChoiceNames();
            this.mView.setSelectionProgress(0);
            return;
        }
        this.mView.setChoicesName(cartMenuItem.getSelectedMandatoryAndOptionalChoicesForDisplay());
        this.mView.setSelectionProgress(this.mMenuItem.getSelectionProgress());
    }

    public void itemSelectionChanged(ArrayList<ChoiceItem> arrayList, boolean z11) {
        if (this.mMenuItem == null) {
            this.mView.onNoItem();
        }
        if (z11) {
            Iterator<ChoiceItem> it = arrayList.iterator();
            while (it.hasNext()) {
                ChoiceItem next = it.next();
                if (!next.isDiscounted() || !Integration.isGemActive()) {
                    this.mCurrentPrice += next.price;
                } else {
                    this.mCurrentPrice += next.oldPrice;
                }
                this.mView.priceChanged(this.mCurrentPrice);
            }
            return;
        }
        Iterator<ChoiceItem> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ChoiceItem next2 = it2.next();
            if (!next2.isDiscounted() || !Integration.isGemActive()) {
                this.mCurrentPrice -= next2.price;
            } else {
                this.mCurrentPrice -= next2.oldPrice;
            }
            this.mView.priceChanged(this.mCurrentPrice);
        }
    }
}
