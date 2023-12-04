package org.digimad.util;

import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.spin.DataFormats;

public class GenericJsonConverter <T>{
    private T t;

    public GenericJsonConverter(T t) {
        this.t = t;
    }

    public ObjectValue convertToJson(){
        ObjectValue value = Variables.objectValue(this.t).serializationDataFormat(DataFormats.JSON_DATAFORMAT_NAME).create();
        return value;
    }
}
