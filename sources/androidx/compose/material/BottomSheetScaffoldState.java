package androidx.compose.material;

import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@ExperimentalMaterialApi
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material/BottomSheetScaffoldState;", "", "drawerState", "Landroidx/compose/material/DrawerState;", "bottomSheetState", "Landroidx/compose/material/BottomSheetState;", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;)V", "getBottomSheetState", "()Landroidx/compose/material/BottomSheetState;", "getDrawerState", "()Landroidx/compose/material/DrawerState;", "getSnackbarHostState", "()Landroidx/compose/material/SnackbarHostState;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Stable
public final class BottomSheetScaffoldState {
    @NotNull
    private final BottomSheetState bottomSheetState;
    @NotNull
    private final DrawerState drawerState;
    @NotNull
    private final SnackbarHostState snackbarHostState;

    public BottomSheetScaffoldState(@NotNull DrawerState drawerState2, @NotNull BottomSheetState bottomSheetState2, @NotNull SnackbarHostState snackbarHostState2) {
        Intrinsics.checkNotNullParameter(drawerState2, "drawerState");
        Intrinsics.checkNotNullParameter(bottomSheetState2, "bottomSheetState");
        Intrinsics.checkNotNullParameter(snackbarHostState2, "snackbarHostState");
        this.drawerState = drawerState2;
        this.bottomSheetState = bottomSheetState2;
        this.snackbarHostState = snackbarHostState2;
    }

    @NotNull
    public final BottomSheetState getBottomSheetState() {
        return this.bottomSheetState;
    }

    @NotNull
    public final DrawerState getDrawerState() {
        return this.drawerState;
    }

    @NotNull
    public final SnackbarHostState getSnackbarHostState() {
        return this.snackbarHostState;
    }
}
