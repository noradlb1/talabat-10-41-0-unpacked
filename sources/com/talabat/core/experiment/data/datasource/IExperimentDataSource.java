package com.talabat.core.experiment.data.datasource;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\bJ4\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH\u0016J)\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ4\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0010H\u0016J)\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J4\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0013H\u0016J)\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J4\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/talabat/core/experiment/data/datasource/IExperimentDataSource;", "", "getBooleanVariant", "", "experimentKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "forceRequest", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lkotlin/Function1;", "getDoubleVariant", "", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;DZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIntVariant", "", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStringVariant", "", "(Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAttribute", "attributeKey", "attributeValue", "com_talabat_core_experiment_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IExperimentDataSource {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @Nullable
        public static Object getBooleanVariant(@NotNull IExperimentDataSource iExperimentDataSource, @NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Continuation<? super Boolean> continuation) {
            return Boxing.boxBoolean(z11);
        }

        public static boolean getBooleanVariant(@NotNull IExperimentDataSource iExperimentDataSource, @NotNull FWFKey fWFKey, boolean z11) {
            Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
            return z11;
        }

        public static double getDoubleVariant(@NotNull IExperimentDataSource iExperimentDataSource, @NotNull FWFKey fWFKey, double d11) {
            Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
            return d11;
        }

        @Nullable
        public static Object getDoubleVariant(@NotNull IExperimentDataSource iExperimentDataSource, @NotNull FWFKey fWFKey, double d11, boolean z11, @NotNull Continuation<? super Double> continuation) {
            return Boxing.boxDouble(d11);
        }

        public static int getIntVariant(@NotNull IExperimentDataSource iExperimentDataSource, @NotNull FWFKey fWFKey, int i11) {
            Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
            return i11;
        }

        @Nullable
        public static Object getIntVariant(@NotNull IExperimentDataSource iExperimentDataSource, @NotNull FWFKey fWFKey, int i11, boolean z11, @NotNull Continuation<? super Integer> continuation) {
            return Boxing.boxInt(i11);
        }

        @Nullable
        public static Object getStringVariant(@NotNull IExperimentDataSource iExperimentDataSource, @NotNull FWFKey fWFKey, @NotNull String str, boolean z11, @NotNull Continuation<? super String> continuation) {
            return str;
        }

        @NotNull
        public static String getStringVariant(@NotNull IExperimentDataSource iExperimentDataSource, @NotNull FWFKey fWFKey, @NotNull String str) {
            Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
            Intrinsics.checkNotNullParameter(str, "defaultValue");
            return str;
        }

        public static void getStringVariant(@NotNull IExperimentDataSource iExperimentDataSource, @NotNull FWFKey fWFKey, @NotNull String str, boolean z11, @NotNull Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
            Intrinsics.checkNotNullParameter(str, "defaultValue");
            Intrinsics.checkNotNullParameter(function1, "callback");
            function1.invoke(str);
        }

        public static void setAttribute(@NotNull IExperimentDataSource iExperimentDataSource, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "attributeKey");
            Intrinsics.checkNotNullParameter(str2, "attributeValue");
        }

        public static void getBooleanVariant(@NotNull IExperimentDataSource iExperimentDataSource, @NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
            Intrinsics.checkNotNullParameter(function1, "callback");
            function1.invoke(Boolean.valueOf(z11));
        }

        public static void getDoubleVariant(@NotNull IExperimentDataSource iExperimentDataSource, @NotNull FWFKey fWFKey, double d11, boolean z11, @NotNull Function1<? super Double, Unit> function1) {
            Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
            Intrinsics.checkNotNullParameter(function1, "callback");
            function1.invoke(Double.valueOf(d11));
        }

        public static void getIntVariant(@NotNull IExperimentDataSource iExperimentDataSource, @NotNull FWFKey fWFKey, int i11, boolean z11, @NotNull Function1<? super Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
            Intrinsics.checkNotNullParameter(function1, "callback");
            function1.invoke(Integer.valueOf(i11));
        }
    }

    @Nullable
    Object getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Continuation<? super Boolean> continuation);

    void getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Function1<? super Boolean, Unit> function1);

    boolean getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11);

    double getDoubleVariant(@NotNull FWFKey fWFKey, double d11);

    @Nullable
    Object getDoubleVariant(@NotNull FWFKey fWFKey, double d11, boolean z11, @NotNull Continuation<? super Double> continuation);

    void getDoubleVariant(@NotNull FWFKey fWFKey, double d11, boolean z11, @NotNull Function1<? super Double, Unit> function1);

    int getIntVariant(@NotNull FWFKey fWFKey, int i11);

    @Nullable
    Object getIntVariant(@NotNull FWFKey fWFKey, int i11, boolean z11, @NotNull Continuation<? super Integer> continuation);

    void getIntVariant(@NotNull FWFKey fWFKey, int i11, boolean z11, @NotNull Function1<? super Integer, Unit> function1);

    @Nullable
    Object getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str, boolean z11, @NotNull Continuation<? super String> continuation);

    @NotNull
    String getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str);

    void getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str, boolean z11, @NotNull Function1<? super String, Unit> function1);

    void setAttribute(@NotNull String str, @NotNull String str2);
}
