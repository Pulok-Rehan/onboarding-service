package com.bracepl.onboarding_service.domain.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;

@Slf4j
public class ValidationUtils {

    public static boolean hasNullOrEmptyField(Object obj) {
        if (obj == null) {
//            log.error("PASSED NULL OBJECT...");
            return true;
        }

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);

                if (value == null) {
//                    log.error(field.get(obj).toString()+ "IS NULL");
                    return true;
                }

                if (value instanceof String && !StringUtils.hasText((String) value)) {
//                    log.error(field.get(obj).toString()+ "IS EMPTY");
                    return true;
                }

                if (value instanceof MultipartFile && ((MultipartFile) value).isEmpty()) {
//                    log.error(field.get(obj).toString()+ "HAS NO FILE");
                    return true;
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
