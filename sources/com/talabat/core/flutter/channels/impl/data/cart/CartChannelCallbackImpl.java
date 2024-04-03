package com.talabat.core.flutter.channels.impl.data.cart;

import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherRM;
import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherResult;
import android.content.Context;
import buisnessmodels.Cart;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.flutter.channels.domain.cart.CartChannelCallback;
import com.talabat.core.flutter.channels.impl.data.cart.dto.AddToCartCallArguments;
import com.talabat.core.flutter.channels.impl.data.cart.dto.ApplyVoucherCallArguments;
import com.talabat.core.flutter.channels.impl.data.cart.dto.CartItemArguments;
import com.talabat.core.flutter.channels.impl.data.cart.dto.FlutterCartKt;
import com.talabat.core.flutter.channels.impl.data.cart.dto.MenuDiscountTypeArgument;
import com.talabat.core.flutter.channels.impl.data.cart.dto.UpdateCutleryWrapperArguments;
import com.talabat.core.flutter.channels.impl.data.cart.dto.UpdateDeliveryTimeArguments;
import com.talabat.core.flutter.channels.impl.data.cart.dto.UpdateSpecialRequestWrapperArguments;
import com.talabat.core.flutter.channels.impl.data.cart.dto.UpdatedSelectedMenuDiscountCallArguments;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.extentions.GsonKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.ApplyVoucherViewModelMapperKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DiscountType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDataKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import datamodels.CartMenuItem;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import datamodels.Coupon;
import datamodels.MenuItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000eH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\"\u0010\u0015\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0002J\"\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u001e\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\u001f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\t\u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020!H\u0002J\u0012\u0010#\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020!H\u0002J\u0012\u0010%\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006&"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/cart/CartChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/cart/CartChannelCallback;", "()V", "addToCart", "", "cartItem", "Lcom/talabat/core/flutter/channels/impl/data/cart/dto/CartItemArguments;", "context", "Landroid/content/Context;", "arguments", "", "applyVoucher", "deSelectMenuDiscount", "getCartInformation", "", "", "getItemSelectedChoices", "", "", "cartMenuItem", "Ldatamodels/CartMenuItem;", "handleItemUpdateQuantity", "updatedQuantity", "handleUpdateItem", "updatedMenuItem", "originalMenuItem", "removeAppliedVoucher", "resetCart", "updateCutlery", "updateDeliveryTimeValue", "updateItemFromCart", "updateQuantity", "updateSelectedAutoAppliedDiscount", "Lcom/talabat/core/flutter/channels/impl/data/cart/dto/UpdatedSelectedMenuDiscountCallArguments;", "updateSelectedCoupon", "updateSelectedMenuDiscount", "updateSelectedPromotion", "updateSpecialRequest", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartChannelCallbackImpl implements CartChannelCallback {

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

    private final void deSelectMenuDiscount() {
        Cart.getInstance().deSelectPromotion();
        Cart.getInstance().deSelectCoupon();
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

    private final void handleItemUpdateQuantity(CartMenuItem cartMenuItem, int i11, Context context) {
        if (cartMenuItem == null) {
            return;
        }
        if (i11 > 0) {
            cartMenuItem.setQuantity(i11);
            Cart.getInstance().updateItemQuantity(cartMenuItem, context);
            return;
        }
        int indexOf = Cart.getInstance().getCartItems().indexOf(cartMenuItem);
        if (indexOf > -1) {
            Cart.getInstance().deleteItemAtPostion(indexOf, context);
        }
    }

    private final void handleUpdateItem(CartMenuItem cartMenuItem, CartMenuItem cartMenuItem2, Context context) {
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
            Cart.getInstance().deleteItemAtPostion(Cart.getInstance().getCartItems().indexOf(cartMenuItem2), context);
            Cart.getInstance().addItem(cartMenuItem, context);
        } else if (!Cart.getInstance().mergeItemExistsInCart(cartMenuItem)) {
            Cart.getInstance().deleteItemAtPostion(Cart.getInstance().getCartItems().indexOf(cartMenuItem2), context);
            Cart.getInstance().addItem(cartMenuItem, context);
        } else if (cartMenuItem2 != null) {
            Cart.getInstance().getCartItems().remove(cartMenuItem2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r1 == null) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateSelectedAutoAppliedDiscount(com.talabat.core.flutter.channels.impl.data.cart.dto.UpdatedSelectedMenuDiscountCallArguments r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.impl.data.cart.CartChannelCallbackImpl.updateSelectedAutoAppliedDiscount(com.talabat.core.flutter.channels.impl.data.cart.dto.UpdatedSelectedMenuDiscountCallArguments):void");
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

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008d, code lost:
        if (r8 == null) goto L_0x008f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateSelectedPromotion(com.talabat.core.flutter.channels.impl.data.cart.dto.UpdatedSelectedMenuDiscountCallArguments r8) {
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
            com.talabat.core.flutter.channels.impl.data.cart.dto.BenefitItemArguments r4 = (com.talabat.core.flutter.channels.impl.data.cart.dto.BenefitItemArguments) r4
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.impl.data.cart.CartChannelCallbackImpl.updateSelectedPromotion(com.talabat.core.flutter.channels.impl.data.cart.dto.UpdatedSelectedMenuDiscountCallArguments):void");
    }

    public void addToCart(@Nullable Object obj, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Gson gson = GsonKt.getGson();
        String json$default = GsonKt.toJson$default(obj, (Gson) null, 1, (Object) null);
        Class cls = AddToCartCallArguments.class;
        AddToCartCallArguments addToCartCallArguments = (AddToCartCallArguments) (!(gson instanceof Gson) ? gson.fromJson(json$default, cls) : GsonInstrumentation.fromJson(gson, json$default, cls));
        Cart instance = Cart.getInstance();
        instance.setRestaurant(GlobalDataModel.SELECTED.getRestaurant(), context);
        String deliveryMode = addToCartCallArguments.getDeliveryMode();
        if (deliveryMode == null) {
            deliveryMode = "Delivery Error Mode";
        }
        instance.setDeliveryMode(deliveryMode);
        ArrayList<CartItemArguments> cartItems = addToCartCallArguments.getCartItems();
        if (cartItems != null) {
            for (CartItemArguments addToCart : cartItems) {
                addToCart(addToCart, context);
            }
        }
    }

    public void applyVoucher(@Nullable Object obj, @NotNull Context context) {
        Object obj2;
        Bounds bounds;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        Gson gson = GsonKt.getGson();
        String json$default = GsonKt.toJson$default(obj, (Gson) null, 1, (Object) null);
        Class cls = ApplyVoucherCallArguments.class;
        if (!(gson instanceof Gson)) {
            obj2 = gson.fromJson(json$default, cls);
        } else {
            obj2 = GsonInstrumentation.fromJson(gson, json$default, cls);
        }
        ApplyVoucherCallArguments applyVoucherCallArguments = (ApplyVoucherCallArguments) obj2;
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
        Cart.getInstance().saveLoyaltyVoucher(context2, loyaltyVoucherRM);
        Cart.getInstance().calculateLoyaltyDiscount(context2);
    }

    @NotNull
    public Map<String, Object> getCartInformation() {
        Cart instance = Cart.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return FlutterCartKt.toMap(instance);
    }

    public void removeAppliedVoucher() {
        Cart.getInstance().removeLoyaltyVoucherIfAvailable();
        Cart.getInstance().removeVoucherIfApplied();
    }

    public void resetCart(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Cart.getInstance().clearCart(context);
    }

    public void updateCutlery(@Nullable Object obj) {
        Object obj2;
        Gson gson = GsonKt.getGson();
        String json$default = GsonKt.toJson$default(obj, (Gson) null, 1, (Object) null);
        Class cls = UpdateCutleryWrapperArguments.class;
        if (!(gson instanceof Gson)) {
            obj2 = gson.fromJson(json$default, cls);
        } else {
            obj2 = GsonInstrumentation.fromJson(gson, json$default, cls);
        }
        Cart.getInstance().setGoGreenSelection(!((UpdateCutleryWrapperArguments) obj2).getCutleryValue());
    }

    public void updateDeliveryTimeValue(@Nullable Object obj) {
        Object obj2;
        Gson gson = GsonKt.getGson();
        boolean z11 = true;
        String json$default = GsonKt.toJson$default(obj, (Gson) null, 1, (Object) null);
        Class cls = UpdateDeliveryTimeArguments.class;
        if (!(gson instanceof Gson)) {
            obj2 = gson.fromJson(json$default, cls);
        } else {
            obj2 = GsonInstrumentation.fromJson(gson, json$default, cls);
        }
        UpdateDeliveryTimeArguments updateDeliveryTimeArguments = (UpdateDeliveryTimeArguments) obj2;
        String deliveryTime = updateDeliveryTimeArguments.getDeliveryTime();
        if (!(deliveryTime == null || deliveryTime.length() == 0)) {
            z11 = false;
        }
        if (!z11) {
            Cart.getInstance().getRestaurant().deliveryTime = updateDeliveryTimeArguments.getDeliveryTime();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c2, code lost:
        if (r7 != false) goto L_0x00c7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0100 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateItemFromCart(@org.jetbrains.annotations.Nullable java.lang.Object r12, @org.jetbrains.annotations.NotNull android.content.Context r13) {
        /*
            r11 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            com.google.gson.Gson r0 = com.talabat.talabatcommon.extentions.GsonKt.getGson()
            r1 = 0
            r2 = 1
            java.lang.String r12 = com.talabat.talabatcommon.extentions.GsonKt.toJson$default(r12, r1, r2, r1)
            boolean r3 = r0 instanceof com.google.gson.Gson
            java.lang.Class<com.talabat.core.flutter.channels.impl.data.cart.dto.UpdateItemFromCartArguments> r4 = com.talabat.core.flutter.channels.impl.data.cart.dto.UpdateItemFromCartArguments.class
            if (r3 != 0) goto L_0x001a
            java.lang.Object r12 = r0.fromJson((java.lang.String) r12, r4)
            goto L_0x001e
        L_0x001a:
            java.lang.Object r12 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r0, (java.lang.String) r12, r4)
        L_0x001e:
            com.talabat.core.flutter.channels.impl.data.cart.dto.UpdateItemFromCartArguments r12 = (com.talabat.core.flutter.channels.impl.data.cart.dto.UpdateItemFromCartArguments) r12
            com.talabat.core.flutter.channels.impl.data.cart.dto.UpdateItemArguments r0 = r12.getUpdatedItem()
            datamodels.MenuItem r0 = r0.getMenuItem()
            if (r0 == 0) goto L_0x0113
            datamodels.CartMenuItem r0 = datamodels.CartMenuItem.createWithMenuItem(r0)
            r3 = 0
            datamodels.ChoiceSection[] r4 = new datamodels.ChoiceSection[r3]
            r0.choiceSections = r4
            com.talabat.helpers.GlobalDataModel.SELECTED.cartMenuItem = r0
            com.talabat.core.flutter.channels.impl.data.cart.dto.UpdateItemArguments r4 = r12.getUpdatedItem()
            int r4 = r4.getQuantity()
            r0.setQuantity(r4)
            com.talabat.core.flutter.channels.impl.data.cart.dto.UpdateItemArguments r4 = r12.getUpdatedItem()
            java.lang.String r4 = r4.getSpecialRequest()
            r0.specialRequest = r4
            com.talabat.core.flutter.channels.impl.data.cart.dto.UpdateItemArguments r4 = r12.getUpdatedItem()
            java.util.ArrayList r4 = r4.getSelectedChoiceSections()
            if (r4 == 0) goto L_0x0070
            com.talabat.core.flutter.channels.impl.data.cart.dto.UpdateItemArguments r4 = r12.getUpdatedItem()
            java.util.ArrayList r4 = r4.getSelectedChoiceSections()
            java.util.Iterator r4 = r4.iterator()
        L_0x0060:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0070
            java.lang.Object r5 = r4.next()
            datamodels.ChoiceSection r5 = (datamodels.ChoiceSection) r5
            r0.setSelectedChoicesForSection(r5)
            goto L_0x0060
        L_0x0070:
            buisnessmodels.Cart r4 = buisnessmodels.Cart.getInstance()
            java.util.ArrayList r4 = r4.getCartItems()
            java.lang.String r5 = "getInstance().cartItems"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.util.Iterator r4 = r4.iterator()
        L_0x0081:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0101
            java.lang.Object r5 = r4.next()
            r6 = r5
            datamodels.CartMenuItem r6 = (datamodels.CartMenuItem) r6
            java.lang.String r7 = r6.specialRequest
            com.talabat.core.flutter.channels.impl.data.cart.dto.OriginalItemArguments r8 = r12.getOriginalItem()
            java.lang.String r8 = r8.getSpecialRequest()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 != 0) goto L_0x00c7
            java.lang.String r7 = r6.specialRequest
            if (r7 == 0) goto L_0x00ab
            int r7 = r7.length()
            if (r7 != 0) goto L_0x00a9
            goto L_0x00ab
        L_0x00a9:
            r7 = r3
            goto L_0x00ac
        L_0x00ab:
            r7 = r2
        L_0x00ac:
            if (r7 == 0) goto L_0x00c5
            com.talabat.core.flutter.channels.impl.data.cart.dto.OriginalItemArguments r7 = r12.getOriginalItem()
            java.lang.String r7 = r7.getSpecialRequest()
            if (r7 == 0) goto L_0x00c1
            int r7 = r7.length()
            if (r7 != 0) goto L_0x00bf
            goto L_0x00c1
        L_0x00bf:
            r7 = r3
            goto L_0x00c2
        L_0x00c1:
            r7 = r2
        L_0x00c2:
            if (r7 == 0) goto L_0x00c5
            goto L_0x00c7
        L_0x00c5:
            r7 = r3
            goto L_0x00c8
        L_0x00c7:
            r7 = r2
        L_0x00c8:
            java.lang.String r8 = "cartMenuItem"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)
            java.util.Set r8 = r11.getItemSelectedChoices(r6)
            com.talabat.core.flutter.channels.impl.data.cart.dto.OriginalItemArguments r9 = r12.getOriginalItem()
            java.util.List r9 = r9.getChoices()
            if (r9 == 0) goto L_0x00e3
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Set r9 = kotlin.collections.CollectionsKt___CollectionsKt.toSet(r9)
            if (r9 != 0) goto L_0x00e7
        L_0x00e3:
            java.util.Set r9 = kotlin.collections.SetsKt__SetsKt.emptySet()
        L_0x00e7:
            int r6 = r6.f13861id
            com.talabat.core.flutter.channels.impl.data.cart.dto.OriginalItemArguments r10 = r12.getOriginalItem()
            int r10 = r10.getMenuItemId()
            if (r6 != r10) goto L_0x00fd
            if (r7 == 0) goto L_0x00fd
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r6 == 0) goto L_0x00fd
            r6 = r2
            goto L_0x00fe
        L_0x00fd:
            r6 = r3
        L_0x00fe:
            if (r6 == 0) goto L_0x0081
            r1 = r5
        L_0x0101:
            datamodels.CartMenuItem r1 = (datamodels.CartMenuItem) r1
            java.lang.String r12 = "updatedMenuItem"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r12)
            r11.handleUpdateItem(r0, r1, r13)
            buisnessmodels.Cart r12 = buisnessmodels.Cart.getInstance()
            r12.recalcualteTotal()
        L_0x0113:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.impl.data.cart.CartChannelCallbackImpl.updateItemFromCart(java.lang.Object, android.content.Context):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006b, code lost:
        if (r5 != false) goto L_0x0070;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateQuantity(@org.jetbrains.annotations.Nullable java.lang.Object r11, @org.jetbrains.annotations.NotNull android.content.Context r12) {
        /*
            r10 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            com.google.gson.Gson r0 = com.talabat.talabatcommon.extentions.GsonKt.getGson()
            r1 = 0
            r2 = 1
            java.lang.String r11 = com.talabat.talabatcommon.extentions.GsonKt.toJson$default(r11, r1, r2, r1)
            boolean r3 = r0 instanceof com.google.gson.Gson
            java.lang.Class<com.talabat.core.flutter.channels.impl.data.cart.dto.UpdateQuantityWrapperArguments> r4 = com.talabat.core.flutter.channels.impl.data.cart.dto.UpdateQuantityWrapperArguments.class
            if (r3 != 0) goto L_0x001a
            java.lang.Object r11 = r0.fromJson((java.lang.String) r11, r4)
            goto L_0x001e
        L_0x001a:
            java.lang.Object r11 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r0, (java.lang.String) r11, r4)
        L_0x001e:
            com.talabat.core.flutter.channels.impl.data.cart.dto.UpdateQuantityWrapperArguments r11 = (com.talabat.core.flutter.channels.impl.data.cart.dto.UpdateQuantityWrapperArguments) r11
            buisnessmodels.Cart r0 = buisnessmodels.Cart.getInstance()
            java.util.ArrayList r0 = r0.getCartItems()
            java.lang.String r3 = "getInstance().cartItems"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.util.Iterator r0 = r0.iterator()
        L_0x0031:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00a0
            java.lang.Object r3 = r0.next()
            r4 = r3
            datamodels.CartMenuItem r4 = (datamodels.CartMenuItem) r4
            java.lang.String r5 = r4.specialRequest
            java.lang.String r6 = r11.getSpecialRequest()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            r6 = 0
            if (r5 != 0) goto L_0x0070
            java.lang.String r5 = r4.specialRequest
            if (r5 == 0) goto L_0x0058
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0056
            goto L_0x0058
        L_0x0056:
            r5 = r6
            goto L_0x0059
        L_0x0058:
            r5 = r2
        L_0x0059:
            if (r5 == 0) goto L_0x006e
            java.lang.String r5 = r11.getSpecialRequest()
            if (r5 == 0) goto L_0x006a
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0068
            goto L_0x006a
        L_0x0068:
            r5 = r6
            goto L_0x006b
        L_0x006a:
            r5 = r2
        L_0x006b:
            if (r5 == 0) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            r5 = r6
            goto L_0x0071
        L_0x0070:
            r5 = r2
        L_0x0071:
            java.lang.String r7 = "cartMenuItem"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            java.util.Set r7 = r10.getItemSelectedChoices(r4)
            java.util.List r8 = r11.getChoices()
            if (r8 == 0) goto L_0x0088
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Set r8 = kotlin.collections.CollectionsKt___CollectionsKt.toSet(r8)
            if (r8 != 0) goto L_0x008c
        L_0x0088:
            java.util.Set r8 = kotlin.collections.SetsKt__SetsKt.emptySet()
        L_0x008c:
            int r4 = r4.f13861id
            int r9 = r11.getMenuItemId()
            if (r4 != r9) goto L_0x009d
            if (r5 == 0) goto L_0x009d
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r4 == 0) goto L_0x009d
            r6 = r2
        L_0x009d:
            if (r6 == 0) goto L_0x0031
            r1 = r3
        L_0x00a0:
            datamodels.CartMenuItem r1 = (datamodels.CartMenuItem) r1
            int r11 = r11.getQuantity()
            r10.handleItemUpdateQuantity(r1, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.impl.data.cart.CartChannelCallbackImpl.updateQuantity(java.lang.Object, android.content.Context):void");
    }

    public void updateSelectedMenuDiscount(@Nullable Object obj) {
        Object obj2;
        Gson gson = GsonKt.getGson();
        String json$default = GsonKt.toJson$default(obj, (Gson) null, 1, (Object) null);
        Class cls = UpdatedSelectedMenuDiscountCallArguments.class;
        if (!(gson instanceof Gson)) {
            obj2 = gson.fromJson(json$default, cls);
        } else {
            obj2 = GsonInstrumentation.fromJson(gson, json$default, cls);
        }
        UpdatedSelectedMenuDiscountCallArguments updatedSelectedMenuDiscountCallArguments = (UpdatedSelectedMenuDiscountCallArguments) obj2;
        if (updatedSelectedMenuDiscountCallArguments.getId() == null && updatedSelectedMenuDiscountCallArguments.getLabel() == null) {
            deSelectMenuDiscount();
            return;
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[updatedSelectedMenuDiscountCallArguments.getDiscountType().ordinal()];
        if (i11 == 1) {
            Intrinsics.checkNotNullExpressionValue(updatedSelectedMenuDiscountCallArguments, StepData.ARGS);
            updateSelectedCoupon(updatedSelectedMenuDiscountCallArguments);
        } else if (i11 == 2) {
            Intrinsics.checkNotNullExpressionValue(updatedSelectedMenuDiscountCallArguments, StepData.ARGS);
            updateSelectedAutoAppliedDiscount(updatedSelectedMenuDiscountCallArguments);
        } else if (i11 == 3) {
            Intrinsics.checkNotNullExpressionValue(updatedSelectedMenuDiscountCallArguments, StepData.ARGS);
            updateSelectedPromotion(updatedSelectedMenuDiscountCallArguments);
        }
    }

    public void updateSpecialRequest(@Nullable Object obj) {
        Object obj2;
        Gson gson = GsonKt.getGson();
        String json$default = GsonKt.toJson$default(obj, (Gson) null, 1, (Object) null);
        Class cls = UpdateSpecialRequestWrapperArguments.class;
        if (!(gson instanceof Gson)) {
            obj2 = gson.fromJson(json$default, cls);
        } else {
            obj2 = GsonInstrumentation.fromJson(gson, json$default, cls);
        }
        Cart.getInstance().setGeneralRequest(((UpdateSpecialRequestWrapperArguments) obj2).getSpecialRequest());
    }

    private final void addToCart(CartItemArguments cartItemArguments, Context context) {
        if (Intrinsics.areEqual((Object) cartItemArguments.isFromUpsell(), (Object) Boolean.TRUE)) {
            MenuItem menuItem = cartItemArguments.getMenuItem();
            if (menuItem != null) {
                menuItem.choiceSections = null;
            }
            Cart.getInstance().addUpsellingItem(cartItemArguments.getMenuItem(), context);
            return;
        }
        CartMenuItem createWithMenuItem = CartMenuItem.createWithMenuItem(cartItemArguments.getMenuItem());
        createWithMenuItem.choiceSections = new ChoiceSection[0];
        GlobalDataModel.SELECTED.cartMenuItem = createWithMenuItem;
        createWithMenuItem.setQuantity(cartItemArguments.getQuantity());
        createWithMenuItem.specialRequest = cartItemArguments.getSpecialRequest();
        if (cartItemArguments.getSelectedChoiceSections() != null) {
            for (ChoiceSection selectedChoicesForSection : cartItemArguments.getSelectedChoiceSections()) {
                createWithMenuItem.setSelectedChoicesForSection(selectedChoicesForSection);
            }
        }
        Cart.getInstance().addItem(createWithMenuItem, context);
    }
}
