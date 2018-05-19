package cn.edu.buaa.lab.robot.repository;

import cn.edu.buaa.lab.robot.model.MusicModel;
import cn.edu.buaa.lab.robot.model.WikipediaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WikipediaRepository extends CrudRepository<WikipediaModel, Integer> {
    Page<WikipediaModel> findAllByDeletedOrderByIdAsc(Integer deleted, Pageable pageable);

}
