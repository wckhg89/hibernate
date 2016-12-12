package com.zumgu.config.module;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.zumgu.config.serializer.DateTimeSerializer;

import org.joda.time.DateTime;

/**
 * Created by kanghonggu on 2016-12-12.
 */
public class DateTimeModule extends SimpleModule {
    public DateTimeModule () {
        super();
        addSerializer(DateTime.class, new DateTimeSerializer());
    }
}
