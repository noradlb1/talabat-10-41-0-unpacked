package androidx.navigation.compose;

import android.content.Context;
import androidx.navigation.NavHostController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavHostControllerKt$rememberNavController$1 extends Lambda implements Function0<NavHostController> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f36395g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavHostControllerKt$rememberNavController$1(Context context) {
        super(0);
        this.f36395g = context;
    }

    @NotNull
    public final NavHostController invoke() {
        return NavHostControllerKt.createNavController(this.f36395g);
    }
}
