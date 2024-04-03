package com.talabat.gem.samples;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.data.ServerKt;
import com.talabat.talabatcommon.extension.ViewKt;
import gateways.DataSourcesDelegateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0003*\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007²\u0006\f\u0010\b\u001a\u0004\u0018\u00010\tX\u0002"}, d2 = {"SLEEP_TILL_APP_START_MILLIS", "", "drawSandboxResponseSection", "", "Lcom/talabat/gem/samples/SampleGemActivity;", "drawStartFlowSection", "drawTiersCountSection", "com_talabat_Components_gem_gem", "sandboxResponse", ""}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SampleGemActivityKt {
    private static final long SLEEP_TILL_APP_START_MILLIS = 5000;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f60495a = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(SampleGemActivityKt.class, "sandboxResponse", "<v#0>", 1))};

    /* access modifiers changed from: private */
    public static final void drawSandboxResponseSection(SampleGemActivity sampleGemActivity) {
        ReadWriteProperty preferences$default = DataSourcesDelegateKt.preferences$default(Delegates.INSTANCE, ServerKt.KEY_SANDBOX_RESPONSE, (Object) null, new SampleGemActivityKt$drawSandboxResponseSection$sandboxResponse$2(sampleGemActivity), 2, (Object) null);
        Button button = (Button) sampleGemActivity._$_findCachedViewById(R.id.sandboxResponseButton);
        Intrinsics.checkNotNullExpressionValue(button, "sandboxResponseButton");
        ViewKt.invoke(button, new SampleGemActivityKt$drawSandboxResponseSection$1(preferences$default));
    }

    /* access modifiers changed from: private */
    /* renamed from: drawSandboxResponseSection$lambda-2  reason: not valid java name */
    public static final Boolean m10587drawSandboxResponseSection$lambda2(ReadWriteProperty<Object, Boolean> readWriteProperty) {
        return readWriteProperty.getValue(null, f60495a[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawSandboxResponseSection$lambda-3  reason: not valid java name */
    public static final void m10588drawSandboxResponseSection$lambda3(ReadWriteProperty<Object, Boolean> readWriteProperty, Boolean bool) {
        readWriteProperty.setValue(null, f60495a[0], bool);
    }

    /* access modifiers changed from: private */
    public static final void drawStartFlowSection(SampleGemActivity sampleGemActivity) {
        String str;
        int i11 = R.id.expiresAfterTextView;
        EditText editText = (EditText) sampleGemActivity._$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(editText, "expiresAfterTextView");
        Double expireAfterMinutes = SampleDataSourcesKt.getExpireAfterMinutes();
        if (expireAfterMinutes != null) {
            str = expireAfterMinutes.toString();
        } else {
            str = null;
        }
        ViewKt.plusAssign((TextView) editText, str);
        EditText editText2 = (EditText) sampleGemActivity._$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(editText2, "expiresAfterTextView");
        editText2.addTextChangedListener(new SampleGemActivityKt$drawStartFlowSection$$inlined$addTextChangedListener$default$1());
    }

    /* access modifiers changed from: private */
    public static final void drawTiersCountSection(SampleGemActivity sampleGemActivity) {
        String str;
        int i11 = R.id.tiersCountTextView;
        EditText editText = (EditText) sampleGemActivity._$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(editText, "tiersCountTextView");
        Double tiersCount = SampleDataSourcesKt.getTiersCount();
        if (tiersCount != null) {
            str = tiersCount.toString();
        } else {
            str = null;
        }
        ViewKt.plusAssign((TextView) editText, str);
        EditText editText2 = (EditText) sampleGemActivity._$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(editText2, "tiersCountTextView");
        editText2.addTextChangedListener(new SampleGemActivityKt$drawTiersCountSection$$inlined$addTextChangedListener$default$1());
    }
}
