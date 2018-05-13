package cn.edu.buaa.lab.robot.repository;

import cn.edu.buaa.lab.robot.model.MusicModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MusicRepository extends CrudRepository<MusicModel, Integer> {
    List<MusicModel> findByDeleted(Integer deleted);
    List<MusicModel> findByDeletedAndOldIndex(Integer deleted, Integer oldIndex);
}
