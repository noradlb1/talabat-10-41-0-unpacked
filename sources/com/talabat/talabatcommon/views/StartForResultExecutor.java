package com.talabat.talabatcommon.views;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u001d\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J(\u0010\u0012\u001a\u00020\u00132\u001d\u0010\u0014\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\u0002\b\u0016H\u0006J\u0017\u0010\u0017\u001a\u00020\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/talabat/talabatcommon/views/StartForResultExecutor;", "T", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "builder", "Lcom/talabat/talabatcommon/views/StartForResultBuilder;", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/talabat/talabatcommon/views/StartForResultBuilder;)V", "getActivity$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Landroidx/appcompat/app/AppCompatActivity;", "getBuilder$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Lcom/talabat/talabatcommon/views/StartForResultBuilder;", "callbacks", "Lcom/talabat/talabatcommon/views/StartForResultCallbacks;", "getCallbacks$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Lcom/talabat/talabatcommon/views/StartForResultCallbacks;", "setCallbacks$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(Lcom/talabat/talabatcommon/views/StartForResultCallbacks;)V", "invoke", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "with", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StartForResultExecutor<T> {
    @NotNull
    private final AppCompatActivity activity;
    @NotNull
    private final StartForResultBuilder<T> builder;
    public StartForResultCallbacks<T> callbacks;

    public StartForResultExecutor(@NotNull AppCompatActivity appCompatActivity, @NotNull StartForResultBuilder<T> startForResultBuilder) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(startForResultBuilder, "builder");
        this.activity = appCompatActivity;
        this.builder = startForResultBuilder;
    }

    @NotNull
    public final AppCompatActivity getActivity$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.activity;
    }

    @NotNull
    public final StartForResultBuilder<T> getBuilder$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.builder;
    }

    @NotNull
    public final StartForResultCallbacks<T> getCallbacks$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        StartForResultCallbacks<T> startForResultCallbacks = this.callbacks;
        if (startForResultCallbacks != null) {
            return startForResultCallbacks;
        }
        Intrinsics.throwUninitializedPropertyAccessException("callbacks");
        return null;
    }

    @StartForResultDsl
    public final void invoke(@NotNull Function1<? super StartForResultCallbacks<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        StartForResultCallbacks startForResultCallbacks = new StartForResultCallbacks();
        function1.invoke(startForResultCallbacks);
        setCallbacks$com_talabat_NewArchi_TalabatCommon_TalabatCommon(startForResultCallbacks);
        StartForResultKt.replaceFragments(this.activity, StartForResultKt.fragment(this));
    }

    public final void setCallbacks$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull StartForResultCallbacks<T> startForResultCallbacks) {
        Intrinsics.checkNotNullParameter(startForResultCallbacks, "<set-?>");
        this.callbacks = startForResultCallbacks;
    }

    @StartForResultDsl
    public final void with(@NotNull StartForResultCallbacks<T> startForResultCallbacks) {
        Intrinsics.checkNotNullParameter(startForResultCallbacks, "callbacks");
        setCallbacks$com_talabat_NewArchi_TalabatCommon_TalabatCommon(startForResultCallbacks);
        StartForResultKt.replaceFragments(this.activity, StartForResultKt.fragment(this));
    }
}
