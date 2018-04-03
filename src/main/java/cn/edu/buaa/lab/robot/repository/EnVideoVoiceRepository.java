package cn.edu.buaa.lab.robot.repository;

import cn.edu.buaa.lab.robot.model.EnVideoVoiceModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnVideoVoiceRepository extends CrudRepository<EnVideoVoiceModel, Integer> {
}
