package com.bend.components.serializers

import com.google.gson.*
import org.joda.time.DateTime
import java.lang.reflect.Type


/**
 *
 * FootballApp
 * DateTimeSerializer
 *
 * Created on 12/07/2017
 * Copyright (c) 2017 SHAPE A/S. All rights reserved.
 *
 */
class DateTimeSerializer : JsonSerializer<DateTime>, JsonDeserializer<DateTime> {

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): DateTime {
        return DateTime(json.asString)
    }

    override fun serialize(src: DateTime, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
        return JsonPrimitive(src.toString())
    }
}