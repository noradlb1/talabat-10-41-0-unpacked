package androidx.navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Args", "Landroidx/navigation/NavArgs;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
public final class ActivityNavArgsLazyKt$navArgs$1 extends Lambda implements Function0<Bundle> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Activity f36298g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityNavArgsLazyKt$navArgs$1(Activity activity) {
        super(0);
        this.f36298g = activity;
    }

    @NotNull
    public final Bundle invoke() {
        Bundle bundle;
        Intent intent = this.f36298g.getIntent();
        if (intent != null) {
            Activity activity = this.f36298g;
            bundle = intent.getExtras();
            if (bundle == null) {
                throw new IllegalStateException("Activity " + activity + " has null extras in " + intent);
            }
        } else {
            bundle = null;
        }
        if (bundle != null) {
            return bundle;
        }
        throw new IllegalStateException("Activity " + this.f36298g + " has a null Intent");
    }
}
