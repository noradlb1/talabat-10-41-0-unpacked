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
public final class TextFieldDefaults$OutlinedBorderContainerBox$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldDefaults f8666g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f8667h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f8668i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f8669j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f8670k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Shape f8671l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f8672m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f8673n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f8674o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f8675p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldDefaults$OutlinedBorderContainerBox$1(TextFieldDefaults textFieldDefaults, boolean z11, boolean z12, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f11, float f12, int i11, int i12) {
        super(2);
        this.f8666g = textFieldDefaults;
        this.f8667h = z11;
        this.f8668i = z12;
        this.f8669j = interactionSource;
        this.f8670k = textFieldColors;
        this.f8671l = shape;
        this.f8672m = f11;
        this.f8673n = f12;
        this.f8674o = i11;
        this.f8675p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f8666g.m1908OutlinedBorderContainerBoxnbWgWpA(this.f8667h, this.f8668i, this.f8669j, this.f8670k, this.f8671l, this.f8672m, this.f8673n, composer, this.f8674o | 1, this.f8675p);
    }
}
