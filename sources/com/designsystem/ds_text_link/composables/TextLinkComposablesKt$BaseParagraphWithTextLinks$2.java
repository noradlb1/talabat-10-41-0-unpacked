package com.designsystem.ds_text_link.composables;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_text_link.DSTextLinkText;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class TextLinkComposablesKt$BaseParagraphWithTextLinks$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f33171g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<DSTextLinkText> f33172h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f33173i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextLinkComposablesKt$BaseParagraphWithTextLinks$2(Modifier modifier, List<? extends DSTextLinkText> list, int i11) {
        super(2);
        this.f33171g = modifier;
        this.f33172h = list;
        this.f33173i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TextLinkComposablesKt.BaseParagraphWithTextLinks(this.f33171g, this.f33172h, composer, this.f33173i | 1);
    }
}
