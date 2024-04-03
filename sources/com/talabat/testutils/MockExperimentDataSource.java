package com.talabat.testutils;

import com.talabat.core.experiment.data.datasource.IExperimentDataSource;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MockExperimentDataSource implements IExperimentDataSource {
    private boolean booleanResult;
    private double doubleResult;
    private int intResult;
    private String stringResult;

    public MockExperimentDataSource(boolean z11) {
        this.intResult = 0;
        this.doubleResult = 0.0d;
        this.booleanResult = z11;
        this.stringResult = null;
    }

    public boolean getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11) {
        return this.booleanResult;
    }

    public double getDoubleVariant(@NotNull FWFKey fWFKey, double d11) {
        return this.doubleResult;
    }

    public int getIntVariant(@NotNull FWFKey fWFKey, int i11) {
        return this.intResult;
    }

    @NotNull
    public String getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str) {
        return this.stringResult;
    }

    public void setAttribute(@NotNull String str, @NotNull String str2) {
    }

    @Nullable
    public Object getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Continuation<? super Boolean> continuation) {
        return Boolean.valueOf(this.booleanResult);
    }

    @Nullable
    public Object getDoubleVariant(@NotNull FWFKey fWFKey, double d11, boolean z11, @NotNull Continuation<? super Double> continuation) {
        return Double.valueOf(this.doubleResult);
    }

    @Nullable
    public Object getIntVariant(@NotNull FWFKey fWFKey, int i11, boolean z11, @NotNull Continuation<? super Integer> continuation) {
        return Integer.valueOf(this.intResult);
    }

    @Nullable
    public Object getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str, boolean z11, @NotNull Continuation<? super String> continuation) {
        return this.stringResult;
    }

    public void getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Function1<? super Boolean, Unit> function1) {
        function1.invoke(Boolean.valueOf(this.booleanResult));
    }

    public void getDoubleVariant(@NotNull FWFKey fWFKey, @NotNull double d11, boolean z11, @NotNull Function1<? super Double, Unit> function1) {
        function1.invoke(Double.valueOf(this.doubleResult));
    }

    public void getIntVariant(@NotNull FWFKey fWFKey, int i11, boolean z11, @NotNull Function1<? super Integer, Unit> function1) {
        function1.invoke(Integer.valueOf(this.intResult));
    }

    public void getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str, boolean z11, @NotNull Function1<? super String, Unit> function1) {
        function1.invoke(this.stringResult);
    }

    public MockExperimentDataSource(boolean z11, String str) {
        this.intResult = 0;
        this.doubleResult = 0.0d;
        this.booleanResult = z11;
        this.stringResult = str;
    }

    public MockExperimentDataSource(String str) {
        this.booleanResult = false;
        this.intResult = 0;
        this.doubleResult = 0.0d;
        this.stringResult = str;
    }

    public MockExperimentDataSource(int i11) {
        this.booleanResult = false;
        this.stringResult = "";
        this.doubleResult = 0.0d;
        this.intResult = i11;
    }

    public MockExperimentDataSource(double d11) {
        this.booleanResult = false;
        this.stringResult = "";
        this.intResult = 0;
        this.doubleResult = d11;
    }
}
