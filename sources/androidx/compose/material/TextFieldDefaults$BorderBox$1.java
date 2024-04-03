package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextFieldDefaults$BorderBox$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldDefaults f5874g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f5875h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f5876i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f5877j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f5878k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Shape f5879l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f5880m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f5881n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f5882o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f5883p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldDefaults$BorderBox$1(TextFieldDefaults textFieldDefaults, boolean z11, boolean z12, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f11, float f12, int i11, int i12) {
        super(2);
        this.f5874g = textFieldDefaults;
        this.f5875h = z11;
        this.f5876i = z12;
        this.f5877j = interactionSource;
        this.f5878k = textFieldColors;
        this.f5879l = shape;
        this.f5880m = f11;
        this.f5881n = f12;
        this.f5882o = i11;
        this.f5883p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f5874g.m1432BorderBoxnbWgWpA(this.f5875h, this.f5876i, this.f5877j, this.f5878k, this.f5879l, this.f5880m, this.f5881n, composer, this.f5882o | 1, this.f5883p);
    }
}
