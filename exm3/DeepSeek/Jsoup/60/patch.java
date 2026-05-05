    public String chompBalanced(char open, char close) {
        int start = -1;
        int end = -1;
        int depth = 0;
        char last = 0;
        boolean inQuote = false;
        boolean escape = false;

        do {
            if (isEmpty()) break;
            Character c = consume();
            if (escape) {
                // current character is escaped, treat as literal
                escape = false;
                // do not process quotes or brackets for this character
            } else {
                if (c == ESC) {
                    escape = true;
                }
                // only process quotes and brackets if not escaped and not an ESC (since ESC already handled)
                if (!escape) {
                    if ((c == '\'' || c == '"') && c != open) {
                        inQuote = !inQuote;
                    }
                    if (inQuote) {
                        // skip bracket counting inside quotes
                    } else {
                        if (c == open) {
                            depth++;
                            if (start == -1)
                                start = pos;
                        } else if (c == close) {
                            depth--;
                        }
                    }
                }
            }

            if (depth > 0 && last != 0)
                end = pos; // don't include the outer match pair in the return
            last = c;
        } while (depth > 0);
        final String out = (end >= 0) ? queue.substring(start, end) : "";
        return out;
    }