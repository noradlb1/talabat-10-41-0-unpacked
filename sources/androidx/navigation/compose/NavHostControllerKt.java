package androidx.navigation.compose;

import android.content.Context;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a1\u0010\u0006\u001a\u00020\u00022\"\u0010\u0007\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t0\b\"\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0007¢\u0006\u0002\u0010\u000b\u001a\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r*\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"NavControllerSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/navigation/NavHostController;", "context", "Landroid/content/Context;", "createNavController", "rememberNavController", "navigators", "", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "([Landroidx/navigation/Navigator;Landroidx/compose/runtime/Composer;I)Landroidx/navigation/NavHostController;", "currentBackStackEntryAsState", "Landroidx/compose/runtime/State;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/navigation/NavController;", "(Landroidx/navigation/NavController;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "navigation-compose_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NavHostControllerKt {
    private static final Saver<NavHostController, ?> NavControllerSaver(Context context) {
        return SaverKt.Saver(NavHostControllerKt$NavControllerSaver$1.INSTANCE, new NavHostControllerKt$NavControllerSaver$2(context));
    }

    /* access modifiers changed from: private */
    public static final NavHostController createNavController(Context context) {
        NavHostController navHostController = new NavHostController(context);
        navHostController.getNavigatorProvider().addNavigator(new ComposeNavigator());
        navHostController.getNavigatorProvider().addNavigator(new DialogNavigator());
        return navHostController;
    }

    @NotNull
    @Composable
    public static final State<NavBackStackEntry> currentBackStackEntryAsState(@NotNull NavController navController, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(navController, "<this>");
        composer.startReplaceableGroup(-120375203);
        State<NavBackStackEntry> collectAsState = SnapshotStateKt.collectAsState(navController.getCurrentBackStackEntryFlow(), null, (CoroutineContext) null, composer, 56, 2);
        composer.endReplaceableGroup();
        return collectAsState;
    }

    @NotNull
    @Composable
    public static final NavHostController rememberNavController(@NotNull Navigator<? extends NavDestination>[] navigatorArr, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(navigatorArr, "navigators");
        composer.startReplaceableGroup(-312215566);
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        NavHostController navHostController = (NavHostController) RememberSaveableKt.rememberSaveable(Arrays.copyOf(navigatorArr, navigatorArr.length), NavControllerSaver(context), (String) null, new NavHostControllerKt$rememberNavController$1(context), composer, 72, 4);
        for (Navigator<? extends NavDestination> addNavigator : navigatorArr) {
            navHostController.getNavigatorProvider().addNavigator(addNavigator);
        }
        composer.endReplaceableGroup();
        return navHostController;
    }
}
