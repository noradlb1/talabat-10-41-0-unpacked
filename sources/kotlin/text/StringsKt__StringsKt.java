package kotlin.text;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.WasExperimental;
import kotlin.collections.CharIterator;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.HTTP;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0011\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u0015\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\n\u001a\u0018\u0010\u0017\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u0018\u0010\u0018\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a:\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001aE\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\b!\u001a:\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010#\u001a\u00020\u0010*\u00020\u00022\u0006\u0010$\u001a\u00020\u0006\u001a7\u0010%\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\bø\u0001\u0000¢\u0006\u0002\u0010*\u001a7\u0010+\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\bø\u0001\u0000¢\u0006\u0002\u0010*\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a;\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\b.\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u00100\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u00100\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\r\u00103\u001a\u00020\u0010*\u00020\u0002H\b\u001a\r\u00104\u001a\u00020\u0010*\u00020\u0002H\b\u001a\r\u00105\u001a\u00020\u0010*\u00020\u0002H\b\u001a \u00106\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00107\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00108\u001a\u000209*\u00020\u0002H\u0002\u001a&\u0010:\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010:\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010;\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u0010;\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u0002\u001a\u0010\u0010>\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u0002\u001a\u0015\u0010@\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\f\u001a\u000f\u0010A\u001a\u00020\r*\u0004\u0018\u00010\rH\b\u001a\u001c\u0010B\u001a\u00020\u0002*\u00020\u00022\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010B\u001a\u00020\r*\u00020\r2\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010E\u001a\u00020\r*\u00020\r2\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001aG\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00010=*\u00020\u00022\u000e\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\bI\u0010J\u001a=\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00010=*\u00020\u00022\u0006\u0010G\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\bI\u001a4\u0010K\u001a\u00020\u0010*\u00020\u00022\u0006\u0010L\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0012\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u0002\u001a\u0012\u0010N\u001a\u00020\r*\u00020\r2\u0006\u0010O\u001a\u00020\u0002\u001a\u001a\u0010P\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006\u001a\u0012\u0010P\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u001d\u0010P\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\b\u001a\u0015\u0010P\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u0001H\b\u001a\u0012\u0010R\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010R\u001a\u00020\r*\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010T\u001a\u00020\u0002\u001a\u001a\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u0002\u001a\u001a\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a.\u0010U\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0014\b\b\u0010V\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00020WH\bø\u0001\u0000\u001a\u001d\u0010U\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\rH\b\u001a$\u0010Z\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010Z\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010\\\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010\\\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001d\u0010_\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\rH\b\u001a)\u0010`\u001a\u00020\r*\u00020\r2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140WH\bø\u0001\u0000¢\u0006\u0002\ba\u001a)\u0010`\u001a\u00020\r*\u00020\r2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020WH\bø\u0001\u0000¢\u0006\u0002\bb\u001a\"\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0002\u001a\u001a\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0002\u001a%\u0010c\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0002H\b\u001a\u001d\u0010c\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0002H\b\u001a=\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010e\u001a0\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\n\u0010G\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a/\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0006\u0010T\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\bf\u001a%\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\b\u001a=\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010h\u001a0\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\n\u0010G\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a%\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\b\u001a\u001c\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a$\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010j\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u001d\u0010j\u001a\u00020\u0002*\u00020\r2\u0006\u0010k\u001a\u00020\u00062\u0006\u0010l\u001a\u00020\u0006H\b\u001a\u001f\u0010m\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u0006H\b\u001a\u0012\u0010m\u001a\u00020\r*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u0012\u0010m\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u0001\u001a\u001c\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\f\u0010r\u001a\u00020\u0010*\u00020\rH\u0007\u001a\u0013\u0010s\u001a\u0004\u0018\u00010\u0010*\u00020\rH\u0007¢\u0006\u0002\u0010t\u001a\n\u0010u\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010u\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\bø\u0001\u0000\u001a\u0016\u0010u\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010u\u001a\u00020\r*\u00020\rH\b\u001a$\u0010u\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\bø\u0001\u0000\u001a\u0016\u0010u\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010w\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010w\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\bø\u0001\u0000\u001a\u0016\u0010w\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010w\u001a\u00020\r*\u00020\rH\b\u001a$\u0010w\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\bø\u0001\u0000\u001a\u0016\u0010w\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010x\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010x\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\bø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010x\u001a\u00020\r*\u00020\rH\b\u001a$\u0010x\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\bø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0002\u0007\n\u0005\b20\u0001¨\u0006y"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "requireNonNegativeLimit", "", "limit", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "replaceFirstCharWithCharSequence", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i11, int i12, boolean z11, boolean z12, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            z12 = false;
        }
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i11, i12, z11, z12);
    }

    public static /* synthetic */ Sequence b(CharSequence charSequence, char[] cArr, int i11, boolean z11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            z11 = false;
        }
        if ((i13 & 8) != 0) {
            i12 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArr, i11, z11, i12);
    }

    public static /* synthetic */ Sequence c(CharSequence charSequence, String[] strArr, int i11, boolean z11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            z11 = false;
        }
        if ((i13 & 8) != 0) {
            i12 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, strArr, i11, z11, i12);
    }

    @NotNull
    public static final String commonPrefixWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, "other");
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i11 = 0;
        while (i11 < min && CharsKt__CharKt.equals(charSequence.charAt(i11), charSequence2.charAt(i11), z11)) {
            i11++;
        }
        int i12 = i11 - 1;
        if (hasSurrogatePairAt(charSequence, i12) || hasSurrogatePairAt(charSequence2, i12)) {
            i11--;
        }
        return charSequence.subSequence(0, i11).toString();
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return commonPrefixWith(charSequence, charSequence2, z11);
    }

    @NotNull
    public static final String commonSuffixWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, "other");
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int min = Math.min(length, length2);
        int i11 = 0;
        while (i11 < min && CharsKt__CharKt.equals(charSequence.charAt((length - i11) - 1), charSequence2.charAt((length2 - i11) - 1), z11)) {
            i11++;
        }
        if (hasSurrogatePairAt(charSequence, (length - i11) - 1) || hasSurrogatePairAt(charSequence2, (length2 - i11) - 1)) {
            i11--;
        }
        return charSequence.subSequence(length - i11, length).toString();
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return commonSuffixWith(charSequence, charSequence2, z11);
    }

    public static boolean contains(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (indexOf$default(charSequence, (String) charSequence2, 0, z11, 2, (Object) null) >= 0) {
                return true;
            }
        } else {
            if (a(charSequence, charSequence2, 0, charSequence.length(), z11, false, 16, (Object) null) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return contains(charSequence, charSequence2, z11);
    }

    public static final boolean contentEqualsIgnoreCaseImpl(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt__StringsJVMKt.equals((String) charSequence, (String) charSequence2, true);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!CharsKt__CharKt.equals(charSequence.charAt(i11), charSequence2.charAt(i11), true)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean contentEqualsImpl(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return Intrinsics.areEqual((Object) charSequence, (Object) charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (charSequence.charAt(i11) != charSequence2.charAt(i11)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean endsWith(@NotNull CharSequence charSequence, char c11, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() > 0 && CharsKt__CharKt.equals(charSequence.charAt(getLastIndex(charSequence)), c11, z11);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c11, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return endsWith(charSequence, c11, z11);
    }

    @Nullable
    public static final Pair<Integer, String> findAnyOf(@NotNull CharSequence charSequence, @NotNull Collection<String> collection, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(collection, "strings");
        return findAnyOf$StringsKt__StringsKt(charSequence, collection, i11, z11, false);
    }

    /* access modifiers changed from: private */
    public static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence charSequence, Collection<String> collection, int i11, boolean z11, boolean z12) {
        IntProgression intProgression;
        Object obj;
        Object obj2;
        int i12;
        if (z11 || collection.size() != 1) {
            if (!z12) {
                intProgression = new IntRange(RangesKt___RangesKt.coerceAtLeast(i11, 0), charSequence.length());
            } else {
                intProgression = RangesKt___RangesKt.downTo(RangesKt___RangesKt.coerceAtMost(i11, getLastIndex(charSequence)), 0);
            }
            if (charSequence instanceof String) {
                int first = intProgression.getFirst();
                int last = intProgression.getLast();
                int step = intProgression.getStep();
                if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                    while (true) {
                        Iterator it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            String str = (String) obj2;
                            if (StringsKt__StringsJVMKt.regionMatches(str, 0, (String) charSequence, first, str.length(), z11)) {
                                break;
                            }
                        }
                        String str2 = (String) obj2;
                        if (str2 == null) {
                            if (first == last) {
                                break;
                            }
                            first += step;
                        } else {
                            return TuplesKt.to(Integer.valueOf(first), str2);
                        }
                    }
                }
            } else {
                int first2 = intProgression.getFirst();
                int last2 = intProgression.getLast();
                int step2 = intProgression.getStep();
                if ((step2 > 0 && first2 <= last2) || (step2 < 0 && last2 <= first2)) {
                    while (true) {
                        Iterator it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it2.next();
                            String str3 = (String) obj;
                            if (regionMatchesImpl(str3, 0, charSequence, first2, str3.length(), z11)) {
                                break;
                            }
                        }
                        String str4 = (String) obj;
                        if (str4 == null) {
                            if (first2 == last2) {
                                break;
                            }
                            first2 += step2;
                        } else {
                            return TuplesKt.to(Integer.valueOf(first2), str4);
                        }
                    }
                }
            }
            return null;
        }
        String str5 = (String) CollectionsKt___CollectionsKt.single(collection);
        CharSequence charSequence2 = charSequence;
        String str6 = str5;
        int i13 = i11;
        if (!z12) {
            i12 = indexOf$default(charSequence2, str6, i13, false, 4, (Object) null);
        } else {
            i12 = lastIndexOf$default(charSequence2, str6, i13, false, 4, (Object) null);
        }
        if (i12 < 0) {
            return null;
        }
        return TuplesKt.to(Integer.valueOf(i12), str5);
    }

    public static /* synthetic */ Pair findAnyOf$default(CharSequence charSequence, Collection collection, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return findAnyOf(charSequence, collection, i11, z11);
    }

    @Nullable
    public static final Pair<Integer, String> findLastAnyOf(@NotNull CharSequence charSequence, @NotNull Collection<String> collection, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(collection, "strings");
        return findAnyOf$StringsKt__StringsKt(charSequence, collection, i11, z11, true);
    }

    public static /* synthetic */ Pair findLastAnyOf$default(CharSequence charSequence, Collection collection, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = getLastIndex(charSequence);
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return findLastAnyOf(charSequence, collection, i11, z11);
    }

    @NotNull
    public static IntRange getIndices(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static int getLastIndex(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(@NotNull CharSequence charSequence, int i11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (!new IntRange(0, charSequence.length() - 2).contains(i11) || !Character.isHighSurrogate(charSequence.charAt(i11)) || !Character.isLowSurrogate(charSequence.charAt(i11 + 1))) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [R, C, java.lang.CharSequence] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.internal.InlineOnly
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <C extends java.lang.CharSequence & R, R> R ifBlank(C r1, kotlin.jvm.functions.Function0<? extends R> r2) {
        /*
            java.lang.String r0 = "defaultValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r1)
            if (r0 == 0) goto L_0x000f
            java.lang.Object r1 = r2.invoke()
        L_0x000f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringsKt.ifBlank(java.lang.CharSequence, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [R, C, java.lang.CharSequence] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.internal.InlineOnly
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <C extends java.lang.CharSequence & R, R> R ifEmpty(C r1, kotlin.jvm.functions.Function0<? extends R> r2) {
        /*
            java.lang.String r0 = "defaultValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            int r0 = r1.length()
            if (r0 != 0) goto L_0x000d
            r0 = 1
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0014
            java.lang.Object r1 = r2.invoke()
        L_0x0014:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringsKt.ifEmpty(java.lang.CharSequence, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    public static final int indexOf(@NotNull CharSequence charSequence, char c11, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (!z11 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c11, i11);
        }
        return indexOfAny(charSequence, new char[]{c11}, i11, z11);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i11, int i12, boolean z11, boolean z12) {
        IntProgression intProgression;
        if (!z12) {
            intProgression = new IntRange(RangesKt___RangesKt.coerceAtLeast(i11, 0), RangesKt___RangesKt.coerceAtMost(i12, charSequence.length()));
        } else {
            intProgression = RangesKt___RangesKt.downTo(RangesKt___RangesKt.coerceAtMost(i11, getLastIndex(charSequence)), RangesKt___RangesKt.coerceAtLeast(i12, 0));
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int first = intProgression.getFirst();
            int last = intProgression.getLast();
            int step = intProgression.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                return -1;
            }
            while (true) {
                if (regionMatchesImpl(charSequence2, 0, charSequence, first, charSequence2.length(), z11)) {
                    return first;
                }
                if (first == last) {
                    return -1;
                }
                first += step;
            }
        } else {
            int first2 = intProgression.getFirst();
            int last2 = intProgression.getLast();
            int step2 = intProgression.getStep();
            if ((step2 <= 0 || first2 > last2) && (step2 >= 0 || last2 > first2)) {
                return -1;
            }
            while (true) {
                if (StringsKt__StringsJVMKt.regionMatches((String) charSequence2, 0, (String) charSequence, first2, charSequence2.length(), z11)) {
                    return first2;
                }
                if (first2 == last2) {
                    return -1;
                }
                first2 += step2;
            }
        }
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c11, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return indexOf(charSequence, c11, i11, z11);
    }

    public static final int indexOfAny(@NotNull CharSequence charSequence, @NotNull char[] cArr, int i11, boolean z11) {
        boolean z12;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        if (z11 || cArr.length != 1 || !(charSequence instanceof String)) {
            IntIterator it = new IntRange(RangesKt___RangesKt.coerceAtLeast(i11, 0), getLastIndex(charSequence)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                char charAt = charSequence.charAt(nextInt);
                int length = cArr.length;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        z12 = false;
                        continue;
                        break;
                    } else if (CharsKt__CharKt.equals(cArr[i12], charAt, z11)) {
                        z12 = true;
                        continue;
                        break;
                    } else {
                        i12++;
                    }
                }
                if (z12) {
                    return nextInt;
                }
            }
            return -1;
        }
        return ((String) charSequence).indexOf(ArraysKt___ArraysKt.single(cArr), i11);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, char[] cArr, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return indexOfAny(charSequence, cArr, i11, z11);
    }

    @InlineOnly
    private static final boolean isEmpty(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return true;
        }
        return false;
    }

    @InlineOnly
    private static final boolean isNotBlank(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return !StringsKt__StringsJVMKt.isBlank(charSequence);
    }

    @InlineOnly
    private static final boolean isNotEmpty(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() > 0) {
            return true;
        }
        return false;
    }

    @InlineOnly
    private static final boolean isNullOrBlank(CharSequence charSequence) {
        return charSequence == null || StringsKt__StringsJVMKt.isBlank(charSequence);
    }

    @InlineOnly
    private static final boolean isNullOrEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    @NotNull
    public static final CharIterator iterator(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new StringsKt__StringsKt$iterator$1(charSequence);
    }

    public static final int lastIndexOf(@NotNull CharSequence charSequence, char c11, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (!z11 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c11, i11);
        }
        return lastIndexOfAny(charSequence, new char[]{c11}, i11, z11);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c11, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = getLastIndex(charSequence);
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return lastIndexOf(charSequence, c11, i11, z11);
    }

    public static final int lastIndexOfAny(@NotNull CharSequence charSequence, @NotNull char[] cArr, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        if (z11 || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int coerceAtMost = RangesKt___RangesKt.coerceAtMost(i11, getLastIndex(charSequence)); -1 < coerceAtMost; coerceAtMost--) {
                char charAt = charSequence.charAt(coerceAtMost);
                int length = cArr.length;
                boolean z12 = false;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        break;
                    } else if (CharsKt__CharKt.equals(cArr[i12], charAt, z11)) {
                        z12 = true;
                        break;
                    } else {
                        i12++;
                    }
                }
                if (z12) {
                    return coerceAtMost;
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(ArraysKt___ArraysKt.single(cArr), i11);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, char[] cArr, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = getLastIndex(charSequence);
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return lastIndexOfAny(charSequence, cArr, i11, z11);
    }

    @NotNull
    public static final Sequence<String> lineSequence(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return splitToSequence$default(charSequence, new String[]{HTTP.CRLF, StringUtils.LF, StringUtils.CR}, false, 0, 6, (Object) null);
    }

    @NotNull
    public static final List<String> lines(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return SequencesKt___SequencesKt.toList(lineSequence(charSequence));
    }

    @InlineOnly
    private static final boolean matches(CharSequence charSequence, Regex regex) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.matches(charSequence);
    }

    @InlineOnly
    private static final String orEmpty(String str) {
        return str == null ? "" : str;
    }

    @NotNull
    public static final CharSequence padEnd(@NotNull CharSequence charSequence, int i11, char c11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i11 < 0) {
            throw new IllegalArgumentException("Desired length " + i11 + " is less than zero.");
        } else if (i11 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb2 = new StringBuilder(i11);
            sb2.append(charSequence);
            IntIterator it = new IntRange(1, i11 - charSequence.length()).iterator();
            while (it.hasNext()) {
                it.nextInt();
                sb2.append(c11);
            }
            return sb2;
        }
    }

    public static /* synthetic */ CharSequence padEnd$default(CharSequence charSequence, int i11, char c11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            c11 = ' ';
        }
        return padEnd(charSequence, i11, c11);
    }

    @NotNull
    public static final CharSequence padStart(@NotNull CharSequence charSequence, int i11, char c11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i11 < 0) {
            throw new IllegalArgumentException("Desired length " + i11 + " is less than zero.");
        } else if (i11 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb2 = new StringBuilder(i11);
            IntIterator it = new IntRange(1, i11 - charSequence.length()).iterator();
            while (it.hasNext()) {
                it.nextInt();
                sb2.append(c11);
            }
            sb2.append(charSequence);
            return sb2;
        }
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence charSequence, int i11, char c11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            c11 = ' ';
        }
        return padStart(charSequence, i11, c11);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, char[] cArr, int i11, boolean z11, int i12) {
        requireNonNegativeLimit(i12);
        return new DelimitedRangesSequence(charSequence, i11, i12, new StringsKt__StringsKt$rangesDelimitedBy$1(cArr, z11));
    }

    public static final boolean regionMatchesImpl(@NotNull CharSequence charSequence, int i11, @NotNull CharSequence charSequence2, int i12, int i13, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, "other");
        if (i12 < 0 || i11 < 0 || i11 > charSequence.length() - i13 || i12 > charSequence2.length() - i13) {
            return false;
        }
        for (int i14 = 0; i14 < i13; i14++) {
            if (!CharsKt__CharKt.equals(charSequence.charAt(i11 + i14), charSequence2.charAt(i12 + i14), z11)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final CharSequence removePrefix(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        if (startsWith$default(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(charSequence2.length(), charSequence.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @NotNull
    public static CharSequence removeRange(@NotNull CharSequence charSequence, int i11, int i12) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i12 < i11) {
            throw new IndexOutOfBoundsException("End index (" + i12 + ") is less than start index (" + i11 + ").");
        } else if (i12 == i11) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb2 = new StringBuilder(charSequence.length() - (i12 - i11));
            sb2.append(charSequence, 0, i11);
            Intrinsics.checkNotNullExpressionValue(sb2, "this.append(value, startIndex, endIndex)");
            sb2.append(charSequence, i12, charSequence.length());
            Intrinsics.checkNotNullExpressionValue(sb2, "this.append(value, startIndex, endIndex)");
            return sb2;
        }
    }

    @NotNull
    public static final CharSequence removeSuffix(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, "suffix");
        if (endsWith$default(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(0, charSequence.length() - charSequence2.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @NotNull
    public static final CharSequence removeSurrounding(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "suffix");
        if (charSequence.length() < charSequence2.length() + charSequence3.length() || !startsWith$default(charSequence, charSequence2, false, 2, (Object) null) || !endsWith$default(charSequence, charSequence3, false, 2, (Object) null)) {
            return charSequence.subSequence(0, charSequence.length());
        }
        return charSequence.subSequence(charSequence2.length(), charSequence.length() - charSequence3.length());
    }

    @InlineOnly
    private static final String replace(CharSequence charSequence, Regex regex, String str) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(str, "replacement");
        return regex.replace(charSequence, str);
    }

    @NotNull
    public static final String replaceAfter(@NotNull String str, char c11, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "replacement");
        Intrinsics.checkNotNullParameter(str3, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, c11, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str3 : replaceRange((CharSequence) str, indexOf$default + 1, str.length(), (CharSequence) str2).toString();
    }

    public static /* synthetic */ String replaceAfter$default(String str, char c11, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = str;
        }
        return replaceAfter(str, c11, str2, str3);
    }

    @NotNull
    public static final String replaceAfterLast(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, TtmlNode.RUBY_DELIMITER);
        Intrinsics.checkNotNullParameter(str3, "replacement");
        Intrinsics.checkNotNullParameter(str4, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str4 : replaceRange((CharSequence) str, lastIndexOf$default + str2.length(), str.length(), (CharSequence) str3).toString();
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str4 = str;
        }
        return replaceAfterLast(str, str2, str3, str4);
    }

    @NotNull
    public static final String replaceBefore(@NotNull String str, char c11, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "replacement");
        Intrinsics.checkNotNullParameter(str3, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, c11, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str3 : replaceRange((CharSequence) str, 0, indexOf$default, (CharSequence) str2).toString();
    }

    public static /* synthetic */ String replaceBefore$default(String str, char c11, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = str;
        }
        return replaceBefore(str, c11, str2, str3);
    }

    @NotNull
    public static final String replaceBeforeLast(@NotNull String str, char c11, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "replacement");
        Intrinsics.checkNotNullParameter(str3, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, c11, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str3 : replaceRange((CharSequence) str, 0, lastIndexOf$default, (CharSequence) str2).toString();
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, char c11, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = str;
        }
        return replaceBeforeLast(str, c11, str2, str3);
    }

    @InlineOnly
    private static final String replaceFirst(CharSequence charSequence, Regex regex, String str) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(str, "replacement");
        return regex.replaceFirst(charSequence, str);
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "replaceFirstCharWithChar")
    private static final String replaceFirstCharWithChar(String str, Function1<? super Character, Character> function1) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return str;
        }
        char charValue = function1.invoke(Character.valueOf(str.charAt(0))).charValue();
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return charValue + substring;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "replaceFirstCharWithCharSequence")
    private static final String replaceFirstCharWithCharSequence(String str, Function1<? super Character, ? extends CharSequence> function1) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(function1.invoke(Character.valueOf(str.charAt(0))));
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        sb2.append(substring);
        return sb2.toString();
    }

    @NotNull
    public static CharSequence replaceRange(@NotNull CharSequence charSequence, int i11, int i12, @NotNull CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, "replacement");
        if (i12 >= i11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(charSequence, 0, i11);
            Intrinsics.checkNotNullExpressionValue(sb2, "this.append(value, startIndex, endIndex)");
            sb2.append(charSequence2);
            sb2.append(charSequence, i12, charSequence.length());
            Intrinsics.checkNotNullExpressionValue(sb2, "this.append(value, startIndex, endIndex)");
            return sb2;
        }
        throw new IndexOutOfBoundsException("End index (" + i12 + ") is less than start index (" + i11 + ").");
    }

    public static final void requireNonNegativeLimit(int i11) {
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i11).toString());
        }
    }

    @NotNull
    public static final List<String> split(@NotNull CharSequence charSequence, @NotNull String[] strArr, boolean z11, int i11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(strArr, "delimiters");
        boolean z12 = true;
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                z12 = false;
            }
            if (!z12) {
                return split$StringsKt__StringsKt(charSequence, str, z11, i11);
            }
        }
        Iterable<IntRange> asIterable = SequencesKt___SequencesKt.asIterable(c(charSequence, strArr, 0, z11, i11, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(asIterable, 10));
        for (IntRange substring : asIterable) {
            arrayList.add(substring(charSequence, substring));
        }
        return arrayList;
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence charSequence, String str, boolean z11, int i11) {
        boolean z12;
        requireNonNegativeLimit(i11);
        int i12 = 0;
        int indexOf = indexOf(charSequence, str, 0, z11);
        if (indexOf == -1 || i11 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(charSequence.toString());
        }
        if (i11 > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        int i13 = 10;
        if (z12) {
            i13 = RangesKt___RangesKt.coerceAtMost(i11, 10);
        }
        ArrayList arrayList = new ArrayList(i13);
        do {
            arrayList.add(charSequence.subSequence(i12, indexOf).toString());
            i12 = str.length() + indexOf;
            if ((z12 && arrayList.size() == i11 - 1) || (indexOf = indexOf(charSequence, str, i12, z11)) == -1) {
                arrayList.add(charSequence.subSequence(i12, charSequence.length()).toString());
            }
            arrayList.add(charSequence.subSequence(i12, indexOf).toString());
            i12 = str.length() + indexOf;
            break;
        } while ((indexOf = indexOf(charSequence, str, i12, z11)) == -1);
        arrayList.add(charSequence.subSequence(i12, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        return split(charSequence, strArr, z11, i11);
    }

    @NotNull
    public static final Sequence<String> splitToSequence(@NotNull CharSequence charSequence, @NotNull String[] strArr, boolean z11, int i11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(strArr, "delimiters");
        return SequencesKt___SequencesKt.map(c(charSequence, strArr, 0, z11, i11, 2, (Object) null), new StringsKt__StringsKt$splitToSequence$1(charSequence));
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, String[] strArr, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        return splitToSequence(charSequence, strArr, z11, i11);
    }

    public static final boolean startsWith(@NotNull CharSequence charSequence, char c11, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() > 0 && CharsKt__CharKt.equals(charSequence.charAt(0), c11, z11);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c11, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return startsWith(charSequence, c11, z11);
    }

    @NotNull
    public static final CharSequence subSequence(@NotNull CharSequence charSequence, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(intRange, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static String substring(@NotNull String str, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(intRange, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        String substring = str.substring(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final String substringAfter(@NotNull String str, char c11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, c11, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(indexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringAfter$default(String str, char c11, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = str;
        }
        return substringAfter(str, c11, str2);
    }

    @NotNull
    public static String substringAfterLast(@NotNull String str, char c11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, c11, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(lastIndexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c11, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = str;
        }
        return substringAfterLast(str, c11, str2);
    }

    @NotNull
    public static final String substringBefore(@NotNull String str, char c11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, c11, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringBefore$default(String str, char c11, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = str;
        }
        return substringBefore(str, c11, str2);
    }

    @NotNull
    public static final String substringBeforeLast(@NotNull String str, char c11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, c11, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, char c11, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = str;
        }
        return substringBeforeLast(str, c11, str2);
    }

    @SinceKotlin(version = "1.5")
    public static boolean toBooleanStrict(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (Intrinsics.areEqual((Object) str, (Object) "true")) {
            return true;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "false")) {
            return false;
        }
        throw new IllegalArgumentException("The string doesn't represent a boolean value: " + str);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    public static Boolean toBooleanStrictOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (Intrinsics.areEqual((Object) str, (Object) "true")) {
            return Boolean.TRUE;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    @NotNull
    public static final CharSequence trim(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = charSequence.length() - 1;
        int i11 = 0;
        boolean z11 = false;
        while (i11 <= length) {
            boolean booleanValue = function1.invoke(Character.valueOf(charSequence.charAt(!z11 ? i11 : length))).booleanValue();
            if (!z11) {
                if (!booleanValue) {
                    z11 = true;
                } else {
                    i11++;
                }
            } else if (!booleanValue) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i11, length + 1);
    }

    @NotNull
    public static final CharSequence trimEnd(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i11 = length - 1;
            if (!function1.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                return charSequence.subSequence(0, length + 1);
            }
            if (i11 < 0) {
                return "";
            }
            length = i11;
        }
    }

    @NotNull
    public static final CharSequence trimStart(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!function1.invoke(Character.valueOf(charSequence.charAt(i11))).booleanValue()) {
                return charSequence.subSequence(i11, charSequence.length());
            }
        }
        return "";
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c11, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return contains(charSequence, c11, z11);
    }

    public static final boolean endsWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, "suffix");
        if (!z11 && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt__StringsJVMKt.endsWith$default((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return regionMatchesImpl(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z11);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return endsWith(charSequence, charSequence2, z11);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return indexOf(charSequence, str, i11, z11);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, Collection collection, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return indexOfAny(charSequence, (Collection<String>) collection, i11, z11);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = getLastIndex(charSequence);
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return lastIndexOf(charSequence, str, i11, z11);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, Collection collection, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = getLastIndex(charSequence);
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return lastIndexOfAny(charSequence, (Collection<String>) collection, i11, z11);
    }

    public static /* synthetic */ String padEnd$default(String str, int i11, char c11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            c11 = ' ';
        }
        return padEnd(str, i11, c11);
    }

    public static /* synthetic */ String padStart$default(String str, int i11, char c11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            c11 = ' ';
        }
        return padStart(str, i11, c11);
    }

    @InlineOnly
    private static final String replace(CharSequence charSequence, Regex regex, Function1<? super MatchResult, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return regex.replace(charSequence, function1);
    }

    public static /* synthetic */ String replaceAfter$default(String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str4 = str;
        }
        return replaceAfter(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, char c11, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = str;
        }
        return replaceAfterLast(str, c11, str2, str3);
    }

    public static /* synthetic */ String replaceBefore$default(String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str4 = str;
        }
        return replaceBefore(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str4 = str;
        }
        return replaceBeforeLast(str, str2, str3, str4);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        return split(charSequence, cArr, z11, i11);
    }

    @NotNull
    public static final Sequence<String> splitToSequence(@NotNull CharSequence charSequence, @NotNull char[] cArr, boolean z11, int i11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "delimiters");
        return SequencesKt___SequencesKt.map(b(charSequence, cArr, 0, z11, i11, 2, (Object) null), new StringsKt__StringsKt$splitToSequence$2(charSequence));
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, char[] cArr, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        return splitToSequence(charSequence, cArr, z11, i11);
    }

    public static final boolean startsWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        if (!z11 && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt__StringsJVMKt.startsWith$default((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return regionMatchesImpl(charSequence, 0, charSequence2, 0, charSequence2.length(), z11);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return startsWith(charSequence, charSequence2, z11);
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    @InlineOnly
    private static final CharSequence subSequence(String str, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.subSequence(i11, i12);
    }

    @InlineOnly
    private static final String substring(CharSequence charSequence, int i11, int i12) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.subSequence(i11, i12).toString();
    }

    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str3 = str;
        }
        return substringAfter(str, str2, str3);
    }

    public static /* synthetic */ String substringAfterLast$default(String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str3 = str;
        }
        return substringAfterLast(str, str2, str3);
    }

    public static /* synthetic */ String substringBefore$default(String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str3 = str;
        }
        return substringBefore(str, str2, str3);
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str3 = str;
        }
        return substringBeforeLast(str, str2, str3);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, String[] strArr, int i11, boolean z11, int i12) {
        requireNonNegativeLimit(i12);
        return new DelimitedRangesSequence(charSequence, i11, i12, new StringsKt__StringsKt$rangesDelimitedBy$2(ArraysKt___ArraysJvmKt.asList((T[]) strArr), z11));
    }

    @NotNull
    public static final String replaceAfter(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, TtmlNode.RUBY_DELIMITER);
        Intrinsics.checkNotNullParameter(str3, "replacement");
        Intrinsics.checkNotNullParameter(str4, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str4 : replaceRange((CharSequence) str, indexOf$default + str2.length(), str.length(), (CharSequence) str3).toString();
    }

    @NotNull
    public static final String replaceAfterLast(@NotNull String str, char c11, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "replacement");
        Intrinsics.checkNotNullParameter(str3, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, c11, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str3 : replaceRange((CharSequence) str, lastIndexOf$default + 1, str.length(), (CharSequence) str2).toString();
    }

    @NotNull
    public static final String replaceBefore(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, TtmlNode.RUBY_DELIMITER);
        Intrinsics.checkNotNullParameter(str3, "replacement");
        Intrinsics.checkNotNullParameter(str4, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str4 : replaceRange((CharSequence) str, 0, indexOf$default, (CharSequence) str3).toString();
    }

    @NotNull
    public static final String replaceBeforeLast(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, TtmlNode.RUBY_DELIMITER);
        Intrinsics.checkNotNullParameter(str3, "replacement");
        Intrinsics.checkNotNullParameter(str4, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str4 : replaceRange((CharSequence) str, 0, lastIndexOf$default, (CharSequence) str3).toString();
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final Sequence<String> splitToSequence(CharSequence charSequence, Regex regex, int i11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.splitToSequence(charSequence, i11);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return startsWith(charSequence, charSequence2, i11, z11);
    }

    @NotNull
    public static final String substring(@NotNull CharSequence charSequence, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(intRange, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1).toString();
    }

    @NotNull
    public static String substringAfter(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, TtmlNode.RUBY_DELIMITER);
        Intrinsics.checkNotNullParameter(str3, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(indexOf$default + str2.length(), str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static String substringAfterLast(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, TtmlNode.RUBY_DELIMITER);
        Intrinsics.checkNotNullParameter(str3, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(lastIndexOf$default + str2.length(), str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final String substringBefore(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, TtmlNode.RUBY_DELIMITER);
        Intrinsics.checkNotNullParameter(str3, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static String substringBeforeLast(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, TtmlNode.RUBY_DELIMITER);
        Intrinsics.checkNotNullParameter(str3, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean contains(@NotNull CharSequence charSequence, char c11, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return indexOf$default(charSequence, c11, 0, z11, 2, (Object) null) >= 0;
    }

    public static final int indexOf(@NotNull CharSequence charSequence, @NotNull String str, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        if (!z11 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i11);
        }
        return a(charSequence, str, i11, charSequence.length(), z11, false, 16, (Object) null);
    }

    public static final int lastIndexOf(@NotNull CharSequence charSequence, @NotNull String str, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        if (z11 || !(charSequence instanceof String)) {
            return indexOf$StringsKt__StringsKt(charSequence, str, i11, 0, z11, true);
        }
        return ((String) charSequence).lastIndexOf(str, i11);
    }

    @NotNull
    public static String removePrefix(@NotNull String str, @NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "prefix");
        if (!startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @NotNull
    public static String removeSuffix(@NotNull String str, @NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "suffix");
        if (!endsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - charSequence.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final String removeSurrounding(@NotNull String str, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "prefix");
        Intrinsics.checkNotNullParameter(charSequence2, "suffix");
        if (str.length() < charSequence.length() + charSequence2.length() || !startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null) || !endsWith$default((CharSequence) str, charSequence2, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @InlineOnly
    private static final String trim(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return trim((CharSequence) str).toString();
    }

    @InlineOnly
    private static final String trimEnd(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return trimEnd((CharSequence) str).toString();
    }

    @InlineOnly
    private static final String trimStart(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return trimStart((CharSequence) str).toString();
    }

    @InlineOnly
    private static final boolean contains(CharSequence charSequence, Regex regex) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.containsMatchIn(charSequence);
    }

    public static final boolean startsWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        if (!z11 && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt__StringsJVMKt.startsWith$default((String) charSequence, (String) charSequence2, i11, false, 4, (Object) null);
        }
        return regionMatchesImpl(charSequence, i11, charSequence2, 0, charSequence2.length(), z11);
    }

    @NotNull
    public static final String trim(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = str.length() - 1;
        int i11 = 0;
        boolean z11 = false;
        while (i11 <= length) {
            boolean booleanValue = function1.invoke(Character.valueOf(str.charAt(!z11 ? i11 : length))).booleanValue();
            if (!z11) {
                if (!booleanValue) {
                    z11 = true;
                } else {
                    i11++;
                }
            } else if (!booleanValue) {
                break;
            } else {
                length--;
            }
        }
        return str.subSequence(i11, length + 1).toString();
    }

    @NotNull
    public static final String trimEnd(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (!function1.invoke(Character.valueOf(str.charAt(length))).booleanValue()) {
                    obj = str.subSequence(0, length + 1);
                    break;
                } else if (i11 < 0) {
                    break;
                } else {
                    length = i11;
                }
            }
            return obj.toString();
        }
        obj = "";
        return obj.toString();
    }

    @NotNull
    public static final String trimStart(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = str.length();
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                obj = "";
                break;
            } else if (!function1.invoke(Character.valueOf(str.charAt(i11))).booleanValue()) {
                obj = str.subSequence(i11, str.length());
                break;
            } else {
                i11++;
            }
        }
        return obj.toString();
    }

    @InlineOnly
    private static final String removeRange(String str, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return removeRange((CharSequence) str, i11, i12).toString();
    }

    @NotNull
    public static final CharSequence removeSurrounding(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, TtmlNode.RUBY_DELIMITER);
        return removeSurrounding(charSequence, charSequence2, charSequence2);
    }

    @InlineOnly
    private static final String replaceRange(String str, int i11, int i12, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "replacement");
        return replaceRange((CharSequence) str, i11, i12, charSequence).toString();
    }

    @NotNull
    public static final CharSequence removeRange(@NotNull CharSequence charSequence, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(intRange, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        return removeRange(charSequence, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static String removeSurrounding(@NotNull String str, @NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, TtmlNode.RUBY_DELIMITER);
        return removeSurrounding(str, charSequence, charSequence);
    }

    @NotNull
    public static final CharSequence replaceRange(@NotNull CharSequence charSequence, @NotNull IntRange intRange, @NotNull CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(intRange, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        Intrinsics.checkNotNullParameter(charSequence2, "replacement");
        return replaceRange(charSequence, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1, charSequence2);
    }

    public static final int indexOfAny(@NotNull CharSequence charSequence, @NotNull Collection<String> collection, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(collection, "strings");
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, collection, i11, z11, false);
        if (findAnyOf$StringsKt__StringsKt != null) {
            return findAnyOf$StringsKt__StringsKt.getFirst().intValue();
        }
        return -1;
    }

    public static final int lastIndexOfAny(@NotNull CharSequence charSequence, @NotNull Collection<String> collection, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(collection, "strings");
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, collection, i11, z11, true);
        if (findAnyOf$StringsKt__StringsKt != null) {
            return findAnyOf$StringsKt__StringsKt.getFirst().intValue();
        }
        return -1;
    }

    @NotNull
    public static final String padEnd(@NotNull String str, int i11, char c11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return padEnd((CharSequence) str, i11, c11).toString();
    }

    @NotNull
    public static String padStart(@NotNull String str, int i11, char c11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return padStart((CharSequence) str, i11, c11).toString();
    }

    @InlineOnly
    private static final String removeRange(String str, IntRange intRange) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(intRange, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        return removeRange((CharSequence) str, intRange).toString();
    }

    @InlineOnly
    private static final String replaceRange(String str, IntRange intRange, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(intRange, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        Intrinsics.checkNotNullParameter(charSequence, "replacement");
        return replaceRange((CharSequence) str, intRange, charSequence).toString();
    }

    @NotNull
    public static final CharSequence trim(@NotNull CharSequence charSequence, @NotNull char... cArr) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        int length = charSequence.length() - 1;
        int i11 = 0;
        boolean z11 = false;
        while (i11 <= length) {
            boolean contains = ArraysKt___ArraysKt.contains(cArr, charSequence.charAt(!z11 ? i11 : length));
            if (!z11) {
                if (!contains) {
                    z11 = true;
                } else {
                    i11++;
                }
            } else if (!contains) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i11, length + 1);
    }

    @NotNull
    public static final CharSequence trimEnd(@NotNull CharSequence charSequence, @NotNull char... cArr) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (!ArraysKt___ArraysKt.contains(cArr, charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i11 < 0) {
                    break;
                }
                length = i11;
            }
        }
        return "";
    }

    @NotNull
    public static final CharSequence trimStart(@NotNull CharSequence charSequence, @NotNull char... cArr) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!ArraysKt___ArraysKt.contains(cArr, charSequence.charAt(i11))) {
                return charSequence.subSequence(i11, charSequence.length());
            }
        }
        return "";
    }

    @NotNull
    public static final List<String> split(@NotNull CharSequence charSequence, @NotNull char[] cArr, boolean z11, int i11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "delimiters");
        if (cArr.length == 1) {
            return split$StringsKt__StringsKt(charSequence, String.valueOf(cArr[0]), z11, i11);
        }
        Iterable<IntRange> asIterable = SequencesKt___SequencesKt.asIterable(b(charSequence, cArr, 0, z11, i11, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(asIterable, 10));
        for (IntRange substring : asIterable) {
            arrayList.add(substring(charSequence, substring));
        }
        return arrayList;
    }

    @NotNull
    public static final String trim(@NotNull String str, @NotNull char... cArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        int length = str.length() - 1;
        int i11 = 0;
        boolean z11 = false;
        while (i11 <= length) {
            boolean contains = ArraysKt___ArraysKt.contains(cArr, str.charAt(!z11 ? i11 : length));
            if (!z11) {
                if (!contains) {
                    z11 = true;
                } else {
                    i11++;
                }
            } else if (!contains) {
                break;
            } else {
                length--;
            }
        }
        return str.subSequence(i11, length + 1).toString();
    }

    @NotNull
    public static final String trimEnd(@NotNull String str, @NotNull char... cArr) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (!ArraysKt___ArraysKt.contains(cArr, str.charAt(length))) {
                    obj = str.subSequence(0, length + 1);
                    break;
                } else if (i11 < 0) {
                    break;
                } else {
                    length = i11;
                }
            }
            return obj.toString();
        }
        obj = "";
        return obj.toString();
    }

    @NotNull
    public static String trimStart(@NotNull String str, @NotNull char... cArr) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        int length = str.length();
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                obj = "";
                break;
            } else if (!ArraysKt___ArraysKt.contains(cArr, str.charAt(i11))) {
                obj = str.subSequence(i11, str.length());
                break;
            } else {
                i11++;
            }
        }
        return obj.toString();
    }

    @NotNull
    public static CharSequence trim(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i11 = 0;
        boolean z11 = false;
        while (i11 <= length) {
            boolean isWhitespace = CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(!z11 ? i11 : length));
            if (!z11) {
                if (!isWhitespace) {
                    z11 = true;
                } else {
                    i11++;
                }
            } else if (!isWhitespace) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i11, length + 1);
    }

    @NotNull
    public static CharSequence trimEnd(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (!CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i11 < 0) {
                    break;
                }
                length = i11;
            }
        }
        return "";
    }

    @NotNull
    public static CharSequence trimStart(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(i11))) {
                return charSequence.subSequence(i11, charSequence.length());
            }
        }
        return "";
    }

    @InlineOnly
    private static final List<String> split(CharSequence charSequence, Regex regex, int i11) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.split(charSequence, i11);
    }
}
