package com.designsystem.ds_empty_state_v2;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSEmptyStateWithLargeIllustrationKt$DSEmptyStateWithLargeIllustration$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f31139g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f31140h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f31141i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31142j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f31143k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31144l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f31145m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f31146n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSEmptyStateWithLargeIllustrationKt$DSEmptyStateWithLargeIllustration$1(String str, int i11, Modifier modifier, String str2, String str3, Function0<Unit> function0, int i12, int i13) {
        super(2);
        this.f31139g = str;
        this.f31140h = i11;
        this.f31141i = modifier;
        this.f31142j = str2;
        this.f31143k = str3;
        this.f31144l = function0;
        this.f31145m = i12;
        this.f31146n = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSEmptyStateWithLargeIllustrationKt.DSEmptyStateWithLargeIllustration(this.f31139g, this.f31140h, this.f31141i, this.f31142j, this.f31143k, this.f31144l, composer, this.f31145m | 1, this.f31146n);
    }
}
