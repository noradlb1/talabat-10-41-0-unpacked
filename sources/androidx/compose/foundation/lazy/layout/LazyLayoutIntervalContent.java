package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001R1\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR1\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "", "key", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "index", "getKey", "()Lkotlin/jvm/functions/Function1;", "type", "getType", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalFoundationApi
public interface LazyLayoutIntervalContent {

    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        @Nullable
        public static Function1 a(LazyLayoutIntervalContent lazyLayoutIntervalContent) {
            return null;
        }

        @NotNull
        public static Function1 b(LazyLayoutIntervalContent lazyLayoutIntervalContent) {
            return LazyLayoutIntervalContent$type$1.INSTANCE;
        }
    }

    @Nullable
    Function1<Integer, Object> getKey();

    @NotNull
    Function1<Integer, Object> getType();
}
