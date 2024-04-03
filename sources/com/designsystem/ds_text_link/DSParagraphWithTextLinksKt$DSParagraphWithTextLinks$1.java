package com.designsystem.ds_text_link;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_text_link.composables.TextLinkComposablesKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSParagraphWithTextLinksKt$DSParagraphWithTextLinks$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f33149g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<DSTextLinkText> f33150h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f33151i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSParagraphWithTextLinksKt$DSParagraphWithTextLinks$1(Modifier modifier, List<? extends DSTextLinkText> list, int i11) {
        super(2);
        this.f33149g = modifier;
        this.f33150h = list;
        this.f33151i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            TextLinkComposablesKt.BaseParagraphWithTextLinks(this.f33149g, this.f33150h, composer, (this.f33151i & 14) | 64);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
