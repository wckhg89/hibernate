package com.zumgu.domain.converter;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.sql.Timestamp;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by kanghonggu on 2016-12-12.
 */
@Converter(autoApply = true)
public class DateTimeConverter implements AttributeConverter <DateTime, Timestamp>{

    @Override
    public Timestamp convertToDatabaseColumn(DateTime dateTime) {
        return dateTime != null ? new Timestamp(dateTime.getMillis()) : null;
    }

    @Override
    public DateTime convertToEntityAttribute(Timestamp timestamp) {
        return timestamp != null ? new DateTime(timestamp, DateTimeZone.UTC) : null;
    }
}
