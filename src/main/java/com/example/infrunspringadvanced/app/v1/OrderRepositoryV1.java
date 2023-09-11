package com.example.infrunspringadvanced.app.v1;

import com.example.infrunspringadvanced.app.trace.TraceStatus;
import com.example.infrunspringadvanced.app.trace.fooTrace.FooTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final FooTraceV1 traceV1;
    public void save(String itemId){
        TraceStatus status = null;
        try {
            status = traceV1.begin("OrderController.request()");
            if (itemId.equals("ex")){
                throw new IllegalArgumentException("예외발생");
            }
            sleep(1000);
            traceV1.end(status);
        } catch (Exception e){
            traceV1.exception(status, e);
            throw e;
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
