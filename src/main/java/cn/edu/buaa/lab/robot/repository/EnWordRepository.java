package cn.edu.buaa.lab.robot.repository;

import cn.edu.buaa.lab.robot.model.EnWordModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnWordRepository extends CrudRepository<EnWordModel, Integer> {
}
