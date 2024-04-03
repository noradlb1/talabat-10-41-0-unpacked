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
public final class TextFieldDefaults$OutlinedTextFieldDecorationBox$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldDefaults f5890g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f5891h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5892i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f5893j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f5894k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f5895l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f5896m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f5897n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5898o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5899p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5900q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5901r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f5902s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f5903t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5904u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f5905v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f5906w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f5907x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldDefaults$OutlinedTextFieldDecorationBox$2(TextFieldDefaults textFieldDefaults, String str, Function2<? super Composer, ? super Integer, Unit> function2, boolean z11, boolean z12, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z13, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function26, int i11, int i12, int i13) {
        super(2);
        this.f5890g = textFieldDefaults;
        this.f5891h = str;
        this.f5892i = function2;
        this.f5893j = z11;
        this.f5894k = z12;
        this.f5895l = visualTransformation;
        this.f5896m = interactionSource;
        this.f5897n = z13;
        this.f5898o = function22;
        this.f5899p = function23;
        this.f5900q = function24;
        this.f5901r = function25;
        this.f5902s = textFieldColors;
        this.f5903t = paddingValues;
        this.f5904u = function26;
        this.f5905v = i11;
        this.f5906w = i12;
        this.f5907x = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        TextFieldDefaults textFieldDefaults = this.f5890g;
        TextFieldDefaults textFieldDefaults2 = textFieldDefaults;
        textFieldDefaults2.OutlinedTextFieldDecorationBox(this.f5891h, this.f5892i, this.f5893j, this.f5894k, this.f5895l, this.f5896m, this.f5897n, this.f5898o, this.f5899p, this.f5900q, this.f5901r, this.f5902s, this.f5903t, this.f5904u, composer2, this.f5905v | 1, this.f5906w, this.f5907x);
    }
}
