package com.designsystem.ds_bottom_sheet;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.compose.DialogNavigator;
import com.designsystem.ds_button.DSPrimaryButton;
import com.designsystem.ds_button.DSSecondaryButton;
import com.designsystem.ds_button.DSSocialButton;
import com.designsystem.ds_button.DSTertiaryButton;
import com.designsystem.marshmallow.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z5.a;
import z5.b;
import z5.c;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 92\u00020\u0001:\u00029:Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eJ\b\u0010)\u001a\u00020\u0003H\u0016J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J&\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010\u000b\u001a\u00020+2\u0006\u00104\u001a\u000205H\u0016J\u001a\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020/2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u00108\u001a\u00020+H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/designsystem/ds_bottom_sheet/DSBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "mLayoutReference", "", "headerEndFirstIconAlternative", "headerEndSecondIconAlternative", "headerStartIconOnClickListener", "Landroid/view/View$OnClickListener;", "headerEndFirstIconOnClickListener", "headerEndSecondIconOnClickListener", "buttonOnClickListener", "onDismiss", "Ljava/lang/Runnable;", "headerEndTextOnClick", "(ILjava/lang/Integer;Ljava/lang/Integer;Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;Ljava/lang/Runnable;Landroid/view/View$OnClickListener;)V", "getButtonOnClickListener", "()Landroid/view/View$OnClickListener;", "setButtonOnClickListener", "(Landroid/view/View$OnClickListener;)V", "getHeaderEndFirstIconAlternative", "()Ljava/lang/Integer;", "setHeaderEndFirstIconAlternative", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHeaderEndFirstIconOnClickListener", "setHeaderEndFirstIconOnClickListener", "getHeaderEndSecondIconAlternative", "setHeaderEndSecondIconAlternative", "getHeaderEndSecondIconOnClickListener", "setHeaderEndSecondIconOnClickListener", "getHeaderEndTextOnClick", "setHeaderEndTextOnClick", "getHeaderStartIconOnClickListener", "setHeaderStartIconOnClickListener", "getOnDismiss", "()Ljava/lang/Runnable;", "setOnDismiss", "(Ljava/lang/Runnable;)V", "originalHeaderEndFirstIcon", "Landroid/graphics/drawable/Drawable;", "originalHeaderEndSecondIcon", "getTheme", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", "view", "setOnClickListeners", "Companion", "FragmentListener", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(message = "This class has been replaced by 'com.designsystem.ds_bottom_sheet_v2.DSBottomSheet'", replaceWith = @ReplaceWith(expression = "DSBottomSheet", imports = {"com.designsystem.ds_bottom_sheet_v2.DSBottomSheet"}))
public final class DSBottomSheet extends BottomSheetDialogFragment {
    public static final int $stable = 8;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "DSBottomSheet";
    /* access modifiers changed from: private */
    @NotNull
    public static final ReadWriteProperty<Object, Integer> layoutReference$delegate = Delegates.INSTANCE.notNull();
    /* access modifiers changed from: private */
    @Nullable
    public static FragmentListener mFragmentListener;
    @Nullable
    private View.OnClickListener buttonOnClickListener;
    @Nullable
    private Integer headerEndFirstIconAlternative;
    @Nullable
    private View.OnClickListener headerEndFirstIconOnClickListener;
    @Nullable
    private Integer headerEndSecondIconAlternative;
    @Nullable
    private View.OnClickListener headerEndSecondIconOnClickListener;
    @Nullable
    private View.OnClickListener headerEndTextOnClick;
    @Nullable
    private View.OnClickListener headerStartIconOnClickListener;
    @Nullable
    private Runnable onDismiss;
    @Nullable
    private Drawable originalHeaderEndFirstIcon;
    @Nullable
    private Drawable originalHeaderEndSecondIcon;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/designsystem/ds_bottom_sheet/DSBottomSheet$Companion;", "", "()V", "TAG", "", "<set-?>", "", "layoutReference", "getLayoutReference", "()I", "setLayoutReference", "(I)V", "layoutReference$delegate", "Lkotlin/properties/ReadWriteProperty;", "mFragmentListener", "Lcom/designsystem/ds_bottom_sheet/DSBottomSheet$FragmentListener;", "getMFragmentListener", "()Lcom/designsystem/ds_bottom_sheet/DSBottomSheet$FragmentListener;", "setMFragmentListener", "(Lcom/designsystem/ds_bottom_sheet/DSBottomSheet$FragmentListener;)V", "newInstance", "Lcom/designsystem/ds_bottom_sheet/DSBottomSheet;", "listener", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ KProperty<Object>[] f30589a = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Companion.class, "layoutReference", "getLayoutReference()I", 0))};

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getLayoutReference() {
            return ((Number) DSBottomSheet.layoutReference$delegate.getValue(this, f30589a[0])).intValue();
        }

