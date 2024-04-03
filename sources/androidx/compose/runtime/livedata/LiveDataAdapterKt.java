package androidx.compose.runtime.livedata;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a5\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0002*\u0002H\u0005*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0006\u001a\u0002H\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"observeAsState", "Landroidx/compose/runtime/State;", "T", "Landroidx/lifecycle/LiveData;", "(Landroidx/lifecycle/LiveData;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "R", "initial", "(Landroidx/lifecycle/LiveData;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "runtime-livedata_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class LiveDataAdapterKt {
    @NotNull
    @Composable
    public static final <T> State<T> observeAsState(@NotNull LiveData<T> liveData, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        composer.startReplaceableGroup(-2027640062);
        State<T> observeAsState = observeAsState(liveData, liveData.getValue(), composer, 8);
        composer.endReplaceableGroup();
        return observeAsState;
    }

    @NotNull
    @Composable
    public static final <R, T extends R> State<R> observeAsState(@NotNull LiveData<T> liveData, R r11, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        composer.startReplaceableGroup(-2027639486);
        LifecycleOwner lifecycleOwner = (LifecycleOwner) composer.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r11, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        EffectsKt.DisposableEffect(liveData, lifecycleOwner, new LiveDataAdapterKt$observeAsState$1(liveData, lifecycleOwner, mutableState), composer, 72);
        composer.endReplaceableGroup();
        return mutableState;
    }
}
