package com.talabat.feature.darkstoresflutter.data.mapper;

import com.talabat.feature.darkstorescart.data.model.CampaignLabel;
import com.talabat.feature.darkstorescart.data.model.CartResponseProduct;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.model.ProductUrl;
import com.talabat.feature.darkstorescart.data.model.Tracking;
import com.talabat.feature.darkstoresflutter.data.model.FlutterCampaign;
import com.talabat.feature.darkstoresflutter.data.model.FlutterCartItem;
import com.talabat.feature.darkstoresflutter.data.model.FlutterTracking;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\u00052\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/mapper/ProductToFlutterCartItemMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lkotlin/Pair;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "Lcom/talabat/feature/darkstorescart/data/model/CartResponseProduct;", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCartItem;", "()V", "apply", "source", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductToFlutterCartItemMapper implements ModelMapper<Pair<? extends Product, ? extends CartResponseProduct>, FlutterCartItem> {
    @NotNull
    public FlutterCartItem apply(@NotNull Pair<Product, CartResponseProduct> pair) {
        String nmrAdId;
        Intrinsics.checkNotNullParameter(pair, "source");
        Product component1 = pair.component1();
        CartResponseProduct component2 = pair.component2();
        String id2 = component1.getId();
        float price = component1.getPrice();
        Float previousPrice = component1.getPreviousPrice();
        int cartCount = component1.getCartCount();
        Integer freeCount = component1.getFreeCount();
        int intValue = freeCount != null ? freeCount.intValue() : 0;
        Iterable<CampaignLabel> appliedCampaigns = component1.getAppliedCampaigns();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(appliedCampaigns, 10));
        for (CampaignLabel campaignLabel : appliedCampaigns) {
            arrayList.add(new FlutterCampaign(campaignLabel.getCampaignId(), campaignLabel.getCampaignName()));
        }
        Float absoluteDiscount = component1.getAbsoluteDiscount();
        float floatValue = absoluteDiscount != null ? absoluteDiscount.floatValue() : 0.0f;
        int ageLimit = component1.getAgeLimit();
        String imageUrl = component1.getImageUrl();
        if (imageUrl == null) {
            imageUrl = "";
        }
        String str = imageUrl;
        Iterable<ProductUrl> imageUrls = component1.getImageUrls();
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(imageUrls, 10));
        for (ProductUrl url : imageUrls) {
            arrayList2.add(url.getUrl());
        }
        String categoryId = component1.getCategoryId();
        String description = component1.getDescription();
        String name2 = component1.getName();
        List<String> tags = component1.getTags();
        int stock = component1.getStock();
        String sku = component1.getSku();
        boolean isFavorite = component1.isFavorite();
        boolean isSponsored = component1.isSponsored();
        Tracking tracking2 = component1.getTracking();
        return new FlutterCartItem(id2, price, previousPrice, cartCount, intValue, arrayList, floatValue, ageLimit, str, arrayList2, categoryId, description, name2, tags, stock, sku, isFavorite, isSponsored, (tracking2 == null || (nmrAdId = tracking2.getNmrAdId()) == null) ? null : new FlutterTracking(nmrAdId), component1.getOfferText(), component2 != null ? Float.valueOf(component2.getSubtotal()) : null, component2 != null ? Float.valueOf(component2.getTotal()) : null, component1.getTooltipAlertText());
    }
}
