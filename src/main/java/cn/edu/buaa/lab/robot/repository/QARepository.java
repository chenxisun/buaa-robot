package cn.edu.buaa.lab.robot.repository;

import cn.edu.buaa.lab.robot.model.QAModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QARepository extends CrudRepository<QAModel, Integer> {
    List<QAModel> findByDeletedAndOldIndex(Integer deleted, Integer oldIndex);
}
