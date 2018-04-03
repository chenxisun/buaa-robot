package cn.edu.buaa.lab.robot.repository;

import cn.edu.buaa.lab.robot.model.StoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StoryRepository extends CrudRepository<StoryModel, Integer> {
}
