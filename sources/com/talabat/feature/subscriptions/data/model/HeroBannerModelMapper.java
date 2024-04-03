package com.talabat.feature.subscriptions.data.model;

import com.talabat.feature.subscriptions.data.remote.model.HeroWidgetResponseModel;
import com.talabat.feature.subscriptions.domain.model.HeroWidgetModel;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/subscriptions/data/model/HeroBannerModelMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/data/remote/model/HeroWidgetResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/HeroWidgetModel;", "()V", "apply", "source", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HeroBannerModelMapper implements ModelMapper<HeroWidgetResponseModel, HeroWidgetModel> {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.feature.subscriptions.domain.model.HeroWidgetModel apply(@org.jetbrains.annotations.NotNull com.talabat.feature.subscriptions.data.remote.model.HeroWidgetResponseModel r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.String r1 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            boolean r1 = r0 instanceof com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingExpandableWidgetResponseModel
            r2 = 0
            r3 = 10
            r4 = 0
            java.lang.String r5 = ""
            if (r1 == 0) goto L_0x00da
            com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingExpandableWidgetResponseModel r0 = (com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingExpandableWidgetResponseModel) r0
            java.util.List r1 = r0.getListItems()
            if (r1 == 0) goto L_0x0074
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r4 = new java.util.ArrayList
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r1, r3)
            r4.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0028:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0074
            java.lang.Object r3 = r1.next()
            com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingExpandableItemResponseModel r3 = (com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingExpandableItemResponseModel) r3
            com.talabat.feature.subscriptions.domain.model.TProOnBoardingExpandableItemModel r13 = new com.talabat.feature.subscriptions.domain.model.TProOnBoardingExpandableItemModel
            java.lang.String r6 = r3.getTitle()
            if (r6 != 0) goto L_0x003e
            r7 = r5
            goto L_0x003f
        L_0x003e:
            r7 = r6
        L_0x003f:
            java.lang.String r6 = r3.getTitleColor()
            if (r6 != 0) goto L_0x0047
            r8 = r5
            goto L_0x0048
        L_0x0047:
            r8 = r6
        L_0x0048:
            java.lang.String r6 = r3.getValue()
            if (r6 != 0) goto L_0x0050
            r9 = r5
            goto L_0x0051
        L_0x0050:
            r9 = r6
        L_0x0051:
            java.lang.String r6 = r3.getValueColor()
            if (r6 != 0) goto L_0x0059
            r10 = r5
            goto L_0x005a
        L_0x0059:
            r10 = r6
        L_0x005a:
            java.lang.String r6 = r3.getSubTitle()
            if (r6 != 0) goto L_0x0062
            r11 = r5
            goto L_0x0063
        L_0x0062:
            r11 = r6
        L_0x0063:
            java.lang.String r3 = r3.getSubTitleColor()
            if (r3 != 0) goto L_0x006b
            r12 = r5
            goto L_0x006c
        L_0x006b:
            r12 = r3
        L_0x006c:
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r4.add(r13)
            goto L_0x0028
        L_0x0074:
            if (r4 != 0) goto L_0x007a
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x007a:
            r15 = r4
            com.talabat.feature.subscriptions.domain.model.HeroWidgetType r16 = com.talabat.feature.subscriptions.domain.model.HeroWidgetType.expandableWidget
            java.lang.String r1 = r0.getExpandWidgetTitle()
            if (r1 != 0) goto L_0x0085
            r14 = r5
            goto L_0x0086
        L_0x0085:
            r14 = r1
        L_0x0086:
            java.lang.Boolean r1 = r0.isExpanded()
            if (r1 == 0) goto L_0x0090
            boolean r2 = r1.booleanValue()
        L_0x0090:
            r13 = r2
            java.lang.String r1 = r0.getTitle()
            if (r1 != 0) goto L_0x0099
            r9 = r5
            goto L_0x009a
        L_0x0099:
            r9 = r1
        L_0x009a:
            java.lang.String r1 = r0.getTitleColor()
            if (r1 != 0) goto L_0x00a2
            r10 = r5
            goto L_0x00a3
        L_0x00a2:
            r10 = r1
        L_0x00a3:
            java.lang.String r1 = r0.getSubtitle()
            if (r1 != 0) goto L_0x00ab
            r11 = r5
            goto L_0x00ac
        L_0x00ab:
            r11 = r1
        L_0x00ac:
            java.lang.String r1 = r0.getSubTitleColor()
            if (r1 != 0) goto L_0x00b4
            r12 = r5
            goto L_0x00b5
        L_0x00b4:
            r12 = r1
        L_0x00b5:
            java.lang.String r1 = r0.getHeaderTitle()
            if (r1 != 0) goto L_0x00bd
            r7 = r5
            goto L_0x00be
        L_0x00bd:
            r7 = r1
        L_0x00be:
            java.lang.String r1 = r0.getHeaderTitleColor()
            if (r1 != 0) goto L_0x00c6
            r8 = r5
            goto L_0x00c7
        L_0x00c6:
            r8 = r1
        L_0x00c7:
            java.lang.String r0 = r0.getTrackingId()
            if (r0 != 0) goto L_0x00d0
            r17 = r5
            goto L_0x00d2
        L_0x00d0:
            r17 = r0
        L_0x00d2:
            com.talabat.feature.subscriptions.domain.model.TProOnBoardingExpandableWidgetModel r0 = new com.talabat.feature.subscriptions.domain.model.TProOnBoardingExpandableWidgetModel
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            goto L_0x0172
        L_0x00da:
            boolean r1 = r0 instanceof com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingInfoWidgetResponseModel
            if (r1 == 0) goto L_0x0162
            r1 = r0
            com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingInfoWidgetResponseModel r1 = (com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingInfoWidgetResponseModel) r1
            java.util.List r6 = r1.getListItems()
            if (r6 == 0) goto L_0x0142
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r4 = new java.util.ArrayList
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r6, r3)
            r4.<init>(r3)
            java.util.Iterator r3 = r6.iterator()
        L_0x00f6:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x0142
            java.lang.Object r6 = r3.next()
            com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingInfoItemResponseModel r6 = (com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingInfoItemResponseModel) r6
            com.talabat.feature.subscriptions.domain.model.TProOnBoardingInfoItemModel r14 = new com.talabat.feature.subscriptions.domain.model.TProOnBoardingInfoItemModel
            java.lang.String r7 = r6.getTitle()
            if (r7 != 0) goto L_0x010c
            r8 = r5
            goto L_0x010d
        L_0x010c:
            r8 = r7
        L_0x010d:
            java.lang.String r7 = r6.getTitleColor()
            if (r7 != 0) goto L_0x0115
            r9 = r5
            goto L_0x0116
        L_0x0115:
            r9 = r7
        L_0x0116:
            java.lang.String r7 = r6.getSubtitle()
            if (r7 != 0) goto L_0x011e
            r10 = r5
            goto L_0x011f
        L_0x011e:
            r10 = r7
        L_0x011f:
            java.lang.String r7 = r6.getSubTitleColor()
            if (r7 != 0) goto L_0x0127
            r11 = r5
            goto L_0x0128
        L_0x0127:
            r11 = r7
        L_0x0128:
            java.lang.String r7 = r6.getCtaTitle()
            if (r7 != 0) goto L_0x0130
            r12 = r5
            goto L_0x0131
        L_0x0130:
            r12 = r7
        L_0x0131:
            java.lang.String r6 = r6.getCtaColor()
            if (r6 != 0) goto L_0x0139
            r13 = r5
            goto L_0x013a
        L_0x0139:
            r13 = r6
        L_0x013a:
            r7 = r14
            r7.<init>(r8, r9, r10, r11, r12, r13)
            r4.add(r14)
            goto L_0x00f6
        L_0x0142:
            if (r4 != 0) goto L_0x0148
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0148:
            java.lang.Integer r1 = r1.getSelectedIndex()
            if (r1 == 0) goto L_0x0152
            int r2 = r1.intValue()
        L_0x0152:
            com.talabat.feature.subscriptions.domain.model.HeroWidgetType r1 = com.talabat.feature.subscriptions.domain.model.HeroWidgetType.infoWidget
            java.lang.String r0 = r19.getTrackingId()
            if (r0 != 0) goto L_0x015b
            goto L_0x015c
        L_0x015b:
            r5 = r0
        L_0x015c:
            com.talabat.feature.subscriptions.domain.model.TProOnBoardingInfoWidgetModel r0 = new com.talabat.feature.subscriptions.domain.model.TProOnBoardingInfoWidgetModel
            r0.<init>(r2, r4, r1, r5)
            goto L_0x0172
        L_0x0162:
            com.talabat.feature.subscriptions.domain.model.TProOnBoardingDefaultWidgetModel r1 = new com.talabat.feature.subscriptions.domain.model.TProOnBoardingDefaultWidgetModel
            com.talabat.feature.subscriptions.domain.model.HeroWidgetType r2 = com.talabat.feature.subscriptions.domain.model.HeroWidgetType.f469default
            java.lang.String r0 = r19.getTrackingId()
            if (r0 != 0) goto L_0x016d
            goto L_0x016e
        L_0x016d:
            r5 = r0
        L_0x016e:
            r1.<init>(r2, r5)
            r0 = r1
        L_0x0172:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.model.HeroBannerModelMapper.apply(com.talabat.feature.subscriptions.data.remote.model.HeroWidgetResponseModel):com.talabat.feature.subscriptions.domain.model.HeroWidgetModel");
    }
}
