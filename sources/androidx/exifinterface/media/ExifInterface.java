package androidx.exifinterface.media;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterfaceUtils;
import com.deliveryhero.perseus.data.remote.api.client.PerseusRetrofitBuilder;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.base.Ascii;
import j$.util.DesugarTimeZone;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import net.bytebuddy.description.modifier.ModifierContributor;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.lang3.CharUtils;
import org.tukaani.xz.LZMA2Options;

public class ExifInterface {
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = {4};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = {8};
    public static final int[] BITS_PER_SAMPLE_RGB = {8, 8, 8};
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    private static final Pattern DATETIME_PRIMARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    private static final Pattern DATETIME_SECONDARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    private static final int DATETIME_VALUE_STRING_LENGTH = 19;
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final ExifTag[] EXIF_POINTER_TAGS = {new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1)};
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    private static final List<Integer> FLIPPED_ROTATION_ORDER = Arrays.asList(new Integer[]{2, 7, 4, 5});
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    private static final Pattern GPS_TIMESTAMP_PATTERN = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
    private static final byte[] HEIF_BRAND_HEIC = {104, 101, 105, 99};
    private static final byte[] HEIF_BRAND_MIF1 = {109, 105, 102, TarConstants.LF_LINK};
    private static final byte[] HEIF_TYPE_FTYP = {102, 116, 121, 112};
    private static final byte[] IDENTIFIER_XMP_APP1;
    private static final ExifTag[] IFD_EXIF_TAGS;
    private static final int IFD_FORMAT_BYTE = 1;
    private static final int IFD_FORMAT_DOUBLE = 12;
    private static final int IFD_FORMAT_IFD = 13;
    private static final int IFD_FORMAT_SBYTE = 6;
    private static final int IFD_FORMAT_SINGLE = 11;
    private static final int IFD_FORMAT_SLONG = 9;
    private static final int IFD_FORMAT_SRATIONAL = 10;
    private static final int IFD_FORMAT_SSHORT = 8;
    private static final int IFD_FORMAT_STRING = 2;
    private static final int IFD_FORMAT_ULONG = 4;
    private static final int IFD_FORMAT_UNDEFINED = 7;
    private static final int IFD_FORMAT_URATIONAL = 5;
    private static final int IFD_FORMAT_USHORT = 3;
    private static final ExifTag[] IFD_GPS_TAGS;
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS;
    private static final int IFD_OFFSET = 8;
    private static final ExifTag[] IFD_THUMBNAIL_TAGS;
    private static final ExifTag[] IFD_TIFF_TAGS;
    private static final int IFD_TYPE_EXIF = 1;
    private static final int IFD_TYPE_GPS = 2;
    private static final int IFD_TYPE_INTEROPERABILITY = 3;
    private static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    private static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    private static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    private static final int IFD_TYPE_PEF = 9;
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    private static final byte MARKER_COM = -2;
    private static final byte MARKER_SOF0 = -64;
    private static final byte MARKER_SOF1 = -63;
    private static final byte MARKER_SOF10 = -54;
    private static final byte MARKER_SOF11 = -53;
    private static final byte MARKER_SOF13 = -51;
    private static final byte MARKER_SOF14 = -50;
    private static final byte MARKER_SOF15 = -49;
    private static final byte MARKER_SOF2 = -62;
    private static final byte MARKER_SOF3 = -61;
    private static final byte MARKER_SOF5 = -59;
    private static final byte MARKER_SOF6 = -58;
    private static final byte MARKER_SOF7 = -57;
    private static final byte MARKER_SOF9 = -55;
    private static final byte MARKER_SOI = -40;
    private static final byte MARKER_SOS = -38;
    private static final int MAX_THUMBNAIL_SIZE = 512;
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    private static final Pattern NON_ZERO_TIME_PATTERN = Pattern.compile(".*[1-9].*");
    private static final ExifTag[] ORF_CAMERA_SETTINGS_TAGS;
    private static final ExifTag[] ORF_IMAGE_PROCESSING_TAGS;
    private static final byte[] ORF_MAKER_NOTE_HEADER_1 = {79, TarConstants.LF_GNUTYPE_LONGNAME, 89, 77, 80, 0};
    private static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    private static final byte[] ORF_MAKER_NOTE_HEADER_2 = {79, TarConstants.LF_GNUTYPE_LONGNAME, 89, 77, 80, 85, TarConstants.LF_GNUTYPE_SPARSE, 0, 73, 73};
    private static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    private static final ExifTag[] ORF_MAKER_NOTE_TAGS;
    private static final short ORF_SIGNATURE_1 = 20306;
    private static final short ORF_SIGNATURE_2 = 21330;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    private static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    private static final String PEF_SIGNATURE = "PENTAX";
    private static final ExifTag[] PEF_TAGS;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    private static final int PNG_CHUNK_CRC_BYTE_LENGTH = 4;
    private static final int PNG_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final byte[] PNG_CHUNK_TYPE_EXIF = {101, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 73, 102};
    private static final byte[] PNG_CHUNK_TYPE_IEND = {73, 69, 78, 68};
    private static final byte[] PNG_CHUNK_TYPE_IHDR = {73, 72, 68, 82};
    private static final byte[] PNG_SIGNATURE = {-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10};
    private static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    private static final String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    private static final List<Integer> ROTATION_ORDER = Arrays.asList(new Integer[]{1, 6, 3, 8});
    private static final short RW2_SIGNATURE = 85;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    private static final int SIGNATURE_CHECK_SIZE = 5000;
    private static final int SKIP_BUFFER_SIZE = 8192;
    public static final int STREAM_TYPE_EXIF_DATA_ONLY = 1;
    public static final int STREAM_TYPE_FULL_IMAGE_DATA = 0;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    private static final String TAG = "ExifInterface";
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    @Deprecated
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CAMERA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_OFFSET_TIME = "OffsetTime";
    public static final String TAG_OFFSET_TIME_DIGITIZED = "OffsetTimeDigitized";
    public static final String TAG_OFFSET_TIME_ORIGINAL = "OffsetTimeOriginal";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final ExifTag TAG_RAF_IMAGE_SIZE = new ExifTag(TAG_STRIP_OFFSETS, LZMA2Options.NICE_LEN_MAX, 3);
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_XMP = "Xmp";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    private static final int WEBP_CHUNK_SIZE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_CHUNK_TYPE_ANIM = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_ANMF = "ANMF".getBytes(Charset.defaultCharset());
    private static final int WEBP_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_CHUNK_TYPE_EXIF = {69, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 73, 70};
    private static final byte[] WEBP_CHUNK_TYPE_VP8 = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_VP8L = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_VP8X = "VP8X".getBytes(Charset.defaultCharset());
    private static final int WEBP_CHUNK_TYPE_VP8X_DEFAULT_LENGTH = 10;
    private static final int WEBP_FILE_SIZE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_SIGNATURE_1 = {82, 73, 70, 70};
    private static final byte[] WEBP_SIGNATURE_2 = {87, 69, 66, 80};
    private static final byte WEBP_VP8L_SIGNATURE = 47;
    private static final byte[] WEBP_VP8_SIGNATURE = {-99, 1, 42};
    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;
    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f35955a = {-1, MARKER_SOI, -1};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f35956b = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f35957c = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f35958d = {65, TarConstants.LF_GNUTYPE_SPARSE, 67, 73, 73, 0, 0, 0};

    /* renamed from: e  reason: collision with root package name */
    public static final ExifTag[][] f35959e;

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f35960f;

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f35961g;
    private static final HashMap<Integer, Integer> sExifPointerTagMap = new HashMap<>();
    private static final HashMap<Integer, ExifTag>[] sExifTagMapsForReading;
    private static final HashMap<String, ExifTag>[] sExifTagMapsForWriting;
    private static SimpleDateFormat sFormatterPrimary;
    private static SimpleDateFormat sFormatterSecondary;
    private static final HashSet<String> sTagSetForCompatibility = new HashSet<>(Arrays.asList(new String[]{TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP}));
    private boolean mAreThumbnailStripsConsecutive;
    private AssetManager.AssetInputStream mAssetInputStream;
    private final HashMap<String, ExifAttribute>[] mAttributes;
    private Set<Integer> mAttributesOffsets;
    private ByteOrder mExifByteOrder;
    private String mFilename;
    private boolean mHasThumbnail;
    private boolean mHasThumbnailStrips;
    private boolean mIsExifDataOnly;
    private int mMimeType;
    private boolean mModified;
    private int mOffsetToExifData;
    private int mOrfMakerNoteOffset;
    private int mOrfThumbnailLength;
    private int mOrfThumbnailOffset;
    private FileDescriptor mSeekableFileDescriptor;
    private byte[] mThumbnailBytes;
    private int mThumbnailCompression;
    private int mThumbnailLength;
    private int mThumbnailOffset;
    private boolean mXmpIsFromSeparateMarker;

    public static class ByteOrderedDataInputStream extends InputStream implements DataInput {
        private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: b  reason: collision with root package name */
        public final DataInputStream f35965b;

        /* renamed from: c  reason: collision with root package name */
        public int f35966c;
        private ByteOrder mByteOrder;
        private byte[] mSkipBuffer;

        public ByteOrderedDataInputStream(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        public int available() throws IOException {
            return this.f35965b.available();
        }

        public void mark(int i11) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        public int position() {
            return this.f35966c;
        }

        public int read() throws IOException {
            this.f35966c++;
            return this.f35965b.read();
        }

        public boolean readBoolean() throws IOException {
            this.f35966c++;
            return this.f35965b.readBoolean();
        }

        public byte readByte() throws IOException {
            this.f35966c++;
            int read = this.f35965b.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        public char readChar() throws IOException {
            this.f35966c += 2;
            return this.f35965b.readChar();
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public void readFully(byte[] bArr, int i11, int i12) throws IOException {
            this.f35966c += i12;
            this.f35965b.readFully(bArr, i11, i12);
        }

        public int readInt() throws IOException {
            this.f35966c += 4;
            int read = this.f35965b.read();
            int read2 = this.f35965b.read();
            int read3 = this.f35965b.read();
            int read4 = this.f35965b.read();
            if ((read | read2 | read3 | read4) >= 0) {
                ByteOrder byteOrder = this.mByteOrder;
                if (byteOrder == LITTLE_ENDIAN) {
                    return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == BIG_ENDIAN) {
                    return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                }
                throw new IOException("Invalid byte order: " + this.mByteOrder);
            }
            throw new EOFException();
        }

        public String readLine() throws IOException {
            return null;
        }

        public long readLong() throws IOException {
            this.f35966c += 8;
            int read = this.f35965b.read();
            int read2 = this.f35965b.read();
            int read3 = this.f35965b.read();
            int read4 = this.f35965b.read();
            int read5 = this.f35965b.read();
            int read6 = this.f35965b.read();
            int read7 = this.f35965b.read();
            int read8 = this.f35965b.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                ByteOrder byteOrder = this.mByteOrder;
                if (byteOrder == LITTLE_ENDIAN) {
                    return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                }
                int i11 = read2;
                if (byteOrder == BIG_ENDIAN) {
                    return (((long) read) << 56) + (((long) i11) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                }
                throw new IOException("Invalid byte order: " + this.mByteOrder);
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            this.f35966c += 2;
            int read = this.f35965b.read();
            int read2 = this.f35965b.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.mByteOrder;
                if (byteOrder == LITTLE_ENDIAN) {
                    return (short) ((read2 << 8) + read);
                }
                if (byteOrder == BIG_ENDIAN) {
                    return (short) ((read << 8) + read2);
                }
                throw new IOException("Invalid byte order: " + this.mByteOrder);
            }
            throw new EOFException();
        }

        public String readUTF() throws IOException {
            this.f35966c += 2;
            return this.f35965b.readUTF();
        }

        public int readUnsignedByte() throws IOException {
            this.f35966c++;
            return this.f35965b.readUnsignedByte();
        }

        public long readUnsignedInt() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public int readUnsignedShort() throws IOException {
            this.f35966c += 2;
            int read = this.f35965b.read();
            int read2 = this.f35965b.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.mByteOrder;
                if (byteOrder == LITTLE_ENDIAN) {
                    return (read2 << 8) + read;
                }
                if (byteOrder == BIG_ENDIAN) {
                    return (read << 8) + read2;
                }
                throw new IOException("Invalid byte order: " + this.mByteOrder);
            }
            throw new EOFException();
        }

        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        public int skipBytes(int i11) throws IOException {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public void skipFully(int i11) throws IOException {
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i11 - i12;
                int skip = (int) this.f35965b.skip((long) i13);
                if (skip <= 0) {
                    if (this.mSkipBuffer == null) {
                        this.mSkipBuffer = new byte[8192];
                    }
                    skip = this.f35965b.read(this.mSkipBuffer, 0, Math.min(8192, i13));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i11 + " bytes.");
                    }
                }
                i12 += skip;
            }
            this.f35966c += i12;
        }

        public ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.mByteOrder = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f35965b = dataInputStream;
            dataInputStream.mark(0);
            this.f35966c = 0;
            this.mByteOrder = byteOrder;
        }

        public int read(byte[] bArr, int i11, int i12) throws IOException {
            int read = this.f35965b.read(bArr, i11, i12);
            this.f35966c += read;
            return read;
        }

        public void readFully(byte[] bArr) throws IOException {
            this.f35966c += bArr.length;
            this.f35965b.readFully(bArr);
        }
    }

    public static class ByteOrderedDataOutputStream extends FilterOutputStream {

        /* renamed from: b  reason: collision with root package name */
        public final OutputStream f35967b;
        private ByteOrder mByteOrder;

        public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f35967b = outputStream;
            this.mByteOrder = byteOrder;
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        public void write(byte[] bArr) throws IOException {
            this.f35967b.write(bArr);
        }

        public void writeByte(int i11) throws IOException {
            this.f35967b.write(i11);
        }

        public void writeInt(int i11) throws IOException {
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f35967b.write((i11 >>> 0) & 255);
                this.f35967b.write((i11 >>> 8) & 255);
                this.f35967b.write((i11 >>> 16) & 255);
                this.f35967b.write((i11 >>> 24) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f35967b.write((i11 >>> 24) & 255);
                this.f35967b.write((i11 >>> 16) & 255);
                this.f35967b.write((i11 >>> 8) & 255);
                this.f35967b.write((i11 >>> 0) & 255);
            }
        }

        public void writeShort(short s11) throws IOException {
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f35967b.write((s11 >>> 0) & 255);
                this.f35967b.write((s11 >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f35967b.write((s11 >>> 8) & 255);
                this.f35967b.write((s11 >>> 0) & 255);
            }
        }

        public void writeUnsignedInt(long j11) throws IOException {
            writeInt((int) j11);
        }

        public void writeUnsignedShort(int i11) throws IOException {
            writeShort((short) i11);
        }

        public void write(byte[] bArr, int i11, int i12) throws IOException {
            this.f35967b.write(bArr, i11, i12);
        }
    }

    public static class ExifAttribute {
        public static final long BYTES_OFFSET_UNKNOWN = -1;
        public final byte[] bytes;
        public final long bytesOffset;
        public final int format;
        public final int numberOfComponents;

        public ExifAttribute(int i11, int i12, byte[] bArr) {
            this(i11, i12, -1, bArr);
        }

        public static ExifAttribute createByte(String str) {
            if (str.length() != 1 || str.charAt(0) < '0' || str.charAt(0) > '1') {
                byte[] bytes2 = str.getBytes(ExifInterface.f35960f);
                return new ExifAttribute(1, bytes2.length, bytes2);
            }
            return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }

        public static ExifAttribute createDouble(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.f35957c[12] * dArr.length)]);
            wrap.order(byteOrder);
            for (double putDouble : dArr) {
                wrap.putDouble(putDouble);
            }
            return new ExifAttribute(12, dArr.length, wrap.array());
        }

        public static ExifAttribute createSLong(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.f35957c[9] * iArr.length)]);
            wrap.order(byteOrder);
            for (int putInt : iArr) {
                wrap.putInt(putInt);
            }
            return new ExifAttribute(9, iArr.length, wrap.array());
        }

        public static ExifAttribute createSRational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.f35957c[10] * rationalArr.length)]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(10, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createString(String str) {
            byte[] bytes2 = (str + 0).getBytes(ExifInterface.f35960f);
            return new ExifAttribute(2, bytes2.length, bytes2);
        }

        public static ExifAttribute createULong(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.f35957c[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j11 : jArr) {
                wrap.putInt((int) j11);
            }
            return new ExifAttribute(4, jArr.length, wrap.array());
        }

        public static ExifAttribute createURational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.f35957c[5] * rationalArr.length)]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(5, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createUShort(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.f35957c[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i11 : iArr) {
                wrap.putShort((short) i11);
            }
            return new ExifAttribute(3, iArr.length, wrap.array());
        }

        /* JADX WARNING: Removed duplicated region for block: B:163:0x019b A[SYNTHETIC, Splitter:B:163:0x019b] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object a(java.nio.ByteOrder r11) {
            /*
                r10 = this;
                java.lang.String r0 = "IOException occurred while closing InputStream"
                java.lang.String r1 = "ExifInterface"
                r2 = 0
                androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r3 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ IOException -> 0x0185, all -> 0x0183 }
                byte[] r4 = r10.bytes     // Catch:{ IOException -> 0x0185, all -> 0x0183 }
                r3.<init>((byte[]) r4)     // Catch:{ IOException -> 0x0185, all -> 0x0183 }
                r3.setByteOrder(r11)     // Catch:{ IOException -> 0x0181 }
                int r11 = r10.format     // Catch:{ IOException -> 0x0181 }
                r4 = 0
                r5 = 1
                switch(r11) {
                    case 1: goto L_0x0148;
                    case 2: goto L_0x00fd;
                    case 3: goto L_0x00e3;
                    case 4: goto L_0x00c9;
                    case 5: goto L_0x00a6;
                    case 6: goto L_0x0148;
                    case 7: goto L_0x00fd;
                    case 8: goto L_0x008c;
                    case 9: goto L_0x0072;
                    case 10: goto L_0x004d;
                    case 11: goto L_0x0032;
                    case 12: goto L_0x0018;
                    default: goto L_0x0016;
                }     // Catch:{ IOException -> 0x0181 }
            L_0x0016:
                goto L_0x0178
            L_0x0018:
                int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0181 }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x001c:
                int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x0029
                double r5 = r3.readDouble()     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x001c
            L_0x0029:
                r3.close()     // Catch:{ IOException -> 0x002d }
                goto L_0x0031
            L_0x002d:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0031:
                return r11
            L_0x0032:
                int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0181 }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x0036:
                int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x0044
                float r5 = r3.readFloat()     // Catch:{ IOException -> 0x0181 }
                double r5 = (double) r5     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x0036
            L_0x0044:
                r3.close()     // Catch:{ IOException -> 0x0048 }
                goto L_0x004c
            L_0x0048:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x004c:
                return r11
            L_0x004d:
                int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0181 }
                androidx.exifinterface.media.ExifInterface$Rational[] r11 = new androidx.exifinterface.media.ExifInterface.Rational[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x0051:
                int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x0069
                int r5 = r3.readInt()     // Catch:{ IOException -> 0x0181 }
                long r5 = (long) r5     // Catch:{ IOException -> 0x0181 }
                int r7 = r3.readInt()     // Catch:{ IOException -> 0x0181 }
                long r7 = (long) r7     // Catch:{ IOException -> 0x0181 }
                androidx.exifinterface.media.ExifInterface$Rational r9 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ IOException -> 0x0181 }
                r9.<init>(r5, r7)     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r9     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x0051
            L_0x0069:
                r3.close()     // Catch:{ IOException -> 0x006d }
                goto L_0x0071
            L_0x006d:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0071:
                return r11
            L_0x0072:
                int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0181 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x0076:
                int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x0083
                int r5 = r3.readInt()     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x0076
            L_0x0083:
                r3.close()     // Catch:{ IOException -> 0x0087 }
                goto L_0x008b
            L_0x0087:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x008b:
                return r11
            L_0x008c:
                int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0181 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x0090:
                int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x009d
                short r5 = r3.readShort()     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x0090
            L_0x009d:
                r3.close()     // Catch:{ IOException -> 0x00a1 }
                goto L_0x00a5
            L_0x00a1:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00a5:
                return r11
            L_0x00a6:
                int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0181 }
                androidx.exifinterface.media.ExifInterface$Rational[] r11 = new androidx.exifinterface.media.ExifInterface.Rational[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x00aa:
                int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x00c0
                long r5 = r3.readUnsignedInt()     // Catch:{ IOException -> 0x0181 }
                long r7 = r3.readUnsignedInt()     // Catch:{ IOException -> 0x0181 }
                androidx.exifinterface.media.ExifInterface$Rational r9 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ IOException -> 0x0181 }
                r9.<init>(r5, r7)     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r9     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x00aa
            L_0x00c0:
                r3.close()     // Catch:{ IOException -> 0x00c4 }
                goto L_0x00c8
            L_0x00c4:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00c8:
                return r11
            L_0x00c9:
                int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0181 }
                long[] r11 = new long[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x00cd:
                int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x00da
                long r5 = r3.readUnsignedInt()     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x00cd
            L_0x00da:
                r3.close()     // Catch:{ IOException -> 0x00de }
                goto L_0x00e2
            L_0x00de:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00e2:
                return r11
            L_0x00e3:
                int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0181 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0181 }
            L_0x00e7:
                int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x00f4
                int r5 = r3.readUnsignedShort()     // Catch:{ IOException -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x00e7
            L_0x00f4:
                r3.close()     // Catch:{ IOException -> 0x00f8 }
                goto L_0x00fc
            L_0x00f8:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00fc:
                return r11
            L_0x00fd:
                int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0181 }
                byte[] r6 = androidx.exifinterface.media.ExifInterface.f35958d     // Catch:{ IOException -> 0x0181 }
                int r6 = r6.length     // Catch:{ IOException -> 0x0181 }
                if (r11 < r6) goto L_0x011a
                r11 = r4
            L_0x0105:
                byte[] r6 = androidx.exifinterface.media.ExifInterface.f35958d     // Catch:{ IOException -> 0x0181 }
                int r7 = r6.length     // Catch:{ IOException -> 0x0181 }
                if (r11 >= r7) goto L_0x0117
                byte[] r7 = r10.bytes     // Catch:{ IOException -> 0x0181 }
                byte r7 = r7[r11]     // Catch:{ IOException -> 0x0181 }
                byte r8 = r6[r11]     // Catch:{ IOException -> 0x0181 }
                if (r7 == r8) goto L_0x0114
                r5 = r4
                goto L_0x0117
            L_0x0114:
                int r11 = r11 + 1
                goto L_0x0105
            L_0x0117:
                if (r5 == 0) goto L_0x011a
                int r4 = r6.length     // Catch:{ IOException -> 0x0181 }
            L_0x011a:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0181 }
                r11.<init>()     // Catch:{ IOException -> 0x0181 }
            L_0x011f:
                int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x0181 }
                if (r4 >= r5) goto L_0x013b
                byte[] r5 = r10.bytes     // Catch:{ IOException -> 0x0181 }
                byte r5 = r5[r4]     // Catch:{ IOException -> 0x0181 }
                if (r5 != 0) goto L_0x012a
                goto L_0x013b
            L_0x012a:
                r6 = 32
                if (r5 < r6) goto L_0x0133
                char r5 = (char) r5     // Catch:{ IOException -> 0x0181 }
                r11.append(r5)     // Catch:{ IOException -> 0x0181 }
                goto L_0x0138
            L_0x0133:
                r5 = 63
                r11.append(r5)     // Catch:{ IOException -> 0x0181 }
            L_0x0138:
                int r4 = r4 + 1
                goto L_0x011f
            L_0x013b:
                java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x0181 }
                r3.close()     // Catch:{ IOException -> 0x0143 }
                goto L_0x0147
            L_0x0143:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0147:
                return r11
            L_0x0148:
                byte[] r11 = r10.bytes     // Catch:{ IOException -> 0x0181 }
                int r6 = r11.length     // Catch:{ IOException -> 0x0181 }
                if (r6 != r5) goto L_0x0168
                byte r6 = r11[r4]     // Catch:{ IOException -> 0x0181 }
                if (r6 < 0) goto L_0x0168
                if (r6 > r5) goto L_0x0168
                java.lang.String r11 = new java.lang.String     // Catch:{ IOException -> 0x0181 }
                char[] r5 = new char[r5]     // Catch:{ IOException -> 0x0181 }
                int r6 = r6 + 48
                char r6 = (char) r6     // Catch:{ IOException -> 0x0181 }
                r5[r4] = r6     // Catch:{ IOException -> 0x0181 }
                r11.<init>(r5)     // Catch:{ IOException -> 0x0181 }
                r3.close()     // Catch:{ IOException -> 0x0163 }
                goto L_0x0167
            L_0x0163:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0167:
                return r11
            L_0x0168:
                java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x0181 }
                java.nio.charset.Charset r5 = androidx.exifinterface.media.ExifInterface.f35960f     // Catch:{ IOException -> 0x0181 }
                r4.<init>(r11, r5)     // Catch:{ IOException -> 0x0181 }
                r3.close()     // Catch:{ IOException -> 0x0173 }
                goto L_0x0177
            L_0x0173:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x0177:
                return r4
            L_0x0178:
                r3.close()     // Catch:{ IOException -> 0x017c }
                goto L_0x0180
            L_0x017c:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x0180:
                return r2
            L_0x0181:
                r11 = move-exception
                goto L_0x0187
            L_0x0183:
                r11 = move-exception
                goto L_0x0199
            L_0x0185:
                r11 = move-exception
                r3 = r2
            L_0x0187:
                java.lang.String r4 = "IOException occurred during reading a value"
                android.util.Log.w(r1, r4, r11)     // Catch:{ all -> 0x0197 }
                if (r3 == 0) goto L_0x0196
                r3.close()     // Catch:{ IOException -> 0x0192 }
                goto L_0x0196
            L_0x0192:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x0196:
                return r2
            L_0x0197:
                r11 = move-exception
                r2 = r3
            L_0x0199:
                if (r2 == 0) goto L_0x01a3
                r2.close()     // Catch:{ IOException -> 0x019f }
                goto L_0x01a3
            L_0x019f:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x01a3:
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.ExifAttribute.a(java.nio.ByteOrder):java.lang.Object");
        }

        public double getDoubleValue(ByteOrder byteOrder) {
            Object a11 = a(byteOrder);
            if (a11 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (a11 instanceof String) {
                return Double.parseDouble((String) a11);
            } else {
                if (a11 instanceof long[]) {
                    long[] jArr = (long[]) a11;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a11 instanceof int[]) {
                    int[] iArr = (int[]) a11;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a11 instanceof double[]) {
                    double[] dArr = (double[]) a11;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a11 instanceof Rational[]) {
                    Rational[] rationalArr = (Rational[]) a11;
                    if (rationalArr.length == 1) {
                        return rationalArr[0].calculate();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int getIntValue(ByteOrder byteOrder) {
            Object a11 = a(byteOrder);
            if (a11 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (a11 instanceof String) {
                return Integer.parseInt((String) a11);
            } else {
                if (a11 instanceof long[]) {
                    long[] jArr = (long[]) a11;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a11 instanceof int[]) {
                    int[] iArr = (int[]) a11;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String getStringValue(ByteOrder byteOrder) {
            Object a11 = a(byteOrder);
            if (a11 == null) {
                return null;
            }
            if (a11 instanceof String) {
                return (String) a11;
            }
            StringBuilder sb2 = new StringBuilder();
            int i11 = 0;
            if (a11 instanceof long[]) {
                long[] jArr = (long[]) a11;
                while (i11 < jArr.length) {
                    sb2.append(jArr[i11]);
                    i11++;
                    if (i11 != jArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            } else if (a11 instanceof int[]) {
                int[] iArr = (int[]) a11;
                while (i11 < iArr.length) {
                    sb2.append(iArr[i11]);
                    i11++;
                    if (i11 != iArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            } else if (a11 instanceof double[]) {
                double[] dArr = (double[]) a11;
                while (i11 < dArr.length) {
                    sb2.append(dArr[i11]);
                    i11++;
                    if (i11 != dArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            } else if (!(a11 instanceof Rational[])) {
                return null;
            } else {
                Rational[] rationalArr = (Rational[]) a11;
                while (i11 < rationalArr.length) {
                    sb2.append(rationalArr[i11].numerator);
                    sb2.append('/');
                    sb2.append(rationalArr[i11].denominator);
                    i11++;
                    if (i11 != rationalArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            }
        }

        public int size() {
            return ExifInterface.f35957c[this.format] * this.numberOfComponents;
        }

        public String toString() {
            return "(" + ExifInterface.f35956b[this.format] + ", data length:" + this.bytes.length + ")";
        }

        public ExifAttribute(int i11, int i12, long j11, byte[] bArr) {
            this.format = i11;
            this.numberOfComponents = i12;
            this.bytesOffset = j11;
            this.bytes = bArr;
        }

        public static ExifAttribute createDouble(double d11, ByteOrder byteOrder) {
            return createDouble(new double[]{d11}, byteOrder);
        }

        public static ExifAttribute createSLong(int i11, ByteOrder byteOrder) {
            return createSLong(new int[]{i11}, byteOrder);
        }

        public static ExifAttribute createULong(long j11, ByteOrder byteOrder) {
            return createULong(new long[]{j11}, byteOrder);
        }

        public static ExifAttribute createUShort(int i11, ByteOrder byteOrder) {
            return createUShort(new int[]{i11}, byteOrder);
        }

        public static ExifAttribute createSRational(Rational rational, ByteOrder byteOrder) {
            return createSRational(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute createURational(Rational rational, ByteOrder byteOrder) {
            return createURational(new Rational[]{rational}, byteOrder);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExifStreamType {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IfdType {
    }

    public static class Rational {
        public final long denominator;
        public final long numerator;

        public Rational(double d11) {
            this((long) (d11 * 10000.0d), 10000);
        }

        public double calculate() {
            return ((double) this.numerator) / ((double) this.denominator);
        }

        public String toString() {
            return this.numerator + "/" + this.denominator;
        }

        public Rational(long j11, long j12) {
            if (j12 == 0) {
                this.numerator = 0;
                this.denominator = 1;
                return;
            }
            this.numerator = j11;
            this.denominator = j12;
        }
    }

    static {
        ExifTag[] exifTagArr = {new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_IMAGE_LENGTH, 257, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, BZip2Constants.MAX_ALPHA_SIZE, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag(TAG_MODEL, 272, 2), new ExifTag(TAG_STRIP_OFFSETS, LZMA2Options.NICE_LEN_MAX, 3, 4), new ExifTag(TAG_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, 306, 2), new ExifTag(TAG_ARTIST, 315, 2), new ExifTag(TAG_WHITE_POINT, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new ExifTag(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new ExifTag(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new ExifTag(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new ExifTag(TAG_RW2_ISO, 23, 3), new ExifTag(TAG_RW2_JPG_FROM_RAW, 46, 7), new ExifTag(TAG_XMP, 700, 1)};
        IFD_TIFF_TAGS = exifTagArr;
        ExifTag[] exifTagArr2 = {new ExifTag(TAG_EXPOSURE_TIME, 33434, 5), new ExifTag(TAG_F_NUMBER, 33437, 5), new ExifTag(TAG_EXPOSURE_PROGRAM, 34850, 3), new ExifTag(TAG_SPECTRAL_SENSITIVITY, 34852, 2), new ExifTag(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new ExifTag(TAG_OECF, 34856, 7), new ExifTag(TAG_SENSITIVITY_TYPE, 34864, 3), new ExifTag(TAG_STANDARD_OUTPUT_SENSITIVITY, 34865, 4), new ExifTag(TAG_RECOMMENDED_EXPOSURE_INDEX, 34866, 4), new ExifTag(TAG_ISO_SPEED, 34867, 4), new ExifTag(TAG_ISO_SPEED_LATITUDE_YYY, 34868, 4), new ExifTag(TAG_ISO_SPEED_LATITUDE_ZZZ, 34869, 4), new ExifTag(TAG_EXIF_VERSION, CpioConstants.C_ISNWK, 2), new ExifTag(TAG_DATETIME_ORIGINAL, 36867, 2), new ExifTag(TAG_DATETIME_DIGITIZED, 36868, 2), new ExifTag(TAG_OFFSET_TIME, ModifierContributor.ForParameter.MASK, 2), new ExifTag(TAG_OFFSET_TIME_ORIGINAL, 36881, 2), new ExifTag(TAG_OFFSET_TIME_DIGITIZED, 36882, 2), new ExifTag(TAG_COMPONENTS_CONFIGURATION, 37121, 7), new ExifTag(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new ExifTag(TAG_SHUTTER_SPEED_VALUE, 37377, 10), new ExifTag(TAG_APERTURE_VALUE, 37378, 5), new ExifTag(TAG_BRIGHTNESS_VALUE, 37379, 10), new ExifTag(TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new ExifTag(TAG_MAX_APERTURE_VALUE, 37381, 5), new ExifTag(TAG_SUBJECT_DISTANCE, 37382, 5), new ExifTag(TAG_METERING_MODE, 37383, 3), new ExifTag(TAG_LIGHT_SOURCE, 37384, 3), new ExifTag(TAG_FLASH, 37385, 3), new ExifTag(TAG_FOCAL_LENGTH, 37386, 5), new ExifTag(TAG_SUBJECT_AREA, 37396, 3), new ExifTag(TAG_MAKER_NOTE, 37500, 7), new ExifTag(TAG_USER_COMMENT, 37510, 7), new ExifTag(TAG_SUBSEC_TIME, 37520, 2), new ExifTag(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new ExifTag(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new ExifTag(TAG_FLASHPIX_VERSION, 40960, 7), new ExifTag(TAG_COLOR_SPACE, 40961, 3), new ExifTag(TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new ExifTag(TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new ExifTag(TAG_RELATED_SOUND_FILE, 40964, 2), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_FLASH_ENERGY, 41483, 5), new ExifTag(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new ExifTag(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new ExifTag(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new ExifTag(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new ExifTag(TAG_SUBJECT_LOCATION, 41492, 3), new ExifTag(TAG_EXPOSURE_INDEX, 41493, 5), new ExifTag(TAG_SENSING_METHOD, 41495, 3), new ExifTag(TAG_FILE_SOURCE, 41728, 7), new ExifTag(TAG_SCENE_TYPE, 41729, 7), new ExifTag(TAG_CFA_PATTERN, 41730, 7), new ExifTag(TAG_CUSTOM_RENDERED, 41985, 3), new ExifTag(TAG_EXPOSURE_MODE, 41986, 3), new ExifTag(TAG_WHITE_BALANCE, 41987, 3), new ExifTag(TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new ExifTag(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new ExifTag(TAG_SCENE_CAPTURE_TYPE, 41990, 3), new ExifTag(TAG_GAIN_CONTROL, 41991, 3), new ExifTag(TAG_CONTRAST, 41992, 3), new ExifTag(TAG_SATURATION, 41993, 3), new ExifTag(TAG_SHARPNESS, 41994, 3), new ExifTag(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new ExifTag(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new ExifTag(TAG_IMAGE_UNIQUE_ID, 42016, 2), new ExifTag("CameraOwnerName", 42032, 2), new ExifTag(TAG_BODY_SERIAL_NUMBER, 42033, 2), new ExifTag(TAG_LENS_SPECIFICATION, 42034, 5), new ExifTag(TAG_LENS_MAKE, 42035, 2), new ExifTag(TAG_LENS_MODEL, 42036, 2), new ExifTag(TAG_GAMMA, 42240, 5), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_EXIF_TAGS = exifTagArr2;
        ExifTag[] exifTagArr3 = {new ExifTag(TAG_GPS_VERSION_ID, 0, 1), new ExifTag(TAG_GPS_LATITUDE_REF, 1, 2), new ExifTag(TAG_GPS_LATITUDE, 2, 5, 10), new ExifTag(TAG_GPS_LONGITUDE_REF, 3, 2), new ExifTag(TAG_GPS_LONGITUDE, 4, 5, 10), new ExifTag(TAG_GPS_ALTITUDE_REF, 5, 1), new ExifTag(TAG_GPS_ALTITUDE, 6, 5), new ExifTag(TAG_GPS_TIMESTAMP, 7, 5), new ExifTag(TAG_GPS_SATELLITES, 8, 2), new ExifTag(TAG_GPS_STATUS, 9, 2), new ExifTag(TAG_GPS_MEASURE_MODE, 10, 2), new ExifTag(TAG_GPS_DOP, 11, 5), new ExifTag(TAG_GPS_SPEED_REF, 12, 2), new ExifTag(TAG_GPS_SPEED, 13, 5), new ExifTag(TAG_GPS_TRACK_REF, 14, 2), new ExifTag(TAG_GPS_TRACK, 15, 5), new ExifTag(TAG_GPS_IMG_DIRECTION_REF, 16, 2), new ExifTag(TAG_GPS_IMG_DIRECTION, 17, 5), new ExifTag(TAG_GPS_MAP_DATUM, 18, 2), new ExifTag(TAG_GPS_DEST_LATITUDE_REF, 19, 2), new ExifTag(TAG_GPS_DEST_LATITUDE, 20, 5), new ExifTag(TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new ExifTag(TAG_GPS_DEST_LONGITUDE, 22, 5), new ExifTag(TAG_GPS_DEST_BEARING_REF, 23, 2), new ExifTag(TAG_GPS_DEST_BEARING, 24, 5), new ExifTag(TAG_GPS_DEST_DISTANCE_REF, 25, 2), new ExifTag(TAG_GPS_DEST_DISTANCE, 26, 5), new ExifTag(TAG_GPS_PROCESSING_METHOD, 27, 7), new ExifTag(TAG_GPS_AREA_INFORMATION, 28, 7), new ExifTag(TAG_GPS_DATESTAMP, 29, 2), new ExifTag(TAG_GPS_DIFFERENTIAL, 30, 3), new ExifTag(TAG_GPS_H_POSITIONING_ERROR, 31, 5)};
        IFD_GPS_TAGS = exifTagArr3;
        ExifTag[] exifTagArr4 = {new ExifTag(TAG_INTEROPERABILITY_INDEX, 1, 2)};
        IFD_INTEROPERABILITY_TAGS = exifTagArr4;
        ExifTag[] exifTagArr5 = {new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_LENGTH, 257, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, BZip2Constants.MAX_ALPHA_SIZE, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag(TAG_MODEL, 272, 2), new ExifTag(TAG_STRIP_OFFSETS, LZMA2Options.NICE_LEN_MAX, 3, 4), new ExifTag(TAG_THUMBNAIL_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, 306, 2), new ExifTag(TAG_ARTIST, 315, 2), new ExifTag(TAG_WHITE_POINT, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_XMP, 700, 1), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_THUMBNAIL_TAGS = exifTagArr5;
        ExifTag[] exifTagArr6 = {new ExifTag(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4)};
        ORF_MAKER_NOTE_TAGS = exifTagArr6;
        ExifTag[] exifTagArr7 = {new ExifTag(TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new ExifTag(TAG_ORF_PREVIEW_IMAGE_LENGTH, BZip2Constants.MAX_ALPHA_SIZE, 4)};
        ORF_CAMERA_SETTINGS_TAGS = exifTagArr7;
        ExifTag[] exifTagArr8 = {new ExifTag(TAG_ORF_ASPECT_FRAME, 4371, 3)};
        ORF_IMAGE_PROCESSING_TAGS = exifTagArr8;
        ExifTag[] exifTagArr9 = {new ExifTag(TAG_COLOR_SPACE, 55, 3)};
        PEF_TAGS = exifTagArr9;
        ExifTag[][] exifTagArr10 = {exifTagArr, exifTagArr2, exifTagArr3, exifTagArr4, exifTagArr5, exifTagArr, exifTagArr6, exifTagArr7, exifTagArr8, exifTagArr9};
        f35959e = exifTagArr10;
        sExifTagMapsForReading = new HashMap[exifTagArr10.length];
        sExifTagMapsForWriting = new HashMap[exifTagArr10.length];
        Charset forName = Charset.forName("US-ASCII");
        f35960f = forName;
        f35961g = "Exif\u0000\u0000".getBytes(forName);
        IDENTIFIER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        sFormatterPrimary = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(PerseusRetrofitBuilder.DATE_FORMAT_DATE_TIME, locale);
        sFormatterSecondary = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        int i11 = 0;
        while (true) {
            ExifTag[][] exifTagArr11 = f35959e;
            if (i11 < exifTagArr11.length) {
                sExifTagMapsForReading[i11] = new HashMap<>();
                sExifTagMapsForWriting[i11] = new HashMap<>();
                for (ExifTag exifTag : exifTagArr11[i11]) {
                    sExifTagMapsForReading[i11].put(Integer.valueOf(exifTag.number), exifTag);
                    sExifTagMapsForWriting[i11].put(exifTag.f35968name, exifTag);
                }
                i11++;
            } else {
                HashMap<Integer, Integer> hashMap = sExifPointerTagMap;
                ExifTag[] exifTagArr12 = EXIF_POINTER_TAGS;
                hashMap.put(Integer.valueOf(exifTagArr12[0].number), 5);
                hashMap.put(Integer.valueOf(exifTagArr12[1].number), 1);
                hashMap.put(Integer.valueOf(exifTagArr12[2].number), 2);
                hashMap.put(Integer.valueOf(exifTagArr12[3].number), 3);
                hashMap.put(Integer.valueOf(exifTagArr12[4].number), 7);
                hashMap.put(Integer.valueOf(exifTagArr12[5].number), 8);
                return;
            }
        }
    }

    public ExifInterface(@NonNull File file) throws IOException {
        ExifTag[][] exifTagArr = f35959e;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (file != null) {
            initForFilename(file.getAbsolutePath());
            return;
        }
        throw new NullPointerException("file cannot be null");
    }

    private void addDefaultValuesForCompatibility() {
        String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
        if (attribute != null && getAttribute(TAG_DATETIME) == null) {
            this.mAttributes[0].put(TAG_DATETIME, ExifAttribute.createString(attribute));
        }
        if (getAttribute(TAG_IMAGE_WIDTH) == null) {
            this.mAttributes[0].put(TAG_IMAGE_WIDTH, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute(TAG_IMAGE_LENGTH) == null) {
            this.mAttributes[0].put(TAG_IMAGE_LENGTH, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute(TAG_ORIENTATION) == null) {
            this.mAttributes[0].put(TAG_ORIENTATION, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute(TAG_LIGHT_SOURCE) == null) {
            this.mAttributes[1].put(TAG_LIGHT_SOURCE, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
    }

    private String convertDecimalDegree(double d11) {
        long j11 = (long) d11;
        double d12 = d11 - ((double) j11);
        long j12 = (long) (d12 * 60.0d);
        long round = Math.round((d12 - (((double) j12) / 60.0d)) * 3600.0d * 1.0E7d);
        return j11 + "/1," + j12 + "/1," + round + "/10000000";
    }

    private static double convertRationalLatLonToDouble(String str, String str2) {
        try {
            String[] split = str.split(",", -1);
            String[] split2 = split[0].split("/", -1);
            String[] split3 = split[1].split("/", -1);
            String[] split4 = split[2].split("/", -1);
            double parseDouble = (Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim())) + ((Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim())) / 60.0d) + ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d);
            if (!str2.equals(LATITUDE_SOUTH)) {
                if (!str2.equals(LONGITUDE_WEST)) {
                    if (!str2.equals("N")) {
                        if (!str2.equals(LONGITUDE_EAST)) {
                            throw new IllegalArgumentException();
                        }
                    }
                    return parseDouble;
                }
            }
            return -parseDouble;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    private void copyChunksUpToGivenChunkType(ByteOrderedDataInputStream byteOrderedDataInputStream, ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr, byte[] bArr2) throws IOException {
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (byteOrderedDataInputStream.read(bArr3) != 4) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                Charset charset = f35960f;
                sb2.append(new String(bArr, charset));
                if (bArr2 == null) {
                    str = "";
                } else {
                    str = " or " + new String(bArr2, charset);
                }
                sb2.append(str);
                throw new IOException(sb2.toString());
            }
            copyWebPChunk(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    private void copyWebPChunk(ByteOrderedDataInputStream byteOrderedDataInputStream, ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr) throws IOException {
        int readInt = byteOrderedDataInputStream.readInt();
        byteOrderedDataOutputStream.write(bArr);
        byteOrderedDataOutputStream.writeInt(readInt);
        if (readInt % 2 == 1) {
            readInt++;
        }
        ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream, readInt);
    }

    @Nullable
    private ExifAttribute getExifAttribute(@NonNull String str) {
        if (str != null) {
            if (TAG_ISO_SPEED_RATINGS.equals(str)) {
                str = TAG_PHOTOGRAPHIC_SENSITIVITY;
            }
            for (int i11 = 0; i11 < f35959e.length; i11++) {
                ExifAttribute exifAttribute = this.mAttributes[i11].get(str);
                if (exifAttribute != null) {
                    return exifAttribute;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:54|55|56) */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0131, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x013a, code lost:
        throw new java.lang.UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x013b, code lost:
        r1.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013e, code lost:
        throw r13;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x0133 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getHeifAttributes(final androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream r13) throws java.io.IOException {
        /*
            r12 = this;
            java.lang.String r0 = "yes"
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L_0x013f
            android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever
            r1.<init>()
            androidx.exifinterface.media.ExifInterface$1 r2 = new androidx.exifinterface.media.ExifInterface$1     // Catch:{ RuntimeException -> 0x0133 }
            r2.<init>(r13)     // Catch:{ RuntimeException -> 0x0133 }
            androidx.exifinterface.media.ExifInterfaceUtils.Api23Impl.a(r1, r2)     // Catch:{ RuntimeException -> 0x0133 }
            r2 = 33
            java.lang.String r2 = r1.extractMetadata(r2)     // Catch:{ RuntimeException -> 0x0133 }
            r3 = 34
            java.lang.String r3 = r1.extractMetadata(r3)     // Catch:{ RuntimeException -> 0x0133 }
            r4 = 26
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x0133 }
            r5 = 17
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x0133 }
            boolean r4 = r0.equals(r4)     // Catch:{ RuntimeException -> 0x0133 }
            if (r4 == 0) goto L_0x0047
            r0 = 29
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x0133 }
            r4 = 30
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x0133 }
            r5 = 31
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x0133 }
            goto L_0x0063
        L_0x0047:
            boolean r0 = r0.equals(r5)     // Catch:{ RuntimeException -> 0x0133 }
            if (r0 == 0) goto L_0x0060
            r0 = 18
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x0133 }
            r4 = 19
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x0133 }
            r5 = 24
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x0133 }
            goto L_0x0063
        L_0x0060:
            r0 = 0
            r4 = r0
            r5 = r4
        L_0x0063:
            r6 = 0
            if (r0 == 0) goto L_0x0079
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r7 = r12.mAttributes     // Catch:{ RuntimeException -> 0x0133 }
            r7 = r7[r6]     // Catch:{ RuntimeException -> 0x0133 }
            java.lang.String r8 = "ImageWidth"
            int r9 = java.lang.Integer.parseInt(r0)     // Catch:{ RuntimeException -> 0x0133 }
            java.nio.ByteOrder r10 = r12.mExifByteOrder     // Catch:{ RuntimeException -> 0x0133 }
            androidx.exifinterface.media.ExifInterface$ExifAttribute r9 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort((int) r9, (java.nio.ByteOrder) r10)     // Catch:{ RuntimeException -> 0x0133 }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x0133 }
        L_0x0079:
            if (r4 == 0) goto L_0x008e
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r7 = r12.mAttributes     // Catch:{ RuntimeException -> 0x0133 }
            r7 = r7[r6]     // Catch:{ RuntimeException -> 0x0133 }
            java.lang.String r8 = "ImageLength"
            int r9 = java.lang.Integer.parseInt(r4)     // Catch:{ RuntimeException -> 0x0133 }
            java.nio.ByteOrder r10 = r12.mExifByteOrder     // Catch:{ RuntimeException -> 0x0133 }
            androidx.exifinterface.media.ExifInterface$ExifAttribute r9 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort((int) r9, (java.nio.ByteOrder) r10)     // Catch:{ RuntimeException -> 0x0133 }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x0133 }
        L_0x008e:
            r7 = 6
            if (r5 == 0) goto L_0x00b8
            int r8 = java.lang.Integer.parseInt(r5)     // Catch:{ RuntimeException -> 0x0133 }
            r9 = 90
            if (r8 == r9) goto L_0x00a8
            r9 = 180(0xb4, float:2.52E-43)
            if (r8 == r9) goto L_0x00a6
            r9 = 270(0x10e, float:3.78E-43)
            if (r8 == r9) goto L_0x00a3
            r8 = 1
            goto L_0x00a9
        L_0x00a3:
            r8 = 8
            goto L_0x00a9
        L_0x00a6:
            r8 = 3
            goto L_0x00a9
        L_0x00a8:
            r8 = r7
        L_0x00a9:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r9 = r12.mAttributes     // Catch:{ RuntimeException -> 0x0133 }
            r9 = r9[r6]     // Catch:{ RuntimeException -> 0x0133 }
            java.lang.String r10 = "Orientation"
            java.nio.ByteOrder r11 = r12.mExifByteOrder     // Catch:{ RuntimeException -> 0x0133 }
            androidx.exifinterface.media.ExifInterface$ExifAttribute r8 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort((int) r8, (java.nio.ByteOrder) r11)     // Catch:{ RuntimeException -> 0x0133 }
            r9.put(r10, r8)     // Catch:{ RuntimeException -> 0x0133 }
        L_0x00b8:
            if (r2 == 0) goto L_0x010b
            if (r3 == 0) goto L_0x010b
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ RuntimeException -> 0x0133 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ RuntimeException -> 0x0133 }
            if (r3 <= r7) goto L_0x0103
            long r8 = (long) r2     // Catch:{ RuntimeException -> 0x0133 }
            r13.seek(r8)     // Catch:{ RuntimeException -> 0x0133 }
            byte[] r8 = new byte[r7]     // Catch:{ RuntimeException -> 0x0133 }
            int r9 = r13.read(r8)     // Catch:{ RuntimeException -> 0x0133 }
            if (r9 != r7) goto L_0x00fb
            int r2 = r2 + r7
            int r3 = r3 + -6
            byte[] r7 = f35961g     // Catch:{ RuntimeException -> 0x0133 }
            boolean r7 = java.util.Arrays.equals(r8, r7)     // Catch:{ RuntimeException -> 0x0133 }
            if (r7 == 0) goto L_0x00f3
            byte[] r7 = new byte[r3]     // Catch:{ RuntimeException -> 0x0133 }
            int r13 = r13.read(r7)     // Catch:{ RuntimeException -> 0x0133 }
            if (r13 != r3) goto L_0x00eb
            r12.mOffsetToExifData = r2     // Catch:{ RuntimeException -> 0x0133 }
            r12.readExifSegment(r7, r6)     // Catch:{ RuntimeException -> 0x0133 }
            goto L_0x010b
        L_0x00eb:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0133 }
            java.lang.String r0 = "Can't read exif"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x0133 }
            throw r13     // Catch:{ RuntimeException -> 0x0133 }
        L_0x00f3:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0133 }
            java.lang.String r0 = "Invalid identifier"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x0133 }
            throw r13     // Catch:{ RuntimeException -> 0x0133 }
        L_0x00fb:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0133 }
            java.lang.String r0 = "Can't read identifier"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x0133 }
            throw r13     // Catch:{ RuntimeException -> 0x0133 }
        L_0x0103:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0133 }
            java.lang.String r0 = "Invalid exif length"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x0133 }
            throw r13     // Catch:{ RuntimeException -> 0x0133 }
        L_0x010b:
            boolean r13 = DEBUG     // Catch:{ RuntimeException -> 0x0133 }
            if (r13 == 0) goto L_0x012d
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0133 }
            r13.<init>()     // Catch:{ RuntimeException -> 0x0133 }
            java.lang.String r2 = "Heif meta: "
            r13.append(r2)     // Catch:{ RuntimeException -> 0x0133 }
            r13.append(r0)     // Catch:{ RuntimeException -> 0x0133 }
            java.lang.String r0 = "x"
            r13.append(r0)     // Catch:{ RuntimeException -> 0x0133 }
            r13.append(r4)     // Catch:{ RuntimeException -> 0x0133 }
            java.lang.String r0 = ", rotation "
            r13.append(r0)     // Catch:{ RuntimeException -> 0x0133 }
            r13.append(r5)     // Catch:{ RuntimeException -> 0x0133 }
        L_0x012d:
            r1.release()
            return
        L_0x0131:
            r13 = move-exception
            goto L_0x013b
        L_0x0133:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x0131 }
            java.lang.String r0 = "Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported."
            r13.<init>(r0)     // Catch:{ all -> 0x0131 }
            throw r13     // Catch:{ all -> 0x0131 }
        L_0x013b:
            r1.release()
            throw r13
        L_0x013f:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException
            java.lang.String r0 = "Reading EXIF from HEIF files is supported from SDK 28 and above"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getHeifAttributes(androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0162 A[LOOP:0: B:8:0x002f->B:57:0x0162, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x016a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getJpegAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r20, int r21, int r22) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r22
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x0017
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getJpegAttributes starting with: "
            r3.append(r4)
            r3.append(r1)
        L_0x0017:
            java.nio.ByteOrder r3 = java.nio.ByteOrder.BIG_ENDIAN
            r1.setByteOrder(r3)
            byte r3 = r20.readByte()
            java.lang.String r4 = "Invalid marker: "
            r5 = -1
            if (r3 != r5) goto L_0x01b4
            byte r6 = r20.readByte()
            r7 = -40
            if (r6 != r7) goto L_0x0199
            r3 = 2
            r4 = r3
        L_0x002f:
            byte r6 = r20.readByte()
            if (r6 != r5) goto L_0x017c
            r6 = 1
            int r4 = r4 + r6
            byte r7 = r20.readByte()
            boolean r8 = DEBUG
            if (r8 == 0) goto L_0x0052
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Found JPEG segment indicator: "
            r9.append(r10)
            r10 = r7 & 255(0xff, float:3.57E-43)
            java.lang.String r10 = java.lang.Integer.toHexString(r10)
            r9.append(r10)
        L_0x0052:
            int r4 = r4 + r6
            r9 = -39
            if (r7 == r9) goto L_0x0176
            r9 = -38
            if (r7 != r9) goto L_0x005d
            goto L_0x0176
        L_0x005d:
            int r9 = r20.readUnsignedShort()
            int r9 = r9 - r3
            int r4 = r4 + r3
            if (r8 == 0) goto L_0x0087
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "JPEG segment: "
            r8.append(r10)
            r10 = r7 & 255(0xff, float:3.57E-43)
            java.lang.String r10 = java.lang.Integer.toHexString(r10)
            r8.append(r10)
            java.lang.String r10 = " (length: "
            r8.append(r10)
            int r10 = r9 + 2
            r8.append(r10)
            java.lang.String r10 = ")"
            r8.append(r10)
        L_0x0087:
            java.lang.String r8 = "Invalid length"
            if (r9 < 0) goto L_0x0170
            r10 = -31
            r11 = 0
            if (r7 == r10) goto L_0x0106
            r10 = -2
            if (r7 == r10) goto L_0x00db
            switch(r7) {
                case -64: goto L_0x00a1;
                case -63: goto L_0x00a1;
                case -62: goto L_0x00a1;
                case -61: goto L_0x00a1;
                default: goto L_0x0096;
            }
        L_0x0096:
            switch(r7) {
                case -59: goto L_0x00a1;
                case -58: goto L_0x00a1;
                case -57: goto L_0x00a1;
                default: goto L_0x0099;
            }
        L_0x0099:
            switch(r7) {
                case -55: goto L_0x00a1;
                case -54: goto L_0x00a1;
                case -53: goto L_0x00a1;
                default: goto L_0x009c;
            }
        L_0x009c:
            switch(r7) {
                case -51: goto L_0x00a1;
                case -50: goto L_0x00a1;
                case -49: goto L_0x00a1;
                default: goto L_0x009f;
            }
        L_0x009f:
            goto L_0x0160
        L_0x00a1:
            r1.skipFully(r6)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r6 = r0.mAttributes
            r6 = r6[r2]
            r7 = 4
            if (r2 == r7) goto L_0x00ae
            java.lang.String r10 = "ImageLength"
            goto L_0x00b0
        L_0x00ae:
            java.lang.String r10 = "ThumbnailImageLength"
        L_0x00b0:
            int r11 = r20.readUnsignedShort()
            long r11 = (long) r11
            java.nio.ByteOrder r13 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r11 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r11, (java.nio.ByteOrder) r13)
            r6.put(r10, r11)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r6 = r0.mAttributes
            r6 = r6[r2]
            if (r2 == r7) goto L_0x00c7
            java.lang.String r7 = "ImageWidth"
            goto L_0x00c9
        L_0x00c7:
            java.lang.String r7 = "ThumbnailImageWidth"
        L_0x00c9:
            int r10 = r20.readUnsignedShort()
            long r10 = (long) r10
            java.nio.ByteOrder r12 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r10 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r10, (java.nio.ByteOrder) r12)
            r6.put(r7, r10)
            int r9 = r9 + -5
            goto L_0x0160
        L_0x00db:
            byte[] r7 = new byte[r9]
            int r10 = r1.read(r7)
            if (r10 != r9) goto L_0x00fe
            java.lang.String r9 = "UserComment"
            java.lang.String r10 = r0.getAttribute(r9)
            if (r10 != 0) goto L_0x015f
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r10 = r0.mAttributes
            r6 = r10[r6]
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r12 = f35960f
            r10.<init>(r7, r12)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r7 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createString(r10)
            r6.put(r9, r7)
            goto L_0x015f
        L_0x00fe:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid exif"
            r1.<init>(r2)
            throw r1
        L_0x0106:
            byte[] r7 = new byte[r9]
            r1.readFully(r7)
            int r10 = r4 + r9
            byte[] r12 = f35961g
            boolean r13 = androidx.exifinterface.media.ExifInterfaceUtils.h(r7, r12)
            if (r13 == 0) goto L_0x012c
            int r6 = r12.length
            byte[] r6 = java.util.Arrays.copyOfRange(r7, r6, r9)
            int r4 = r21 + r4
            int r7 = r12.length
            int r4 = r4 + r7
            r0.mOffsetToExifData = r4
            r0.readExifSegment(r6, r2)
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r4 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream
            r4.<init>((byte[]) r6)
            r0.setThumbnailData(r4)
            goto L_0x015e
        L_0x012c:
            byte[] r12 = IDENTIFIER_XMP_APP1
            boolean r13 = androidx.exifinterface.media.ExifInterfaceUtils.h(r7, r12)
            if (r13 == 0) goto L_0x015e
            int r13 = r12.length
            int r4 = r4 + r13
            int r12 = r12.length
            byte[] r7 = java.util.Arrays.copyOfRange(r7, r12, r9)
            java.lang.String r9 = "Xmp"
            java.lang.String r12 = r0.getAttribute(r9)
            if (r12 != 0) goto L_0x015e
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r12 = r0.mAttributes
            r12 = r12[r11]
            androidx.exifinterface.media.ExifInterface$ExifAttribute r15 = new androidx.exifinterface.media.ExifInterface$ExifAttribute
            r14 = 1
            int r13 = r7.length
            long r3 = (long) r4
            r16 = r13
            r13 = r15
            r5 = r15
            r15 = r16
            r16 = r3
            r18 = r7
            r13.<init>(r14, r15, r16, r18)
            r12.put(r9, r5)
            r0.mXmpIsFromSeparateMarker = r6
        L_0x015e:
            r4 = r10
        L_0x015f:
            r9 = r11
        L_0x0160:
            if (r9 < 0) goto L_0x016a
            r1.skipFully(r9)
            int r4 = r4 + r9
            r3 = 2
            r5 = -1
            goto L_0x002f
        L_0x016a:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r8)
            throw r1
        L_0x0170:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r8)
            throw r1
        L_0x0176:
            java.nio.ByteOrder r2 = r0.mExifByteOrder
            r1.setByteOrder(r2)
            return
        L_0x017c:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid marker:"
            r2.append(r3)
            r3 = r6 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0199:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01b4:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getJpegAttributes(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int, int):void");
    }

    private int getMimeType(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (isJpegFormat(bArr)) {
            return 4;
        }
        if (isRafFormat(bArr)) {
            return 9;
        }
        if (isHeifFormat(bArr)) {
            return 12;
        }
        if (isOrfFormat(bArr)) {
            return 7;
        }
        if (isRw2Format(bArr)) {
            return 10;
        }
        if (isPngFormat(bArr)) {
            return 13;
        }
        if (isWebpFormat(bArr)) {
            return 14;
        }
        return 0;
    }

    private void getOrfAttributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        int i11;
        int i12;
        getRawAttributes(seekableByteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.mAttributes[1].get(TAG_MAKER_NOTE);
        if (exifAttribute != null) {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.bytes);
            seekableByteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            byte[] bArr = ORF_MAKER_NOTE_HEADER_1;
            byte[] bArr2 = new byte[bArr.length];
            seekableByteOrderedDataInputStream2.readFully(bArr2);
            seekableByteOrderedDataInputStream2.seek(0);
            byte[] bArr3 = ORF_MAKER_NOTE_HEADER_2;
            byte[] bArr4 = new byte[bArr3.length];
            seekableByteOrderedDataInputStream2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                seekableByteOrderedDataInputStream2.seek(8);
            } else if (Arrays.equals(bArr4, bArr3)) {
                seekableByteOrderedDataInputStream2.seek(12);
            }
            readImageFileDirectory(seekableByteOrderedDataInputStream2, 6);
            ExifAttribute exifAttribute2 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_START);
            ExifAttribute exifAttribute3 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
            if (!(exifAttribute2 == null || exifAttribute3 == null)) {
                this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT, exifAttribute2);
                this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, exifAttribute3);
            }
            ExifAttribute exifAttribute4 = this.mAttributes[8].get(TAG_ORF_ASPECT_FRAME);
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.a(this.mExifByteOrder);
                if (iArr == null || iArr.length != 4) {
                    Log.w(TAG, "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i13 = iArr[2];
                int i14 = iArr[0];
                if (i13 > i14 && (i11 = iArr[3]) > (i12 = iArr[1])) {
                    int i15 = (i13 - i14) + 1;
                    int i16 = (i11 - i12) + 1;
                    if (i15 < i16) {
                        int i17 = i15 + i16;
                        i16 = i17 - i16;
                        i15 = i17 - i16;
                    }
                    ExifAttribute createUShort = ExifAttribute.createUShort(i15, this.mExifByteOrder);
                    ExifAttribute createUShort2 = ExifAttribute.createUShort(i16, this.mExifByteOrder);
                    this.mAttributes[0].put(TAG_IMAGE_WIDTH, createUShort);
                    this.mAttributes[0].put(TAG_IMAGE_LENGTH, createUShort2);
                }
            }
        }
    }

    private void getPngAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getPngAttributes starting with: ");
            sb2.append(byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        byte[] bArr = PNG_SIGNATURE;
        byteOrderedDataInputStream.skipFully(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = byteOrderedDataInputStream.readInt();
                int i11 = length + 4;
                byte[] bArr2 = new byte[4];
                if (byteOrderedDataInputStream.read(bArr2) == 4) {
                    int i12 = i11 + 4;
                    if (i12 == 16) {
                        if (!Arrays.equals(bArr2, PNG_CHUNK_TYPE_IHDR)) {
                            throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                        }
                    }
                    if (!Arrays.equals(bArr2, PNG_CHUNK_TYPE_IEND)) {
                        if (Arrays.equals(bArr2, PNG_CHUNK_TYPE_EXIF)) {
                            byte[] bArr3 = new byte[readInt];
                            if (byteOrderedDataInputStream.read(bArr3) == readInt) {
                                int readInt2 = byteOrderedDataInputStream.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr2);
                                crc32.update(bArr3);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.mOffsetToExifData = i12;
                                    readExifSegment(bArr3, 0);
                                    validateImages();
                                    setThumbnailData(new ByteOrderedDataInputStream(bArr3));
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + ExifInterfaceUtils.a(bArr2));
                        }
                        int i13 = readInt + 4;
                        byteOrderedDataInputStream.skipFully(i13);
                        length = i12 + i13;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void getRafAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        boolean z11 = DEBUG;
        if (z11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getRafAttributes starting with: ");
            sb2.append(byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.skipFully(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        byteOrderedDataInputStream.read(bArr);
        byteOrderedDataInputStream.read(bArr2);
        byteOrderedDataInputStream.read(bArr3);
        int i11 = ByteBuffer.wrap(bArr).getInt();
        int i12 = ByteBuffer.wrap(bArr2).getInt();
        int i13 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i12];
        byteOrderedDataInputStream.skipFully(i11 - byteOrderedDataInputStream.position());
        byteOrderedDataInputStream.read(bArr4);
        getJpegAttributes(new ByteOrderedDataInputStream(bArr4), i11, 5);
        byteOrderedDataInputStream.skipFully(i13 - byteOrderedDataInputStream.position());
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        int readInt = byteOrderedDataInputStream.readInt();
        if (z11) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("numberOfDirectoryEntry: ");
            sb3.append(readInt);
        }
        for (int i14 = 0; i14 < readInt; i14++) {
            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                short readShort = byteOrderedDataInputStream.readShort();
                short readShort2 = byteOrderedDataInputStream.readShort();
                ExifAttribute createUShort = ExifAttribute.createUShort((int) readShort, this.mExifByteOrder);
                ExifAttribute createUShort2 = ExifAttribute.createUShort((int) readShort2, this.mExifByteOrder);
                this.mAttributes[0].put(TAG_IMAGE_LENGTH, createUShort);
                this.mAttributes[0].put(TAG_IMAGE_WIDTH, createUShort2);
                if (DEBUG) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Updated to length: ");
                    sb4.append(readShort);
                    sb4.append(", width: ");
                    sb4.append(readShort2);
                    return;
                }
                return;
            }
            byteOrderedDataInputStream.skipFully(readUnsignedShort2);
        }
    }

    private void getRawAttributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        ExifAttribute exifAttribute;
        parseTiffHeaders(seekableByteOrderedDataInputStream);
        readImageFileDirectory(seekableByteOrderedDataInputStream, 0);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 0);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 5);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 4);
        validateImages();
        if (this.mMimeType == 8 && (exifAttribute = this.mAttributes[1].get(TAG_MAKER_NOTE)) != null) {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.bytes);
            seekableByteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            seekableByteOrderedDataInputStream2.skipFully(6);
            readImageFileDirectory(seekableByteOrderedDataInputStream2, 9);
            ExifAttribute exifAttribute2 = this.mAttributes[9].get(TAG_COLOR_SPACE);
            if (exifAttribute2 != null) {
                this.mAttributes[1].put(TAG_COLOR_SPACE, exifAttribute2);
            }
        }
    }

    private void getRw2Attributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getRw2Attributes starting with: ");
            sb2.append(seekableByteOrderedDataInputStream);
        }
        getRawAttributes(seekableByteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.mAttributes[0].get(TAG_RW2_JPG_FROM_RAW);
        if (exifAttribute != null) {
            getJpegAttributes(new ByteOrderedDataInputStream(exifAttribute.bytes), (int) exifAttribute.bytesOffset, 5);
        }
        ExifAttribute exifAttribute2 = this.mAttributes[0].get(TAG_RW2_ISO);
        ExifAttribute exifAttribute3 = this.mAttributes[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (exifAttribute2 != null && exifAttribute3 == null) {
            this.mAttributes[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, exifAttribute2);
        }
    }

    private void getStandaloneAttributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        byte[] bArr = f35961g;
        seekableByteOrderedDataInputStream.skipFully(bArr.length);
        byte[] bArr2 = new byte[seekableByteOrderedDataInputStream.available()];
        seekableByteOrderedDataInputStream.readFully(bArr2);
        this.mOffsetToExifData = bArr.length;
        readExifSegment(bArr2, 0);
    }

    private void getWebpAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getWebpAttributes starting with: ");
            sb2.append(byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
        byteOrderedDataInputStream.skipFully(WEBP_SIGNATURE_1.length);
        int readInt = byteOrderedDataInputStream.readInt() + 8;
        byte[] bArr = WEBP_SIGNATURE_2;
        byteOrderedDataInputStream.skipFully(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (byteOrderedDataInputStream.read(bArr2) == 4) {
                    int readInt2 = byteOrderedDataInputStream.readInt();
                    int i11 = length + 4 + 4;
                    if (Arrays.equals(WEBP_CHUNK_TYPE_EXIF, bArr2)) {
                        byte[] bArr3 = new byte[readInt2];
                        if (byteOrderedDataInputStream.read(bArr3) == readInt2) {
                            this.mOffsetToExifData = i11;
                            readExifSegment(bArr3, 0);
                            setThumbnailData(new ByteOrderedDataInputStream(bArr3));
                            return;
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + ExifInterfaceUtils.a(bArr2));
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    length = i11 + readInt2;
                    if (length != readInt) {
                        if (length <= readInt) {
                            byteOrderedDataInputStream.skipFully(readInt2);
                        } else {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:68|69|70) */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        java.lang.Double.parseDouble(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015c, code lost:
        return new android.util.Pair<>(12, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0162, code lost:
        return new android.util.Pair<>(2, -1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x014e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<java.lang.Integer, java.lang.Integer> guessDataFormat(java.lang.String r12) {
        /*
            java.lang.String r0 = ","
            boolean r1 = r12.contains(r0)
            r2 = 0
            r3 = 1
            r4 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r6 = -1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            if (r1 == 0) goto L_0x00a6
            java.lang.String[] r12 = r12.split(r0, r6)
            r0 = r12[r2]
            android.util.Pair r0 = guessDataFormat(r0)
            java.lang.Object r1 = r0.first
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r1 != r4) goto L_0x0029
            return r0
        L_0x0029:
            int r1 = r12.length
            if (r3 >= r1) goto L_0x00a5
            r1 = r12[r3]
            android.util.Pair r1 = guessDataFormat(r1)
            java.lang.Object r2 = r1.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x004d
            java.lang.Object r2 = r1.second
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r2 = r6
            goto L_0x0055
        L_0x004d:
            java.lang.Object r2 = r0.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
        L_0x0055:
            java.lang.Object r4 = r0.second
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 == r6) goto L_0x0080
            java.lang.Object r4 = r1.first
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Object r8 = r0.second
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x0077
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r4 = r0.second
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0080
        L_0x0077:
            java.lang.Object r1 = r0.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L_0x0081
        L_0x0080:
            r1 = r6
        L_0x0081:
            if (r2 != r6) goto L_0x008b
            if (r1 != r6) goto L_0x008b
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        L_0x008b:
            if (r2 != r6) goto L_0x0097
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.<init>(r1, r7)
            goto L_0x00a2
        L_0x0097:
            if (r1 != r6) goto L_0x00a2
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r0.<init>(r1, r7)
        L_0x00a2:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x00a5:
            return r0
        L_0x00a6:
            java.lang.String r0 = "/"
            boolean r1 = r12.contains(r0)
            r8 = 0
            if (r1 == 0) goto L_0x0105
            java.lang.String[] r12 = r12.split(r0, r6)
            int r0 = r12.length
            if (r0 != r4) goto L_0x00ff
            r0 = r12[r2]     // Catch:{ NumberFormatException -> 0x00ff }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            long r0 = (long) r0     // Catch:{ NumberFormatException -> 0x00ff }
            r12 = r12[r3]     // Catch:{ NumberFormatException -> 0x00ff }
            double r2 = java.lang.Double.parseDouble(r12)     // Catch:{ NumberFormatException -> 0x00ff }
            long r2 = (long) r2     // Catch:{ NumberFormatException -> 0x00ff }
            int r12 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r4 = 10
            if (r12 < 0) goto L_0x00f5
            int r12 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r12 >= 0) goto L_0x00d0
            goto L_0x00f5
        L_0x00d0:
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r12 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r0 = 5
            if (r12 > 0) goto L_0x00eb
            int r12 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r12 <= 0) goto L_0x00dd
            goto L_0x00eb
        L_0x00dd:
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            r12.<init>(r1, r0)     // Catch:{ NumberFormatException -> 0x00ff }
            return r12
        L_0x00eb:
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r12
        L_0x00f5:
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r12
        L_0x00ff:
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        L_0x0105:
            long r0 = java.lang.Long.parseLong(r12)     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ NumberFormatException -> 0x014e }
            long r1 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            r2 = 4
            if (r1 < 0) goto L_0x0130
            long r3 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            r10 = 65535(0xffff, double:3.23786E-319)
            int r1 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r1 > 0) goto L_0x0130
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            r1 = 3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r2)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x0130:
            long r0 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0144
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            r1 = 9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x0144:
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x014e:
            java.lang.Double.parseDouble(r12)     // Catch:{ NumberFormatException -> 0x015d }
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x015d }
            r0 = 12
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x015d }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x015d }
            return r12
        L_0x015d:
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.guessDataFormat(java.lang.String):android.util.Pair");
    }

    private void handleThumbnailFromJfif(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (exifAttribute != null && exifAttribute2 != null) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
            if (this.mMimeType == 7) {
                intValue += this.mOrfMakerNoteOffset;
            }
            if (intValue > 0 && intValue2 > 0) {
                this.mHasThumbnail = true;
                if (this.mFilename == null && this.mAssetInputStream == null && this.mSeekableFileDescriptor == null) {
                    byte[] bArr = new byte[intValue2];
                    byteOrderedDataInputStream.skip((long) intValue);
                    byteOrderedDataInputStream.read(bArr);
                    this.mThumbnailBytes = bArr;
                }
                this.mThumbnailOffset = intValue;
                this.mThumbnailLength = intValue2;
            }
            if (DEBUG) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Setting thumbnail attributes with offset: ");
                sb2.append(intValue);
                sb2.append(", length: ");
                sb2.append(intValue2);
            }
        }
    }

    private void handleThumbnailFromStrips(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = byteOrderedDataInputStream;
        HashMap hashMap2 = hashMap;
        ExifAttribute exifAttribute = (ExifAttribute) hashMap2.get(TAG_STRIP_OFFSETS);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap2.get(TAG_STRIP_BYTE_COUNTS);
        if (exifAttribute != null && exifAttribute2 != null) {
            long[] d11 = ExifInterfaceUtils.d(exifAttribute.a(this.mExifByteOrder));
            long[] d12 = ExifInterfaceUtils.d(exifAttribute2.a(this.mExifByteOrder));
            if (d11 == null || d11.length == 0) {
                Log.w(TAG, "stripOffsets should not be null or have zero length.");
            } else if (d12 == null || d12.length == 0) {
                Log.w(TAG, "stripByteCounts should not be null or have zero length.");
            } else if (d11.length != d12.length) {
                Log.w(TAG, "stripOffsets and stripByteCounts should have same length.");
            } else {
                long j11 = 0;
                for (long j12 : d12) {
                    j11 += j12;
                }
                int i11 = (int) j11;
                byte[] bArr = new byte[i11];
                this.mAreThumbnailStripsConsecutive = true;
                this.mHasThumbnailStrips = true;
                this.mHasThumbnail = true;
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                while (i12 < d11.length) {
                    int i15 = (int) d11[i12];
                    int i16 = (int) d12[i12];
                    if (i12 < d11.length - 1 && ((long) (i15 + i16)) != d11[i12 + 1]) {
                        this.mAreThumbnailStripsConsecutive = false;
                    }
                    int i17 = i15 - i13;
                    if (i17 >= 0) {
                        long j13 = (long) i17;
                        if (byteOrderedDataInputStream2.skip(j13) != j13) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Failed to skip ");
                            sb2.append(i17);
                            sb2.append(" bytes.");
                            return;
                        }
                        int i18 = i13 + i17;
                        byte[] bArr2 = new byte[i16];
                        if (byteOrderedDataInputStream2.read(bArr2) != i16) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Failed to read ");
                            sb3.append(i16);
                            sb3.append(" bytes.");
                            return;
                        }
                        i13 = i18 + i16;
                        System.arraycopy(bArr2, 0, bArr, i14, i16);
                        i14 += i16;
                        i12++;
                    } else {
                        return;
                    }
                }
                this.mThumbnailBytes = bArr;
                if (this.mAreThumbnailStripsConsecutive) {
                    this.mThumbnailOffset = (int) d11[0];
                    this.mThumbnailLength = i11;
                }
            }
        }
    }

    private void initForFilename(String str) throws IOException {
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.mAssetInputStream = null;
            this.mFilename = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    if (isSeekableFD(fileInputStream2.getFD())) {
                        this.mSeekableFileDescriptor = fileInputStream2.getFD();
                    } else {
                        this.mSeekableFileDescriptor = null;
                    }
                    loadAttributes(fileInputStream2);
                    ExifInterfaceUtils.c(fileInputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    ExifInterfaceUtils.c(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                ExifInterfaceUtils.c(fileInputStream);
                throw th;
            }
        } else {
            throw new NullPointerException("filename cannot be null");
        }
    }

    private static boolean isExifDataOnly(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = f35961g;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i11 = 0;
        while (true) {
            byte[] bArr3 = f35961g;
            if (i11 >= bArr3.length) {
                return true;
            }
            if (bArr2[i11] != bArr3[i11]) {
                return false;
            }
            i11++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0090, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x008c */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isHeifFormat(byte[] r15) throws java.io.IOException {
        /*
            r14 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r2 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x008c }
            r2.<init>((byte[]) r15)     // Catch:{ Exception -> 0x008c }
            int r1 = r2.readInt()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r3 = (long) r1     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r1 = 4
            byte[] r5 = new byte[r1]     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r2.read(r5)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            byte[] r6 = HEIF_TYPE_FTYP     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r5 = java.util.Arrays.equals(r5, r6)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r5 != 0) goto L_0x001e
            r2.close()
            return r0
        L_0x001e:
            r5 = 1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r8 = 8
            if (r7 != 0) goto L_0x0034
            long r3 = r2.readLong()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r10 = 16
            int r7 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x0035
            r2.close()
            return r0
        L_0x0034:
            r10 = r8
        L_0x0035:
            int r7 = r15.length     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r12 = (long) r7     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            int r7 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r7 <= 0) goto L_0x003d
            int r15 = r15.length     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r3 = (long) r15
        L_0x003d:
            long r3 = r3 - r10
            int r15 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r15 >= 0) goto L_0x0046
            r2.close()
            return r0
        L_0x0046:
            byte[] r15 = new byte[r1]     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r7 = 0
            r9 = r0
            r10 = r9
        L_0x004c:
            r11 = 4
            long r11 = r3 / r11
            int r11 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x0081
            int r11 = r2.read(r15)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r11 == r1) goto L_0x005e
            r2.close()
            return r0
        L_0x005e:
            int r11 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r11 != 0) goto L_0x0063
            goto L_0x007f
        L_0x0063:
            byte[] r11 = HEIF_BRAND_MIF1     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r12 = 1
            if (r11 == 0) goto L_0x006e
            r9 = r12
            goto L_0x0077
        L_0x006e:
            byte[] r11 = HEIF_BRAND_HEIC     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r11 == 0) goto L_0x0077
            r10 = r12
        L_0x0077:
            if (r9 == 0) goto L_0x007f
            if (r10 == 0) goto L_0x007f
            r2.close()
            return r12
        L_0x007f:
            long r7 = r7 + r5
            goto L_0x004c
        L_0x0081:
            r2.close()
            goto L_0x0093
        L_0x0085:
            r15 = move-exception
            r1 = r2
            goto L_0x0094
        L_0x0088:
            r1 = r2
            goto L_0x008c
        L_0x008a:
            r15 = move-exception
            goto L_0x0094
        L_0x008c:
            boolean r15 = DEBUG     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x0093
            r1.close()
        L_0x0093:
            return r0
        L_0x0094:
            if (r1 == 0) goto L_0x0099
            r1.close()
        L_0x0099:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.isHeifFormat(byte[]):boolean");
    }

    private static boolean isJpegFormat(byte[] bArr) throws IOException {
        int i11 = 0;
        while (true) {
            byte[] bArr2 = f35955a;
            if (i11 >= bArr2.length) {
                return true;
            }
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
            i11++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isOrfFormat(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r2 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            java.nio.ByteOrder r4 = r3.readByteOrder(r2)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r3.mExifByteOrder = r4     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r2.setByteOrder(r4)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r1 = 20306(0x4f52, float:2.8455E-41)
            if (r4 == r1) goto L_0x001c
            r1 = 21330(0x5352, float:2.989E-41)
            if (r4 != r1) goto L_0x001d
        L_0x001c:
            r0 = 1
        L_0x001d:
            r2.close()
            return r0
        L_0x0021:
            r4 = move-exception
            r1 = r2
            goto L_0x0027
        L_0x0024:
            r1 = r2
            goto L_0x002d
        L_0x0026:
            r4 = move-exception
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()
        L_0x002c:
            throw r4
        L_0x002d:
            if (r1 == 0) goto L_0x0032
            r1.close()
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.isOrfFormat(byte[]):boolean");
    }

    private boolean isPngFormat(byte[] bArr) throws IOException {
        int i11 = 0;
        while (true) {
            byte[] bArr2 = PNG_SIGNATURE;
            if (i11 >= bArr2.length) {
                return true;
            }
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
            i11++;
        }
    }

    private boolean isRafFormat(byte[] bArr) throws IOException {
        byte[] bytes = RAF_SIGNATURE.getBytes(Charset.defaultCharset());
        for (int i11 = 0; i11 < bytes.length; i11++) {
            if (bArr[i11] != bytes[i11]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isRw2Format(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r2 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            java.nio.ByteOrder r4 = r3.readByteOrder(r2)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r3.mExifByteOrder = r4     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r2.setByteOrder(r4)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r1 = 85
            if (r4 != r1) goto L_0x0019
            r0 = 1
        L_0x0019:
            r2.close()
            return r0
        L_0x001d:
            r4 = move-exception
            r1 = r2
            goto L_0x0023
        L_0x0020:
            r1 = r2
            goto L_0x0029
        L_0x0022:
            r4 = move-exception
        L_0x0023:
            if (r1 == 0) goto L_0x0028
            r1.close()
        L_0x0028:
            throw r4
        L_0x0029:
            if (r1 == 0) goto L_0x002e
            r1.close()
        L_0x002e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.isRw2Format(byte[]):boolean");
    }

    private static boolean isSeekableFD(FileDescriptor fileDescriptor) {
        try {
            ExifInterfaceUtils.Api21Impl.c(fileDescriptor, 0, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isSupportedDataType(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_BITS_PER_SAMPLE);
        if (exifAttribute2 == null) {
            return false;
        }
        int[] iArr = (int[]) exifAttribute2.a(this.mExifByteOrder);
        int[] iArr2 = BITS_PER_SAMPLE_RGB;
        if (Arrays.equals(iArr2, iArr)) {
            return true;
        }
        if (this.mMimeType != 3 || (exifAttribute = (ExifAttribute) hashMap.get(TAG_PHOTOMETRIC_INTERPRETATION)) == null) {
            return false;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        if ((intValue != 1 || !Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) && (intValue != 6 || !Arrays.equals(iArr, iArr2))) {
            return false;
        }
        return true;
    }

    private static boolean isSupportedFormatForSavingAttributes(int i11) {
        return i11 == 4 || i11 == 13 || i11 == 14 || i11 == 3 || i11 == 0;
    }

    public static boolean isSupportedMimeType(@NonNull String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.hashCode();
            char c11 = 65535;
            switch (lowerCase.hashCode()) {
                case -1875291391:
                    if (lowerCase.equals("image/x-fuji-raf")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1635437028:
                    if (lowerCase.equals("image/x-samsung-srw")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1594371159:
                    if (lowerCase.equals("image/x-sony-arw")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -1487464693:
                    if (lowerCase.equals("image/heic")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -1487464690:
                    if (lowerCase.equals("image/heif")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -1487394660:
                    if (lowerCase.equals(MimeTypes.IMAGE_JPEG)) {
                        c11 = 5;
                        break;
                    }
                    break;
                case -1487018032:
                    if (lowerCase.equals("image/webp")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case -1423313290:
                    if (lowerCase.equals("image/x-adobe-dng")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case -985160897:
                    if (lowerCase.equals("image/x-panasonic-rw2")) {
                        c11 = 8;
                        break;
                    }
                    break;
                case -879258763:
                    if (lowerCase.equals("image/png")) {
                        c11 = 9;
                        break;
                    }
                    break;
                case -332763809:
                    if (lowerCase.equals("image/x-pentax-pef")) {
                        c11 = 10;
                        break;
                    }
                    break;
                case 1378106698:
                    if (lowerCase.equals("image/x-olympus-orf")) {
                        c11 = 11;
                        break;
                    }
                    break;
                case 2099152104:
                    if (lowerCase.equals("image/x-nikon-nef")) {
                        c11 = 12;
                        break;
                    }
                    break;
                case 2099152524:
                    if (lowerCase.equals("image/x-nikon-nrw")) {
                        c11 = CharUtils.CR;
                        break;
                    }
                    break;
                case 2111234748:
                    if (lowerCase.equals("image/x-canon-cr2")) {
                        c11 = 14;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                    return true;
                default:
                    return false;
            }
        } else {
            throw new NullPointerException("mimeType shouldn't be null");
        }
    }

    private boolean isThumbnail(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_IMAGE_WIDTH);
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
        if (intValue > 512 || intValue2 > 512) {
            return false;
        }
        return true;
    }

    private boolean isWebpFormat(byte[] bArr) throws IOException {
        int i11 = 0;
        while (true) {
            byte[] bArr2 = WEBP_SIGNATURE_1;
            if (i11 >= bArr2.length) {
                int i12 = 0;
                while (true) {
                    byte[] bArr3 = WEBP_SIGNATURE_2;
                    if (i12 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[WEBP_SIGNATURE_1.length + i12 + 4] != bArr3[i12]) {
                        return false;
                    }
                    i12++;
                }
            } else if (bArr[i11] != bArr2[i11]) {
                return false;
            } else {
                i11++;
            }
        }
    }

    private void loadAttributes(@NonNull InputStream inputStream) {
        if (inputStream != null) {
            int i11 = 0;
            while (i11 < f35959e.length) {
                try {
                    this.mAttributes[i11] = new HashMap<>();
                    i11++;
                } catch (IOException | UnsupportedOperationException e11) {
                    boolean z11 = DEBUG;
                    if (z11) {
                        Log.w(TAG, "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e11);
                    }
                    addDefaultValuesForCompatibility();
                    if (!z11) {
                        return;
                    }
                } catch (Throwable th2) {
                    addDefaultValuesForCompatibility();
                    if (DEBUG) {
                        printAttributes();
                    }
                    throw th2;
                }
            }
            if (!this.mIsExifDataOnly) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                this.mMimeType = getMimeType(bufferedInputStream);
                inputStream = bufferedInputStream;
            }
            if (shouldSupportSeek(this.mMimeType)) {
                SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(inputStream);
                if (this.mIsExifDataOnly) {
                    getStandaloneAttributes(seekableByteOrderedDataInputStream);
                } else {
                    int i12 = this.mMimeType;
                    if (i12 == 12) {
                        getHeifAttributes(seekableByteOrderedDataInputStream);
                    } else if (i12 == 7) {
                        getOrfAttributes(seekableByteOrderedDataInputStream);
                    } else if (i12 == 10) {
                        getRw2Attributes(seekableByteOrderedDataInputStream);
                    } else {
                        getRawAttributes(seekableByteOrderedDataInputStream);
                    }
                }
                seekableByteOrderedDataInputStream.seek((long) this.mOffsetToExifData);
                setThumbnailData(seekableByteOrderedDataInputStream);
            } else {
                ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
                int i13 = this.mMimeType;
                if (i13 == 4) {
                    getJpegAttributes(byteOrderedDataInputStream, 0, 0);
                } else if (i13 == 13) {
                    getPngAttributes(byteOrderedDataInputStream);
                } else if (i13 == 9) {
                    getRafAttributes(byteOrderedDataInputStream);
                } else if (i13 == 14) {
                    getWebpAttributes(byteOrderedDataInputStream);
                }
            }
            addDefaultValuesForCompatibility();
            if (!DEBUG) {
                return;
            }
            printAttributes();
            return;
        }
        throw new NullPointerException("inputstream shouldn't be null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        if (com.talabat.sidemenu.SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE.equals(r1) != false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Long parseDateTime(@androidx.annotation.Nullable java.lang.String r10, @androidx.annotation.Nullable java.lang.String r11, @androidx.annotation.Nullable java.lang.String r12) {
        /*
            r0 = 0
            if (r10 == 0) goto L_0x0084
            java.util.regex.Pattern r1 = NON_ZERO_TIME_PATTERN
            java.util.regex.Matcher r1 = r1.matcher(r10)
            boolean r1 = r1.matches()
            if (r1 != 0) goto L_0x0011
            goto L_0x0084
        L_0x0011:
            java.text.ParsePosition r1 = new java.text.ParsePosition
            r2 = 0
            r1.<init>(r2)
            java.text.SimpleDateFormat r3 = sFormatterPrimary     // Catch:{ IllegalArgumentException -> 0x0084 }
            java.util.Date r3 = r3.parse(r10, r1)     // Catch:{ IllegalArgumentException -> 0x0084 }
            if (r3 != 0) goto L_0x0028
            java.text.SimpleDateFormat r3 = sFormatterSecondary     // Catch:{ IllegalArgumentException -> 0x0084 }
            java.util.Date r3 = r3.parse(r10, r1)     // Catch:{ IllegalArgumentException -> 0x0084 }
            if (r3 != 0) goto L_0x0028
            return r0
        L_0x0028:
            long r3 = r3.getTime()     // Catch:{ IllegalArgumentException -> 0x0084 }
            if (r12 == 0) goto L_0x0078
            r10 = 1
            java.lang.String r1 = r12.substring(r2, r10)     // Catch:{ IllegalArgumentException -> 0x0084 }
            r2 = 3
            java.lang.String r5 = r12.substring(r10, r2)     // Catch:{ IllegalArgumentException -> 0x0084 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ IllegalArgumentException -> 0x0084 }
            r6 = 6
            r7 = 4
            java.lang.String r6 = r12.substring(r7, r6)     // Catch:{ IllegalArgumentException -> 0x0084 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ IllegalArgumentException -> 0x0084 }
            java.lang.String r8 = "+"
            boolean r8 = r8.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0084 }
            java.lang.String r9 = "-"
            if (r8 != 0) goto L_0x0056
            boolean r8 = r9.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0084 }
            if (r8 == 0) goto L_0x0078
        L_0x0056:
            java.lang.String r8 = ":"
            java.lang.String r12 = r12.substring(r2, r7)     // Catch:{ IllegalArgumentException -> 0x0084 }
            boolean r12 = r8.equals(r12)     // Catch:{ IllegalArgumentException -> 0x0084 }
            if (r12 == 0) goto L_0x0078
            r12 = 14
            if (r5 > r12) goto L_0x0078
            int r5 = r5 * 60
            int r5 = r5 + r6
            int r5 = r5 * 60
            int r5 = r5 * 1000
            boolean r12 = r9.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0084 }
            if (r12 == 0) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r10 = -1
        L_0x0075:
            int r5 = r5 * r10
            long r1 = (long) r5     // Catch:{ IllegalArgumentException -> 0x0084 }
            long r3 = r3 + r1
        L_0x0078:
            if (r11 == 0) goto L_0x007f
            long r10 = androidx.exifinterface.media.ExifInterfaceUtils.g(r11)     // Catch:{ IllegalArgumentException -> 0x0084 }
            long r3 = r3 + r10
        L_0x007f:
            java.lang.Long r10 = java.lang.Long.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x0084 }
            return r10
        L_0x0084:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.parseDateTime(java.lang.String, java.lang.String, java.lang.String):java.lang.Long");
    }

    private void parseTiffHeaders(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = readByteOrder;
        byteOrderedDataInputStream.setByteOrder(readByteOrder);
        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i11 = this.mMimeType;
        if (i11 == 7 || i11 == 10 || readUnsignedShort == 42) {
            int readInt = byteOrderedDataInputStream.readInt();
            if (readInt >= 8) {
                int i12 = readInt - 8;
                if (i12 > 0) {
                    byteOrderedDataInputStream.skipFully(i12);
                    return;
                }
                return;
            }
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    private void printAttributes() {
        for (int i11 = 0; i11 < this.mAttributes.length; i11++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The size of tag group[");
            sb2.append(i11);
            sb2.append("]: ");
            sb2.append(this.mAttributes[i11].size());
            for (Map.Entry next : this.mAttributes[i11].entrySet()) {
                ExifAttribute exifAttribute = (ExifAttribute) next.getValue();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("tagName: ");
                sb3.append((String) next.getKey());
                sb3.append(", tagType: ");
                sb3.append(exifAttribute.toString());
                sb3.append(", tagValue: '");
                sb3.append(exifAttribute.getStringValue(this.mExifByteOrder));
                sb3.append("'");
            }
        }
    }

    private ByteOrder readByteOrder(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short readShort = byteOrderedDataInputStream.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    private void readExifSegment(byte[] bArr, int i11) throws IOException {
        SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(bArr);
        parseTiffHeaders(seekableByteOrderedDataInputStream);
        readImageFileDirectory(seekableByteOrderedDataInputStream, i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0242  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readImageFileDirectory(androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream r26, int r27) throws java.io.IOException {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            java.util.Set<java.lang.Integer> r3 = r0.mAttributesOffsets
            int r4 = r1.f35966c
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            short r3 = r26.readShort()
            boolean r4 = DEBUG
            if (r4 == 0) goto L_0x0026
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "numberOfDirectoryEntry: "
            r4.append(r5)
            r4.append(r3)
        L_0x0026:
            if (r3 > 0) goto L_0x0029
            return
        L_0x0029:
            r4 = 0
            r5 = r4
        L_0x002b:
            r6 = 5
            r9 = 1
            if (r5 >= r3) goto L_0x02da
            int r11 = r26.readUnsignedShort()
            int r12 = r26.readUnsignedShort()
            int r15 = r26.readInt()
            int r13 = r26.position()
            long r13 = (long) r13
            r16 = 4
            long r13 = r13 + r16
            java.util.HashMap<java.lang.Integer, androidx.exifinterface.media.ExifInterface$ExifTag>[] r18 = sExifTagMapsForReading
            r7 = r18[r2]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r11)
            java.lang.Object r7 = r7.get(r8)
            androidx.exifinterface.media.ExifInterface$ExifTag r7 = (androidx.exifinterface.media.ExifInterface.ExifTag) r7
            boolean r8 = DEBUG
            r10 = 3
            if (r8 == 0) goto L_0x0082
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Integer r20 = java.lang.Integer.valueOf(r27)
            r6[r4] = r20
            java.lang.Integer r20 = java.lang.Integer.valueOf(r11)
            r6[r9] = r20
            if (r7 == 0) goto L_0x006a
            java.lang.String r9 = r7.f35968name
            goto L_0x006b
        L_0x006a:
            r9 = 0
        L_0x006b:
            r19 = 2
            r6[r19] = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)
            r6[r10] = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r15)
            r18 = 4
            r6[r18] = r9
            java.lang.String r9 = "ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d"
            java.lang.String.format(r9, r6)
        L_0x0082:
            r6 = 7
            if (r7 != 0) goto L_0x0099
            if (r8 == 0) goto L_0x0094
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r4 = "Skip the tag entry since tag number is not defined: "
            r9.append(r4)
            r9.append(r11)
        L_0x0094:
            r21 = r7
            r9 = r11
            goto L_0x0104
        L_0x0099:
            if (r12 <= 0) goto L_0x00f2
            int[] r4 = f35957c
            int r9 = r4.length
            if (r12 < r9) goto L_0x00a1
            goto L_0x00f2
        L_0x00a1:
            boolean r9 = r7.a(r12)
            if (r9 != 0) goto L_0x00c5
            if (r8 == 0) goto L_0x0094
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r9 = "Skip the tag entry since data format ("
            r4.append(r9)
            java.lang.String[] r9 = f35956b
            r9 = r9[r12]
            r4.append(r9)
            java.lang.String r9 = ") is unexpected for tag: "
            r4.append(r9)
            java.lang.String r9 = r7.f35968name
            r4.append(r9)
            goto L_0x0094
        L_0x00c5:
            if (r12 != r6) goto L_0x00c9
            int r12 = r7.primaryFormat
        L_0x00c9:
            r9 = r11
            long r10 = (long) r15
            r4 = r4[r12]
            r21 = r7
            long r6 = (long) r4
            long r6 = r6 * r10
            r10 = 0
            int r4 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r4 < 0) goto L_0x00e1
            r10 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r4 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r4 <= 0) goto L_0x00df
            goto L_0x00e1
        L_0x00df:
            r4 = 1
            goto L_0x0107
        L_0x00e1:
            if (r8 == 0) goto L_0x00f0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r10 = "Skip the tag entry since the number of components is invalid: "
            r4.append(r10)
            r4.append(r15)
        L_0x00f0:
            r4 = 0
            goto L_0x0107
        L_0x00f2:
            r21 = r7
            r9 = r11
            if (r8 == 0) goto L_0x0104
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Skip the tag entry since data format is invalid: "
            r4.append(r6)
            r4.append(r12)
        L_0x0104:
            r4 = 0
            r6 = 0
        L_0x0107:
            if (r4 != 0) goto L_0x0112
            r1.seek(r13)
            r22 = r3
            r21 = r5
            goto L_0x02d0
        L_0x0112:
            int r4 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            java.lang.String r10 = "Compression"
            if (r4 <= 0) goto L_0x019b
            int r4 = r26.readInt()
            if (r8 == 0) goto L_0x012e
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r22 = r3
            java.lang.String r3 = "seek to data offset: "
            r11.append(r3)
            r11.append(r4)
            goto L_0x0130
        L_0x012e:
            r22 = r3
        L_0x0130:
            int r3 = r0.mMimeType
            r11 = 7
            if (r3 != r11) goto L_0x0190
            r3 = r21
            java.lang.String r11 = r3.f35968name
            r21 = r5
            java.lang.String r5 = "MakerNote"
            boolean r5 = r5.equals(r11)
            if (r5 == 0) goto L_0x0146
            r0.mOrfMakerNoteOffset = r4
            goto L_0x018d
        L_0x0146:
            r5 = 6
            if (r2 != r5) goto L_0x018d
            java.lang.String r11 = "ThumbnailImage"
            java.lang.String r5 = r3.f35968name
            boolean r5 = r11.equals(r5)
            if (r5 == 0) goto L_0x018d
            r0.mOrfThumbnailOffset = r4
            r0.mOrfThumbnailLength = r15
            java.nio.ByteOrder r5 = r0.mExifByteOrder
            r11 = 6
            androidx.exifinterface.media.ExifInterface$ExifAttribute r5 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort((int) r11, (java.nio.ByteOrder) r5)
            int r11 = r0.mOrfThumbnailOffset
            r16 = r13
            long r13 = (long) r11
            java.nio.ByteOrder r11 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r11 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r13, (java.nio.ByteOrder) r11)
            int r13 = r0.mOrfThumbnailLength
            long r13 = (long) r13
            java.nio.ByteOrder r2 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r2 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r13, (java.nio.ByteOrder) r2)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r13 = r0.mAttributes
            r14 = 4
            r13 = r13[r14]
            r13.put(r10, r5)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r5 = r0.mAttributes
            r5 = r5[r14]
            java.lang.String r13 = "JPEGInterchangeFormat"
            r5.put(r13, r11)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r5 = r0.mAttributes
            r5 = r5[r14]
            java.lang.String r11 = "JPEGInterchangeFormatLength"
            r5.put(r11, r2)
            goto L_0x0196
        L_0x018d:
            r16 = r13
            goto L_0x0196
        L_0x0190:
            r16 = r13
            r3 = r21
            r21 = r5
        L_0x0196:
            long r4 = (long) r4
            r1.seek(r4)
            goto L_0x01a3
        L_0x019b:
            r22 = r3
            r16 = r13
            r3 = r21
            r21 = r5
        L_0x01a3:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r2 = sExifPointerTagMap
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)
            java.lang.Object r2 = r2.get(r4)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r8 == 0) goto L_0x01c6
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "nextIfdType: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r5 = " byteCount: "
            r4.append(r5)
            r4.append(r6)
        L_0x01c6:
            r4 = 8
            if (r2 == 0) goto L_0x0258
            r5 = 3
            if (r12 == r5) goto L_0x01ec
            r5 = 4
            if (r12 == r5) goto L_0x01e7
            if (r12 == r4) goto L_0x01e2
            r4 = 9
            if (r12 == r4) goto L_0x01dd
            r4 = 13
            if (r12 == r4) goto L_0x01dd
            r4 = -1
            goto L_0x01f1
        L_0x01dd:
            int r4 = r26.readInt()
            goto L_0x01f0
        L_0x01e2:
            short r4 = r26.readShort()
            goto L_0x01f0
        L_0x01e7:
            long r4 = r26.readUnsignedInt()
            goto L_0x01f1
        L_0x01ec:
            int r4 = r26.readUnsignedShort()
        L_0x01f0:
            long r4 = (long) r4
        L_0x01f1:
            if (r8 == 0) goto L_0x0207
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Long r7 = java.lang.Long.valueOf(r4)
            r9 = 0
            r6[r9] = r7
            java.lang.String r3 = r3.f35968name
            r7 = 1
            r6[r7] = r3
            java.lang.String r3 = "Offset: %d, tagName: %s"
            java.lang.String.format(r3, r6)
        L_0x0207:
            r6 = 0
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x0242
            java.util.Set<java.lang.Integer> r3 = r0.mAttributesOffsets
            int r6 = (int) r4
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            boolean r3 = r3.contains(r6)
            if (r3 != 0) goto L_0x0225
            r1.seek(r4)
            int r2 = r2.intValue()
            r0.readImageFileDirectory(r1, r2)
            goto L_0x0251
        L_0x0225:
            if (r8 == 0) goto L_0x0251
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "Skip jump into the IFD since it has already been read: IfdType "
            r3.append(r6)
            r3.append(r2)
            java.lang.String r2 = " (at "
            r3.append(r2)
            r3.append(r4)
            java.lang.String r2 = ")"
            r3.append(r2)
            goto L_0x0251
        L_0x0242:
            if (r8 == 0) goto L_0x0251
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Skip jump into the IFD since its offset is invalid: "
            r2.append(r3)
            r2.append(r4)
        L_0x0251:
            r13 = r16
            r1.seek(r13)
            goto L_0x02d0
        L_0x0258:
            r13 = r16
            int r2 = r26.position()
            int r5 = r0.mOffsetToExifData
            int r2 = r2 + r5
            int r5 = (int) r6
            byte[] r5 = new byte[r5]
            r1.readFully(r5)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r6 = new androidx.exifinterface.media.ExifInterface$ExifAttribute
            long r7 = (long) r2
            r23 = r13
            r13 = r6
            r14 = r12
            r16 = r7
            r18 = r5
            r13.<init>(r14, r15, r16, r18)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r2 = r2[r27]
            java.lang.String r5 = r3.f35968name
            r2.put(r5, r6)
            java.lang.String r2 = "DNGVersion"
            java.lang.String r5 = r3.f35968name
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x028b
            r2 = 3
            r0.mMimeType = r2
        L_0x028b:
            java.lang.String r2 = "Make"
            java.lang.String r5 = r3.f35968name
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x029f
            java.lang.String r2 = "Model"
            java.lang.String r5 = r3.f35968name
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x02ad
        L_0x029f:
            java.nio.ByteOrder r2 = r0.mExifByteOrder
            java.lang.String r2 = r6.getStringValue(r2)
            java.lang.String r5 = "PENTAX"
            boolean r2 = r2.contains(r5)
            if (r2 != 0) goto L_0x02c0
        L_0x02ad:
            java.lang.String r2 = r3.f35968name
            boolean r2 = r10.equals(r2)
            if (r2 == 0) goto L_0x02c2
            java.nio.ByteOrder r2 = r0.mExifByteOrder
            int r2 = r6.getIntValue(r2)
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r2 != r3) goto L_0x02c2
        L_0x02c0:
            r0.mMimeType = r4
        L_0x02c2:
            int r2 = r26.position()
            long r2 = (long) r2
            r13 = r23
            int r2 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r2 == 0) goto L_0x02d0
            r1.seek(r13)
        L_0x02d0:
            int r5 = r21 + 1
            short r5 = (short) r5
            r2 = r27
            r3 = r22
            r4 = 0
            goto L_0x002b
        L_0x02da:
            int r2 = r26.readInt()
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x02f1
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            r7 = 0
            r4[r7] = r5
            java.lang.String r5 = "nextIfdOffset: %d"
            java.lang.String.format(r5, r4)
        L_0x02f1:
            long r4 = (long) r2
            r7 = 0
            int r7 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x0334
            java.util.Set<java.lang.Integer> r7 = r0.mAttributesOffsets
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)
            boolean r7 = r7.contains(r8)
            if (r7 != 0) goto L_0x0324
            r1.seek(r4)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r3 = 4
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0316
            r0.readImageFileDirectory(r1, r3)
            goto L_0x0343
        L_0x0316:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r2 = r2[r6]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0343
            r0.readImageFileDirectory(r1, r6)
            goto L_0x0343
        L_0x0324:
            if (r3 == 0) goto L_0x0343
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since re-reading an IFD may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            goto L_0x0343
        L_0x0334:
            if (r3 == 0) goto L_0x0343
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since a wrong offset may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
        L_0x0343:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.readImageFileDirectory(androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream, int):void");
    }

    private void removeAttribute(String str) {
        for (int i11 = 0; i11 < f35959e.length; i11++) {
            this.mAttributes[i11].remove(str);
        }
    }

    private void replaceInvalidTags(int i11, String str, String str2) {
        if (!this.mAttributes[i11].isEmpty() && this.mAttributes[i11].get(str) != null) {
            HashMap<String, ExifAttribute> hashMap = this.mAttributes[i11];
            hashMap.put(str2, hashMap.get(str));
            this.mAttributes[i11].remove(str);
        }
    }

    private void retrieveJpegImageSize(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i11) throws IOException {
        ExifAttribute exifAttribute = this.mAttributes[i11].get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute2 = this.mAttributes[i11].get(TAG_IMAGE_WIDTH);
        if (exifAttribute == null || exifAttribute2 == null) {
            ExifAttribute exifAttribute3 = this.mAttributes[i11].get(TAG_JPEG_INTERCHANGE_FORMAT);
            ExifAttribute exifAttribute4 = this.mAttributes[i11].get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
            if (exifAttribute3 != null && exifAttribute4 != null) {
                int intValue = exifAttribute3.getIntValue(this.mExifByteOrder);
                int intValue2 = exifAttribute3.getIntValue(this.mExifByteOrder);
                seekableByteOrderedDataInputStream.seek((long) intValue);
                byte[] bArr = new byte[intValue2];
                seekableByteOrderedDataInputStream.read(bArr);
                getJpegAttributes(new ByteOrderedDataInputStream(bArr), intValue, i11);
            }
        }
    }

    private void saveJpegAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        ExifAttribute exifAttribute;
        if (DEBUG) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("saveJpegAttributes starting with (inputStream: ");
            sb2.append(inputStream);
            sb2.append(", outputStream: ");
            sb2.append(outputStream);
            sb2.append(")");
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, ByteOrder.BIG_ENDIAN);
        if (byteOrderedDataInputStream.readByte() == -1) {
            byteOrderedDataOutputStream.writeByte(-1);
            if (byteOrderedDataInputStream.readByte() == -40) {
                byteOrderedDataOutputStream.writeByte(-40);
                if (getAttribute(TAG_XMP) == null || !this.mXmpIsFromSeparateMarker) {
                    exifAttribute = null;
                } else {
                    exifAttribute = this.mAttributes[0].remove(TAG_XMP);
                }
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(-31);
                writeExifSegment(byteOrderedDataOutputStream);
                if (exifAttribute != null) {
                    this.mAttributes[0].put(TAG_XMP, exifAttribute);
                }
                byte[] bArr = new byte[4096];
                while (byteOrderedDataInputStream.readByte() == -1) {
                    byte readByte = byteOrderedDataInputStream.readByte();
                    if (readByte == -39 || readByte == -38) {
                        byteOrderedDataOutputStream.writeByte(-1);
                        byteOrderedDataOutputStream.writeByte(readByte);
                        ExifInterfaceUtils.e(byteOrderedDataInputStream, byteOrderedDataOutputStream);
                        return;
                    } else if (readByte != -31) {
                        byteOrderedDataOutputStream.writeByte(-1);
                        byteOrderedDataOutputStream.writeByte(readByte);
                        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                        byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort);
                        int i11 = readUnsignedShort - 2;
                        if (i11 >= 0) {
                            while (i11 > 0) {
                                int read = byteOrderedDataInputStream.read(bArr, 0, Math.min(i11, 4096));
                                if (read < 0) {
                                    break;
                                }
                                byteOrderedDataOutputStream.write(bArr, 0, read);
                                i11 -= read;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    } else {
                        int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort() - 2;
                        if (readUnsignedShort2 >= 0) {
                            byte[] bArr2 = new byte[6];
                            if (readUnsignedShort2 >= 6) {
                                if (byteOrderedDataInputStream.read(bArr2) != 6) {
                                    throw new IOException("Invalid exif");
                                } else if (Arrays.equals(bArr2, f35961g)) {
                                    byteOrderedDataInputStream.skipFully(readUnsignedShort2 - 6);
                                }
                            }
                            byteOrderedDataOutputStream.writeByte(-1);
                            byteOrderedDataOutputStream.writeByte(readByte);
                            byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort2 + 2);
                            if (readUnsignedShort2 >= 6) {
                                readUnsignedShort2 -= 6;
                                byteOrderedDataOutputStream.write(bArr2);
                            }
                            while (readUnsignedShort2 > 0) {
                                int read2 = byteOrderedDataInputStream.read(bArr, 0, Math.min(readUnsignedShort2, 4096));
                                if (read2 < 0) {
                                    break;
                                }
                                byteOrderedDataOutputStream.write(bArr, 0, read2);
                                readUnsignedShort2 -= read2;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    private void savePngAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (DEBUG) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("savePngAttributes starting with (inputStream: ");
            sb2.append(inputStream);
            sb2.append(", outputStream: ");
            sb2.append(outputStream);
            sb2.append(")");
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, byteOrder);
        byte[] bArr = PNG_SIGNATURE;
        ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr.length);
        int i11 = this.mOffsetToExifData;
        if (i11 == 0) {
            int readInt = byteOrderedDataInputStream.readInt();
            byteOrderedDataOutputStream.writeInt(readInt);
            ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream, readInt + 4 + 4);
        } else {
            ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream, ((i11 - bArr.length) - 4) - 4);
            byteOrderedDataInputStream.skipFully(byteOrderedDataInputStream.readInt() + 4 + 4);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new ByteOrderedDataOutputStream(byteArrayOutputStream2, byteOrder);
                writeExifSegment(byteOrderedDataOutputStream2);
                byte[] byteArray = ((ByteArrayOutputStream) byteOrderedDataOutputStream2.f35967b).toByteArray();
                byteOrderedDataOutputStream.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                byteOrderedDataOutputStream.writeInt((int) crc32.getValue());
                ExifInterfaceUtils.c(byteArrayOutputStream2);
                ExifInterfaceUtils.e(byteOrderedDataInputStream, byteOrderedDataOutputStream);
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                ExifInterfaceUtils.c(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            ExifInterfaceUtils.c(byteArrayOutputStream);
            throw th;
        }
    }

    private void saveWebpAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        InputStream inputStream2 = inputStream;
        OutputStream outputStream2 = outputStream;
        if (DEBUG) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("saveWebpAttributes starting with (inputStream: ");
            sb2.append(inputStream2);
            sb2.append(", outputStream: ");
            sb2.append(outputStream2);
            sb2.append(")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream2, byteOrder);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream2, byteOrder);
        byte[] bArr = WEBP_SIGNATURE_1;
        ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr.length);
        byte[] bArr2 = WEBP_SIGNATURE_2;
        byteOrderedDataInputStream.skipFully(bArr2.length + 4);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new ByteOrderedDataOutputStream(byteArrayOutputStream2, byteOrder);
                int i17 = this.mOffsetToExifData;
                if (i17 != 0) {
                    ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream2, ((i17 - ((bArr.length + 4) + bArr2.length)) - 4) - 4);
                    byteOrderedDataInputStream.skipFully(4);
                    byteOrderedDataInputStream.skipFully(byteOrderedDataInputStream.readInt());
                    writeExifSegment(byteOrderedDataOutputStream2);
                } else {
                    byte[] bArr3 = new byte[4];
                    if (byteOrderedDataInputStream.read(bArr3) == 4) {
                        byte[] bArr4 = WEBP_CHUNK_TYPE_VP8X;
                        boolean z11 = false;
                        if (Arrays.equals(bArr3, bArr4)) {
                            int readInt = byteOrderedDataInputStream.readInt();
                            if (readInt % 2 == 1) {
                                i16 = readInt + 1;
                            } else {
                                i16 = readInt;
                            }
                            byte[] bArr5 = new byte[i16];
                            byteOrderedDataInputStream.read(bArr5);
                            byte b11 = (byte) (8 | bArr5[0]);
                            bArr5[0] = b11;
                            if (((b11 >> 1) & 1) == 1) {
                                z11 = true;
                            }
                            byteOrderedDataOutputStream2.write(bArr4);
                            byteOrderedDataOutputStream2.writeInt(readInt);
                            byteOrderedDataOutputStream2.write(bArr5);
                            if (z11) {
                                copyChunksUpToGivenChunkType(byteOrderedDataInputStream, byteOrderedDataOutputStream2, WEBP_CHUNK_TYPE_ANIM, (byte[]) null);
                                while (true) {
                                    byte[] bArr6 = new byte[4];
                                    inputStream2.read(bArr6);
                                    if (!Arrays.equals(bArr6, WEBP_CHUNK_TYPE_ANMF)) {
                                        break;
                                    }
                                    copyWebPChunk(byteOrderedDataInputStream, byteOrderedDataOutputStream2, bArr6);
                                }
                                writeExifSegment(byteOrderedDataOutputStream2);
                            } else {
                                copyChunksUpToGivenChunkType(byteOrderedDataInputStream, byteOrderedDataOutputStream2, WEBP_CHUNK_TYPE_VP8, WEBP_CHUNK_TYPE_VP8L);
                                writeExifSegment(byteOrderedDataOutputStream2);
                            }
                        } else {
                            byte[] bArr7 = WEBP_CHUNK_TYPE_VP8;
                            if (Arrays.equals(bArr3, bArr7) || Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                                int readInt2 = byteOrderedDataInputStream.readInt();
                                if (readInt2 % 2 == 1) {
                                    i11 = readInt2 + 1;
                                } else {
                                    i11 = readInt2;
                                }
                                byte[] bArr8 = new byte[3];
                                if (Arrays.equals(bArr3, bArr7)) {
                                    byteOrderedDataInputStream.read(bArr8);
                                    byte[] bArr9 = new byte[3];
                                    if (byteOrderedDataInputStream.read(bArr9) != 3 || !Arrays.equals(WEBP_VP8_SIGNATURE, bArr9)) {
                                        throw new IOException("Encountered error while checking VP8 signature");
                                    }
                                    i15 = byteOrderedDataInputStream.readInt();
                                    i14 = (i15 << 18) >> 18;
                                    i13 = (i15 << 2) >> 18;
                                    i11 -= 10;
                                    i12 = 0;
                                } else if (!Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                                    i15 = 0;
                                    i14 = 0;
                                    i13 = 0;
                                    i12 = 0;
                                } else if (byteOrderedDataInputStream.readByte() == 47) {
                                    i15 = byteOrderedDataInputStream.readInt();
                                    i12 = i15 & 8;
                                    i11 -= 5;
                                    i13 = ((i15 << 4) >> 18) + 1;
                                    i14 = ((i15 << 18) >> 18) + 1;
                                } else {
                                    throw new IOException("Encountered error while checking VP8L signature");
                                }
                                byteOrderedDataOutputStream2.write(bArr4);
                                byteOrderedDataOutputStream2.writeInt(10);
                                byte[] bArr10 = new byte[10];
                                byte b12 = (byte) (bArr10[0] | 8);
                                bArr10[0] = b12;
                                bArr10[0] = (byte) (b12 | (i12 << 4));
                                int i18 = i14 - 1;
                                int i19 = i13 - 1;
                                bArr10[4] = (byte) i18;
                                bArr10[5] = (byte) (i18 >> 8);
                                bArr10[6] = (byte) (i18 >> 16);
                                bArr10[7] = (byte) i19;
                                bArr10[8] = (byte) (i19 >> 8);
                                bArr10[9] = (byte) (i19 >> 16);
                                byteOrderedDataOutputStream2.write(bArr10);
                                byteOrderedDataOutputStream2.write(bArr3);
                                byteOrderedDataOutputStream2.writeInt(readInt2);
                                if (Arrays.equals(bArr3, bArr7)) {
                                    byteOrderedDataOutputStream2.write(bArr8);
                                    byteOrderedDataOutputStream2.write(WEBP_VP8_SIGNATURE);
                                    byteOrderedDataOutputStream2.writeInt(i15);
                                } else if (Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                                    byteOrderedDataOutputStream2.write(47);
                                    byteOrderedDataOutputStream2.writeInt(i15);
                                }
                                ExifInterfaceUtils.f(byteOrderedDataInputStream, byteOrderedDataOutputStream2, i11);
                                writeExifSegment(byteOrderedDataOutputStream2);
                            }
                        }
                    } else {
                        throw new IOException("Encountered invalid length while parsing WebP chunk type");
                    }
                }
                ExifInterfaceUtils.e(byteOrderedDataInputStream, byteOrderedDataOutputStream2);
                int size = byteArrayOutputStream2.size();
                byte[] bArr11 = WEBP_SIGNATURE_2;
                byteOrderedDataOutputStream.writeInt(size + bArr11.length);
                byteOrderedDataOutputStream.write(bArr11);
                byteArrayOutputStream2.writeTo(byteOrderedDataOutputStream);
                ExifInterfaceUtils.c(byteArrayOutputStream2);
            } catch (Exception e11) {
                e = e11;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    throw new IOException("Failed to save WebP file", e);
                } catch (Throwable th2) {
                    th = th2;
                    ExifInterfaceUtils.c(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = byteArrayOutputStream2;
                ExifInterfaceUtils.c(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            throw new IOException("Failed to save WebP file", e);
        }
    }

    private void setThumbnailData(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        HashMap<String, ExifAttribute> hashMap = this.mAttributes[4];
        ExifAttribute exifAttribute = hashMap.get(TAG_COMPRESSION);
        if (exifAttribute != null) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            this.mThumbnailCompression = intValue;
            if (intValue != 1) {
                if (intValue == 6) {
                    handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
                    return;
                } else if (intValue != 7) {
                    return;
                }
            }
            if (isSupportedDataType(hashMap)) {
                handleThumbnailFromStrips(byteOrderedDataInputStream, hashMap);
                return;
            }
            return;
        }
        this.mThumbnailCompression = 6;
        handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
    }

    private static boolean shouldSupportSeek(int i11) {
        return (i11 == 4 || i11 == 9 || i11 == 13 || i11 == 14) ? false : true;
    }

    private void swapBasedOnImageSize(int i11, int i12) throws IOException {
        if (!this.mAttributes[i11].isEmpty() && !this.mAttributes[i12].isEmpty()) {
            ExifAttribute exifAttribute = this.mAttributes[i11].get(TAG_IMAGE_LENGTH);
            ExifAttribute exifAttribute2 = this.mAttributes[i11].get(TAG_IMAGE_WIDTH);
            ExifAttribute exifAttribute3 = this.mAttributes[i12].get(TAG_IMAGE_LENGTH);
            ExifAttribute exifAttribute4 = this.mAttributes[i12].get(TAG_IMAGE_WIDTH);
            if (exifAttribute != null && exifAttribute2 != null && exifAttribute3 != null && exifAttribute4 != null) {
                int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
                int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
                int intValue3 = exifAttribute3.getIntValue(this.mExifByteOrder);
                int intValue4 = exifAttribute4.getIntValue(this.mExifByteOrder);
                if (intValue < intValue3 && intValue2 < intValue4) {
                    HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
                    HashMap<String, ExifAttribute> hashMap = hashMapArr[i11];
                    hashMapArr[i11] = hashMapArr[i12];
                    hashMapArr[i12] = hashMap;
                }
            }
        }
    }

    private void updateImageSizeValues(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i11) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2;
        ExifAttribute exifAttribute3 = this.mAttributes[i11].get(TAG_DEFAULT_CROP_SIZE);
        ExifAttribute exifAttribute4 = this.mAttributes[i11].get(TAG_RW2_SENSOR_TOP_BORDER);
        ExifAttribute exifAttribute5 = this.mAttributes[i11].get(TAG_RW2_SENSOR_LEFT_BORDER);
        ExifAttribute exifAttribute6 = this.mAttributes[i11].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        ExifAttribute exifAttribute7 = this.mAttributes[i11].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (exifAttribute3 != null) {
            if (exifAttribute3.format == 5) {
                Rational[] rationalArr = (Rational[]) exifAttribute3.a(this.mExifByteOrder);
                if (rationalArr == null || rationalArr.length != 2) {
                    Log.w(TAG, "Invalid crop size values. cropSize=" + Arrays.toString(rationalArr));
                    return;
                }
                exifAttribute2 = ExifAttribute.createURational(rationalArr[0], this.mExifByteOrder);
                exifAttribute = ExifAttribute.createURational(rationalArr[1], this.mExifByteOrder);
            } else {
                int[] iArr = (int[]) exifAttribute3.a(this.mExifByteOrder);
                if (iArr == null || iArr.length != 2) {
                    Log.w(TAG, "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                exifAttribute2 = ExifAttribute.createUShort(iArr[0], this.mExifByteOrder);
                exifAttribute = ExifAttribute.createUShort(iArr[1], this.mExifByteOrder);
            }
            this.mAttributes[i11].put(TAG_IMAGE_WIDTH, exifAttribute2);
            this.mAttributes[i11].put(TAG_IMAGE_LENGTH, exifAttribute);
        } else if (exifAttribute4 == null || exifAttribute5 == null || exifAttribute6 == null || exifAttribute7 == null) {
            retrieveJpegImageSize(seekableByteOrderedDataInputStream, i11);
        } else {
            int intValue = exifAttribute4.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute6.getIntValue(this.mExifByteOrder);
            int intValue3 = exifAttribute7.getIntValue(this.mExifByteOrder);
            int intValue4 = exifAttribute5.getIntValue(this.mExifByteOrder);
            if (intValue2 > intValue && intValue3 > intValue4) {
                ExifAttribute createUShort = ExifAttribute.createUShort(intValue2 - intValue, this.mExifByteOrder);
                ExifAttribute createUShort2 = ExifAttribute.createUShort(intValue3 - intValue4, this.mExifByteOrder);
                this.mAttributes[i11].put(TAG_IMAGE_LENGTH, createUShort);
                this.mAttributes[i11].put(TAG_IMAGE_WIDTH, createUShort2);
            }
        }
    }

    private void validateImages() throws IOException {
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        ExifAttribute exifAttribute = this.mAttributes[1].get(TAG_PIXEL_X_DIMENSION);
        ExifAttribute exifAttribute2 = this.mAttributes[1].get(TAG_PIXEL_Y_DIMENSION);
        if (!(exifAttribute == null || exifAttribute2 == null)) {
            this.mAttributes[0].put(TAG_IMAGE_WIDTH, exifAttribute);
            this.mAttributes[0].put(TAG_IMAGE_LENGTH, exifAttribute2);
        }
        if (this.mAttributes[4].isEmpty() && isThumbnail(this.mAttributes[5])) {
            HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        isThumbnail(this.mAttributes[4]);
        replaceInvalidTags(0, TAG_THUMBNAIL_ORIENTATION, TAG_ORIENTATION);
        replaceInvalidTags(0, TAG_THUMBNAIL_IMAGE_LENGTH, TAG_IMAGE_LENGTH);
        replaceInvalidTags(0, TAG_THUMBNAIL_IMAGE_WIDTH, TAG_IMAGE_WIDTH);
        replaceInvalidTags(5, TAG_THUMBNAIL_ORIENTATION, TAG_ORIENTATION);
        replaceInvalidTags(5, TAG_THUMBNAIL_IMAGE_LENGTH, TAG_IMAGE_LENGTH);
        replaceInvalidTags(5, TAG_THUMBNAIL_IMAGE_WIDTH, TAG_IMAGE_WIDTH);
        replaceInvalidTags(4, TAG_ORIENTATION, TAG_THUMBNAIL_ORIENTATION);
        replaceInvalidTags(4, TAG_IMAGE_LENGTH, TAG_THUMBNAIL_IMAGE_LENGTH);
        replaceInvalidTags(4, TAG_IMAGE_WIDTH, TAG_THUMBNAIL_IMAGE_WIDTH);
    }

    private int writeExifSegment(ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws IOException {
        short s11;
        ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = byteOrderedDataOutputStream;
        ExifTag[][] exifTagArr = f35959e;
        int[] iArr = new int[exifTagArr.length];
        int[] iArr2 = new int[exifTagArr.length];
        for (ExifTag exifTag : EXIF_POINTER_TAGS) {
            removeAttribute(exifTag.f35968name);
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                removeAttribute(TAG_STRIP_OFFSETS);
                removeAttribute(TAG_STRIP_BYTE_COUNTS);
            } else {
                removeAttribute(TAG_JPEG_INTERCHANGE_FORMAT);
                removeAttribute(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
            }
        }
        for (int i11 = 0; i11 < f35959e.length; i11++) {
            for (Object obj : this.mAttributes[i11].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.mAttributes[i11].remove(entry.getKey());
                }
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].f35968name, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].f35968name, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].f35968name, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                this.mAttributes[4].put(TAG_STRIP_OFFSETS, ExifAttribute.createUShort(0, this.mExifByteOrder));
                this.mAttributes[4].put(TAG_STRIP_BYTE_COUNTS, ExifAttribute.createUShort(this.mThumbnailLength, this.mExifByteOrder));
            } else {
                this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, ExifAttribute.createULong(0, this.mExifByteOrder));
                this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, ExifAttribute.createULong((long) this.mThumbnailLength, this.mExifByteOrder));
            }
        }
        for (int i12 = 0; i12 < f35959e.length; i12++) {
            int i13 = 0;
            for (Map.Entry<String, ExifAttribute> value : this.mAttributes[i12].entrySet()) {
                int size = ((ExifAttribute) value.getValue()).size();
                if (size > 4) {
                    i13 += size;
                }
            }
            iArr2[i12] = iArr2[i12] + i13;
        }
        int i14 = 8;
        for (int i15 = 0; i15 < f35959e.length; i15++) {
            if (!this.mAttributes[i15].isEmpty()) {
                iArr[i15] = i14;
                i14 += (this.mAttributes[i15].size() * 12) + 2 + 4 + iArr2[i15];
            }
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                this.mAttributes[4].put(TAG_STRIP_OFFSETS, ExifAttribute.createUShort(i14, this.mExifByteOrder));
            } else {
                this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, ExifAttribute.createULong((long) i14, this.mExifByteOrder));
            }
            this.mThumbnailOffset = i14;
            i14 += this.mThumbnailLength;
        }
        if (this.mMimeType == 4) {
            i14 += 8;
        }
        if (DEBUG) {
            for (int i16 = 0; i16 < f35959e.length; i16++) {
                String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", new Object[]{Integer.valueOf(i16), Integer.valueOf(iArr[i16]), Integer.valueOf(this.mAttributes[i16].size()), Integer.valueOf(iArr2[i16]), Integer.valueOf(i14)});
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].f35968name, ExifAttribute.createULong((long) iArr[1], this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].f35968name, ExifAttribute.createULong((long) iArr[2], this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].f35968name, ExifAttribute.createULong((long) iArr[3], this.mExifByteOrder));
        }
        int i17 = this.mMimeType;
        if (i17 == 4) {
            byteOrderedDataOutputStream2.writeUnsignedShort(i14);
            byteOrderedDataOutputStream2.write(f35961g);
        } else if (i17 == 13) {
            byteOrderedDataOutputStream2.writeInt(i14);
            byteOrderedDataOutputStream2.write(PNG_CHUNK_TYPE_EXIF);
        } else if (i17 == 14) {
            byteOrderedDataOutputStream2.write(WEBP_CHUNK_TYPE_EXIF);
            byteOrderedDataOutputStream2.writeInt(i14);
        }
        if (this.mExifByteOrder == ByteOrder.BIG_ENDIAN) {
            s11 = 19789;
        } else {
            s11 = 18761;
        }
        byteOrderedDataOutputStream2.writeShort(s11);
        byteOrderedDataOutputStream2.setByteOrder(this.mExifByteOrder);
        byteOrderedDataOutputStream2.writeUnsignedShort(42);
        byteOrderedDataOutputStream2.writeUnsignedInt(8);
        for (int i18 = 0; i18 < f35959e.length; i18++) {
            if (!this.mAttributes[i18].isEmpty()) {
                byteOrderedDataOutputStream2.writeUnsignedShort(this.mAttributes[i18].size());
                int size2 = iArr[i18] + 2 + (this.mAttributes[i18].size() * 12) + 4;
                for (Map.Entry next : this.mAttributes[i18].entrySet()) {
                    int i19 = sExifTagMapsForWriting[i18].get(next.getKey()).number;
                    ExifAttribute exifAttribute = (ExifAttribute) next.getValue();
                    int size3 = exifAttribute.size();
                    byteOrderedDataOutputStream2.writeUnsignedShort(i19);
                    byteOrderedDataOutputStream2.writeUnsignedShort(exifAttribute.format);
                    byteOrderedDataOutputStream2.writeInt(exifAttribute.numberOfComponents);
                    if (size3 > 4) {
                        byteOrderedDataOutputStream2.writeUnsignedInt((long) size2);
                        size2 += size3;
                    } else {
                        byteOrderedDataOutputStream2.write(exifAttribute.bytes);
                        if (size3 < 4) {
                            while (size3 < 4) {
                                byteOrderedDataOutputStream2.writeByte(0);
                                size3++;
                            }
                        }
                    }
                }
                if (i18 != 0 || this.mAttributes[4].isEmpty()) {
                    byteOrderedDataOutputStream2.writeUnsignedInt(0);
                } else {
                    byteOrderedDataOutputStream2.writeUnsignedInt((long) iArr[4]);
                }
                for (Map.Entry<String, ExifAttribute> value2 : this.mAttributes[i18].entrySet()) {
                    byte[] bArr = ((ExifAttribute) value2.getValue()).bytes;
                    if (bArr.length > 4) {
                        byteOrderedDataOutputStream2.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.mHasThumbnail) {
            byteOrderedDataOutputStream2.write(getThumbnailBytes());
        }
        if (this.mMimeType == 14 && i14 % 2 == 1) {
            byteOrderedDataOutputStream2.writeByte(0);
        }
        byteOrderedDataOutputStream2.setByteOrder(ByteOrder.BIG_ENDIAN);
        return i14;
    }

    public void flipHorizontally() {
        int i11 = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i11 = 2;
                break;
            case 2:
                break;
            case 3:
                i11 = 4;
                break;
            case 4:
                i11 = 3;
                break;
            case 5:
                i11 = 6;
                break;
            case 6:
                i11 = 5;
                break;
            case 7:
                i11 = 8;
                break;
            case 8:
                i11 = 7;
                break;
            default:
                i11 = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i11));
    }

    public void flipVertically() {
        int i11 = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i11 = 4;
                break;
            case 2:
                i11 = 3;
                break;
            case 3:
                i11 = 2;
                break;
            case 4:
                break;
            case 5:
                i11 = 8;
                break;
            case 6:
                i11 = 7;
                break;
            case 7:
                i11 = 6;
                break;
            case 8:
                i11 = 5;
                break;
            default:
                i11 = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i11));
    }

    public double getAltitude(double d11) {
        double attributeDouble = getAttributeDouble(TAG_GPS_ALTITUDE, -1.0d);
        int i11 = -1;
        int attributeInt = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
        if (attributeDouble < 0.0d || attributeInt < 0) {
            return d11;
        }
        if (attributeInt != 1) {
            i11 = 1;
        }
        return attributeDouble * ((double) i11);
    }

    @Nullable
    public String getAttribute(@NonNull String str) {
        if (str != null) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute != null) {
                if (!sTagSetForCompatibility.contains(str)) {
                    return exifAttribute.getStringValue(this.mExifByteOrder);
                }
                if (str.equals(TAG_GPS_TIMESTAMP)) {
                    int i11 = exifAttribute.format;
                    if (i11 == 5 || i11 == 10) {
                        Rational[] rationalArr = (Rational[]) exifAttribute.a(this.mExifByteOrder);
                        if (rationalArr == null || rationalArr.length != 3) {
                            Log.w(TAG, "Invalid GPS Timestamp array. array=" + Arrays.toString(rationalArr));
                            return null;
                        }
                        Rational rational = rationalArr[0];
                        Rational rational2 = rationalArr[1];
                        Rational rational3 = rationalArr[2];
                        return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) rational.numerator) / ((float) rational.denominator))), Integer.valueOf((int) (((float) rational2.numerator) / ((float) rational2.denominator))), Integer.valueOf((int) (((float) rational3.numerator) / ((float) rational3.denominator)))});
                    }
                    Log.w(TAG, "GPS Timestamp format is not rational. format=" + exifAttribute.format);
                    return null;
                }
                try {
                    return Double.toString(exifAttribute.getDoubleValue(this.mExifByteOrder));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    @Nullable
    public byte[] getAttributeBytes(@NonNull String str) {
        if (str != null) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute != null) {
                return exifAttribute.bytes;
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public double getAttributeDouble(@NonNull String str, double d11) {
        if (str != null) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute == null) {
                return d11;
            }
            try {
                return exifAttribute.getDoubleValue(this.mExifByteOrder);
            } catch (NumberFormatException unused) {
                return d11;
            }
        } else {
            throw new NullPointerException("tag shouldn't be null");
        }
    }

    public int getAttributeInt(@NonNull String str, int i11) {
        if (str != null) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute == null) {
                return i11;
            }
            try {
                return exifAttribute.getIntValue(this.mExifByteOrder);
            } catch (NumberFormatException unused) {
                return i11;
            }
        } else {
            throw new NullPointerException("tag shouldn't be null");
        }
    }

    @Nullable
    public long[] getAttributeRange(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        } else if (!this.mModified) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute == null) {
                return null;
            }
            return new long[]{exifAttribute.bytesOffset, (long) exifAttribute.bytes.length};
        } else {
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long getDateTime() {
        return parseDateTime(getAttribute(TAG_DATETIME), getAttribute(TAG_SUBSEC_TIME), getAttribute(TAG_OFFSET_TIME));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long getDateTimeDigitized() {
        return parseDateTime(getAttribute(TAG_DATETIME_DIGITIZED), getAttribute(TAG_SUBSEC_TIME_DIGITIZED), getAttribute(TAG_OFFSET_TIME_DIGITIZED));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long getDateTimeOriginal() {
        return parseDateTime(getAttribute(TAG_DATETIME_ORIGINAL), getAttribute(TAG_SUBSEC_TIME_ORIGINAL), getAttribute(TAG_OFFSET_TIME_ORIGINAL));
    }

    @SuppressLint({"AutoBoxing"})
    @Nullable
    public Long getGpsDateTime() {
        String attribute = getAttribute(TAG_GPS_DATESTAMP);
        String attribute2 = getAttribute(TAG_GPS_TIMESTAMP);
        if (!(attribute == null || attribute2 == null)) {
            Pattern pattern = NON_ZERO_TIME_PATTERN;
            if (pattern.matcher(attribute).matches() || pattern.matcher(attribute2).matches()) {
                String str = attribute + ' ' + attribute2;
                ParsePosition parsePosition = new ParsePosition(0);
                try {
                    Date parse = sFormatterPrimary.parse(str, parsePosition);
                    if (parse == null && (parse = sFormatterSecondary.parse(str, parsePosition)) == null) {
                        return null;
                    }
                    return Long.valueOf(parse.getTime());
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return null;
    }

    @Deprecated
    public boolean getLatLong(float[] fArr) {
        double[] latLong = getLatLong();
        if (latLong == null) {
            return false;
        }
        fArr[0] = (float) latLong[0];
        fArr[1] = (float) latLong[1];
        return true;
    }

    public int getRotationDegrees() {
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    @Nullable
    public byte[] getThumbnail() {
        int i11 = this.mThumbnailCompression;
        if (i11 == 6 || i11 == 7) {
            return getThumbnailBytes();
        }
        return null;
    }

    @Nullable
    public Bitmap getThumbnailBitmap() {
        if (!this.mHasThumbnail) {
            return null;
        }
        if (this.mThumbnailBytes == null) {
            this.mThumbnailBytes = getThumbnailBytes();
        }
        int i11 = this.mThumbnailCompression;
        if (i11 == 6 || i11 == 7) {
            return BitmapFactory.decodeByteArray(this.mThumbnailBytes, 0, this.mThumbnailLength);
        }
        if (i11 == 1) {
            int length = this.mThumbnailBytes.length / 3;
            int[] iArr = new int[length];
            for (int i12 = 0; i12 < length; i12++) {
                byte[] bArr = this.mThumbnailBytes;
                int i13 = i12 * 3;
                iArr[i12] = (bArr[i13] << Ascii.DLE) + 0 + (bArr[i13 + 1] << 8) + bArr[i13 + 2];
            }
            ExifAttribute exifAttribute = this.mAttributes[4].get(TAG_THUMBNAIL_IMAGE_LENGTH);
            ExifAttribute exifAttribute2 = this.mAttributes[4].get(TAG_THUMBNAIL_IMAGE_WIDTH);
            if (!(exifAttribute == null || exifAttribute2 == null)) {
                return Bitmap.createBitmap(iArr, exifAttribute2.getIntValue(this.mExifByteOrder), exifAttribute.getIntValue(this.mExifByteOrder), Bitmap.Config.ARGB_8888);
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x005f A[SYNTHETIC, Splitter:B:32:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007c A[Catch:{ Exception -> 0x009c, all -> 0x0082 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00a1  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getThumbnailBytes() {
        /*
            r8 = this;
            boolean r0 = r8.mHasThumbnail
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            byte[] r0 = r8.mThumbnailBytes
            if (r0 == 0) goto L_0x000b
            return r0
        L_0x000b:
            android.content.res.AssetManager$AssetInputStream r0 = r8.mAssetInputStream     // Catch:{ Exception -> 0x009a, all -> 0x008e }
            if (r0 == 0) goto L_0x0028
            boolean r2 = r0.markSupported()     // Catch:{ Exception -> 0x0025, all -> 0x001e }
            if (r2 == 0) goto L_0x001a
            r0.reset()     // Catch:{ Exception -> 0x0025, all -> 0x001e }
        L_0x0018:
            r2 = r1
            goto L_0x0049
        L_0x001a:
            androidx.exifinterface.media.ExifInterfaceUtils.c(r0)
            return r1
        L_0x001e:
            r2 = move-exception
            r7 = r1
            r1 = r0
            r0 = r2
            r2 = r7
            goto L_0x0091
        L_0x0025:
            r2 = r1
            goto L_0x009c
        L_0x0028:
            java.lang.String r0 = r8.mFilename     // Catch:{ Exception -> 0x009a, all -> 0x008e }
            if (r0 == 0) goto L_0x0034
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x009a, all -> 0x008e }
            java.lang.String r2 = r8.mFilename     // Catch:{ Exception -> 0x009a, all -> 0x008e }
            r0.<init>(r2)     // Catch:{ Exception -> 0x009a, all -> 0x008e }
            goto L_0x0018
        L_0x0034:
            java.io.FileDescriptor r0 = r8.mSeekableFileDescriptor     // Catch:{ Exception -> 0x009a, all -> 0x008e }
            java.io.FileDescriptor r0 = androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.b(r0)     // Catch:{ Exception -> 0x009a, all -> 0x008e }
            int r2 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x008b, all -> 0x0087 }
            r3 = 0
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.c(r0, r3, r2)     // Catch:{ Exception -> 0x008b, all -> 0x0087 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x008b, all -> 0x0087 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x008b, all -> 0x0087 }
            r7 = r2
            r2 = r0
            r0 = r7
        L_0x0049:
            int r3 = r8.mThumbnailOffset     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            int r4 = r8.mOffsetToExifData     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            int r3 = r3 + r4
            long r3 = (long) r3     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            long r3 = r0.skip(r3)     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            int r5 = r8.mThumbnailOffset     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            int r6 = r8.mOffsetToExifData     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            int r5 = r5 + r6
            long r5 = (long) r5
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            java.lang.String r4 = "Corrupted image"
            if (r3 != 0) goto L_0x007c
            int r3 = r8.mThumbnailLength     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            int r5 = r0.read(r3)     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            int r6 = r8.mThumbnailLength     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            if (r5 != r6) goto L_0x0076
            r8.mThumbnailBytes = r3     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            androidx.exifinterface.media.ExifInterfaceUtils.c(r0)
            if (r2 == 0) goto L_0x0075
            androidx.exifinterface.media.ExifInterfaceUtils.b(r2)
        L_0x0075:
            return r3
        L_0x0076:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            throw r3     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
        L_0x007c:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
            throw r3     // Catch:{ Exception -> 0x009c, all -> 0x0082 }
        L_0x0082:
            r1 = move-exception
            r7 = r1
            r1 = r0
        L_0x0085:
            r0 = r7
            goto L_0x0091
        L_0x0087:
            r2 = move-exception
            r7 = r2
            r2 = r0
            goto L_0x0085
        L_0x008b:
            r2 = r0
            r0 = r1
            goto L_0x009c
        L_0x008e:
            r2 = move-exception
            r0 = r2
            r2 = r1
        L_0x0091:
            androidx.exifinterface.media.ExifInterfaceUtils.c(r1)
            if (r2 == 0) goto L_0x0099
            androidx.exifinterface.media.ExifInterfaceUtils.b(r2)
        L_0x0099:
            throw r0
        L_0x009a:
            r0 = r1
            r2 = r0
        L_0x009c:
            androidx.exifinterface.media.ExifInterfaceUtils.c(r0)
            if (r2 == 0) goto L_0x00a4
            androidx.exifinterface.media.ExifInterfaceUtils.b(r2)
        L_0x00a4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getThumbnailBytes():byte[]");
    }

    @Nullable
    public long[] getThumbnailRange() {
        if (this.mModified) {
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        } else if (!this.mHasThumbnail) {
            return null;
        } else {
            if (this.mHasThumbnailStrips && !this.mAreThumbnailStripsConsecutive) {
                return null;
            }
            return new long[]{(long) (this.mThumbnailOffset + this.mOffsetToExifData), (long) this.mThumbnailLength};
        }
    }

    public boolean hasAttribute(@NonNull String str) {
        return getExifAttribute(str) != null;
    }

    public boolean hasThumbnail() {
        return this.mHasThumbnail;
    }

    public boolean isFlipped() {
        int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
        if (attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5) {
            return true;
        }
        return false;
    }

    public boolean isThumbnailCompressed() {
        if (!this.mHasThumbnail) {
            return false;
        }
        int i11 = this.mThumbnailCompression;
        if (i11 == 6 || i11 == 7) {
            return true;
        }
        return false;
    }

    public void resetOrientation() {
        setAttribute(TAG_ORIENTATION, Integer.toString(1));
    }

    public void rotate(int i11) {
        if (i11 % 90 == 0) {
            int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
            List<Integer> list = ROTATION_ORDER;
            int i12 = 0;
            if (list.contains(Integer.valueOf(attributeInt))) {
                int indexOf = (list.indexOf(Integer.valueOf(attributeInt)) + (i11 / 90)) % 4;
                if (indexOf < 0) {
                    i12 = 4;
                }
                i12 = list.get(indexOf + i12).intValue();
            } else {
                List<Integer> list2 = FLIPPED_ROTATION_ORDER;
                if (list2.contains(Integer.valueOf(attributeInt))) {
                    int indexOf2 = (list2.indexOf(Integer.valueOf(attributeInt)) + (i11 / 90)) % 4;
                    if (indexOf2 < 0) {
                        i12 = 4;
                    }
                    i12 = list2.get(indexOf2 + i12).intValue();
                }
            }
            setAttribute(TAG_ORIENTATION, Integer.toString(i12));
            return;
        }
        throw new IllegalArgumentException("degree should be a multiple of 90");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d7, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d8, code lost:
        r9 = null;
        r1 = r6;
        r6 = r8;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00dd, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00de, code lost:
        r8 = null;
        r9 = null;
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00e2, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00e3, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00f4, code lost:
        androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.c(r13.mSeekableFileDescriptor, 0, android.system.OsConstants.SEEK_SET);
        r1 = new java.io.FileOutputStream(r13.mSeekableFileDescriptor);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0103, code lost:
        r1 = new java.io.FileOutputStream(r13.mFilename);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0155, code lost:
        r2.delete();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e2 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:27:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f4 A[Catch:{ Exception -> 0x011e, all -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0103 A[Catch:{ Exception -> 0x011e, all -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0155  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveAttributes() throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r13.mMimeType
            boolean r0 = isSupportedFormatForSavingAttributes(r0)
            if (r0 == 0) goto L_0x017a
            java.io.FileDescriptor r0 = r13.mSeekableFileDescriptor
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = r13.mFilename
            if (r0 == 0) goto L_0x0011
            goto L_0x0019
        L_0x0011:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface does not support saving attributes for the current input."
            r0.<init>(r1)
            throw r0
        L_0x0019:
            boolean r0 = r13.mHasThumbnail
            if (r0 == 0) goto L_0x002e
            boolean r0 = r13.mHasThumbnailStrips
            if (r0 == 0) goto L_0x002e
            boolean r0 = r13.mAreThumbnailStripsConsecutive
            if (r0 == 0) goto L_0x0026
            goto L_0x002e
        L_0x0026:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface does not support saving attributes when the image file has non-consecutive thumbnail strips"
            r0.<init>(r1)
            throw r0
        L_0x002e:
            r0 = 1
            r13.mModified = r0
            byte[] r1 = r13.getThumbnail()
            r13.mThumbnailBytes = r1
            r1 = 0
            java.lang.String r2 = "temp"
            java.lang.String r3 = "tmp"
            java.io.File r2 = java.io.File.createTempFile(r2, r3)     // Catch:{ Exception -> 0x0168, all -> 0x0165 }
            java.lang.String r3 = r13.mFilename     // Catch:{ Exception -> 0x0168, all -> 0x0165 }
            r4 = 0
            if (r3 == 0) goto L_0x004e
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0168, all -> 0x0165 }
            java.lang.String r6 = r13.mFilename     // Catch:{ Exception -> 0x0168, all -> 0x0165 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0168, all -> 0x0165 }
            goto L_0x005c
        L_0x004e:
            java.io.FileDescriptor r3 = r13.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0168, all -> 0x0165 }
            int r6 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0168, all -> 0x0165 }
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.c(r3, r4, r6)     // Catch:{ Exception -> 0x0168, all -> 0x0165 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0168, all -> 0x0165 }
            java.io.FileDescriptor r6 = r13.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0168, all -> 0x0165 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0168, all -> 0x0165 }
        L_0x005c:
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0161, all -> 0x015d }
            r6.<init>(r2)     // Catch:{ Exception -> 0x0161, all -> 0x015d }
            androidx.exifinterface.media.ExifInterfaceUtils.e(r3, r6)     // Catch:{ Exception -> 0x015b, all -> 0x0159 }
            androidx.exifinterface.media.ExifInterfaceUtils.c(r3)
            androidx.exifinterface.media.ExifInterfaceUtils.c(r6)
            r3 = 0
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00e6, all -> 0x00e2 }
            r6.<init>(r2)     // Catch:{ Exception -> 0x00e6, all -> 0x00e2 }
            java.lang.String r7 = r13.mFilename     // Catch:{ Exception -> 0x00dd, all -> 0x00e2 }
            if (r7 == 0) goto L_0x007c
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00dd, all -> 0x00e2 }
            java.lang.String r8 = r13.mFilename     // Catch:{ Exception -> 0x00dd, all -> 0x00e2 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00dd, all -> 0x00e2 }
            goto L_0x008a
        L_0x007c:
            java.io.FileDescriptor r7 = r13.mSeekableFileDescriptor     // Catch:{ Exception -> 0x00dd, all -> 0x00e2 }
            int r8 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x00dd, all -> 0x00e2 }
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.c(r7, r4, r8)     // Catch:{ Exception -> 0x00dd, all -> 0x00e2 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00dd, all -> 0x00e2 }
            java.io.FileDescriptor r8 = r13.mSeekableFileDescriptor     // Catch:{ Exception -> 0x00dd, all -> 0x00e2 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00dd, all -> 0x00e2 }
        L_0x008a:
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00d7, all -> 0x00e2 }
            r8.<init>(r6)     // Catch:{ Exception -> 0x00d7, all -> 0x00e2 }
            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00d1, all -> 0x00cd }
            r9.<init>(r7)     // Catch:{ Exception -> 0x00d1, all -> 0x00cd }
            int r10 = r13.mMimeType     // Catch:{ Exception -> 0x00c8 }
            r11 = 4
            if (r10 != r11) goto L_0x009d
            r13.saveJpegAttributes(r8, r9)     // Catch:{ Exception -> 0x00c8 }
            goto L_0x00bc
        L_0x009d:
            r11 = 13
            if (r10 != r11) goto L_0x00a5
            r13.savePngAttributes(r8, r9)     // Catch:{ Exception -> 0x00c8 }
            goto L_0x00bc
        L_0x00a5:
            r11 = 14
            if (r10 != r11) goto L_0x00ad
            r13.saveWebpAttributes(r8, r9)     // Catch:{ Exception -> 0x00c8 }
            goto L_0x00bc
        L_0x00ad:
            r11 = 3
            if (r10 == r11) goto L_0x00b2
            if (r10 != 0) goto L_0x00bc
        L_0x00b2:
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataOutputStream r10 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataOutputStream     // Catch:{ Exception -> 0x00c8 }
            java.nio.ByteOrder r11 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ Exception -> 0x00c8 }
            r10.<init>(r9, r11)     // Catch:{ Exception -> 0x00c8 }
            r13.writeExifSegment(r10)     // Catch:{ Exception -> 0x00c8 }
        L_0x00bc:
            androidx.exifinterface.media.ExifInterfaceUtils.c(r8)
            androidx.exifinterface.media.ExifInterfaceUtils.c(r9)
            r2.delete()
            r13.mThumbnailBytes = r1
            return
        L_0x00c8:
            r1 = move-exception
            r12 = r6
            r6 = r1
            r1 = r12
            goto L_0x00eb
        L_0x00cd:
            r0 = move-exception
            r9 = r1
            goto L_0x014c
        L_0x00d1:
            r9 = move-exception
            r12 = r9
            r9 = r1
            r1 = r6
            r6 = r12
            goto L_0x00eb
        L_0x00d7:
            r8 = move-exception
            r9 = r1
            r1 = r6
            r6 = r8
            r8 = r9
            goto L_0x00eb
        L_0x00dd:
            r7 = move-exception
            r8 = r1
            r9 = r8
            r1 = r6
            goto L_0x00e9
        L_0x00e2:
            r0 = move-exception
            r9 = r1
            goto L_0x014d
        L_0x00e6:
            r7 = move-exception
            r8 = r1
            r9 = r8
        L_0x00e9:
            r6 = r7
            r7 = r9
        L_0x00eb:
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0122, all -> 0x0120 }
            r10.<init>(r2)     // Catch:{ Exception -> 0x0122, all -> 0x0120 }
            java.lang.String r1 = r13.mFilename     // Catch:{ Exception -> 0x011e, all -> 0x011c }
            if (r1 != 0) goto L_0x0103
            java.io.FileDescriptor r1 = r13.mSeekableFileDescriptor     // Catch:{ Exception -> 0x011e, all -> 0x011c }
            int r11 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x011e, all -> 0x011c }
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.c(r1, r4, r11)     // Catch:{ Exception -> 0x011e, all -> 0x011c }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x011e, all -> 0x011c }
            java.io.FileDescriptor r4 = r13.mSeekableFileDescriptor     // Catch:{ Exception -> 0x011e, all -> 0x011c }
            r1.<init>(r4)     // Catch:{ Exception -> 0x011e, all -> 0x011c }
            goto L_0x010a
        L_0x0103:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x011e, all -> 0x011c }
            java.lang.String r4 = r13.mFilename     // Catch:{ Exception -> 0x011e, all -> 0x011c }
            r1.<init>(r4)     // Catch:{ Exception -> 0x011e, all -> 0x011c }
        L_0x010a:
            r7 = r1
            androidx.exifinterface.media.ExifInterfaceUtils.e(r10, r7)     // Catch:{ Exception -> 0x011e, all -> 0x011c }
            androidx.exifinterface.media.ExifInterfaceUtils.c(r10)     // Catch:{ all -> 0x014b }
            androidx.exifinterface.media.ExifInterfaceUtils.c(r7)     // Catch:{ all -> 0x014b }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x014b }
            java.lang.String r1 = "Failed to save new file"
            r0.<init>(r1, r6)     // Catch:{ all -> 0x014b }
            throw r0     // Catch:{ all -> 0x014b }
        L_0x011c:
            r0 = move-exception
            goto L_0x0143
        L_0x011e:
            r1 = move-exception
            goto L_0x0125
        L_0x0120:
            r0 = move-exception
            goto L_0x0144
        L_0x0122:
            r3 = move-exception
            r10 = r1
            r1 = r3
        L_0x0125:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0140 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0140 }
            r4.<init>()     // Catch:{ all -> 0x0140 }
            java.lang.String r5 = "Failed to save new file. Original file is stored in "
            r4.append(r5)     // Catch:{ all -> 0x0140 }
            java.lang.String r5 = r2.getAbsolutePath()     // Catch:{ all -> 0x0140 }
            r4.append(r5)     // Catch:{ all -> 0x0140 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0140 }
            r3.<init>(r4, r1)     // Catch:{ all -> 0x0140 }
            throw r3     // Catch:{ all -> 0x0140 }
        L_0x0140:
            r1 = move-exception
            r3 = r0
            r0 = r1
        L_0x0143:
            r1 = r10
        L_0x0144:
            androidx.exifinterface.media.ExifInterfaceUtils.c(r1)     // Catch:{ all -> 0x014b }
            androidx.exifinterface.media.ExifInterfaceUtils.c(r7)     // Catch:{ all -> 0x014b }
            throw r0     // Catch:{ all -> 0x014b }
        L_0x014b:
            r0 = move-exception
        L_0x014c:
            r1 = r8
        L_0x014d:
            androidx.exifinterface.media.ExifInterfaceUtils.c(r1)
            androidx.exifinterface.media.ExifInterfaceUtils.c(r9)
            if (r3 != 0) goto L_0x0158
            r2.delete()
        L_0x0158:
            throw r0
        L_0x0159:
            r0 = move-exception
            goto L_0x015f
        L_0x015b:
            r0 = move-exception
            goto L_0x0163
        L_0x015d:
            r0 = move-exception
            r6 = r1
        L_0x015f:
            r1 = r3
            goto L_0x0173
        L_0x0161:
            r0 = move-exception
            r6 = r1
        L_0x0163:
            r1 = r3
            goto L_0x016a
        L_0x0165:
            r0 = move-exception
            r6 = r1
            goto L_0x0173
        L_0x0168:
            r0 = move-exception
            r6 = r1
        L_0x016a:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x0172 }
            java.lang.String r3 = "Failed to copy original file to temp file"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0172 }
            throw r2     // Catch:{ all -> 0x0172 }
        L_0x0172:
            r0 = move-exception
        L_0x0173:
            androidx.exifinterface.media.ExifInterfaceUtils.c(r1)
            androidx.exifinterface.media.ExifInterfaceUtils.c(r6)
            throw r0
        L_0x017a:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface only supports saving attributes for JPEG, PNG, WebP, and DNG formats."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.saveAttributes():void");
    }

    public void setAltitude(double d11) {
        String str;
        if (d11 >= 0.0d) {
            str = "0";
        } else {
            str = "1";
        }
        setAttribute(TAG_GPS_ALTITUDE, new Rational(Math.abs(d11)).toString());
        setAttribute(TAG_GPS_ALTITUDE_REF, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:95:0x029e, code lost:
        r12 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setAttribute(@androidx.annotation.NonNull java.lang.String r17, @androidx.annotation.Nullable java.lang.String r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            if (r1 == 0) goto L_0x034b
            java.lang.String r3 = "DateTime"
            boolean r3 = r3.equals(r1)
            java.lang.String r4 = " : "
            java.lang.String r5 = "Invalid value for "
            java.lang.String r6 = "ExifInterface"
            if (r3 != 0) goto L_0x0026
            java.lang.String r3 = "DateTimeOriginal"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0026
            java.lang.String r3 = "DateTimeDigitized"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x006d
        L_0x0026:
            if (r2 == 0) goto L_0x006d
            java.util.regex.Pattern r3 = DATETIME_PRIMARY_FORMAT_PATTERN
            java.util.regex.Matcher r3 = r3.matcher(r2)
            boolean r3 = r3.find()
            java.util.regex.Pattern r7 = DATETIME_SECONDARY_FORMAT_PATTERN
            java.util.regex.Matcher r7 = r7.matcher(r2)
            boolean r7 = r7.find()
            int r8 = r18.length()
            r9 = 19
            if (r8 != r9) goto L_0x0054
            if (r3 != 0) goto L_0x0049
            if (r7 != 0) goto L_0x0049
            goto L_0x0054
        L_0x0049:
            if (r7 == 0) goto L_0x006d
            java.lang.String r3 = "-"
            java.lang.String r7 = ":"
            java.lang.String r2 = r2.replaceAll(r3, r7)
            goto L_0x006d
        L_0x0054:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r1)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            android.util.Log.w(r6, r1)
            return
        L_0x006d:
            java.lang.String r3 = "ISOSpeedRatings"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0077
            java.lang.String r1 = "PhotographicSensitivity"
        L_0x0077:
            r3 = 2
            r7 = 1
            if (r2 == 0) goto L_0x0110
            java.util.HashSet<java.lang.String> r8 = sTagSetForCompatibility
            boolean r8 = r8.contains(r1)
            if (r8 == 0) goto L_0x0110
            java.lang.String r8 = "GPSTimeStamp"
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x00e9
            java.util.regex.Pattern r8 = GPS_TIMESTAMP_PATTERN
            java.util.regex.Matcher r8 = r8.matcher(r2)
            boolean r9 = r8.find()
            if (r9 != 0) goto L_0x00b0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r1)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            android.util.Log.w(r6, r1)
            return
        L_0x00b0:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r8.group(r7)
            int r4 = java.lang.Integer.parseInt(r4)
            r2.append(r4)
            java.lang.String r4 = "/1,"
            r2.append(r4)
            java.lang.String r5 = r8.group(r3)
            int r5 = java.lang.Integer.parseInt(r5)
            r2.append(r5)
            r2.append(r4)
            r4 = 3
            java.lang.String r4 = r8.group(r4)
            int r4 = java.lang.Integer.parseInt(r4)
            r2.append(r4)
            java.lang.String r4 = "/1"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            goto L_0x0110
        L_0x00e9:
            double r8 = java.lang.Double.parseDouble(r2)     // Catch:{ NumberFormatException -> 0x00f7 }
            androidx.exifinterface.media.ExifInterface$Rational r10 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ NumberFormatException -> 0x00f7 }
            r10.<init>(r8)     // Catch:{ NumberFormatException -> 0x00f7 }
            java.lang.String r2 = r10.toString()     // Catch:{ NumberFormatException -> 0x00f7 }
            goto L_0x0110
        L_0x00f7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r1)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            android.util.Log.w(r6, r1)
            return
        L_0x0110:
            r4 = 0
            r5 = r4
        L_0x0112:
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r6 = f35959e
            int r6 = r6.length
            if (r5 >= r6) goto L_0x034a
            r6 = 4
            if (r5 != r6) goto L_0x0120
            boolean r6 = r0.mHasThumbnail
            if (r6 != 0) goto L_0x0120
            goto L_0x0342
        L_0x0120:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifTag>[] r6 = sExifTagMapsForWriting
            r6 = r6[r5]
            java.lang.Object r6 = r6.get(r1)
            androidx.exifinterface.media.ExifInterface$ExifTag r6 = (androidx.exifinterface.media.ExifInterface.ExifTag) r6
            if (r6 == 0) goto L_0x0342
            if (r2 != 0) goto L_0x0137
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r6 = r0.mAttributes
            r6 = r6[r5]
            r6.remove(r1)
            goto L_0x0342
        L_0x0137:
            android.util.Pair r8 = guessDataFormat(r2)
            int r9 = r6.primaryFormat
            java.lang.Object r10 = r8.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            r11 = -1
            if (r9 == r10) goto L_0x0200
            int r9 = r6.primaryFormat
            java.lang.Object r10 = r8.second
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            if (r9 != r10) goto L_0x0156
            goto L_0x0200
        L_0x0156:
            int r9 = r6.secondaryFormat
            if (r9 == r11) goto L_0x0174
            java.lang.Object r10 = r8.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            if (r9 == r10) goto L_0x0170
            int r9 = r6.secondaryFormat
            java.lang.Object r10 = r8.second
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            if (r9 != r10) goto L_0x0174
        L_0x0170:
            int r6 = r6.secondaryFormat
            goto L_0x0202
        L_0x0174:
            int r9 = r6.primaryFormat
            if (r9 == r7) goto L_0x01fe
            r10 = 7
            if (r9 == r10) goto L_0x01fe
            if (r9 != r3) goto L_0x017f
            goto L_0x01fe
        L_0x017f:
            boolean r9 = DEBUG
            if (r9 == 0) goto L_0x0342
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Given tag ("
            r9.append(r10)
            r9.append(r1)
            java.lang.String r10 = ") value didn't match with one of expected formats: "
            r9.append(r10)
            java.lang.String[] r10 = f35956b
            int r12 = r6.primaryFormat
            r12 = r10[r12]
            r9.append(r12)
            int r12 = r6.secondaryFormat
            java.lang.String r13 = ""
            java.lang.String r14 = ", "
            if (r12 != r11) goto L_0x01a8
            r6 = r13
            goto L_0x01bb
        L_0x01a8:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r14)
            int r6 = r6.secondaryFormat
            r6 = r10[r6]
            r12.append(r6)
            java.lang.String r6 = r12.toString()
        L_0x01bb:
            r9.append(r6)
            java.lang.String r6 = " (guess: "
            r9.append(r6)
            java.lang.Object r6 = r8.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r6 = r10[r6]
            r9.append(r6)
            java.lang.Object r6 = r8.second
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r6 != r11) goto L_0x01db
            goto L_0x01f4
        L_0x01db:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r14)
            java.lang.Object r8 = r8.second
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            r8 = r10[r8]
            r6.append(r8)
            java.lang.String r13 = r6.toString()
        L_0x01f4:
            r9.append(r13)
            java.lang.String r6 = ")"
            r9.append(r6)
            goto L_0x0342
        L_0x01fe:
            r6 = r9
            goto L_0x0202
        L_0x0200:
            int r6 = r6.primaryFormat
        L_0x0202:
            java.lang.String r8 = "/"
            java.lang.String r9 = ","
            switch(r6) {
                case 1: goto L_0x0335;
                case 2: goto L_0x0328;
                case 3: goto L_0x0303;
                case 4: goto L_0x02de;
                case 5: goto L_0x02a1;
                case 6: goto L_0x0209;
                case 7: goto L_0x0328;
                case 8: goto L_0x0209;
                case 9: goto L_0x027b;
                case 10: goto L_0x0242;
                case 11: goto L_0x0209;
                case 12: goto L_0x021d;
                default: goto L_0x0209;
            }
        L_0x0209:
            r12 = r4
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x0343
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Data format isn't one of expected formats: "
            r3.append(r4)
            r3.append(r6)
            goto L_0x0343
        L_0x021d:
            java.lang.String[] r6 = r2.split(r9, r11)
            int r8 = r6.length
            double[] r8 = new double[r8]
            r9 = r4
        L_0x0225:
            int r10 = r6.length
            if (r9 >= r10) goto L_0x0233
            r10 = r6[r9]
            double r10 = java.lang.Double.parseDouble(r10)
            r8[r9] = r10
            int r9 = r9 + 1
            goto L_0x0225
        L_0x0233:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r6 = r0.mAttributes
            r6 = r6[r5]
            java.nio.ByteOrder r9 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r8 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createDouble((double[]) r8, (java.nio.ByteOrder) r9)
            r6.put(r1, r8)
            goto L_0x0342
        L_0x0242:
            java.lang.String[] r6 = r2.split(r9, r11)
            int r9 = r6.length
            androidx.exifinterface.media.ExifInterface$Rational[] r9 = new androidx.exifinterface.media.ExifInterface.Rational[r9]
            r10 = r4
        L_0x024a:
            int r12 = r6.length
            if (r10 >= r12) goto L_0x026d
            r12 = r6[r10]
            java.lang.String[] r12 = r12.split(r8, r11)
            androidx.exifinterface.media.ExifInterface$Rational r13 = new androidx.exifinterface.media.ExifInterface$Rational
            r14 = r12[r4]
            double r14 = java.lang.Double.parseDouble(r14)
            long r14 = (long) r14
            r12 = r12[r7]
            double r3 = java.lang.Double.parseDouble(r12)
            long r3 = (long) r3
            r13.<init>(r14, r3)
            r9[r10] = r13
            int r10 = r10 + 1
            r3 = 2
            r4 = 0
            goto L_0x024a
        L_0x026d:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r5]
            java.nio.ByteOrder r4 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createSRational((androidx.exifinterface.media.ExifInterface.Rational[]) r9, (java.nio.ByteOrder) r4)
            r3.put(r1, r4)
            goto L_0x029e
        L_0x027b:
            java.lang.String[] r3 = r2.split(r9, r11)
            int r4 = r3.length
            int[] r4 = new int[r4]
            r6 = 0
        L_0x0283:
            int r8 = r3.length
            if (r6 >= r8) goto L_0x0291
            r8 = r3[r6]
            int r8 = java.lang.Integer.parseInt(r8)
            r4[r6] = r8
            int r6 = r6 + 1
            goto L_0x0283
        L_0x0291:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r5]
            java.nio.ByteOrder r6 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createSLong((int[]) r4, (java.nio.ByteOrder) r6)
            r3.put(r1, r4)
        L_0x029e:
            r12 = 0
            goto L_0x0343
        L_0x02a1:
            java.lang.String[] r3 = r2.split(r9, r11)
            int r4 = r3.length
            androidx.exifinterface.media.ExifInterface$Rational[] r4 = new androidx.exifinterface.media.ExifInterface.Rational[r4]
            r6 = 0
        L_0x02a9:
            int r9 = r3.length
            if (r6 >= r9) goto L_0x02ce
            r9 = r3[r6]
            java.lang.String[] r9 = r9.split(r8, r11)
            androidx.exifinterface.media.ExifInterface$Rational r10 = new androidx.exifinterface.media.ExifInterface$Rational
            r12 = 0
            r13 = r9[r12]
            double r13 = java.lang.Double.parseDouble(r13)
            long r13 = (long) r13
            r9 = r9[r7]
            r15 = r8
            double r7 = java.lang.Double.parseDouble(r9)
            long r7 = (long) r7
            r10.<init>(r13, r7)
            r4[r6] = r10
            int r6 = r6 + 1
            r8 = r15
            r7 = 1
            goto L_0x02a9
        L_0x02ce:
            r12 = 0
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r5]
            java.nio.ByteOrder r6 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createURational((androidx.exifinterface.media.ExifInterface.Rational[]) r4, (java.nio.ByteOrder) r6)
            r3.put(r1, r4)
            goto L_0x0343
        L_0x02de:
            r12 = r4
            java.lang.String[] r3 = r2.split(r9, r11)
            int r4 = r3.length
            long[] r4 = new long[r4]
            r6 = r12
        L_0x02e7:
            int r7 = r3.length
            if (r6 >= r7) goto L_0x02f5
            r7 = r3[r6]
            long r7 = java.lang.Long.parseLong(r7)
            r4[r6] = r7
            int r6 = r6 + 1
            goto L_0x02e7
        L_0x02f5:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r5]
            java.nio.ByteOrder r6 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long[]) r4, (java.nio.ByteOrder) r6)
            r3.put(r1, r4)
            goto L_0x0343
        L_0x0303:
            r12 = r4
            java.lang.String[] r3 = r2.split(r9, r11)
            int r4 = r3.length
            int[] r4 = new int[r4]
            r6 = r12
        L_0x030c:
            int r7 = r3.length
            if (r6 >= r7) goto L_0x031a
            r7 = r3[r6]
            int r7 = java.lang.Integer.parseInt(r7)
            r4[r6] = r7
            int r6 = r6 + 1
            goto L_0x030c
        L_0x031a:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r5]
            java.nio.ByteOrder r6 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort((int[]) r4, (java.nio.ByteOrder) r6)
            r3.put(r1, r4)
            goto L_0x0343
        L_0x0328:
            r12 = r4
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r5]
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createString(r2)
            r3.put(r1, r4)
            goto L_0x0343
        L_0x0335:
            r12 = r4
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r5]
            androidx.exifinterface.media.ExifInterface$ExifAttribute r4 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createByte(r2)
            r3.put(r1, r4)
            goto L_0x0343
        L_0x0342:
            r12 = r4
        L_0x0343:
            int r5 = r5 + 1
            r4 = r12
            r3 = 2
            r7 = 1
            goto L_0x0112
        L_0x034a:
            return
        L_0x034b:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "tag shouldn't be null"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.setAttribute(java.lang.String, java.lang.String):void");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setDateTime(@NonNull Long l11) {
        if (l11 == null) {
            throw new NullPointerException("Timestamp should not be null.");
        } else if (l11.longValue() >= 0) {
            String l12 = Long.toString(l11.longValue() % 1000);
            for (int length = l12.length(); length < 3; length++) {
                l12 = "0" + l12;
            }
            setAttribute(TAG_DATETIME, sFormatterPrimary.format(new Date(l11.longValue())));
            setAttribute(TAG_SUBSEC_TIME, l12);
        } else {
            throw new IllegalArgumentException("Timestamp should a positive value.");
        }
    }

    public void setGpsInfo(Location location) {
        if (location != null) {
            setAttribute(TAG_GPS_PROCESSING_METHOD, location.getProvider());
            setLatLong(location.getLatitude(), location.getLongitude());
            setAltitude(location.getAltitude());
            setAttribute(TAG_GPS_SPEED_REF, "K");
            setAttribute(TAG_GPS_SPEED, new Rational((double) ((location.getSpeed() * ((float) TimeUnit.HOURS.toSeconds(1))) / 1000.0f)).toString());
            String[] split = sFormatterPrimary.format(new Date(location.getTime())).split("\\s+", -1);
            setAttribute(TAG_GPS_DATESTAMP, split[0]);
            setAttribute(TAG_GPS_TIMESTAMP, split[1]);
        }
    }

    public void setLatLong(double d11, double d12) {
        String str;
        String str2;
        if (d11 < -90.0d || d11 > 90.0d || Double.isNaN(d11)) {
            throw new IllegalArgumentException("Latitude value " + d11 + " is not valid.");
        } else if (d12 < -180.0d || d12 > 180.0d || Double.isNaN(d12)) {
            throw new IllegalArgumentException("Longitude value " + d12 + " is not valid.");
        } else {
            if (d11 >= 0.0d) {
                str = "N";
            } else {
                str = LATITUDE_SOUTH;
            }
            setAttribute(TAG_GPS_LATITUDE_REF, str);
            setAttribute(TAG_GPS_LATITUDE, convertDecimalDegree(Math.abs(d11)));
            if (d12 >= 0.0d) {
                str2 = LONGITUDE_EAST;
            } else {
                str2 = LONGITUDE_WEST;
            }
            setAttribute(TAG_GPS_LONGITUDE_REF, str2);
            setAttribute(TAG_GPS_LONGITUDE, convertDecimalDegree(Math.abs(d12)));
        }
    }

    public static class SeekableByteOrderedDataInputStream extends ByteOrderedDataInputStream {
        public SeekableByteOrderedDataInputStream(byte[] bArr) throws IOException {
            super(bArr);
            this.f35965b.mark(Integer.MAX_VALUE);
        }

        public void seek(long j11) throws IOException {
            int i11 = this.f35966c;
            if (((long) i11) > j11) {
                this.f35966c = 0;
                this.f35965b.reset();
            } else {
                j11 -= (long) i11;
            }
            skipFully((int) j11);
        }

        public SeekableByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f35965b.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    @Nullable
    public double[] getLatLong() {
        String attribute = getAttribute(TAG_GPS_LATITUDE);
        String attribute2 = getAttribute(TAG_GPS_LATITUDE_REF);
        String attribute3 = getAttribute(TAG_GPS_LONGITUDE);
        String attribute4 = getAttribute(TAG_GPS_LONGITUDE_REF);
        if (attribute == null || attribute2 == null || attribute3 == null || attribute4 == null) {
            return null;
        }
        try {
            return new double[]{convertRationalLatLonToDouble(attribute, attribute2), convertRationalLatLonToDouble(attribute3, attribute4)};
        } catch (IllegalArgumentException unused) {
            Log.w(TAG, "Latitude/longitude values are not parsable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", new Object[]{attribute, attribute2, attribute3, attribute4}));
            return null;
        }
    }

    public static class ExifTag {

        /* renamed from: name  reason: collision with root package name */
        public final String f35968name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        public ExifTag(String str, int i11, int i12) {
            this.f35968name = str;
            this.number = i11;
            this.primaryFormat = i12;
            this.secondaryFormat = -1;
        }

        public boolean a(int i11) {
            int i12;
            int i13 = this.primaryFormat;
            if (i13 == 7 || i11 == 7 || i13 == i11 || (i12 = this.secondaryFormat) == i11) {
                return true;
            }
            if ((i13 == 4 || i12 == 4) && i11 == 3) {
                return true;
            }
            if ((i13 == 9 || i12 == 9) && i11 == 8) {
                return true;
            }
            if ((i13 == 12 || i12 == 12) && i11 == 11) {
                return true;
            }
            return false;
        }

        public ExifTag(String str, int i11, int i12, int i13) {
            this.f35968name = str;
            this.number = i11;
            this.primaryFormat = i12;
            this.secondaryFormat = i13;
        }
    }

    public ExifInterface(@NonNull String str) throws IOException {
        ExifTag[][] exifTagArr = f35959e;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            initForFilename(str);
            return;
        }
        throw new NullPointerException("filename cannot be null");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExifInterface(@androidx.annotation.NonNull java.io.FileDescriptor r5) throws java.io.IOException {
        /*
            r4 = this;
            r4.<init>()
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r0 = f35959e
            int r1 = r0.length
            java.util.HashMap[] r1 = new java.util.HashMap[r1]
            r4.mAttributes = r1
            java.util.HashSet r1 = new java.util.HashSet
            int r0 = r0.length
            r1.<init>(r0)
            r4.mAttributesOffsets = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r4.mExifByteOrder = r0
            if (r5 == 0) goto L_0x0057
            r0 = 0
            r4.mAssetInputStream = r0
            r4.mFilename = r0
            boolean r1 = isSeekableFD(r5)
            if (r1 == 0) goto L_0x0034
            r4.mSeekableFileDescriptor = r5
            java.io.FileDescriptor r5 = androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.b(r5)     // Catch:{ Exception -> 0x002b }
            r1 = 1
            goto L_0x0037
        L_0x002b:
            r5 = move-exception
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Failed to duplicate file descriptor"
            r0.<init>(r1, r5)
            throw r0
        L_0x0034:
            r4.mSeekableFileDescriptor = r0
            r1 = 0
        L_0x0037:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x004a }
            r2.<init>(r5)     // Catch:{ all -> 0x004a }
            r4.loadAttributes(r2)     // Catch:{ all -> 0x0048 }
            androidx.exifinterface.media.ExifInterfaceUtils.c(r2)
            if (r1 == 0) goto L_0x0047
            androidx.exifinterface.media.ExifInterfaceUtils.b(r5)
        L_0x0047:
            return
        L_0x0048:
            r0 = move-exception
            goto L_0x004e
        L_0x004a:
            r2 = move-exception
            r3 = r2
            r2 = r0
            r0 = r3
        L_0x004e:
            androidx.exifinterface.media.ExifInterfaceUtils.c(r2)
            if (r1 == 0) goto L_0x0056
            androidx.exifinterface.media.ExifInterfaceUtils.b(r5)
        L_0x0056:
            throw r0
        L_0x0057:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "fileDescriptor cannot be null"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.<init>(java.io.FileDescriptor):void");
    }

    public ExifInterface(@NonNull InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    public ExifInterface(@NonNull InputStream inputStream, int i11) throws IOException {
        ExifTag[][] exifTagArr = f35959e;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.mFilename = null;
            if (i11 == 1) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, f35961g.length);
                if (!isExifDataOnly(bufferedInputStream)) {
                    Log.w(TAG, "Given data does not follow the structure of an Exif-only data.");
                    return;
                }
                this.mIsExifDataOnly = true;
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
                inputStream = bufferedInputStream;
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.mAssetInputStream = (AssetManager.AssetInputStream) inputStream;
                this.mSeekableFileDescriptor = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (isSeekableFD(fileInputStream.getFD())) {
                        this.mAssetInputStream = null;
                        this.mSeekableFileDescriptor = fileInputStream.getFD();
                    }
                }
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
            }
            loadAttributes(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }
}
