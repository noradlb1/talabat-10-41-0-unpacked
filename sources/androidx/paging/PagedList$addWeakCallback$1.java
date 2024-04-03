package androidx.paging;

import androidx.paging.PagedList;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "", "it", "Ljava/lang/ref/WeakReference;", "Landroidx/paging/PagedList$Callback;", "invoke"}, k = 3, mv = {1, 4, 2})
public final class PagedList$addWeakCallback$1 extends Lambda implements Function1<WeakReference<PagedList.Callback>, Boolean> {
    public static final PagedList$addWeakCallback$1 INSTANCE = new PagedList$addWeakCallback$1();

    public PagedList$addWeakCallback$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((WeakReference<PagedList.Callback>) (WeakReference) obj));
    }

    public final boolean invoke(@NotNull WeakReference<PagedList.Callback> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "it");
        return weakReference.get() == null;
    }
}
