package com.example.whiteboard.Controllers;

import com.example.whiteboard.models.Widget;
import com.example.whiteboard.services.WidgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    WidgetService service = new WidgetService();

    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidget(
            @PathVariable String tid,
            @RequestBody Widget widget) {
        return service.createWidget(tid, widget);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable String tid) {
        return service.findWidgetsForTopic(tid);
    }

    @PutMapping("/api/widgets/{wid}")
    public Integer updateWidget(
            @PathVariable String wid,
            @RequestBody Widget newWidget) {
        System.out.println("here");
        return service.updateWidget(wid, newWidget);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public Integer deleteWidget(
            @PathVariable String wid) {
        return service.deleteWidget(wid);
    }

    @PutMapping("/api/topics/{tid}/{order}")
    public Integer reorderWidget(
            @PathVariable String tid,
            @PathVariable String order,
            @RequestBody Widget newWidget) {
        return service.reorderWidget(tid, Integer.parseInt(order), newWidget);
    }
}
