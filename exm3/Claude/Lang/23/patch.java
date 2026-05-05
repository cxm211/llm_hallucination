public void setFormatsByArgumentIndex(Format[] newFormats) {
    for (int i = 0; i < newFormats.length; i++) {
        super.setFormatByArgumentIndex(i, newFormats[i]);
    }
}