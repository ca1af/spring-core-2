package com.example.infrunspringadvanced.app.v1;

import com.example.infrunspringadvanced.app.trace.TraceStatus;
import com.example.infrunspringadvanced.app.trace.fooTrace.FooTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
    private final OrderRepositoryV1 orderRepositoryV0;
    private final FooTraceV1 traceV1;
    public void orderItem(String itemID){
        TraceStatus status = null;
        try {
            status = traceV1.begin("OrderController.request()");
            orderRepositoryV0.save(itemID);
            traceV1.end(status);
        } catch (Exception e){
            traceV1.exception(status, e);
            throw e;
        }
    }
}
