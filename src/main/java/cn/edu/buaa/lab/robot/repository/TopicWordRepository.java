package cn.edu.buaa.lab.robot.repository;

import cn.edu.buaa.lab.robot.model.TopicWordModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TopicWordRepository extends CrudRepository<TopicWordModel, Integer> {

//    @Query(value = "SELECT * FROM r_topic_word ORDER BY id ASC limit ?1, ?2", nativeQuery = true)
    List<TopicWordModel> findAllByDeletedAndTopicName(Integer deleted, String topic);

    Page<TopicWordModel> findAllByDeletedAndTopicNameOrderByIdAsc(Integer deleted, String topic, Pageable pageable);
}
