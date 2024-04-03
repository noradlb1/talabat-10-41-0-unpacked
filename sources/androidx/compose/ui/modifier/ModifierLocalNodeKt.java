package androidx.compose.ui.modifier;

import androidx.compose.ui.ExperimentalComposeUiApi;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007\u001a)\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006\"\u0006\u0012\u0002\b\u00030\u0004H\u0007¢\u0006\u0002\u0010\u0007\u001aA\u0010\u0000\u001a\u00020\u000122\u0010\b\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\n0\t0\u0006\"\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\u0010\u000b\u001a(\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u0002H\u00020\tH\u0007¨\u0006\r"}, d2 = {"modifierLocalMapOf", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "T", "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "keys", "", "([Landroidx/compose/ui/modifier/ModifierLocal;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "entries", "Lkotlin/Pair;", "", "([Lkotlin/Pair;)Landroidx/compose/ui/modifier/ModifierLocalMap;", "entry", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ModifierLocalNodeKt {
    @ExperimentalComposeUiApi
    @NotNull
    public static final ModifierLocalMap modifierLocalMapOf() {
        return EmptyMap.INSTANCE;
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final <T> ModifierLocalMap modifierLocalMapOf(@NotNull ModifierLocal<T> modifierLocal) {
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        return new SingleLocalMap(modifierLocal);
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final <T> ModifierLocalMap modifierLocalMapOf(@NotNull Pair<? extends ModifierLocal<T>, ? extends T> pair) {
        Intrinsics.checkNotNullParameter(pair, "entry");
        SingleLocalMap singleLocalMap = new SingleLocalMap((ModifierLocal) pair.getFirst());
        singleLocalMap.set$ui_release((ModifierLocal) pair.getFirst(), pair.getSecond());
        return singleLocalMap;
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final ModifierLocalMap modifierLocalMapOf(@NotNull Pair<? extends ModifierLocal<?>, ? extends Object>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, RemoteConfigConstants.ResponseFieldKey.ENTRIES);
        return new MultiLocalMap((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final ModifierLocalMap modifierLocalMapOf(@NotNull ModifierLocal<?>... modifierLocalArr) {
        Intrinsics.checkNotNullParameter(modifierLocalArr, UserMetadata.KEYDATA_FILENAME);
        ArrayList arrayList = new ArrayList(modifierLocalArr.length);
        for (ModifierLocal<?> modifierLocal : modifierLocalArr) {
            arrayList.add(TuplesKt.to(modifierLocal, null));
        }
        Object[] array = arrayList.toArray(new Pair[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Pair[] pairArr = (Pair[]) array;
        return new MultiLocalMap((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }
}
