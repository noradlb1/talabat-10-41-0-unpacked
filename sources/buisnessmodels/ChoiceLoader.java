package buisnessmodels;

import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import datamodels.MenuItem;
import datamodels.MenuSection;
import java.util.ArrayList;
import java.util.Iterator;
import library.talabat.choiceLoader.ChoiceLoaderPresenter;
import library.talabat.choiceLoader.IChoiceLoaderPresenter;

public class ChoiceLoader {
    private static ChoiceLoader choiceLoaderInstance;
    private IChoiceLoaderPresenter choiceLoaderPresenter;
    private int count;
    private ArrayList<Integer> itemIdList;
    private StringBuilder itemIdStringBuilder;
    private ArrayList<String> requestList;

    public static ChoiceLoader getInstance() {
        return choiceLoaderInstance;
    }

    public static void startChoiceLoader(AppVersionProvider appVersionProvider) {
        MenuItemRM menuItemRM;
        MenuSection[] menuSectionArr;
        ChoiceLoader choiceLoader = new ChoiceLoader();
        choiceLoaderInstance = choiceLoader;
        choiceLoader.count = 0;
        choiceLoader.requestList = new ArrayList<>();
        choiceLoaderInstance.itemIdList = new ArrayList<>();
        MenuItemsResponseModel menuItemsResponseModel = GlobalDataModel.JSON.menuItemsResponseModel;
        if (menuItemsResponseModel != null && (menuItemRM = menuItemsResponseModel.menu) != null && (menuSectionArr = menuItemRM.menuSection) != null) {
            for (MenuSection menuSection : menuSectionArr) {
                for (MenuItem menuItem : menuSection.items) {
                    if (!menuItem.isChoicesLoaded() && menuItem.willHaveChoices() && menuItem.price == 0.0f && !choiceLoaderInstance.itemIdList.contains(Integer.valueOf(menuItem.f13861id))) {
                        choiceLoaderInstance.itemIdList.add(Integer.valueOf(menuItem.f13861id));
                    }
                }
            }
            ChoiceLoader choiceLoader2 = choiceLoaderInstance;
            choiceLoader2.count = choiceLoader2.itemIdList.size();
            GlobalDataModel.MENU.doNotLoad = false;
            choiceLoaderInstance.choiceLoaderPresenter = new ChoiceLoaderPresenter(appVersionProvider);
            int i11 = choiceLoaderInstance.count;
            if (i11 > 0) {
                GlobalDataModel.MENU.requiredCount = (i11 / 10) + 1;
                choiceLoaderInstance.getChoices();
            }
        }
    }

    public static void stopChoiceLoader() {
        IChoiceLoaderPresenter iChoiceLoaderPresenter = choiceLoaderInstance.choiceLoaderPresenter;
        if (iChoiceLoaderPresenter != null) {
            iChoiceLoaderPresenter.stopChoiceLoading();
        }
        choiceLoaderInstance.count = 0;
        choiceLoaderInstance = null;
    }

    public void getChoices() {
        String str;
        Iterator<Integer> it = choiceLoaderInstance.itemIdList.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            Integer next = it.next();
            if (!GlobalDataModel.MENU.priceOnSelectionItemAvailable) {
                GlobalDataModel.MENU.priceOnSelectionItemAvailable = true;
            }
            if (i11 % 10 == 0) {
                this.itemIdStringBuilder = new StringBuilder();
            }
            if (this.itemIdStringBuilder.length() > 0 && next.intValue() > 0) {
                this.itemIdStringBuilder.append(",");
            }
            if (next.intValue() > 0) {
                this.itemIdStringBuilder.append(next);
            }
            i11++;
            if (i11 % 10 == 0 || i11 == choiceLoaderInstance.count) {
                if (this.itemIdStringBuilder.length() > 0) {
                    str = this.itemIdStringBuilder.toString();
                } else {
                    str = "";
                }
                if (this.choiceLoaderPresenter != null && !TalabatUtils.isNullOrEmpty(str)) {
                    this.requestList.add(str);
                    if (!GlobalDataModel.MENU.doNotLoad && i11 == choiceLoaderInstance.count) {
                        this.choiceLoaderPresenter.setRequestItemIds(GlobalDataModel.SELECTED.restaurant.getBranchId(), this.requestList);
                    }
                }
            }
        }
    }
}
