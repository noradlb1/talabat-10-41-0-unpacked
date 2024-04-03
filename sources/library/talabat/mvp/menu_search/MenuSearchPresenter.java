package library.talabat.mvp.menu_search;

import JsonModels.Response.GroceryResponse.GrocerySearchResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import JsonModels.parser.UniversalGson;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.EditText;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.rxbinding3.widget.RxTextView;
import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.lib.Integration;
import datamodels.CartMenuItem;
import datamodels.MenuItem;
import datamodels.MenuSection;
import datamodels.Restaurant;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import library.talabat.mvp.menu_cart_item.MenuCartItemPresenterBase;
import library.talabat.mvp.menu_cart_item.MenuCartItemViewBase;

@Instrumented
public class MenuSearchPresenter extends MenuCartItemPresenterBase implements IMenuSearchPresenter, MenuSearchListener {

    /* renamed from: a  reason: collision with root package name */
    public Restaurant f26760a;

    /* renamed from: b  reason: collision with root package name */
    public MenuCartItemViewBase f26761b;

    /* renamed from: c  reason: collision with root package name */
    public PublishSubject<Integer> f26762c = PublishSubject.create();
    /* access modifiers changed from: private */
    public boolean disableAutomaticSearch;
    private CompositeDisposable disposable = new CompositeDisposable();
    /* access modifiers changed from: private */
    public String filterBrands;
    /* access modifiers changed from: private */
    public IMenuSearchInteractor iMenuSearchInteractor;
    /* access modifiers changed from: private */
    public int newPageNumber;
    /* access modifiers changed from: private */
    public String previousQuery = "";
    /* access modifiers changed from: private */
    public PublishSubject<String> publishSubject = PublishSubject.create();
    /* access modifiers changed from: private */
    public String query;
    /* access modifiers changed from: private */
    public EditText searchEditText;
    /* access modifiers changed from: private */
    public String selectedTagsString = "";
    private String sharedPreferenceKey = "grocery_recent_history_key";
    /* access modifiers changed from: private */
    public String sortBy;
    /* access modifiers changed from: private */
    public String sortOrder;

    public MenuSearchPresenter(AppVersionProvider appVersionProvider, MenuCartItemViewBase menuCartItemViewBase) {
        this.iMenuSearchInteractor = new MenuSearchInteractor(appVersionProvider, this);
        this.f26760a = GlobalDataModel.SELECTED.getRestaurant();
        this.f26761b = menuCartItemViewBase;
    }

    private ArrayList<String> getRecentSearchKeyTerms() {
        Object obj;
        SharedPreferences sharedPreferences = this.f26761b.getContext().getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        Gson gson = UniversalGson.INSTANCE.gson;
        String string = sharedPreferences.getString(this.sharedPreferenceKey, "");
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        if (!(gson instanceof Gson)) {
            obj = gson.fromJson(string, type);
        } else {
            obj = GsonInstrumentation.fromJson(gson, string, type);
        }
        return (ArrayList) obj;
    }

    private DisposableObserver<GrocerySearchResponse> getSearchObserver() {
        return new DisposableObserver<GrocerySearchResponse>() {
            public void onComplete() {
                MenuSearchPresenter.this.f26761b.stopLoading();
            }

            public void onError(Throwable th2) {
                MenuSearchPresenter.this.f26761b.stopLoading();
                MenuSearchPresenter menuSearchPresenter = MenuSearchPresenter.this;
                menuSearchPresenter.setUpSearchThreads(menuSearchPresenter.f26761b.getEditText(), MenuSearchPresenter.this.newPageNumber);
            }

            public void onNext(GrocerySearchResponse grocerySearchResponse) {
                MenuSearchPresenter.this.f26761b.stopLoading();
                if (grocerySearchResponse.component1() != null) {
                    if (grocerySearchResponse.component1().length < 10) {
                        MenuSearchPresenter.this.f26761b.setAllItemsLoaded();
                    }
                    if (grocerySearchResponse.component1().length == 0) {
                        MenuSearchPresenter.this.f26761b.showEmptyScreen(true);
                    } else {
                        MenuSearchPresenter.this.f26761b.showEmptyScreen(false);
                        MenuSearchPresenter.this.f26761b.updateList(Arrays.asList(grocerySearchResponse.component1()), MenuSearchPresenter.this.query, MenuSearchPresenter.this.newPageNumber);
                        MenuSearchPresenter.this.f26761b.setIsUpdateRequired(true);
                    }
                } else {
                    MenuSearchPresenter.this.f26761b.showEmptyScreen(true);
                }
                if (!MenuSearchPresenter.this.previousQuery.equals(MenuSearchPresenter.this.query)) {
                    MenuSearchPresenter menuSearchPresenter = MenuSearchPresenter.this;
                    menuSearchPresenter.previousQuery = menuSearchPresenter.query;
                    MenuSearchPresenter.this.f26761b.setGroceryTags(grocerySearchResponse.getPagingSummary().getGroceryTags());
                }
                if (grocerySearchResponse.getPagingSummary().getPagingInfo() != null) {
                    MenuSearchPresenter.this.f26761b.setItemCount(grocerySearchResponse.getPagingSummary().getPagingInfo());
                }
            }
        };
    }

