package com.instabug.bug.settings;

import java.io.Serializable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private boolean f45763a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f45764b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f45765c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f45766d;

    public a() {
        this.f45763a = true;
        this.f45764b = true;
        this.f45765c = true;
        this.f45766d = true;
    }

    public a(boolean z11, boolean z12, boolean z13, boolean z14) {
        this.f45763a = z11;
        this.f45764b = z12;
        this.f45765c = z13;
        this.f45766d = z14;
    }

    public boolean a() {
        return this.f45765c;
    }

    public boolean b() {
        return this.f45766d;
    }

    public boolean c() {
        return this.f45764b;
    }

    public boolean d() {
        return this.f45763a;
    }

    public String toString() {
        return this.f45763a + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f45764b + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f45765c + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f45766d;
    }
}
