package com.talabat.offering.data;

import JsonModels.PolygonEvents;
import com.talabat.feature.pickup.data.events.ConstantsKt;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ShopClickedEvent;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b4\b\b\u0018\u00002\u00020\u0001Bµ\u0001\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u001bJ\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u00107\u001a\u00020\u0006HÆ\u0003J\u0017\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015HÆ\u0003J\t\u00109\u001a\u00020\u0017HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010<\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u000bHÆ\u0003J\t\u0010B\u001a\u00020\rHÆ\u0003J\t\u0010C\u001a\u00020\rHÆ\u0003J\t\u0010D\u001a\u00020\u000bHÆ\u0003Jà\u0001\u0010E\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00062\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020\u000b2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020\rHÖ\u0001J\t\u0010J\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\"R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\"R\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u001f\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u00102\u001a\u0004\b3\u00101¨\u0006K"}, d2 = {"Lcom/talabat/offering/data/RestaurantListUpdatedEvent;", "", "restaurants", "Ljava/util/ArrayList;", "Ldatamodels/Restaurant;", "shopListType", "", "channelIndex", "channel", "shopListTrigger", "isRecomendRestaurantsExist", "", "shopRecommendedQuantity", "", "shopOpenNumber", "isCollection", "shopIds", "polygonEvent", "LJsonModels/PolygonEvents;", "listViewType", "swimlanesGa", "Ljava/util/HashMap;", "eventOriginSource", "Ltracking/ShopClickedEvent$EventOriginSource;", "eventOrigin", "telcoVerified", "telcoExpired", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIIZLjava/lang/String;LJsonModels/PolygonEvents;Ljava/lang/String;Ljava/util/HashMap;Ltracking/ShopClickedEvent$EventOriginSource;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getChannel", "()Ljava/lang/String;", "getChannelIndex", "getEventOrigin", "getEventOriginSource", "()Ltracking/ShopClickedEvent$EventOriginSource;", "()Z", "getListViewType", "getPolygonEvent", "()LJsonModels/PolygonEvents;", "getRestaurants", "()Ljava/util/ArrayList;", "getShopIds", "getShopListTrigger", "getShopListType", "getShopOpenNumber", "()I", "getShopRecommendedQuantity", "getSwimlanesGa", "()Ljava/util/HashMap;", "getTelcoExpired", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTelcoVerified", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIIZLjava/lang/String;LJsonModels/PolygonEvents;Ljava/lang/String;Ljava/util/HashMap;Ltracking/ShopClickedEvent$EventOriginSource;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/talabat/offering/data/RestaurantListUpdatedEvent;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RestaurantListUpdatedEvent {
    @Nullable
    private final String channel;
    @Nullable
    private final String channelIndex;
    @Nullable
    private final String eventOrigin;
    @NotNull
    private final ShopClickedEvent.EventOriginSource eventOriginSource;
    private final boolean isCollection;
    private final boolean isRecomendRestaurantsExist;
    @NotNull
    private final String listViewType;
    @Nullable
    private final PolygonEvents polygonEvent;
    @Nullable
    private final ArrayList<Restaurant> restaurants;
    @Nullable
    private final String shopIds;
    @Nullable
    private final String shopListTrigger;
    @Nullable
    private final String shopListType;
    private final int shopOpenNumber;
    private final int shopRecommendedQuantity;
    @Nullable
    private final HashMap<String, String> swimlanesGa;
    @Nullable
    private final Boolean telcoExpired;
    @Nullable
    private final Boolean telcoVerified;

    public RestaurantListUpdatedEvent(@Nullable ArrayList<Restaurant> arrayList, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z11, int i11, int i12, boolean z12, @Nullable String str5, @Nullable PolygonEvents polygonEvents, @NotNull String str6, @Nullable HashMap<String, String> hashMap, @NotNull ShopClickedEvent.EventOriginSource eventOriginSource2, @Nullable String str7, @Nullable Boolean bool, @Nullable Boolean bool2) {
        String str8 = str6;
        ShopClickedEvent.EventOriginSource eventOriginSource3 = eventOriginSource2;
        Intrinsics.checkNotNullParameter(str8, ConstantsKt.LOADED_LIST_VIEW_TYPE);
        Intrinsics.checkNotNullParameter(eventOriginSource3, "eventOriginSource");
        this.restaurants = arrayList;
        this.shopListType = str;
        this.channelIndex = str2;
        this.channel = str3;
        this.shopListTrigger = str4;
        this.isRecomendRestaurantsExist = z11;
        this.shopRecommendedQuantity = i11;
        this.shopOpenNumber = i12;
        this.isCollection = z12;
        this.shopIds = str5;
        this.polygonEvent = polygonEvents;
        this.listViewType = str8;
        this.swimlanesGa = hashMap;
        this.eventOriginSource = eventOriginSource3;
        this.eventOrigin = str7;
        this.telcoVerified = bool;
        this.telcoExpired = bool2;
    }

    public static /* synthetic */ RestaurantListUpdatedEvent copy$default(RestaurantListUpdatedEvent restaurantListUpdatedEvent, ArrayList arrayList, String str, String str2, String str3, String str4, boolean z11, int i11, int i12, boolean z12, String str5, PolygonEvents polygonEvents, String str6, HashMap hashMap, ShopClickedEvent.EventOriginSource eventOriginSource2, String str7, Boolean bool, Boolean bool2, int i13, Object obj) {
        RestaurantListUpdatedEvent restaurantListUpdatedEvent2 = restaurantListUpdatedEvent;
        int i14 = i13;
        return restaurantListUpdatedEvent.copy((i14 & 1) != 0 ? restaurantListUpdatedEvent2.restaurants : arrayList, (i14 & 2) != 0 ? restaurantListUpdatedEvent2.shopListType : str, (i14 & 4) != 0 ? restaurantListUpdatedEvent2.channelIndex : str2, (i14 & 8) != 0 ? restaurantListUpdatedEvent2.channel : str3, (i14 & 16) != 0 ? restaurantListUpdatedEvent2.shopListTrigger : str4, (i14 & 32) != 0 ? restaurantListUpdatedEvent2.isRecomendRestaurantsExist : z11, (i14 & 64) != 0 ? restaurantListUpdatedEvent2.shopRecommendedQuantity : i11, (i14 & 128) != 0 ? restaurantListUpdatedEvent2.shopOpenNumber : i12, (i14 & 256) != 0 ? restaurantListUpdatedEvent2.isCollection : z12, (i14 & 512) != 0 ? restaurantListUpdatedEvent2.shopIds : str5, (i14 & 1024) != 0 ? restaurantListUpdatedEvent2.polygonEvent : polygonEvents, (i14 & 2048) != 0 ? restaurantListUpdatedEvent2.listViewType : str6, (i14 & 4096) != 0 ? restaurantListUpdatedEvent2.swimlanesGa : hashMap, (i14 & 8192) != 0 ? restaurantListUpdatedEvent2.eventOriginSource : eventOriginSource2, (i14 & 16384) != 0 ? restaurantListUpdatedEvent2.eventOrigin : str7, (i14 & 32768) != 0 ? restaurantListUpdatedEvent2.telcoVerified : bool, (i14 & 65536) != 0 ? restaurantListUpdatedEvent2.telcoExpired : bool2);
    }

    @Nullable
    public final ArrayList<Restaurant> component1() {
        return this.restaurants;
    }

    @Nullable
    public final String component10() {
        return this.shopIds;
    }

    @Nullable
    public final PolygonEvents component11() {
        return this.polygonEvent;
    }

    @NotNull
    public final String component12() {
        return this.listViewType;
    }

    @Nullable
    public final HashMap<String, String> component13() {
        return this.swimlanesGa;
    }

    @NotNull
    public final ShopClickedEvent.EventOriginSource component14() {
        return this.eventOriginSource;
    }

    @Nullable
    public final String component15() {
        return this.eventOrigin;
    }

    @Nullable
    public final Boolean component16() {
        return this.telcoVerified;
    }

    @Nullable
    public final Boolean component17() {
        return this.telcoExpired;
    }

    @Nullable
    public final String component2() {
        return this.shopListType;
    }

    @Nullable
    public final String component3() {
        return this.channelIndex;
    }

    @Nullable
    public final String component4() {
        return this.channel;
    }

    @Nullable
    public final String component5() {
        return this.shopListTrigger;
    }

    public final boolean component6() {
        return this.isRecomendRestaurantsExist;
    }

    public final int component7() {
        return this.shopRecommendedQuantity;
    }

    public final int component8() {
        return this.shopOpenNumber;
    }

    public final boolean component9() {
        return this.isCollection;
    }

    @NotNull
    public final RestaurantListUpdatedEvent copy(@Nullable ArrayList<Restaurant> arrayList, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z11, int i11, int i12, boolean z12, @Nullable String str5, @Nullable PolygonEvents polygonEvents, @NotNull String str6, @Nullable HashMap<String, String> hashMap, @NotNull ShopClickedEvent.EventOriginSource eventOriginSource2, @Nullable String str7, @Nullable Boolean bool, @Nullable Boolean bool2) {
        ArrayList<Restaurant> arrayList2 = arrayList;
        Intrinsics.checkNotNullParameter(str6, ConstantsKt.LOADED_LIST_VIEW_TYPE);
        Intrinsics.checkNotNullParameter(eventOriginSource2, "eventOriginSource");
        return new RestaurantListUpdatedEvent(arrayList, str, str2, str3, str4, z11, i11, i12, z12, str5, polygonEvents, str6, hashMap, eventOriginSource2, str7, bool, bool2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RestaurantListUpdatedEvent)) {
            return false;
        }
        RestaurantListUpdatedEvent restaurantListUpdatedEvent = (RestaurantListUpdatedEvent) obj;
        return Intrinsics.areEqual((Object) this.restaurants, (Object) restaurantListUpdatedEvent.restaurants) && Intrinsics.areEqual((Object) this.shopListType, (Object) restaurantListUpdatedEvent.shopListType) && Intrinsics.areEqual((Object) this.channelIndex, (Object) restaurantListUpdatedEvent.channelIndex) && Intrinsics.areEqual((Object) this.channel, (Object) restaurantListUpdatedEvent.channel) && Intrinsics.areEqual((Object) this.shopListTrigger, (Object) restaurantListUpdatedEvent.shopListTrigger) && this.isRecomendRestaurantsExist == restaurantListUpdatedEvent.isRecomendRestaurantsExist && this.shopRecommendedQuantity == restaurantListUpdatedEvent.shopRecommendedQuantity && this.shopOpenNumber == restaurantListUpdatedEvent.shopOpenNumber && this.isCollection == restaurantListUpdatedEvent.isCollection && Intrinsics.areEqual((Object) this.shopIds, (Object) restaurantListUpdatedEvent.shopIds) && Intrinsics.areEqual((Object) this.polygonEvent, (Object) restaurantListUpdatedEvent.polygonEvent) && Intrinsics.areEqual((Object) this.listViewType, (Object) restaurantListUpdatedEvent.listViewType) && Intrinsics.areEqual((Object) this.swimlanesGa, (Object) restaurantListUpdatedEvent.swimlanesGa) && Intrinsics.areEqual((Object) this.eventOriginSource, (Object) restaurantListUpdatedEvent.eventOriginSource) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) restaurantListUpdatedEvent.eventOrigin) && Intrinsics.areEqual((Object) this.telcoVerified, (Object) restaurantListUpdatedEvent.telcoVerified) && Intrinsics.areEqual((Object) this.telcoExpired, (Object) restaurantListUpdatedEvent.telcoExpired);
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
    public final String getEventOrigin() {
        return this.eventOrigin;
    }

    @NotNull
    public final ShopClickedEvent.EventOriginSource getEventOriginSource() {
        return this.eventOriginSource;
    }

    @NotNull
    public final String getListViewType() {
        return this.listViewType;
    }

    @Nullable
    public final PolygonEvents getPolygonEvent() {
        return this.polygonEvent;
    }

    @Nullable
    public final ArrayList<Restaurant> getRestaurants() {
        return this.restaurants;
    }

    @Nullable
    public final String getShopIds() {
        return this.shopIds;
    }

    @Nullable
    public final String getShopListTrigger() {
        return this.shopListTrigger;
    }

    @Nullable
    public final String getShopListType() {
        return this.shopListType;
    }

    public final int getShopOpenNumber() {
        return this.shopOpenNumber;
    }

    public final int getShopRecommendedQuantity() {
        return this.shopRecommendedQuantity;
    }

    @Nullable
    public final HashMap<String, String> getSwimlanesGa() {
        return this.swimlanesGa;
    }

    @Nullable
    public final Boolean getTelcoExpired() {
        return this.telcoExpired;
    }

    @Nullable
    public final Boolean getTelcoVerified() {
        return this.telcoVerified;
    }

    public int hashCode() {
        ArrayList<Restaurant> arrayList = this.restaurants;
        int i11 = 0;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        String str = this.shopListType;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.channelIndex;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.channel;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.shopListTrigger;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        boolean z11 = this.isRecomendRestaurantsExist;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i12 = (((((hashCode5 + (z11 ? 1 : 0)) * 31) + this.shopRecommendedQuantity) * 31) + this.shopOpenNumber) * 31;
        boolean z13 = this.isCollection;
        if (!z13) {
            z12 = z13;
        }
        int i13 = (i12 + (z12 ? 1 : 0)) * 31;
        String str5 = this.shopIds;
        int hashCode6 = (i13 + (str5 == null ? 0 : str5.hashCode())) * 31;
        PolygonEvents polygonEvents = this.polygonEvent;
        int hashCode7 = (((hashCode6 + (polygonEvents == null ? 0 : polygonEvents.hashCode())) * 31) + this.listViewType.hashCode()) * 31;
        HashMap<String, String> hashMap = this.swimlanesGa;
        int hashCode8 = (((hashCode7 + (hashMap == null ? 0 : hashMap.hashCode())) * 31) + this.eventOriginSource.hashCode()) * 31;
        String str6 = this.eventOrigin;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool = this.telcoVerified;
        int hashCode10 = (hashCode9 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.telcoExpired;
        if (bool2 != null) {
            i11 = bool2.hashCode();
        }
        return hashCode10 + i11;
    }

    public final boolean isCollection() {
        return this.isCollection;
    }

    public final boolean isRecomendRestaurantsExist() {
        return this.isRecomendRestaurantsExist;
    }

    @NotNull
    public String toString() {
        ArrayList<Restaurant> arrayList = this.restaurants;
        String str = this.shopListType;
        String str2 = this.channelIndex;
        String str3 = this.channel;
        String str4 = this.shopListTrigger;
        boolean z11 = this.isRecomendRestaurantsExist;
        int i11 = this.shopRecommendedQuantity;
        int i12 = this.shopOpenNumber;
        boolean z12 = this.isCollection;
        String str5 = this.shopIds;
        PolygonEvents polygonEvents = this.polygonEvent;
        String str6 = this.listViewType;
        HashMap<String, String> hashMap = this.swimlanesGa;
        ShopClickedEvent.EventOriginSource eventOriginSource2 = this.eventOriginSource;
        String str7 = this.eventOrigin;
        Boolean bool = this.telcoVerified;
        Boolean bool2 = this.telcoExpired;
        return "RestaurantListUpdatedEvent(restaurants=" + arrayList + ", shopListType=" + str + ", channelIndex=" + str2 + ", channel=" + str3 + ", shopListTrigger=" + str4 + ", isRecomendRestaurantsExist=" + z11 + ", shopRecommendedQuantity=" + i11 + ", shopOpenNumber=" + i12 + ", isCollection=" + z12 + ", shopIds=" + str5 + ", polygonEvent=" + polygonEvents + ", listViewType=" + str6 + ", swimlanesGa=" + hashMap + ", eventOriginSource=" + eventOriginSource2 + ", eventOrigin=" + str7 + ", telcoVerified=" + bool + ", telcoExpired=" + bool2 + ")";
    }
}
