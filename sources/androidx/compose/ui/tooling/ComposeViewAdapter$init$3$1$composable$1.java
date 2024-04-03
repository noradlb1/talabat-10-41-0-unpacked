package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ComposeViewAdapter$init$3$1$composable$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f10249g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f10250h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Composer f10251i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Class<? extends PreviewParameterProvider<?>> f10252j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f10253k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ComposeViewAdapter f10254l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeViewAdapter$init$3$1$composable$1(String str, String str2, Composer composer, Class<? extends PreviewParameterProvider<?>> cls, int i11, ComposeViewAdapter composeViewAdapter) {
        super(0);
        this.f10249g = str;
        this.f10250h = str2;
        this.f10251i = composer;
        this.f10252j = cls;
        this.f10253k = i11;
        this.f10254l = composeViewAdapter;
    }

    public final void invoke() {
        Throwable cause;
        try {
            CommonPreviewUtils commonPreviewUtils = CommonPreviewUtils.INSTANCE;
            String str = this.f10249g;
            String str2 = this.f10250h;
            Composer composer = this.f10251i;
            Object[] previewProviderParameters = PreviewUtilsKt.getPreviewProviderParameters(this.f10252j, this.f10253k);
            commonPreviewUtils.invokeComposableViaReflection$ui_tooling_release(str, str2, composer, Arrays.copyOf(previewProviderParameters, previewProviderParameters.length));
        } catch (Throwable th2) {
            Throwable th3 = th2;
            while ((th3 instanceof ReflectiveOperationException) && (cause = th3.getCause()) != null) {
                th3 = cause;
            }
            Object access$getDelayExceptionLock$p = this.f10254l.delayExceptionLock;
            ComposeViewAdapter composeViewAdapter = this.f10254l;
            synchronized (access$getDelayExceptionLock$p) {
                composeViewAdapter.delayedException = th3;
                Unit unit = Unit.INSTANCE;
                throw th2;
            }
        }
    }
}
