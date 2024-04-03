package com.talabat.offering.data;

import JsonModels.PolygonEvents;
import datamodels.Restaurant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ShopClickedEvent;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fHÆ\u0003J\t\u0010)\u001a\u00020\u0011HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J¨\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\u00132\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u0012\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006:"}, d2 = {"Lcom/talabat/offering/data/RestaurantShopClickedEvent;", "", "selectedRestaurant", "Ldatamodels/Restaurant;", "clickOrigin", "", "searchString", "channelIndex", "channel", "screenType", "searchTerm", "polygonEvent", "LJsonModels/PolygonEvents;", "listViewType", "swimlanesGa", "Ljava/util/HashMap;", "eventOriginSource", "Ltracking/ShopClickedEvent$EventOriginSource;", "isGemRestaurant", "", "(Ldatamodels/Restaurant;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LJsonModels/PolygonEvents;Ljava/lang/String;Ljava/util/HashMap;Ltracking/ShopClickedEvent$EventOriginSource;Ljava/lang/Boolean;)V", "getChannel", "()Ljava/lang/String;", "getChannelIndex", "getClickOrigin", "getEventOriginSource", "()Ltracking/ShopClickedEvent$EventOriginSource;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getListViewType", "getPolygonEvent", "()LJsonModels/PolygonEvents;", "getScreenType", "getSearchString", "getSearchTerm", "getSelectedRestaurant", "()Ldatamodels/Restaurant;", "getSwimlanesGa", "()Ljava/util/HashMap;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ldatamodels/Restaurant;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LJsonModels/PolygonEvents;Ljava/lang/String;Ljava/util/HashMap;Ltracking/ShopClickedEvent$EventOriginSource;Ljava/lang/Boolean;)Lcom/talabat/offering/data/RestaurantShopClickedEvent;", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RestaurantShopClickedEvent {
    @Nullable
    private final String channel;
    @Nullable
    private final String channelIndex;
    @Nullable
    private final String clickOrigin;
    @NotNull
    private final ShopClickedEvent.EventOriginSource eventOriginSource;
    @Nullable
    private final Boolean isGemRestaurant;
    @Nullable
    private final String listViewType;
    @Nullable
    private final PolygonEvents polygonEvent;
    @Nullable
    private final String screenType;
    @Nullable
    private final String searchString;
    @Nullable
    private final String searchTerm;
    @Nullable
    private final Restaurant selectedRestaurant;
    @Nullable
    private final HashMap<String, String> swimlanesGa;

    public RestaurantShopClickedEvent(@Nullable Restaurant restaurant, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable PolygonEvents polygonEvents, @Nullable String str7, @Nullable HashMap<String, String> hashMap, @NotNull ShopClickedEvent.EventOriginSource eventOriginSource2, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(eventOriginSource2, "eventOriginSource");
        this.selectedRestaurant = restaurant;
        this.clickOrigin = str;
        this.searchString = str2;
        this.channelIndex = str3;
        this.channel = str4;
        this.screenType = str5;
        this.searchTerm = str6;
        this.polygonEvent = polygonEvents;
        this.listViewType = str7;
        this.swimlanesGa = hashMap;
        this.eventOriginSource = eventOriginSource2;
        this.isGemRestaurant = bool;
    }

    public static /* synthetic */ RestaurantShopClickedEvent copy$default(RestaurantShopClickedEvent restaurantShopClickedEvent, Restaurant restaurant, String str, String str2, String str3, String str4, String str5, String str6, PolygonEvents polygonEvents, String str7, HashMap hashMap, ShopClickedEvent.EventOriginSource eventOriginSource2, Boolean bool, int i11, Object obj) {
        RestaurantShopClickedEvent restaurantShopClickedEvent2 = restaurantShopClickedEvent;
        int i12 = i11;
        return restaurantShopClickedEvent.copy((i12 & 1) != 0 ? restaurantShopClickedEvent2.selectedRestaurant : restaurant, (i12 & 2) != 0 ? restaurantShopClickedEvent2.clickOrigin : str, (i12 & 4) != 0 ? restaurantShopClickedEvent2.searchString : str2, (i12 & 8) != 0 ? restaurantShopClickedEvent2.channelIndex : str3, (i12 & 16) != 0 ? restaurantShopClickedEvent2.channel : str4, (i12 & 32) != 0 ? restaurantShopClickedEvent2.screenType : str5, (i12 & 64) != 0 ? restaurantShopClickedEvent2.searchTerm : str6, (i12 & 128) != 0 ? restaurantShopClickedEvent2.polygonEvent : polygonEvents, (i12 & 256) != 0 ? restaurantShopClickedEvent2.listViewType : str7, (i12 & 512) != 0 ? restaurantShopClickedEvent2.swimlanesGa : hashMap, (i12 & 1024) != 0 ? restaurantShopClickedEvent2.eventOriginSource : eventOriginSource2, (i12 & 2048) != 0 ? restaurantShopClickedEvent2.isGemRestaurant : bool);
    }

    @Nullable
    public final Restaurant component1() {
        return this.selectedRestaurant;
    }

    @Nullable
    public final HashMap<String, String> component10() {
        return this.swimlanesGa;
    }

    @NotNull
    public final ShopClickedEvent.EventOriginSource component11() {
        return this.eventOriginSource;
    }

    @Nullable
    public final Boolean component12() {
        return this.isGemRestaurant;
    }

    @Nullable
    public final String component2() {
        return this.clickOrigin;
    }

    @Nullable
    public final String component3() {
        return this.searchString;
    }

    @Nullable
    public final String component4() {
        return this.channelIndex;
    }

    @Nullable
    public final String component5() {
        return this.channel;
    }

    @Nullable
    public final String component6() {
        return this.screenType;
    }

    @Nullable
    public final String component7() {
        return this.searchTerm;
    }

    @Nullable
    public final PolygonEvents component8() {
        return this.polygonEvent;
    }

    @Nullable
    public final String component9() {
        return this.listViewType;
    }

    @NotNull
    public final RestaurantShopClickedEvent copy(@Nullable Restaurant restaurant, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable PolygonEvents polygonEvents, @Nullable String str7, @Nullable HashMap<String, String> hashMap, @NotNull ShopClickedEvent.EventOriginSource eventOriginSource2, @Nullable Boolean bool) {
        ShopClickedEvent.EventOriginSource eventOriginSource3 = eventOriginSource2;
        Intrinsics.checkNotNullParameter(eventOriginSource3, "eventOriginSource");
        return new RestaurantShopClickedEvent(restaurant, str, str2, str3, str4, str5, str6, polygonEvents, str7, hashMap, eventOriginSource3, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RestaurantShopClickedEvent)) {
            return false;
        }
        RestaurantShopClickedEvent restaurantShopClickedEvent = (RestaurantShopClickedEvent) obj;
        return Intrinsics.areEqual((Object) this.selectedRestaurant, (Object) restaurantShopClickedEvent.selectedRestaurant) && Intrinsics.areEqual((Object) this.clickOrigin, (Object) restaurantShopClickedEvent.clickOrigin) && Intrinsics.areEqual((Object) this.searchString, (Object) restaurantShopClickedEvent.searchString) && Intrinsics.areEqual((Object) this.channelIndex, (Object) restaurantShopClickedEvent.channelIndex) && Intrinsics.areEqual((Object) this.channel, (Object) restaurantShopClickedEvent.channel) && Intrinsics.areEqual((Object) this.screenType, (Object) restaurantShopClickedEvent.screenType) && Intrinsics.areEqual((Object) this.searchTerm, (Object) restaurantShopClickedEvent.searchTerm) && Intrinsics.areEqual((Object) this.polygonEvent, (Object) restaurantShopClickedEvent.polygonEvent) && Intrinsics.areEqual((Object) this.listViewType, (Object) restaurantShopClickedEvent.listViewType) && Intrinsics.areEqual((Object) this.swimlanesGa, (Object) restaurantShopClickedEvent.swimlanesGa) && Intrinsics.areEqual((Object) this.eventOriginSource, (Object) restaurantShopClickedEvent.eventOriginSource) && Intrinsics.areEqual((Object) this.isGemRestaurant, (Object) restaurantShopClickedEvent.isGemRestaurant);
    }

    @Nullable
    public final String getChannel() {
        return this.channel;
    }

    @Nullable
    public final String getChannelIndex() {
        return this.channelIndex;
    }

    @Nullable
    public final String getClickOrigin() {
        return this.clickOrigin;
    }

    @NotNull
    public final ShopClickedEvent.EventOriginSource getEventOriginSource() {
        return this.eventOriginSource;
    }

    @Nullable
    public final String getListViewType() {
        return this.listViewType;
    }

    @Nullable
    public final PolygonEvents getPolygonEvent() {
        return this.polygonEvent;
    }

    @Nullable
    public final String getScreenType() {
        return this.screenType;
    }

    @Nullable
    public final String getSearchString() {
        return this.searchString;
    }

    @Nullable
    public final String getSearchTerm() {
        return this.searchTerm;
    }

    @Nullable
    public final Restaurant getSelectedRestaurant() {
        return this.selectedRestaurant;
    }

    @Nullable
    public final HashMap<String, String> getSwimlanesGa() {
        return this.swimlanesGa;
    }

    public int hashCode() {
        Restaurant restaurant = this.selectedRestaurant;
        int i11 = 0;
        int hashCode = (restaurant == null ? 0 : restaurant.hashCode()) * 31;
        String str = this.clickOrigin;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.searchString;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.channelIndex;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.channel;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.screenType;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.searchTerm;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        PolygonEvents polygonEvents = this.polygonEvent;
        int hashCode8 = (hashCode7 + (polygonEvents == null ? 0 : polygonEvents.hashCode())) * 31;
        String str7 = this.listViewType;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        HashMap<String, String> hashMap = this.swimlanesGa;
        int hashCode10 = (((hashCode9 + (hashMap == null ? 0 : hashMap.hashCode())) * 31) + this.eventOriginSource.hashCode()) * 31;
        Boolean bool = this.isGemRestaurant;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode10 + i11;
    }

    @Nullable
    public final Boolean isGemRestaurant() {
        return this.isGemRestaurant;
    }

    @NotNull
    public String toString() {
        Restaurant restaurant = this.selectedRestaurant;
        String str = this.clickOrigin;
        String str2 = this.searchString;
        String str3 = this.channelIndex;
        String str4 = this.channel;
        String str5 = this.screenType;
        String str6 = this.searchTerm;
        PolygonEvents polygonEvents = this.polygonEvent;
        String str7 = this.listViewType;
        HashMap<String, String> hashMap = this.swimlanesGa;
        ShopClickedEvent.EventOriginSource eventOriginSource2 = this.eventOriginSource;
        Boolean bool = this.isGemRestaurant;
        return "RestaurantShopClickedEvent(selectedRestaurant=" + restaurant + ", clickOrigin=" + str + ", searchString=" + str2 + ", channelIndex=" + str3 + ", channel=" + str4 + ", screenType=" + str5 + ", searchTerm=" + str6 + ", polygonEvent=" + polygonEvents + ", listViewType=" + str7 + ", swimlanesGa=" + hashMap + ", eventOriginSource=" + eventOriginSource2 + ", isGemRestaurant=" + bool + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RestaurantShopClickedEvent(datamodels.Restaurant r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, JsonModels.PolygonEvents r24, java.lang.String r25, java.util.HashMap r26, tracking.ShopClickedEvent.EventOriginSource r27, java.lang.Boolean r28, int r29, kotlin.jvm.internal.DefaultConstructorMarker r30) {
        /*
            r16 = this;
            r0 = r29
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r4 = r2
            goto L_0x000b
        L_0x0009:
            r4 = r17
        L_0x000b:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0011
            r5 = r2
            goto L_0x0013
        L_0x0011:
            r5 = r18
        L_0x0013:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0019
            r6 = r2
            goto L_0x001b
        L_0x0019:
            r6 = r19
        L_0x001b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0021
            r7 = r2
            goto L_0x0023
        L_0x0021:
            r7 = r20
        L_0x0023:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0029
            r8 = r2
            goto L_0x002b
        L_0x0029:
            r8 = r21
        L_0x002b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0031
            r9 = r2
            goto L_0x0033
        L_0x0031:
            r9 = r22
        L_0x0033:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0039
            r10 = r2
            goto L_0x003b
        L_0x0039:
            r10 = r23
        L_0x003b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0041
            r11 = r2
            goto L_0x0043
        L_0x0041:
            r11 = r24
        L_0x0043:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0049
            r12 = r2
            goto L_0x004b
        L_0x0049:
            r12 = r25
        L_0x004b:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0051
            r13 = r2
            goto L_0x0053
        L_0x0051:
            r13 = r26
        L_0x0053:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0059
            r15 = r2
            goto L_0x005b
        L_0x0059:
            r15 = r28
        L_0x005b:
            r3 = r16
            r14 = r27
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.offering.data.RestaurantShopClickedEvent.<init>(datamodels.Restaurant, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, JsonModels.PolygonEvents, java.lang.String, java.util.HashMap, tracking.ShopClickedEvent$EventOriginSource, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
