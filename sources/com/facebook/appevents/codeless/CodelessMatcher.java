package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.UiThread;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessLoggingEventListener;
import com.facebook.appevents.codeless.RCTCodelessLoggingEventListener;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ParameterComponent;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o6.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0001\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0007J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0007J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0007J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R@\u0010\u0006\u001a4\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007j\u001e\u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\f`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher;", "", "()V", "activitiesSet", "", "Landroid/app/Activity;", "activityToListenerMap", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashMap;", "Lkotlin/collections/HashSet;", "listenerSet", "uiThreadHandler", "Landroid/os/Handler;", "viewMatchers", "Lcom/facebook/appevents/codeless/CodelessMatcher$ViewMatcher;", "add", "", "activity", "destroy", "matchViews", "remove", "startTracking", "Companion", "MatchedView", "ViewMatcher", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class CodelessMatcher {
    @NotNull
    private static final String CURRENT_CLASS_NAME = ".";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String PARENT_CLASS_NAME = "..";
    /* access modifiers changed from: private */
    public static final String TAG = CodelessMatcher.class.getCanonicalName();
    /* access modifiers changed from: private */
    @Nullable
    public static CodelessMatcher codelessMatcher;
    @NotNull
    private final Set<Activity> activitiesSet;
    @NotNull
    private final HashMap<Integer, HashSet<String>> activityToListenerMap;
    @NotNull
    private HashSet<String> listenerSet;
    @NotNull
    private final Handler uiThreadHandler;
    @NotNull
    private final Set<ViewMatcher> viewMatchers;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\tH\u0007J\"\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher$Companion;", "", "()V", "CURRENT_CLASS_NAME", "", "PARENT_CLASS_NAME", "TAG", "kotlin.jvm.PlatformType", "codelessMatcher", "Lcom/facebook/appevents/codeless/CodelessMatcher;", "getInstance", "getParameters", "Landroid/os/Bundle;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "rootView", "Landroid/view/View;", "hostView", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final synchronized CodelessMatcher getInstance() {
            CodelessMatcher access$getCodelessMatcher$cp;
            if (CodelessMatcher.codelessMatcher == null) {
                CodelessMatcher.codelessMatcher = new CodelessMatcher((DefaultConstructorMarker) null);
            }
            access$getCodelessMatcher$cp = CodelessMatcher.codelessMatcher;
            if (access$getCodelessMatcher$cp == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessMatcher");
            }
            return access$getCodelessMatcher$cp;
        }

        @JvmStatic
        @NotNull
        @UiThread
        public final Bundle getParameters(@Nullable EventBinding eventBinding, @NotNull View view, @NotNull View view2) {
            List<ParameterComponent> viewParameters;
            List<MatchedView> list;
            boolean z11;
            boolean z12;
            Intrinsics.checkNotNullParameter(view, "rootView");
            Intrinsics.checkNotNullParameter(view2, "hostView");
            Bundle bundle = new Bundle();
            if (!(eventBinding == null || (viewParameters = eventBinding.getViewParameters()) == null)) {
                for (ParameterComponent next : viewParameters) {
                    if (next.getValue() != null) {
                        if (next.getValue().length() > 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            bundle.putString(next.getName(), next.getValue());
                        }
                    }
                    if (next.getPath().size() > 0) {
                        if (Intrinsics.areEqual((Object) next.getPathType(), (Object) Constants.PATH_TYPE_RELATIVE)) {
                            ViewMatcher.Companion companion = ViewMatcher.Companion;
                            List<PathComponent> path = next.getPath();
                            String simpleName = view2.getClass().getSimpleName();
                            Intrinsics.checkNotNullExpressionValue(simpleName, "hostView.javaClass.simpleName");
                            list = companion.findViewByPath(eventBinding, view2, path, 0, -1, simpleName);
                        } else {
                            ViewMatcher.Companion companion2 = ViewMatcher.Companion;
                            List<PathComponent> path2 = next.getPath();
                            String simpleName2 = view.getClass().getSimpleName();
                            Intrinsics.checkNotNullExpressionValue(simpleName2, "rootView.javaClass.simpleName");
                            list = companion2.findViewByPath(eventBinding, view, path2, 0, -1, simpleName2);
                        }
                        Iterator<MatchedView> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            MatchedView next2 = it.next();
                            if (next2.getView() != null) {
                                ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                                String textOfView = ViewHierarchy.getTextOfView(next2.getView());
                                if (textOfView.length() > 0) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (z11) {
                                    bundle.putString(next.getName(), textOfView);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return bundle;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\u0003R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher$MatchedView;", "", "view", "Landroid/view/View;", "viewMapKey", "", "(Landroid/view/View;Ljava/lang/String;)V", "Ljava/lang/ref/WeakReference;", "getViewMapKey", "()Ljava/lang/String;", "getView", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class MatchedView {
        @Nullable
        private final WeakReference<View> view;
        @NotNull
        private final String viewMapKey;

        public MatchedView(@NotNull View view2, @NotNull String str) {
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(str, "viewMapKey");
            this.view = new WeakReference<>(view2);
            this.viewMapKey = str;
        }

        @Nullable
        public final View getView() {
            WeakReference<View> weakReference = this.view;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }

        @NotNull
        public final String getViewMapKey() {
            return this.viewMapKey;
        }
    }

    @UiThread
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001fB7\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0002J \u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J \u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J \u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u001c\u0010\u001a\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0002R\u000e\u0010\f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher$ViewMatcher;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "Ljava/lang/Runnable;", "rootView", "Landroid/view/View;", "handler", "Landroid/os/Handler;", "listenerSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "activityName", "(Landroid/view/View;Landroid/os/Handler;Ljava/util/HashSet;Ljava/lang/String;)V", "eventBindings", "", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "Ljava/lang/ref/WeakReference;", "attachListener", "", "matchedView", "Lcom/facebook/appevents/codeless/CodelessMatcher$MatchedView;", "mapping", "attachOnClickListener", "attachOnItemClickListener", "attachRCTListener", "findView", "onGlobalLayout", "onScrollChanged", "run", "startMatch", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ViewMatcher implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @NotNull
        private final String activityName;
        @Nullable
        private List<EventBinding> eventBindings;
        @NotNull
        private final Handler handler;
        @NotNull
        private final HashSet<String> listenerSet;
        @NotNull
        private final WeakReference<View> rootView;

        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JH\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¨\u0006\u0018"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher$ViewMatcher$Companion;", "", "()V", "findViewByPath", "", "Lcom/facebook/appevents/codeless/CodelessMatcher$MatchedView;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "view", "Landroid/view/View;", "path", "Lcom/facebook/appevents/codeless/internal/PathComponent;", "level", "", "index", "mapKey", "", "findVisibleChildren", "viewGroup", "Landroid/view/ViewGroup;", "isTheSameView", "", "targetView", "pathElement", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final List<View> findVisibleChildren(ViewGroup viewGroup) {
                ArrayList arrayList = new ArrayList();
                int childCount = viewGroup.getChildCount();
                if (childCount > 0) {
                    int i11 = 0;
                    while (true) {
                        int i12 = i11 + 1;
                        View childAt = viewGroup.getChildAt(i11);
                        if (childAt.getVisibility() == 0) {
                            Intrinsics.checkNotNullExpressionValue(childAt, "child");
                            arrayList.add(childAt);
                        }
                        if (i12 >= childCount) {
                            break;
                        }
                        i11 = i12;
                    }
                }
                return arrayList;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0066, code lost:
                if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10.getClass().getSimpleName(), (java.lang.Object) (java.lang.String) r12.get(r12.size() - 1)) == false) goto L_0x0068;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private final boolean isTheSameView(android.view.View r10, com.facebook.appevents.codeless.internal.PathComponent r11, int r12) {
                /*
                    r9 = this;
                    int r0 = r11.getIndex()
                    r1 = -1
                    r2 = 0
                    if (r0 == r1) goto L_0x000f
                    int r0 = r11.getIndex()
                    if (r12 == r0) goto L_0x000f
                    return r2
                L_0x000f:
                    java.lang.Class r12 = r10.getClass()
                    java.lang.String r12 = r12.getCanonicalName()
                    java.lang.String r0 = r11.getClassName()
                    boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r0)
                    r0 = 1
                    if (r12 != 0) goto L_0x0069
                    java.lang.String r12 = r11.getClassName()
                    kotlin.text.Regex r1 = new kotlin.text.Regex
                    java.lang.String r3 = ".*android\\..*"
                    r1.<init>((java.lang.String) r3)
                    boolean r12 = r1.matches(r12)
                    if (r12 == 0) goto L_0x0068
                    java.lang.String r3 = r11.getClassName()
                    java.lang.String r12 = "."
                    java.lang.String[] r4 = new java.lang.String[]{r12}
                    r5 = 0
                    r6 = 0
                    r7 = 6
                    r8 = 0
                    java.util.List r12 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r3, (java.lang.String[]) r4, (boolean) r5, (int) r6, (int) r7, (java.lang.Object) r8)
                    r1 = r12
                    java.util.Collection r1 = (java.util.Collection) r1
                    boolean r1 = r1.isEmpty()
                    r1 = r1 ^ r0
                    if (r1 == 0) goto L_0x0068
                    int r1 = r12.size()
                    int r1 = r1 - r0
                    java.lang.Object r12 = r12.get(r1)
                    java.lang.String r12 = (java.lang.String) r12
                    java.lang.Class r1 = r10.getClass()
                    java.lang.String r1 = r1.getSimpleName()
                    boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r12)
                    if (r12 != 0) goto L_0x0069
                L_0x0068:
                    return r2
                L_0x0069:
                    int r12 = r11.getMatchBitmask()
                    com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r1 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.ID
                    int r1 = r1.getValue()
                    r12 = r12 & r1
                    if (r12 <= 0) goto L_0x0081
                    int r12 = r11.getId()
                    int r1 = r10.getId()
                    if (r12 == r1) goto L_0x0081
                    return r2
                L_0x0081:
                    int r12 = r11.getMatchBitmask()
                    com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r1 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.TEXT
                    int r1 = r1.getValue()
                    r12 = r12 & r1
                    java.lang.String r1 = ""
                    if (r12 <= 0) goto L_0x00ad
                    java.lang.String r12 = r11.getText()
                    java.lang.String r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.getTextOfView(r10)
                    java.lang.String r4 = com.facebook.internal.Utility.sha256hash((java.lang.String) r3)
                    java.lang.String r4 = com.facebook.internal.Utility.coerceValueIfNullOrEmpty(r4, r1)
                    boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r3)
                    if (r3 != 0) goto L_0x00ad
                    boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r4)
                    if (r12 != 0) goto L_0x00ad
                    return r2
                L_0x00ad:
                    int r12 = r11.getMatchBitmask()
                    com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r3 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.DESCRIPTION
                    int r3 = r3.getValue()
                    r12 = r12 & r3
                    if (r12 <= 0) goto L_0x00e3
                    java.lang.String r12 = r11.getDescription()
                    java.lang.CharSequence r3 = r10.getContentDescription()
                    if (r3 != 0) goto L_0x00c6
                    r3 = r1
                    goto L_0x00ce
                L_0x00c6:
                    java.lang.CharSequence r3 = r10.getContentDescription()
                    java.lang.String r3 = r3.toString()
                L_0x00ce:
                    java.lang.String r4 = com.facebook.internal.Utility.sha256hash((java.lang.String) r3)
                    java.lang.String r4 = com.facebook.internal.Utility.coerceValueIfNullOrEmpty(r4, r1)
                    boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r3)
                    if (r3 != 0) goto L_0x00e3
                    boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r4)
                    if (r12 != 0) goto L_0x00e3
                    return r2
                L_0x00e3:
                    int r12 = r11.getMatchBitmask()
                    com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r3 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.HINT
                    int r3 = r3.getValue()
                    r12 = r12 & r3
                    if (r12 <= 0) goto L_0x010d
                    java.lang.String r12 = r11.getHint()
                    java.lang.String r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.getHintOfView(r10)
                    java.lang.String r4 = com.facebook.internal.Utility.sha256hash((java.lang.String) r3)
                    java.lang.String r4 = com.facebook.internal.Utility.coerceValueIfNullOrEmpty(r4, r1)
                    boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r3)
                    if (r3 != 0) goto L_0x010d
                    boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r4)
                    if (r12 != 0) goto L_0x010d
                    return r2
                L_0x010d:
                    int r12 = r11.getMatchBitmask()
                    com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r3 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.TAG
                    int r3 = r3.getValue()
                    r12 = r12 & r3
                    if (r12 <= 0) goto L_0x0143
                    java.lang.String r11 = r11.getTag()
                    java.lang.Object r12 = r10.getTag()
                    if (r12 != 0) goto L_0x0126
                    r10 = r1
                    goto L_0x012e
                L_0x0126:
                    java.lang.Object r10 = r10.getTag()
                    java.lang.String r10 = r10.toString()
                L_0x012e:
                    java.lang.String r12 = com.facebook.internal.Utility.sha256hash((java.lang.String) r10)
                    java.lang.String r12 = com.facebook.internal.Utility.coerceValueIfNullOrEmpty(r12, r1)
                    boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r10)
                    if (r10 != 0) goto L_0x0143
                    boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
                    if (r10 != 0) goto L_0x0143
                    return r2
                L_0x0143:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.Companion.isTheSameView(android.view.View, com.facebook.appevents.codeless.internal.PathComponent, int):boolean");
            }

            @JvmStatic
            @NotNull
            public final List<MatchedView> findViewByPath(@Nullable EventBinding eventBinding, @Nullable View view, @NotNull List<PathComponent> list, int i11, int i12, @NotNull String str) {
                List<View> findVisibleChildren;
                int size;
                List<View> findVisibleChildren2;
                int size2;
                Intrinsics.checkNotNullParameter(list, "path");
                Intrinsics.checkNotNullParameter(str, "mapKey");
                String str2 = str + '.' + i12;
                ArrayList arrayList = new ArrayList();
                if (view == null) {
                    return arrayList;
                }
                if (i11 >= list.size()) {
                    arrayList.add(new MatchedView(view, str2));
                } else {
                    PathComponent pathComponent = list.get(i11);
                    if (Intrinsics.areEqual((Object) pathComponent.getClassName(), (Object) CodelessMatcher.PARENT_CLASS_NAME)) {
                        ViewParent parent = view.getParent();
                        if ((parent instanceof ViewGroup) && (size2 = findVisibleChildren2.size()) > 0) {
                            int i13 = 0;
                            while (true) {
                                int i14 = i13 + 1;
                                arrayList.addAll(findViewByPath(eventBinding, (findVisibleChildren2 = findVisibleChildren((ViewGroup) parent)).get(i13), list, i11 + 1, i13, str2));
                                if (i14 >= size2) {
                                    break;
                                }
                                i13 = i14;
                            }
                        }
                        return arrayList;
                    } else if (Intrinsics.areEqual((Object) pathComponent.getClassName(), (Object) ".")) {
                        arrayList.add(new MatchedView(view, str2));
                        return arrayList;
                    } else if (!isTheSameView(view, pathComponent, i12)) {
                        return arrayList;
                    } else {
                        if (i11 == list.size() - 1) {
                            arrayList.add(new MatchedView(view, str2));
                        }
                    }
                }
                if ((view instanceof ViewGroup) && (size = findVisibleChildren.size()) > 0) {
                    int i15 = 0;
                    while (true) {
                        int i16 = i15 + 1;
                        arrayList.addAll(findViewByPath(eventBinding, (findVisibleChildren = findVisibleChildren((ViewGroup) view)).get(i15), list, i11 + 1, i15, str2));
                        if (i16 >= size) {
                            break;
                        }
                        i15 = i16;
                    }
                }
                return arrayList;
            }
        }

        public ViewMatcher(@Nullable View view, @NotNull Handler handler2, @NotNull HashSet<String> hashSet, @NotNull String str) {
            Intrinsics.checkNotNullParameter(handler2, "handler");
            Intrinsics.checkNotNullParameter(hashSet, "listenerSet");
            Intrinsics.checkNotNullParameter(str, "activityName");
            this.rootView = new WeakReference<>(view);
            this.handler = handler2;
            this.listenerSet = hashSet;
            this.activityName = str;
            handler2.postDelayed(this, 200);
        }

        private final void attachListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            if (eventBinding != null) {
                try {
                    View view2 = matchedView.getView();
                    if (view2 != null) {
                        View findRCTRootView = ViewHierarchy.findRCTRootView(view2);
                        if (findRCTRootView == null || !ViewHierarchy.INSTANCE.isRCTButton(view2, findRCTRootView)) {
                            String name2 = view2.getClass().getName();
                            Intrinsics.checkNotNullExpressionValue(name2, "view.javaClass.name");
                            if (!StringsKt__StringsJVMKt.startsWith$default(name2, "com.facebook.react", false, 2, (Object) null)) {
                                if (!(view2 instanceof AdapterView)) {
                                    attachOnClickListener(matchedView, view, eventBinding);
                                } else if (view2 instanceof ListView) {
                                    attachOnItemClickListener(matchedView, view, eventBinding);
                                }
                            }
                        } else {
                            attachRCTListener(matchedView, view, eventBinding);
                        }
                    }
                } catch (Exception e11) {
                    Utility utility = Utility.INSTANCE;
                    Utility.logd(CodelessMatcher.TAG, e11);
                }
            }
        }

        private final void attachOnClickListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            boolean z11;
            View view2 = matchedView.getView();
            if (view2 != null) {
                String viewMapKey = matchedView.getViewMapKey();
                View.OnClickListener existingOnClickListener = ViewHierarchy.getExistingOnClickListener(view2);
                if (existingOnClickListener instanceof CodelessLoggingEventListener.AutoLoggingOnClickListener) {
                    if (existingOnClickListener == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnClickListener");
                    } else if (((CodelessLoggingEventListener.AutoLoggingOnClickListener) existingOnClickListener).getSupportCodelessLogging()) {
                        z11 = true;
                        if (!this.listenerSet.contains(viewMapKey) && !z11) {
                            view2.setOnClickListener(CodelessLoggingEventListener.getOnClickListener(eventBinding, view, view2));
                            this.listenerSet.add(viewMapKey);
                            return;
                        }
                    }
                }
                z11 = false;
                if (!this.listenerSet.contains(viewMapKey)) {
                }
            }
        }

        private final void attachOnItemClickListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            boolean z11;
            AdapterView adapterView = (AdapterView) matchedView.getView();
            if (adapterView != null) {
                String viewMapKey = matchedView.getViewMapKey();
                AdapterView.OnItemClickListener onItemClickListener = adapterView.getOnItemClickListener();
                if (onItemClickListener instanceof CodelessLoggingEventListener.AutoLoggingOnItemClickListener) {
                    if (onItemClickListener == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnItemClickListener");
                    } else if (((CodelessLoggingEventListener.AutoLoggingOnItemClickListener) onItemClickListener).getSupportCodelessLogging()) {
                        z11 = true;
                        if (!this.listenerSet.contains(viewMapKey) && !z11) {
                            adapterView.setOnItemClickListener(CodelessLoggingEventListener.getOnItemClickListener(eventBinding, view, adapterView));
                            this.listenerSet.add(viewMapKey);
                            return;
                        }
                    }
                }
                z11 = false;
                if (!this.listenerSet.contains(viewMapKey)) {
                }
            }
        }

        private final void attachRCTListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            boolean z11;
            View view2 = matchedView.getView();
            if (view2 != null) {
                String viewMapKey = matchedView.getViewMapKey();
                View.OnTouchListener existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(view2);
                if (existingOnTouchListener instanceof RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener) {
                    if (existingOnTouchListener == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener");
                    } else if (((RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener) existingOnTouchListener).getSupportCodelessLogging()) {
                        z11 = true;
                        if (!this.listenerSet.contains(viewMapKey) && !z11) {
                            view2.setOnTouchListener(RCTCodelessLoggingEventListener.getOnTouchListener(eventBinding, view, view2));
                            this.listenerSet.add(viewMapKey);
                            return;
                        }
                    }
                }
                z11 = false;
                if (!this.listenerSet.contains(viewMapKey)) {
                }
            }
        }

        private final void findView(EventBinding eventBinding, View view) {
            boolean z11;
            if (eventBinding != null && view != null) {
                String activityName2 = eventBinding.getActivityName();
                if (activityName2 == null || activityName2.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 || Intrinsics.areEqual((Object) eventBinding.getActivityName(), (Object) this.activityName)) {
                    List<PathComponent> viewPath = eventBinding.getViewPath();
                    if (viewPath.size() <= 25) {
                        for (MatchedView attachListener : Companion.findViewByPath(eventBinding, view, viewPath, 0, -1, this.activityName)) {
                            attachListener(attachListener, view, eventBinding);
                        }
                    }
                }
            }
        }

        @JvmStatic
        @NotNull
        public static final List<MatchedView> findViewByPath(@Nullable EventBinding eventBinding, @Nullable View view, @NotNull List<PathComponent> list, int i11, int i12, @NotNull String str) {
            return Companion.findViewByPath(eventBinding, view, list, i11, i12, str);
        }

        private final void startMatch() {
            int size;
            List<EventBinding> list = this.eventBindings;
            if (list != null && this.rootView.get() != null && list.size() - 1 >= 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    findView(list.get(i11), this.rootView.get());
                    if (i12 <= size) {
                        i11 = i12;
                    } else {
                        return;
                    }
                }
            }
        }

        public void onGlobalLayout() {
            startMatch();
        }

        public void onScrollChanged() {
            startMatch();
        }

        public void run() {
            View view;
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                List<EventBinding> parseArray = EventBinding.Companion.parseArray(appSettingsWithoutQuery.getEventBindings());
                this.eventBindings = parseArray;
                if (parseArray != null && (view = this.rootView.get()) != null) {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.addOnGlobalLayoutListener(this);
                        viewTreeObserver.addOnScrollChangedListener(this);
                    }
                    startMatch();
                }
            }
        }
    }

    private CodelessMatcher() {
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        Set<Activity> newSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        Intrinsics.checkNotNullExpressionValue(newSetFromMap, "newSetFromMap(WeakHashMap())");
        this.activitiesSet = newSetFromMap;
        this.viewMatchers = new LinkedHashSet();
        this.listenerSet = new HashSet<>();
        this.activityToListenerMap = new HashMap<>();
    }

    public /* synthetic */ CodelessMatcher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final synchronized CodelessMatcher getInstance() {
        CodelessMatcher instance;
        synchronized (CodelessMatcher.class) {
            instance = Companion.getInstance();
        }
        return instance;
    }

    @JvmStatic
    @NotNull
    @UiThread
    public static final Bundle getParameters(@Nullable EventBinding eventBinding, @NotNull View view, @NotNull View view2) {
        return Companion.getParameters(eventBinding, view, view2);
    }

    private final void matchViews() {
        for (Activity next : this.activitiesSet) {
            if (next != null) {
                View rootView = AppEventUtility.getRootView(next);
                String simpleName = next.getClass().getSimpleName();
                Handler handler = this.uiThreadHandler;
                HashSet<String> hashSet = this.listenerSet;
                Intrinsics.checkNotNullExpressionValue(simpleName, "activityName");
                this.viewMatchers.add(new ViewMatcher(rootView, handler, hashSet, simpleName));
            }
        }
    }

    private final void startTracking() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            matchViews();
        } else {
            this.uiThreadHandler.post(new d(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startTracking$lambda-1  reason: not valid java name */
    public static final void m8907startTracking$lambda1(CodelessMatcher codelessMatcher2) {
        Intrinsics.checkNotNullParameter(codelessMatcher2, "this$0");
        codelessMatcher2.matchViews();
    }

    @UiThread
    public final void add(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!InternalSettings.isUnityApp()) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                this.activitiesSet.add(activity);
                this.listenerSet.clear();
                HashSet<String> hashSet = this.activityToListenerMap.get(Integer.valueOf(activity.hashCode()));
                if (hashSet != null) {
                    this.listenerSet = hashSet;
                }
                startTracking();
                return;
            }
            throw new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
        }
    }

    @UiThread
    public final void destroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityToListenerMap.remove(Integer.valueOf(activity.hashCode()));
    }

    @UiThread
    public final void remove(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!InternalSettings.isUnityApp()) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                this.activitiesSet.remove(activity);
                this.viewMatchers.clear();
                this.activityToListenerMap.put(Integer.valueOf(activity.hashCode()), (HashSet) this.listenerSet.clone());
                this.listenerSet.clear();
                return;
            }
            throw new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
        }
    }
}
