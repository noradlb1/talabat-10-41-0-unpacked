package com.designsystem.ds_checkbox_v2;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSCheckboxKt$DSCheckbox$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f30901g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f30902h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f30903i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f30904j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f30905k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f30906l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSCheckboxKt$DSCheckbox$2(Modifier modifier, boolean z11, boolean z12, Function1<? super Boolean, Unit> function1, int i11, int i12) {
        super(2);
        this.f30901g = modifier;
        this.f30902h = z11;
        this.f30903i = z12;
        this.f30904j = function1;
        this.f30905k = i11;
        this.f30906l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSCheckboxKt.DSCheckbox(this.f30901g, this.f30902h, this.f30903i, this.f30904j, composer, this.f30905k | 1, this.f30906l);
    }
}
