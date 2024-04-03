package com.talabat.sdsquad.domain.inlineds;

import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.InlineAdDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.SwimlaneDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorCellType;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayWrapper;
import io.reactivex.Flowable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002J\u001e\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u000f"}, d2 = {"Lcom/talabat/sdsquad/domain/inlineds/InsertInlineAdUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/inlineds/InsertInlineAdUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayWrapper;", "", "link", "key", "getStringValue", "requestValues", "a", "<init>", "()V", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0})
public final class InsertInlineAdUseCase extends UseCase<RequestValues, Flowable<List<? extends VendorDisplayWrapper>>> {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B-\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/talabat/sdsquad/domain/inlineds/InsertInlineAdUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "vendorsList", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayWrapper;", "link", "", "image", "position", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;I)V", "getImage", "()Ljava/lang/String;", "getLink", "getPosition", "()I", "getVendorsList", "()Ljava/util/List;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RequestValues implements UseCase.RequestValues {
        @NotNull
        private final String image;
        @NotNull
        private final String link;
        private final int position;
        @Nullable
        private final List<VendorDisplayWrapper> vendorsList;

        public RequestValues(@Nullable List<VendorDisplayWrapper> list, @NotNull String str, @NotNull String str2, int i11) {
            Intrinsics.checkNotNullParameter(str, "link");
            Intrinsics.checkNotNullParameter(str2, "image");
            this.vendorsList = list;
            this.link = str;
            this.image = str2;
            this.position = i11;
        }

        @NotNull
        public final String getImage() {
            return this.image;
        }

        @NotNull
        public final String getLink() {
            return this.link;
        }

        public final int getPosition() {
            return this.position;
        }

