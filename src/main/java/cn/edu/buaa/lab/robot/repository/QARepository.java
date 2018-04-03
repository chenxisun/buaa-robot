package cn.edu.buaa.lab.robot.repository;

import cn.edu.buaa.lab.robot.model.QAModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QARepository extends CrudRepository<QAModel, Integer> {
}
