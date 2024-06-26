package androidx.compose.runtime.saveable;

import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "T", "list", "", "", "invoke", "(Ljava/util/List;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class MapSaverKt$mapSaver$2 extends Lambda implements Function1<List<? extends Object>, T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<Map<String, ? extends Object>, T> f9488g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MapSaverKt$mapSaver$2(Function1<? super Map<String, ? extends Object>, ? extends T> function1) {
        super(1);
        this.f9488g = function1;
    }

    @Nullable
    public final T invoke(@NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, DefaultCardView.CARD_LIST);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list.size() % 2 == 0) {
            for (int i11 = 0; i11 < list.size(); i11 += 2) {
                Object obj = list.get(i11);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, list.get(i11 + 1));
            }
            return this.f9488g.invoke(linkedHashMap);
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
