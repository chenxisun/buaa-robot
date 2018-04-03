package cn.edu.buaa.lab.robot.repository;

import cn.edu.buaa.lab.robot.model.KeywordModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KeywordRepository extends CrudRepository<KeywordModel, Integer> {
}
