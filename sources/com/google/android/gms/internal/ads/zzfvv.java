package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfvg;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import net.bytebuddy.description.method.MethodDescription;

abstract class zzfvv<OutputT> extends zzfvg.zzi<OutputT> {
    private static final zzfvr zzaP;
    private static final Logger zzaQ;
    /* access modifiers changed from: private */
    public volatile int remaining;
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile Set<Throwable> seenExceptions = null;

    static {
        Throwable th2;
        zzfvr zzfvr;
        Class<zzfvv> cls = zzfvv.class;
        zzaQ = Logger.getLogger(cls.getName());
        try {
            zzfvr = new zzfvs(AtomicReferenceFieldUpdater.newUpdater(cls, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(cls, "remaining"));
            th2 = null;
        } catch (Throwable th3) {
            zzfvr = new zzfvu((zzfvt) null);
            th2 = th3;
        }
        zzaP = zzfvr;
        if (th2 != null) {
            zzaQ.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME, "SafeAtomicHelper is broken!", th2);
        }
    }

    public zzfvv(int i11) {
        this.remaining = i11;
    }

    public final int zzC() {
        return zzaP.zza(this);
    }

    public final Set<Throwable> zzE() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zza(newSetFromMap);
        zzaP.zzb(this, (Set<Throwable>) null, newSetFromMap);
        Set<Throwable> set2 = this.seenExceptions;
        set2.getClass();
        return set2;
    }

    public final void zzH() {
        this.seenExceptions = null;
    }

    public abstract void zza(Set<Throwable> set);
}
