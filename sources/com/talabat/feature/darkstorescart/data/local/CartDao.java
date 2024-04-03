package com.talabat.feature.darkstorescart.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import com.talabat.feature.darkstorescart.data.model.CartInfo;
import com.talabat.feature.darkstorescart.data.model.CartResponseProduct;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo;
import com.talabat.feature.darkstorescart.data.model.Tracking;
import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Dao
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0013\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0017J\b\u0010\u000b\u001a\u00020\u0003H'J\b\u0010\f\u001a\u00020\u0003H'J\b\u0010\r\u001a\u00020\u0003H'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH'J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H'J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\t\u001a\u00020\nH'J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0005H'J\u0016\u0010\u0016\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018H'J$\u0010\u0019\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0002J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H'J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010$\u001a\u00020 H'J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u001cH\u0002J$\u0010'\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0002J\u0018\u0010(\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\b\u0010)\u001a\u00020\u0003H'J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018H'J\u001e\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00180\u00122\b\b\u0002\u0010\u001f\u001a\u00020 H'J\u001e\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00180-2\b\b\u0002\u0010\u001f\u001a\u00020 H'J\u0012\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\nH'J\b\u0010/\u001a\u000200H'J\u0018\u00101\u001a\b\u0012\u0004\u0012\u000200022\b\b\u0002\u0010\u001f\u001a\u00020 H'J \u00103\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00104\u001a\u0002002\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0016\u00105\u001a\u00020\u00032\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0002J\u0016\u00107\u001a\u00020\u00032\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0002J\b\u00108\u001a\u00020\u0003H\u0017J\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0017J\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0017J\u0016\u0010;\u001a\u00020\u00032\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0002J\u0018\u0010<\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010=\u001a\u000200H'J\u0016\u0010>\u001a\u00020\u00032\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0002J\u0018\u0010?\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010@\u001a\u00020AH'J\u0018\u0010B\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010C\u001a\u00020AH'J\u0018\u0010D\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH'J\u0018\u0010E\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010=\u001a\u000200H'J\u0018\u0010F\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010G\u001a\u00020 H'J\u001a\u0010H\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\n2\b\u0010I\u001a\u0004\u0018\u00010\nH'J\u0018\u0010J\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH'J \u0010K\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010=\u001a\u0002002\u0006\u0010L\u001a\u00020 H'J\u0018\u0010M\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010=\u001a\u000200H'J\u001a\u0010N\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\n2\b\u0010O\u001a\u0004\u0018\u00010\nH'J\u0016\u0010P\u001a\u00020\u00032\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018H\u0002J\u001e\u0010Q\u001a\u00020 *\u00020A2\u0006\u0010R\u001a\u00020A2\b\b\u0002\u0010S\u001a\u000200H\u0002¨\u0006T"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/local/CartDao;", "", "addProduct", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "cartInfo", "Lcom/talabat/feature/darkstorescart/data/model/CartInfo;", "clearCart", "cartId", "", "clearCartInfo", "deleteALlZeros", "deleteAll", "deleteCartInfo", "deleteEntry", "cartItem", "getCartInfo", "Lio/reactivex/Maybe;", "insertCartInfo", "insertEntry", "", "insertProducts", "products", "", "markMissingProductsAsOOS", "dbProducts", "responseProducts", "Lcom/talabat/feature/darkstorescart/data/model/CartResponseProduct;", "markOOS", "productId", "hasBeenMarkedOOS", "", "markPriceChanged", "dbProduct", "responseProduct", "hasPriceChanged", "markProductAsPredictedToBeOOS", "markQuantityChanged", "markStockAndPriceChanges", "removeProduct", "rollbackCartCountsToSynced", "selectAll", "selectAllMaybe", "selectAllObservable", "Lio/reactivex/Observable;", "selectById", "selectTotalProductsCount", "", "selectTotalProductsCountAsSingle", "Lio/reactivex/Single;", "setProductCount", "count", "updateAbsoluteDiscount", "cartResponseProducts", "updateAlertTooltipText", "updateAllSyncFailure", "updateAllSyncSuccess", "updateAllSyncSuccessV2", "updateCounts", "updateFreeProductCount", "value", "updateOfferText", "updatePrice", "price", "", "updateProductAbsoluteDiscount", "absoluteDiscount", "updateProductCategory", "updateProductCount", "updateProductOOSPrediction", "predictedToBeOOS", "updateProductOfferText", "offerText", "updateProductSku", "updateProductStockAmount", "hasQuantityChanged", "updateProductSyncCount", "updateProductToolTipAlertText", "toolTipAlertText", "updateSkusAndCategories", "compare", "other", "numberOfDecimalPlacesToCompare", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CartDao {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @Transaction
        public static void addProduct(@NotNull CartDao cartDao, @NotNull Product product, @NotNull CartInfo cartInfo) {
            int i11;
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(cartInfo, "cartInfo");
            Product selectById = cartDao.selectById(product.getId());
            if (selectById != null) {
                i11 = selectById.getCartCount();
            } else {
                i11 = 0;
            }
            cartDao.setProductCount(product, i11 + 1, cartInfo);
        }

        @Transaction
        public static void clearCart(@NotNull CartDao cartDao, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
            cartDao.deleteAll();
            cartDao.deleteCartInfo(str);
        }

        private static boolean compare(CartDao cartDao, float f11, float f12, int i11) {
            double pow = Math.pow(10.0d, (double) i11);
            return ((int) (((double) f11) * pow)) == ((int) (((double) f12) * pow));
        }

        public static /* synthetic */ boolean compare$default(CartDao cartDao, float f11, float f12, int i11, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    i11 = 2;
                }
                return compare(cartDao, f11, f12, i11);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: compare");
        }

        private static void markMissingProductsAsOOS(CartDao cartDao, List<Product> list, List<CartResponseProduct> list2) {
            Iterable<CartResponseProduct> iterable = list2;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (CartResponseProduct productId : iterable) {
                arrayList.add(productId.getProductId());
            }
            ArrayList<Product> arrayList2 = new ArrayList<>();
            for (Object next : list) {
                if (!arrayList.contains(((Product) next).getId())) {
                    arrayList2.add(next);
                }
            }
            for (Product product : arrayList2) {
                cartDao.markOOS(product.getId(), true);
                cartDao.updateProductStockAmount(product.getId(), product.getCartCount(), false);
                cartDao.markPriceChanged(product.getId(), false);
            }
        }

        private static void markPriceChanged(CartDao cartDao, Product product, CartResponseProduct cartResponseProduct) {
            if (product.getCartCount() == cartResponseProduct.getQuantity()) {
                if (!compare$default(cartDao, product.getPrice(), cartResponseProduct.getPrice(), 0, 2, (Object) null)) {
                    cartDao.markPriceChanged(product.getId(), true);
                    cartDao.updatePrice(product.getId(), cartResponseProduct.getPrice());
                }
            }
        }

        private static void markProductAsPredictedToBeOOS(CartDao cartDao, Product product, CartResponseProduct cartResponseProduct) {
            cartDao.updateProductOOSPrediction(product.getId(), cartResponseProduct.getTags().contains("low_stock"));
        }

        private static void markQuantityChanged(CartDao cartDao, Product product, CartResponseProduct cartResponseProduct) {
            if (product.getCartCount() > cartResponseProduct.getQuantity()) {
                cartDao.updateProductStockAmount(product.getId(), cartResponseProduct.getQuantity(), true);
            }
        }

        private static void markStockAndPriceChanges(CartDao cartDao, List<Product> list, List<CartResponseProduct> list2) {
            Object obj;
            Iterable<CartResponseProduct> iterable = list2;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (CartResponseProduct productId : iterable) {
                arrayList.add(productId.getProductId());
            }
            ArrayList<Product> arrayList2 = new ArrayList<>();
            for (Object next : list) {
                if (arrayList.contains(((Product) next).getId())) {
                    arrayList2.add(next);
                }
            }
            for (Product product : arrayList2) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) ((CartResponseProduct) obj).getProductId(), (Object) product.getId())) {
                        break;
                    }
                }
                Intrinsics.checkNotNull(obj);
                CartResponseProduct cartResponseProduct = (CartResponseProduct) obj;
                markQuantityChanged(cartDao, product, cartResponseProduct);
                markPriceChanged(cartDao, product, cartResponseProduct);
                markProductAsPredictedToBeOOS(cartDao, product, cartResponseProduct);
            }
        }

        @Transaction
        public static void removeProduct(@NotNull CartDao cartDao, @NotNull String str, @NotNull CartInfo cartInfo) {
            Intrinsics.checkNotNullParameter(str, "productId");
            Intrinsics.checkNotNullParameter(cartInfo, "cartInfo");
            Product selectById = cartDao.selectById(str);
            if (selectById != null) {
                int cartCount = selectById.getCartCount() - 1;
                if (cartCount > 0) {
                    cartDao.setProductCount(selectById, cartCount, cartInfo);
                } else {
                    cartDao.deleteEntry(selectById);
                }
            }
        }

        public static /* synthetic */ Maybe selectAllMaybe$default(CartDao cartDao, boolean z11, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    z11 = false;
                }
                return cartDao.selectAllMaybe(z11);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectAllMaybe");
        }

        public static /* synthetic */ Observable selectAllObservable$default(CartDao cartDao, boolean z11, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    z11 = false;
                }
                return cartDao.selectAllObservable(z11);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectAllObservable");
        }

        public static /* synthetic */ Single selectTotalProductsCountAsSingle$default(CartDao cartDao, boolean z11, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    z11 = false;
                }
                return cartDao.selectTotalProductsCountAsSingle(z11);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectTotalProductsCountAsSingle");
        }

        @Transaction
        public static void setProductCount(@NotNull CartDao cartDao, @NotNull Product product, int i11, @NotNull CartInfo cartInfo) {
            boolean z11;
            CartDao cartDao2 = cartDao;
            int i12 = i11;
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(cartInfo, "cartInfo");
            if (cartDao2.selectById(product.getId()) != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 && i12 > 0) {
                cartDao2.updateProductCount(product.getId(), i12);
            } else if (!z11 && i12 > 0) {
                cartDao2.insertEntry(Product.copy$default(product, (String) null, (String) null, (String) null, 0.0f, (Float) null, i11, 0, (Integer) null, (Float) null, (Tracking) null, (String) null, 0, false, (List) null, (List) null, (String) null, (List) null, (String) null, false, (String) null, false, (CampaignTrigger) null, 0, (ProductExtendedInfo) null, (List) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, 2147483615, (Object) null));
            } else if (z11 && i12 <= 0) {
                cartDao.deleteEntry(product);
            }
            if (cartDao.selectTotalProductsCount() == 0) {
                cartDao2.deleteCartInfo(cartInfo.getCartId());
            } else {
                cartDao2.insertCartInfo(cartInfo);
            }
        }

        private static void updateAbsoluteDiscount(CartDao cartDao, List<CartResponseProduct> list) {
            for (CartResponseProduct cartResponseProduct : list) {
                cartDao.updateProductAbsoluteDiscount(cartResponseProduct.getProductId(), cartResponseProduct.getAbsoluteDiscount());
            }
        }

        private static void updateAlertTooltipText(CartDao cartDao, List<CartResponseProduct> list) {
            for (CartResponseProduct cartResponseProduct : list) {
                cartDao.updateProductToolTipAlertText(cartResponseProduct.getProductId(), cartResponseProduct.getTooltipAlertText());
            }
        }

        @Transaction
        public static void updateAllSyncFailure(@NotNull CartDao cartDao) {
            cartDao.rollbackCartCountsToSynced();
            cartDao.deleteALlZeros();
        }

        @NotNull
        @Transaction
        public static List<Product> updateAllSyncSuccess(@NotNull CartDao cartDao, @NotNull List<CartResponseProduct> list) {
            Object obj;
            Intrinsics.checkNotNullParameter(list, "cartResponseProducts");
            List<Product> selectAll = cartDao.selectAll();
            Iterable<CartResponseProduct> iterable = list;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (CartResponseProduct productId : iterable) {
                arrayList.add(productId.getProductId());
            }
            Iterable iterable2 = selectAll;
            ArrayList<Product> arrayList2 = new ArrayList<>();
            for (Object next : iterable2) {
                if (!arrayList.contains(((Product) next).getId())) {
                    arrayList2.add(next);
                }
            }
            for (Product deleteEntry : arrayList2) {
                cartDao.deleteEntry(deleteEntry);
            }
            ArrayList<Product> arrayList3 = new ArrayList<>();
            for (Object next2 : iterable2) {
                if (arrayList.contains(((Product) next2).getId())) {
                    arrayList3.add(next2);
                }
            }
            for (Product product : arrayList3) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) ((CartResponseProduct) obj).getProductId(), (Object) product.getId())) {
                        break;
                    }
                }
                Intrinsics.checkNotNull(obj);
                CartResponseProduct cartResponseProduct = (CartResponseProduct) obj;
                if (product.getCartCount() > cartResponseProduct.getQuantity()) {
                    cartDao.updateProductStockAmount(product.getId(), cartResponseProduct.getQuantity(), false);
                }
                markProductAsPredictedToBeOOS(cartDao, product, cartResponseProduct);
            }
            updateCounts(cartDao, list);
            updateSkusAndCategories(cartDao, list);
            updateAbsoluteDiscount(cartDao, list);
            updateOfferText(cartDao, list);
            updateAlertTooltipText(cartDao, list);
            return cartDao.selectAll();
        }

        @NotNull
        @Transaction
        public static List<Product> updateAllSyncSuccessV2(@NotNull CartDao cartDao, @NotNull List<CartResponseProduct> list) {
            Intrinsics.checkNotNullParameter(list, "cartResponseProducts");
            List<Product> selectAll = cartDao.selectAll();
            markMissingProductsAsOOS(cartDao, selectAll, list);
            markStockAndPriceChanges(cartDao, selectAll, list);
            updateCounts(cartDao, list);
            updateSkusAndCategories(cartDao, list);
            updateAbsoluteDiscount(cartDao, list);
            updateOfferText(cartDao, list);
            updateAlertTooltipText(cartDao, list);
            return cartDao.selectAll();
        }

        private static void updateCounts(CartDao cartDao, List<CartResponseProduct> list) {
            for (CartResponseProduct cartResponseProduct : list) {
                cartDao.updateProductSyncCount(cartResponseProduct.getProductId(), cartResponseProduct.getQuantity());
                cartDao.updateProductCount(cartResponseProduct.getProductId(), cartResponseProduct.getQuantity());
                cartDao.updateFreeProductCount(cartResponseProduct.getProductId(), cartResponseProduct.getFreeQuantity());
            }
        }

        private static void updateOfferText(CartDao cartDao, List<CartResponseProduct> list) {
            for (CartResponseProduct cartResponseProduct : list) {
                cartDao.updateProductOfferText(cartResponseProduct.getProductId(), cartResponseProduct.getOfferText());
            }
        }

        private static void updateSkusAndCategories(CartDao cartDao, List<CartResponseProduct> list) {
            boolean z11;
            for (CartResponseProduct cartResponseProduct : list) {
                if (cartResponseProduct.getProductSku() != null) {
                    cartDao.updateProductSku(cartResponseProduct.getProductId(), cartResponseProduct.getProductSku());
                }
                Collection productCategoryIds = cartResponseProduct.getProductCategoryIds();
                if (productCategoryIds == null || productCategoryIds.isEmpty()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    cartDao.updateProductCategory(cartResponseProduct.getProductId(), (String) CollectionsKt___CollectionsKt.first(cartResponseProduct.getProductCategoryIds()));
                }
            }
        }
    }

    @Transaction
    void addProduct(@NotNull Product product, @NotNull CartInfo cartInfo);

    @Transaction
    void clearCart(@NotNull String str);

    @Query("DELETE FROM CartInfo")
    void clearCartInfo();

    @Query("DELETE FROM Product WHERE cartCount = 0")
    void deleteALlZeros();

    @Query("DELETE FROM Product")
    void deleteAll();

    @Query("DELETE from CartInfo WHERE cartId = :cartId")
    void deleteCartInfo(@NotNull String str);

    @Delete
    void deleteEntry(@NotNull Product product);

    @NotNull
    @Query("SELECT * FROM CartInfo WHERE cartId = :cartId")
    Maybe<CartInfo> getCartInfo(@NotNull String str);

    @Insert(onConflict = 1)
    void insertCartInfo(@NotNull CartInfo cartInfo);

    @Insert
    long insertEntry(@NotNull Product product);

    @Insert
    void insertProducts(@NotNull List<Product> list);

    @Query("UPDATE Product SET hasBeenMarkedOOS = :hasBeenMarkedOOS WHERE id = :productId")
    void markOOS(@NotNull String str, boolean z11);

    @Query("UPDATE Product SET hasPriceChanged = :hasPriceChanged WHERE id = :productId")
    void markPriceChanged(@NotNull String str, boolean z11);

    @Transaction
    void removeProduct(@NotNull String str, @NotNull CartInfo cartInfo);

    @Query("UPDATE Product SET cartCount = syncedCount")
    void rollbackCartCountsToSynced();

    @NotNull
    @Query("SELECT * FROM Product")
    List<Product> selectAll();

    @NotNull
    @Query("SELECT * FROM Product WHERE hasBeenMarkedOOS = :hasBeenMarkedOOS")
    Maybe<List<Product>> selectAllMaybe(boolean z11);

    @NotNull
    @Query("SELECT * FROM Product WHERE hasBeenMarkedOOS = :hasBeenMarkedOOS")
    Observable<List<Product>> selectAllObservable(boolean z11);

    @Nullable
    @Query("SELECT * FROM Product WHERE id = :productId LIMIT 1")
    Product selectById(@NotNull String str);

    @Query("SELECT TOTAL(cartCount) FROM Product")
    int selectTotalProductsCount();

    @NotNull
    @Query("SELECT TOTAL(cartCount) FROM Product WHERE hasBeenMarkedOOS = :hasBeenMarkedOOS")
    Single<Integer> selectTotalProductsCountAsSingle(boolean z11);

    @Transaction
    void setProductCount(@NotNull Product product, int i11, @NotNull CartInfo cartInfo);

    @Transaction
    void updateAllSyncFailure();

    @NotNull
    @Transaction
    List<Product> updateAllSyncSuccess(@NotNull List<CartResponseProduct> list);

    @NotNull
    @Transaction
    List<Product> updateAllSyncSuccessV2(@NotNull List<CartResponseProduct> list);

    @Query("UPDATE Product SET freeCount = :value WHERE id = :productId")
    void updateFreeProductCount(@NotNull String str, int i11);

    @Query("UPDATE Product SET price = :price WHERE id = :productId")
    void updatePrice(@NotNull String str, float f11);

    @Query("UPDATE Product SET absoluteDiscount = :absoluteDiscount WHERE id = :productId")
    void updateProductAbsoluteDiscount(@NotNull String str, float f11);

    @Query("UPDATE Product SET categoryId = :value WHERE id = :productId AND categoryId = ''")
    void updateProductCategory(@NotNull String str, @NotNull String str2);

    @Query("UPDATE Product SET cartCount = :value WHERE id = :productId")
    void updateProductCount(@NotNull String str, int i11);

    @Query("UPDATE Product SET predictedToBeOOS = :predictedToBeOOS WHERE id = :productId")
    void updateProductOOSPrediction(@NotNull String str, boolean z11);

    @Query("UPDATE Product SET offerText = :offerText WHERE id = :productId")
    void updateProductOfferText(@NotNull String str, @Nullable String str2);

    @Query("UPDATE Product SET sku = :value WHERE id = :productId")
    void updateProductSku(@NotNull String str, @NotNull String str2);

    @Query("UPDATE Product SET stock = :value, hasQuantityChanged = :hasQuantityChanged WHERE id = :productId")
    void updateProductStockAmount(@NotNull String str, int i11, boolean z11);

    @Query("UPDATE Product SET syncedCount = :value WHERE id = :productId")
    void updateProductSyncCount(@NotNull String str, int i11);

    @Query("UPDATE Product SET toolTipAlertText = :toolTipAlertText WHERE id = :productId")
    void updateProductToolTipAlertText(@NotNull String str, @Nullable String str2);
}
