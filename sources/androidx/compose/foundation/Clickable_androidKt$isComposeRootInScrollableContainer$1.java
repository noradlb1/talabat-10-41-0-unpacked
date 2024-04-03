package androidx.compose.foundation;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class Clickable_androidKt$isComposeRootInScrollableContainer$1 extends Lambda implements Function0<Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f1628g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Clickable_androidKt$isComposeRootInScrollableContainer$1(View view) {
        super(0);
        this.f1628g = view;
    }

    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(Clickable_androidKt.isInScrollableViewGroup(this.f1628g));
    }
}
