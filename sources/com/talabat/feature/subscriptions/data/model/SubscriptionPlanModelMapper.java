package com.talabat.feature.subscriptions.data.model;

import com.talabat.feature.subscriptions.data.remote.model.SubscriptionPlanResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionProductResponse;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlan;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory;
import com.talabat.feature.subscriptions.domain.model.SubscriptionProduct;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0002¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/subscriptions/data/model/SubscriptionPlanModelMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPlanResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPlan;", "()V", "apply", "source", "mapCategory", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPlanCategory;", "category", "", "mapProduct", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionProduct;", "product", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionProductResponse;", "mapProductsList", "", "products", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPlanModelMapper implements ModelMapper<SubscriptionPlanResponseModel, SubscriptionPlan> {
    private final SubscriptionPlanCategory mapCategory(String str) {
        boolean z11;
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return SubscriptionPlanCategory.NONE;
        }
        return SubscriptionPlanCategory.valueOf(str);
    }

    private final SubscriptionProduct mapProduct(SubscriptionProductResponse subscriptionProductResponse) {
        String title = subscriptionProductResponse.getTitle();
        String str = "";
        if (title == null) {
            title = str;
        }
        String description = subscriptionProductResponse.getDescription();
        if (description == null) {
            description = str;
        }
        String id2 = subscriptionProductResponse.getId();
        if (id2 == null) {
            id2 = str;
        }
        String icon = subscriptionProductResponse.getIcon();
        if (icon != null) {
            str = icon;
        }
        return new SubscriptionProduct(title, id2, description, str);
    }

    private final List<SubscriptionProduct> mapProductsList(List<SubscriptionProductResponse> list) {
        Iterable<SubscriptionProductResponse> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (SubscriptionProductResponse mapProduct : iterable) {
            arrayList.add(mapProduct(mapProduct));
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: com.talabat.feature.subscriptions.data.remote.model.UdfItemResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: com.talabat.feature.subscriptions.data.remote.model.UdfItemResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.talabat.feature.subscriptions.data.remote.model.UdfItemResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v4, resolved type: com.talabat.feature.subscriptions.data.remote.model.UdfItemResponse} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0150  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.feature.subscriptions.domain.model.SubscriptionPlan apply(@org.jetbrains.annotations.NotNull com.talabat.feature.subscriptions.data.remote.model.SubscriptionPlanResponseModel r37) {
        /*
            r36 = this;
            r0 = r36
            java.lang.String r1 = "source"
            r2 = r37
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.util.List r1 = r37.getProducts()
            if (r1 != 0) goto L_0x0013
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0013:
            java.lang.String r3 = r37.getId()
            java.lang.String r4 = ""
            if (r3 != 0) goto L_0x001d
            r6 = r4
            goto L_0x001e
        L_0x001d:
            r6 = r3
        L_0x001e:
            java.lang.String r3 = r37.getTitle()
            if (r3 != 0) goto L_0x0026
            r7 = r4
            goto L_0x0027
        L_0x0026:
            r7 = r3
        L_0x0027:
            java.lang.String r3 = r37.getDescription()
            if (r3 != 0) goto L_0x002f
            r8 = r4
            goto L_0x0030
        L_0x002f:
            r8 = r3
        L_0x0030:
            com.talabat.feature.subscriptions.domain.model.CurrencyAmount r3 = new com.talabat.feature.subscriptions.domain.model.CurrencyAmount
            java.lang.Float r5 = r37.getAmount()
            if (r5 == 0) goto L_0x003d
            float r5 = r5.floatValue()
            goto L_0x003e
        L_0x003d:
            r5 = 0
        L_0x003e:
            java.lang.String r10 = r37.getCurrency()
            if (r10 != 0) goto L_0x0045
            r10 = r4
        L_0x0045:
            r3.<init>(r5, r10)
            java.lang.String r5 = r37.getCountry()
            if (r5 != 0) goto L_0x0050
            r10 = r4
            goto L_0x0051
        L_0x0050:
            r10 = r5
        L_0x0051:
            java.lang.Integer r5 = r37.getDurationDays()
            if (r5 == 0) goto L_0x005d
            int r5 = r5.intValue()
            r12 = r5
            goto L_0x005e
        L_0x005d:
            r12 = 0
        L_0x005e:
            com.talabat.feature.subscriptions.domain.model.FreeTrialInfo r15 = new com.talabat.feature.subscriptions.domain.model.FreeTrialInfo
            java.lang.Integer r5 = r37.getFreeTrialDays()
            if (r5 == 0) goto L_0x006b
            int r5 = r5.intValue()
            goto L_0x006c
        L_0x006b:
            r5 = 0
        L_0x006c:
            java.lang.String r13 = r37.getFreeTrialTitle()
            if (r13 != 0) goto L_0x0073
            r13 = r4
        L_0x0073:
            java.lang.Boolean r14 = r37.getFreeTrialEligible()
            if (r14 == 0) goto L_0x007e
            boolean r14 = r14.booleanValue()
            goto L_0x007f
        L_0x007e:
            r14 = 0
        L_0x007f:
            r15.<init>(r5, r13, r14)
            java.lang.String r5 = r37.getTermsUrl()
            if (r5 != 0) goto L_0x008a
            r13 = r4
            goto L_0x008b
        L_0x008a:
            r13 = r5
        L_0x008b:
            java.util.List r1 = r0.mapProductsList(r1)
            java.lang.Boolean r5 = r37.getActiveSubscription()
            if (r5 == 0) goto L_0x009b
            boolean r5 = r5.booleanValue()
            r14 = r5
            goto L_0x009c
        L_0x009b:
            r14 = 0
        L_0x009c:
            java.util.List r5 = r37.getUdf()
            r16 = 0
            if (r5 == 0) goto L_0x00d8
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x00aa:
            boolean r17 = r5.hasNext()
            if (r17 == 0) goto L_0x00c5
            java.lang.Object r17 = r5.next()
            r18 = r17
            com.talabat.feature.subscriptions.data.remote.model.UdfItemResponse r18 = (com.talabat.feature.subscriptions.data.remote.model.UdfItemResponse) r18
            java.lang.String r9 = r18.getKey()
            java.lang.String r11 = "minimumDeliveryFee"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r11)
            if (r9 == 0) goto L_0x00aa
            goto L_0x00c7
        L_0x00c5:
            r17 = r16
        L_0x00c7:
            com.talabat.feature.subscriptions.data.remote.model.UdfItemResponse r17 = (com.talabat.feature.subscriptions.data.remote.model.UdfItemResponse) r17
            if (r17 == 0) goto L_0x00d8
            java.lang.String r5 = r17.getValue()
            if (r5 == 0) goto L_0x00d8
            float r5 = java.lang.Float.parseFloat(r5)
            r19 = r5
            goto L_0x00da
        L_0x00d8:
            r19 = 0
        L_0x00da:
            java.util.List r5 = r37.getUdf()
            if (r5 == 0) goto L_0x0116
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x00e6:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x0105
            java.lang.Object r9 = r5.next()
            r11 = r9
            com.talabat.feature.subscriptions.data.remote.model.UdfItemResponse r11 = (com.talabat.feature.subscriptions.data.remote.model.UdfItemResponse) r11
            java.lang.String r11 = r11.getKey()
            java.lang.String r2 = "isFreeCoffeeEnabled"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0102
            r16 = r9
            goto L_0x0105
        L_0x0102:
            r2 = r37
            goto L_0x00e6
        L_0x0105:
            com.talabat.feature.subscriptions.data.remote.model.UdfItemResponse r16 = (com.talabat.feature.subscriptions.data.remote.model.UdfItemResponse) r16
            if (r16 == 0) goto L_0x0116
            java.lang.String r2 = r16.getValue()
            if (r2 == 0) goto L_0x0116
            java.lang.String r5 = "1"
            boolean r2 = r2.equals(r5)
            goto L_0x0117
        L_0x0116:
            r2 = 0
        L_0x0117:
            java.lang.String r5 = r37.getPlanPeriod()
            if (r5 != 0) goto L_0x0120
            r20 = r4
            goto L_0x0122
        L_0x0120:
            r20 = r5
        L_0x0122:
            java.lang.String r5 = r37.getBillingCycle()
            if (r5 != 0) goto L_0x012b
            r21 = r4
            goto L_0x012d
        L_0x012b:
            r21 = r5
        L_0x012d:
            java.lang.String r5 = r37.getPeriodPrice()
            if (r5 != 0) goto L_0x0136
            r22 = r4
            goto L_0x0138
        L_0x0136:
            r22 = r5
        L_0x0138:
            java.lang.Integer r5 = r37.getOrder()
            if (r5 == 0) goto L_0x0145
            int r5 = r5.intValue()
            r23 = r5
            goto L_0x0147
        L_0x0145:
            r23 = 0
        L_0x0147:
            java.lang.String r5 = r37.getFreeTrialText()
            if (r5 != 0) goto L_0x0150
            r24 = r4
            goto L_0x0152
        L_0x0150:
            r24 = r5
        L_0x0152:
            java.lang.String r5 = r37.getPaymentText()
            if (r5 != 0) goto L_0x015b
            r25 = r4
            goto L_0x015d
        L_0x015b:
            r25 = r5
        L_0x015d:
            java.lang.String r5 = r37.getCategory()
            com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory r26 = r0.mapCategory(r5)
            com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationType r27 = r37.getCancellationType()
            java.lang.String r5 = r37.getBenefitsHeader()
            if (r5 != 0) goto L_0x0172
            r29 = r4
            goto L_0x0174
        L_0x0172:
            r29 = r5
        L_0x0174:
            java.lang.String r5 = r37.getBannerHeader()
            if (r5 != 0) goto L_0x017d
            r28 = r4
            goto L_0x017f
        L_0x017d:
            r28 = r5
        L_0x017f:
            java.lang.String r5 = r37.getBannerImage()
            if (r5 != 0) goto L_0x0188
            r34 = r4
            goto L_0x018a
        L_0x0188:
            r34 = r5
        L_0x018a:
            java.lang.String r5 = r37.getBannerDescription()
            if (r5 != 0) goto L_0x0191
            goto L_0x0192
        L_0x0191:
            r4 = r5
        L_0x0192:
            com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType r30 = r37.getRenewType()
            com.talabat.feature.subscriptions.domain.model.SubscriptionPlan r35 = new com.talabat.feature.subscriptions.domain.model.SubscriptionPlan
            r5 = r35
            r31 = 0
            r32 = 33554432(0x2000000, float:9.403955E-38)
            r33 = 0
            r9 = r10
            r10 = r12
            r11 = r13
            r12 = r14
            r13 = r19
            r14 = r2
            r2 = r15
            r15 = r1
            r16 = r3
            r17 = r2
            r18 = r22
            r19 = r20
            r20 = r21
            r21 = r24
            r22 = r25
            r24 = r26
            r25 = r27
            r26 = r34
            r27 = r28
            r28 = r4
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            return r35
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.model.SubscriptionPlanModelMapper.apply(com.talabat.feature.subscriptions.data.remote.model.SubscriptionPlanResponseModel):com.talabat.feature.subscriptions.domain.model.SubscriptionPlan");
    }
}
