package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TwoLine$ListItem$1$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6164g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6165h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6166i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TwoLine$ListItem$1$2(Function2<? super Composer, ? super Integer, Unit> function2, int i11, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(2);
        this.f6164g = function2;
        this.f6165h = i11;
        this.f6166i = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            this.f6164g.invoke(composer, Integer.valueOf((this.f6165h >> 12) & 14));
            this.f6166i.invoke(composer, Integer.valueOf((this.f6165h >> 6) & 14));
            return;
        }
        composer.skipToGroupEnd();
    }
}
