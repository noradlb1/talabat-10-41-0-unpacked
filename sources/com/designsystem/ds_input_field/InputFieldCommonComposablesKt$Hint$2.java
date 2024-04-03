package com.designsystem.ds_input_field;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class InputFieldCommonComposablesKt$Hint$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f31588g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f31589h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextStyle f31590i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ BoxScope f31591j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f31592k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldCommonComposablesKt$Hint$2(String str, long j11, TextStyle textStyle, BoxScope boxScope, int i11) {
        super(2);
        this.f31588g = str;
        this.f31589h = j11;
        this.f31590i = textStyle;
        this.f31591j = boxScope;
        this.f31592k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        InputFieldCommonComposablesKt.m8412HintEPk0efs(this.f31588g, this.f31589h, this.f31590i, this.f31591j, composer, this.f31592k | 1);
    }
}
