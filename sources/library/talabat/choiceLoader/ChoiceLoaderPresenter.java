package library.talabat.choiceLoader;

import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.GlobalDataModel;
import datamodels.MenuItem;
import datamodels.MenuSection;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.Iterator;

public class ChoiceLoaderPresenter implements IChoiceLoaderPresenter, ChoiceLoaderListener {

    /* renamed from: a  reason: collision with root package name */
    public MenuSection[] f26519a;

    /* renamed from: b  reason: collision with root package name */
    public Restaurant f26520b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f26521c;
    private IChoiceLoaderInteractor choiceLoaderInteractor;

    /* renamed from: d  reason: collision with root package name */
    public int f26522d;
    private boolean processing = false;
    private ArrayList<SplitChoiceItemModel[]> splitChoiceItemModels;

    public ChoiceLoaderPresenter(AppVersionProvider appVersionProvider) {
        this.choiceLoaderInteractor = new ChoiceLoaderInteractor(appVersionProvider, this);
        this.splitChoiceItemModels = new ArrayList<>(GlobalDataModel.MENU.requiredCount);
        this.f26521c = new ArrayList<>();
    }

    private void callRequestExecutor() {
        GlobalDataModel.MENU.responseReceived = 0;
        for (int i11 = 0; i11 < GlobalDataModel.MENU.requestAtOnceCount; i11++) {
            if (this.f26521c.size() > 0 && !GlobalDataModel.MENU.doNotLoad) {
                this.choiceLoaderInteractor.getAllChoicesForVisibleMenuSection(this.f26522d, this.f26521c.get(0));
                this.f26521c.remove(0);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = com.talabat.helpers.GlobalDataModel.JSON.menuItemsResponseModel;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadGloabalMenuModel(datamodels.MenuSection[] r4) {
        /*
            r3 = this;
            boolean r0 = com.talabat.helpers.GlobalDataModel.MENU.doNotLoad
            if (r0 != 0) goto L_0x0012
            JsonModels.MenuItemsResponseModel r0 = com.talabat.helpers.GlobalDataModel.JSON.menuItemsResponseModel
            datamodels.Restaurant r1 = r0.restaurant
            if (r1 == 0) goto L_0x0012
            datamodels.Restaurant r2 = r3.f26520b
            if (r2 != r1) goto L_0x0012
            JsonModels.MenuItemRM r0 = r0.menu
            r0.menuSection = r4
        L_0x0012:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.choiceLoader.ChoiceLoaderPresenter.loadGloabalMenuModel(datamodels.MenuSection[]):void");
    }

    public void onChoiceReceived(SplitChoiceItemModel[] splitChoiceItemModelArr) {
        SplitChoiceItemModel[] splitChoiceItemModelArr2 = splitChoiceItemModelArr;
        if (!this.processing) {
            this.processing = true;
            MenuItemsResponseModel menuItemsResponseModel = GlobalDataModel.JSON.menuItemsResponseModel;
            MenuItemRM menuItemRM = menuItemsResponseModel.menu;
            if (menuItemRM != null) {
                MenuSection[] menuSectionArr = menuItemRM.menuSection;
                if (menuSectionArr.length > 0) {
                    this.f26519a = menuSectionArr;
                    this.f26520b = menuItemsResponseModel.restaurant;
                    for (MenuSection menuSection : menuSectionArr) {
                        if (!GlobalDataModel.MENU.doNotLoad) {
                            for (SplitChoiceItemModel splitChoiceItemModel : splitChoiceItemModelArr2) {
                                if (GlobalDataModel.MENU.doNotLoad) {
                                    break;
                                }
                                for (MenuItem menuItem : menuSection.items) {
                                    if (GlobalDataModel.MENU.doNotLoad) {
                                        break;
                                    }
                                    if (splitChoiceItemModel.f480id == menuItem.f13861id) {
                                        if (menuItem.price == 0.0f) {
                                            GlobalDataModel.MENU.priceOnSelectionItemAvailable = true;
                                        }
                                        menuItem.choiceSections = splitChoiceItemModel.choiceSections;
                                        menuItem.choicesLoaded = true;
                                    }
                                }
                            }
                        }
                    }
                    loadGloabalMenuModel(this.f26519a);
                }
            }
            this.processing = false;
            Iterator<SplitChoiceItemModel[]> it = this.splitChoiceItemModels.iterator();
            while (it.hasNext()) {
                SplitChoiceItemModel[] next = it.next();
                if (next != null) {
                    onChoiceReceived(next);
                }
            }
        } else {
            Iterator<SplitChoiceItemModel[]> it2 = this.splitChoiceItemModels.iterator();
            while (it2.hasNext()) {
                SplitChoiceItemModel[] next2 = it2.next();
            }
        }
        int i11 = GlobalDataModel.MENU.responseReceived + 1;
        GlobalDataModel.MENU.responseReceived = i11;
        if (i11 == GlobalDataModel.MENU.requestAtOnceCount) {
            callRequestExecutor();
        }
    }

    public void onDataError() {
    }

    public void onDestroy() {
        IChoiceLoaderInteractor iChoiceLoaderInteractor = this.choiceLoaderInteractor;
        if (iChoiceLoaderInteractor != null) {
            iChoiceLoaderInteractor.unregister();
        }
        this.choiceLoaderInteractor = null;
    }

    public void onNetworkError() {
    }

    public void onNoChoiceAvailable() {
    }

    public void onServerError(VolleyError volleyError) {
    }

    public void setRequestItemIds(int i11, ArrayList<String> arrayList) {
        this.f26522d = i11;
        ArrayList<String> arrayList2 = this.f26521c;
        if (arrayList2 != null) {
            arrayList2.clear();
        } else {
            this.f26521c = new ArrayList<>();
        }
        this.f26521c.addAll(arrayList);
        if (!GlobalDataModel.MENU.doNotLoad) {
            callRequestExecutor();
        }
    }

    public void stopChoiceLoading() {
        ArrayList<String> arrayList = this.f26521c;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.f26521c = new ArrayList<>();
        }
    }
}
