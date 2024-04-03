package buisnessmodels.restaurantmenu;

import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse;
import com.talabat.core.observabilityNew.domain.squads.menu.MenuScreenPerformanceParams;
import com.talabat.restaurantmenu.MenuModel;
import datamodels.DeliveryArea;
import datamodels.MenuItem;
import datamodels.PromotionDisplay;
import datamodels.Restaurant;
import datamodels.Warning;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lbuisnessmodels/restaurantmenu/MenuResponseMapper;", "", "()V", "menuModel", "Lcom/talabat/restaurantmenu/MenuModel;", "getMenuModel", "()Lcom/talabat/restaurantmenu/MenuModel;", "setMenuModel", "(Lcom/talabat/restaurantmenu/MenuModel;)V", "clear", "", "updateMenu", "menu", "LJsonModels/MenuItemRM;", "updateMenuItemsResponseModelSpecifics", "menuItemsResponseModel", "LJsonModels/MenuItemsResponseModel;", "updateRestaurant", "restaurant", "Ldatamodels/Restaurant;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MenuResponseMapper {
    @NotNull
    public static final MenuResponseMapper INSTANCE = new MenuResponseMapper();
    @NotNull
    private static MenuModel menuModel = new MenuModel((MenuItemsResponseModel) null, (Restaurant) null, (TgoFreeDeliveryResponse) null, (MenuItemRM) null, (ArrayList) null, (String) null, (PromotionDisplay[]) null, (DeliveryArea[]) null, (Warning[]) null, 511, (DefaultConstructorMarker) null);

    private MenuResponseMapper() {
    }

    public final void clear() {
        menuModel = new MenuModel((MenuItemsResponseModel) null, (Restaurant) null, (TgoFreeDeliveryResponse) null, (MenuItemRM) null, (ArrayList) null, (String) null, (PromotionDisplay[]) null, (DeliveryArea[]) null, (Warning[]) null, 511, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final MenuModel getMenuModel() {
        return menuModel;
    }

    public final void setMenuModel(@NotNull MenuModel menuModel2) {
        Intrinsics.checkNotNullParameter(menuModel2, "<set-?>");
        menuModel = menuModel2;
    }

    public final void updateMenu(@NotNull MenuItemRM menuItemRM) {
        Intrinsics.checkNotNullParameter(menuItemRM, MenuScreenPerformanceParams.SCREEN_TYPE);
        menuModel.setMenu(menuItemRM);
        menuModel.getMenuItemsResponseModel().menu = menuItemRM;
    }

    public final void updateMenuItemsResponseModelSpecifics(@NotNull MenuItemsResponseModel menuItemsResponseModel) {
        Intrinsics.checkNotNullParameter(menuItemsResponseModel, "menuItemsResponseModel");
        MenuModel menuModel2 = menuModel;
        Warning[] warningArr = menuItemsResponseModel.warnings;
        if (warningArr == null) {
            warningArr = new Warning[0];
        }
        menuModel2.setWarnings(warningArr);
        MenuModel menuModel3 = menuModel;
        DeliveryArea[] deliveryAreaArr = menuItemsResponseModel.deliveryAreas;
        if (deliveryAreaArr == null) {
            deliveryAreaArr = new DeliveryArea[0];
        }
        menuModel3.setDeliveryAreas(deliveryAreaArr);
        MenuModel menuModel4 = menuModel;
        PromotionDisplay[] promotionDisplayArr = menuItemsResponseModel.promotions;
        if (promotionDisplayArr == null) {
            promotionDisplayArr = new PromotionDisplay[0];
        }
        menuModel4.setPromotions(promotionDisplayArr);
        MenuModel menuModel5 = menuModel;
        ArrayList<MenuItem> arrayList = menuItemsResponseModel.upsellingItems;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        menuModel5.setUpsellingItems(arrayList);
        MenuModel menuModel6 = menuModel;
        String str = menuItemsResponseModel.heroImage;
        if (str == null) {
            str = "";
        }
        menuModel6.setHeroImage(str);
        MenuModel menuModel7 = menuModel;
        TgoFreeDeliveryResponse tgoFreeDeliveryResponse = menuItemsResponseModel.tgoFreeDeliveryResponse;
        if (tgoFreeDeliveryResponse == null) {
            tgoFreeDeliveryResponse = new TgoFreeDeliveryResponse();
        }
        menuModel7.setTgoFreeDeliveryResponse(tgoFreeDeliveryResponse);
        menuModel.getMenuItemsResponseModel().warnings = menuItemsResponseModel.warnings;
        menuModel.getMenuItemsResponseModel().deliveryAreas = menuItemsResponseModel.deliveryAreas;
        menuModel.getMenuItemsResponseModel().promotions = menuItemsResponseModel.promotions;
        menuModel.getMenuItemsResponseModel().upsellingItems = menuItemsResponseModel.upsellingItems;
        menuModel.getMenuItemsResponseModel().heroImage = menuItemsResponseModel.heroImage;
        menuModel.getMenuItemsResponseModel().tgoFreeDeliveryResponse = menuItemsResponseModel.tgoFreeDeliveryResponse;
    }

    public final void updateRestaurant(@NotNull Restaurant restaurant) {
        Intrinsics.checkNotNullParameter(restaurant, "restaurant");
        menuModel.setRestaurant(restaurant);
    }
}
