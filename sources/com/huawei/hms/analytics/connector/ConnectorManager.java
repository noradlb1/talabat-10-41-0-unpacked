package com.huawei.hms.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.analytics.ao;
import com.huawei.hms.analytics.ap;
import com.huawei.hms.analytics.ar;
import com.huawei.hms.analytics.av;
import com.huawei.hms.analytics.be;
import com.huawei.hms.analytics.bl;
import com.huawei.hms.analytics.cde;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.dg;
import com.huawei.hms.analytics.dl;
import com.huawei.hms.analytics.dm;
import com.huawei.hms.analytics.dr;
import com.huawei.hms.analytics.dt;
import com.huawei.hms.analytics.e;
import com.huawei.hms.analytics.ea;
import com.huawei.hms.analytics.framework.SyncManager;
import com.huawei.hms.analytics.ghi;
import com.huawei.hms.analytics.hij;
import com.huawei.hms.analytics.instance.CallBack;
import java.util.HashMap;
import java.util.Map;

public class ConnectorManager {
    /* access modifiers changed from: private */
    public String ikl;
    /* access modifiers changed from: private */
    public ao klm;
    private boolean lmn;

    public ConnectorManager(Context context, String str, String str2) {
        lmn(context, str, str2, "UNKNOWN");
    }

    public ConnectorManager(Context context, String str, String str2, String str3) {
        lmn(context, str, str2, str3);
    }

    private void klm(Context context, String str, String str2, String str3) {
        Context applicationContext = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        cde.lmn();
        cde.lmn((hij) new ghi(context, str, str3, SyncManager.TaskNames.INIT_TASK_CONNECTOR));
        bl lmn2 = cde.lmn().lmn(str);
        if (lmn2 == null) {
            ao aoVar = new ao(applicationContext, str);
            this.klm = aoVar;
            aoVar.lmn(str2);
            cde.lmn().lmn(str, (bl) this.klm);
        } else {
            this.klm = (ao) lmn2;
        }
        e.lmn(context);
    }

    private void lmn(Context context, String str, String str2, String str3) {
        if (context != null) {
            if (!ea.lmn().lmn(context)) {
                HiLog.w("InteractionManager", "user unlock");
            } else if (TextUtils.isEmpty(str) || str.length() > 256) {
                HiLog.d("InteractionManager", "serviceTag param is not right");
            } else if (TextUtils.isEmpty(str2) || str2.length() > 256) {
                HiLog.w("InteractionManager", "header param is not right");
            } else {
                try {
                    this.ikl = str;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "UNKNOWN";
                    }
                    klm(context, str, str2, str3);
                    this.lmn = true;
                } catch (Throwable th2) {
                    HiLog.e("InteractionManager", "other exception,init connector instance error ");
                    dr.lmn(th2);
                }
            }
        }
    }

    public Map<String, String[]> getDataUploadSiteInfo(String str) {
        if (!this.lmn) {
            HiLog.w("InteractionManager", "The instance init failed. serviceTag: " + this.ikl);
            if (!str.equals(this.ikl)) {
                return new HashMap();
            }
            HashMap hashMap = new HashMap(1);
            hashMap.put("errorCode", new String[]{"-101"});
            return hashMap;
        } else if (be.lmn(str)) {
            return ao.klm(str);
        } else {
            try {
                SyncManager.getInstance().await(SyncManager.TaskNames.INIT_TASK_CONNECTOR, 150);
                return ao.klm(str);
            } catch (InterruptedException unused) {
                HiLog.w("InteractionManager", "getDataUploadSiteInfo Interrupted Exception");
                return new HashMap();
            }
        }
    }

    public Map<String, String> getUserProfiles(boolean z11) {
        if (this.lmn) {
            if (be.lmn(this.ikl)) {
                return this.klm.lmn(z11);
            }
            try {
                SyncManager.getInstance().await(SyncManager.TaskNames.INIT_TASK_CONNECTOR, 150);
                return this.klm.lmn(z11);
            } catch (InterruptedException unused) {
                HiLog.w("InteractionManager", "getUserProfiles Interrupted Exception");
            }
        }
        return new HashMap();
    }

    public void onEvent(final String str, Bundle bundle) {
        if (this.lmn) {
            HiLog.i("InteractionManager", "connectManager onEvent");
            final Bundle lmn2 = dm.lmn(bundle);
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    Bundle bundle;
                    if (be.lmn(ConnectorManager.this.ikl)) {
                        ao klm2 = ConnectorManager.this.klm;
                        String str = str;
                        Bundle bundle2 = lmn2;
                        if (!av.lmn().lmn.fgh || !av.lmn().lmn(klm2.hij).ikl) {
                            HiLog.w("interactionInstance", "The Analytics Kit is disabled");
                        } else if (TextUtils.isEmpty(str)) {
                            HiLog.w("interactionInstance", HiLog.ErrorCode.PE001, " param is null");
                        } else {
                            if (bundle2 == null) {
                                HiLog.w("interactionInstance", "bundle is null");
                                bundle = new Bundle();
                            } else {
                                bundle = (Bundle) bundle2.clone();
                            }
                            dt dtVar = new dt(str, klm2.hij);
                            if (!dl.lmn(str, ar.klm)) {
                                dtVar.ikl(bundle);
                                klm2.lmn(str, dtVar);
                            } else if (!dl.lmn(str, 256)) {
                            } else {
                                if (!dtVar.lmn(bundle)) {
                                    HiLog.w("interactionInstance", HiLog.ErrorCode.PE006, "bundle params is invalid.");
                                } else {
                                    klm2.lmn(str, dtVar, System.currentTimeMillis());
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public void onReport() {
        if (this.lmn) {
            HiLog.i("InteractionManager", "connectManager onReport");
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (!av.lmn().lmn(ConnectorManager.this.ikl).ikl) {
                        HiLog.w("InteractionManager", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
                    } else if (be.lmn(ConnectorManager.this.ikl)) {
                        ConnectorManager.this.klm.lmn();
                    }
                }
            });
        }
    }

    public void setAnalyticsEnabled(boolean z11) {
        if (this.lmn) {
            dg.lmn().lmn(new Runnable(z11) {
                final /* synthetic */ boolean lmn;

                public final void run(
/*
Method generation error in method: com.huawei.hms.analytics.ao.1.run():void, dex: classes6.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.huawei.hms.analytics.ao.1.run():void, class status: UNLOADED
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
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
            });
        }
    }

    @Deprecated
    public void setEnableAndroidID(Boolean bool) {
        if (this.lmn) {
            av.lmn().lmn(this.klm.hij).lmn = bool.booleanValue();
        }
    }

    public void syncOaid(CallBack callBack) {
        if (callBack == null) {
            HiLog.w("InteractionManager", "callback is null");
        } else if (!this.lmn) {
            callBack.onResult(CallBack.INIT_FAILED, this.ikl + " init failed");
        } else {
            ao aoVar = this.klm;
            dg.lmn().lmn(new ap(aoVar.ghi, aoVar.hij, callBack));
        }
    }
}
