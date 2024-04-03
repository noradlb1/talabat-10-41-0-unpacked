package org.junit.jupiter.engine.extension;

import j$.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TimeoutDurationParser {
    private static final Pattern PATTERN = Pattern.compile("([1-9]\\d*) ?((?:[nμm]?s)|m|h|d)?", 66);
    private static final Map<String, TimeUnit> UNITS_BY_ABBREVIATION;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("ns", TimeUnit.NANOSECONDS);
        hashMap.put("μs", TimeUnit.MICROSECONDS);
        hashMap.put("ms", TimeUnit.MILLISECONDS);
        hashMap.put("s", TimeUnit.SECONDS);
        hashMap.put("m", TimeUnit.MINUTES);
        hashMap.put("h", TimeUnit.HOURS);
        hashMap.put("d", TimeUnit.DAYS);
        UNITS_BY_ABBREVIATION = Collections.unmodifiableMap(hashMap);
    }

    public TimeoutDuration a(CharSequence charSequence) throws DateTimeParseException {
        TimeUnit timeUnit;
        Matcher matcher = PATTERN.matcher(charSequence);
        if (matcher.matches()) {
            long parseLong = Long.parseLong(matcher.group(1));
            String group = matcher.group(2);
            if (group == null) {
                timeUnit = TimeUnit.SECONDS;
            } else {
                timeUnit = UNITS_BY_ABBREVIATION.get(group.toLowerCase(Locale.ENGLISH));
            }
            return new TimeoutDuration(parseLong, timeUnit);
        }
        throw new DateTimeParseException("Timeout duration is not in the expected format (<number> [ns|μs|ms|s|m|h|d])", charSequence, 0);
    }
}
