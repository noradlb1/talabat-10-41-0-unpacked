package com.talabat.offering.domain.entities;

import JsonModels.PolygonEvents;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bk\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0012HÆ\u0003Jo\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\tHÖ\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00063"}, d2 = {"Lcom/talabat/offering/domain/entities/OfferCollection;", "", "headerText", "Lcom/talabat/offering/domain/entities/HeaderText;", "callToAction", "Lcom/talabat/offering/domain/entities/CallToAction;", "header", "Lcom/talabat/offering/domain/entities/Header;", "productId", "", "restaurants", "", "Ldatamodels/Restaurant;", "background", "Lcom/talabat/offering/domain/entities/Background;", "polygonEvents", "LJsonModels/PolygonEvents;", "filter", "Ldatamodels/QuickFilter;", "(Lcom/talabat/offering/domain/entities/HeaderText;Lcom/talabat/offering/domain/entities/CallToAction;Lcom/talabat/offering/domain/entities/Header;Ljava/lang/String;Ljava/util/List;Lcom/talabat/offering/domain/entities/Background;LJsonModels/PolygonEvents;Ldatamodels/QuickFilter;)V", "getBackground", "()Lcom/talabat/offering/domain/entities/Background;", "getCallToAction", "()Lcom/talabat/offering/domain/entities/CallToAction;", "getFilter", "()Ldatamodels/QuickFilter;", "getHeader", "()Lcom/talabat/offering/domain/entities/Header;", "getHeaderText", "()Lcom/talabat/offering/domain/entities/HeaderText;", "getPolygonEvents", "()LJsonModels/PolygonEvents;", "getProductId", "()Ljava/lang/String;", "getRestaurants", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OfferCollection {
    @Nullable
    private final Background background;
    @Nullable
    private final CallToAction callToAction;
    @Nullable
    private final QuickFilter filter;
    @Nullable
    private final Header header;
    @Nullable
    private final HeaderText headerText;
    @Nullable
    private final PolygonEvents polygonEvents;
    @Nullable
    private final String productId;
    @Nullable
    private final List<Restaurant> restaurants;

    public OfferCollection() {
        this((HeaderText) null, (CallToAction) null, (Header) null, (String) null, (List) null, (Background) null, (PolygonEvents) null, (QuickFilter) null, 255, (DefaultConstructorMarker) null);
    }

    public OfferCollection(@Nullable HeaderText headerText2, @Nullable CallToAction callToAction2, @Nullable Header header2, @Nullable String str, @Nullable List<? extends Restaurant> list, @Nullable Background background2, @Nullable PolygonEvents polygonEvents2, @Nullable QuickFilter quickFilter) {
        this.headerText = headerText2;
        this.callToAction = callToAction2;
        this.header = header2;
        this.productId = str;
        this.restaurants = list;
        this.background = background2;
        this.polygonEvents = polygonEvents2;
        this.filter = quickFilter;
    }

    public static /* synthetic */ OfferCollection copy$default(OfferCollection offerCollection, HeaderText headerText2, CallToAction callToAction2, Header header2, String str, List list, Background background2, PolygonEvents polygonEvents2, QuickFilter quickFilter, int i11, Object obj) {
        OfferCollection offerCollection2 = offerCollection;
        int i12 = i11;
        return offerCollection.copy((i12 & 1) != 0 ? offerCollection2.headerText : headerText2, (i12 & 2) != 0 ? offerCollection2.callToAction : callToAction2, (i12 & 4) != 0 ? offerCollection2.header : header2, (i12 & 8) != 0 ? offerCollection2.productId : str, (i12 & 16) != 0 ? offerCollection2.restaurants : list, (i12 & 32) != 0 ? offerCollection2.background : background2, (i12 & 64) != 0 ? offerCollection2.polygonEvents : polygonEvents2, (i12 & 128) != 0 ? offerCollection2.filter : quickFilter);
    }

    @Nullable
    public final HeaderText component1() {
        return this.headerText;
    }

    @Nullable
    public final CallToAction component2() {
        return this.callToAction;
    }

    @Nullable
    public final Header component3() {
        return this.header;
    }

    @Nullable
    public final String component4() {
        return this.productId;
    }

    @Nullable
    public final List<Restaurant> component5() {
        return this.restaurants;
    }

    @Nullable
    public final Background component6() {
        return this.background;
    }

    @Nullable
    public final PolygonEvents component7() {
        return this.polygonEvents;
    }

    @Nullable
    public final QuickFilter component8() {
        return this.filter;
    }

    @NotNull
    public final OfferCollection copy(@Nullable HeaderText headerText2, @Nullable CallToAction callToAction2, @Nullable Header header2, @Nullable String str, @Nullable List<? extends Restaurant> list, @Nullable Background background2, @Nullable PolygonEvents polygonEvents2, @Nullable QuickFilter quickFilter) {
        return new OfferCollection(headerText2, callToAction2, header2, str, list, background2, polygonEvents2, quickFilter);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferCollection)) {
            return false;
        }
        OfferCollection offerCollection = (OfferCollection) obj;
        return Intrinsics.areEqual((Object) this.headerText, (Object) offerCollection.headerText) && Intrinsics.areEqual((Object) this.callToAction, (Object) offerCollection.callToAction) && Intrinsics.areEqual((Object) this.header, (Object) offerCollection.header) && Intrinsics.areEqual((Object) this.productId, (Object) offerCollection.productId) && Intrinsics.areEqual((Object) this.restaurants, (Object) offerCollection.restaurants) && Intrinsics.areEqual((Object) this.background, (Object) offerCollection.background) && Intrinsics.areEqual((Object) this.polygonEvents, (Object) offerCollection.polygonEvents) && Intrinsics.areEqual((Object) this.filter, (Object) offerCollection.filter);
    }

    @Nullable
    public final Background getBackground() {
        return this.background;
    }

    @Nullable
    public final CallToAction getCallToAction() {
        return this.callToAction;
    }

    @Nullable
    public final QuickFilter getFilter() {
        return this.filter;
    }

    @Nullable
    public final Header getHeader() {
        return this.header;
    }

    @Nullable
    public final HeaderText getHeaderText() {
        return this.headerText;
    }

    @Nullable
    public final PolygonEvents getPolygonEvents() {
        return this.polygonEvents;
    }

    @Nullable
    public final String getProductId() {
        return this.productId;
    }

    @Nullable
    public final List<Restaurant> getRestaurants() {
        return this.restaurants;
    }

    public int hashCode() {
        HeaderText headerText2 = this.headerText;
        int i11 = 0;
        int hashCode = (headerText2 == null ? 0 : headerText2.hashCode()) * 31;
        CallToAction callToAction2 = this.callToAction;
        int hashCode2 = (hashCode + (callToAction2 == null ? 0 : callToAction2.hashCode())) * 31;
        Header header2 = this.header;
        int hashCode3 = (hashCode2 + (header2 == null ? 0 : header2.hashCode())) * 31;
        String str = this.productId;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        List<Restaurant> list = this.restaurants;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        Background background2 = this.background;
        int hashCode6 = (hashCode5 + (background2 == null ? 0 : background2.hashCode())) * 31;
        PolygonEvents polygonEvents2 = this.polygonEvents;
        int hashCode7 = (hashCode6 + (polygonEvents2 == null ? 0 : polygonEvents2.hashCode())) * 31;
        QuickFilter quickFilter = this.filter;
        if (quickFilter != null) {
            i11 = quickFilter.hashCode();
        }
        return hashCode7 + i11;
    }

    @NotNull
    public String toString() {
        HeaderText headerText2 = this.headerText;
        CallToAction callToAction2 = this.callToAction;
        Header header2 = this.header;
        String str = this.productId;
        List<Restaurant> list = this.restaurants;
        Background background2 = this.background;
        PolygonEvents polygonEvents2 = this.polygonEvents;
        QuickFilter quickFilter = this.filter;
        return "OfferCollection(headerText=" + headerText2 + ", callToAction=" + callToAction2 + ", header=" + header2 + ", productId=" + str + ", restaurants=" + list + ", background=" + background2 + ", polygonEvents=" + polygonEvents2 + ", filter=" + quickFilter + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OfferCollection(com.talabat.offering.domain.entities.HeaderText r10, com.talabat.offering.domain.entities.CallToAction r11, com.talabat.offering.domain.entities.Header r12, java.lang.String r13, java.util.List r14, com.talabat.offering.domain.entities.Background r15, JsonModels.PolygonEvents r16, datamodels.QuickFilter r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.offering.domain.entities.OfferCollection.<init>(com.talabat.offering.domain.entities.HeaderText, com.talabat.offering.domain.entities.CallToAction, com.talabat.offering.domain.entities.Header, java.lang.String, java.util.List, com.talabat.offering.domain.entities.Background, JsonModels.PolygonEvents, datamodels.QuickFilter, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
