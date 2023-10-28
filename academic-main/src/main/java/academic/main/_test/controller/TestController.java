package academic.main._test.controller;

import academic.main._test.domain.TestEntity;
import academic.main._test.domain.TestRedisEntity;
import academic.main._test.service.TestService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping("/save")
    public void save(@RequestBody TestEntity testEntity) {
        testService.saveEntity(testEntity);
    }

    @GetMapping("/get")
    public ResponseEntity<List<TestEntity>> get() {
        return ResponseEntity.ok(testService.findAllTestEntities());
    }

    @PostMapping("/redis/save")
    public void saveRedis(@RequestBody TestRedisEntity testRedisEntity) {
        testService.saveRedisEntity(testRedisEntity);
    }

    @GetMapping("/redis/get")
    public ResponseEntity<List<TestRedisEntity>> getRedis() {
        return ResponseEntity.ok(testService.findTestRedisEntity());
    }
}
