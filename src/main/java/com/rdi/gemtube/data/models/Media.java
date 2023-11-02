package com.rdi.gemtube.data.models;

import com.rdi.gemtube.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Setter
@Getter
public class Media {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String title;
    private String description;
    // we specified that the fetch type is eager because by default it is lazy and it is not what we want
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User uploader;
    private String url;
    private LocalDateTime createdAt;

    // this tells spring that it should set do this operation of setting this field before persisting the object
    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }
}
