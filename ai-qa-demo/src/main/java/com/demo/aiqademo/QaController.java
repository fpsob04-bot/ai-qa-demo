package com.demo.aiqademo;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/qa")
public class QaController {

    private final OllamaService ollamaService;
    private final QaRecordRepository repository;

    public QaController(OllamaService ollamaService, QaRecordRepository repository) {
        this.ollamaService = ollamaService;
        this.repository = repository;
    }


    @PostMapping("/ask")
    public Map<String, Object> ask(@RequestBody Map<String, String> payload) {
        String question = payload.get("question");
        // 新增校验逻辑
        if (question == null || question.trim().isEmpty()) {
            throw new IllegalArgumentException("问题不能为空");
        }
        String answer = ollamaService.ask(question);

        QaRecord record = new QaRecord(question, answer);
        repository.save(record);

        Map<String, Object> response = new HashMap<>();
        response.put("question", question);
        response.put("answer", answer);
        response.put("id", record.getId());
        return response;
    }
}