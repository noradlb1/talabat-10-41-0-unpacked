package com.talabat.talabatcommon.extentions;

import av.a;
import av.b;
import av.c;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aS\u0010\u0000\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\"\u0004\b\u0000\u0010\u00042\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001ay\u0010\b\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\"\u0004\b\u0000\u0010\u0004*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tH\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u0001\u0010\f\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\r*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012>\u0010\u000e\u001a:\b\u0001\u0012\u0004\u0012\u0002H\u0004\u0012&\u0012$\u0012 \u0012\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tH\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u0001\u0010\u000f\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\"\u0004\b\u0000\u0010\u0004*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012>\u0010\u000e\u001a:\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012&\u0012$\u0012 \u0012\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tH\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u0001\u0010\u0011\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\r*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012@\u0010\u000e\u001a<\b\u0001\u0012\u0004\u0012\u0002H\u0004\u0012(\u0012&\u0012\"\u0012 \b\u0001\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tH\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aÁ\u0001\u0010\u0012\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\r*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012@\u0010\u000e\u001a<\b\u0001\u0012\u0004\u0012\u0002H\u0004\u0012(\u0012&\u0012\"\u0012 \b\u0001\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tH\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a¥\u0001\u0010\u0015\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\r*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\u0006\u0010\u0013\u001a\u0002H\r2@\u0010\u000e\u001a<\b\u0001\u0012\u0004\u0012\u0002H\u0004\u0012(\u0012&\u0012\"\u0012 \b\u0001\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tH\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001ad\u0010\u0017\u001a\u00020\n\"\u0004\b\u0000\u0010\u0004*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\u00012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\n0\u0001H@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001aa\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00040\u001b\"\u0004\b\u0000\u0010\u0004*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\u001f\u0010\u001c\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u001b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001¢\u0006\u0002\b\u001dHDø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001aP\u0010\u001f\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0004*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\u0001H@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a:\u0010 \u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010!\u001aa\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00040\u001b\"\u0004\b\u0000\u0010\u0004*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\u001f\u0010\u001c\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u001b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001¢\u0006\u0002\b\u001dHFø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u0010#\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\r*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\"\u0010$\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tH\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001ay\u0010%\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\"\u0004\b\u0000\u0010\u0004*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\"\u0010&\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tH\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u0001\u0010'\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\r*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012$\u0010$\u001a \b\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tH\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u0001\u0010(\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\r*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\u0006\u0010)\u001a\u0002H\r2$\u0010$\u001a \b\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tH\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001ay\u0010*\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\"\u0004\b\u0000\u0010\u0004*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\"\u0010+\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010,\u001ay\u0010-\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\"\u0004\b\u0000\u0010\u0004*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\"\u0010.\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tH\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aG\u00100\u001a&\b\u0001\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n 1*\u0004\u0018\u0001H\u0004H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u000402H\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u00103\u001ac\u00104\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u0001H\u0004H\u000405\"\u0004\b\u0000\u0010\u0004*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\u001a\b\u0002\u00106\u001a\u0014\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u0004050\u0001H\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u00107\u001a;\u00108\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\"\u0004\b\u0000\u0010\u0004*\u0004\u0018\u0001H\u0004H\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u00109\u001ac\u0010:\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u0001H\u0004H\u00040;\"\u0004\b\u0000\u0010\u0004*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\u001a\b\u0002\u00106\u001a\u0014\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040;0\u0001H\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010<\u001ac\u0010=\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u0001H\u0004H\u000402\"\u0004\b\u0000\u0010\u0004*\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\u001a\b\u0002\u00106\u001a\u0014\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u0004020\u0001H\u0007ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010>*H\u0010?\u001a\u0004\b\u0000\u0010\u0004\"\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006@"}, d2 = {"Either", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "T", "", "block", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "doOnNext", "Lkotlin/Function2;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function1;", "flatMap", "R", "flatMapper", "flatMapError", "", "flatMapNonNull", "flatMapOrDefault", "defaultValue", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function1;", "flatMapOrDefaultValue", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function1;", "fold", "onFailure", "onSuccess", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/talabat/talabatcommon/extentions/EitherFold;", "folding", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrElse", "getOrThrow", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "map", "mapper", "mapError", "errorMapper", "mapNonNull", "mapOrDefault", "defaultIfNull", "recoverWith", "fallback", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "takeIf", "filter", "", "toEither", "kotlin.jvm.PlatformType", "Lio/reactivex/Single;", "(Lio/reactivex/Single;)Lkotlin/jvm/functions/Function1;", "toMaybe", "Lio/reactivex/Maybe;", "factory", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Maybe;", "toNonNullEither", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "toObservable", "Lio/reactivex/Observable;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "toSingle", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Single;", "SuspendEither", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class KotlinResultKt {
    @SuspendEitherVersion(version = 1)
    @NotNull
    public static final <T> Function1<Continuation<? super Result<? extends T>>, Object> Either(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        return new KotlinResultKt$Either$1(function1, (Continuation<? super KotlinResultKt$Either$1>) null);
    }

    @SuspendEitherVersion(version = 2)
    @NotNull
    public static final <T> Function1<Continuation<? super Result<? extends T>>, Object> doOnNext(@NotNull Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(function2, "block");
        return Either(new KotlinResultKt$doOnNext$1(function1, function2, (Continuation<? super KotlinResultKt$doOnNext$1>) null));
    }

    @SuspendEitherVersion(version = 1)
    @NotNull
    public static final <T, R> Function1<Continuation<? super Result<? extends R>>, Object> flatMap(@NotNull Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, @NotNull Function2<? super T, ? super Continuation<? super Function1<? super Continuation<? super Result<? extends R>>, ? extends Object>>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(function2, "flatMapper");
        return Either(new KotlinResultKt$flatMap$1(function2, function1, (Continuation<? super KotlinResultKt$flatMap$1>) null));
    }

    @SuspendEitherVersion(version = 1)
    @NotNull
    public static final <T> Function1<Continuation<? super Result<? extends T>>, Object> flatMapError(@NotNull Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, @NotNull Function2<? super Throwable, ? super Continuation<? super Function1<? super Continuation<? super Result<? extends T>>, ? extends Object>>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(function2, "flatMapper");
        return Either(new KotlinResultKt$flatMapError$1(function1, function2, (Continuation<? super KotlinResultKt$flatMapError$1>) null));
    }

    @SuspendEitherVersion(version = 2)
    @NotNull
    public static final <T, R> Function1<Continuation<? super Result<? extends R>>, Object> flatMapNonNull(@NotNull Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, @NotNull Function2<? super T, ? super Continuation<? super Function1<? super Continuation<? super Result<? extends R>>, ? extends Object>>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(function2, "flatMapper");
        return Either(new KotlinResultKt$flatMapNonNull$1(function1, function2, (Continuation<? super KotlinResultKt$flatMapNonNull$1>) null));
    }

    @SuspendEitherVersion(version = 2)
    @NotNull
    public static final <T, R> Function1<Continuation<? super Result<? extends R>>, Object> flatMapOrDefault(@NotNull Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, @NotNull Function1<? super Continuation<? super Result<? extends R>>, ? extends Object> function12, @NotNull Function2<? super T, ? super Continuation<? super Function1<? super Continuation<? super Result<? extends R>>, ? extends Object>>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(function12, "defaultValue");
        Intrinsics.checkNotNullParameter(function2, "flatMapper");
        return Either(new KotlinResultKt$flatMapOrDefault$1(function1, function12, function2, (Continuation<? super KotlinResultKt$flatMapOrDefault$1>) null));
    }

    @SuspendEitherVersion(version = 2)
    @NotNull
    public static final <T, R> Function1<Continuation<? super Result<? extends R>>, Object> flatMapOrDefaultValue(@NotNull Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, R r11, @NotNull Function2<? super T, ? super Continuation<? super Function1<? super Continuation<? super Result<? extends R>>, ? extends Object>>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(function2, "flatMapper");
        return Either(new KotlinResultKt$flatMapOrDefaultValue$1(function1, r11, function2, (Continuation<? super KotlinResultKt$flatMapOrDefaultValue$1>) null));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @com.talabat.talabatcommon.extentions.SuspendEitherVersion(version = 1)
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "use the fold(EitherFold) function instead of this one")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object fold(kotlin.jvm.functions.Function1 r4, kotlin.jvm.functions.Function1 r5, kotlin.jvm.functions.Function1 r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof com.talabat.talabatcommon.extentions.KotlinResultKt$fold$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.talabatcommon.extentions.KotlinResultKt$fold$1 r0 = (com.talabat.talabatcommon.extentions.KotlinResultKt$fold$1) r0
            int r1 = r0.f47025k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f47025k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.extentions.KotlinResultKt$fold$1 r0 = new com.talabat.talabatcommon.extentions.KotlinResultKt$fold$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f47024j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f47025k
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r4 = r0.f47023i
            r6 = r4
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            java.lang.Object r4 = r0.f47022h
            r5 = r4
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004b
        L_0x0033:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.f47022h = r5
            r0.f47023i = r6
            r0.f47025k = r3
            java.lang.Object r7 = r4.invoke(r0)
            if (r7 != r1) goto L_0x004b
            return r1
        L_0x004b:
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r4 = r7.m6338unboximpl()
            java.lang.Throwable r7 = kotlin.Result.m6332exceptionOrNullimpl(r4)
            if (r7 != 0) goto L_0x005b
            r6.invoke(r4)
            goto L_0x005e
        L_0x005b:
            r5.invoke(r7)
        L_0x005e:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.extentions.KotlinResultKt.fold(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object fold$default(Function1 function1, Function1 function12, Function1 function13, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function12 = KotlinResultKt$fold$2.INSTANCE;
        }
        return fold(function1, function12, function13, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @com.talabat.talabatcommon.extentions.SuspendEitherVersion(version = 1)
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object getOrElse(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>>, ? extends java.lang.Object> r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<java.lang.Object> r6) {
        /*
            boolean r0 = r6 instanceof com.talabat.talabatcommon.extentions.KotlinResultKt$getOrElse$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.talabatcommon.extentions.KotlinResultKt$getOrElse$1 r0 = (com.talabat.talabatcommon.extentions.KotlinResultKt$getOrElse$1) r0
            int r1 = r0.f47028j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f47028j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.extentions.KotlinResultKt$getOrElse$1 r0 = new com.talabat.talabatcommon.extentions.KotlinResultKt$getOrElse$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.f47027i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f47028j
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.f47026h
            r5 = r4
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0044
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.f47026h = r5
            r0.f47028j = r3
            java.lang.Object r6 = r4.invoke(r0)
            if (r6 != r1) goto L_0x0044
            return r1
        L_0x0044:
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r4 = r6.m6338unboximpl()
            java.lang.Throwable r6 = kotlin.Result.m6332exceptionOrNullimpl(r4)
            if (r6 != 0) goto L_0x0051
            goto L_0x0055
        L_0x0051:
            java.lang.Object r4 = r5.invoke(r6)
        L_0x0055:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.extentions.KotlinResultKt.getOrElse(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @com.talabat.talabatcommon.extentions.SuspendEitherVersion(version = 1)
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object getOrThrow(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>>, ? extends java.lang.Object> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r5) {
        /*
            boolean r0 = r5 instanceof com.talabat.talabatcommon.extentions.KotlinResultKt$getOrThrow$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.talabatcommon.extentions.KotlinResultKt$getOrThrow$1 r0 = (com.talabat.talabatcommon.extentions.KotlinResultKt$getOrThrow$1) r0
            int r1 = r0.f47030i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f47030i = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.extentions.KotlinResultKt$getOrThrow$1 r0 = new com.talabat.talabatcommon.extentions.KotlinResultKt$getOrThrow$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.f47029h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f47030i
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003d
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.f47030i = r3
            java.lang.Object r5 = r4.invoke(r0)
            if (r5 != r1) goto L_0x003d
            return r1
        L_0x003d:
            kotlin.Result r5 = (kotlin.Result) r5
            java.lang.Object r4 = r5.m6338unboximpl()
            kotlin.ResultKt.throwOnFailure(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.extentions.KotlinResultKt.getOrThrow(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @com.talabat.talabatcommon.extentions.SuspendEitherVersion(version = 2)
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object invoke(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Result<? extends T>>, ? extends java.lang.Object> r6, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.talabat.talabatcommon.extentions.EitherFold<T>, kotlin.Unit> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.talabatcommon.extentions.EitherFold<T>> r8) {
        /*
            boolean r0 = r8 instanceof com.talabat.talabatcommon.extentions.KotlinResultKt$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.talabatcommon.extentions.KotlinResultKt$invoke$1 r0 = (com.talabat.talabatcommon.extentions.KotlinResultKt$invoke$1) r0
            int r1 = r0.f47034k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f47034k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.extentions.KotlinResultKt$invoke$1 r0 = new com.talabat.talabatcommon.extentions.KotlinResultKt$invoke$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.f47033j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f47034k
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r5) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            goto L_0x0034
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.f47031h
            com.talabat.talabatcommon.extentions.EitherFold r6 = (com.talabat.talabatcommon.extentions.EitherFold) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0084
        L_0x003c:
            java.lang.Object r6 = r0.f47032i
            com.talabat.talabatcommon.extentions.EitherFold r6 = (com.talabat.talabatcommon.extentions.EitherFold) r6
            java.lang.Object r7 = r0.f47031h
            com.talabat.talabatcommon.extentions.EitherFold r7 = (com.talabat.talabatcommon.extentions.EitherFold) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0063
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r8)
            com.talabat.talabatcommon.extentions.EitherFold r8 = new com.talabat.talabatcommon.extentions.EitherFold
            r8.<init>()
            r7.invoke(r8)
            r0.f47031h = r8
            r0.f47032i = r8
            r0.f47034k = r5
            java.lang.Object r6 = r6.invoke(r0)
            if (r6 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r7 = r8
            r8 = r6
            r6 = r7
        L_0x0063:
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r8 = r8.m6338unboximpl()
            java.lang.Throwable r2 = kotlin.Result.m6332exceptionOrNullimpl(r8)
            r5 = 0
            if (r2 != 0) goto L_0x0086
            kotlin.jvm.functions.Function2 r6 = r6.getOnSuccess$com_talabat_NewArchi_TalabatCommon_TalabatCommon()
            if (r6 == 0) goto L_0x0099
            r0.f47031h = r7
            r0.f47032i = r5
            r0.f47034k = r4
            java.lang.Object r6 = r6.invoke(r8, r0)
            if (r6 != r1) goto L_0x0083
            return r1
        L_0x0083:
            r6 = r7
        L_0x0084:
            r7 = r6
            goto L_0x0099
        L_0x0086:
            kotlin.jvm.functions.Function2 r6 = r6.getOnFailure$com_talabat_NewArchi_TalabatCommon_TalabatCommon()
            if (r6 == 0) goto L_0x0099
            r0.f47031h = r7
            r0.f47032i = r5
            r0.f47034k = r3
            java.lang.Object r6 = r6.invoke(r2, r0)
            if (r6 != r1) goto L_0x0083
            return r1
        L_0x0099:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.extentions.KotlinResultKt.invoke(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @SuspendEitherVersion(version = 1)
    @NotNull
    public static final <T, R> Function1<Continuation<? super Result<? extends R>>, Object> map(@NotNull Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(function2, "mapper");
        return Either(new KotlinResultKt$map$1(function2, function1, (Continuation<? super KotlinResultKt$map$1>) null));
    }

    @SuspendEitherVersion(version = 1)
    @NotNull
    public static final <T> Function1<Continuation<? super Result<? extends T>>, Object> mapError(@NotNull Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, @NotNull Function2<? super Throwable, ? super Continuation<? super T>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(function2, "errorMapper");
        return Either(new KotlinResultKt$mapError$1(function1, function2, (Continuation<? super KotlinResultKt$mapError$1>) null));
    }

    @SuspendEitherVersion(version = 2)
    @NotNull
    public static final <T, R> Function1<Continuation<? super Result<? extends R>>, Object> mapNonNull(@NotNull Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(function2, "mapper");
        return Either(new KotlinResultKt$mapNonNull$1(function1, function2, (Continuation<? super KotlinResultKt$mapNonNull$1>) null));
    }

    @SuspendEitherVersion(version = 2)
    @NotNull
    public static final <T, R> Function1<Continuation<? super Result<? extends R>>, Object> mapOrDefault(@NotNull Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, R r11, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(function2, "mapper");
        return Either(new KotlinResultKt$mapOrDefault$1(function1, r11, function2, (Continuation<? super KotlinResultKt$mapOrDefault$1>) null));
    }

    @SuspendEitherVersion(version = 1)
    @NotNull
    public static final <T> Function1<Continuation<? super Result<? extends T>>, Object> recoverWith(@NotNull Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, @NotNull Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function12) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(function12, "fallback");
        return Either(new KotlinResultKt$recoverWith$1(function1, function12, (Continuation<? super KotlinResultKt$recoverWith$1>) null));
    }

    @SuspendEitherVersion(version = 2)
    @NotNull
    public static final <T> Function1<Continuation<? super Result<? extends T>>, Object> takeIf(@NotNull Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(function2, "filter");
        return Either(new KotlinResultKt$takeIf$1(function1, function2, (Continuation<? super KotlinResultKt$takeIf$1>) null));
    }

    @SuspendEitherVersion(version = 3)
    @NotNull
    public static final <T> Function1<Continuation<? super Result<? extends T>>, Object> toEither(@NotNull Single<T> single) {
        Intrinsics.checkNotNullParameter(single, "<this>");
        return Either(new KotlinResultKt$toEither$1(single, (Continuation<? super KotlinResultKt$toEither$1>) null));
    }

    @SuspendEitherVersion(version = 2)
    @NotNull
    public static final <T> Maybe<T> toMaybe(@NotNull Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, @NotNull Function1<? super T, ? extends Maybe<T>> function12) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(function12, "factory");
        Maybe<T> defer = Maybe.defer(new a(function1, function12));
        Intrinsics.checkNotNullExpressionValue(defer, "defer {\n    try {\n      ….error(throwable)\n    }\n}");
        return defer;
    }

    public static /* synthetic */ Maybe toMaybe$default(Function1 function1, Function1 function12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function12 = KotlinResultKt$toMaybe$1.INSTANCE;
        }
        return toMaybe(function1, function12);
    }

    /* access modifiers changed from: private */
    /* renamed from: toMaybe$lambda-5  reason: not valid java name */
    public static final MaybeSource m9350toMaybe$lambda5(Function1 function1, Function1 function12) {
        Maybe maybe;
        Intrinsics.checkNotNullParameter(function1, "$this_toMaybe");
        Intrinsics.checkNotNullParameter(function12, "$factory");
        try {
            Object runBlocking$default = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new KotlinResultKt$toMaybe$2$1(function1, (Continuation) null), 1, (Object) null);
            if (runBlocking$default == null || (maybe = (Maybe) function12.invoke(runBlocking$default)) == null) {
                return Maybe.empty();
            }
            return maybe;
        } catch (Throwable th2) {
            if (th2 instanceof NullValueInEitherException) {
                return Maybe.empty();
            }
            return Maybe.error(th2);
        }
    }

    @SuspendEitherVersion(version = 3)
    @NotNull
    public static final <T> Function1<Continuation<? super Result<? extends T>>, Object> toNonNullEither(@Nullable T t11) {
        return Either(new KotlinResultKt$toNonNullEither$1(t11, (Continuation<? super KotlinResultKt$toNonNullEither$1>) null));
    }

    @SuspendEitherVersion(version = 2)
    @NotNull
    public static final <T> Observable<T> toObservable(@NotNull Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, @NotNull Function1<? super T, ? extends Observable<T>> function12) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(function12, "factory");
        Observable<T> defer = Observable.defer(new c(function1, function12));
        Intrinsics.checkNotNullExpressionValue(defer, "defer {\n    try {\n      ….error(throwable)\n    }\n}");
        return defer;
    }

    public static /* synthetic */ Observable toObservable$default(Function1 function1, Function1 function12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function12 = KotlinResultKt$toObservable$1.INSTANCE;
        }
        return toObservable(function1, function12);
    }

    /* access modifiers changed from: private */
    /* renamed from: toObservable$lambda-1  reason: not valid java name */
    public static final ObservableSource m9351toObservable$lambda1(Function1 function1, Function1 function12) {
        Observable observable;
        Intrinsics.checkNotNullParameter(function1, "$this_toObservable");
        Intrinsics.checkNotNullParameter(function12, "$factory");
        try {
            Object runBlocking$default = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new KotlinResultKt$toObservable$2$1(function1, (Continuation) null), 1, (Object) null);
            if (runBlocking$default == null || (observable = (Observable) function12.invoke(runBlocking$default)) == null) {
                return Observable.empty();
            }
            return observable;
        } catch (Throwable th2) {
            if (th2 instanceof NullValueInEitherException) {
                return Observable.empty();
            }
            return Observable.error(th2);
        }
    }

    @SuspendEitherVersion(version = 2)
    @NotNull
    public static final <T> Single<T> toSingle(@NotNull Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, @NotNull Function1<? super T, ? extends Single<T>> function12) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(function12, "factory");
        Single<T> defer = Single.defer(new b(function1, function12));
        Intrinsics.checkNotNullExpressionValue(defer, "defer {\n    try {\n      ….error(throwable)\n    }\n}");
        return defer;
    }

    public static /* synthetic */ Single toSingle$default(Function1 function1, Function1 function12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function12 = KotlinResultKt$toSingle$1.INSTANCE;
        }
        return toSingle(function1, function12);
    }

    /* access modifiers changed from: private */
    /* renamed from: toSingle$lambda-3  reason: not valid java name */
    public static final SingleSource m9352toSingle$lambda3(Function1 function1, Function1 function12) {
        Single single;
        Single single2;
        Intrinsics.checkNotNullParameter(function1, "$this_toSingle");
        Intrinsics.checkNotNullParameter(function12, "$factory");
        try {
            Object runBlocking$default = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new KotlinResultKt$toSingle$2$1(function1, (Continuation) null), 1, (Object) null);
            if (runBlocking$default != null && (single2 = (Single) function12.invoke(runBlocking$default)) != null) {
                return single2;
            }
            Single error = Single.error((Throwable) new NoSuchElementException());
            Intrinsics.checkNotNullExpressionValue(error, "error<T>(NoSuchElementException())");
            return error;
        } catch (Throwable th2) {
            if (th2 instanceof NullValueInEitherException) {
                single = Single.error((Throwable) new NoSuchElementException());
            } else {
                single = Single.error(th2);
            }
            Intrinsics.checkNotNullExpressionValue(single, "{\n        if (throwable …le.error(throwable)\n    }");
            return single;
        }
    }

    @SuspendEitherVersion(version = 2)
    @Nullable
    public static final <T> Object fold(@NotNull Function1<? super Continuation<? super Result<? extends T>>, ? extends Object> function1, @NotNull Function1<? super EitherFold<T>, Unit> function12, @NotNull Continuation<? super EitherFold<T>> continuation) {
        return invoke(function1, function12, continuation);
    }
}
