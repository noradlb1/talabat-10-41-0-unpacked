package androidx.compose.ui.node;

import android.view.View;
import androidx.annotation.RestrictTo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a1\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\bH\u0000\u001a\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"viewAdaptersKey", "", "tagKey", "key", "", "getOrAddAdapter", "T", "Landroidx/compose/ui/node/ViewAdapter;", "Landroid/view/View;", "id", "factory", "Lkotlin/Function0;", "(Landroid/view/View;ILkotlin/jvm/functions/Function0;)Landroidx/compose/ui/node/ViewAdapter;", "getViewAdapter", "Landroidx/compose/ui/node/MergedViewAdapter;", "getViewAdapterIfExists", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ViewInterop_androidKt {
    private static final int viewAdaptersKey = tagKey("ViewAdapter");

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T extends ViewAdapter> T getOrAddAdapter(@NotNull View view, int i11, @NotNull Function0<? extends T> function0) {
        T t11;
        T t12;
        boolean z11;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function0, "factory");
        MergedViewAdapter viewAdapter = getViewAdapter(view);
        List<ViewAdapter> adapters = viewAdapter.getAdapters();
        int size = adapters.size();
        int i12 = 0;
        while (true) {
            t11 = null;
            if (i12 >= size) {
                t12 = null;
                break;
            }
            t12 = adapters.get(i12);
            if (((ViewAdapter) t12).getId() == i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                break;
            }
            i12++;
        }
        if (t12 instanceof ViewAdapter) {
            t11 = (ViewAdapter) t12;
        }
        if (t11 != null) {
            return t11;
        }
        T t13 = (ViewAdapter) function0.invoke();
        viewAdapter.getAdapters().add(t13);
        return t13;
    }

    @NotNull
    public static final MergedViewAdapter getViewAdapter(@NotNull View view) {
        MergedViewAdapter mergedViewAdapter;
        Intrinsics.checkNotNullParameter(view, "<this>");
        int i11 = viewAdaptersKey;
        Object tag = view.getTag(i11);
        if (tag instanceof MergedViewAdapter) {
            mergedViewAdapter = (MergedViewAdapter) tag;
        } else {
            mergedViewAdapter = null;
        }
        if (mergedViewAdapter != null) {
            return mergedViewAdapter;
        }
        MergedViewAdapter mergedViewAdapter2 = new MergedViewAdapter();
        view.setTag(i11, mergedViewAdapter2);
        return mergedViewAdapter2;
    }

    @Nullable
    public static final MergedViewAdapter getViewAdapterIfExists(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(viewAdaptersKey);
        if (tag instanceof MergedViewAdapter) {
            return (MergedViewAdapter) tag;
        }
        return null;
    }

    public static final int tagKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return str.hashCode() | 50331648;
    }
}
