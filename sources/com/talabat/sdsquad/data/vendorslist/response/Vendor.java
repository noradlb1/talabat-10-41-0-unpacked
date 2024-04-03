package com.talabat.sdsquad.data.vendorslist.response;

import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0003\b\u0002\b\b\u0018\u00002\u00020\u0001Bÿ\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\b\u00100\u001a\u0004\u0018\u00010\u0003\u0012\b\u00101\u001a\u0004\u0018\u00010\u0003\u0012\b\u00102\u001a\u0004\u0018\u00010\u0003\u0012\b\u00103\u001a\u0004\u0018\u00010\u0003\u0012\b\u00104\u001a\u0004\u0018\u00010\u0003\u0012\b\u00105\u001a\u0004\u0018\u00010\u0003\u0012\b\u00106\u001a\u0004\u0018\u00010\u0003\u0012\b\u00107\u001a\u0004\u0018\u00010\u0003\u0012\b\u00108\u001a\u0004\u0018\u00010\u0003\u0012\b\u00109\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010=\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010>\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010?\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010@\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010A\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010C\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010D\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010E\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010F\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010G\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010H\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010I\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010J\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010K\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010L\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010M\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010N\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010O\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010P\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010Q\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010R\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010S\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010T\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010U\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010V\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010W\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010X\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010Y\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010Z\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010[\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\\\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010]\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010^\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010_\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010`J\u0011\u0010Á\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\f\u0010Â\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010Å\u0001\u001a\u00020\u0011HÆ\u0003J\f\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010È\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\f\u0010É\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0012\u0010Ê\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017HÆ\u0003J\u0011\u0010Ë\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010Ì\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\f\u0010Í\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010Î\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010~J\f\u0010Ï\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010Ð\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010~J\f\u0010Ò\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0012\u0010Ó\u0001\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017HÆ\u0003J\u0011\u0010Ô\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010Õ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010Ö\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010~J\u0011\u0010×\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\f\u0010Ø\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010Ù\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010Ú\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010Û\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010Þ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010ß\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010à\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010~J\u0011\u0010á\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\f\u0010â\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010ã\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010ä\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010å\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010æ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010ç\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010è\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010é\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010ê\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010ë\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010ì\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010í\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010î\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010ï\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010ð\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010ñ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\f\u0010ò\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010ó\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010ô\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010õ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010ö\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010÷\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010~J\f\u0010ø\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010ù\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010ú\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010~J\u0011\u0010û\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010~J\f\u0010ü\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010ý\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010~J\f\u0010þ\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010~J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010~J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010~J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010zJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010zJ\f\u0010\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010~J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010~J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010~J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010~J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010bJ\f\u0010\u0002\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jº\b\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00172\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010\u0002J\u0015\u0010\u0002\u001a\u00020\u00032\t\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0002\u001a\u00020\u0011HÖ\u0001J\n\u0010\u0002\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010c\u001a\u0004\ba\u0010bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010c\u001a\u0004\bd\u0010bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010c\u001a\u0004\be\u0010bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010c\u001a\u0004\bh\u0010bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010gR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010gR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010gR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010gR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010gR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010gR\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010gR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010gR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010c\u001a\u0004\bu\u0010bR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010gR\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0004¢\u0006\n\n\u0002\u0010{\u001a\u0004\by\u0010zR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010gR\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001a\u0004\b}\u0010~R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010gR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010gR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\u000b\n\u0002\u0010\u001a\u0005\b\u0001\u0010~R\u0019\u0010 \u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010gR\u001f\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00178\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010xR\u001b\u0010\"\u001a\u0004\u0018\u00010\u001a8\u0006X\u0004¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b\u0001\u0010zR\u001b\u0010#\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u0010$\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\u000b\n\u0002\u0010\u001a\u0005\b\u0001\u0010~R\u0019\u0010%\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010gR\u001b\u0010&\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u0010'\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u0010(\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u0010)\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u0010*\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u0010+\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u0010,\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u0010-\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\u000b\n\u0002\u0010\u001a\u0005\b\u0001\u0010~R\u001b\u0010.\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u0010/\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u00100\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u00101\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u00102\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001a\u0010_\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010c\u001a\u0004\b_\u0010bR\u001a\u00103\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010c\u001a\u0004\b3\u0010bR\u001b\u00104\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u00105\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u00106\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u00107\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u00108\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u00109\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u0010:\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u0010;\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u001b\u0010<\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b\u0001\u0010bR\u0019\u0010=\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010gR\u0019\u0010>\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b \u0001\u0010gR\u0019\u0010?\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b¡\u0001\u0010gR\u001b\u0010@\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b¢\u0001\u0010bR\u001b\u0010A\u001a\u0004\u0018\u00010\u001a8\u0006X\u0004¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b£\u0001\u0010zR\u001b\u0010B\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\u000b\n\u0002\u0010\u001a\u0005\b¤\u0001\u0010~R\u001b\u0010C\u001a\u0004\u0018\u00010\u001a8\u0006X\u0004¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b¥\u0001\u0010zR\u001b\u0010D\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\u000b\n\u0002\u0010\u001a\u0005\b¦\u0001\u0010~R\u001b\u0010E\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\u000b\n\u0002\u0010\u001a\u0005\b§\u0001\u0010~R\u0019\u0010F\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b¨\u0001\u0010gR\u001b\u0010G\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\u000b\n\u0002\u0010\u001a\u0005\b©\u0001\u0010~R\u0019\u0010H\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\bª\u0001\u0010gR\u0019\u0010I\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b«\u0001\u0010gR\u001b\u0010^\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\u000b\n\u0002\u0010\u001a\u0005\b¬\u0001\u0010~R\u0019\u0010J\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b­\u0001\u0010gR\u001b\u0010K\u001a\u0004\u0018\u00010\u001a8\u0006X\u0004¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b®\u0001\u0010zR\u001b\u0010L\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000b\n\u0002\u0010c\u001a\u0005\b¯\u0001\u0010bR\u001b\u0010M\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\u000b\n\u0002\u0010\u001a\u0005\b°\u0001\u0010~R\u001b\u0010N\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\u000b\n\u0002\u0010\u001a\u0005\b±\u0001\u0010~R\u0019\u0010O\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b²\u0001\u0010gR\u0019\u0010P\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b³\u0001\u0010gR\u0019\u0010Q\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b´\u0001\u0010gR\u001b\u0010R\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\u000b\n\u0002\u0010\u001a\u0005\bµ\u0001\u0010~R\u001b\u0010S\u001a\u0004\u0018\u00010\u001a8\u0006X\u0004¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b¶\u0001\u0010zR\u001b\u0010T\u001a\u0004\u0018\u00010\u001a8\u0006X\u0004¢\u0006\u000b\n\u0002\u0010{\u001a\u0005\b·\u0001\u0010zR\u0019\u0010U\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b¸\u0001\u0010gR\u0019\u0010V\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b¹\u0001\u0010gR\u0019\u0010W\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\bº\u0001\u0010gR\u001b\u0010X\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\u000b\n\u0002\u0010\u001a\u0005\b»\u0001\u0010~R\u0019\u0010Y\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b¼\u0001\u0010gR\u001b\u0010Z\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\u000b\n\u0002\u0010\u001a\u0005\b½\u0001\u0010~R\u0019\u0010[\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b¾\u0001\u0010gR\u0019\u0010\\\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\t\n\u0000\u001a\u0005\b¿\u0001\u0010gR\u001b\u0010]\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\u000b\n\u0002\u0010\u001a\u0005\bÀ\u0001\u0010~¨\u0006\u0002"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/response/Vendor;", "", "ac", "", "acod", "acr", "act", "", "adb", "adc", "aid", "amt", "an", "atbt", "att", "avd", "bid", "", "bna", "bsl", "cav", "css", "cus", "", "Lcom/talabat/sdsquad/data/vendorslist/response/Cuisine;", "dch", "", "dcl", "dct", "des", "dls", "dtim", "dtxt", "fids", "finalRank", "fm", "gid", "gtl", "hasv", "hrd", "hsp", "htc", "htd", "iccm", "icr", "id", "ida", "inc", "ipa", "ipos", "ipt", "isVatInc", "isd", "isds", "ism", "isn", "iss", "isub", "itg", "ius", "iush", "lat", "lg", "lon", "mav", "mcc", "mdis", "mna", "mpro", "mtyp", "na", "pdto", "pmsg", "pri", "ptxt", "rat", "rgrl", "sha", "shc", "sl", "smr", "st", "stt", "tch", "trc", "trt", "trts", "ttrev", "ttyp", "uscom", "uscomid", "usicon", "ust", "verticalType", "priceTag", "isSafeDropOff", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getAc", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAcod", "getAcr", "getAct", "()Ljava/lang/String;", "getAdb", "getAdc", "getAid", "()Ljava/lang/Object;", "getAmt", "getAn", "getAtbt", "getAtt", "getAvd", "getBid", "()I", "getBna", "getBsl", "getCav", "getCss", "getCus", "()Ljava/util/List;", "getDch", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDcl", "getDct", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDes", "getDls", "getDtim", "getDtxt", "getFids", "getFinalRank", "getFm", "getGid", "getGtl", "getHasv", "getHrd", "getHsp", "getHtc", "getHtd", "getIccm", "getIcr", "getId", "getIda", "getInc", "getIpa", "getIpos", "getIpt", "getIsd", "getIsds", "getIsm", "getIsn", "getIss", "getIsub", "getItg", "getIus", "getIush", "getLat", "getLg", "getLon", "getMav", "getMcc", "getMdis", "getMna", "getMpro", "getMtyp", "getNa", "getPdto", "getPmsg", "getPri", "getPriceTag", "getPtxt", "getRat", "getRgrl", "getSha", "getShc", "getSl", "getSmr", "getSt", "getStt", "getTch", "getTrc", "getTrt", "getTrts", "getTtrev", "getTtyp", "getUscom", "getUscomid", "getUsicon", "getUst", "getVerticalType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component7", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "component77", "component78", "component79", "component8", "component80", "component81", "component82", "component83", "component84", "component85", "component86", "component87", "component88", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/talabat/sdsquad/data/vendorslist/response/Vendor;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Vendor {
    @SerializedName("ac")
    @Nullable

    /* renamed from: ac  reason: collision with root package name */
    private final Boolean f61319ac;
    @SerializedName("acod")
    @Nullable
    private final Boolean acod;
    @SerializedName("acr")
    @Nullable
    private final Boolean acr;
    @SerializedName("act")
    @Nullable
    private final String act;
    @SerializedName("adb")
    @Nullable
    private final Boolean adb;
    @SerializedName("adc")
    @Nullable
    private final String adc;
    @SerializedName("aid")
    @Nullable
    private final Object aid;
    @SerializedName("amt")
    @Nullable
    private final String amt;
    @SerializedName("an")
    @Nullable

    /* renamed from: an  reason: collision with root package name */
    private final String f61320an;
    @SerializedName("atbt")
    @Nullable
    private final String atbt;
    @SerializedName("att")
    @Nullable
    private final String att;
    @SerializedName("avd")
    @Nullable
    private final String avd;
    @SerializedName("bid")
    private final int bid;
    @SerializedName("bna")
    @Nullable
    private final String bna;
    @SerializedName("bsl")
    @Nullable
    private final String bsl;
    @SerializedName("cav")
    @Nullable
    private final Boolean cav;
    @SerializedName("css")
    @Nullable
    private final String css;
    @SerializedName("cus")
    @Nullable
    private final List<Cuisine> cus;
    @SerializedName("dch")
    @Nullable
    private final Double dch;
    @SerializedName("dcl")
    @Nullable
    private final String dcl;
    @SerializedName("dct")
    @Nullable
    private final Integer dct;
    @SerializedName("des")
    @Nullable
    private final String des;
    @SerializedName("dls")
    @Nullable
    private final String dls;
    @SerializedName("dtim")
    @Nullable
    private final Integer dtim;
    @SerializedName("dtxt")
    @Nullable
    private final String dtxt;
    @SerializedName("fids")
    @Nullable
    private final List<Integer> fids;
    @SerializedName("finalRank")
    @Nullable
    private final Double finalRank;
    @SerializedName("fm")
    @Nullable

    /* renamed from: fm  reason: collision with root package name */
    private final Boolean f61321fm;
    @SerializedName("gid")
    @Nullable
    private final Integer gid;
    @SerializedName("gtl")
    @Nullable
    private final String gtl;
    @SerializedName("hasv")
    @Nullable
    private final Boolean hasv;
    @SerializedName("hrd")
    @Nullable
    private final Boolean hrd;
    @SerializedName("hsp")
    @Nullable
    private final Boolean hsp;
    @SerializedName("htc")
    @Nullable
    private final Boolean htc;
    @SerializedName("htd")
    @Nullable
    private final Boolean htd;
    @SerializedName("iccm")
    @Nullable
    private final Boolean iccm;
    @SerializedName("icr")
    @Nullable
    private final Boolean icr;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Integer f61322id;
    @SerializedName("ida")
    @Nullable
    private final Boolean ida;
    @SerializedName("inc")
    @Nullable
    private final Boolean inc;
    @SerializedName("ipa")
    @Nullable
    private final Boolean ipa;
    @SerializedName("ipos")
    @Nullable
    private final Boolean ipos;
    @SerializedName("ipt")
    @Nullable
    private final Boolean ipt;
    @SerializedName("cld")
    @Nullable
    private final Boolean isSafeDropOff;
    @SerializedName("isVatInc")
    @Nullable
    private final Boolean isVatInc;
    @SerializedName("isd")
    @Nullable
    private final Boolean isd;
    @SerializedName("isds")
    @Nullable
    private final Boolean isds;
    @SerializedName("ism")
    @Nullable
    private final Boolean ism;
    @SerializedName("isn")
    @Nullable
    private final Boolean isn;
    @SerializedName("iss")
    @Nullable
    private final Boolean iss;
    @SerializedName("isub")
    @Nullable
    private final Boolean isub;
    @SerializedName("itg")
    @Nullable
    private final Boolean itg;
    @SerializedName("ius")
    @Nullable
    private final Boolean ius;
    @SerializedName("iush")
    @Nullable
    private final Boolean iush;
    @SerializedName("Lat")
    @Nullable
    private final String lat;
    @SerializedName("lg")
    @Nullable

    /* renamed from: lg  reason: collision with root package name */
    private final String f61323lg;
    @SerializedName("Lon")
    @Nullable
    private final String lon;
    @SerializedName("mav")
    @Nullable
    private final Boolean mav;
    @SerializedName("mcc")
    @Nullable
    private final Double mcc;
    @SerializedName("mdis")
    @Nullable
    private final Integer mdis;
    @SerializedName("mna")
    @Nullable
    private final Double mna;
    @SerializedName("mpro")
    @Nullable
    private final Integer mpro;
    @SerializedName("mtyp")
    @Nullable
    private final Integer mtyp;
    @SerializedName("na")
    @Nullable

    /* renamed from: na  reason: collision with root package name */
    private final String f61324na;
    @SerializedName("pdto")
    @Nullable
    private final Integer pdto;
    @SerializedName("pmsg")
    @Nullable
    private final String pmsg;
    @SerializedName("pri")
    @Nullable
    private final String pri;
    @SerializedName("prtg")
    @Nullable
    private final Integer priceTag;
    @SerializedName("ptxt")
    @Nullable
    private final String ptxt;
    @SerializedName("rat")
    @Nullable
    private final Double rat;
    @SerializedName("rgrl")
    @Nullable
    private final Boolean rgrl;
    @SerializedName("sha")
    @Nullable
    private final Integer sha;
    @SerializedName("shc")
    @Nullable
    private final Integer shc;
    @SerializedName("sl")
    @Nullable

    /* renamed from: sl  reason: collision with root package name */
    private final String f61325sl;
    @SerializedName("smr")
    @Nullable
    private final String smr;
    @SerializedName("st")
    @Nullable

    /* renamed from: st  reason: collision with root package name */
    private final String f61326st;
    @SerializedName("stt")
    @Nullable
    private final Integer stt;
    @SerializedName("tch")
    @Nullable
    private final Double tch;
    @SerializedName("trc")
    @Nullable
    private final Double trc;
    @SerializedName("trt")
    @Nullable
    private final String trt;
    @SerializedName("trts")
    @Nullable
    private final String trts;
    @SerializedName("ttrev")
    @Nullable
    private final String ttrev;
    @SerializedName("ttyp")
    @Nullable
    private final Integer ttyp;
    @SerializedName("uscom")
    @Nullable
    private final String uscom;
    @SerializedName("uscomid")
    @Nullable
    private final Integer uscomid;
    @SerializedName("usicon")
    @Nullable
    private final String usicon;
    @SerializedName("ust")
    @Nullable
    private final String ust;
    @SerializedName("verticalType")
    @Nullable
    private final Integer verticalType;

    public Vendor(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str, @Nullable Boolean bool4, @Nullable String str2, @Nullable Object obj, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, int i11, @Nullable String str8, @Nullable String str9, @Nullable Boolean bool5, @Nullable String str10, @Nullable List<Cuisine> list, @Nullable Double d11, @Nullable String str11, @Nullable Integer num, @Nullable String str12, @Nullable String str13, @Nullable Integer num2, @Nullable String str14, @Nullable List<Integer> list2, @Nullable Double d12, @Nullable Boolean bool6, @Nullable Integer num3, @Nullable String str15, @Nullable Boolean bool7, @Nullable Boolean bool8, @Nullable Boolean bool9, @Nullable Boolean bool10, @Nullable Boolean bool11, @Nullable Boolean bool12, @Nullable Boolean bool13, @Nullable Integer num4, @Nullable Boolean bool14, @Nullable Boolean bool15, @Nullable Boolean bool16, @Nullable Boolean bool17, @Nullable Boolean bool18, @Nullable Boolean bool19, @Nullable Boolean bool20, @Nullable Boolean bool21, @Nullable Boolean bool22, @Nullable Boolean bool23, @Nullable Boolean bool24, @Nullable Boolean bool25, @Nullable Boolean bool26, @Nullable Boolean bool27, @Nullable Boolean bool28, @Nullable String str16, @Nullable String str17, @Nullable String str18, @Nullable Boolean bool29, @Nullable Double d13, @Nullable Integer num5, @Nullable Double d14, @Nullable Integer num6, @Nullable Integer num7, @Nullable String str19, @Nullable Integer num8, @Nullable String str20, @Nullable String str21, @Nullable String str22, @Nullable Double d15, @Nullable Boolean bool30, @Nullable Integer num9, @Nullable Integer num10, @Nullable String str23, @Nullable String str24, @Nullable String str25, @Nullable Integer num11, @Nullable Double d16, @Nullable Double d17, @Nullable String str26, @Nullable String str27, @Nullable String str28, @Nullable Integer num12, @Nullable String str29, @Nullable Integer num13, @Nullable String str30, @Nullable String str31, @Nullable Integer num14, @Nullable Integer num15, @Nullable Boolean bool31) {
        this.f61319ac = bool;
        this.acod = bool2;
        this.acr = bool3;
        this.act = str;
        this.adb = bool4;
        this.adc = str2;
        this.aid = obj;
        this.amt = str3;
        this.f61320an = str4;
        this.atbt = str5;
        this.att = str6;
        this.avd = str7;
        this.bid = i11;
        this.bna = str8;
        this.bsl = str9;
        this.cav = bool5;
        this.css = str10;
        this.cus = list;
        this.dch = d11;
        this.dcl = str11;
        this.dct = num;
        this.des = str12;
        this.dls = str13;
        this.dtim = num2;
        this.dtxt = str14;
        this.fids = list2;
        this.finalRank = d12;
        this.f61321fm = bool6;
        this.gid = num3;
        this.gtl = str15;
        this.hasv = bool7;
        this.hrd = bool8;
        this.hsp = bool9;
        this.htc = bool10;
        this.htd = bool11;
        this.iccm = bool12;
        this.icr = bool13;
        this.f61322id = num4;
        this.ida = bool14;
        this.inc = bool15;
        this.ipa = bool16;
        this.ipos = bool17;
        this.ipt = bool18;
        this.isVatInc = bool19;
        this.isd = bool20;
        this.isds = bool21;
        this.ism = bool22;
        this.isn = bool23;
        this.iss = bool24;
        this.isub = bool25;
        this.itg = bool26;
        this.ius = bool27;
        this.iush = bool28;
        this.lat = str16;
        this.f61323lg = str17;
        this.lon = str18;
        this.mav = bool29;
        this.mcc = d13;
        this.mdis = num5;
        this.mna = d14;
        this.mpro = num6;
        this.mtyp = num7;
        this.f61324na = str19;
        this.pdto = num8;
        this.pmsg = str20;
        this.pri = str21;
        this.ptxt = str22;
        this.rat = d15;
        this.rgrl = bool30;
        this.sha = num9;
        this.shc = num10;
        this.f61325sl = str23;
        this.smr = str24;
        this.f61326st = str25;
        this.stt = num11;
        this.tch = d16;
        this.trc = d17;
        this.trt = str26;
        this.trts = str27;
        this.ttrev = str28;
        this.ttyp = num12;
        this.uscom = str29;
        this.uscomid = num13;
        this.usicon = str30;
        this.ust = str31;
        this.verticalType = num14;
        this.priceTag = num15;
        this.isSafeDropOff = bool31;
    }

    public static /* synthetic */ Vendor copy$default(Vendor vendor, Boolean bool, Boolean bool2, Boolean bool3, String str, Boolean bool4, String str2, Object obj, String str3, String str4, String str5, String str6, String str7, int i11, String str8, String str9, Boolean bool5, String str10, List list, Double d11, String str11, Integer num, String str12, String str13, Integer num2, String str14, List list2, Double d12, Boolean bool6, Integer num3, String str15, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, Integer num4, Boolean bool14, Boolean bool15, Boolean bool16, Boolean bool17, Boolean bool18, Boolean bool19, Boolean bool20, Boolean bool21, Boolean bool22, Boolean bool23, Boolean bool24, Boolean bool25, Boolean bool26, Boolean bool27, Boolean bool28, String str16, String str17, String str18, Boolean bool29, Double d13, Integer num5, Double d14, Integer num6, Integer num7, String str19, Integer num8, String str20, String str21, String str22, Double d15, Boolean bool30, Integer num9, Integer num10, String str23, String str24, String str25, Integer num11, Double d16, Double d17, String str26, String str27, String str28, Integer num12, String str29, Integer num13, String str30, String str31, Integer num14, Integer num15, Boolean bool31, int i12, int i13, int i14, Object obj2) {
        Vendor vendor2 = vendor;
        int i15 = i12;
        int i16 = i13;
        int i17 = i14;
        return vendor.copy((i15 & 1) != 0 ? vendor2.f61319ac : bool, (i15 & 2) != 0 ? vendor2.acod : bool2, (i15 & 4) != 0 ? vendor2.acr : bool3, (i15 & 8) != 0 ? vendor2.act : str, (i15 & 16) != 0 ? vendor2.adb : bool4, (i15 & 32) != 0 ? vendor2.adc : str2, (i15 & 64) != 0 ? vendor2.aid : obj, (i15 & 128) != 0 ? vendor2.amt : str3, (i15 & 256) != 0 ? vendor2.f61320an : str4, (i15 & 512) != 0 ? vendor2.atbt : str5, (i15 & 1024) != 0 ? vendor2.att : str6, (i15 & 2048) != 0 ? vendor2.avd : str7, (i15 & 4096) != 0 ? vendor2.bid : i11, (i15 & 8192) != 0 ? vendor2.bna : str8, (i15 & 16384) != 0 ? vendor2.bsl : str9, (i15 & 32768) != 0 ? vendor2.cav : bool5, (i15 & 65536) != 0 ? vendor2.css : str10, (i15 & 131072) != 0 ? vendor2.cus : list, (i15 & 262144) != 0 ? vendor2.dch : d11, (i15 & 524288) != 0 ? vendor2.dcl : str11, (i15 & 1048576) != 0 ? vendor2.dct : num, (i15 & 2097152) != 0 ? vendor2.des : str12, (i15 & 4194304) != 0 ? vendor2.dls : str13, (i15 & 8388608) != 0 ? vendor2.dtim : num2, (i15 & 16777216) != 0 ? vendor2.dtxt : str14, (i15 & 33554432) != 0 ? vendor2.fids : list2, (i15 & 67108864) != 0 ? vendor2.finalRank : d12, (i15 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? vendor2.f61321fm : bool6, (i15 & 268435456) != 0 ? vendor2.gid : num3, (i15 & 536870912) != 0 ? vendor2.gtl : str15, (i15 & 1073741824) != 0 ? vendor2.hasv : bool7, (i15 & Integer.MIN_VALUE) != 0 ? vendor2.hrd : bool8, (i16 & 1) != 0 ? vendor2.hsp : bool9, (i16 & 2) != 0 ? vendor2.htc : bool10, (i16 & 4) != 0 ? vendor2.htd : bool11, (i16 & 8) != 0 ? vendor2.iccm : bool12, (i16 & 16) != 0 ? vendor2.icr : bool13, (i16 & 32) != 0 ? vendor2.f61322id : num4, (i16 & 64) != 0 ? vendor2.ida : bool14, (i16 & 128) != 0 ? vendor2.inc : bool15, (i16 & 256) != 0 ? vendor2.ipa : bool16, (i16 & 512) != 0 ? vendor2.ipos : bool17, (i16 & 1024) != 0 ? vendor2.ipt : bool18, (i16 & 2048) != 0 ? vendor2.isVatInc : bool19, (i16 & 4096) != 0 ? vendor2.isd : bool20, (i16 & 8192) != 0 ? vendor2.isds : bool21, (i16 & 16384) != 0 ? vendor2.ism : bool22, (i16 & 32768) != 0 ? vendor2.isn : bool23, (i16 & 65536) != 0 ? vendor2.iss : bool24, (i16 & 131072) != 0 ? vendor2.isub : bool25, (i16 & 262144) != 0 ? vendor2.itg : bool26, (i16 & 524288) != 0 ? vendor2.ius : bool27, (i16 & 1048576) != 0 ? vendor2.iush : bool28, (i16 & 2097152) != 0 ? vendor2.lat : str16, (i16 & 4194304) != 0 ? vendor2.f61323lg : str17, (i16 & 8388608) != 0 ? vendor2.lon : str18, (i16 & 16777216) != 0 ? vendor2.mav : bool29, (i16 & 33554432) != 0 ? vendor2.mcc : d13, (i16 & 67108864) != 0 ? vendor2.mdis : num5, (i16 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? vendor2.mna : d14, (i16 & 268435456) != 0 ? vendor2.mpro : num6, (i16 & 536870912) != 0 ? vendor2.mtyp : num7, (i16 & 1073741824) != 0 ? vendor2.f61324na : str19, (i16 & Integer.MIN_VALUE) != 0 ? vendor2.pdto : num8, (i17 & 1) != 0 ? vendor2.pmsg : str20, (i17 & 2) != 0 ? vendor2.pri : str21, (i17 & 4) != 0 ? vendor2.ptxt : str22, (i17 & 8) != 0 ? vendor2.rat : d15, (i17 & 16) != 0 ? vendor2.rgrl : bool30, (i17 & 32) != 0 ? vendor2.sha : num9, (i17 & 64) != 0 ? vendor2.shc : num10, (i17 & 128) != 0 ? vendor2.f61325sl : str23, (i17 & 256) != 0 ? vendor2.smr : str24, (i17 & 512) != 0 ? vendor2.f61326st : str25, (i17 & 1024) != 0 ? vendor2.stt : num11, (i17 & 2048) != 0 ? vendor2.tch : d16, (i17 & 4096) != 0 ? vendor2.trc : d17, (i17 & 8192) != 0 ? vendor2.trt : str26, (i17 & 16384) != 0 ? vendor2.trts : str27, (i17 & 32768) != 0 ? vendor2.ttrev : str28, (i17 & 65536) != 0 ? vendor2.ttyp : num12, (i17 & 131072) != 0 ? vendor2.uscom : str29, (i17 & 262144) != 0 ? vendor2.uscomid : num13, (i17 & 524288) != 0 ? vendor2.usicon : str30, (i17 & 1048576) != 0 ? vendor2.ust : str31, (i17 & 2097152) != 0 ? vendor2.verticalType : num14, (i17 & 4194304) != 0 ? vendor2.priceTag : num15, (i17 & 8388608) != 0 ? vendor2.isSafeDropOff : bool31);
    }

    @Nullable
    public final Boolean component1() {
        return this.f61319ac;
    }

    @Nullable
    public final String component10() {
        return this.atbt;
    }

    @Nullable
    public final String component11() {
        return this.att;
    }

    @Nullable
    public final String component12() {
        return this.avd;
    }

    public final int component13() {
        return this.bid;
    }

    @Nullable
    public final String component14() {
        return this.bna;
    }

    @Nullable
    public final String component15() {
        return this.bsl;
    }

    @Nullable
    public final Boolean component16() {
        return this.cav;
    }

    @Nullable
    public final String component17() {
        return this.css;
    }

    @Nullable
    public final List<Cuisine> component18() {
        return this.cus;
    }

    @Nullable
    public final Double component19() {
        return this.dch;
    }

    @Nullable
    public final Boolean component2() {
        return this.acod;
    }

    @Nullable
    public final String component20() {
        return this.dcl;
    }

    @Nullable
    public final Integer component21() {
        return this.dct;
    }

    @Nullable
    public final String component22() {
        return this.des;
    }

    @Nullable
    public final String component23() {
        return this.dls;
    }

    @Nullable
    public final Integer component24() {
        return this.dtim;
    }

    @Nullable
    public final String component25() {
        return this.dtxt;
    }

    @Nullable
    public final List<Integer> component26() {
        return this.fids;
    }

    @Nullable
    public final Double component27() {
        return this.finalRank;
    }

    @Nullable
    public final Boolean component28() {
        return this.f61321fm;
    }

    @Nullable
    public final Integer component29() {
        return this.gid;
    }

    @Nullable
    public final Boolean component3() {
        return this.acr;
    }

    @Nullable
    public final String component30() {
        return this.gtl;
    }

    @Nullable
    public final Boolean component31() {
        return this.hasv;
    }

    @Nullable
    public final Boolean component32() {
        return this.hrd;
    }

    @Nullable
    public final Boolean component33() {
        return this.hsp;
    }

    @Nullable
    public final Boolean component34() {
        return this.htc;
    }

    @Nullable
    public final Boolean component35() {
        return this.htd;
    }

    @Nullable
    public final Boolean component36() {
        return this.iccm;
    }

    @Nullable
    public final Boolean component37() {
        return this.icr;
    }

    @Nullable
    public final Integer component38() {
        return this.f61322id;
    }

    @Nullable
    public final Boolean component39() {
        return this.ida;
    }

    @Nullable
    public final String component4() {
        return this.act;
    }

    @Nullable
    public final Boolean component40() {
        return this.inc;
    }

    @Nullable
    public final Boolean component41() {
        return this.ipa;
    }

    @Nullable
    public final Boolean component42() {
        return this.ipos;
    }

    @Nullable
    public final Boolean component43() {
        return this.ipt;
    }

    @Nullable
    public final Boolean component44() {
        return this.isVatInc;
    }

    @Nullable
    public final Boolean component45() {
        return this.isd;
    }

    @Nullable
    public final Boolean component46() {
        return this.isds;
    }

    @Nullable
    public final Boolean component47() {
        return this.ism;
    }

    @Nullable
    public final Boolean component48() {
        return this.isn;
    }

    @Nullable
    public final Boolean component49() {
        return this.iss;
    }

    @Nullable
    public final Boolean component5() {
        return this.adb;
    }

    @Nullable
    public final Boolean component50() {
        return this.isub;
    }

    @Nullable
    public final Boolean component51() {
        return this.itg;
    }

    @Nullable
    public final Boolean component52() {
        return this.ius;
    }

    @Nullable
    public final Boolean component53() {
        return this.iush;
    }

    @Nullable
    public final String component54() {
        return this.lat;
    }

    @Nullable
    public final String component55() {
        return this.f61323lg;
    }

    @Nullable
    public final String component56() {
        return this.lon;
    }

    @Nullable
    public final Boolean component57() {
        return this.mav;
    }

    @Nullable
    public final Double component58() {
        return this.mcc;
    }

    @Nullable
    public final Integer component59() {
        return this.mdis;
    }

    @Nullable
    public final String component6() {
        return this.adc;
    }

    @Nullable
    public final Double component60() {
        return this.mna;
    }

    @Nullable
    public final Integer component61() {
        return this.mpro;
    }

    @Nullable
    public final Integer component62() {
        return this.mtyp;
    }

    @Nullable
    public final String component63() {
        return this.f61324na;
    }

    @Nullable
    public final Integer component64() {
        return this.pdto;
    }

    @Nullable
    public final String component65() {
        return this.pmsg;
    }

    @Nullable
    public final String component66() {
        return this.pri;
    }

    @Nullable
    public final String component67() {
        return this.ptxt;
    }

    @Nullable
    public final Double component68() {
        return this.rat;
    }

    @Nullable
    public final Boolean component69() {
        return this.rgrl;
    }

    @Nullable
    public final Object component7() {
        return this.aid;
    }

    @Nullable
    public final Integer component70() {
        return this.sha;
    }

    @Nullable
    public final Integer component71() {
        return this.shc;
    }

    @Nullable
    public final String component72() {
        return this.f61325sl;
    }

    @Nullable
    public final String component73() {
        return this.smr;
    }

    @Nullable
    public final String component74() {
        return this.f61326st;
    }

    @Nullable
    public final Integer component75() {
        return this.stt;
    }

    @Nullable
    public final Double component76() {
        return this.tch;
    }

    @Nullable
    public final Double component77() {
        return this.trc;
    }

    @Nullable
    public final String component78() {
        return this.trt;
    }

    @Nullable
    public final String component79() {
        return this.trts;
    }

    @Nullable
    public final String component8() {
        return this.amt;
    }

    @Nullable
    public final String component80() {
        return this.ttrev;
    }

    @Nullable
    public final Integer component81() {
        return this.ttyp;
    }

    @Nullable
    public final String component82() {
        return this.uscom;
    }

    @Nullable
    public final Integer component83() {
        return this.uscomid;
    }

    @Nullable
    public final String component84() {
        return this.usicon;
    }

    @Nullable
    public final String component85() {
        return this.ust;
    }

    @Nullable
    public final Integer component86() {
        return this.verticalType;
    }

    @Nullable
    public final Integer component87() {
        return this.priceTag;
    }

    @Nullable
    public final Boolean component88() {
        return this.isSafeDropOff;
    }

    @Nullable
    public final String component9() {
        return this.f61320an;
    }

    @NotNull
    public final Vendor copy(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str, @Nullable Boolean bool4, @Nullable String str2, @Nullable Object obj, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, int i11, @Nullable String str8, @Nullable String str9, @Nullable Boolean bool5, @Nullable String str10, @Nullable List<Cuisine> list, @Nullable Double d11, @Nullable String str11, @Nullable Integer num, @Nullable String str12, @Nullable String str13, @Nullable Integer num2, @Nullable String str14, @Nullable List<Integer> list2, @Nullable Double d12, @Nullable Boolean bool6, @Nullable Integer num3, @Nullable String str15, @Nullable Boolean bool7, @Nullable Boolean bool8, @Nullable Boolean bool9, @Nullable Boolean bool10, @Nullable Boolean bool11, @Nullable Boolean bool12, @Nullable Boolean bool13, @Nullable Integer num4, @Nullable Boolean bool14, @Nullable Boolean bool15, @Nullable Boolean bool16, @Nullable Boolean bool17, @Nullable Boolean bool18, @Nullable Boolean bool19, @Nullable Boolean bool20, @Nullable Boolean bool21, @Nullable Boolean bool22, @Nullable Boolean bool23, @Nullable Boolean bool24, @Nullable Boolean bool25, @Nullable Boolean bool26, @Nullable Boolean bool27, @Nullable Boolean bool28, @Nullable String str16, @Nullable String str17, @Nullable String str18, @Nullable Boolean bool29, @Nullable Double d13, @Nullable Integer num5, @Nullable Double d14, @Nullable Integer num6, @Nullable Integer num7, @Nullable String str19, @Nullable Integer num8, @Nullable String str20, @Nullable String str21, @Nullable String str22, @Nullable Double d15, @Nullable Boolean bool30, @Nullable Integer num9, @Nullable Integer num10, @Nullable String str23, @Nullable String str24, @Nullable String str25, @Nullable Integer num11, @Nullable Double d16, @Nullable Double d17, @Nullable String str26, @Nullable String str27, @Nullable String str28, @Nullable Integer num12, @Nullable String str29, @Nullable Integer num13, @Nullable String str30, @Nullable String str31, @Nullable Integer num14, @Nullable Integer num15, @Nullable Boolean bool31) {
        return new Vendor(bool, bool2, bool3, str, bool4, str2, obj, str3, str4, str5, str6, str7, i11, str8, str9, bool5, str10, list, d11, str11, num, str12, str13, num2, str14, list2, d12, bool6, num3, str15, bool7, bool8, bool9, bool10, bool11, bool12, bool13, num4, bool14, bool15, bool16, bool17, bool18, bool19, bool20, bool21, bool22, bool23, bool24, bool25, bool26, bool27, bool28, str16, str17, str18, bool29, d13, num5, d14, num6, num7, str19, num8, str20, str21, str22, d15, bool30, num9, num10, str23, str24, str25, num11, d16, d17, str26, str27, str28, num12, str29, num13, str30, str31, num14, num15, bool31);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vendor)) {
            return false;
        }
        Vendor vendor = (Vendor) obj;
        return Intrinsics.areEqual((Object) this.f61319ac, (Object) vendor.f61319ac) && Intrinsics.areEqual((Object) this.acod, (Object) vendor.acod) && Intrinsics.areEqual((Object) this.acr, (Object) vendor.acr) && Intrinsics.areEqual((Object) this.act, (Object) vendor.act) && Intrinsics.areEqual((Object) this.adb, (Object) vendor.adb) && Intrinsics.areEqual((Object) this.adc, (Object) vendor.adc) && Intrinsics.areEqual(this.aid, vendor.aid) && Intrinsics.areEqual((Object) this.amt, (Object) vendor.amt) && Intrinsics.areEqual((Object) this.f61320an, (Object) vendor.f61320an) && Intrinsics.areEqual((Object) this.atbt, (Object) vendor.atbt) && Intrinsics.areEqual((Object) this.att, (Object) vendor.att) && Intrinsics.areEqual((Object) this.avd, (Object) vendor.avd) && this.bid == vendor.bid && Intrinsics.areEqual((Object) this.bna, (Object) vendor.bna) && Intrinsics.areEqual((Object) this.bsl, (Object) vendor.bsl) && Intrinsics.areEqual((Object) this.cav, (Object) vendor.cav) && Intrinsics.areEqual((Object) this.css, (Object) vendor.css) && Intrinsics.areEqual((Object) this.cus, (Object) vendor.cus) && Intrinsics.areEqual((Object) this.dch, (Object) vendor.dch) && Intrinsics.areEqual((Object) this.dcl, (Object) vendor.dcl) && Intrinsics.areEqual((Object) this.dct, (Object) vendor.dct) && Intrinsics.areEqual((Object) this.des, (Object) vendor.des) && Intrinsics.areEqual((Object) this.dls, (Object) vendor.dls) && Intrinsics.areEqual((Object) this.dtim, (Object) vendor.dtim) && Intrinsics.areEqual((Object) this.dtxt, (Object) vendor.dtxt) && Intrinsics.areEqual((Object) this.fids, (Object) vendor.fids) && Intrinsics.areEqual((Object) this.finalRank, (Object) vendor.finalRank) && Intrinsics.areEqual((Object) this.f61321fm, (Object) vendor.f61321fm) && Intrinsics.areEqual((Object) this.gid, (Object) vendor.gid) && Intrinsics.areEqual((Object) this.gtl, (Object) vendor.gtl) && Intrinsics.areEqual((Object) this.hasv, (Object) vendor.hasv) && Intrinsics.areEqual((Object) this.hrd, (Object) vendor.hrd) && Intrinsics.areEqual((Object) this.hsp, (Object) vendor.hsp) && Intrinsics.areEqual((Object) this.htc, (Object) vendor.htc) && Intrinsics.areEqual((Object) this.htd, (Object) vendor.htd) && Intrinsics.areEqual((Object) this.iccm, (Object) vendor.iccm) && Intrinsics.areEqual((Object) this.icr, (Object) vendor.icr) && Intrinsics.areEqual((Object) this.f61322id, (Object) vendor.f61322id) && Intrinsics.areEqual((Object) this.ida, (Object) vendor.ida) && Intrinsics.areEqual((Object) this.inc, (Object) vendor.inc) && Intrinsics.areEqual((Object) this.ipa, (Object) vendor.ipa) && Intrinsics.areEqual((Object) this.ipos, (Object) vendor.ipos) && Intrinsics.areEqual((Object) this.ipt, (Object) vendor.ipt) && Intrinsics.areEqual((Object) this.isVatInc, (Object) vendor.isVatInc) && Intrinsics.areEqual((Object) this.isd, (Object) vendor.isd) && Intrinsics.areEqual((Object) this.isds, (Object) vendor.isds) && Intrinsics.areEqual((Object) this.ism, (Object) vendor.ism) && Intrinsics.areEqual((Object) this.isn, (Object) vendor.isn) && Intrinsics.areEqual((Object) this.iss, (Object) vendor.iss) && Intrinsics.areEqual((Object) this.isub, (Object) vendor.isub) && Intrinsics.areEqual((Object) this.itg, (Object) vendor.itg) && Intrinsics.areEqual((Object) this.ius, (Object) vendor.ius) && Intrinsics.areEqual((Object) this.iush, (Object) vendor.iush) && Intrinsics.areEqual((Object) this.lat, (Object) vendor.lat) && Intrinsics.areEqual((Object) this.f61323lg, (Object) vendor.f61323lg) && Intrinsics.areEqual((Object) this.lon, (Object) vendor.lon) && Intrinsics.areEqual((Object) this.mav, (Object) vendor.mav) && Intrinsics.areEqual((Object) this.mcc, (Object) vendor.mcc) && Intrinsics.areEqual((Object) this.mdis, (Object) vendor.mdis) && Intrinsics.areEqual((Object) this.mna, (Object) vendor.mna) && Intrinsics.areEqual((Object) this.mpro, (Object) vendor.mpro) && Intrinsics.areEqual((Object) this.mtyp, (Object) vendor.mtyp) && Intrinsics.areEqual((Object) this.f61324na, (Object) vendor.f61324na) && Intrinsics.areEqual((Object) this.pdto, (Object) vendor.pdto) && Intrinsics.areEqual((Object) this.pmsg, (Object) vendor.pmsg) && Intrinsics.areEqual((Object) this.pri, (Object) vendor.pri) && Intrinsics.areEqual((Object) this.ptxt, (Object) vendor.ptxt) && Intrinsics.areEqual((Object) this.rat, (Object) vendor.rat) && Intrinsics.areEqual((Object) this.rgrl, (Object) vendor.rgrl) && Intrinsics.areEqual((Object) this.sha, (Object) vendor.sha) && Intrinsics.areEqual((Object) this.shc, (Object) vendor.shc) && Intrinsics.areEqual((Object) this.f61325sl, (Object) vendor.f61325sl) && Intrinsics.areEqual((Object) this.smr, (Object) vendor.smr) && Intrinsics.areEqual((Object) this.f61326st, (Object) vendor.f61326st) && Intrinsics.areEqual((Object) this.stt, (Object) vendor.stt) && Intrinsics.areEqual((Object) this.tch, (Object) vendor.tch) && Intrinsics.areEqual((Object) this.trc, (Object) vendor.trc) && Intrinsics.areEqual((Object) this.trt, (Object) vendor.trt) && Intrinsics.areEqual((Object) this.trts, (Object) vendor.trts) && Intrinsics.areEqual((Object) this.ttrev, (Object) vendor.ttrev) && Intrinsics.areEqual((Object) this.ttyp, (Object) vendor.ttyp) && Intrinsics.areEqual((Object) this.uscom, (Object) vendor.uscom) && Intrinsics.areEqual((Object) this.uscomid, (Object) vendor.uscomid) && Intrinsics.areEqual((Object) this.usicon, (Object) vendor.usicon) && Intrinsics.areEqual((Object) this.ust, (Object) vendor.ust) && Intrinsics.areEqual((Object) this.verticalType, (Object) vendor.verticalType) && Intrinsics.areEqual((Object) this.priceTag, (Object) vendor.priceTag) && Intrinsics.areEqual((Object) this.isSafeDropOff, (Object) vendor.isSafeDropOff);
    }

    @Nullable
    public final Boolean getAc() {
        return this.f61319ac;
    }

    @Nullable
    public final Boolean getAcod() {
        return this.acod;
    }

    @Nullable
    public final Boolean getAcr() {
        return this.acr;
    }

    @Nullable
    public final String getAct() {
        return this.act;
    }

    @Nullable
    public final Boolean getAdb() {
        return this.adb;
    }

    @Nullable
    public final String getAdc() {
        return this.adc;
    }

    @Nullable
    public final Object getAid() {
        return this.aid;
    }

    @Nullable
    public final String getAmt() {
        return this.amt;
    }

    @Nullable
    public final String getAn() {
        return this.f61320an;
    }

    @Nullable
    public final String getAtbt() {
        return this.atbt;
    }

    @Nullable
    public final String getAtt() {
        return this.att;
    }

    @Nullable
    public final String getAvd() {
        return this.avd;
    }

    public final int getBid() {
        return this.bid;
    }

    @Nullable
    public final String getBna() {
        return this.bna;
    }

    @Nullable
    public final String getBsl() {
        return this.bsl;
    }

    @Nullable
    public final Boolean getCav() {
        return this.cav;
    }

    @Nullable
    public final String getCss() {
        return this.css;
    }

    @Nullable
    public final List<Cuisine> getCus() {
        return this.cus;
    }

    @Nullable
    public final Double getDch() {
        return this.dch;
    }

    @Nullable
    public final String getDcl() {
        return this.dcl;
    }

    @Nullable
    public final Integer getDct() {
        return this.dct;
    }

    @Nullable
    public final String getDes() {
        return this.des;
    }

    @Nullable
    public final String getDls() {
        return this.dls;
    }

    @Nullable
    public final Integer getDtim() {
        return this.dtim;
    }

    @Nullable
    public final String getDtxt() {
        return this.dtxt;
    }

    @Nullable
    public final List<Integer> getFids() {
        return this.fids;
    }

    @Nullable
    public final Double getFinalRank() {
        return this.finalRank;
    }

    @Nullable
    public final Boolean getFm() {
        return this.f61321fm;
    }

    @Nullable
    public final Integer getGid() {
        return this.gid;
    }

    @Nullable
    public final String getGtl() {
        return this.gtl;
    }

    @Nullable
    public final Boolean getHasv() {
        return this.hasv;
    }

    @Nullable
    public final Boolean getHrd() {
        return this.hrd;
    }

    @Nullable
    public final Boolean getHsp() {
        return this.hsp;
    }

    @Nullable
    public final Boolean getHtc() {
        return this.htc;
    }

    @Nullable
    public final Boolean getHtd() {
        return this.htd;
    }

    @Nullable
    public final Boolean getIccm() {
        return this.iccm;
    }

    @Nullable
    public final Boolean getIcr() {
        return this.icr;
    }

    @Nullable
    public final Integer getId() {
        return this.f61322id;
    }

    @Nullable
    public final Boolean getIda() {
        return this.ida;
    }

    @Nullable
    public final Boolean getInc() {
        return this.inc;
    }

    @Nullable
    public final Boolean getIpa() {
        return this.ipa;
    }

    @Nullable
    public final Boolean getIpos() {
        return this.ipos;
    }

    @Nullable
    public final Boolean getIpt() {
        return this.ipt;
    }

    @Nullable
    public final Boolean getIsd() {
        return this.isd;
    }

    @Nullable
    public final Boolean getIsds() {
        return this.isds;
    }

    @Nullable
    public final Boolean getIsm() {
        return this.ism;
    }

    @Nullable
    public final Boolean getIsn() {
        return this.isn;
    }

    @Nullable
    public final Boolean getIss() {
        return this.iss;
    }

    @Nullable
    public final Boolean getIsub() {
        return this.isub;
    }

    @Nullable
    public final Boolean getItg() {
        return this.itg;
    }

    @Nullable
    public final Boolean getIus() {
        return this.ius;
    }

    @Nullable
    public final Boolean getIush() {
        return this.iush;
    }

    @Nullable
    public final String getLat() {
        return this.lat;
    }

    @Nullable
    public final String getLg() {
        return this.f61323lg;
    }

    @Nullable
    public final String getLon() {
        return this.lon;
    }

    @Nullable
    public final Boolean getMav() {
        return this.mav;
    }

    @Nullable
    public final Double getMcc() {
        return this.mcc;
    }

    @Nullable
    public final Integer getMdis() {
        return this.mdis;
    }

    @Nullable
    public final Double getMna() {
        return this.mna;
    }

    @Nullable
    public final Integer getMpro() {
        return this.mpro;
    }

    @Nullable
    public final Integer getMtyp() {
        return this.mtyp;
    }

    @Nullable
    public final String getNa() {
        return this.f61324na;
    }

    @Nullable
    public final Integer getPdto() {
        return this.pdto;
    }

    @Nullable
    public final String getPmsg() {
        return this.pmsg;
    }

    @Nullable
    public final String getPri() {
        return this.pri;
    }

    @Nullable
    public final Integer getPriceTag() {
        return this.priceTag;
    }

    @Nullable
    public final String getPtxt() {
        return this.ptxt;
    }

    @Nullable
    public final Double getRat() {
        return this.rat;
    }

    @Nullable
    public final Boolean getRgrl() {
        return this.rgrl;
    }

    @Nullable
    public final Integer getSha() {
        return this.sha;
    }

    @Nullable
    public final Integer getShc() {
        return this.shc;
    }

    @Nullable
    public final String getSl() {
        return this.f61325sl;
    }

    @Nullable
    public final String getSmr() {
        return this.smr;
    }

    @Nullable
    public final String getSt() {
        return this.f61326st;
    }

    @Nullable
    public final Integer getStt() {
        return this.stt;
    }

    @Nullable
    public final Double getTch() {
        return this.tch;
    }

    @Nullable
    public final Double getTrc() {
        return this.trc;
    }

    @Nullable
    public final String getTrt() {
        return this.trt;
    }

    @Nullable
    public final String getTrts() {
        return this.trts;
    }

    @Nullable
    public final String getTtrev() {
        return this.ttrev;
    }

    @Nullable
    public final Integer getTtyp() {
        return this.ttyp;
    }

    @Nullable
    public final String getUscom() {
        return this.uscom;
    }

    @Nullable
    public final Integer getUscomid() {
        return this.uscomid;
    }

    @Nullable
    public final String getUsicon() {
        return this.usicon;
    }

    @Nullable
    public final String getUst() {
        return this.ust;
    }

    @Nullable
    public final Integer getVerticalType() {
        return this.verticalType;
    }

    public int hashCode() {
        Boolean bool = this.f61319ac;
        int i11 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.acod;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.acr;
        int hashCode3 = (hashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str = this.act;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool4 = this.adb;
        int hashCode5 = (hashCode4 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        String str2 = this.adc;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Object obj = this.aid;
        int hashCode7 = (hashCode6 + (obj == null ? 0 : obj.hashCode())) * 31;
        String str3 = this.amt;
        int hashCode8 = (hashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f61320an;
        int hashCode9 = (hashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.atbt;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.att;
        int hashCode11 = (hashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.avd;
        int hashCode12 = (((hashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.bid) * 31;
        String str8 = this.bna;
        int hashCode13 = (hashCode12 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.bsl;
        int hashCode14 = (hashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Boolean bool5 = this.cav;
        int hashCode15 = (hashCode14 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        String str10 = this.css;
        int hashCode16 = (hashCode15 + (str10 == null ? 0 : str10.hashCode())) * 31;
        List<Cuisine> list = this.cus;
        int hashCode17 = (hashCode16 + (list == null ? 0 : list.hashCode())) * 31;
        Double d11 = this.dch;
        int hashCode18 = (hashCode17 + (d11 == null ? 0 : d11.hashCode())) * 31;
        String str11 = this.dcl;
        int hashCode19 = (hashCode18 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Integer num = this.dct;
        int hashCode20 = (hashCode19 + (num == null ? 0 : num.hashCode())) * 31;
        String str12 = this.des;
        int hashCode21 = (hashCode20 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.dls;
        int hashCode22 = (hashCode21 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Integer num2 = this.dtim;
        int hashCode23 = (hashCode22 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str14 = this.dtxt;
        int hashCode24 = (hashCode23 + (str14 == null ? 0 : str14.hashCode())) * 31;
        List<Integer> list2 = this.fids;
        int hashCode25 = (hashCode24 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Double d12 = this.finalRank;
        int hashCode26 = (hashCode25 + (d12 == null ? 0 : d12.hashCode())) * 31;
        Boolean bool6 = this.f61321fm;
        int hashCode27 = (hashCode26 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Integer num3 = this.gid;
        int hashCode28 = (hashCode27 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str15 = this.gtl;
        int hashCode29 = (hashCode28 + (str15 == null ? 0 : str15.hashCode())) * 31;
        Boolean bool7 = this.hasv;
        int hashCode30 = (hashCode29 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Boolean bool8 = this.hrd;
        int hashCode31 = (hashCode30 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        Boolean bool9 = this.hsp;
        int hashCode32 = (hashCode31 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
        Boolean bool10 = this.htc;
        int hashCode33 = (hashCode32 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
        Boolean bool11 = this.htd;
        int hashCode34 = (hashCode33 + (bool11 == null ? 0 : bool11.hashCode())) * 31;
        Boolean bool12 = this.iccm;
        int hashCode35 = (hashCode34 + (bool12 == null ? 0 : bool12.hashCode())) * 31;
        Boolean bool13 = this.icr;
        int hashCode36 = (hashCode35 + (bool13 == null ? 0 : bool13.hashCode())) * 31;
        Integer num4 = this.f61322id;
        int hashCode37 = (hashCode36 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Boolean bool14 = this.ida;
        int hashCode38 = (hashCode37 + (bool14 == null ? 0 : bool14.hashCode())) * 31;
        Boolean bool15 = this.inc;
        int hashCode39 = (hashCode38 + (bool15 == null ? 0 : bool15.hashCode())) * 31;
        Boolean bool16 = this.ipa;
        int hashCode40 = (hashCode39 + (bool16 == null ? 0 : bool16.hashCode())) * 31;
        Boolean bool17 = this.ipos;
        int hashCode41 = (hashCode40 + (bool17 == null ? 0 : bool17.hashCode())) * 31;
        Boolean bool18 = this.ipt;
        int hashCode42 = (hashCode41 + (bool18 == null ? 0 : bool18.hashCode())) * 31;
        Boolean bool19 = this.isVatInc;
        int hashCode43 = (hashCode42 + (bool19 == null ? 0 : bool19.hashCode())) * 31;
        Boolean bool20 = this.isd;
        int hashCode44 = (hashCode43 + (bool20 == null ? 0 : bool20.hashCode())) * 31;
        Boolean bool21 = this.isds;
        int hashCode45 = (hashCode44 + (bool21 == null ? 0 : bool21.hashCode())) * 31;
        Boolean bool22 = this.ism;
        int hashCode46 = (hashCode45 + (bool22 == null ? 0 : bool22.hashCode())) * 31;
        Boolean bool23 = this.isn;
        int hashCode47 = (hashCode46 + (bool23 == null ? 0 : bool23.hashCode())) * 31;
        Boolean bool24 = this.iss;
        int hashCode48 = (hashCode47 + (bool24 == null ? 0 : bool24.hashCode())) * 31;
        Boolean bool25 = this.isub;
        int hashCode49 = (hashCode48 + (bool25 == null ? 0 : bool25.hashCode())) * 31;
        Boolean bool26 = this.itg;
        int hashCode50 = (hashCode49 + (bool26 == null ? 0 : bool26.hashCode())) * 31;
        Boolean bool27 = this.ius;
        int hashCode51 = (hashCode50 + (bool27 == null ? 0 : bool27.hashCode())) * 31;
        Boolean bool28 = this.iush;
        int hashCode52 = (hashCode51 + (bool28 == null ? 0 : bool28.hashCode())) * 31;
        String str16 = this.lat;
        int hashCode53 = (hashCode52 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.f61323lg;
        int hashCode54 = (hashCode53 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.lon;
        int hashCode55 = (hashCode54 + (str18 == null ? 0 : str18.hashCode())) * 31;
        Boolean bool29 = this.mav;
        int hashCode56 = (hashCode55 + (bool29 == null ? 0 : bool29.hashCode())) * 31;
        Double d13 = this.mcc;
        int hashCode57 = (hashCode56 + (d13 == null ? 0 : d13.hashCode())) * 31;
        Integer num5 = this.mdis;
        int hashCode58 = (hashCode57 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Double d14 = this.mna;
        int hashCode59 = (hashCode58 + (d14 == null ? 0 : d14.hashCode())) * 31;
        Integer num6 = this.mpro;
        int hashCode60 = (hashCode59 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.mtyp;
        int hashCode61 = (hashCode60 + (num7 == null ? 0 : num7.hashCode())) * 31;
        String str19 = this.f61324na;
        int hashCode62 = (hashCode61 + (str19 == null ? 0 : str19.hashCode())) * 31;
        Integer num8 = this.pdto;
        int hashCode63 = (hashCode62 + (num8 == null ? 0 : num8.hashCode())) * 31;
        String str20 = this.pmsg;
        int hashCode64 = (hashCode63 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.pri;
        int hashCode65 = (hashCode64 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.ptxt;
        int hashCode66 = (hashCode65 + (str22 == null ? 0 : str22.hashCode())) * 31;
        Double d15 = this.rat;
        int hashCode67 = (hashCode66 + (d15 == null ? 0 : d15.hashCode())) * 31;
        Boolean bool30 = this.rgrl;
        int hashCode68 = (hashCode67 + (bool30 == null ? 0 : bool30.hashCode())) * 31;
        Integer num9 = this.sha;
        int hashCode69 = (hashCode68 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.shc;
        int hashCode70 = (hashCode69 + (num10 == null ? 0 : num10.hashCode())) * 31;
        String str23 = this.f61325sl;
        int hashCode71 = (hashCode70 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.smr;
        int hashCode72 = (hashCode71 + (str24 == null ? 0 : str24.hashCode())) * 31;
        String str25 = this.f61326st;
        int hashCode73 = (hashCode72 + (str25 == null ? 0 : str25.hashCode())) * 31;
        Integer num11 = this.stt;
        int hashCode74 = (hashCode73 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Double d16 = this.tch;
        int hashCode75 = (hashCode74 + (d16 == null ? 0 : d16.hashCode())) * 31;
        Double d17 = this.trc;
        int hashCode76 = (hashCode75 + (d17 == null ? 0 : d17.hashCode())) * 31;
        String str26 = this.trt;
        int hashCode77 = (hashCode76 + (str26 == null ? 0 : str26.hashCode())) * 31;
        String str27 = this.trts;
        int hashCode78 = (hashCode77 + (str27 == null ? 0 : str27.hashCode())) * 31;
        String str28 = this.ttrev;
        int hashCode79 = (hashCode78 + (str28 == null ? 0 : str28.hashCode())) * 31;
        Integer num12 = this.ttyp;
        int hashCode80 = (hashCode79 + (num12 == null ? 0 : num12.hashCode())) * 31;
        String str29 = this.uscom;
        int hashCode81 = (hashCode80 + (str29 == null ? 0 : str29.hashCode())) * 31;
        Integer num13 = this.uscomid;
        int hashCode82 = (hashCode81 + (num13 == null ? 0 : num13.hashCode())) * 31;
        String str30 = this.usicon;
        int hashCode83 = (hashCode82 + (str30 == null ? 0 : str30.hashCode())) * 31;
        String str31 = this.ust;
        int hashCode84 = (hashCode83 + (str31 == null ? 0 : str31.hashCode())) * 31;
        Integer num14 = this.verticalType;
        int hashCode85 = (hashCode84 + (num14 == null ? 0 : num14.hashCode())) * 31;
        Integer num15 = this.priceTag;
        int hashCode86 = (hashCode85 + (num15 == null ? 0 : num15.hashCode())) * 31;
        Boolean bool31 = this.isSafeDropOff;
        if (bool31 != null) {
            i11 = bool31.hashCode();
        }
        return hashCode86 + i11;
    }

    @Nullable
    public final Boolean isSafeDropOff() {
        return this.isSafeDropOff;
    }

    @Nullable
    public final Boolean isVatInc() {
        return this.isVatInc;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.f61319ac;
        Boolean bool2 = this.acod;
        Boolean bool3 = this.acr;
        String str = this.act;
        Boolean bool4 = this.adb;
        String str2 = this.adc;
        Object obj = this.aid;
        String str3 = this.amt;
        String str4 = this.f61320an;
        String str5 = this.atbt;
        String str6 = this.att;
        String str7 = this.avd;
        int i11 = this.bid;
        String str8 = this.bna;
        String str9 = this.bsl;
        Boolean bool5 = this.cav;
        String str10 = this.css;
        List<Cuisine> list = this.cus;
        Double d11 = this.dch;
        String str11 = this.dcl;
        Integer num = this.dct;
        String str12 = this.des;
        String str13 = this.dls;
        Integer num2 = this.dtim;
        String str14 = this.dtxt;
        List<Integer> list2 = this.fids;
        Double d12 = this.finalRank;
        Boolean bool6 = this.f61321fm;
        Integer num3 = this.gid;
        String str15 = this.gtl;
        Boolean bool7 = this.hasv;
        Boolean bool8 = this.hrd;
        Boolean bool9 = this.hsp;
        Boolean bool10 = this.htc;
        Boolean bool11 = this.htd;
        Boolean bool12 = this.iccm;
        Boolean bool13 = this.icr;
        Integer num4 = this.f61322id;
        Boolean bool14 = this.ida;
        Boolean bool15 = this.inc;
        Boolean bool16 = this.ipa;
        Boolean bool17 = this.ipos;
        Boolean bool18 = this.ipt;
        Boolean bool19 = this.isVatInc;
        Boolean bool20 = this.isd;
        Boolean bool21 = this.isds;
        Boolean bool22 = this.ism;
        Boolean bool23 = this.isn;
        Boolean bool24 = this.iss;
        Boolean bool25 = this.isub;
        Boolean bool26 = this.itg;
        Boolean bool27 = this.ius;
        Boolean bool28 = this.iush;
        String str16 = this.lat;
        String str17 = this.f61323lg;
        String str18 = this.lon;
        Boolean bool29 = this.mav;
        Double d13 = this.mcc;
        Integer num5 = this.mdis;
        Double d14 = this.mna;
        Integer num6 = this.mpro;
        Integer num7 = this.mtyp;
        String str19 = this.f61324na;
        Integer num8 = this.pdto;
        String str20 = this.pmsg;
        String str21 = this.pri;
        String str22 = this.ptxt;
        Double d15 = this.rat;
        Boolean bool30 = this.rgrl;
        Integer num9 = this.sha;
        Integer num10 = this.shc;
        String str23 = this.f61325sl;
        String str24 = this.smr;
        String str25 = this.f61326st;
        Integer num11 = this.stt;
        Double d16 = this.tch;
        Double d17 = this.trc;
        String str26 = this.trt;
        String str27 = this.trts;
        String str28 = this.ttrev;
        Integer num12 = this.ttyp;
        String str29 = this.uscom;
        Integer num13 = this.uscomid;
        String str30 = this.usicon;
        String str31 = this.ust;
        Integer num14 = this.verticalType;
        Integer num15 = this.priceTag;
        Boolean bool31 = this.isSafeDropOff;
        return "Vendor(ac=" + bool + ", acod=" + bool2 + ", acr=" + bool3 + ", act=" + str + ", adb=" + bool4 + ", adc=" + str2 + ", aid=" + obj + ", amt=" + str3 + ", an=" + str4 + ", atbt=" + str5 + ", att=" + str6 + ", avd=" + str7 + ", bid=" + i11 + ", bna=" + str8 + ", bsl=" + str9 + ", cav=" + bool5 + ", css=" + str10 + ", cus=" + list + ", dch=" + d11 + ", dcl=" + str11 + ", dct=" + num + ", des=" + str12 + ", dls=" + str13 + ", dtim=" + num2 + ", dtxt=" + str14 + ", fids=" + list2 + ", finalRank=" + d12 + ", fm=" + bool6 + ", gid=" + num3 + ", gtl=" + str15 + ", hasv=" + bool7 + ", hrd=" + bool8 + ", hsp=" + bool9 + ", htc=" + bool10 + ", htd=" + bool11 + ", iccm=" + bool12 + ", icr=" + bool13 + ", id=" + num4 + ", ida=" + bool14 + ", inc=" + bool15 + ", ipa=" + bool16 + ", ipos=" + bool17 + ", ipt=" + bool18 + ", isVatInc=" + bool19 + ", isd=" + bool20 + ", isds=" + bool21 + ", ism=" + bool22 + ", isn=" + bool23 + ", iss=" + bool24 + ", isub=" + bool25 + ", itg=" + bool26 + ", ius=" + bool27 + ", iush=" + bool28 + ", lat=" + str16 + ", lg=" + str17 + ", lon=" + str18 + ", mav=" + bool29 + ", mcc=" + d13 + ", mdis=" + num5 + ", mna=" + d14 + ", mpro=" + num6 + ", mtyp=" + num7 + ", na=" + str19 + ", pdto=" + num8 + ", pmsg=" + str20 + ", pri=" + str21 + ", ptxt=" + str22 + ", rat=" + d15 + ", rgrl=" + bool30 + ", sha=" + num9 + ", shc=" + num10 + ", sl=" + str23 + ", smr=" + str24 + ", st=" + str25 + ", stt=" + num11 + ", tch=" + d16 + ", trc=" + d17 + ", trt=" + str26 + ", trts=" + str27 + ", ttrev=" + str28 + ", ttyp=" + num12 + ", uscom=" + str29 + ", uscomid=" + num13 + ", usicon=" + str30 + ", ust=" + str31 + ", verticalType=" + num14 + ", priceTag=" + num15 + ", isSafeDropOff=" + bool31 + ")";
    }
}
