private static String decodeEntity(String entity) {
    if (entity.isEmpty()) return null;
    // try named entity (case-insensitive)
    String key = entity.toLowerCase();
    if (namedEntities.containsKey(key)) {
        return namedEntities.get(key);
    }
    // numeric entities
    if (entity.startsWith("#")) {
        try {
            int codePoint;
            if (entity.length() > 1 && (entity.charAt(1) == 'x' || entity.charAt(1) == 'X')) {
                codePoint = Integer.parseInt(entity.substring(2), 16);
            } else {
                codePoint = Integer.parseInt(entity.substring(1));
            }
            if (Character.isValidCodePoint(codePoint)) {
                return new String(Character.toChars(codePoint));
            }
        } catch (NumberFormatException e) {
            // fall through
        }
    }
    return null;
}