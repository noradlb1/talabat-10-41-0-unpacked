package com.huawei.hms.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.analytics.core.log.HiLog;

public class e implements Application.ActivityLifecycleCallbacks {
    private static e ijk;
    private boolean def = false;
    private long efg = 0;
    private Runnable fgh;
    private final Handler ghi = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public boolean hij = true;
    public bl ikl;
    public boolean klm = true;
    public boolean lmn = false;

    public static e lmn(Context context) {
        synchronized (e.class) {
            if (ijk == null) {
                ijk = new e();
                Application lmn2 = context instanceof Application ? (Application) context : dp.lmn();
                if (lmn2 != null) {
                    lmn2.registerActivityLifecycleCallbacks(ijk);
                } else {
                    HiLog.e("LifecycleRingback", "application is null.register activity lifecycle failed");
                }
            }
        }
        return ijk;
    }

    public static /* synthetic */ void lmn(e eVar, long j11) {
        HiLog.d("LifecycleRingback", "Background. Pause time: ".concat(String.valueOf(j11)));
        bl blVar = eVar.ikl;
        if (blVar != null) {
            blVar.klm(j11);
        }
        if (!eVar.klm) {
            HiLog.i("LifecycleRingback", "background report is closed");
            return;
        }
        bl blVar2 = eVar.ikl;
        if (blVar2 != null) {
            blVar2.lmn();
            eVar.ikl.klm();
        }
        cde.lmn().klm();
    }

    public final void lmn() {
        if (!this.def) {
            this.def = true;
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (!av.lmn().lmn.fgh) {
                        HiLog.w("LifecycleRingback", "auto collect is closed");
                    } else if (!(e.this.ikl instanceof def) || !be.lmn()) {
                        HiLog.i("LifecycleRingback", "is OpennessInit Complete: " + be.lmn());
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putString("$StartType", av.lmn().lmn.f47857d);
                        ((def) e.this.ikl).klm("$LaunchApp", new dt("$LaunchApp", bundle), 0);
                        HiLog.d("LifecycleRingback", "onLaunchAppEvent");
                    }
                }
            });
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        HiLog.d("LifecycleRingback", "onActivityPaused called.");
        this.hij = true;
        Runnable runnable = this.fgh;
        if (runnable != null) {
            this.ghi.removeCallbacks(runnable);
        }
        final long currentTimeMillis = System.currentTimeMillis();
        long j11 = c.lmn().ghi;
        long j12 = this.efg;
        if (!(j12 == 0 || j11 == 0 || (j11 > j12 && j11 <= currentTimeMillis))) {
            c.lmn().hij = null;
            HiLog.d("LifecycleRingback", "Clear previous page info");
        }
        Handler handler = this.ghi;
        AnonymousClass2 r52 = new Runnable() {
            public final void run() {
                if (!e.this.lmn || !e.this.hij) {
                    HiLog.i("LifecycleRingback", "still foreground");
                    return;
                }
                boolean unused = e.this.lmn = false;
                try {
                    e.lmn(e.this, currentTimeMillis);
                } catch (Throwable th2) {
                    HiLog.w("LifecycleRingback", "lifecycle callback onReport error");
                    dr.lmn(th2);
                }
            }
        };
        this.fgh = r52;
        handler.postDelayed(r52, 200);
        if (!av.lmn().lmn.fgh) {
            HiLog.w("LifecycleRingback", "auto collect is closed");
        } else if (be.lmn()) {
            c lmn2 = c.lmn();
            HiLog.d("ActivityStatCommander", "onScreenExitDelayed with time: ".concat(String.valueOf(currentTimeMillis)));
            lmn2.fgh = true;
            lmn2.efg.postDelayed(new Runnable(activity, currentTimeMillis) {
                final /* synthetic */ long klm;
                final /* synthetic */ Activity lmn;

                public final void run(
/*
Method generation error in method: com.huawei.hms.analytics.c.2.run():void, dex: classes6.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.huawei.hms.analytics.c.2.run():void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            }, 100);
        }
    }

    public void onActivityResumed(final Activity activity) {
        HiLog.d("LifecycleRingback", "onActivityResumed called.");
        final long currentTimeMillis = System.currentTimeMillis();
        this.efg = currentTimeMillis;
        this.hij = false;
        boolean z11 = !this.lmn;
        this.lmn = true;
        Runnable runnable = this.fgh;
        if (runnable != null) {
            this.ghi.removeCallbacks(runnable);
        }
        if (!z11 || this.ikl == null) {
            HiLog.d("LifecycleRingback", "still foreground.");
        } else {
            HiLog.d("LifecycleRingback", "foreground. Resume time: ".concat(String.valueOf(currentTimeMillis)));
            this.ikl.lmn(currentTimeMillis);
        }
        if (this.ikl != null) {
            lmn();
        }
        if (be.lmn()) {
            c.lmn().lmn(activity, new Bundle(), currentTimeMillis);
        } else {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        c.lmn().lmn(activity, new Bundle(), currentTimeMillis);
                    } else {
                        HiLog.w("LifecycleRingback", "opennessInitComplete is false");
                    }
                }
            });
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
