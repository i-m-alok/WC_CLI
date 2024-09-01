package com.wc_cli.enums;

public enum CLIOption {
    ByteCount("c", "byteCount", false, "Option to count bytes", false),
    LineCount("l", "lineCount", false, "Option to count lines", false),
    WordCount("w", "wordCount", false, "Option to count words", false),
    CharacterCount("m", "charCount", false, "Option to count characters", false);

    private final String shortOpt;
    private final String longOpt;
    private final boolean hasArg;
    private final String description;
    private final boolean required;

    CLIOption(String shortOpt, String longOpt, boolean hasArg, String description, boolean required) {
        this.shortOpt = shortOpt;
        this.longOpt = longOpt;
        this.hasArg = hasArg;
        this.description = description;
        this.required = required;
    }

    public String getShortOpt() {
        return shortOpt;
    }

    public String getLongOpt() {
        return longOpt;
    }

    public boolean isHasArg() {
        return hasArg;
    }

    public String getDescription() {
        return description;
    }

    public boolean isRequired() {
        return required;
    }
}
