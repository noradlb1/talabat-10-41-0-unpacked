package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.RestrictTo;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0016\u0017\u0018B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u0002H\u0016J0\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0013\u0010\u0003\u001a\u00020\u00048\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/navigation/ActivityNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/ActivityNavigator$Destination;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "hostActivity", "Landroid/app/Activity;", "createDestination", "navigate", "Landroidx/navigation/NavDestination;", "destination", "args", "Landroid/os/Bundle;", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "popBackStack", "", "Companion", "Destination", "Extras", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Navigator.Name("activity")
public class ActivityNavigator extends Navigator<Destination> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String EXTRA_NAV_CURRENT = "android-support-navigation:ActivityNavigator:current";
    @NotNull
    private static final String EXTRA_NAV_SOURCE = "android-support-navigation:ActivityNavigator:source";
    @NotNull
    private static final String EXTRA_POP_ENTER_ANIM = "android-support-navigation:ActivityNavigator:popEnterAnim";
    @NotNull
    private static final String EXTRA_POP_EXIT_ANIM = "android-support-navigation:ActivityNavigator:popExitAnim";
    @NotNull
    private static final String LOG_TAG = "ActivityNavigator";
    @NotNull
    private final Context context;
    @Nullable
    private final Activity hostActivity;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/navigation/ActivityNavigator$Companion;", "", "()V", "EXTRA_NAV_CURRENT", "", "EXTRA_NAV_SOURCE", "EXTRA_POP_ENTER_ANIM", "EXTRA_POP_EXIT_ANIM", "LOG_TAG", "applyPopAnimationsToPendingTransition", "", "activity", "Landroid/app/Activity;", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void applyPopAnimationsToPendingTransition(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intent intent = activity.getIntent();
            if (intent != null) {
                int intExtra = intent.getIntExtra(ActivityNavigator.EXTRA_POP_ENTER_ANIM, -1);
                int intExtra2 = intent.getIntExtra(ActivityNavigator.EXTRA_POP_EXIT_ANIM, -1);
                if (intExtra != -1 || intExtra2 != -1) {
                    if (intExtra == -1) {
                        intExtra = 0;
                    }
                    if (intExtra2 == -1) {
                        intExtra2 = 0;
                    }
                    activity.overridePendingTransition(intExtra, intExtra2);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0017J\u0010\u0010)\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010*\u001a\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010\rJ\u0010\u0010,\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0010\u0010-\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\tJ\u0010\u0010.\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0010\u0010/\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010\tJ\b\u00101\u001a\u00020\u001eH\u0017J\b\u00102\u001a\u00020\tH\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\r8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u00118F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\"\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\b\u001a\u0004\u0018\u00010\u0017@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\f¨\u00063"}, d2 = {"Landroidx/navigation/ActivityNavigator$Destination;", "Landroidx/navigation/NavDestination;", "navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "(Landroidx/navigation/NavigatorProvider;)V", "activityNavigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "<set-?>", "", "action", "getAction", "()Ljava/lang/String;", "Landroid/content/ComponentName;", "component", "getComponent", "()Landroid/content/ComponentName;", "Landroid/net/Uri;", "data", "getData", "()Landroid/net/Uri;", "dataPattern", "getDataPattern", "Landroid/content/Intent;", "intent", "getIntent", "()Landroid/content/Intent;", "targetPackage", "getTargetPackage", "equals", "", "other", "", "hashCode", "", "onInflate", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "setAction", "setComponentName", "name", "setData", "setDataPattern", "setIntent", "setTargetPackage", "packageName", "supportsActions", "toString", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @NavDestination.ClassType(Activity.class)
    public static class Destination extends NavDestination {
        @Nullable
        private String action;
        @Nullable
        private ComponentName component;
        @Nullable
        private Uri data;
        @Nullable
        private String dataPattern;
        @Nullable
        private Intent intent;
        @Nullable
        private String targetPackage;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Destination(@NotNull Navigator<? extends Destination> navigator) {
            super((Navigator<? extends NavDestination>) navigator);
            Intrinsics.checkNotNullParameter(navigator, "activityNavigator");
        }

        public boolean equals(@Nullable Object obj) {
            boolean z11;
            if (obj == null || !(obj instanceof Destination) || !super.equals(obj)) {
                return false;
            }
            Intent intent2 = this.intent;
            if (intent2 != null) {
                z11 = intent2.filterEquals(((Destination) obj).intent);
            } else if (((Destination) obj).intent == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 || !Intrinsics.areEqual((Object) this.dataPattern, (Object) ((Destination) obj).dataPattern)) {
                return false;
            }
            return true;
        }

        @Nullable
        public final String getAction() {
            Intent intent2 = this.intent;
            if (intent2 != null) {
                return intent2.getAction();
            }
            return null;
        }

        @Nullable
        public final ComponentName getComponent() {
            Intent intent2 = this.intent;
            if (intent2 != null) {
                return intent2.getComponent();
            }
            return null;
        }

        @Nullable
        public final Uri getData() {
            Intent intent2 = this.intent;
            if (intent2 != null) {
                return intent2.getData();
            }
            return null;
        }

        @Nullable
        public final String getDataPattern() {
            return this.dataPattern;
        }

        @Nullable
        public final Intent getIntent() {
            return this.intent;
        }

        @Nullable
        public final String getTargetPackage() {
            Intent intent2 = this.intent;
            if (intent2 != null) {
                return intent2.getPackage();
            }
            return null;
        }

        public int hashCode() {
            int i11;
            int hashCode = super.hashCode() * 31;
            Intent intent2 = this.intent;
            int i12 = 0;
            if (intent2 != null) {
                i11 = intent2.filterHashCode();
            } else {
                i11 = 0;
            }
            int i13 = (hashCode + i11) * 31;
            String str = this.dataPattern;
            if (str != null) {
                i12 = str.hashCode();
            }
            return i13 + i12;
        }

        @CallSuper
        public void onInflate(@NotNull Context context, @NotNull AttributeSet attributeSet) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.ActivityNavigator);
            Intrinsics.checkNotNullExpressionValue(obtainAttributes, "context.resources.obtain…tyNavigator\n            )");
            String string = obtainAttributes.getString(R.styleable.ActivityNavigator_targetPackage);
            if (string != null) {
                String packageName = context.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
                string = StringsKt__StringsJVMKt.replace$default(string, NavInflater.APPLICATION_ID_PLACEHOLDER, packageName, false, 4, (Object) null);
            }
            setTargetPackage(string);
            String string2 = obtainAttributes.getString(R.styleable.ActivityNavigator_android_name);
            if (string2 != null) {
                if (string2.charAt(0) == '.') {
                    string2 = context.getPackageName() + string2;
                }
                setComponentName(new ComponentName(context, string2));
            }
            setAction(obtainAttributes.getString(R.styleable.ActivityNavigator_action));
            String string3 = obtainAttributes.getString(R.styleable.ActivityNavigator_data);
            if (string3 != null) {
                setData(Uri.parse(string3));
            }
            setDataPattern(obtainAttributes.getString(R.styleable.ActivityNavigator_dataPattern));
            obtainAttributes.recycle();
        }

        @NotNull
        public final Destination setAction(@Nullable String str) {
            if (this.intent == null) {
                this.intent = new Intent();
            }
            Intent intent2 = this.intent;
            Intrinsics.checkNotNull(intent2);
            intent2.setAction(str);
            return this;
        }

        @NotNull
        public final Destination setComponentName(@Nullable ComponentName componentName) {
            if (this.intent == null) {
                this.intent = new Intent();
            }
            Intent intent2 = this.intent;
            Intrinsics.checkNotNull(intent2);
            intent2.setComponent(componentName);
            return this;
        }

        @NotNull
        public final Destination setData(@Nullable Uri uri) {
            if (this.intent == null) {
                this.intent = new Intent();
            }
            Intent intent2 = this.intent;
            Intrinsics.checkNotNull(intent2);
            intent2.setData(uri);
            return this;
        }

        @NotNull
        public final Destination setDataPattern(@Nullable String str) {
            this.dataPattern = str;
            return this;
        }

        @NotNull
        public final Destination setIntent(@Nullable Intent intent2) {
            this.intent = intent2;
            return this;
        }

        @NotNull
        public final Destination setTargetPackage(@Nullable String str) {
            if (this.intent == null) {
                this.intent = new Intent();
            }
            Intent intent2 = this.intent;
            Intrinsics.checkNotNull(intent2);
            intent2.setPackage(str);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public boolean supportsActions() {
            return false;
        }

        @NotNull
        public String toString() {
            ComponentName component2 = getComponent();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(super.toString());
            if (component2 != null) {
                sb2.append(" class=");
                sb2.append(component2.getClassName());
            } else {
                String action2 = getAction();
                if (action2 != null) {
                    sb2.append(" action=");
                    sb2.append(action2);
                }
            }
            String sb3 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "sb.toString()");
            return sb3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Destination(@NotNull NavigatorProvider navigatorProvider) {
            this((Navigator<? extends Destination>) navigatorProvider.getNavigator(ActivityNavigator.class));
            Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Landroidx/navigation/ActivityNavigator$Extras;", "Landroidx/navigation/Navigator$Extras;", "flags", "", "activityOptions", "Landroidx/core/app/ActivityOptionsCompat;", "(ILandroidx/core/app/ActivityOptionsCompat;)V", "getActivityOptions", "()Landroidx/core/app/ActivityOptionsCompat;", "getFlags", "()I", "Builder", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Extras implements Navigator.Extras {
        @Nullable
        private final ActivityOptionsCompat activityOptions;
        private final int flags;

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/navigation/ActivityNavigator$Extras$Builder;", "", "()V", "activityOptions", "Landroidx/core/app/ActivityOptionsCompat;", "flags", "", "addFlags", "build", "Landroidx/navigation/ActivityNavigator$Extras;", "setActivityOptions", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Builder {
            @Nullable
            private ActivityOptionsCompat activityOptions;
            private int flags;

            @NotNull
            public final Builder addFlags(int i11) {
                this.flags = i11 | this.flags;
                return this;
            }

            @NotNull
            public final Extras build() {
                return new Extras(this.flags, this.activityOptions);
            }

            @NotNull
            public final Builder setActivityOptions(@NotNull ActivityOptionsCompat activityOptionsCompat) {
                Intrinsics.checkNotNullParameter(activityOptionsCompat, "activityOptions");
                this.activityOptions = activityOptionsCompat;
                return this;
            }
        }

        public Extras(int i11, @Nullable ActivityOptionsCompat activityOptionsCompat) {
            this.flags = i11;
            this.activityOptions = activityOptionsCompat;
        }

        @Nullable
        public final ActivityOptionsCompat getActivityOptions() {
            return this.activityOptions;
        }

        public final int getFlags() {
            return this.flags;
        }
    }

    public ActivityNavigator(@NotNull Context context2) {
        Object obj;
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        Iterator it = SequencesKt__SequencesKt.generateSequence(context2, ActivityNavigator$hostActivity$1.INSTANCE).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Context) obj) instanceof Activity) {
                break;
            }
        }
        this.hostActivity = (Activity) obj;
    }

    @JvmStatic
    public static final void applyPopAnimationsToPendingTransition(@NotNull Activity activity) {
        Companion.applyPopAnimationsToPendingTransition(activity);
    }

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Context getContext() {
        return this.context;
    }

    public boolean popBackStack() {
        Activity activity = this.hostActivity;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }

    @NotNull
    public Destination createDestination() {
        return new Destination((Navigator<? extends Destination>) this);
    }

    @Nullable
    public NavDestination navigate(@NotNull Destination destination, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        Intent intent;
        int intExtra;
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination.getIntent() != null) {
            Intent intent2 = new Intent(destination.getIntent());
            if (bundle != null) {
                intent2.putExtras(bundle);
                String dataPattern = destination.getDataPattern();
                if (!(dataPattern == null || dataPattern.length() == 0)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(dataPattern);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle.containsKey(group)) {
                            matcher.appendReplacement(stringBuffer, "");
                            stringBuffer.append(Uri.encode(String.valueOf(bundle.get(group))));
                        } else {
                            throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill data pattern " + dataPattern);
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    intent2.setData(Uri.parse(stringBuffer.toString()));
                }
            }
            boolean z11 = extras instanceof Extras;
            if (z11) {
                intent2.addFlags(((Extras) extras).getFlags());
            }
            if (this.hostActivity == null) {
                intent2.addFlags(268435456);
            }
            if (navOptions != null && navOptions.shouldLaunchSingleTop()) {
                intent2.addFlags(536870912);
            }
            Activity activity = this.hostActivity;
            if (!(activity == null || (intent = activity.getIntent()) == null || (intExtra = intent.getIntExtra(EXTRA_NAV_CURRENT, 0)) == 0)) {
                intent2.putExtra(EXTRA_NAV_SOURCE, intExtra);
            }
            intent2.putExtra(EXTRA_NAV_CURRENT, destination.getId());
            Resources resources = this.context.getResources();
            if (navOptions != null) {
                int popEnterAnim = navOptions.getPopEnterAnim();
                int popExitAnim = navOptions.getPopExitAnim();
                if ((popEnterAnim <= 0 || !Intrinsics.areEqual((Object) resources.getResourceTypeName(popEnterAnim), (Object) "animator")) && (popExitAnim <= 0 || !Intrinsics.areEqual((Object) resources.getResourceTypeName(popExitAnim), (Object) "animator"))) {
                    intent2.putExtra(EXTRA_POP_ENTER_ANIM, popEnterAnim);
                    intent2.putExtra(EXTRA_POP_EXIT_ANIM, popExitAnim);
                } else {
                    Log.w(LOG_TAG, "Activity destinations do not support Animator resource. Ignoring popEnter resource " + resources.getResourceName(popEnterAnim) + " and popExit resource " + resources.getResourceName(popExitAnim) + " when launching " + destination);
                }
            }
            if (z11) {
                ActivityOptionsCompat activityOptions = ((Extras) extras).getActivityOptions();
                if (activityOptions != null) {
                    ContextCompat.startActivity(this.context, intent2, activityOptions.toBundle());
                } else {
                    this.context.startActivity(intent2);
                }
            } else {
                this.context.startActivity(intent2);
            }
            if (navOptions == null || this.hostActivity == null) {
                return null;
            }
            int enterAnim = navOptions.getEnterAnim();
            int exitAnim = navOptions.getExitAnim();
            if ((enterAnim > 0 && Intrinsics.areEqual((Object) resources.getResourceTypeName(enterAnim), (Object) "animator")) || (exitAnim > 0 && Intrinsics.areEqual((Object) resources.getResourceTypeName(exitAnim), (Object) "animator"))) {
                Log.w(LOG_TAG, "Activity destinations do not support Animator resource. Ignoring enter resource " + resources.getResourceName(enterAnim) + " and exit resource " + resources.getResourceName(exitAnim) + "when launching " + destination);
                return null;
            } else if (enterAnim < 0 && exitAnim < 0) {
                return null;
            } else {
                this.hostActivity.overridePendingTransition(RangesKt___RangesKt.coerceAtLeast(enterAnim, 0), RangesKt___RangesKt.coerceAtLeast(exitAnim, 0));
                return null;
            }
        } else {
            throw new IllegalStateException(("Destination " + destination.getId() + " does not have an Intent set.").toString());
        }
    }
}
