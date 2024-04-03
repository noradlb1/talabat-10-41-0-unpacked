package library.talabat.mvp.itemdetails;

import android.content.Context;
import buisnessmodels.Cart;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.lib.Integration;
import datamodels.CartMenuItem;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import java.util.ArrayList;
import java.util.Iterator;
import tracking.AppTracker;
import tracking.ScreenNames;

public class ItemDetailsPresenter implements IItemDetailsPresenter {
    private CartMenuItem cartMenuItem;
    private ItemDetailsView itemDetailsView;

    public ItemDetailsPresenter(ItemDetailsView itemDetailsView2) {
        this.itemDetailsView = itemDetailsView2;
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

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addSelectedChoiceSection(datamodels.ChoiceSection r3) {
        /*
            r2 = this;
            datamodels.CartMenuItem r0 = r2.cartMenuItem
            r0.setSelectedChoicesForSection(r3)
            boolean r3 = com.talabat.lib.Integration.isGemActive()
            if (r3 == 0) goto L_0x001b
            datamodels.CartMenuItem r3 = r2.cartMenuItem
            boolean r0 = r3.isItemDiscount
            if (r0 == 0) goto L_0x001b
            library.talabat.mvp.itemdetails.ItemDetailsView r0 = r2.itemDetailsView
            java.lang.String r3 = r3.getTotalDisplayOldPrice()
            r0.setPrice(r3)
            goto L_0x0027
        L_0x001b:
            library.talabat.mvp.itemdetails.ItemDetailsView r3 = r2.itemDetailsView
            datamodels.CartMenuItem r0 = r2.cartMenuItem
            r1 = 1
            java.lang.String r0 = r0.getTotalDisplayPrice(r1)
            r3.setPrice(r0)
        L_0x0027:
            datamodels.CartMenuItem r3 = r2.cartMenuItem
            boolean r3 = r3.isDiscounted()
            if (r3 == 0) goto L_0x0040
            boolean r3 = com.talabat.lib.Integration.isGemActive()
            if (r3 != 0) goto L_0x0040
            library.talabat.mvp.itemdetails.ItemDetailsView r3 = r2.itemDetailsView
            datamodels.CartMenuItem r0 = r2.cartMenuItem
            java.lang.String r0 = r0.getTotalDisplayOldPrice()
            r3.setStrikeoutPrice(r0)
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.itemdetails.ItemDetailsPresenter.addSelectedChoiceSection(datamodels.ChoiceSection):void");
    }

    public void addToCart(Context context) {
        String str;
        Cart instance = Cart.getInstance();
        this.cartMenuItem.specialRequest = this.itemDetailsView.getSpecialRequest();
        if (!instance.hasItems()) {
            instance.setRestaurant(GlobalDataModel.SELECTED.restaurant, context);
        } else if (instance.getRestaurant() != null && !instance.isRestaurantCart(GlobalDataModel.SELECTED.restaurant)) {
            this.itemDetailsView.showRestaurantChangePopup(this.cartMenuItem);
            return;
        }
        if (!this.cartMenuItem.isAllMantatoryChoiceSelected()) {
            this.itemDetailsView.showChoiceNotSelectedPopup(this.cartMenuItem.getIndexofNotSelectedMandatoryChoices());
            return;
        }
        instance.addItem(this.cartMenuItem, context);
        ArrayList<ChoiceSection> arrayList = this.cartMenuItem.selectedChoices;
        if (arrayList != null) {
            str = getChoicesString(arrayList);
        } else {
            str = "";
        }
        AppTracker.onItemAddedToCart(this.itemDetailsView.getContext(), Cart.getInstance().getRestaurant(), this.cartMenuItem, AppTracker.getRestaurantId(GlobalDataModel.SELECTED.restaurant), AppTracker.getRestaurantName(GlobalDataModel.SELECTED.restaurant), "product choice", str, this.cartMenuItem.getSelectedQuantityOfMandatoryAndOptionalChoices()[0], this.cartMenuItem.getSelectedQuantityOfMandatoryAndOptionalChoices()[1], ScreenNames.getScreenType(this.itemDetailsView.getScreenName()), this.itemDetailsView.getScreenName());
        GlobalDataModel.ANIMATIONHELPER.addItemClicked = true;
        this.itemDetailsView.itemAdded(this.cartMenuItem);
    }

    public void changeRestaurantAndAddItemToCart(Context context, CartMenuItem cartMenuItem2) {
        Cart.getInstance().setRestaurant(GlobalDataModel.SELECTED.restaurant, context);
        addToCart(context);
    }

    public void decreaseQuantity() {
        int quantity = this.cartMenuItem.getQuantity();
        if (quantity > 1) {
            quantity--;
        }
        this.cartMenuItem.setQuantity(quantity);
        if (Integration.isGemActive()) {
            CartMenuItem cartMenuItem2 = this.cartMenuItem;
            if (cartMenuItem2.isItemDiscount) {
                this.itemDetailsView.setPrice(cartMenuItem2.getTotalDisplayOldPrice());
                if (this.cartMenuItem.isDiscounted() && !Integration.isGemActive()) {
                    this.itemDetailsView.setStrikeoutPrice(this.cartMenuItem.getTotalDisplayOldPrice());
                }
                this.itemDetailsView.setQuantity("" + quantity);
            }
        }
        this.itemDetailsView.setPrice(this.cartMenuItem.getTotalDisplayPrice(true));
        this.itemDetailsView.setStrikeoutPrice(this.cartMenuItem.getTotalDisplayOldPrice());
        this.itemDetailsView.setQuantity("" + quantity);
    }

    public void freeItemChoiceSelected() {
        if (this.cartMenuItem.isAllMantatoryChoiceSelected()) {
            this.itemDetailsView.itemAdded(this.cartMenuItem);
        } else {
            this.itemDetailsView.showChoiceNotSelectedPopup(this.cartMenuItem.getIndexofNotSelectedMandatoryChoices());
        }
    }

    public void increaseQuantity() {
        int quantity = this.cartMenuItem.getQuantity();
        if (quantity < 100) {
            quantity++;
        }
        this.cartMenuItem.setQuantity(quantity);
        if (Integration.isGemActive()) {
            CartMenuItem cartMenuItem2 = this.cartMenuItem;
            if (cartMenuItem2.isItemDiscount) {
                this.itemDetailsView.setPrice(cartMenuItem2.getTotalDisplayOldPrice());
                if (this.cartMenuItem.isDiscounted() && !Integration.isGemActive()) {
                    this.itemDetailsView.setStrikeoutPrice(this.cartMenuItem.getTotalDisplayOldPrice());
                }
                ItemDetailsView itemDetailsView2 = this.itemDetailsView;
                itemDetailsView2.setQuantity("" + quantity);
            }
        }
        this.itemDetailsView.setPrice(this.cartMenuItem.getTotalDisplayPrice(true));
        this.itemDetailsView.setStrikeoutPrice(this.cartMenuItem.getTotalDisplayOldPrice());
        ItemDetailsView itemDetailsView22 = this.itemDetailsView;
        itemDetailsView22.setQuantity("" + quantity);
    }

    public void onDestroy() {
        this.itemDetailsView = null;
    }

    public void setCartMenuItem(CartMenuItem cartMenuItem2) {
        this.cartMenuItem = cartMenuItem2;
        cartMenuItem2.setQuantity(1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setItemDetails() {
        /*
            r3 = this;
            library.talabat.mvp.itemdetails.ItemDetailsView r0 = r3.itemDetailsView
            datamodels.CartMenuItem r1 = r3.cartMenuItem
            java.lang.String r1 = r1.f13862name
            r0.setTitle(r1)
            library.talabat.mvp.itemdetails.ItemDetailsView r0 = r3.itemDetailsView
            datamodels.CartMenuItem r1 = r3.cartMenuItem
            java.lang.String r1 = r1.desc
            r0.setDescription(r1)
            boolean r0 = com.talabat.lib.Integration.isGemActive()
            if (r0 == 0) goto L_0x0028
            datamodels.CartMenuItem r0 = r3.cartMenuItem
            boolean r1 = r0.isItemDiscount
            if (r1 == 0) goto L_0x0028
            library.talabat.mvp.itemdetails.ItemDetailsView r1 = r3.itemDetailsView
            java.lang.String r0 = r0.getDisplayOldPrice()
            r1.setPrice(r0)
            goto L_0x0033
        L_0x0028:
            library.talabat.mvp.itemdetails.ItemDetailsView r0 = r3.itemDetailsView
            datamodels.CartMenuItem r1 = r3.cartMenuItem
            java.lang.String r1 = r1.getDisplayPrice()
            r0.setPrice(r1)
        L_0x0033:
            library.talabat.mvp.itemdetails.ItemDetailsView r0 = r3.itemDetailsView
            datamodels.CartMenuItem r1 = r3.cartMenuItem
            boolean r2 = r1.hasThumbnail
            java.lang.String r1 = r1.getThumbnail()
            r0.setImage(r2, r1)
            library.talabat.mvp.itemdetails.ItemDetailsView r0 = r3.itemDetailsView
            datamodels.CartMenuItem r1 = r3.cartMenuItem
            datamodels.ChoiceSection[] r1 = r1.choiceSections
            r0.setChoiceLayout(r1)
            datamodels.CartMenuItem r0 = r3.cartMenuItem
            boolean r0 = r0.isDiscounted()
            if (r0 == 0) goto L_0x0062
            boolean r0 = com.talabat.lib.Integration.isGemActive()
            if (r0 != 0) goto L_0x0062
            library.talabat.mvp.itemdetails.ItemDetailsView r0 = r3.itemDetailsView
            datamodels.CartMenuItem r1 = r3.cartMenuItem
            java.lang.String r1 = r1.getTotalDisplayOldPrice()
            r0.setStrikeoutPrice(r1)
        L_0x0062:
            datamodels.Restaurant r0 = com.talabat.helpers.GlobalDataModel.SELECTED.restaurant
            if (r0 == 0) goto L_0x0078
            library.talabat.mvp.itemdetails.ItemDetailsView r0 = r3.itemDetailsView
            android.content.Context r0 = r0.getContext()
            datamodels.CartMenuItem r1 = r3.cartMenuItem
            datamodels.Restaurant r2 = com.talabat.helpers.GlobalDataModel.SELECTED.restaurant
            java.lang.String r2 = tracking.AppTracker.getRestaurantName(r2)
            tracking.AppTracker.onProductView(r0, r1, r2)
            goto L_0x008f
        L_0x0078:
            library.talabat.mvp.itemdetails.ItemDetailsView r0 = r3.itemDetailsView
            android.content.Context r0 = r0.getContext()
            datamodels.CartMenuItem r1 = r3.cartMenuItem
            buisnessmodels.Cart r2 = buisnessmodels.Cart.getInstance()
            datamodels.Restaurant r2 = r2.getRestaurant()
            java.lang.String r2 = tracking.AppTracker.getRestaurantName(r2)
            tracking.AppTracker.onProductView(r0, r1, r2)
        L_0x008f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.itemdetails.ItemDetailsPresenter.setItemDetails():void");
    }
}
