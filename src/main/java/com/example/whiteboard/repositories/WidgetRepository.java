package com.example.whiteboard.repositories;

import com.example.whiteboard.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {
    @Query(value = "SELECT * FROM widgets where topic_id=:topicId", nativeQuery = true)
    List<Widget> findWidgetsByTopicId(
            @Param("topicId") String topicId);
    @Query(value = "SELECT * FROM widgets where topic_id=:topicId and widget_order=:order", nativeQuery = true)
    Widget findWidgetsByTopicIdAndOrder(
            @Param("topicId") String topicId,
            @Param("order") int order);
}
