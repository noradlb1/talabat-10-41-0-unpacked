package com.designsystem.ds_text_link;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_text_link.DSTextLinkText;
import com.designsystem.ds_text_link.composables.TextLinkComposablesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSTextLinkKt$DSTextLink$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f33158g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f33159h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f33160i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f33161j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f33162k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTextLinkKt$DSTextLink$1(Modifier modifier, String str, boolean z11, Function0<Unit> function0, int i11) {
        super(2);
        this.f33158g = modifier;
        this.f33159h = str;
        this.f33160i = z11;
        this.f33161j = function0;
        this.f33162k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            TextLinkComposablesKt.BaseParagraphWithTextLinks(this.f33158g, CollectionsKt__CollectionsJVMKt.listOf(new DSTextLinkText.Link(this.f33159h, this.f33160i, this.f33161j)), composer, (this.f33162k >> 3) & 14);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
