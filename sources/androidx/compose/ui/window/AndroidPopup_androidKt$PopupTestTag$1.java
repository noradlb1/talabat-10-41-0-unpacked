package androidx.compose.ui.window;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidPopup_androidKt$PopupTestTag$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f10391g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f10392h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f10393i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidPopup_androidKt$PopupTestTag$1(String str, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f10391g = str;
        this.f10392h = function2;
        this.f10393i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AndroidPopup_androidKt.PopupTestTag(this.f10391g, this.f10392h, composer, this.f10393i | 1);
    }
}
