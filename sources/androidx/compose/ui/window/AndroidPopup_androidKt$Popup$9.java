package androidx.compose.ui.window;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidPopup_androidKt$Popup$9 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PopupPositionProvider f10381g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f10382h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PopupProperties f10383i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f10384j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f10385k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f10386l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidPopup_androidKt$Popup$9(PopupPositionProvider popupPositionProvider, Function0<Unit> function0, PopupProperties popupProperties, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f10381g = popupPositionProvider;
        this.f10382h = function0;
        this.f10383i = popupProperties;
        this.f10384j = function2;
        this.f10385k = i11;
        this.f10386l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AndroidPopup_androidKt.Popup(this.f10381g, this.f10382h, this.f10383i, this.f10384j, composer, this.f10385k | 1, this.f10386l);
    }
}
