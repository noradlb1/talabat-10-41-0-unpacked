package com.talabat.darkstores.data.darkstores.mapper;

import com.talabat.darkstores.feature.cart.multibasket.Cart;
import com.talabat.feature.darkstorescart.data.model.CampaignLabel;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import com.talabat.feature.darkstorescart.data.model.CartResponse;
import com.talabat.feature.darkstorescart.data.model.CartResponseProduct;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo;
import com.talabat.feature.darkstorescart.data.model.Tracking;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"Lcom/talabat/darkstores/data/darkstores/mapper/CartResponseMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstorescart/data/model/CartResponse;", "Lcom/talabat/darkstores/feature/cart/multibasket/Cart;", "()V", "apply", "source", "mapCartItem", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "cartItem", "Lcom/talabat/feature/darkstorescart/data/model/CartResponseProduct;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartResponseMapper implements ModelMapper<CartResponse, Cart> {
    private final Product mapCartItem(CartResponseProduct cartResponseProduct) {
        String str;
        String str2;
        String str3;
        int i11;
        int i12;
        String productId = cartResponseProduct.getProductId();
        String productSku = cartResponseProduct.getProductSku();
        String str4 = "";
        if (productSku == null) {
            str = str4;
        } else {
            str = productSku;
        }
        List<String> productCategoryIds = cartResponseProduct.getProductCategoryIds();
        if (productCategoryIds != null) {
            str2 = (String) CollectionsKt___CollectionsKt.firstOrNull(productCategoryIds);
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str3 = str4;
        } else {
            str3 = str2;
        }
        List<String> productCategoryIds2 = cartResponseProduct.getProductCategoryIds();
        int quantity = cartResponseProduct.getQuantity();
        float price = cartResponseProduct.getPrice();
        float absoluteDiscount = cartResponseProduct.getAbsoluteDiscount();
        List<CampaignLabel> appliedCampaigns = cartResponseProduct.getAppliedCampaigns();
        int freeQuantity = cartResponseProduct.getFreeQuantity();
        List<String> tags = cartResponseProduct.getTags();
        String productName = cartResponseProduct.getProductName();
        if (productName != null) {
            str4 = productName;
        }
        String imageUrl = cartResponseProduct.getImageUrl();
        Integer ageLimit = cartResponseProduct.getAgeLimit();
        if (ageLimit != null) {
            i11 = ageLimit.intValue();
        } else {
            i11 = 0;
        }
        Integer stock = cartResponseProduct.getStock();
        if (stock != null) {
            i12 = stock.intValue();
        } else {
            i12 = 0;
        }
        return new Product(productId, str4, imageUrl, price, (Float) null, quantity, 0, Integer.valueOf(freeQuantity), Float.valueOf(absoluteDiscount), (Tracking) null, (String) null, i12, false, (List) null, tags, (String) null, appliedCampaigns, str3, false, str, false, (CampaignTrigger) null, i11, (ProductExtendedInfo) null, productCategoryIds2, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, cartResponseProduct.getOfferText(), cartResponseProduct.getTooltipAlertText(), 515159632, (DefaultConstructorMarker) null);
    }

    @NotNull
    public Cart apply(@NotNull CartResponse cartResponse) {
        Intrinsics.checkNotNullParameter(cartResponse, "source");
        String cartId = cartResponse.getCartId();
        Iterable<CartResponseProduct> items = cartResponse.getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(items, 10));
        for (CartResponseProduct mapCartItem : items) {
            arrayList.add(mapCartItem(mapCartItem));
        }
        return new Cart(cartId, arrayList);
    }
}
