package com.talabat.itemdetailsbottomsheet;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatEditText;
import com.talabat.TalabatTextView;
import com.talabat.designhelpers.GlideActivityExceptionHandler;
import com.talabat.helpers.RoundedCornersTransformation;
import com.talabat.itemdetailsbottomsheet.viewmodel.ItemDetailsVMBuilder;
import com.talabat.itemdetailsbottomsheet.viewmodel.ItemDetailsViewModel;
import com.talabat.lib.Integration;
import com.talabat.talabatcommon.helpers.GlideApp;
import com.talabat.talabatcommon.helpers.GlideRequests;
import com.talabat.talabatcommon.helpers.TalabatGlideModule;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcore.TalabatBaseMvvmBottomSheetDialogFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import datamodels.CartMenuItem;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ns.a;
import ns.b;
import ns.c;
import ns.d;
import ns.e;
import ns.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001PB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010 \u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0006H\u0002J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0016J\b\u0010'\u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020\u001cH\u0002J\b\u0010)\u001a\u00020\u001cH\u0016J\u0012\u0010*\u001a\u00020\u001c2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u00105\u001a\u00020\u001c2\u0006\u00104\u001a\u00020.H\u0002J\u0017\u00106\u001a\u00020\u001c2\b\u00107\u001a\u0004\u0018\u000108H\u0002¢\u0006\u0002\u00109J\u0010\u0010:\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0006H\u0002J\u0012\u0010;\u001a\u00020\u001c2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010?\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020=H\u0002J\u0017\u0010A\u001a\u00020\u001c2\b\u0010B\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010CJ\u0010\u0010D\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\u0012H\u0002J\u0010\u0010E\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0006H\u0002J\u0010\u0010F\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010G\u001a\u00020\u001c2\u0006\u00104\u001a\u00020.J\u0018\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010=J\b\u0010L\u001a\u00020\u001cH\u0002J\u0010\u0010M\u001a\u00020\u001c2\u0006\u0010N\u001a\u00020=H\u0002J\b\u0010O\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012XD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006Q"}, d2 = {"Lcom/talabat/itemdetailsbottomsheet/ItemDetailsBottomSheet;", "Lcom/talabat/talabatcore/TalabatBaseMvvmBottomSheetDialogFragment;", "Lcom/talabat/itemdetailsbottomsheet/viewmodel/ItemDetailsViewModel;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "()V", "cartMenuItem", "Ldatamodels/CartMenuItem;", "getCartMenuItem", "()Ldatamodels/CartMenuItem;", "setCartMenuItem", "(Ldatamodels/CartMenuItem;)V", "interactionListener", "Lcom/talabat/itemdetailsbottomsheet/ItemDetailsCallbacks;", "getInteractionListener", "()Lcom/talabat/itemdetailsbottomsheet/ItemDetailsCallbacks;", "setInteractionListener", "(Lcom/talabat/itemdetailsbottomsheet/ItemDetailsCallbacks;)V", "maxLength", "", "getMaxLength", "()I", "shouldDisableSpecialRequest", "", "getShouldDisableSpecialRequest", "()Z", "setShouldDisableSpecialRequest", "(Z)V", "closeBottomSheetFromDialog", "", "doNoImageAdjustments", "imageView", "Landroid/widget/ImageView;", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getItemImage", "item", "getViewModelClass", "Ljava/lang/Class;", "hideLoading", "initializeViews", "observatory", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setBottomSheetHeight", "setChangedPrices", "newPrice", "", "(Ljava/lang/Float;)V", "setClickListeners", "setImageHeader", "imageUrl", "", "setPrice", "setPriceToTextViews", "displayPrice", "setQuantity", "quantity", "(Ljava/lang/Integer;)V", "setQuantityToTextView", "setSpecialRequestTextWatcher", "setSpecialRequestView", "setup", "showDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "showLoading", "showOldPrice", "price", "viewModelBuilder", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ItemDetailsBottomSheet extends TalabatBaseMvvmBottomSheetDialogFragment<ItemDetailsViewModel> implements AnimationHelper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_CART_MENU_ITEM = "cartMenuItem";
    @NotNull
    public static final String EXTRA_DISABLE_SPECIAL_REQUEST = "shouldDisableSpecialRequest";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private CartMenuItem cartMenuItem = new CartMenuItem();
    @Nullable
    private ItemDetailsCallbacks interactionListener;
    private final int maxLength = 200;
    private boolean shouldDisableSpecialRequest;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0006\u001a\u00070\u0007¢\u0006\u0002\b\b2\u000b\u0010\t\u001a\u00070\n¢\u0006\u0002\b\b2\u0006\u0010\u000b\u001a\u00020\f2\u000b\u0010\r\u001a\u00070\u000e¢\u0006\u0002\b\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/itemdetailsbottomsheet/ItemDetailsBottomSheet$Companion;", "", "()V", "EXTRA_CART_MENU_ITEM", "", "EXTRA_DISABLE_SPECIAL_REQUEST", "newInstance", "Lcom/talabat/itemdetailsbottomsheet/ItemDetailsBottomSheet;", "Lorg/jetbrains/annotations/NotNull;", "cartMenuItem", "Ldatamodels/CartMenuItem;", "shouldDisableSpecialRequest", "", "interactionListener", "Lcom/talabat/itemdetailsbottomsheet/ItemDetailsCallbacks;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ItemDetailsBottomSheet newInstance(@NotNull CartMenuItem cartMenuItem, boolean z11, @NotNull ItemDetailsCallbacks itemDetailsCallbacks) {
            Intrinsics.checkNotNullParameter(cartMenuItem, ItemDetailsBottomSheet.EXTRA_CART_MENU_ITEM);
            Intrinsics.checkNotNullParameter(itemDetailsCallbacks, "interactionListener");
            ItemDetailsBottomSheet itemDetailsBottomSheet = new ItemDetailsBottomSheet();
            itemDetailsBottomSheet.setInteractionListener(itemDetailsCallbacks);
            Bundle bundle = new Bundle();
            bundle.putParcelable(ItemDetailsBottomSheet.EXTRA_CART_MENU_ITEM, cartMenuItem);
            bundle.putBoolean(ItemDetailsBottomSheet.EXTRA_DISABLE_SPECIAL_REQUEST, z11);
            itemDetailsBottomSheet.setArguments(bundle);
            return itemDetailsBottomSheet;
        }
    }

    private final void closeBottomSheetFromDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            int i11 = R.id.itemdetails_bottom_sheet;
            RelativeLayout relativeLayout = (RelativeLayout) dialog.findViewById(i11);
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "it.itemdetails_bottom_sheet");
            adjustViewHeight(relativeLayout, ((RelativeLayout) dialog.findViewById(i11)).getHeight(), 0, AnimationSpeed.NORMAL);
            dialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void doNoImageAdjustments(ImageView imageView) {
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        int i11 = R.id.item_name;
        ViewGroup.LayoutParams layoutParams = ((TalabatTextView) _$_findCachedViewById(i11)).getLayoutParams();
        if (layoutParams != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            int i12 = R.id.close_bottomsheet;
            int intrinsicHeight = ((ImageView) _$_findCachedViewById(i12)).getDrawable().getIntrinsicHeight();
            ViewGroup.LayoutParams layoutParams3 = ((ImageView) _$_findCachedViewById(i12)).getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams2.setMargins(layoutParams2.leftMargin, intrinsicHeight + (((RelativeLayout.LayoutParams) layoutParams3).topMargin * 2), layoutParams2.rightMargin, layoutParams2.bottomMargin);
                ((TalabatTextView) _$_findCachedViewById(i11)).setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    private final void getItemImage(CartMenuItem cartMenuItem2) {
        int i11 = Resources.getSystem().getDisplayMetrics().widthPixels;
        ItemDetailsViewModel.setImage$default((ItemDetailsViewModel) getViewModel(), cartMenuItem2, 0, 2, (Object) null);
    }

    private final void hideLoading() {
        ((RelativeLayout) _$_findCachedViewById(R.id.progress_bar_view)).setVisibility(8);
    }

    private final void initializeViews() {
        CartMenuItem cartMenuItem2 = this.cartMenuItem;
        boolean z11 = true;
        if (cartMenuItem2.getQuantity() == 0) {
            cartMenuItem2.setQuantity(1);
        }
        ((TalabatTextView) _$_findCachedViewById(R.id.item_name)).setText(cartMenuItem2.f13862name);
        int i11 = R.id.item_description;
        TalabatTextView talabatTextView = (TalabatTextView) _$_findCachedViewById(i11);
        String str = cartMenuItem2.desc;
        int i12 = 0;
        if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = false;
        }
        if (z11) {
            i12 = 8;
        }
        talabatTextView.setVisibility(i12);
        String str2 = cartMenuItem2.desc;
        Intrinsics.checkNotNullExpressionValue(str2, "item.desc");
        ((TalabatTextView) _$_findCachedViewById(i11)).setText(StringsKt__StringsKt.trim((CharSequence) str2).toString());
        getItemImage(cartMenuItem2);
        setQuantityToTextView(cartMenuItem2.getQuantity());
        setPrice(cartMenuItem2);
        setSpecialRequestView(this.shouldDisableSpecialRequest);
        setSpecialRequestTextWatcher(cartMenuItem2);
        setClickListeners(cartMenuItem2);
    }

    private final void setBottomSheetHeight(View view) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(new a(view));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setBottomSheetHeight$lambda-13  reason: not valid java name */
    public static final void m10673setBottomSheetHeight$lambda13(View view, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(view, "$view");
        if (dialogInterface != null) {
            FrameLayout frameLayout = (FrameLayout) ((BottomSheetDialog) dialogInterface).findViewById(R.id.design_bottom_sheet);
            if (frameLayout != null) {
                BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                Intrinsics.checkNotNullExpressionValue(from, "from(bottomSheet)");
                from.setPeekHeight(((ViewGroup) view.findViewById(R.id.itemdetails_bottom_sheet)).getHeight());
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    /* access modifiers changed from: private */
    public final void setChangedPrices(Float f11) {
        setPrice(this.cartMenuItem);
    }

    private final void setClickListeners(CartMenuItem cartMenuItem2) {
        ((ImageButton) _$_findCachedViewById(R.id.button_minus)).setOnClickListener(new b(this, cartMenuItem2));
        ((ImageButton) _$_findCachedViewById(R.id.button_plus)).setOnClickListener(new c(this, cartMenuItem2));
        ((RelativeLayout) _$_findCachedViewById(R.id.add_to_basket_view)).setOnClickListener(new d(this, cartMenuItem2));
        ((ImageView) _$_findCachedViewById(R.id.close_bottomsheet)).setOnClickListener(new e(this));
        ((TalabatButton) _$_findCachedViewById(R.id.add_to_basket)).setOnClickListener(new f(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setClickListeners$lambda-2  reason: not valid java name */
    public static final void m10674setClickListeners$lambda2(ItemDetailsBottomSheet itemDetailsBottomSheet, CartMenuItem cartMenuItem2, View view) {
        Intrinsics.checkNotNullParameter(itemDetailsBottomSheet, "this$0");
        Intrinsics.checkNotNullParameter(cartMenuItem2, "$item");
        ((ItemDetailsViewModel) itemDetailsBottomSheet.getViewModel()).onDecreaseQuantityClicked(cartMenuItem2);
    }

    /* access modifiers changed from: private */
    /* renamed from: setClickListeners$lambda-3  reason: not valid java name */
    public static final void m10675setClickListeners$lambda3(ItemDetailsBottomSheet itemDetailsBottomSheet, CartMenuItem cartMenuItem2, View view) {
        Intrinsics.checkNotNullParameter(itemDetailsBottomSheet, "this$0");
        Intrinsics.checkNotNullParameter(cartMenuItem2, "$item");
        ((ItemDetailsViewModel) itemDetailsBottomSheet.getViewModel()).onIncreaseQuantityClicked(cartMenuItem2);
    }

    /* access modifiers changed from: private */
    /* renamed from: setClickListeners$lambda-4  reason: not valid java name */
    public static final void m10676setClickListeners$lambda4(ItemDetailsBottomSheet itemDetailsBottomSheet, CartMenuItem cartMenuItem2, View view) {
        Intrinsics.checkNotNullParameter(itemDetailsBottomSheet, "this$0");
        Intrinsics.checkNotNullParameter(cartMenuItem2, "$item");
        ItemDetailsCallbacks itemDetailsCallbacks = itemDetailsBottomSheet.interactionListener;
        if (itemDetailsCallbacks != null) {
            itemDetailsCallbacks.onAddToBasketClicked(cartMenuItem2);
        }
        ((ItemDetailsViewModel) itemDetailsBottomSheet.getViewModel()).addItemToCart(cartMenuItem2);
        itemDetailsBottomSheet.closeBottomSheetFromDialog();
    }

    /* access modifiers changed from: private */
    /* renamed from: setClickListeners$lambda-5  reason: not valid java name */
    public static final void m10677setClickListeners$lambda5(ItemDetailsBottomSheet itemDetailsBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(itemDetailsBottomSheet, "this$0");
        itemDetailsBottomSheet.closeBottomSheetFromDialog();
    }

    /* access modifiers changed from: private */
    /* renamed from: setClickListeners$lambda-6  reason: not valid java name */
    public static final void m10678setClickListeners$lambda6(ItemDetailsBottomSheet itemDetailsBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(itemDetailsBottomSheet, "this$0");
        ((RelativeLayout) itemDetailsBottomSheet._$_findCachedViewById(R.id.add_to_basket_view)).performClick();
    }

    /* access modifiers changed from: private */
    public final void setImageHeader(String str) {
        if (str == null) {
            return;
        }
        if (GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(getContext())) {
            GlideRequests with = GlideApp.with((Fragment) this);
            int i11 = R.id.image_header;
            with.clear((View) (ImageView) _$_findCachedViewById(i11));
            Intrinsics.checkNotNullExpressionValue(GlideApp.with((Fragment) this).load(str).placeholder((int) R.drawable.pale_orange_top_rounded).listener((RequestListener) new ItemDetailsBottomSheet$setImageHeader$1$1(this)).apply(TalabatGlideModule.requestOptions().transform((Transformation<Bitmap>[]) new Transformation[]{new CenterCrop(), new RoundedCornersTransformation(getContext(), getResources().getDimensionPixelSize(R.dimen._15radius), 0, RoundedCornersTransformation.CornerType.TOP_LEFT), new RoundedCornersTransformation(getContext(), getResources().getDimensionPixelSize(R.dimen._15radius), 0, RoundedCornersTransformation.CornerType.TOP_RIGHT)})).into((ImageView) _$_findCachedViewById(i11)), "private fun setImageHead…        }\n        }\n    }");
            return;
        }
        doNoImageAdjustments((ImageView) _$_findCachedViewById(R.id.image_header));
    }

    private final void setPrice(CartMenuItem cartMenuItem2) {
        if (cartMenuItem2.isItemHasStartPrice()) {
            String string = getString(R.string.from);
            String displayStartsWithPrice = cartMenuItem2.getDisplayStartsWithPrice(true);
            setPriceToTextViews(string + " " + displayStartsWithPrice);
        } else if (!cartMenuItem2.isDiscounted()) {
            String totalDisplayPrice = cartMenuItem2.getTotalDisplayPrice();
            Intrinsics.checkNotNullExpressionValue(totalDisplayPrice, "cartMenuItem.totalDisplayPrice");
            setPriceToTextViews(totalDisplayPrice);
        } else if (Integration.isGemActive()) {
            String totalDisplayOldPrice = cartMenuItem2.getTotalDisplayOldPrice();
            Intrinsics.checkNotNullExpressionValue(totalDisplayOldPrice, "displayPrice");
            setPriceToTextViews(totalDisplayOldPrice);
        } else {
            String totalDisplayOldPrice2 = cartMenuItem2.getTotalDisplayOldPrice();
            Intrinsics.checkNotNullExpressionValue(totalDisplayOldPrice2, "cartMenuItem.totalDisplayOldPrice");
            showOldPrice(totalDisplayOldPrice2);
            String totalDisplayPrice2 = cartMenuItem2.getTotalDisplayPrice();
            Intrinsics.checkNotNullExpressionValue(totalDisplayPrice2, "cartMenuItem.totalDisplayPrice");
            setPriceToTextViews(totalDisplayPrice2);
        }
    }

    private final void setPriceToTextViews(String str) {
        ((TalabatTextView) _$_findCachedViewById(R.id.price)).setText(str);
        ((TextView) _$_findCachedViewById(R.id.total_price)).setText(str);
    }

    /* access modifiers changed from: private */
    public final void setQuantity(Integer num) {
        if (num != null) {
            setQuantityToTextView(num.intValue());
        }
    }

    private final void setQuantityToTextView(int i11) {
        CartMenuItem cartMenuItem2 = this.cartMenuItem;
        ((TextView) _$_findCachedViewById(R.id.text_count)).setText(String.valueOf(i11));
        Drawable drawable = null;
        if (cartMenuItem2.getQuantity() <= 1) {
            int i12 = R.id.button_minus;
            ImageButton imageButton = (ImageButton) _$_findCachedViewById(i12);
            Context context = getContext();
            if (context != null) {
                drawable = ContextCompat.getDrawable(context, R.drawable.ds_minus_circle);
            }
            imageButton.setImageDrawable(drawable);
            Context context2 = getContext();
            if (context2 != null) {
                ImageViewCompat.setImageTintList((ImageButton) _$_findCachedViewById(i12), ColorStateList.valueOf(ContextCompat.getColor(context2, R.color.ds_neutral_55)));
                return;
            }
            return;
        }
        int i13 = R.id.button_minus;
        ImageButton imageButton2 = (ImageButton) _$_findCachedViewById(i13);
        Context context3 = getContext();
        if (context3 != null) {
            drawable = ContextCompat.getDrawable(context3, R.drawable.ds_minus_circle);
        }
        imageButton2.setImageDrawable(drawable);
        Context context4 = getContext();
        if (context4 != null) {
            ImageViewCompat.setImageTintList((ImageButton) _$_findCachedViewById(i13), ColorStateList.valueOf(ContextCompat.getColor(context4, R.color.ds_primary_100)));
        }
    }

    private final void setSpecialRequestTextWatcher(CartMenuItem cartMenuItem2) {
        ((TalabatEditText) _$_findCachedViewById(R.id.general_request)).addTextChangedListener(new ItemDetailsBottomSheet$setSpecialRequestTextWatcher$1(cartMenuItem2));
    }

    private final void setSpecialRequestView(boolean z11) {
        if (z11) {
            ((RelativeLayout) _$_findCachedViewById(R.id.general_request_view)).setVisibility(8);
            ((RelativeLayout) _$_findCachedViewById(R.id.general_request_disabled_view)).setVisibility(0);
            return;
        }
        ((RelativeLayout) _$_findCachedViewById(R.id.general_request_view)).setVisibility(0);
        ((TalabatEditText) _$_findCachedViewById(R.id.general_request)).setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.maxLength)});
        ((RelativeLayout) _$_findCachedViewById(R.id.general_request_disabled_view)).setVisibility(8);
    }

    private final void showLoading() {
        ((RelativeLayout) _$_findCachedViewById(R.id.progress_bar_view)).setVisibility(0);
    }

    private final void showOldPrice(String str) {
        int i11 = R.id.old_price;
        ((TalabatTextView) _$_findCachedViewById(i11)).setVisibility(0);
        ((TalabatTextView) _$_findCachedViewById(i11)).setText(str);
        ((TalabatTextView) _$_findCachedViewById(i11)).setPaintFlags(((TalabatTextView) _$_findCachedViewById(i11)).getPaintFlags() | 16);
        new GradientDrawable().setStroke(getResources().getDimensionPixelOffset(R.dimen.stroke_1dp), Color.parseColor("#fd7474"));
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void adjustViewHeight(@NotNull View view, int i11, int i12, @NotNull AnimationSpeed animationSpeed) {
        AnimationHelper.DefaultImpls.adjustViewHeight(this, view, i11, i12, animationSpeed);
    }

    public void delay(long j11, @NotNull Function0<Unit> function0) {
        AnimationHelper.DefaultImpls.delay(this, j11, function0);
    }

    public void failureHere(@Nullable Failure failure) {
    }

    @NotNull
    public final CartMenuItem getCartMenuItem() {
        return this.cartMenuItem;
    }

    @Nullable
    public final ItemDetailsCallbacks getInteractionListener() {
        return this.interactionListener;
    }

    public final int getMaxLength() {
        return this.maxLength;
    }

    public final boolean getShouldDisableSpecialRequest() {
        return this.shouldDisableSpecialRequest;
    }

    @NotNull
    public Class<ItemDetailsViewModel> getViewModelClass() {
        return ItemDetailsViewModel.class;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((ItemDetailsViewModel) getViewModel()).getQuantity(), new ItemDetailsBottomSheet$observatory$1(this));
        LifecycleKt.observe(this, ((ItemDetailsViewModel) getViewModel()).getPrice(), new ItemDetailsBottomSheet$observatory$2(this));
        LifecycleKt.observe(this, ((ItemDetailsViewModel) getViewModel()).getImageUrl(), new ItemDetailsBottomSheet$observatory$3(this));
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.VoucherBottomSheetDialogTheme);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Parcelable parcelable = arguments.getParcelable(EXTRA_CART_MENU_ITEM);
            Intrinsics.checkNotNull(parcelable);
            this.cartMenuItem = (CartMenuItem) parcelable;
            this.shouldDisableSpecialRequest = arguments.getBoolean(EXTRA_DISABLE_SPECIAL_REQUEST);
        }
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.item_details_bottomsheet, viewGroup, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setup(view);
    }

    public final void setCartMenuItem(@NotNull CartMenuItem cartMenuItem2) {
        Intrinsics.checkNotNullParameter(cartMenuItem2, "<set-?>");
        this.cartMenuItem = cartMenuItem2;
    }

    public final void setInteractionListener(@Nullable ItemDetailsCallbacks itemDetailsCallbacks) {
        this.interactionListener = itemDetailsCallbacks;
    }

    public final void setShouldDisableSpecialRequest(boolean z11) {
        this.shouldDisableSpecialRequest = z11;
    }

    public final void setup(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        setBottomSheetHeight(view);
        initializeViews();
    }

    public final void showDialog(@NotNull FragmentManager fragmentManager, @Nullable String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        if (!isVisible()) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag).commitNow();
            }
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commitNow();
        }
    }

    @NotNull
    public ItemDetailsViewModel viewModelBuilder() {
        return ItemDetailsVMBuilder.INSTANCE.getItemDetailsViewModel();
    }
}
