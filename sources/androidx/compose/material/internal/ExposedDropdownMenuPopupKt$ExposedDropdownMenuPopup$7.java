package androidx.compose.material.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$7 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6202g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ PopupPositionProvider f6203h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6204i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f6205j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f6206k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$7(Function0<Unit> function0, PopupPositionProvider popupPositionProvider, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f6202g = function0;
        this.f6203h = popupPositionProvider;
        this.f6204i = function2;
        this.f6205j = i11;
        this.f6206k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(this.f6202g, this.f6203h, this.f6204i, composer, this.f6205j | 1, this.f6206k);
    }
}
