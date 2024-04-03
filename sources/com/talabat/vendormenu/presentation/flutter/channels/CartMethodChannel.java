package com.talabat.vendormenu.presentation.flutter.channels;

import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherRM;
import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherResult;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import buisnessmodels.Cart;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.extentions.GsonKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.ApplyVoucherViewModelMapperKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDataKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.vendormenu.presentation.flutter.data.FlutterCartKt;
import com.talabat.vendormenu.presentation.flutter.dto.AddToBasketCallArguments;
import com.talabat.vendormenu.presentation.flutter.dto.AddToCartWrapperArguments;
import com.talabat.vendormenu.presentation.flutter.dto.ApplyVoucherCallArguments;
import com.talabat.vendormenu.presentation.flutter.dto.MenuDiscountTypeArgument;
import com.talabat.vendormenu.presentation.flutter.dto.UpdateCutleryWrapperArguments;
import com.talabat.vendormenu.presentation.flutter.dto.UpdateDeliveryTimeArguments;
import com.talabat.vendormenu.presentation.flutter.dto.UpdateQuantityWrapperArguments;
import com.talabat.vendormenu.presentation.flutter.dto.UpdateSpecialRequestWrapperArguments;
import com.talabat.vendormenu.presentation.flutter.dto.UpdatedSelectedMenuDiscountCallArguments;
import datamodels.CartMenuItem;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import datamodels.Coupon;
import datamodels.MenuItem;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 :2\u00020\u0001:\u0001:B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J)\u0010\u0012\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0017H\u0002¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001aH\u0002J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!H\u0002J\u001a\u0010\"\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010#\u001a\u00020\u001fH\u0002J\u001a\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010!H\u0002J\u0018\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\tH\u0002J\u0010\u0010,\u001a\u00020\t2\u0006\u0010\n\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u0015H\u0002J\u0010\u0010/\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u00100\u001a\u00020\t2\u0006\u0010\n\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\t2\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020\t2\u0006\u00103\u001a\u000204H\u0002J\u0010\u00106\u001a\u00020\t2\u0006\u00103\u001a\u000204H\u0002J\u0010\u00107\u001a\u00020\t2\u0006\u00103\u001a\u000204H\u0002J\u0010\u00108\u001a\u00020\t2\u0006\u0010\n\u001a\u000209H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006;"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/channels/CartMethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "addArgumentsToCart", "", "argument", "Lcom/talabat/vendormenu/presentation/flutter/dto/AddToCartWrapperArguments;", "addToCart", "cartItem", "Lcom/talabat/vendormenu/presentation/flutter/dto/AddToBasketCallArguments;", "applyVoucher", "Lcom/talabat/vendormenu/presentation/flutter/dto/ApplyVoucherCallArguments;", "deSelectMenuDiscount", "extractArgs", "T", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "clazz", "Ljava/lang/Class;", "(Lio/flutter/plugin/common/MethodCall;Ljava/lang/Class;)Ljava/lang/Object;", "getCartInformation", "", "", "", "getItemSelectedChoices", "", "", "cartMenuItem", "Ldatamodels/CartMenuItem;", "handleItemUpdateQuantity", "updatedQuantity", "handleUpdateItem", "updatedMenuItem", "originalMenuItem", "onMethodCall", "call", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "removeAppliedVoucher", "updateCutlery", "Lcom/talabat/vendormenu/presentation/flutter/dto/UpdateCutleryWrapperArguments;", "updateDeliveryTimeValue", "updateItemFromCart", "updateQuantity", "Lcom/talabat/vendormenu/presentation/flutter/dto/UpdateQuantityWrapperArguments;", "updateSelectedAutoAppliedDiscount", "arguments", "Lcom/talabat/vendormenu/presentation/flutter/dto/UpdatedSelectedMenuDiscountCallArguments;", "updateSelectedCoupon", "updateSelectedMenuDiscount", "updateSelectedPromotion", "updateSpecialRequest", "Lcom/talabat/vendormenu/presentation/flutter/dto/UpdateSpecialRequestWrapperArguments;", "Companion", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartMethodChannel implements MethodChannel.MethodCallHandler {
    @NotNull
    private static final String ADD_T0_CART = "addToCart";
    @NotNull
    private static final String APPLY_VOUCHER = "applyVoucher";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String GET_CART = "getCartInfo";
    @NotNull
    private static final String REMOVE_APPLIED_VOUCHER = "removeAppliedVoucher";
    @NotNull
    private static final String RESET_CART = "resetCart";
    @NotNull
    private static final String TAG = "CartMethodChannel";
    @NotNull
    private static final String UPDATE_CUTLERY = "updateCutlery";
    @NotNull
    private static final String UPDATE_DELIVERY_TIME = "updateDeliveryTime";
    @NotNull
    private static final String UPDATE_ITEM_FROM_CART = "updateItemFromCart";
    @NotNull
    private static final String UPDATE_QUANTITY = "updateItemQuantity";
    @NotNull
    private static final String UPDATE_SELECTED_MENU_DISCOUNT = "updateSelectedMenuDiscountRequest";
    @NotNull
    private static final String UPDATE_SPECIAL_REQUEST = "updateSpecialRequest";
    @NotNull
    private Context context;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/channels/CartMethodChannel$Companion;", "", "()V", "ADD_T0_CART", "", "APPLY_VOUCHER", "GET_CART", "REMOVE_APPLIED_VOUCHER", "RESET_CART", "TAG", "UPDATE_CUTLERY", "UPDATE_DELIVERY_TIME", "UPDATE_ITEM_FROM_CART", "UPDATE_QUANTITY", "UPDATE_SELECTED_MENU_DISCOUNT", "UPDATE_SPECIAL_REQUEST", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MenuDiscountTypeArgument.values().length];
            iArr[MenuDiscountTypeArgument.COUPON.ordinal()] = 1;
            iArr[MenuDiscountTypeArgument.AUTO_APPLIED_DISCOUNT.ordinal()] = 2;
            iArr[MenuDiscountTypeArgument.PROMOTION.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CartMethodChannel(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    private final void addArgumentsToCart(AddToCartWrapperArguments addToCartWrapperArguments) {
        Cart instance = Cart.getInstance();
        instance.setRestaurant(GlobalDataModel.SELECTED.getRestaurant(), this.context);
        String deliveryMode = addToCartWrapperArguments.getDeliveryMode();
        if (deliveryMode == null) {
            deliveryMode = "Delivery Error Mode";
        }
        instance.setDeliveryMode(deliveryMode);
        ArrayList<AddToBasketCallArguments> cartItems = addToCartWrapperArguments.getCartItems();
        if (cartItems != null) {
            for (AddToBasketCallArguments addToCart : cartItems) {
                addToCart(addToCart, this.context);
            }
        }
    }

    private final void addToCart(AddToBasketCallArguments addToBasketCallArguments, Context context2) {
        if (Intrinsics.areEqual((Object) addToBasketCallArguments.isFromUpsell(), (Object) Boolean.TRUE)) {
            MenuItem menuItem = addToBasketCallArguments.getMenuItem();
            if (menuItem != null) {
                menuItem.choiceSections = null;
            }
            Cart.getInstance().addUpsellingItem(addToBasketCallArguments.getMenuItem(), context2);
            return;
        }
        CartMenuItem createWithMenuItem = CartMenuItem.createWithMenuItem(addToBasketCallArguments.getMenuItem());
        createWithMenuItem.choiceSections = new ChoiceSection[0];
        GlobalDataModel.SELECTED.cartMenuItem = createWithMenuItem;
        createWithMenuItem.setQuantity(addToBasketCallArguments.getQuantity());
        createWithMenuItem.specialRequest = addToBasketCallArguments.getSpecialRequest();
        if (addToBasketCallArguments.getSelectedChoiceSections() != null) {
            for (ChoiceSection selectedChoicesForSection : addToBasketCallArguments.getSelectedChoiceSections()) {
                createWithMenuItem.setSelectedChoicesForSection(selectedChoicesForSection);
            }
        }
        Cart.getInstance().addItem(createWithMenuItem, context2);
    }

    private final void applyVoucher(ApplyVoucherCallArguments applyVoucherCallArguments) {
        Bounds bounds;
        DiscountType mapToDiscountType = ApplyVoucherViewModelMapperKt.mapToDiscountType(applyVoucherCallArguments.getDiscountType());
        float discountValue = (float) applyVoucherCallArguments.getDiscountValue();
        String voucherCode = applyVoucherCallArguments.getVoucherCode();
        String id2 = applyVoucherCallArguments.getId();
        float maxDiscountCap = (float) applyVoucherCallArguments.getMaxDiscountCap();
        float minOrderValue = (float) applyVoucherCallArguments.getMinOrderValue();
        String title = applyVoucherCallArguments.getTitle();
        Bounds bounds2 = applyVoucherCallArguments.getBounds();
        if (bounds2 == null) {
            bounds = new Bounds(CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList(), (List) null, false, 12, (DefaultConstructorMarker) null);
        } else {
            bounds = bounds2;
        }
        LoyaltyVoucherResult layoutVoucherResult = VoucherDataKt.toLayoutVoucherResult(new VoucherData(id2, title, 0, discountValue, mapToDiscountType, maxDiscountCap, minOrderValue, bounds, (VoucherOptionType) null, (String) null, (String) null, (String) null, (String) null, (String) null, voucherCode, (String) null, (Integer) null, 114436, (DefaultConstructorMarker) null));
        LoyaltyVoucherRM loyaltyVoucherRM = new LoyaltyVoucherRM((LoyaltyVoucherResult) null, (List) null, (Boolean) null, 7, (DefaultConstructorMarker) null);
        loyaltyVoucherRM.result = layoutVoucherResult;
        Cart.getInstance().saveLoyaltyVoucher(this.context, loyaltyVoucherRM);
        Cart.getInstance().calculateLoyaltyDiscount(this.context);
    }

    private final void deSelectMenuDiscount() {
        Cart.getInstance().deSelectPromotion();
        Cart.getInstance().deSelectCoupon();
    }

    private final <T> T extractArgs(MethodCall methodCall, Class<T> cls) {
        Gson gson = GsonKt.getGson();
        String json$default = GsonKt.toJson$default(methodCall.arguments, (Gson) null, 1, (Object) null);
        return !(gson instanceof Gson) ? gson.fromJson(json$default, cls) : GsonInstrumentation.fromJson(gson, json$default, cls);
    }

    private final Map<String, Object> getCartInformation() {
        Cart instance = Cart.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return FlutterCartKt.toMap(instance);
    }

    private final Set<Integer> getItemSelectedChoices(CartMenuItem cartMenuItem) {
        Set<Integer> set;
        ArrayList<ChoiceSection> arrayList = cartMenuItem.selectedChoices;
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            for (ChoiceSection choiceSection : arrayList) {
                ArrayList<ChoiceItem> arrayList3 = choiceSection.itemChoices;
                Intrinsics.checkNotNullExpressionValue(arrayList3, "choiceSection.itemChoices");
                ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
                for (ChoiceItem choiceItem : arrayList3) {
                    arrayList4.add(Integer.valueOf(choiceItem.f13839id));
                }
                arrayList2.add(arrayList4);
            }
            List flatten = CollectionsKt__IterablesKt.flatten(arrayList2);
            if (!(flatten == null || (set = CollectionsKt___CollectionsKt.toSet(flatten)) == null)) {
                return set;
            }
        }
        return SetsKt__SetsKt.emptySet();
    }

    private final void handleItemUpdateQuantity(CartMenuItem cartMenuItem, int i11) {
        if (cartMenuItem == null) {
            return;
        }
        if (i11 > 0) {
            cartMenuItem.setQuantity(i11);
            Cart.getInstance().updateItemQuantity(cartMenuItem, this.context);
            return;
        }
        int indexOf = Cart.getInstance().getCartItems().indexOf(cartMenuItem);
        if (indexOf > -1) {
            Cart.getInstance().deleteItemAtPostion(indexOf, this.context);
        }
    }

    private final void handleUpdateItem(CartMenuItem cartMenuItem, CartMenuItem cartMenuItem2) {
        String refId = cartMenuItem.getRefId();
        String str = cartMenuItem.specialRequest;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String str3 = refId + str;
        if (cartMenuItem2 != null) {
            String refId2 = cartMenuItem2.getRefId();
            String str4 = cartMenuItem2.specialRequest;
            if (str4 != null) {
                str2 = str4;
            }
            str2 = refId2 + str2;
        }
        if (Intrinsics.areEqual((Object) str2, (Object) str3)) {
            Cart.getInstance().deleteItemAtPostion(Cart.getInstance().getCartItems().indexOf(cartMenuItem2), this.context);
            Cart.getInstance().addItem(cartMenuItem, this.context);
        } else if (!Cart.getInstance().mergeItemExistsInCart(cartMenuItem)) {
            Cart.getInstance().deleteItemAtPostion(Cart.getInstance().getCartItems().indexOf(cartMenuItem2), this.context);
            Cart.getInstance().addItem(cartMenuItem, this.context);
        } else if (cartMenuItem2 != null) {
            Cart.getInstance().getCartItems().remove(cartMenuItem2);
        }
    }

    private final void removeAppliedVoucher() {
        Cart.getInstance().removeLoyaltyVoucherIfAvailable();
        Cart.getInstance().removeVoucherIfApplied();
    }

    private final void updateCutlery(UpdateCutleryWrapperArguments updateCutleryWrapperArguments) {
        Cart.getInstance().setGoGreenSelection(!updateCutleryWrapperArguments.getCutleryValue());
    }

    private final void updateDeliveryTimeValue(MethodCall methodCall) {
        boolean z11;
        UpdateDeliveryTimeArguments updateDeliveryTimeArguments = (UpdateDeliveryTimeArguments) extractArgs(methodCall, UpdateDeliveryTimeArguments.class);
        String deliveryTime = updateDeliveryTimeArguments.getDeliveryTime();
        if (deliveryTime == null || deliveryTime.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            Cart.getInstance().getRestaurant().deliveryTime = updateDeliveryTimeArguments.getDeliveryTime();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ab, code lost:
        if (r5 != false) goto L_0x00b0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ea A[EDGE_INSN: B:44:0x00ea->B:42:0x00ea ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateItemFromCart(io.flutter.plugin.common.MethodCall r11) {
        /*
            r10 = this;
            java.lang.Class<com.talabat.vendormenu.presentation.flutter.dto.UpdateItemFromCartArguments> r0 = com.talabat.vendormenu.presentation.flutter.dto.UpdateItemFromCartArguments.class
            java.lang.Object r11 = r10.extractArgs(r11, r0)
            com.talabat.vendormenu.presentation.flutter.dto.UpdateItemFromCartArguments r11 = (com.talabat.vendormenu.presentation.flutter.dto.UpdateItemFromCartArguments) r11
            com.talabat.vendormenu.presentation.flutter.dto.UpdateItemArguments r0 = r11.getUpdatedItem()
            datamodels.MenuItem r0 = r0.getMenuItem()
            if (r0 == 0) goto L_0x00fb
            datamodels.CartMenuItem r0 = datamodels.CartMenuItem.createWithMenuItem(r0)
            r1 = 0
            datamodels.ChoiceSection[] r2 = new datamodels.ChoiceSection[r1]
            r0.choiceSections = r2
            com.talabat.helpers.GlobalDataModel.SELECTED.cartMenuItem = r0
            com.talabat.vendormenu.presentation.flutter.dto.UpdateItemArguments r2 = r11.getUpdatedItem()
            int r2 = r2.getQuantity()
            r0.setQuantity(r2)
            com.talabat.vendormenu.presentation.flutter.dto.UpdateItemArguments r2 = r11.getUpdatedItem()
            java.lang.String r2 = r2.getSpecialRequest()
            r0.specialRequest = r2
            com.talabat.vendormenu.presentation.flutter.dto.UpdateItemArguments r2 = r11.getUpdatedItem()
            java.util.ArrayList r2 = r2.getSelectedChoiceSections()
            if (r2 == 0) goto L_0x0058
            com.talabat.vendormenu.presentation.flutter.dto.UpdateItemArguments r2 = r11.getUpdatedItem()
            java.util.ArrayList r2 = r2.getSelectedChoiceSections()
            java.util.Iterator r2 = r2.iterator()
        L_0x0048:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0058
            java.lang.Object r3 = r2.next()
            datamodels.ChoiceSection r3 = (datamodels.ChoiceSection) r3
            r0.setSelectedChoicesForSection(r3)
            goto L_0x0048
        L_0x0058:
            buisnessmodels.Cart r2 = buisnessmodels.Cart.getInstance()
            java.util.ArrayList r2 = r2.getCartItems()
            java.lang.String r3 = "getInstance().cartItems"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.util.Iterator r2 = r2.iterator()
        L_0x0069:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00e9
            java.lang.Object r3 = r2.next()
            r4 = r3
            datamodels.CartMenuItem r4 = (datamodels.CartMenuItem) r4
            java.lang.String r5 = r4.specialRequest
            com.talabat.vendormenu.presentation.flutter.dto.OriginalItemArguments r6 = r11.getOriginalItem()
            java.lang.String r6 = r6.getSpecialRequest()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            r6 = 1
            if (r5 != 0) goto L_0x00b0
            java.lang.String r5 = r4.specialRequest
            if (r5 == 0) goto L_0x0094
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0092
            goto L_0x0094
        L_0x0092:
            r5 = r1
            goto L_0x0095
        L_0x0094:
            r5 = r6
        L_0x0095:
            if (r5 == 0) goto L_0x00ae
            com.talabat.vendormenu.presentation.flutter.dto.OriginalItemArguments r5 = r11.getOriginalItem()
            java.lang.String r5 = r5.getSpecialRequest()
            if (r5 == 0) goto L_0x00aa
            int r5 = r5.length()
            if (r5 != 0) goto L_0x00a8
            goto L_0x00aa
        L_0x00a8:
            r5 = r1
            goto L_0x00ab
        L_0x00aa:
            r5 = r6
        L_0x00ab:
            if (r5 == 0) goto L_0x00ae
            goto L_0x00b0
        L_0x00ae:
            r5 = r1
            goto L_0x00b1
        L_0x00b0:
            r5 = r6
        L_0x00b1:
            java.lang.String r7 = "cartMenuItem"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            java.util.Set r7 = r10.getItemSelectedChoices(r4)
            com.talabat.vendormenu.presentation.flutter.dto.OriginalItemArguments r8 = r11.getOriginalItem()
            java.util.List r8 = r8.getChoices()
            if (r8 == 0) goto L_0x00cc
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Set r8 = kotlin.collections.CollectionsKt___CollectionsKt.toSet(r8)
            if (r8 != 0) goto L_0x00d0
        L_0x00cc:
            java.util.Set r8 = kotlin.collections.SetsKt__SetsKt.emptySet()
        L_0x00d0:
            int r4 = r4.f13861id
            com.talabat.vendormenu.presentation.flutter.dto.OriginalItemArguments r9 = r11.getOriginalItem()
            int r9 = r9.getMenuItemId()
            if (r4 != r9) goto L_0x00e5
            if (r5 == 0) goto L_0x00e5
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r4 == 0) goto L_0x00e5
            goto L_0x00e6
        L_0x00e5:
            r6 = r1
        L_0x00e6:
            if (r6 == 0) goto L_0x0069
            goto L_0x00ea
        L_0x00e9:
            r3 = 0
        L_0x00ea:
            datamodels.CartMenuItem r3 = (datamodels.CartMenuItem) r3
            java.lang.String r11 = "updatedMenuItem"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r11)
            r10.handleUpdateItem(r0, r3)
            buisnessmodels.Cart r11 = buisnessmodels.Cart.getInstance()
            r11.recalcualteTotal()
        L_0x00fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.vendormenu.presentation.flutter.channels.CartMethodChannel.updateItemFromCart(io.flutter.plugin.common.MethodCall):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        if (r3 != false) goto L_0x0051;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0082 A[EDGE_INSN: B:37:0x0082->B:34:0x0082 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateQuantity(com.talabat.vendormenu.presentation.flutter.dto.UpdateQuantityWrapperArguments r10) {
        /*
            r9 = this;
            buisnessmodels.Cart r0 = buisnessmodels.Cart.getInstance()
            java.util.ArrayList r0 = r0.getCartItems()
            java.lang.String r1 = "getInstance().cartItems"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.Iterator r0 = r0.iterator()
        L_0x0011:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0081
            java.lang.Object r1 = r0.next()
            r2 = r1
            datamodels.CartMenuItem r2 = (datamodels.CartMenuItem) r2
            java.lang.String r3 = r2.specialRequest
            java.lang.String r4 = r10.getSpecialRequest()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            r4 = 0
            r5 = 1
            if (r3 != 0) goto L_0x0051
            java.lang.String r3 = r2.specialRequest
            if (r3 == 0) goto L_0x0039
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r3 = r4
            goto L_0x003a
        L_0x0039:
            r3 = r5
        L_0x003a:
            if (r3 == 0) goto L_0x004f
            java.lang.String r3 = r10.getSpecialRequest()
            if (r3 == 0) goto L_0x004b
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r3 = r4
            goto L_0x004c
        L_0x004b:
            r3 = r5
        L_0x004c:
            if (r3 == 0) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            r3 = r4
            goto L_0x0052
        L_0x0051:
            r3 = r5
        L_0x0052:
            java.lang.String r6 = "cartMenuItem"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            java.util.Set r6 = r9.getItemSelectedChoices(r2)
            java.util.List r7 = r10.getChoices()
            if (r7 == 0) goto L_0x0069
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Set r7 = kotlin.collections.CollectionsKt___CollectionsKt.toSet(r7)
            if (r7 != 0) goto L_0x006d
        L_0x0069:
            java.util.Set r7 = kotlin.collections.SetsKt__SetsKt.emptySet()
        L_0x006d:
            int r2 = r2.f13861id
            int r8 = r10.getMenuItemId()
            if (r2 != r8) goto L_0x007e
            if (r3 == 0) goto L_0x007e
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r2 == 0) goto L_0x007e
            r4 = r5
        L_0x007e:
            if (r4 == 0) goto L_0x0011
            goto L_0x0082
        L_0x0081:
            r1 = 0
        L_0x0082:
            datamodels.CartMenuItem r1 = (datamodels.CartMenuItem) r1
            int r10 = r10.getQuantity()
            r9.handleItemUpdateQuantity(r1, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.vendormenu.presentation.flutter.channels.CartMethodChannel.updateQuantity(com.talabat.vendormenu.presentation.flutter.dto.UpdateQuantityWrapperArguments):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r1 == null) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateSelectedAutoAppliedDiscount(com.talabat.vendormenu.presentation.flutter.dto.UpdatedSelectedMenuDiscountCallArguments r4) {
        /*
            r3 = this;
            datamodels.mappers.AutoApplyDiscountCoupon r0 = new datamodels.mappers.AutoApplyDiscountCoupon
            r0.<init>()
            java.lang.String r1 = r4.getId()
            if (r1 == 0) goto L_0x001f
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r1)
            r2 = r2 ^ 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            if (r1 != 0) goto L_0x0021
        L_0x001f:
            java.lang.String r1 = "0"
        L_0x0021:
            r0.aadCampaignId = r1
            java.lang.Float r1 = r4.getDiscount()
            if (r1 == 0) goto L_0x002e
            float r1 = r1.floatValue()
            goto L_0x002f
        L_0x002e:
            r1 = 0
        L_0x002f:
            r0.discount = r1
            java.lang.String r4 = r4.getLabel()
            r0.marketingTitle = r4
            java.lang.String r4 = "AUTO_APPLIED_DISCOUNT"
            r0.aadDiscriminator = r4
            buisnessmodels.Cart r4 = buisnessmodels.Cart.getInstance()
            r4.setSelectedCoupon(r0)
            buisnessmodels.Cart r4 = buisnessmodels.Cart.getInstance()
            float r0 = r0.discount
            r4.couponDiscount = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.vendormenu.presentation.flutter.channels.CartMethodChannel.updateSelectedAutoAppliedDiscount(com.talabat.vendormenu.presentation.flutter.dto.UpdatedSelectedMenuDiscountCallArguments):void");
    }

    private final void updateSelectedCoupon(UpdatedSelectedMenuDiscountCallArguments updatedSelectedMenuDiscountCallArguments) {
        int i11;
        float f11;
        Integer intOrNull;
        Coupon coupon = new Coupon();
        String id2 = updatedSelectedMenuDiscountCallArguments.getId();
        if (id2 == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(id2)) == null) {
            i11 = 0;
        } else {
            i11 = intOrNull.intValue();
        }
        coupon.f13847id = i11;
        Float discount = updatedSelectedMenuDiscountCallArguments.getDiscount();
        if (discount != null) {
            f11 = discount.floatValue();
        } else {
            f11 = 0.0f;
        }
        coupon.discount = f11;
        coupon.marketingTitle = updatedSelectedMenuDiscountCallArguments.getLabel();
        Cart.getInstance().setSelectedCoupon(coupon);
        Cart.getInstance().couponDiscount = coupon.discount;
    }

    private final void updateSelectedMenuDiscount(UpdatedSelectedMenuDiscountCallArguments updatedSelectedMenuDiscountCallArguments) {
        if (updatedSelectedMenuDiscountCallArguments.getId() == null && updatedSelectedMenuDiscountCallArguments.getLabel() == null) {
            deSelectMenuDiscount();
            return;
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[updatedSelectedMenuDiscountCallArguments.getDiscountType().ordinal()];
        if (i11 == 1) {
            updateSelectedCoupon(updatedSelectedMenuDiscountCallArguments);
        } else if (i11 == 2) {
            updateSelectedAutoAppliedDiscount(updatedSelectedMenuDiscountCallArguments);
        } else if (i11 == 3) {
            updateSelectedPromotion(updatedSelectedMenuDiscountCallArguments);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008d, code lost:
        if (r8 == null) goto L_0x008f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateSelectedPromotion(com.talabat.vendormenu.presentation.flutter.dto.UpdatedSelectedMenuDiscountCallArguments r8) {
        /*
            r7 = this;
            buisnessmodels.Cart r0 = buisnessmodels.Cart.getInstance()
            datamodels.Promotion r1 = new datamodels.Promotion
            r1.<init>()
            java.lang.String r2 = r8.getId()
            r3 = 0
            if (r2 == 0) goto L_0x001b
            java.lang.Integer r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2)
            if (r2 == 0) goto L_0x001b
            int r2 = r2.intValue()
            goto L_0x001c
        L_0x001b:
            r2 = r3
        L_0x001c:
            r1.f13866id = r2
            java.lang.String r2 = r8.getLabel()
            r1.marketingTitle = r2
            java.util.List r8 = r8.getBenefitItems()
            if (r8 == 0) goto L_0x008f
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r2 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r8, r4)
            r2.<init>(r4)
            java.util.Iterator r8 = r8.iterator()
        L_0x003b:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r8.next()
            com.talabat.vendormenu.presentation.flutter.dto.BenefitItemArguments r4 = (com.talabat.vendormenu.presentation.flutter.dto.BenefitItemArguments) r4
            datamodels.BenefitItem r5 = new datamodels.BenefitItem
            r5.<init>()
            java.lang.Integer r6 = r4.getId()
            if (r6 == 0) goto L_0x0057
            int r6 = r6.intValue()
            goto L_0x0058
        L_0x0057:
            r6 = r3
        L_0x0058:
            r5.f13836id = r6
            java.lang.String r6 = r4.getLabel()
            r5.f13837name = r6
            java.lang.String r6 = r4.getMenuItemId()
            if (r6 == 0) goto L_0x006b
            int r6 = java.lang.Integer.parseInt(r6)
            goto L_0x006c
        L_0x006b:
            r6 = r3
        L_0x006c:
            r5.itemId = r6
            java.lang.Boolean r4 = r4.isSelected()
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r4 == 0) goto L_0x007c
            r1.selectedBenefitItem = r5
        L_0x007c:
            r2.add(r5)
            goto L_0x003b
        L_0x0080:
            datamodels.BenefitItem[] r8 = new datamodels.BenefitItem[r3]
            java.lang.Object[] r8 = r2.toArray(r8)
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r2)
            datamodels.BenefitItem[] r8 = (datamodels.BenefitItem[]) r8
            if (r8 != 0) goto L_0x0091
        L_0x008f:
            datamodels.BenefitItem[] r8 = new datamodels.BenefitItem[r3]
        L_0x0091:
            r1.benefitItems = r8
            r2 = 1
            r1.isSelected = r2
            r1.isAvailable = r2
            r4 = 0
            r1.conditionAmount = r4
            java.lang.String r4 = "promotion.benefitItems"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r4)
            int r8 = r8.length
            if (r8 != 0) goto L_0x00a4
            r3 = r2
        L_0x00a4:
            r8 = r3 ^ 1
            r1.isBenefitListOfItems = r8
            r0.setSelectedPromotion(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.vendormenu.presentation.flutter.channels.CartMethodChannel.updateSelectedPromotion(com.talabat.vendormenu.presentation.flutter.dto.UpdatedSelectedMenuDiscountCallArguments):void");
    }

    private final void updateSpecialRequest(UpdateSpecialRequestWrapperArguments updateSpecialRequestWrapperArguments) {
        Cart.getInstance().setGeneralRequest(updateSpecialRequestWrapperArguments.getSpecialRequest());
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        LogManager.debug("CartMethodChannel onMethodCall: method: " + str);
        String str2 = methodCall.method;
        if (str2 != null) {
            switch (str2.hashCode()) {
                case -1628100569:
                    if (str2.equals(UPDATE_QUANTITY)) {
                        updateQuantity((UpdateQuantityWrapperArguments) extractArgs(methodCall, UpdateQuantityWrapperArguments.class));
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case -1588271738:
                    if (str2.equals(UPDATE_ITEM_FROM_CART)) {
                        updateItemFromCart(methodCall);
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case -472176449:
                    if (str2.equals(UPDATE_SPECIAL_REQUEST)) {
                        updateSpecialRequest((UpdateSpecialRequestWrapperArguments) extractArgs(methodCall, UpdateSpecialRequestWrapperArguments.class));
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case -367342151:
                    if (str2.equals(UPDATE_CUTLERY)) {
                        updateCutlery((UpdateCutleryWrapperArguments) extractArgs(methodCall, UpdateCutleryWrapperArguments.class));
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case -289574838:
                    if (str2.equals(UPDATE_DELIVERY_TIME)) {
                        updateDeliveryTimeValue(methodCall);
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case 23457852:
                    if (str2.equals(ADD_T0_CART)) {
                        addArgumentsToCart((AddToCartWrapperArguments) extractArgs(methodCall, AddToCartWrapperArguments.class));
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case 304639253:
                    if (str2.equals(REMOVE_APPLIED_VOUCHER)) {
                        removeAppliedVoucher();
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case 506301280:
                    if (str2.equals(APPLY_VOUCHER)) {
                        applyVoucher((ApplyVoucherCallArguments) extractArgs(methodCall, ApplyVoucherCallArguments.class));
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case 1175260555:
                    if (str2.equals(UPDATE_SELECTED_MENU_DISCOUNT)) {
                        updateSelectedMenuDiscount((UpdatedSelectedMenuDiscountCallArguments) extractArgs(methodCall, UpdatedSelectedMenuDiscountCallArguments.class));
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case 2023279887:
                    if (str2.equals(RESET_CART)) {
                        Cart.getInstance().clearCart(this.context);
                        result.success(Boolean.TRUE);
                        return;
                    }
                    break;
                case 2084110692:
                    if (str2.equals(GET_CART)) {
                        result.success(getCartInformation());
                        return;
                    }
                    break;
            }
        }
        Reflection.getOrCreateKotlinClass(CartMethodChannel.class).getSimpleName();
        result.notImplemented();
    }

    public final void setContext(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }
}
