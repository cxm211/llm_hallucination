// Lang/23/input.java
public void testSetFormatsByArgumentIndex() {
        Map<String, ? extends FormatFactory> registry = Collections.singletonMap("testfmt", new LowerCaseFormatFactory());
        String pattern = "Pattern: {0,testfmt}";
        ExtendedMessageFormat emf = new ExtendedMessageFormat(pattern, Locale.US, registry);
        Format[] formats = emf.getFormatsByArgumentIndex();
        Format[] newFormats = formats.clone();
        emf.setFormatsByArgumentIndex(newFormats);
        Format[] updatedFormats = emf.getFormatsByArgumentIndex();
        assertTrue(Arrays.equals(newFormats, updatedFormats));
    }
