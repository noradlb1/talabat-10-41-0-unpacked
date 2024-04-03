package com.designsystem.ds_empty_state_v2;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class EmptyStateComposablesKt$EmptyStateIcon$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ EmptyStateIcon f31178g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f31179h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmptyStateComposablesKt$EmptyStateIcon$2(EmptyStateIcon emptyStateIcon, int i11) {
        super(2);
        this.f31178g = emptyStateIcon;
        this.f31179h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        EmptyStateComposablesKt.EmptyStateIcon(this.f31178g, composer, this.f31179h | 1);
    }
}
