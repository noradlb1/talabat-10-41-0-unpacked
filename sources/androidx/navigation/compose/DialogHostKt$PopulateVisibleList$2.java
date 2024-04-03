package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.navigation.NavBackStackEntry;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DialogHostKt$PopulateVisibleList$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<NavBackStackEntry> f36379g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Collection<NavBackStackEntry> f36380h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f36381i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogHostKt$PopulateVisibleList$2(List<NavBackStackEntry> list, Collection<NavBackStackEntry> collection, int i11) {
        super(2);
        this.f36379g = list;
        this.f36380h = collection;
        this.f36381i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DialogHostKt.PopulateVisibleList(this.f36379g, this.f36380h, composer, this.f36381i | 1);
    }
}
