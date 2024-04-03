package library.talabat.mvp.grocerydetails;

import JsonModels.Request.GroceryRequest.GrocerySortAndFilterRequest;
import JsonModels.Response.GroceryResponse.GroceryItemsForSectionResponse;
import io.reactivex.observers.DisposableObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"library/talabat/mvp/grocerydetails/GroceryDetailsInteractor$applyFilterAndSorting$1", "Lio/reactivex/observers/DisposableObserver;", "LJsonModels/Response/GroceryResponse/GroceryItemsForSectionResponse;", "onComplete", "", "onError", "e", "", "onNext", "groceryItemsForSectionResponse", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryDetailsInteractor$applyFilterAndSorting$1 extends DisposableObserver<GroceryItemsForSectionResponse> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f26719b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GroceryDetailsInteractor f26720c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f26721d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ GrocerySortAndFilterRequest f26722e;

    public GroceryDetailsInteractor$applyFilterAndSorting$1(int i11, GroceryDetailsInteractor groceryDetailsInteractor, int i12, GrocerySortAndFilterRequest grocerySortAndFilterRequest) {
        this.f26719b = i11;
        this.f26720c = groceryDetailsInteractor;
        this.f26721d = i12;
        this.f26722e = grocerySortAndFilterRequest;
    }

    public void onComplete() {
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "e");
        GroceryDetailsListener access$getGroceryDetailsListener$p = this.f26720c.groceryDetailsListener;
        if (access$getGroceryDetailsListener$p != null) {
            access$getGroceryDetailsListener$p.onItemsDataError();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c1, code lost:
        if (r2.booleanValue() == false) goto L_0x00c3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNext(@org.jetbrains.annotations.NotNull JsonModels.Response.GroceryResponse.GroceryItemsForSectionResponse r11) {
        /*
            r10 = this;
            java.lang.String r0 = "groceryItemsForSectionResponse"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            int r0 = r10.f26719b
            r1 = 1
            if (r0 != r1) goto L_0x00d7
            library.talabat.mvp.grocerydetails.GroceryDetailsInteractor r0 = r10.f26720c
            JsonModels.Response.GroceryResponse.MenuItemsForSection r2 = r11.getResult()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            JsonModels.Response.GroceryResponse.GroceryItemsForSectionPagingInfo r2 = r2.getPagingInfo()
            int r2 = r2.getTotalPages()
            r0.setTotalPages(r2)
            JsonModels.MenuItemsResponseModel r0 = com.talabat.helpers.GlobalDataModel.JSON.menuItemsResponseModel
            JsonModels.MenuItemRM r0 = r0.menu
            datamodels.MenuSection[] r0 = r0.menuSection
            java.lang.String r2 = "menuItemsResponseModel.menu.menuSection"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            int r2 = r0.length
            r3 = 0
            r4 = r3
        L_0x002c:
            if (r4 >= r2) goto L_0x00d7
            r5 = r0[r4]
            int r6 = r5.f13863id
            int r7 = r10.f26721d
            if (r6 != r7) goto L_0x00d3
            datamodels.MenuItem[] r0 = new datamodels.MenuItem[r3]
            r5.sortedItemsList = r0
            JsonModels.Response.GroceryResponse.MenuItemsForSection r0 = r11.getResult()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            JsonModels.Response.GroceryResponse.GroceryItemsForSectionPagingInfo r0 = r0.getPagingInfo()
            r5.sortedItemsItemsPagingInfo = r0
            JsonModels.Response.GroceryResponse.MenuItemsForSection r0 = r11.getResult()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            datamodels.MenuSection r0 = r0.getMenuSection()
            JsonModels.Response.GroceryResponse.GroceryItemsForSectionBrandModel[] r0 = r0.brands
            r5.brands = r0
            JsonModels.Request.GroceryRequest.GrocerySortAndFilterRequest r0 = r10.f26722e
            java.lang.String r0 = r0.getBrandIds()
            r2 = 0
            if (r0 == 0) goto L_0x006d
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0067
            r0 = r1
            goto L_0x0068
        L_0x0067:
            r0 = r3
        L_0x0068:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x006e
        L_0x006d:
            r0 = r2
        L_0x006e:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00c3
            JsonModels.Request.GroceryRequest.GrocerySortAndFilterRequest r0 = r10.f26722e
            java.lang.String r0 = r0.getSortBy()
            java.lang.String r4 = "original"
            r6 = 2
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.equals$default(r0, r4, r3, r6, r2)
            if (r0 == 0) goto L_0x00c3
            JsonModels.Request.GroceryRequest.GrocerySortAndFilterRequest r0 = r10.f26722e
            java.lang.String r0 = r0.getSortOrder()
            if (r0 == 0) goto L_0x009c
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0096
            r0 = r1
            goto L_0x0097
        L_0x0096:
            r0 = r3
        L_0x0097:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x009d
        L_0x009c:
            r0 = r2
        L_0x009d:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00c3
            JsonModels.Request.GroceryRequest.GrocerySortAndFilterRequest r0 = r10.f26722e
            java.lang.String r0 = r0.getTagIds()
            if (r0 == 0) goto L_0x00ba
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00b5
            goto L_0x00b6
        L_0x00b5:
            r1 = r3
        L_0x00b6:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
        L_0x00ba:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            boolean r0 = r2.booleanValue()
            if (r0 != 0) goto L_0x00d7
        L_0x00c3:
            JsonModels.Response.GroceryResponse.MenuItemsForSection r0 = r11.getResult()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            datamodels.MenuSection r0 = r0.getMenuSection()
            JsonModels.Response.GroceryResponse.GroceryTagsModel[] r0 = r0.groceryTags
            r5.filteredGroceryTags = r0
            goto L_0x00d7
        L_0x00d3:
            int r4 = r4 + 1
            goto L_0x002c
        L_0x00d7:
            library.talabat.mvp.grocerydetails.GroceryDetailsInteractor r0 = r10.f26720c
            java.util.HashMap r0 = r0.getMenuItemsRealList()
            int r1 = r10.f26719b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            boolean r0 = r0.containsKey(r1)
            java.lang.String r1 = "groceryItemsForSectionRe…esult!!.menuSection.items"
            if (r0 != 0) goto L_0x010a
            library.talabat.mvp.grocerydetails.GroceryDetailsInteractor r0 = r10.f26720c
            java.util.HashMap r0 = r0.getMenuItemsRealList()
            int r2 = r10.f26719b
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            JsonModels.Response.GroceryResponse.MenuItemsForSection r3 = r11.getResult()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            datamodels.MenuSection r3 = r3.getMenuSection()
            datamodels.MenuItem[] r3 = r3.items
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            r0.put(r2, r3)
        L_0x010a:
            library.talabat.mvp.grocerydetails.GroceryDetailsInteractor r0 = r10.f26720c
            int r0 = r0.getTotalMenuPages()
            int r2 = r10.f26719b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = " and "
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = " "
            r3.append(r0)
            library.talabat.mvp.grocerydetails.GroceryDetailsInteractor r4 = r10.f26720c
            int r5 = r10.f26719b
            int r6 = r10.f26721d
            JsonModels.Response.GroceryResponse.MenuItemsForSection r0 = r11.getResult()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            datamodels.MenuSection r0 = r0.getMenuSection()
            datamodels.MenuItem[] r7 = r0.items
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            JsonModels.Response.GroceryResponse.MenuItemsForSection r8 = r11.getResult()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            JsonModels.Response.GroceryResponse.MenuItemsForSection r11 = r11.getResult()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            datamodels.MenuSection r11 = r11.getMenuSection()
            JsonModels.Response.GroceryResponse.GroceryTagsModel[] r9 = r11.groceryTags
            r4.allocateMenuItemsInOrder(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.grocerydetails.GroceryDetailsInteractor$applyFilterAndSorting$1.onNext(JsonModels.Response.GroceryResponse.GroceryItemsForSectionResponse):void");
    }
}
