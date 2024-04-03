package coil.size;

import androidx.annotation.MainThread;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0001\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u0011\u0010\u0002\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Lcoil/size/SizeResolver;", "", "size", "Lcoil/size/Size;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface SizeResolver {
    @NotNull
    public static final Companion Companion = Companion.f39797a;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcoil/size/SizeResolver$Companion;", "", "()V", "invoke", "Lcoil/size/SizeResolver;", "size", "Lcoil/size/Size;", "create", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f39797a = new Companion();

        private Companion() {
        }

        @JvmStatic
        @NotNull
        @JvmName(name = "create")
        public final SizeResolver create(@NotNull Size size) {
            Intrinsics.checkNotNullParameter(size, BindingAdaptersKt.QUERY_SIZE);
            return new RealSizeResolver(size);
        }
    }

    @Nullable
    @MainThread
    Object size(@NotNull Continuation<? super Size> continuation);
}
