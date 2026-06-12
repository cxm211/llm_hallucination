    public String chompBalanced(char open, char close) {
        int start = -1;
        int end = -1;
        int depth = 0;
        char last = 0;
        boolean inQuote = false;
        char quoteChar = 0;

        do {
            if (isEmpty()) break;
            Character c = consume();
            if (last == 0 || last != ESC) {
                if ((c.equals('\'') || c.equals('"')) && c != open) {
                    if (!inQuote) {
                        inQuote = true;
                        quoteChar = c;
                    } else if (c.equals(quoteChar)) {
                        inQuote = false;
                        quoteChar = 0;
                    }
                }
                if (inQuote)
                    continue;
                if (c.equals(open)) {
                    depth++;
                    if (start == -1)
                        start = pos;
                }
                else if (c.equals(close))
                    depth--;
            }

            if (depth > 0 && last != 0)
                end = pos; // don't include the outer match pair in the return
            last = c;
        } while (depth > 0);
        final String out = (end >= 0) ? queue.substring(start, end) : "";
        return out;
    }