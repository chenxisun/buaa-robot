package cn.edu.buaa.lab.robot.repository;

import cn.edu.buaa.lab.robot.model.TopicWordModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TopicWordRepository extends CrudRepository<TopicWordModel, Integer> {
}
