package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DialogHostKt$DialogHost$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DialogNavigator f36375g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f36376h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogHostKt$DialogHost$2(DialogNavigator dialogNavigator, int i11) {
        super(2);
        this.f36375g = dialogNavigator;
        this.f36376h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DialogHostKt.DialogHost(this.f36375g, composer, this.f36376h | 1);
    }
}
