package com.talabat.feature.darkstoresflutter.data.mapper;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstoresflutter.data.model.FlutterCartItem;
import com.talabat.mapper.ModelMapper;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\u0011\u001a\u00020\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016R?\u0010\t\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/mapper/FlutterMapToProductMapper;", "Lcom/talabat/mapper/ModelMapper;", "", "", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "flutterCartItemAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCartItem;", "kotlin.jvm.PlatformType", "getFlutterCartItemAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "flutterCartItemAdapter$delegate", "Lkotlin/Lazy;", "apply", "source", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterMapToProductMapper implements ModelMapper<Map<String, ? extends Object>, Product> {
    @NotNull
    private final Lazy flutterCartItemAdapter$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new FlutterMapToProductMapper$flutterCartItemAdapter$2(this));
    /* access modifiers changed from: private */
    @NotNull
    public final Moshi moshi;

    @Inject
    public FlutterMapToProductMapper(@NotNull Moshi moshi2) {
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.moshi = moshi2;
    }

    private final JsonAdapter<FlutterCartItem> getFlutterCartItemAdapter() {
        return (JsonAdapter) this.flutterCartItemAdapter$delegate.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00ba, code lost:
        r1 = r1.getNmrAdId();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.feature.darkstorescart.data.model.Product apply(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, ? extends java.lang.Object> r37) {
        /*
            r36 = this;
            r0 = r37
            java.lang.String r1 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            com.squareup.moshi.JsonAdapter r1 = r36.getFlutterCartItemAdapter()
            java.lang.Object r0 = r1.fromJsonValue(r0)
            com.talabat.feature.darkstoresflutter.data.model.FlutterCartItem r0 = (com.talabat.feature.darkstoresflutter.data.model.FlutterCartItem) r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r2 = r0.getProductId()
            float r5 = r0.getPrice()
            java.lang.Float r6 = r0.getOldPrice()
            int r7 = r0.getQuantity()
            int r3 = r0.getFreeQuantity()
            java.util.List r1 = r0.getCampaigns()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r15 = new java.util.ArrayList
            r4 = 10
            int r8 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r1, r4)
            r15.<init>(r8)
            java.util.Iterator r1 = r1.iterator()
        L_0x003d:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x005a
            java.lang.Object r8 = r1.next()
            com.talabat.feature.darkstoresflutter.data.model.FlutterCampaign r8 = (com.talabat.feature.darkstoresflutter.data.model.FlutterCampaign) r8
            com.talabat.feature.darkstorescart.data.model.CampaignLabel r9 = new com.talabat.feature.darkstorescart.data.model.CampaignLabel
            java.lang.String r10 = r8.getCampaignId()
            java.lang.String r8 = r8.getName()
            r9.<init>(r10, r8)
            r15.add(r9)
            goto L_0x003d
        L_0x005a:
            float r10 = r0.getAbsoluteDiscount()
            int r24 = r0.getAgeLimit()
            java.lang.String r11 = r0.getMainImageUrl()
            java.util.List r1 = r0.getImageURLs()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r13 = new java.util.ArrayList
            int r4 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r1, r4)
            r13.<init>(r4)
            java.util.Iterator r1 = r1.iterator()
        L_0x0079:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r1.next()
            java.lang.String r4 = (java.lang.String) r4
            com.talabat.feature.darkstorescart.data.model.ProductUrl r8 = new com.talabat.feature.darkstorescart.data.model.ProductUrl
            r8.<init>(r4)
            r13.add(r8)
            goto L_0x0079
        L_0x008e:
            java.lang.String r1 = r0.getCategoryId()
            if (r1 != 0) goto L_0x0096
            java.lang.String r1 = ""
        L_0x0096:
            r19 = r1
            java.lang.String r17 = r0.getItemDescription()
            java.lang.String r4 = r0.getName()
            java.util.List r16 = r0.getTags()
            int r18 = r0.getStockAmount()
            java.lang.String r21 = r0.getSku()
            boolean r20 = r0.isFavourited()
            boolean r22 = r0.isSponsored()
            com.talabat.feature.darkstoresflutter.data.model.FlutterTracking r1 = r0.getTracking()
            if (r1 == 0) goto L_0x00c8
            java.lang.String r1 = r1.getNmrAdId()
            if (r1 == 0) goto L_0x00c8
            com.talabat.feature.darkstorescart.data.model.Tracking r8 = new com.talabat.feature.darkstorescart.data.model.Tracking
            r8.<init>(r1)
            r35 = r8
            goto L_0x00cb
        L_0x00c8:
            r1 = 0
            r35 = r1
        L_0x00cb:
            java.lang.String r31 = r0.getOfferText()
            java.lang.String r32 = r0.getTooltipAlertText()
            com.talabat.feature.darkstorescart.data.model.Product r0 = new com.talabat.feature.darkstorescart.data.model.Product
            r1 = r0
            r8 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
            java.lang.Float r10 = java.lang.Float.valueOf(r10)
            r12 = 0
            r14 = 0
            r23 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r33 = 530584640(0x1fa01440, float:6.7796137E-20)
            r34 = 0
            r3 = r4
            r4 = r11
            r11 = r35
            r35 = r13
            r13 = r18
            r18 = r15
            r15 = r35
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstoresflutter.data.mapper.FlutterMapToProductMapper.apply(java.util.Map):com.talabat.feature.darkstorescart.data.model.Product");
    }
}
