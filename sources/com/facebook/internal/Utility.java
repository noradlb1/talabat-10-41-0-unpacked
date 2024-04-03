package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.webkit.ProxyConfig;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.framework.common.ContainerUtils;
import com.newrelic.agent.android.agentdata.HexAttribute;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import datamodels.TypesAliasesKt;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import v6.q;
import v6.r;

@Instrumented
@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002ß\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u00042\u0006\u0010@\u001a\u00020AH\u0002J \u0010B\u001a\u00020;2\u0006\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020>2\u0006\u0010@\u001a\u00020AH\u0002J'\u0010C\u001a\u00020*\"\u0004\b\u0000\u0010D2\b\u0010E\u001a\u0004\u0018\u0001HD2\b\u0010F\u001a\u0004\u0018\u0001HDH\u0007¢\u0006\u0002\u0010GJ\u0012\u0010H\u001a\u0004\u0018\u00010\"2\u0006\u0010I\u001a\u00020\u0004H\u0007J&\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u00042\b\u0010M\u001a\u0004\u0018\u00010\u00042\b\u0010N\u001a\u0004\u0018\u00010OH\u0007J\u0018\u0010P\u001a\u00020;2\u0006\u0010@\u001a\u00020A2\u0006\u0010Q\u001a\u00020\u0004H\u0002J\u0010\u0010R\u001a\u00020;2\u0006\u0010@\u001a\u00020AH\u0007J\u0012\u0010S\u001a\u00020;2\b\u0010T\u001a\u0004\u0018\u00010UH\u0007J\u001e\u0010V\u001a\u0004\u0018\u00010\u00042\b\u0010W\u001a\u0004\u0018\u00010\u00042\b\u0010X\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010Y\u001a\u00020\u00132\u0006\u0010Z\u001a\u00020[H\u0002J\u0016\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00040]2\u0006\u0010^\u001a\u00020_H\u0007J\u001c\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010a2\u0006\u0010b\u001a\u00020\"H\u0007J\u001c\u0010c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040a2\u0006\u0010b\u001a\u00020\"H\u0007J\u001a\u0010d\u001a\u00020\u00062\b\u0010e\u001a\u0004\u0018\u00010f2\u0006\u0010g\u001a\u00020hH\u0007J\u0012\u0010i\u001a\u00020;2\b\u0010j\u001a\u0004\u0018\u00010kH\u0007J\b\u0010l\u001a\u00020*H\u0002J\u0010\u0010m\u001a\u00020\u00042\u0006\u0010n\u001a\u00020\u0006H\u0007J\u0012\u0010o\u001a\u00020\u00042\b\u0010@\u001a\u0004\u0018\u00010AH\u0007J\u0010\u0010p\u001a\u00020\u00042\u0006\u0010@\u001a\u00020AH\u0007J\n\u0010q\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010r\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010O2\b\u0010u\u001a\u0004\u0018\u00010\u00042\u0006\u0010v\u001a\u00020sH\u0007J\u0010\u0010w\u001a\u00020\u00132\u0006\u0010x\u001a\u00020KH\u0007J\n\u0010y\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010z\u001a\u00020\u00042\b\u0010{\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010|\u001a\u00020}2\u0006\u0010I\u001a\u00020\u0004H\u0002J\u0019\u0010~\u001a\u00020;2\u0006\u0010I\u001a\u00020\u00042\u0007\u0010\u001a\u00030\u0001H\u0007J\u0013\u0010\u0001\u001a\u00020\u00042\b\u0010@\u001a\u0004\u0018\u00010AH\u0007JM\u0010\u0001\u001a\u0005\u0018\u00010\u00012\f\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00042\"\u0010\u0001\u001a\u0012\u0012\r\b\u0001\u0012\t\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001\"\t\u0012\u0002\b\u0003\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010\u0001JH\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u00042\"\u0010\u0001\u001a\u0012\u0012\r\b\u0001\u0012\t\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001\"\t\u0012\u0002\b\u0003\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010\u0001J\u0014\u0010\u0001\u001a\u00020\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J(\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010b\u001a\u00020\"2\b\u0010u\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010KH\u0007J\u001c\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010Z\u001a\u00030\u0001H\u0002J\u001d\u0010\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0001\u001a\u00020\u00042\u0007\u0010Z\u001a\u00030\u0001H\u0002J\u001c\u0010\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0001\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0004H\u0002J@\u0010\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\u0018\u0010\u0001\u001a\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0001\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0001\u001a\u00020*2\u0006\u0010@\u001a\u00020AH\u0007J\u0011\u0010\u0001\u001a\u00020*2\u0006\u0010@\u001a\u00020AH\u0007J\u0014\u0010\u0001\u001a\u00020*2\t\u0010\u0001\u001a\u0004\u0018\u00010KH\u0007J\u0015\u0010 \u0001\u001a\u00020*2\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u0001H\u0007J\u0014\u0010£\u0001\u001a\u00020*2\t\u0010\u0001\u001a\u0004\u0018\u00010KH\u0007J\u0011\u0010¤\u0001\u001a\u00020*2\u0006\u0010@\u001a\u00020AH\u0002J\u0013\u0010¥\u0001\u001a\u00020*2\b\u0010W\u001a\u0004\u0018\u00010\u0004H\u0007J\u0019\u0010¥\u0001\u001a\u00020*2\u000e\u0010¦\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010§\u0001H\u0007J\u0014\u0010¨\u0001\u001a\u00020*2\t\u0010\u0001\u001a\u0004\u0018\u00010KH\u0007J\u0018\u0010©\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040ª\u00012\u0006\u0010^\u001a\u00020_H\u0007J\u0017\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040]2\u0006\u0010^\u001a\u00020_H\u0007J\u001e\u0010¬\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040a2\u0007\u0010­\u0001\u001a\u00020\u0004H\u0007J'\u0010®\u0001\u001a\u00020;2\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u00042\u0011\u0010°\u0001\u001a\f\u0018\u00010±\u0001j\u0005\u0018\u0001`²\u0001H\u0007J\u001f\u0010®\u0001\u001a\u00020;2\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010³\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J+\u0010®\u0001\u001a\u00020;2\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010³\u0001\u001a\u0004\u0018\u00010\u00042\n\u0010´\u0001\u001a\u0005\u0018\u00010µ\u0001H\u0007J\"\u0010¶\u0001\u001a\u00020\u00042\u0017\u0010·\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040aH\u0007J\u0013\u0010¸\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010u\u001a\u00020\u0004H\u0007J\u0011\u0010¹\u0001\u001a\u00020*2\u0006\u0010@\u001a\u00020AH\u0007J\u0014\u0010º\u0001\u001a\u00020O2\t\u0010»\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J.\u0010¼\u0001\u001a\u00020;2\u0006\u0010F\u001a\u00020O2\b\u0010u\u001a\u0004\u0018\u00010\u00042\u0011\u0010½\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010]H\u0007J&\u0010¾\u0001\u001a\u00020*2\u0006\u0010t\u001a\u00020O2\b\u0010u\u001a\u0004\u0018\u00010\u00042\t\u0010¿\u0001\u001a\u0004\u0018\u00010\u0001H\u0007J&\u0010À\u0001\u001a\u00020;2\u0006\u0010F\u001a\u00020O2\b\u0010u\u001a\u0004\u0018\u00010\u00042\t\u0010¿\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010Á\u0001\u001a\u00020;2\u0006\u0010F\u001a\u00020O2\b\u0010u\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010KH\u0007J!\u0010Â\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010a2\b\u0010Ã\u0001\u001a\u00030Ä\u0001H\u0007J\u0013\u0010Å\u0001\u001a\u00020\u00042\b\u0010e\u001a\u0004\u0018\u00010fH\u0007J%\u0010Æ\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010a2\b\u0010Ã\u0001\u001a\u00030Ä\u0001H\u0007J\t\u0010Ç\u0001\u001a\u00020;H\u0002J\t\u0010È\u0001\u001a\u00020\u0006H\u0002J\u0012\u0010É\u0001\u001a\u00020;2\u0007\u0010Ê\u0001\u001a\u00020AH\u0002J\u0012\u0010Ë\u0001\u001a\u00020;2\u0007\u0010Ê\u0001\u001a\u00020AH\u0002J\t\u0010Ì\u0001\u001a\u00020;H\u0002J\t\u0010Í\u0001\u001a\u00020;H\u0002J\u0015\u0010Î\u0001\u001a\u00020;2\n\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u0001H\u0007J\u001f\u0010Ñ\u0001\u001a\u00020\u00042\t\u0010Ò\u0001\u001a\u0004\u0018\u00010\"2\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J6\u0010Ô\u0001\u001a\u00020;2\u0006\u0010<\u001a\u00020\"2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u00010\u00042\u0007\u0010Õ\u0001\u001a\u00020*2\u0006\u0010@\u001a\u00020AH\u0007J\u001a\u0010Ö\u0001\u001a\u00020;2\u0006\u0010<\u001a\u00020\"2\u0007\u0010Ê\u0001\u001a\u00020AH\u0007J\u0014\u0010×\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010Z\u001a\u00030\u0001H\u0007J\u0013\u0010×\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010u\u001a\u00020\u0004H\u0007J\u0016\u0010Ø\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010Z\u001a\u0005\u0018\u00010\u0001H\u0007J\u0015\u0010Ø\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010u\u001a\u0004\u0018\u00010\u0004H\u0007J\u001d\u0010Ù\u0001\u001a\u00020*2\b\u0010E\u001a\u0004\u0018\u00010\u00042\b\u0010F\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010Ú\u0001\u001a\u0004\u0018\u00010_2\t\u0010Ò\u0001\u001a\u0004\u0018\u00010\"2\t\u0010Û\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010Ü\u0001\u001a\u0004\u0018\u00010\"2\t\u0010Ò\u0001\u001a\u0004\u0018\u00010\"2\t\u0010Û\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J*\u0010Ý\u0001\u001a\u00020;2\b\u0010Ã\u0001\u001a\u00030Ä\u00012\u0015\u0010·\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010aH\u0007J.\u0010Þ\u0001\u001a\u00020;2\b\u0010Ã\u0001\u001a\u00030Ä\u00012\u0019\u0010·\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u0004\u0018\u00010\"8G¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR\u000e\u0010(\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020*8FX\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0002\u001a\u0004\b)\u0010,R\u0011\u0010-\u001a\u00020*8G¢\u0006\u0006\u001a\u0004\b-\u0010,R\u001c\u0010.\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0013\u00103\u001a\u0004\u0018\u00010\u001e8G¢\u0006\u0006\u001a\u0004\b4\u0010 R\u000e\u00105\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001a\"\u0004\b9\u0010\u001c¨\u0006à\u0001"}, d2 = {"Lcom/facebook/internal/Utility;", "", "()V", "ARC_DEVICE_PATTERN", "", "DEFAULT_STREAM_BUFFER_SIZE", "", "EXTRA_APP_EVENTS_INFO_FORMAT_VERSION", "FACEBOOK_PROFILE_FIELDS", "HASH_ALGORITHM_MD5", "HASH_ALGORITHM_SHA1", "HASH_ALGORITHM_SHA256", "INSTAGRAM_PROFILE_FIELDS", "LOG_TAG", "NO_CARRIER", "REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS", "URL_SCHEME", "UTF8", "availableExternalStorageGB", "", "getAvailableExternalStorageGB", "()J", "setAvailableExternalStorageGB", "(J)V", "carrierName", "getCarrierName", "()Ljava/lang/String;", "setCarrierName", "(Ljava/lang/String;)V", "currentLocale", "Ljava/util/Locale;", "getCurrentLocale", "()Ljava/util/Locale;", "dataProcessingOptions", "Lorg/json/JSONObject;", "getDataProcessingOptions", "()Lorg/json/JSONObject;", "deviceTimeZoneName", "getDeviceTimeZoneName", "setDeviceTimeZoneName", "deviceTimezoneAbbreviation", "isAutoAppLinkSetup", "", "isAutoAppLinkSetup$annotations", "()Z", "isDataProcessingRestricted", "locale", "getLocale", "setLocale", "(Ljava/util/Locale;)V", "numCPUCores", "resourceLocale", "getResourceLocale", "timestampOfLastCheck", "totalExternalStorageGB", "versionName", "getVersionName", "setVersionName", "appendAnonIdUnderCompliance", "", "params", "attributionIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "anonymousAppDeviceGUID", "context", "Landroid/content/Context;", "appendAttributionIdUnderCompliance", "areObjectsEqual", "T", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "awaitGetGraphMeRequestWithCache", "accessToken", "buildUri", "Landroid/net/Uri;", "authority", "path", "parameters", "Landroid/os/Bundle;", "clearCookiesForDomain", "domain", "clearFacebookCookies", "closeQuietly", "closeable", "Ljava/io/Closeable;", "coerceValueIfNullOrEmpty", "s", "valueIfNullOrEmpty", "convertBytesToGB", "bytes", "", "convertJSONArrayToList", "", "jsonArray", "Lorg/json/JSONArray;", "convertJSONObjectToHashMap", "", "jsonObject", "convertJSONObjectToStringMap", "copyAndCloseInputStream", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "disconnectQuietly", "connection", "Ljava/net/URLConnection;", "externalStorageExists", "generateRandomString", "length", "getActivityName", "getAppName", "getAppVersion", "getBundleLongAsDate", "Ljava/util/Date;", "bundle", "key", "dateBase", "getContentSize", "contentUri", "getCurrentTokenDomainWithDefault", "getGraphDomainFromTokenDomain", "tokenGraphDomain", "getGraphMeRequestWithCache", "Lcom/facebook/GraphRequest;", "getGraphMeRequestWithCacheAsync", "callback", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "getMetadataApplicationId", "getMethodQuietly", "Ljava/lang/reflect/Method;", "clazz", "Ljava/lang/Class;", "methodName", "parameterTypes", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "className", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getProfileFieldsForGraphDomain", "graphDomain", "getStringPropertyAsJSON", "nonJSONPropertyKey", "getUriString", "uri", "hashBytes", "hash", "Ljava/security/MessageDigest;", "", "hashWithAlgorithm", "algorithm", "invokeMethodQuietly", "receiver", "method", "args", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "isAutofillAvailable", "isChromeOS", "isContentUri", "isCurrentAccessToken", "token", "Lcom/facebook/AccessToken;", "isFileUri", "isGooglePlayServicesAvailable", "isNullOrEmpty", "c", "", "isWebUri", "jsonArrayToSet", "", "jsonArrayToStringList", "jsonStrToMap", "str", "logd", "tag", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "t", "", "mapToJsonStr", "map", "md5hash", "mustFixWindowParamsForAutofill", "parseUrlQueryString", "queryString", "putCommaSeparatedStringList", "list", "putJSONValueInBundle", "value", "putNonEmptyString", "putUri", "readNonnullStringMapFromParcel", "parcel", "Landroid/os/Parcel;", "readStreamToString", "readStringMapFromParcel", "refreshAvailableExternalStorage", "refreshBestGuessNumberOfCPUCores", "refreshCarrierName", "appContext", "refreshPeriodicExtendedDeviceInfo", "refreshTimezone", "refreshTotalExternalStorage", "runOnNonUiThread", "runnable", "Ljava/lang/Runnable;", "safeGetStringFromResponse", "response", "propertyName", "setAppEventAttributionParameters", "limitEventUsage", "setAppEventExtendedDeviceInfoParameters", "sha1hash", "sha256hash", "stringsEqualOrEmpty", "tryGetJSONArrayFromResponse", "propertyKey", "tryGetJSONObjectFromResponse", "writeNonnullStringMapToParcel", "writeStringMapToParcel", "GraphMeRequestWithCacheCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Utility {
    @NotNull
    private static final String ARC_DEVICE_PATTERN = ".+_cheets|cheets_.+";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
    @NotNull
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";
    @NotNull
    private static final String FACEBOOK_PROFILE_FIELDS = "id,name,first_name,middle_name,last_name";
    @NotNull
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    @NotNull
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
    @NotNull
    private static final String HASH_ALGORITHM_SHA256 = "SHA-256";
    @NotNull
    private static final String INSTAGRAM_PROFILE_FIELDS = "id,name,profile_picture";
    @NotNull
    public static final Utility INSTANCE = new Utility();
    @NotNull
    public static final String LOG_TAG = "FacebookSDK";
    @NotNull
    private static final String NO_CARRIER = "NoCarrier";
    private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;
    @NotNull
    private static final String URL_SCHEME = "https";
    @NotNull
    private static final String UTF8 = "UTF-8";
    private static long availableExternalStorageGB = -1;
    @NotNull
    private static String carrierName = NO_CARRIER;
    @NotNull
    private static String deviceTimeZoneName = "";
    @NotNull
    private static String deviceTimezoneAbbreviation = "";
    @Nullable
    private static Locale locale;
    private static int numCPUCores;
    private static long timestampOfLastCheck = -1;
    private static long totalExternalStorageGB = -1;
    @Nullable
    private static String versionName = "";

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "", "onFailure", "", "error", "Lcom/facebook/FacebookException;", "onSuccess", "userInfo", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface GraphMeRequestWithCacheCallback {
        void onFailure(@Nullable FacebookException facebookException);

        void onSuccess(@Nullable JSONObject jSONObject);
    }

    private Utility() {
    }

    private final void appendAnonIdUnderCompliance(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, String str, Context context) {
        if (Build.VERSION.SDK_INT < 31 || !isGooglePlayServicesAvailable(context)) {
            jSONObject.put("anon_id", (Object) str);
        } else if (!attributionIdentifiers.isTrackingLimited()) {
            jSONObject.put("anon_id", (Object) str);
        }
    }

    private final void appendAttributionIdUnderCompliance(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, Context context) {
        if (Build.VERSION.SDK_INT < 31 || !isGooglePlayServicesAvailable(context)) {
            jSONObject.put("attribution", (Object) attributionIdentifiers.getAttributionId());
        } else if (!attributionIdentifiers.isTrackingLimited()) {
            jSONObject.put("attribution", (Object) attributionIdentifiers.getAttributionId());
        }
    }

    @JvmStatic
    public static final <T> boolean areObjectsEqual(@Nullable T t11, @Nullable T t12) {
        return t11 == null ? t12 == null : Intrinsics.areEqual((Object) t11, (Object) t12);
    }

    @JvmStatic
    @Nullable
    public static final JSONObject awaitGetGraphMeRequestWithCache(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "accessToken");
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            return profileInformation;
        }
        GraphResponse executeAndWait = INSTANCE.getGraphMeRequestWithCache(str).executeAndWait();
        if (executeAndWait.getError() != null) {
            return null;
        }
        return executeAndWait.getJsonObject();
    }

    @JvmStatic
    @NotNull
    public static final Uri buildUri(@Nullable String str, @Nullable String str2, @Nullable Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String next : bundle.keySet()) {
                Object obj = bundle.get(next);
                if (obj instanceof String) {
                    builder.appendQueryParameter(next, (String) obj);
                }
            }
        }
        Uri build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    private final void clearCookiesForDomain(Context context, String str) {
        int i11;
        boolean z11;
        CookieSyncManager.createInstance(context).sync();
        CookieManager instance = CookieManager.getInstance();
        String cookie = instance.getCookie(str);
        if (cookie != null) {
            Object[] array = StringsKt__StringsKt.split$default((CharSequence) cookie, new String[]{TypesAliasesKt.separator}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                int length = strArr.length;
                int i12 = 0;
                while (i12 < length) {
                    String str2 = strArr[i12];
                    i12++;
                    Object[] array2 = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                    if (array2 != null) {
                        String[] strArr2 = (String[]) array2;
                        if (strArr2.length > 0) {
                            String str3 = strArr2[0];
                            int length2 = str3.length() - 1;
                            int i13 = 0;
                            boolean z12 = false;
                            while (i13 <= length2) {
                                if (!z12) {
                                    i11 = i13;
                                } else {
                                    i11 = length2;
                                }
                                if (Intrinsics.compare((int) str3.charAt(i11), 32) <= 0) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (!z12) {
                                    if (!z11) {
                                        z12 = true;
                                    } else {
                                        i13++;
                                    }
                                } else if (!z11) {
                                    break;
                                } else {
                                    length2--;
                                }
                            }
                            instance.setCookie(str, Intrinsics.stringPlus(str3.subSequence(i13, length2 + 1).toString(), "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;"));
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                instance.removeExpiredCookie();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    @JvmStatic
    public static final void clearFacebookCookies(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Utility utility = INSTANCE;
            utility.clearCookiesForDomain(context, "facebook.com");
            utility.clearCookiesForDomain(context, ".facebook.com");
            utility.clearCookiesForDomain(context, "https://facebook.com");
            utility.clearCookiesForDomain(context, "https://.facebook.com");
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void closeQuietly(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @JvmStatic
    @Nullable
    public static final String coerceValueIfNullOrEmpty(@Nullable String str, @Nullable String str2) {
        return isNullOrEmpty(str) ? str2 : str;
    }

    private final long convertBytesToGB(double d11) {
        return Math.round(d11 / 1.073741824E9d);
    }

    @JvmStatic
    @NotNull
    public static final List<String> convertJSONArrayToList(@NotNull JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
        try {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            if (length <= 0) {
                return arrayList;
            }
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                String string = jSONArray.getString(i11);
                Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                arrayList.add(string);
                if (i12 >= length) {
                    return arrayList;
                }
                i11 = i12;
            }
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    @JvmStatic
    @NotNull
    public static final Map<String, Object> convertJSONObjectToHashMap(@NotNull JSONObject jSONObject) {
        int length;
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        HashMap hashMap = new HashMap();
        JSONArray names = jSONObject.names();
        if (names != null && (length = names.length()) > 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                try {
                    String string = names.getString(i11);
                    Intrinsics.checkNotNullExpressionValue(string, "keys.getString(i)");
                    Object obj = jSONObject.get(string);
                    if (obj instanceof JSONObject) {
                        obj = convertJSONObjectToHashMap((JSONObject) obj);
                    }
                    Intrinsics.checkNotNullExpressionValue(obj, "value");
                    hashMap.put(string, obj);
                } catch (JSONException unused) {
                }
                if (i12 >= length) {
                    break;
                }
                i11 = i12;
            }
        }
        return hashMap;
    }

    @JvmStatic
    @NotNull
    public static final Map<String, String> convertJSONObjectToStringMap(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (optString != null) {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                hashMap.put(next, optString);
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0034  */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int copyAndCloseInputStream(@org.jetbrains.annotations.Nullable java.io.InputStream r6, @org.jetbrains.annotations.NotNull java.io.OutputStream r7) throws java.io.IOException {
        /*
            java.lang.String r0 = "outputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ all -> 0x002a }
            r1.<init>(r6)     // Catch:{ all -> 0x002a }
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0027 }
            r2 = 0
            r3 = r2
        L_0x0011:
            int r4 = r1.read(r0)     // Catch:{ all -> 0x0027 }
            r5 = -1
            if (r4 == r5) goto L_0x001d
            r7.write(r0, r2, r4)     // Catch:{ all -> 0x0027 }
            int r3 = r3 + r4
            goto L_0x0011
        L_0x001d:
            r1.close()
            if (r6 != 0) goto L_0x0023
            goto L_0x0026
        L_0x0023:
            r6.close()
        L_0x0026:
            return r3
        L_0x0027:
            r7 = move-exception
            r0 = r1
            goto L_0x002b
        L_0x002a:
            r7 = move-exception
        L_0x002b:
            if (r0 != 0) goto L_0x002e
            goto L_0x0031
        L_0x002e:
            r0.close()
        L_0x0031:
            if (r6 != 0) goto L_0x0034
            goto L_0x0037
        L_0x0034:
            r6.close()
        L_0x0037:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Utility.copyAndCloseInputStream(java.io.InputStream, java.io.OutputStream):int");
    }

    @JvmStatic
    public static final void disconnectQuietly(@Nullable URLConnection uRLConnection) {
        if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    private final boolean externalStorageExists() {
        return Intrinsics.areEqual((Object) "mounted", (Object) Environment.getExternalStorageState());
    }

    @JvmStatic
    @NotNull
    public static final String generateRandomString(int i11) {
        String bigInteger = new BigInteger(i11 * 5, new Random()).toString(32);
        Intrinsics.checkNotNullExpressionValue(bigInteger, "BigInteger(length * 5, r).toString(32)");
        return bigInteger;
    }

    @JvmStatic
    @NotNull
    public static final String getActivityName(@Nullable Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        String simpleName = context.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "{\n      context.javaClass.simpleName\n    }");
        return simpleName;
    }

    @JvmStatic
    @NotNull
    public static final String getAppName(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String applicationName = FacebookSdk.getApplicationName();
            if (applicationName != null) {
                return applicationName;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i11 = applicationInfo.labelRes;
            if (i11 == 0) {
                return applicationInfo.nonLocalizedLabel.toString();
            }
            String string = context.getString(i11);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(stringId)");
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    @JvmStatic
    @Nullable
    public static final String getAppVersion() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final Date getBundleLongAsDate(@Nullable Bundle bundle, @Nullable String str, @NotNull Date date) {
        long j11;
        Intrinsics.checkNotNullParameter(date, "dateBase");
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            j11 = ((Number) obj).longValue();
        } else {
            if (obj instanceof String) {
                try {
                    j11 = Long.parseLong((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        if (j11 == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date(date.getTime() + (j11 * 1000));
    }

    @JvmStatic
    public static final long getContentSize(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "contentUri");
        Cursor cursor = null;
        try {
            Cursor query = FacebookSdk.getApplicationContext().getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
            if (query == null) {
                return 0;
            }
            int columnIndex = query.getColumnIndex("_size");
            query.moveToFirst();
            long j11 = query.getLong(columnIndex);
            query.close();
            return j11;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    @JvmStatic
    @NotNull
    public static final Locale getCurrentLocale() {
        Locale resourceLocale = getResourceLocale();
        if (resourceLocale != null) {
            return resourceLocale;
        }
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
        return locale2;
    }

    private final String getCurrentTokenDomainWithDefault() {
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.getGraphDomain() == null) {
            return AccessToken.DEFAULT_GRAPH_DOMAIN;
        }
        return currentAccessToken.getGraphDomain();
    }

    @JvmStatic
    @Nullable
    @AutoHandleExceptions
    public static final JSONObject getDataProcessingOptions() {
        String string = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.DATA_PROCESSING_OPTIONS_PREFERENCES, 0).getString(FacebookSdk.DATA_PROCESSION_OPTIONS, (String) null);
        if (string != null) {
            try {
                return new JSONObject(string);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final String getGraphDomainFromTokenDomain(@Nullable String str) {
        String facebookDomain = FacebookSdk.getFacebookDomain();
        if (str == null) {
            return facebookDomain;
        }
        if (Intrinsics.areEqual((Object) str, (Object) FacebookSdk.GAMING)) {
            return StringsKt__StringsJVMKt.replace$default(facebookDomain, "facebook.com", FacebookSdk.FB_GG, false, 4, (Object) null);
        }
        if (Intrinsics.areEqual((Object) str, (Object) FacebookSdk.INSTAGRAM)) {
            return StringsKt__StringsJVMKt.replace$default(facebookDomain, "facebook.com", FacebookSdk.INSTAGRAM_COM, false, 4, (Object) null);
        }
        return facebookDomain;
    }

    private final GraphRequest getGraphMeRequestWithCache(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", getProfileFieldsForGraphDomain(getCurrentTokenDomainWithDefault()));
        bundle.putString("access_token", str);
        GraphRequest newMeRequest = GraphRequest.Companion.newMeRequest((AccessToken) null, (GraphRequest.GraphJSONObjectCallback) null);
        newMeRequest.setParameters(bundle);
        newMeRequest.setHttpMethod(HttpMethod.GET);
        return newMeRequest;
    }

    @JvmStatic
    public static final void getGraphMeRequestWithCacheAsync(@NotNull String str, @NotNull GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback) {
        Intrinsics.checkNotNullParameter(str, "accessToken");
        Intrinsics.checkNotNullParameter(graphMeRequestWithCacheCallback, "callback");
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            graphMeRequestWithCacheCallback.onSuccess(profileInformation);
            return;
        }
        q qVar = new q(graphMeRequestWithCacheCallback, str);
        GraphRequest graphMeRequestWithCache = INSTANCE.getGraphMeRequestWithCache(str);
        graphMeRequestWithCache.setCallback(qVar);
        graphMeRequestWithCache.executeAsync();
    }

    /* access modifiers changed from: private */
    /* renamed from: getGraphMeRequestWithCacheAsync$lambda-3  reason: not valid java name */
    public static final void m8962getGraphMeRequestWithCacheAsync$lambda3(GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback, String str, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(graphMeRequestWithCacheCallback, "$callback");
        Intrinsics.checkNotNullParameter(str, "$accessToken");
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        if (graphResponse.getError() != null) {
            graphMeRequestWithCacheCallback.onFailure(graphResponse.getError().getException());
            return;
        }
        ProfileInformationCache profileInformationCache = ProfileInformationCache.INSTANCE;
        JSONObject jsonObject = graphResponse.getJsonObject();
        if (jsonObject != null) {
            ProfileInformationCache.putProfileInformation(str, jsonObject);
            graphMeRequestWithCacheCallback.onSuccess(graphResponse.getJsonObject());
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @JvmStatic
    @NotNull
    public static final String getMetadataApplicationId(@Nullable Context context) {
        Validate.notNull(context, "context");
        return FacebookSdk.getApplicationId();
    }

    @JvmStatic
    @Nullable
    public static final Method getMethodQuietly(@NotNull Class<?> cls, @NotNull String str, @NotNull Class<?>... clsArr) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_METHOD_NAME);
        Intrinsics.checkNotNullParameter(clsArr, "parameterTypes");
        try {
            return cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final String getProfileFieldsForGraphDomain(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) FacebookSdk.INSTAGRAM)) {
            return INSTAGRAM_PROFILE_FIELDS;
        }
        return FACEBOOK_PROFILE_FIELDS;
    }

    @JvmStatic
    @Nullable
    public static final Locale getResourceLocale() {
        try {
            return FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final Object getStringPropertyAsJSON(@NotNull JSONObject jSONObject, @Nullable String str, @Nullable String str2) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Object opt = jSONObject.opt(str);
        if (opt != null && (opt instanceof String)) {
            opt = new JSONTokener((String) opt).nextValue();
        }
        if (opt == null || (opt instanceof JSONObject) || (opt instanceof JSONArray)) {
            return opt;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, opt);
            return jSONObject2;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    @JvmStatic
    @Nullable
    public static final String getUriString(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    private final String hashBytes(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder sb2 = new StringBuilder();
        Intrinsics.checkNotNullExpressionValue(digest, "digest");
        int length = digest.length;
        int i11 = 0;
        while (i11 < length) {
            byte b11 = digest[i11];
            i11++;
            sb2.append(Integer.toHexString((b11 >> 4) & 15));
            sb2.append(Integer.toHexString((b11 >> 0) & 15));
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "builder.toString()");
        return sb3;
    }

    private final String hashWithAlgorithm(String str, String str2) {
        Charset charset = Charsets.UTF_8;
        if (str2 != null) {
            byte[] bytes = str2.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return hashWithAlgorithm(str, bytes);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @JvmStatic
    @Nullable
    public static final Object invokeMethodQuietly(@Nullable Object obj, @NotNull Method method, @NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        try {
            return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static final boolean isAutoAppLinkSetup() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("fb%s://applinks", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            intent.setData(Uri.parse(format));
            Context applicationContext = FacebookSdk.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            String packageName = applicationContext.getPackageName();
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)");
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                if (Intrinsics.areEqual((Object) packageName, (Object) resolveInfo.activityInfo.packageName)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @JvmStatic
    public static /* synthetic */ void isAutoAppLinkSetup$annotations() {
    }

    @JvmStatic
    public static final boolean isAutofillAvailable(@NotNull Context context) {
        AutofillManager autofillManager;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class)) != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled()) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean isChromeOS(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        String str = Build.DEVICE;
        if (str != null) {
            Intrinsics.checkNotNullExpressionValue(str, "DEVICE");
            if (new Regex(ARC_DEVICE_PATTERN).matches(str)) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean isContentUri(@Nullable Uri uri) {
        if (uri == null || !StringsKt__StringsJVMKt.equals("content", uri.getScheme(), true)) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean isCurrentAccessToken(@Nullable AccessToken accessToken) {
        return accessToken != null && Intrinsics.areEqual((Object) accessToken, (Object) AccessToken.Companion.getCurrentAccessToken());
    }

    @JvmStatic
    @AutoHandleExceptions
    public static final boolean isDataProcessingRestricted() {
        JSONObject dataProcessingOptions = getDataProcessingOptions();
        if (dataProcessingOptions == null) {
            return false;
        }
        try {
            JSONArray jSONArray = dataProcessingOptions.getJSONArray(FacebookSdk.DATA_PROCESSION_OPTIONS);
            int length = jSONArray.length();
            if (length > 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    String string = jSONArray.getString(i11);
                    Intrinsics.checkNotNullExpressionValue(string, "options.getString(i)");
                    String lowerCase = string.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                    if (Intrinsics.areEqual((Object) lowerCase, (Object) "ldu")) {
                        return true;
                    }
                    if (i12 >= length) {
                        break;
                    }
                    i11 = i12;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @JvmStatic
    public static final boolean isFileUri(@Nullable Uri uri) {
        if (uri == null || !StringsKt__StringsJVMKt.equals("file", uri.getScheme(), true)) {
            return false;
        }
        return true;
    }

    private final boolean isGooglePlayServicesAvailable(Context context) {
        Method methodQuietly = getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
        if (methodQuietly == null) {
            return false;
        }
        Object invokeMethodQuietly = invokeMethodQuietly((Object) null, methodQuietly, context);
        if (!(invokeMethodQuietly instanceof Integer) || !Intrinsics.areEqual(invokeMethodQuietly, (Object) 0)) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean isNullOrEmpty(@Nullable Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    @JvmStatic
    public static final boolean isWebUri(@Nullable Uri uri) {
        if (uri == null || (!StringsKt__StringsJVMKt.equals(ProxyConfig.MATCH_HTTP, uri.getScheme(), true) && !StringsKt__StringsJVMKt.equals("https", uri.getScheme(), true) && !StringsKt__StringsJVMKt.equals("fbstaging", uri.getScheme(), true))) {
            return false;
        }
        return true;
    }

    @JvmStatic
    @NotNull
    public static final Set<String> jsonArrayToSet(@NotNull JSONArray jSONArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
        HashSet hashSet = new HashSet();
        int length = jSONArray.length();
        if (length > 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                String string = jSONArray.getString(i11);
                Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                hashSet.add(string);
                if (i12 >= length) {
                    break;
                }
                i11 = i12;
            }
        }
        return hashSet;
    }

    @JvmStatic
    @NotNull
    public static final List<String> jsonArrayToStringList(@NotNull JSONArray jSONArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length > 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                arrayList.add(jSONArray.getString(i11));
                if (i12 >= length) {
                    break;
                }
                i11 = i12;
            }
        }
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final Map<String, String> jsonStrToMap(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "str");
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return new HashMap();
        }
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Intrinsics.checkNotNullExpressionValue(next, "key");
                String string = jSONObject.getString(next);
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
                hashMap.put(next, string);
            }
            return hashMap;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    @JvmStatic
    public static final void logd(@Nullable String str, @Nullable Exception exc) {
        if (FacebookSdk.isDebugEnabled() && str != null && exc != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(exc.getClass().getSimpleName());
            sb2.append(": ");
            sb2.append(exc.getMessage());
        }
    }

    @JvmStatic
    @NotNull
    public static final String mapToJsonStr(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        String str = "";
        if (!map.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry next : map.entrySet()) {
                    jSONObject.put((String) next.getKey(), (Object) (String) next.getValue());
                }
                str = JSONObjectInstrumentation.toString(jSONObject);
            } catch (JSONException unused) {
            }
            Intrinsics.checkNotNullExpressionValue(str, "{\n      try {\n        val jsonObject = JSONObject()\n        for ((key, value) in map) {\n          jsonObject.put(key, value)\n        }\n        jsonObject.toString()\n      } catch (_e: JSONException) {\n        \"\"\n      }\n    }");
        }
        return str;
    }

    @JvmStatic
    @Nullable
    public static final String md5hash(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_MD5, str);
    }

    @JvmStatic
    public static final boolean mustFixWindowParamsForAutofill(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return isAutofillAvailable(context);
    }

    @JvmStatic
    @NotNull
    public static final Bundle parseUrlQueryString(@Nullable String str) {
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(str)) {
            if (str != null) {
                Object[] array = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    int length = strArr.length;
                    int i11 = 0;
                    while (i11 < length) {
                        String str2 = strArr[i11];
                        i11++;
                        Object[] array2 = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                        if (array2 != null) {
                            String[] strArr2 = (String[]) array2;
                            try {
                                if (strArr2.length == 2) {
                                    bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), URLDecoder.decode(strArr2[1], "UTF-8"));
                                } else if (strArr2.length == 1) {
                                    bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), "");
                                }
                            } catch (UnsupportedEncodingException e11) {
                                logd(LOG_TAG, (Exception) e11);
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        return bundle;
    }

    @JvmStatic
    public static final void putCommaSeparatedStringList(@NotNull Bundle bundle, @Nullable String str, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(bundle, "b");
        if (list != null) {
            bundle.putString(str, TextUtils.join(",", list));
        }
    }

    @JvmStatic
    public static final boolean putJSONValueInBundle(@NotNull Bundle bundle, @Nullable String str, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (obj == null) {
            bundle.remove(str);
            return true;
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        } else if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
            return true;
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Number) obj).doubleValue());
            return true;
        } else if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
            return true;
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Number) obj).intValue());
            return true;
        } else if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
            return true;
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Number) obj).longValue());
            return true;
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
            return true;
        } else if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return true;
        } else if (obj instanceof JSONArray) {
            bundle.putString(str, JSONArrayInstrumentation.toString((JSONArray) obj));
            return true;
        } else if (!(obj instanceof JSONObject)) {
            return false;
        } else {
            bundle.putString(str, JSONObjectInstrumentation.toString((JSONObject) obj));
            return true;
        }
    }

    @JvmStatic
    public static final void putNonEmptyString(@NotNull Bundle bundle, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(bundle, "b");
        if (!isNullOrEmpty(str2)) {
            bundle.putString(str, str2);
        }
    }

    @JvmStatic
    public static final void putUri(@NotNull Bundle bundle, @Nullable String str, @Nullable Uri uri) {
        Intrinsics.checkNotNullParameter(bundle, "b");
        if (uri != null) {
            putNonEmptyString(bundle, str, uri.toString());
        }
    }

    @JvmStatic
    @Nullable
    public static final Map<String, String> readNonnullStringMapFromParcel(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (readInt > 0) {
            int i11 = 0;
            do {
                i11++;
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (!(readString == null || readString2 == null)) {
                    hashMap.put(readString, readString2);
                    continue;
                }
            } while (i11 < readInt);
        }
        return hashMap;
    }

    @JvmStatic
    @NotNull
    public static final String readStreamToString(@Nullable InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader;
        BufferedInputStream bufferedInputStream;
        Throwable th2;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                try {
                    StringBuilder sb2 = new StringBuilder();
                    char[] cArr = new char[2048];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read != -1) {
                            sb2.append(cArr, 0, read);
                        } else {
                            String sb3 = sb2.toString();
                            Intrinsics.checkNotNullExpressionValue(sb3, "{\n      bufferedInputStream = BufferedInputStream(inputStream)\n      reader = InputStreamReader(bufferedInputStream)\n      val stringBuilder = StringBuilder()\n      val bufferSize = 1024 * 2\n      val buffer = CharArray(bufferSize)\n      var n = 0\n      while (reader.read(buffer).also { n = it } != -1) {\n        stringBuilder.append(buffer, 0, n)\n      }\n      stringBuilder.toString()\n    }");
                            closeQuietly(bufferedInputStream);
                            closeQuietly(inputStreamReader);
                            return sb3;
                        }
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    closeQuietly(bufferedInputStream);
                    closeQuietly(inputStreamReader);
                    throw th2;
                }
            } catch (Throwable th4) {
                th2 = th4;
                inputStreamReader = null;
                closeQuietly(bufferedInputStream);
                closeQuietly(inputStreamReader);
                throw th2;
            }
        } catch (Throwable th5) {
            bufferedInputStream = null;
            th2 = th5;
            inputStreamReader = null;
            closeQuietly(bufferedInputStream);
            closeQuietly(inputStreamReader);
            throw th2;
        }
    }

    @JvmStatic
    @Nullable
    public static final Map<String, String> readStringMapFromParcel(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (readInt > 0) {
            int i11 = 0;
            do {
                i11++;
                hashMap.put(parcel.readString(), parcel.readString());
            } while (i11 < readInt);
        }
        return hashMap;
    }

    private final void refreshAvailableExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                availableExternalStorageGB = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
            availableExternalStorageGB = convertBytesToGB((double) availableExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private final int refreshBestGuessNumberOfCPUCores() {
        int i11 = numCPUCores;
        if (i11 > 0) {
            return i11;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new r());
            if (listFiles != null) {
                numCPUCores = listFiles.length;
            }
        } catch (Exception unused) {
        }
        if (numCPUCores <= 0) {
            numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return numCPUCores;
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshBestGuessNumberOfCPUCores$lambda-4  reason: not valid java name */
    public static final boolean m8963refreshBestGuessNumberOfCPUCores$lambda4(File file, String str) {
        return Pattern.matches("cpu[0-9]+", str);
    }

    private final void refreshCarrierName(Context context) {
        if (Intrinsics.areEqual((Object) carrierName, (Object) NO_CARRIER)) {
            try {
                Object systemService = context.getSystemService("phone");
                if (systemService != null) {
                    String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
                    Intrinsics.checkNotNullExpressionValue(networkOperatorName, "telephonyManager.networkOperatorName");
                    carrierName = networkOperatorName;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
            } catch (Exception unused) {
            }
        }
    }

    private final void refreshPeriodicExtendedDeviceInfo(Context context) {
        if (timestampOfLastCheck == -1 || System.currentTimeMillis() - timestampOfLastCheck >= 1800000) {
            timestampOfLastCheck = System.currentTimeMillis();
            refreshTimezone();
            refreshCarrierName(context);
            refreshTotalExternalStorage();
            refreshAvailableExternalStorage();
        }
    }

    private final void refreshTimezone() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            String displayName = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            Intrinsics.checkNotNullExpressionValue(displayName, "tz.getDisplayName(tz.inDaylightTime(Date()), TimeZone.SHORT)");
            deviceTimezoneAbbreviation = displayName;
            String id2 = timeZone.getID();
            Intrinsics.checkNotNullExpressionValue(id2, "tz.id");
            deviceTimeZoneName = id2;
        } catch (AssertionError | Exception unused) {
        }
    }

    private final void refreshTotalExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                totalExternalStorageGB = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            }
            totalExternalStorageGB = convertBytesToGB((double) totalExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void runOnNonUiThread(@Nullable Runnable runnable) {
        try {
            FacebookSdk.getExecutor().execute(runnable);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    @NotNull
    public static final String safeGetStringFromResponse(@Nullable JSONObject jSONObject, @Nullable String str) {
        if (jSONObject == null) {
            return "";
        }
        String optString = jSONObject.optString(str, "");
        Intrinsics.checkNotNullExpressionValue(optString, "response.optString(propertyName, \"\")");
        return optString;
    }

    @JvmStatic
    public static final void setAppEventAttributionParameters(@NotNull JSONObject jSONObject, @Nullable AttributionIdentifiers attributionIdentifiers, @Nullable String str, boolean z11, @NotNull Context context) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkNotNullParameter(context, "context");
        FeatureManager featureManager = FeatureManager.INSTANCE;
        FeatureManager.Feature feature = FeatureManager.Feature.ServiceUpdateCompliance;
        if (!FeatureManager.isEnabled(feature)) {
            jSONObject.put("anon_id", (Object) str);
        }
        boolean z12 = true;
        jSONObject.put("application_tracking_enabled", !z11);
        jSONObject.put("advertiser_id_collection_enabled", FacebookSdk.getAdvertiserIDCollectionEnabled());
        if (attributionIdentifiers != null) {
            if (FeatureManager.isEnabled(feature)) {
                INSTANCE.appendAnonIdUnderCompliance(jSONObject, attributionIdentifiers, str, context);
            }
            if (attributionIdentifiers.getAttributionId() != null) {
                if (FeatureManager.isEnabled(feature)) {
                    INSTANCE.appendAttributionIdUnderCompliance(jSONObject, attributionIdentifiers, context);
                } else {
                    jSONObject.put("attribution", (Object) attributionIdentifiers.getAttributionId());
                }
            }
            if (attributionIdentifiers.getAndroidAdvertiserId() != null) {
                jSONObject.put("advertiser_id", (Object) attributionIdentifiers.getAndroidAdvertiserId());
                jSONObject.put("advertiser_tracking_enabled", !attributionIdentifiers.isTrackingLimited());
            }
            if (!attributionIdentifiers.isTrackingLimited()) {
                String allHashedUserData = UserDataStore.getAllHashedUserData();
                if (allHashedUserData.length() != 0) {
                    z12 = false;
                }
                if (!z12) {
                    jSONObject.put("ud", (Object) allHashedUserData);
                }
            }
            if (attributionIdentifiers.getAndroidInstallerPackage() != null) {
                jSONObject.put("installer_package", (Object) attributionIdentifiers.getAndroidInstallerPackage());
            }
        }
    }

    @JvmStatic
    public static final void setAppEventExtendedDeviceInfoParameters(@NotNull JSONObject jSONObject, @NotNull Context context) throws JSONException {
        Locale locale2;
        String str;
        int i11;
        int i12;
        DisplayManager displayManager;
        String country;
        Intrinsics.checkNotNullParameter(jSONObject, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkNotNullParameter(context, "appContext");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put((Object) EXTRA_APP_EVENTS_INFO_FORMAT_VERSION);
        INSTANCE.refreshPeriodicExtendedDeviceInfo(context);
        String packageName = context.getPackageName();
        int i13 = 0;
        int i14 = -1;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            if (packageInfo != null) {
                i14 = packageInfo.versionCode;
                versionName = packageInfo.versionName;
                jSONArray.put((Object) packageName);
                jSONArray.put(i14);
                jSONArray.put((Object) versionName);
                jSONArray.put((Object) Build.VERSION.RELEASE);
                jSONArray.put((Object) Build.MODEL);
                try {
                    locale2 = context.getResources().getConfiguration().locale;
                } catch (Exception unused) {
                    locale2 = Locale.getDefault();
                }
                locale = locale2;
                StringBuilder sb2 = new StringBuilder();
                Locale locale3 = locale;
                String str2 = "";
                if (locale3 == null || (str = locale3.getLanguage()) == null) {
                    str = str2;
                }
                sb2.append(str);
                sb2.append('_');
                Locale locale4 = locale;
                if (!(locale4 == null || (country = locale4.getCountry()) == null)) {
                    str2 = country;
                }
                sb2.append(str2);
                jSONArray.put((Object) sb2.toString());
                jSONArray.put((Object) deviceTimezoneAbbreviation);
                jSONArray.put((Object) carrierName);
                double d11 = 0.0d;
                try {
                    Object systemService = context.getSystemService("display");
                    Display display = null;
                    if (systemService instanceof DisplayManager) {
                        displayManager = (DisplayManager) systemService;
                    } else {
                        displayManager = null;
                    }
                    if (displayManager != null) {
                        display = displayManager.getDisplay(0);
                    }
                    if (display != null) {
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        display.getMetrics(displayMetrics);
                        i12 = displayMetrics.widthPixels;
                        try {
                            i13 = displayMetrics.heightPixels;
                            d11 = (double) displayMetrics.density;
                        } catch (Exception unused2) {
                        }
                        i11 = i13;
                        i13 = i12;
                        jSONArray.put(i13);
                        jSONArray.put(i11);
                        jSONArray.put((Object) new DecimalFormat("#.##").format(d11));
                        jSONArray.put(INSTANCE.refreshBestGuessNumberOfCPUCores());
                        jSONArray.put(totalExternalStorageGB);
                        jSONArray.put(availableExternalStorageGB);
                        jSONArray.put((Object) deviceTimeZoneName);
                        jSONObject.put(Constants.EXTINFO, (Object) JSONArrayInstrumentation.toString(jSONArray));
                    }
                    i11 = 0;
                    jSONArray.put(i13);
                    jSONArray.put(i11);
                    jSONArray.put((Object) new DecimalFormat("#.##").format(d11));
                    jSONArray.put(INSTANCE.refreshBestGuessNumberOfCPUCores());
                    jSONArray.put(totalExternalStorageGB);
                    jSONArray.put(availableExternalStorageGB);
                    jSONArray.put((Object) deviceTimeZoneName);
                    jSONObject.put(Constants.EXTINFO, (Object) JSONArrayInstrumentation.toString(jSONArray));
                } catch (Exception unused3) {
                    i12 = 0;
                }
            }
        } catch (PackageManager.NameNotFoundException unused4) {
        }
    }

    @JvmStatic
    @Nullable
    public static final String sha1hash(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA1, str);
    }

    @JvmStatic
    @Nullable
    public static final String sha256hash(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm("SHA-256", str);
    }

    @JvmStatic
    public static final boolean stringsEqualOrEmpty(@Nullable String str, @Nullable String str2) {
        boolean z11;
        boolean z12;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (str2 == null || str2.length() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 && z12) {
            return true;
        }
        if (z11 || z12) {
            return false;
        }
        return Intrinsics.areEqual((Object) str, (Object) str2);
    }

    @JvmStatic
    @Nullable
    public static final JSONArray tryGetJSONArrayFromResponse(@Nullable JSONObject jSONObject, @Nullable String str) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONArray(str);
    }

    @JvmStatic
    @Nullable
    public static final JSONObject tryGetJSONObjectFromResponse(@Nullable JSONObject jSONObject, @Nullable String str) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONObject(str);
    }

    @JvmStatic
    public static final void writeNonnullStringMapToParcel(@NotNull Parcel parcel, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
    }

    @JvmStatic
    public static final void writeStringMapToParcel(@NotNull Parcel parcel, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
    }

    public final long getAvailableExternalStorageGB() {
        return availableExternalStorageGB;
    }

    @NotNull
    public final String getCarrierName() {
        return carrierName;
    }

    @NotNull
    public final String getDeviceTimeZoneName() {
        return deviceTimeZoneName;
    }

    @Nullable
    public final Locale getLocale() {
        return locale;
    }

    @Nullable
    public final String getVersionName() {
        return versionName;
    }

    public final void setAvailableExternalStorageGB(long j11) {
        availableExternalStorageGB = j11;
    }

    public final void setCarrierName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        carrierName = str;
    }

    public final void setDeviceTimeZoneName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        deviceTimeZoneName = str;
    }

    public final void setLocale(@Nullable Locale locale2) {
        locale = locale2;
    }

    public final void setVersionName(@Nullable String str) {
        versionName = str;
    }

    @JvmStatic
    @Nullable
    public static final Method getMethodQuietly(@NotNull String str, @NotNull String str2, @NotNull Class<?>... clsArr) {
        Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_CLASS_NAME);
        Intrinsics.checkNotNullParameter(str2, HexAttribute.HEX_ATTR_METHOD_NAME);
        Intrinsics.checkNotNullParameter(clsArr, "parameterTypes");
        try {
            Class<?> cls = Class.forName(str);
            Intrinsics.checkNotNullExpressionValue(cls, "clazz");
            return getMethodQuietly(cls, str2, (Class<?>[]) (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private final String hashWithAlgorithm(String str, byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            Intrinsics.checkNotNullExpressionValue(instance, "hash");
            return hashBytes(instance, bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final boolean isNullOrEmpty(@Nullable String str) {
        if (str == null) {
            return true;
        }
        return str.length() == 0;
    }

    @JvmStatic
    @Nullable
    public static final String sha1hash(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA1, bArr);
    }

    @JvmStatic
    @Nullable
    public static final String sha256hash(@Nullable byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm("SHA-256", bArr);
    }

    @JvmStatic
    public static final void logd(@Nullable String str, @Nullable String str2) {
        FacebookSdk.isDebugEnabled();
    }

    @JvmStatic
    public static final void logd(@Nullable String str, @Nullable String str2, @Nullable Throwable th2) {
        if (FacebookSdk.isDebugEnabled()) {
            isNullOrEmpty(str);
        }
    }
}
