package com.application.sobesTask.controller;


import com.application.sobesTask.event.AddEvent;


import com.application.sobesTask.model.Graph;
import com.application.sobesTask.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RelationController {
    private final UserService userService;

    @PostMapping("/add")
    public void add(@RequestBody AddEvent event) {
        userService.save(event);
    }

    @GetMapping("/show")
    public Graph showGraph() {
        return userService.showGraph();
    }
}
