package cn.edu.buaa.lab.robot.repository;

import cn.edu.buaa.lab.robot.model.MusicEnglishModel;
import cn.edu.buaa.lab.robot.model.MusicModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MusicEnglishRepository extends CrudRepository<MusicModel, Integer> {
    List<MusicEnglishModel> findByDeleted(Integer deleted);
}
