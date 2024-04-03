package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composer;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\b\b¢\u0006\u0002\b\tH\u0017¢\u0006\u0002\u0010\nJC\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\b\b¢\u0006\u0002\b\tH\u0016¢\u0006\u0002\u0010\fJ\u0001\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2%\b\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062%\b\u0002\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000621\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0002\b\b¢\u0006\u0002\b\tH\u0016¢\u0006\u0002\u0010\u0015Jo\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2%\b\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000621\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0002\b\b¢\u0006\u0002\b\tH\u0017¢\u0006\u0002\u0010\u0016JC\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\b\b¢\u0006\u0002\b\tH'¢\u0006\u0002\u0010\fø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListScope;", "", "item", "", "key", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "contentType", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", "name", "index", "itemContent", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "stickyHeader", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@LazyScopeMarker
public interface LazyListScope {

    /* renamed from: androidx.compose.foundation.lazy.LazyListScope$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void a(LazyListScope lazyListScope, @Nullable Object obj, @Nullable Object obj2, @NotNull Function3 function3) {
            Intrinsics.checkNotNullParameter(function3, "content");
            throw new IllegalStateException("The method is not implemented".toString());
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
        public static /* synthetic */ void b(LazyListScope lazyListScope, Object obj, Function3 function3) {
            Intrinsics.checkNotNullParameter(function3, "content");
            lazyListScope.item(obj, (Object) null, function3);
        }

        public static void c(LazyListScope lazyListScope, int i11, @Nullable Function1 function1, @NotNull Function1 function12, @NotNull Function4 function4) {
            Intrinsics.checkNotNullParameter(function12, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
            Intrinsics.checkNotNullParameter(function4, "itemContent");
            throw new IllegalStateException("The method is not implemented".toString());
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
        public static /* synthetic */ void d(LazyListScope lazyListScope, int i11, Function1 function1, Function4 function4) {
            Intrinsics.checkNotNullParameter(function4, "itemContent");
            lazyListScope.items(i11, function1, LazyListScope$items$2.INSTANCE, function4);
        }

        public static /* synthetic */ void i(LazyListScope lazyListScope, Object obj, Object obj2, Function3 function3, int i11, Object obj3) {
            if (obj3 == null) {
                if ((i11 & 1) != 0) {
                    obj = null;
                }
                if ((i11 & 2) != 0) {
                    obj2 = null;
                }
                lazyListScope.item(obj, obj2, function3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }

        public static /* synthetic */ void j(LazyListScope lazyListScope, Object obj, Function3 function3, int i11, Object obj2) {
            if (obj2 == null) {
                if ((i11 & 1) != 0) {
                    obj = null;
                }
                lazyListScope.item(obj, function3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }

        public static /* synthetic */ void k(LazyListScope lazyListScope, int i11, Function1 function1, Function1 function12, Function4 function4, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    function1 = null;
                }
                if ((i12 & 4) != 0) {
                    function12 = LazyListScope$items$1.INSTANCE;
                }
                lazyListScope.items(i11, function1, function12, function4);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }

        public static /* synthetic */ void l(LazyListScope lazyListScope, int i11, Function1 function1, Function4 function4, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    function1 = null;
                }
                lazyListScope.items(i11, function1, function4);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }

        public static /* synthetic */ void m(LazyListScope lazyListScope, Object obj, Object obj2, Function3 function3, int i11, Object obj3) {
            if (obj3 == null) {
                if ((i11 & 1) != 0) {
                    obj = null;
                }
                if ((i11 & 2) != 0) {
                    obj2 = null;
                }
                lazyListScope.stickyHeader(obj, obj2, function3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stickyHeader");
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void item(@NotNull LazyListScope lazyListScope, @Nullable Object obj, @Nullable Object obj2, @NotNull Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> function3) {
            Intrinsics.checkNotNullParameter(function3, "content");
            CC.a(lazyListScope, obj, obj2, function3);
        }

        @Deprecated
        public static void items(@NotNull LazyListScope lazyListScope, int i11, @Nullable Function1<? super Integer, ? extends Object> function1, @NotNull Function1<? super Integer, ? extends Object> function12, @NotNull Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4) {
            Intrinsics.checkNotNullParameter(function12, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
            Intrinsics.checkNotNullParameter(function4, "itemContent");
            CC.c(lazyListScope, i11, function1, function12, function4);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
        @Deprecated
        public static /* synthetic */ void item(LazyListScope lazyListScope, Object obj, Function3 function3) {
            Intrinsics.checkNotNullParameter(function3, "content");
            CC.b(lazyListScope, obj, function3);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
        @Deprecated
        public static /* synthetic */ void items(LazyListScope lazyListScope, int i11, Function1 function1, Function4 function4) {
            Intrinsics.checkNotNullParameter(function4, "itemContent");
            CC.d(lazyListScope, i11, function1, function4);
        }
    }

    void item(@Nullable Object obj, @Nullable Object obj2, @NotNull Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> function3);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* synthetic */ void item(Object obj, Function3 function3);

    void items(int i11, @Nullable Function1<? super Integer, ? extends Object> function1, @NotNull Function1<? super Integer, ? extends Object> function12, @NotNull Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* synthetic */ void items(int i11, Function1 function1, Function4 function4);

    @ExperimentalFoundationApi
    void stickyHeader(@Nullable Object obj, @Nullable Object obj2, @NotNull Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> function3);
}
