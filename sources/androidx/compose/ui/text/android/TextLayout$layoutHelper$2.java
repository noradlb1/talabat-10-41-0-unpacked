package androidx.compose.ui.text.android;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/android/LayoutHelper;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextLayout$layoutHelper$2 extends Lambda implements Function0<LayoutHelper> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextLayout f10144g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextLayout$layoutHelper$2(TextLayout textLayout) {
        super(0);
        this.f10144g = textLayout;
    }

    @NotNull
    public final LayoutHelper invoke() {
        return new LayoutHelper(this.f10144g.getLayout());
    }
}
