package cn.edu.buaa.lab.robot.repository;

import cn.edu.buaa.lab.robot.model.WeatherModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WeatherRepository extends CrudRepository<WeatherModel, Integer> {
    List<WeatherModel> findAllByDeletedAndDateAndCity(Integer deleted, String date, String city);

    List<WeatherModel> findAllByDeleted(Integer deleted);

    List<WeatherModel> findAllByDeletedAndDateAndCityContains(Integer deleted, String date, String city);
}
