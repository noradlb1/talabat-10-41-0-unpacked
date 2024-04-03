package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginTargetApp;
import com.huawei.hms.support.api.entity.core.CommonCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v6.n;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b;\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b;\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001:\u000eÕ\u0001Ö\u0001×\u0001Ø\u0001Ù\u0001Ú\u0001Û\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u000200~0}H\u0002J\u000f\u0010\u0001\u001a\b\u0012\u0004\u0012\u000200~H\u0002J\u000f\u0010\u0001\u001a\b\u0012\u0004\u0012\u000200~H\u0002J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020H\u0002J.\u0010\u0001\u001a\u00020A2\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020A\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020A2\b\u0010\u0001\u001a\u00030\u0001H\u0007J\u0018\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\u0001\u0010\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00042\u0010\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\u0007\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030 \u00012\u0007\u0010¡\u0001\u001a\u00020\u00042\u0007\u0010¢\u0001\u001a\u00020\u00042\t\u0010£\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010¤\u0001\u001a\u00030\u00012\b\u0010¥\u0001\u001a\u00030\u00012\b\u0010¦\u0001\u001a\u00030\u0001H\u0007J½\u0001\u0010§\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00042\u0010\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\u0007\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030 \u00012\u0007\u0010¡\u0001\u001a\u00020\u00042\u0007\u0010¢\u0001\u001a\u00020\u00042\b\u0010¨\u0001\u001a\u00030\u00012\t\u0010£\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010¤\u0001\u001a\u00030\u00012\b\u0010©\u0001\u001a\u00030ª\u00012\b\u0010¥\u0001\u001a\u00030\u00012\b\u0010¦\u0001\u001a\u00030\u00012\t\u0010«\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010­\u0001\u001a\u0004\u0018\u00010\u0004H\u0002JD\u0010®\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010°\u0001\u001a\u0004\u0018\u00010\u00042\n\u0010±\u0001\u001a\u0005\u0018\u00010²\u00012\n\u0010³\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\u0016\u0010´\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0007J.\u0010µ\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010¶\u0001\u001a\u00030\u00012\n\u0010·\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010¸\u0001\u001a\u0005\u0018\u00010\u0001H\u0007JÆ\u0001\u0010¹\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010~2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020\u00042\u0010\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\u0007\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030 \u00012\u0007\u0010¡\u0001\u001a\u00020\u00042\u0007\u0010¢\u0001\u001a\u00020\u00042\b\u0010¨\u0001\u001a\u00030\u00012\t\u0010£\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010¤\u0001\u001a\u00030\u00012\b\u0010¥\u0001\u001a\u00030\u00012\b\u0010¦\u0001\u001a\u00030\u00012\t\u0010«\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0002\u0010­\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J\u0019\u0010º\u0001\u001a\t\u0012\u0004\u0012\u00020A0\u00012\u0007\u0010\u0001\u001a\u00020H\u0002J\u0016\u0010»\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010¼\u0001\u001a\u00030\u0001H\u0007J\u0018\u0010½\u0001\u001a\u0005\u0018\u00010¾\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\u0016\u0010¿\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010À\u0001\u001a\u00030\u0001H\u0007J\u0018\u0010Á\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010Â\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\u001d\u0010Ã\u0001\u001a\u00030²\u00012\u0007\u0010°\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u0001H\u0007J%\u0010Ä\u0001\u001a\u00030²\u00012\u000f\u0010Å\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u00010~2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0012\u0010Æ\u0001\u001a\u00020A2\u0007\u0010Ç\u0001\u001a\u00020AH\u0007J\t\u0010È\u0001\u001a\u00020AH\u0007J\u0016\u0010É\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010¼\u0001\u001a\u00030\u0001H\u0007J\u0013\u0010Ê\u0001\u001a\u00020A2\b\u0010¼\u0001\u001a\u00030\u0001H\u0007J\u0016\u0010Ë\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010À\u0001\u001a\u00030\u0001H\u0007J\u0014\u0010Ì\u0001\u001a\u00030\u00012\b\u0010À\u0001\u001a\u00030\u0001H\u0007J\u0013\u0010Í\u0001\u001a\u00030\u00012\u0007\u0010Î\u0001\u001a\u00020AH\u0007J?\u0010Ï\u0001\u001a\u00030Ð\u00012\b\u0010¼\u0001\u001a\u00030\u00012\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010°\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010Î\u0001\u001a\u00020A2\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\n\u0010Ò\u0001\u001a\u00030Ð\u0001H\u0007J-\u0010Ó\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010H\u0007J-\u0010Ô\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@X\u0004¢\u0006\u0004\n\u0002\u0010BR\u000e\u0010C\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010v\u001a\n w*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R \u0010|\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u000200~0}X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0001\u001a\b\u0012\u0004\u0012\u000200~X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0001\u001a\b\u0012\u0004\u0012\u000200~X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006Ü\u0001"}, d2 = {"Lcom/facebook/internal/NativeProtocol;", "", "()V", "ACTION_APPINVITE_DIALOG", "", "ACTION_CAMERA_EFFECT", "ACTION_FEED_DIALOG", "ACTION_LIKE_DIALOG", "ACTION_MESSAGE_DIALOG", "ACTION_OGACTIONPUBLISH_DIALOG", "ACTION_OGMESSAGEPUBLISH_DIALOG", "ACTION_SHARE_STORY", "AUDIENCE_EVERYONE", "AUDIENCE_FRIENDS", "AUDIENCE_ME", "BRIDGE_ARG_ACTION_ID_STRING", "BRIDGE_ARG_APP_NAME_STRING", "BRIDGE_ARG_ERROR_BUNDLE", "BRIDGE_ARG_ERROR_CODE", "BRIDGE_ARG_ERROR_DESCRIPTION", "BRIDGE_ARG_ERROR_JSON", "BRIDGE_ARG_ERROR_SUBCODE", "BRIDGE_ARG_ERROR_TYPE", "CONTENT_SCHEME", "ERROR_APPLICATION_ERROR", "ERROR_NETWORK_ERROR", "ERROR_PERMISSION_DENIED", "ERROR_PROTOCOL_ERROR", "ERROR_SERVICE_DISABLED", "ERROR_UNKNOWN_ERROR", "ERROR_USER_CANCELED", "EXTRA_ACCESS_TOKEN", "EXTRA_APPLICATION_ID", "EXTRA_APPLICATION_NAME", "EXTRA_AUTHENTICATION_TOKEN", "EXTRA_DATA_ACCESS_EXPIRATION_TIME", "EXTRA_DIALOG_COMPLETE_KEY", "EXTRA_DIALOG_COMPLETION_GESTURE_KEY", "EXTRA_EXPIRES_SECONDS_SINCE_EPOCH", "EXTRA_GET_INSTALL_DATA_PACKAGE", "EXTRA_GRAPH_API_VERSION", "EXTRA_LOGGER_REF", "EXTRA_NONCE", "EXTRA_PERMISSIONS", "EXTRA_PROTOCOL_ACTION", "EXTRA_PROTOCOL_BRIDGE_ARGS", "EXTRA_PROTOCOL_CALL_ID", "EXTRA_PROTOCOL_METHOD_ARGS", "EXTRA_PROTOCOL_METHOD_RESULTS", "EXTRA_PROTOCOL_VERSION", "EXTRA_PROTOCOL_VERSIONS", "EXTRA_TOAST_DURATION_MS", "EXTRA_USER_ID", "FACEBOOK_PROXY_AUTH_ACTIVITY", "FACEBOOK_PROXY_AUTH_APP_ID_KEY", "FACEBOOK_PROXY_AUTH_E2E_KEY", "FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY", "FACEBOOK_SDK_VERSION_KEY", "FACEBOOK_TOKEN_REFRESH_ACTIVITY", "IMAGE_URL_KEY", "IMAGE_USER_GENERATED_KEY", "INTENT_ACTION_PLATFORM_ACTIVITY", "INTENT_ACTION_PLATFORM_SERVICE", "KNOWN_PROTOCOL_VERSIONS", "", "", "[Ljava/lang/Integer;", "MESSAGE_GET_ACCESS_TOKEN_REPLY", "MESSAGE_GET_ACCESS_TOKEN_REQUEST", "MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY", "MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST", "MESSAGE_GET_INSTALL_DATA_REPLY", "MESSAGE_GET_INSTALL_DATA_REQUEST", "MESSAGE_GET_LIKE_STATUS_REPLY", "MESSAGE_GET_LIKE_STATUS_REQUEST", "MESSAGE_GET_LOGIN_STATUS_REPLY", "MESSAGE_GET_LOGIN_STATUS_REQUEST", "MESSAGE_GET_PROTOCOL_VERSIONS_REPLY", "MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST", "NO_PROTOCOL_AVAILABLE", "OPEN_GRAPH_CREATE_OBJECT_KEY", "PLATFORM_PROVIDER", "PLATFORM_PROVIDER_VERSIONS", "PLATFORM_PROVIDER_VERSION_COLUMN", "PROTOCOL_VERSION_20121101", "PROTOCOL_VERSION_20130502", "PROTOCOL_VERSION_20130618", "PROTOCOL_VERSION_20131024", "PROTOCOL_VERSION_20131107", "PROTOCOL_VERSION_20140204", "PROTOCOL_VERSION_20140313", "PROTOCOL_VERSION_20140324", "PROTOCOL_VERSION_20140701", "PROTOCOL_VERSION_20141001", "PROTOCOL_VERSION_20141028", "PROTOCOL_VERSION_20141107", "PROTOCOL_VERSION_20141218", "PROTOCOL_VERSION_20150401", "PROTOCOL_VERSION_20150702", "PROTOCOL_VERSION_20160327", "PROTOCOL_VERSION_20161017", "PROTOCOL_VERSION_20170213", "PROTOCOL_VERSION_20170411", "PROTOCOL_VERSION_20170417", "PROTOCOL_VERSION_20171115", "PROTOCOL_VERSION_20210906", "RESULT_ARGS_ACCESS_TOKEN", "RESULT_ARGS_DIALOG_COMPLETE_KEY", "RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY", "RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH", "RESULT_ARGS_GRAPH_DOMAIN", "RESULT_ARGS_PERMISSIONS", "RESULT_ARGS_SIGNED_REQUEST", "STATUS_ERROR_CODE", "STATUS_ERROR_DESCRIPTION", "STATUS_ERROR_JSON", "STATUS_ERROR_SUBCODE", "STATUS_ERROR_TYPE", "TAG", "kotlin.jvm.PlatformType", "WEB_DIALOG_ACTION", "WEB_DIALOG_IS_FALLBACK", "WEB_DIALOG_PARAMS", "WEB_DIALOG_URL", "actionToAppInfoMap", "", "", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "effectCameraAppInfoList", "facebookAppInfoList", "protocolVersionsAsyncUpdating", "Ljava/util/concurrent/atomic/AtomicBoolean;", "buildActionToAppInfoMap", "buildEffectCameraAppInfoList", "buildFacebookAppList", "buildPlatformProviderVersionURI", "Landroid/net/Uri;", "appInfo", "computeLatestAvailableVersionFromVersionSpec", "allAvailableFacebookAppVersions", "Ljava/util/TreeSet;", "latestSdkVersion", "versionSpec", "", "createBundleForException", "Landroid/os/Bundle;", "e", "Lcom/facebook/FacebookException;", "createInstagramIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "applicationId", "permissions", "", "e2e", "isRerequest", "", "isForPublish", "defaultAudience", "Lcom/facebook/login/DefaultAudience;", "clientState", "authType", "messengerPageId", "resetMessengerState", "isFamilyLogin", "shouldSkipAccountDedupe", "createNativeAppIntent", "ignoreAppSwitchToLoggedOut", "targetApp", "Lcom/facebook/login/LoginTargetApp;", "nonce", "codeChallenge", "codeChallengeMethod", "createPlatformActivityIntent", "callId", "action", "versionResult", "Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "extras", "createPlatformServiceIntent", "createProtocolResultIntent", "requestIntent", "results", "error", "createProxyAuthIntents", "fetchAllAvailableProtocolVersionsForAppInfo", "getBridgeArgumentsFromIntent", "intent", "getCallIdFromIntent", "Ljava/util/UUID;", "getErrorDataFromResultIntent", "resultIntent", "getExceptionFromErrorData", "errorData", "getLatestAvailableProtocolVersionForAction", "getLatestAvailableProtocolVersionForAppInfoList", "appInfoList", "getLatestAvailableProtocolVersionForService", "minimumVersion", "getLatestKnownVersion", "getMethodArgumentsFromIntent", "getProtocolVersionFromIntent", "getSuccessResultsFromIntent", "isErrorResult", "isVersionCompatibleWithBucketedIntent", "version", "setupProtocolRequestIntent", "", "params", "updateAllAvailableProtocolVersionsAsync", "validateActivityIntent", "validateServiceIntent", "EffectTestAppInfo", "InstagramAppInfo", "KatanaAppInfo", "MessengerAppInfo", "NativeAppInfo", "ProtocolVersionQueryResult", "WakizashiAppInfo", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class NativeProtocol {
    @NotNull
    public static final String ACTION_APPINVITE_DIALOG = "com.facebook.platform.action.request.APPINVITES_DIALOG";
    @NotNull
    public static final String ACTION_CAMERA_EFFECT = "com.facebook.platform.action.request.CAMERA_EFFECT";
    @NotNull
    public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
    @NotNull
    public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";
    @NotNull
    public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
    @NotNull
    public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    @NotNull
    public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    @NotNull
    public static final String ACTION_SHARE_STORY = "com.facebook.platform.action.request.SHARE_STORY";
    @NotNull
    public static final String AUDIENCE_EVERYONE = "everyone";
    @NotNull
    public static final String AUDIENCE_FRIENDS = "friends";
    @NotNull
    public static final String AUDIENCE_ME = "only_me";
    @NotNull
    public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";
    @NotNull
    public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";
    @NotNull
    public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";
    @NotNull
    public static final String BRIDGE_ARG_ERROR_CODE = "error_code";
    @NotNull
    public static final String BRIDGE_ARG_ERROR_DESCRIPTION = "error_description";
    @NotNull
    public static final String BRIDGE_ARG_ERROR_JSON = "error_json";
    @NotNull
    public static final String BRIDGE_ARG_ERROR_SUBCODE = "error_subcode";
    @NotNull
    public static final String BRIDGE_ARG_ERROR_TYPE = "error_type";
    @NotNull
    private static final String CONTENT_SCHEME = "content://";
    @NotNull
    public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
    @NotNull
    public static final String ERROR_NETWORK_ERROR = "NetworkError";
    @NotNull
    public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
    @NotNull
    public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
    @NotNull
    public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
    @NotNull
    public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
    @NotNull
    public static final String ERROR_USER_CANCELED = "UserCanceled";
    @NotNull
    public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
    @NotNull
    public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
    @NotNull
    public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
    @NotNull
    public static final String EXTRA_AUTHENTICATION_TOKEN = "com.facebook.platform.extra.ID_TOKEN";
    @NotNull
    public static final String EXTRA_DATA_ACCESS_EXPIRATION_TIME = "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME";
    @NotNull
    public static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";
    @NotNull
    public static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";
    @NotNull
    public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
    @NotNull
    public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
    @NotNull
    public static final String EXTRA_GRAPH_API_VERSION = "com.facebook.platform.extra.GRAPH_API_VERSION";
    @NotNull
    public static final String EXTRA_LOGGER_REF = "com.facebook.platform.extra.LOGGER_REF";
    @NotNull
    public static final String EXTRA_NONCE = "com.facebook.platform.extra.NONCE";
    @NotNull
    public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
    @NotNull
    public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
    @NotNull
    public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";
    @NotNull
    public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
    @NotNull
    public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";
    @NotNull
    public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";
    @NotNull
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
    @NotNull
    public static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";
    @NotNull
    public static final String EXTRA_TOAST_DURATION_MS = "com.facebook.platform.extra.EXTRA_TOAST_DURATION_MS";
    @NotNull
    public static final String EXTRA_USER_ID = "com.facebook.platform.extra.USER_ID";
    @NotNull
    private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
    @NotNull
    public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
    @NotNull
    public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
    @NotNull
    public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
    @NotNull
    public static final String FACEBOOK_SDK_VERSION_KEY = "facebook_sdk_version";
    @NotNull
    private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
    @NotNull
    public static final String IMAGE_URL_KEY = "url";
    @NotNull
    public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
    @NotNull
    public static final NativeProtocol INSTANCE;
    @NotNull
    public static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";
    @NotNull
    public static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";
    @NotNull
    private static final Integer[] KNOWN_PROTOCOL_VERSIONS = {Integer.valueOf(PROTOCOL_VERSION_20210906), Integer.valueOf(PROTOCOL_VERSION_20171115), Integer.valueOf(PROTOCOL_VERSION_20170417), Integer.valueOf(PROTOCOL_VERSION_20170411), Integer.valueOf(PROTOCOL_VERSION_20170213), Integer.valueOf(PROTOCOL_VERSION_20161017), Integer.valueOf(PROTOCOL_VERSION_20160327), Integer.valueOf(PROTOCOL_VERSION_20150702), Integer.valueOf(PROTOCOL_VERSION_20150401), Integer.valueOf(PROTOCOL_VERSION_20141218), Integer.valueOf(PROTOCOL_VERSION_20141107), Integer.valueOf(PROTOCOL_VERSION_20141028), Integer.valueOf(PROTOCOL_VERSION_20141001), Integer.valueOf(PROTOCOL_VERSION_20140701), Integer.valueOf(PROTOCOL_VERSION_20140324), Integer.valueOf(PROTOCOL_VERSION_20140313), Integer.valueOf(PROTOCOL_VERSION_20140204), Integer.valueOf(PROTOCOL_VERSION_20131107), Integer.valueOf(PROTOCOL_VERSION_20131024), Integer.valueOf(PROTOCOL_VERSION_20130618), Integer.valueOf(PROTOCOL_VERSION_20130502), Integer.valueOf(PROTOCOL_VERSION_20121101)};
    public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY = 65545;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST = 65544;
    public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
    public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
    public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
    public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
    public static final int MESSAGE_GET_LOGIN_STATUS_REPLY = 65547;
    public static final int MESSAGE_GET_LOGIN_STATUS_REQUEST = 65546;
    public static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 65539;
    public static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 65538;
    public static final int NO_PROTOCOL_AVAILABLE = -1;
    @NotNull
    public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
    @NotNull
    private static final String PLATFORM_PROVIDER = ".provider.PlatformProvider";
    @NotNull
    private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";
    @NotNull
    private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
    public static final int PROTOCOL_VERSION_20121101 = 20121101;
    public static final int PROTOCOL_VERSION_20130502 = 20130502;
    public static final int PROTOCOL_VERSION_20130618 = 20130618;
    public static final int PROTOCOL_VERSION_20131024 = 20131024;
    public static final int PROTOCOL_VERSION_20131107 = 20131107;
    public static final int PROTOCOL_VERSION_20140204 = 20140204;
    public static final int PROTOCOL_VERSION_20140313 = 20140313;
    public static final int PROTOCOL_VERSION_20140324 = 20140324;
    public static final int PROTOCOL_VERSION_20140701 = 20140701;
    public static final int PROTOCOL_VERSION_20141001 = 20141001;
    public static final int PROTOCOL_VERSION_20141028 = 20141028;
    public static final int PROTOCOL_VERSION_20141107 = 20141107;
    public static final int PROTOCOL_VERSION_20141218 = 20141218;
    public static final int PROTOCOL_VERSION_20150401 = 20150401;
    public static final int PROTOCOL_VERSION_20150702 = 20150702;
    public static final int PROTOCOL_VERSION_20160327 = 20160327;
    public static final int PROTOCOL_VERSION_20161017 = 20161017;
    public static final int PROTOCOL_VERSION_20170213 = 20170213;
    public static final int PROTOCOL_VERSION_20170411 = 20170411;
    public static final int PROTOCOL_VERSION_20170417 = 20170417;
    public static final int PROTOCOL_VERSION_20171115 = 20171115;
    public static final int PROTOCOL_VERSION_20210906 = 20210906;
    @NotNull
    public static final String RESULT_ARGS_ACCESS_TOKEN = "access_token";
    @NotNull
    public static final String RESULT_ARGS_DIALOG_COMPLETE_KEY = "didComplete";
    @NotNull
    public static final String RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY = "completionGesture";
    @NotNull
    public static final String RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH = "expires_seconds_since_epoch";
    @NotNull
    public static final String RESULT_ARGS_GRAPH_DOMAIN = "graph_domain";
    @NotNull
    public static final String RESULT_ARGS_PERMISSIONS = "permissions";
    @NotNull
    public static final String RESULT_ARGS_SIGNED_REQUEST = "signed request";
    @NotNull
    public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
    @NotNull
    public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
    @NotNull
    public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
    @NotNull
    public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
    @NotNull
    public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
    /* access modifiers changed from: private */
    public static final String TAG = NativeProtocol.class.getName();
    @NotNull
    public static final String WEB_DIALOG_ACTION = "action";
    @NotNull
    public static final String WEB_DIALOG_IS_FALLBACK = "is_fallback";
    @NotNull
    public static final String WEB_DIALOG_PARAMS = "params";
    @NotNull
    public static final String WEB_DIALOG_URL = "url";
    @NotNull
    private static final Map<String, List<NativeAppInfo>> actionToAppInfoMap;
    @NotNull
    private static final List<NativeAppInfo> effectCameraAppInfoList;
    @NotNull
    private static final List<NativeAppInfo> facebookAppInfoList;
    @NotNull
    private static final AtomicBoolean protocolVersionsAsyncUpdating = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$EffectTestAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EffectTestAppInfo extends NativeAppInfo {
        @Nullable
        public Void getLoginActivity() {
            return null;
        }

        @NotNull
        public String getPackage() {
            return "com.facebook.arstudio.player";
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$InstagramAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "getResponseType", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class InstagramAppInfo extends NativeAppInfo {
        @NotNull
        public String getLoginActivity() {
            return "com.instagram.platform.AppAuthorizeActivity";
        }

        @NotNull
        public String getPackage() {
            return "com.instagram.android";
        }

        @NotNull
        public String getResponseType() {
            return ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/facebook/internal/NativeProtocol$KatanaAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "isAndroidAPIVersionNotLessThan30", "", "onAvailableVersionsNullOrEmpty", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class KatanaAppInfo extends NativeAppInfo {
        private final boolean isAndroidAPIVersionNotLessThan30() {
            if (FacebookSdk.getApplicationContext().getApplicationInfo().targetSdkVersion >= 30) {
                return true;
            }
            return false;
        }

        @NotNull
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }

        @NotNull
        public String getPackage() {
            return "com.facebook.katana";
        }

        public void onAvailableVersionsNullOrEmpty() {
            if (isAndroidAPIVersionNotLessThan30()) {
                Log.w(NativeProtocol.TAG, "Apps that target Android API 30+ (Android 11+) cannot call Facebook native apps unless the package visibility needs are declared. Please follow https://developers.facebook.com/docs/android/troubleshooting/#faq_267321845055988 to make the declaration.");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$MessengerAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class MessengerAppInfo extends NativeAppInfo {
        @Nullable
        public Void getLoginActivity() {
            return null;
        }

        @NotNull
        public String getPackage() {
            return "com.facebook.orca";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "", "()V", "availableVersions", "Ljava/util/TreeSet;", "", "fetchAvailableVersions", "", "force", "", "getAvailableVersions", "getLoginActivity", "", "getPackage", "getResponseType", "onAvailableVersionsNullOrEmpty", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class NativeAppInfo {
        @Nullable
        private TreeSet<Integer> availableVersions;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) java.lang.Boolean.FALSE) == false) goto L_0x001b;
         */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0033  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized void fetchAvailableVersions(boolean r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                if (r2 != 0) goto L_0x001b
                java.util.TreeSet<java.lang.Integer> r2 = r1.availableVersions     // Catch:{ all -> 0x0038 }
                if (r2 == 0) goto L_0x001b
                if (r2 != 0) goto L_0x000b
                r2 = 0
                goto L_0x0013
            L_0x000b:
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0038 }
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0038 }
            L_0x0013:
                java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0038 }
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r0)     // Catch:{ all -> 0x0038 }
                if (r2 != 0) goto L_0x0023
            L_0x001b:
                com.facebook.internal.NativeProtocol r2 = com.facebook.internal.NativeProtocol.INSTANCE     // Catch:{ all -> 0x0038 }
                java.util.TreeSet r2 = r2.fetchAllAvailableProtocolVersionsForAppInfo(r1)     // Catch:{ all -> 0x0038 }
                r1.availableVersions = r2     // Catch:{ all -> 0x0038 }
            L_0x0023:
                java.util.TreeSet<java.lang.Integer> r2 = r1.availableVersions     // Catch:{ all -> 0x0038 }
                if (r2 == 0) goto L_0x0030
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0038 }
                if (r2 == 0) goto L_0x002e
                goto L_0x0030
            L_0x002e:
                r2 = 0
                goto L_0x0031
            L_0x0030:
                r2 = 1
            L_0x0031:
                if (r2 == 0) goto L_0x0036
                r1.onAvailableVersionsNullOrEmpty()     // Catch:{ all -> 0x0038 }
            L_0x0036:
                monitor-exit(r1)
                return
            L_0x0038:
                r2 = move-exception
                monitor-exit(r1)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.NativeAppInfo.fetchAvailableVersions(boolean):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) java.lang.Boolean.FALSE) == false) goto L_0x0018;
         */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.TreeSet<java.lang.Integer> getAvailableVersions() {
            /*
                r2 = this;
                java.util.TreeSet<java.lang.Integer> r0 = r2.availableVersions
                if (r0 == 0) goto L_0x0018
                if (r0 != 0) goto L_0x0008
                r0 = 0
                goto L_0x0010
            L_0x0008:
                boolean r0 = r0.isEmpty()
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            L_0x0010:
                java.lang.Boolean r1 = java.lang.Boolean.FALSE
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
                if (r0 != 0) goto L_0x001c
            L_0x0018:
                r0 = 0
                r2.fetchAvailableVersions(r0)
            L_0x001c:
                java.util.TreeSet<java.lang.Integer> r0 = r2.availableVersions
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.NativeAppInfo.getAvailableVersions():java.util.TreeSet");
        }

        @Nullable
        public abstract String getLoginActivity();

        @NotNull
        public abstract String getPackage();

        @NotNull
        public String getResponseType() {
            return ServerProtocol.DIALOG_RESPONSE_TYPE_ID_TOKEN_AND_SIGNED_REQUEST;
        }

        public void onAvailableVersionsNullOrEmpty() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "", "()V", "<set-?>", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "appInfo", "getAppInfo", "()Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "", "protocolVersion", "getProtocolVersion", "()I", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ProtocolVersionQueryResult {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        @Nullable
        public NativeAppInfo appInfo;
        /* access modifiers changed from: private */
        public int protocolVersion;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult$Companion;", "", "()V", "create", "Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "nativeAppInfo", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "protocolVersion", "", "createEmpty", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @NotNull
            public final ProtocolVersionQueryResult create(@Nullable NativeAppInfo nativeAppInfo, int i11) {
                ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult((DefaultConstructorMarker) null);
                protocolVersionQueryResult.appInfo = nativeAppInfo;
                protocolVersionQueryResult.protocolVersion = i11;
                return protocolVersionQueryResult;
            }

            @JvmStatic
            @NotNull
            public final ProtocolVersionQueryResult createEmpty() {
                ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult((DefaultConstructorMarker) null);
                protocolVersionQueryResult.protocolVersion = -1;
                return protocolVersionQueryResult;
            }
        }

        private ProtocolVersionQueryResult() {
        }

        public /* synthetic */ ProtocolVersionQueryResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public static final ProtocolVersionQueryResult create(@Nullable NativeAppInfo nativeAppInfo, int i11) {
            return Companion.create(nativeAppInfo, i11);
        }

        @JvmStatic
        @NotNull
        public static final ProtocolVersionQueryResult createEmpty() {
            return Companion.createEmpty();
        }

        @Nullable
        public final NativeAppInfo getAppInfo() {
            return this.appInfo;
        }

        public final int getProtocolVersion() {
            return this.protocolVersion;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/NativeProtocol$WakizashiAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class WakizashiAppInfo extends NativeAppInfo {
        @NotNull
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }

        @NotNull
        public String getPackage() {
            return RemoteServiceWrapper.RECEIVER_SERVICE_PACKAGE_WAKIZASHI;
        }
    }

    static {
        NativeProtocol nativeProtocol = new NativeProtocol();
        INSTANCE = nativeProtocol;
        facebookAppInfoList = nativeProtocol.buildFacebookAppList();
        effectCameraAppInfoList = nativeProtocol.buildEffectCameraAppInfoList();
        actionToAppInfoMap = nativeProtocol.buildActionToAppInfoMap();
    }

    private NativeProtocol() {
    }

    private final Map<String, List<NativeAppInfo>> buildActionToAppInfoMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MessengerAppInfo());
        List<NativeAppInfo> list = facebookAppInfoList;
        hashMap.put(ACTION_OGACTIONPUBLISH_DIALOG, list);
        hashMap.put(ACTION_FEED_DIALOG, list);
        hashMap.put(ACTION_LIKE_DIALOG, list);
        hashMap.put(ACTION_APPINVITE_DIALOG, list);
        hashMap.put(ACTION_MESSAGE_DIALOG, arrayList);
        hashMap.put(ACTION_OGMESSAGEPUBLISH_DIALOG, arrayList);
        hashMap.put(ACTION_CAMERA_EFFECT, effectCameraAppInfoList);
        hashMap.put(ACTION_SHARE_STORY, list);
        return hashMap;
    }

    private final List<NativeAppInfo> buildEffectCameraAppInfoList() {
        ArrayList arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new EffectTestAppInfo());
        arrayListOf.addAll(buildFacebookAppList());
        return arrayListOf;
    }

    private final List<NativeAppInfo> buildFacebookAppList() {
        return CollectionsKt__CollectionsKt.arrayListOf(new KatanaAppInfo(), new WakizashiAppInfo());
    }

    private final Uri buildPlatformProviderVersionURI(NativeAppInfo nativeAppInfo) {
        Uri parse = Uri.parse(CONTENT_SCHEME + nativeAppInfo.getPackage() + PLATFORM_PROVIDER_VERSIONS);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(CONTENT_SCHEME + appInfo.getPackage() + PLATFORM_PROVIDER_VERSIONS)");
        return parse;
    }

    @JvmStatic
    public static final int computeLatestAvailableVersionFromVersionSpec(@Nullable TreeSet<Integer> treeSet, int i11, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "versionSpec");
        if (treeSet == null) {
            return -1;
        }
        int length = iArr.length - 1;
        Iterator<Integer> descendingIterator = treeSet.descendingIterator();
        int i12 = -1;
        while (descendingIterator.hasNext()) {
            Integer next = descendingIterator.next();
            Intrinsics.checkNotNullExpressionValue(next, "fbAppVersion");
            i12 = Math.max(i12, next.intValue());
            while (length >= 0 && iArr[length] > next.intValue()) {
                length--;
            }
            if (length < 0) {
                return -1;
            }
            if (iArr[length] == next.intValue()) {
                if (length % 2 == 0) {
                    return Math.min(i12, i11);
                }
                return -1;
            }
        }
        return -1;
    }

    @JvmStatic
    @Nullable
    public static final Bundle createBundleForException(@Nullable FacebookException facebookException) {
        if (facebookException == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("error_description", facebookException.toString());
        if (facebookException instanceof FacebookOperationCanceledException) {
            bundle.putString(BRIDGE_ARG_ERROR_TYPE, ERROR_USER_CANCELED);
        }
        return bundle;
    }

    @JvmStatic
    @Nullable
    public static final Intent createInstagramIntent(@NotNull Context context, @NotNull String str, @NotNull Collection<String> collection, @NotNull String str2, boolean z11, boolean z12, @NotNull DefaultAudience defaultAudience, @NotNull String str3, @NotNull String str4, @Nullable String str5, boolean z13, boolean z14, boolean z15) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "applicationId");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        Intrinsics.checkNotNullParameter(str2, "e2e");
        Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
        Intrinsics.checkNotNullParameter(str3, "clientState");
        Intrinsics.checkNotNullParameter(str4, "authType");
        InstagramAppInfo instagramAppInfo = r13;
        InstagramAppInfo instagramAppInfo2 = new InstagramAppInfo();
        return validateActivityIntent(context2, INSTANCE.createNativeAppIntent(instagramAppInfo, str, collection, str2, z12, defaultAudience, str3, str4, false, str5, z13, LoginTargetApp.INSTAGRAM, z14, z15, "", (String) null, (String) null), instagramAppInfo2);
    }

    private final Intent createNativeAppIntent(NativeAppInfo nativeAppInfo, String str, Collection<String> collection, String str2, boolean z11, DefaultAudience defaultAudience, String str3, String str4, boolean z12, String str5, boolean z13, LoginTargetApp loginTargetApp, boolean z14, boolean z15, String str6, String str7, String str8) {
        String loginActivity = nativeAppInfo.getLoginActivity();
        if (loginActivity == null) {
            return null;
        }
        String str9 = str;
        Intent putExtra = new Intent().setClassName(nativeAppInfo.getPackage(), loginActivity).putExtra("client_id", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent()\n            .setClassName(appInfo.getPackage(), activityName)\n            .putExtra(FACEBOOK_PROXY_AUTH_APP_ID_KEY, applicationId)");
        putExtra.putExtra(FACEBOOK_SDK_VERSION_KEY, FacebookSdk.getSdkVersion());
        if (!Utility.isNullOrEmpty((Collection<?>) collection)) {
            putExtra.putExtra("scope", TextUtils.join(",", collection));
        }
        if (!Utility.isNullOrEmpty(str2)) {
            String str10 = str2;
            putExtra.putExtra("e2e", str2);
        }
        String str11 = str3;
        putExtra.putExtra("state", str3);
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, nativeAppInfo.getResponseType());
        putExtra.putExtra("nonce", str6);
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, "true");
        if (z11) {
            putExtra.putExtra("default_audience", defaultAudience.getNativeProtocolAudience());
        }
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_LEGACY_OVERRIDE, FacebookSdk.getGraphApiVersion());
        String str12 = str4;
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, str4);
        if (z12) {
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_FAIL_ON_LOGGED_OUT, true);
        }
        String str13 = str5;
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_MESSENGER_PAGE_ID, str5);
        boolean z16 = z13;
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RESET_MESSENGER_STATE, z13);
        if (z14) {
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_FX_APP, loginTargetApp.toString());
        }
        if (z15) {
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_SKIP_DEDUPE, true);
        }
        return putExtra;
    }

    @JvmStatic
    @Nullable
    public static final Intent createPlatformActivityIntent(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable ProtocolVersionQueryResult protocolVersionQueryResult, @Nullable Bundle bundle) {
        NativeAppInfo appInfo;
        Intent validateActivityIntent;
        Intrinsics.checkNotNullParameter(context, "context");
        if (protocolVersionQueryResult == null || (appInfo = protocolVersionQueryResult.getAppInfo()) == null || (validateActivityIntent = validateActivityIntent(context, new Intent().setAction(INTENT_ACTION_PLATFORM_ACTIVITY).setPackage(appInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), appInfo)) == null) {
            return null;
        }
        setupProtocolRequestIntent(validateActivityIntent, str, str2, protocolVersionQueryResult.getProtocolVersion(), bundle);
        return validateActivityIntent;
    }

    @JvmStatic
    @Nullable
    public static final Intent createPlatformServiceIntent(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        for (NativeAppInfo next : facebookAppInfoList) {
            Intent validateServiceIntent = validateServiceIntent(context, new Intent(INTENT_ACTION_PLATFORM_SERVICE).setPackage(next.getPackage()).addCategory("android.intent.category.DEFAULT"), next);
            if (validateServiceIntent != null) {
                return validateServiceIntent;
            }
        }
        return null;
    }

    @JvmStatic
    @Nullable
    public static final Intent createProtocolResultIntent(@NotNull Intent intent, @Nullable Bundle bundle, @Nullable FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(intent, "requestIntent");
        UUID callIdFromIntent = getCallIdFromIntent(intent);
        if (callIdFromIntent == null) {
            return null;
        }
        Intent intent2 = new Intent();
        intent2.putExtra(EXTRA_PROTOCOL_VERSION, getProtocolVersionFromIntent(intent));
        Bundle bundle2 = new Bundle();
        bundle2.putString("action_id", callIdFromIntent.toString());
        if (facebookException != null) {
            bundle2.putBundle("error", createBundleForException(facebookException));
        }
        intent2.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
        if (bundle != null) {
            intent2.putExtra(EXTRA_PROTOCOL_METHOD_RESULTS, bundle);
        }
        return intent2;
    }

    @JvmStatic
    @NotNull
    public static final List<Intent> createProxyAuthIntents(@Nullable Context context, @NotNull String str, @NotNull Collection<String> collection, @NotNull String str2, boolean z11, boolean z12, @NotNull DefaultAudience defaultAudience, @NotNull String str3, @NotNull String str4, boolean z13, @Nullable String str5, boolean z14, boolean z15, boolean z16, @Nullable String str6, @Nullable String str7, @Nullable String str8) {
        Intrinsics.checkNotNullParameter(str, "applicationId");
        Intrinsics.checkNotNullParameter(collection, "permissions");
        Intrinsics.checkNotNullParameter(str2, "e2e");
        Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
        Intrinsics.checkNotNullParameter(str3, "clientState");
        Intrinsics.checkNotNullParameter(str4, "authType");
        ArrayList arrayList = new ArrayList();
        Iterator it = facebookAppInfoList.iterator();
        while (it.hasNext()) {
            Iterator it2 = it;
            ArrayList arrayList2 = arrayList;
            Intent createNativeAppIntent = INSTANCE.createNativeAppIntent((NativeAppInfo) it.next(), str, collection, str2, z12, defaultAudience, str3, str4, z13, str5, z14, LoginTargetApp.FACEBOOK, z15, z16, str6, str7, str8);
            if (createNativeAppIntent != null) {
                arrayList2.add(createNativeAppIntent);
            }
            String str9 = str;
            Collection<String> collection2 = collection;
            String str10 = str2;
            DefaultAudience defaultAudience2 = defaultAudience;
            String str11 = str3;
            String str12 = str4;
            arrayList = arrayList2;
            it = it2;
        }
        return arrayList;
    }

    public static /* synthetic */ List createProxyAuthIntents$default(Context context, String str, Collection collection, String str2, boolean z11, boolean z12, DefaultAudience defaultAudience, String str3, String str4, boolean z13, String str5, boolean z14, boolean z15, boolean z16, String str6, String str7, String str8, int i11, Object obj) {
        return createProxyAuthIntents(context, str, collection, str2, z11, z12, defaultAudience, str3, str4, z13, str5, z14, z15, z16, str6, str7, (i11 & 65536) != 0 ? "S256" : str8);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0044 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.TreeSet<java.lang.Integer> fetchAllAvailableProtocolVersionsForAppInfo(com.facebook.internal.NativeProtocol.NativeAppInfo r11) {
        /*
            r10 = this;
            java.lang.String r0 = "Failed to query content resolver."
            java.util.TreeSet r1 = new java.util.TreeSet
            r1.<init>()
            android.content.Context r2 = com.facebook.FacebookSdk.getApplicationContext()
            android.content.ContentResolver r3 = r2.getContentResolver()
            java.lang.String r2 = "version"
            java.lang.String[] r5 = new java.lang.String[]{r2}
            android.net.Uri r4 = r10.buildPlatformProviderVersionURI(r11)
            r9 = 0
            android.content.Context r6 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x0074 }
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch:{ all -> 0x0074 }
            java.lang.String r11 = r11.getPackage()     // Catch:{ all -> 0x0074 }
            java.lang.String r7 = ".provider.PlatformProvider"
            java.lang.String r11 = kotlin.jvm.internal.Intrinsics.stringPlus(r11, r7)     // Catch:{ all -> 0x0074 }
            r7 = 0
            android.content.pm.ProviderInfo r11 = r6.resolveContentProvider(r11, r7)     // Catch:{ RuntimeException -> 0x0032 }
            goto L_0x0039
        L_0x0032:
            r11 = move-exception
            java.lang.String r6 = TAG     // Catch:{ all -> 0x0074 }
            android.util.Log.e(r6, r0, r11)     // Catch:{ all -> 0x0074 }
            r11 = r9
        L_0x0039:
            if (r11 == 0) goto L_0x006d
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r11 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ NullPointerException -> 0x0050, SecurityException -> 0x004a, IllegalArgumentException -> 0x0044 }
            r9 = r11
            goto L_0x0055
        L_0x0044:
            java.lang.String r11 = TAG     // Catch:{ all -> 0x0074 }
            android.util.Log.e(r11, r0)     // Catch:{ all -> 0x0074 }
            goto L_0x0055
        L_0x004a:
            java.lang.String r11 = TAG     // Catch:{ all -> 0x0074 }
            android.util.Log.e(r11, r0)     // Catch:{ all -> 0x0074 }
            goto L_0x0055
        L_0x0050:
            java.lang.String r11 = TAG     // Catch:{ all -> 0x0074 }
            android.util.Log.e(r11, r0)     // Catch:{ all -> 0x0074 }
        L_0x0055:
            if (r9 == 0) goto L_0x006d
        L_0x0057:
            boolean r11 = r9.moveToNext()     // Catch:{ all -> 0x0074 }
            if (r11 == 0) goto L_0x006d
            int r11 = r9.getColumnIndex(r2)     // Catch:{ all -> 0x0074 }
            int r11 = r9.getInt(r11)     // Catch:{ all -> 0x0074 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0074 }
            r1.add(r11)     // Catch:{ all -> 0x0074 }
            goto L_0x0057
        L_0x006d:
            if (r9 != 0) goto L_0x0070
            goto L_0x0073
        L_0x0070:
            r9.close()
        L_0x0073:
            return r1
        L_0x0074:
            r11 = move-exception
            if (r9 != 0) goto L_0x0078
            goto L_0x007b
        L_0x0078:
            r9.close()
        L_0x007b:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(com.facebook.internal.NativeProtocol$NativeAppInfo):java.util.TreeSet");
    }

    @JvmStatic
    @Nullable
    public static final Bundle getBridgeArgumentsFromIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
            return null;
        }
        return intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
    }

    @JvmStatic
    @Nullable
    public static final UUID getCallIdFromIntent(@Nullable Intent intent) {
        String str;
        if (intent == null) {
            return null;
        }
        if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
            Bundle bundleExtra = intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
            if (bundleExtra != null) {
                str = bundleExtra.getString("action_id");
            } else {
                str = null;
            }
        } else {
            str = intent.getStringExtra(EXTRA_PROTOCOL_CALL_ID);
        }
        if (str == null) {
            return null;
        }
        try {
            return UUID.fromString(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final Bundle getErrorDataFromResultIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "resultIntent");
        if (!isErrorResult(intent)) {
            return null;
        }
        Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
        if (bridgeArgumentsFromIntent != null) {
            return bridgeArgumentsFromIntent.getBundle("error");
        }
        return intent.getExtras();
    }

    @JvmStatic
    @Nullable
    public static final FacebookException getExceptionFromErrorData(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString(BRIDGE_ARG_ERROR_TYPE);
        if (string == null) {
            string = bundle.getString(STATUS_ERROR_TYPE);
        }
        String string2 = bundle.getString("error_description");
        if (string2 == null) {
            string2 = bundle.getString(STATUS_ERROR_DESCRIPTION);
        }
        if (string == null || !StringsKt__StringsJVMKt.equals(string, ERROR_USER_CANCELED, true)) {
            return new FacebookException(string2);
        }
        return new FacebookOperationCanceledException(string2);
    }

    @JvmStatic
    @NotNull
    public static final ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAction(@NotNull String str, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(str, WEB_DIALOG_ACTION);
        Intrinsics.checkNotNullParameter(iArr, "versionSpec");
        List list = actionToAppInfoMap.get(str);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return INSTANCE.getLatestAvailableProtocolVersionForAppInfoList(list, iArr);
    }

    private final ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAppInfoList(List<? extends NativeAppInfo> list, int[] iArr) {
        updateAllAvailableProtocolVersionsAsync();
        if (list == null) {
            return ProtocolVersionQueryResult.Companion.createEmpty();
        }
        for (NativeAppInfo nativeAppInfo : list) {
            int computeLatestAvailableVersionFromVersionSpec = computeLatestAvailableVersionFromVersionSpec(nativeAppInfo.getAvailableVersions(), getLatestKnownVersion(), iArr);
            if (computeLatestAvailableVersionFromVersionSpec != -1) {
                return ProtocolVersionQueryResult.Companion.create(nativeAppInfo, computeLatestAvailableVersionFromVersionSpec);
            }
        }
        return ProtocolVersionQueryResult.Companion.createEmpty();
    }

    @JvmStatic
    public static final int getLatestAvailableProtocolVersionForService(int i11) {
        return INSTANCE.getLatestAvailableProtocolVersionForAppInfoList(facebookAppInfoList, new int[]{i11}).getProtocolVersion();
    }

    @JvmStatic
    public static final int getLatestKnownVersion() {
        return KNOWN_PROTOCOL_VERSIONS[0].intValue();
    }

    @JvmStatic
    @Nullable
    public static final Bundle getMethodArgumentsFromIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
            return intent.getExtras();
        }
        return intent.getBundleExtra(EXTRA_PROTOCOL_METHOD_ARGS);
    }

    @JvmStatic
    public static final int getProtocolVersionFromIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        return intent.getIntExtra(EXTRA_PROTOCOL_VERSION, 0);
    }

    @JvmStatic
    @Nullable
    public static final Bundle getSuccessResultsFromIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "resultIntent");
        int protocolVersionFromIntent = getProtocolVersionFromIntent(intent);
        Bundle extras = intent.getExtras();
        if (!isVersionCompatibleWithBucketedIntent(protocolVersionFromIntent) || extras == null) {
            return extras;
        }
        return extras.getBundle(EXTRA_PROTOCOL_METHOD_RESULTS);
    }

    @JvmStatic
    public static final boolean isErrorResult(@NotNull Intent intent) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(intent, "resultIntent");
        Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
        if (bridgeArgumentsFromIntent == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(bridgeArgumentsFromIntent.containsKey("error"));
        }
        if (bool == null) {
            return intent.hasExtra(STATUS_ERROR_TYPE);
        }
        return bool.booleanValue();
    }

    @JvmStatic
    public static final boolean isVersionCompatibleWithBucketedIntent(int i11) {
        return ArraysKt___ArraysKt.contains((T[]) KNOWN_PROTOCOL_VERSIONS, Integer.valueOf(i11)) && i11 >= 20140701;
    }

    @JvmStatic
    public static final void setupProtocolRequestIntent(@NotNull Intent intent, @Nullable String str, @Nullable String str2, int i11, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        String applicationId = FacebookSdk.getApplicationId();
        String applicationName = FacebookSdk.getApplicationName();
        intent.putExtra(EXTRA_PROTOCOL_VERSION, i11).putExtra(EXTRA_PROTOCOL_ACTION, str2).putExtra(EXTRA_APPLICATION_ID, applicationId);
        if (isVersionCompatibleWithBucketedIntent(i11)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("action_id", str);
            Utility.putNonEmptyString(bundle2, BRIDGE_ARG_APP_NAME_STRING, applicationName);
            intent.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
            if (bundle == null) {
                bundle = new Bundle();
            }
            intent.putExtra(EXTRA_PROTOCOL_METHOD_ARGS, bundle);
            return;
        }
        intent.putExtra(EXTRA_PROTOCOL_CALL_ID, str);
        if (!Utility.isNullOrEmpty(applicationName)) {
            intent.putExtra(EXTRA_APPLICATION_NAME, applicationName);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
    }

    @JvmStatic
    public static final void updateAllAvailableProtocolVersionsAsync() {
        if (protocolVersionsAsyncUpdating.compareAndSet(false, true)) {
            FacebookSdk.getExecutor().execute(new n());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateAllAvailableProtocolVersionsAsync$lambda-1  reason: not valid java name */
    public static final void m8961updateAllAvailableProtocolVersionsAsync$lambda1() {
        try {
            for (NativeAppInfo fetchAvailableVersions : facebookAppInfoList) {
                fetchAvailableVersions.fetchAvailableVersions(true);
            }
        } finally {
            protocolVersionsAsyncUpdating.set(false);
        }
    }

    @JvmStatic
    @Nullable
    public static final Intent validateActivityIntent(@NotNull Context context, @Nullable Intent intent, @Nullable NativeAppInfo nativeAppInfo) {
        ResolveInfo resolveActivity;
        Intrinsics.checkNotNullParameter(context, "context");
        if (intent == null || (resolveActivity = context.getPackageManager().resolveActivity(intent, 0)) == null) {
            return null;
        }
        FacebookSignatureValidator facebookSignatureValidator = FacebookSignatureValidator.INSTANCE;
        String str = resolveActivity.activityInfo.packageName;
        Intrinsics.checkNotNullExpressionValue(str, "resolveInfo.activityInfo.packageName");
        if (!FacebookSignatureValidator.validateSignature(context, str)) {
            return null;
        }
        return intent;
    }

    @JvmStatic
    @Nullable
    public static final Intent validateServiceIntent(@NotNull Context context, @Nullable Intent intent, @Nullable NativeAppInfo nativeAppInfo) {
        ResolveInfo resolveService;
        Intrinsics.checkNotNullParameter(context, "context");
        if (intent == null || (resolveService = context.getPackageManager().resolveService(intent, 0)) == null) {
            return null;
        }
        FacebookSignatureValidator facebookSignatureValidator = FacebookSignatureValidator.INSTANCE;
        String str = resolveService.serviceInfo.packageName;
        Intrinsics.checkNotNullExpressionValue(str, "resolveInfo.serviceInfo.packageName");
        if (!FacebookSignatureValidator.validateSignature(context, str)) {
            return null;
        }
        return intent;
    }
}
