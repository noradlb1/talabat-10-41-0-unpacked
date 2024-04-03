package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldDefaults$TextFieldDecorationBox$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldDefaults f8708g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f8709h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8710i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f8711j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f8712k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f8713l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f8714m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f8715n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8716o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8717p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8718q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8719r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8720s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Shape f8721t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f8722u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f8723v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8724w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f8725x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ int f8726y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ int f8727z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldDefaults$TextFieldDecorationBox$2(TextFieldDefaults textFieldDefaults, String str, Function2<? super Composer, ? super Integer, Unit> function2, boolean z11, boolean z12, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z13, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function27, int i11, int i12, int i13) {
        super(2);
        this.f8708g = textFieldDefaults;
        this.f8709h = str;
        this.f8710i = function2;
        this.f8711j = z11;
        this.f8712k = z12;
        this.f8713l = visualTransformation;
        this.f8714m = interactionSource;
        this.f8715n = z13;
        this.f8716o = function22;
        this.f8717p = function23;
        this.f8718q = function24;
        this.f8719r = function25;
        this.f8720s = function26;
        this.f8721t = shape;
        this.f8722u = textFieldColors;
        this.f8723v = paddingValues;
        this.f8724w = function27;
        this.f8725x = i11;
        this.f8726y = i12;
        this.f8727z = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        TextFieldDefaults textFieldDefaults = this.f8708g;
        TextFieldDefaults textFieldDefaults2 = textFieldDefaults;
        textFieldDefaults2.TextFieldDecorationBox(this.f8709h, this.f8710i, this.f8711j, this.f8712k, this.f8713l, this.f8714m, this.f8715n, this.f8716o, this.f8717p, this.f8718q, this.f8719r, this.f8720s, this.f8721t, this.f8722u, this.f8723v, this.f8724w, composer2, this.f8725x | 1, this.f8726y, this.f8727z);
    }
}
