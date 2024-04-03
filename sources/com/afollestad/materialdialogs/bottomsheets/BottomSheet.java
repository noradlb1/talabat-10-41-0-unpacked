package com.afollestad.materialdialogs.bottomsheets;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.navigation.compose.DialogNavigator;
import com.afollestad.materialdialogs.DialogBehavior;
import com.afollestad.materialdialogs.LayoutMode;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.internal.button.DialogActionButtonLayout;
import com.afollestad.materialdialogs.internal.button.DialogActionButtonLayoutKt;
import com.afollestad.materialdialogs.internal.list.DialogRecyclerView;
import com.afollestad.materialdialogs.internal.main.DialogLayout;
import com.afollestad.materialdialogs.internal.main.DialogScrollView;
import com.afollestad.materialdialogs.internal.message.DialogContentLayout;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 F2\u00020\u0001:\u0001FB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J(\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+2\u0006\u0010%\u001a\u00020&2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0015H\u0016J\u0010\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020$H\u0002J\u0010\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\u0006H\u0002J\b\u00107\u001a\u000203H\u0016J\u0010\u00108\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u00109\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020/2\u0006\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020>H\u0016J/\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020+2\u0006\u0010A\u001a\u00020&2\u0006\u0010;\u001a\u00020/2\b\u0010B\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010CJ\b\u0010D\u001a\u00020$H\u0002J\b\u0010E\u001a\u00020$H\u0002R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068B@BX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068@@@X\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/afollestad/materialdialogs/bottomsheets/BottomSheet;", "Lcom/afollestad/materialdialogs/DialogBehavior;", "layoutMode", "Lcom/afollestad/materialdialogs/LayoutMode;", "(Lcom/afollestad/materialdialogs/LayoutMode;)V", "<set-?>", "", "actualPeekHeight", "getActualPeekHeight", "()I", "setActualPeekHeight", "(I)V", "actualPeekHeight$delegate", "Lkotlin/properties/ReadWriteProperty;", "bottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "getBottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "setBottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;)V", "bottomSheetView", "Landroid/view/ViewGroup;", "buttonsLayout", "Lcom/afollestad/materialdialogs/internal/button/DialogActionButtonLayout;", "defaultPeekHeight", "getDefaultPeekHeight$com_afollestad_material_dialogs_bottomsheets", "setDefaultPeekHeight$com_afollestad_material_dialogs_bottomsheets", "defaultPeekHeight$delegate", "dialog", "Lcom/afollestad/materialdialogs/MaterialDialog;", "maxPeekHeight", "getMaxPeekHeight$com_afollestad_material_dialogs_bottomsheets", "setMaxPeekHeight$com_afollestad_material_dialogs_bottomsheets", "rootView", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "carryOverWindowFlags", "", "dialogWindow", "Landroid/view/Window;", "creatingActivity", "Landroid/app/Activity;", "createView", "creatingContext", "Landroid/content/Context;", "layoutInflater", "Landroid/view/LayoutInflater;", "getDialogLayout", "Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "root", "getThemeRes", "isDark", "", "hideButtons", "invalidateDividers", "currentHeight", "onDismiss", "onPostShow", "onPreShow", "setBackgroundColor", "view", "color", "cornerRounding", "", "setWindowConstraints", "context", "window", "maxWidth", "(Landroid/content/Context;Landroid/view/Window;Lcom/afollestad/materialdialogs/internal/main/DialogLayout;Ljava/lang/Integer;)V", "setupBottomSheetBehavior", "showButtons", "Companion", "com.afollestad.material-dialogs.bottomsheets"}, k = 1, mv = {1, 1, 15})
public final class BottomSheet implements DialogBehavior {
    private static final long BUTTONS_SHOW_DURATION_MS = 180;
    private static final long BUTTONS_SHOW_START_DELAY_MS = 100;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float DEFAULT_PEEK_HEIGHT_RATIO = 0.6f;
    public static final long LAYOUT_PEEK_CHANGE_DURATION_MS = 250;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f40364a;
    private final ReadWriteProperty actualPeekHeight$delegate;
    @Nullable
    private BottomSheetBehavior<?> bottomSheetBehavior;
    /* access modifiers changed from: private */
    public ViewGroup bottomSheetView;
    /* access modifiers changed from: private */
    public DialogActionButtonLayout buttonsLayout;
    @NotNull
    private final ReadWriteProperty defaultPeekHeight$delegate;
    /* access modifiers changed from: private */
    public MaterialDialog dialog;
    private final LayoutMode layoutMode;
    private int maxPeekHeight;
    private CoordinatorLayout rootView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/afollestad/materialdialogs/bottomsheets/BottomSheet$Companion;", "", "()V", "BUTTONS_SHOW_DURATION_MS", "", "BUTTONS_SHOW_START_DELAY_MS", "DEFAULT_PEEK_HEIGHT_RATIO", "", "LAYOUT_PEEK_CHANGE_DURATION_MS", "com.afollestad.material-dialogs.bottomsheets"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Class<BottomSheet> cls = BottomSheet.class;
        f40364a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "defaultPeekHeight", "getDefaultPeekHeight$com_afollestad_material_dialogs_bottomsheets()I")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "actualPeekHeight", "getActualPeekHeight()I"))};
    }

    public BottomSheet() {
        this((LayoutMode) null, 1, (DefaultConstructorMarker) null);
    }

    public BottomSheet(@NotNull LayoutMode layoutMode2) {
        Intrinsics.checkParameterIsNotNull(layoutMode2, "layoutMode");
        this.layoutMode = layoutMode2;
        Delegates delegates = Delegates.INSTANCE;
        this.defaultPeekHeight$delegate = delegates.notNull();
        this.maxPeekHeight = -1;
        this.actualPeekHeight$delegate = delegates.notNull();
    }

    private final void carryOverWindowFlags(Window window, Activity activity) {
        Window window2 = activity.getWindow();
        if (window2 == null) {
            Intrinsics.throwNpe();
        }
        window.setNavigationBarColor(window2.getNavigationBarColor());
    }

    /* access modifiers changed from: private */
    public final int getActualPeekHeight() {
        return ((Number) this.actualPeekHeight$delegate.getValue(this, f40364a[1])).intValue();
    }

    private final void hideButtons() {
        if (DialogActionButtonLayoutKt.shouldBeVisible(this.buttonsLayout)) {
            DialogActionButtonLayout dialogActionButtonLayout = this.buttonsLayout;
            if (dialogActionButtonLayout == null) {
                Intrinsics.throwNpe();
            }
            Animator animateValues$default = UtilKt.animateValues$default(0, dialogActionButtonLayout.getMeasuredHeight(), 250, new BottomSheet$hideButtons$animator$1(this), (Function0) null, 16, (Object) null);
            DialogActionButtonLayout dialogActionButtonLayout2 = this.buttonsLayout;
            if (dialogActionButtonLayout2 != null) {
                UtilKt.onDetach(dialogActionButtonLayout2, new BottomSheet$hideButtons$1(animateValues$default));
            }
            animateValues$default.start();
        }
    }

    /* access modifiers changed from: private */
    public final void invalidateDividers(int i11) {
        DialogLayout view;
        DialogContentLayout contentLayout;
        MaterialDialog materialDialog;
        DialogLayout view2;
        MaterialDialog materialDialog2 = this.dialog;
        if (materialDialog2 != null && (view = materialDialog2.getView()) != null && (contentLayout = view.getContentLayout()) != null && (materialDialog = this.dialog) != null && (view2 = materialDialog.getView()) != null) {
            int measuredHeight = view2.getMeasuredHeight();
            DialogScrollView scrollView = contentLayout.getScrollView();
            DialogRecyclerView recyclerView = contentLayout.getRecyclerView();
            if (i11 < measuredHeight) {
                DialogActionButtonLayout dialogActionButtonLayout = this.buttonsLayout;
                if (dialogActionButtonLayout != null) {
                    dialogActionButtonLayout.setDrawDivider(true);
                }
            } else if (scrollView != null) {
                scrollView.invalidateDividers();
            } else if (recyclerView != null) {
                recyclerView.invalidateDividers();
            } else {
                DialogActionButtonLayout dialogActionButtonLayout2 = this.buttonsLayout;
                if (dialogActionButtonLayout2 != null) {
                    dialogActionButtonLayout2.setDrawDivider(false);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void setActualPeekHeight(int i11) {
        this.actualPeekHeight$delegate.setValue(this, f40364a[1], Integer.valueOf(i11));
    }

    private final void setupBottomSheetBehavior() {
        BottomSheetBehavior<?> from = BottomSheetBehavior.from(this.bottomSheetView);
        from.setHideable(true);
        from.setPeekHeight(0);
        this.bottomSheetBehavior = from;
        UtilKt.setCallbacks(from, new BottomSheet$setupBottomSheetBehavior$2(this), new BottomSheet$setupBottomSheetBehavior$3(this));
        MDUtil mDUtil = MDUtil.INSTANCE;
        ViewGroup viewGroup = this.bottomSheetView;
        if (viewGroup == null) {
            Intrinsics.throwNpe();
        }
        mDUtil.waitForHeight(viewGroup, new BottomSheet$setupBottomSheetBehavior$4(this));
    }

    /* access modifiers changed from: private */
    public final void showButtons() {
        if (DialogActionButtonLayoutKt.shouldBeVisible(this.buttonsLayout)) {
            DialogActionButtonLayout dialogActionButtonLayout = this.buttonsLayout;
            if (dialogActionButtonLayout == null) {
                Intrinsics.throwNpe();
            }
            int measuredHeight = dialogActionButtonLayout.getMeasuredHeight();
            DialogActionButtonLayout dialogActionButtonLayout2 = this.buttonsLayout;
            if (dialogActionButtonLayout2 != null) {
                dialogActionButtonLayout2.setTranslationY((float) measuredHeight);
            }
            DialogActionButtonLayout dialogActionButtonLayout3 = this.buttonsLayout;
            if (dialogActionButtonLayout3 != null) {
                dialogActionButtonLayout3.setVisibility(0);
            }
            Animator animateValues$default = UtilKt.animateValues$default(measuredHeight, 0, BUTTONS_SHOW_DURATION_MS, new BottomSheet$showButtons$animator$1(this), (Function0) null, 16, (Object) null);
            DialogActionButtonLayout dialogActionButtonLayout4 = this.buttonsLayout;
            if (dialogActionButtonLayout4 != null) {
                UtilKt.onDetach(dialogActionButtonLayout4, new BottomSheet$showButtons$1(animateValues$default));
            }
            animateValues$default.setStartDelay(100);
            animateValues$default.start();
        }
    }

    @NotNull
    @SuppressLint({"InflateParams"})
    public ViewGroup createView(@NotNull Context context, @NotNull Window window, @NotNull LayoutInflater layoutInflater, @NotNull MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(context, "creatingContext");
        Intrinsics.checkParameterIsNotNull(window, "dialogWindow");
        Intrinsics.checkParameterIsNotNull(layoutInflater, "layoutInflater");
        Intrinsics.checkParameterIsNotNull(materialDialog, DialogNavigator.NAME);
        View inflate = layoutInflater.inflate(R.layout.md_dialog_base_bottomsheet, (ViewGroup) null, false);
        if (inflate != null) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
            this.rootView = coordinatorLayout;
            this.dialog = materialDialog;
            this.bottomSheetView = (ViewGroup) coordinatorLayout.findViewById(R.id.md_root_bottom_sheet);
            CoordinatorLayout coordinatorLayout2 = this.rootView;
            if (coordinatorLayout2 == null) {
                Intrinsics.throwNpe();
            }
            this.buttonsLayout = (DialogActionButtonLayout) coordinatorLayout2.findViewById(R.id.md_button_layout);
            MDUtil mDUtil = MDUtil.INSTANCE;
            WindowManager windowManager = window.getWindowManager();
            Intrinsics.checkExpressionValueIsNotNull(windowManager, "dialogWindow.windowManager");
            int intValue = mDUtil.getWidthAndHeight(windowManager).component2().intValue();
            setDefaultPeekHeight$com_afollestad_material_dialogs_bottomsheets((int) (((float) intValue) * 0.6f));
            setActualPeekHeight(getDefaultPeekHeight$com_afollestad_material_dialogs_bottomsheets());
            this.maxPeekHeight = intValue;
            setupBottomSheetBehavior();
            if (context instanceof Activity) {
                carryOverWindowFlags(window, (Activity) context);
            }
            CoordinatorLayout coordinatorLayout3 = this.rootView;
            if (coordinatorLayout3 == null) {
                Intrinsics.throwNpe();
            }
            return coordinatorLayout3;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
    }

    @Nullable
    public final BottomSheetBehavior<?> getBottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets() {
        return this.bottomSheetBehavior;
    }

    public final int getDefaultPeekHeight$com_afollestad_material_dialogs_bottomsheets() {
        return ((Number) this.defaultPeekHeight$delegate.getValue(this, f40364a[0])).intValue();
    }

    @NotNull
    public DialogLayout getDialogLayout(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "root");
        View findViewById = viewGroup.findViewById(R.id.md_root);
        if (findViewById != null) {
            DialogLayout dialogLayout = (DialogLayout) findViewById;
            dialogLayout.setLayoutMode(this.layoutMode);
            DialogActionButtonLayout dialogActionButtonLayout = this.buttonsLayout;
            if (dialogActionButtonLayout == null) {
                Intrinsics.throwNpe();
            }
            dialogLayout.attachButtonsLayout(dialogActionButtonLayout);
            return dialogLayout;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.afollestad.materialdialogs.internal.main.DialogLayout");
    }

    public final int getMaxPeekHeight$com_afollestad_material_dialogs_bottomsheets() {
        return this.maxPeekHeight;
    }

    public int getThemeRes(boolean z11) {
        if (z11) {
            return R.style.MD_Dark_BottomSheet;
        }
        return R.style.MD_Light_BottomSheet;
    }

    public boolean onDismiss() {
        BottomSheetBehavior<?> bottomSheetBehavior2;
        if (this.dialog == null || (bottomSheetBehavior2 = this.bottomSheetBehavior) == null) {
            return false;
        }
        if (bottomSheetBehavior2 == null) {
            Intrinsics.throwNpe();
        }
        if (bottomSheetBehavior2.getState() == 5) {
            return false;
        }
        BottomSheetBehavior<?> bottomSheetBehavior3 = this.bottomSheetBehavior;
        if (bottomSheetBehavior3 == null) {
            Intrinsics.throwNpe();
        }
        bottomSheetBehavior3.setState(5);
        hideButtons();
        return true;
    }

    public void onPostShow(@NotNull MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, DialogNavigator.NAME);
    }

    public void onPreShow(@NotNull MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, DialogNavigator.NAME);
        if (!materialDialog.getCancelOnTouchOutside() || !materialDialog.getCancelable()) {
            CoordinatorLayout coordinatorLayout = this.rootView;
            if (coordinatorLayout != null) {
                coordinatorLayout.setOnClickListener((View.OnClickListener) null);
            }
        } else {
            CoordinatorLayout coordinatorLayout2 = this.rootView;
            if (coordinatorLayout2 != null) {
                coordinatorLayout2.setOnClickListener(new BottomSheet$onPreShow$1(this));
            }
        }
        MDUtil mDUtil = MDUtil.INSTANCE;
        ViewGroup viewGroup = this.bottomSheetView;
        if (viewGroup == null) {
            Intrinsics.throwNpe();
        }
        mDUtil.waitForHeight(viewGroup, new BottomSheet$onPreShow$2(this));
    }

    public void setBackgroundColor(@NotNull DialogLayout dialogLayout, int i11, float f11) {
        Intrinsics.checkParameterIsNotNull(dialogLayout, "view");
        ViewGroup viewGroup = this.bottomSheetView;
        if (viewGroup != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(new float[]{f11, f11, f11, f11, 0.0f, 0.0f, 0.0f, 0.0f});
            gradientDrawable.setColor(i11);
            viewGroup.setBackground(gradientDrawable);
        }
        DialogActionButtonLayout dialogActionButtonLayout = this.buttonsLayout;
        if (dialogActionButtonLayout != null) {
            dialogActionButtonLayout.setBackgroundColor(i11);
        }
    }

    public final void setBottomSheetBehavior$com_afollestad_material_dialogs_bottomsheets(@Nullable BottomSheetBehavior<?> bottomSheetBehavior2) {
        this.bottomSheetBehavior = bottomSheetBehavior2;
    }

    public final void setDefaultPeekHeight$com_afollestad_material_dialogs_bottomsheets(int i11) {
        this.defaultPeekHeight$delegate.setValue(this, f40364a[0], Integer.valueOf(i11));
    }

    public final void setMaxPeekHeight$com_afollestad_material_dialogs_bottomsheets(int i11) {
        this.maxPeekHeight = i11;
    }

    public void setWindowConstraints(@NotNull Context context, @NotNull Window window, @NotNull DialogLayout dialogLayout, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(window, "window");
        Intrinsics.checkParameterIsNotNull(dialogLayout, "view");
        if (num == null || num.intValue() != 0) {
            window.setSoftInputMode(16);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = -1;
            layoutParams.height = -1;
            window.setAttributes(layoutParams);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BottomSheet(LayoutMode layoutMode2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? LayoutMode.MATCH_PARENT : layoutMode2);
    }
}
