package com.talabat.restaurantmenu;

import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.talabat.core.observabilityNew.domain.squads.menu.MenuScreenPerformanceParams;
import datamodels.DeliveryArea;
import datamodels.MenuItem;
import datamodels.PromotionDisplay;
import datamodels.Restaurant;
import datamodels.Warning;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001By\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010¢\u0006\u0002\u0010\u0016J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0007HÆ\u0003J\t\u0010A\u001a\u00020\tHÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010C\u001a\u00020\u000eHÆ\u0003J\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003¢\u0006\u0002\u0010)J\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010HÆ\u0003¢\u0006\u0002\u0010:J\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010HÆ\u0001¢\u0006\u0002\u0010HJ\u0013\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010L\u001a\u00020MH\u0016J\t\u0010N\u001a\u00020\u000eHÖ\u0001R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010X\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006O"}, d2 = {"Lcom/talabat/restaurantmenu/MenuModel;", "", "menuItemsResponseModel", "LJsonModels/MenuItemsResponseModel;", "restaurant", "Ldatamodels/Restaurant;", "tgoFreeDeliveryResponse", "LJsonModels/Response/SplitRestaurantApiResponse/TgoFreeDeliveryResponse;", "menu", "LJsonModels/MenuItemRM;", "upsellingItems", "Ljava/util/ArrayList;", "Ldatamodels/MenuItem;", "heroImage", "", "promotions", "", "Ldatamodels/PromotionDisplay;", "deliveryAreas", "Ldatamodels/DeliveryArea;", "warnings", "Ldatamodels/Warning;", "(LJsonModels/MenuItemsResponseModel;Ldatamodels/Restaurant;LJsonModels/Response/SplitRestaurantApiResponse/TgoFreeDeliveryResponse;LJsonModels/MenuItemRM;Ljava/util/ArrayList;Ljava/lang/String;[Ldatamodels/PromotionDisplay;[Ldatamodels/DeliveryArea;[Ldatamodels/Warning;)V", "getDeliveryAreas", "()[Ldatamodels/DeliveryArea;", "setDeliveryAreas", "([Ldatamodels/DeliveryArea;)V", "[Ldatamodels/DeliveryArea;", "getHeroImage", "()Ljava/lang/String;", "setHeroImage", "(Ljava/lang/String;)V", "getMenu", "()LJsonModels/MenuItemRM;", "setMenu", "(LJsonModels/MenuItemRM;)V", "getMenuItemsResponseModel", "()LJsonModels/MenuItemsResponseModel;", "setMenuItemsResponseModel", "(LJsonModels/MenuItemsResponseModel;)V", "getPromotions", "()[Ldatamodels/PromotionDisplay;", "setPromotions", "([Ldatamodels/PromotionDisplay;)V", "[Ldatamodels/PromotionDisplay;", "getRestaurant", "()Ldatamodels/Restaurant;", "setRestaurant", "(Ldatamodels/Restaurant;)V", "getTgoFreeDeliveryResponse", "()LJsonModels/Response/SplitRestaurantApiResponse/TgoFreeDeliveryResponse;", "setTgoFreeDeliveryResponse", "(LJsonModels/Response/SplitRestaurantApiResponse/TgoFreeDeliveryResponse;)V", "getUpsellingItems", "()Ljava/util/ArrayList;", "setUpsellingItems", "(Ljava/util/ArrayList;)V", "getWarnings", "()[Ldatamodels/Warning;", "setWarnings", "([Ldatamodels/Warning;)V", "[Ldatamodels/Warning;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(LJsonModels/MenuItemsResponseModel;Ldatamodels/Restaurant;LJsonModels/Response/SplitRestaurantApiResponse/TgoFreeDeliveryResponse;LJsonModels/MenuItemRM;Ljava/util/ArrayList;Ljava/lang/String;[Ldatamodels/PromotionDisplay;[Ldatamodels/DeliveryArea;[Ldatamodels/Warning;)Lcom/talabat/restaurantmenu/MenuModel;", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MenuModel {
    @NotNull
    private DeliveryArea[] deliveryAreas;
    @NotNull
    private String heroImage;
    @NotNull
    private MenuItemRM menu;
    @NotNull
    private MenuItemsResponseModel menuItemsResponseModel;
    @NotNull
    private PromotionDisplay[] promotions;
    @NotNull
    private Restaurant restaurant;
    @NotNull
    private TgoFreeDeliveryResponse tgoFreeDeliveryResponse;
    @NotNull
    private ArrayList<MenuItem> upsellingItems;
    @NotNull
    private Warning[] warnings;

    @JvmOverloads
    public MenuModel() {
        this((MenuItemsResponseModel) null, (Restaurant) null, (TgoFreeDeliveryResponse) null, (MenuItemRM) null, (ArrayList) null, (String) null, (PromotionDisplay[]) null, (DeliveryArea[]) null, (Warning[]) null, 511, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MenuModel(@NotNull MenuItemsResponseModel menuItemsResponseModel2) {
        this(menuItemsResponseModel2, (Restaurant) null, (TgoFreeDeliveryResponse) null, (MenuItemRM) null, (ArrayList) null, (String) null, (PromotionDisplay[]) null, (DeliveryArea[]) null, (Warning[]) null, TypedValues.PositionType.TYPE_POSITION_TYPE, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(menuItemsResponseModel2, "menuItemsResponseModel");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MenuModel(@NotNull MenuItemsResponseModel menuItemsResponseModel2, @NotNull Restaurant restaurant2) {
        this(menuItemsResponseModel2, restaurant2, (TgoFreeDeliveryResponse) null, (MenuItemRM) null, (ArrayList) null, (String) null, (PromotionDisplay[]) null, (DeliveryArea[]) null, (Warning[]) null, 508, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(menuItemsResponseModel2, "menuItemsResponseModel");
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MenuModel(@org.jetbrains.annotations.NotNull JsonModels.MenuItemsResponseModel r14, @org.jetbrains.annotations.NotNull datamodels.Restaurant r15, @org.jetbrains.annotations.NotNull JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse r16) {
        /*
            r13 = this;
            java.lang.String r0 = "menuItemsResponseModel"
            r2 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "restaurant"
            r3 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "tgoFreeDeliveryResponse"
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 504(0x1f8, float:7.06E-43)
            r12 = 0
            r1 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurantmenu.MenuModel.<init>(JsonModels.MenuItemsResponseModel, datamodels.Restaurant, JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MenuModel(@org.jetbrains.annotations.NotNull JsonModels.MenuItemsResponseModel r14, @org.jetbrains.annotations.NotNull datamodels.Restaurant r15, @org.jetbrains.annotations.NotNull JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse r16, @org.jetbrains.annotations.NotNull JsonModels.MenuItemRM r17) {
        /*
            r13 = this;
            java.lang.String r0 = "menuItemsResponseModel"
            r2 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "restaurant"
            r3 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "tgoFreeDeliveryResponse"
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "menu"
            r5 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 496(0x1f0, float:6.95E-43)
            r12 = 0
            r1 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurantmenu.MenuModel.<init>(JsonModels.MenuItemsResponseModel, datamodels.Restaurant, JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse, JsonModels.MenuItemRM):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MenuModel(@org.jetbrains.annotations.NotNull JsonModels.MenuItemsResponseModel r14, @org.jetbrains.annotations.NotNull datamodels.Restaurant r15, @org.jetbrains.annotations.NotNull JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse r16, @org.jetbrains.annotations.NotNull JsonModels.MenuItemRM r17, @org.jetbrains.annotations.NotNull java.util.ArrayList<datamodels.MenuItem> r18) {
        /*
            r13 = this;
            java.lang.String r0 = "menuItemsResponseModel"
            r2 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "restaurant"
            r3 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "tgoFreeDeliveryResponse"
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "menu"
            r5 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "upsellingItems"
            r6 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 480(0x1e0, float:6.73E-43)
            r12 = 0
            r1 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurantmenu.MenuModel.<init>(JsonModels.MenuItemsResponseModel, datamodels.Restaurant, JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse, JsonModels.MenuItemRM, java.util.ArrayList):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MenuModel(@org.jetbrains.annotations.NotNull JsonModels.MenuItemsResponseModel r14, @org.jetbrains.annotations.NotNull datamodels.Restaurant r15, @org.jetbrains.annotations.NotNull JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse r16, @org.jetbrains.annotations.NotNull JsonModels.MenuItemRM r17, @org.jetbrains.annotations.NotNull java.util.ArrayList<datamodels.MenuItem> r18, @org.jetbrains.annotations.NotNull java.lang.String r19) {
        /*
            r13 = this;
            java.lang.String r0 = "menuItemsResponseModel"
            r2 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "restaurant"
            r3 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "tgoFreeDeliveryResponse"
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "menu"
            r5 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "upsellingItems"
            r6 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "heroImage"
            r7 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 448(0x1c0, float:6.28E-43)
            r12 = 0
            r1 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurantmenu.MenuModel.<init>(JsonModels.MenuItemsResponseModel, datamodels.Restaurant, JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse, JsonModels.MenuItemRM, java.util.ArrayList, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MenuModel(@org.jetbrains.annotations.NotNull JsonModels.MenuItemsResponseModel r14, @org.jetbrains.annotations.NotNull datamodels.Restaurant r15, @org.jetbrains.annotations.NotNull JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse r16, @org.jetbrains.annotations.NotNull JsonModels.MenuItemRM r17, @org.jetbrains.annotations.NotNull java.util.ArrayList<datamodels.MenuItem> r18, @org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull datamodels.PromotionDisplay[] r20) {
        /*
            r13 = this;
            java.lang.String r0 = "menuItemsResponseModel"
            r2 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "restaurant"
            r3 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "tgoFreeDeliveryResponse"
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "menu"
            r5 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "upsellingItems"
            r6 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "heroImage"
            r7 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "promotions"
            r8 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r9 = 0
            r10 = 0
            r11 = 384(0x180, float:5.38E-43)
            r12 = 0
            r1 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurantmenu.MenuModel.<init>(JsonModels.MenuItemsResponseModel, datamodels.Restaurant, JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse, JsonModels.MenuItemRM, java.util.ArrayList, java.lang.String, datamodels.PromotionDisplay[]):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MenuModel(@org.jetbrains.annotations.NotNull JsonModels.MenuItemsResponseModel r14, @org.jetbrains.annotations.NotNull datamodels.Restaurant r15, @org.jetbrains.annotations.NotNull JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse r16, @org.jetbrains.annotations.NotNull JsonModels.MenuItemRM r17, @org.jetbrains.annotations.NotNull java.util.ArrayList<datamodels.MenuItem> r18, @org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull datamodels.PromotionDisplay[] r20, @org.jetbrains.annotations.NotNull datamodels.DeliveryArea[] r21) {
        /*
            r13 = this;
            java.lang.String r0 = "menuItemsResponseModel"
            r2 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "restaurant"
            r3 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "tgoFreeDeliveryResponse"
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "menu"
            r5 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "upsellingItems"
            r6 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "heroImage"
            r7 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "promotions"
            r8 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "deliveryAreas"
            r9 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r10 = 0
            r11 = 256(0x100, float:3.59E-43)
            r12 = 0
            r1 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurantmenu.MenuModel.<init>(JsonModels.MenuItemsResponseModel, datamodels.Restaurant, JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse, JsonModels.MenuItemRM, java.util.ArrayList, java.lang.String, datamodels.PromotionDisplay[], datamodels.DeliveryArea[]):void");
    }

    @JvmOverloads
    public MenuModel(@NotNull MenuItemsResponseModel menuItemsResponseModel2, @NotNull Restaurant restaurant2, @NotNull TgoFreeDeliveryResponse tgoFreeDeliveryResponse2, @NotNull MenuItemRM menuItemRM, @NotNull ArrayList<MenuItem> arrayList, @NotNull String str, @NotNull PromotionDisplay[] promotionDisplayArr, @NotNull DeliveryArea[] deliveryAreaArr, @NotNull Warning[] warningArr) {
        Intrinsics.checkNotNullParameter(menuItemsResponseModel2, "menuItemsResponseModel");
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        Intrinsics.checkNotNullParameter(tgoFreeDeliveryResponse2, "tgoFreeDeliveryResponse");
        Intrinsics.checkNotNullParameter(menuItemRM, MenuScreenPerformanceParams.SCREEN_TYPE);
        Intrinsics.checkNotNullParameter(arrayList, "upsellingItems");
        Intrinsics.checkNotNullParameter(str, "heroImage");
        Intrinsics.checkNotNullParameter(promotionDisplayArr, "promotions");
        Intrinsics.checkNotNullParameter(deliveryAreaArr, "deliveryAreas");
        Intrinsics.checkNotNullParameter(warningArr, "warnings");
        this.menuItemsResponseModel = menuItemsResponseModel2;
        this.restaurant = restaurant2;
        this.tgoFreeDeliveryResponse = tgoFreeDeliveryResponse2;
        this.menu = menuItemRM;
        this.upsellingItems = arrayList;
        this.heroImage = str;
        this.promotions = promotionDisplayArr;
        this.deliveryAreas = deliveryAreaArr;
        this.warnings = warningArr;
    }

    public static /* synthetic */ MenuModel copy$default(MenuModel menuModel, MenuItemsResponseModel menuItemsResponseModel2, Restaurant restaurant2, TgoFreeDeliveryResponse tgoFreeDeliveryResponse2, MenuItemRM menuItemRM, ArrayList arrayList, String str, PromotionDisplay[] promotionDisplayArr, DeliveryArea[] deliveryAreaArr, Warning[] warningArr, int i11, Object obj) {
        MenuModel menuModel2 = menuModel;
        int i12 = i11;
        return menuModel.copy((i12 & 1) != 0 ? menuModel2.menuItemsResponseModel : menuItemsResponseModel2, (i12 & 2) != 0 ? menuModel2.restaurant : restaurant2, (i12 & 4) != 0 ? menuModel2.tgoFreeDeliveryResponse : tgoFreeDeliveryResponse2, (i12 & 8) != 0 ? menuModel2.menu : menuItemRM, (i12 & 16) != 0 ? menuModel2.upsellingItems : arrayList, (i12 & 32) != 0 ? menuModel2.heroImage : str, (i12 & 64) != 0 ? menuModel2.promotions : promotionDisplayArr, (i12 & 128) != 0 ? menuModel2.deliveryAreas : deliveryAreaArr, (i12 & 256) != 0 ? menuModel2.warnings : warningArr);
    }

    @NotNull
    public final MenuItemsResponseModel component1() {
        return this.menuItemsResponseModel;
    }

    @NotNull
    public final Restaurant component2() {
        return this.restaurant;
    }

    @NotNull
    public final TgoFreeDeliveryResponse component3() {
        return this.tgoFreeDeliveryResponse;
    }

    @NotNull
    public final MenuItemRM component4() {
        return this.menu;
    }

    @NotNull
    public final ArrayList<MenuItem> component5() {
        return this.upsellingItems;
    }

    @NotNull
    public final String component6() {
        return this.heroImage;
    }

    @NotNull
    public final PromotionDisplay[] component7() {
        return this.promotions;
    }

    @NotNull
    public final DeliveryArea[] component8() {
        return this.deliveryAreas;
    }

    @NotNull
    public final Warning[] component9() {
        return this.warnings;
    }

    @NotNull
    public final MenuModel copy(@NotNull MenuItemsResponseModel menuItemsResponseModel2, @NotNull Restaurant restaurant2, @NotNull TgoFreeDeliveryResponse tgoFreeDeliveryResponse2, @NotNull MenuItemRM menuItemRM, @NotNull ArrayList<MenuItem> arrayList, @NotNull String str, @NotNull PromotionDisplay[] promotionDisplayArr, @NotNull DeliveryArea[] deliveryAreaArr, @NotNull Warning[] warningArr) {
        Intrinsics.checkNotNullParameter(menuItemsResponseModel2, "menuItemsResponseModel");
        Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
        Intrinsics.checkNotNullParameter(tgoFreeDeliveryResponse2, "tgoFreeDeliveryResponse");
        Intrinsics.checkNotNullParameter(menuItemRM, MenuScreenPerformanceParams.SCREEN_TYPE);
        ArrayList<MenuItem> arrayList2 = arrayList;
        Intrinsics.checkNotNullParameter(arrayList2, "upsellingItems");
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "heroImage");
        PromotionDisplay[] promotionDisplayArr2 = promotionDisplayArr;
        Intrinsics.checkNotNullParameter(promotionDisplayArr2, "promotions");
        DeliveryArea[] deliveryAreaArr2 = deliveryAreaArr;
        Intrinsics.checkNotNullParameter(deliveryAreaArr2, "deliveryAreas");
        Warning[] warningArr2 = warningArr;
        Intrinsics.checkNotNullParameter(warningArr2, "warnings");
        return new MenuModel(menuItemsResponseModel2, restaurant2, tgoFreeDeliveryResponse2, menuItemRM, arrayList2, str2, promotionDisplayArr2, deliveryAreaArr2, warningArr2);
    }

    public boolean equals(@Nullable Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        Class<MenuModel> cls2 = MenuModel.class;
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual((Object) cls2, (Object) cls)) {
            return false;
        }
        if (obj != null) {
            MenuModel menuModel = (MenuModel) obj;
            if (Arrays.equals(this.promotions, menuModel.promotions) && Arrays.equals(this.deliveryAreas, menuModel.deliveryAreas) && Arrays.equals(this.warnings, menuModel.warnings)) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.restaurantmenu.MenuModel");
    }

    @NotNull
    public final DeliveryArea[] getDeliveryAreas() {
        return this.deliveryAreas;
    }

    @NotNull
    public final String getHeroImage() {
        return this.heroImage;
    }

    @NotNull
    public final MenuItemRM getMenu() {
        return this.menu;
    }

    @NotNull
    public final MenuItemsResponseModel getMenuItemsResponseModel() {
        return this.menuItemsResponseModel;
    }

    @NotNull
    public final PromotionDisplay[] getPromotions() {
        return this.promotions;
    }

    @NotNull
    public final Restaurant getRestaurant() {
        return this.restaurant;
    }

    @NotNull
    public final TgoFreeDeliveryResponse getTgoFreeDeliveryResponse() {
        return this.tgoFreeDeliveryResponse;
    }

    @NotNull
    public final ArrayList<MenuItem> getUpsellingItems() {
        return this.upsellingItems;
    }

    @NotNull
    public final Warning[] getWarnings() {
        return this.warnings;
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.promotions) * 31) + Arrays.hashCode(this.deliveryAreas)) * 31) + Arrays.hashCode(this.warnings);
    }

    public final void setDeliveryAreas(@NotNull DeliveryArea[] deliveryAreaArr) {
        Intrinsics.checkNotNullParameter(deliveryAreaArr, "<set-?>");
        this.deliveryAreas = deliveryAreaArr;
    }

    public final void setHeroImage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.heroImage = str;
    }

    public final void setMenu(@NotNull MenuItemRM menuItemRM) {
        Intrinsics.checkNotNullParameter(menuItemRM, "<set-?>");
        this.menu = menuItemRM;
    }

    public final void setMenuItemsResponseModel(@NotNull MenuItemsResponseModel menuItemsResponseModel2) {
        Intrinsics.checkNotNullParameter(menuItemsResponseModel2, "<set-?>");
        this.menuItemsResponseModel = menuItemsResponseModel2;
    }

    public final void setPromotions(@NotNull PromotionDisplay[] promotionDisplayArr) {
        Intrinsics.checkNotNullParameter(promotionDisplayArr, "<set-?>");
        this.promotions = promotionDisplayArr;
    }

    public final void setRestaurant(@NotNull Restaurant restaurant2) {
        Intrinsics.checkNotNullParameter(restaurant2, "<set-?>");
        this.restaurant = restaurant2;
    }

    public final void setTgoFreeDeliveryResponse(@NotNull TgoFreeDeliveryResponse tgoFreeDeliveryResponse2) {
        Intrinsics.checkNotNullParameter(tgoFreeDeliveryResponse2, "<set-?>");
        this.tgoFreeDeliveryResponse = tgoFreeDeliveryResponse2;
    }

    public final void setUpsellingItems(@NotNull ArrayList<MenuItem> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.upsellingItems = arrayList;
    }

    public final void setWarnings(@NotNull Warning[] warningArr) {
        Intrinsics.checkNotNullParameter(warningArr, "<set-?>");
        this.warnings = warningArr;
    }

    @NotNull
    public String toString() {
        MenuItemsResponseModel menuItemsResponseModel2 = this.menuItemsResponseModel;
        Restaurant restaurant2 = this.restaurant;
        TgoFreeDeliveryResponse tgoFreeDeliveryResponse2 = this.tgoFreeDeliveryResponse;
        MenuItemRM menuItemRM = this.menu;
        ArrayList<MenuItem> arrayList = this.upsellingItems;
        String str = this.heroImage;
        String arrays = Arrays.toString(this.promotions);
        String arrays2 = Arrays.toString(this.deliveryAreas);
        String arrays3 = Arrays.toString(this.warnings);
        return "MenuModel(menuItemsResponseModel=" + menuItemsResponseModel2 + ", restaurant=" + restaurant2 + ", tgoFreeDeliveryResponse=" + tgoFreeDeliveryResponse2 + ", menu=" + menuItemRM + ", upsellingItems=" + arrayList + ", heroImage=" + str + ", promotions=" + arrays + ", deliveryAreas=" + arrays2 + ", warnings=" + arrays3 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MenuModel(JsonModels.MenuItemsResponseModel r11, datamodels.Restaurant r12, JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse r13, JsonModels.MenuItemRM r14, java.util.ArrayList r15, java.lang.String r16, datamodels.PromotionDisplay[] r17, datamodels.DeliveryArea[] r18, datamodels.Warning[] r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            JsonModels.MenuItemsResponseModel r1 = new JsonModels.MenuItemsResponseModel
            r1.<init>()
            goto L_0x000d
        L_0x000c:
            r1 = r11
        L_0x000d:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0017
            datamodels.Restaurant r2 = new datamodels.Restaurant
            r2.<init>()
            goto L_0x0018
        L_0x0017:
            r2 = r12
        L_0x0018:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0022
            JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse r3 = new JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse
            r3.<init>()
            goto L_0x0023
        L_0x0022:
            r3 = r13
        L_0x0023:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x002d
            JsonModels.MenuItemRM r4 = new JsonModels.MenuItemRM
            r4.<init>()
            goto L_0x002e
        L_0x002d:
            r4 = r14
        L_0x002e:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0038
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            goto L_0x0039
        L_0x0038:
            r5 = r15
        L_0x0039:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0040
            java.lang.String r6 = ""
            goto L_0x0042
        L_0x0040:
            r6 = r16
        L_0x0042:
            r7 = r0 & 64
            r8 = 0
            if (r7 == 0) goto L_0x004a
            datamodels.PromotionDisplay[] r7 = new datamodels.PromotionDisplay[r8]
            goto L_0x004c
        L_0x004a:
            r7 = r17
        L_0x004c:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0053
            datamodels.DeliveryArea[] r9 = new datamodels.DeliveryArea[r8]
            goto L_0x0055
        L_0x0053:
            r9 = r18
        L_0x0055:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x005c
            datamodels.Warning[] r0 = new datamodels.Warning[r8]
            goto L_0x005e
        L_0x005c:
            r0 = r19
        L_0x005e:
            r11 = r10
            r12 = r1
            r13 = r2
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r9
            r20 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurantmenu.MenuModel.<init>(JsonModels.MenuItemsResponseModel, datamodels.Restaurant, JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse, JsonModels.MenuItemRM, java.util.ArrayList, java.lang.String, datamodels.PromotionDisplay[], datamodels.DeliveryArea[], datamodels.Warning[], int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
