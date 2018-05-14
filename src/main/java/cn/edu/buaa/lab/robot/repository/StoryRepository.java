package cn.edu.buaa.lab.robot.repository;

import cn.edu.buaa.lab.robot.model.StoryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends CrudRepository<StoryModel, Integer> {
    List<StoryModel> findByDeleted(Integer deleted);
    Page<StoryModel> findAllByDeletedOrderByIdAsc(Integer deleted, Pageable pageable);
    List<StoryModel> findByDeletedAndOldIndex(Integer deleted, Integer oldIndex);
}
