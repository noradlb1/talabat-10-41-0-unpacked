package kotlin.io.path;

import androidx.exifinterface.media.ExifInterface;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.FileStore;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ì\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a*\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00012\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001a\"\u00020\u0001H\b¢\u0006\u0002\u0010\u001b\u001a?\u0010\u001c\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010!\u001a6\u0010\u001c\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\b¢\u0006\u0002\u0010\"\u001aK\u0010#\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010%\u001aB\u0010#\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\b¢\u0006\u0002\u0010&\u001a\u001c\u0010'\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u00022\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0001\u001a4\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020,2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\b1H\u0007\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\r\u00102\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u00103\u001a\u00020\u0001*\u00020\u0002H\b\u001a.\u00104\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u0002070\u001a\"\u000207H\b¢\u0006\u0002\u00108\u001a\u001f\u00104\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020:H\b\u001a.\u0010;\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\b¢\u0006\u0002\u0010<\u001a.\u0010=\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\b¢\u0006\u0002\u0010<\u001a.\u0010>\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\b¢\u0006\u0002\u0010<\u001a\u0015\u0010?\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u0002H\b\u001a6\u0010@\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\b¢\u0006\u0002\u0010A\u001a\r\u0010B\u001a\u000200*\u00020\u0002H\b\u001a\r\u0010C\u001a\u00020:*\u00020\u0002H\b\u001a\u0015\u0010D\u001a\u00020\u0002*\u00020\u00022\u0006\u0010E\u001a\u00020\u0002H\n\u001a\u0015\u0010D\u001a\u00020\u0002*\u00020\u00022\u0006\u0010E\u001a\u00020\u0001H\n\u001a&\u0010F\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\b¢\u0006\u0002\u0010H\u001a2\u0010I\u001a\u0002HJ\"\n\b\u0000\u0010J\u0018\u0001*\u00020K*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\b¢\u0006\u0002\u0010L\u001a4\u0010M\u001a\u0004\u0018\u0001HJ\"\n\b\u0000\u0010J\u0018\u0001*\u00020K*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\b¢\u0006\u0002\u0010L\u001a\r\u0010N\u001a\u00020O*\u00020\u0002H\b\u001a\r\u0010P\u001a\u00020Q*\u00020\u0002H\b\u001a.\u0010R\u001a\u000200*\u00020\u00022\b\b\u0002\u0010S\u001a\u00020\u00012\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002000.H\bø\u0001\u0000\u001a0\u0010U\u001a\u0004\u0018\u00010V*\u00020\u00022\u0006\u0010W\u001a\u00020\u00012\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\b¢\u0006\u0002\u0010X\u001a&\u0010Y\u001a\u00020Z*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\b¢\u0006\u0002\u0010[\u001a(\u0010\\\u001a\u0004\u0018\u00010]*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\b¢\u0006\u0002\u0010^\u001a,\u0010_\u001a\b\u0012\u0004\u0012\u00020a0`*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\b¢\u0006\u0002\u0010b\u001a&\u0010c\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\b¢\u0006\u0002\u0010H\u001a\r\u0010d\u001a\u00020:*\u00020\u0002H\b\u001a\r\u0010e\u001a\u00020:*\u00020\u0002H\b\u001a\r\u0010f\u001a\u00020:*\u00020\u0002H\b\u001a&\u0010g\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\b¢\u0006\u0002\u0010H\u001a\u0015\u0010h\u001a\u00020:*\u00020\u00022\u0006\u0010E\u001a\u00020\u0002H\b\u001a\r\u0010i\u001a\u00020:*\u00020\u0002H\b\u001a\r\u0010j\u001a\u00020:*\u00020\u0002H\b\u001a\u001c\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00020l*\u00020\u00022\b\b\u0002\u0010S\u001a\u00020\u0001H\u0007\u001a.\u0010m\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u0002070\u001a\"\u000207H\b¢\u0006\u0002\u00108\u001a\u001f\u0010m\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020:H\b\u001a&\u0010n\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\b¢\u0006\u0002\u0010H\u001a2\u0010o\u001a\u0002Hp\"\n\b\u0000\u0010p\u0018\u0001*\u00020q*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\b¢\u0006\u0002\u0010r\u001a<\u0010o\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010V0s*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00012\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\b¢\u0006\u0002\u0010t\u001a\r\u0010u\u001a\u00020\u0002*\u00020\u0002H\b\u001a\u0014\u0010v\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0016\u0010w\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0014\u0010x\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a8\u0010y\u001a\u00020\u0002*\u00020\u00022\u0006\u0010W\u001a\u00020\u00012\b\u0010z\u001a\u0004\u0018\u00010V2\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\b¢\u0006\u0002\u0010{\u001a\u0015\u0010|\u001a\u00020\u0002*\u00020\u00022\u0006\u0010z\u001a\u00020ZH\b\u001a\u0015\u0010}\u001a\u00020\u0002*\u00020\u00022\u0006\u0010z\u001a\u00020]H\b\u001a\u001b\u0010~\u001a\u00020\u0002*\u00020\u00022\f\u0010z\u001a\b\u0012\u0004\u0012\u00020a0`H\b\u001a\u000e\u0010\u001a\u00020\u0002*\u00030\u0001H\b\u001aF\u0010\u0001\u001a\u0003H\u0001\"\u0005\b\u0000\u0010\u0001*\u00020\u00022\b\b\u0002\u0010S\u001a\u00020\u00012\u001b\u0010\u0001\u001a\u0016\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0005\u0012\u0003H\u00010.H\bø\u0001\u0000¢\u0006\u0003\u0010\u0001\u001a3\u0010\u0001\u001a\u000200*\u00020\u00022\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020,2\n\b\u0002\u0010\u0001\u001a\u00030\u00012\t\b\u0002\u0010\u0001\u001a\u00020:H\u0007\u001aJ\u0010\u0001\u001a\u000200*\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u00030\u00012\t\b\u0002\u0010\u0001\u001a\u00020:2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\b1H\u0007\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001\u001a0\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00022\u0014\u00106\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u00010\u001a\"\u00030\u0001H\u0007¢\u0006\u0003\u0010\u0001\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u001e\u0010\u0010\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0001"}, d2 = {"extension", "", "Ljava/nio/file/Path;", "getExtension$annotations", "(Ljava/nio/file/Path;)V", "getExtension", "(Ljava/nio/file/Path;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath$annotations", "getInvariantSeparatorsPath", "invariantSeparatorsPathString", "getInvariantSeparatorsPathString$annotations", "getInvariantSeparatorsPathString", "name", "getName$annotations", "getName", "nameWithoutExtension", "getNameWithoutExtension$annotations", "getNameWithoutExtension", "pathString", "getPathString$annotations", "getPathString", "Path", "path", "base", "subpaths", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "createTempDirectory", "directory", "prefix", "attributes", "Ljava/nio/file/attribute/FileAttribute;", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createTempFile", "suffix", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "fileAttributeViewNotAvailable", "", "attributeViewClass", "Ljava/lang/Class;", "fileVisitor", "Ljava/nio/file/FileVisitor;", "builderAction", "Lkotlin/Function1;", "Lkotlin/io/path/FileVisitorBuilder;", "", "Lkotlin/ExtensionFunctionType;", "absolute", "absolutePathString", "copyTo", "target", "options", "Ljava/nio/file/CopyOption;", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "overwrite", "", "createDirectories", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createDirectory", "createFile", "createLinkPointingTo", "createSymbolicLinkPointingTo", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "deleteExisting", "deleteIfExists", "div", "other", "exists", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "fileAttributesView", "V", "Ljava/nio/file/attribute/FileAttributeView;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "fileAttributesViewOrNull", "fileSize", "", "fileStore", "Ljava/nio/file/FileStore;", "forEachDirectoryEntry", "glob", "action", "getAttribute", "", "attribute", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "getLastModifiedTime", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "getOwner", "Ljava/nio/file/attribute/UserPrincipal;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "getPosixFilePermissions", "", "Ljava/nio/file/attribute/PosixFilePermission;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "isDirectory", "isExecutable", "isHidden", "isReadable", "isRegularFile", "isSameFileAs", "isSymbolicLink", "isWritable", "listDirectoryEntries", "", "moveTo", "notExists", "readAttributes", "A", "Ljava/nio/file/attribute/BasicFileAttributes;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", "", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "readSymbolicLink", "relativeTo", "relativeToOrNull", "relativeToOrSelf", "setAttribute", "value", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "setLastModifiedTime", "setOwner", "setPosixFilePermissions", "toPath", "Ljava/net/URI;", "useDirectoryEntries", "T", "block", "Lkotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "visitFileTree", "visitor", "maxDepth", "", "followLinks", "walk", "Lkotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)Lkotlin/sequences/Sequence;", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/io/path/PathsKt")
class PathsKt__PathUtilsKt extends PathsKt__PathReadWriteKt {
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path Path(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        Path a11 = Paths.get(str, new String[0]);
        Intrinsics.checkNotNullExpressionValue(a11, "get(path)");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path absolute(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Path a11 = path.toAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(a11, "toAbsolutePath()");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final String absolutePathString(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.toAbsolutePath().toString();
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path copyTo(Path path, Path path2, boolean z11) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "target");
        CopyOption[] copyOptionArr = z11 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path a11 = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(a11, "copy(this, target, *options)");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path createDirectories(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(fileAttributeArr, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Path a11 = Files.createDirectories(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(a11, "createDirectories(this, *attributes)");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path createDirectory(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(fileAttributeArr, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Path a11 = Files.createDirectory(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(a11, "createDirectory(this, *attributes)");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path createFile(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(fileAttributeArr, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Path a11 = Files.createFile(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(a11, "createFile(this, *attributes)");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path createLinkPointingTo(Path path, Path path2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "target");
        Path a11 = Files.createLink(path, path2);
        Intrinsics.checkNotNullExpressionValue(a11, "createLink(this, target)");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path createSymbolicLinkPointingTo(Path path, Path path2, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "target");
        Intrinsics.checkNotNullParameter(fileAttributeArr, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Path a11 = Files.createSymbolicLink(path, path2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(a11, "createSymbolicLink(this, target, *attributes)");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path createTempDirectory(String str, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Path a11 = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(a11, "createTempDirectory(prefix, *attributes)");
        return a11;
    }

    public static /* synthetic */ Path createTempDirectory$default(Path path, String str, FileAttribute[] fileAttributeArr, int i11, Object obj) throws IOException {
        if ((i11 & 2) != 0) {
            str = null;
        }
        return createTempDirectory(path, str, fileAttributeArr);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path createTempFile(String str, String str2, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Path a11 = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(a11, "createTempFile(prefix, suffix, *attributes)");
        return a11;
    }

    public static /* synthetic */ Path createTempFile$default(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i11, Object obj) throws IOException {
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        return createTempFile(path, str, str2, fileAttributeArr);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final void deleteExisting(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Files.delete(path);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean deleteIfExists(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Files.deleteIfExists(path);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path div(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "other");
        Path a11 = path.resolve(path2);
        Intrinsics.checkNotNullExpressionValue(a11, "this.resolve(other)");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean exists(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        return Files.exists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @NotNull
    @PublishedApi
    public static final Void fileAttributeViewNotAvailable(@NotNull Path path, @NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(cls, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + cls + " is not available for the file " + path + '.');
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesView(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        V a11 = Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        if (a11 != null) {
            return a11;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        fileAttributeViewNotAvailable(path, FileAttributeView.class);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesViewOrNull(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        return Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final long fileSize(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Files.size(path);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final FileStore fileStore(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        FileStore a11 = Files.getFileStore(path);
        Intrinsics.checkNotNullExpressionValue(a11, "getFileStore(this)");
        return a11;
    }

    @SinceKotlin(version = "1.7")
    @NotNull
    @ExperimentalPathApi
    public static final FileVisitor<Path> fileVisitor(@NotNull Function1<? super FileVisitorBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        FileVisitorBuilderImpl fileVisitorBuilderImpl = new FileVisitorBuilderImpl();
        function1.invoke(fileVisitorBuilderImpl);
        return fileVisitorBuilderImpl.build();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r2, r4);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        throw r0;
     */
    @kotlin.SinceKotlin(version = "1.5")
    @kotlin.internal.InlineOnly
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void forEachDirectoryEntry(java.nio.file.Path r2, java.lang.String r3, kotlin.jvm.functions.Function1<? super java.nio.file.Path, kotlin.Unit> r4) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "glob"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.nio.file.DirectoryStream r2 = java.nio.file.Files.newDirectoryStream(r2, r3)
            r3 = 1
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch:{ all -> 0x0038 }
            java.util.Iterator r0 = r2.iterator()     // Catch:{ all -> 0x0038 }
        L_0x001d:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0038 }
            if (r1 == 0) goto L_0x002b
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0038 }
            r4.invoke(r1)     // Catch:{ all -> 0x0038 }
            goto L_0x001d
        L_0x002b:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0038 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r4 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r4)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            return
        L_0x0038:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x003a }
        L_0x003a:
            r0 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            kotlin.io.CloseableKt.closeFinally(r2, r4)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathUtilsKt.forEachDirectoryEntry(java.nio.file.Path, java.lang.String, kotlin.jvm.functions.Function1):void");
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Object getAttribute(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(str, "attribute");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        return Files.getAttribute(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @NotNull
    public static final String getExtension(@NotNull Path path) {
        String obj;
        String substringAfterLast;
        Intrinsics.checkNotNullParameter(path, "<this>");
        Path a11 = path.getFileName();
        if (a11 == null || (obj = a11.toString()) == null || (substringAfterLast = StringsKt__StringsKt.substringAfterLast(obj, '.', "")) == null) {
            return "";
        }
        return substringAfterLast;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void getExtension$annotations(Path path) {
    }

    private static final String getInvariantSeparatorsPath(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return getInvariantSeparatorsPathString(path);
    }

    @SinceKotlin(version = "1.4")
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @ReplaceWith(expression = "invariantSeparatorsPathString", imports = {}))
    @InlineOnly
    @ExperimentalPathApi
    public static /* synthetic */ void getInvariantSeparatorsPath$annotations(Path path) {
    }

    @NotNull
    public static final String getInvariantSeparatorsPathString(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        String a11 = path.getFileSystem().getSeparator();
        if (Intrinsics.areEqual((Object) a11, (Object) "/")) {
            return path.toString();
        }
        String obj = path.toString();
        Intrinsics.checkNotNullExpressionValue(a11, "separator");
        return StringsKt__StringsJVMKt.replace$default(obj, a11, "/", false, 4, (Object) null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void getInvariantSeparatorsPathString$annotations(Path path) {
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final FileTime getLastModifiedTime(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        FileTime a11 = Files.getLastModifiedTime(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(a11, "getLastModifiedTime(this, *options)");
        return a11;
    }

    @NotNull
    public static final String getName(@NotNull Path path) {
        String str;
        Intrinsics.checkNotNullParameter(path, "<this>");
        Path a11 = path.getFileName();
        if (a11 != null) {
            str = a11.toString();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void getName$annotations(Path path) {
    }

    @NotNull
    public static final String getNameWithoutExtension(@NotNull Path path) {
        String obj;
        String substringBeforeLast$default;
        Intrinsics.checkNotNullParameter(path, "<this>");
        Path a11 = path.getFileName();
        if (a11 == null || (obj = a11.toString()) == null || (substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(obj, (String) RealDiscoveryConfigurationRepository.VERSION_DELIMETER, (String) null, 2, (Object) null)) == null) {
            return "";
        }
        return substringBeforeLast$default;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void getNameWithoutExtension$annotations(Path path) {
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final UserPrincipal getOwner(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        return Files.getOwner(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final String getPathString(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.toString();
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void getPathString$annotations(Path path) {
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Set<PosixFilePermission> getPosixFilePermissions(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        Set<PosixFilePermission> a11 = Files.getPosixFilePermissions(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(a11, "getPosixFilePermissions(this, *options)");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean isDirectory(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        return Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean isExecutable(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Files.isExecutable(path);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean isHidden(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Files.isHidden(path);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean isReadable(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Files.isReadable(path);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean isRegularFile(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        return Files.isRegularFile(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean isSameFileAs(Path path, Path path2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "other");
        return Files.isSameFile(path, path2);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean isSymbolicLink(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Files.isSymbolicLink(path);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean isWritable(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Files.isWritable(path);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    @kotlin.SinceKotlin(version = "1.5")
    @org.jetbrains.annotations.NotNull
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<java.nio.file.Path> listDirectoryEntries(@org.jetbrains.annotations.NotNull java.nio.file.Path r1, @org.jetbrains.annotations.NotNull java.lang.String r2) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "glob"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.nio.file.DirectoryStream r1 = java.nio.file.Files.newDirectoryStream(r1, r2)
            java.lang.String r2 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ all -> 0x001c }
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r1)     // Catch:{ all -> 0x001c }
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r0)
            return r2
        L_0x001c:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001e }
        L_0x001e:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathUtilsKt.listDirectoryEntries(java.nio.file.Path, java.lang.String):java.util.List");
    }

    public static /* synthetic */ List listDirectoryEntries$default(Path path, String str, int i11, Object obj) throws IOException {
        if ((i11 & 1) != 0) {
            str = "*";
        }
        return listDirectoryEntries(path, str);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path moveTo(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "target");
        Intrinsics.checkNotNullParameter(copyOptionArr, "options");
        Path a11 = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(a11, "move(this, target, *options)");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final boolean notExists(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        return Files.notExists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final /* synthetic */ <A extends BasicFileAttributes> A readAttributes(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        A a11 = Files.readAttributes(path, BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(a11, "readAttributes(this, A::class.java, *options)");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path readSymbolicLink(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Path a11 = Files.readSymbolicLink(path);
        Intrinsics.checkNotNullExpressionValue(a11, "readSymbolicLink(this)");
        return a11;
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path relativeTo(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, TtmlNode.RUBY_BASE);
        try {
            return PathRelativizer.INSTANCE.tryRelativeTo(path, path2);
        } catch (IllegalArgumentException e11) {
            throw new IllegalArgumentException(e11.getMessage() + "\nthis path: " + path + "\nbase path: " + path2, e11);
        }
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path relativeToOrNull(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, TtmlNode.RUBY_BASE);
        try {
            return PathRelativizer.INSTANCE.tryRelativeTo(path, path2);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path relativeToOrSelf(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, TtmlNode.RUBY_BASE);
        Path relativeToOrNull = relativeToOrNull(path, path2);
        if (relativeToOrNull == null) {
            return path;
        }
        return relativeToOrNull;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path setAttribute(Path path, String str, Object obj, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(str, "attribute");
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        Path a11 = Files.setAttribute(path, str, obj, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(a11, "setAttribute(this, attribute, value, *options)");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path setLastModifiedTime(Path path, FileTime fileTime) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(fileTime, "value");
        Path a11 = Files.setLastModifiedTime(path, fileTime);
        Intrinsics.checkNotNullExpressionValue(a11, "setLastModifiedTime(this, value)");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path setOwner(Path path, UserPrincipal userPrincipal) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(userPrincipal, "value");
        Path a11 = Files.setOwner(path, userPrincipal);
        Intrinsics.checkNotNullExpressionValue(a11, "setOwner(this, value)");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path setPosixFilePermissions(Path path, Set<? extends PosixFilePermission> set) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(set, "value");
        Path a11 = Files.setPosixFilePermissions(path, set);
        Intrinsics.checkNotNullExpressionValue(a11, "setPosixFilePermissions(this, value)");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path toPath(URI uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Path a11 = Paths.get(uri);
        Intrinsics.checkNotNullExpressionValue(a11, "get(this)");
        return a11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r1, r3);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    @kotlin.SinceKotlin(version = "1.5")
    @kotlin.internal.InlineOnly
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> T useDirectoryEntries(java.nio.file.Path r1, java.lang.String r2, kotlin.jvm.functions.Function1<? super kotlin.sequences.Sequence<? extends java.nio.file.Path>, ? extends T> r3) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "glob"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.nio.file.DirectoryStream r1 = java.nio.file.Files.newDirectoryStream(r1, r2)
            r2 = 1
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)     // Catch:{ all -> 0x002c }
            kotlin.sequences.Sequence r0 = kotlin.collections.CollectionsKt___CollectionsKt.asSequence(r1)     // Catch:{ all -> 0x002c }
            java.lang.Object r3 = r3.invoke(r0)     // Catch:{ all -> 0x002c }
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r0)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            return r3
        L_0x002c:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x002e }
        L_0x002e:
            r0 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            kotlin.io.CloseableKt.closeFinally(r1, r3)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathUtilsKt.useDirectoryEntries(java.nio.file.Path, java.lang.String, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalPathApi
    public static final void visitFileTree(@NotNull Path path, @NotNull FileVisitor<Path> fileVisitor, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(fileVisitor, "visitor");
        Path unused = Files.walkFileTree(path, z11 ? SetsKt__SetsJVMKt.setOf(FileVisitOption.FOLLOW_LINKS) : SetsKt__SetsKt.emptySet(), i11, fileVisitor);
    }

    public static /* synthetic */ void visitFileTree$default(Path path, FileVisitor fileVisitor, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = Integer.MAX_VALUE;
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        visitFileTree(path, (FileVisitor<Path>) fileVisitor, i11, z11);
    }

    @SinceKotlin(version = "1.7")
    @NotNull
    @ExperimentalPathApi
    public static final Sequence<Path> walk(@NotNull Path path, @NotNull PathWalkOption... pathWalkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(pathWalkOptionArr, "options");
        return new PathTreeWalk(path, pathWalkOptionArr);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path Path(String str, String... strArr) {
        Intrinsics.checkNotNullParameter(str, TtmlNode.RUBY_BASE);
        Intrinsics.checkNotNullParameter(strArr, "subpaths");
        Path a11 = Paths.get(str, (String[]) Arrays.copyOf(strArr, strArr.length));
        Intrinsics.checkNotNullExpressionValue(a11, "get(base, *subpaths)");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path createTempDirectory(@Nullable Path path, @Nullable String str, @NotNull FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (path != null) {
            Path a11 = Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
            Intrinsics.checkNotNullExpressionValue(a11, "createTempDirectory(dire…ory, prefix, *attributes)");
            return a11;
        }
        Path a12 = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(a12, "createTempDirectory(prefix, *attributes)");
        return a12;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path createTempFile(@Nullable Path path, @Nullable String str, @Nullable String str2, @NotNull FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (path != null) {
            Path a11 = Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
            Intrinsics.checkNotNullExpressionValue(a11, "createTempFile(directory…fix, suffix, *attributes)");
            return a11;
        }
        Path a12 = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(a12, "createTempFile(prefix, suffix, *attributes)");
        return a12;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path div(Path path, String str) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(str, "other");
        Path a11 = path.resolve(str);
        Intrinsics.checkNotNullExpressionValue(a11, "this.resolve(other)");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path moveTo(Path path, Path path2, boolean z11) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "target");
        CopyOption[] copyOptionArr = z11 ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path a11 = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(a11, "move(this, target, *options)");
        return a11;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Map<String, Object> readAttributes(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(str, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(linkOptionArr, "options");
        Map<String, Object> a11 = Files.readAttributes(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(a11, "readAttributes(this, attributes, *options)");
        return a11;
    }

    public static /* synthetic */ void visitFileTree$default(Path path, int i11, boolean z11, Function1 function1, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = Integer.MAX_VALUE;
        }
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        visitFileTree(path, i11, z11, (Function1<? super FileVisitorBuilder, Unit>) function1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalPathApi
    public static final void visitFileTree(@NotNull Path path, int i11, boolean z11, @NotNull Function1<? super FileVisitorBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        visitFileTree(path, fileVisitor(function1), i11, z11);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path copyTo(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "target");
        Intrinsics.checkNotNullParameter(copyOptionArr, "options");
        Path a11 = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(a11, "copy(this, target, *options)");
        return a11;
    }
}
