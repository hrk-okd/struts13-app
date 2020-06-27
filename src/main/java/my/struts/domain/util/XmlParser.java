package my.struts.domain.util;

import lombok.RequiredArgsConstructor;
import org.simpleframework.xml.Serializer;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class XmlParser {

    private final Serializer serializer;

    @Nullable
    public <T> T read(@NonNull final String str, @NonNull final Class<T> clazz) {
        try {
            return serializer.read(clazz, str, false);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
