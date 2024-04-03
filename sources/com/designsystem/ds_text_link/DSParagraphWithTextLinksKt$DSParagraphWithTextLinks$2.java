package com.designsystem.ds_text_link;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSParagraphWithTextLinksKt$DSParagraphWithTextLinks$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f33152g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<DSTextLinkText> f33153h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f33154i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f33155j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSParagraphWithTextLinksKt$DSParagraphWithTextLinks$2(Modifier modifier, List<? extends DSTextLinkText> list, int i11, int i12) {
        super(2);
        this.f33152g = modifier;
        this.f33153h = list;
        this.f33154i = i11;
        this.f33155j = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSParagraphWithTextLinksKt.DSParagraphWithTextLinks(this.f33152g, this.f33153h, composer, this.f33154i | 1, this.f33155j);
    }
}
