package androidx.window.embedding;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import android.view.WindowMetrics;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.extensions.embedding.ActivityRule;
import androidx.window.extensions.embedding.ActivityStack;
import androidx.window.extensions.embedding.EmbeddingRule;
import androidx.window.extensions.embedding.SplitInfo;
import androidx.window.extensions.embedding.SplitPairRule;
import androidx.window.extensions.embedding.SplitPlaceholderRule;
import com.huawei.hms.support.api.entity.core.CommonCode;
import j$.util.function.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import s2.a;
import s2.b;
import s2.c;
import s2.d;
import s2.e;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\u0002¢\u0006\u0004\b\t\u0010\nJ,\u0010\u000b\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fJ(\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\b0\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007J(\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00140\b0\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000eH\u0007J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000eH\u0007J\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020 0\u000e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000e¨\u0006#"}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter;", "", "Landroidx/window/extensions/embedding/SplitInfo;", "splitInfo", "Landroidx/window/embedding/SplitInfo;", "translate", "F", "S", "Landroid/util/Pair;", "component1", "(Landroid/util/Pair;)Ljava/lang/Object;", "component2", "", "splitInfoList", "", "Landroidx/window/embedding/SplitPairFilter;", "splitPairFilters", "j$/util/function/Predicate", "Landroid/app/Activity;", "translateActivityPairPredicates", "Landroid/content/Intent;", "translateActivityIntentPredicates", "Landroidx/window/embedding/SplitRule;", "splitRule", "Landroid/view/WindowMetrics;", "translateParentMetricsPredicate", "Landroidx/window/embedding/ActivityFilter;", "activityFilters", "translateActivityPredicates", "translateIntentPredicates", "Landroidx/window/embedding/EmbeddingRule;", "rules", "Landroidx/window/extensions/embedding/EmbeddingRule;", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
@ExperimentalWindowApi
public final class EmbeddingAdapter {
    private final <F, S> F component1(Pair<F, S> pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return pair.first;
    }

    private final <F, S> S component2(Pair<F, S> pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return pair.second;
    }

    /* access modifiers changed from: private */
    /* renamed from: translateActivityIntentPredicates$lambda-3  reason: not valid java name */
    public static final boolean m9123translateActivityIntentPredicates$lambda3(EmbeddingAdapter embeddingAdapter, Set set, Pair pair) {
        Intrinsics.checkNotNullParameter(embeddingAdapter, "this$0");
        Intrinsics.checkNotNullParameter(set, "$splitPairFilters");
        Intrinsics.checkNotNullExpressionValue(pair, "(first, second)");
        Activity activity = (Activity) embeddingAdapter.component1(pair);
        Intent intent = (Intent) embeddingAdapter.component2(pair);
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (((SplitPairFilter) it.next()).matchesActivityIntentPair(activity, intent)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: translateActivityPairPredicates$lambda-1  reason: not valid java name */
    public static final boolean m9124translateActivityPairPredicates$lambda1(EmbeddingAdapter embeddingAdapter, Set set, Pair pair) {
        Intrinsics.checkNotNullParameter(embeddingAdapter, "this$0");
        Intrinsics.checkNotNullParameter(set, "$splitPairFilters");
        Intrinsics.checkNotNullExpressionValue(pair, "(first, second)");
        Activity activity = (Activity) embeddingAdapter.component1(pair);
        Activity activity2 = (Activity) embeddingAdapter.component2(pair);
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (((SplitPairFilter) it.next()).matchesActivityPair(activity, activity2)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: translateActivityPredicates$lambda-6  reason: not valid java name */
    public static final boolean m9125translateActivityPredicates$lambda6(Set set, Activity activity) {
        Intrinsics.checkNotNullParameter(set, "$activityFilters");
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            if (((ActivityFilter) it.next()).matchesActivity(activity)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: translateIntentPredicates$lambda-8  reason: not valid java name */
    public static final boolean m9126translateIntentPredicates$lambda8(Set set, Intent intent) {
        Intrinsics.checkNotNullParameter(set, "$activityFilters");
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Intrinsics.checkNotNullExpressionValue(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            if (((ActivityFilter) it.next()).matchesIntent(intent)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: translateParentMetricsPredicate$lambda-4  reason: not valid java name */
    public static final boolean m9127translateParentMetricsPredicate$lambda4(SplitRule splitRule, WindowMetrics windowMetrics) {
        Intrinsics.checkNotNullParameter(splitRule, "$splitRule");
        Intrinsics.checkNotNullExpressionValue(windowMetrics, "windowMetrics");
        return splitRule.checkParentMetrics(windowMetrics);
    }

    @NotNull
    public final List<SplitInfo> translate(@NotNull List<? extends SplitInfo> list) {
        Intrinsics.checkNotNullParameter(list, "splitInfoList");
        Iterable<SplitInfo> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (SplitInfo translate : iterable) {
            arrayList.add(translate(translate));
        }
        return arrayList;
    }

    @NotNull
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Pair<Activity, Intent>> translateActivityIntentPredicates(@NotNull Set<SplitPairFilter> set) {
        Intrinsics.checkNotNullParameter(set, "splitPairFilters");
        return new a(this, set);
    }

    @NotNull
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Pair<Activity, Activity>> translateActivityPairPredicates(@NotNull Set<SplitPairFilter> set) {
        Intrinsics.checkNotNullParameter(set, "splitPairFilters");
        return new e(this, set);
    }

    @NotNull
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Activity> translateActivityPredicates(@NotNull Set<ActivityFilter> set) {
        Intrinsics.checkNotNullParameter(set, "activityFilters");
        return new b(set);
    }

    @NotNull
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Intent> translateIntentPredicates(@NotNull Set<ActivityFilter> set) {
        Intrinsics.checkNotNullParameter(set, "activityFilters");
        return new d(set);
    }

    @NotNull
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<WindowMetrics> translateParentMetricsPredicate(@NotNull SplitRule splitRule) {
        Intrinsics.checkNotNullParameter(splitRule, "splitRule");
        return new c(splitRule);
    }

    private final SplitInfo translate(SplitInfo splitInfo) {
        boolean z11;
        ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
        Intrinsics.checkNotNullExpressionValue(primaryActivityStack, "splitInfo.primaryActivityStack");
        boolean z12 = false;
        try {
            z11 = primaryActivityStack.isEmpty();
        } catch (NoSuchMethodError unused) {
            z11 = false;
        }
        List activities = primaryActivityStack.getActivities();
        Intrinsics.checkNotNullExpressionValue(activities, "primaryActivityStack.activities");
        ActivityStack activityStack = new ActivityStack(activities, z11);
        ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
        Intrinsics.checkNotNullExpressionValue(secondaryActivityStack, "splitInfo.secondaryActivityStack");
        try {
            z12 = secondaryActivityStack.isEmpty();
        } catch (NoSuchMethodError unused2) {
        }
        List activities2 = secondaryActivityStack.getActivities();
        Intrinsics.checkNotNullExpressionValue(activities2, "secondaryActivityStack.activities");
        return new SplitInfo(activityStack, new ActivityStack(activities2, z12), splitInfo.getSplitRatio());
    }

    @NotNull
    public final Set<EmbeddingRule> translate(@NotNull Set<? extends EmbeddingRule> set) {
        SplitPairRule splitPairRule;
        Intrinsics.checkNotNullParameter(set, "rules");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(set, 10));
        for (EmbeddingRule embeddingRule : set) {
            if (embeddingRule instanceof SplitPairRule) {
                SplitPairRule splitPairRule2 = (SplitPairRule) embeddingRule;
                splitPairRule = new SplitPairRule.Builder(translateActivityPairPredicates(splitPairRule2.getFilters()), translateActivityIntentPredicates(splitPairRule2.getFilters()), translateParentMetricsPredicate((SplitRule) embeddingRule)).setSplitRatio(splitPairRule2.getSplitRatio()).setLayoutDirection(splitPairRule2.getLayoutDirection()).setShouldFinishPrimaryWithSecondary(splitPairRule2.getFinishPrimaryWithSecondary()).setShouldFinishSecondaryWithPrimary(splitPairRule2.getFinishSecondaryWithPrimary()).setShouldClearTop(splitPairRule2.getClearTop()).build();
                Intrinsics.checkNotNullExpressionValue(splitPairRule, "SplitPairRuleBuilder(\n  …                 .build()");
            } else if (embeddingRule instanceof SplitPlaceholderRule) {
                SplitPlaceholderRule splitPlaceholderRule = (SplitPlaceholderRule) embeddingRule;
                splitPairRule = new SplitPlaceholderRule.Builder(splitPlaceholderRule.getPlaceholderIntent(), translateActivityPredicates(splitPlaceholderRule.getFilters()), translateIntentPredicates(splitPlaceholderRule.getFilters()), translateParentMetricsPredicate((SplitRule) embeddingRule)).setSplitRatio(splitPlaceholderRule.getSplitRatio()).setLayoutDirection(splitPlaceholderRule.getLayoutDirection()).build();
                Intrinsics.checkNotNullExpressionValue(splitPairRule, "SplitPlaceholderRuleBuil…                 .build()");
            } else if (embeddingRule instanceof ActivityRule) {
                ActivityRule activityRule = (ActivityRule) embeddingRule;
                splitPairRule = new ActivityRule.Builder(translateActivityPredicates(activityRule.getFilters()), translateIntentPredicates(activityRule.getFilters())).setShouldAlwaysExpand(activityRule.getAlwaysExpand()).build();
                Intrinsics.checkNotNullExpressionValue(splitPairRule, "ActivityRuleBuilder(\n   …                 .build()");
            } else {
                throw new IllegalArgumentException("Unsupported rule type");
            }
            arrayList.add((EmbeddingRule) splitPairRule);
        }
        return CollectionsKt___CollectionsKt.toSet(arrayList);
    }
}
