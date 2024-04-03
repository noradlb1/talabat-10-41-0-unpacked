package androidx.compose.ui.text.android;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RenderNode;
import android.graphics.fonts.Font;
import android.graphics.text.MeasuredText;
import androidx.annotation.RequiresApi;
import com.huawei.hms.flutter.map.constants.Param;
import com.instabug.library.model.session.config.SessionsConfigParameter;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0017\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0017J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000bH\u0017J(\u0010\b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0017J(\u0010\b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J(\u0010\u0015\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J0\u0010\u0015\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J(\u0010\u0015\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0017J(\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0016J0\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0016JH\u0010 \u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0016J\"\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J,\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\n2\u0006\u0010+\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J,\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\n2\u0006\u0010+\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J*\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016JR\u0010'\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&H\u0017JR\u0010'\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&H\u0017JL\u00105\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\u0006\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00112\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010;\u001a\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J(\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020\r2\u0006\u0010?\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u0011H\u0016J\u0018\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020CH\u0017J\u0018\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020DH\u0016J\u0010\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020EH\u0017J\u0018\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020E2\u0006\u0010B\u001a\u00020CH\u0017J@\u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\r2\u0006\u0010L\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0017J0\u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010M\u001a\u0002092\u0006\u0010J\u001a\u00020\u000b2\u0006\u0010N\u001a\u0002092\u0006\u0010%\u001a\u00020&H\u0017J@\u0010O\u001a\u00020\u00172\u0006\u0010P\u001a\u00020-2\u0006\u0010Q\u001a\u00020\u00112\u0006\u0010R\u001a\u0002092\u0006\u0010S\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\u00112\u0006\u0010U\u001a\u00020V2\u0006\u0010%\u001a\u00020&H\u0017J0\u0010W\u001a\u00020\u00172\u0006\u0010X\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\r2\u0006\u0010[\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010\\\u001a\u00020\u00172\u0006\u0010]\u001a\u0002092\u0006\u0010%\u001a\u00020&H\u0016J(\u0010\\\u001a\u00020\u00172\u0006\u0010]\u001a\u0002092\u0006\u0010.\u001a\u00020\u00112\u0006\u0010^\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010_\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&H\u0016J0\u0010_\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010`\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0016J\"\u0010a\u001a\u00020\u00172\u0006\u0010b\u001a\u00020c2\u0006\u0010+\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010&H\u0017J\"\u0010a\u001a\u00020\u00172\u0006\u0010b\u001a\u00020c2\u0006\u0010+\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0017J\u0018\u0010d\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010e\u001a\u00020\u00172\u0006\u0010f\u001a\u00020gH\u0016J\u0018\u0010e\u001a\u00020\u00172\u0006\u0010f\u001a\u00020g2\u0006\u0010+\u001a\u00020\nH\u0016J\u0018\u0010e\u001a\u00020\u00172\u0006\u0010f\u001a\u00020g2\u0006\u0010+\u001a\u00020\u000bH\u0016J \u0010h\u001a\u00020\u00172\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010i\u001a\u00020\u00172\u0006\u0010]\u001a\u0002092\u0006\u0010%\u001a\u00020&H\u0016J*\u0010i\u001a\u00020\u00172\b\u0010]\u001a\u0004\u0018\u0001092\u0006\u0010.\u001a\u00020\u00112\u0006\u0010^\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&H\u0016J0\u0010j\u001a\u00020\u00172\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00112\u0006\u0010^\u001a\u00020\u00112\u0006\u0010n\u001a\u0002092\u0006\u0010%\u001a\u00020&H\u0017J \u0010j\u001a\u00020\u00172\u0006\u0010k\u001a\u00020o2\u0006\u0010n\u001a\u0002092\u0006\u0010%\u001a\u00020&H\u0017J \u0010p\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0016J\u0018\u0010q\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010q\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&H\u0016J0\u0010q\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010r\u001a\u00020\u00172\u0006\u0010s\u001a\u00020tH\u0017J(\u0010u\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u000b2\u0006\u0010v\u001a\u00020\r2\u0006\u0010w\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J@\u0010u\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010v\u001a\u00020\r2\u0006\u0010w\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J8\u0010x\u001a\u00020\u00172\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00112\u0006\u0010^\u001a\u00020\u00112\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J8\u0010x\u001a\u00020\u00172\u0006\u0010k\u001a\u00020y2\u0006\u0010z\u001a\u00020\u00112\u0006\u0010{\u001a\u00020\u00112\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J(\u0010x\u001a\u00020\u00172\u0006\u0010k\u001a\u00020o2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J8\u0010x\u001a\u00020\u00172\u0006\u0010k\u001a\u00020o2\u0006\u0010z\u001a\u00020\u00112\u0006\u0010{\u001a\u00020\u00112\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J@\u0010|\u001a\u00020\u00172\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00112\u0006\u0010^\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010}\u001a\u00020\r2\u0006\u0010~\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016J0\u0010|\u001a\u00020\u00172\u0006\u0010k\u001a\u00020o2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010}\u001a\u00020\r2\u0006\u0010~\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0016JT\u0010\u001a\u00020\u00172\u0007\u0010k\u001a\u00030\u00012\u0006\u0010z\u001a\u00020\u00112\u0006\u0010{\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u00112\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0017JS\u0010\u001a\u00020\u00172\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00112\u0006\u0010^\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u00112\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0017JS\u0010\u001a\u00020\u00172\u0006\u0010k\u001a\u00020y2\u0006\u0010z\u001a\u00020\u00112\u0006\u0010{\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u00112\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0017Jw\u0010\u0001\u001a\u00020\u00172\u0007\u0010B\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00112\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00112\t\u0010\u0001\u001a\u0004\u0018\u0001092\u0007\u0010\u0001\u001a\u00020\u00112\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010;\u001a\u00020\u00112\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&H\u0016J\t\u0010\u0001\u001a\u00020\u0017H\u0017J\u0012\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\nH\u0016J\t\u0010\u0001\u001a\u00020\u0011H\u0016J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020\u0011H\u0016J\u0012\u0010\u0001\u001a\u00020\u00172\u0007\u0010\u0001\u001a\u00020\u0019H\u0017J\t\u0010\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u0001\u001a\u00020\u0005H\u0016J\u0011\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u001b\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0001\u001a\u00030\u0001H\u0017J\u0011\u0010\u0001\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000bH\u0017J\u001b\u0010\u0001\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000b2\b\u0010\u0001\u001a\u00030\u0001H\u0017J)\u0010\u0001\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0017J3\u0010\u0001\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0001\u001a\u00030\u0001H\u0017J\t\u0010 \u0001\u001a\u00020\u0017H\u0016J\u0012\u0010¡\u0001\u001a\u00020\u00172\u0007\u0010¢\u0001\u001a\u00020\u0011H\u0016J\u0012\u0010£\u0001\u001a\u00020\u00172\u0007\u0010¤\u0001\u001a\u00020\rH\u0016J\t\u0010¥\u0001\u001a\u00020\u0011H\u0016J\u001e\u0010¦\u0001\u001a\u00020\u00112\t\u0010\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J'\u0010¦\u0001\u001a\u00020\u00112\t\u0010\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010%\u001a\u0004\u0018\u00010&2\u0007\u0010§\u0001\u001a\u00020\u0011H\u0017J3\u0010¦\u0001\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J<\u0010¦\u0001\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010&2\u0007\u0010§\u0001\u001a\u00020\u0011H\u0017J\u001d\u0010¨\u0001\u001a\u00020\u00112\t\u0010\u0001\u001a\u0004\u0018\u00010\u000b2\u0007\u0010©\u0001\u001a\u00020\u0011H\u0016J&\u0010¨\u0001\u001a\u00020\u00112\t\u0010\u0001\u001a\u0004\u0018\u00010\u000b2\u0007\u0010©\u0001\u001a\u00020\u00112\u0007\u0010§\u0001\u001a\u00020\u0011H\u0017J2\u0010¨\u0001\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0007\u0010©\u0001\u001a\u00020\u0011H\u0016J;\u0010¨\u0001\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0007\u0010©\u0001\u001a\u00020\u00112\u0007\u0010§\u0001\u001a\u00020\u0011H\u0017J\u001b\u0010ª\u0001\u001a\u00020\u00172\u0007\u0010«\u0001\u001a\u00020\r2\u0007\u0010¬\u0001\u001a\u00020\rH\u0016J\u0013\u0010­\u0001\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010®\u0001\u001a\u00020\u00172\u0007\u0010¯\u0001\u001a\u00020\u0001J\u0012\u0010°\u0001\u001a\u00020\u00172\u0007\u0010±\u0001\u001a\u00020\u0011H\u0016J\u0015\u0010²\u0001\u001a\u00020\u00172\n\u0010³\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0013\u0010´\u0001\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001b\u0010µ\u0001\u001a\u00020\u00172\u0007\u0010«\u0001\u001a\u00020\r2\u0007\u0010¬\u0001\u001a\u00020\rH\u0016J\u001b\u0010¶\u0001\u001a\u00020\u00172\u0007\u0010·\u0001\u001a\u00020\r2\u0007\u0010¸\u0001\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X.¢\u0006\u0002\n\u0000¨\u0006¹\u0001"}, d2 = {"Landroidx/compose/ui/text/android/TextAndroidCanvas;", "Landroid/graphics/Canvas;", "()V", "nativeCanvas", "clipOutPath", "", "path", "Landroid/graphics/Path;", "clipOutRect", "rect", "Landroid/graphics/Rect;", "Landroid/graphics/RectF;", "left", "", "top", "right", "bottom", "", "clipPath", "op", "Landroid/graphics/Region$Op;", "clipRect", "concat", "", "matrix", "Landroid/graphics/Matrix;", "disableZ", "drawARGB", "a", "r", "g", "b", "drawArc", "oval", "startAngle", "sweepAngle", "useCenter", "paint", "Landroid/graphics/Paint;", "drawBitmap", "bitmap", "Landroid/graphics/Bitmap;", "src", "dst", "colors", "", "offset", "stride", "x", "y", "width", "height", "hasAlpha", "drawBitmapMesh", "meshWidth", "meshHeight", "verts", "", "vertOffset", "colorOffset", "drawCircle", "cx", "cy", "radius", "drawColor", "color", "mode", "Landroid/graphics/BlendMode;", "Landroid/graphics/PorterDuff$Mode;", "", "drawDoubleRoundRect", "outer", "outerRx", "outerRy", "inner", "innerRx", "innerRy", "outerRadii", "innerRadii", "drawGlyphs", "glyphIds", "glyphIdOffset", "positions", "positionOffset", "glyphCount", "font", "Landroid/graphics/fonts/Font;", "drawLine", "startX", "startY", "stopX", "stopY", "drawLines", "pts", "count", "drawOval", "drawPaint", "drawPatch", "patch", "Landroid/graphics/NinePatch;", "drawPath", "drawPicture", "picture", "Landroid/graphics/Picture;", "drawPoint", "drawPoints", "drawPosText", "text", "", "index", "pos", "", "drawRGB", "drawRect", "drawRenderNode", "renderNode", "Landroid/graphics/RenderNode;", "drawRoundRect", "rx", "ry", "drawText", "", "start", "end", "drawTextOnPath", "hOffset", "vOffset", "drawTextRun", "Landroid/graphics/text/MeasuredText;", "contextStart", "contextEnd", "isRtl", "contextIndex", "contextCount", "drawVertices", "Landroid/graphics/Canvas$VertexMode;", "vertexCount", "texs", "texOffset", "indices", "", "indexOffset", "indexCount", "enableZ", "getClipBounds", "bounds", "getDensity", "getDrawFilter", "Landroid/graphics/DrawFilter;", "getHeight", "getMatrix", "ctm", "getMaximumBitmapHeight", "getMaximumBitmapWidth", "getSaveCount", "getWidth", "isOpaque", "quickReject", "type", "Landroid/graphics/Canvas$EdgeType;", "restore", "restoreToCount", "saveCount", "rotate", "degrees", "save", "saveLayer", "saveFlags", "saveLayerAlpha", "alpha", "scale", "sx", "sy", "setBitmap", "setCanvas", "canvas", "setDensity", "density", "setDrawFilter", "filter", "setMatrix", "skew", "translate", "dx", "dy", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"ClassVerificationFailure"})
public final class TextAndroidCanvas extends Canvas {
    private Canvas nativeCanvas;

    @RequiresApi(26)
    public boolean clipOutPath(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipOutPath(path);
    }

    @RequiresApi(26)
    public boolean clipOutRect(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "rect");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipOutRect(rectF);
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean clipPath(@NotNull Path path, @NotNull Region.Op op2) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(op2, "op");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipPath(path, op2);
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean clipRect(@NotNull RectF rectF, @NotNull Region.Op op2) {
        Intrinsics.checkNotNullParameter(rectF, "rect");
        Intrinsics.checkNotNullParameter(op2, "op");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(rectF, op2);
    }

    public void concat(@Nullable Matrix matrix) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.concat(matrix);
    }

    @RequiresApi(29)
    public void disableZ() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.disableZ();
    }

    public void drawARGB(int i11, int i12, int i13, int i14) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawARGB(i11, i12, i13, i14);
    }

    public void drawArc(@NotNull RectF rectF, float f11, float f12, boolean z11, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(rectF, "oval");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawArc(rectF, f11, f12, z11, paint);
    }

    public void drawBitmap(@NotNull Bitmap bitmap, float f11, float f12, @Nullable Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmap(bitmap, f11, f12, paint);
    }

    public void drawBitmapMesh(@NotNull Bitmap bitmap, int i11, int i12, @NotNull float[] fArr, int i13, @Nullable int[] iArr, int i14, @Nullable Paint paint) {
        Bitmap bitmap2 = bitmap;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        float[] fArr2 = fArr;
        Intrinsics.checkNotNullParameter(fArr, "verts");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmapMesh(bitmap, i11, i12, fArr, i13, iArr, i14, paint);
    }

    public void drawCircle(float f11, float f12, float f13, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawCircle(f11, f12, f13, paint);
    }

    public void drawColor(int i11) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawColor(i11);
    }

    @RequiresApi(29)
    public void drawDoubleRoundRect(@NotNull RectF rectF, float f11, float f12, @NotNull RectF rectF2, float f13, float f14, @NotNull Paint paint) {
        RectF rectF3 = rectF;
        Intrinsics.checkNotNullParameter(rectF, "outer");
        RectF rectF4 = rectF2;
        Intrinsics.checkNotNullParameter(rectF2, "inner");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawDoubleRoundRect(rectF, f11, f12, rectF2, f13, f14, paint);
    }

    @RequiresApi(31)
    public void drawGlyphs(@NotNull int[] iArr, int i11, @NotNull float[] fArr, int i12, int i13, @NotNull Font font, @NotNull Paint paint) {
        int[] iArr2 = iArr;
        Intrinsics.checkNotNullParameter(iArr, "glyphIds");
        float[] fArr2 = fArr;
        Intrinsics.checkNotNullParameter(fArr, "positions");
        Font font2 = font;
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawGlyphs(iArr, i11, fArr, i12, i13, font, paint);
    }

    public void drawLine(float f11, float f12, float f13, float f14, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawLine(f11, f12, f13, f14, paint);
    }

    public void drawLines(@NotNull float[] fArr, int i11, int i12, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(fArr, "pts");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawLines(fArr, i11, i12, paint);
    }

    public void drawOval(@NotNull RectF rectF, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(rectF, "oval");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawOval(rectF, paint);
    }

    public void drawPaint(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPaint(paint);
    }

    @RequiresApi(31)
    public void drawPatch(@NotNull NinePatch ninePatch, @NotNull Rect rect, @Nullable Paint paint) {
        Intrinsics.checkNotNullParameter(ninePatch, "patch");
        Intrinsics.checkNotNullParameter(rect, "dst");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPatch(ninePatch, rect, paint);
    }

    public void drawPath(@NotNull Path path, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPath(path, paint);
    }

    public void drawPicture(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPicture(picture);
    }

    public void drawPoint(float f11, float f12, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPoint(f11, f12, paint);
    }

    public void drawPoints(@Nullable float[] fArr, int i11, int i12, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPoints(fArr, i11, i12, paint);
    }

    @Deprecated(message = "Deprecated in Java")
    public void drawPosText(@NotNull char[] cArr, int i11, int i12, @NotNull float[] fArr, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(cArr, "text");
        Intrinsics.checkNotNullParameter(fArr, "pos");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPosText(cArr, i11, i12, fArr, paint);
    }

    public void drawRGB(int i11, int i12, int i13) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawRGB(i11, i12, i13);
    }

    public void drawRect(@NotNull RectF rectF, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(rectF, "rect");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawRect(rectF, paint);
    }

    @RequiresApi(29)
    public void drawRenderNode(@NotNull RenderNode renderNode) {
        Intrinsics.checkNotNullParameter(renderNode, "renderNode");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawRenderNode(renderNode);
    }

    public void drawRoundRect(@NotNull RectF rectF, float f11, float f12, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(rectF, "rect");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawRoundRect(rectF, f11, f12, paint);
    }

    public void drawText(@NotNull char[] cArr, int i11, int i12, float f11, float f12, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(cArr, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawText(cArr, i11, i12, f11, f12, paint);
    }

    public void drawTextOnPath(@NotNull char[] cArr, int i11, int i12, @NotNull Path path, float f11, float f12, @NotNull Paint paint) {
        char[] cArr2 = cArr;
        Intrinsics.checkNotNullParameter(cArr, "text");
        Path path2 = path;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawTextOnPath(cArr, i11, i12, path, f11, f12, paint);
    }

    @RequiresApi(23)
    public void drawTextRun(@NotNull char[] cArr, int i11, int i12, int i13, int i14, float f11, float f12, boolean z11, @NotNull Paint paint) {
        char[] cArr2 = cArr;
        Intrinsics.checkNotNullParameter(cArr, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawTextRun(cArr, i11, i12, i13, i14, f11, f12, z11, paint);
    }

    public void drawVertices(@NotNull Canvas.VertexMode vertexMode, int i11, @NotNull float[] fArr, int i12, @Nullable float[] fArr2, int i13, @Nullable int[] iArr, int i14, @Nullable short[] sArr, int i15, int i16, @NotNull Paint paint) {
        Canvas.VertexMode vertexMode2 = vertexMode;
        Intrinsics.checkNotNullParameter(vertexMode, SessionsConfigParameter.SYNC_MODE);
        Intrinsics.checkNotNullParameter(fArr, "verts");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawVertices(vertexMode, i11, fArr, i12, fArr2, i13, iArr, i14, sArr, i15, i16, paint);
    }

    @RequiresApi(29)
    public void enableZ() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.enableZ();
    }

    public boolean getClipBounds(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, Param.BOUNDS);
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        boolean clipBounds = canvas.getClipBounds(rect);
        if (clipBounds) {
            rect.set(0, 0, rect.width(), Integer.MAX_VALUE);
        }
        return clipBounds;
    }

    public int getDensity() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.getDensity();
    }

    @Nullable
    public DrawFilter getDrawFilter() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.getDrawFilter();
    }

    public int getHeight() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.getHeight();
    }

    @Deprecated(message = "Deprecated in Java")
    public void getMatrix(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "ctm");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.getMatrix(matrix);
    }

    public int getMaximumBitmapHeight() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.getMaximumBitmapHeight();
    }

    public int getMaximumBitmapWidth() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.getMaximumBitmapWidth();
    }

    public int getSaveCount() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.getSaveCount();
    }

    public int getWidth() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.getWidth();
    }

    public boolean isOpaque() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.isOpaque();
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean quickReject(@NotNull RectF rectF, @NotNull Canvas.EdgeType edgeType) {
        Intrinsics.checkNotNullParameter(rectF, "rect");
        Intrinsics.checkNotNullParameter(edgeType, "type");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.quickReject(rectF, edgeType);
    }

    public void restore() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.restore();
    }

    public void restoreToCount(int i11) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.restoreToCount(i11);
    }

    public void rotate(float f11) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.rotate(f11);
    }

    public int save() {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.save();
    }

    @Deprecated(message = "Deprecated in Java")
    public int saveLayer(@Nullable RectF rectF, @Nullable Paint paint, int i11) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayer(rectF, paint, i11);
    }

    @Deprecated(message = "Deprecated in Java")
    public int saveLayerAlpha(@Nullable RectF rectF, int i11, int i12) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayerAlpha(rectF, i11, i12);
    }

    public void scale(float f11, float f12) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.scale(f11, f12);
    }

    public void setBitmap(@Nullable Bitmap bitmap) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.setBitmap(bitmap);
    }

    public final void setCanvas(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.nativeCanvas = canvas;
    }

    public void setDensity(int i11) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.setDensity(i11);
    }

    public void setDrawFilter(@Nullable DrawFilter drawFilter) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.setDrawFilter(drawFilter);
    }

    public void setMatrix(@Nullable Matrix matrix) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.setMatrix(matrix);
    }

    public void skew(float f11, float f12) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.skew(f11, f12);
    }

    public void translate(float f11, float f12) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.translate(f11, f12);
    }

    @RequiresApi(26)
    public boolean clipOutRect(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipOutRect(rect);
    }

    public boolean clipPath(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipPath(path);
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean clipRect(@NotNull Rect rect, @NotNull Region.Op op2) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(op2, "op");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(rect, op2);
    }

    public void drawArc(float f11, float f12, float f13, float f14, float f15, float f16, boolean z11, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawArc(f11, f12, f13, f14, f15, f16, z11, paint);
    }

    public void drawBitmap(@NotNull Bitmap bitmap, @Nullable Rect rect, @NotNull RectF rectF, @Nullable Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(rectF, "dst");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmap(bitmap, rect, rectF, paint);
    }

    @RequiresApi(29)
    public void drawColor(long j11) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawColor(j11);
    }

    @RequiresApi(29)
    public void drawDoubleRoundRect(@NotNull RectF rectF, @NotNull float[] fArr, @NotNull RectF rectF2, @NotNull float[] fArr2, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(rectF, "outer");
        Intrinsics.checkNotNullParameter(fArr, "outerRadii");
        Intrinsics.checkNotNullParameter(rectF2, "inner");
        Intrinsics.checkNotNullParameter(fArr2, "innerRadii");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawDoubleRoundRect(rectF, fArr, rectF2, fArr2, paint);
    }

    public void drawLines(@NotNull float[] fArr, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(fArr, "pts");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawLines(fArr, paint);
    }

    public void drawOval(float f11, float f12, float f13, float f14, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawOval(f11, f12, f13, f14, paint);
    }

    @RequiresApi(31)
    public void drawPatch(@NotNull NinePatch ninePatch, @NotNull RectF rectF, @Nullable Paint paint) {
        Intrinsics.checkNotNullParameter(ninePatch, "patch");
        Intrinsics.checkNotNullParameter(rectF, "dst");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPatch(ninePatch, rectF, paint);
    }

    public void drawPicture(@NotNull Picture picture, @NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        Intrinsics.checkNotNullParameter(rectF, "dst");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPicture(picture, rectF);
    }

    public void drawPoints(@NotNull float[] fArr, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(fArr, "pts");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPoints(fArr, paint);
    }

    @Deprecated(message = "Deprecated in Java")
    public void drawPosText(@NotNull String str, @NotNull float[] fArr, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(fArr, "pos");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPosText(str, fArr, paint);
    }

    public void drawRect(@NotNull Rect rect, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(rect, "r");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawRect(rect, paint);
    }

    public void drawRoundRect(float f11, float f12, float f13, float f14, float f15, float f16, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawRoundRect(f11, f12, f13, f14, f15, f16, paint);
    }

    public void drawText(@NotNull String str, float f11, float f12, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawText(str, f11, f12, paint);
    }

    public void drawTextOnPath(@NotNull String str, @NotNull Path path, float f11, float f12, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawTextOnPath(str, path, f11, f12, paint);
    }

    @RequiresApi(23)
    public void drawTextRun(@NotNull CharSequence charSequence, int i11, int i12, int i13, int i14, float f11, float f12, boolean z11, @NotNull Paint paint) {
        CharSequence charSequence2 = charSequence;
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawTextRun(charSequence, i11, i12, i13, i14, f11, f12, z11, paint);
    }

    @RequiresApi(30)
    public boolean quickReject(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "rect");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.quickReject(rectF);
    }

    public int saveLayer(@Nullable RectF rectF, @Nullable Paint paint) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayer(rectF, paint);
    }

    public int saveLayerAlpha(@Nullable RectF rectF, int i11) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayerAlpha(rectF, i11);
    }

    @RequiresApi(26)
    public boolean clipOutRect(float f11, float f12, float f13, float f14) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipOutRect(f11, f12, f13, f14);
    }

    public boolean clipRect(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "rect");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(rectF);
    }

    public void drawBitmap(@NotNull Bitmap bitmap, @Nullable Rect rect, @NotNull Rect rect2, @Nullable Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(rect2, "dst");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmap(bitmap, rect, rect2, paint);
    }

    public void drawColor(int i11, @NotNull PorterDuff.Mode mode) {
        Intrinsics.checkNotNullParameter(mode, SessionsConfigParameter.SYNC_MODE);
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawColor(i11, mode);
    }

    public void drawPicture(@NotNull Picture picture, @NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        Intrinsics.checkNotNullParameter(rect, "dst");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawPicture(picture, rect);
    }

    public void drawRect(float f11, float f12, float f13, float f14, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawRect(f11, f12, f13, f14, paint);
    }

    public void drawText(@NotNull String str, int i11, int i12, float f11, float f12, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawText(str, i11, i12, f11, f12, paint);
    }

    @RequiresApi(29)
    public void drawTextRun(@NotNull MeasuredText measuredText, int i11, int i12, int i13, int i14, float f11, float f12, boolean z11, @NotNull Paint paint) {
        MeasuredText measuredText2 = measuredText;
        Intrinsics.checkNotNullParameter(measuredText, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawTextRun(measuredText, i11, i12, i13, i14, f11, f12, z11, paint);
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean quickReject(@NotNull Path path, @NotNull Canvas.EdgeType edgeType) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(edgeType, "type");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.quickReject(path, edgeType);
    }

    @Deprecated(message = "Deprecated in Java")
    public int saveLayer(float f11, float f12, float f13, float f14, @Nullable Paint paint, int i11) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayer(f11, f12, f13, f14, paint, i11);
    }

    @Deprecated(message = "Deprecated in Java")
    public int saveLayerAlpha(float f11, float f12, float f13, float f14, int i11, int i12) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayerAlpha(f11, f12, f13, f14, i11, i12);
    }

    @RequiresApi(26)
    public boolean clipOutRect(int i11, int i12, int i13, int i14) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipOutRect(i11, i12, i13, i14);
    }

    public boolean clipRect(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(rect);
    }

    @Deprecated(message = "Deprecated in Java")
    public void drawBitmap(@NotNull int[] iArr, int i11, int i12, float f11, float f12, int i13, int i14, boolean z11, @Nullable Paint paint) {
        int[] iArr2 = iArr;
        Intrinsics.checkNotNullParameter(iArr, "colors");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmap(iArr, i11, i12, f11, f12, i13, i14, z11, paint);
    }

    @RequiresApi(29)
    public void drawColor(int i11, @NotNull BlendMode blendMode) {
        Intrinsics.checkNotNullParameter(blendMode, SessionsConfigParameter.SYNC_MODE);
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawColor(i11, blendMode);
    }

    public void drawText(@NotNull CharSequence charSequence, int i11, int i12, float f11, float f12, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawText(charSequence, i11, i12, f11, f12, paint);
    }

    @RequiresApi(30)
    public boolean quickReject(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.quickReject(path);
    }

    public int saveLayer(float f11, float f12, float f13, float f14, @Nullable Paint paint) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayer(f11, f12, f13, f14, paint);
    }

    public int saveLayerAlpha(float f11, float f12, float f13, float f14, int i11) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.saveLayerAlpha(f11, f12, f13, f14, i11);
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean clipRect(float f11, float f12, float f13, float f14, @NotNull Region.Op op2) {
        Intrinsics.checkNotNullParameter(op2, "op");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(f11, f12, f13, f14, op2);
    }

    @Deprecated(message = "Deprecated in Java")
    public void drawBitmap(@NotNull int[] iArr, int i11, int i12, int i13, int i14, int i15, int i16, boolean z11, @Nullable Paint paint) {
        int[] iArr2 = iArr;
        Intrinsics.checkNotNullParameter(iArr, "colors");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmap(iArr, i11, i12, i13, i14, i15, i16, z11, paint);
    }

    @RequiresApi(29)
    public void drawColor(long j11, @NotNull BlendMode blendMode) {
        Intrinsics.checkNotNullParameter(blendMode, SessionsConfigParameter.SYNC_MODE);
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawColor(j11, blendMode);
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean quickReject(float f11, float f12, float f13, float f14, @NotNull Canvas.EdgeType edgeType) {
        Intrinsics.checkNotNullParameter(edgeType, "type");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.quickReject(f11, f12, f13, f14, edgeType);
    }

    public boolean clipRect(float f11, float f12, float f13, float f14) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(f11, f12, f13, f14);
    }

    public void drawBitmap(@NotNull Bitmap bitmap, @NotNull Matrix matrix, @Nullable Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        canvas.drawBitmap(bitmap, matrix, paint);
    }

    @RequiresApi(30)
    public boolean quickReject(float f11, float f12, float f13, float f14) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.quickReject(f11, f12, f13, f14);
    }

    public boolean clipRect(int i11, int i12, int i13, int i14) {
        Canvas canvas = this.nativeCanvas;
        if (canvas == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            canvas = null;
        }
        return canvas.clipRect(i11, i12, i13, i14);
    }
}
