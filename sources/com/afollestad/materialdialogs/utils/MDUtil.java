package com.afollestad.materialdialogs.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\nJ$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0003\u0010\u000f\u001a\u00020\t2\b\b\u0003\u0010\u0010\u001a\u00020\tH\u0007J?\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016J?\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00182%\b\u0002\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\t\u0018\u00010\u001aH\u0007J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007J;\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\"H\u0007¢\u0006\u0002\u0010#J$\u0010$\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\tH\u0007J9\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010'\u001a\u00020(H\u0007¢\u0006\u0002\u0010)J9\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010*\u001a\u00020+2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010'\u001a\u00020(H\u0007¢\u0006\u0002\u0010,J%\u0010-\u001a\u00020\t\"\b\b\u0000\u0010.*\u00020/*\u0002H.2\b\b\u0001\u0010\u0012\u001a\u00020\tH\u0007¢\u0006\u0002\u00100J#\u00101\u001a\b\u0012\u0004\u0012\u00020\u000602*\u00020\u000e2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u00103J\u0018\u00104\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t05*\u000206H\u0007J7\u00107\u001a\u00020\u0004*\u0004\u0018\u00010\t2!\u00108\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u00040\u001aH\b¢\u0006\u0002\u0010:J/\u0010;\u001a\u0002H<\"\b\b\u0000\u0010<*\u00020/*\u00020=2\b\b\u0002\u0010>\u001a\u00020\u000e2\b\b\u0001\u0010\u0012\u001a\u00020\tH\u0007¢\u0006\u0002\u0010?J\u0016\u0010@\u001a\u00020(*\u00020\t2\b\b\u0002\u0010A\u001a\u00020BH\u0007J\f\u0010C\u001a\u00020(*\u00020\u000eH\u0007J3\u0010D\u001a\u00020\u0004*\u0004\u0018\u00010E2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0001\u0010F\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010G\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010HJ \u0010I\u001a\u00020\u0004*\u00020J2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00040\u001aH\u0007JE\u0010L\u001a\u00020\u0004\"\b\b\u0000\u0010.*\u00020/*\u0004\u0018\u0001H.2\b\b\u0002\u0010M\u001a\u00020\t2\b\b\u0002\u0010N\u001a\u00020\t2\b\b\u0002\u0010O\u001a\u00020\t2\b\b\u0002\u0010P\u001a\u00020\tH\u0007¢\u0006\u0002\u0010QJ4\u0010R\u001a\u00020\u0004\"\b\b\u0000\u0010.*\u00020/*\u0002H.2\u0017\u00108\u001a\u0013\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u00020\u00040\u001a¢\u0006\u0002\bSH\u0007¢\u0006\u0002\u0010TJ4\u0010U\u001a\u00020\u0004\"\b\b\u0000\u0010.*\u00020/*\u0002H.2\u0017\u00108\u001a\u0013\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u00020\u00040\u001a¢\u0006\u0002\bSH\u0007¢\u0006\u0002\u0010T¨\u0006V"}, d2 = {"Lcom/afollestad/materialdialogs/utils/MDUtil;", "", "()V", "assertOneSet", "", "method", "", "b", "a", "", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Integer;)V", "createColorSelector", "Landroid/content/res/ColorStateList;", "context", "Landroid/content/Context;", "unchecked", "checked", "resolveColor", "res", "attr", "fallback", "Lkotlin/Function0;", "(Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)I", "resolveColors", "", "attrs", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forAttr", "resolveDimen", "", "defaultValue", "resolveDrawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "resolveInt", "resolveString", "", "html", "", "(Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Integer;Z)Ljava/lang/CharSequence;", "materialDialog", "Lcom/afollestad/materialdialogs/MaterialDialog;", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/lang/Integer;Z)Ljava/lang/CharSequence;", "dimenPx", "T", "Landroid/view/View;", "(Landroid/view/View;I)I", "getStringArray", "", "(Landroid/content/Context;Ljava/lang/Integer;)[Ljava/lang/String;", "getWidthAndHeight", "Lkotlin/Pair;", "Landroid/view/WindowManager;", "ifNotZero", "block", "value", "(Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "inflate", "R", "Landroid/view/ViewGroup;", "ctxt", "(Landroid/view/ViewGroup;Landroid/content/Context;I)Landroid/view/View;", "isColorDark", "threshold", "", "isLandscape", "maybeSetTextColor", "Landroid/widget/TextView;", "attrRes", "hintAttrRes", "(Landroid/widget/TextView;Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Integer;)V", "textChanged", "Landroid/widget/EditText;", "callback", "updatePadding", "left", "top", "right", "bottom", "(Landroid/view/View;IIII)V", "waitForHeight", "Lkotlin/ExtensionFunctionType;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "waitForWidth", "com.afollestad.material-dialogs.core"}, k = 1, mv = {1, 1, 15})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MDUtil {
    public static final MDUtil INSTANCE = new MDUtil();

    private MDUtil() {
    }

    public static /* synthetic */ ColorStateList createColorSelector$default(MDUtil mDUtil, Context context, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = 0;
        }
        return mDUtil.createColorSelector(context, i11, i12);
    }

    public static /* synthetic */ View inflate$default(MDUtil mDUtil, ViewGroup viewGroup, Context context, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            context = viewGroup.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
        }
        return mDUtil.inflate(viewGroup, context, i11);
    }

    public static /* synthetic */ boolean isColorDark$default(MDUtil mDUtil, int i11, double d11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            d11 = 0.5d;
        }
        return mDUtil.isColorDark(i11, d11);
    }

    public static /* synthetic */ void maybeSetTextColor$default(MDUtil mDUtil, TextView textView, Context context, Integer num, Integer num2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            num2 = null;
        }
        mDUtil.maybeSetTextColor(textView, context, num, num2);
    }

    public static /* synthetic */ int resolveColor$default(MDUtil mDUtil, Context context, Integer num, Integer num2, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            num = null;
        }
        if ((i11 & 4) != 0) {
            num2 = null;
        }
        if ((i11 & 8) != 0) {
            function0 = null;
        }
        return mDUtil.resolveColor(context, num, num2, function0);
    }

    public static /* synthetic */ int[] resolveColors$default(MDUtil mDUtil, Context context, int[] iArr, Function1 function1, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            function1 = null;
        }
        return mDUtil.resolveColors(context, iArr, function1);
    }

    public static /* synthetic */ float resolveDimen$default(MDUtil mDUtil, Context context, int i11, float f11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            f11 = 0.0f;
        }
        return mDUtil.resolveDimen(context, i11, f11);
    }

    public static /* synthetic */ Drawable resolveDrawable$default(MDUtil mDUtil, Context context, Integer num, Integer num2, Drawable drawable, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            num = null;
        }
        if ((i11 & 4) != 0) {
            num2 = null;
        }
        if ((i11 & 8) != 0) {
            drawable = null;
        }
        return mDUtil.resolveDrawable(context, num, num2, drawable);
    }

    public static /* synthetic */ int resolveInt$default(MDUtil mDUtil, Context context, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i12 = 0;
        }
        return mDUtil.resolveInt(context, i11, i12);
    }

    public static /* synthetic */ CharSequence resolveString$default(MDUtil mDUtil, MaterialDialog materialDialog, Integer num, Integer num2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            num = null;
        }
        if ((i11 & 4) != 0) {
            num2 = null;
        }
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        return mDUtil.resolveString(materialDialog, num, num2, z11);
    }

    public static /* synthetic */ void updatePadding$default(MDUtil mDUtil, View view, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            if (view != null) {
                i11 = view.getPaddingLeft();
            } else {
                i11 = 0;
            }
        }
        int i16 = i11;
        if ((i15 & 2) != 0) {
            if (view != null) {
                i12 = view.getPaddingTop();
            } else {
                i12 = 0;
            }
        }
        int i17 = i12;
        if ((i15 & 4) != 0) {
            if (view != null) {
                i13 = view.getPaddingRight();
            } else {
                i13 = 0;
            }
        }
        int i18 = i13;
        if ((i15 & 8) != 0) {
            if (view != null) {
                i14 = view.getPaddingBottom();
            } else {
                i14 = 0;
            }
        }
        mDUtil.updatePadding(view, i16, i17, i18, i14);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void assertOneSet(@NotNull String str, @Nullable Object obj, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(str, "method");
        if (num == null && obj == null) {
            throw new IllegalArgumentException(str + ": You must specify a resource ID or literal value");
        }
    }

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ColorStateList createColorSelector(@NotNull Context context, @ColorInt int i11, @ColorInt int i12) {
        int i13;
        int i14;
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (i12 == 0) {
            i13 = resolveColor$default(this, context, (Integer) null, Integer.valueOf(R.attr.colorControlActivated), (Function0) null, 10, (Object) null);
        } else {
            i13 = i12;
        }
        int[][] iArr = {new int[]{-16842912, -16842908}, new int[]{16842912}, new int[]{16842908}};
        int[] iArr2 = new int[3];
        if (i11 == 0) {
            i14 = resolveColor$default(this, context, (Integer) null, Integer.valueOf(R.attr.colorControlNormal), (Function0) null, 10, (Object) null);
        } else {
            i14 = i11;
        }
        iArr2[0] = i14;
        iArr2[1] = i13;
        iArr2[2] = i13;
        return new ColorStateList(iArr, iArr2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final <T extends View> int dimenPx(@NotNull T t11, @DimenRes int i11) {
        Intrinsics.checkParameterIsNotNull(t11, "$this$dimenPx");
        Context context = t11.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return context.getResources().getDimensionPixelSize(i11);
    }

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String[] getStringArray(@NotNull Context context, @Nullable @ArrayRes Integer num) {
        Intrinsics.checkParameterIsNotNull(context, "$this$getStringArray");
        if (num == null) {
            return new String[0];
        }
        String[] stringArray = context.getResources().getStringArray(num.intValue());
        Intrinsics.checkExpressionValueIsNotNull(stringArray, "resources.getStringArray(res)");
        return stringArray;
    }

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Pair<Integer, Integer> getWidthAndHeight(@NotNull WindowManager windowManager) {
        Intrinsics.checkParameterIsNotNull(windowManager, "$this$getWidthAndHeight");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return new Pair<>(Integer.valueOf(point.x), Integer.valueOf(point.y));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void ifNotZero(@Nullable Integer num, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "block");
        if (num != null && num.intValue() != 0) {
            function1.invoke(num);
        }
    }

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final <R extends View> R inflate(@NotNull ViewGroup viewGroup, @NotNull Context context, @LayoutRes int i11) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$this$inflate");
        Intrinsics.checkParameterIsNotNull(context, "ctxt");
        R inflate = LayoutInflater.from(context).inflate(i11, viewGroup, false);
        if (inflate != null) {
            return inflate;
        }
        throw new TypeCastException("null cannot be cast to non-null type R");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isColorDark(int i11, double d11) {
        return i11 != 0 && ((double) 1) - ((((((double) Color.red(i11)) * 0.299d) + (((double) Color.green(i11)) * 0.587d)) + (((double) Color.blue(i11)) * 0.114d)) / ((double) 255)) >= d11;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isLandscape(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$this$isLandscape");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        if (resources.getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void maybeSetTextColor(@Nullable TextView textView, @NotNull Context context, @Nullable @AttrRes Integer num, @Nullable @AttrRes Integer num2) {
        int resolveColor$default;
        int resolveColor$default2;
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (textView == null) {
            return;
        }
        if (num != null || num2 != null) {
            if (!(num == null || (resolveColor$default2 = resolveColor$default(this, context, (Integer) null, num, (Function0) null, 10, (Object) null)) == 0)) {
                textView.setTextColor(resolveColor$default2);
            }
            if (num2 != null && (resolveColor$default = resolveColor$default(this, context, (Integer) null, num2, (Function0) null, 10, (Object) null)) != 0) {
                textView.setHintTextColor(resolveColor$default);
            }
        }
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int resolveColor(@NotNull Context context, @Nullable @ColorRes Integer num, @Nullable @AttrRes Integer num2, @Nullable Function0<Integer> function0) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        int i11 = 0;
        if (num2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{num2.intValue()});
            try {
                int color = obtainStyledAttributes.getColor(0, 0);
                if (color == 0 && function0 != null) {
                    return function0.invoke().intValue();
                }
                obtainStyledAttributes.recycle();
                return color;
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            if (num != null) {
                i11 = num.intValue();
            }
            return ContextCompat.getColor(context, i11);
        }
    }

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int[] resolveColors(@NotNull Context context, @NotNull int[] iArr, @Nullable Function1<? super Integer, Integer> function1) {
        Integer invoke;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(iArr, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(iArr);
        try {
            IntRange until = RangesKt___RangesKt.until(0, iArr.length);
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10));
            Iterator it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                int color = obtainStyledAttributes.getColor(nextInt, 0);
                if (color == 0) {
                    if (function1 == null || (invoke = function1.invoke(Integer.valueOf(iArr[nextInt]))) == null) {
                        color = 0;
                    } else {
                        color = invoke.intValue();
                    }
                }
                arrayList.add(Integer.valueOf(color));
            }
            return CollectionsKt___CollectionsKt.toIntArray(arrayList);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final float resolveDimen(@NotNull Context context, @AttrRes int i11, float f11) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i11});
        try {
            return obtainStyledAttributes.getDimension(0, f11);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Drawable resolveDrawable(@NotNull Context context, @Nullable @DrawableRes Integer num, @Nullable @AttrRes Integer num2, @Nullable Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (num2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{num2.intValue()});
            try {
                Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
                if (drawable2 != null || drawable == null) {
                    drawable = drawable2;
                }
                return drawable;
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else if (num == null) {
            return drawable;
        } else {
            return ContextCompat.getDrawable(context, num.intValue());
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int resolveInt(@NotNull Context context, @AttrRes int i11, int i12) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i11});
        try {
            return obtainStyledAttributes.getInt(0, i12);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final CharSequence resolveString(@NotNull MaterialDialog materialDialog, @Nullable @StringRes Integer num, @Nullable @StringRes Integer num2, boolean z11) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "materialDialog");
        return resolveString(materialDialog.getWindowContext(), num, num2, z11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void textChanged(@NotNull EditText editText, @NotNull Function1<? super CharSequence, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(editText, "$this$textChanged");
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        editText.addTextChangedListener(new MDUtil$textChanged$1(function1));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final <T extends View> void updatePadding(@Nullable T t11, int i11, int i12, int i13, int i14) {
        if ((t11 == null || i11 != t11.getPaddingLeft() || i12 != t11.getPaddingTop() || i13 != t11.getPaddingRight() || i14 != t11.getPaddingBottom()) && t11 != null) {
            t11.setPadding(i11, i12, i13, i14);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final <T extends View> void waitForHeight(@NotNull T t11, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t11, "$this$waitForHeight");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        if (t11.getMeasuredWidth() <= 0 || t11.getMeasuredHeight() <= 0) {
            t11.getViewTreeObserver().addOnGlobalLayoutListener(new MDUtil$waitForHeight$1(t11, function1));
        } else {
            function1.invoke(t11);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final <T extends View> void waitForWidth(@NotNull T t11, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(t11, "$this$waitForWidth");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        if (t11.getMeasuredWidth() <= 0 || t11.getMeasuredHeight() <= 0) {
            t11.getViewTreeObserver().addOnGlobalLayoutListener(new MDUtil$waitForWidth$1(t11, function1));
        } else {
            function1.invoke(t11);
        }
    }

    public static /* synthetic */ CharSequence resolveString$default(MDUtil mDUtil, Context context, Integer num, Integer num2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            num = null;
        }
        if ((i11 & 4) != 0) {
            num2 = null;
        }
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        return mDUtil.resolveString(context, num, num2, z11);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final CharSequence resolveString(@NotNull Context context, @Nullable @StringRes Integer num, @Nullable @StringRes Integer num2, boolean z11) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        int intValue = num != null ? num.intValue() : num2 != null ? num2.intValue() : 0;
        if (intValue == 0) {
            return null;
        }
        CharSequence text = context.getResources().getText(intValue);
        Intrinsics.checkExpressionValueIsNotNull(text, "context.resources.getText(resourceId)");
        return z11 ? Html.fromHtml(text.toString()) : text;
    }
}
