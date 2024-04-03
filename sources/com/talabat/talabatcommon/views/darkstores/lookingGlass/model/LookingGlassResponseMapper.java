package com.talabat.talabatcommon.views.darkstores.lookingGlass.model;

import com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.response.GVendorInfo;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.response.GlassCategory;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.response.GlassItem;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.response.LookingGlassResponse;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0015\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006!"}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/LookingGlassResponseMapper;", "", "currencySymbol", "", "numOfDecimalPlaces", "", "decimalPattern", "(Ljava/lang/String;ILjava/lang/String;)V", "getCurrencySymbol", "()Ljava/lang/String;", "getDecimalPattern", "getNumOfDecimalPlaces", "()I", "addCagories", "", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GDisplayCategory;", "glassCategory", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GlassCategory;", "getDisplayPrice", "price", "", "(Ljava/lang/Double;)Ljava/lang/String;", "getGlassItem", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GDisplayItem;", "item", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/GlassItem;", "getItems", "it", "", "map", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/LookingGlassDisplayModel;", "data", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/LookingGlassResponse;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LookingGlassResponseMapper {
    @NotNull
    private final String currencySymbol;
    @NotNull
    private final String decimalPattern;
    private final int numOfDecimalPlaces;

    public LookingGlassResponseMapper(@NotNull String str, int i11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "currencySymbol");
        Intrinsics.checkNotNullParameter(str2, "decimalPattern");
        this.currencySymbol = str;
        this.numOfDecimalPlaces = i11;
        this.decimalPattern = str2;
    }

    @NotNull
    public final Collection<GDisplayCategory> addCagories(@NotNull GlassCategory glassCategory) {
        Intrinsics.checkNotNullParameter(glassCategory, "glassCategory");
        ArrayList arrayList = new ArrayList();
        GDisplayCategory gDisplayCategory = new GDisplayCategory();
        gDisplayCategory.setHeadline(glassCategory.getHeadline());
        gDisplayCategory.setId(glassCategory.getId());
        List<GlassItem> items = glassCategory.getItems();
        if (items != null && (!items.isEmpty())) {
            gDisplayCategory.getItems().addAll(getItems(items));
            arrayList.add(gDisplayCategory);
        }
        return arrayList;
    }

    @NotNull
    public final String getCurrencySymbol() {
        return this.currencySymbol;
    }

    @NotNull
    public final String getDecimalPattern() {
        return this.decimalPattern;
    }

    @NotNull
    public final String getDisplayPrice(@Nullable Double d11) {
        if (d11 == null) {
            return "";
        }
        return CurrencyFormatter.Companion.getFormattedCurrency(d11.doubleValue(), true, this.currencySymbol, this.numOfDecimalPlaces, this.decimalPattern);
    }

    @NotNull
    public final GDisplayItem getGlassItem(@NotNull GlassItem glassItem) {
        Intrinsics.checkNotNullParameter(glassItem, "item");
        GDisplayItem gDisplayItem = new GDisplayItem((String) null, (String) null, (String) null, (String) null, (Double) null, (Integer) null, (Double) null, (String) null, (List) null, 511, (DefaultConstructorMarker) null);
        gDisplayItem.setId(glassItem.getId());
        gDisplayItem.setName(glassItem.getName());
        gDisplayItem.setPrice(glassItem.getPrice());
        gDisplayItem.setDescription(glassItem.getDescription());
        gDisplayItem.setDiscount(glassItem.getDiscount());
        gDisplayItem.setDiscountText(glassItem.getDiscountText());
        gDisplayItem.setTags(glassItem.getTags());
        gDisplayItem.setImageUrl(glassItem.getImageUrl());
        gDisplayItem.setPriceDisplayText(getDisplayPrice(glassItem.getPrice()));
        gDisplayItem.setOriginalPriceDisplayText(getDisplayPrice(glassItem.getOriginalPrice()));
        return gDisplayItem;
    }

    @NotNull
    public final Collection<GDisplayItem> getItems(@NotNull List<GlassItem> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        ArrayList arrayList = new ArrayList();
        for (GlassItem glassItem : list) {
            arrayList.add(getGlassItem(glassItem));
        }
        return arrayList;
    }

    public final int getNumOfDecimalPlaces() {
        return this.numOfDecimalPlaces;
    }

    @NotNull
    public final LookingGlassDisplayModel map(@Nullable LookingGlassResponse lookingGlassResponse) {
        LookingGlassDisplayModel lookingGlassDisplayModel = new LookingGlassDisplayModel();
        if (lookingGlassResponse != null) {
            GVendorInfo vendorInfo = lookingGlassResponse.getVendorInfo();
            if (vendorInfo != null) {
                lookingGlassDisplayModel.setVendorInfo(vendorInfo);
            }
            for (GlassCategory addCagories : lookingGlassResponse.getCategories()) {
                lookingGlassDisplayModel.getCategories().addAll(addCagories(addCagories));
            }
        }
        return lookingGlassDisplayModel;
    }
}
