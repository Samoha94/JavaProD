package com.gmail.samoha199412.entities.UserFiles;

import com.gmail.samoha199412.entities.user.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_files")
public class UserFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "file_size")
    private Integer fileSize;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
}
