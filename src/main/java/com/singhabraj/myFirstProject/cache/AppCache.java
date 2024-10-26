package com.singhabraj.myFirstProject.cache;

import com.singhabraj.myFirstProject.entity.ConfigJournalAppEntity;
import com.singhabraj.myFirstProject.repository.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    public enum keys{
        WEATHER_API
    }
    public Map<String,String> appCache;

    @Autowired
    ConfigJournalAppRepository configJournalAppRepository;

    @PostConstruct
    public void init(){
        appCache =new HashMap<>();
        List<ConfigJournalAppEntity> all = configJournalAppRepository.findAll();

        for(ConfigJournalAppEntity configJournalAppEntity : all){
            appCache.put(configJournalAppEntity.getKey(),configJournalAppEntity.getValue());
        }

    }
}
