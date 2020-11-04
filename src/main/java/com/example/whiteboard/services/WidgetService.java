package com.example.whiteboard.services;

import com.example.whiteboard.models.Widget;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WidgetService {
    List<Widget> widgets = new ArrayList<Widget>();

    public Widget createWidget(String tid, Widget widget) {
        Random rand = new Random();
        String newId = Integer.toHexString(rand.nextInt());
        widget.setId(newId);
        widget.setTopicId(tid);
        int i = 0;
        for (Widget w : widgets) {
            if (widget.getTopicId().equals(tid)) {
                i++;
            }
        }
        widget.setWidgetOrder(i);
        widgets.add(widget);
        return widget;
    }

    public List<Widget> findWidgetsForTopic(String tid) {
        List<Widget> widgetsForTopic = new ArrayList<Widget>();
        for(Widget w: widgets) {
            if(w.getTopicId().equals(tid)) {
                widgetsForTopic.add(w);
            }
        }
        return widgetsForTopic;
    }

    public Integer updateWidget(String widgetId, Widget newWidget) {
        for (int i = 0; i < widgets.size(); i++) {
            if (widgets.get(i).getId().equals(widgetId)) {
                widgets.set(i, newWidget);
                return 1;
            }
        }
        return 0;
    }

    public Integer deleteWidget(String widgetId) {
        for (int i = 0; i < widgets.size(); i++) {
            if (widgets.get(i).getId().equals(widgetId)) {
                widgets.remove(i);
                return 1;
            }
        }
        return 0;
    }

    public Integer reorderWidget(String tid, Integer order, Widget newWidget) {
        for (int i = 0; i < widgets.size(); i++) {
            Widget w = widgets.get(i);
            if (w.getTopicId().equals(tid) && w.getWidgetOrder().equals(newWidget.getWidgetOrder())) {
                w.setWidgetOrder(order);
            }
            if (w.getId().equals(newWidget.getId())) {
                widgets.set(i, newWidget);
            }
        }
        return 1;
    }
}