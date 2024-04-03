package splitties.bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.support.api.entity.core.CommonCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aB\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\bø\u0001\u0000¢\u0006\u0002\u0010\t\u001aB\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\n2\u0006\u0010\u0005\u001a\u0002H\u00022\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aH\u0010\f\u001a\u0002H\r\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\r*\u00020\u000e2\u0006\u0010\u0005\u001a\u0002H\u00022\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\r0\u0007¢\u0006\u0002\b\bH\bø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001aH\u0010\u0010\u001a\u0002H\r\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\r*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\r0\u0007¢\u0006\u0002\b\bH\bø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001aH\u0010\u0010\u001a\u0002H\r\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\r*\u00020\n2\u0006\u0010\u0005\u001a\u0002H\u00022\u0019\b\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\r0\u0007¢\u0006\u0002\b\bH\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0013"}, d2 = {"putExtras", "", "Spec", "Lsplitties/bundle/BundleSpec;", "Landroid/app/Activity;", "spec", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/app/Activity;Lsplitties/bundle/BundleSpec;Lkotlin/jvm/functions/Function1;)V", "Landroid/content/Intent;", "(Landroid/content/Intent;Lsplitties/bundle/BundleSpec;Lkotlin/jvm/functions/Function1;)V", "with", "R", "Landroid/os/Bundle;", "(Landroid/os/Bundle;Lsplitties/bundle/BundleSpec;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withExtras", "(Landroid/app/Activity;Lsplitties/bundle/BundleSpec;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroid/content/Intent;Lsplitties/bundle/BundleSpec;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "splitties-bundle_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class BundleAccessorsKt {
    /* JADX INFO: finally extract failed */
    public static final <Spec extends BundleSpec> void putExtras(@NotNull Activity activity, @NotNull Spec spec, @NotNull Function1<? super Spec, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(function1, "block");
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        try {
            spec.setCurrentBundle(extras);
            function1.invoke(spec);
            InlineMarker.finallyStart(1);
            spec.setCurrentBundle((Bundle) null);
            InlineMarker.finallyEnd(1);
            Unit unit = Unit.INSTANCE;
            intent.replaceExtras(extras);
        } catch (Throwable th2) {
            InlineMarker.finallyStart(1);
            spec.setCurrentBundle((Bundle) null);
            InlineMarker.finallyEnd(1);
            throw th2;
        }
    }

    public static final <Spec extends BundleSpec, R> R with(@NotNull Bundle bundle, @NotNull Spec spec, @NotNull Function1<? super Spec, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(function1, "block");
        try {
            spec.setCurrentBundle(bundle);
            return function1.invoke(spec);
        } finally {
            InlineMarker.finallyStart(1);
            spec.setCurrentBundle((Bundle) null);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final <Spec extends BundleSpec, R> R withExtras(@NotNull Activity activity, @NotNull Spec spec, @NotNull Function1<? super Spec, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(function1, "block");
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        try {
            spec.setReadOnly(true);
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            spec.setCurrentBundle(extras);
            return function1.invoke(spec);
        } finally {
            InlineMarker.finallyStart(1);
            spec.setCurrentBundle((Bundle) null);
            spec.setReadOnly(false);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: finally extract failed */
    public static final <Spec extends BundleSpec> void putExtras(@NotNull Intent intent, @NotNull Spec spec, @NotNull Function1<? super Spec, Unit> function1) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(function1, "block");
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        try {
            spec.setCurrentBundle(extras);
            function1.invoke(spec);
            InlineMarker.finallyStart(1);
            spec.setCurrentBundle((Bundle) null);
            InlineMarker.finallyEnd(1);
            Unit unit = Unit.INSTANCE;
            intent.replaceExtras(extras);
        } catch (Throwable th2) {
            InlineMarker.finallyStart(1);
            spec.setCurrentBundle((Bundle) null);
            InlineMarker.finallyEnd(1);
            throw th2;
        }
    }

    public static final <Spec extends BundleSpec, R> R withExtras(@NotNull Intent intent, @NotNull Spec spec, @NotNull Function1<? super Spec, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(function1, "block");
        try {
            spec.setReadOnly(true);
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            spec.setCurrentBundle(extras);
            return function1.invoke(spec);
        } finally {
            InlineMarker.finallyStart(1);
            spec.setCurrentBundle((Bundle) null);
            spec.setReadOnly(false);
            InlineMarker.finallyEnd(1);
        }
    }
}
