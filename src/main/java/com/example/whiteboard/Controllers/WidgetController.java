package com.example.whiteboard.Controllers;

import com.example.whiteboard.models.Widget;
import com.example.whiteboard.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    @Autowired
    WidgetService service;

    @PostMapping("/api/widgets")
    public Widget createWidget(
            @RequestBody Widget widget) {
        return service.createWidget(widget);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable String tid) {
        return service.findWidgetsForTopic(tid);
    }

    @PutMapping("/api/widgets/{wid}")
    public Widget updateWidget(
            @PathVariable int wid,
            @RequestBody Widget newWidget) {
        System.out.println("here");
        return service.updateWidget(wid, newWidget);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public void deleteWidget(
            @PathVariable int wid) {
        service.deleteWidget(wid);
    }

    @PutMapping("/api/topics/{tid}/{order}")
    public Widget reorderWidget(
            @PathVariable String tid,
            @PathVariable String order,
            @RequestBody Widget newWidget) {
        return service.reorderWidget(tid, Integer.parseInt(order), newWidget);
    }
}
