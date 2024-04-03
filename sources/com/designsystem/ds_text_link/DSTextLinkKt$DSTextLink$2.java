package com.designsystem.ds_text_link;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSTextLinkKt$DSTextLink$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f33163g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f33164h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f33165i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f33166j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f33167k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f33168l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTextLinkKt$DSTextLink$2(String str, Modifier modifier, boolean z11, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f33163g = str;
        this.f33164h = modifier;
        this.f33165i = z11;
        this.f33166j = function0;
        this.f33167k = i11;
        this.f33168l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSTextLinkKt.DSTextLink(this.f33163g, this.f33164h, this.f33165i, this.f33166j, composer, this.f33167k | 1, this.f33168l);
    }
}
