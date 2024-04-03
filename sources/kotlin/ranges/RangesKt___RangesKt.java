package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.ranges.CharProgression;
import kotlin.ranges.IntProgression;
import kotlin.ranges.LongProgression;
import net.bytebuddy.asm.Advice;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001e\u001a'\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006\u001a\u0012\u0010\u0000\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007\u001a\u0012\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\b\u001a\u0012\u0010\u0000\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\t\u001a\u0012\u0010\u0000\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\n\u001a'\u0010\u000b\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\f\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u000b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005\u001a\u0012\u0010\u000b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006\u001a\u0012\u0010\u000b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\b2\u0006\u0010\f\u001a\u00020\b\u001a\u0012\u0010\u000b\u001a\u00020\t*\u00020\t2\u0006\u0010\f\u001a\u00020\t\u001a\u0012\u0010\u000b\u001a\u00020\n*\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a3\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00012\b\u0010\f\u001a\u0004\u0018\u0001H\u0001¢\u0006\u0002\u0010\u000e\u001a/\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a-\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0012¢\u0006\u0002\u0010\u0013\u001a\u001a\u0010\r\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005\u001a\u001a\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006\u001a\u001a\u0010\r\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u001a\u001a\u0010\r\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b\u001a\u0018\u0010\r\u001a\u00020\b*\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0012\u001a\u001a\u0010\r\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t\u001a\u0018\u0010\r\u001a\u00020\t*\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0012\u001a\u001a\u0010\r\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\n¢\u0006\u0002\u0010\u0019\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0002\b \u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\u0005H\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020!2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\n¢\u0006\u0002\u0010\"\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\tH\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\nH\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\u0005H\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\bH\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020#2\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\n¢\u0006\u0002\u0010$\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\nH\n\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0002\b \u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\bH\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0004\u001a\u0015\u0010&\u001a\u00020**\u00020\u00182\u0006\u0010(\u001a\u00020\u0018H\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\b2\u0006\u0010(\u001a\u00020\u0005H\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\b2\u0006\u0010(\u001a\u00020\tH\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\b2\u0006\u0010(\u001a\u00020\nH\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\u0005H\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\bH\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\nH\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\u0005H\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\bH\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\n2\u0006\u0010(\u001a\u00020\tH\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0004\u001a\f\u0010+\u001a\u00020\u0018*\u00020*H\u0007\u001a\f\u0010+\u001a\u00020\b*\u00020'H\u0007\u001a\f\u0010+\u001a\u00020\t*\u00020)H\u0007\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\u0018*\u00020*H\u0007¢\u0006\u0002\u0010-\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\b*\u00020'H\u0007¢\u0006\u0002\u0010.\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\t*\u00020)H\u0007¢\u0006\u0002\u0010/\u001a\f\u00100\u001a\u00020\u0018*\u00020*H\u0007\u001a\f\u00100\u001a\u00020\b*\u00020'H\u0007\u001a\f\u00100\u001a\u00020\t*\u00020)H\u0007\u001a\u0013\u00101\u001a\u0004\u0018\u00010\u0018*\u00020*H\u0007¢\u0006\u0002\u0010-\u001a\u0013\u00101\u001a\u0004\u0018\u00010\b*\u00020'H\u0007¢\u0006\u0002\u0010.\u001a\u0013\u00101\u001a\u0004\u0018\u00010\t*\u00020)H\u0007¢\u0006\u0002\u0010/\u001a\r\u00102\u001a\u00020\u0018*\u00020\u0016H\b\u001a\u0014\u00102\u001a\u00020\u0018*\u00020\u00162\u0006\u00102\u001a\u000203H\u0007\u001a\r\u00102\u001a\u00020\b*\u00020!H\b\u001a\u0014\u00102\u001a\u00020\b*\u00020!2\u0006\u00102\u001a\u000203H\u0007\u001a\r\u00102\u001a\u00020\t*\u00020#H\b\u001a\u0014\u00102\u001a\u00020\t*\u00020#2\u0006\u00102\u001a\u000203H\u0007\u001a\u0014\u00104\u001a\u0004\u0018\u00010\u0018*\u00020\u0016H\b¢\u0006\u0002\u00105\u001a\u001b\u00104\u001a\u0004\u0018\u00010\u0018*\u00020\u00162\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00106\u001a\u0014\u00104\u001a\u0004\u0018\u00010\b*\u00020!H\b¢\u0006\u0002\u00107\u001a\u001b\u00104\u001a\u0004\u0018\u00010\b*\u00020!2\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00108\u001a\u0014\u00104\u001a\u0004\u0018\u00010\t*\u00020#H\b¢\u0006\u0002\u00109\u001a\u001b\u00104\u001a\u0004\u0018\u00010\t*\u00020#2\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u0010:\u001a\u0015\u0010;\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\bH\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\u00052\u0006\u0010(\u001a\u00020\tH\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\nH\n\u001a\u0015\u0010;\u001a\u00020\u0016*\u00020\u00182\u0006\u0010(\u001a\u00020\u0018H\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\u0005H\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\bH\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\b2\u0006\u0010(\u001a\u00020\tH\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\nH\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\u0005H\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\bH\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\tH\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\nH\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\u0005H\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\bH\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\n2\u0006\u0010(\u001a\u00020\tH\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\nH\n\u001a\n\u0010<\u001a\u00020**\u00020*\u001a\n\u0010<\u001a\u00020'*\u00020'\u001a\n\u0010<\u001a\u00020)*\u00020)\u001a\u0015\u0010=\u001a\u00020**\u00020*2\u0006\u0010=\u001a\u00020\bH\u0004\u001a\u0015\u0010=\u001a\u00020'*\u00020'2\u0006\u0010=\u001a\u00020\bH\u0004\u001a\u0015\u0010=\u001a\u00020)*\u00020)2\u0006\u0010=\u001a\u00020\tH\u0004\u001a\u0013\u0010>\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0000¢\u0006\u0002\u0010?\u001a\u0013\u0010>\u001a\u0004\u0018\u00010\u0005*\u00020\u0007H\u0000¢\u0006\u0002\u0010@\u001a\u0013\u0010>\u001a\u0004\u0018\u00010\u0005*\u00020\bH\u0000¢\u0006\u0002\u0010A\u001a\u0013\u0010>\u001a\u0004\u0018\u00010\u0005*\u00020\tH\u0000¢\u0006\u0002\u0010B\u001a\u0013\u0010>\u001a\u0004\u0018\u00010\u0005*\u00020\nH\u0000¢\u0006\u0002\u0010C\u001a\u0013\u0010D\u001a\u0004\u0018\u00010\b*\u00020\u0006H\u0000¢\u0006\u0002\u0010E\u001a\u0013\u0010D\u001a\u0004\u0018\u00010\b*\u00020\u0007H\u0000¢\u0006\u0002\u0010F\u001a\u0013\u0010D\u001a\u0004\u0018\u00010\b*\u00020\tH\u0000¢\u0006\u0002\u0010G\u001a\u0013\u0010H\u001a\u0004\u0018\u00010\t*\u00020\u0006H\u0000¢\u0006\u0002\u0010I\u001a\u0013\u0010H\u001a\u0004\u0018\u00010\t*\u00020\u0007H\u0000¢\u0006\u0002\u0010J\u001a\u0013\u0010K\u001a\u0004\u0018\u00010\n*\u00020\u0006H\u0000¢\u0006\u0002\u0010L\u001a\u0013\u0010K\u001a\u0004\u0018\u00010\n*\u00020\u0007H\u0000¢\u0006\u0002\u0010M\u001a\u0013\u0010K\u001a\u0004\u0018\u00010\n*\u00020\bH\u0000¢\u0006\u0002\u0010N\u001a\u0013\u0010K\u001a\u0004\u0018\u00010\n*\u00020\tH\u0000¢\u0006\u0002\u0010O\u001a\u0015\u0010P\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\bH\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0004\u001a\u0015\u0010P\u001a\u00020\u0016*\u00020\u00182\u0006\u0010(\u001a\u00020\u0018H\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\u0005H\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\b2\u0006\u0010(\u001a\u00020\tH\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\nH\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\u0005H\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\bH\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\nH\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\u0005H\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\bH\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\n2\u0006\u0010(\u001a\u00020\tH\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0004¨\u0006Q"}, d2 = {"coerceAtLeast", "T", "", "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "contains", "", "Lkotlin/ranges/CharRange;", "element", "", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "value", "byteRangeContains", "doubleRangeContains", "floatRangeContains", "intRangeContains", "longRangeContains", "shortRangeContains", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "Lkotlin/ranges/OpenEndRange;", "downTo", "Lkotlin/ranges/IntProgression;", "to", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/CharProgression;", "first", "firstOrNull", "(Lkotlin/ranges/CharProgression;)Ljava/lang/Character;", "(Lkotlin/ranges/IntProgression;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongProgression;)Ljava/lang/Long;", "last", "lastOrNull", "random", "Lkotlin/random/Random;", "randomOrNull", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "rangeUntil", "reversed", "step", "toByteExactOrNull", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "toIntExactOrNull", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "(J)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "until", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/ranges/RangesKt")
class RangesKt___RangesKt extends RangesKt__RangesKt {
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "byteRangeContains")
    public static final /* synthetic */ boolean byteRangeContains(ClosedRange closedRange, double d11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(d11);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final byte coerceAtLeast(byte b11, byte b12) {
        return b11 < b12 ? b12 : b11;
    }

    public static double coerceAtLeast(double d11, double d12) {
        return d11 < d12 ? d12 : d11;
    }

    public static float coerceAtLeast(float f11, float f12) {
        return f11 < f12 ? f12 : f11;
    }

    public static int coerceAtLeast(int i11, int i12) {
        return i11 < i12 ? i12 : i11;
    }

    public static long coerceAtLeast(long j11, long j12) {
        return j11 < j12 ? j12 : j11;
    }

    @NotNull
    public static <T extends Comparable<? super T>> T coerceAtLeast(@NotNull T t11, @NotNull T t12) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(t12, "minimumValue");
        if (t11.compareTo(t12) < 0) {
            return t12;
        }
        return t11;
    }

    public static final short coerceAtLeast(short s11, short s12) {
        return s11 < s12 ? s12 : s11;
    }

    public static final byte coerceAtMost(byte b11, byte b12) {
        return b11 > b12 ? b12 : b11;
    }

    public static double coerceAtMost(double d11, double d12) {
        return d11 > d12 ? d12 : d11;
    }

    public static float coerceAtMost(float f11, float f12) {
        return f11 > f12 ? f12 : f11;
    }

    public static int coerceAtMost(int i11, int i12) {
        return i11 > i12 ? i12 : i11;
    }

    public static long coerceAtMost(long j11, long j12) {
        return j11 > j12 ? j12 : j11;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T coerceAtMost(@NotNull T t11, @NotNull T t12) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(t12, "maximumValue");
        if (t11.compareTo(t12) > 0) {
            return t12;
        }
        return t11;
    }

    public static final short coerceAtMost(short s11, short s12) {
        return s11 > s12 ? s12 : s11;
    }

    @NotNull
    public static <T extends Comparable<? super T>> T coerceIn(@NotNull T t11, @Nullable T t12, @Nullable T t13) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        if (t12 == null || t13 == null) {
            if (t12 == null || t11.compareTo(t12) >= 0) {
                return (t13 == null || t11.compareTo(t13) <= 0) ? t11 : t13;
            }
            return t12;
        } else if (t12.compareTo(t13) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t13 + " is less than minimum " + t12 + '.');
        } else if (t11.compareTo(t12) < 0) {
            return t12;
        } else {
            if (t11.compareTo(t13) > 0) {
                return t13;
            }
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(IntRange intRange, Integer num) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return num != null && intRange.contains(num.intValue());
    }

    @NotNull
    public static final IntProgression downTo(int i11, byte b11) {
        return IntProgression.Companion.fromClosedRange(i11, b11, -1);
    }

    @SinceKotlin(version = "1.7")
    public static final int first(@NotNull IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        if (!intProgression.isEmpty()) {
            return intProgression.getFirst();
        }
        throw new NoSuchElementException("Progression " + intProgression + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Integer firstOrNull(@NotNull IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        if (intProgression.isEmpty()) {
            return null;
        }
        return Integer.valueOf(intProgression.getFirst());
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@NotNull ClosedRange<Integer> closedRange, byte b11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Integer.valueOf(b11));
    }

    @SinceKotlin(version = "1.7")
    public static final int last(@NotNull IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        if (!intProgression.isEmpty()) {
            return intProgression.getLast();
        }
        throw new NoSuchElementException("Progression " + intProgression + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Integer lastOrNull(@NotNull IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        if (intProgression.isEmpty()) {
            return null;
        }
        return Integer.valueOf(intProgression.getLast());
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@NotNull ClosedRange<Long> closedRange, byte b11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Long.valueOf((long) b11));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int random(IntRange intRange) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return random(intRange, (Random) Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final Integer randomOrNull(IntRange intRange) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return randomOrNull(intRange, (Random) Random.Default);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(int i11, byte b11) {
        return until(i11, b11);
    }

    @NotNull
    public static IntProgression reversed(@NotNull IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        return IntProgression.Companion.fromClosedRange(intProgression.getLast(), intProgression.getFirst(), -intProgression.getStep());
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@NotNull ClosedRange<Short> closedRange, byte b11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Short.valueOf((short) b11));
    }

    @NotNull
    public static IntProgression step(@NotNull IntProgression intProgression, int i11) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(i11 > 0, Integer.valueOf(i11));
        IntProgression.Companion companion = IntProgression.Companion;
        int first = intProgression.getFirst();
        int last = intProgression.getLast();
        if (intProgression.getStep() <= 0) {
            i11 = -i11;
        }
        return companion.fromClosedRange(first, last, i11);
    }

    @Nullable
    public static final Byte toByteExactOrNull(int i11) {
        if (new IntRange(-128, 127).contains(i11)) {
            return Byte.valueOf((byte) i11);
        }
        return null;
    }

    @Nullable
    public static final Integer toIntExactOrNull(long j11) {
        if (new LongRange(-2147483648L, 2147483647L).contains(j11)) {
            return Integer.valueOf((int) j11);
        }
        return null;
    }

    @Nullable
    public static final Long toLongExactOrNull(double d11) {
        boolean z11 = false;
        if (-9.223372036854776E18d <= d11 && d11 <= 9.223372036854776E18d) {
            z11 = true;
        }
        if (z11) {
            return Long.valueOf((long) d11);
        }
        return null;
    }

    @Nullable
    public static final Short toShortExactOrNull(int i11) {
        if (new IntRange(-32768, Advice.MethodSizeHandler.UNDEFINED_SIZE).contains(i11)) {
            return Short.valueOf((short) i11);
        }
        return null;
    }

    @NotNull
    public static final IntRange until(int i11, byte b11) {
        return new IntRange(i11, b11 - 1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "byteRangeContains")
    public static final /* synthetic */ boolean byteRangeContains(ClosedRange closedRange, float f11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(f11);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(LongRange longRange, Long l11) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return l11 != null && longRange.contains(l11.longValue());
    }

    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(@NotNull ClosedRange<Double> closedRange, float f11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Double.valueOf((double) f11));
    }

    @NotNull
    public static final LongProgression downTo(long j11, byte b11) {
        return LongProgression.Companion.fromClosedRange(j11, (long) b11, -1);
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Long firstOrNull(@NotNull LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        if (longProgression.isEmpty()) {
            return null;
        }
        return Long.valueOf(longProgression.getFirst());
    }

    @JvmName(name = "floatRangeContains")
    public static final boolean floatRangeContains(@NotNull ClosedRange<Float> closedRange, double d11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Float.valueOf((float) d11));
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@NotNull OpenEndRange<Integer> openEndRange, byte b11) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Integer.valueOf(b11));
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Long lastOrNull(@NotNull LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        if (longProgression.isEmpty()) {
            return null;
        }
        return Long.valueOf(longProgression.getLast());
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@NotNull OpenEndRange<Long> openEndRange, byte b11) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Long.valueOf((long) b11));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final long random(LongRange longRange) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return random(longRange, (Random) Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final Long randomOrNull(LongRange longRange) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return randomOrNull(longRange, (Random) Random.Default);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(long j11, byte b11) {
        return until(j11, b11);
    }

    @NotNull
    public static final LongProgression reversed(@NotNull LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        return LongProgression.Companion.fromClosedRange(longProgression.getLast(), longProgression.getFirst(), -longProgression.getStep());
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@NotNull OpenEndRange<Short> openEndRange, byte b11) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Short.valueOf((short) b11));
    }

    @Nullable
    public static final Byte toByteExactOrNull(long j11) {
        if (new LongRange(-128, 127).contains(j11)) {
            return Byte.valueOf((byte) ((int) j11));
        }
        return null;
    }

    @Nullable
    public static final Integer toIntExactOrNull(double d11) {
        boolean z11 = false;
        if (-2.147483648E9d <= d11 && d11 <= 2.147483647E9d) {
            z11 = true;
        }
        if (z11) {
            return Integer.valueOf((int) d11);
        }
        return null;
    }

    @Nullable
    public static final Long toLongExactOrNull(float f11) {
        boolean z11 = false;
        if (-9.223372E18f <= f11 && f11 <= 9.223372E18f) {
            z11 = true;
        }
        if (z11) {
            return Long.valueOf((long) f11);
        }
        return null;
    }

    @Nullable
    public static final Short toShortExactOrNull(long j11) {
        if (new LongRange(-32768, 32767).contains(j11)) {
            return Short.valueOf((short) ((int) j11));
        }
        return null;
    }

    @NotNull
    public static final LongRange until(long j11, byte b11) {
        return new LongRange(j11, ((long) b11) - 1);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> closedRange, int i11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(i11);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(CharRange charRange, Character ch2) {
        Intrinsics.checkNotNullParameter(charRange, "<this>");
        return ch2 != null && charRange.contains(ch2.charValue());
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(@NotNull OpenEndRange<Double> openEndRange, float f11) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Double.valueOf((double) f11));
    }

    @NotNull
    public static final IntProgression downTo(byte b11, byte b12) {
        return IntProgression.Companion.fromClosedRange(b11, b12, -1);
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Character firstOrNull(@NotNull CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, "<this>");
        if (charProgression.isEmpty()) {
            return null;
        }
        return Character.valueOf(charProgression.getFirst());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "intRangeContains")
    public static final /* synthetic */ boolean intRangeContains(ClosedRange closedRange, double d11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Integer intExactOrNull = toIntExactOrNull(d11);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Character lastOrNull(@NotNull CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, "<this>");
        if (charProgression.isEmpty()) {
            return null;
        }
        return Character.valueOf(charProgression.getLast());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "longRangeContains")
    public static final /* synthetic */ boolean longRangeContains(ClosedRange closedRange, double d11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Long longExactOrNull = toLongExactOrNull(d11);
        if (longExactOrNull != null) {
            return closedRange.contains(longExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final char random(CharRange charRange) {
        Intrinsics.checkNotNullParameter(charRange, "<this>");
        return random(charRange, (Random) Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final Character randomOrNull(CharRange charRange) {
        Intrinsics.checkNotNullParameter(charRange, "<this>");
        return randomOrNull(charRange, (Random) Random.Default);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(byte b11, byte b12) {
        return until(b11, b12);
    }

    @NotNull
    public static final CharProgression reversed(@NotNull CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, "<this>");
        return CharProgression.Companion.fromClosedRange(charProgression.getLast(), charProgression.getFirst(), -charProgression.getStep());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "shortRangeContains")
    public static final /* synthetic */ boolean shortRangeContains(ClosedRange closedRange, double d11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Short shortExactOrNull = toShortExactOrNull(d11);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @NotNull
    public static final LongProgression step(@NotNull LongProgression longProgression, long j11) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(j11 > 0, Long.valueOf(j11));
        LongProgression.Companion companion = LongProgression.Companion;
        long first = longProgression.getFirst();
        long last = longProgression.getLast();
        if (longProgression.getStep() <= 0) {
            j11 = -j11;
        }
        return companion.fromClosedRange(first, last, j11);
    }

    @Nullable
    public static final Byte toByteExactOrNull(short s11) {
        if (intRangeContains((ClosedRange<Integer>) new IntRange(-128, 127), s11)) {
            return Byte.valueOf((byte) s11);
        }
        return null;
    }

    @Nullable
    public static final Integer toIntExactOrNull(float f11) {
        boolean z11 = false;
        if (-2.14748365E9f <= f11 && f11 <= 2.14748365E9f) {
            z11 = true;
        }
        if (z11) {
            return Integer.valueOf((int) f11);
        }
        return null;
    }

    @Nullable
    public static final Short toShortExactOrNull(double d11) {
        boolean z11 = false;
        if (-32768.0d <= d11 && d11 <= 32767.0d) {
            z11 = true;
        }
        if (z11) {
            return Short.valueOf((short) ((int) d11));
        }
        return null;
    }

    @NotNull
    public static final IntRange until(byte b11, byte b12) {
        return new IntRange(b11, b12 - 1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@NotNull OpenEndRange<Byte> openEndRange, int i11) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(i11);
        if (byteExactOrNull != null) {
            return openEndRange.contains(byteExactOrNull);
        }
        return false;
    }

    @InlineOnly
    private static final boolean contains(IntRange intRange, byte b11) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return intRangeContains((ClosedRange<Integer>) intRange, b11);
    }

    @NotNull
    public static final IntProgression downTo(short s11, byte b11) {
        return IntProgression.Companion.fromClosedRange(s11, b11, -1);
    }

    @SinceKotlin(version = "1.7")
    public static final long first(@NotNull LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        if (!longProgression.isEmpty()) {
            return longProgression.getFirst();
        }
        throw new NoSuchElementException("Progression " + longProgression + " is empty.");
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "intRangeContains")
    public static final /* synthetic */ boolean intRangeContains(ClosedRange closedRange, float f11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Integer intExactOrNull = toIntExactOrNull(f11);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.7")
    public static final long last(@NotNull LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        if (!longProgression.isEmpty()) {
            return longProgression.getLast();
        }
        throw new NoSuchElementException("Progression " + longProgression + " is empty.");
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "longRangeContains")
    public static final /* synthetic */ boolean longRangeContains(ClosedRange closedRange, float f11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Long longExactOrNull = toLongExactOrNull(f11);
        if (longExactOrNull != null) {
            return closedRange.contains(longExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.3")
    public static int random(@NotNull IntRange intRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return RandomKt.nextInt(random, intRange);
        } catch (IllegalArgumentException e11) {
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Integer randomOrNull(@NotNull IntRange intRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (intRange.isEmpty()) {
            return null;
        }
        return Integer.valueOf(RandomKt.nextInt(random, intRange));
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(short s11, byte b11) {
        return until(s11, b11);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "shortRangeContains")
    public static final /* synthetic */ boolean shortRangeContains(ClosedRange closedRange, float f11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Short shortExactOrNull = toShortExactOrNull(f11);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @Nullable
    public static final Byte toByteExactOrNull(double d11) {
        boolean z11 = false;
        if (-128.0d <= d11 && d11 <= 127.0d) {
            z11 = true;
        }
        if (z11) {
            return Byte.valueOf((byte) ((int) d11));
        }
        return null;
    }

    @Nullable
    public static final Short toShortExactOrNull(float f11) {
        boolean z11 = false;
        if (-32768.0f <= f11 && f11 <= 32767.0f) {
            z11 = true;
        }
        if (z11) {
            return Short.valueOf((short) ((int) f11));
        }
        return null;
    }

    @NotNull
    public static final IntRange until(short s11, byte b11) {
        return new IntRange(s11, b11 - 1);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> closedRange, long j11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(j11);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @InlineOnly
    private static final boolean contains(LongRange longRange, byte b11) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return longRangeContains((ClosedRange<Long>) longRange, b11);
    }

    @NotNull
    public static final CharProgression downTo(char c11, char c12) {
        return CharProgression.Companion.fromClosedRange(c11, c12, -1);
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@NotNull ClosedRange<Integer> closedRange, long j11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Integer intExactOrNull = toIntExactOrNull(j11);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@NotNull ClosedRange<Long> closedRange, int i11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Long.valueOf((long) i11));
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final CharRange rangeUntil(char c11, char c12) {
        return until(c11, c12);
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@NotNull ClosedRange<Short> closedRange, int i11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Short shortExactOrNull = toShortExactOrNull(i11);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @NotNull
    public static final CharProgression step(@NotNull CharProgression charProgression, int i11) {
        Intrinsics.checkNotNullParameter(charProgression, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(i11 > 0, Integer.valueOf(i11));
        CharProgression.Companion companion = CharProgression.Companion;
        char first = charProgression.getFirst();
        char last = charProgression.getLast();
        if (charProgression.getStep() <= 0) {
            i11 = -i11;
        }
        return companion.fromClosedRange(first, last, i11);
    }

    @Nullable
    public static final Byte toByteExactOrNull(float f11) {
        boolean z11 = false;
        if (-128.0f <= f11 && f11 <= 127.0f) {
            z11 = true;
        }
        if (z11) {
            return Byte.valueOf((byte) ((int) f11));
        }
        return null;
    }

    @NotNull
    public static final CharRange until(char c11, char c12) {
        if (Intrinsics.compare((int) c12, 0) <= 0) {
            return CharRange.Companion.getEMPTY();
        }
        return new CharRange(c11, (char) (c12 - 1));
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@NotNull OpenEndRange<Byte> openEndRange, long j11) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(j11);
        if (byteExactOrNull != null) {
            return openEndRange.contains(byteExactOrNull);
        }
        return false;
    }

    @InlineOnly
    private static final boolean contains(LongRange longRange, int i11) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return longRangeContains((ClosedRange<Long>) longRange, i11);
    }

    @NotNull
    public static IntProgression downTo(int i11, int i12) {
        return IntProgression.Companion.fromClosedRange(i11, i12, -1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@NotNull OpenEndRange<Integer> openEndRange, long j11) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Integer intExactOrNull = toIntExactOrNull(j11);
        if (intExactOrNull != null) {
            return openEndRange.contains(intExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@NotNull OpenEndRange<Long> openEndRange, int i11) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Long.valueOf((long) i11));
    }

    @SinceKotlin(version = "1.3")
    public static final long random(@NotNull LongRange longRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return RandomKt.nextLong(random, longRange);
        } catch (IllegalArgumentException e11) {
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Long randomOrNull(@NotNull LongRange longRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (longRange.isEmpty()) {
            return null;
        }
        return Long.valueOf(RandomKt.nextLong(random, longRange));
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(int i11, int i12) {
        return until(i11, i12);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@NotNull OpenEndRange<Short> openEndRange, int i11) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Short shortExactOrNull = toShortExactOrNull(i11);
        if (shortExactOrNull != null) {
            return openEndRange.contains(shortExactOrNull);
        }
        return false;
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> closedRange, short s11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(s11);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final byte coerceIn(byte b11, byte b12, byte b13) {
        if (b12 > b13) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + b13 + " is less than minimum " + b12 + '.');
        } else if (b11 < b12) {
            return b12;
        } else {
            return b11 > b13 ? b13 : b11;
        }
    }

    @InlineOnly
    private static final boolean contains(IntRange intRange, long j11) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return intRangeContains((ClosedRange<Integer>) intRange, j11);
    }

    @NotNull
    public static final LongProgression downTo(long j11, int i11) {
        return LongProgression.Companion.fromClosedRange(j11, (long) i11, -1);
    }

    @SinceKotlin(version = "1.7")
    public static final char first(@NotNull CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, "<this>");
        if (!charProgression.isEmpty()) {
            return charProgression.getFirst();
        }
        throw new NoSuchElementException("Progression " + charProgression + " is empty.");
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@NotNull ClosedRange<Integer> closedRange, short s11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Integer.valueOf(s11));
    }

    @SinceKotlin(version = "1.7")
    public static final char last(@NotNull CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, "<this>");
        if (!charProgression.isEmpty()) {
            return charProgression.getLast();
        }
        throw new NoSuchElementException("Progression " + charProgression + " is empty.");
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@NotNull ClosedRange<Long> closedRange, short s11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Long.valueOf((long) s11));
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(long j11, int i11) {
        return until(j11, i11);
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@NotNull ClosedRange<Short> closedRange, long j11) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Short shortExactOrNull = toShortExactOrNull(j11);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @NotNull
    public static IntRange until(int i11, int i12) {
        if (i12 <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        return new IntRange(i11, i12 - 1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@NotNull OpenEndRange<Byte> openEndRange, short s11) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(s11);
        if (byteExactOrNull != null) {
            return openEndRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final short coerceIn(short s11, short s12, short s13) {
        if (s12 > s13) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + s13 + " is less than minimum " + s12 + '.');
        } else if (s11 < s12) {
            return s12;
        } else {
            return s11 > s13 ? s13 : s11;
        }
    }

    @InlineOnly
    private static final boolean contains(IntRange intRange, short s11) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return intRangeContains((ClosedRange<Integer>) intRange, s11);
    }

    @NotNull
    public static final IntProgression downTo(byte b11, int i11) {
        return IntProgression.Companion.fromClosedRange(b11, i11, -1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@NotNull OpenEndRange<Integer> openEndRange, short s11) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Integer.valueOf(s11));
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@NotNull OpenEndRange<Long> openEndRange, short s11) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Long.valueOf((long) s11));
    }

    @SinceKotlin(version = "1.3")
    public static final char random(@NotNull CharRange charRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(charRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return (char) random.nextInt(charRange.getFirst(), charRange.getLast() + 1);
        } catch (IllegalArgumentException e11) {
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Character randomOrNull(@NotNull CharRange charRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(charRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (charRange.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) random.nextInt(charRange.getFirst(), charRange.getLast() + 1));
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(byte b11, int i11) {
        return until(b11, i11);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@NotNull OpenEndRange<Short> openEndRange, long j11) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Short shortExactOrNull = toShortExactOrNull(j11);
        if (shortExactOrNull != null) {
            return openEndRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static int coerceIn(int i11, int i12, int i13) {
        if (i12 > i13) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i13 + " is less than minimum " + i12 + '.');
        } else if (i11 < i12) {
            return i12;
        } else {
            return i11 > i13 ? i13 : i11;
        }
    }

    @InlineOnly
    private static final boolean contains(LongRange longRange, short s11) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return longRangeContains((ClosedRange<Long>) longRange, s11);
    }

    @NotNull
    public static final IntProgression downTo(short s11, int i11) {
        return IntProgression.Companion.fromClosedRange(s11, i11, -1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(short s11, int i11) {
        return until(s11, i11);
    }

    @NotNull
    public static final LongRange until(long j11, int i11) {
        return new LongRange(j11, ((long) i11) - 1);
    }

    public static long coerceIn(long j11, long j12, long j13) {
        if (j12 > j13) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j13 + " is less than minimum " + j12 + '.');
        } else if (j11 < j12) {
            return j12;
        } else {
            return j11 > j13 ? j13 : j11;
        }
    }

    @NotNull
    public static final LongProgression downTo(int i11, long j11) {
        return LongProgression.Companion.fromClosedRange((long) i11, j11, -1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(int i11, long j11) {
        return until(i11, j11);
    }

    @NotNull
    public static final IntRange until(byte b11, int i11) {
        if (i11 <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        return new IntRange(b11, i11 - 1);
    }

    public static float coerceIn(float f11, float f12, float f13) {
        if (f12 > f13) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f13 + " is less than minimum " + f12 + '.');
        } else if (f11 < f12) {
            return f12;
        } else {
            return f11 > f13 ? f13 : f11;
        }
    }

    @NotNull
    public static final LongProgression downTo(long j11, long j12) {
        return LongProgression.Companion.fromClosedRange(j11, j12, -1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(long j11, long j12) {
        return until(j11, j12);
    }

    public static double coerceIn(double d11, double d12, double d13) {
        if (d12 > d13) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d13 + " is less than minimum " + d12 + '.');
        } else if (d11 < d12) {
            return d12;
        } else {
            return d11 > d13 ? d13 : d11;
        }
    }

    @NotNull
    public static final LongProgression downTo(byte b11, long j11) {
        return LongProgression.Companion.fromClosedRange((long) b11, j11, -1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(byte b11, long j11) {
        return until(b11, j11);
    }

    @NotNull
    public static final IntRange until(short s11, int i11) {
        if (i11 <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        return new IntRange(s11, i11 - 1);
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static <T extends Comparable<? super T>> T coerceIn(@NotNull T t11, @NotNull ClosedFloatingPointRange<T> closedFloatingPointRange) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        if (closedFloatingPointRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedFloatingPointRange + '.');
        } else if (!closedFloatingPointRange.lessThanOrEquals(t11, closedFloatingPointRange.getStart()) || closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getStart(), t11)) {
            return (!closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getEndInclusive(), t11) || closedFloatingPointRange.lessThanOrEquals(t11, closedFloatingPointRange.getEndInclusive())) ? t11 : closedFloatingPointRange.getEndInclusive();
        } else {
            return closedFloatingPointRange.getStart();
        }
    }

    @NotNull
    public static final LongProgression downTo(short s11, long j11) {
        return LongProgression.Companion.fromClosedRange((long) s11, j11, -1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(short s11, long j11) {
        return until(s11, j11);
    }

    @NotNull
    public static final IntProgression downTo(int i11, short s11) {
        return IntProgression.Companion.fromClosedRange(i11, s11, -1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(int i11, short s11) {
        return until(i11, s11);
    }

    @NotNull
    public static final LongRange until(int i11, long j11) {
        if (j11 <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange((long) i11, j11 - 1);
    }

    @NotNull
    public static final LongProgression downTo(long j11, short s11) {
        return LongProgression.Companion.fromClosedRange(j11, (long) s11, -1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(long j11, short s11) {
        return until(j11, s11);
    }

    @NotNull
    public static final IntProgression downTo(byte b11, short s11) {
        return IntProgression.Companion.fromClosedRange(b11, s11, -1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(byte b11, short s11) {
        return until(b11, s11);
    }

    @NotNull
    public static final LongRange until(long j11, long j12) {
        if (j12 <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange(j11, j12 - 1);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T coerceIn(@NotNull T t11, @NotNull ClosedRange<T> closedRange) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(closedRange, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        if (closedRange instanceof ClosedFloatingPointRange) {
            return coerceIn(t11, (ClosedFloatingPointRange) closedRange);
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + '.');
        } else if (t11.compareTo(closedRange.getStart()) < 0) {
            return closedRange.getStart();
        } else {
            return t11.compareTo(closedRange.getEndInclusive()) > 0 ? closedRange.getEndInclusive() : t11;
        }
    }

    @NotNull
    public static final IntProgression downTo(short s11, short s12) {
        return IntProgression.Companion.fromClosedRange(s11, s12, -1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(short s11, short s12) {
        return until(s11, s12);
    }

    @NotNull
    public static final LongRange until(byte b11, long j11) {
        if (j11 <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange((long) b11, j11 - 1);
    }

    @NotNull
    public static final LongRange until(short s11, long j11) {
        if (j11 <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange((long) s11, j11 - 1);
    }

    @NotNull
    public static final IntRange until(int i11, short s11) {
        return new IntRange(i11, s11 - 1);
    }

    public static int coerceIn(int i11, @NotNull ClosedRange<Integer> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((Number) coerceIn(Integer.valueOf(i11), (ClosedFloatingPointRange) closedRange)).intValue();
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + '.');
        } else if (i11 < closedRange.getStart().intValue()) {
            return closedRange.getStart().intValue();
        } else {
            return i11 > closedRange.getEndInclusive().intValue() ? closedRange.getEndInclusive().intValue() : i11;
        }
    }

    @NotNull
    public static final LongRange until(long j11, short s11) {
        return new LongRange(j11, ((long) s11) - 1);
    }

    @NotNull
    public static final IntRange until(byte b11, short s11) {
        return new IntRange(b11, s11 - 1);
    }

    @NotNull
    public static final IntRange until(short s11, short s12) {
        return new IntRange(s11, s12 - 1);
    }

    public static long coerceIn(long j11, @NotNull ClosedRange<Long> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, BasketDeliveryFeeTiersInfoKeys.KEY_RANGE);
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((Number) coerceIn(Long.valueOf(j11), (ClosedFloatingPointRange) closedRange)).longValue();
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + '.');
        } else if (j11 < closedRange.getStart().longValue()) {
            return closedRange.getStart().longValue();
        } else {
            return j11 > closedRange.getEndInclusive().longValue() ? closedRange.getEndInclusive().longValue() : j11;
        }
    }
}
