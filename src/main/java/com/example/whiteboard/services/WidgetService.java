package com.example.whiteboard.services;

import com.example.whiteboard.models.Widget;
import com.example.whiteboard.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// port 3306

@Service
public class WidgetService {
    @Autowired
    WidgetRepository repository;

    public Widget createWidget(Widget widget) {
        return repository.save(widget);
    }

    public List<Widget> findWidgetsForTopic(String tid) {
        return repository.findWidgetsByTopicId(tid);
    }

    public Widget updateWidget(int widgetId, Widget newWidget) {
        return repository.save(newWidget);
    }

    public void deleteWidget(int widgetId) {
        repository.deleteById(widgetId);
    }

    public Widget reorderWidget(String tid, Integer order, Widget newWidget) {
        Widget oldSpot = repository.findWidgetsByTopicIdAndOrder(tid, newWidget.getWidgetOrder());
        oldSpot.setWidgetOrder(order);
        repository.save(newWidget);
        return repository.save(oldSpot);
    }
}