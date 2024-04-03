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
public final class DSAlternativeTextLinkKt$DSAlternativeTextLink$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f33141g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f33142h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f33143i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f33144j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f33145k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f33146l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSAlternativeTextLinkKt$DSAlternativeTextLink$2(String str, Modifier modifier, boolean z11, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f33141g = str;
        this.f33142h = modifier;
        this.f33143i = z11;
        this.f33144j = function0;
        this.f33145k = i11;
        this.f33146l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSAlternativeTextLinkKt.DSAlternativeTextLink(this.f33141g, this.f33142h, this.f33143i, this.f33144j, composer, this.f33145k | 1, this.f33146l);
    }
}
