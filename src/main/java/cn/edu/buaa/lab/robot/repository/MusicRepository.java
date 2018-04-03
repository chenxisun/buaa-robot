package cn.edu.buaa.lab.robot.repository;

import cn.edu.buaa.lab.robot.model.MusicModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MusicRepository extends CrudRepository<MusicModel, Integer> {
}
