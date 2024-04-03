package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014J\b\u0010\u0019\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Landroidx/window/embedding/SplitPairFilter;", "", "primaryActivityName", "Landroid/content/ComponentName;", "secondaryActivityName", "secondaryActivityIntentAction", "", "(Landroid/content/ComponentName;Landroid/content/ComponentName;Ljava/lang/String;)V", "getPrimaryActivityName", "()Landroid/content/ComponentName;", "getSecondaryActivityIntentAction", "()Ljava/lang/String;", "getSecondaryActivityName", "equals", "", "other", "hashCode", "", "matchesActivityIntentPair", "primaryActivity", "Landroid/app/Activity;", "secondaryActivityIntent", "Landroid/content/Intent;", "matchesActivityPair", "secondaryActivity", "toString", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalWindowApi
public final class SplitPairFilter {
    @NotNull
    private final ComponentName primaryActivityName;
    @Nullable
    private final String secondaryActivityIntentAction;
    @NotNull
    private final ComponentName secondaryActivityName;

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0148  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SplitPairFilter(@org.jetbrains.annotations.NotNull android.content.ComponentName r18, @org.jetbrains.annotations.NotNull android.content.ComponentName r19, @org.jetbrains.annotations.Nullable java.lang.String r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.String r3 = "primaryActivityName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "secondaryActivityName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            r17.<init>()
            r0.primaryActivityName = r1
            r0.secondaryActivityName = r2
            r3 = r20
            r0.secondaryActivityIntentAction = r3
            java.lang.String r7 = r18.getPackageName()
            java.lang.String r3 = "primaryActivityName.packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r3)
            java.lang.String r14 = r18.getClassName()
            java.lang.String r1 = "primaryActivityName.className"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r1)
            java.lang.String r15 = r19.getPackageName()
            java.lang.String r1 = "secondaryActivityName.packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r1)
            java.lang.String r13 = r19.getClassName()
            java.lang.String r1 = "secondaryActivityName.className"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r1)
            int r1 = r7.length()
            r16 = 1
            r12 = 0
            if (r1 != 0) goto L_0x004b
            r1 = r16
            goto L_0x004c
        L_0x004b:
            r1 = r12
        L_0x004c:
            if (r1 != 0) goto L_0x005d
            int r1 = r15.length()
            if (r1 != 0) goto L_0x0057
            r1 = r16
            goto L_0x0058
        L_0x0057:
            r1 = r12
        L_0x0058:
            if (r1 != 0) goto L_0x005d
            r1 = r16
            goto L_0x005e
        L_0x005d:
            r1 = r12
        L_0x005e:
            if (r1 == 0) goto L_0x0148
            int r1 = r14.length()
            if (r1 != 0) goto L_0x0069
            r1 = r16
            goto L_0x006a
        L_0x0069:
            r1 = r12
        L_0x006a:
            if (r1 != 0) goto L_0x007b
            int r1 = r13.length()
            if (r1 != 0) goto L_0x0075
            r1 = r16
            goto L_0x0076
        L_0x0075:
            r1 = r12
        L_0x0076:
            if (r1 != 0) goto L_0x007b
            r1 = r16
            goto L_0x007c
        L_0x007b:
            r1 = r12
        L_0x007c:
            if (r1 == 0) goto L_0x013c
            java.lang.String r11 = "*"
            r10 = 2
            r9 = 0
            boolean r1 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r7, (java.lang.CharSequence) r11, (boolean) r12, (int) r10, (java.lang.Object) r9)
            if (r1 == 0) goto L_0x009e
            java.lang.String r2 = "*"
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r7
            int r1 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r1, (java.lang.String) r2, (int) r3, (boolean) r4, (int) r5, (java.lang.Object) r6)
            int r2 = r7.length()
            int r2 = r2 + -1
            if (r1 != r2) goto L_0x009c
            goto L_0x009e
        L_0x009c:
            r1 = r12
            goto L_0x00a0
        L_0x009e:
            r1 = r16
        L_0x00a0:
            java.lang.String r2 = "Wildcard in package name is only allowed at the end."
            if (r1 == 0) goto L_0x0132
            boolean r1 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r14, (java.lang.CharSequence) r11, (boolean) r12, (int) r10, (java.lang.Object) r9)
            if (r1 == 0) goto L_0x00ca
            java.lang.String r1 = "*"
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r8 = r14
            r7 = r9
            r9 = r1
            r1 = r10
            r10 = r3
            r3 = r11
            r11 = r4
            r4 = r12
            r12 = r5
            r5 = r13
            r13 = r6
            int r6 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r8, (java.lang.String) r9, (int) r10, (boolean) r11, (int) r12, (java.lang.Object) r13)
            int r8 = r14.length()
            int r8 = r8 + -1
            if (r6 != r8) goto L_0x00c8
            goto L_0x00cf
        L_0x00c8:
            r12 = r4
            goto L_0x00d1
        L_0x00ca:
            r7 = r9
            r1 = r10
            r3 = r11
            r4 = r12
            r5 = r13
        L_0x00cf:
            r12 = r16
        L_0x00d1:
            java.lang.String r6 = "Wildcard in class name is only allowed at the end."
            if (r12 == 0) goto L_0x0128
            boolean r8 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r15, (java.lang.CharSequence) r3, (boolean) r4, (int) r1, (java.lang.Object) r7)
            if (r8 == 0) goto L_0x00f1
            java.lang.String r9 = "*"
            r10 = 0
            r11 = 0
            r12 = 6
            r13 = 0
            r8 = r15
            int r8 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r8, (java.lang.String) r9, (int) r10, (boolean) r11, (int) r12, (java.lang.Object) r13)
            int r9 = r15.length()
            int r9 = r9 + -1
            if (r8 != r9) goto L_0x00ef
            goto L_0x00f1
        L_0x00ef:
            r12 = r4
            goto L_0x00f3
        L_0x00f1:
            r12 = r16
        L_0x00f3:
            if (r12 == 0) goto L_0x011e
            boolean r1 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r3, (boolean) r4, (int) r1, (java.lang.Object) r7)
            if (r1 == 0) goto L_0x0111
            java.lang.String r9 = "*"
            r10 = 0
            r11 = 0
            r12 = 6
            r13 = 0
            r8 = r5
            int r1 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r8, (java.lang.String) r9, (int) r10, (boolean) r11, (int) r12, (java.lang.Object) r13)
            int r2 = r5.length()
            int r2 = r2 + -1
            if (r1 != r2) goto L_0x010f
            goto L_0x0111
        L_0x010f:
            r16 = r4
        L_0x0111:
            if (r16 == 0) goto L_0x0114
            return
        L_0x0114:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = r6.toString()
            r1.<init>(r2)
            throw r1
        L_0x011e:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0128:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = r6.toString()
            r1.<init>(r2)
            throw r1
        L_0x0132:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x013c:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Activity class name must not be empty."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0148:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Package name must not be empty"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.SplitPairFilter.<init>(android.content.ComponentName, android.content.ComponentName, java.lang.String):void");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairFilter)) {
            return false;
        }
        SplitPairFilter splitPairFilter = (SplitPairFilter) obj;
        if (Intrinsics.areEqual((Object) this.primaryActivityName, (Object) splitPairFilter.primaryActivityName) && Intrinsics.areEqual((Object) this.secondaryActivityName, (Object) splitPairFilter.secondaryActivityName) && Intrinsics.areEqual((Object) this.secondaryActivityIntentAction, (Object) splitPairFilter.secondaryActivityIntentAction)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ComponentName getPrimaryActivityName() {
        return this.primaryActivityName;
    }

    @Nullable
    public final String getSecondaryActivityIntentAction() {
        return this.secondaryActivityIntentAction;
    }

    @NotNull
    public final ComponentName getSecondaryActivityName() {
        return this.secondaryActivityName;
    }

    public int hashCode() {
        int i11;
        int hashCode = ((this.primaryActivityName.hashCode() * 31) + this.secondaryActivityName.hashCode()) * 31;
        String str = this.secondaryActivityIntentAction;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        return hashCode + i11;
    }

    public final boolean matchesActivityIntentPair(@NotNull Activity activity, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "primaryActivity");
        Intrinsics.checkNotNullParameter(intent, "secondaryActivityIntent");
        ComponentName componentName = activity.getComponentName();
        MatcherUtils matcherUtils = MatcherUtils.INSTANCE;
        if (!matcherUtils.areComponentsMatching$window_release(componentName, this.primaryActivityName) || !matcherUtils.areComponentsMatching$window_release(intent.getComponent(), this.secondaryActivityName)) {
            return false;
        }
        String str = this.secondaryActivityIntentAction;
        if (str == null || Intrinsics.areEqual((Object) str, (Object) intent.getAction())) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003e, code lost:
        if (matchesActivityIntentPair(r6, r7) != false) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean matchesActivityPair(@org.jetbrains.annotations.NotNull android.app.Activity r6, @org.jetbrains.annotations.NotNull android.app.Activity r7) {
        /*
            r5 = this;
            java.lang.String r0 = "primaryActivity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "secondaryActivity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            androidx.window.embedding.MatcherUtils r0 = androidx.window.embedding.MatcherUtils.INSTANCE
            android.content.ComponentName r1 = r6.getComponentName()
            android.content.ComponentName r2 = r5.primaryActivityName
            boolean r1 = r0.areComponentsMatching$window_release(r1, r2)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0028
            android.content.ComponentName r1 = r7.getComponentName()
            android.content.ComponentName r4 = r5.secondaryActivityName
            boolean r0 = r0.areComponentsMatching$window_release(r1, r4)
            if (r0 == 0) goto L_0x0028
            r0 = r2
            goto L_0x0029
        L_0x0028:
            r0 = r3
        L_0x0029:
            android.content.Intent r1 = r7.getIntent()
            if (r1 == 0) goto L_0x0043
            if (r0 == 0) goto L_0x0041
            android.content.Intent r7 = r7.getIntent()
            java.lang.String r0 = "secondaryActivity.intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            boolean r6 = r5.matchesActivityIntentPair(r6, r7)
            if (r6 == 0) goto L_0x0041
            goto L_0x0042
        L_0x0041:
            r2 = r3
        L_0x0042:
            r0 = r2
        L_0x0043:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.SplitPairFilter.matchesActivityPair(android.app.Activity, android.app.Activity):boolean");
    }

    @NotNull
    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + this.primaryActivityName + ", secondaryActivityName=" + this.secondaryActivityName + ", secondaryActivityAction=" + this.secondaryActivityIntentAction + AbstractJsonLexerKt.END_OBJ;
    }
}
