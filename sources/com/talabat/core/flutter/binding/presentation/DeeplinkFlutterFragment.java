package com.talabat.core.flutter.binding.presentation;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.talabat.core.flutter.binding.domain.ActivityEngineBinding;
import com.talabat.core.flutter.binding.domain.DeeplinkEngineBindingRegistry;
import com.talabat.core.flutter.binding.domain.EngineBinding;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\u0013¨\u0006$"}, d2 = {"Lcom/talabat/core/flutter/binding/presentation/DeeplinkFlutterFragment;", "Lio/flutter/embedding/android/FlutterFragment;", "Lio/flutter/embedding/engine/FlutterEngine$EngineLifecycleListener;", "()V", "deeplinkEngineBindingRegistry", "Lcom/talabat/core/flutter/binding/domain/DeeplinkEngineBindingRegistry;", "getDeeplinkEngineBindingRegistry", "()Lcom/talabat/core/flutter/binding/domain/DeeplinkEngineBindingRegistry;", "deeplinkEngineBindingRegistry$delegate", "Lkotlin/Lazy;", "featuresBindingRegistry", "", "Lcom/talabat/core/flutter/binding/domain/EngineBinding;", "getFeaturesBindingRegistry", "()Ljava/util/Set;", "featuresBindingRegistry$delegate", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "observabilityManager$delegate", "observeFlutterBehaviour", "", "explanation", "", "onAttach", "context", "Landroid/content/Context;", "onDestroy", "onEngineWillDestroy", "onPreEngineRestart", "provideFlutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "shouldAttachEngineToActivity", "", "Companion", "com_talabat_core_flutter-binding_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeeplinkFlutterFragment extends FlutterFragment implements FlutterEngine.EngineLifecycleListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Lazy deeplinkEngineBindingRegistry$delegate;
    @NotNull
    private final Lazy featuresBindingRegistry$delegate;
    @NotNull
    private final Lazy observabilityManager$delegate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/flutter/binding/presentation/DeeplinkFlutterFragment$Companion;", "", "()V", "newInstance", "Lcom/talabat/core/flutter/binding/presentation/DeeplinkFlutterFragment;", "deeplink", "", "com_talabat_core_flutter-binding_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DeeplinkFlutterFragment newInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "deeplink");
            DeeplinkFlutterFragment deeplinkFlutterFragment = new DeeplinkFlutterFragment();
            Bundle bundle = new Bundle();
            bundle.putString("deeplink", str);
            deeplinkFlutterFragment.setArguments(bundle);
            return deeplinkFlutterFragment;
        }
    }

    public DeeplinkFlutterFragment() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.deeplinkEngineBindingRegistry$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new DeeplinkFlutterFragment$deeplinkEngineBindingRegistry$2(this));
        this.featuresBindingRegistry$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new DeeplinkFlutterFragment$featuresBindingRegistry$2(this));
        this.observabilityManager$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new DeeplinkFlutterFragment$observabilityManager$2(this));
    }

    private final DeeplinkEngineBindingRegistry getDeeplinkEngineBindingRegistry() {
        return (DeeplinkEngineBindingRegistry) this.deeplinkEngineBindingRegistry$delegate.getValue();
    }

    private final Set<EngineBinding> getFeaturesBindingRegistry() {
        return (Set) this.featuresBindingRegistry$delegate.getValue();
    }

    private final IObservabilityManager getObservabilityManager() {
        return (IObservabilityManager) this.observabilityManager$delegate.getValue();
    }

    private final void observeFlutterBehaviour(String str) {
        String str2;
        String localClassName;
        IObservabilityManager observabilityManager = getObservabilityManager();
        Pair[] pairArr = new Pair[4];
        Bundle arguments = getArguments();
        String str3 = "N/A";
        if (arguments == null || (str2 = arguments.getString("deeplink")) == null) {
            str2 = str3;
        }
        pairArr[0] = TuplesKt.to("deeplink", str2);
        FragmentActivity activity = getActivity();
        if (!(activity == null || (localClassName = activity.getLocalClassName()) == null)) {
            str3 = localClassName;
        }
        pairArr[1] = TuplesKt.to("activity_name", str3);
        pairArr[2] = TuplesKt.to("instance_id", String.valueOf(System.identityHashCode(this)));
        pairArr[3] = TuplesKt.to("engine_id", String.valueOf(System.identityHashCode(getFlutterEngine())));
        observabilityManager.trackUnExpectedScenario(str, MapsKt__MapsKt.mapOf(pairArr));
    }

    public void onAttach(@NotNull Context context) {
        boolean z11;
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle arguments = getArguments();
        if (arguments != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            arguments = null;
        }
        if (arguments == null) {
            arguments = new Bundle();
        }
        setArguments(arguments);
        super.onAttach(context);
    }

    public void onDestroy() {
        PlatformViewsController platformViewsController;
        observeFlutterBehaviour("deeplink_flutter_fragment_destroyed");
        FlutterEngine flutterEngine = getFlutterEngine();
        if (!(flutterEngine == null || (platformViewsController = flutterEngine.getPlatformViewsController()) == null)) {
            platformViewsController.onDetachedFromJNI();
        }
        super.onDestroy();
        getDeeplinkEngineBindingRegistry().destroy(true);
    }

    public void onEngineWillDestroy() {
        observeFlutterBehaviour("deeplink_flutter_fragment_engine_will_destroy");
    }

    public void onPreEngineRestart() {
        observeFlutterBehaviour("deeplink_flutter_fragment_engine_restart");
    }

    @Nullable
    public FlutterEngine provideFlutterEngine(@NotNull Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle arguments = getArguments();
        String str2 = null;
        if (arguments != null) {
            str = arguments.getString("deeplink");
        } else {
            str = null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str2 = arguments2.getString("verticals");
        }
        Log.i("DeeplinkFlutterFragment", " provideFlutterEngine deeplink=" + str + " and verticals=" + str2);
        DeeplinkEngineBindingRegistry deeplinkEngineBindingRegistry = getDeeplinkEngineBindingRegistry();
        if (str == null) {
            str = "";
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        FlutterEngine init = deeplinkEngineBindingRegistry.init(str, requireActivity, getArguments());
        init.addEngineLifecycleListener(this);
        for (EngineBinding engineBinding : getFeaturesBindingRegistry()) {
            if (engineBinding instanceof ActivityEngineBinding) {
                FragmentActivity requireActivity2 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                ((ActivityEngineBinding) engineBinding).init(init, requireActivity2, getArguments());
            } else {
                engineBinding.init(init);
            }
        }
        return init;
    }

    public boolean shouldAttachEngineToActivity() {
        return true;
    }
}
