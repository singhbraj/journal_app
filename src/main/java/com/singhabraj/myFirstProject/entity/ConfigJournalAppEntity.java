package com.singhabraj.myFirstProject.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "config_journal_app")
public class ConfigJournalAppEntity {
    @Id
private ObjectId id;
private String key;
private String value;
}
