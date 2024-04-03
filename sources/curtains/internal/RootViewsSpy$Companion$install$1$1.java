package curtains.internal;

import android.view.View;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "mViews", "invoke"}, k = 3, mv = {1, 4, 1})
public final class RootViewsSpy$Companion$install$1$1 extends Lambda implements Function1<ArrayList<View>, ArrayList<View>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RootViewsSpy f13802g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RootViewsSpy$Companion$install$1$1(RootViewsSpy rootViewsSpy) {
        super(1);
        this.f13802g = rootViewsSpy;
    }

    @NotNull
    public final ArrayList<View> invoke(@NotNull ArrayList<View> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "mViews");
        RootViewsSpy$delegatingViewList$1 access$getDelegatingViewList$p = this.f13802g.delegatingViewList;
        access$getDelegatingViewList$p.addAll(arrayList);
        return access$getDelegatingViewList$p;
    }
}
