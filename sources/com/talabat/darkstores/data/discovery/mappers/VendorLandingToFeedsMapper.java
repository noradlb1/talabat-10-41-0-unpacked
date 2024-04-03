package com.talabat.darkstores.data.discovery.mappers;

import com.talabat.darkstores.data.discovery.model.FeedMultiListData;
import com.talabat.darkstores.model.Category;
import com.talabat.darkstores.model.Swimlane;
import com.talabat.feature.darkstores.vendorlanding.domain.model.Banner;
import com.talabat.feature.darkstores.vendorlanding.domain.model.CategoryTree;
import com.talabat.feature.darkstores.vendorlanding.domain.model.ImageUrl;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LayoutType;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMission;
import com.talabat.feature.darkstores.vendorlanding.domain.model.SubCategory;
import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLanding;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J&\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/data/discovery/mappers/VendorLandingToFeedsMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/VendorLanding;", "Lcom/talabat/darkstores/data/discovery/model/FeedMultiListData;", "bannerMapper", "Lcom/talabat/darkstores/data/discovery/mappers/BannerDomainToViewModelMapper;", "(Lcom/talabat/darkstores/data/discovery/mappers/BannerDomainToViewModelMapper;)V", "apply", "source", "parseSwimlanes", "", "Lcom/talabat/darkstores/model/Swimlane;", "swimlaneItems", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Item;", "requestId", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorLandingToFeedsMapper implements ModelMapper<VendorLanding, FeedMultiListData> {
    @NotNull
    private final BannerDomainToViewModelMapper bannerMapper;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutType.values().length];
            iArr[LayoutType.COMPACT.ordinal()] = 1;
            iArr[LayoutType.COMPACT_WITH_TEXT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public VendorLandingToFeedsMapper(@NotNull BannerDomainToViewModelMapper bannerDomainToViewModelMapper) {
        Intrinsics.checkNotNullParameter(bannerDomainToViewModelMapper, "bannerMapper");
        this.bannerMapper = bannerDomainToViewModelMapper;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<com.talabat.darkstores.model.Swimlane> parseSwimlanes(java.util.List<com.talabat.feature.darkstores.vendorlanding.domain.model.Item> r47, java.lang.String r48) {
        /*
            r46 = this;
            r0 = r47
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r2)
            r1.<init>(r3)
            java.util.Iterator r0 = r0.iterator()
        L_0x0013:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x013f
            java.lang.Object r3 = r0.next()
            com.talabat.feature.darkstores.vendorlanding.domain.model.Item r3 = (com.talabat.feature.darkstores.vendorlanding.domain.model.Item) r3
            java.lang.String r5 = r3.getName()
            java.lang.String r10 = r3.getId()
            com.talabat.feature.darkstores.vendorlanding.domain.model.LayoutType r4 = r3.getLayoutType()
            int[] r6 = com.talabat.darkstores.data.discovery.mappers.VendorLandingToFeedsMapper.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r6[r4]
            r6 = 1
            if (r4 == r6) goto L_0x003e
            r6 = 2
            if (r4 == r6) goto L_0x003b
            r8 = 0
            goto L_0x0041
        L_0x003b:
            com.talabat.darkstores.model.CompactSwimlaneLayoutType r4 = com.talabat.darkstores.model.CompactSwimlaneLayoutType.COMPACT_WITH_TEXT
            goto L_0x0040
        L_0x003e:
            com.talabat.darkstores.model.CompactSwimlaneLayoutType r4 = com.talabat.darkstores.model.CompactSwimlaneLayoutType.COMPACT
        L_0x0040:
            r8 = r4
        L_0x0041:
            java.util.List r4 = r3.getProducts()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r9 = new java.util.ArrayList
            int r6 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r4, r2)
            r9.<init>(r6)
            java.util.Iterator r4 = r4.iterator()
        L_0x0054:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0117
            java.lang.Object r6 = r4.next()
            com.talabat.feature.darkstores.vendorlanding.domain.model.SwimlaneProduct r6 = (com.talabat.feature.darkstores.vendorlanding.domain.model.SwimlaneProduct) r6
            java.lang.String r12 = r6.getId()
            java.lang.String r13 = r6.getName()
            java.lang.String r14 = r6.getImageUrl()
            float r15 = r6.getPrice()
            java.lang.Float r16 = r6.getOriginalPrice()
            r17 = 0
            r18 = 0
            r11 = 0
            java.lang.Integer r19 = java.lang.Integer.valueOf(r11)
            r20 = 0
            com.talabat.feature.darkstores.vendorlanding.domain.model.SwimlaneProductTracking r11 = r6.getTracking()
            if (r11 == 0) goto L_0x0091
            com.talabat.feature.darkstorescart.data.model.Tracking r7 = new com.talabat.feature.darkstorescart.data.model.Tracking
            java.lang.String r11 = r11.getNmrAdId()
            r7.<init>(r11)
            r21 = r7
            goto L_0x0093
        L_0x0091:
            r21 = 0
        L_0x0093:
            java.lang.String r22 = r6.getVendorId()
            int r23 = r6.getStockAmount()
            boolean r24 = r6.isAvailable()
            java.util.List r7 = r6.getImageUrls()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r11 = new java.util.ArrayList
            r45 = r0
            int r0 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r7, r2)
            r11.<init>(r0)
            java.util.Iterator r0 = r7.iterator()
        L_0x00b4:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L_0x00cf
            java.lang.Object r7 = r0.next()
            com.talabat.feature.darkstores.vendorlanding.domain.model.ImageUrl r7 = (com.talabat.feature.darkstores.vendorlanding.domain.model.ImageUrl) r7
            com.talabat.feature.darkstorescart.data.model.ProductUrl r2 = new com.talabat.feature.darkstorescart.data.model.ProductUrl
            java.lang.String r7 = r7.getUrl()
            r2.<init>(r7)
            r11.add(r2)
            r2 = 10
            goto L_0x00b4
        L_0x00cf:
            java.util.List r26 = r6.getTags()
            java.lang.String r27 = r6.getDescription()
            java.util.List r28 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            java.lang.String r29 = r6.getCategoryId()
            r30 = 0
            java.lang.String r31 = r6.getSku()
            boolean r32 = r6.isSponsored()
            r33 = 0
            int r34 = r6.getAgeLimit()
            r35 = 0
            r36 = 0
            java.lang.Boolean r38 = java.lang.Boolean.FALSE
            r39 = r38
            r40 = r38
            r37 = r38
            java.lang.String r41 = r6.getOfferText()
            r42 = 0
            r43 = 1098907648(0x41800000, float:16.0)
            r44 = 0
            com.talabat.feature.darkstorescart.data.model.Product r0 = new com.talabat.feature.darkstorescart.data.model.Product
            r2 = r11
            r11 = r0
            r25 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)
            r9.add(r0)
            r0 = r45
            r2 = 10
            goto L_0x0054
        L_0x0117:
            r45 = r0
            com.talabat.darkstores.model.SwimlaneTracking r12 = new com.talabat.darkstores.model.SwimlaneTracking
            com.talabat.feature.darkstores.vendorlanding.domain.model.Tracking r0 = r3.getTracking()
            if (r0 == 0) goto L_0x0126
            java.lang.String r7 = r0.getTrackingId()
            goto L_0x0127
        L_0x0126:
            r7 = 0
        L_0x0127:
            r12.<init>(r7)
            com.talabat.darkstores.model.Swimlane r0 = new com.talabat.darkstores.model.Swimlane
            r6 = 0
            r2 = 0
            r4 = r0
            r7 = r8
            r8 = r2
            r11 = r48
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            r1.add(r0)
            r0 = r45
            r2 = 10
            goto L_0x0013
        L_0x013f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.data.discovery.mappers.VendorLandingToFeedsMapper.parseSwimlanes(java.util.List, java.lang.String):java.util.List");
    }

    @NotNull
    public FeedMultiListData apply(@NotNull VendorLanding vendorLanding) {
        Intrinsics.checkNotNullParameter(vendorLanding, "source");
        Iterable<CategoryTree> categoryTree = vendorLanding.getCategoryTree();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(categoryTree, 10));
        for (CategoryTree categoryTree2 : categoryTree) {
            String name2 = categoryTree2.getName();
            String id2 = categoryTree2.getId();
            Iterable<ImageUrl> imageUrls = categoryTree2.getImageUrls();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(imageUrls, 10));
            for (ImageUrl url : imageUrls) {
                arrayList2.add(new com.talabat.darkstores.data.discovery.model.ImageUrl(url.getUrl()));
            }
            Iterable<SubCategory> subCategories = categoryTree2.getSubCategories();
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(subCategories, 10));
            for (SubCategory subCategory : subCategories) {
                arrayList3.add(new com.talabat.darkstores.model.SubCategory(subCategory.getName(), subCategory.getId()));
            }
            arrayList.add(new Category(name2, id2, arrayList2, arrayList3));
        }
        String requestId = vendorLanding.getProductSwimlanes().getRequestId();
        String primaryMissionSwimlanesRequestId = vendorLanding.getMetadata().getPrimaryMissionSwimlanesRequestId();
        List<Swimlane> parseSwimlanes = parseSwimlanes(vendorLanding.getProductSwimlanes().getItems(), requestId);
        LifestyleMission lifestyleMission = vendorLanding.getLifestyleMission();
        List<Swimlane> parseSwimlanes2 = parseSwimlanes(vendorLanding.getTopSwimlanes(), requestId);
        List<Swimlane> parseSwimlanes3 = parseSwimlanes(vendorLanding.getHighlightedSwimlanes(), requestId);
        Iterable<Banner> heroBanners = vendorLanding.getHeroBanners();
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(heroBanners, 10));
        for (Banner apply : heroBanners) {
            arrayList4.add(this.bannerMapper.apply(apply));
        }
        Iterable<Banner> banners = vendorLanding.getBanners();
        ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(banners, 10));
        for (Banner apply2 : banners) {
            arrayList5.add(this.bannerMapper.apply(apply2));
        }
        return new FeedMultiListData(arrayList, lifestyleMission, requestId, parseSwimlanes, parseSwimlanes2, parseSwimlanes3, arrayList4, arrayList5, vendorLanding.getVendor(), primaryMissionSwimlanesRequestId);
    }
}
