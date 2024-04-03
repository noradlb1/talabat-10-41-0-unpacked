package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import com.facebook.share.internal.ShareConstants;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0002\b\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Landroidx/window/embedding/ActivityRule;", "Landroidx/window/embedding/EmbeddingRule;", "filters", "", "Landroidx/window/embedding/ActivityFilter;", "alwaysExpand", "", "(Ljava/util/Set;Z)V", "getAlwaysExpand", "()Z", "getFilters", "()Ljava/util/Set;", "equals", "other", "", "hashCode", "", "plus", "filter", "plus$window_release", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalWindowApi
public final class ActivityRule extends EmbeddingRule {
    private final boolean alwaysExpand;
    @NotNull
    private final Set<ActivityFilter> filters;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActivityRule(Set set, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, (i11 & 2) != 0 ? false : z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityRule)) {
            return false;
        }
        ActivityRule activityRule = (ActivityRule) obj;
        if (Intrinsics.areEqual((Object) this.filters, (Object) activityRule.filters) && this.alwaysExpand == activityRule.alwaysExpand) {
            return true;
        }
        return false;
    }

    public final boolean getAlwaysExpand() {
        return this.alwaysExpand;
    }

    @NotNull
    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public int hashCode() {
        return (this.filters.hashCode() * 31) + e.a(this.alwaysExpand);
    }

    @NotNull
    public final ActivityRule plus$window_release(@NotNull ActivityFilter activityFilter) {
        Intrinsics.checkNotNullParameter(activityFilter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(activityFilter);
        return new ActivityRule(CollectionsKt___CollectionsKt.toSet(linkedHashSet), this.alwaysExpand);
    }

    public ActivityRule(@NotNull Set<ActivityFilter> set, boolean z11) {
        Intrinsics.checkNotNullParameter(set, ShareConstants.WEB_DIALOG_PARAM_FILTERS);
        this.alwaysExpand = z11;
        this.filters = CollectionsKt___CollectionsKt.toSet(set);
    }
}