        @Nullable
        public final FragmentListener getMFragmentListener() {
            return DSBottomSheet.mFragmentListener;
        }

        @NotNull
        public final DSBottomSheet newInstance(@NotNull FragmentListener fragmentListener, int i11) {
            Intrinsics.checkNotNullParameter(fragmentListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            setMFragmentListener(fragmentListener);
            setLayoutReference(i11);
            return new DSBottomSheet(i11, (Integer) null, (Integer) null, (View.OnClickListener) null, (View.OnClickListener) null, (View.OnClickListener) null, (View.OnClickListener) null, (Runnable) null, (View.OnClickListener) null, TypedValues.PositionType.TYPE_POSITION_TYPE, (DefaultConstructorMarker) null);
        }

        public final void setLayoutReference(int i11) {
            DSBottomSheet.layoutReference$delegate.setValue(this, f30589a[0], Integer.valueOf(i11));
        }

        public final void setMFragmentListener(@Nullable FragmentListener fragmentListener) {
            DSBottomSheet.mFragmentListener = fragmentListener;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/designsystem/ds_bottom_sheet/DSBottomSheet$FragmentListener;", "", "getView", "", "view", "Landroid/view/View;", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface FragmentListener {
        void getView(@Nullable View view);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DSBottomSheet(int r10, java.lang.Integer r11, java.lang.Integer r12, android.view.View.OnClickListener r13, android.view.View.OnClickListener r14, android.view.View.OnClickListener r15, android.view.View.OnClickListener r16, java.lang.Runnable r17, android.view.View.OnClickListener r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r9 = this;
            r0 = r19
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r14
        L_0x001f:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r15
        L_0x0026:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0034
            r8 = r2
            goto L_0x0036
        L_0x0034:
            r8 = r17
        L_0x0036:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r2 = r18
        L_0x003d:
            r11 = r9
            r12 = r10
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_bottom_sheet.DSBottomSheet.<init>(int, java.lang.Integer, java.lang.Integer, android.view.View$OnClickListener, android.view.View$OnClickListener, android.view.View$OnClickListener, android.view.View$OnClickListener, java.lang.Runnable, android.view.View$OnClickListener, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m8258onViewCreated$lambda1(DSBottomSheet dSBottomSheet, DialogInterface dialogInterface) {
        WindowManager windowManager;
        Display defaultDisplay;
        Intrinsics.checkNotNullParameter(dSBottomSheet, "this$0");
        if (dialogInterface != null) {
            BottomSheetBehavior<FrameLayout> behavior = ((BottomSheetDialog) dialogInterface).getBehavior();
            behavior.setFitToContents(true);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            FragmentActivity activity = dSBottomSheet.getActivity();
            if (!(activity == null || (windowManager = activity.getWindowManager()) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null)) {
                defaultDisplay.getMetrics(displayMetrics);
            }
            behavior.setPeekHeight(DSBottomSheetContentsKt.dpToPx(displayMetrics.heightPixels, dSBottomSheet.getResources()));
            behavior.setState(4);
            behavior.addBottomSheetCallback(new DSBottomSheet$onViewCreated$1$1$1(behavior));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    private final void setOnClickListeners() {
        View view;
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        View view7;
        View view8;
        View view9 = getView();
        View view10 = null;
        if (view9 == null) {
            view = null;
        } else {
            view = view9.findViewById(R.id.bottom_sheet_header);
        }
        ((ImageView) ((DSBottomSheetHeader) view).findViewById(R.id.bsh_start_icon)).setOnClickListener(this.headerStartIconOnClickListener);
        View view11 = getView();
        if (view11 == null) {
            view2 = null;
        } else {
            view2 = view11.findViewById(R.id.bottom_sheet_header);
        }
        int i11 = R.id.bsh_end_first_icon;
        ((ImageView) ((DSBottomSheetHeader) view2).findViewById(i11)).setOnClickListener(this.headerEndFirstIconOnClickListener);
        View view12 = getView();
        if (view12 == null) {
            view3 = null;
        } else {
            view3 = view12.findViewById(R.id.bs_button_primary);
        }
        ((DSPrimaryButton) view3).setOnClickListener(this.buttonOnClickListener);
        View view13 = getView();
        if (view13 == null) {
            view4 = null;
        } else {
            view4 = view13.findViewById(R.id.bs_button_secondary);
        }
        ((DSSecondaryButton) view4).setOnClickListener(this.buttonOnClickListener);
        View view14 = getView();
        if (view14 == null) {
            view5 = null;
        } else {
            view5 = view14.findViewById(R.id.bs_button_tertiary);
        }
        ((DSTertiaryButton) view5).setOnClickListener(this.buttonOnClickListener);
        View view15 = getView();
        if (view15 == null) {
            view6 = null;
        } else {
            view6 = view15.findViewById(R.id.bs_button_social);
        }
        ((DSSocialButton) view6).setOnClickListener(this.buttonOnClickListener);
        View view16 = getView();
        if (view16 == null) {
            view7 = null;
        } else {
            view7 = view16.findViewById(R.id.bottom_sheet_header);
        }
        ((TextView) ((DSBottomSheetHeader) view7).findViewById(R.id.bsh_end_text)).setOnClickListener(this.headerEndTextOnClick);
        View view17 = getView();
        if (view17 == null) {
            view8 = null;
        } else {
            view8 = view17.findViewById(R.id.bottom_sheet_header);
        }
        ((ImageView) ((DSBottomSheetHeader) view8).findViewById(R.id.bsh_end_second_icon)).setOnClickListener(new b(this));
        View view18 = getView();
        if (view18 != null) {
            view10 = view18.findViewById(R.id.bottom_sheet_header);
        }
        ((ImageView) ((DSBottomSheetHeader) view10).findViewById(i11)).setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnClickListeners$lambda-3  reason: not valid java name */
    public static final void m8259setOnClickListeners$lambda3(DSBottomSheet dSBottomSheet, View view) {
        View view2;
        Drawable.ConstantState constantState;
        Intrinsics.checkNotNullParameter(dSBottomSheet, "this$0");
        View.OnClickListener headerEndSecondIconOnClickListener2 = dSBottomSheet.getHeaderEndSecondIconOnClickListener();
        if (headerEndSecondIconOnClickListener2 != null) {
            headerEndSecondIconOnClickListener2.onClick(view);
        }
        Integer headerEndSecondIconAlternative2 = dSBottomSheet.getHeaderEndSecondIconAlternative();
        if (headerEndSecondIconAlternative2 != null) {
            View view3 = null;
            Drawable drawable = ResourcesCompat.getDrawable(dSBottomSheet.getResources(), headerEndSecondIconAlternative2.intValue(), (Resources.Theme) null);
            View view4 = dSBottomSheet.getView();
            if (view4 == null) {
                view2 = null;
            } else {
                view2 = view4.findViewById(R.id.bottom_sheet_header);
            }
            int i11 = R.id.bsh_end_second_icon;
            Drawable.ConstantState constantState2 = ((ImageView) ((DSBottomSheetHeader) view2).findViewById(i11)).getDrawable().getConstantState();
            boolean z11 = false;
            if (constantState2 != null) {
                if (drawable == null) {
                    constantState = null;
                } else {
                    constantState = drawable.getConstantState();
                }
                if (constantState2.equals(constantState)) {
                    z11 = true;
                }
            }
            if (z11) {
                View view5 = dSBottomSheet.getView();
                if (view5 != null) {
                    view3 = view5.findViewById(R.id.bottom_sheet_header);
                }
                ((ImageView) ((DSBottomSheetHeader) view3).findViewById(i11)).setImageDrawable(dSBottomSheet.originalHeaderEndSecondIcon);
                return;
            }
            View view6 = dSBottomSheet.getView();
            if (view6 != null) {
                view3 = view6.findViewById(R.id.bottom_sheet_header);
            }
            ((ImageView) ((DSBottomSheetHeader) view3).findViewById(i11)).setImageDrawable(drawable);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnClickListeners$lambda-5  reason: not valid java name */
    public static final void m8260setOnClickListeners$lambda5(DSBottomSheet dSBottomSheet, View view) {
        View view2;
        Drawable.ConstantState constantState;
        Intrinsics.checkNotNullParameter(dSBottomSheet, "this$0");
        View.OnClickListener headerEndFirstIconOnClickListener2 = dSBottomSheet.getHeaderEndFirstIconOnClickListener();
        if (headerEndFirstIconOnClickListener2 != null) {
            headerEndFirstIconOnClickListener2.onClick(view);
        }
        Integer headerEndFirstIconAlternative2 = dSBottomSheet.getHeaderEndFirstIconAlternative();
        if (headerEndFirstIconAlternative2 != null) {
            View view3 = null;
            Drawable drawable = ResourcesCompat.getDrawable(dSBottomSheet.getResources(), headerEndFirstIconAlternative2.intValue(), (Resources.Theme) null);
            View view4 = dSBottomSheet.getView();
            if (view4 == null) {
                view2 = null;
            } else {
                view2 = view4.findViewById(R.id.bottom_sheet_header);
            }
            int i11 = R.id.bsh_end_first_icon;
            Drawable.ConstantState constantState2 = ((ImageView) ((DSBottomSheetHeader) view2).findViewById(i11)).getDrawable().getConstantState();
            boolean z11 = false;
            if (constantState2 != null) {
                if (drawable == null) {
                    constantState = null;
                } else {
                    constantState = drawable.getConstantState();
                }
                if (constantState2.equals(constantState)) {
                    z11 = true;
                }
            }
            if (z11) {
                View view5 = dSBottomSheet.getView();
                if (view5 != null) {
                    view3 = view5.findViewById(R.id.bottom_sheet_header);
                }
                ((ImageView) ((DSBottomSheetHeader) view3).findViewById(i11)).setImageDrawable(dSBottomSheet.originalHeaderEndFirstIcon);
                return;
            }
            View view6 = dSBottomSheet.getView();
            if (view6 != null) {
                view3 = view6.findViewById(R.id.bottom_sheet_header);
            }
            ((ImageView) ((DSBottomSheetHeader) view3).findViewById(i11)).setImageDrawable(drawable);
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final View.OnClickListener getButtonOnClickListener() {
        return this.buttonOnClickListener;
    }

    @Nullable
    public final Integer getHeaderEndFirstIconAlternative() {
        return this.headerEndFirstIconAlternative;
    }

    @Nullable
    public final View.OnClickListener getHeaderEndFirstIconOnClickListener() {
        return this.headerEndFirstIconOnClickListener;
    }

    @Nullable
    public final Integer getHeaderEndSecondIconAlternative() {
        return this.headerEndSecondIconAlternative;
    }

    @Nullable
    public final View.OnClickListener getHeaderEndSecondIconOnClickListener() {
        return this.headerEndSecondIconOnClickListener;
    }

    @Nullable
    public final View.OnClickListener getHeaderEndTextOnClick() {
        return this.headerEndTextOnClick;
    }

    @Nullable
    public final View.OnClickListener getHeaderStartIconOnClickListener() {
        return this.headerStartIconOnClickListener;
    }

    @Nullable
    public final Runnable getOnDismiss() {
        return this.onDismiss;
    }

    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        Window window;
        Window window2;
        WindowManager windowManager;
        Display defaultDisplay;
        super.onActivityCreated(bundle);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        FragmentActivity activity = getActivity();
        if (!(activity == null || (windowManager = activity.getWindowManager()) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null)) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        WindowManager.LayoutParams layoutParams = null;
        if (((double) displayMetrics.heightPixels) > ((double) Resources.getSystem().getDisplayMetrics().heightPixels) * 0.75d) {
            Dialog dialog = getDialog();
            if (!(dialog == null || (window2 = dialog.getWindow()) == null)) {
                layoutParams = window2.getAttributes();
            }
            if (layoutParams != null) {
                layoutParams.windowAnimations = R.style.DialogAnimation;
                return;
            }
            return;
        }
        Dialog dialog2 = getDialog();
        if (!(dialog2 == null || (window = dialog2.getWindow()) == null)) {
            layoutParams = window.getAttributes();
        }
        if (layoutParams != null) {
            layoutParams.windowAnimations = R.style.DialogAnimationHalf;
        }
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(Companion.getLayoutReference(), viewGroup, false);
    }

    public void onDismiss(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, DialogNavigator.NAME);
        super.onDismiss(dialogInterface);
        Runnable runnable = this.onDismiss;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        View view2;
        Intrinsics.checkNotNullParameter(view, "view");
        FragmentListener fragmentListener = mFragmentListener;
        if (fragmentListener != null) {
            fragmentListener.getView(view);
        }
        View view3 = getView();
        View view4 = null;
        if (view3 == null) {
            view2 = null;
        } else {
            view2 = view3.findViewById(R.id.bottom_sheet_header);
        }
        this.originalHeaderEndSecondIcon = ((ImageView) ((DSBottomSheetHeader) view2).findViewById(R.id.bsh_end_second_icon)).getDrawable();
        View view5 = getView();
        if (view5 != null) {
            view4 = view5.findViewById(R.id.bottom_sheet_header);
        }
        this.originalHeaderEndFirstIcon = ((ImageView) ((DSBottomSheetHeader) view4).findViewById(R.id.bsh_end_first_icon)).getDrawable();
        setOnClickListeners();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(new a(this));
        }
        super.onViewCreated(view, bundle);
    }

    public final void setButtonOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.buttonOnClickListener = onClickListener;
    }

    public final void setHeaderEndFirstIconAlternative(@Nullable Integer num) {
        this.headerEndFirstIconAlternative = num;
    }

    public final void setHeaderEndFirstIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.headerEndFirstIconOnClickListener = onClickListener;
    }

    public final void setHeaderEndSecondIconAlternative(@Nullable Integer num) {
        this.headerEndSecondIconAlternative = num;
    }

    public final void setHeaderEndSecondIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.headerEndSecondIconOnClickListener = onClickListener;
    }

    public final void setHeaderEndTextOnClick(@Nullable View.OnClickListener onClickListener) {
        this.headerEndTextOnClick = onClickListener;
    }

    public final void setHeaderStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.headerStartIconOnClickListener = onClickListener;
    }

    public final void setOnDismiss(@Nullable Runnable runnable) {
        this.onDismiss = runnable;
    }

    public DSBottomSheet(int i11, @Nullable Integer num, @Nullable Integer num2, @Nullable View.OnClickListener onClickListener, @Nullable View.OnClickListener onClickListener2, @Nullable View.OnClickListener onClickListener3, @Nullable View.OnClickListener onClickListener4, @Nullable Runnable runnable, @Nullable View.OnClickListener onClickListener5) {
        this.headerEndFirstIconAlternative = num;
        this.headerEndSecondIconAlternative = num2;
        this.headerStartIconOnClickListener = onClickListener;
        this.headerEndFirstIconOnClickListener = onClickListener2;
        this.headerEndSecondIconOnClickListener = onClickListener3;
        this.buttonOnClickListener = onClickListener4;
        this.onDismiss = runnable;
        this.headerEndTextOnClick = onClickListener5;
        Companion.setLayoutReference(i11);
    }
}
