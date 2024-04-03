package com.designsystem.ds_chip;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ChipComposablesKt$ChipIcon$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f30910g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f30911h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f30912i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f30913j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipComposablesKt$ChipIcon$2(int i11, boolean z11, String str, int i12) {
        super(2);
        this.f30910g = i11;
        this.f30911h = z11;
        this.f30912i = str;
        this.f30913j = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ChipComposablesKt.ChipIcon(this.f30910g, this.f30911h, this.f30912i, composer, this.f30913j | 1);
    }
}
