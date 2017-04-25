package com.aliaksey.controller.Util;

import com.aliaksey.entity.Role;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aliaksey on 24.04.2017.
 */
public class CustomSerializer extends StdSerializer<List<Role>> {
    protected CustomSerializer(Class<List<Role>> t) {
        super(t);
    }

    public void serialize(List<Role> roles, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<Integer> ids = new ArrayList<Integer>();
        for (Role item : roles) {
            ids.add(item.getId());
        }
        jsonGenerator.writeObject(ids);
    }
}
