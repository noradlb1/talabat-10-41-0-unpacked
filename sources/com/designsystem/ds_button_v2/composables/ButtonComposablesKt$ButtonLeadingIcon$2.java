package com.designsystem.ds_button_v2.composables;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ButtonComposablesKt$ButtonLeadingIcon$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f30811g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f30812h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f30813i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonComposablesKt$ButtonLeadingIcon$2(int i11, long j11, int i12) {
        super(2);
        this.f30811g = i11;
        this.f30812h = j11;
        this.f30813i = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ButtonComposablesKt.m8296ButtonLeadingIconRPmYEkk(this.f30811g, this.f30812h, composer, this.f30813i | 1);
    }
}
