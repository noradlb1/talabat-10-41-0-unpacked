package library.talabat.mvp.menu_cart_item;

import android.content.Context;
import android.widget.ImageView;
import buisnessmodels.Cart;
import buisnessmodels.GEMEngine;
import com.talabat.helpers.GlobalDataModel;
import datamodels.CartMenuItem;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.Iterator;
import tracking.AppTracker;
import tracking.ScreenNames;

public class MenuCartItemPresenterBase implements IMenuCartItemPresenterBase {
    private void addItemToCart(Cart cart, CartMenuItem cartMenuItem, MenuCartItemViewBase menuCartItemViewBase) {
        String str;
        if (cart.getCartItemQuantity(cartMenuItem) < 99) {
            cart.addItem(cartMenuItem, menuCartItemViewBase.getContext());
            ArrayList<ChoiceSection> arrayList = cartMenuItem.selectedChoices;
            if (arrayList != null) {
                str = getChoicesString(arrayList);
            } else {
                str = "";
            }
            CartMenuItem cartMenuItem2 = cartMenuItem;
            AppTracker.onItemAddedToCart(menuCartItemViewBase.getContext(), Cart.getInstance().getRestaurant(), cartMenuItem2, AppTracker.getRestaurantId(GlobalDataModel.SELECTED.restaurant), AppTracker.getRestaurantName(GlobalDataModel.SELECTED.restaurant), "", str, 0, 0, ScreenNames.getScreenType(menuCartItemViewBase.getScreenName()), menuCartItemViewBase.getScreenName());
            menuCartItemViewBase.onItemAdded(cartMenuItem);
            return;
        }
        menuCartItemViewBase.onMaxCartItemsReached();
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

    public void addItem(Restaurant restaurant, CartMenuItem cartMenuItem, MenuCartItemViewBase menuCartItemViewBase) {
        if (cartMenuItem.hasChoices()) {
            menuCartItemViewBase.onNavigateToItemDetails(cartMenuItem, (ImageView) null);
            return;
        }
        Cart instance = Cart.getInstance();
        if (!instance.hasItems()) {
            instance.setRestaurant(restaurant, menuCartItemViewBase.getContext());
            GlobalDataModel.GEMCONSTANTS.cartCouponSupressed = false;
            if (GlobalDataModel.GEMCONSTANTS.isGemFlow && GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().supressCouponsAndPromotionForCart();
            }
            addItemToCart(instance, cartMenuItem, menuCartItemViewBase);
        } else if (instance.isRestaurantCart(restaurant)) {
            if (GlobalDataModel.GEMCONSTANTS.isGemFlow && GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().supressCouponsAndPromotionForCart();
            }
            addItemToCart(instance, cartMenuItem, menuCartItemViewBase);
        } else {
            menuCartItemViewBase.showRestaurantChangePopup(restaurant, cartMenuItem);
        }
    }

    public void changeRestaurantAndAddItem(Context context, Restaurant restaurant, CartMenuItem cartMenuItem, MenuCartItemViewBase menuCartItemViewBase) {
        Cart instance = Cart.getInstance();
        instance.setRestaurant(restaurant, context);
        GlobalDataModel.GEMCONSTANTS.cartCouponSupressed = false;
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow && GEMEngine.getInstance() != null) {
            GEMEngine.getInstance().supressCouponsAndPromotionForCart();
        }
        addItemToCart(instance, cartMenuItem, menuCartItemViewBase);
    }

    public void onDestroy() {
    }
}
