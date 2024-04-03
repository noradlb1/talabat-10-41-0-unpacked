package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CardKt$Card$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f6670g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Shape f6671h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CardColors f6672i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CardElevation f6673j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f6674k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f6675l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f6676m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f6677n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardKt$Card$2(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f6670g = modifier;
        this.f6671h = shape;
        this.f6672i = cardColors;
        this.f6673j = cardElevation;
        this.f6674k = borderStroke;
        this.f6675l = function3;
        this.f6676m = i11;
        this.f6677n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CardKt.Card(this.f6670g, this.f6671h, this.f6672i, this.f6673j, this.f6674k, this.f6675l, composer, this.f6676m | 1, this.f6677n);
    }
}
