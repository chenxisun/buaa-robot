package cn.edu.buaa.lab.robot.service;

import cn.edu.buaa.lab.robot.model.MusicModel;
import cn.edu.buaa.lab.robot.model.WeatherModel;
import cn.edu.buaa.lab.robot.model.WikipediaModel;
import cn.edu.buaa.lab.robot.repository.MusicRepository;
import cn.edu.buaa.lab.robot.repository.WikipediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class WikipediaService {
    private static final Logger logger = LoggerFactory.getLogger("WikipediaService");

    @Autowired
    private WikipediaRepository wikipediaRepository;

    public Page<WikipediaModel> getList(Integer pageNo, Integer pageSize) {
        PageRequest pageRequest = new PageRequest(pageNo, pageSize);
        Page<WikipediaModel> wikiList = wikipediaRepository.findAllByDeletedOrderByIdAsc(0,pageRequest);
        return wikiList;
    }

}
