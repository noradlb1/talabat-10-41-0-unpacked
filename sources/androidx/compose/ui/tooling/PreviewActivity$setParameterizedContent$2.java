package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u000b"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PreviewActivity$setParameterizedContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f10274g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f10275h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object[] f10276i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreviewActivity$setParameterizedContent$2(String str, String str2, Object[] objArr) {
        super(2);
        this.f10274g = str;
        this.f10275h = str2;
        this.f10276i = objArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            CommonPreviewUtils commonPreviewUtils = CommonPreviewUtils.INSTANCE;
            String str = this.f10274g;
            String str2 = this.f10275h;
            Object[] objArr = this.f10276i;
            commonPreviewUtils.invokeComposableViaReflection$ui_tooling_release(str, str2, composer, Arrays.copyOf(objArr, objArr.length));
            return;
        }
        composer.skipToGroupEnd();
    }
}
