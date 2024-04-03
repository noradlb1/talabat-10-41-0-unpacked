package com.designsystem.ds_progress_bar;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSProgressBarKt$DSProgressBar$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32461g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f32462h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Color f32463i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32464j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32465k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSProgressBarKt$DSProgressBar$2(Modifier modifier, float f11, Color color, int i11, int i12) {
        super(2);
        this.f32461g = modifier;
        this.f32462h = f11;
        this.f32463i = color;
        this.f32464j = i11;
        this.f32465k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSProgressBarKt.m8514DSProgressBargKt5lHk(this.f32461g, this.f32462h, this.f32463i, composer, this.f32464j | 1, this.f32465k);
    }
}
