package academic.main._test.controller;

import academic.main._test.domain.TestEntity;
import academic.main._test.domain.TestRedisEntity;
import academic.main._test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(testService.findTestRedisEntities());
    }

    @GetMapping("/redis/cacheable/get/{id}")
    public ResponseEntity<TestRedisEntity> getRedis(@PathVariable("id") Long id,
                                                    @RequestBody TestRedisEntity testRedisEntity) {
        return ResponseEntity.ok(testService.getCacheableRedisEntity(id, testRedisEntity));
    }
}
