package com.talabat.talabatcommon.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010\u001cR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/talabat/talabatcommon/views/StartForResultFragment;", "T", "", "Landroidx/fragment/app/Fragment;", "()V", "builder", "Lcom/talabat/talabatcommon/views/StartForResultBuilder;", "getBuilder$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Lcom/talabat/talabatcommon/views/StartForResultBuilder;", "setBuilder$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(Lcom/talabat/talabatcommon/views/StartForResultBuilder;)V", "callbacks", "Lcom/talabat/talabatcommon/views/StartForResultCallbacks;", "getCallbacks$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Lcom/talabat/talabatcommon/views/StartForResultCallbacks;", "setCallbacks$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(Lcom/talabat/talabatcommon/views/StartForResultCallbacks;)V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "removeFragment", "()Ljava/lang/Integer;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StartForResultFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @Nullable
    private StartForResultBuilder<Object> builder;
    @Nullable
    private StartForResultCallbacks<Object> callbacks;

    private final Integer removeFragment() {
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        FragmentActivity activity = getActivity();
        if (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null || (beginTransaction = supportFragmentManager.beginTransaction()) == null || (remove = beginTransaction.remove(this)) == null) {
            return null;
        }
        return Integer.valueOf(remove.commitAllowingStateLoss());
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    @Nullable
    public final StartForResultBuilder<Object> getBuilder$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.builder;
    }

    @Nullable
    public final StartForResultCallbacks<Object> getCallbacks$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.callbacks;
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        Function1<Object, Unit> onSuccess$com_talabat_NewArchi_TalabatCommon_TalabatCommon;
        Object obj;
        Function1<Intent, Object> resultRetriever$com_talabat_NewArchi_TalabatCommon_TalabatCommon;
        Function0<Unit> onCancelled$com_talabat_NewArchi_TalabatCommon_TalabatCommon;
        super.onActivityResult(i11, i12, intent);
        StartForResultCallbacks<Object> startForResultCallbacks = this.callbacks;
        if (startForResultCallbacks != null && this.builder != null && i11 == 100) {
            if (i12 == 0) {
                if (!(startForResultCallbacks == null || (onCancelled$com_talabat_NewArchi_TalabatCommon_TalabatCommon = startForResultCallbacks.getOnCancelled$com_talabat_NewArchi_TalabatCommon_TalabatCommon()) == null)) {
                    onCancelled$com_talabat_NewArchi_TalabatCommon_TalabatCommon.invoke();
                }
            } else if (!(startForResultCallbacks == null || (onSuccess$com_talabat_NewArchi_TalabatCommon_TalabatCommon = startForResultCallbacks.getOnSuccess$com_talabat_NewArchi_TalabatCommon_TalabatCommon()) == null)) {
                StartForResultBuilder<Object> startForResultBuilder = this.builder;
                if (startForResultBuilder == null || (resultRetriever$com_talabat_NewArchi_TalabatCommon_TalabatCommon = startForResultBuilder.getResultRetriever$com_talabat_NewArchi_TalabatCommon_TalabatCommon()) == null) {
                    obj = null;
                } else {
                    obj = resultRetriever$com_talabat_NewArchi_TalabatCommon_TalabatCommon.invoke(intent);
                }
                onSuccess$com_talabat_NewArchi_TalabatCommon_TalabatCommon.invoke(obj);
            }
            removeFragment();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        Function0<Unit> onCancelled$com_talabat_NewArchi_TalabatCommon_TalabatCommon;
        Function0<Unit> onStart$com_talabat_NewArchi_TalabatCommon_TalabatCommon;
        TraceMachine.startTracing("StartForResultFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "StartForResultFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "StartForResultFragment#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        StartForResultCallbacks<Object> startForResultCallbacks = this.callbacks;
        if (!(startForResultCallbacks == null || (onStart$com_talabat_NewArchi_TalabatCommon_TalabatCommon = startForResultCallbacks.getOnStart$com_talabat_NewArchi_TalabatCommon_TalabatCommon()) == null)) {
            onStart$com_talabat_NewArchi_TalabatCommon_TalabatCommon.invoke();
        }
        StartForResultBuilder<Object> startForResultBuilder = this.builder;
        if (startForResultBuilder != null) {
            startActivityForResult(startForResultBuilder.getStartingIntent$com_talabat_NewArchi_TalabatCommon_TalabatCommon().invoke(), 100);
        } else {
            StartForResultCallbacks<Object> startForResultCallbacks2 = this.callbacks;
            if (!(startForResultCallbacks2 == null || (onCancelled$com_talabat_NewArchi_TalabatCommon_TalabatCommon = startForResultCallbacks2.getOnCancelled$com_talabat_NewArchi_TalabatCommon_TalabatCommon()) == null)) {
                onCancelled$com_talabat_NewArchi_TalabatCommon_TalabatCommon.invoke();
            }
        }
        TraceMachine.exitMethod();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public final void setBuilder$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@Nullable StartForResultBuilder<Object> startForResultBuilder) {
        this.builder = startForResultBuilder;
    }

    public final void setCallbacks$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@Nullable StartForResultCallbacks<Object> startForResultCallbacks) {
        this.callbacks = startForResultCallbacks;
    }
}
