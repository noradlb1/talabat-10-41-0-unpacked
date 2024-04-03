package androidx.constraintlayout.core;

import androidx.constraintlayout.core.Pools;

public class Cache {

    /* renamed from: a  reason: collision with root package name */
    public Pools.Pool<ArrayRow> f10433a = new Pools.SimplePool(256);

    /* renamed from: b  reason: collision with root package name */
    public Pools.Pool<ArrayRow> f10434b = new Pools.SimplePool(256);

    /* renamed from: c  reason: collision with root package name */
    public Pools.Pool<SolverVariable> f10435c = new Pools.SimplePool(256);

    /* renamed from: d  reason: collision with root package name */
    public SolverVariable[] f10436d = new SolverVariable[32];
}
