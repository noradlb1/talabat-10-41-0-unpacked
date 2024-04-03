package com.talabat.cuisines.domain;

import datamodels.TypesAliasesKt;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a,\u0010\u0006\u001a\u00020\u00072\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002\u001a\b\u0010\t\u001a\u00020\u0007H\u0001\u001a\b\u0010\n\u001a\u00020\u0007H\u0001\u001a,\u0010\u000b\u001a\u00020\f2\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002\u001a\b\u0010\r\u001a\u00020\fH\u0001\u001a\b\u0010\u000e\u001a\u00020\fH\u0001\u001a4\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00032\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002\u001a\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003H\u0001\"*\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004X\u000e¢\u0006\u0002\n\u0000\"*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"selectedAnalyticsCuisinesCollections", "Ljava/util/HashMap;", "", "Lcom/talabat/cuisines/domain/SelectableCuisine;", "Lkotlin/collections/HashMap;", "selectedAnalyticsCuisinesVendors", "clearUpAnalyticsSelectedCuisines", "", "selectedAnalyticsCuisines", "clearUpAnalyticsSelectedCuisinesCollections", "clearUpAnalyticsSelectedCuisinesVendors", "shopCategorySelected", "", "shopCategorySelectedCollections", "shopCategorySelectedVendors", "updateAnalyticsCuisinesOnClick", "selectableCuisine", "updateAnalyticsCuisinesOnClickCollections", "updateAnalyticsCuisinesOnClickVendors", "com_talabat_Components_cuisines_cuisines"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AnalyticsUseCaseKt {
    @NotNull
    private static HashMap<Integer, SelectableCuisine> selectedAnalyticsCuisinesCollections = new HashMap<>();
    @NotNull
    private static HashMap<Integer, SelectableCuisine> selectedAnalyticsCuisinesVendors = new HashMap<>();

    private static final void clearUpAnalyticsSelectedCuisines(HashMap<Integer, SelectableCuisine> hashMap) {
        hashMap.clear();
    }

    @BusinessRule
    public static final void clearUpAnalyticsSelectedCuisinesCollections() {
        clearUpAnalyticsSelectedCuisines(selectedAnalyticsCuisinesCollections);
    }

    @BusinessRule
    public static final void clearUpAnalyticsSelectedCuisinesVendors() {
        clearUpAnalyticsSelectedCuisines(selectedAnalyticsCuisinesVendors);
    }

    private static final String shopCategorySelected(HashMap<Integer, SelectableCuisine> hashMap) {
        Collection<SelectableCuisine> values = hashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "selectedAnalyticsCuisines.values");
        return CollectionsKt___CollectionsKt.joinToString$default(values, TypesAliasesKt.separator, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, AnalyticsUseCaseKt$shopCategorySelected$1.INSTANCE, 30, (Object) null);
    }

    @NotNull
    @BusinessRule
    public static final String shopCategorySelectedCollections() {
        return shopCategorySelected(selectedAnalyticsCuisinesCollections);
    }

    @NotNull
    @BusinessRule
    public static final String shopCategorySelectedVendors() {
        return shopCategorySelected(selectedAnalyticsCuisinesVendors);
    }

    private static final void updateAnalyticsCuisinesOnClick(SelectableCuisine selectableCuisine, HashMap<Integer, SelectableCuisine> hashMap) {
        if (selectableCuisine.isOn()) {
            hashMap.put(Integer.valueOf(selectableCuisine.getCuisine().f13848id), selectableCuisine);
        } else {
            hashMap.remove(Integer.valueOf(selectableCuisine.getCuisine().f13848id));
        }
    }

    @BusinessRule
    public static final void updateAnalyticsCuisinesOnClickCollections(@NotNull SelectableCuisine selectableCuisine) {
        Intrinsics.checkNotNullParameter(selectableCuisine, "selectableCuisine");
        updateAnalyticsCuisinesOnClick(selectableCuisine, selectedAnalyticsCuisinesCollections);
    }

    @BusinessRule
    public static final void updateAnalyticsCuisinesOnClickVendors(@NotNull SelectableCuisine selectableCuisine) {
        Intrinsics.checkNotNullParameter(selectableCuisine, "selectableCuisine");
        updateAnalyticsCuisinesOnClick(selectableCuisine, selectedAnalyticsCuisinesVendors);
    }
}
