package androidx.navigation.compose;

import android.content.Context;
import android.os.Bundle;
import androidx.navigation.NavHostController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/navigation/NavHostController;", "it", "Landroid/os/Bundle;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavHostControllerKt$NavControllerSaver$2 extends Lambda implements Function1<Bundle, NavHostController> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f36394g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavHostControllerKt$NavControllerSaver$2(Context context) {
        super(1);
        this.f36394g = context;
    }

    @Nullable
    public final NavHostController invoke(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "it");
        NavHostController access$createNavController = NavHostControllerKt.createNavController(this.f36394g);
        access$createNavController.restoreState(bundle);
        return access$createNavController;
    }
}
