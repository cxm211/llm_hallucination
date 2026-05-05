// JacksonDatabind/72/input.java
public void testNullDelegate() throws Exception {
        try {
            Class<?> clazz = Class.forName("com.fasterxml.jackson.databind.ser.BeanPropertyWriter");
            java.lang.reflect.Constructor<?> ctor = clazz.getDeclaredConstructor();
            ctor.setAccessible(true);
            Object instance = ctor.newInstance();
            java.lang.reflect.Field field = clazz.getDeclaredField("_delegate");
            field.setAccessible(true);
            field.set(instance, null);
            java.lang.reflect.Method method = clazz.getMethod("getPropertyIndex");
            int result = (Integer) method.invoke(instance);
            org.junit.Assert.assertEquals(-1, result);
        } catch (ClassNotFoundException e) {
            org.junit.Assume.assumeNoException(e);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            org.junit.Assume.assumeNoException(e);
        }
    }
