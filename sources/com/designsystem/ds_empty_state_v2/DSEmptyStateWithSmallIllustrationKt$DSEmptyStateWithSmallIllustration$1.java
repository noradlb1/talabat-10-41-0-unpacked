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
public final class DSEmptyStateWithSmallIllustrationKt$DSEmptyStateWithSmallIllustration$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f31149g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f31150h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f31151i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31152j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f31153k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31154l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f31155m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f31156n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSEmptyStateWithSmallIllustrationKt$DSEmptyStateWithSmallIllustration$1(String str, int i11, Modifier modifier, String str2, String str3, Function0<Unit> function0, int i12, int i13) {
        super(2);
        this.f31149g = str;
        this.f31150h = i11;
        this.f31151i = modifier;
        this.f31152j = str2;
        this.f31153k = str3;
        this.f31154l = function0;
        this.f31155m = i12;
        this.f31156n = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSEmptyStateWithSmallIllustrationKt.DSEmptyStateWithSmallIllustration(this.f31149g, this.f31150h, this.f31151i, this.f31152j, this.f31153k, this.f31154l, composer, this.f31155m | 1, this.f31156n);
    }
}
