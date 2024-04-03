package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/text/input/EditCommand;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class EditProcessor$generateBatchErrorMessage$1$1 extends Lambda implements Function1<EditCommand, CharSequence> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ EditCommand f10209g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ EditProcessor f10210h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditProcessor$generateBatchErrorMessage$1$1(EditCommand editCommand, EditProcessor editProcessor) {
        super(1);
        this.f10209g = editCommand;
        this.f10210h = editProcessor;
    }

    @NotNull
    public final CharSequence invoke(@NotNull EditCommand editCommand) {
        Intrinsics.checkNotNullParameter(editCommand, "it");
        String str = this.f10209g == editCommand ? " > " : "   ";
        return str + this.f10210h.toStringForLog(editCommand);
    }
}
