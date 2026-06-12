public static String unescape(String string) {
    if (string == null) return null;
    if (!string.contains("&")) return string;
    StringBuilder accum = new StringBuilder(string.length());
    int len = string.length();
    for (int i = 0; i < len; i++) {
        char c = string.charAt(i);
        if (c == '&') {
            int entityEnd = i + 1;
            while (entityEnd < len) {
                char ch = string.charAt(entityEnd);
                if (Character.isLetterOrDigit(ch) || ch == '#' || ch == 'x') {
                    entityEnd++;
                } else {
                    break;
                }
            }
            boolean hasSemicolon = false;
            if (entityEnd < len && string.charAt(entityEnd) == ';') {
                hasSemicolon = true;
                entityEnd++;
            }
            String entityToken = string.substring(i + 1, hasSemicolon ? entityEnd - 1 : entityEnd);
            String decoded = decodeEntity(entityToken);
            if (decoded != null) {
                accum.append(decoded);
                i = entityEnd - 1;
            } else {
                accum.append('&');
            }
        } else {
            accum.append(c);
        }
    }
    return accum.toString();
}