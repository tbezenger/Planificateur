package poopleserverrest.jsoncoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.websocket.*;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by bruno on 23/03/14.
 */

public abstract class AJSONCoder<T> implements Encoder.TextStream<T>, Decoder.TextStream<T> {

    private static final ObjectMapper _objectMapper = new ObjectMapper();
    private ObjectWriter _writer = AJSONCoder._objectMapper.writer();
    private ObjectReader _reader = AJSONCoder._objectMapper.reader();

    private Class<T> _type;

    public void init() {

        ParameterizedType $thisClass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type $T = $thisClass.getActualTypeArguments()[0];
        if ($T instanceof Class) {
            _type = (Class<T>) $T;
        } else if ($T instanceof ParameterizedType) {
            _type = (Class<T>) ((ParameterizedType) $T).getRawType();
        }
    }


    public void init(EndpointConfig endpointConfig) {
        init();
    }


    public void destroy() {

    }


    public void encode(T t, Writer writer) throws EncodeException, IOException {
        _objectMapper.writerWithType(_type).writeValue(writer, t);
    }


    public T decode(Reader reader) throws DecodeException, IOException {
        return _objectMapper.readValue(reader, _type);
    }
}