        @Nullable
        public final List<VendorDisplayWrapper> getVendorsList() {
            return this.vendorsList;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:21|(9:23|(2:24|(3:26|(2:28|58)(2:29|57)|(2:56|31))(1:55))|33|34|35|36|37|53|38)(0)|32|33|34|35|36|37|53|38) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00bb */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getStringValue(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            r1 = 1
            r2 = 0
            if (r14 == 0) goto L_0x0054
            kotlin.text.Regex r3 = new kotlin.text.Regex
            java.lang.String r4 = "&"
            r3.<init>((java.lang.String) r4)
            java.util.List r13 = r3.split(r13, r2)
            boolean r3 = r13.isEmpty()
            if (r3 != 0) goto L_0x0042
            int r3 = r13.size()
            java.util.ListIterator r3 = r13.listIterator(r3)
        L_0x001f:
            boolean r4 = r3.hasPrevious()
            if (r4 == 0) goto L_0x0042
            java.lang.Object r4 = r3.previous()
            java.lang.String r4 = (java.lang.String) r4
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0033
            r4 = r1
            goto L_0x0034
        L_0x0033:
            r4 = r2
        L_0x0034:
            if (r4 != 0) goto L_0x001f
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            int r3 = r3.nextIndex()
            int r3 = r3 + r1
            java.util.List r13 = kotlin.collections.CollectionsKt___CollectionsKt.take(r13, r3)
            goto L_0x0046
        L_0x0042:
            java.util.List r13 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0046:
            java.util.Collection r13 = (java.util.Collection) r13
            java.lang.String[] r3 = new java.lang.String[r2]
            java.lang.Object[] r13 = r13.toArray(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r0)
            java.lang.String[] r13 = (java.lang.String[]) r13
            goto L_0x0055
        L_0x0054:
            r13 = 0
        L_0x0055:
            java.lang.String r3 = ""
            if (r13 == 0) goto L_0x00d6
            int r4 = r13.length     // Catch:{ Exception -> 0x00d2 }
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch:{ Exception -> 0x00d2 }
            int r6 = r13.length     // Catch:{ Exception -> 0x00d2 }
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ Exception -> 0x00d2 }
            int r7 = r13.length     // Catch:{ Exception -> 0x00d2 }
            r8 = r2
        L_0x0061:
            if (r8 >= r7) goto L_0x00c0
            r9 = r13[r8]     // Catch:{ Exception -> 0x00d2 }
            kotlin.text.Regex r10 = new kotlin.text.Regex     // Catch:{ Exception -> 0x00d2 }
            java.lang.String r11 = "="
            r10.<init>((java.lang.String) r11)     // Catch:{ Exception -> 0x00d2 }
            java.util.List r9 = r10.split(r9, r2)     // Catch:{ Exception -> 0x00d2 }
            boolean r10 = r9.isEmpty()     // Catch:{ Exception -> 0x00d2 }
            if (r10 != 0) goto L_0x00a1
            int r10 = r9.size()     // Catch:{ Exception -> 0x00d2 }
            java.util.ListIterator r10 = r9.listIterator(r10)     // Catch:{ Exception -> 0x00d2 }
        L_0x007e:
            boolean r11 = r10.hasPrevious()     // Catch:{ Exception -> 0x00d2 }
            if (r11 == 0) goto L_0x00a1
            java.lang.Object r11 = r10.previous()     // Catch:{ Exception -> 0x00d2 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x00d2 }
            int r11 = r11.length()     // Catch:{ Exception -> 0x00d2 }
            if (r11 != 0) goto L_0x0092
            r11 = r1
            goto L_0x0093
        L_0x0092:
            r11 = r2
        L_0x0093:
            if (r11 != 0) goto L_0x007e
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch:{ Exception -> 0x00d2 }
            int r10 = r10.nextIndex()     // Catch:{ Exception -> 0x00d2 }
            int r10 = r10 + r1
            java.util.List r9 = kotlin.collections.CollectionsKt___CollectionsKt.take(r9, r10)     // Catch:{ Exception -> 0x00d2 }
            goto L_0x00a5
        L_0x00a1:
            java.util.List r9 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()     // Catch:{ Exception -> 0x00d2 }
        L_0x00a5:
            java.util.Collection r9 = (java.util.Collection) r9     // Catch:{ Exception -> 0x00d2 }
            java.lang.String[] r10 = new java.lang.String[r2]     // Catch:{ Exception -> 0x00d2 }
            java.lang.Object[] r9 = r9.toArray(r10)     // Catch:{ Exception -> 0x00d2 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r0)     // Catch:{ Exception -> 0x00d2 }
            java.lang.String[] r9 = (java.lang.String[]) r9     // Catch:{ Exception -> 0x00d2 }
            r10 = r9[r2]     // Catch:{ Exception -> 0x00d2 }
            r5[r8] = r10     // Catch:{ Exception -> 0x00d2 }
            r9 = r9[r1]     // Catch:{ Exception -> 0x00bb }
            r6[r8] = r9     // Catch:{ Exception -> 0x00bb }
            goto L_0x00bd
        L_0x00bb:
            r6[r8] = r3     // Catch:{ Exception -> 0x00d2 }
        L_0x00bd:
            int r8 = r8 + 1
            goto L_0x0061
        L_0x00c0:
            r13 = r3
        L_0x00c1:
            if (r2 >= r4) goto L_0x00d0
            r0 = r5[r2]     // Catch:{ Exception -> 0x00d2 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r14)     // Catch:{ Exception -> 0x00d2 }
            if (r0 == 0) goto L_0x00cd
            r13 = r6[r2]     // Catch:{ Exception -> 0x00d2 }
        L_0x00cd:
            int r2 = r2 + 1
            goto L_0x00c1
        L_0x00d0:
            r3 = r13
            goto L_0x00d6
        L_0x00d2:
            r13 = move-exception
            com.talabat.talabatcore.logger.LogManager.logException(r13)
        L_0x00d6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.sdsquad.domain.inlineds.InsertInlineAdUseCase.getStringValue(java.lang.String, java.lang.String):java.lang.String");
    }

    @NotNull
    /* renamed from: a */
    public Flowable<List<VendorDisplayWrapper>> executeUseCase(@Nullable RequestValues requestValues) {
        Integer num;
        Intrinsics.checkNotNull(requestValues);
        if (requestValues.getVendorsList() != null) {
            String stringValue = getStringValue(requestValues.getLink(), "v");
            VendorDisplayModel vendorDisplayModel = null;
            if (stringValue != null) {
                num = StringsKt__StringNumberConversionsKt.toIntOrNull(stringValue);
            } else {
                num = null;
            }
            if (num != null) {
                num.intValue();
                List<VendorDisplayWrapper> vendorsList = requestValues.getVendorsList();
                Intrinsics.checkNotNull(vendorsList);
                Iterator<VendorDisplayWrapper> it = vendorsList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    VendorDisplayWrapper next = it.next();
                    if (next.getVendorDisplayModel() != null) {
                        VendorDisplayModel vendorDisplayModel2 = next.getVendorDisplayModel();
                        Intrinsics.checkNotNull(vendorDisplayModel2);
                        if (vendorDisplayModel2.getId() == num.intValue()) {
                            vendorDisplayModel = next.getVendorDisplayModel();
                            break;
                        }
                    }
                }
                if (vendorDisplayModel != null) {
                    InlineAdDisplayModel inlineAdDisplayModel = new InlineAdDisplayModel(requestValues.getLink(), requestValues.getImage(), requestValues.getPosition(), vendorDisplayModel.getVendorLogo(), vendorDisplayModel.getVendorName(), vendorDisplayModel.getCuisines(), vendorDisplayModel.getBaseUrl());
                    List mutableList = CollectionsKt___CollectionsKt.toMutableList(requestValues.getVendorsList());
                    VendorDisplayWrapper vendorDisplayWrapper = new VendorDisplayWrapper(VendorCellType.InlineAd, (VendorDisplayModel) null, (List) null, (SwimlaneDisplayModel) null, inlineAdDisplayModel, 14, (DefaultConstructorMarker) null);
                    Iterator it2 = mutableList.iterator();
                    int i11 = 0;
                    while (it2.hasNext() && ((VendorDisplayWrapper) it2.next()).getVendorDisplayModel() == null) {
                        i11++;
                    }
                    mutableList.add(inlineAdDisplayModel.getAdsPosition() + i11, vendorDisplayWrapper);
                    Flowable<List<VendorDisplayWrapper>> just = Flowable.just(mutableList);
                    Intrinsics.checkNotNullExpressionValue(just, "just(vendorList)");
                    return just;
                }
            }
        }
        Flowable<List<VendorDisplayWrapper>> just2 = Flowable.just(requestValues.getVendorsList());
        Intrinsics.checkNotNullExpressionValue(just2, "just(requestValues.vendorsList)");
        return just2;
    }
}
