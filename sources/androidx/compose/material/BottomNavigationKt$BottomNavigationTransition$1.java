package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BottomNavigationKt$BottomNavigationTransition$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<Float, Composer, Integer, Unit> f4104g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4105h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ State<Float> f4106i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomNavigationKt$BottomNavigationTransition$1(Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, int i11, State<Float> state) {
        super(2);
        this.f4104g = function3;
        this.f4105h = i11;
        this.f4106i = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            this.f4104g.invoke(Float.valueOf(BottomNavigationKt.m1110BottomNavigationTransition_Klgx_Pg$lambda3(this.f4106i)), composer, Integer.valueOf((this.f4105h >> 6) & 112));
        } else {
            composer.skipToGroupEnd();
        }
    }
}
