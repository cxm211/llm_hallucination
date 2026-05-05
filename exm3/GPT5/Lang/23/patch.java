public void setFormatsByArgumentIndex(Format[] newFormats) {
        if (newFormats == null) {
            throw new NullPointerException("newFormats");
        }
        for (int i = 0; i < newFormats.length; i++) {
            super.setFormatByArgumentIndex(i, newFormats[i]);
        }
    }