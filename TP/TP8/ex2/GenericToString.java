import java.lang.reflect.Field;

public class GenericToString {
    public static String toString(Object obj) {
        StringBuilder result = new StringBuilder();
        Class<?> objectClass = obj.getClass();

        for (Field field : objectClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(FriendlyName.class)) {
                
                FriendlyName friendlyName = field.getAnnotation(FriendlyName.class);
                field.setAccessible(true);

                try {
                    Object value = field.get(obj);
                    result.append(friendlyName.value()).append(": ").append(value).append("\n");

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return result.toString().trim();
    }
}
   