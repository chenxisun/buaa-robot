package cn.edu.buaa.lab.robot.repository;

import cn.edu.buaa.lab.robot.model.TopicModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TopicRepository extends CrudRepository<TopicModel, Integer> {
}
