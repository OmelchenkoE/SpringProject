package app.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String text;
    private String author;
}

