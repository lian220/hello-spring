package hello.hellospring.web;

import hello.hellospring.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLoggerProvider;
    public void logic(String testId) {
        myLoggerProvider.log("service id: " + testId);
    }
}
