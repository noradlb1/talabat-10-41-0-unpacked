package androidx.window.embedding;

import android.app.Activity;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0013\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Landroidx/window/embedding/SplitInfo;", "", "primaryActivityStack", "Landroidx/window/embedding/ActivityStack;", "secondaryActivityStack", "splitRatio", "", "(Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/ActivityStack;F)V", "getPrimaryActivityStack", "()Landroidx/window/embedding/ActivityStack;", "getSecondaryActivityStack", "getSplitRatio", "()F", "contains", "", "activity", "Landroid/app/Activity;", "equals", "other", "hashCode", "", "toString", "", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalWindowApi
public final class SplitInfo {
    @NotNull
    private final ActivityStack primaryActivityStack;
    @NotNull
    private final ActivityStack secondaryActivityStack;
    private final float splitRatio;

    public SplitInfo(@NotNull ActivityStack activityStack, @NotNull ActivityStack activityStack2, float f11) {
        Intrinsics.checkNotNullParameter(activityStack, "primaryActivityStack");
        Intrinsics.checkNotNullParameter(activityStack2, "secondaryActivityStack");
        this.primaryActivityStack = activityStack;
        this.secondaryActivityStack = activityStack2;
        this.splitRatio = f11;
    }

    public final boolean contains(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.primaryActivityStack.contains(activity) || this.secondaryActivityStack.contains(activity)) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitInfo)) {
            return false;
        }
        SplitInfo splitInfo = (SplitInfo) obj;
        if (!Intrinsics.areEqual((Object) this.primaryActivityStack, (Object) splitInfo.primaryActivityStack) || !Intrinsics.areEqual((Object) this.secondaryActivityStack, (Object) splitInfo.secondaryActivityStack)) {
            return false;
        }
        if (this.splitRatio == splitInfo.splitRatio) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return false;
        }
        return true;
    }

    @NotNull
    public final ActivityStack getPrimaryActivityStack() {
        return this.primaryActivityStack;
    }

    @NotNull
    public final ActivityStack getSecondaryActivityStack() {
        return this.secondaryActivityStack;
    }

    public final float getSplitRatio() {
        return this.splitRatio;
    }

    public int hashCode() {
        return (((this.primaryActivityStack.hashCode() * 31) + this.secondaryActivityStack.hashCode()) * 31) + Float.floatToIntBits(this.splitRatio);
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SplitInfo:{");
        sb2.append("primaryActivityStack=" + getPrimaryActivityStack() + AbstractJsonLexerKt.COMMA);
        sb2.append("secondaryActivityStack=" + getSecondaryActivityStack() + AbstractJsonLexerKt.COMMA);
        sb2.append("splitRatio=" + getSplitRatio() + AbstractJsonLexerKt.END_OBJ);
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