    private void saveRecentSearchKeyTerms(ArrayList<String> arrayList) {
        String str;
        SharedPreferences sharedPreferences = this.f26761b.getContext().getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) arrayList);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) arrayList);
        }
        sharedPreferences.edit().putString(this.sharedPreferenceKey, str).apply();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void saveSearchTerm(java.lang.String r4) {
        /*
            r3 = this;
            java.util.ArrayList r0 = r3.getRecentSearchKeyTerms()
            if (r0 != 0) goto L_0x000b
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x000b:
            boolean r1 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r4)
            r2 = 0
            if (r1 != 0) goto L_0x0034
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x0022
            boolean r1 = r0.contains(r4)
            if (r1 != 0) goto L_0x0027
            r0.add(r2, r4)
            goto L_0x0025
        L_0x0022:
            r0.add(r2, r4)
        L_0x0025:
            r4 = 1
            r2 = r4
        L_0x0027:
            int r4 = r0.size()
            r1 = 5
            if (r4 <= r1) goto L_0x0031
            r0.remove(r1)
        L_0x0031:
            r3.saveRecentSearchKeyTerms(r0)
        L_0x0034:
            if (r2 == 0) goto L_0x003b
            library.talabat.mvp.menu_cart_item.MenuCartItemViewBase r4 = r3.f26761b
            r4.onSearchHistoryChanged(r0)
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.menu_search.MenuSearchPresenter.saveSearchTerm(java.lang.String):void");
    }

    private DisposableObserver<TextViewTextChangeEvent> searchMenuitemTextWatcher() {
        return new DisposableObserver<TextViewTextChangeEvent>() {
            public void onComplete() {
                MenuSearchPresenter.this.f26761b.stopLoading();
            }

            public void onError(Throwable th2) {
                MenuSearchPresenter.this.f26761b.stopLoading();
            }

            public void onNext(TextViewTextChangeEvent textViewTextChangeEvent) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Search query: ");
                sb2.append(textViewTextChangeEvent.getText());
                boolean z11 = MenuSearchPresenter.this.disableAutomaticSearch || textViewTextChangeEvent.getText().toString().length() >= 3;
                if (TextUtils.isEmpty(textViewTextChangeEvent.getText().toString().trim()) || !z11) {
                    MenuSearchPresenter.this.newPageNumber = 0;
                    MenuSearchPresenter.this.previousQuery = "";
                    MenuSearchPresenter.this.f26761b.stopLoading();
                    MenuSearchPresenter.this.f26761b.showClearButton(false);
                    MenuSearchPresenter.this.f26761b.showEmptyScreen(false);
                    MenuSearchPresenter.this.f26761b.updateList(new ArrayList(), MenuSearchPresenter.this.query, MenuSearchPresenter.this.newPageNumber);
                    MenuSearchPresenter.this.f26761b.setIsUpdateRequired(false);
                    return;
                }
                MenuSearchPresenter.this.newPageNumber = 0;
                MenuSearchPresenter.this.f26761b.showClearButton(true);
                MenuSearchPresenter.this.query = textViewTextChangeEvent.getText().toString().trim();
                if (!MenuSearchPresenter.this.disableAutomaticSearch) {
                    MenuSearchPresenter.this.f26761b.showLoading();
                    MenuSearchPresenter.this.publishSubject.onNext(textViewTextChangeEvent.getText().toString().trim());
                }
            }
        };
    }

    public void addItem(Restaurant restaurant, CartMenuItem cartMenuItem) {
        addItem(restaurant, cartMenuItem, this.f26761b);
    }

    public void changeRestaurantAndAddItem(Context context, Restaurant restaurant, CartMenuItem cartMenuItem) {
        changeRestaurantAndAddItem(context, restaurant, cartMenuItem, this.f26761b);
    }

    public void clearEditText() {
        this.previousQuery = "";
        EditText editText = this.searchEditText;
        if (editText != null) {
            editText.setText("");
        }
    }

    public void clearQuery() {
    }

    public void clearSearchHistoryList() {
        saveRecentSearchKeyTerms(new ArrayList());
    }

    public void disableAutoSearch(boolean z11) {
        this.disableAutomaticSearch = z11;
    }

    public void getChoiceSection(int i11) {
        this.iMenuSearchInteractor.getChoiceSection(i11);
    }

    public List<MenuItem> getMenuItems() {
        return processMenuItems();
    }

    public ArrayList<String> getRecentSearchHistoryList() {
        return getRecentSearchKeyTerms();
    }

    public Restaurant getmRestaurant() {
        return this.f26760a;
    }

    public void handleMenuWithChoiceClick() {
        if (this.f26760a.shopType == 0) {
            this.f26761b.navigateToMenuWithChoiceFlutterScreen();
        } else {
            this.f26761b.navigateToMenuWithChoiceNativeScreen();
        }
    }

    public void handleMenuWithoutChoiceClick() {
        if (this.f26760a.shopType == 0) {
            this.f26761b.navigateToMenuWithoutChoiceFlutterScreen();
        } else {
            this.f26761b.navigateToMenuWithoutChoiceNativeScreen();
        }
    }

    public void onChoiceReceived(SplitChoiceItemModel splitChoiceItemModel) {
        MenuSection[] menuSectionArr = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
        int length = menuSectionArr.length;
        int i11 = 0;
        loop0:
        while (true) {
            if (i11 >= length) {
                break;
            }
            for (MenuItem menuItem : menuSectionArr[i11].items) {
                if (menuItem.f13861id == splitChoiceItemModel.f480id) {
                    menuItem.choiceSections = splitChoiceItemModel.choiceSections;
                    menuItem.choicesLoaded = true;
                    break loop0;
                }
            }
            i11++;
        }
        this.f26761b.onChoiceReceived(splitChoiceItemModel);
    }

    public void onDataError() {
    }

    public void onDestroy() {
        this.disposable.clear();
        this.f26761b = null;
        IMenuSearchInteractor iMenuSearchInteractor2 = this.iMenuSearchInteractor;
        if (iMenuSearchInteractor2 != null) {
            iMenuSearchInteractor2.unregister();
        }
        this.iMenuSearchInteractor = null;
    }

    public void onNetworkError() {
    }

    public void onNoChoiceAvailable() {
        this.f26761b.noChoicesAvailable();
    }

    public void onSearchApiCalled(String str) {
        saveSearchTerm(str);
        this.f26761b.onSearchApiCalled();
    }

    public void onServerError(VolleyError volleyError) {
    }

    public List<MenuItem> processMenuItems() {
        ArrayList arrayList = new ArrayList();
        for (MenuSection menuSection : GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection) {
            for (MenuItem menuItem : menuSection.items) {
                if (!arrayList.contains(menuItem)) {
                    if (!Integration.isGemActive()) {
                        arrayList.add(menuItem);
                    } else if (!menuItem.isPromotional && !menuItem.excludedFromGem) {
                        arrayList.add(menuItem);
                    }
                }
            }
        }
        return arrayList;
    }

    public void setNewPageNumber(int i11) {
        boolean z11;
        if (this.disableAutomaticSearch || this.searchEditText.getText().toString().length() >= 3) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (i11 <= 0 || !z11) {
            this.newPageNumber = 0;
            this.previousQuery = "";
            this.f26761b.stopLoading();
            this.f26761b.showClearButton(false);
            this.f26761b.showEmptyScreen(false);
            this.f26761b.updateList(new ArrayList(), this.query, this.newPageNumber);
            this.f26761b.setIsUpdateRequired(false);
            return;
        }
        if (this.disableAutomaticSearch) {
            this.f26761b.showLoading();
        }
        this.f26761b.getTagsString();
        this.newPageNumber = i11;
        this.f26762c.onNext(Integer.valueOf(i11));
    }

    public void setTagsString(String str) {
        this.selectedTagsString = str;
    }

    public void setUpSearchThreads(EditText editText, final int i11) {
        this.newPageNumber = i11;
        this.searchEditText = editText;
        this.disposable.clear();
        DisposableObserver<GrocerySearchResponse> searchObserver = getSearchObserver();
        CompositeDisposable compositeDisposable = this.disposable;
        PublishSubject<String> publishSubject2 = this.publishSubject;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        compositeDisposable.add((Disposable) publishSubject2.debounce(0, timeUnit).filter(new Predicate<String>() {
            public boolean test(String str) {
                return !str.trim().isEmpty();
            }
        }).switchMapSingle(new Function<String, Single<GrocerySearchResponse>>() {
            public Single<GrocerySearchResponse> apply(String str) {
                MenuSearchPresenter.this.query = str;
                IMenuSearchInteractor c11 = MenuSearchPresenter.this.iMenuSearchInteractor;
                return c11.getDataFromApi(str, MenuSearchPresenter.this.f26760a.getBranchId() + "", i11, MenuSearchPresenter.this.sortBy, MenuSearchPresenter.this.sortOrder, MenuSearchPresenter.this.filterBrands, MenuSearchPresenter.this.selectedTagsString);
            }
        }).subscribeWith(searchObserver));
        this.disposable.add((Disposable) RxTextView.textChangeEvents(this.searchEditText).skipInitialValue().distinctUntilChanged().filter(new Predicate<TextViewTextChangeEvent>() {
            public boolean test(TextViewTextChangeEvent textViewTextChangeEvent) {
                boolean z11 = !MenuSearchPresenter.this.disableAutomaticSearch && MenuSearchPresenter.this.searchEditText.getText().toString().length() < 3;
                if (!TextUtils.isEmpty(textViewTextChangeEvent.getText().toString().trim()) || !z11) {
                    return true;
                }
                MenuSearchPresenter.this.newPageNumber = 0;
                MenuSearchPresenter.this.previousQuery = "";
                MenuSearchPresenter.this.f26761b.stopLoading();
                MenuSearchPresenter.this.f26761b.showClearButton(false);
                MenuSearchPresenter.this.f26761b.showEmptyScreen(false);
                MenuSearchPresenter.this.f26761b.updateList(new ArrayList(), MenuSearchPresenter.this.query, MenuSearchPresenter.this.newPageNumber);
                MenuSearchPresenter.this.f26761b.setIsUpdateRequired(false);
                return false;
            }
        }).debounce(600, timeUnit).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(searchMenuitemTextWatcher()));
        this.disposable.add((Disposable) this.f26762c.debounce(600, timeUnit).switchMapSingle(new Function<Integer, Single<GrocerySearchResponse>>() {
            public Single<GrocerySearchResponse> apply(Integer num) {
                MenuSearchPresenter.this.newPageNumber = num.intValue();
                IMenuSearchInteractor c11 = MenuSearchPresenter.this.iMenuSearchInteractor;
                String g11 = MenuSearchPresenter.this.query;
                return c11.getDataFromApi(g11, MenuSearchPresenter.this.f26760a.getBranchId() + "", num.intValue(), MenuSearchPresenter.this.sortBy, MenuSearchPresenter.this.sortOrder, MenuSearchPresenter.this.filterBrands, MenuSearchPresenter.this.selectedTagsString);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<GrocerySearchResponse>() {
            public void onComplete() {
                MenuSearchPresenter.this.f26761b.stopLoading();
            }

            public void onError(Throwable th2) {
                MenuSearchPresenter.this.f26761b.stopLoading();
                MenuSearchPresenter menuSearchPresenter = MenuSearchPresenter.this;
                menuSearchPresenter.setUpSearchThreads(menuSearchPresenter.f26761b.getEditText(), i11);
            }

            public void onNext(GrocerySearchResponse grocerySearchResponse) {
                MenuSearchPresenter.this.f26761b.stopLoading();
                if (grocerySearchResponse.component1() != null) {
                    if (grocerySearchResponse.component1().length == 0 || grocerySearchResponse.component1().length < 10) {
                        MenuSearchPresenter.this.f26761b.setAllItemsLoaded();
                    }
                    if (grocerySearchResponse.component1().length == 0 && MenuSearchPresenter.this.newPageNumber == 1) {
                        MenuSearchPresenter.this.f26761b.showEmptyScreen(true);
                    } else {
                        MenuSearchPresenter.this.f26761b.showEmptyScreen(false);
                        MenuSearchPresenter.this.f26761b.updateList(Arrays.asList(grocerySearchResponse.component1()), MenuSearchPresenter.this.query, MenuSearchPresenter.this.newPageNumber);
                        MenuSearchPresenter.this.f26761b.setIsUpdateRequired(true);
                    }
                } else if (MenuSearchPresenter.this.newPageNumber == 1) {
                    MenuSearchPresenter.this.f26761b.showEmptyScreen(true);
                }
                if (!MenuSearchPresenter.this.previousQuery.equals(MenuSearchPresenter.this.query)) {
                    MenuSearchPresenter menuSearchPresenter = MenuSearchPresenter.this;
                    menuSearchPresenter.previousQuery = menuSearchPresenter.query;
                    MenuSearchPresenter.this.f26761b.setGroceryTags(grocerySearchResponse.getPagingSummary().getGroceryTags());
                }
                if (grocerySearchResponse.getPagingSummary().getPagingInfo() != null) {
                    MenuSearchPresenter.this.f26761b.setItemCount(grocerySearchResponse.getPagingSummary().getPagingInfo());
                }
            }
        }));
        this.disposable.add(searchObserver);
    }
}
