package com.talabat.feature.darkstoresflutter.data.repository;

import com.talabat.feature.darkstorescart.data.model.CartResponse;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import com.talabat.feature.darkstoresflutter.data.mapper.CampaignProgressToFlutterCampaignProgressMapper;
import com.talabat.feature.darkstoresflutter.data.mapper.FlutterCartToMapMapper;
import com.talabat.feature.darkstoresflutter.data.mapper.FlutterMapToProductMapper;
import com.talabat.feature.darkstoresflutter.data.mapper.ProductToFlutterCartItemMapper;
import com.talabat.feature.darkstoresflutter.data.model.FlutterCart;
import com.talabat.feature.darkstoresflutter.domain.repository.DarkstoresCartFlutterRepository;
import dagger.Reusable;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lm.a;
import lm.b;
import lm.c;
import lm.d;
import lm.e;
import lm.f;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ$\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0011H\u0016J$\u0010!\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00100\"2\u0006\u0010#\u001a\u00020\u0011H\u0016J\b\u0010$\u001a\u00020\u000eH\u0016J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0011H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/repository/DarkstoresCartFlutterRepositoryImpl;", "Lcom/talabat/feature/darkstoresflutter/domain/repository/DarkstoresCartFlutterRepository;", "cartRepository", "Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;", "productToFlutterCartItemMapper", "Lcom/talabat/feature/darkstoresflutter/data/mapper/ProductToFlutterCartItemMapper;", "flutterMapToProductMapper", "Lcom/talabat/feature/darkstoresflutter/data/mapper/FlutterMapToProductMapper;", "flutterCartToMapMapper", "Lcom/talabat/feature/darkstoresflutter/data/mapper/FlutterCartToMapMapper;", "campaignProgressToFlutterCampaignProgressMapper", "Lcom/talabat/feature/darkstoresflutter/data/mapper/CampaignProgressToFlutterCampaignProgressMapper;", "(Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;Lcom/talabat/feature/darkstoresflutter/data/mapper/ProductToFlutterCartItemMapper;Lcom/talabat/feature/darkstoresflutter/data/mapper/FlutterMapToProductMapper;Lcom/talabat/feature/darkstoresflutter/data/mapper/FlutterCartToMapMapper;Lcom/talabat/feature/darkstoresflutter/data/mapper/CampaignProgressToFlutterCampaignProgressMapper;)V", "addProductToCart", "Lio/reactivex/Completable;", "productMap", "", "", "", "globalVendorId", "buildFlutterCart", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCart;", "cartResponse", "Lcom/talabat/feature/darkstorescart/data/model/CartResponse;", "isCartUploadInProgress", "", "products", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "clearCart", "navigateToCheckout", "", "specialRequest", "observeCartChanges", "Lio/reactivex/Observable;", "vendorId", "refreshCart", "removeProductFromCart", "productId", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class DarkstoresCartFlutterRepositoryImpl implements DarkstoresCartFlutterRepository {
    @NotNull
    private final CampaignProgressToFlutterCampaignProgressMapper campaignProgressToFlutterCampaignProgressMapper;
    @NotNull
    private final DarkstoresCartRepository cartRepository;
    @NotNull
    private final FlutterCartToMapMapper flutterCartToMapMapper;
    @NotNull
    private final FlutterMapToProductMapper flutterMapToProductMapper;
    @NotNull
    private final ProductToFlutterCartItemMapper productToFlutterCartItemMapper;

    @Inject
    public DarkstoresCartFlutterRepositoryImpl(@NotNull DarkstoresCartRepository darkstoresCartRepository, @NotNull ProductToFlutterCartItemMapper productToFlutterCartItemMapper2, @NotNull FlutterMapToProductMapper flutterMapToProductMapper2, @NotNull FlutterCartToMapMapper flutterCartToMapMapper2, @NotNull CampaignProgressToFlutterCampaignProgressMapper campaignProgressToFlutterCampaignProgressMapper2) {
        Intrinsics.checkNotNullParameter(darkstoresCartRepository, "cartRepository");
        Intrinsics.checkNotNullParameter(productToFlutterCartItemMapper2, "productToFlutterCartItemMapper");
        Intrinsics.checkNotNullParameter(flutterMapToProductMapper2, "flutterMapToProductMapper");
        Intrinsics.checkNotNullParameter(flutterCartToMapMapper2, "flutterCartToMapMapper");
        Intrinsics.checkNotNullParameter(campaignProgressToFlutterCampaignProgressMapper2, "campaignProgressToFlutterCampaignProgressMapper");
        this.cartRepository = darkstoresCartRepository;
        this.productToFlutterCartItemMapper = productToFlutterCartItemMapper2;
        this.flutterMapToProductMapper = flutterMapToProductMapper2;
        this.flutterCartToMapMapper = flutterCartToMapMapper2;
        this.campaignProgressToFlutterCampaignProgressMapper = campaignProgressToFlutterCampaignProgressMapper2;
    }

    /* access modifiers changed from: private */
    /* renamed from: addProductToCart$lambda-0  reason: not valid java name */
    public static final Product m10200addProductToCart$lambda0(DarkstoresCartFlutterRepositoryImpl darkstoresCartFlutterRepositoryImpl, Map map) {
        Intrinsics.checkNotNullParameter(darkstoresCartFlutterRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(map, "$productMap");
        return darkstoresCartFlutterRepositoryImpl.flutterMapToProductMapper.apply((Map<String, ? extends Object>) map);
    }

    /* access modifiers changed from: private */
    /* renamed from: addProductToCart$lambda-1  reason: not valid java name */
    public static final CompletableSource m10201addProductToCart$lambda1(DarkstoresCartFlutterRepositoryImpl darkstoresCartFlutterRepositoryImpl, String str, Product product) {
        Intrinsics.checkNotNullParameter(darkstoresCartFlutterRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(str, "$globalVendorId");
        Intrinsics.checkNotNullParameter(product, "product");
        return darkstoresCartFlutterRepositoryImpl.cartRepository.addProductToCart(product, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.talabat.feature.darkstorescart.data.model.CartResponseProduct} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: com.talabat.feature.darkstorescart.data.model.CartResponseProduct} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: com.talabat.feature.darkstorescart.data.model.CartResponseProduct} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: com.talabat.feature.darkstorescart.data.model.CartResponseProduct} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.talabat.feature.darkstoresflutter.data.model.FlutterCart buildFlutterCart(com.talabat.feature.darkstorescart.data.model.CartResponse r19, boolean r20, java.util.List<com.talabat.feature.darkstorescart.data.model.Product> r21) {
        /*
            r18 = this;
            r0 = r18
            com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository r1 = r0.cartRepository
            java.lang.String r3 = r1.getCartId()
            java.lang.String r4 = r19.getVendorId()
            java.lang.Float r1 = r19.getMinimumOrderValue()
            if (r1 == 0) goto L_0x0017
            float r1 = r1.floatValue()
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            r5 = r1
            r1 = r21
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r6 = new java.util.ArrayList
            r2 = 10
            int r7 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r1, r2)
            r6.<init>(r7)
            java.util.Iterator r1 = r1.iterator()
        L_0x002c:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x0070
            java.lang.Object r7 = r1.next()
            com.talabat.feature.darkstorescart.data.model.Product r7 = (com.talabat.feature.darkstorescart.data.model.Product) r7
            java.util.List r9 = r19.getItems()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x0042:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x005f
            java.lang.Object r10 = r9.next()
            r11 = r10
            com.talabat.feature.darkstorescart.data.model.CartResponseProduct r11 = (com.talabat.feature.darkstorescart.data.model.CartResponseProduct) r11
            java.lang.String r11 = r11.getProductId()
            java.lang.String r12 = r7.getId()
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
            if (r11 == 0) goto L_0x0042
            r8 = r10
            goto L_0x0060
        L_0x005f:
            r8 = 0
        L_0x0060:
            com.talabat.feature.darkstorescart.data.model.CartResponseProduct r8 = (com.talabat.feature.darkstorescart.data.model.CartResponseProduct) r8
            com.talabat.feature.darkstoresflutter.data.mapper.ProductToFlutterCartItemMapper r9 = r0.productToFlutterCartItemMapper
            kotlin.Pair r7 = kotlin.TuplesKt.to(r7, r8)
            com.talabat.feature.darkstoresflutter.data.model.FlutterCartItem r7 = r9.apply((kotlin.Pair<com.talabat.feature.darkstorescart.data.model.Product, com.talabat.feature.darkstorescart.data.model.CartResponseProduct>) r7)
            r6.add(r7)
            goto L_0x002c
        L_0x0070:
            float r10 = r19.getSubtotal()
            float r11 = r19.getDeliveryFee()
            float r12 = r19.getTotal()
            float r13 = r19.getAbsoluteDiscount()
            float r14 = r19.getDeliveryAbsoluteDiscount()
            java.lang.Float r15 = r19.getServiceFee()
            float r17 = r19.getDeliveryTotal()
            java.lang.Float r16 = r19.getSubtotalAfterDiscount()
            com.talabat.feature.darkstoresflutter.data.model.FlutterPriceSummary r7 = new com.talabat.feature.darkstoresflutter.data.model.FlutterPriceSummary
            r9 = r7
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17)
            java.util.List r1 = r19.getAppliedCampaigns()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r9 = new java.util.ArrayList
            int r10 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r1, r2)
            r9.<init>(r10)
            java.util.Iterator r1 = r1.iterator()
        L_0x00a9:
            boolean r10 = r1.hasNext()
            if (r10 == 0) goto L_0x00c6
            java.lang.Object r10 = r1.next()
            com.talabat.feature.darkstorescart.data.model.CampaignLabel r10 = (com.talabat.feature.darkstorescart.data.model.CampaignLabel) r10
            com.talabat.feature.darkstoresflutter.data.model.FlutterCampaign r11 = new com.talabat.feature.darkstoresflutter.data.model.FlutterCampaign
            java.lang.String r12 = r10.getCampaignId()
            java.lang.String r10 = r10.getCampaignName()
            r11.<init>(r12, r10)
            r9.add(r11)
            goto L_0x00a9
        L_0x00c6:
            java.util.List r1 = r19.getFeeDescriptions()
            if (r1 == 0) goto L_0x010a
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r10 = new java.util.ArrayList
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r1, r2)
            r10.<init>(r2)
            java.util.Iterator r1 = r1.iterator()
        L_0x00db:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x010b
            java.lang.Object r2 = r1.next()
            com.talabat.feature.darkstorescart.data.model.FeeDescription r2 = (com.talabat.feature.darkstorescart.data.model.FeeDescription) r2
            com.talabat.feature.darkstoresflutter.data.model.FlutterFeeDescription r15 = new com.talabat.feature.darkstoresflutter.data.model.FlutterFeeDescription
            java.lang.String r12 = r2.getType()
            java.lang.String r13 = r2.getName()
            java.lang.String r14 = r2.getDescription()
            java.lang.String r16 = r2.getUrl()
            java.lang.String r2 = r2.getUrlText()
            r11 = r15
            r8 = r15
            r15 = r16
            r16 = r2
            r11.<init>(r12, r13, r14, r15, r16)
            r10.add(r8)
            goto L_0x00db
        L_0x010a:
            r10 = 0
        L_0x010b:
            com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse r1 = r19.getCampaignProgress()
            if (r1 == 0) goto L_0x0119
            com.talabat.feature.darkstoresflutter.data.mapper.CampaignProgressToFlutterCampaignProgressMapper r2 = r0.campaignProgressToFlutterCampaignProgressMapper
            com.talabat.feature.darkstoresflutter.data.model.FlutterCampaignProgressWrapper r1 = r2.apply((com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse) r1)
            r11 = r1
            goto L_0x011a
        L_0x0119:
            r11 = 0
        L_0x011a:
            com.talabat.feature.darkstoresflutter.data.model.FlutterCart r1 = new com.talabat.feature.darkstoresflutter.data.model.FlutterCart
            r2 = r1
            r8 = r9
            r9 = r10
            r10 = r20
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstoresflutter.data.repository.DarkstoresCartFlutterRepositoryImpl.buildFlutterCart(com.talabat.feature.darkstorescart.data.model.CartResponse, boolean, java.util.List):com.talabat.feature.darkstoresflutter.data.model.FlutterCart");
    }

    /* access modifiers changed from: private */
    /* renamed from: clearCart$lambda-2  reason: not valid java name */
    public static final Unit m10202clearCart$lambda2(DarkstoresCartFlutterRepositoryImpl darkstoresCartFlutterRepositoryImpl) {
        Intrinsics.checkNotNullParameter(darkstoresCartFlutterRepositoryImpl, "this$0");
        darkstoresCartFlutterRepositoryImpl.cartRepository.clearCart();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: observeCartChanges$lambda-5  reason: not valid java name */
    public static final ObservableSource m10203observeCartChanges$lambda5(DarkstoresCartFlutterRepositoryImpl darkstoresCartFlutterRepositoryImpl, Pair pair) {
        Intrinsics.checkNotNullParameter(darkstoresCartFlutterRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        return darkstoresCartFlutterRepositoryImpl.cartRepository.getAllInStockProducts().map(new f(darkstoresCartFlutterRepositoryImpl, (CartResponse) pair.component1(), ((Boolean) pair.component2()).booleanValue()));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeCartChanges$lambda-5$lambda-4  reason: not valid java name */
    public static final FlutterCart m10204observeCartChanges$lambda5$lambda4(DarkstoresCartFlutterRepositoryImpl darkstoresCartFlutterRepositoryImpl, CartResponse cartResponse, boolean z11, List list) {
        Intrinsics.checkNotNullParameter(darkstoresCartFlutterRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(cartResponse, "$response");
        Intrinsics.checkNotNullParameter(list, "products");
        return darkstoresCartFlutterRepositoryImpl.buildFlutterCart(cartResponse, z11, list);
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshCart$lambda-3  reason: not valid java name */
    public static final Unit m10205refreshCart$lambda3(DarkstoresCartFlutterRepositoryImpl darkstoresCartFlutterRepositoryImpl) {
        Intrinsics.checkNotNullParameter(darkstoresCartFlutterRepositoryImpl, "this$0");
        darkstoresCartFlutterRepositoryImpl.cartRepository.refreshCart();
        return Unit.INSTANCE;
    }

    @NotNull
    public Completable addProductToCart(@NotNull Map<String, ? extends Object> map, @NotNull String str) {
        Intrinsics.checkNotNullParameter(map, "productMap");
        Intrinsics.checkNotNullParameter(str, "globalVendorId");
        Completable flatMapCompletable = Single.fromCallable(new b(this, map)).flatMapCompletable(new c(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "fromCallable { flutterMa…alVendorId)\n            }");
        return flatMapCompletable;
    }

    @NotNull
    public Completable clearCart() {
        Completable fromCallable = Completable.fromCallable(new d(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "fromCallable {\n         …ory.clearCart()\n        }");
        return fromCallable;
    }

    public void navigateToCheckout(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "specialRequest");
        this.cartRepository.navigateToCheckout(str);
    }

    @NotNull
    public Observable<Map<String, Object>> observeCartChanges(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Observable<R> map = this.cartRepository.getCartResponse().switchMap(new a(this)).map(this.flutterCartToMapMapper);
        Intrinsics.checkNotNullExpressionValue(map, "cartRepository.getCartRe…p(flutterCartToMapMapper)");
        return map;
    }

    @NotNull
    public Completable refreshCart() {
        Completable fromCallable = Completable.fromCallable(new e(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "fromCallable {\n         …y.refreshCart()\n        }");
        return fromCallable;
    }

    @NotNull
    public Completable removeProductFromCart(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "productId");
        return this.cartRepository.removeProductFromCart(str);
    }
}
