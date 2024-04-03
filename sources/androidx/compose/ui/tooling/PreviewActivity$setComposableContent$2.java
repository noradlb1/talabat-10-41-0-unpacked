package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u000b"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PreviewActivity$setComposableContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f10261g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f10262h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreviewActivity$setComposableContent$2(String str, String str2) {
        super(2);
        this.f10261g = str;
        this.f10262h = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            CommonPreviewUtils.INSTANCE.invokeComposableViaReflection$ui_tooling_release(this.f10261g, this.f10262h, composer, new Object[0]);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
