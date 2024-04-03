package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldDefaults$FilledContainerBox$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldDefaults f8658g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f8659h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f8660i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f8661j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f8662k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Shape f8663l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f8664m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f8665n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldDefaults$FilledContainerBox$1(TextFieldDefaults textFieldDefaults, boolean z11, boolean z12, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, int i11, int i12) {
        super(2);
        this.f8658g = textFieldDefaults;
        this.f8659h = z11;
        this.f8660i = z12;
        this.f8661j = interactionSource;
        this.f8662k = textFieldColors;
        this.f8663l = shape;
        this.f8664m = i11;
        this.f8665n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f8658g.FilledContainerBox(this.f8659h, this.f8660i, this.f8661j, this.f8662k, this.f8663l, composer, this.f8664m | 1, this.f8665n);
    }
}
