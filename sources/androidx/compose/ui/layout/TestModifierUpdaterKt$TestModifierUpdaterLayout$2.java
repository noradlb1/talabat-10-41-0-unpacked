package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TestModifierUpdaterKt$TestModifierUpdaterLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<TestModifierUpdater, Unit> f9897g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9898h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TestModifierUpdaterKt$TestModifierUpdaterLayout$2(Function1<? super TestModifierUpdater, Unit> function1, int i11) {
        super(2);
        this.f9897g = function1;
        this.f9898h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TestModifierUpdaterKt.TestModifierUpdaterLayout(this.f9897g, composer, this.f9898h | 1);
    }
}
