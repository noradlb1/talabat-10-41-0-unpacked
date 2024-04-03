package com.afollestad.materialdialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.CheckResult;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.callbacks.DialogCallbackExtKt;
import com.afollestad.materialdialogs.internal.button.DialogActionButton;
import com.afollestad.materialdialogs.internal.list.DialogAdapter;
import com.afollestad.materialdialogs.internal.main.DialogLayout;
import com.afollestad.materialdialogs.list.DialogListExtKt;
import com.afollestad.materialdialogs.message.DialogMessageSettings;
import com.afollestad.materialdialogs.utils.ColorsKt;
import com.afollestad.materialdialogs.utils.DialogsKt;
import com.afollestad.materialdialogs.utils.FontsKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.afollestad.materialdialogs.utils.ViewsKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 q2\u00020\u0001:\u0001qB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\bJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\bJ\u0006\u0010H\u001a\u00020\u0000J\b\u0010I\u001a\u00020\u0000H\u0007J\u0006\u0010J\u001a\u00020\u0000J\u0019\u0010$\u001a\u0002HK\"\u0004\b\u0000\u0010K2\u0006\u0010L\u001a\u00020&¢\u0006\u0002\u0010MJ#\u0010+\u001a\u00020\u00002\n\b\u0002\u0010N\u001a\u0004\u0018\u00010*2\n\b\u0003\u0010O\u001a\u0004\u0018\u000106¢\u0006\u0002\u0010PJ\u0012\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010Q\u001a\u00020\bH\u0007J\b\u0010R\u001a\u00020\u001aH\u0016J#\u0010S\u001a\u00020\u00002\n\b\u0003\u0010O\u001a\u0004\u0018\u0001062\n\b\u0002\u0010T\u001a\u0004\u0018\u00010U¢\u0006\u0002\u0010VJ\b\u0010W\u001a\u00020\u001aH\u0002J#\u00105\u001a\u00020\u00002\n\b\u0003\u0010O\u001a\u0004\u0018\u0001062\n\b\u0003\u0010X\u001a\u0004\u0018\u000106¢\u0006\u0002\u0010YJ@\u0010Z\u001a\u00020\u00002\n\b\u0003\u0010O\u001a\u0004\u0018\u0001062\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\2\u001b\b\u0002\u0010]\u001a\u0015\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019¢\u0006\u0002\b_¢\u0006\u0002\u0010`JA\u0010a\u001a\u00020\u00002\n\b\u0003\u0010O\u001a\u0004\u0018\u0001062\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\2\u001c\b\u0002\u0010b\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\u0004\u0018\u0001`\u001b¢\u0006\u0002\u0010`JC\u0010c\u001a\u00020\u00002\n\b\u0003\u0010O\u001a\u0004\u0018\u0001062\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\2\u001c\b\u0002\u0010b\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\u0004\u0018\u0001`\u001bH\u0007¢\u0006\u0002\u0010`J\b\u0010d\u001a\u00020\u0000H\u0007J\u0015\u0010e\u001a\u00020\u001a2\u0006\u0010f\u001a\u00020gH\u0000¢\u0006\u0002\bhJA\u0010i\u001a\u00020\u00002\n\b\u0003\u0010O\u001a\u0004\u0018\u0001062\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\2\u001c\b\u0002\u0010b\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\u0004\u0018\u0001`\u001b¢\u0006\u0002\u0010`J\u0010\u0010j\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\bH\u0017J\u0010\u0010k\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\bH\u0017J\b\u0010l\u001a\u00020\u001aH\u0002J\b\u0010m\u001a\u00020\u001aH\u0016J\"\u0010m\u001a\u00020\u00002\u0017\u0010n\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b_H\bJ#\u0010o\u001a\u00020\u00002\n\b\u0003\u0010O\u001a\u0004\u0018\u0001062\n\b\u0002\u0010[\u001a\u0004\u0018\u00010&¢\u0006\u0002\u0010pR$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000e@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000e@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R*\u0010\u0017\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001a0\u0019j\u0002`\u001b0\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\rR$\u0010!\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000b\"\u0004\b#\u0010\rR\u001d\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R*\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\u0007\u001a\u0004\u0018\u00010*@@X\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R*\u00103\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001a0\u0019j\u0002`\u001b0\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001dR\u0016\u00105\u001a\u0004\u0018\u0001068\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u00107R$\u00108\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001a0\u0019j\u0002`\u001b0\u0018X\u0004¢\u0006\u0002\n\u0000R$\u00109\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001a0\u0019j\u0002`\u001b0\u0018X\u0004¢\u0006\u0002\n\u0000R$\u0010:\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001a0\u0019j\u0002`\u001b0\u0018X\u0004¢\u0006\u0002\n\u0000R*\u0010;\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001a0\u0019j\u0002`\u001b0\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u001dR*\u0010=\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001a0\u0019j\u0002`\u001b0\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u001dR(\u0010?\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000e@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0011\"\u0004\bA\u0010\u0013R\u0011\u0010B\u001a\u00020C¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010G¨\u0006r"}, d2 = {"Lcom/afollestad/materialdialogs/MaterialDialog;", "Landroid/app/Dialog;", "windowContext", "Landroid/content/Context;", "dialogBehavior", "Lcom/afollestad/materialdialogs/DialogBehavior;", "(Landroid/content/Context;Lcom/afollestad/materialdialogs/DialogBehavior;)V", "<set-?>", "", "autoDismissEnabled", "getAutoDismissEnabled", "()Z", "setAutoDismissEnabled$com_afollestad_material_dialogs_core", "(Z)V", "Landroid/graphics/Typeface;", "bodyFont", "getBodyFont", "()Landroid/graphics/Typeface;", "setBodyFont$com_afollestad_material_dialogs_core", "(Landroid/graphics/Typeface;)V", "buttonFont", "getButtonFont", "setButtonFont$com_afollestad_material_dialogs_core", "cancelListeners", "", "Lkotlin/Function1;", "", "Lcom/afollestad/materialdialogs/DialogCallback;", "getCancelListeners$com_afollestad_material_dialogs_core", "()Ljava/util/List;", "cancelOnTouchOutside", "getCancelOnTouchOutside", "setCancelOnTouchOutside$com_afollestad_material_dialogs_core", "cancelable", "getCancelable", "setCancelable$com_afollestad_material_dialogs_core", "config", "", "", "", "getConfig", "()Ljava/util/Map;", "", "cornerRadius", "getCornerRadius", "()Ljava/lang/Float;", "setCornerRadius$com_afollestad_material_dialogs_core", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getDialogBehavior", "()Lcom/afollestad/materialdialogs/DialogBehavior;", "dismissListeners", "getDismissListeners$com_afollestad_material_dialogs_core", "maxWidth", "", "Ljava/lang/Integer;", "negativeListeners", "neutralListeners", "positiveListeners", "preShowListeners", "getPreShowListeners$com_afollestad_material_dialogs_core", "showListeners", "getShowListeners$com_afollestad_material_dialogs_core", "titleFont", "getTitleFont", "setTitleFont$com_afollestad_material_dialogs_core", "view", "Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "getView", "()Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "getWindowContext", "()Landroid/content/Context;", "clearNegativeListeners", "clearNeutralListeners", "clearPositiveListeners", "T", "key", "(Ljava/lang/String;)Ljava/lang/Object;", "literalDp", "res", "(Ljava/lang/Float;Ljava/lang/Integer;)Lcom/afollestad/materialdialogs/MaterialDialog;", "debugMode", "dismiss", "icon", "drawable", "Landroid/graphics/drawable/Drawable;", "(Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;)Lcom/afollestad/materialdialogs/MaterialDialog;", "invalidateBackgroundColorAndRadius", "literal", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/afollestad/materialdialogs/MaterialDialog;", "message", "text", "", "applySettings", "Lcom/afollestad/materialdialogs/message/DialogMessageSettings;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Integer;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Lcom/afollestad/materialdialogs/MaterialDialog;", "negativeButton", "click", "neutralButton", "noAutoDismiss", "onActionButtonClicked", "which", "Lcom/afollestad/materialdialogs/WhichButton;", "onActionButtonClicked$com_afollestad_material_dialogs_core", "positiveButton", "setCancelable", "setCanceledOnTouchOutside", "setWindowConstraints", "show", "func", "title", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/afollestad/materialdialogs/MaterialDialog;", "Companion", "com.afollestad.material-dialogs.core"}, k = 1, mv = {1, 1, 15})
public final class MaterialDialog extends Dialog {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static DialogBehavior DEFAULT_BEHAVIOR = ModalDialog.INSTANCE;
    private boolean autoDismissEnabled;
    @Nullable
    private Typeface bodyFont;
    @Nullable
    private Typeface buttonFont;
    @NotNull
    private final List<Function1<MaterialDialog, Unit>> cancelListeners;
    private boolean cancelOnTouchOutside;
    private boolean cancelable;
    @NotNull
    private final Map<String, Object> config;
    @Nullable
    private Float cornerRadius;
    @NotNull
    private final DialogBehavior dialogBehavior;
    @NotNull
    private final List<Function1<MaterialDialog, Unit>> dismissListeners;
    @Px
    private Integer maxWidth;
    private final List<Function1<MaterialDialog, Unit>> negativeListeners;
    private final List<Function1<MaterialDialog, Unit>> neutralListeners;
    private final List<Function1<MaterialDialog, Unit>> positiveListeners;
    @NotNull
    private final List<Function1<MaterialDialog, Unit>> preShowListeners;
    @NotNull
    private final List<Function1<MaterialDialog, Unit>> showListeners;
    @Nullable
    private Typeface titleFont;
    @NotNull
    private final DialogLayout view;
    @NotNull
    private final Context windowContext;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/afollestad/materialdialogs/MaterialDialog$Companion;", "", "()V", "DEFAULT_BEHAVIOR", "Lcom/afollestad/materialdialogs/DialogBehavior;", "DEFAULT_BEHAVIOR$annotations", "getDEFAULT_BEHAVIOR", "()Lcom/afollestad/materialdialogs/DialogBehavior;", "setDEFAULT_BEHAVIOR", "(Lcom/afollestad/materialdialogs/DialogBehavior;)V", "com.afollestad.material-dialogs.core"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void DEFAULT_BEHAVIOR$annotations() {
        }

        @NotNull
        public final DialogBehavior getDEFAULT_BEHAVIOR() {
            return MaterialDialog.DEFAULT_BEHAVIOR;
        }

        public final void setDEFAULT_BEHAVIOR(@NotNull DialogBehavior dialogBehavior) {
            Intrinsics.checkParameterIsNotNull(dialogBehavior, "<set-?>");
            MaterialDialog.DEFAULT_BEHAVIOR = dialogBehavior;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WhichButton.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[WhichButton.POSITIVE.ordinal()] = 1;
            iArr[WhichButton.NEGATIVE.ordinal()] = 2;
            iArr[WhichButton.NEUTRAL.ordinal()] = 3;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MaterialDialog(Context context, DialogBehavior dialogBehavior2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? DEFAULT_BEHAVIOR : dialogBehavior2);
    }

    public static /* synthetic */ MaterialDialog cornerRadius$default(MaterialDialog materialDialog, Float f11, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = null;
        }
        if ((i11 & 2) != 0) {
            num = null;
        }
        return materialDialog.cornerRadius(f11, num);
    }

    public static /* synthetic */ MaterialDialog debugMode$default(MaterialDialog materialDialog, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        return materialDialog.debugMode(z11);
    }

    @NotNull
    public static final DialogBehavior getDEFAULT_BEHAVIOR() {
        return DEFAULT_BEHAVIOR;
    }

    public static /* synthetic */ MaterialDialog icon$default(MaterialDialog materialDialog, Integer num, Drawable drawable, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        if ((i11 & 2) != 0) {
            drawable = null;
        }
        return materialDialog.icon(num, drawable);
    }

    private final void invalidateBackgroundColorAndRadius() {
        float f11;
        int resolveColor$default = ColorsKt.resolveColor$default(this, (Integer) null, Integer.valueOf(R.attr.md_background_color), new MaterialDialog$invalidateBackgroundColorAndRadius$backgroundColor$1(this), 1, (Object) null);
        Float f12 = this.cornerRadius;
        if (f12 != null) {
            f11 = f12.floatValue();
        } else {
            f11 = MDUtil.resolveDimen$default(MDUtil.INSTANCE, this.windowContext, R.attr.md_corner_radius, 0.0f, 4, (Object) null);
        }
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        this.dialogBehavior.setBackgroundColor(this.view, resolveColor$default, f11);
    }

    public static /* synthetic */ MaterialDialog maxWidth$default(MaterialDialog materialDialog, Integer num, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        if ((i11 & 2) != 0) {
            num2 = null;
        }
        return materialDialog.maxWidth(num, num2);
    }

    public static /* synthetic */ MaterialDialog message$default(MaterialDialog materialDialog, Integer num, CharSequence charSequence, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        if ((i11 & 2) != 0) {
            charSequence = null;
        }
        if ((i11 & 4) != 0) {
            function1 = null;
        }
        return materialDialog.message(num, charSequence, function1);
    }

    public static /* synthetic */ MaterialDialog negativeButton$default(MaterialDialog materialDialog, Integer num, CharSequence charSequence, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        if ((i11 & 2) != 0) {
            charSequence = null;
        }
        if ((i11 & 4) != 0) {
            function1 = null;
        }
        return materialDialog.negativeButton(num, charSequence, function1);
    }

    public static /* synthetic */ MaterialDialog neutralButton$default(MaterialDialog materialDialog, Integer num, CharSequence charSequence, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        if ((i11 & 2) != 0) {
            charSequence = null;
        }
        if ((i11 & 4) != 0) {
            function1 = null;
        }
        return materialDialog.neutralButton(num, charSequence, function1);
    }

    public static /* synthetic */ MaterialDialog positiveButton$default(MaterialDialog materialDialog, Integer num, CharSequence charSequence, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        if ((i11 & 2) != 0) {
            charSequence = null;
        }
        if ((i11 & 4) != 0) {
            function1 = null;
        }
        return materialDialog.positiveButton(num, charSequence, function1);
    }

    public static final void setDEFAULT_BEHAVIOR(@NotNull DialogBehavior dialogBehavior2) {
        DEFAULT_BEHAVIOR = dialogBehavior2;
    }

    private final void setWindowConstraints() {
        DialogBehavior dialogBehavior2 = this.dialogBehavior;
        Context context = this.windowContext;
        Integer num = this.maxWidth;
        Window window = getWindow();
        if (window == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(window, "window!!");
        dialogBehavior2.setWindowConstraints(context, window, this.view, num);
    }

    public static /* synthetic */ MaterialDialog title$default(MaterialDialog materialDialog, Integer num, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        if ((i11 & 2) != 0) {
            str = null;
        }
        return materialDialog.title(num, str);
    }

    @NotNull
    public final MaterialDialog cancelOnTouchOutside(boolean z11) {
        setCanceledOnTouchOutside(z11);
        return this;
    }

    @NotNull
    public final MaterialDialog cancelable(boolean z11) {
        setCancelable(z11);
        return this;
    }

    @NotNull
    public final MaterialDialog clearNegativeListeners() {
        this.negativeListeners.clear();
        return this;
    }

    @NotNull
    @Deprecated(message = "Use of neutral buttons is discouraged, see https://material.io/design/components/dialogs.html#actions.")
    public final MaterialDialog clearNeutralListeners() {
        this.neutralListeners.clear();
        return this;
    }

    @NotNull
    public final MaterialDialog clearPositiveListeners() {
        this.positiveListeners.clear();
        return this;
    }

    public final <T> T config(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return this.config.get(str);
    }

    @NotNull
    public final MaterialDialog cornerRadius(@Nullable Float f11, @Nullable @DimenRes Integer num) {
        Float f12;
        MDUtil.INSTANCE.assertOneSet("cornerRadius", f11, num);
        if (num != null) {
            f12 = Float.valueOf(this.windowContext.getResources().getDimension(num.intValue()));
        } else {
            Resources resources = this.windowContext.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "windowContext.resources");
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            if (f11 == null) {
                Intrinsics.throwNpe();
            }
            f12 = Float.valueOf(TypedValue.applyDimension(1, f11.floatValue(), displayMetrics));
        }
        this.cornerRadius = f12;
        invalidateBackgroundColorAndRadius();
        return this;
    }

    @CheckResult
    @NotNull
    public final MaterialDialog debugMode(boolean z11) {
        this.view.setDebugMode(z11);
        return this;
    }

    public void dismiss() {
        if (!this.dialogBehavior.onDismiss()) {
            DialogsKt.hideKeyboard(this);
            super.dismiss();
        }
    }

    public final boolean getAutoDismissEnabled() {
        return this.autoDismissEnabled;
    }

    @Nullable
    public final Typeface getBodyFont() {
        return this.bodyFont;
    }

    @Nullable
    public final Typeface getButtonFont() {
        return this.buttonFont;
    }

    @NotNull
    public final List<Function1<MaterialDialog, Unit>> getCancelListeners$com_afollestad_material_dialogs_core() {
        return this.cancelListeners;
    }

    public final boolean getCancelOnTouchOutside() {
        return this.cancelOnTouchOutside;
    }

    public final boolean getCancelable() {
        return this.cancelable;
    }

    @NotNull
    public final Map<String, Object> getConfig() {
        return this.config;
    }

    @Nullable
    public final Float getCornerRadius() {
        return this.cornerRadius;
    }

    @NotNull
    public final DialogBehavior getDialogBehavior() {
        return this.dialogBehavior;
    }

    @NotNull
    public final List<Function1<MaterialDialog, Unit>> getDismissListeners$com_afollestad_material_dialogs_core() {
        return this.dismissListeners;
    }

    @NotNull
    public final List<Function1<MaterialDialog, Unit>> getPreShowListeners$com_afollestad_material_dialogs_core() {
        return this.preShowListeners;
    }

    @NotNull
    public final List<Function1<MaterialDialog, Unit>> getShowListeners$com_afollestad_material_dialogs_core() {
        return this.showListeners;
    }

    @Nullable
    public final Typeface getTitleFont() {
        return this.titleFont;
    }

    @NotNull
    public final DialogLayout getView() {
        return this.view;
    }

    @NotNull
    public final Context getWindowContext() {
        return this.windowContext;
    }

    @NotNull
    public final MaterialDialog icon(@Nullable @DrawableRes Integer num, @Nullable Drawable drawable) {
        MDUtil.INSTANCE.assertOneSet("icon", drawable, num);
        DialogsKt.populateIcon(this, this.view.getTitleLayout().getIconView$com_afollestad_material_dialogs_core(), num, drawable);
        return this;
    }

    @NotNull
    public final MaterialDialog maxWidth(@Nullable @DimenRes Integer num, @Px @Nullable Integer num2) {
        boolean z11;
        MDUtil.INSTANCE.assertOneSet("maxWidth", num, num2);
        Integer num3 = this.maxWidth;
        if (num3 == null || num3 == null || num3.intValue() != 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (num != null) {
            num2 = Integer.valueOf(this.windowContext.getResources().getDimensionPixelSize(num.intValue()));
        } else if (num2 == null) {
            Intrinsics.throwNpe();
        }
        this.maxWidth = num2;
        if (z11) {
            setWindowConstraints();
        }
        return this;
    }

    @NotNull
    public final MaterialDialog message(@Nullable @StringRes Integer num, @Nullable CharSequence charSequence, @Nullable Function1<? super DialogMessageSettings, Unit> function1) {
        MDUtil.INSTANCE.assertOneSet("message", charSequence, num);
        this.view.getContentLayout().setMessage(this, num, charSequence, this.bodyFont, function1);
        return this;
    }

    @NotNull
    public final MaterialDialog negativeButton(@Nullable @StringRes Integer num, @Nullable CharSequence charSequence, @Nullable Function1<? super MaterialDialog, Unit> function1) {
        if (function1 != null) {
            this.negativeListeners.add(function1);
        }
        DialogActionButton actionButton = DialogActionExtKt.getActionButton(this, WhichButton.NEGATIVE);
        if (num == null && charSequence == null && ViewsKt.isVisible(actionButton)) {
            return this;
        }
        DialogsKt.populateText(this, actionButton, num, charSequence, 17039360, this.buttonFont, Integer.valueOf(R.attr.md_color_button_text));
        return this;
    }

    @NotNull
    @Deprecated(message = "Use of neutral buttons is discouraged, see https://material.io/design/components/dialogs.html#actions.")
    public final MaterialDialog neutralButton(@Nullable @StringRes Integer num, @Nullable CharSequence charSequence, @Nullable Function1<? super MaterialDialog, Unit> function1) {
        if (function1 != null) {
            this.neutralListeners.add(function1);
        }
        DialogActionButton actionButton = DialogActionExtKt.getActionButton(this, WhichButton.NEUTRAL);
        if (num == null && charSequence == null && ViewsKt.isVisible(actionButton)) {
            return this;
        }
        DialogsKt.populateText$default(this, actionButton, num, charSequence, 0, this.buttonFont, (Integer) null, 40, (Object) null);
        return this;
    }

    @CheckResult
    @NotNull
    public final MaterialDialog noAutoDismiss() {
        this.autoDismissEnabled = false;
        return this;
    }

    public final void onActionButtonClicked$com_afollestad_material_dialogs_core(@NotNull WhichButton whichButton) {
        Intrinsics.checkParameterIsNotNull(whichButton, "which");
        int i11 = WhenMappings.$EnumSwitchMapping$0[whichButton.ordinal()];
        if (i11 == 1) {
            DialogCallbackExtKt.invokeAll(this.positiveListeners, this);
            RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(this);
            if (!(listAdapter instanceof DialogAdapter)) {
                listAdapter = null;
            }
            DialogAdapter dialogAdapter = (DialogAdapter) listAdapter;
            if (dialogAdapter != null) {
                dialogAdapter.positiveButtonClicked();
            }
        } else if (i11 == 2) {
            DialogCallbackExtKt.invokeAll(this.negativeListeners, this);
        } else if (i11 == 3) {
            DialogCallbackExtKt.invokeAll(this.neutralListeners, this);
        }
        if (this.autoDismissEnabled) {
            dismiss();
        }
    }

    @NotNull
    public final MaterialDialog positiveButton(@Nullable @StringRes Integer num, @Nullable CharSequence charSequence, @Nullable Function1<? super MaterialDialog, Unit> function1) {
        if (function1 != null) {
            this.positiveListeners.add(function1);
        }
        DialogActionButton actionButton = DialogActionExtKt.getActionButton(this, WhichButton.POSITIVE);
        if (num == null && charSequence == null && ViewsKt.isVisible(actionButton)) {
            return this;
        }
        DialogsKt.populateText(this, actionButton, num, charSequence, 17039370, this.buttonFont, Integer.valueOf(R.attr.md_color_button_text));
        return this;
    }

    public final void setAutoDismissEnabled$com_afollestad_material_dialogs_core(boolean z11) {
        this.autoDismissEnabled = z11;
    }

    public final void setBodyFont$com_afollestad_material_dialogs_core(@Nullable Typeface typeface) {
        this.bodyFont = typeface;
    }

    public final void setButtonFont$com_afollestad_material_dialogs_core(@Nullable Typeface typeface) {
        this.buttonFont = typeface;
    }

    public final void setCancelOnTouchOutside$com_afollestad_material_dialogs_core(boolean z11) {
        this.cancelOnTouchOutside = z11;
    }

    @Deprecated(message = "Use fluent cancelable(Boolean) instead.", replaceWith = @ReplaceWith(expression = "cancelable(cancelable)", imports = {}))
    public void setCancelable(boolean z11) {
        this.cancelable = z11;
        super.setCancelable(z11);
    }

    public final void setCancelable$com_afollestad_material_dialogs_core(boolean z11) {
        this.cancelable = z11;
    }

    @Deprecated(message = "Use fluent cancelOnTouchOutside(Boolean) instead.", replaceWith = @ReplaceWith(expression = "cancelOnTouchOutside(cancelOnTouchOutside)", imports = {}))
    public void setCanceledOnTouchOutside(boolean z11) {
        this.cancelOnTouchOutside = z11;
        super.setCanceledOnTouchOutside(z11);
    }

    public final void setCornerRadius$com_afollestad_material_dialogs_core(@Nullable Float f11) {
        this.cornerRadius = f11;
    }

    public final void setTitleFont$com_afollestad_material_dialogs_core(@Nullable Typeface typeface) {
        this.titleFont = typeface;
    }

    public void show() {
        setWindowConstraints();
        DialogsKt.preShow(this);
        this.dialogBehavior.onPreShow(this);
        super.show();
        this.dialogBehavior.onPostShow(this);
    }

    @NotNull
    public final MaterialDialog title(@Nullable @StringRes Integer num, @Nullable String str) {
        MDUtil.INSTANCE.assertOneSet("title", str, num);
        DialogsKt.populateText$default(this, this.view.getTitleLayout().getTitleView$com_afollestad_material_dialogs_core(), num, str, 0, this.titleFont, Integer.valueOf(R.attr.md_color_title), 8, (Object) null);
        return this;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaterialDialog(@NotNull Context context, @NotNull DialogBehavior dialogBehavior2) {
        super(context, ThemeKt.inferTheme(context, dialogBehavior2));
        Intrinsics.checkParameterIsNotNull(context, "windowContext");
        Intrinsics.checkParameterIsNotNull(dialogBehavior2, "dialogBehavior");
        this.windowContext = context;
        this.dialogBehavior = dialogBehavior2;
        this.config = new LinkedHashMap();
        this.autoDismissEnabled = true;
        this.cancelOnTouchOutside = true;
        this.cancelable = true;
        this.preShowListeners = new ArrayList();
        this.showListeners = new ArrayList();
        this.dismissListeners = new ArrayList();
        this.cancelListeners = new ArrayList();
        this.positiveListeners = new ArrayList();
        this.negativeListeners = new ArrayList();
        this.neutralListeners = new ArrayList();
        LayoutInflater from = LayoutInflater.from(context);
        Window window = getWindow();
        if (window == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(window, "window!!");
        Intrinsics.checkExpressionValueIsNotNull(from, "layoutInflater");
        ViewGroup createView = dialogBehavior2.createView(context, window, from, this);
        setContentView(createView);
        DialogLayout dialogLayout = dialogBehavior2.getDialogLayout(createView);
        dialogLayout.attachDialog(this);
        this.view = dialogLayout;
        this.titleFont = FontsKt.font$default(this, (Integer) null, Integer.valueOf(R.attr.md_font_title), 1, (Object) null);
        this.bodyFont = FontsKt.font$default(this, (Integer) null, Integer.valueOf(R.attr.md_font_body), 1, (Object) null);
        this.buttonFont = FontsKt.font$default(this, (Integer) null, Integer.valueOf(R.attr.md_font_button), 1, (Object) null);
        invalidateBackgroundColorAndRadius();
    }

    @NotNull
    public final MaterialDialog show(@NotNull Function1<? super MaterialDialog, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "func");
        function1.invoke(this);
        show();
        return this;
    }
}
