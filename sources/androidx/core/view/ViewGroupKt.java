package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import com.facebook.internal.NativeProtocol;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0015\u0010\u0010\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\n\u001a3\u0010\u0013\u001a\u00020\u0014*\u00020\u00032!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00140\u0016H\bø\u0001\u0000\u001aH\u0010\u0019\u001a\u00020\u0014*\u00020\u000326\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00140\u001aH\bø\u0001\u0000\u001a\u0015\u0010\u001c\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u001b\u001a\u00020\rH\u0002\u001a\r\u0010\u001d\u001a\u00020\u0011*\u00020\u0003H\b\u001a\r\u0010\u001e\u001a\u00020\u0011*\u00020\u0003H\b\u001a\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 *\u00020\u0003H\u0002\u001a\u0015\u0010!\u001a\u00020\u0014*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\n\u001a\u0015\u0010\"\u001a\u00020\u0014*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\n\u001a\u0017\u0010#\u001a\u00020\u0014*\u00020$2\b\b\u0001\u0010\f\u001a\u00020\rH\b\u001a5\u0010%\u001a\u00020\u0014*\u00020$2\b\b\u0003\u0010&\u001a\u00020\r2\b\b\u0003\u0010'\u001a\u00020\r2\b\b\u0003\u0010(\u001a\u00020\r2\b\b\u0003\u0010)\u001a\u00020\rH\b\u001a5\u0010*\u001a\u00020\u0014*\u00020$2\b\b\u0003\u0010+\u001a\u00020\r2\b\b\u0003\u0010'\u001a\u00020\r2\b\b\u0003\u0010,\u001a\u00020\r2\b\b\u0003\u0010)\u001a\u00020\rH\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\"\u0016\u0010\b\u001a\u00020\t*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0016\u0010\f\u001a\u00020\r*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0002\u0007\n\u0005\b20\u0001¨\u0006-"}, d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "Landroid/view/ViewGroup;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "descendants", "getDescendants", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "(Landroid/view/ViewGroup;)Lkotlin/ranges/IntRange;", "size", "", "getSize", "(Landroid/view/ViewGroup;)I", "contains", "", "view", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "plusAssign", "setMargins", "Landroid/view/ViewGroup$MarginLayoutParams;", "updateMargins", "left", "top", "right", "bottom", "updateMarginsRelative", "start", "end", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ViewGroupKt {
    public static final boolean contains(@NotNull ViewGroup viewGroup, @NotNull View view) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (viewGroup.indexOfChild(view) != -1) {
            return true;
        }
        return false;
    }

    public static final void forEach(@NotNull ViewGroup viewGroup, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            function1.invoke(childAt);
        }
    }

    public static final void forEachIndexed(@NotNull ViewGroup viewGroup, @NotNull Function2<? super Integer, ? super View, Unit> function2) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(function2, NativeProtocol.WEB_DIALOG_ACTION);
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            Integer valueOf = Integer.valueOf(i11);
            View childAt = viewGroup.getChildAt(i11);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            function2.invoke(valueOf, childAt);
        }
    }

    @NotNull
    public static final View get(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        View childAt = viewGroup.getChildAt(i11);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i11 + ", Size: " + viewGroup.getChildCount());
    }

    @NotNull
    public static final Sequence<View> getChildren(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        return new ViewGroupKt$children$1(viewGroup);
    }

    @NotNull
    public static final Sequence<View> getDescendants(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        return SequencesKt__SequenceBuilderKt.sequence(new ViewGroupKt$descendants$1(viewGroup, (Continuation<? super ViewGroupKt$descendants$1>) null));
    }

    @NotNull
    public static final IntRange getIndices(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        return RangesKt___RangesKt.until(0, viewGroup.getChildCount());
    }

    public static final int getSize(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        if (viewGroup.getChildCount() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        if (viewGroup.getChildCount() != 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final Iterator<View> iterator(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        return new ViewGroupKt$iterator$1(viewGroup);
    }

    public static final void minusAssign(@NotNull ViewGroup viewGroup, @NotNull View view) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        viewGroup.removeView(view);
    }

    public static final void plusAssign(@NotNull ViewGroup viewGroup, @NotNull View view) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        viewGroup.addView(view);
    }

    public static final void setMargins(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i11) {
        Intrinsics.checkNotNullParameter(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i11, i11, i11, i11);
    }

    public static final void updateMargins(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i11, @Px int i12, @Px int i13, @Px int i14) {
        Intrinsics.checkNotNullParameter(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i11, i12, i13, i14);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = marginLayoutParams.leftMargin;
        }
        if ((i15 & 2) != 0) {
            i12 = marginLayoutParams.topMargin;
        }
        if ((i15 & 4) != 0) {
            i13 = marginLayoutParams.rightMargin;
        }
        if ((i15 & 8) != 0) {
            i14 = marginLayoutParams.bottomMargin;
        }
        Intrinsics.checkNotNullParameter(marginLayoutParams, "<this>");
        marginLayoutParams.setMargins(i11, i12, i13, i14);
    }

    @RequiresApi(17)
    @SuppressLint({"ClassVerificationFailure"})
    public static final void updateMarginsRelative(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i11, @Px int i12, @Px int i13, @Px int i14) {
        Intrinsics.checkNotNullParameter(marginLayoutParams, "<this>");
        marginLayoutParams.setMarginStart(i11);
        marginLayoutParams.topMargin = i12;
        marginLayoutParams.setMarginEnd(i13);
        marginLayoutParams.bottomMargin = i14;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = marginLayoutParams.getMarginStart();
        }
        if ((i15 & 2) != 0) {
            i12 = marginLayoutParams.topMargin;
        }
        if ((i15 & 4) != 0) {
            i13 = marginLayoutParams.getMarginEnd();
        }
        if ((i15 & 8) != 0) {
            i14 = marginLayoutParams.bottomMargin;
        }
        Intrinsics.checkNotNullParameter(marginLayoutParams, "<this>");
        marginLayoutParams.setMarginStart(i11);
        marginLayoutParams.topMargin = i12;
        marginLayoutParams.setMarginEnd(i13);
        marginLayoutParams.bottomMargin = i14;
    }
}
