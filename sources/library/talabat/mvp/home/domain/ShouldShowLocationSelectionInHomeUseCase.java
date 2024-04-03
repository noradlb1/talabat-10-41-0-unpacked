package library.talabat.mvp.home.domain;

import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0006"}, d2 = {"Llibrary/talabat/mvp/home/domain/ShouldShowLocationSelectionInHomeUseCase;", "", "shouldShowLocationSelection", "Lio/reactivex/Single;", "Llibrary/talabat/mvp/home/domain/ShouldShowLocationSelectionInHomeUseCase$Result;", "Result", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ShouldShowLocationSelectionInHomeUseCase {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Llibrary/talabat/mvp/home/domain/ShouldShowLocationSelectionInHomeUseCase$Result;", "", "()V", "DontShow", "ShouldShow", "Llibrary/talabat/mvp/home/domain/ShouldShowLocationSelectionInHomeUseCase$Result$ShouldShow;", "Llibrary/talabat/mvp/home/domain/ShouldShowLocationSelectionInHomeUseCase$Result$DontShow;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class Result {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Llibrary/talabat/mvp/home/domain/ShouldShowLocationSelectionInHomeUseCase$Result$DontShow;", "Llibrary/talabat/mvp/home/domain/ShouldShowLocationSelectionInHomeUseCase$Result;", "()V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class DontShow extends Result {
            @NotNull
            public static final DontShow INSTANCE = new DontShow();

            private DontShow() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Llibrary/talabat/mvp/home/domain/ShouldShowLocationSelectionInHomeUseCase$Result$ShouldShow;", "Llibrary/talabat/mvp/home/domain/ShouldShowLocationSelectionInHomeUseCase$Result;", "()V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class ShouldShow extends Result {
            @NotNull
            public static final ShouldShow INSTANCE = new ShouldShow();

            private ShouldShow() {
                super((DefaultConstructorMarker) null);
            }
        }

        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    Single<Result> shouldShowLocationSelection();
}
