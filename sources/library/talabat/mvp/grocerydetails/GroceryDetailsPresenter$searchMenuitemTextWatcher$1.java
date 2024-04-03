package library.talabat.mvp.grocerydetails;

import android.text.TextUtils;
import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent;
import com.talabat.helpers.GlobalDataModel;
import datamodels.MenuSection;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"library/talabat/mvp/grocerydetails/GroceryDetailsPresenter$searchMenuitemTextWatcher$1", "Lio/reactivex/observers/DisposableObserver;", "Lcom/jakewharton/rxbinding3/widget/TextViewTextChangeEvent;", "onComplete", "", "onError", "e", "", "onNext", "textViewTextChangeEvent", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryDetailsPresenter$searchMenuitemTextWatcher$1 extends DisposableObserver<TextViewTextChangeEvent> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsPresenter f26727b;

    public GroceryDetailsPresenter$searchMenuitemTextWatcher$1(GroceryDetailsPresenter groceryDetailsPresenter) {
        this.f26727b = groceryDetailsPresenter;
    }

    public void onComplete() {
        GroceryDetailsView access$getGroceryDetailsView$p = this.f26727b.groceryDetailsView;
        if (access$getGroceryDetailsView$p != null) {
            access$getGroceryDetailsView$p.stopLoading();
        }
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "e");
        GroceryDetailsView access$getGroceryDetailsView$p = this.f26727b.groceryDetailsView;
        if (access$getGroceryDetailsView$p != null) {
            access$getGroceryDetailsView$p.stopLoading();
        }
    }

    public void onNext(@NotNull TextViewTextChangeEvent textViewTextChangeEvent) {
        Intrinsics.checkNotNullParameter(textViewTextChangeEvent, "textViewTextChangeEvent");
        CharSequence text = textViewTextChangeEvent.getText();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Search query: ");
        sb2.append(text);
        boolean z11 = this.f26727b.disableAutomaticSearch || textViewTextChangeEvent.getText().toString().length() >= 3;
        String obj = textViewTextChangeEvent.getText().toString();
        int length = obj.length() - 1;
        int i11 = 0;
        boolean z12 = false;
        while (i11 <= length) {
            boolean z13 = Intrinsics.compare((int) obj.charAt(!z12 ? i11 : length), 32) <= 0;
            if (!z12) {
                if (!z13) {
                    z12 = true;
                } else {
                    i11++;
                }
            } else if (!z13) {
                break;
            } else {
                length--;
            }
        }
        if (TextUtils.isEmpty(obj.subSequence(i11, length + 1).toString()) || !z11) {
            MenuSection[] menuSectionArr = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
            Intrinsics.checkNotNullExpressionValue(menuSectionArr, "menuItemsResponseModel.menu.menuSection");
            int length2 = menuSectionArr.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length2) {
                    break;
                }
                MenuSection menuSection = menuSectionArr[i12];
                if (menuSection.f13863id == this.f26727b.getMenuSectionId()) {
                    GroceryDetailsPresenter groceryDetailsPresenter = this.f26727b;
                    String str = menuSection.sortCriteria;
                    Intrinsics.checkNotNullExpressionValue(str, "menuSection.sortCriteria");
                    groceryDetailsPresenter.setSortBy(str);
                    GroceryDetailsPresenter groceryDetailsPresenter2 = this.f26727b;
                    String str2 = menuSection.sortOrder;
                    Intrinsics.checkNotNullExpressionValue(str2, "menuSection.sortOrder");
                    groceryDetailsPresenter2.setSortOrder(str2);
                    GroceryDetailsPresenter groceryDetailsPresenter3 = this.f26727b;
                    String str3 = menuSection.filterBrands;
                    Intrinsics.checkNotNullExpressionValue(str3, "menuSection.filterBrands");
                    groceryDetailsPresenter3.setFilterBrands(str3);
                    menuSection.searchBrandIds = new ArrayList<>();
                    break;
                }
                i12++;
            }
            GroceryDetailsView access$getGroceryDetailsView$p = this.f26727b.groceryDetailsView;
            if (access$getGroceryDetailsView$p != null) {
                access$getGroceryDetailsView$p.stopLoading();
            }
            GroceryDetailsView access$getGroceryDetailsView$p2 = this.f26727b.groceryDetailsView;
            if (access$getGroceryDetailsView$p2 != null) {
                access$getGroceryDetailsView$p2.showClearButton(false);
            }
            GroceryDetailsView access$getGroceryDetailsView$p3 = this.f26727b.groceryDetailsView;
            if (access$getGroceryDetailsView$p3 != null) {
                access$getGroceryDetailsView$p3.showEmptyScreen(false, false);
            }
            GroceryDetailsView access$getGroceryDetailsView$p4 = this.f26727b.groceryDetailsView;
            if (access$getGroceryDetailsView$p4 != null) {
                access$getGroceryDetailsView$p4.isRequired();
            }
            GroceryDetailsView access$getGroceryDetailsView$p5 = this.f26727b.groceryDetailsView;
            if (access$getGroceryDetailsView$p5 != null) {
                access$getGroceryDetailsView$p5.updateList(this.f26727b.getAllItemsToDisplay(), this.f26727b.getPagingInfo(), this.f26727b.query);
            }
            GroceryDetailsView access$getGroceryDetailsView$p6 = this.f26727b.groceryDetailsView;
            if (access$getGroceryDetailsView$p6 != null) {
                access$getGroceryDetailsView$p6.setItemsCount(this.f26727b.getPagingInfo());
            }
            GroceryDetailsView access$getGroceryDetailsView$p7 = this.f26727b.groceryDetailsView;
            if (access$getGroceryDetailsView$p7 != null) {
                access$getGroceryDetailsView$p7.setIsUpdateRequired(false);
                return;
            }
            return;
        }
        this.f26727b.incrementedPageNumber = 0;
        GroceryDetailsView access$getGroceryDetailsView$p8 = this.f26727b.groceryDetailsView;
        if (access$getGroceryDetailsView$p8 != null) {
            access$getGroceryDetailsView$p8.showClearButton(true);
        }
        GroceryDetailsView access$getGroceryDetailsView$p9 = this.f26727b.groceryDetailsView;
        if (access$getGroceryDetailsView$p9 != null) {
            access$getGroceryDetailsView$p9.resetTagsRecyclerView();
        }
        this.f26727b.query = StringsKt__StringsKt.trim((CharSequence) textViewTextChangeEvent.getText().toString()).toString();
        MenuSection[] menuSectionArr2 = GlobalDataModel.JSON.menuItemsResponseModel.menu.menuSection;
        Intrinsics.checkNotNullExpressionValue(menuSectionArr2, "menuItemsResponseModel.menu.menuSection");
        int length3 = menuSectionArr2.length;
        int i13 = 0;
        while (true) {
            if (i13 >= length3) {
                break;
            }
            MenuSection menuSection2 = menuSectionArr2[i13];
            if (menuSection2.f13863id == this.f26727b.getMenuSectionId()) {
                ArrayList<String> arrayList = menuSection2.searchBrandIds;
                Intrinsics.checkNotNullExpressionValue(arrayList, "menuSection.searchBrandIds");
                if (!arrayList.isEmpty()) {
                    menuSection2.searchBrandIds.clear();
                }
                menuSection2.searchBrandIds.addAll(menuSection2.brandIds);
            } else {
                i13++;
            }
        }
        if (!this.f26727b.disableAutomaticSearch) {
            GroceryDetailsView access$getGroceryDetailsView$p10 = this.f26727b.groceryDetailsView;
            if (access$getGroceryDetailsView$p10 != null) {
                access$getGroceryDetailsView$p10.showLoading();
            }
            PublishSubject access$getPublishSubject$p = this.f26727b.publishSubject;
            String obj2 = textViewTextChangeEvent.getText().toString();
            int length4 = obj2.length() - 1;
            int i14 = 0;
            boolean z14 = false;
            while (i14 <= length4) {
                boolean z15 = Intrinsics.compare((int) obj2.charAt(!z14 ? i14 : length4), 32) <= 0;
                if (!z14) {
                    if (!z15) {
                        z14 = true;
                    } else {
                        i14++;
                    }
                } else if (!z15) {
                    break;
                } else {
                    length4--;
                }
            }
            access$getPublishSubject$p.onNext(obj2.subSequence(i14, length4 + 1).toString());
        }
    }
}
