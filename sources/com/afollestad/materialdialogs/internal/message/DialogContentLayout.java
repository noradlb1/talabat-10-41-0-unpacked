package com.afollestad.materialdialogs.internal.message;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.navigation.compose.DialogNavigator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.internal.list.DialogRecyclerView;
import com.afollestad.materialdialogs.internal.main.DialogLayout;
import com.afollestad.materialdialogs.internal.main.DialogScrollView;
import com.afollestad.materialdialogs.message.DialogMessageSettings;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.afollestad.materialdialogs.utils.ViewsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010)\u001a\u00020*H\u0002J1\u0010+\u001a\u00020\b2\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\u000e2\b\u0010-\u001a\u0004\u0018\u00010\b2\u0006\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020(¢\u0006\u0002\u00100J$\u00101\u001a\u00020*2\u0006\u00102\u001a\u0002032\n\u00104\u001a\u0006\u0012\u0002\b\u0003052\b\u00106\u001a\u0004\u0018\u000107J\u0006\u00108\u001a\u00020(J\u001a\u00109\u001a\u00020*2\b\b\u0002\u0010:\u001a\u00020\u000e2\b\b\u0002\u0010;\u001a\u00020\u000eJ\u001a\u0010<\u001a\u00020*2\b\b\u0002\u0010:\u001a\u00020\u000e2\b\b\u0002\u0010;\u001a\u00020\u000eJ0\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000eH\u0014J\u0018\u0010A\u001a\u00020*2\u0006\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u000eH\u0014JN\u0010D\u001a\u00020*2\u0006\u00102\u001a\u0002032\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\u000e2\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010H2\u0019\u0010I\u001a\u0015\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020*\u0018\u00010J¢\u0006\u0002\bL¢\u0006\u0002\u0010MR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/afollestad/materialdialogs/internal/message/DialogContentLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "customView", "Landroid/view/View;", "getCustomView", "()Landroid/view/View;", "setCustomView", "(Landroid/view/View;)V", "frameHorizontalMargin", "", "getFrameHorizontalMargin", "()I", "frameHorizontalMargin$delegate", "Lkotlin/Lazy;", "messageTextView", "Landroid/widget/TextView;", "recyclerView", "Lcom/afollestad/materialdialogs/internal/list/DialogRecyclerView;", "getRecyclerView", "()Lcom/afollestad/materialdialogs/internal/list/DialogRecyclerView;", "setRecyclerView", "(Lcom/afollestad/materialdialogs/internal/list/DialogRecyclerView;)V", "rootLayout", "Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "getRootLayout", "()Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "scrollFrame", "Landroid/view/ViewGroup;", "scrollView", "Lcom/afollestad/materialdialogs/internal/main/DialogScrollView;", "getScrollView", "()Lcom/afollestad/materialdialogs/internal/main/DialogScrollView;", "setScrollView", "(Lcom/afollestad/materialdialogs/internal/main/DialogScrollView;)V", "useHorizontalPadding", "", "addContentScrollView", "", "addCustomView", "res", "view", "scrollable", "horizontalPadding", "(Ljava/lang/Integer;Landroid/view/View;ZZ)Landroid/view/View;", "addRecyclerView", "dialog", "Lcom/afollestad/materialdialogs/MaterialDialog;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "haveMoreThanOneChild", "modifyFirstAndLastPadding", "top", "bottom", "modifyScrollViewPadding", "onLayout", "changed", "left", "right", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setMessage", "text", "", "typeface", "Landroid/graphics/Typeface;", "applySettings", "Lkotlin/Function1;", "Lcom/afollestad/materialdialogs/message/DialogMessageSettings;", "Lkotlin/ExtensionFunctionType;", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/lang/CharSequence;Landroid/graphics/Typeface;Lkotlin/jvm/functions/Function1;)V", "com.afollestad.material-dialogs.core"}, k = 1, mv = {1, 1, 15})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DialogContentLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f40403b = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DialogContentLayout.class), "frameHorizontalMargin", "getFrameHorizontalMargin()I"))};
    @Nullable
    private View customView;
    private final Lazy frameHorizontalMargin$delegate;
    private TextView messageTextView;
    @Nullable
    private DialogRecyclerView recyclerView;
    private ViewGroup scrollFrame;
    @Nullable
    private DialogScrollView scrollView;
    private boolean useHorizontalPadding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DialogContentLayout(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    private final void addContentScrollView() {
        if (this.scrollView == null) {
            DialogScrollView dialogScrollView = (DialogScrollView) ViewsKt.inflate$default((ViewGroup) this, R.layout.md_dialog_stub_scrollview, (ViewGroup) null, 2, (Object) null);
            dialogScrollView.setRootView(getRootLayout());
            View childAt = dialogScrollView.getChildAt(0);
            if (childAt != null) {
                this.scrollFrame = (ViewGroup) childAt;
                this.scrollView = dialogScrollView;
                addView(dialogScrollView);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    private final int getFrameHorizontalMargin() {
        Lazy lazy = this.frameHorizontalMargin$delegate;
        KProperty kProperty = f40403b[0];
        return ((Number) lazy.getValue()).intValue();
    }

    private final DialogLayout getRootLayout() {
        ViewParent parent = getParent();
        if (parent != null) {
            return (DialogLayout) parent;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.afollestad.materialdialogs.internal.main.DialogLayout");
    }

    public static /* synthetic */ void modifyFirstAndLastPadding$default(DialogContentLayout dialogContentLayout, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = -1;
        }
        if ((i13 & 2) != 0) {
            i12 = -1;
        }
        dialogContentLayout.modifyFirstAndLastPadding(i11, i12);
    }

    public static /* synthetic */ void modifyScrollViewPadding$default(DialogContentLayout dialogContentLayout, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = -1;
        }
        if ((i13 & 2) != 0) {
            i12 = -1;
        }
        dialogContentLayout.modifyScrollViewPadding(i11, i12);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View addCustomView(@org.jetbrains.annotations.Nullable @androidx.annotation.LayoutRes java.lang.Integer r10, @org.jetbrains.annotations.Nullable android.view.View r11, boolean r12, boolean r13) {
        /*
            r9 = this;
            android.view.View r0 = r9.customView
            r1 = 0
            if (r0 != 0) goto L_0x0007
            r0 = 1
            goto L_0x0008
        L_0x0007:
            r0 = r1
        L_0x0008:
            if (r0 == 0) goto L_0x0089
            r0 = 0
            if (r11 == 0) goto L_0x0023
            android.view.ViewParent r2 = r11.getParent()
            if (r2 == 0) goto L_0x0023
            android.view.ViewParent r2 = r11.getParent()
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 != 0) goto L_0x001c
            r2 = r0
        L_0x001c:
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            if (r2 == 0) goto L_0x0023
            r2.removeView(r11)
        L_0x0023:
            if (r12 == 0) goto L_0x0066
            r9.useHorizontalPadding = r1
            r9.addContentScrollView()
            if (r11 == 0) goto L_0x002d
            goto L_0x003f
        L_0x002d:
            if (r10 != 0) goto L_0x0032
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0032:
            int r10 = r10.intValue()
            android.view.ViewGroup r11 = r9.scrollFrame
            java.lang.Object r10 = com.afollestad.materialdialogs.utils.ViewsKt.inflate((android.view.ViewGroup) r9, (int) r10, (android.view.ViewGroup) r11)
            r11 = r10
            android.view.View r11 = (android.view.View) r11
        L_0x003f:
            r9.customView = r11
            android.view.ViewGroup r10 = r9.scrollFrame
            if (r10 != 0) goto L_0x0048
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0048:
            android.view.View r11 = r9.customView
            if (r11 == 0) goto L_0x0062
            if (r13 == 0) goto L_0x0061
            com.afollestad.materialdialogs.utils.MDUtil r1 = com.afollestad.materialdialogs.utils.MDUtil.INSTANCE
            int r3 = r9.getFrameHorizontalMargin()
            r4 = 0
            int r5 = r9.getFrameHorizontalMargin()
            r6 = 0
            r7 = 10
            r8 = 0
            r2 = r11
            com.afollestad.materialdialogs.utils.MDUtil.updatePadding$default(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0061:
            r0 = r11
        L_0x0062:
            r10.addView(r0)
            goto L_0x0081
        L_0x0066:
            r9.useHorizontalPadding = r13
            if (r11 == 0) goto L_0x006b
            goto L_0x007c
        L_0x006b:
            if (r10 != 0) goto L_0x0070
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0070:
            int r10 = r10.intValue()
            r11 = 2
            java.lang.Object r10 = com.afollestad.materialdialogs.utils.ViewsKt.inflate$default((android.view.ViewGroup) r9, (int) r10, (android.view.ViewGroup) r0, (int) r11, (java.lang.Object) r0)
            r11 = r10
            android.view.View r11 = (android.view.View) r11
        L_0x007c:
            r9.customView = r11
            r9.addView(r11)
        L_0x0081:
            android.view.View r10 = r9.customView
            if (r10 != 0) goto L_0x0088
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0088:
            return r10
        L_0x0089:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Custom view already set."
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.internal.message.DialogContentLayout.addCustomView(java.lang.Integer, android.view.View, boolean, boolean):android.view.View");
    }

    public final void addRecyclerView(@NotNull MaterialDialog materialDialog, @NotNull RecyclerView.Adapter<?> adapter, @Nullable RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkParameterIsNotNull(materialDialog, DialogNavigator.NAME);
        Intrinsics.checkParameterIsNotNull(adapter, "adapter");
        if (this.recyclerView == null) {
            DialogRecyclerView dialogRecyclerView = (DialogRecyclerView) ViewsKt.inflate$default((ViewGroup) this, R.layout.md_dialog_stub_recyclerview, (ViewGroup) null, 2, (Object) null);
            dialogRecyclerView.attach(materialDialog);
            if (layoutManager == null) {
                layoutManager = new LinearLayoutManager(materialDialog.getWindowContext());
            }
            dialogRecyclerView.setLayoutManager(layoutManager);
            this.recyclerView = dialogRecyclerView;
            addView(dialogRecyclerView);
        }
        DialogRecyclerView dialogRecyclerView2 = this.recyclerView;
        if (dialogRecyclerView2 != null) {
            dialogRecyclerView2.setAdapter(adapter);
        }
    }

    @Nullable
    public final View getCustomView() {
        return this.customView;
    }

    @Nullable
    public final DialogRecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @Nullable
    public final DialogScrollView getScrollView() {
        return this.scrollView;
    }

    public final boolean haveMoreThanOneChild() {
        return getChildCount() > 1;
    }

    public final void modifyFirstAndLastPadding(int i11, int i12) {
        if (i11 != -1) {
            MDUtil.updatePadding$default(MDUtil.INSTANCE, getChildAt(0), 0, i11, 0, 0, 13, (Object) null);
        }
        if (i12 != -1) {
            MDUtil.updatePadding$default(MDUtil.INSTANCE, getChildAt(getChildCount() - 1), 0, 0, 0, i12, 7, (Object) null);
        }
    }

    public final void modifyScrollViewPadding(int i11, int i12) {
        View view = this.scrollView;
        if (view == null) {
            view = this.recyclerView;
        }
        if (i11 != -1) {
            MDUtil.updatePadding$default(MDUtil.INSTANCE, view, 0, i11, 0, 0, 13, (Object) null);
        }
        if (i12 != -1) {
            MDUtil.updatePadding$default(MDUtil.INSTANCE, view, 0, 0, 0, i12, 7, (Object) null);
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int childCount = getChildCount();
        int i17 = 0;
        int i18 = 0;
        while (i17 < childCount) {
            View childAt = getChildAt(i17);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "currentChild");
            int measuredHeight = childAt.getMeasuredHeight() + i18;
            if (!Intrinsics.areEqual((Object) childAt, (Object) this.customView) || !this.useHorizontalPadding) {
                i15 = getMeasuredWidth();
                i16 = 0;
            } else {
                i16 = getFrameHorizontalMargin();
                i15 = getMeasuredWidth() - getFrameHorizontalMargin();
            }
            childAt.layout(i16, i18, i15, measuredHeight);
            i17++;
            i18 = measuredHeight;
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        DialogScrollView dialogScrollView = this.scrollView;
        if (dialogScrollView != null) {
            dialogScrollView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
        }
        DialogScrollView dialogScrollView2 = this.scrollView;
        if (dialogScrollView2 != null) {
            i13 = dialogScrollView2.getMeasuredHeight();
        } else {
            i13 = 0;
        }
        int i16 = size2 - i13;
        if (this.scrollView != null) {
            i14 = getChildCount() - 1;
        } else {
            i14 = getChildCount();
        }
        if (i14 == 0) {
            setMeasuredDimension(size, i13);
            return;
        }
        int i17 = i16 / i14;
        int childCount = getChildCount();
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "currentChild");
            int id2 = childAt.getId();
            DialogScrollView dialogScrollView3 = this.scrollView;
            if (dialogScrollView3 == null || id2 != dialogScrollView3.getId()) {
                if (!Intrinsics.areEqual((Object) childAt, (Object) this.customView) || !this.useHorizontalPadding) {
                    i15 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                } else {
                    i15 = View.MeasureSpec.makeMeasureSpec(size - (getFrameHorizontalMargin() * 2), 1073741824);
                }
                childAt.measure(i15, View.MeasureSpec.makeMeasureSpec(i17, Integer.MIN_VALUE));
                i13 += childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size, i13);
    }

    public final void setCustomView(@Nullable View view) {
        this.customView = view;
    }

    public final void setMessage(@NotNull MaterialDialog materialDialog, @Nullable @StringRes Integer num, @Nullable CharSequence charSequence, @Nullable Typeface typeface, @Nullable Function1<? super DialogMessageSettings, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(materialDialog, DialogNavigator.NAME);
        addContentScrollView();
        if (this.messageTextView == null) {
            int i11 = R.layout.md_dialog_stub_message;
            ViewGroup viewGroup = this.scrollFrame;
            if (viewGroup == null) {
                Intrinsics.throwNpe();
            }
            TextView textView = (TextView) ViewsKt.inflate((ViewGroup) this, i11, viewGroup);
            ViewGroup viewGroup2 = this.scrollFrame;
            if (viewGroup2 == null) {
                Intrinsics.throwNpe();
            }
            viewGroup2.addView(textView);
            this.messageTextView = textView;
        }
        TextView textView2 = this.messageTextView;
        if (textView2 == null) {
            Intrinsics.throwNpe();
        }
        DialogMessageSettings dialogMessageSettings = new DialogMessageSettings(materialDialog, textView2);
        if (function1 != null) {
            Unit invoke = function1.invoke(dialogMessageSettings);
        }
        TextView textView3 = this.messageTextView;
        if (textView3 != null) {
            if (typeface != null) {
                textView3.setTypeface(typeface);
            }
            MDUtil.maybeSetTextColor$default(MDUtil.INSTANCE, textView3, materialDialog.getWindowContext(), Integer.valueOf(R.attr.md_color_content), (Integer) null, 4, (Object) null);
            dialogMessageSettings.setText$com_afollestad_material_dialogs_core(num, charSequence);
        }
    }

    public final void setRecyclerView(@Nullable DialogRecyclerView dialogRecyclerView) {
        this.recyclerView = dialogRecyclerView;
    }

    public final void setScrollView(@Nullable DialogScrollView dialogScrollView) {
        this.scrollView = dialogScrollView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogContentLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.frameHorizontalMargin$delegate = LazyKt__LazyJVMKt.lazy(new DialogContentLayout$frameHorizontalMargin$2(this));
    }
}
