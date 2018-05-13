package cn.edu.buaa.lab.robot.repository;

import cn.edu.buaa.lab.robot.model.StoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends CrudRepository<StoryModel, Integer> {
    List<StoryModel> findByDeleted(Integer deleted);
    List<StoryModel> findByDeletedAndOldIndex(Integer deleted, Integer oldIndex);
}
