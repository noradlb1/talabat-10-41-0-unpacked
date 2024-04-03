package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ChipKt$ChipContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6819g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TextStyle f6820h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f6821i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6822j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6823k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6824l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f6825m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f6826n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f6827o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f6828p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f6829q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipKt$ChipContent$2(Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, long j11, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, long j12, long j13, float f11, PaddingValues paddingValues, int i11) {
        super(2);
        this.f6819g = function2;
        this.f6820h = textStyle;
        this.f6821i = j11;
        this.f6822j = function22;
        this.f6823k = function23;
        this.f6824l = function24;
        this.f6825m = j12;
        this.f6826n = j13;
        this.f6827o = f11;
        this.f6828p = paddingValues;
        this.f6829q = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ChipKt.m1541ChipContentfe0OD_I(this.f6819g, this.f6820h, this.f6821i, this.f6822j, this.f6823k, this.f6824l, this.f6825m, this.f6826n, this.f6827o, this.f6828p, composer, this.f6829q | 1);
    }
}
