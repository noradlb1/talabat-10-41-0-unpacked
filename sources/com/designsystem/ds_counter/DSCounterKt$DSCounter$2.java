package com.designsystem.ds_counter;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSCounterKt$DSCounter$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f31059g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f31060h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f31061i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f31062j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f31063k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f31064l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSCounterKt$DSCounter$2(int i11, Modifier modifier, long j11, long j12, int i12, int i13) {
        super(2);
        this.f31059g = i11;
        this.f31060h = modifier;
        this.f31061i = j11;
        this.f31062j = j12;
        this.f31063k = i12;
        this.f31064l = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSCounterKt.m8333DSCountereaDK9VM(this.f31059g, this.f31060h, this.f31061i, this.f31062j, composer, this.f31063k | 1, this.f31064l);
    }
}
