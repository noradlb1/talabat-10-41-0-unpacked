package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class a<E> {
    @NotNull
    public static ImmutableList a(ImmutableList immutableList, int i11, int i12) {
        return new ImmutableList.SubList(immutableList, i11, i12);
    }
}
