package com.talabat.vendormenu.presentation.flutter.data;

import JsonModels.MenuItemRM;
import com.google.firebase.analytics.FirebaseAnalytics;
import datamodels.MenuItem;
import datamodels.MenuSection;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001*\u00020\u0004\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001*\u00020\u0005\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001*\u00020\u0006¨\u0006\u0007"}, d2 = {"toMap", "", "", "", "LJsonModels/MenuItemRM;", "Ldatamodels/MenuItem;", "Ldatamodels/MenuSection;", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FlutterMenuKt {
    @Nullable
    public static final Map<String, Object> toMap(@NotNull MenuItemRM menuItemRM) {
        Intrinsics.checkNotNullParameter(menuItemRM, "<this>");
        MenuSection[] menuSectionArr = menuItemRM.menuSection;
        if (menuSectionArr == null) {
            return null;
        }
        Pair[] pairArr = new Pair[1];
        Intrinsics.checkNotNullExpressionValue(menuSectionArr, "menuSection");
        ArrayList arrayList = new ArrayList(menuSectionArr.length);
        for (MenuSection menuSection : menuSectionArr) {
            Intrinsics.checkNotNullExpressionValue(menuSection, "it");
            arrayList.add(toMap(menuSection));
        }
        pairArr[0] = TuplesKt.to("menuSection", arrayList);
        return MapsKt__MapsKt.mutableMapOf(pairArr);
    }

    @Nullable
    public static final Map<String, Object> toMap(@NotNull MenuSection menuSection) {
        Intrinsics.checkNotNullParameter(menuSection, "<this>");
        if (menuSection.items == null) {
            return null;
        }
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("id", Integer.valueOf(menuSection.f13863id));
        MenuItem[] menuItemArr = menuSection.items;
        Intrinsics.checkNotNullExpressionValue(menuItemArr, FirebaseAnalytics.Param.ITEMS);
        ArrayList arrayList = new ArrayList(menuItemArr.length);
        for (MenuItem menuItem : menuItemArr) {
            Intrinsics.checkNotNullExpressionValue(menuItem, "it");
            arrayList.add(toMap(menuItem));
        }
        pairArr[1] = TuplesKt.to("itm", arrayList);
        return MapsKt__MapsKt.mutableMapOf(pairArr);
    }

    @Nullable
    public static final Map<String, Object> toMap(@NotNull MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "<this>");
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to("id", Integer.valueOf(menuItem.f13861id)), TuplesKt.to("msi", Integer.valueOf(menuItem.menuSectionId)), TuplesKt.to("nm", menuItem.f13862name), TuplesKt.to("dsc", menuItem.desc), TuplesKt.to("pr", Float.valueOf(menuItem.price)), TuplesKt.to("opr", Float.valueOf(menuItem.oldPrice)), TuplesKt.to("isi", Boolean.valueOf(menuItem.isItemDiscount)), TuplesKt.to("icc", Boolean.valueOf(menuItem.willHaveChoices)), TuplesKt.to("imgurl", menuItem.imgurl));
    }
}
