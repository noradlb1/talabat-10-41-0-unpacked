package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidCursorHandle_androidKt$CursorHandle$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f3261g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f3262h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3263i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3264j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidCursorHandle_androidKt$CursorHandle$2(long j11, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f3261g = j11;
        this.f3262h = modifier;
        this.f3263i = function2;
        this.f3264j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AndroidCursorHandle_androidKt.m824CursorHandleULxng0E(this.f3261g, this.f3262h, this.f3263i, composer, this.f3264j | 1);
    }
}
