package cn.edu.buaa.lab.robot.repository;

import cn.edu.buaa.lab.robot.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {
}
