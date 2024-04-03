package androidx.compose.ui.viewinterop;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidView_androidKt$AndroidView$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<Context, T> f10330g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f10331h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<T, Unit> f10332i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f10333j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f10334k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidView_androidKt$AndroidView$4(Function1<? super Context, ? extends T> function1, Modifier modifier, Function1<? super T, Unit> function12, int i11, int i12) {
        super(2);
        this.f10330g = function1;
        this.f10331h = modifier;
        this.f10332i = function12;
        this.f10333j = i11;
        this.f10334k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AndroidView_androidKt.AndroidView(this.f10330g, this.f10331h, this.f10332i, composer, this.f10333j | 1, this.f10334k);
    }
}
