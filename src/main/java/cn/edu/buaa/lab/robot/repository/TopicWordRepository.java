package cn.edu.buaa.lab.robot.repository;

import cn.edu.buaa.lab.robot.model.TopicModel;
import cn.edu.buaa.lab.robot.model.TopicWordModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TopicWordRepository extends CrudRepository<TopicWordModel, Integer> {
    List<TopicWordModel> findAllByDeletedAndTopic(Integer deleted, String topic);
}
