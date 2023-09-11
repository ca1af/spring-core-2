package com.example.infrunspringadvanced.app.trace.fooTrace;

import com.example.infrunspringadvanced.app.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FooTraceV1Test {
    @Test
    void begin_end() {
        FooTraceV1 fooTraceV1 = new FooTraceV1();
        TraceStatus hello = fooTraceV1.begin("hello");
        fooTraceV1.end(hello);
    }

    @Test
    void begin_exception() {
        FooTraceV1 fooTraceV1 = new FooTraceV1();
        TraceStatus hello = fooTraceV1.begin("hello");
        fooTraceV1.exception(hello, new IllegalArgumentException());
    }
}