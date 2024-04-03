package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ButtonKt$ElevatedButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6610g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6611h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f6612i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Shape f6613j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ButtonColors f6614k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ButtonElevation f6615l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f6616m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f6617n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6618o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f6619p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f6620q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f6621r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonKt$ElevatedButton$2(Function0<Unit> function0, Modifier modifier, boolean z11, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f6610g = function0;
        this.f6611h = modifier;
        this.f6612i = z11;
        this.f6613j = shape;
        this.f6614k = buttonColors;
        this.f6615l = buttonElevation;
        this.f6616m = borderStroke;
        this.f6617n = paddingValues;
        this.f6618o = mutableInteractionSource;
        this.f6619p = function3;
        this.f6620q = i11;
        this.f6621r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ButtonKt.ElevatedButton(this.f6610g, this.f6611h, this.f6612i, this.f6613j, this.f6614k, this.f6615l, this.f6616m, this.f6617n, this.f6618o, this.f6619p, composer, this.f6620q | 1, this.f6621r);
    }
}
