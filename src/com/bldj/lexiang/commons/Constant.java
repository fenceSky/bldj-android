package com.bldj.lexiang.commons;

public class Constant {

    /**
     * 超时时间
     */
    public static final int TIMEOUT = 10000;

    private static final int GD_LOG_LEVEL_INFO = 3;

    private static final int GD_LOG_LEVEL_NONE = 0;

    /**
     * Set this flag to GD_LOG_LEVEL_NONE when releasing your application in
     * order to remove all logs generated by GreenDroid.
     */
    private static final int GD_LOG_LEVEL = GD_LOG_LEVEL_NONE;

    /**
     * Indicates whether info logs are enabled. This should be true only when
     * developing/debugging an application/the library
     */
    public static final boolean GD_INFO_LOGS_ENABLED = (GD_LOG_LEVEL == GD_LOG_LEVEL_INFO);
    
    public static final String  IMAGELOADER_LOCAL_TITLE = "file://";
}