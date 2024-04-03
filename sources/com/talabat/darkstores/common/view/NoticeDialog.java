package com.talabat.darkstores.common.view;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import ci.q;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.darkstores.R;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000f"}, d2 = {"Lcom/talabat/darkstores/common/view/NoticeDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onViewCreated", "view", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NoticeDialog extends DialogFragment implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m9657onViewCreated$lambda2(NoticeDialog noticeDialog, View view) {
        Intrinsics.checkNotNullParameter(noticeDialog, "this$0");
        noticeDialog.dismiss();
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
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Window window;
        try {
            TraceMachine.enterMethod(this._nr_trace, "NoticeDialog#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "NoticeDialog#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.dialog_untappable_banner, viewGroup, false);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        TraceMachine.exitMethod();
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        Window window;
        WindowManager.LayoutParams attributes;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null && (attributes = window.getAttributes()) != null) {
            Intrinsics.checkNotNullExpressionValue(attributes, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
            attributes.dimAmount = 0.1f;
            window.setAttributes(attributes);
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ((TextView) _$_findCachedViewById(R.id.continue_btn)).setOnClickListener(new q(this));
        TextView textView = (TextView) _$_findCachedViewById(R.id.d_title);
        Bundle arguments = getArguments();
        String str2 = null;
        if (arguments != null) {
            str = arguments.getString("title");
        } else {
            str = null;
        }
        textView.setText(str);
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.d_body);
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str2 = arguments2.getString("description");
        }
        textView2.setText(str2);
    }
}
