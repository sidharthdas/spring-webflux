package com.springreactivelearning.controller;

import com.springreactivelearning.service.GetRawData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Sidharth Das
 * created on  31/01/23
 */
@RestController
public class RawController {

    @Autowired
    private GetRawData getRawData;

    @GetMapping("/get")
    public Mono<Object> getRawData() {
        return getRawData.getMap()
                .zipWith(getRawData.getRaw())
                .map(tuple -> {
                            tuple.getT1().put("user", tuple.getT2());
                            return tuple.getT1();
                        }
                );
    }
}
