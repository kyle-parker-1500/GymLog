package com.example.hw04_gymlog_v300.database.typeConverters;

import androidx.room.TypeConverter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

// gotta convert LocalDate to something that Room can handle (remember-> 3 datatypes room can handle:
// text, int, real)
public class LocalDateTypeConverter {
    @TypeConverter
    public long convertDateToLong(LocalDateTime date) {
        // of = object factory
        ZonedDateTime zdt = ZonedDateTime.of(date, ZoneId.systemDefault());
        // toInstant = now()
        return zdt.toInstant().toEpochMilli();
    }

    @TypeConverter
    public LocalDateTime convertLongToDate(Long epochMilli) {
        Instant instant = Instant.ofEpochMilli(epochMilli);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

}
