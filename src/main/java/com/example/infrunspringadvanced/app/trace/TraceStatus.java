package com.example.infrunspringadvanced.app.trace;

public class TraceStatus {
    private TraceId traceId;
    private Long startTimeMilliMs;
    private String message;

    public TraceStatus(TraceId traceId, Long startTimeMilliMs, String message) {
        this.traceId = traceId;
        this.message = message;
        this.startTimeMilliMs = startTimeMilliMs;
    }

    public TraceId getTraceId() {
        return traceId;
    }

    public Long getStartTimeMs() {
        return startTimeMilliMs;
    }

    public String getMessage() {
        return message;
    }
}
