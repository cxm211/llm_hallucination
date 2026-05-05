// JacksonDatabind/40/input.java
public void testEmptyToNullCoercionForOtherPrimitives() throws Exception {
        _testEmptyToNullCoercion(boolean.class, Boolean.FALSE);
        _testEmptyToNullCoercion(char.class, Character.valueOf('\0'));
        _testEmptyToNullCoercion(byte.class, Byte.valueOf((byte)0));
        _testEmptyToNullCoercion(short.class, Short.valueOf((short)0));
    }
