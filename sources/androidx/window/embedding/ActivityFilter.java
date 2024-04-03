package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import com.huawei.hms.support.api.entity.core.CommonCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Landroidx/window/embedding/ActivityFilter;", "", "componentName", "Landroid/content/ComponentName;", "intentAction", "", "(Landroid/content/ComponentName;Ljava/lang/String;)V", "getComponentName", "()Landroid/content/ComponentName;", "getIntentAction", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "matchesActivity", "activity", "Landroid/app/Activity;", "matchesIntent", "intent", "Landroid/content/Intent;", "toString", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalWindowApi
public final class ActivityFilter {
    @NotNull
    private final ComponentName componentName;
    @Nullable
    private final String intentAction;

    public ActivityFilter(@NotNull ComponentName componentName2, @Nullable String str) {
        boolean z11;
        boolean z12;
        boolean z13;
        Intrinsics.checkNotNullParameter(componentName2, "componentName");
        this.componentName = componentName2;
        this.intentAction = str;
        String packageName = componentName2.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "componentName.packageName");
        String className = componentName2.getClassName();
        Intrinsics.checkNotNullExpressionValue(className, "componentName.className");
        boolean z14 = true;
        if (packageName.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (className.length() > 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (!StringsKt__StringsKt.contains$default((CharSequence) packageName, (CharSequence) "*", false, 2, (Object) null) || StringsKt__StringsKt.indexOf$default((CharSequence) packageName, "*", 0, false, 6, (Object) null) == packageName.length() - 1) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (z13) {
                    if (StringsKt__StringsKt.contains$default((CharSequence) className, (CharSequence) "*", false, 2, (Object) null) && StringsKt__StringsKt.indexOf$default((CharSequence) className, "*", 0, false, 6, (Object) null) != className.length() - 1) {
                        z14 = false;
                    }
                    if (!z14) {
                        throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
                    }
                    return;
                }
                throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
            }
            throw new IllegalArgumentException("Activity class name must not be empty.".toString());
        }
        throw new IllegalArgumentException("Package name must not be empty".toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityFilter)) {
            return false;
        }
        ActivityFilter activityFilter = (ActivityFilter) obj;
        if (Intrinsics.areEqual((Object) this.componentName, (Object) activityFilter.componentName) && Intrinsics.areEqual((Object) this.intentAction, (Object) activityFilter.intentAction)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ComponentName getComponentName() {
        return this.componentName;
    }

    @Nullable
    public final String getIntentAction() {
        return this.intentAction;
    }

    public int hashCode() {
        int i11;
        int hashCode = this.componentName.hashCode() * 31;
        String str = this.intentAction;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        return hashCode + i11;
    }

    public final boolean matchesActivity(@NotNull Activity activity) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (MatcherUtils.INSTANCE.areActivityOrIntentComponentsMatching$window_release(activity, this.componentName)) {
            String str2 = this.intentAction;
            if (str2 != null) {
                Intent intent = activity.getIntent();
                if (intent == null) {
                    str = null;
                } else {
                    str = intent.getAction();
                }
                if (Intrinsics.areEqual((Object) str2, (Object) str)) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public final boolean matchesIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        if (!MatcherUtils.INSTANCE.areComponentsMatching$window_release(intent.getComponent(), this.componentName)) {
            return false;
        }
        String str = this.intentAction;
        if (str == null || Intrinsics.areEqual((Object) str, (Object) intent.getAction())) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "ActivityFilter(componentName=" + this.componentName + ", intentAction=" + this.intentAction + ')';
    }
}
