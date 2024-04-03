package com.designsystem.ds_tag_v2;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSTag2Kt$DSTag2$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f33101g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f33102h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DSTagPriority f33103i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DSTagSize f33104j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ DSTagColor f33105k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Integer f33106l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f33107m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f33108n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTag2Kt$DSTag2$2(Modifier modifier, String str, DSTagPriority dSTagPriority, DSTagSize dSTagSize, DSTagColor dSTagColor, Integer num, int i11, int i12) {
        super(2);
        this.f33101g = modifier;
        this.f33102h = str;
        this.f33103i = dSTagPriority;
        this.f33104j = dSTagSize;
        this.f33105k = dSTagColor;
        this.f33106l = num;
        this.f33107m = i11;
        this.f33108n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSTag2Kt.DSTag2(this.f33101g, this.f33102h, this.f33103i, this.f33104j, this.f33105k, this.f33106l, composer, this.f33107m | 1, this.f33108n);
    }
}
