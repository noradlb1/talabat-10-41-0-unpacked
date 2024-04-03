package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextFieldImplKt$CommonDecorationBox$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldType f5972g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f5973h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5974i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f5975j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5976k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5977l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5978m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5979n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f5980o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ boolean f5981p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ boolean f5982q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f5983r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f5984s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f5985t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5986u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f5987v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f5988w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f5989x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldImplKt$CommonDecorationBox$4(TextFieldType textFieldType, String str, Function2<? super Composer, ? super Integer, Unit> function2, VisualTransformation visualTransformation, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, boolean z11, boolean z12, boolean z13, InteractionSource interactionSource, PaddingValues paddingValues, TextFieldColors textFieldColors, Function2<? super Composer, ? super Integer, Unit> function26, int i11, int i12, int i13) {
        super(2);
        this.f5972g = textFieldType;
        this.f5973h = str;
        this.f5974i = function2;
        this.f5975j = visualTransformation;
        this.f5976k = function22;
        this.f5977l = function23;
        this.f5978m = function24;
        this.f5979n = function25;
        this.f5980o = z11;
        this.f5981p = z12;
        this.f5982q = z13;
        this.f5983r = interactionSource;
        this.f5984s = paddingValues;
        this.f5985t = textFieldColors;
        this.f5986u = function26;
        this.f5987v = i11;
        this.f5988w = i12;
        this.f5989x = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        TextFieldType textFieldType = this.f5972g;
        TextFieldType textFieldType2 = textFieldType;
        TextFieldImplKt.CommonDecorationBox(textFieldType2, this.f5973h, this.f5974i, this.f5975j, this.f5976k, this.f5977l, this.f5978m, this.f5979n, this.f5980o, this.f5981p, this.f5982q, this.f5983r, this.f5984s, this.f5985t, this.f5986u, composer2, this.f5987v | 1, this.f5988w, this.f5989x);
    }
}
