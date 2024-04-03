package androidx.compose.ui.tooling;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.navigation.compose.ComposeNavigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/tooling/PreviewActivity;", "Landroidx/activity/ComponentActivity;", "()V", "TAG", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setComposableContent", "composableFqn", "setParameterizedContent", "className", "methodName", "parameterProvider", "ui-tooling_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PreviewActivity extends ComponentActivity {
    public static final int $stable = 0;
    @NotNull
    private final String TAG = "PreviewActivity";

    private final void setComposableContent(String str) {
        Intrinsics.stringPlus("PreviewActivity has composable ", str);
        String substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(str, '.', (String) null, 2, (Object) null);
        String substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(str, '.', (String) null, 2, (Object) null);
        String stringExtra = getIntent().getStringExtra("parameterProviderClassName");
        if (stringExtra == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Previewing '");
            sb2.append(substringAfterLast$default);
            sb2.append("' without a parameter provider.");
            ComponentActivityKt.setContent$default(this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(-985531688, true, new PreviewActivity$setComposableContent$2(substringBeforeLast$default, substringAfterLast$default)), 1, (Object) null);
            return;
        }
        setParameterizedContent(substringBeforeLast$default, substringAfterLast$default, stringExtra);
    }

    private final void setParameterizedContent(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Previewing '");
        sb2.append(str2);
        sb2.append("' with parameter provider: '");
        sb2.append(str3);
        sb2.append('\'');
        Object[] previewProviderParameters = PreviewUtilsKt.getPreviewProviderParameters(PreviewUtilsKt.asPreviewProviderClass(str3), getIntent().getIntExtra("parameterProviderIndex", -1));
        if (previewProviderParameters.length > 1) {
            ComponentActivityKt.setContent$default(this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(-985538154, true, new PreviewActivity$setParameterizedContent$1(previewProviderParameters, str, str2)), 1, (Object) null);
        } else {
            ComponentActivityKt.setContent$default(this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(-985537892, true, new PreviewActivity$setParameterizedContent$2(str, str2, previewProviderParameters)), 1, (Object) null);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        String stringExtra;
        super.onCreate(bundle);
        if ((getApplicationInfo().flags & 2) == 0) {
            finish();
            return;
        }
        Intent intent = getIntent();
        if (intent != null && (stringExtra = intent.getStringExtra(ComposeNavigator.NAME)) != null) {
            setComposableContent(stringExtra);
        }
    }
}
